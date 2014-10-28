package br.com.locadora.model.dao;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.Usuario;
import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.bean.Objeto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AcessoUsuarioDAO implements InterfaceUsuarioDAO {

    private InterfacePool pool;

    public AcessoUsuarioDAO(InterfacePool pool) {
        this.pool = pool;
    }

    @Override
    public void atualizar(Usuario usuario) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlAtualizar = " UPDATE DIARIA SET bairro=?, celular=?, cep=?, "
                + " cidade=?, cpf_cnpj=?, email=?, endereco=?, estado=?,"
                + " telefone=?, nome=? WHERE codigo = ? ;";

        try {
            ps = con.prepareStatement(sqlAtualizar);

            setPreparedStatement(usuario, ps);

            ps.executeUpdate();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
    }

    @Override
    public void excluir(Integer codigo) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlExcluir = "DELETE FROM DIARIA WHERE CODIGO_DIARIA = ?;";

        try {
            ps = con.prepareStatement(sqlExcluir);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
    }

    @Override
    public List<Usuario> getUsuario(Integer codigo_interno) throws SQLException {
        List<Usuario> resultado = new ArrayList<Usuario>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n"
                + "	A.CODIGO_COPIA, \n"
                + "    A.CODIGO_INTERNO,\n"
                + "    A.DEL_FLAG,\n"
                + "    B.DESCRICAO_OBJETO,\n"
                + "    B.TIPO_MOVIMENTO,\n"
                + "    B.TIPO_MIDIA,\n"
                + "    A.LOCALIZACAO,\n"
                + "    A.IDIOMA,\n"
                + "    A.LEGENDA,\n"
                + "    C.DIAS,\n"
                + "    C.VALOR,\n"
                + "    C.VALOR_PROMOCAO\n"
                + "FROM\n"
                + "    locadora.COPIA A,\n"
                + "    locadora.OBJETO B,\n"
                + "    locadora.DIARIA C\n"
                + "WHERE\n"
                + "    A.CODIGO_OBJETO = B.CODIGO_OBJETO\n"
                + "        AND C.CODIGO_DIARIA = B.CODIGO_DIARIA\n"
                + "        AND A.DEL_FLAG = 0\n"
                + "        AND TIPO_MOVIMENTO = 'Locação'\n"
                + "		AND A.CODIGO_INTERNO = ?;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo_interno);

            rs = ps.executeQuery();

            resultado = getListaUsuario(rs);
//            if (resultado.size() > 0) {
//                return resultado.get(0);
//            }
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    @Override
    public List<Usuario> getUsuarios(String nome_usuario) throws SQLException {
        List<Usuario> resultado = new ArrayList<Usuario>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM DIARIA WHERE NOME_DIARIA LIKE ? ORDER BY NOME_DIARIA;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, nome_usuario);
            rs = ps.executeQuery();

            resultado = getListaUsuario(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    public List<Usuario> getTodasUsuarios() throws SQLException {
        List<Usuario> resultado = new ArrayList<Usuario>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM DIARIA ORDER BY NOME_DIARIA;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();

            resultado = getListaUsuario(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    private List<Usuario> getListaUsuario(ResultSet rs) throws SQLException {
        List<Usuario> resultado = new ArrayList<Usuario>();
        while (rs.next()) {
            Usuario usuario = new Usuario();
            Diaria diaria = new Diaria();
            Objeto objeto = new Objeto();

            diaria.setDias(rs.getInt("DIAS"));
            diaria.setValor(rs.getDouble("VALOR"));
            diaria.setValor_promocao(rs.getDouble("VALOR_PROMOCAO"));

            objeto.setDescricao_objeto(rs.getString("DESCRICAO_OBJETO"));
            objeto.setTipo_movimento(rs.getString("TIPO_MOVIMENTO"));
            objeto.setTipo_midia(rs.getString("TIPO_MIDIA"));

            objeto.setDiaria(diaria);
            
            resultado.add(usuario);
        }
        return resultado;
    }

    @Override
    public void salvar(Usuario usuario) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO `locadora`.`COPIA`(`CODIGO_INTERNO`,"
                + "`LOCALIZACAO`,`IDIOMA`,`LEGENDA`,`DATA_AQUISICAO`,"
                + "`PRECO_CUSTO`,`CODIGO_OBJETO`)VALUES(?,?,?,?,?,?,?);";

        try {
            ps = con.prepareStatement(sqlInsert);

            setPreparedStatement1(usuario, ps);

            ps.executeUpdate();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
    }

    private void setPreparedStatement(Usuario usuario, PreparedStatement ps)
            throws SQLException {
       
    }

    private void setPreparedStatement1(Usuario usuario, PreparedStatement ps)
            throws SQLException {
        
    }

    public List<Usuario> getUsuarios() throws SQLException {
        List<Usuario> resultado = new ArrayList<Usuario>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM CLIENTE ORDER BY NOME_CLIENTE;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();

            resultado = getListaUsuario(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

}
