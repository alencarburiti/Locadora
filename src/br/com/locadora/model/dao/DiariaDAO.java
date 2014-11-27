package br.com.locadora.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.bean.Promocao;
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
        String sqlAtualizar = "UPDATE `locadora`.`DIARIA` SET `NOME_DIARIA` = ?, `VALOR` = ?,\n"
                + " `DIAS` = ?, `MULTAS` = ? WHERE `CODIGO_DIARIA` = ?;";

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
    
    public void excluirPromocao(Integer codigo) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlExcluir = "DELETE FROM PROMOCAO WHERE CODIGO_PROMOCAO = ?;";

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
            ps.setString(1, "%" + nome_diaria + "%");
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
            ps.setString(1, "%" + nome_diaria + "%");
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
    
    public List<Diaria> getDiariaPromocao() {
        List<Diaria> resultado = new ArrayList<Diaria>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM DIARIA A, PROMOCAO B WHERE A.CODIGO_DIARIA = B.DIARIA_CODIGO_DIARIA;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();

            resultado = getListaDiariaPromocao(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DiariaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    public List<Diaria> getDiariaPromocao(Diaria diaria) {
        List<Diaria> resultado = new ArrayList<Diaria>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM DIARIA A, PROMOCAO B WHERE A.CODIGO_DIARIA = B.DIARIA_CODIGO_DIARIA and codigo_diaria = ?"
                + " ORDER BY ORDEM;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, diaria.getCodigo_diaria());
            rs = ps.executeQuery();

            resultado = getListaDiariaPromocao(rs);

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
            diaria.setMultas(rs.getDouble("MULTAS"));
            diaria.setDias(rs.getInt("DIAS"));
            diaria.setMaximo_dias(rs.getInt("MAXIMO_DIAS"));
            if(rs.getInt("ACUMULATIVO") == 0){
                diaria.setAcumulativo(true);                
            } else {
                diaria.setAcumulativo(false);                
            }

            resultado.add(diaria);
        }
        return resultado;
    }
    
    private List<Diaria> getListaDiariaPromocao(ResultSet rs) throws SQLException {
        List<Diaria> resultado = new ArrayList<Diaria>();
        while (rs.next()) {
            Promocao promocao = new Promocao();
            
            promocao.setCodigo_promocao(rs.getInt("CODIGO_PROMOCAO"));
            promocao.setDescricao_promocao(rs.getString("DESCRICAO_PROMOCAO"));
            promocao.setValor_promocao(rs.getDouble("VALOR_PROMOCAO"));
            promocao.setLocar_quantidade(rs.getInt("LOCAR_QUANTIDADE"));
            promocao.setGanhar_quantidade(rs.getInt("GANHAR_QUANTIDADE"));
            if(rs.getString("PAGAMENTO_A_VISTA").equals("0")){
                System.out.println("Pagamento a vista: "+ true);
                promocao.setPagamento_a_vista(true);                
            }else {
                System.out.println("Pagamento a vista: "+ false);
                promocao.setPagamento_a_vista(false);                
            }
            
            promocao.setOrderm(rs.getInt("ORDEM"));
            if(rs.getInt("DOMINGO")==0){
                promocao.setDomingo(true);
            } else {
                promocao.setDomingo(false);
            }
            
            if(rs.getInt("SEGUNDA") == 0){
                promocao.setSegunda(true);
            } else {
                promocao.setSegunda(false);
            }
            
            if(rs.getInt("TERCA") == 0){
                promocao.setTerca(true);                
            } else {
                promocao.setTerca(false);                
            }
            if(rs.getInt("QUARTA") == 0){
                promocao.setQuarta(true);
            } else {
                promocao.setQuarta(false);
            }
            if(rs.getInt("QUINTA") == 0){
                promocao.setQuinta(true);
            } else {
                promocao.setQuinta(false);
            }
            if(rs.getInt("SEXTA") == 0){
                promocao.setSexta(true);
            } else {
                promocao.setSexta(false);
            }
            if(rs.getInt("SABADO") == 0){
                promocao.setSabado(true);
            } else {
                promocao.setSabado(false);
            }
            
            
            Diaria diaria = new Diaria();
            
            diaria.setPromocao(promocao);
            diaria.setCodigo_diaria(rs.getInt("CODIGO_DIARIA"));
            diaria.setNome_diaria(rs.getString("NOME_DIARIA"));
            diaria.setValor(rs.getDouble("VALOR"));
            diaria.setMultas(rs.getDouble("MULTAS"));
            diaria.setDias(rs.getInt("DIAS"));
            
            resultado.add(diaria);
        }
        return resultado;
    }

    @Override
    public Diaria salvar(Diaria diaria) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO `locadora`.`DIARIA`(`NOME_DIARIA`,`VALOR`,"
                + "`DIAS`,`MULTAS`, MAXIMO_DIAS, ACUMULATIVO)VALUES(?,?,?,?,?,?);";

        try {
            ps = con.prepareStatement(sqlInsert);

            setPreparedStatement1(diaria, ps);

            ps.executeUpdate();

            ResultSet res;
            Integer codigo_max;
            String sql_max = "SELECT MAX(CODIGO_DIARIA) FROM DIARIA";

            ps = con.prepareStatement(sql_max);
            res = ps.executeQuery();
            res.next();
            codigo_max = res.getInt("MAX(CODIGO_DIARIA)");
            diaria.setCodigo_diaria(codigo_max);

            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return diaria;
    }

    public Diaria salvarPromocao(Diaria diaria) {
        Connection con = pool.getConnection();
        PreparedStatement ps;
        Diaria diariaRetorno = new Diaria();

        String sqlInsert = "INSERT INTO `locadora`.`promocao`(`descricao_promocao`,`valor_promocao`, \n"
                + " `ordem`,`diaria_codigo_diaria`,pagamento_a_vista, "
                + " `domingo`, segunda, terca, quarta, quinta, sexta, sabado, locar_quantidade, ganhar_quantidade)\n"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

        try {
            ps = con.prepareStatement(sqlInsert);

            ps.setString(1, diaria.getPromocao().getDescricao_promocao());
            ps.setDouble(2, diaria.getPromocao().getValor_promocao());
            ps.setInt(3, diaria.getPromocao().getOrderm());
            ps.setInt(4, diaria.getPromocao().getDiaria().getCodigo_diaria());
            if (diaria.getPromocao().getPagamento_a_vista() == true) {
                ps.setString(5, "0");
            } else {
                ps.setString(5, "1");
            }

            if (diaria.getPromocao().getDomingo() == true) {
                ps.setInt(6, 0);
            } else {
                ps.setInt(6, 1);
            }

            if (diaria.getPromocao().getSegunda() == true) {
                ps.setInt(7, 0);
            } else {
                ps.setInt(7, 1);
            }

            if (diaria.getPromocao().getTerca() == true) {
                ps.setInt(8, 0);
            } else {
                ps.setInt(8, 1);
            }

            if (diaria.getPromocao().getQuarta() == true) {
                ps.setInt(9, 0);
            } else {
                ps.setInt(9, 1);
            }

            if (diaria.getPromocao().getQuinta() == true) {
                ps.setInt(10, 0);
            } else {
                ps.setInt(10, 1);
            }

            if (diaria.getPromocao().getSexta() == true) {
                ps.setInt(11, 0);
            } else {
                ps.setInt(11, 1);
            }

            if (diaria.getPromocao().getSabado() == true) {
                ps.setInt(12, 0);
            } else {
                ps.setInt(12, 1);
            }

            ps.setInt(13, diaria.getPromocao().getLocar_quantidade());
            ps.setInt(14, diaria.getPromocao().getGanhar_quantidade());
            
            
            ps.executeUpdate();

            ResultSet res;
            Integer codigo_max;
            String sql_max = "SELECT MAX(CODIGO_PROMOCAO) FROM PROMOCAO";

            ps = con.prepareStatement(sql_max);
            res = ps.executeQuery();
            res.next();
            codigo_max = res.getInt("MAX(CODIGO_PROMOCAO)");
            Promocao promo = new Promocao();
            promo.setCodigo_promocao(codigo_max);
            diariaRetorno.setPromocao(promo);
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DiariaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return diariaRetorno;
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
        ps.setInt(3, diaria.getDias());
        ps.setDouble(4, diaria.getMultas());
        ps.setInt(5, diaria.getMaximo_dias());
        if (diaria.getAcumulativo() == true) {
            ps.setInt(6, 0);
        } else {
            ps.setInt(6, 1);
        }
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
