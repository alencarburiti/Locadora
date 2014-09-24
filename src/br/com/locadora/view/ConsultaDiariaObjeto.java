/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConsultarProdutoGUI.java
 *
 * Created on 02/06/2011, 03:08:41
 */
package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.bean.FornecedorModel;
import br.com.locadora.model.dao.DiariaDAO;
import br.com.locadora.model.dao.FornecedorDAO;
import br.com.locadora.util.ItemDbGrid;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALENCAR
 */
public class ConsultaDiariaObjeto extends javax.swing.JFrame {

    CadastroObjeto janelapai;

    public ConsultaDiariaObjeto() {
        initComponents();
        janelapai = null;
    }
    List<Diaria> diarias;

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jb_cancelar = new javax.swing.JButton();
        jb_ok = new javax.swing.JButton();
        jb_novo1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_diaria = new javax.swing.JTable();
        jtf_consulta = new javax.swing.JTextField();
        jb_buscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Consulta Diária");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/exit.png"))); // NOI18N
        jb_cancelar.setText("Cancelar");
        jb_cancelar.setName("jb_cancelar"); // NOI18N
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 110, 40));

        jb_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/ok.png"))); // NOI18N
        jb_ok.setText("OK");
        jb_ok.setName("jb_ok"); // NOI18N
        jb_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_okActionPerformed(evt);
            }
        });
        getContentPane().add(jb_ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 80, 40));

        jb_novo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/novo_registro.gif"))); // NOI18N
        jb_novo1.setText("Novo");
        jb_novo1.setName("jb_novo1"); // NOI18N
        jb_novo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_novo1ActionPerformed(evt);
            }
        });
        getContentPane().add(jb_novo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 110, 40));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta Diária"));
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jtbl_diaria.setUpdateSelectionOnSort(false);
        jtbl_diaria.setVerifyInputWhenFocusTarget(false);
        jtbl_diaria.setDefaultEditor(Object.class, null);
        jtbl_diaria.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount() == 2){
                    botaoOK(jtbl_diaria);

                }}});
                jtbl_diaria.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {

                    },
                    new String [] {
                        "Código", "Descrição", "Dias", "Valor", "Valor Promoção", "Multa"
                    }
                ) {
                    Class[] types = new Class [] {
                        java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                    };
                    boolean[] canEdit = new boolean [] {
                        false, false, false, false, false, false
                    };

                    public Class getColumnClass(int columnIndex) {
                        return types [columnIndex];
                    }

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                    }
                });
                jtbl_diaria.setName("jtbl_diaria"); // NOI18N
                jtbl_diaria.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        jtbl_diariaKeyPressed(evt);
                    }
                });
                jScrollPane1.setViewportView(jtbl_diaria);
                if (jtbl_diaria.getColumnModel().getColumnCount() > 0) {
                    jtbl_diaria.getColumnModel().getColumn(0).setResizable(false);
                    jtbl_diaria.getColumnModel().getColumn(0).setPreferredWidth(15);
                    jtbl_diaria.getColumnModel().getColumn(1).setResizable(false);
                    jtbl_diaria.getColumnModel().getColumn(1).setPreferredWidth(100);
                    jtbl_diaria.getColumnModel().getColumn(2).setResizable(false);
                    jtbl_diaria.getColumnModel().getColumn(2).setPreferredWidth(10);
                    jtbl_diaria.getColumnModel().getColumn(3).setResizable(false);
                    jtbl_diaria.getColumnModel().getColumn(3).setPreferredWidth(35);
                    jtbl_diaria.getColumnModel().getColumn(4).setResizable(false);
                    jtbl_diaria.getColumnModel().getColumn(4).setPreferredWidth(35);
                    jtbl_diaria.getColumnModel().getColumn(5).setResizable(false);
                    jtbl_diaria.getColumnModel().getColumn(5).setPreferredWidth(20);
                }

                jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 600, 200));

                jtf_consulta.setName("jtf_consulta"); // NOI18N
                jPanel1.add(jtf_consulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 450, -1));

                jb_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/ok.png"))); // NOI18N
                jb_buscar.setName("jb_buscar"); // NOI18N
                jb_buscar.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_buscarActionPerformed1(evt);
                    }
                });
                jPanel1.add(jb_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, -1, -1));

                getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 650, 300));

                setSize(new java.awt.Dimension(700, 406));
                setLocationRelativeTo(null);
            }// </editor-fold>//GEN-END:initComponents

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        setVisible(false);
        if ((janelapai != null)) {
            janelapai.setEnabled(true);
            janelapai.setVisible(true);
            //telaCadastroObjeto.setStatusTela(false);
        }

}//GEN-LAST:event_jb_cancelarActionPerformed
    private CadastroObjeto_InterFace telaCadastroObjeto;
    
    private void jb_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_okActionPerformed
        if (jtbl_diaria.getSelectedRow() == 1) {
            botaoOK(jtbl_diaria);
        }
}//GEN-LAST:event_jb_okActionPerformed
    public void botaoOK(JTable tb) {
       if(tb.getSelectedRow() != -1){
        setVisible(false);
        Diaria diaria = tbDiariaLinhaSelecionada(jtbl_diaria);
        if ((janelapai != null) && (diaria != null)) {
            janelapai.setEnabled(true);
            janelapai.setVisible(true);
            telaCadastroObjeto.carregaDiaria(diaria);
            //telaCadastroObjeto.setStatusTela(false);
        }


//        if ((janelapai3 != null) && (diaria != null)) {
//            janelapai3.setEnabled(true);
//            janelapai3.setVisible(true);
//            telaAjusteEstoque.carregaFornecedor(diaria);
//            //telaSaidaEstoque.statusTela(true);        
//        }

    } else {
           JOptionPane.showMessageDialog(null, "Selecione um fornecedor");
       }
    }
           
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        setVisible(false);
        if ((janelapai != null)) {
            janelapai.setEnabled(true);
            janelapai.setVisible(true);
            //telaCadastroObjeto.setStatusTela(false);
        }


        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void jb_novo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_novo1ActionPerformed
        CadastroFornecedor forn;

        forn = new CadastroFornecedor();
        forn.janelapai2 = this;
        forn.setVisible(true);
        this.setEnabled(false);


        // TODO add your handling code here:
}//GEN-LAST:event_jb_novo1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        jt_pesquisar.getColumnModel().getColumn( 3 ).setMaxWidth( 60 );
//        jt_pesquisar.getColumnModel().getColumn( 3 ).setMinWidth( 60 );
//        jt_pesquisar.getTableHeader().getColumnModel().getColumn( 3 ).setMaxWidth( 60 );
//        jt_pesquisar.getTableHeader().getColumnModel().getColumn( 3 ).setMinWidth( 60 );
    }//GEN-LAST:event_formWindowOpened

