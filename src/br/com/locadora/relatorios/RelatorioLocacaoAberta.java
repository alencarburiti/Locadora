/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.locadora.relatorios;

import br.com.locadora.conexao.Pool;
import br.com.locadora.util.Conexao;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ALENCAR
 */
public class RelatorioLocacaoAberta {
    Pool pool;
    public void gerarRelatorio() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = pool.getConnection();
        try{
            String sqlSelect = "SELECT idproduto, descproduto, concentracao, quantidade FROM produto WHERE (quantidade <>0)";
            Conexao conexao = new Conexao();
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport("./jasper/Produto.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){
            erro.printStackTrace();
        }
        }
    }

