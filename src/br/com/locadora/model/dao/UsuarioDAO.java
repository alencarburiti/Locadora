    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model.dao;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Usuario;
import br.com.locadora.util.Conexao;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ALENCAR
 */
public class UsuarioDAO implements InterfaceUsuarioDAO {

    private InterfacePool pool;

    public UsuarioDAO(InterfacePool pool) {
        this.pool = pool;
    }

    java.sql.PreparedStatement pstm;
    ResultSet rs;

    //comando sql para inserir dados na tabela destino
    private String cadastraUsuario = "INSERT INTO usuario (NOME_USUARIO, LOGIN, SENHA)VALUES(?,?,?)";
    //comando sql para consultar pelo nome
    private String consultaUsuarioNome = "SELECT * FROM USUARIO WHERE NOME_USUARIO LIKE ? ORDER BY NOME_USUARIO";
    private String consultaUsuarioDescricao = "SELECT * FROM USUARIO WHERE (NOME_USUARIO LIKE ?) ORDER BY NOME_USUARIO";
    private String consultaUsuarioDescricao1 = "SELECT * FROM USUARIO WHERE (LOGIN LIKE ?) ORDER BY NOME_USUARIO";
    private String consultaUsuarioCodigo = "SELECT * FROM USUARIO WHERE CODIGO_USUARIO = ? ORDER BY NOME_USUARIO";
    private String consultaUsuarioLogin = "SELECT * FROM USUARIO WHERE LOGIN = ?";
    // comando sql para alterar dados da tabela aluno
    private String alteraUsuario = "UPDATE usuario SET NOME_USUARIO = ?,LOGIN = ?,SENHA = ? WHERE CODIGO_USUARIO = ?";
    private String excluiUsuario = "DELETE FROM USUARIO WHERE CODIGO_USUARIO = ?";

    public void cadastraUsuario(Usuario usuario) {
        try {

            Conexao conexao = new Conexao();

            pstm = (PreparedStatement) conexao.conecta().prepareStatement(cadastraUsuario);
            pstm.setString(1, usuario.getNome_usuario());
            pstm.setString(2, usuario.getLogin());
            pstm.setString(3, usuario.getSenha());
            pstm.executeUpdate();
            
            
            conexao.desconecta();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não foi possivel gravar");

        }
    }

    public void alteraUsuario(Usuario usuario) {
        try {

            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(alteraUsuario);
            pstm.setString(1, usuario.getNome_usuario());
            pstm.setString(2, usuario.getLogin());
            pstm.setString(3, usuario.getSenha());
            pstm.setInt(4, usuario.getCodigo_usuario());
            pstm.executeUpdate();
            conexao.desconecta();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não foi possivel gravar");

        }
    }

    public boolean excluiUsuario(Usuario usuario)  throws SQLException{
        try {

            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(excluiUsuario);
            pstm.setInt(1, usuario.getCodigo_usuario());
            pstm.executeUpdate();
            conexao.desconecta();
            return true;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Este registro não pode ser excluído pois está referenciado em outra tabela");
            return false;

        }
    }

    public List<Usuario> getUsuarios(String nome_usuario) {
        List<Usuario> resultado = new ArrayList<Usuario>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM USUARIO WHERE NOME_USUARIO LIKE ?;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, nome_usuario);
            rs = ps.executeQuery();

