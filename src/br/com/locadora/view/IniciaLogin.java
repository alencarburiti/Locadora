package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.model.dao.UsuarioDAO;
import br.com.locadora.model.bean.Usuario;
import br.com.locadora.util.ArquivoConfiguracao;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Alencar
 */
public class IniciaLogin extends javax.swing.JFrame {

    public List<Usuario> usuarios;
    public String usuarioNome;
    public Integer codUsuário;
    public String login;
    public String permissao;
    public InterfacePool pool;
        
    /**
     * Creates new form Log_login
     */
    public IniciaLogin() {

        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jb_logar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        jl_erro = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        jtf_login = new javax.swing.JTextField();
        jpf_senha = new javax.swing.JPasswordField();
        jb_limpar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login"); // NOI18N
        setIconImages(null);
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

        jb_logar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/http___iconesbr.oficinadanet.com_8533_16x16.png"))); // NOI18N
        jb_logar.setText("OK !");
        jb_logar.setName("jb_logar"); // NOI18N
        jb_logar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_logarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_logar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 81, 40));

        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/sair.gif"))); // NOI18N
        jb_cancelar.setText("Sair");
        jb_cancelar.setName("jb_cancelar"); // NOI18N
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 97, -1));

        jl_erro.setText("        ");
        jl_erro.setName("jl_erro"); // NOI18N
        getContentPane().add(jl_erro, new org.netbeans.lib.awtextra.AbsoluteConstraints(643, 17, -1, -1));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        label1.setName("label1"); // NOI18N
        label1.setText("Login:");
        jPanel1.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 50, -1));

        label2.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        label2.setName("label2"); // NOI18N
        label2.setText("Senha:");
        jPanel1.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jtf_login.setName("jtf_login"); // NOI18N
        jtf_login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_loginKeyPressed(evt);
            }
        });
        jPanel1.add(jtf_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 150, -1));

        jpf_senha.setName("jpf_senha"); // NOI18N
        jpf_senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpf_senhaKeyPressed(evt);
            }
        });
        jPanel1.add(jpf_senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 150, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 260, 110));

        jb_limpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/limpar.png"))); // NOI18N
        jb_limpar.setText("Limpar");
        jb_limpar.setName("jb_limpar"); // NOI18N
        jb_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_limparActionPerformed(evt);
            }
        });
        getContentPane().add(jb_limpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, -1, -1));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/BROADWAY-LOGIN.png"))); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 260, 110));

        setSize(new java.awt.Dimension(426, 347));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_cancelarActionPerformed

    private void jb_logarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_logarActionPerformed
        entrar();
    }//GEN-LAST:event_jb_logarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jpf_senhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpf_senhaKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            entrar();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jpf_senhaKeyPressed

    private void jtf_loginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_loginKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jpf_senha.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_loginKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        dispose();
    }//GEN-LAST:event_formWindowClosed

    private void jb_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_limparActionPerformed
        limparCampos();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_limparActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new IniciaLogin().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_limpar;
    private javax.swing.JButton jb_logar;
    private javax.swing.JLabel jl_erro;
    private javax.swing.JPasswordField jpf_senha;
    private javax.swing.JTextField jtf_login;
    private java.awt.Label label1;
    private java.awt.Label label2;
    // End of variables declaration//GEN-END:variables

    private void entrar() {

        if (validaLogin()) {
            if (verificaLogin()) {
                ArquivoConfiguracao conf = new ArquivoConfiguracao();
                conf.writePropertie("login", usuarios.get(0).getLogin());
                conf.writePropertie("codigo_usuario", String.valueOf(usuarios.get(0).getCodigo_usuario()));
                TelaPrincipal tela = new TelaPrincipal();                
                tela.carregaUsuario(usuarios.get(0));
                tela.show();
                this.dispose();
            } else {
                jpf_senha.requestFocus();
                jpf_senha.setText("");
            }
        }
    }

    private boolean validaLogin() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_login.getText().equals("")) {
            msgERRO = msgERRO + " *Login\n";
        }
        if (jpf_senha.getText().equals("")) {
            msgERRO = msgERRO + " *Senha\n";
        }

        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            return false;
        } else {
            return true;
        }

    }

    public boolean verificaLogin() {
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        usuarios = usuarioControl.consultarLogin(jtf_login.getText().trim());

        //verifica o login
        if ((usuarios).isEmpty()) {
            JOptionPane.showMessageDialog(null, "Login inexistente");
            jtf_login.requestFocus();
            return false;
        }

        //verifica a senha
        char[] senha = jpf_senha.getPassword();
        char[] senhaDoBanco = usuarios.get(0).getSenha().toCharArray();

        // verifica o tamanho da senha
        if (senha.length != senhaDoBanco.length) {
            JOptionPane.showMessageDialog(null, "Senha incorreta");
            return false; // se for diferente, retorna falso
        } else {
            for (int i = 0; i < senha.length; i++) {
                if (senha[i] != senhaDoBanco[i]) {
                    JOptionPane.showMessageDialog(null, "Senha incorreta");
                    return false; // se for diferente, retorna falso
                }
            }
        }

        return true;
    }
    
    public boolean limparCampos() {
        jtf_login.setText("");
        jpf_senha.setText("");
        jtf_login.requestFocus();
        return true;
    }
}
