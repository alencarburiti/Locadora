package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.controller.SiscomController;
import br.com.locadora.util.LimitadorTexto;
import br.com.locadora.util.UnaccentedDocument;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALENCAR
 */
public final class EntradaCaixa extends javax.swing.JFrame {

    public Atendimento janelapaiLocacao;
    public Atendimento janelapaiDevolucao;
    public InterfacePool pool;
    public SiscomController controller;

    /**
     * Creates new form ProdutoCadastroGUI
     */
    public EntradaCaixa() {
        initComponents();
        janelapaiLocacao = null;
        janelapaiDevolucao = null;
    }

    //public ProdutoConsultarGUI janelapaim;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tfa_similar = new javax.swing.JTextArea();
        jb_cancelar = new javax.swing.JButton();
        jb_salvar = new javax.swing.JButton();
        jtf_total_locacao = new javax.swing.JTextField(new LimitadorTexto(80), "",10);
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtf_valor_desconto = new javax.swing.JTextField(new LimitadorTexto(80), "",10);
        jLabel6 = new javax.swing.JLabel();
        jtf_valor_pago = new javax.swing.JTextField(new LimitadorTexto(80), "",10);
        jLabel7 = new javax.swing.JLabel();
        jtf_troco = new javax.swing.JTextField(new LimitadorTexto(80), "",10);
        jLabel8 = new javax.swing.JLabel();
        jtf_debito_atual = new javax.swing.JTextField(new LimitadorTexto(80), "",10);
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tfa_similar.setColumns(20);
        tfa_similar.setRows(5);
        tfa_similar.setName("tfa_similar"); // NOI18N
        jScrollPane1.setViewportView(tfa_similar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Caixa");
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
        jb_cancelar.setMaximumSize(new java.awt.Dimension(101, 33));
        jb_cancelar.setName("jb_cancelar"); // NOI18N
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, -1, 35));

        jb_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/ok.png"))); // NOI18N
        jb_salvar.setText("Confirmar");
        jb_salvar.setName("jb_salvar"); // NOI18N
        jb_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_salvarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_salvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, -1, 35));

        jtf_total_locacao.setDocument(new UnaccentedDocument());
        jtf_total_locacao.setEditable(false);
        jtf_total_locacao.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jtf_total_locacao.setForeground(new java.awt.Color(204, 0, 0));
        jtf_total_locacao.setText("R$ 0,00");
        jtf_total_locacao.setName("jtf_total_locacao");
        jtf_total_locacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_total_locacaoActionPerformed(evt);
            }
        });
        jtf_total_locacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_total_locacaoFocusGained(evt);
            }
        });
        jtf_total_locacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_total_locacaoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_total_locacaoKeyReleased(evt);
            }
        });
        getContentPane().add(jtf_total_locacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 170, -1));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Total Locação:");
        jLabel1.setName("jLabel1"); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel5.setText("Valor Desconto:");
        jLabel5.setName("jLabel5"); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jtf_total_locacao.setDocument(new UnaccentedDocument());
        jtf_valor_desconto.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jtf_valor_desconto.setText("R$ 0,00");
        jtf_valor_desconto.setName("jtf_valor_desconto"); // NOI18N
        jtf_valor_desconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_valor_descontoActionPerformed(evt);
            }
        });
        jtf_valor_desconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_valor_descontoFocusGained(evt);
            }
        });
        jtf_valor_desconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_valor_descontoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_valor_descontoKeyReleased(evt);
            }
        });
        getContentPane().add(jtf_valor_desconto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 170, -1));

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel6.setText("Valor Pago:");
        jLabel6.setName("jLabel6"); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jtf_total_locacao.setDocument(new UnaccentedDocument());
        jtf_valor_pago.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jtf_valor_pago.setText("R$ 0,00");
        jtf_valor_pago.setName("jtf_valor_pago"); // NOI18N
        jtf_valor_pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_valor_pagoActionPerformed(evt);
            }
        });
        jtf_valor_pago.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_valor_pagoFocusGained(evt);
            }
        });
        jtf_valor_pago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_valor_pagoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_valor_pagoKeyReleased(evt);
            }
        });
        getContentPane().add(jtf_valor_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 170, -1));

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel7.setText("Troco");
        jLabel7.setName("jLabel7"); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jtf_total_locacao.setDocument(new UnaccentedDocument());
        jtf_troco.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jtf_troco.setText("R$ 0,00");
        jtf_troco.setName("jtf_troco"); // NOI18N
        jtf_troco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_trocoActionPerformed(evt);
            }
        });
        jtf_troco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_trocoFocusGained(evt);
            }
        });
        jtf_troco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_trocoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_trocoKeyReleased(evt);
            }
        });
        getContentPane().add(jtf_troco, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 170, -1));

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel8.setText("Débito Atual");
        jLabel8.setName("jLabel8"); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        jtf_total_locacao.setDocument(new UnaccentedDocument());
        jtf_debito_atual.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jtf_debito_atual.setForeground(new java.awt.Color(204, 0, 0));
        jtf_debito_atual.setText("R$ 0,00");
        jtf_debito_atual.setName("jtf_debito_atual"); // NOI18N
        jtf_debito_atual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_debito_atualActionPerformed(evt);
            }
        });
        jtf_debito_atual.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_debito_atualFocusGained(evt);
            }
        });
        jtf_debito_atual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_debito_atualKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_debito_atualKeyReleased(evt);
            }
        });
        getContentPane().add(jtf_debito_atual, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 170, -1));

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel9.setText("Caixa");
        jLabel9.setName("jLabel9"); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 50));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dinheiro", "Cartão de Crédito", "Cartão de Débito" }));
        jComboBox1.setName("jComboBox1"); // NOI18N
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 220, 40));

        setSize(new java.awt.Dimension(396, 438));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        retornaJanelaPai();

}//GEN-LAST:event_jb_cancelarActionPerformed
    private void retornaJanelaPai() {
        setVisible(false);

        if (janelapaiLocacao != null) {
            janelapaiLocacao.setEnabled(true);
            janelapaiLocacao.setVisible(true);
//            janelapai.request();
        }
       
    }
    private void jb_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salvarActionPerformed
        
        if (janelapaiLocacao != null) {
            controller = new SiscomController();
            controller.processarRequisicao("cadastrarLocacao");
           
            DefaultTableModel tb_locacao = (DefaultTableModel) Atendimento.jtbl_locacao.getModel();
            int rows = tb_locacao.getRowCount();
            for (int i = rows - 1; i >= 0; i--) {
                tb_locacao.removeRow(i);
            }
        } else if (janelapaiDevolucao != null) {
            controller = new SiscomController();
            controller.processarRequisicao("cadastrarDevolucao");
            
            DefaultTableModel tb_devolucao = (DefaultTableModel) Atendimento.jtbl_devolucao.getModel();
            int rows = tb_devolucao.getRowCount();
            for (int i = rows - 1; i >= 0; i--) {
                tb_devolucao.removeRow(i);
            }
        }
}//GEN-LAST:event_jb_salvarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if (janelapaiLocacao != null) {
            jtf_debito_atual.setText(Atendimento.jtf_credito_total_locacao.getText());
            jtf_total_locacao.setText(Atendimento.jtf_valor_total_locacao.getText());            
        } else if (janelapaiDevolucao != null) {
            jtf_debito_atual.setText(Atendimento.jtf_credito_total_devolucao.getText());
            jtf_total_locacao.setText(Atendimento.jtf_valor_total_devolucao.getText());            
        }
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        retornaJanelaPai();
    }//GEN-LAST:event_formWindowClosed

    private void jtf_total_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_total_locacaoKeyPressed
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_locacaoKeyPressed
    private void jtf_total_locacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_total_locacaoFocusGained
       
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_locacaoFocusGained

    private void jtf_total_locacaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_total_locacaoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_locacaoKeyReleased

    private void jtf_total_locacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_total_locacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_locacaoActionPerformed

    private void jtf_valor_descontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_valor_descontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_descontoActionPerformed

    private void jtf_valor_descontoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_descontoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_descontoFocusGained

    private void jtf_valor_descontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valor_descontoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_descontoKeyPressed

    private void jtf_valor_descontoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valor_descontoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_descontoKeyReleased

    private void jtf_valor_pagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_valor_pagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_pagoActionPerformed

    private void jtf_valor_pagoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_pagoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_pagoFocusGained

    private void jtf_valor_pagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valor_pagoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_pagoKeyPressed

    private void jtf_valor_pagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valor_pagoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_pagoKeyReleased

    private void jtf_trocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_trocoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_trocoActionPerformed

    private void jtf_trocoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_trocoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_trocoFocusGained

    private void jtf_trocoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_trocoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_trocoKeyPressed

    private void jtf_trocoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_trocoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_trocoKeyReleased

    private void jtf_debito_atualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_debito_atualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_debito_atualActionPerformed

    private void jtf_debito_atualFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_debito_atualFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_debito_atualFocusGained

    private void jtf_debito_atualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_debito_atualKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_debito_atualKeyPressed

    private void jtf_debito_atualKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_debito_atualKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_debito_atualKeyReleased

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new EntradaCaixa().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_salvar;
    public static javax.swing.JTextField jtf_debito_atual;
    public static javax.swing.JTextField jtf_total_locacao;
    public static javax.swing.JTextField jtf_troco;
    public static javax.swing.JTextField jtf_valor_desconto;
    public static javax.swing.JTextField jtf_valor_pago;
    private javax.swing.JTextArea tfa_similar;
    // End of variables declaration//GEN-END:variables



    public void setTela(String permissao) {
        if (permissao.equals("usuario")) {
//            jb_novo.setEnabled(false);
//            jb_alterar1.setEnabled(false);
//            jb_excluir1.setEnabled(false);
        } else {
        }
    }



    public void setStatusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }


}
