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

import br.com.locadora.controller.SiscomController;
import br.com.locadora.model.bean.Genero;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALENCAR
 */
public class MenuGenero extends javax.swing.JFrame {

    public String tipoCadastro;
    public TelaPrincipal janelapai;
    public static List<Genero> generos;
    private TelaPrincipal_Interface telaPrincipal;
    public SiscomController controller;
    public Genero genero;

    /**
     * Creates new form DestinoGUI
     */
    public MenuGenero() {
        initComponents();
//        listarGenero();
    }
    DefaultTableModel tmDestino = new DefaultTableModel(null, new String[]{"Código", "Descrição"});
    ListSelectionModel lsmDestino;

//    public void setTela(String permissao) {
//        if (permissao.equals("usuario")) {
//            jb_novo.setEnabled(false);
//            jb_alterar.setEnabled(false);
//            jb_excluir.setEnabled(false);
//        } else {
//        }
//    }
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
        jrb_codigo = new javax.swing.JRadioButton();
        jrb_descricao = new javax.swing.JRadioButton();
        jl_pesquisar_destino = new javax.swing.JLabel();
        jb_buscar = new javax.swing.JButton();
        jtf_consulta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_genero = new javax.swing.JTable();
        jb_excluir = new javax.swing.JButton();
        jb_sair = new javax.swing.JButton();
        jb_novo = new javax.swing.JButton();
        jb_alterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciamento de Gênero");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultas"));
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(jrb_codigo);
        jrb_codigo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jrb_codigo.setSelected(true);
        jrb_codigo.setText("Código");
        jrb_codigo.setName("jrb_codigo"); // NOI18N
        jPanel1.add(jrb_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 24, -1, -1));

        buttonGroup1.add(jrb_descricao);
        jrb_descricao.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jrb_descricao.setText("Descrição");
        jrb_descricao.setName("jrb_descricao"); // NOI18N
        jPanel1.add(jrb_descricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 24, -1, -1));

        jl_pesquisar_destino.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jl_pesquisar_destino.setText("Parâmetro");
        jl_pesquisar_destino.setName("jl_pesquisar_destino"); // NOI18N
        jPanel1.add(jl_pesquisar_destino, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 64, -1, -1));

        jb_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pesquisar.png"))); // NOI18N
        jb_buscar.setName("jb_buscar"); // NOI18N
        jb_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_buscarActionPerformed(evt);
            }
        });
        jPanel1.add(jb_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, -1));

        jtf_consulta.setName("jtf_consulta"); // NOI18N
        jtf_consulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_consultaKeyPressed(evt);
            }
        });
        jPanel1.add(jtf_consulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 57, 340, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 490, 100));

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jtbl_genero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbl_genero.setUpdateSelectionOnSort(false);

        jtbl_genero.setVerifyInputWhenFocusTarget(false);
        jtbl_genero.setDefaultEditor(Object.class, null);
        jtbl_genero.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount() == 2){
                    alterar();
                }}});
                jtbl_genero.setDoubleBuffered(true);
                jtbl_genero.setDragEnabled(true);
                jtbl_genero.setName("jtbl_genero"); // NOI18N
                jtbl_genero.getTableHeader().setReorderingAllowed(false);
                jtbl_genero.setModel(tmDestino);
                jtbl_genero.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                lsmDestino = jtbl_genero.getSelectionModel();
                /*
                lsmDestino.addListSelectionListener(new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent e){
                        if (! e.getValueIsAdjusting()){
                            tbDestinoLinhaSelecionada(jtbl_genero);
                        }
                    }
                });*/
                jtbl_genero.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        jtbl_generoKeyPressed(evt);
                    }
                });
                jScrollPane1.setViewportView(jtbl_genero);
                if (jtbl_genero.getColumnModel().getColumnCount() > 0) {
                    jtbl_genero.getColumnModel().getColumn(0).setResizable(false);
                    jtbl_genero.getColumnModel().getColumn(0).setPreferredWidth(20);
                    jtbl_genero.getColumnModel().getColumn(1).setResizable(false);
                    jtbl_genero.getColumnModel().getColumn(1).setPreferredWidth(300);
                }

                getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 490, 150));

                jb_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/delete.gif"))); // NOI18N
                jb_excluir.setText("Excluir");
                jb_excluir.setName("jb_excluir"); // NOI18N
                jb_excluir.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_excluirActionPerformed(evt);
                    }
                });
                getContentPane().add(jb_excluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

                jb_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/exit.png"))); // NOI18N
                jb_sair.setText("Sair");
                jb_sair.setName("jb_sair"); // NOI18N
                jb_sair.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_sairActionPerformed(evt);
                    }
                });
                getContentPane().add(jb_sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, 33));

                jb_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/novo_registro.gif"))); // NOI18N
                jb_novo.setText("Novo");
                jb_novo.setName("jb_novo"); // NOI18N
                jb_novo.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_novoActionPerformed(evt);
                    }
                });
                getContentPane().add(jb_novo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

                jb_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/alterar_registro.gif"))); // NOI18N
                jb_alterar.setText("Alterar");
                jb_alterar.setName("jb_alterar"); // NOI18N
                jb_alterar.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_alterarActionPerformed(evt);
                    }
                });
                getContentPane().add(jb_alterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

                setSize(new java.awt.Dimension(561, 373));
                setLocationRelativeTo(null);
            }// </editor-fold>//GEN-END:initComponents

    private void jb_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_novoActionPerformed
        CadastroGenero des = new CadastroGenero();
        des.janelapai = this;
        des.setVisible(true);
