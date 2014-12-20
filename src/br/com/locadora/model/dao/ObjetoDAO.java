package br.com.locadora.model.dao;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.bean.Genero;
import br.com.locadora.model.bean.Objeto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ObjetoDAO implements InterfaceObjetoDAO {
    
    private InterfacePool pool;
    
    public ObjetoDAO(InterfacePool pool) {
        this.pool = pool;
    }
    
    @Override
    public void atualizar(Objeto objeto) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlAtualizar = "UPDATE `LOCADORA`.`OBJETO`\n" +
            "SET\n" +
            "`TITULO` = ?,\n" +
            "`TITULO_ORIGINAL` = ?,\n" +
            "`TIPO_MOVIMENTO` = ?,\n" +
            "`PRODUCAO` = ?,\n" +
            "`DURACAO` = ?,\n" +
            "`MIDIA` = ?,\n" +
            "`TIPO_MIDIA` = ?,\n" +
            "`ELENCO` = ?,\n" +
            "`SINOPSE` = ?,\n" +
            "`CENSURA` = ?,\n" +
            "`GENERO_CODIGO_GENERO` = ?,\n" +
            "`DIARIA_CODIGO_DIARIA` = ?,\n" +
            "`DEL_FLAG` = ?\n" +
            "WHERE `CODIGO_OBJETO` = ?;";
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
        String sqlExcluir = "DELETE FROM OBJETO WHERE CODIGO_OBJETO = ?;";
        
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
    public List<Objeto> getObjeto_objeto(String objeto) throws SQLException {
        List<Objeto> resultado = new ArrayList<Objeto>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n"
                + "    *\n"
                + "FROM\n"
                + "    OBJETO A,\n"
                + "    DIARIA B,\n"
                + "    GENERO C\n"
                + "WHERE\n"
                + "    A.DIARIA_CODIGO_DIARIA = B.CODIGO_DIARIA\n"
                + "        AND A.GENERO_CODIGO_GENERO = C.CODIGO_GENERO\n"
                + "        AND A.TITULO LIKE ?\n"                
                + "GROUP BY A.CODIGO_OBJETO , A.TITULO LIMIT 0, 50;";
        
        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%" + objeto + "%");
            
            rs = ps.executeQuery();
            
            resultado = getListaObjeto(rs);
            
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    @Override
    public List<Objeto> getObjeto_ator(String ator) throws SQLException {
        List<Objeto> resultado = new ArrayList<Objeto>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n"
                + "    *\n"
                + "FROM\n"
                + "    OBJETO A,\n"
                + "    DIARIA B,\n"
                + "    GENERO C\n"
                + "WHERE\n"
                + "    A.DIARIA_CODIGO_DIARIA = B.CODIGO_DIARIA\n"
                + "        AND A.GENERO_CODIGO_GENERO = C.CODIGO_GENERO\n"
                + "        AND A.ELENCO LIKE ? LIMIT 0, 50;";
        
        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%" + ator + "%");
            
            rs = ps.executeQuery();
            
            resultado = getListaObjeto(rs);
            
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    @Override
    public List<Objeto> getObjeto_codigo(Integer codigo_objeto) throws SQLException {
        List<Objeto> resultado = new ArrayList<Objeto>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n"
                + "    *\n"
                + "FROM\n"
                + "    OBJETO A,\n"
                + "    DIARIA B,\n"
                + "    GENERO C\n"
                + "WHERE\n"
                + "    A.DIARIA_CODIGO_DIARIA = B.CODIGO_DIARIA\n"
                + "        AND A.GENERO_CODIGO_GENERO = C.CODIGO_GENERO\n"
                + "        AND A.CODIGO_OBJETO = ? LIMIT 0, 50;";
        
        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo_objeto);
            
            rs = ps.executeQuery();
            
            resultado = getListaObjeto(rs);
            
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    @Override
    public List<Objeto> getObjetos() throws SQLException {
        List<Objeto> resultado = new ArrayList<Objeto>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM CLIENTE ORDER BY NOME_CLIENTE LIMIT 0, 50;";
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
            objeto.setCodigo_objeto(rs.getInt("CODIGO_OBJETO"));
            objeto.setTitulo(rs.getString("TITULO"));
            objeto.setTitulo_original(rs.getString("TITULO_ORIGINAL"));            
            objeto.setTipo_movimento(rs.getString("TIPO_MOVIMENTO"));
            objeto.setProducao(rs.getString("PRODUCAO"));
            objeto.setDuracao(rs.getString("DURACAO"));
            objeto.setMidia(rs.getString("MIDIA"));
            objeto.setTipo_midia(rs.getString("TIPO_MIDIA"));
            objeto.setElenco(rs.getString("ELENCO"));
            objeto.setSinopse(rs.getString("SINOPSE"));
            objeto.setCensura(rs.getInt("CENSURA"));
            
            Diaria diaria = new Diaria();
            diaria.setCodigo_diaria(rs.getInt("DIARIA_CODIGO_DIARIA"));
            diaria.setDias(rs.getInt("DIAS"));
            diaria.setNome_diaria(rs.getString("NOME_DIARIA"));
            diaria.setValor(rs.getDouble("VALOR"));
            
            Genero genero = new Genero();
            genero.setCodigo_genero(rs.getInt("CODIGO_GENERO"));
            genero.setNome_genero(rs.getString("NOME_GENERO"));
            
            objeto.setGenero(genero);
            objeto.setDiaria(diaria);
            resultado.add(objeto);
        }
        return resultado;
    }
    
    @Override
    public Objeto salvar(Objeto objeto) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;
        
        String sqlInsert = "INSERT INTO `locadora`.`OBJETO`(`TITULO`,`TITULO_ORIGINAL`,"
                + "`TIPO_MOVIMENTO`,`PRODUCAO`,`DURACAO`,`MIDIA`,`TIPO_MIDIA`,`DIARIA_CODIGO_DIARIA`,`GENERO_CODIGO_GENERO`,`ELENCO`,"
                + "`SINOPSE`, CENSURA)VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
        
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
        
        ps.setString(1, objeto.getTitulo());
        ps.setString(2, objeto.getTitulo_original());        
        ps.setString(3, objeto.getTipo_movimento());
        ps.setString(4, objeto.getProducao());
        ps.setString(5, objeto.getDuracao());
        ps.setString(6, objeto.getMidia());
        ps.setString(7, objeto.getTipo_midia());
        ps.setString(8, objeto.getElenco());
        ps.setString(9, objeto.getSinopse());
        ps.setInt(10, objeto.getCensura());
        ps.setInt(11, objeto.getGenero().getCodigo_genero());
        ps.setInt(12, objeto.getDiaria().getCodigo_diaria());
        ps.setInt(13, Integer.parseInt(objeto.getStatus()));
        ps.setInt(14, objeto.getCodigo_objeto());
        System.out.println("6 - Diária alterar código: "+objeto.getDiaria().getCodigo_diaria());
        System.out.println("6 - Diária alterar descrição: "+objeto.getDiaria().getNome_diaria());
    }
    
    private void setPreparedStatement1(Objeto objeto, PreparedStatement ps)
            throws SQLException {
        
        ps.setString(1, objeto.getTitulo());
        ps.setString(2, objeto.getTitulo_original());        
        ps.setString(3, objeto.getTipo_movimento());
        ps.setString(4, objeto.getProducao());
        ps.setString(5, objeto.getDuracao());
        ps.setString(6, objeto.getMidia());
        ps.setString(7, objeto.getTipo_midia());
        ps.setInt(8, objeto.getDiaria().getCodigo_diaria());
        ps.setInt(9, objeto.getGenero().getCodigo_genero());
        ps.setString(10, objeto.getElenco());
        ps.setString(11, objeto.getSinopse());
        ps.setInt(12, objeto.getCensura());
    }
    
}
