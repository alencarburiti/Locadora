package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.model.dao.UsuarioDAO;
import br.com.locadora.model.bean.Usuario;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.TemaInterface;
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
        TemaInterface.getInterface(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtf_login = new javax.swing.JTextField();
        jpf_senha = new javax.swing.JPasswordField();
        jb_logar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        jb_limpar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
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

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setName("jPanel1"); // NOI18N

        jtf_login.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jtf_login.setName("jtf_login"); // NOI18N
        jtf_login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_loginKeyPressed(evt);
            }
        });

        jpf_senha.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jpf_senha.setName("jpf_senha"); // NOI18N
        jpf_senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpf_senhaKeyPressed(evt);
            }
        });

        jb_logar.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jb_logar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/usuarios.png"))); // NOI18N
        jb_logar.setText("Entrar");
        jb_logar.setName("jb_logar"); // NOI18N
        jb_logar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_logarActionPerformed(evt);
            }
        });

        jb_cancelar.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/sair.gif"))); // NOI18N
        jb_cancelar.setText("Sair");
        jb_cancelar.setName("jb_cancelar"); // NOI18N
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });

        jb_limpar.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jb_limpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/limpar.png"))); // NOI18N
        jb_limpar.setText("Limpar");
        jb_limpar.setName("jb_limpar"); // NOI18N
        jb_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_limparActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Login:");
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Senha:");
        jLabel3.setName("jLabel3"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jb_logar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jb_limpar)
                .addGap(10, 10, 10)
                .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpf_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_login, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jb_cancelar, jb_limpar, jb_logar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpf_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jb_logar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jb_cancelar, jb_limpar, jb_logar});

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/BROADWAY-LOGIN.png"))); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(346, 315));
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_limpar;
    private javax.swing.JButton jb_logar;
    private javax.swing.JPasswordField jpf_senha;
    private javax.swing.JTextField jtf_login;
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
