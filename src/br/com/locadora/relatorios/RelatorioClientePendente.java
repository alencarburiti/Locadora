/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.relatorios;

import br.com.locadora.conexao.InterfacePool;
import java.awt.HeadlessException;
import java.io.File;
import java.io.InputStream;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ALENCAR
 */
public class RelatorioClientePendente {

    private InterfacePool pool;

    public RelatorioClientePendente(InterfacePool pool) {
        this.pool = pool;
    }

    public void gerarRelatorio() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = pool.getConnection();

        try {
            String sqlSelect = "SELECT \n" +
            "    *\n" +
            "FROM\n" +
            "    (SELECT \n" +
            "        *,\n" +
            "            (CASE\n" +
            "                WHEN (DEBITO - CREDITO) < 0 THEN 0\n" +
            "                ELSE (DEBITO - CREDITO)\n" +
            "            END) AS DEVEDOR\n" +
            "    FROM\n" +
            "        (SELECT \n" +
            "        A.CLIENTE_CODIGO_CLIENTE,\n" +
            "            C.NOME_DEPENDENTE,\n" +
            "            (SELECT \n" +
            "                    SUM(VALOR)\n" +
            "                FROM\n" +
            "                    LANCAMENTO LC_A, TIPO_SERVICO B\n" +
            "                WHERE\n" +
            "                    LC_A.TIPO_SERVICO_CODIGO_TIPO_SERVICO = B.CODIGO_TIPO_SERVICO\n" +
            "                        AND B.TIPO = 'C'\n" +
            "                        AND LC_A.CLIENTE_CODIGO_CLIENTE = A.CLIENTE_CODIGO_CLIENTE) AS CREDITO,\n" +
            "            (SELECT \n" +
            "                    SUM(VALOR)\n" +
            "                FROM\n" +
            "                    LANCAMENTO LD_A, TIPO_SERVICO B\n" +
            "                WHERE\n" +
            "                    LD_A.TIPO_SERVICO_CODIGO_TIPO_SERVICO = B.CODIGO_TIPO_SERVICO\n" +
            "                        AND B.TIPO = 'D'\n" +
            "                        AND LD_A.CLIENTE_CODIGO_CLIENTE = A.CLIENTE_CODIGO_CLIENTE) AS DEBITO,\n" +
            "            (SELECT \n" +
            "                    MAX(DATA_LANCAMENTO)\n" +
            "                FROM\n" +
            "                    LANCAMENTO L_DATA, TIPO_SERVICO B\n" +
            "                WHERE\n" +
            "                    L_DATA.TIPO_SERVICO_CODIGO_TIPO_SERVICO = B.CODIGO_TIPO_SERVICO\n" +
            "                        AND B.TIPO = 'C'\n" +
            "                        AND L_DATA.CLIENTE_CODIGO_CLIENTE = A.CLIENTE_CODIGO_CLIENTE) AS DATA_LANCAMENTO\n" +
            "    FROM\n" +
            "        LANCAMENTO A, TIPO_SERVICO B, DEPENDENTE C\n" +
            "    WHERE\n" +
            "        A.TIPO_SERVICO_CODIGO_TIPO_SERVICO = B.CODIGO_TIPO_SERVICO\n" +
            "            AND A.CLIENTE_CODIGO_CLIENTE = C.CLIENTE_CODIGO_CLIENTE\n" +
            "            AND C.TIPO_DEPENDENTE = '0'\n" +
            "    GROUP BY 1) AS LANC) AS L_DEVE \n" +
            "WHERE\n" +
            "    DEVEDOR > 0 ORDER BY DATA_LANCAMENTO DESC;";

            ps = con.prepareStatement(sqlSelect);

            rs = ps.executeQuery();
            rs.afterLast();//mover apos a ultima linha  
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            System.out.println("Total de Registro:"+totalRegistro);
            if (totalRegistro > 0) {
                InputStream caminho = getClass().getResourceAsStream("rel_cliente_pendente.jasper");                                
                
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(caminho, parametros, jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            } else {
                JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
            }
        } catch (SQLException | JRException | HeadlessException erro) {
            erro.printStackTrace();
        }
    }
    
    public void gerarRelatorioExcel(String dataInicial, String dataFinal, String titulo, File arquivo) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = pool.getConnection();

        try {
            String sqlSelect = "SELECT\n"
                    + "    CODIGO_OBJETO,\n"
                    + "    TITULO,\n"
                    + "    COUNT(CODIGO_ITEM_LOCACAO) AS QTD_LOCACAO,\n"
                    + "    SUM(VALOR_LOCADO) AS VALOR_LOCACAO,\n"
                    + "    SUM(DIAS_RELOCACAO) AS QTD_RELOCACAO,\n"
                    + "    SUM(VALOR_RELOCACAO) AS VALOR_RELOCACAO\n"
                    + "FROM\n"
                    + "    OBJETO A,\n"
                    + "    COPIA B,\n"
                    + "    ITEM_LOCACAO C\n"
                    + "WHERE\n"
                    + "    A.CODIGO_OBJETO = B.OBJETO_CODIGO_OBJETO\n"
                    + "        AND B.CODIGO_COPIA = C.COPIA_CODIGO_COPIA\n"
                    + "        AND DATA_LOCACAO BETWEEN ? AND ? AND TITULO LIKE ?\n"
                    + "GROUP BY 1,2;";

            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, dataInicial);
            ps.setString(2, dataFinal);
            ps.setString(3, "%" + titulo + "%");

            rs = ps.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            System.out.println("Total de Registro:"+totalRegistro);
            if (totalRegistro > 0) {
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport("jasper/rel_cliente_pendente.jasper", parametros, jrRS);
                
                JRXlsExporter exporter = new JRXlsExporter();
                exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(arquivo));
                
                SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
                configuration.setDetectCellType(true);
                configuration.setCollapseRowSpan(false);
                configuration.setMaxRowsPerSheet(20000);
                configuration.setOnePagePerSheet(false);
                configuration.setRemoveEmptySpaceBetweenRows(Boolean.TRUE);
                configuration.setRemoveEmptySpaceBetweenColumns(Boolean.TRUE);
                
                exporter.setConfiguration(configuration);
                
                exporter.exportReport();
                
                System.out.println("Relatorio gerado");
            } else {
                JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
            }
        } catch (SQLException | JRException | HeadlessException erro) {
            erro.printStackTrace();
        }
    }
    
}


