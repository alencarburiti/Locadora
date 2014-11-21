package br.com.locadora.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.Diaria;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DiariaDAO implements InterfaceDiariaDAO {

    private InterfacePool pool;

    public DiariaDAO(InterfacePool pool) {
        this.pool = pool;
    }

    @Override
    public void atualizar(Diaria diaria) {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlAtualizar = "UPDATE `locadora`.`DIARIA` SET `NOME_DIARIA` = ?, `VALOR` = ?,\n" +
            " `DIAS` = ?, `MULTAS` = ? WHERE `CODIGO_DIARIA` = ?;";

        try {
            ps = con.prepareStatement(sqlAtualizar);

            setPreparedStatement(diaria, ps);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema ao atualizar");
            ex.printStackTrace();
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
    public Diaria getDiaria_codigo(Integer codigo) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM DIARIA WHERE CODIGO_DIARIA = ?;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo);

            rs = ps.executeQuery();

            List<Diaria> resultado = getListaDiaria(rs);
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
    public List<Diaria> getDiaria_nome(String nome_diaria) throws SQLException {
        List<Diaria> resultado = new ArrayList<Diaria>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM DIARIA WHERE NOME_DIARIA LIKE ? ORDER BY NOME_DIARIA;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%"+nome_diaria+"%");
            rs = ps.executeQuery();

            resultado = getListaDiaria(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
        public List<Diaria> getDiarias(String nome_diaria) throws SQLException {
        List<Diaria> resultado = new ArrayList<Diaria>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM DIARIA WHERE NOME_DIARIA LIKE ? ORDER BY NOME_DIARIA;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%"+nome_diaria+"%");
            rs = ps.executeQuery();

            resultado = getListaDiaria(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    public List<Diaria> getTodasDiarias() {
        List<Diaria> resultado = new ArrayList<Diaria>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM DIARIA ORDER BY NOME_DIARIA;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();

            resultado = getListaDiaria(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DiariaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    private List<Diaria> getListaDiaria(ResultSet rs) throws SQLException {
        List<Diaria> resultado = new ArrayList<Diaria>();
        while (rs.next()) {
            Diaria diaria = new Diaria();
            diaria.setCodigo_diaria(rs.getInt("CODIGO_DIARIA"));
            diaria.setNome_diaria(rs.getString("NOME_DIARIA"));
            diaria.setValor(rs.getDouble("VALOR"));
            diaria.setValor_promocao(rs.getDouble("VALOR_PROMOCAO"));
            diaria.setMultas(rs.getDouble("MULTAS"));
            diaria.setDias(rs.getInt("DIAS"));

            resultado.add(diaria);
        }
        return resultado;
    }

    @Override
    public void salvar(Diaria diaria) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO `locadora`.`DIARIA`(`NOME_DIARIA`,`VALOR`,"
                + "`VALOR_PROMOCAO`,`DIAS`,`MULTAS`)VALUES(?,?,?,?,?);";

        try {
            ps = con.prepareStatement(sqlInsert);

            setPreparedStatement1(diaria, ps);

            ps.executeUpdate();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
    }

    private void setPreparedStatement(Diaria diaria, PreparedStatement ps)
            throws SQLException {
        ps.setString(1, diaria.getNome_diaria());
        ps.setDouble(2, diaria.getValor());        
        ps.setInt(3, diaria.getDias());
        ps.setDouble(4, diaria.getMultas());
        ps.setInt(5, diaria.getCodigo_diaria());
        
    }

    private void setPreparedStatement1(Diaria diaria, PreparedStatement ps)
            throws SQLException {
        ps.setString(1, diaria.getNome_diaria());
        ps.setDouble(2, diaria.getValor());
        ps.setDouble(3, diaria.getValor_promocao());
        ps.setInt(4, diaria.getDias());
        ps.setDouble(5, diaria.getMultas());
    }

    public List<Diaria> getDiarias() throws SQLException {
        List<Diaria> resultado = new ArrayList<Diaria>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM CLIENTE ORDER BY NOME_CLIENTE;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();

            resultado = getListaDiaria(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

}
