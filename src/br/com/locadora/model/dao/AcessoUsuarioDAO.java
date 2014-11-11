package br.com.locadora.model.dao;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Usuario;
import br.com.locadora.model.bean.InterfaceAcesso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AcessoUsuarioDAO {

    private InterfacePool pool;

    public AcessoUsuarioDAO(InterfacePool pool) {
        this.pool = pool;
    }
    
    public void atualizar(AcessoUsuario acessoUsuario) {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlAtualizar = " UPDATE `locadora`.`acesso` SET `LER` = ?,`ESCREVER` = ?,`DELETAR` = ?, `SUPER_USUARIO` = ? \n" +        
        "WHERE `CODIGO_ACESSO` = ?";

        try {
            ps = con.prepareStatement(sqlAtualizar);

            setPreparedStatement(acessoUsuario, ps);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AcessoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
    }

    
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

//            resultado = getListaUsuario(rs);
//            if (resultado.size() > 0) {
//                return resultado.get(0);
//            }
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
       
    public List<InterfaceAcesso> getPermissoes() {
        List<InterfaceAcesso> resultado = new ArrayList<InterfaceAcesso>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM INTERFACE WHERE DEL_FLAG = 0";

        try {
            ps = con.prepareStatement(sqlSelect);            

            rs = ps.executeQuery();

            resultado = getListaPermissao(rs);
//            if (resultado.size() > 0) {
//                return resultado.get(0);
//            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AcessoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    
    public List<AcessoUsuario> getPermissaoUsuario(Usuario usuario) {
        List<AcessoUsuario> resultado = new ArrayList<AcessoUsuario>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM ACESSO A, INTERFACE B WHERE A.INTERFACE_CODIGO_INTERFACE = B.CODIGO_INTERFACE "
                + "AND  USUARIO_CODIGO_USUARIO = ?;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, usuario.getCodigo_usuario());
            rs = ps.executeQuery();

            resultado = getListaPermissaoUsuario(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AcessoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
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

//            resultado = getListaUsuario(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    private List<AcessoUsuario> getListaPermissaoUsuario(ResultSet rs) throws SQLException {
        List<AcessoUsuario> resultado = new ArrayList<AcessoUsuario>();
        while (rs.next()) {
            AcessoUsuario acessoUsuario = new AcessoUsuario();
            acessoUsuario.setCodigo_acesso(rs.getInt("CODIGO_ACESSO"));
            acessoUsuario.setLer(rs.getInt("LER"));
            acessoUsuario.setEscrever(rs.getInt("ESCREVER"));
            acessoUsuario.setDeletar(rs.getInt("DELETAR"));
            acessoUsuario.setSuper_usuario(rs.getInt("SUPER_USUARIO"));
            
            InterfaceAcesso inter = new InterfaceAcesso();
            inter.setDescricao(rs.getString("DESCRICAO"));
            inter.setCodigo_interface(rs.getInt("CODIGO_INTERFACE"));
            acessoUsuario.setInterfaceAcesso(inter);
            
            resultado.add(acessoUsuario);
        }
        return resultado;
    }
    
    private List<InterfaceAcesso> getListaPermissao(ResultSet rs) throws SQLException {
        List<InterfaceAcesso> resultado = new ArrayList<InterfaceAcesso>();
        while (rs.next()) {
            InterfaceAcesso interfaceAcesso = new InterfaceAcesso();
            interfaceAcesso.setCodigo_interface(rs.getInt("CODIGO_INTERFACE"));
            interfaceAcesso.setDescricao(rs.getString("DESCRICAO"));
            interfaceAcesso.setNome_classe(rs.getString("NOME_CLASSE"));
            interfaceAcesso.setTipo(rs.getString("TIPO"));
            interfaceAcesso.setDel_flag(rs.getInt("DEL_FLAG"));
            
            resultado.add(interfaceAcesso);
        }
        return resultado;
    }

    
    public void salvar(AcessoUsuario acessoUsuario)  {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO `locadora`.`acesso`(`LER`,`ESCREVER`,`DELETAR`,`SUPER_USUARIO`,\n" +
            "`USUARIO_CODIGO_USUARIO`,`INTERFACE_CODIGO_INTERFACE`)VALUES(?,?,?,?,?,?);";

        try {
            ps = con.prepareStatement(sqlInsert);

            setPreparedStatement1(acessoUsuario, ps);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AcessoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
    }

    private void setPreparedStatement(AcessoUsuario acessoUsuario, PreparedStatement ps)
            throws SQLException {
        
        ps.setInt(1, acessoUsuario.getLer());
        ps.setInt(2, acessoUsuario.getEscrever());
        ps.setInt(3, acessoUsuario.getDeletar());
        ps.setInt(4, acessoUsuario.getSuper_usuario());
        ps.setInt(5, acessoUsuario.getCodigo_acesso());
        
    }

    private void setPreparedStatement1(AcessoUsuario acessoUsuario, PreparedStatement ps)
            throws SQLException {
        
        ps.setInt(1, acessoUsuario.getLer());
        ps.setInt(2, acessoUsuario.getEscrever());
        ps.setInt(3, acessoUsuario.getDeletar());
        ps.setInt(4, acessoUsuario.getSuper_usuario());
        ps.setInt(5, acessoUsuario.getUsuario().getCodigo_usuario());
        ps.setInt(6, acessoUsuario.getInterfaceAcesso().getCodigo_interface());
        
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

//            resultado = getListaUsuario(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

}
