/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MenuDiaria.java
 *
 * Created on 02/06/2011, 00:56:52
 */
package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.controller.SiscomController;
import br.com.locadora.model.bean.Diaria;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author ALENCAR
 */
public class MenuMidia extends javax.swing.JFrame {

    public String tipoCadastro;
    public TelaPrincipal janelapai;
    public static List<Diaria> diarias;
    private TelaPrincipal_Interface telaPrincipal;
    public InterfacePool pool;
    public SiscomController controller;
    public Diaria diaria;

    /**
     * Creates new form DiariaGUI
     */
    public MenuMidia() {
        initComponents();
//        listarDiaria();
    }

    public void setTela(String permissao) {
        if (permissao.equals("usuario")) {
            jb_novo.setEnabled(false);
            jb_alterar.setEnabled(false);
            jb_excluir.setEnabled(false);
        } else {
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
        jrb_codigo_diaria = new javax.swing.JRadioButton();
        jrb_descricao = new javax.swing.JRadioButton();
        jl_pesquisar_destino = new javax.swing.JLabel();
        jb_buscar = new javax.swing.JButton();
        jtf_consulta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_diaria = new javax.swing.JTable();
        jb_excluir = new javax.swing.JButton();
        jb_sair = new javax.swing.JButton();
        jb_novo = new javax.swing.JButton();
        jb_alterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciamento de Diárias");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta Diária"));
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(jrb_codigo_diaria);
        jrb_codigo_diaria.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jrb_codigo_diaria.setText("Código");
        jrb_codigo_diaria.setName("jrb_codigo_diaria"); // NOI18N
        jPanel1.add(jrb_codigo_diaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        buttonGroup1.add(jrb_descricao);
        jrb_descricao.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jrb_descricao.setSelected(true);
        jrb_descricao.setText("Descrição");
        jrb_descricao.setName("jrb_descricao"); // NOI18N
        jPanel1.add(jrb_descricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jl_pesquisar_destino.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jl_pesquisar_destino.setText("Parâmetro");
        jl_pesquisar_destino.setName("jl_pesquisar_destino"); // NOI18N
        jPanel1.add(jl_pesquisar_destino, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jb_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pesquisar.png"))); // NOI18N
        jb_buscar.setName("jb_buscar"); // NOI18N
        jb_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_buscarActionPerformed(evt);
            }
        });
        jPanel1.add(jb_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, -1, -1));

        jtf_consulta.setName("jtf_consulta"); // NOI18N
        jtf_consulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_consultaKeyPressed(evt);
            }
        });
        jPanel1.add(jtf_consulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 520, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 70, 660, 100));

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jtbl_diaria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Valor", "Dias", "Multa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
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
        jtbl_diaria.setUpdateSelectionOnSort(false);

        jtbl_diaria.setVerifyInputWhenFocusTarget(false);
        jtbl_diaria.setDefaultEditor(Object.class, null);
        jtbl_diaria.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount() == 2){
                    alterar();
                }}});
                jtbl_diaria.setDoubleBuffered(true);
                jtbl_diaria.setDragEnabled(true);
                jtbl_diaria.setName("jtbl_diaria"); // NOI18N
                jtbl_diaria.getTableHeader().setReorderingAllowed(false);
                jtbl_diaria.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        jtbl_diariaKeyPressed(evt);
                    }
                });
                jScrollPane1.setViewportView(jtbl_diaria);
                if (jtbl_diaria.getColumnModel().getColumnCount() > 0) {
                    jtbl_diaria.getColumnModel().getColumn(0).setPreferredWidth(10);
                    jtbl_diaria.getColumnModel().getColumn(1).setPreferredWidth(200);
                    jtbl_diaria.getColumnModel().getColumn(2).setPreferredWidth(30);
                    jtbl_diaria.getColumnModel().getColumn(3).setPreferredWidth(20);
                    jtbl_diaria.getColumnModel().getColumn(4).setPreferredWidth(30);
                }

                getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 183, 660, 190));

                jb_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/delete.gif"))); // NOI18N
                jb_excluir.setText("Excluir");
                jb_excluir.setName("jb_excluir"); // NOI18N
                jb_excluir.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_excluirActionPerformed(evt);
                    }
                });
                getContentPane().add(jb_excluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));

                jb_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/exit.png"))); // NOI18N
                jb_sair.setText("Sair");
                jb_sair.setName("jb_sair"); // NOI18N
                jb_sair.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_sairActionPerformed(evt);
                    }
                });
                getContentPane().add(jb_sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, -1, 33));

                jb_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/novo_registro.gif"))); // NOI18N
                jb_novo.setText("Novo");
                jb_novo.setName("jb_novo"); // NOI18N
                jb_novo.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_novoActionPerformed(evt);
                    }
                });
                getContentPane().add(jb_novo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

                jb_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/alterar_registro.gif"))); // NOI18N
                jb_alterar.setText("Alterar");
                jb_alterar.setName("jb_alterar"); // NOI18N
                jb_alterar.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_alterarActionPerformed(evt);
                    }
                });
                getContentPane().add(jb_alterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, -1, -1));

                setSize(new java.awt.Dimension(720, 424));
                setLocationRelativeTo(null);
            }// </editor-fold>//GEN-END:initComponents

    private void jb_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_novoActionPerformed
        CadastroDiaria des = new CadastroDiaria();
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
        Diaria desti = tbDiariaLinhaSelecionada(jtbl_diaria);
        if (desti != null) {
            AtualizaDiaria diariaAltera = new AtualizaDiaria(desti);
            diariaAltera.janelapai = this;
            diariaAltera.setVisible(true);
            this.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um armazém");
            jtf_consulta.requestFocus();
        }
    }
    private void jb_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_excluirActionPerformed
        excluiDiaria();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_excluirActionPerformed

    private void jb_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_sairActionPerformed
        setVisible(false);
        telaPrincipal.setStatusTela(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_sairActionPerformed

    private void jb_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_buscarActionPerformed
        enviaDados();
    }//GEN-LAST:event_jb_buscarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        setVisible(false);
        telaPrincipal.setStatusTela(true);
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jtf_consultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_consultaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtbl_diaria.addRowSelectionInterval(0, 0);
        }

    }//GEN-LAST:event_jtf_consultaKeyPressed

    private void jtbl_diariaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_diariaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Diaria desti = tbDiariaLinhaSelecionada(jtbl_diaria);
            if (desti != null) {
                AtualizaDiaria diariaAltera = new AtualizaDiaria(desti);
                diariaAltera.janelapai = this;
                diariaAltera.setVisible(true);
            }

        }
    }//GEN-LAST:event_jtbl_diariaKeyPressed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MenuMidia().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_alterar;
    public static javax.swing.JButton jb_buscar;
    private javax.swing.JButton jb_excluir;
    private javax.swing.JButton jb_novo;
    private javax.swing.JButton jb_sair;
    private javax.swing.JLabel jl_pesquisar_destino;
    public static javax.swing.JRadioButton jrb_codigo_diaria;
    public static javax.swing.JRadioButton jrb_descricao;
    public static javax.swing.JTable jtbl_diaria;
    public static javax.swing.JTextField jtf_consulta;
    // End of variables declaration//GEN-END:variables

    public void setTelaPrincipal(TelaPrincipal_Interface telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
    }

    private void enviaDados() {
        controller = new SiscomController();
        controller.processarRequisicao("consultarDiaria");
    }

    public Diaria tbDiariaLinhaSelecionada(JTable tb) {
        Diaria dest = null;
        if (tb.getSelectedRow() != -1) {
            dest = new Diaria();
            dest.setCodigo_diaria(diarias.get(tb.getSelectedRow()).getCodigo_diaria());
            dest.setNome_diaria(diarias.get(tb.getSelectedRow()).getNome_diaria());

        }
        return dest;
    }

    public void request() {
        jtf_consulta.requestFocus();
        // TODO add your handling code here:
    }

    public Diaria removeDiaria(JTable tb) {
//        if (tb.getSelectedRow() != -1) {
//            int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
//            if (selectedOption == JOptionPane.YES_NO_OPTION) {
//                DiariaDAO diariaControl = new DiariaDAO();
//                diaria.setCodigo_diaria(diarias.get(tb.getSelectedRow()).getCodigo_diaria());
//                if (diariaControl.excluirDiaria(diaria)) {
//                    tmDiaria.removeRow(tb.getSelectedRow());
//                }
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "Selecione um armazém");
//        }
        return diaria;
    }

    public void excluiDiaria() {
        removeDiaria(jtbl_diaria);
    }

}