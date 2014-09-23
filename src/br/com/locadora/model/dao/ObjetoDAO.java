package br.com.locadora.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.Objeto;
import java.sql.Date;

public class ObjetoDAO implements InterfaceObjetoDAO {

    private InterfacePool pool;

    public ObjetoDAO(InterfacePool pool) {
        this.pool = pool;
    }

    @Override
    public void atualizar(Objeto objeto) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlAtualizar = " UPDATE objeto SET bairro=?, celular=?, cep=?, "
                + " cidade=?, cpf_cnpj=?, email=?, endereco=?, estado=?,"
                + " telefone=?, nome=? WHERE codigo = ? ;";

        try {
            ps = con.prepareStatement(sqlAtualizar);

            setPreparedStatement(objeto, ps);

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
        String sqlExcluir = "DELETE FROM objeto WHERE codigo = ?;";

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
    public Objeto getObjeto_nome(String nome_objeto) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM CLIENTE WHERE NOME_CLIENTE LIKE ?";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%" + nome_objeto + "%");

            rs = ps.executeQuery();

            List<Objeto> resultado = getListaObjeto(rs);

            if (resultado.size() > 0) {
                return resultado.get(0);
            }
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return null;
    }

    @Override
    public Objeto getObjeto_codigo(Integer codigo_objeto) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM CLIENTE WHERE CODIGO_CLIENTE = ?;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo_objeto);

            rs = ps.executeQuery();

            List<Objeto> resultado = getListaObjeto(rs);
            if (resultado.size() > 0) {
                return resultado.get(0);
            }
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return null;
    }

    @Override
    public List<Objeto> getObjetos() throws SQLException {
        List<Objeto> resultado = new ArrayList<Objeto>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM CLIENTE ORDER BY NOME_CLIENTE;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();

            resultado = getListaObjeto(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    private List<Objeto> getListaObjeto(ResultSet rs) throws SQLException {
        List<Objeto> resultado = new ArrayList<Objeto>();
        while (rs.next()) {
            Objeto objeto = new Objeto();
//			objeto.setCodigo_objeto(rs.getInt("CODIGO_CLIENTE"));
//                        objeto.setNome_objeto(rs.getString("NOME_CLIENTE"));                        
//                        objeto.setNome_empresa_trabalho(rs.getString("NOME_EMPRESA_TRABALHO"));
//                        objeto.setProfissao(rs.getString("PROFISSAO"));
//                        objeto.setNome_empresa_trabalho(rs.getString("NOME_EMPRESA_TRABALHO"));
//                        objeto.setCpf(rs.getString("CPF"));
//                        objeto.setData_nascimento(rs.getDate("DATA_NASCIMENTO"));
//                        objeto.setEndereco(rs.getString("ENDERECO"));
//                        objeto.setBairro(rs.getString("BAIRRO"));			 
//                        objeto.setComplemento(rs.getString("COMPLEMENTO"));
//                        objeto.setCidade(rs.getString("CIDADE"));
//			objeto.setEstado(rs.getString("ESTADO"));
//			objeto.setEmail(rs.getString("EMAIL"));                        
//			objeto.setStatus(rs.getString("STATUS"));
//			objeto.setObservacao(rs.getString("OBSERVACAO"));			
            resultado.add(objeto);
        }
        return resultado;
    }

    @Override
    public Objeto salvar(Objeto objeto) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO `locadora`.`OBJETO`(`DESCRICAO_OBJETO`,`TITULO_ORIGINAL`,`DESCRICAO_RESUMIDA`,"
                + "`TIPO_MOVIMENTO`,`PRODUCAO`,`DURACAO`,`MIDIA`,`TIPO_MIDIA`,`CODIGO_DIARIA`,`CODIGO_GENERO`,`ELENCO`,"
                + "`SINOPSE`)VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";

        try {
            ps = con.prepareStatement(sqlInsert);

            setPreparedStatement1(objeto, ps);

            ps.executeUpdate();
            ResultSet res;
            Integer codigo_max;
            String sql_max = "SELECT MAX(CODIGO_OBJETO) FROM OBJETO";

            ps = con.prepareStatement(sql_max);
            res = ps.executeQuery();
            res.next();
            codigo_max = res.getInt("MAX(CODIGO_OBJETO)");
            objeto.setCodigo_objeto(codigo_max);
            System.out.println(codigo_max);

            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return objeto;
    }

    private void setPreparedStatement(Objeto objeto, PreparedStatement ps)
            throws SQLException {

        ps.setString(1, objeto.getDescricao_objeto());
        ps.setString(2, objeto.getTitulo_original());
        ps.setString(3, objeto.getDescricao_resumida());
        ps.setString(4, objeto.getTipo_movimento());
        ps.setString(5, objeto.getProducao());
        ps.setString(6, objeto.getDuracao());
        ps.setString(7, objeto.getMidia());
        ps.setString(8, objeto.getTipo_midia());
        ps.setInt(9, objeto.getDiaria().getCodigo_diaria());
        ps.setInt(10, objeto.getGenero().getCodigo_genero());
        ps.setString(11, objeto.getElenco());
        ps.setString(12, objeto.getSinopse());
    }

    private void setPreparedStatement1(Objeto objeto, PreparedStatement ps)
            throws SQLException {

        ps.setString(1, objeto.getDescricao_objeto());
        ps.setString(2, objeto.getTitulo_original());
        ps.setString(3, objeto.getDescricao_resumida());
        ps.setString(4, objeto.getTipo_movimento());
        ps.setString(5, objeto.getProducao());
        ps.setString(6, objeto.getDuracao());
        ps.setString(7, objeto.getMidia());
        ps.setString(8, objeto.getTipo_midia());
        ps.setInt(9, objeto.getDiaria().getCodigo_diaria());
        ps.setInt(10, objeto.getGenero().getCodigo_genero());
        ps.setString(11, objeto.getElenco());
        ps.setString(12, objeto.getSinopse());
    }

}
