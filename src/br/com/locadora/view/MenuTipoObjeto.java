/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MenuGenero.java
 *
 * Created on 02/06/2011, 00:56:52
 */
package br.com.locadora.view;

import br.com.locadora.model.dao.GeneroDAO;
import br.com.locadora.model.bean.Genero;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALENCAR
 */
public class MenuTipoObjeto extends javax.swing.JFrame {

    String tipoCadastro;
    public TelaPrincipal janelapai;
    List<Genero> generos;

    /** Creates new form DestinoGUI */
    public MenuTipoObjeto() {
        initComponents();
        listarGenero();
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            // UIManager.setLookAndFeel("com.sun.java.swing.plaf.smoothmetal.SmoothmetalLookAndAndFeel");
            //UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
            //UIManager.setLookAndFeel(seta_look);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
    }
    DefaultTableModel tmDestino = new DefaultTableModel(null, new String[]{"Código", "Descrição"});
    ListSelectionModel lsmDestino;

    public void setTela(String permissao) {
        if (permissao.equals("usuario")) {
            jb_novo.setEnabled(false);
            jb_alterar.setEnabled(false);
            jb_excluir.setEnabled(false);
        } else {
        }
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
        jPanel1 = new javax.swing.JPanel();
        jrb_codigo = new javax.swing.JRadioButton();
        jrb_detalhado = new javax.swing.JRadioButton();
        jrb_descricao = new javax.swing.JRadioButton();
        jl_pesquisar_destino = new javax.swing.JLabel();
        jb_buscar = new javax.swing.JButton();
        jtf_pesquisar_genero = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_pesquisar = new javax.swing.JTable();
        jb_excluir = new javax.swing.JButton();
        jb_sair = new javax.swing.JButton();
        jb_novo = new javax.swing.JButton();
        jb_alterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciamento de Tipos de Gênero");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultas"));
        jPanel1.setName("jPanel1"); // NOI18N

        buttonGroup1.add(jrb_codigo);
        jrb_codigo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jrb_codigo.setSelected(true);
        jrb_codigo.setText("Código");
        jrb_codigo.setName("jrb_codigo"); // NOI18N

        buttonGroup1.add(jrb_detalhado);
        jrb_detalhado.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jrb_detalhado.setText("Específica");
        jrb_detalhado.setName("jrb_detalhado"); // NOI18N

        buttonGroup1.add(jrb_descricao);
        jrb_descricao.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jrb_descricao.setText("Descrição");
        jrb_descricao.setName("jrb_descricao"); // NOI18N

        jl_pesquisar_destino.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jl_pesquisar_destino.setText("Parâmetro");
        jl_pesquisar_destino.setName("jl_pesquisar_destino"); // NOI18N

        jb_buscar.setText("Ir");
        jb_buscar.setName("jb_buscar"); // NOI18N
        jb_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_buscarActionPerformed(evt);
            }
        });

        jtf_pesquisar_genero.setName("jtf_pesquisar_genero"); // NOI18N
        jtf_pesquisar_genero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_pesquisar_generoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jrb_codigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jrb_descricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jrb_detalhado))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jl_pesquisar_destino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtf_pesquisar_genero, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jb_buscar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrb_codigo)
                    .addComponent(jrb_descricao)
                    .addComponent(jrb_detalhado))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_pesquisar_destino)
                    .addComponent(jtf_pesquisar_genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_buscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jt_pesquisar.setModel(tmDestino);
        jt_pesquisar.setUpdateSelectionOnSort(false);

        jt_pesquisar.setVerifyInputWhenFocusTarget(false);
        jt_pesquisar.setDefaultEditor(Object.class, null);
        jt_pesquisar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount() == 2){
                    alterar();
                }}});
                jt_pesquisar.setDoubleBuffered(true);
                jt_pesquisar.setDragEnabled(true);
                jt_pesquisar.setName("jt_pesquisar"); // NOI18N
                jt_pesquisar.getTableHeader().setReorderingAllowed(false);
                jt_pesquisar.setModel(tmDestino);
                jt_pesquisar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                lsmDestino = jt_pesquisar.getSelectionModel();
                /*
                lsmDestino.addListSelectionListener(new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent e){
                        if (! e.getValueIsAdjusting()){
                            tbDestinoLinhaSelecionada(jt_pesquisar);
                        }
                    }
                });*/
                jt_pesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        jt_pesquisarKeyPressed(evt);
                    }
                });
                jScrollPane1.setViewportView(jt_pesquisar);

                jb_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/medicalpharm/image/delete.gif"))); // NOI18N
                jb_excluir.setText("Excluir");
                jb_excluir.setName("jb_excluir"); // NOI18N
                jb_excluir.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_excluirActionPerformed(evt);
                    }
                });

                jb_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/medicalpharm/image/exit.png"))); // NOI18N
                jb_sair.setText("Sair");
                jb_sair.setName("jb_sair"); // NOI18N
                jb_sair.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_sairActionPerformed(evt);
                    }
                });

                jb_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/medicalpharm/image/novo_registro.gif"))); // NOI18N
                jb_novo.setText("Novo");
                jb_novo.setName("jb_novo"); // NOI18N
                jb_novo.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_novoActionPerformed(evt);
                    }
                });

                jb_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/medicalpharm/image/alterar_registro.gif"))); // NOI18N
                jb_alterar.setText("Alterar");
                jb_alterar.setName("jb_alterar"); // NOI18N
                jb_alterar.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_alterarActionPerformed(evt);
                    }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(188, 188, 188)
                                .addComponent(jb_novo)
                                .addGap(5, 5, 5)
                                .addComponent(jb_alterar)
                                .addGap(5, 5, 5)
                                .addComponent(jb_excluir)
                                .addGap(5, 5, 5)
                                .addComponent(jb_sair)))
                        .addContainerGap(27, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jb_novo)
                            .addComponent(jb_alterar)
                            .addComponent(jb_excluir)
                            .addComponent(jb_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(29, Short.MAX_VALUE))
                );

                setSize(new java.awt.Dimension(616, 374));
                setLocationRelativeTo(null);
            }// </editor-fold>//GEN-END:initComponents

    private void jb_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_novoActionPerformed
        CadastroTipoObjeto cadastroTipoGenero = new CadastroTipoObjeto();
        cadastroTipoGenero.janelapai = this;
        cadastroTipoGenero.setVisible(true);
        this.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_novoActionPerformed

    private void jb_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_alterarActionPerformed
        alterar();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_alterarActionPerformed
    public void alterar() {
        Genero desti = tbDestinoLinhaSelecionada(jt_pesquisar);
        if (desti != null) {
            AtualizaGenero generoAltera = new AtualizaGenero(desti);
//            generoAltera.janelapai = this;
            generoAltera.setVisible(true);
            this.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um armazém");
            jtf_pesquisar_genero.requestFocus();
        }
    }
    private void jb_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_excluirActionPerformed
        excluiDestino();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_excluirActionPerformed

    private void jb_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_sairActionPerformed
        setVisible(false);
        telaPrincipal.setStatusTela(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_sairActionPerformed

    private void jb_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_buscarActionPerformed
        if (jrb_codigo.isSelected() == true) {
            listarGeneroCodigo();
        } else if (jrb_descricao.isSelected() == true) {
            listarGeneroDescricao();
        } else if (jrb_detalhado.isSelected() == true) {
            listarGenero();
        } else {
            listarGenero();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jb_buscarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        setVisible(false);
        telaPrincipal.setStatusTela(true);
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtf_pesquisar_genero.requestFocus();
        // TODO add your handling code here:

        jt_pesquisar.getColumnModel().getColumn(0).setMaxWidth(80);
        jt_pesquisar.getColumnModel().getColumn(0).setMinWidth(80);
        jt_pesquisar.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(80);
        jt_pesquisar.getTableHeader().getColumnModel().getColumn(0).setMinWidth(80);

        jt_pesquisar.getColumnModel().getColumn(1).setMaxWidth(520);
        jt_pesquisar.getColumnModel().getColumn(1).setMinWidth(520);
        jt_pesquisar.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(520);
        jt_pesquisar.getTableHeader().getColumnModel().getColumn(1).setMinWidth(520);
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jtf_pesquisar_generoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_pesquisar_generoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            listarGenero();
            jt_pesquisar.addRowSelectionInterval(0, 0);
        }

    }//GEN-LAST:event_jtf_pesquisar_generoKeyPressed

    private void jt_pesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_pesquisarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Genero desti = tbDestinoLinhaSelecionada(jt_pesquisar);
            if (desti != null) {
                AtualizaGenero generoAltera = new AtualizaGenero(desti);
//                generoAltera.janelapai = this;
                generoAltera.setVisible(true);
            }

        }
    }//GEN-LAST:event_jt_pesquisarKeyPressed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MenuTipoObjeto().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_alterar;
    private javax.swing.JButton jb_buscar;
    private javax.swing.JButton jb_excluir;
    private javax.swing.JButton jb_novo;
    private javax.swing.JButton jb_sair;
    private javax.swing.JLabel jl_pesquisar_destino;
    private javax.swing.JRadioButton jrb_codigo;
    private javax.swing.JRadioButton jrb_descricao;
    private javax.swing.JRadioButton jrb_detalhado;
    private javax.swing.JTable jt_pesquisar;
    private javax.swing.JTextField jtf_pesquisar_genero;
    // End of variables declaration//GEN-END:variables
    private TelaPrincipal_Interface telaPrincipal;
    //Recebendo tela como parametro para atualização apos pesquisa

    public void setTelaPrincipal(TelaPrincipal_Interface telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
    }

    public Genero tbDestinoLinhaSelecionada(JTable tb) {
        Genero dest = null;
        if (tb.getSelectedRow() != -1) {
            dest = new Genero();
            dest.setCodigo_genero(generos.get(tb.getSelectedRow()).getCodigo_genero());
            dest.setNome_genero(generos.get(tb.getSelectedRow()).getNome_genero());

        }
        return dest;
    }
    Genero genero = new Genero();

    public void request() {
        jtf_pesquisar_genero.requestFocus();
        // TODO add your handling code here:
    }

    public Genero removeGenero(JTable tb) {
        if (tb.getSelectedRow() != -1) {
            int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
            if (selectedOption == JOptionPane.YES_NO_OPTION) {
//                GeneroDAO generoControl = new GeneroDAO();
//                genero.setCodigo_genero(generos.get(tb.getSelectedRow()).getCodigo_genero());
//                if (generoControl.excluiDestino(genero)) {
//                    tmDestino.removeRow(tb.getSelectedRow());
//                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um armazém");
        }
        return genero;
    }

    public void excluiDestino() {
        removeGenero(jt_pesquisar);
    }

    public final void listarGenero() {
//        GeneroDAO dest = new GeneroDAO();
//        generos = dest.listarGenero("%" + jtf_pesquisar_genero.getText().trim() + "%");
//        mostraDestinos(generos);
    }

    private void listarGeneroCodigo() {
        if (jtf_pesquisar_genero.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe um código");
        } else {
//            GeneroDAO dest = new GeneroDAO();
//            generos = dest.listarGeneroCodigo(jtf_pesquisar_genero.getText().trim());
//            mostraDestinos(generos);
        }
    }

    private void listarGeneroDescricao() {
//        GeneroDAO dest = new GeneroDAO();
//        generos = dest.listarGeneroDescricao(jtf_pesquisar_genero.getText().trim() + "%");
//        mostraDestinos(generos);
    }

    public void mostraDestinos(List<Genero> genero) {
        while (tmDestino.getRowCount() > 0) {
            tmDestino.removeRow(0);
        }

        if (genero.size() == 0) {
            JOptionPane.showMessageDialog(this, "Nenhum armazém encontrado");

        } else {


            String[] campos = new String[]{null, null};
            for (int i = 0; i < genero.size(); i++) {//ou i<genero.size() para retornar todos

                tmDestino.addRow(campos);

                tmDestino.setValueAt(genero.get(i).getCodigo_genero(), i, 0);
                tmDestino.setValueAt(genero.get(i).getNome_genero(), i, 1);
            }
        }

    }
}
