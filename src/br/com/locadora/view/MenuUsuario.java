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
import br.com.locadora.util.TemaInterface;
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
    public AtualizaUsuario atualizaUsuario;
    /**
     * Creates new form Cad_Usuário
     */
    public MenuUsuario() {
        initComponents();
        listarUsuário();
        TemaInterface.getInterface(this);
        atualizaUsuario = null;
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
        jtf_consultar_usuario = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jb_novo = new javax.swing.JButton();
        jb_alterar1 = new javax.swing.JButton();
        jb_excluir1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

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
        setTitle("Gerenciamento de Usuários");
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

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jtbl_usuario.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
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
                false, false, false
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
                jtbl_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        jtbl_usuarioMouseClicked(evt);
                    }
                });
                jtbl_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        jtbl_usuarioKeyPressed(evt);
                    }
                });
                jScrollPane2.setViewportView(jtbl_usuario);
                if (jtbl_usuario.getColumnModel().getColumnCount() > 0) {
                    jtbl_usuario.getColumnModel().getColumn(0).setPreferredWidth(10);
                    jtbl_usuario.getColumnModel().getColumn(1).setPreferredWidth(300);
                    jtbl_usuario.getColumnModel().getColumn(2).setPreferredWidth(80);
                }

                jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta Usuário"));
                jPanel3.setName("jPanel3"); // NOI18N

                buttonGroup1.add(jrb_codigo);
                jrb_codigo.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
                jrb_codigo.setText("Código");
                jrb_codigo.setName("jrb_codigo"); // NOI18N

                buttonGroup1.add(jrb_nome);
                jrb_nome.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
                jrb_nome.setSelected(true);
                jrb_nome.setText("Nome");
                jrb_nome.setName("jrb_nome"); // NOI18N

                buttonGroup1.add(jrb_login);
                jrb_login.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
                jrb_login.setText("Login");
                jrb_login.setName("jrb_login"); // NOI18N

                jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
                jLabel1.setText("Parâmetro");
                jLabel1.setName("jLabel1"); // NOI18N

                jButton1.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
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

                jtf_consultar_usuario.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
                jtf_consultar_usuario.setName("jtf_consultar_usuario"); // NOI18N
                jtf_consultar_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        jtf_consultar_usuarioKeyPressed(evt);
                    }
                });

                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                    jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jrb_nome)
                                .addGap(10, 10, 10)
                                .addComponent(jrb_login)
                                .addGap(10, 10, 10)
                                .addComponent(jrb_codigo))
                            .addComponent(jLabel1)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jtf_consultar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButton1)))
                        .addGap(10, 10, 10))
                );
                jPanel3Layout.setVerticalGroup(
                    jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrb_nome)
                            .addComponent(jrb_login)
                            .addComponent(jrb_codigo))
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_consultar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(10, 10, 10))
                );

                jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jtf_consultar_usuario});

                jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
                jPanel1.setName("jPanel1"); // NOI18N
                jPanel1.setLayout(new java.awt.GridBagLayout());

                jb_novo.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
                jb_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/novo_registro.gif"))); // NOI18N
                jb_novo.setText("Novo");
                jb_novo.setName("jb_novo"); // NOI18N
                jb_novo.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_novoActionPerformed(evt);
                    }
                });
                jPanel1.add(jb_novo, new java.awt.GridBagConstraints());

                jb_alterar1.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
                jb_alterar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/alterar_registro.gif"))); // NOI18N
                jb_alterar1.setText("Alterar");
                jb_alterar1.setName("jb_alterar1"); // NOI18N
                jb_alterar1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_alterar1ActionPerformed(evt);
                    }
                });
                jPanel1.add(jb_alterar1, new java.awt.GridBagConstraints());

                jb_excluir1.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
                jb_excluir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/delete.gif"))); // NOI18N
                jb_excluir1.setText("Excluir");
                jb_excluir1.setName("jb_excluir1"); // NOI18N
                jb_excluir1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_excluir1ActionPerformed(evt);
                    }
                });
                jPanel1.add(jb_excluir1, new java.awt.GridBagConstraints());

                jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/BROADWAY-LOGIN.png"))); // NOI18N
                jLabel2.setName("jLabel2"); // NOI18N

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(20, 20, 20))
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                );

                pack();
                setLocationRelativeTo(null);
            }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtf_consultar_usuario.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jb_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_novoActionPerformed
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuUsuario");
        try {
            if (acesso.getSuper_usuario()== 0) {
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

    private void jtf_consultar_usuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_consultar_usuarioKeyPressed
        acionarAtalho(evt);
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
    }//GEN-LAST:event_jtf_consultar_usuarioKeyPressed

    private void jtbl_usuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_usuarioKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            alterar();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_usuarioKeyPressed

    private void jtbl_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_usuarioMouseClicked
        if (evt.getClickCount() == 2) {
            alterar();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_usuarioMouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jb_alterar1;
    private javax.swing.JButton jb_excluir1;
    private javax.swing.JButton jb_novo;
    private javax.swing.JRadioButton jrb_codigo;
    private javax.swing.JRadioButton jrb_login;
    private javax.swing.JRadioButton jrb_nome;
    private javax.swing.JTable jtbl_usuario;
    public static javax.swing.JTextField jtf_consultar_usuario;
    private java.awt.PopupMenu popupMenu1;
    // End of variables declaration//GEN-END:variables
    Usuario usuario = new Usuario();

    public void request() {
        jtf_consultar_usuario.requestFocus();
    }

    public void listarUsuário() {
        pool = new Pool();
        UsuarioDAO usu = new UsuarioDAO(pool);
        usuarios = usu.getUsuarios("%" + jtf_consultar_usuario.getText().trim() + "%");
        mostraUsuarios(usuarios);
    }

    public void listarUsuárioCodigo() {
        if (jtf_consultar_usuario.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe um Código");
        } else {
            pool = new Pool();
            UsuarioDAO usu = new UsuarioDAO(pool);
            usuarios = usu.listarUsuarioCodigo(jtf_consultar_usuario.getText().trim());
            mostraUsuarios(usuarios);
        }
    }

    public void listarUsuárioDescrição() {
        pool = new Pool();
        UsuarioDAO usu = new UsuarioDAO(pool);

        usuarios = usu.listarUsuarioDescrição("%"+jtf_consultar_usuario.getText().trim() + "%");
        mostraUsuarios(usuarios);
    }

    public void mostraUsuarios(List<Usuario> usuarios) {
        DefaultTableModel tableModel = (DefaultTableModel) jtbl_usuario.getModel();
        tableModel.setNumRows(0);

        if (usuarios.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum Usuário encontrado");

        } else {

            for (int i = 0; i < usuarios.size(); i++) {

                DefaultTableModel row = (DefaultTableModel) jtbl_usuario.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(usuarios.get(i), usuarios.get(i).getNome_usuario());
                row.addRow(new Object[]{usuarios.get(i).getCodigo_usuario(), hashDbGrid, usuarios.get(i).getLogin()});
            }
            jtbl_usuario.requestFocus();
            jtbl_usuario.setSelectionMode(1);
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

    public void acionarAtalho(java.awt.event.KeyEvent evt) {

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            setVisible(false);
            janelapai.setStatusTela(true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            excluirUsuario();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            jtf_consultar_usuario.requestFocus();
        }
    }
    
    public void alterar() {
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.Locadora.view.MenuUsuario");
        try {
            System.out.println("Escrever: " + acesso.getEscrever());
            if (acesso.getSuper_usuario()== 0) {
                Usuario usu = tbUsuarioLinhaSelecionada(jtbl_usuario);
                if (usu != null) {
                    if(atualizaUsuario == null){
                        atualizaUsuario = new AtualizaUsuario(usu);
                        atualizaUsuario.janelapai = this;
                        atualizaUsuario.setVisible(true);
                        this.setEnabled(false);                
                    } else {
                        atualizaUsuario.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um Usuário");
                    jtf_consultar_usuario.requestFocus();
                }
                
            }
        
    }  catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }
    }
}
