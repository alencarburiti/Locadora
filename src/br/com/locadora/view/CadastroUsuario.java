/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CadastroUsuario.java
 *
 * Created on 26/05/2011, 16:09:54
 */
package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.model.dao.UsuarioDAO;
import br.com.locadora.model.bean.Usuario;
import br.com.locadora.util.LimitadorTexto;
import br.com.locadora.util.UnaccentedDocument;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author ALENCAR
 */
public class CadastroUsuario extends javax.swing.JFrame {

    public MenuUsuario janelapai;
    public List<Usuario> usuarios;
    public InterfacePool pool;

    /** Creates new form UsuarioCadastroGUI */
    public CadastroUsuario() {
        initComponents();
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jb_salvar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jpf_senha = new javax.swing.JPasswordField(new LimitadorTexto(45), "",10);
        jLabel1 = new javax.swing.JLabel();
        jtf_login = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtf_nome = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        tf_codigo = new java.awt.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cadastrando Usuário");
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
        getContentPane().add(jb_salvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, 35));

        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/exit.png"))); // NOI18N
        jb_cancelar.setText("Cancelar");
        jb_cancelar.setName("jb_cancelar"); // NOI18N
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, 35));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Login");
        jLabel3.setName("jLabel3"); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jpf_senha.setName("jpf_senha"); // NOI18N
        jpf_senha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jpf_senhaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jpf_senhaFocusLost(evt);
            }
        });
        jpf_senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpf_senhaKeyPressed(evt);
            }
        });
        getContentPane().add(jpf_senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 140, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("Nome");
        jLabel1.setName("jLabel1"); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jtf_login.setDocument(new UnaccentedDocument());
        jtf_login.setName("jtf_login"); // NOI18N
        jtf_login.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_loginFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_loginFocusLost(evt);
            }
        });
        jtf_login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_loginKeyPressed(evt);
            }
        });
        getContentPane().add(jtf_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 180, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText("Código");
        jLabel5.setName("jLabel5"); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("Senha");
        jLabel4.setName("jLabel4"); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, -1, -1));

        jtf_nome.setDocument(new UnaccentedDocument());
        jtf_nome.setName("jtf_nome"); // NOI18N
        jtf_nome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_nomeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_nomeFocusLost(evt);
            }
        });
        jtf_nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_nomeKeyPressed(evt);
            }
        });
        getContentPane().add(jtf_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 320, -1));

        tf_codigo.setEditable(false);
        tf_codigo.setName("tf_codigo"); // NOI18N
        getContentPane().add(tf_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 100, -1));

        setSize(new java.awt.Dimension(365, 273));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jb_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salvarActionPerformed
        verificaCadastro();
        janelapai.listarUsuário();
}//GEN-LAST:event_jb_salvarActionPerformed

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        janelapai.setEnabled(true);
        janelapai.setVisible(true);
        janelapai.request();
        setVisible(false);
}//GEN-LAST:event_jb_cancelarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtf_nome.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        janelapai.setEnabled(true);
        janelapai.setVisible(true);
        janelapai.request();
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void jpf_senhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpf_senhaKeyPressed
        jpf_senha.addKeyListener(new KeyAdapter() {  
      public void keyReleased(KeyEvent evt) {  
        if (evt.getKeyCode() != KeyEvent.VK_HOME) {  
          String s = jpf_senha.getText();  
          jpf_senha.setText(s.toUpperCase());  
        }  
      }  
    }); 
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            verificaCadastro();
            janelapai.listarUsuário();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jpf_senhaKeyPressed

    private void jtf_nomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_nomeFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nomeFocusLost

    private void jtf_loginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_loginFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_loginFocusLost

    private void jpf_senhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpf_senhaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jpf_senhaFocusLost

    private void jtf_nomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_nomeFocusGained
        jtf_nome.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (jtf_nome.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o nome do usuário");
                    jtf_nome.requestFocus();
                    return false;
                } else {
                    return true;
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nomeFocusGained

    private void jtf_loginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_loginFocusGained
        jtf_login.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (jtf_login.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o login do usuário");
                    jtf_login.requestFocus();
                    return false;
                } else {
                    return true;
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_loginFocusGained

    private void jpf_senhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpf_senhaFocusGained
        jpf_senha.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (jpf_senha.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Informe a senha do usuário");
                    jpf_senha.requestFocus();
                    return false;
                } else {
                    return true;
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_jpf_senhaFocusGained

private void jtf_nomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nomeKeyPressed
    jtf_nome.addKeyListener(new KeyAdapter() {  
      public void keyReleased(KeyEvent evt) {  
        if (evt.getKeyCode() != KeyEvent.VK_HOME) {  
          String s = jtf_nome.getText();  
          jtf_nome.setText(s.toUpperCase());  
        }  
      }  
    }); 
    // TODO add your handling code here:
}//GEN-LAST:event_jtf_nomeKeyPressed

private void jtf_loginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_loginKeyPressed
    jtf_login.addKeyListener(new KeyAdapter() {  
      public void keyReleased(KeyEvent evt) {  
        if (evt.getKeyCode() != KeyEvent.VK_HOME) {  
          String s = jtf_login.getText();  
          jtf_login.setText(s.toUpperCase());  
        }  
      }  
    }); 
    
    // TODO add your handling code here:
}//GEN-LAST:event_jtf_loginKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CadastroUsuario().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_salvar;
    private javax.swing.JPasswordField jpf_senha;
    private javax.swing.JTextField jtf_login;
    private javax.swing.JTextField jtf_nome;
    private java.awt.TextField tf_codigo;
    // End of variables declaration//GEN-END:variables
    Usuario usuario = new Usuario();

    private void cadastraUsuario() {
        if (verificarCampos()) {
            pool = new Pool();
            UsuarioDAO usuarioControl = new UsuarioDAO(pool);
            usuario.setNome_usuário(jtf_nome.getText().trim());
            usuario.setLogin(jtf_login.getText().trim());
            usuario.setSenha(jpf_senha.getText().trim());
            usuarioControl.cadastraUsuario(usuario);
            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
            retornaJanelaPai();
        }
    }

    public boolean verificarCampos() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_nome.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Nome\n";
        }
        if (jtf_login.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Login\n";
        }
        if (jpf_senha.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Senha\n";
        }


        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            return false;
        } else {
            return true;
        }

    }

    public void retornaJanelaPai() {
        janelapai.setEnabled(true);
        janelapai.setVisible(true);
        janelapai.request();
        setVisible(false);

    }

    public void verificaCadastro() {
        pool = new Pool();
        UsuarioDAO usu = new UsuarioDAO(pool);
        usuarios = usu.listarUsuarioDescrição1(jtf_nome.getText().trim(), jtf_login.getText().trim());
        validaCadastro(usuarios);
    }

    public void validaCadastro(List<Usuario> usuario) {//verifica cadastro existente que retornou de uma lista

        if (usuario.size() == 0) {
            cadastraUsuario();
        } else {
            JOptionPane.showMessageDialog(null, "Usuário ou login existente");
            jtf_nome.requestFocus();
        }
    }
}
