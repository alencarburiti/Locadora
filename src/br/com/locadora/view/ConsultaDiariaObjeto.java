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
import br.com.locadora.controller.SiscomController;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.dao.DiariaDAO;
import br.com.locadora.model.dao.UsuarioDAO;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.Moeda;
import br.com.locadora.util.TemaInterface;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALENCAR
 */
public class ConsultaDiariaObjeto extends javax.swing.JFrame {

    public CadastroObjeto janelapai;
    public AtualizaObjeto janelapai2;
    public List<Diaria> diarias;
    public Moeda moeda;
    public InterfacePool pool;
    public SiscomController controller;
    public AcessoUsuario acesso;

    public ConsultaDiariaObjeto() {
        initComponents();
        TemaInterface.getInterface(this);
        janelapai = null;
        janelapai2 = null;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_diaria = new javax.swing.JTable();
        jtf_consulta = new javax.swing.JTextField();
        jb_buscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jb_novo1 = new javax.swing.JButton();
        jb_ok = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Diária");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta Diária"));
        jPanel1.setName("jPanel1"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jtbl_diaria.setUpdateSelectionOnSort(false);
        jtbl_diaria.setVerifyInputWhenFocusTarget(false);
        jtbl_diaria.setDefaultEditor(Object.class, null);
        jtbl_diaria.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount() == 2){
                    botaoOK(jtbl_diaria);

                }}});
                jtbl_diaria.setFont(new java.awt.Font("Helvetica Neue", 0, 1213)); // NOI18N
                jtbl_diaria.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {

                    },
                    new String [] {
                        "Código", "Descrição", "Dias", "Valor", "Relocação"
                    }
                ) {
                    Class[] types = new Class [] {
                        java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
                jtbl_diaria.setName("jtbl_diaria"); // NOI18N
                jtbl_diaria.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        jtbl_diariaKeyPressed(evt);
                    }
                });
                jScrollPane1.setViewportView(jtbl_diaria);
                if (jtbl_diaria.getColumnModel().getColumnCount() > 0) {
                    jtbl_diaria.getColumnModel().getColumn(0).setResizable(false);
                    jtbl_diaria.getColumnModel().getColumn(0).setPreferredWidth(15);
                    jtbl_diaria.getColumnModel().getColumn(1).setPreferredWidth(200);
                    jtbl_diaria.getColumnModel().getColumn(2).setPreferredWidth(10);
                    jtbl_diaria.getColumnModel().getColumn(3).setResizable(false);
                    jtbl_diaria.getColumnModel().getColumn(3).setPreferredWidth(20);
                    jtbl_diaria.getColumnModel().getColumn(4).setPreferredWidth(20);
                }

                jtf_consulta.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
                jtf_consulta.setName("jtf_consulta"); // NOI18N
                jtf_consulta.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        jtf_consultaKeyPressed(evt);
                    }
                });

                jb_buscar.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
                jb_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/ok.png"))); // NOI18N
                jb_buscar.setName("jb_buscar"); // NOI18N
                jb_buscar.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_buscarActionPerformed1(evt);
                    }
                });

                jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
                jLabel1.setText("Parâmetro");
                jLabel1.setName("jLabel1"); // NOI18N

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtf_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jb_buscar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(10, 10, 10))
                );
                jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jb_buscar))
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                );

                jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
                jPanel2.setName("jPanel2"); // NOI18N

                jb_novo1.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
                jb_novo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/novo_registro.gif"))); // NOI18N
                jb_novo1.setText("Novo");
                jb_novo1.setName("jb_novo1"); // NOI18N
                jb_novo1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_novo1ActionPerformed(evt);
                    }
                });

                jb_ok.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
                jb_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/ok.png"))); // NOI18N
                jb_ok.setText("OK");
                jb_ok.setName("jb_ok"); // NOI18N
                jb_ok.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_okActionPerformed(evt);
                    }
                });

                jb_cancelar.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
                jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/exit.png"))); // NOI18N
                jb_cancelar.setText("Cancelar");
                jb_cancelar.setName("jb_cancelar"); // NOI18N
                jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_cancelarActionPerformed(evt);
                    }
                });

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jb_novo1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jb_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(155, 155, 155))
                );
                jPanel2Layout.setVerticalGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jb_novo1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jb_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                );

                setSize(new java.awt.Dimension(672, 464));
                setLocationRelativeTo(null);
            }// </editor-fold>//GEN-END:initComponents

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        setVisible(false);
        if ((janelapai != null)) {
            janelapai.setStatusTela(true);
        } else if ((janelapai2 != null)) {
            janelapai2.setStatusTela(true);
        }

}//GEN-LAST:event_jb_cancelarActionPerformed


    private void jb_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_okActionPerformed
        botaoOK(jtbl_diaria);
}//GEN-LAST:event_jb_okActionPerformed
    public void botaoOK(JTable tb) {
        if (tb.getSelectedRow() != -1) {
            setVisible(false);
            Diaria diaria = tbDiariaLinhaSelecionada(jtbl_diaria);
            if ((janelapai != null) && (diaria != null)) {
                janelapai.setStatusTela(true);
                janelapai.carregaDiaria(diaria);
            } else if ((janelapai2 != null) && (diaria != null)) {
                janelapai2.setStatusTela(true);
                janelapai2.carregaDiaria(diaria);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma Diária");
        }
    }

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        setVisible(false);
        if ((janelapai != null)) {
            janelapai.setEnabled(true);
            janelapai.setVisible(true);
            janelapai.setStatusTela(true);
        }
        if ((janelapai2 != null)) {
            janelapai2.setEnabled(true);
            janelapai2.setVisible(true);
            janelapai2.setStatusTela(true);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void jb_novo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_novo1ActionPerformed
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuDiaria");
        try {
            if (acesso.getEscrever() == 0) {
                CadastroDiaria cadastroDiaria = new CadastroDiaria();
                cadastroDiaria.janelapaiConsulta = this;
                cadastroDiaria.setVisible(true);
                setStatusTela(false);
                cadastroDiaria.acesso = acesso;
            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }

        // TODO add your handling code here:
}//GEN-LAST:event_jb_novo1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtbl_diaria.requestFocus();
        jtbl_diaria.setSelectionMode(1);
    }//GEN-LAST:event_formWindowOpened

private void jtbl_diariaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_diariaKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        botaoOK(jtbl_diaria);
    }
    if (evt.getKeyCode() == KeyEvent.VK_F5) {
        jtf_consulta.requestFocus();
    }
    if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
        setVisible(false);
        if (janelapai != null) {
            janelapai.setStatusTela(true);
        } else if (janelapai2 != null) {
            janelapai2.setStatusTela(true);
        }
    }

    // TODO add your handling code here:
}//GEN-LAST:event_jtbl_diariaKeyPressed

    private void jb_buscarActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_buscarActionPerformed1
        try {
            listaDiaria(jtf_consulta.getText().trim());
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDiariaObjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jb_buscarActionPerformed1

    private void jtf_consultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_consultaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                listaDiaria(jtf_consulta.getText().trim());
            } catch (SQLException ex) {
                Logger.getLogger(ConsultaDiariaObjeto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_consultaKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ConsultaDiariaObjeto().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_buscar;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_novo1;
    private javax.swing.JButton jb_ok;
    private javax.swing.JTable jtbl_diaria;
    private javax.swing.JTextField jtf_consulta;
    // End of variables declaration//GEN-END:variables

    public void setCadastro() {
        jb_novo1.setEnabled(false);
    }

    public Diaria tbDiariaLinhaSelecionada(JTable tb) {
        Diaria diaria = null;
        if (tb.getSelectedRow() != -1) {
            diaria = new Diaria();
            diaria.setCodigo_diaria(diarias.get(tb.getSelectedRow()).getCodigo_diaria());
            diaria.setNome_diaria(diarias.get(tb.getSelectedRow()).getNome_diaria());
            diaria.setDias(diarias.get(tb.getSelectedRow()).getDias());
            diaria.setValor(diarias.get(tb.getSelectedRow()).getValor());
            diaria.setValor_promocao(diarias.get(tb.getSelectedRow()).getValor_promocao());
            diaria.setMultas(diarias.get(tb.getSelectedRow()).getMultas());
        }
        return diaria;
    }

    public void listaDiaria(String consulta) throws SQLException {
        pool = new Pool();
        DiariaDAO diariaDAO = new DiariaDAO(pool);
        diarias = diariaDAO.getDiarias("%" + jtf_consulta.getText().trim() + "%");
        mostraDiaria(diarias);
    }

    public void listaTodasDiarias() {
        pool = new Pool();
        DiariaDAO diariaDAO = new DiariaDAO(pool);
        diarias = diariaDAO.getTodasDiarias();
        mostraDiaria(diarias);
    }

    public void mostraDiaria(List<Diaria> diarias) {
        ((DefaultTableModel) jtbl_diaria.getModel()).setRowCount(0);
        jtbl_diaria.updateUI();

        if (diarias.size() == 0) {
            JOptionPane.showMessageDialog(this, "Nenhuma diaria encontrada");

        } else {
            for (int i = 0; i < diarias.size(); i++) {
                Diaria diaria = new Diaria();
                diaria.setCodigo_diaria(diarias.get(i).getCodigo_diaria());
                diaria.setNome_diaria(diarias.get(i).getNome_diaria());
                diaria.setDias(diarias.get(i).getDias());

                String valor = null;
                
                String multa = null;

                valor = String.valueOf(diarias.get(i).getValor());
                
                multa = String.valueOf(diarias.get(i).getMultas());
                moeda = new Moeda();
                valor = moeda.setPrecoFormat(valor);
                
                multa = moeda.setPrecoFormat(multa);

                DefaultTableModel row = (DefaultTableModel) jtbl_diaria.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(diaria, diaria.getNome_diaria());
                row.addRow(new Object[]{diaria.getCodigo_diaria(), hashDbGrid, diaria.getDias(), valor, multa});
            }
            jtbl_diaria.requestFocus();
            jtbl_diaria.setSelectionMode(1);
        }
    }

    public void setStatusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }
}
