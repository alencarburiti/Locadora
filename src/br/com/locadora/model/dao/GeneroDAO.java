package br.com.locadora.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.Genero;

public class GeneroDAO implements InterfaceGeneroDAO {

    private InterfacePool pool;

    public GeneroDAO(InterfacePool pool) {
        this.pool = pool;
    }

    @Override
    public void atualizar(Genero genero) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlAtualizar = " UPDATE DIARIA SET bairro=?, celular=?, cep=?, "
                + " cidade=?, cpf_cnpj=?, email=?, endereco=?, estado=?,"
                + " telefone=?, nome=? WHERE codigo = ? ;";

        try {
            ps = con.prepareStatement(sqlAtualizar);

            setPreparedStatement(genero, ps);

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
    public Genero getGenero(Integer codigo) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM DIARIA WHERE CODIGO_DIARIA = ?;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo);

            rs = ps.executeQuery();

            List<Genero> resultado = getListaGenero(rs);
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
    public List<Genero> getGeneros(String nome_genero) throws SQLException {
        List<Genero> resultado = new ArrayList<Genero>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM GENERO WHERE NOME_GENERO LIKE ? ORDER BY NOME_GENERO;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, nome_genero);
            rs = ps.executeQuery();

            resultado = getListaGenero(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    public List<Genero> getTodasGeneros() throws SQLException {
        List<Genero> resultado = new ArrayList<Genero>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM GENERO ORDER BY NOME_GENERO;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();

            resultado = getListaGenero(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    private List<Genero> getListaGenero(ResultSet rs) throws SQLException {
        List<Genero> resultado = new ArrayList<Genero>();
        while (rs.next()) {
            Genero genero = new Genero();
            genero.setCodigo_genero(rs.getInt("CODIGO_GENERO"));
            genero.setNome_genero(rs.getString("NOME_GENERO"));
            
            resultado.add(genero);
        }
        return resultado;
    }

    @Override
    public void salvar(Genero genero) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO `locadora`.`DIARIA`(`NOME_DIARIA`,`VALOR`,"
                + "`VALOR_PROMOCAO`,`DIAS`,`MULTAS`)VALUES(?,?,?,?,?);";

        try {
            ps = con.prepareStatement(sqlInsert);

            setPreparedStatement1(genero, ps);

            ps.executeUpdate();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
    }

    private void setPreparedStatement(Genero genero, PreparedStatement ps)
            throws SQLException {
        ps.setString(1, genero.getNome_genero());
     
    }

    private void setPreparedStatement1(Genero genero, PreparedStatement ps)
            throws SQLException {
            ps.setString(1, genero.getNome_genero());
    }

    public List<Genero> getGeneros() throws SQLException {
        List<Genero> resultado = new ArrayList<Genero>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM CLIENTE ORDER BY NOME_CLIENTE;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();

            resultado = getListaGenero(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

}
