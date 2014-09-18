    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model.dao;

import br.com.locadora.model.bean.TipoObjeto;
import br.com.locadora.util.Conexao;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ALENCAR
 */
public class TipoObjetoDAO {

    PreparedStatement pstm;
    ResultSet rs;
//comando sql para inserir dados na tabela GENERO
    private String cadastraTipoObjeto = "INSERT INTO GENERO (NOME_GENERO) VALUES (?)";
    //comando sql para consultar pelo nome
    private String consultaTipoObjetoNome = "SELECT CODIGO_GENERO, NOME_GENERO FROM GENERO WHERE NOME_GENERO LIKE ? ORDER BY NOME_GENERO";
    private String consultaTipoObjetoDescricao = "SELECT CODIGO_GENERO, NOME_GENERO FROM GENERO WHERE NOME_GENERO LIKE ? ORDER BY NOME_GENERO";
    private String consultaTipoObjetoCodigo = "SELECT CODIGO_GENERO,NOME_GENERO FROM GENERO WHERE (CODIGO_GENERO = ?) ORDER BY NOME_GENERO";
    private String consulta = "SELECT CODIGO_GENERO, NOME_GENERO FROM GENERO ORDER BY NOME_GENERO";
    // comando sql para alterar dados da tabela aluno
    private String alteraTipoObjeto = "UPDATE GENERO SET NOME_GENERO = ? WHERE CODIGO_GENERO = ?";
    private String excluiTipoObjeto = "DELETE FROM GENERO WHERE CODIGO_GENERO = ?";

    public TipoObjetoDAO() {
    }
//metodo para cadastrar GENERO

    public void cadastraTipoObjeto(TipoObjeto tipoObjeto) {
        try {

            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(cadastraTipoObjeto);
            pstm.setString(1, tipoObjeto.getNome_tipo_objeto());
            pstm.executeUpdate();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void alteraTipoObjeto(TipoObjeto tipoObjeto) {
        try {

            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(alteraTipoObjeto);
            pstm.setString(1, tipoObjeto.getNome_tipo_objeto());
            pstm.setInt(2, tipoObjeto.getCodigo_tipo_objeto());
            pstm.executeUpdate();
            conexao.desconecta();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não foi possivel gravar");

        }
    }

    public boolean excluiTipoObjeto(TipoObjeto tipoObjeto) {
        try {

            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(excluiTipoObjeto);
            pstm.setInt(1, tipoObjeto.getCodigo_tipo_objeto());
            pstm.executeUpdate();
            conexao.desconecta();
            return true;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Este registro não pode ser excluído pois está referenciado em outra tabela");
            return false;
        }
    }

    public List<TipoObjeto> listarTipoObjeto(String nome_tipoObjeto) {
        List<TipoObjeto> tipoObjeto = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaTipoObjetoNome);
            pstm.setString(1, nome_tipoObjeto);
            rs = pstm.executeQuery();
            TipoObjeto dest;
            while (rs.next()) {
                dest = new TipoObjeto();
                dest.setCodigo_tipo_objeto(rs.getInt("CODIGO_TIPO_OBJETO"));
                dest.setNome_tipo_objeto(rs.getString("NOME_TIPO_OBJETO"));
                tipoObjeto.add(dest);

            }
            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipoObjeto;
    }

    public List<TipoObjeto> listarTipoObjetoCodigo(String codigo_tipoObjeto) {
        List<TipoObjeto> tipoObjeto = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaTipoObjetoCodigo);
            pstm.setString(1, codigo_tipoObjeto);
            rs = pstm.executeQuery();
            TipoObjeto dest;
            while (rs.next()) {
                dest = new TipoObjeto();
                dest.setCodigo_tipo_objeto(rs.getInt("CODIGO_GENERO"));
                dest.setNome_tipo_objeto(rs.getString("NOME_GENERO"));
                tipoObjeto.add(dest);

            }
            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipoObjeto;
    }

    public List<TipoObjeto> listarTipoObjetoDescricao(String nome_tipoObjeto) {
        List<TipoObjeto> tipoObjetos = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaTipoObjetoDescricao);
            pstm.setString(1, nome_tipoObjeto);
            rs = pstm.executeQuery();
            TipoObjeto tipoObjeto;
            while (rs.next()) {
                tipoObjeto = new TipoObjeto();
                tipoObjeto.setCodigo_tipo_objeto(rs.getInt("CODIGO_GENERO"));
                tipoObjeto.setNome_tipo_objeto(rs.getString("NOME_GENERO"));
                tipoObjetos.add(tipoObjeto);

            }
            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipoObjetos;
    }

    public List<TipoObjeto> listarTipoObjetos() {
        List<TipoObjeto> tipoObjetos = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
            rs = pstm.executeQuery();
            TipoObjeto tipoObjeto;
            while (rs.next()) {
                tipoObjeto = new TipoObjeto();
                tipoObjeto.setCodigo_tipo_objeto(rs.getInt("CODIGO_GENERO"));
                tipoObjeto.setNome_tipo_objeto(rs.getString("NOME_GENERO"));
                tipoObjetos.add(tipoObjeto);
            }
            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipoObjetos;
    }
}
