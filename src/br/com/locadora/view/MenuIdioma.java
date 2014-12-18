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
import br.com.locadora.conexao.Pool;
import br.com.locadora.controller.SiscomController;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Idioma;
import br.com.locadora.model.dao.IdiomaDAO;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.TemaInterface;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALENCAR
 */
public class MenuIdioma extends javax.swing.JFrame {

    public String tipoCadastro;
    public TelaPrincipal janelapai;
    public InterfacePool pool;
    public SiscomController controller;
    public Idioma idioma;
    public List<Idioma> idiomas;
    AcessoUsuario acesso;

    /**
     * Creates new form DiariaGUI
     */
    public MenuIdioma() {
        initComponents();
        TemaInterface.getInterface(this);
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
        jl_pesquisar_destino = new javax.swing.JLabel();
        jb_buscar = new javax.swing.JButton();
        jtf_consulta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_idioma = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciamento de Idiomas");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta Idioma"));
        jPanel1.setName("jPanel1"); // NOI18N

        jl_pesquisar_destino.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jl_pesquisar_destino.setText("Parâmetro");
        jl_pesquisar_destino.setName("jl_pesquisar_destino"); // NOI18N

        jb_buscar.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jb_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pesquisar.png"))); // NOI18N
        jb_buscar.setName("jb_buscar"); // NOI18N
        jb_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_buscarActionPerformed(evt);
            }
        });

        jtf_consulta.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jtf_consulta.setName("jtf_consulta"); // NOI18N
        jtf_consulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_consultaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_pesquisar_destino)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtf_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jb_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jl_pesquisar_destino)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jb_buscar, jtf_consulta});

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jtbl_idioma.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtbl_idioma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
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
        jtbl_idioma.setDoubleBuffered(true);
        jtbl_idioma.setDragEnabled(true);
        jtbl_idioma.setName("jtbl_idioma"); // NOI18N
        jtbl_idioma.getTableHeader().setReorderingAllowed(false);
        jtbl_idioma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbl_idiomaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbl_idioma);
        if (jtbl_idioma.getColumnModel().getColumnCount() > 0) {
            jtbl_idioma.getColumnModel().getColumn(0).setPreferredWidth(10);
            jtbl_idioma.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jb_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_buscarActionPerformed
        consultaIdioma();
    }//GEN-LAST:event_jb_buscarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        setVisible(false);
        janelapai.setStatusTela(true);
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtf_consulta.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jtf_consultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_consultaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            consultaIdioma();
        }

    }//GEN-LAST:event_jtf_consultaKeyPressed

    private void jtbl_idiomaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_idiomaKeyPressed

    }//GEN-LAST:event_jtbl_idiomaKeyPressed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MenuIdioma().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JButton jb_buscar;
    private javax.swing.JLabel jl_pesquisar_destino;
    public static javax.swing.JTable jtbl_idioma;
    public static javax.swing.JTextField jtf_consulta;
    // End of variables declaration//GEN-END:variables

    public void consultaIdioma() {
        try {
            pool = new Pool();
            IdiomaDAO idiomaDAO = new IdiomaDAO(pool);
            idiomas = null;
            idiomas = idiomaDAO.getIdioma_nome(jtf_consulta.getText().trim());
            mostrarIdiomas(idiomas);
        } catch (SQLException ex) {
            Logger.getLogger(MenuIdioma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarIdiomas(List<Idioma> idiomas) {
        DefaultTableModel tableModel = (DefaultTableModel) jtbl_idioma.getModel();
        tableModel.setNumRows(0);

        if (idiomas.size() == 0) {
            JOptionPane.showMessageDialog(null, "Nenhuma idioma encontrado");

        } else {
            for (int i = 0; i < idiomas.size(); i++) {

                DefaultTableModel row = (DefaultTableModel) jtbl_idioma.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(idiomas.get(i), idiomas.get(i).getNome_idioma());
                row.addRow(new Object[]{idiomas.get(i).getCodigo_idioma(), hashDbGrid});
            }
            jtbl_idioma.requestFocus();
            jtbl_idioma.setSelectionMode(1);
        }
    }

    public void acionarAtalho(java.awt.event.KeyEvent evt) {

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            setVisible(false);
            janelapai.setStatusTela(true);
        }
    }
}
