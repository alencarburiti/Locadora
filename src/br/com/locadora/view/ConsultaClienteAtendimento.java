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
import br.com.locadora.util.Colorir;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.TemaInterface;
import static br.com.locadora.view.LocacaoEmAberto.itensDevolucao;
import static br.com.locadora.view.LocacaoEmAberto.jtbl_locacao_aberto;
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
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author ALENCAR
 */
public class ConsultaClienteAtendimento extends javax.swing.JFrame {

    public AtendimentoLocacao janelapaiLocacao;
    public AtendimentoDevolucao janelapaiDevolucao;
    public AtendimentoVenda janelapaiVenda;
    public FinanceiroReceber janelapaiRecebimento;
    public List<Cliente> clientes;
    public List<Dependente> dependentes;
    public AcessoUsuario acesso;
    public CadastraAlteraCliente cadastraAlteraCliente;

    public ConsultaClienteAtendimento() {
        initComponents();
        TemaInterface.getInterface(this);
        janelapaiLocacao = null;
        janelapaiDevolucao = null;
        janelapaiVenda = null; 
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
        jButton1 = new javax.swing.JButton();
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
        jb_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pesquisar.png"))); // NOI18N
        jb_buscar.setName("jb_buscar"); // NOI18N
        jb_buscar.setPreferredSize(new java.awt.Dimension(28, 28));
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
                        "Cód. Cliente", "Nome do Cliente/Dependente", "Data Nascimento", "Tipo do Cliente", "Situação", "Cód. Dependente"
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
                    jtbl_cliente.getColumnModel().getColumn(3).setPreferredWidth(40);
                    jtbl_cliente.getColumnModel().getColumn(4).setPreferredWidth(20);
                    jtbl_cliente.getColumnModel().getColumn(5).setPreferredWidth(20);
                }

                jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
                jLabel2.setText("Parâmetro");
                jLabel2.setName("jLabel2"); // NOI18N

