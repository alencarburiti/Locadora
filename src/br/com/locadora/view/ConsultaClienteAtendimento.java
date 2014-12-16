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
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.dao.ClienteDAO;
import br.com.locadora.model.dao.DependenteDAO;
import br.com.locadora.model.dao.UsuarioDAO;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.TemaInterface;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class ConsultaClienteAtendimento extends javax.swing.JFrame {

    public AtendimentoLocacao janelapaiLocacao;
    public AtendimentoDevolucao janelapaiDevolucao;
    public Recebimento janelapaiRecebimento;
    public List<Cliente> clientes;
    public List<Dependente> dependentes;
    public AcessoUsuario acesso;

    public ConsultaClienteAtendimento() {
        initComponents();
        TemaInterface.getInterface(this);
        janelapaiLocacao = null;
        janelapaiDevolucao = null;
        janelapaiRecebimento = null;
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
        jtf_consulta = new javax.swing.JTextField();
        jb_buscar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbl_cliente = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jb_cancelar = new javax.swing.JButton();
        jb_novo1 = new javax.swing.JButton();
        jb_ok = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Cliente");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta Cliente/Dependente"));
        jPanel1.setName("jPanel1"); // NOI18N

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

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        jtbl_cliente.setUpdateSelectionOnSort(false);
        jtbl_cliente.setVerifyInputWhenFocusTarget(false);
        jtbl_cliente.setDefaultEditor(Object.class, null);
        jtbl_cliente.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount() == 2){
                    botaoOK(jtbl_cliente);

                }}});
                jtbl_cliente.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
                jtbl_cliente.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {

                    },
                    new String [] {
                        "Cód. Cliente", "Nome do Cliente/Dependente", "Data Nascimento", "Situação", "Tipo do Cliente", "Cód. Dependente"
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
                jtbl_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        jtbl_clienteKeyPressed(evt);
                    }
                });
                jScrollPane3.setViewportView(jtbl_cliente);
                if (jtbl_cliente.getColumnModel().getColumnCount() > 0) {
                    jtbl_cliente.getColumnModel().getColumn(0).setPreferredWidth(10);
                    jtbl_cliente.getColumnModel().getColumn(1).setPreferredWidth(180);
                    jtbl_cliente.getColumnModel().getColumn(2).setPreferredWidth(20);
                    jtbl_cliente.getColumnModel().getColumn(3).setPreferredWidth(20);
                    jtbl_cliente.getColumnModel().getColumn(4).setPreferredWidth(40);
                    jtbl_cliente.getColumnModel().getColumn(5).setPreferredWidth(20);
                }

                jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
                jLabel2.setText("Parâmetro");
                jLabel2.setName("jLabel2"); // NOI18N

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
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                );
                jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jb_buscar))
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
                jPanel2.setName("jPanel2"); // NOI18N

                jb_cancelar.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
                jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/exit.png"))); // NOI18N
                jb_cancelar.setText("Cancelar");
                jb_cancelar.setName("jb_cancelar"); // NOI18N
                jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_cancelarActionPerformed(evt);
                    }
                });

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

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jb_novo1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jb_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(220, 220, 220))
                );

                jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jb_cancelar, jb_novo1, jb_ok});

                jPanel2Layout.setVerticalGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jb_novo1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jb_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(10, Short.MAX_VALUE))
                );

                jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jb_cancelar, jb_novo1, jb_ok});

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
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                );

                setSize(new java.awt.Dimension(840, 448));
                setLocationRelativeTo(null);
            }// </editor-fold>//GEN-END:initComponents

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        setVisible(false);
        if ((janelapaiLocacao != null)) {
            janelapaiLocacao.setStatusTela(true);
        } else if ((janelapaiDevolucao != null)) {
            janelapaiDevolucao.setStatusTela(true);
        } else if ((janelapaiRecebimento != null)) {
            janelapaiRecebimento.setStatusTela(true);
        }

}//GEN-LAST:event_jb_cancelarActionPerformed

    private void jb_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_okActionPerformed
        if (jtbl_cliente.getSelectedRow() == 1) {
            botaoOK(jtbl_cliente);
        }
}//GEN-LAST:event_jb_okActionPerformed
    public void botaoOK(JTable tb) {
        if (tb != null) {
            Dependente dependente = tbClienteDependenteLinhaSelecionada(jtbl_cliente);
            if ((janelapaiLocacao != null) && (dependente != null)) {
                setVisible(false);
                janelapaiLocacao.carregarClienteDependente(dependente);
                janelapaiLocacao.setStatusTela(true);
            } else if ((janelapaiDevolucao != null) && (dependente != null)) {
                setVisible(false);
                janelapaiDevolucao.carregarClienteDependente(dependente);
                janelapaiDevolucao.setStatusTela(true);
            } else if ((janelapaiRecebimento != null) && (dependente != null)) {
                setVisible(false);
                janelapaiRecebimento.carregarClienteDependente(dependente);
                janelapaiRecebimento.setStatusTela(true);
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um Cliente");
            }            
        }
    }


    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        setVisible(false);
        if ((janelapaiLocacao != null)) {
            janelapaiLocacao.setStatusTela(true);
        } else if ((janelapaiDevolucao != null)) {
            janelapaiDevolucao.setStatusTela(true);
        } else if ((janelapaiRecebimento != null)) {
            janelapaiRecebimento.setStatusTela(true);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void jb_novo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_novo1ActionPerformed
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuCliente");
        try {
            if (acesso.getEscrever() == 0) {
                CadastroCliente cadastroCliente = new CadastroCliente();
                cadastroCliente.janelapai2 = this;
                cadastroCliente.setVisible(true);
                setStatusTela(false);
                cadastroCliente.acesso = acesso;
            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }
}//GEN-LAST:event_jb_novo1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if (janelapaiLocacao != null) {
            AtendimentoLocacao.jtf_codigo_cliente.setText("");
            listaClienteDependente();
//            jtbl_cliente.requestFocus();
//            jtbl_cliente.setSelectionMode(1);
        } else if (janelapaiDevolucao != null) {
            AtendimentoDevolucao.jtf_codigo_cliente.setText("");
            listaClienteDependente();
//            jtbl_cliente.requestFocus();
//            jtbl_cliente.setSelectionMode(1);
        } else if (janelapaiRecebimento != null) {
            Recebimento.jtf_codigo_cliente.setText("");
            listaClienteDependente();
//            jtbl_cliente.requestFocus();
//            jtbl_cliente.setSelectionMode(1);
        }

    }//GEN-LAST:event_formWindowOpened

    private void jb_buscarActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_buscarActionPerformed1
        listaClienteDependente();
    }//GEN-LAST:event_jb_buscarActionPerformed1

    private void jtbl_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_clienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_clienteMouseClicked

    private void jtf_consultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_consultaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            listaClienteDependente();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_consultaKeyPressed

    private void jtbl_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_clienteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            botaoOK(jtbl_cliente);
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            jtf_consulta.requestFocus();
        }
    }//GEN-LAST:event_jtbl_clienteKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            jtf_consulta.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F10) {
            botaoOK(jtbl_cliente);
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            setVisible(false);
            if ((janelapaiLocacao != null)) {
                janelapaiLocacao.setEnabled(true);
                janelapaiLocacao.setVisible(true);
                //telaCadastroObjeto.setStatusTela(false);
            }

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jb_buscar;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_novo1;
    private javax.swing.JButton jb_ok;
    public static javax.swing.JTable jtbl_cliente;
    public static javax.swing.JTextField jtf_consulta;
    // End of variables declaration//GEN-END:variables

    public void setCadastro() {
        jb_novo1.setEnabled(false);
    }

    public Dependente tbClienteDependenteLinhaSelecionada(JTable tb) {
        Dependente dependente = null;

        if (tb.getSelectedRow() != -1) {
            dependente = new Dependente();

            dependente.setCodigo_dependente(dependentes.get(tb.getSelectedRow()).getCodigo_dependente());
            dependente.setNome_dependente(dependentes.get(tb.getSelectedRow()).getNome_dependente());
            dependente.setDebito(dependentes.get(tb.getSelectedRow()).getDebito());
            dependente.setData_nascimento(dependentes.get(tb.getSelectedRow()).getData_nascimento());

            Cliente cliente = new Cliente();
            cliente.setCodigo_cliente(dependentes.get(tb.getSelectedRow()).getCliente().getCodigo_cliente());

            dependente.setCliente(cliente);
        }
        return dependente;
    }
    private InterfacePool pool;

    public void listaClienteDependente() {
        try {
            pool = new Pool();
            DependenteDAO dependenteDAO = new DependenteDAO(pool);
            dependentes = dependenteDAO.getClienteDependente("%" + jtf_consulta.getText().trim() + "%");
            mostraClienteDependente(dependentes);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaClienteAtendimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listaTodasClientes() throws SQLException {
        pool = new Pool();
        ClienteDAO clienteDAO = new ClienteDAO(pool);
//        clientes = clienteDAO.getTodasClientes();
//        mostraClienteDependente(clientes);
    }

    public void mostraClienteDependente(List<Dependente> dependentes) {
        ((DefaultTableModel) jtbl_cliente.getModel()).setRowCount(0);
        jtbl_cliente.updateUI();

        if (dependentes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum Cliente encontrado");
            jtf_consulta.requestFocus();

        } else {
            for (Dependente dependente : dependentes) {
                SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
                String data_nascimento = null;
                try {
                    data_nascimento = out.format(in.parse(dependente.getData_nascimento().toString()));
                } catch (ParseException ex) {
                    Logger.getLogger(ConsultaClienteAtendimento.class.getName()).log(Level.SEVERE, null, ex);
                }
                DefaultTableModel row = (DefaultTableModel) jtbl_cliente.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(dependente, dependente.getNome_dependente());
                row.addRow(new Object[]{dependente.getCliente().getCodigo_cliente(), hashDbGrid, data_nascimento, dependente.getCliente().getStatus(), dependente.getTipo_dependente(), dependente.getCodigo_dependente()});
            }
            jtbl_cliente.requestFocus();
            jtbl_cliente.setSelectionMode(0);
//            jtbl_cliente.requestFocus();
//            jtbl_cliente.setRowSelectionInterval(0, 0);
        }
    }

    public void setStatusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }
}
