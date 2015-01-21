/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Cad_Fornecedor.java
 *
 * Created on 06/04/2011, 16:41:51
 */
package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.dao.FornecedorDAO;
import br.com.locadora.model.bean.Fornecedor;
import br.com.locadora.model.dao.UsuarioDAO;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.TemaInterface;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alencar
 */
public class MenuFornecedor extends javax.swing.JFrame {

    public TelaPrincipal janelapai;
    public static AcessoUsuario acesso = new AcessoUsuario();
    public InterfacePool pool;
    public CadastraAlteraFornecedor cadastra_altera_fornecedor;
    public FornecedorDAO fornecedorDAO;
    public List<Fornecedor> fornecedores;

    /**
     * Creates new form Cad_Fornecedor
     */
    public MenuFornecedor() {
        initComponents();
        TemaInterface.getInterface(this);
        cadastra_altera_fornecedor = null;
        getFornecedores();
    }

    String tipoCadastro;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_fornecedor = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jl_pesquisar = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jrb_codigo = new javax.swing.JRadioButton();
        jrb_descricao = new javax.swing.JRadioButton();
        jtf_pesquisar = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jb_novo = new javax.swing.JButton();
        jb_alterar = new javax.swing.JButton();
        jb_excluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciamento de Fornecedores");
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

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jtbl_fornecedor.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtbl_fornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome Fantasia", "CNPJ", "Vendedor", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jtbl_fornecedor.setName("jtbl_fornecedor"); // NOI18N
        jtbl_fornecedor.getTableHeader().setReorderingAllowed(false);
        jtbl_fornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_fornecedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbl_fornecedor);
        if (jtbl_fornecedor.getColumnModel().getColumnCount() > 0) {
            jtbl_fornecedor.getColumnModel().getColumn(0).setPreferredWidth(10);
            jtbl_fornecedor.getColumnModel().getColumn(1).setPreferredWidth(300);
            jtbl_fornecedor.getColumnModel().getColumn(2).setPreferredWidth(50);
            jtbl_fornecedor.getColumnModel().getColumn(3).setPreferredWidth(50);
            jtbl_fornecedor.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta Fornecedor"));
        jPanel3.setName("jPanel3"); // NOI18N

        jl_pesquisar.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jl_pesquisar.setText("Parâmetro");
        jl_pesquisar.setName("jl_pesquisar"); // NOI18N

        jButton1.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pesquisar.png"))); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrb_codigo);
        jrb_codigo.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jrb_codigo.setText("Código");
        jrb_codigo.setName("jrb_codigo"); // NOI18N

        buttonGroup1.add(jrb_descricao);
        jrb_descricao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jrb_descricao.setSelected(true);
        jrb_descricao.setText("Nome Fantasia");
        jrb_descricao.setName("jrb_descricao"); // NOI18N

        jtf_pesquisar.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jtf_pesquisar.setName("jtf_pesquisar"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jrb_descricao)
                        .addGap(10, 10, 10)
                        .addComponent(jrb_codigo))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jl_pesquisar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jtf_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton1)))
                .addGap(10, 10, 10))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrb_descricao)
                    .addComponent(jrb_codigo))
                .addGap(10, 10, 10)
                .addComponent(jl_pesquisar)
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(10, 10, 10))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jtf_pesquisar});

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

        jb_alterar.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jb_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/alterar_registro.gif"))); // NOI18N
        jb_alterar.setText("Alterar");
        jb_alterar.setName("jb_alterar"); // NOI18N
        jb_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_alterarActionPerformed(evt);
            }
        });
        jPanel1.add(jb_alterar, new java.awt.GridBagConstraints());

        jb_excluir.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jb_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/delete.gif"))); // NOI18N
        jb_excluir.setText("Excluir");
        jb_excluir.setName("jb_excluir"); // NOI18N
        jb_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_excluirActionPerformed(evt);
            }
        });
        jPanel1.add(jb_excluir, new java.awt.GridBagConstraints());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/BROADWAY-LOGIN.png"))); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtf_pesquisar.requestFocus();

    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jrb_codigo.isSelected() == true) {
            getFornecedorCodigo();
        } else if (jrb_descricao.isSelected() == true) {
            getFornecededorNomeFantasia();
        } else {
            getFornecedores();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jb_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_novoActionPerformed
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuFornecedor");
        try {
            if (acesso.getEscrever() == true) {
                CadastraAlteraFornecedor cadastroFornecedor = new CadastraAlteraFornecedor();
                cadastroFornecedor.janelapai = this;
                cadastroFornecedor.setVisible(true);
                setStatusTela(false);
                cadastroFornecedor.acesso = acesso;
            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }

}//GEN-LAST:event_jb_novoActionPerformed

    private void jb_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_alterarActionPerformed
        alterar();

}//GEN-LAST:event_jb_alterarActionPerformed

    private void jb_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_excluirActionPerformed
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuFornecedor");
        try {
            if (acesso.getEscrever() == true) {
                excluiFornecedor();
            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jb_excluirActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        setVisible(false);
        janelapai.setStatusTela(true);
    }//GEN-LAST:event_formWindowClosed

    private void jtbl_fornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_fornecedorMouseClicked
        if (evt.getClickCount() == 2) {
            alterar();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_fornecedorMouseClicked

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
                new MenuFornecedor().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_alterar;
    private javax.swing.JButton jb_excluir;
    private javax.swing.JButton jb_novo;
    private javax.swing.JLabel jl_pesquisar;
    private javax.swing.JRadioButton jrb_codigo;
    private javax.swing.JRadioButton jrb_descricao;
    private javax.swing.JTable jtbl_fornecedor;
    private javax.swing.JTextField jtf_pesquisar;
    // End of variables declaration//GEN-END:variables

    public void request() {
        jtf_pesquisar.requestFocus();
    }

    public void getFornecedores() {
        pool = new Pool();
        fornecedorDAO = new FornecedorDAO(pool);
        fornecedores = fornecedorDAO.getFornecedores();
        mostraForncedor(fornecedores);
    }

    private void getFornecedorCodigo() {
        pool = new Pool();
        fornecedorDAO = new FornecedorDAO(pool);
        fornecedores = fornecedorDAO.getFornecedorCodigo(Integer.parseInt(jtf_pesquisar.getText().trim()));
        mostraForncedor(fornecedores);
    }

    public void getFornecededorNomeFantasia() {
        pool = new Pool();
        fornecedorDAO = new FornecedorDAO(pool);
        fornecedores = fornecedorDAO.getFornecedorNomeFantasia(jtf_pesquisar.getText().trim() + "%");
        mostraForncedor(fornecedores);
    }

    public void mostraForncedor(List<Fornecedor> fornecedores) {
        DefaultTableModel tableModel = (DefaultTableModel) jtbl_fornecedor.getModel();
        tableModel.setNumRows(0);

        if (fornecedores.size() == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum fornecedor encontrado");

        } else {

            for (int i = 0; i < fornecedores.size(); i++) {

                DefaultTableModel row = (DefaultTableModel) jtbl_fornecedor.getModel();
//                ItemDbGrid hashDbGrid = new ItemDbGrid(cliente, cliente.getNome_cliente());
                row.addRow(new Object[]{fornecedores.get(i).getCodigo_fornecedor(), fornecedores.get(i).getNome_fantasia(), fornecedores.get(i).getCnpj(),
                    fornecedores.get(i).getNome_vendedor(), fornecedores.get(i).getTelefone()});

            }
        }

    }

    public Fornecedor tbFornecedorLinhaSelecionada(JTable tb) {

        if (tb.getSelectedRow() != -1) {
            fornecedor = new Fornecedor();
            fornecedor = fornecedores.get(tb.getSelectedRow());
        } else {
            fornecedor = null;
        }
        return fornecedor;
    }

    private void excluiFornecedor() {
        removeFornecedor(jtbl_fornecedor);

    }
    Fornecedor fornecedor = new Fornecedor();

    public Fornecedor removeFornecedor(JTable tb) {
        if (tb.getSelectedRow() != -1) {
            int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
            if (selectedOption == JOptionPane.YES_NO_OPTION) {
                DefaultTableModel row = (DefaultTableModel) jtbl_fornecedor.getModel();
                pool = new Pool();
                fornecedorDAO = new FornecedorDAO(pool);
                fornecedor.setCodigo_fornecedor(fornecedores.get(tb.getSelectedRow()).getCodigo_fornecedor());
                try {
                    fornecedorDAO.excluir(fornecedor.getCodigo_fornecedor());
                    row.removeRow(jtbl_fornecedor.getSelectedRow());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Este registro não pode ser excluído pois está referenciado em outra tabela");
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um destino");
        }
        return fornecedor;
    }

    public void setStatusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }

    private void alterar() {
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuFornecedor");
        try {
            if (acesso.getLer() == true || acesso.getEscrever() == true) {
                Fornecedor forn = tbFornecedorLinhaSelecionada(jtbl_fornecedor);
                if (forn != null) {
                    if (cadastra_altera_fornecedor == null) {
                        cadastra_altera_fornecedor = new CadastraAlteraFornecedor(forn);
                        cadastra_altera_fornecedor.janelapai = this;
                        cadastra_altera_fornecedor.setVisible(true);
                        setEnabled(false);
                    } else {
                        cadastra_altera_fornecedor.setVisible(true);
                    }
                } else {

                    JOptionPane.showMessageDialog(null, "Selecione um fornecedor");
                    jtf_pesquisar.requestFocus();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }
    }

    public void acionarAtalho(java.awt.event.KeyEvent evt) {

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            setVisible(false);
            janelapai.setStatusTela(true);
        }

        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            jtf_pesquisar.requestFocus();
        }
    }
}
