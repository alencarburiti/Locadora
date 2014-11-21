/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Cad_Usuário.java
 *
 * Created on 07/04/2011, 20:29:27
 */
package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.dao.UsuarioDAO;
import br.com.locadora.model.bean.Usuario;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.ItemDbGrid;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alencar
 */
public class MenuUsuario extends javax.swing.JFrame {

    public String tipoCadastro;
    public List<Usuario> usuarios;
    public TelaPrincipal janelapai;
    public InterfacePool pool;
    public AcessoUsuario acesso;

    /**
     * Creates new form Cad_Usuário
     */
    public MenuUsuario() {
        initComponents();
        listarUsuário();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        popupMenu1 = new java.awt.PopupMenu();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_usuario = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jrb_codigo = new javax.swing.JRadioButton();
        jrb_nome = new javax.swing.JRadioButton();
        jrb_login = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jtf_pesquisar_usuario = new javax.swing.JTextField();
        jb_sair = new javax.swing.JButton();
        jb_excluir1 = new javax.swing.JButton();
        jb_alterar1 = new javax.swing.JButton();
        jb_novo = new javax.swing.JButton();

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setName("jTable1"); // NOI18N
        jScrollPane1.setViewportView(jTable1);

        popupMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciamento de usuários");
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

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jtbl_usuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome Usuário", "Login"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbl_usuario.setUpdateSelectionOnSort(false);

        jtbl_usuario.setVerifyInputWhenFocusTarget(false);
        jtbl_usuario.setDefaultEditor(Object.class, null);
        jtbl_usuario.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount() == 2){
                    alterar();
                }}});
                jtbl_usuario.setName("jtbl_usuario"); // NOI18N
                jtbl_usuario.getTableHeader().setReorderingAllowed(false);
                jScrollPane2.setViewportView(jtbl_usuario);
                if (jtbl_usuario.getColumnModel().getColumnCount() > 0) {
                    jtbl_usuario.getColumnModel().getColumn(0).setResizable(false);
                    jtbl_usuario.getColumnModel().getColumn(0).setPreferredWidth(10);
                    jtbl_usuario.getColumnModel().getColumn(1).setResizable(false);
                    jtbl_usuario.getColumnModel().getColumn(1).setPreferredWidth(130);
                    jtbl_usuario.getColumnModel().getColumn(2).setResizable(false);
                    jtbl_usuario.getColumnModel().getColumn(2).setPreferredWidth(50);
                }

                getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 184, 530, 180));

                jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultas"));
                jPanel3.setName("jPanel3"); // NOI18N
                jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                buttonGroup1.add(jrb_codigo);
                jrb_codigo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
                jrb_codigo.setText("Código");
                jrb_codigo.setName("jrb_codigo"); // NOI18N
                jPanel3.add(jrb_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

                buttonGroup1.add(jrb_nome);
                jrb_nome.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
                jrb_nome.setSelected(true);
                jrb_nome.setText("Nome");
                jrb_nome.setName("jrb_nome"); // NOI18N
                jPanel3.add(jrb_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

                buttonGroup1.add(jrb_login);
                jrb_login.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
                jrb_login.setText("Login");
                jrb_login.setName("jrb_login"); // NOI18N
                jPanel3.add(jrb_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

                jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
                jLabel1.setText("Parâmetro");
                jLabel1.setName("jLabel1"); // NOI18N
                jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

                jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pesquisar.png"))); // NOI18N
                jButton1.setName("jButton1"); // NOI18N
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton1ActionPerformed(evt);
                    }
                });
                jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        jButton1KeyPressed(evt);
                    }
                });
                jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));

                jtf_pesquisar_usuario.setName("jtf_pesquisar_usuario"); // NOI18N
                jPanel3.add(jtf_pesquisar_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 280, -1));

                getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 530, 110));

                jb_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/exit.png"))); // NOI18N
                jb_sair.setText("Sair");
                jb_sair.setName("jb_sair"); // NOI18N
                jb_sair.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_sairActionPerformed(evt);
                    }
                });
                getContentPane().add(jb_sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, 35));

                jb_excluir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/delete.gif"))); // NOI18N
                jb_excluir1.setText("Excluir");
                jb_excluir1.setName("jb_excluir1"); // NOI18N
                jb_excluir1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_excluir1ActionPerformed(evt);
                    }
                });
                getContentPane().add(jb_excluir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, 35));

                jb_alterar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/alterar_registro.gif"))); // NOI18N
                jb_alterar1.setText("Alterar");
                jb_alterar1.setName("jb_alterar1"); // NOI18N
                jb_alterar1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_alterar1ActionPerformed(evt);
                    }
                });
                getContentPane().add(jb_alterar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 101, 35));

                jb_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/novo_registro.gif"))); // NOI18N
                jb_novo.setText("Novo");
                jb_novo.setName("jb_novo"); // NOI18N
                jb_novo.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_novoActionPerformed(evt);
                    }
                });
                getContentPane().add(jb_novo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, 35));

                setSize(new java.awt.Dimension(581, 404));
                setLocationRelativeTo(null);
            }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        jtf_pesquisar_usuario.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jb_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_novoActionPerformed
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuUsuario");
        try {
            if (acesso.getEscrever() == 0) {
                CadastroUsuario cadastroUsuario = new CadastroUsuario();
                cadastroUsuario.janelapai = this;
                cadastroUsuario.setVisible(true);
                setStatusTela(false);
            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }

        // TODO add your handling code here:
}//GEN-LAST:event_jb_novoActionPerformed

    private void jb_alterar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_alterar1ActionPerformed
        alterar();
        // TODO add your handling code here:
}//GEN-LAST:event_jb_alterar1ActionPerformed
    public void alterar() {
//        Usuario usu = tbUsuarioLinhaSelecionada(jt_pesquisar);
//        if (usu != null) {
//            UsuariosAlterarGUI usuarioAltera = new UsuariosAlterarGUI(usu);
//            usuarioAltera.janelapai = this;
//            usuarioAltera.setVisible(true);
//            this.setEnabled(false);
//        } else {
//
//            JOptionPane.showMessageDialog(null, "Selecione um usuario");
//            tf_pesquisar_usuario.requestFocus();
//        }
    }
    private void jb_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_sairActionPerformed
        setVisible(false);
        janelapai.setStatusTela(true);
}//GEN-LAST:event_jb_sairActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jrb_codigo.isSelected() == true) {
            listarUsuárioCodigo();

        } else if (jrb_nome.isSelected() == true) {
            listarUsuárioDescrição();
        } else if (jrb_login.isSelected() == true) {
            listarUsuário();
        } else {
            listarUsuário();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jb_excluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_excluir1ActionPerformed
        excluirUsuario();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_excluir1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        janelapai.setStatusTela(true);
        setVisible(false);
    }//GEN-LAST:event_formWindowClosed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (jrb_codigo.isSelected() == true) {
                listarUsuárioCodigo();

            } else if (jrb_nome.isSelected() == true) {
                listarUsuárioDescrição();
            } else if (jrb_login.isSelected() == true) {
                listarUsuário();
            } else {
                listarUsuário();
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MenuUsuario().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jb_alterar1;
    private javax.swing.JButton jb_excluir1;
    private javax.swing.JButton jb_novo;
    private javax.swing.JButton jb_sair;
    private javax.swing.JRadioButton jrb_codigo;
    private javax.swing.JRadioButton jrb_login;
    private javax.swing.JRadioButton jrb_nome;
    private javax.swing.JTable jtbl_usuario;
    private javax.swing.JTextField jtf_pesquisar_usuario;
    private java.awt.PopupMenu popupMenu1;
    // End of variables declaration//GEN-END:variables
    Usuario usuario = new Usuario();

    public void request() {
        jtf_pesquisar_usuario.requestFocus();
    }

    public void listarUsuário() {
        pool = new Pool();
        UsuarioDAO usu = new UsuarioDAO(pool);
        usuarios = usu.getUsuarios("%" + jtf_pesquisar_usuario.getText().trim() + "%");
        mostraUsuarios(usuarios);
    }

    public void listarUsuárioCodigo() {
        if (jtf_pesquisar_usuario.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe um código");
        } else {
            pool = new Pool();
            UsuarioDAO usu = new UsuarioDAO(pool);
            usuarios = usu.listarUsuarioCodigo(jtf_pesquisar_usuario.getText().trim());
            mostraUsuarios(usuarios);
        }
    }

    public void listarUsuárioDescrição() {
        pool = new Pool();
        UsuarioDAO usu = new UsuarioDAO(pool);

        usuarios = usu.listarUsuarioDescrição(jtf_pesquisar_usuario.getText().trim() + "%");
        mostraUsuarios(usuarios);
    }

    public void mostraUsuarios(List<Usuario> usuarios) {
        while (jtbl_usuario.getRowCount() > 0) {
            jtbl_usuario.remove(0);
        }

        if (usuarios.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum usuário encontrado");

        } else {
            
            for (int i = 0; i < usuarios.size(); i++) {

                DefaultTableModel row = (DefaultTableModel) jtbl_usuario.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(usuarios.get(i), usuarios.get(i).getNome_usuario());
                row.addRow(new Object[]{usuarios.get(i).getCodigo_usuario(), hashDbGrid, usuarios.get(i).getLogin()});
            }
        }

    }

    public Usuario tbUsuarioLinhaSelecionada(JTable tb) {
        Usuario usu = null;
        if (tb.getSelectedRow() != -1) {
            usu = new Usuario();
            usu.setCodigo_usuario(usuarios.get(tb.getSelectedRow()).getCodigo_usuario());
            usu.setNome_usuario(usuarios.get(tb.getSelectedRow()).getNome_usuario());
            usu.setLogin(usuarios.get(tb.getSelectedRow()).getLogin());
            usu.setSenha(usuarios.get(tb.getSelectedRow()).getSenha());
            usu.setPermissao(usuarios.get(tb.getSelectedRow()).getPermissao());

        }
        return usu;
    }

    private void excluirUsuario() {
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuObjeto");

        try {
            if (acesso.getSuper_usuario() == 0) {
                DefaultTableModel row = (DefaultTableModel) jtbl_usuario.getModel();
                if (jtbl_usuario.getSelectedRow() != -1) {
                    int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
                    if (selectedOption == JOptionPane.YES_NO_OPTION) {
                        pool = new Pool();
                        UsuarioDAO usuarioDAO = new UsuarioDAO(pool);
                        usuario = new Usuario();
                        usuario.setCodigo_usuario(usuarios.get(jtbl_usuario.getSelectedRow()).getCodigo_usuario());

                        try {
                            usuarioDAO.excluiUsuario(usuario);
                            row.removeRow(jtbl_usuario.getSelectedRow());
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Este registro não pode ser excluído pois está referenciado em outra tabela");
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um objeto");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }
    }

    public void setStatusTela(boolean status) {

        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);

    }
}
