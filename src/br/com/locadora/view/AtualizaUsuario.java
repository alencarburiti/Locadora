/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AtualizaUsuario.java
 *
 * Created on 26/05/2011, 16:10:08
 */
package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.model.dao.UsuarioDAO;
import br.com.locadora.model.bean.Usuario;
import br.com.locadora.util.LimitadorTexto;
import br.com.locadora.util.TemaInterface;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ALENCAR
 */
public class AtualizaUsuario extends javax.swing.JFrame {

    public MenuUsuario janelapai;
    private Usuario usuario;
    List<Usuario> usuarios;
    public InterfacePool pool;

    /**
     * Creates new form UsuariosAlterarGUI
     */
    public AtualizaUsuario() {
        initComponents();
        TemaInterface.getInterface(this);
        janelapai = null;        
    }

    public AtualizaUsuario(Usuario usu) {
        initComponents();
        if(usu != null){
            TemaInterface.getInterface(this);
            janelapai = null;
            
            this.usuario = usu;
            jtf_codigo_usuario.setText(String.valueOf(usu.getCodigo_usuario()));
            jtf_nome.setText(usu.getNome_usuario());
            jtf_login.setText(usu.getLogin());
            jpf_senha.setText(usu.getSenha());
            jtf_nome.requestFocus();
            System.out.println("Senha para alterar: "+usu.getSenha());
        }
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
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtf_login = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jLabel5 = new javax.swing.JLabel();
        jtf_nome = new javax.swing.JTextField();
        jtf_codigo_usuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jpf_senha = new javax.swing.JPasswordField(new LimitadorTexto(45), "",10);
        jb_salvar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterando Usuário");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuário"));
        jPanel1.setName("jPanel1"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel3.setText("Login");
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel1.setText("Nome");
        jLabel1.setName("jLabel1"); // NOI18N

        jtf_login.setEditable(false);
        jtf_login.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
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

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel5.setText("Código");
        jLabel5.setName("jLabel5"); // NOI18N

        jtf_nome.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_nome.setName("jtf_nome"); // NOI18N
        jtf_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_nomeActionPerformed(evt);
            }
        });
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

        jtf_codigo_usuario.setEditable(false);
        jtf_codigo_usuario.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_codigo_usuario.setName("jtf_codigo_usuario"); // NOI18N

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel4.setText("Senha");
        jLabel4.setName("jLabel4"); // NOI18N

        jpf_senha.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jpf_senha.setToolTipText("Senha deve conter no mínimo 6 dígitos");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jtf_login, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jpf_senha)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jtf_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_codigo_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(jtf_codigo_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(jtf_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpf_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jb_salvar.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/save.png"))); // NOI18N
        jb_salvar.setText("Salvar");
        jb_salvar.setName("jb_salvar"); // NOI18N
        jb_salvar.setPreferredSize(new java.awt.Dimension(100, 40));
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

        jb_cancelar.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/sair.png"))); // NOI18N
        jb_cancelar.setText("Sair");
        jb_cancelar.setName("jb_cancelar"); // NOI18N
        jb_cancelar.setPreferredSize(new java.awt.Dimension(100, 40));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jb_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jb_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_salvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        retornaJanelaPai();
    }//GEN-LAST:event_formWindowClosed

    private void jtf_loginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_loginFocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_loginFocusGained

    private void jtf_loginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_loginFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_loginFocusLost

    private void jtf_loginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_loginKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jpf_senha.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_loginKeyPressed

    private void jtf_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nomeActionPerformed

    private void jtf_nomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_nomeFocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nomeFocusGained

    private void jtf_nomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_nomeFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nomeFocusLost

    private void jtf_nomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nomeKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jpf_senha.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nomeKeyPressed

    private void jpf_senhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpf_senhaFocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_jpf_senhaFocusGained

    private void jpf_senhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpf_senhaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jpf_senhaFocusLost

    private void jpf_senhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpf_senhaKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_salvar.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jpf_senhaKeyPressed

    private void jb_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salvarActionPerformed
        alteraUsuario();
    }//GEN-LAST:event_jb_salvarActionPerformed

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        retornaJanelaPai();
    }//GEN-LAST:event_jb_cancelarActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtf_nome.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jb_salvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_salvarKeyPressed
        acionarAtalho(evt);
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jb_salvar.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_salvarKeyPressed

    private void jb_cancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_cancelarKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_cancelarKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AtualizaUsuario().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_salvar;
    private javax.swing.JPasswordField jpf_senha;
    private javax.swing.JTextField jtf_codigo_usuario;
    private javax.swing.JTextField jtf_login;
    private javax.swing.JTextField jtf_nome;
    // End of variables declaration//GEN-END:variables

    public void alteraUsuario() {
        if (verificarCampos()) {
            pool = new Pool();
            UsuarioDAO usuarioControl = new UsuarioDAO(pool);
            usuario = new Usuario();
            usuario.setCodigo_usuario(Integer.parseInt(jtf_codigo_usuario.getText().trim()));
            usuario.setNome_usuario(jtf_nome.getText().trim());
            usuario.setLogin(jtf_login.getText().trim());
            usuario.setSenha(jpf_senha.getText().trim());

            usuarioControl.alteraUsuario(usuario);
            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
        }
    }
    
    public boolean verificarCampos() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_nome.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Nome\n";
        }

        if (jpf_senha.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Senha\n";
        } else if (jpf_senha.getText().length() <= 5) {
            msgERRO = msgERRO + " *Senha menor que 6 caracteres\n";
        } else {
            char[] senha = jpf_senha.getPassword();
            String senha_consultar = "";
            for (int i = 0; i < senha.length; i++) {
                senha_consultar = senha_consultar + senha[i];
            }
            pool = new Pool();
            UsuarioDAO usu = new UsuarioDAO(pool);
            usuarios = usu.consultarSenha(senha_consultar);
            if (usuarios.size() != 0) {
                char[] senhaDoBanco = usuarios.get(0).getSenha().toCharArray();
                // verifica o tamanho da senha
                int caracter_igual = 0;
                for (int i = 0; i < senha.length; i++) {
                    if (senha[i] == senhaDoBanco[i]) {
                        caracter_igual = caracter_igual + 1;
                    }
                }
                if (senha.length == caracter_igual) {
                    if (usuarios.get(0).getCodigo_usuario() != Integer.parseInt(jtf_codigo_usuario.getText())) {
                        System.out.println("Login de Consulta: "+usuarios.get(0).getLogin());
                        System.out.println("Senha de Consulta: "+usuarios.get(0).getSenha());
                        msgERRO = msgERRO + " *Senha Existente\n";
                    }
                }
            }
        }
        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            return false;
        } else {
            return true;
        }

    }

    public void retornaJanelaPai() {
        setVisible(false);
        if(janelapai != null){
            janelapai.setStatusTela(true);
            janelapai.jtf_pesquisa.requestFocus();
            janelapai.atualizaUsuario = null;
            janelapai.getUsuarios();            
        }
    }

    public void acionarAtalho(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F10) {
            jb_salvar.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            retornaJanelaPai();
        }
    }
}
