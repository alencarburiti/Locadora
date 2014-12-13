package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.controller.SiscomController;
import br.com.locadora.model.bean.InterfaceAcesso;
import br.com.locadora.model.bean.Usuario;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.dao.AcessoUsuarioDAO;
import br.com.locadora.model.dao.UsuarioDAO;
import br.com.locadora.util.AutoCompletion;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.TemaInterface;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALENCAR
 */
public final class AcessoInterface extends javax.swing.JFrame {

    public InterfacePool pool;
    public SiscomController controller;
    public String action;
    public TelaPrincipal janelapai;
    public List<AcessoUsuario> acessos;
    public AcessoUsuario acesso;

    /**
     * Creates new form ProdutoCadastroGUI
     */
    public AcessoInterface() {
        initComponents();

        TemaInterface.getInterface(this);
    }

    //public ProdutoConsultarGUI janelapaim;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tfa_similar = new javax.swing.JTextArea();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jcb_usuario = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbl_permissoes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jcb_interface = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jcb_ler = new javax.swing.JCheckBox();
        jcb_escrever = new javax.swing.JCheckBox();
        jcb_deletar = new javax.swing.JCheckBox();
        jcb_super = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jb_cancelar = new javax.swing.JButton();
        jb_salvar = new javax.swing.JButton();

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tfa_similar.setColumns(20);
        tfa_similar.setRows(5);
        tfa_similar.setName("tfa_similar"); // NOI18N
        jScrollPane1.setViewportView(tfa_similar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Controle de Acessos");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuário"));
        jPanel1.setName("jPanel1"); // NOI18N

        jcb_usuario.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_usuario.setName("jcb_usuario"); // NOI18N
        jcb_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_usuarioActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel2.setText("Nome:");
        jLabel2.setName("jLabel2"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jcb_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(120, 120, 120))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(jcb_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        jtbl_permissoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tela", "Ler", "Escrever", "Deletar", "Super"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbl_permissoes.setName("jtbl_permissoes"); // NOI18N
        jScrollPane3.setViewportView(jtbl_permissoes);
        if (jtbl_permissoes.getColumnModel().getColumnCount() > 0) {
            jtbl_permissoes.getColumnModel().getColumn(0).setPreferredWidth(150);
            jtbl_permissoes.getColumnModel().getColumn(1).setPreferredWidth(30);
            jtbl_permissoes.getColumnModel().getColumn(2).setPreferredWidth(30);
            jtbl_permissoes.getColumnModel().getColumn(3).setPreferredWidth(30);
            jtbl_permissoes.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Acessos"));
        jPanel2.setName("jPanel2"); // NOI18N

        jcb_interface.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_interface.setName("jcb_interface"); // NOI18N
        jcb_interface.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_interfaceActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel1.setText("Permissão:");
        jLabel1.setName("jLabel1"); // NOI18N

        jcb_ler.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_ler.setText("Consultar");
        jcb_ler.setName("jcb_ler"); // NOI18N
        jcb_ler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_lerActionPerformed(evt);
            }
        });

        jcb_escrever.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_escrever.setText("Salvar/Alterar");
        jcb_escrever.setName("jcb_escrever"); // NOI18N
        jcb_escrever.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_escreverActionPerformed(evt);
            }
        });

        jcb_deletar.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_deletar.setText("Deletar");
        jcb_deletar.setName("jcb_deletar"); // NOI18N
        jcb_deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_deletarActionPerformed(evt);
            }
        });

        jcb_super.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_super.setText("Super Usuário");
        jcb_super.setName("jcb_super"); // NOI18N
        jcb_super.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_superActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jcb_ler)
                        .addGap(10, 10, 10)
                        .addComponent(jcb_escrever)
                        .addGap(10, 10, 10)
                        .addComponent(jcb_deletar)
                        .addGap(10, 10, 10)
                        .addComponent(jcb_super))
                    .addComponent(jcb_interface, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(jcb_interface, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcb_ler)
                    .addComponent(jcb_escrever)
                    .addComponent(jcb_deletar)
                    .addComponent(jcb_super))
                .addGap(10, 10, 10))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel3.setName("jPanel3"); // NOI18N

        jb_cancelar.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/exit.png"))); // NOI18N
        jb_cancelar.setText("Sair");
        jb_cancelar.setMaximumSize(new java.awt.Dimension(101, 33));
        jb_cancelar.setName("jb_cancelar"); // NOI18N
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });

        jb_salvar.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jb_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/ok.png"))); // NOI18N
        jb_salvar.setText("Aplicar");
        jb_salvar.setName("jb_salvar"); // NOI18N
        jb_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_salvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jb_salvar)
                .addGap(6, 6, 6)
                .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jb_cancelar, jb_salvar});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jb_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jb_cancelar, jb_salvar});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        setSize(new java.awt.Dimension(485, 520));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        setVisible(false);
        janelapai.setStatusTela(true);
}//GEN-LAST:event_jb_cancelarActionPerformed

    private void jb_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salvarActionPerformed
        adicionarPermissao();
}//GEN-LAST:event_jb_salvarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        mostraUsuarios();
        mostraTodasPermissoes();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        setVisible(false);
        janelapai.setStatusTela(true);
    }//GEN-LAST:event_formWindowClosed

    private void jcb_escreverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_escreverActionPerformed
        if (jcb_escrever.isSelected()) {
            jcb_ler.setSelected(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_escreverActionPerformed

    private void jcb_deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_deletarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_deletarActionPerformed

    private void jcb_interfaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_interfaceActionPerformed
        checkBoxSelecionado();
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_interfaceActionPerformed

    private void jcb_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_usuarioActionPerformed
        permissaoSelecionado();
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_usuarioActionPerformed

    private void jcb_superActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_superActionPerformed
        if (jcb_super.isSelected()) {
            jcb_ler.setSelected(true);
            jcb_escrever.setSelected(true);
            jcb_deletar.setSelected(true);
            jcb_super.setSelected(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_superActionPerformed

    private void jcb_lerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_lerActionPerformed
        if (jcb_escrever.isSelected()) {
            jcb_ler.setSelected(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_lerActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AcessoInterface().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_salvar;
    private javax.swing.JCheckBox jcb_deletar;
    private javax.swing.JCheckBox jcb_escrever;
    private javax.swing.JComboBox jcb_interface;
    private javax.swing.JCheckBox jcb_ler;
    private javax.swing.JCheckBox jcb_super;
    private javax.swing.JComboBox jcb_usuario;
    private javax.swing.JTable jtbl_permissoes;
    private javax.swing.JTextArea tfa_similar;
    // End of variables declaration//GEN-END:variables

    public void setStatusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }

    public void mostraUsuarios() {
        pool = new Pool();
        UsuarioDAO usuarioDAO = new UsuarioDAO(pool);
        List<Usuario> usuarios;
        usuarios = usuarioDAO.getUsuarios();

        if (usuarios.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum usuário encontrado");

        } else {
            for (int i = 0; i < usuarios.size(); i++) {
                ItemDbGrid hashDbGrid = new ItemDbGrid(usuarios.get(i), (usuarios.get(i).getNome_usuario() + " - " + usuarios.get(i).getLogin()));
                jcb_usuario.addItem(hashDbGrid);

                AutoCompletion auto = new AutoCompletion(jcb_usuario);
            }

        }
    }

    public void mostraTodasPermissoes() {
        pool = new Pool();
        AcessoUsuarioDAO acessoUsuarioDAO = new AcessoUsuarioDAO(pool);
        List<InterfaceAcesso> interfaces;
        interfaces = acessoUsuarioDAO.getPermissoes();

        if (interfaces.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhuma interface encontrada");

        } else {
            for (int i = 0; i < interfaces.size(); i++) {
                ItemDbGrid hashDbGrid = new ItemDbGrid(interfaces.get(i), interfaces.get(i).getDescricao());
                jcb_interface.addItem(hashDbGrid);

                AutoCompletion auto = new AutoCompletion(jcb_interface);
            }

        }
    }

    public void checkBoxSelecionado() {

        pool = new Pool();
        AcessoUsuarioDAO acessoDAO = new AcessoUsuarioDAO(pool);

        Usuario usuario;

        ItemDbGrid hashDbGrid = (ItemDbGrid) jcb_usuario.getSelectedItem();
        usuario = (Usuario) hashDbGrid.getObjeto();
        acessos = new ArrayList<AcessoUsuario>();
        acessos = acessoDAO.getPermissaoUsuario(usuario);

        InterfaceAcesso inter = new InterfaceAcesso();

        ItemDbGrid hashDbGrid_Interface = (ItemDbGrid) jcb_interface.getSelectedItem();
        inter = (InterfaceAcesso) hashDbGrid_Interface.getObjeto();

        if (!acessos.isEmpty()) {
            for (int i = 0; i < acessos.size(); i++) {

                if (inter.getCodigo_interface().equals(acessos.get(i).getInterfaceAcesso().getCodigo_interface())) {
                    boolean ler;
                    boolean escrever;
                    boolean deletar;
                    boolean super_usuario;

                    ler = acessos.get(i).getLer() == 0;
                    escrever = acessos.get(i).getEscrever() == 0;
                    deletar = acessos.get(i).getDeletar() == 0;
                    super_usuario = acessos.get(i).getSuper_usuario() == 0;

                    jcb_ler.setSelected(ler);
                    jcb_escrever.setSelected(escrever);
                    jcb_deletar.setSelected(deletar);
                    jcb_super.setSelected(super_usuario);
                    break;
                } else {
                    jcb_ler.setSelected(true);
                    jcb_escrever.setSelected(true);
                    jcb_deletar.setSelected(false);
                    jcb_super.setSelected(false);
                }
            }
        }

    }

    public void permissaoSelecionado() {

        //Limpa tabela depois de selecionar novo cliente
        DefaultTableModel tb_locacao = (DefaultTableModel) jtbl_permissoes.getModel();
        int rows = tb_locacao.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            tb_locacao.removeRow(i);
        }

        pool = new Pool();
        AcessoUsuarioDAO acessoDAO = new AcessoUsuarioDAO(pool);

        Usuario usuario;

        List<AcessoUsuario> acessos = null;

        ItemDbGrid hashDbGrid = (ItemDbGrid) jcb_usuario.getSelectedItem();
        usuario = (Usuario) hashDbGrid.getObjeto();

        acessos = acessoDAO.getPermissaoUsuario(usuario);

        if (!acessos.isEmpty()) {
            for (int i = 0; i < acessos.size(); i++) {
                String ler;
                String escrever;
                String deletar;
                String super_usuario;

                if (acessos.get(i).getLer() == 0) {
                    ler = "X";
                } else {
                    ler = "";
                }

                if (acessos.get(i).getEscrever() == 0) {
                    escrever = "X";
                } else {
                    escrever = "";
                }

                if (acessos.get(i).getDeletar() == 0) {
                    deletar = "X";
                } else {
                    deletar = "";
                }

                if (acessos.get(i).getSuper_usuario() == 0) {
                    super_usuario = "X";
                } else {
                    super_usuario = "";
                }

                DefaultTableModel row = (DefaultTableModel) jtbl_permissoes.getModel();
                ItemDbGrid hashDbGridTb = new ItemDbGrid(acessos.get(i), acessos.get(i).getInterfaceAcesso().getDescricao());
                row.addRow(new Object[]{hashDbGridTb, ler, escrever, deletar, super_usuario});

            }
        } else {
            jcb_ler.setSelected(true);
            jcb_escrever.setSelected(true);
            jcb_deletar.setSelected(false);
            jcb_super.setSelected(false);
            JOptionPane.showMessageDialog(null, "Não tem acessos cadastrados");
        }

    }

    public void adicionarPermissao() {
        Usuario usuario;

        ItemDbGrid hashDbGridUsuario = (ItemDbGrid) jcb_usuario.getSelectedItem();
        usuario = (Usuario) hashDbGridUsuario.getObjeto();

        pool = new Pool();
        AcessoUsuarioDAO acessoDAO = new AcessoUsuarioDAO(pool);

        AcessoUsuario acessoUsuario = new AcessoUsuario();

        if (jcb_ler.isSelected() == true) {
            acessoUsuario.setLer(0);
        } else {
            acessoUsuario.setLer(1);
        }

        if (jcb_escrever.isSelected() == true) {
            acessoUsuario.setEscrever(0);
        } else {
            acessoUsuario.setEscrever(1);
        }

        if (jcb_deletar.isSelected() == true) {
            acessoUsuario.setDeletar(0);
        } else {
            acessoUsuario.setDeletar(1);
        }

        if (jcb_super.isSelected() == true) {
            acessoUsuario.setSuper_usuario(0);
        } else {
            acessoUsuario.setSuper_usuario(1);
        }

        InterfaceAcesso inter;// = new InterfaceAcesso();

        ItemDbGrid hashDbGrid = (ItemDbGrid) jcb_interface.getSelectedItem();
        inter = (InterfaceAcesso) hashDbGrid.getObjeto();

        acessoUsuario.setUsuario(usuario);
        acessoUsuario.setInterfaceAcesso(inter);

//        System.out.println(acessoUsuario.getCodigo_acesso());
        acessoUsuario = checarCadastroExistente(acessoUsuario);

        if (acessoUsuario.getCodigo_acesso() == null) {
            acessoDAO.salvar(acessoUsuario);
            permissaoSelecionado();
        } else {
            int selectedOption = JOptionPane.showConfirmDialog(this, "Permissão adicionada, Desejar atualizar?", "Atenção", JOptionPane.YES_NO_OPTION);
            if (selectedOption == JOptionPane.YES_NO_OPTION) {
                acessoDAO.atualizar(acessoUsuario);
                permissaoSelecionado();
                checkBoxSelecionado();
            }
        }

    }

    public AcessoUsuario checarCadastroExistente(AcessoUsuario acessoUsuario) {
        boolean tabela = false;

        if (jtbl_permissoes.getRowCount() == 0) {
            tabela = false;
        } else {
            for (int i = 0; i < jtbl_permissoes.getRowCount(); i++) {
                tabela = acessoUsuario.getInterfaceAcesso().getDescricao().equals(jtbl_permissoes.getValueAt(i, 0).toString());
                System.out.println("Index: " + i + " Size: " + jtbl_permissoes.getRowCount() + " Valor: " + jtbl_permissoes.getValueAt(i, 0).toString());
                if (tabela == true) {
                    acessoUsuario.setCodigo_acesso(acessos.get(i).getCodigo_acesso());
                    break;
                }
            }

        }

        return acessoUsuario;
    }

}