                jButton1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
                jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/cliente.png"))); // NOI18N
                jButton1.setText("Verificar Cliente");
                jButton1.setName("jButton1"); // NOI18N
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton1ActionPerformed(evt);
                    }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtf_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jb_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0))
                );
                jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, 0)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtf_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jb_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(jButton1)
                                .addGap(0, 0, 0)))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                );

                jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jb_buscar, jtf_consulta});

                jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
                jPanel2.setName("jPanel2"); // NOI18N

                jb_cancelar.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
                jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/sair.png"))); // NOI18N
                jb_cancelar.setText("Sair");
                jb_cancelar.setName("jb_cancelar"); // NOI18N
                jb_cancelar.setPreferredSize(new java.awt.Dimension(100, 40));
                jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_cancelarActionPerformed(evt);
                    }
                });

                jb_novo1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
                jb_novo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/novo_registro.png"))); // NOI18N
                jb_novo1.setText("Novo");
                jb_novo1.setName("jb_novo1"); // NOI18N
                jb_novo1.setPreferredSize(new java.awt.Dimension(100, 40));
                jb_novo1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_novo1ActionPerformed(evt);
                    }
                });

                jb_ok.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
                jb_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/finalizar.png"))); // NOI18N
                jb_ok.setText("OK");
                jb_ok.setName("jb_ok"); // NOI18N
                jb_ok.setPreferredSize(new java.awt.Dimension(100, 40));
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
                        .addGap(235, 235, 235)
                        .addComponent(jb_novo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jb_ok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(235, 235, 235))
                );
                jPanel2Layout.setVerticalGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jb_ok, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(jb_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(jb_novo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, 0))
                );

                jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jb_cancelar, jb_ok});

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(8, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                );

                setSize(new java.awt.Dimension(800, 364));
                setLocationRelativeTo(null);
            }// </editor-fold>//GEN-END:initComponents

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        retornaJanelaPai();
}//GEN-LAST:event_jb_cancelarActionPerformed

    private void jb_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_okActionPerformed
        if (jtbl_cliente.getSelectedRow() != -1) {
            botaoOK(jtbl_cliente);
        }
}//GEN-LAST:event_jb_okActionPerformed
    public void botaoOK(JTable tb) {
        if (tb != null) {
            Dependente dependente = tbClienteDependenteLinhaSelecionada(jtbl_cliente);
            if ((janelapaiLocacao != null) && (dependente != null)) {
                if(jtbl_cliente.getValueAt(jtbl_cliente.getSelectedRow(), 4) != "Cliente Inativo" ){
                    if(jtbl_cliente.getValueAt(jtbl_cliente.getSelectedRow(), 4) != "Dependente Inativo" ){
                        janelapaiLocacao.carregarClienteDependente(dependente);
                        retornaJanelaPai();
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Dependente Inativo. Favor consultar o titular!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente Inativo. Favor verificar!");
                }
            } else if ((janelapaiDevolucao != null) && (dependente != null)) {
                setVisible(false);
                janelapaiDevolucao.carregarClienteDependente(dependente);
                retornaJanelaPai();
            }else if ((janelapaiVenda != null) && (dependente != null)) {
                setVisible(false);
                janelapaiVenda.carregarClienteDependente(dependente);
                retornaJanelaPai();            
            } else if ((janelapaiRecebimento != null) && (dependente != null)) {
                setVisible(false);
                janelapaiRecebimento.carregarClienteDependente(dependente);
                retornaJanelaPai();
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um Cliente");
            }            
        }
    }


    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        retornaJanelaPai();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void jb_novo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_novo1ActionPerformed
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuCliente");
        try {
            if (acesso.getEscrever() == true) {
                if(cadastraAlteraCliente == null){
                    cadastraAlteraCliente = new CadastraAlteraCliente();
                    cadastraAlteraCliente.janelapai2 = this;
                    cadastraAlteraCliente.setVisible(true);
                    this.setStatusTela(false);
                    cadastraAlteraCliente.acesso = acesso;                    
                } else {
                    cadastraAlteraCliente.setVisible(true);
                }
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
        } else if (janelapaiDevolucao != null) {
            AtendimentoDevolucao.jtf_codigo_cliente.setText("");
            listaClienteDependente();
        } else if (janelapaiRecebimento != null) {
            FinanceiroReceber.jtf_codigo_cliente.setText("");
            listaClienteDependente();        
        } else if (janelapaiVenda != null) {
            AtendimentoVenda.jtf_codigo_cliente.setText("");
            listaClienteDependente();
        }

    }//GEN-LAST:event_formWindowOpened

    private void jb_buscarActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_buscarActionPerformed1
        listaClienteDependente();
    }//GEN-LAST:event_jb_buscarActionPerformed1

    private void jtbl_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_clienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_clienteMouseClicked

    private void jtf_consultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_consultaKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            listaClienteDependente();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_consultaKeyPressed

    private void jtbl_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_clienteKeyPressed
        acionarAtalho(evt);
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
            retornaJanelaPai();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        verificarCliente();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton jButton1;
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

    public void verificarCliente() {
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        AcessoUsuario acesso;
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.Locadora.view.MenuCliente");
        try {
            System.out.println("Escrever: " + acesso.getEscrever());
            if (acesso.getEscrever() == true) {
                if(jtbl_cliente.getSelectedRow() != -1){
                    pool = new Pool();
                    ClienteDAO clienteDAO = new ClienteDAO(pool);
                    Cliente cliente = clienteDAO.getCliente_codigo(dependentes.get(jtbl_cliente.getSelectedRow()).getCliente().getCodigo_cliente()).get(0);

                    if (cliente != null) {
                        if(cadastraAlteraCliente == null ){
                            cadastraAlteraCliente = new CadastraAlteraCliente(cliente);
                            cadastraAlteraCliente.janelapai4 = this;
                            cadastraAlteraCliente.setVisible(true);
                            setEnabled(false);
                        } else {
                            cadastraAlteraCliente.setVisible(true);
                        }
                    }
                }
                 else {
                    JOptionPane.showMessageDialog(null, "Selecione um cliente");
                    jtf_consulta.requestFocus();                    
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }
    }
    
    public Dependente tbClienteDependenteLinhaSelecionada(JTable tb) {
        Dependente dependente = null;

        if (tb.getSelectedRow() != -1) {
            dependente = dependentes.get(tb.getSelectedRow());

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
                //Escreve na tela se o cliente/dependente esta ou nao ativo
                String status = "";
                if(dependente.getCliente().getStatus() == true){
                    if(dependente.getTipo_dependente().equals("Cliente")){
                        if(dependente.getStatus() == true){
                            status = "Ativo";
                        } else {
                            status = "Cliente Inativo";
                        }                        
                    } else if(dependente.getTipo_dependente().equals("Dependente")){
                        if(dependente.getStatus() == true){
                            status = "Ativo";
                        } else {
                            status = "Dependente Inativo";
                        }
                    }
                } else {
                    status = "Cliente Inativo";
                }
                        
                DefaultTableModel row = (DefaultTableModel) jtbl_cliente.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(dependente, dependente.getNome_dependente());
                row.addRow(new Object[]{dependente.getCliente().getCodigo_cliente(), hashDbGrid, data_nascimento, dependente.getTipo_dependente(), status, dependente.getCodigo_dependente()});
            }
            
            TableCellRenderer tcr = new Colorir(null, this, null);            
            TableColumn column = jtbl_cliente.getColumnModel().getColumn(0);
            column.setCellRenderer(tcr);            
            column = jtbl_cliente.getColumnModel().getColumn(1);
            column.setCellRenderer(tcr);
            column = jtbl_cliente.getColumnModel().getColumn(2);
            column.setCellRenderer(tcr);
            column = jtbl_cliente.getColumnModel().getColumn(3);
            column.setCellRenderer(tcr);
            column = jtbl_cliente.getColumnModel().getColumn(4);
            column.setCellRenderer(tcr);
            column = jtbl_cliente.getColumnModel().getColumn(5);
            column.setCellRenderer(tcr);
            
            
            jtbl_cliente.requestFocus();
            jtbl_cliente.setSelectionMode(0);
        }
    }

    public void setStatusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }
    
    public void acionarAtalho(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F10) {
            botaoOK(jtbl_cliente);
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            retornaJanelaPai();
        }
    }

    private void retornaJanelaPai() {
        setVisible(false);
        if ((janelapaiLocacao != null)) {
            janelapaiLocacao.setStatusTela(true);
        } else if ((janelapaiDevolucao != null)) {
            janelapaiDevolucao.setStatusTela(true);
        } else if ((janelapaiRecebimento != null)) {
            janelapaiRecebimento.setStatusTela(true);
        } else if((janelapaiVenda != null)){
            janelapaiVenda.setStatusTela(true);
        }            
    }
}
