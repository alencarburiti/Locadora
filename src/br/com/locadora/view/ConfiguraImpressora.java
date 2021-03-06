/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MenuDiaria.java
 *
 * Created on 02/06/2011, 00:56:52
 */
package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.controller.SiscomController;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.AutoCompletion;
import br.com.locadora.util.Printer;
import br.com.locadora.util.TemaInterface;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ALENCAR
 */
public class ConfiguraImpressora extends javax.swing.JFrame {

    public String tipoCadastro;
    public TelaPrincipal janelapai;
    public EntradaCaixaLocacao janelapaiCaixaLocacao;
    public EntradaCaixaDevolucao janelapaiCaixaDevolucao;
    public InterfacePool pool;
    public SiscomController controller;

    /**
     * Creates new form DiariaGUI
     */
    public ConfiguraImpressora() {
        initComponents();
        TemaInterface.getInterface(this);
        janelapai = null;
        janelapaiCaixaLocacao = null;
        janelapaiCaixaDevolucao = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jcb_impressora_principal = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcb_impressora_alternativa = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jb_aplicar = new javax.swing.JButton();
        jb_sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configurar Impressora");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Impressoras"));
        jPanel1.setName("jPanel1"); // NOI18N

        jcb_impressora_principal.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_impressora_principal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        jcb_impressora_principal.setName("jcb_impressora_principal"); // NOI18N
        jcb_impressora_principal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_impressora_principalActionPerformed(evt);
            }
        });
        jcb_impressora_principal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcb_impressora_principalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jcb_impressora_principalFocusLost(evt);
            }
        });
        jcb_impressora_principal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcb_impressora_principalKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel1.setText("Selecione impressora principal:");
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel2.setText("Selecione impressora alternativa:");
        jLabel2.setName("jLabel2"); // NOI18N

        jcb_impressora_alternativa.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_impressora_alternativa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        jcb_impressora_alternativa.setName("jcb_impressora_alternativa"); // NOI18N
        jcb_impressora_alternativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_impressora_alternativaActionPerformed(evt);
            }
        });
        jcb_impressora_alternativa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcb_impressora_alternativaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jcb_impressora_alternativaFocusLost(evt);
            }
        });
        jcb_impressora_alternativa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcb_impressora_alternativaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcb_impressora_principal, 0, 255, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jcb_impressora_alternativa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(jcb_impressora_principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(jcb_impressora_alternativa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel2.setName("jPanel2"); // NOI18N

        jb_aplicar.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_aplicar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/save.png"))); // NOI18N
        jb_aplicar.setText("Salvar");
        jb_aplicar.setName("jb_aplicar"); // NOI18N
        jb_aplicar.setPreferredSize(new java.awt.Dimension(100, 40));
        jb_aplicar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_aplicarMouseClicked(evt);
            }
        });
        jb_aplicar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_aplicarKeyPressed(evt);
            }
        });

        jb_sair.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/sair.png"))); // NOI18N
        jb_sair.setText("Sair");
        jb_sair.setName("jb_sair"); // NOI18N
        jb_sair.setPreferredSize(new java.awt.Dimension(100, 40));
        jb_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_sairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jb_aplicar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jb_sair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jb_sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_aplicar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        retornaJanelaPai();
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        mostraImpressoras();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jcb_impressora_principalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_impressora_principalActionPerformed

    }//GEN-LAST:event_jcb_impressora_principalActionPerformed

    private void jcb_impressora_principalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcb_impressora_principalFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_impressora_principalFocusGained

    private void jcb_impressora_principalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcb_impressora_principalFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_impressora_principalFocusLost

    private void jcb_impressora_alternativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_impressora_alternativaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_impressora_alternativaActionPerformed

    private void jcb_impressora_alternativaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcb_impressora_alternativaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_impressora_alternativaFocusGained

    private void jcb_impressora_alternativaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcb_impressora_alternativaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_impressora_alternativaFocusLost

    private void jb_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_sairActionPerformed
        retornaJanelaPai();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_sairActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void jb_aplicarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_aplicarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            configurarImpressora();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_aplicarKeyPressed

    private void jb_aplicarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_aplicarMouseClicked
        if(evt.getClickCount() == 1){
            configurarImpressora();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_aplicarMouseClicked

    private void jcb_impressora_principalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcb_impressora_principalKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_impressora_principalKeyPressed

    private void jcb_impressora_alternativaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcb_impressora_alternativaKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_impressora_alternativaKeyPressed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ConfiguraImpressora().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jb_aplicar;
    private javax.swing.JButton jb_sair;
    private javax.swing.JComboBox jcb_impressora_alternativa;
    private javax.swing.JComboBox jcb_impressora_principal;
    // End of variables declaration//GEN-END:variables

    public void mostraImpressoras() {

        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        String impressora_principal = conf.readPropertie("impressora_principal");
        String impressora_alternativa = conf.readPropertie("impressora_alternativa");
        List<String> impressoras = Printer.retornaImpressoras();

        if (impressoras.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhuma impressora encontrada");

        } else {
            for (int i = 0; i < impressoras.size(); i++) {
                jcb_impressora_principal.addItem(impressoras.get(i));
                AutoCompletion auto = new AutoCompletion(jcb_impressora_principal);
            }

            for (int i = 0; i < impressoras.size(); i++) {
                jcb_impressora_alternativa.addItem(impressoras.get(i));
                AutoCompletion auto = new AutoCompletion(jcb_impressora_alternativa);
            }

            for (Integer x = 0; x < jcb_impressora_principal.getItemCount(); x++) {
                if (impressora_principal.equals(jcb_impressora_principal.getItemAt(x))) {
                    jcb_impressora_principal.setSelectedIndex(x);
                    break;
                }

            }
            for (Integer x = 0; x < jcb_impressora_alternativa.getItemCount(); x++) {
                if (impressora_alternativa.equals(jcb_impressora_alternativa.getItemAt(x))) {
                    jcb_impressora_alternativa.setSelectedIndex(x);
                    break;
                }

            }
        }
    }

    public void acionarAtalho(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F10) {
            configurarImpressora();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            retornaJanelaPai();
        }
    }

    private void retornaJanelaPai() {
        setVisible(false);
        if(janelapai != null){
            janelapai.setStatusTela(true);
        } else if(janelapaiCaixaDevolucao != null){
            janelapaiCaixaDevolucao.setStatusTela(true);
        } else if (janelapaiCaixaLocacao != null){
            janelapaiCaixaLocacao.setStatusTela(true);
        }
    }
    
    public void configurarImpressora(){
        try {
            ArquivoConfiguracao conf = new ArquivoConfiguracao();
            conf.writePropertie("impressora_principal", jcb_impressora_principal.getSelectedItem().toString());
            conf.writePropertie("impressora_alternativa", jcb_impressora_alternativa.getSelectedItem().toString());
            JOptionPane.showMessageDialog(null, "Configurado com sucesso");            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível configurar impressora");
        }
    }
}
