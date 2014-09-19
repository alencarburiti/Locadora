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
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.FornecedorModel;
import br.com.locadora.model.dao.ClienteDAO;
import br.com.locadora.model.dao.FornecedorDAO;
import br.com.locadora.util.ItemDbGrid;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class ConsultaClienteAtendimento extends javax.swing.JFrame {

    public Atendimento janelapai;
    public Atendimento_InterFace telaAtendimento;
    public List<Cliente> clientes;
    
    public ConsultaClienteAtendimento() {
        initComponents();
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
        jb_cancelar = new javax.swing.JButton();
        jb_ok = new javax.swing.JButton();
        jb_novo1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jtf_consulta = new javax.swing.JTextField();
        jb_buscar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbl_cliente = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/exit.png"))); // NOI18N
        jb_cancelar.setText("Cancelar");
        jb_cancelar.setName("jb_cancelar"); // NOI18N
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 110, 40));

        jb_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/ok.png"))); // NOI18N
        jb_ok.setText("OK");
        jb_ok.setName("jb_ok"); // NOI18N
        jb_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_okActionPerformed(evt);
            }
        });
        getContentPane().add(jb_ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 80, 40));

        jb_novo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/novo_registro.gif"))); // NOI18N
        jb_novo1.setText("Novo");
        jb_novo1.setName("jb_novo1"); // NOI18N
        jb_novo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_novo1ActionPerformed(evt);
            }
        });
        getContentPane().add(jb_novo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 110, 40));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta Cliente"));
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtf_consulta.setName("jtf_consulta"); // NOI18N
        jPanel1.add(jtf_consulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 450, -1));

        jb_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/ok.png"))); // NOI18N
        jb_buscar.setName("jb_buscar"); // NOI18N
        jb_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_buscarActionPerformed1(evt);
            }
        });
        jPanel1.add(jb_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, -1, -1));

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        jtbl_cliente.setUpdateSelectionOnSort(false);
        jtbl_cliente.setVerifyInputWhenFocusTarget(false);
        jtbl_cliente.setDefaultEditor(Object.class, null);
        jtbl_cliente.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount() == 2){
                    botaoOK(jtbl_cliente);

                }}});
                jtbl_cliente.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {

                    },
                    new String [] {
                        "Código", "Nome", "Data Nascimento", "CPF", "Email", "Status"
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
                jtbl_cliente.setName("jtbl_cliente"); // NOI18N
                jtbl_cliente.getTableHeader().setReorderingAllowed(false);
                jtbl_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        jtbl_clienteMouseClicked(evt);
                    }
                });
                jScrollPane3.setViewportView(jtbl_cliente);

                jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 688, 210));

                getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 750, 300));

                setSize(new java.awt.Dimension(836, 438));
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
    
    private void jb_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_okActionPerformed
        if (jtbl_cliente.getSelectedRow() == 1) {
            botaoOK(jtbl_cliente);
        }
}//GEN-LAST:event_jb_okActionPerformed
    public void botaoOK(JTable tb) {
        if (tb.getSelectedRow() != -1) {
            setVisible(false);
            Cliente cliente = tbClienteLinhaSelecionada(jtbl_cliente);
            if ((janelapai != null) && (cliente != null)) {
                janelapai.setEnabled(true);
                janelapai.setVisible(true);
                telaAtendimento.carregaCliente(cliente);
//                telaAtendimento.setStatusTela(false);
            }

//        if ((janelapai3 != null) && (cliente != null)) {
//            janelapai3.setEnabled(true);
//            janelapai3.setVisible(true);
//            telaAjusteEstoque.carregaFornecedor(cliente);
//            //telaSaidaEstoque.statusTela(true);        
//        }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Cliente");
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

    private void jb_buscarActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_buscarActionPerformed1
        try {
            listaCliente(jtf_consulta.getText().trim());
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaClienteAtendimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jb_buscarActionPerformed1

    private void jtbl_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_clienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_clienteMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ConsultaClienteAtendimento().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jb_buscar;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_novo1;
    private javax.swing.JButton jb_ok;
    public static javax.swing.JTable jtbl_cliente;
    private javax.swing.JTextField jtf_consulta;
    // End of variables declaration//GEN-END:variables

    //Recebendo tela como parametro para atualização apos pesquisa
    public void setTelaAtendimento(Atendimento_InterFace telaAtendimento) {
        this.telaAtendimento = telaAtendimento;
    }

    
    public void setCadastro() {
        jb_novo1.setEnabled(false);
    }

    public Cliente tbClienteLinhaSelecionada(JTable tb) {
        Cliente cliente = null;
        if (tb.getSelectedRow() != -1) {
            cliente = new Cliente();
            cliente.setCodigo_cliente(clientes.get(tb.getSelectedRow()).getCodigo_cliente());
            cliente.setNome_cliente(clientes.get(tb.getSelectedRow()).getNome_cliente());            
        }
        return cliente;
    }
    private InterfacePool pool;

    public void listaCliente(String consulta) throws SQLException {
        pool = new Pool();
        ClienteDAO clienteDAO = new ClienteDAO(pool);
        clientes = clienteDAO.getClientes_nome("%" + jtf_consulta.getText().trim() + "%");
        mostraCliente(clientes);
    }

    public void listaTodasClientes() throws SQLException {
        pool = new Pool();
        ClienteDAO clienteDAO = new ClienteDAO(pool);
//        clientes = clienteDAO.getTodasClientes();
        mostraCliente(clientes);
    }

    public void mostraCliente(List<Cliente> clientes) {
        ((DefaultTableModel) jtbl_cliente.getModel()).setRowCount(0);
        jtbl_cliente.updateUI();

        if (clientes.size() == 0) {
            JOptionPane.showMessageDialog(this, "Nenhuma cliente encontrada");

        } else {
            for (int i = 0; i < clientes.size(); i++) {

                Cliente cliente = new Cliente();
                cliente.setCodigo_cliente(clientes.get(i).getCodigo_cliente());
                cliente.setNome_cliente(clientes.get(i).getNome_cliente());
                cliente.setCpf(clientes.get(i).getCpf());
                cliente.setEmail(clientes.get(i).getEmail());
                if(clientes.get(i).getStatus() == "A"){
                    cliente.setStatus("Ativo");
                }else{
                    cliente.setStatus("Inativo");
                }
                cliente.setStatus(clientes.get(i).getStatus());

                SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
                
                String data_nascimento = null;
                try {
                    data_nascimento = out.format(in.parse(clientes.get(i).getData_nascimento().toString()));
                } catch (ParseException ex) {
                    Logger.getLogger(ConsultaClienteAtendimento.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                DefaultTableModel row = (DefaultTableModel) jtbl_cliente.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(cliente, cliente.getNome_cliente());
                row.addRow(new Object[]{cliente.getCodigo_cliente(), hashDbGrid, data_nascimento, cliente.getCpf(), cliente.getEmail(), cliente.getStatus()});
                
            }
            jtbl_cliente.setSelectionMode(1);
        }
    }

    public String setPrecoFormat(String preco) {
        DecimalFormat dFormat = new DecimalFormat();
        dFormat.applyPattern("R$ #0.00");
        return dFormat.format(getPrecoFormato(preco));
    }

    public Double getPrecoFormato(String preco) {
        Double precoFormatado = 0.0;
        try {
            preco = preco.replace("R", "");
            preco = preco.replace("$", "");
            preco = preco.replace(",", ".");
            preco = preco.replace(" ", "");
            precoFormatado = Double.parseDouble(preco.trim());

            //this.objFuncionario.setSalario(getSalarioFormat(jTSalario.getText())); pegar valor em double
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Valor Informado Incorreto!\nInforme um valor com o seguinte formato:\nEx: 100,00");
        }

        return precoFormatado;
    }

}
