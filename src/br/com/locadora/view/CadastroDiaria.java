/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CadastroDiaria.java
 *
 * Created on 23/05/2011, 20:12:16
 */
package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.controller.SiscomController;
import br.com.locadora.model.bean.Diaria;
import br.com.locadora.util.LimitadorTexto;
import br.com.locadora.util.UnaccentedDocument;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ALENCAR
 */
public class CadastroDiaria extends javax.swing.JFrame {

    public MenuDiaria janelapai;
    public List<Diaria> generos;

    /**
     * Creates new form DestinoCadastroGUI
     */
    public CadastroDiaria() {
        initComponents();
        janelapai = null;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox2 = new javax.swing.JCheckBox();
        jb_salvar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        jtf_nome_diaria = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtf_codigo_diaria = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtf_valor = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jLabel5 = new javax.swing.JLabel();
        jtf_valor_promocao = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jLabel6 = new javax.swing.JLabel();
        jtf_dias = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jLabel7 = new javax.swing.JLabel();
        jtf_multa = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jPanel1 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();

        jCheckBox2.setText("jCheckBox2");
        jCheckBox2.setName("jCheckBox2"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cadastrando Diárias");
        setBackground(new java.awt.Color(255, 102, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jb_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/gravar_registro.gif"))); // NOI18N
        jb_salvar.setText("Salvar");
        jb_salvar.setName("jb_salvar"); // NOI18N
        jb_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_salvarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_salvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, 35));

        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/exit.png"))); // NOI18N
        jb_cancelar.setText("Cancelar");
        jb_cancelar.setName("jb_cancelar"); // NOI18N
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, 35));

