/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DestinoCadastroGUI.java
 *
 * Created on 23/05/2011, 20:12:16
 */
package br.com.locadora.view;

import br.com.locadora.controller.SiscomController;
import br.com.locadora.model.bean.Genero;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import br.com.locadora.util.LimitadorTexto;
import br.com.locadora.util.UnaccentedDocument;
import java.awt.event.KeyAdapter;
import javax.swing.InputVerifier;
import javax.swing.JComponent;

/**
 *
 * @author ALENCAR
 */
public class AtualizaGenero extends javax.swing.JFrame {

    private Genero objdestino;
    public MenuGenero janelapai;
    public SiscomController controller;

    /**
     * Creates new form DestinoCadastroGUI
     */
    public AtualizaGenero() {
        initComponents();

    }

    public AtualizaGenero(Genero genero) {
        this.objdestino = genero;
        initComponents();

        jtf_codigo.setText(String.valueOf(objdestino.getCodigo_genero()));
        jtf_nome_genero.setText(objdestino.getNome_genero());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jb_salvar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        jtf_codigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtf_nome_genero = new javax.swing.JTextField (new LimitadorTexto(45), "",10);
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterando Gênero");
        setBackground(new java.awt.Color(255, 255, 255));
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
        jb_salvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_salvarKeyPressed(evt);
            }
        });
        getContentPane().add(jb_salvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, 35));

        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/exit.png"))); // NOI18N
        jb_cancelar.setText("Cancelar");
        jb_cancelar.setName("jb_cancelar"); // NOI18N
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });
        jb_cancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_cancelarKeyPressed(evt);
            }
        });
        getContentPane().add(jb_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, 35));

        jtf_codigo.setEditable(false);
        jtf_codigo.setName("jtf_codigo"); // NOI18N
        getContentPane().add(jtf_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 90, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Código");
        jLabel2.setName("jLabel2"); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jtf_nome_genero.setName("jtf_nome_genero"); // NOI18N
        jtf_nome_genero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_nome_generoFocusGained(evt);
            }
        });
        jtf_nome_genero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_nome_generoKeyPressed(evt);
            }
        });
        getContentPane().add(jtf_nome_genero, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 370, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Nome Gênero*");
        jLabel3.setName("jLabel3"); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        setSize(new java.awt.Dimension(413, 171));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jb_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salvarActionPerformed
        enviaDados();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_salvarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtf_nome_genero.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        janelapai.setStatusTela(true);
        setVisible(false);
    }//GEN-LAST:event_jb_cancelarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        janelapai.setStatusTela(true);
        setVisible(false);
    }//GEN-LAST:event_formWindowClosed

    private void jtf_nome_generoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nome_generoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_salvar.requestFocus();
        }
        acionarAtalho(evt);
    }//GEN-LAST:event_jtf_nome_generoKeyPressed

    private void jtf_nome_generoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_nome_generoFocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nome_generoFocusGained

    private void jb_salvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_salvarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            enviaDados();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_salvarKeyPressed

    private void jb_cancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_cancelarKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            janelapai.setStatusTela(true);
            setVisible(false);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_cancelarKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AtualizaGenero().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_salvar;
    public static javax.swing.JTextField jtf_codigo;
    public static javax.swing.JTextField jtf_nome_genero;
    // End of variables declaration//GEN-END:variables

    public void alimentaCampos(List<MenuGenero> destinos) {
    }

    private void enviaDados() {
        if (verificarCampos()) {
            controller = new SiscomController();
            controller.processarRequisicao("atualizarGenero");
            JOptionPane.showMessageDialog(null, "Atualização efetuada com sucesso");
            janelapai.buscarDados();                        
            janelapai.jtf_consulta.requestFocus();
            janelapai.setStatusTela(true);
            setVisible(false);
        }
    }

    public boolean verificarCampos() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_nome_genero.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Descrição\n";
        }
        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            return false;
        } else {
            return true;
        }

    }

    public void acionarAtalho(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F10) {
            enviaDados();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            setVisible(false);
            janelapai.setStatusTela(true);
        }
    }
}
