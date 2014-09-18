/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConsultarProdutoGUI.java
 *
 * Created on 02/06/2011, 03:08:41
 */
package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.model.bean.Genero;
import br.com.locadora.model.dao.GeneroDAO;
import br.com.locadora.util.ItemDbGrid;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALENCAR
 */
public class ConsultaGeneroObjeto extends javax.swing.JFrame {

    CadastroObjeto janelapai;

    public ConsultaGeneroObjeto() {
        initComponents();
        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            // UIManager.setLookAndFeel("com.sun.java.swing.plaf.smoothmetal.SmoothmetalLookAndAndFeel");
            //UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
            //UIManager.setLookAndFeel(seta_look);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro);
        }

        janelapai = null;

    }
    List<Genero> generos;

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jb_cancelar = new javax.swing.JButton();
        jb_ok = new javax.swing.JButton();
        jb_novo1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_genero = new javax.swing.JTable();
        jtf_consulta = new javax.swing.JTextField();
        jb_buscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Consulta Gênero");
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

        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/exit.png"))); // NOI18N
        jb_cancelar.setText("Cancelar");
        jb_cancelar.setName("jb_cancelar"); // NOI18N
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 110, 40));

        jb_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/ok.png"))); // NOI18N
        jb_ok.setText("OK");
        jb_ok.setName("jb_ok"); // NOI18N
        jb_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_okActionPerformed(evt);
            }
        });
        getContentPane().add(jb_ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 80, 40));

        jb_novo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/novo_registro.gif"))); // NOI18N
        jb_novo1.setText("Novo");
        jb_novo1.setName("jb_novo1"); // NOI18N
        jb_novo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_novo1ActionPerformed(evt);
            }
        });
        getContentPane().add(jb_novo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 110, 40));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta Gênero"));
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jtbl_genero.setUpdateSelectionOnSort(false);
        jtbl_genero.setVerifyInputWhenFocusTarget(false);
        jtbl_genero.setDefaultEditor(Object.class, null);
        jtbl_genero.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount() == 2){
                    botaoOK(jtbl_genero);

                }}});
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
                jtbl_genero.setName("jtbl_genero"); // NOI18N
                jtbl_genero.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        jtbl_generoKeyPressed(evt);
                    }
                });
                jScrollPane1.setViewportView(jtbl_genero);
                if (jtbl_genero.getColumnModel().getColumnCount() > 0) {
                    jtbl_genero.getColumnModel().getColumn(0).setResizable(false);
                    jtbl_genero.getColumnModel().getColumn(0).setPreferredWidth(15);
                    jtbl_genero.getColumnModel().getColumn(1).setResizable(false);
                    jtbl_genero.getColumnModel().getColumn(1).setPreferredWidth(150);
                }

                jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 300, 200));

                jtf_consulta.setName("jtf_consulta"); // NOI18N
                jPanel1.add(jtf_consulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 270, -1));

                jb_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/ok.png"))); // NOI18N
                jb_buscar.setName("jb_buscar"); // NOI18N
                jb_buscar.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_buscarActionPerformed1(evt);
                    }
                });
                jPanel1.add(jb_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, -1));

                getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 360, 300));

                setSize(new java.awt.Dimension(415, 406));
                setLocationRelativeTo(null);
            }// </editor-fold>//GEN-END:initComponents

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        setVisible(false);
        if ((janelapai != null)) {
            janelapai.setEnabled(true);
            janelapai.setVisible(true);
            //telaCadastroObjeto.setStatusTela(false);
        }

}//GEN-LAST:event_jb_cancelarActionPerformed
    private CadastroObjeto_InterFace telaCadastroObjeto;

    private void jb_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_okActionPerformed
        if (jtbl_genero.getSelectedRow() == 1) {
            botaoOK(jtbl_genero);
        }
}//GEN-LAST:event_jb_okActionPerformed
    public void botaoOK(JTable tb) {
       if(tb.getSelectedRow() != -1){
        setVisible(false);
        Genero genero = tbGeneroLinhaSelecionada(jtbl_genero);
        if ((janelapai != null) && (genero != null)) {
            janelapai.setEnabled(true);
            janelapai.setVisible(true);
            telaCadastroObjeto.carregaGenero(genero);
            //telaCadastroObjeto.setStatusTela(false);
        }


//        if ((janelapai3 != null) && (genero != null)) {
//            janelapai3.setEnabled(true);
//            janelapai3.setVisible(true);
//            telaAjusteEstoque.carregaFornecedor(genero);
//            //telaSaidaEstoque.statusTela(true);        
//        }

    } else {
           JOptionPane.showMessageDialog(null, "Selecione um fornecedor");
       }
    }
           
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        setVisible(false);
        if ((janelapai != null)) {
            janelapai.setEnabled(true);
            janelapai.setVisible(true);
            //telaCadastroObjeto.setStatusTela(false);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void jb_novo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_novo1ActionPerformed
//        CadastroFornecedor forn;
//
//        forn = new CadastroFornecedor();
//        forn.janelapai2 = this;
//        forn.setVisible(true);
//        this.setEnabled(false);


        // TODO add your handling code here:
}//GEN-LAST:event_jb_novo1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        jt_pesquisar.getColumnModel().getColumn( 3 ).setMaxWidth( 60 );
//        jt_pesquisar.getColumnModel().getColumn( 3 ).setMinWidth( 60 );
//        jt_pesquisar.getTableHeader().getColumnModel().getColumn( 3 ).setMaxWidth( 60 );
//        jt_pesquisar.getTableHeader().getColumnModel().getColumn( 3 ).setMinWidth( 60 );
    }//GEN-LAST:event_formWindowOpened

