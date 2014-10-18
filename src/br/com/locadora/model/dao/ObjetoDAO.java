package br.com.locadora.model.dao;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.Cliente;
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
        try {
            ps = con.prepareCall("{CALL SP_UPDATE_OBJETO_BY_PK(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            
            setPreparedStatement(objeto, ps);

            ps.execute();
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
    public List<Objeto> getObjeto_objeto(String objeto) throws SQLException {
        List<Objeto> resultado = new ArrayList<Objeto>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n"
                + "    *\n"
                + "FROM\n"
                + "    LOCADORA.OBJETO A,\n"
                + "    LOCADORA.DIARIA B,\n"
                + "    LOCADORA.GENERO C\n"
                + "WHERE\n"
                + "    A.DIARIA_CODIGO_DIARIA = B.CODIGO_DIARIA\n"
                + "        AND A.GENERO_CODIGO_GENERO = C.CODIGO_GENERO\n"
                + "        AND A.DESCRICAO_OBJETO LIKE ?\n"
                + "        or TITULO_ORIGINAL LIKE ?\n"
                + "        OR DESCRICAO_RESUMIDA LIKE ?\n"
                + "GROUP BY A.CODIGO_OBJETO , A.DESCRICAO_OBJETO;";
        
        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%" + objeto + "%");
            ps.setString(2, "%" + objeto + "%");
            ps.setString(3, "%" + objeto + "%");
            
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
                + "    LOCADORA.OBJETO A,\n"
                + "    LOCADORA.DIARIA B,\n"
                + "    LOCADORA.GENERO C\n"
                + "WHERE\n"
                + "    A.DIARIA_CODIGO_DIARIA = B.CODIGO_DIARIA\n"
                + "        AND A.GENERO_CODIGO_GENERO = C.CODIGO_GENERO\n"
                + "        AND A.ELENCO LIKE ? ";
        
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
                + "    LOCADORA.OBJETO A,\n"
                + "    LOCADORA.DIARIA B,\n"
                + "    LOCADORA.GENERO C\n"
                + "WHERE\n"
                + "    A.DIARIA_CODIGO_DIARIA = B.CODIGO_DIARIA\n"
                + "        AND A.GENERO_CODIGO_GENERO = C.CODIGO_GENERO\n"
                + "        AND A.CODIGO_OBJETO = ?;";
        
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
            objeto.setCodigo_objeto(rs.getInt("CODIGO_OBJETO"));
            objeto.setDescricao_objeto(rs.getString("DESCRICAO_OBJETO"));
            objeto.setTitulo_original(rs.getString("TITULO_ORIGINAL"));
            objeto.setDescricao_resumida(rs.getString("DESCRICAO_RESUMIDA"));
            objeto.setTipo_movimento(rs.getString("TIPO_MOVIMENTO"));
            objeto.setProducao(rs.getString("PRODUCAO"));
            objeto.setDuracao(rs.getString("DURACAO"));
            objeto.setMidia(rs.getString("MIDIA"));
            objeto.setTipo_midia(rs.getString("TIPO_MIDIA"));
            objeto.setElenco(rs.getString("ELENCO"));
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
        
        String sqlInsert = "INSERT INTO `locadora`.`OBJETO`(`DESCRICAO_OBJETO`,`TITULO_ORIGINAL`,`DESCRICAO_RESUMIDA`,"
                + "`TIPO_MOVIMENTO`,`PRODUCAO`,`DURACAO`,`MIDIA`,`TIPO_MIDIA`,`DIARIA_CODIGO_DIARIA`,`GENERO_CODIGO_GENERO`,`ELENCO`,"
                + "`SINOPSE`, CENSURA)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);";
        
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
        
        ps.setInt(1, objeto.getCodigo_objeto());
        ps.setString(2, objeto.getDescricao_objeto());
        ps.setString(3, objeto.getTitulo_original());
        ps.setString(4, objeto.getDescricao_resumida());
        ps.setString(5, objeto.getTipo_movimento());
        ps.setString(6, objeto.getProducao());
        ps.setString(7, objeto.getDuracao());
        ps.setString(8, objeto.getMidia());
        ps.setString(9, objeto.getTipo_midia());
        ps.setString(10, objeto.getElenco());
        ps.setString(11, objeto.getSinopse());
        ps.setInt(12, objeto.getCensura());
        ps.setInt(13, objeto.getGenero().getCodigo_genero());
        ps.setInt(14, objeto.getDiaria().getCodigo_diaria());
        ps.setInt(15, Integer.parseInt(objeto.getStatus()));
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
        ps.setInt(13, objeto.getCensura());
    }
    
}
