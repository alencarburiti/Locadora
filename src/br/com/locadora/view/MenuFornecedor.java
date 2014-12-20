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
import br.com.locadora.model.bean.FornecedorModel;
import br.com.locadora.model.dao.UsuarioDAO;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.TemaInterface;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alencar
 */
public class MenuFornecedor extends javax.swing.JFrame {

    public TelaPrincipal janelapai;
    public static AcessoUsuario acesso = new AcessoUsuario();
    public InterfacePool pool;
    public AtualizaFornecedor atualizaFornecedor;

    /**
     * Creates new form Cad_Fornecedor
     */
    public MenuFornecedor() {
        initComponents();
        TemaInterface.getInterface(this);
        listarFornecedor();
        atualizaFornecedor = null;
    }
    
    List<FornecedorModel> fornecedores;
    DefaultTableModel tmFornecedor = new DefaultTableModel(null, new String[]{"CÓDIGO", "RAZÃO SOCIAL", "NOME FANTASIA", "ENDEREÇO",
        "CNPJ", "TELEFONE", "FAX", "VENDEDOR", "TELEFONE VENDEDOR"});
    ListSelectionModel lsmFornecedor;
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
        jt_pesquisar = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jl_pesquisar = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jrb_codigo = new javax.swing.JRadioButton();
        jrb_descricao = new javax.swing.JRadioButton();
        jrb_detalhamento = new javax.swing.JRadioButton();
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

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jt_pesquisar.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jt_pesquisar.setModel(tmFornecedor);
        jt_pesquisar.setName("jt_pesquisar"); // NOI18N
        jt_pesquisar.getTableHeader().setReorderingAllowed(false);
        jt_pesquisar.setModel(tmFornecedor);
        jt_pesquisar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmFornecedor = jt_pesquisar.getSelectionModel();
        lsmFornecedor.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e){
                if (! e.getValueIsAdjusting()){
                    tbFornecedorLinhaSelecionada(jt_pesquisar);
                }
            }
        });
        jt_pesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jt_pesquisarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jt_pesquisar);

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
        jrb_codigo.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jrb_codigo.setText("Código");
        jrb_codigo.setName("jrb_codigo"); // NOI18N

        buttonGroup1.add(jrb_descricao);
        jrb_descricao.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jrb_descricao.setSelected(true);
        jrb_descricao.setText("Descrição");
        jrb_descricao.setName("jrb_descricao"); // NOI18N

        buttonGroup1.add(jrb_detalhamento);
        jrb_detalhamento.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jrb_detalhamento.setText("Específica");
        jrb_detalhamento.setName("jrb_detalhamento"); // NOI18N

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
                        .addComponent(jrb_detalhamento)
                        .addGap(11, 11, 11)
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
                    .addComponent(jrb_detalhamento)
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
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
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
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtf_pesquisar.requestFocus();

        jt_pesquisar.getColumnModel().getColumn(0).setMaxWidth(70);
        jt_pesquisar.getColumnModel().getColumn(0).setMinWidth(70);
        jt_pesquisar.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(70);
        jt_pesquisar.getTableHeader().getColumnModel().getColumn(0).setMinWidth(70);

        jt_pesquisar.getColumnModel().getColumn(1).setMaxWidth(230);
        jt_pesquisar.getColumnModel().getColumn(1).setMinWidth(230);
        jt_pesquisar.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(230);
        jt_pesquisar.getTableHeader().getColumnModel().getColumn(1).setMinWidth(230);

        jt_pesquisar.getColumnModel().getColumn(2).setMaxWidth(200);
        jt_pesquisar.getColumnModel().getColumn(2).setMinWidth(200);
        jt_pesquisar.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(200);
        jt_pesquisar.getTableHeader().getColumnModel().getColumn(2).setMinWidth(200);

        jt_pesquisar.getColumnModel().getColumn(3).setMaxWidth(150);
        jt_pesquisar.getColumnModel().getColumn(3).setMinWidth(150);
        jt_pesquisar.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(150);
        jt_pesquisar.getTableHeader().getColumnModel().getColumn(3).setMinWidth(150);

        jt_pesquisar.getColumnModel().getColumn(4).setMaxWidth(120);
        jt_pesquisar.getColumnModel().getColumn(4).setMinWidth(120);
        jt_pesquisar.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(120);
        jt_pesquisar.getTableHeader().getColumnModel().getColumn(4).setMinWidth(120);

        jt_pesquisar.getColumnModel().getColumn(5).setMaxWidth(100);
        jt_pesquisar.getColumnModel().getColumn(5).setMinWidth(100);
        jt_pesquisar.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(100);
        jt_pesquisar.getTableHeader().getColumnModel().getColumn(5).setMinWidth(100);

        jt_pesquisar.getColumnModel().getColumn(6).setMaxWidth(100);
        jt_pesquisar.getColumnModel().getColumn(6).setMinWidth(100);
        jt_pesquisar.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(100);
        jt_pesquisar.getTableHeader().getColumnModel().getColumn(6).setMinWidth(100);

        jt_pesquisar.getColumnModel().getColumn(7).setMaxWidth(100);
        jt_pesquisar.getColumnModel().getColumn(7).setMinWidth(100);
        jt_pesquisar.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(100);
        jt_pesquisar.getTableHeader().getColumnModel().getColumn(7).setMinWidth(100);

    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jrb_codigo.isSelected() == true) {
            listarFornecedorCodigo();
        } else if (jrb_descricao.isSelected() == true) {
            listarFornecedorDescricao();
        } else if (jrb_detalhamento.isSelected() == true) {
            listarFornecedor();
        } else {
            listarFornecedor();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jb_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_novoActionPerformed
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuFornecedor");
        try {
            if (acesso.getEscrever() == 0) {
                CadastroFornecedor cadastroFornecedor = new CadastroFornecedor();
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
        excluiFornecedor();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_excluirActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        setVisible(false);
        janelapai.setStatusTela(true);
    }//GEN-LAST:event_formWindowClosed

    private void jt_pesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt_pesquisarMouseClicked
if(evt.getClickCount() == 2){
     alterar();
}
        // TODO add your handling code here:
    }//GEN-LAST:event_jt_pesquisarMouseClicked

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
    private javax.swing.JRadioButton jrb_detalhamento;
    private javax.swing.JTable jt_pesquisar;
    private javax.swing.JTextField jtf_pesquisar;
    // End of variables declaration//GEN-END:variables

    public void request() {
        jtf_pesquisar.requestFocus();
    }

    public void listarFornecedor() {
        FornecedorDAO forn = new FornecedorDAO();
        fornecedores = forn.listarForncedor("%" + jtf_pesquisar.getText().trim() + "%");
        mostraForncedor(fornecedores);
    }

    private void listarFornecedorCodigo() {
        FornecedorDAO forn = new FornecedorDAO();
        fornecedores = forn.listarForncedorCodigo(jtf_pesquisar.getText().trim());
        mostraForncedor(fornecedores);
    }

    private void listarFornecedorDescricao() {
        FornecedorDAO forn = new FornecedorDAO();
        fornecedores = forn.listarForncedorDescricao(jtf_pesquisar.getText().trim() + "%");
        mostraForncedor(fornecedores);
    }

    public void mostraForncedor(List<FornecedorModel> fornecedor) {
        while (tmFornecedor.getRowCount() > 0) {
            tmFornecedor.removeRow(0);
        }

        if (fornecedor.size() == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum fornecedor encontrado");

        } else {

            String[] campos = new String[]{null, null};
            for (int i = 0; i < fornecedor.size(); i++) {

                tmFornecedor.addRow(campos);

                jt_pesquisar.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//comando para criar a barra de rolagem

                tmFornecedor.setValueAt(fornecedor.get(i).getCod_fornecedor(), i, 0);
                tmFornecedor.setValueAt(fornecedor.get(i).getRazao_social(), i, 1);
                tmFornecedor.setValueAt(fornecedor.get(i).getNome_fantasia(), i, 2);
                tmFornecedor.setValueAt(fornecedor.get(i).getEndereço(), i, 3);
                tmFornecedor.setValueAt(fornecedor.get(i).getCNPJ(), i, 4);
                tmFornecedor.setValueAt(fornecedor.get(i).getTelefone(), i, 5);
                tmFornecedor.setValueAt(fornecedor.get(i).getFax(), i, 6);
                tmFornecedor.setValueAt(fornecedor.get(i).getNome_vendedor(), i, 7);
                tmFornecedor.setValueAt(fornecedor.get(i).getTel_vendedor(), i, 8);

            }
        }

    }

    public FornecedorModel tbFornecedorLinhaSelecionada(JTable tb) {

        if (tb.getSelectedRow() != -1) {
            fornecedor = new FornecedorModel();
            fornecedor.setCod_fornecedor(fornecedores.get(tb.getSelectedRow()).getCod_fornecedor());
            fornecedor.setRazao_social(fornecedores.get(tb.getSelectedRow()).getRazao_social());
            fornecedor.setNome_fantasia(fornecedores.get(tb.getSelectedRow()).getNome_fantasia());
            fornecedor.setEndereço(fornecedores.get(tb.getSelectedRow()).getEndereço());
            fornecedor.setCNPJ(fornecedores.get(tb.getSelectedRow()).getCNPJ());
            fornecedor.setTelefone(fornecedores.get(tb.getSelectedRow()).getTelefone());
            fornecedor.setFax(fornecedores.get(tb.getSelectedRow()).getFax());
            fornecedor.setCidade(fornecedores.get(tb.getSelectedRow()).getCidade());
            fornecedor.setCEP(fornecedores.get(tb.getSelectedRow()).getCEP());
            fornecedor.setEstado(fornecedores.get(tb.getSelectedRow()).getEstado());
            fornecedor.setInsc_municipal(fornecedores.get(tb.getSelectedRow()).getInsc_municipal());
            fornecedor.setInsc_estadual(fornecedores.get(tb.getSelectedRow()).getInsc_estadual());
            fornecedor.setNome_vendedor(fornecedores.get(tb.getSelectedRow()).getNome_vendedor());
            fornecedor.setTel_vendedor(fornecedores.get(tb.getSelectedRow()).getTel_vendedor());
        } else {
            fornecedor = null;
        }
        return fornecedor;
    }

    private void excluiFornecedor() {
        removeFornecedor(jt_pesquisar);

    }
    FornecedorModel fornecedor = new FornecedorModel();

    public FornecedorModel removeFornecedor(JTable tb) {
        if (tb.getSelectedRow() != -1) {
            int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
            if (selectedOption == JOptionPane.YES_NO_OPTION) {
                FornecedorDAO fornecedorControl = new FornecedorDAO();
                fornecedor.setCod_fornecedor(fornecedores.get(tb.getSelectedRow()).getCod_fornecedor());
                if (fornecedorControl.excluiFornecedor(fornecedor)) {
                    tmFornecedor.removeRow(tb.getSelectedRow());
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
            if (acesso.getLer() == 0 || acesso.getEscrever() == 0) {
                FornecedorModel forn = tbFornecedorLinhaSelecionada(jt_pesquisar);
                if (forn != null) {
                    if(atualizaFornecedor == null){
                        atualizaFornecedor = new AtualizaFornecedor(forn);
                        atualizaFornecedor.janelapai = this;
                        atualizaFornecedor.setVisible(true);
                        setEnabled(false);
                    } else {
                        atualizaFornecedor.setVisible(true);
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
}
