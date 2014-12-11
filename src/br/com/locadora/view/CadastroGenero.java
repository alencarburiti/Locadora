/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CadastroGenero.java
 *
 * Created on 23/05/2011, 20:12:16
 */
package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.controller.SiscomController;
import br.com.locadora.model.bean.Genero;
import br.com.locadora.util.LimitadorTexto;
import br.com.locadora.util.UnaccentedDocument;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author ALENCAR
 */
public class CadastroGenero extends javax.swing.JFrame {

    public MenuGenero janelapai;
    public List<Genero> generos;
    public InterfacePool pool;
    public SiscomController controller;

    /**
     * Creates new form DestinoCadastroGUI
     */
    public CadastroGenero() {
        initComponents();
        janelapai = null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jb_salvar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        jtf_nome_genero = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtf_codigo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrando Gêneros");
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
        getContentPane().add(jb_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, 35));

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

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Código");
        jLabel2.setName("jLabel2"); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jtf_codigo.setEditable(false);
        jtf_codigo.setName("jtf_codigo"); // NOI18N
        getContentPane().add(jtf_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 90, -1));

        setSize(new java.awt.Dimension(414, 169));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jb_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salvarActionPerformed
        enviaDados();
    }//GEN-LAST:event_jb_salvarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtf_nome_genero.requestFocus();
        this.setEnabled(true);
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
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CadastroGenero().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_salvar;
    private javax.swing.JTextField jtf_codigo;
    public static javax.swing.JTextField jtf_nome_genero;
    // End of variables declaration//GEN-END:variables

    private void enviaDados() {
        if (verificarCampos()) {
            controller = new SiscomController();
            controller.processarRequisicao("cadastrarGenero");
            janelapai.setStatusTela(true);
            janelapai.buscarDados();
            janelapai.jtf_consulta.requestFocus();
        }
    }

    public boolean verificarCampos() {
        String msgERRO = "Preencha os campos obrigatórios:\n";
        if (jtf_nome_genero.getText().length() > 45) {
            JOptionPane.showMessageDialog(null, "Campo descrição ultrapassou o tamanho permitido");
            jtf_nome_genero.requestFocus();
            return false;
        }
        if (jtf_nome_genero.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Descrição\n";
        }
        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            jtf_nome_genero.requestFocus();
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