//        this.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_novoActionPerformed

    private void jb_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_alterarActionPerformed
        alterar();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_alterarActionPerformed
    public void alterar() {
        Genero desti = tbDestinoLinhaSelecionada(jtbl_genero);
        if (desti != null) {
            AtualizaGenero generoAltera = new AtualizaGenero(desti);
            generoAltera.janelapai = this;
            generoAltera.setVisible(true);
            this.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um armazém");
            jtf_consulta.requestFocus();
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
        buscarDados();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_buscarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        setVisible(false);
        telaPrincipal.setStatusTela(true);
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void jtf_consultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_consultaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            listarGenero();
            jtbl_genero.addRowSelectionInterval(0, 0);
        }

    }//GEN-LAST:event_jtf_consultaKeyPressed

    private void jtbl_generoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_generoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Genero desti = tbDestinoLinhaSelecionada(jtbl_genero);
            if (desti != null) {
                AtualizaGenero generoAltera = new AtualizaGenero(desti);
                generoAltera.janelapai = this;
                generoAltera.setVisible(true);
            }

        }
    }//GEN-LAST:event_jtbl_generoKeyPressed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MenuGenero().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_alterar;
    private javax.swing.JButton jb_buscar;
    private javax.swing.JButton jb_excluir;
    private javax.swing.JButton jb_novo;
    private javax.swing.JButton jb_sair;
    private javax.swing.JLabel jl_pesquisar_destino;
    public static javax.swing.JRadioButton jrb_codigo;
    public static javax.swing.JRadioButton jrb_descricao;
    public static javax.swing.JTable jtbl_genero;
    public static javax.swing.JTextField jtf_consulta;
    // End of variables declaration//GEN-END:variables

    private void buscarDados() {
        controller = new SiscomController();
        controller.processarRequisicao("consultarGenero");
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

    public void request() {
        jtf_consulta.requestFocus();
        // TODO add your handling code here:
    }

    public Genero removeGenero(JTable tb) {
        if (tb.getSelectedRow() != -1) {
            int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
//            if (selectedOption == JOptionPane.YES_NO_OPTION) {
//                GeneroDAO generoControl = new GeneroDAO();
//                genero.setCodigo_genero(generos.get(tb.getSelectedRow()).getCodigo_genero());
//                if (generoControl.excluiDestino(genero)) {
//                    tmDestino.removeRow(tb.getSelectedRow());
//                }
//            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um armazém");
        }
        return genero;
    }

    public void excluiDestino() {
        removeGenero(jtbl_genero);
    }

    public void setTelaPrincipal(TelaPrincipal_Interface telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
    }
}