            resultado = getListaUsuario(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
        
    public List<Usuario> getUsuarios() {
        List<Usuario> resultado = new ArrayList<Usuario>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM USUARIO WHERE DEL_FLAG = 0;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();

            resultado = getListaUsuario(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    public List<Usuario> listarUsuarioCodigo(String cod_usuário) {
        List<Usuario> usuario = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaUsuarioCodigo);
            pstm.setString(1, cod_usuário);
            rs = pstm.executeQuery();
            Usuario usua;
            while (rs.next()) {
                usua = new Usuario();
                usua.setCodigo_usuario(rs.getInt("CODIGO_USUARIO"));
                usua.setNome_usuario(rs.getString("NOME_USUARIO"));
                usua.setLogin(rs.getString("LOGIN"));
                usua.setSenha(rs.getString("SENHA"));
                usuario.add(usua);

            }
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public List<Usuario> listarUsuarioDescrição(String nome_usuario) {
        List<Usuario> usuario = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaUsuarioDescricao);
            pstm.setString(1, nome_usuario);
            rs = pstm.executeQuery();
            Usuario usua;
            while (rs.next()) {
                usua = new Usuario();
                usua.setCodigo_usuario(rs.getInt("CODIGO_USUARIO"));
                usua.setNome_usuario(rs.getString("NOME_USUARIO"));
                usua.setLogin(rs.getString("LOGIN"));
                usua.setSenha(rs.getString("SENHA"));                
                usuario.add(usua);

            }
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public List<Usuario> listarUsuarioDescrição1(String nome_usuario, String login) {
        List<Usuario> usuario = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaUsuarioDescricao1);
            pstm.setString(1, nome_usuario);
            pstm.setString(2, login);
            rs = pstm.executeQuery();
            Usuario usua;
            while (rs.next()) {
                usua = new Usuario();
                usua.setCodigo_usuario(rs.getInt("CODIGO_USUARIO"));
                usua.setNome_usuario(rs.getString("NOME_USUARIO"));
                usua.setLogin(rs.getString("LOGIN"));
                usua.setSenha(rs.getString("SENHA"));                
                usuario.add(usua);

            }
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public List<Usuario> consultarLogin(String login) {
        List<Usuario> usuario = new ArrayList();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            ps = con.prepareStatement(consultaUsuarioLogin);

            ps.setString(1, login);
            rs = ps.executeQuery();
            //rs.absolute(1);
            Usuario usua;
            while (rs.next()) {
                usua = new Usuario();
                usua.setCodigo_usuario(rs.getInt("CODIGO_USUARIO"));
                usua.setNome_usuario(rs.getString("NOME_USUARIO"));
                usua.setLogin(rs.getString("LOGIN"));
                usua.setSenha(rs.getString("SENHA"));
                usuario.add(usua);

            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error: "+ ex);
        } finally {
            pool.liberarConnection(con);
        }
        return usuario;
    }

    public AcessoUsuario verificarPermissao(String senha, String nome_classe) {

        AcessoUsuario acesso = null;
        Usuario usuario = null;
        try {
            Conexao conexao = new Conexao();

            String sqlSelect = "SELECT \n"
                    + "    A.CODIGO_USUARIO, A.NOME_USUARIO, A.LOGIN, A.SENHA, B.LER, B.ESCREVER, B.DELETAR\n"
                    + "FROM\n"
                    + "    USUARIO A,\n"
                    + "    ACESSO B,\n"
                    + "    INTERFACE C\n"
                    + "WHERE\n"
                    + "    A.CODIGO_USUARIO = B.USUARIO_CODIGO_USUARIO\n"
                    + "    AND C.CODIGO_INTERFACE = B.INTERFACE_CODIGO_INTERFACE\n"
                    + "        AND C.NOME_CLASSE = ? \n"
                    + "        AND A.SENHA = ? ;";

            pstm = (PreparedStatement) conexao.conecta().prepareStatement(sqlSelect);
            pstm.setString(1, nome_classe);
            pstm.setString(2, senha);
            rs = pstm.executeQuery();
            rs.absolute(1);

            //            rs.next();
            acesso = new AcessoUsuario();
            usuario = new Usuario();

            usuario.setCodigo_usuario(rs.getInt("CODIGO_USUARIO"));
            usuario.setNome_usuario(rs.getString("NOME_USUARIO"));
            usuario.setLogin(rs.getString("LOGIN"));
            usuario.setSenha(rs.getString("SENHA"));

            acesso.setUsuario(usuario);

            acesso.setLer(rs.getInt("LER"));
            acesso.setEscrever(rs.getInt("ESCREVER"));
            acesso.setDeletar(rs.getInt("DELETAR"));

            pstm.close();
            rs.close();
            conexao.desconecta();

        } catch (Exception e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Senha incorreta");
                    
        }
        return acesso;
    }
    
    public AcessoUsuario permissaoInterface(String login, String nome_classe) {

        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        AcessoUsuario acesso = new AcessoUsuario();
        Usuario usuario = new Usuario();
            
            
        String sqlSelect = "SELECT \n"
                + "    * \n"
                + "FROM\n"
                + "    USUARIO A,\n"
                + "    ACESSO B,\n"
                + "    INTERFACE C\n"
                + "WHERE\n"
                + "    A.CODIGO_USUARIO = B.USUARIO_CODIGO_USUARIO\n"
                + "    AND C.CODIGO_INTERFACE = B.INTERFACE_CODIGO_INTERFACE\n"
                + "        AND C.NOME_CLASSE = ? \n"
                + "        AND A.LOGIN = ? ;";

        try {

            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, nome_classe);
            ps.setString(2, login);
            rs = ps.executeQuery();            
            
            while(rs.next()){
                System.out.println("=======Início Permissão=========");
                System.out.println("Nome da Classe:"+nome_classe);
                System.out.println("Código do Usuário: "+rs.getInt("CODIGO_USUARIO"));
                System.out.println("Senha: "+rs.getString("SENHA"));
                System.out.println("Login: "+rs.getString("LOGIN"));
                
                System.out.println("LER: "+rs.getInt("LER"));
                System.out.println("ESCREVER: "+rs.getInt("ESCREVER"));
                System.out.println("DELETAR: "+rs.getInt("DELETAR"));
                System.out.println("SUPER: "+rs.getInt("SUPER_USUARIO"));
                System.out.println("==========Fim Permissão==========");
                
                usuario.setCodigo_usuario(rs.getInt("CODIGO_USUARIO"));
                usuario.setLogin(rs.getString("LOGIN"));
                usuario.setSenha(rs.getString("SENHA"));

                acesso.setUsuario(usuario);

                acesso.setLer(rs.getInt("LER"));
                acesso.setEscrever(rs.getInt("ESCREVER"));
                acesso.setDeletar(rs.getInt("DELETAR"));   
                acesso.setSuper_usuario(rs.getInt("SUPER_USUARIO"));
            }

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } finally {
            pool.liberarConnection(con);

        }
        return acesso;
    }

    public void salvarCaixa(String ip, String name, Integer numero_caixa) {

        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        AcessoUsuario acesso = new AcessoUsuario();
        Usuario usuario = new Usuario();
            
            
        String sqlInsert = "INSERT INTO `locadora`.`CAIXA`(`IP`,`NAME`,`NUMERO`)VALUES(?,?,?);";

        try {

            ps = con.prepareStatement(sqlInsert);
            ps.setString(1, ip);
            ps.setString(2, name);
            ps.setInt(3, numero_caixa);
            
            ps.executeUpdate();            
            
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } finally {
            pool.liberarConnection(con);

        }

    }
    
    public void excluir(Integer codigo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void salvar(Usuario usuario) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void atualizar(Usuario usuario) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Usuario> getUsuario(Integer codigo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    private List<Usuario> getListaUsuario(ResultSet rs) throws SQLException {
        List<Usuario> resultado = new ArrayList<Usuario>();
        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setCodigo_usuario(rs.getInt("CODIGO_USUARIO"));
            usuario.setNome_usuario(rs.getString("NOME_USUARIO"));
            usuario.setLogin(rs.getString("LOGIN"));
            resultado.add(usuario);
        }
        return resultado;
    }
}
