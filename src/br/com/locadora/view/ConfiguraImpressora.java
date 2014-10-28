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
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ALENCAR
 */
public class ConfiguraImpressora extends javax.swing.JFrame {

    public String tipoCadastro;
    public TelaPrincipal janelapai;    
    private TelaPrincipal_Interface telaPrincipal;
    public InterfacePool pool;
    public SiscomController controller;

    /**
     * Creates new form DiariaGUI
     */
    public ConfiguraImpressora() {
        initComponents();
//        listarDiaria();
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
        jButton1 = new javax.swing.JButton();
        jcb_impressoras = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Impressoras");
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

        jButton1.setText("Aplicar");
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, -1));

        jcb_impressoras.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        jcb_impressoras.setName("jcb_impressoras"); // NOI18N
        jcb_impressoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_impressorasActionPerformed(evt);
            }
        });
        jcb_impressoras.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcb_impressorasFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jcb_impressorasFocusLost(evt);
            }
        });
        getContentPane().add(jcb_impressoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 210, -1));

        jLabel1.setText("Selecione impressora:");
        jLabel1.setName("jLabel1"); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        setSize(new java.awt.Dimension(293, 191));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
   
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        setVisible(false);
        janelapai.setStatusTela(true);
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        mostraImpressoras();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        conf.writePropertie("impressora_principal",jcb_impressoras.getSelectedItem().toString());        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jcb_impressorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_impressorasActionPerformed

    }//GEN-LAST:event_jcb_impressorasActionPerformed

    private void jcb_impressorasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcb_impressorasFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_impressorasFocusGained

    private void jcb_impressorasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcb_impressorasFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_impressorasFocusLost
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox jcb_impressoras;
    // End of variables declaration//GEN-END:variables

    public void setTelaPrincipal(TelaPrincipal_Interface telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
    }
    public void mostraImpressoras() {

        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        String impressora_principal = conf.readPropertie("impressora_principal");
        
        List<String> impressoras = Printer.retornaImpressoras();
                
        if (impressoras.size() == 0) {
            JOptionPane.showMessageDialog(this, "Nenhuma impressora encontrada");

        } else {
            for (int i = 0; i < impressoras.size(); i++) {
                jcb_impressoras.addItem(impressoras.get(i));

                AutoCompletion auto = new AutoCompletion(jcb_impressoras);
            }
            for (Integer x = 0; x < jcb_impressoras.getItemCount(); x++) {
//                System.out.println("Tamanho combobox: "+jcb_impressoras.getItemCount());
//                System.out.println("Impressora principal: "+impressora_principal);
//                System.out.println("Impressora ComboBox: "+jcb_impressoras.getItemAt(x));
//                System.out.println("Posição: " + x);
//                System.out.println("Impressora conf: "+impressora_principal+"Impressora Combo: "+jcb_impressoras.getItemAt(x)+" Posição combo: "+x);
                    if(impressora_principal.equals(jcb_impressoras.getItemAt(x))){
//                        System.out.println("Impressora comboBox: "+impressora_principal.equals(jcb_impressoras.getItemAt(x)));
//                        System.out.println("Impressora conf: "+impressora_principal+"Impressora Combo: "+jcb_impressoras.getItemAt(x)+" Posição combo: "+x);
                        jcb_impressoras.setSelectedIndex(x);
                        break;
                    }        
                
            }
        }
    }

}