        jtf_nome_diaria.setText("Catálogo");
        jtf_nome_diaria.setName("jtf_nome_diaria"); // NOI18N
        getContentPane().add(jtf_nome_diaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 280, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Nome");
        jLabel3.setName("jLabel3"); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Código Diária");
        jLabel2.setName("jLabel2"); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jtf_codigo_diaria.setEditable(false);
        jtf_codigo_diaria.setName("jtf_codigo_diaria"); // NOI18N
        getContentPane().add(jtf_codigo_diaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 90, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("Valor");
        jLabel4.setName("jLabel4"); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jtf_nome_diaria.setDocument(new UnaccentedDocument());
        jtf_valor.setText("R$ 3,00");
        jtf_valor.setName("jtf_valor"); // NOI18N
        jtf_valor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_valorFocusGained(evt);
            }
        });
        jtf_valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_valorKeyPressed(evt);
            }
        });
        getContentPane().add(jtf_valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 90, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText("Valor Promoção");
        jLabel5.setName("jLabel5"); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, -1));

        jtf_nome_diaria.setDocument(new UnaccentedDocument());
        jtf_valor_promocao.setText("R$ 2,50");
        jtf_valor_promocao.setName("jtf_valor_promocao"); // NOI18N
        jtf_valor_promocao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_valor_promocaoFocusGained(evt);
            }
        });
        jtf_valor_promocao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_valor_promocaoKeyPressed(evt);
            }
        });
        getContentPane().add(jtf_valor_promocao, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 90, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setText("Dias");
        jLabel6.setName("jLabel6"); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, -1, -1));

        jtf_nome_diaria.setDocument(new UnaccentedDocument());
        jtf_dias.setText("1");
        jtf_dias.setName("jtf_dias"); // NOI18N
        jtf_dias.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_diasFocusGained(evt);
            }
        });
        jtf_dias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_diasKeyPressed(evt);
            }
        });
        getContentPane().add(jtf_dias, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 90, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel7.setText("Multas");
        jLabel7.setName("jLabel7"); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, -1, -1));

        jtf_nome_diaria.setDocument(new UnaccentedDocument());
        jtf_multa.setText("R$ 0,50");
        jtf_multa.setName("jtf_multa"); // NOI18N
        jtf_multa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_multaFocusGained(evt);
            }
        });
        jtf_multa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_multaKeyPressed(evt);
            }
        });
        getContentPane().add(jtf_multa, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 90, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dias de Promoção"));
        jPanel1.setName("jPanel1"); // NOI18N

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Domingo");
        jCheckBox1.setName("jCheckBox1"); // NOI18N
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1);

        jCheckBox3.setSelected(true);
        jCheckBox3.setText("Segunda");
        jCheckBox3.setName("jCheckBox3"); // NOI18N
        jPanel1.add(jCheckBox3);

        jCheckBox4.setSelected(true);
        jCheckBox4.setText("Terça");
        jCheckBox4.setName("jCheckBox4"); // NOI18N
        jPanel1.add(jCheckBox4);

        jCheckBox5.setSelected(true);
        jCheckBox5.setText("Quarta");
        jCheckBox5.setName("jCheckBox5"); // NOI18N
        jPanel1.add(jCheckBox5);

        jCheckBox6.setSelected(true);
        jCheckBox6.setText("Quinta");
        jCheckBox6.setName("jCheckBox6"); // NOI18N
        jPanel1.add(jCheckBox6);

        jCheckBox7.setSelected(true);
        jCheckBox7.setText("Sexta");
        jCheckBox7.setName("jCheckBox7"); // NOI18N
        jPanel1.add(jCheckBox7);

        jCheckBox8.setSelected(true);
        jCheckBox8.setText("Sábado");
        jCheckBox8.setName("jCheckBox8"); // NOI18N
        jPanel1.add(jCheckBox8);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 380, 90));

        setSize(new java.awt.Dimension(429, 334));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jb_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salvarActionPerformed
        enviaDados();
    }//GEN-LAST:event_jb_salvarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtf_nome_diaria.requestFocus();
        this.setEnabled(true);
    }//GEN-LAST:event_formWindowOpened

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        retornaJanelaPai();
    }//GEN-LAST:event_jb_cancelarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        retornaJanelaPai();
    }//GEN-LAST:event_formWindowClosed

    private void jtf_valorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valorFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valorFocusGained

    private void jtf_valorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valorKeyPressed

    private void jtf_valor_promocaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_promocaoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_promocaoFocusGained

    private void jtf_valor_promocaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valor_promocaoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_promocaoKeyPressed

    private void jtf_diasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_diasFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_diasFocusGained

    private void jtf_diasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_diasKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_diasKeyPressed

    private void jtf_multaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_multaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_multaFocusGained

    private void jtf_multaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_multaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_multaKeyPressed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CadastroDiaria().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    public static javax.swing.JCheckBox jCheckBox3;
    public static javax.swing.JCheckBox jCheckBox4;
    public static javax.swing.JCheckBox jCheckBox5;
    public static javax.swing.JCheckBox jCheckBox6;
    public static javax.swing.JCheckBox jCheckBox7;
    public static javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_salvar;
    public static javax.swing.JTextField jtf_codigo_diaria;
    public static javax.swing.JTextField jtf_dias;
    public static javax.swing.JTextField jtf_multa;
    public static javax.swing.JTextField jtf_nome_diaria;
    public static javax.swing.JTextField jtf_valor;
    public static javax.swing.JTextField jtf_valor_promocao;
    // End of variables declaration//GEN-END:variables

    private void retornaJanelaPai() {
        setVisible(false);

        if (janelapai != null) {
            janelapai.setEnabled(true);
            janelapai.setVisible(true);
            janelapai.request();
        }

    }

    InterfacePool pool;
    SiscomController controller;

    private void enviaDados() {
        if (verificarCampos()) {
            controller = new SiscomController();
            controller.processarRequisicao("cadastrarDiaria");
            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
            retornaJanelaPai();
        }
    }

    public boolean verificarCampos() {
        String msgERRO = "Preencha os campos obrigatórios:\n";
        if (jtf_nome_diaria.getText().length() > 45) {
            JOptionPane.showMessageDialog(null, "Campo descrição ultrapassou o tamanho permitido");
            jtf_nome_diaria.requestFocus();
            return false;
        }
        if (jtf_nome_diaria.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Descrição\n";
        }
        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            jtf_nome_diaria.requestFocus();
            return false;
        } else {
            return true;
        }
    }

}
