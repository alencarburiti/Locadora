/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EntradaGUI.java
 *
 * Created on 27/05/2011, 15:13:50
 */
package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.controller.SiscomController;
import br.com.locadora.model.bean.Lancamento;
import br.com.locadora.model.dao.LancamentoDAO;
import br.com.locadora.util.Moeda;
import br.com.locadora.util.TemaInterface;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FluxodeCaixaDetalhado extends javax.swing.JFrame {

    public TelaPrincipal janelapai;
    public static List<Lancamento> lancamentos;
    public InterfacePool pool;
    public SiscomController controller;

    public FluxodeCaixaDetalhado() {
        initComponents();
        TemaInterface.getInterface(this);
        janelapai = null;
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
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbl_lancamento_caixa = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jb_sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fluxo de Caixa Detalhado");
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

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        jtbl_lancamento_caixa.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtbl_lancamento_caixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente/Dependente", "Tipo Serviço", "Caixa", "Data Lançamento", "Valor", "Usuário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbl_lancamento_caixa.setName("jtbl_lancamento_caixa"); // NOI18N
        jtbl_lancamento_caixa.getTableHeader().setReorderingAllowed(false);
        jtbl_lancamento_caixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_lancamento_caixaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtbl_lancamento_caixa);
        if (jtbl_lancamento_caixa.getColumnModel().getColumnCount() > 0) {
            jtbl_lancamento_caixa.getColumnModel().getColumn(0).setPreferredWidth(130);
            jtbl_lancamento_caixa.getColumnModel().getColumn(1).setPreferredWidth(120);
            jtbl_lancamento_caixa.getColumnModel().getColumn(2).setPreferredWidth(10);
            jtbl_lancamento_caixa.getColumnModel().getColumn(3).setPreferredWidth(30);
            jtbl_lancamento_caixa.getColumnModel().getColumn(4).setPreferredWidth(30);
            jtbl_lancamento_caixa.getColumnModel().getColumn(5).setPreferredWidth(20);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel1.setName("jPanel1"); // NOI18N

        jb_sair.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jb_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/exit.png"))); // NOI18N
        jb_sair.setText("Sair");
        jb_sair.setName("jb_sair"); // NOI18N
        jb_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_sairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(jb_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(373, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jb_sair)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jb_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_buscarActionPerformed
        
}//GEN-LAST:event_jb_buscarActionPerformed

    private void jb_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_sairActionPerformed
        setVisible(false);
        janelapai.setStatusTela(true);
}//GEN-LAST:event_jb_sairActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        setVisible(false);
        janelapai.setStatusTela(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void jtbl_lancamento_caixaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_lancamento_caixaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_lancamento_caixaMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        lancamentoCaixa();
    }//GEN-LAST:event_formWindowOpened

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            
//        }
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FluxodeCaixaDetalhado().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jb_sair;
    public static javax.swing.JTable jtbl_lancamento_caixa;
    // End of variables declaration//GEN-END:variables

    public void lancamentoCaixa() {
        pool = new Pool();
        LancamentoDAO lancDAO = new LancamentoDAO(pool);
        lancamentos = lancDAO.getLancamentoDetalhado();
        mostrarLancamentoCaixa(lancamentos);
    }

    public void mostrarLancamentoCaixa(List<Lancamento> lancamentos) {
        DefaultTableModel tableModel = (DefaultTableModel) jtbl_lancamento_caixa.getModel();
        tableModel.setNumRows(0);

        if (lancamentos.size() == 0) {
            JOptionPane.showMessageDialog(null, "Nenhuma Lançamento encontrado");

        } else {
            for (int i = 0; i < lancamentos.size(); i++) {

                String valor = null;

                valor = String.valueOf(lancamentos.get(i).getValor());

                Moeda moeda = new Moeda();

                valor = moeda.setPrecoFormat(valor);

                SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

                String data_lancamento = null;
                try {
                    data_lancamento = out.format(in.parse(lancamentos.get(i).getData_lancamento().toString()));
                } catch (ParseException ex) {
                    Logger.getLogger(FluxodeCaixaDetalhado.class.getName()).log(Level.SEVERE, null, ex);
                }

                DefaultTableModel row = (DefaultTableModel) jtbl_lancamento_caixa.getModel();
//                ItemDbGrid hashDbGrid = new ItemDbGrid(diaria, diaria.getNome_diaria());
                row.addRow(new Object[]{lancamentos.get(i).getDependente().getNome_dependente(), lancamentos.get(i).getTipoServico().getDescricao(),
                    lancamentos.get(i).getCaixa(), data_lancamento, valor, lancamentos.get(i).getUsuario().getNome_usuario()});
            }

        }
    }

    public void statusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }
    public void retornaJanelaPai(){
        setVisible(false);
        if(janelapai != null){
            janelapai.setStatusTela(true);            
        }
    }

}