private void jtbl_generoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_generoKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//        if(jTable1.getSelectedRow()== 1){                           
        botaoOK(jtbl_genero);
        //01  }
    }
    // TODO add your handling code here:
}//GEN-LAST:event_jtbl_generoKeyPressed

    private void jb_buscarActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_buscarActionPerformed1
        try {        
            listaGenero(jtf_consulta.getText().trim());
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaGeneroObjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jb_buscarActionPerformed1

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ConsultaGeneroObjeto().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_buscar;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_novo1;
    private javax.swing.JButton jb_ok;
    private javax.swing.JTable jtbl_genero;
    private javax.swing.JTextField jtf_consulta;
    // End of variables declaration//GEN-END:variables

    //Recebendo tela como parametro para atualização apos pesquisa
    public void setTelaCadastroObjeto(CadastroObjeto_InterFace telaCadastroObjeto) {
        this.telaCadastroObjeto = telaCadastroObjeto;
    }

    public void setCadastro() {
        jb_novo1.setEnabled(false);
    }

    public Genero tbGeneroLinhaSelecionada(JTable tb) {
        Genero genero = null;
        if (tb.getSelectedRow() != -1) {
            genero = new Genero();
            genero.setCodigo_genero(generos.get(tb.getSelectedRow()).getCodigo_genero());
            genero.setNome_genero(generos.get(tb.getSelectedRow()).getNome_genero());
        }
        return genero;
    }
    private InterfacePool pool;
    public void listaGenero(String consulta) throws SQLException {
        pool = new Pool();
        GeneroDAO generoDAO = new GeneroDAO(pool);
        generos = generoDAO.getGeneros("%" + jtf_consulta.getText().trim() + "%");
        mostraGenero(generos);
    }
    
    public void listaTodasGeneros() throws SQLException {
        pool = new Pool();
        GeneroDAO generoDAO = new GeneroDAO(pool);
        generos = generoDAO.getTodasGeneros();
        mostraGenero(generos);
    }

    public void mostraGenero(List<Genero> generos) {
        ((DefaultTableModel) jtbl_genero.getModel()).setRowCount(0);
        jtbl_genero.updateUI();

        if (generos.size() == 0) {
            JOptionPane.showMessageDialog(this, "Nenhuma genero encontrada");

        } else {
            for (int i = 0; i < generos.size(); i++) {
                Genero genero = new Genero();
                genero.setCodigo_genero(generos.get(i).getCodigo_genero());
                genero.setNome_genero(generos.get(i).getNome_genero());
                
                System.out.print(genero.getNome_genero());
                DefaultTableModel row = (DefaultTableModel) jtbl_genero.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(genero, genero.getNome_genero());
                row.addRow(new Object[]{genero.getCodigo_genero(), hashDbGrid});
            }
            jtbl_genero.setSelectionMode(1);
        }
    }
    
}