private void jtbl_diariaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_diariaKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//        if(jTable1.getSelectedRow()== 1){                           
        botaoOK(jtbl_diaria);
        //01  }
    }
    // TODO add your handling code here:
}//GEN-LAST:event_jtbl_diariaKeyPressed

    private void jb_buscarActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_buscarActionPerformed1
        try {        
            listaDiaria(jtf_consulta.getText().trim());
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDiariaObjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jb_buscarActionPerformed1

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ConsultaDiariaObjeto().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_buscar;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_novo1;
    private javax.swing.JButton jb_ok;
    private javax.swing.JTable jtbl_diaria;
    private javax.swing.JTextField jtf_consulta;
    // End of variables declaration//GEN-END:variables

    //Recebendo tela como parametro para atualização apos pesquisa
    public void setTelaCadastroObjeto(CadastroObjeto_InterFace telaCadastroObjeto) {
        this.telaCadastroObjeto = telaCadastroObjeto;
    }



    public void setCadastro() {
        jb_novo1.setEnabled(false);
    }

    public Diaria tbDiariaLinhaSelecionada(JTable tb) {
        Diaria diaria = null;
        if (tb.getSelectedRow() != -1) {
            diaria = new Diaria();
            diaria.setCodigo_diaria(diarias.get(tb.getSelectedRow()).getCodigo_diaria());
            diaria.setNome_diaria(diarias.get(tb.getSelectedRow()).getNome_diaria());
            diaria.setDias(diarias.get(tb.getSelectedRow()).getDias());
            diaria.setValor(diarias.get(tb.getSelectedRow()).getValor());
            diaria.setValor_promocao(diarias.get(tb.getSelectedRow()).getValor_promocao());
            diaria.setMultas(diarias.get(tb.getSelectedRow()).getMultas());
        }
        return diaria;
    }
    private InterfacePool pool;
    public void listaDiaria(String consulta) throws SQLException {
        pool = new Pool();
        DiariaDAO diariaDAO = new DiariaDAO(pool);
        diarias = diariaDAO.getDiarias("%" + jtf_consulta.getText().trim() + "%");
        mostraDiaria(diarias);
    }
    
    public void listaTodasDiarias() throws SQLException {
        pool = new Pool();
        DiariaDAO diariaDAO = new DiariaDAO(pool);
        diarias = diariaDAO.getTodasDiarias();
        mostraDiaria(diarias);
    }

    public void mostraDiaria(List<Diaria> diarias) {
        ((DefaultTableModel) jtbl_diaria.getModel()).setRowCount(0);
        jtbl_diaria.updateUI();

        if (diarias.size() == 0) {
            JOptionPane.showMessageDialog(this, "Nenhuma diaria encontrada");

        } else {
            for (int i = 0; i < diarias.size(); i++) {
                Diaria diaria = new Diaria();
                diaria.setCodigo_diaria(diarias.get(i).getCodigo_diaria());
                diaria.setNome_diaria(diarias.get(i).getNome_diaria());
                diaria.setDias(diarias.get(i).getDias());
                
                String valor = null;
                String valor_promocao = null;
                String multa = null;
                
                valor = String.valueOf(diarias.get(i).getValor());
                valor_promocao = String.valueOf(diarias.get(i).getValor_promocao());
                multa = String.valueOf(diarias.get(i).getMultas());
                
                valor = setPrecoFormat(valor);
                valor_promocao = setPrecoFormat(valor_promocao);
                multa = setPrecoFormat(multa);
                                
                DefaultTableModel row = (DefaultTableModel) jtbl_diaria.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(diaria, diaria.getNome_diaria());
                row.addRow(new Object[]{diaria.getCodigo_diaria(), hashDbGrid, diaria.getDias(), valor, valor_promocao, multa});
            }
            jtbl_diaria.setSelectionMode(1);
        }
    }
    public String setPrecoFormat(String preco) {
        DecimalFormat dFormat = new DecimalFormat();
        dFormat.applyPattern("R$ #0.00");
        return dFormat.format(getPrecoFormato(preco));
    }
    public Double getPrecoFormato(String preco) {
        Double precoFormatado = 0.0;
        try {
            preco = preco.replace("R", "");
            preco = preco.replace("$", "");
            preco = preco.replace(",", ".");
            preco = preco.replace(" ", "");
            precoFormatado = Double.parseDouble(preco.trim());

            //this.objFuncionario.setSalario(getSalarioFormat(jTSalario.getText())); pegar valor em double

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Valor Informado Incorreto!\nInforme um valor com o seguinte formato:\nEx: 100,00");
        }
        return precoFormatado;
    }

}
