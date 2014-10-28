package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.controller.SiscomController;
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.Lancamento;
import br.com.locadora.model.bean.TipoServico;
import br.com.locadora.model.bean.Usuario;
import br.com.locadora.model.dao.DependenteDAO;
import br.com.locadora.model.dao.LancamentoDAO;
import br.com.locadora.model.dao.TipoServicoDAO;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.Moeda;
import static br.com.locadora.view.AtendimentoLocacao.jtbl_locacao;
import static br.com.locadora.view.AtendimentoLocacao.jtf_nome_objeto_locacao;
import static br.com.locadora.view.CadastroCliente.jtf_data_nascimento_dependente;
import static br.com.locadora.view.CadastroCliente.validaData;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class Recebimento extends javax.swing.JFrame {

    public DecimalFormat formatoPreco;
    public MaskFormatter formatoData;
    public String permissao;
    public Cliente cliente;
    public static Dependente dependente = new Dependente();
    private Date data;
    public InterfacePool pool;
    public SiscomController controller;
    public TelaPrincipal janelapai;
    public Moeda moeda;
    public List<Lancamento> lancamentos;
    public Lancamento lancamento;
    public TipoServico tipoServico;

    public Recebimento() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtf_codigo_cliente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtf_nome_cliente = new javax.swing.JTextField();
        jb_cliente = new javax.swing.JButton();
        jp_locacao = new javax.swing.JPanel();
        /*try  {          
            Locale BRAZIL = new Locale("pt","BR");  
            DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);
            formatoPreco = new DecimalFormat("¤ ###,###,##0.00",REAL);  
        }    catch (Exception erro)  
        {    
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");  
        }
        */
        jtf_valor_lancamento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_recebimento = new javax.swing.JTable();
        jl_codigo_locacao = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jtf_total_debito = new javax.swing.JTextField();
        jtf_total_credito = new javax.swing.JTextField();
        jb_adicionar_locacao = new javax.swing.JButton();
        jb_remover_locacao = new javax.swing.JButton();
        jtf_saldo = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jcb_tipo_servico = new javax.swing.JComboBox();
        try  {
            formatoData = new MaskFormatter("##/##/####");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");
        }
        jtf_data_lancamento = new JFormattedTextField(formatoData);

        jDesktopPane1.setName("jDesktopPane1"); // NOI18N
        jDesktopPane1.setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Recebimento");
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
        getContentPane().setLayout(null);

        jDesktopPane2.setName("jDesktopPane2"); // NOI18N
        getContentPane().add(jDesktopPane2);
        jDesktopPane2.setBounds(710, 100, 0, 0);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("Código ");
        jLabel1.setName("jLabel1"); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, -1));

        jtf_codigo_cliente.setEditable(false);
        jtf_codigo_cliente.setName("jtf_codigo_cliente"); // NOI18N
        jPanel1.add(jtf_codigo_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 130, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel10.setText("Cliente");
        jLabel10.setName("jLabel10"); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        jtf_nome_cliente.setName("jtf_nome_cliente"); // NOI18N
        jtf_nome_cliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_nome_clienteFocusLost(evt);
            }
        });
        jtf_nome_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_nome_clienteKeyPressed(evt);
            }
        });
        jPanel1.add(jtf_nome_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 320, -1));

        jb_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pesquisar.png"))); // NOI18N
        jb_cliente.setName("jb_cliente"); // NOI18N
        jb_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_clienteActionPerformed(evt);
            }
        });
        jb_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_clienteKeyPressed(evt);
            }
        });
        jPanel1.add(jb_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 30, -1));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 500, 80);

        jp_locacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Recebimentos"));
        jp_locacao.setName("jp_locacao"); // NOI18N
        jp_locacao.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtf_valor_lancamento.setText("R$ 0,00");
        jtf_valor_lancamento.setName("jtf_valor_lancamento"); // NOI18N
        jtf_valor_lancamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_valor_lancamentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_valor_lancamentoFocusLost(evt);
            }
        });
        jp_locacao.add(jtf_valor_lancamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 100, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Data Lançamento");
        jLabel3.setName("jLabel3"); // NOI18N
        jp_locacao.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 120, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText("Valor");
        jLabel5.setName("jLabel5"); // NOI18N
        jp_locacao.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 50, -1));

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jtbl_recebimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data Lançamento", "Tipo Serviço", "Descrição", "Tipo D/C", "Valor", "Usuário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbl_recebimento.setName("jtbl_recebimento"); // NOI18N
        jScrollPane2.setViewportView(jtbl_recebimento);
        if (jtbl_recebimento.getColumnModel().getColumnCount() > 0) {
            jtbl_recebimento.getColumnModel().getColumn(0).setResizable(false);
            jtbl_recebimento.getColumnModel().getColumn(0).setPreferredWidth(30);
            jtbl_recebimento.getColumnModel().getColumn(1).setPreferredWidth(30);
            jtbl_recebimento.getColumnModel().getColumn(2).setPreferredWidth(100);
            jtbl_recebimento.getColumnModel().getColumn(3).setPreferredWidth(20);
            jtbl_recebimento.getColumnModel().getColumn(4).setPreferredWidth(50);
            jtbl_recebimento.getColumnModel().getColumn(5).setPreferredWidth(40);
        }

        jp_locacao.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 780, 220));

        jl_codigo_locacao.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jl_codigo_locacao.setText("Serviço");
        jl_codigo_locacao.setName("jl_codigo_locacao"); // NOI18N
        jp_locacao.add(jl_codigo_locacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel27.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel27.setText("Total Crédito:");
        jLabel27.setName("jLabel27"); // NOI18N
        jp_locacao.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 120, 30));

        jLabel28.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel28.setText("Total Débito:");
        jLabel28.setName("jLabel28"); // NOI18N
        jp_locacao.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, 100, 30));

        jtf_total_debito.setEditable(false);
        jtf_total_debito.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtf_total_debito.setText("R$ 0,00");
        jtf_total_debito.setName("jtf_total_debito"); // NOI18N
        jtf_total_debito.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_total_debitoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_total_debitoFocusLost(evt);
            }
        });
        jp_locacao.add(jtf_total_debito, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 130, 30));

        jtf_total_credito.setEditable(false);
        jtf_total_credito.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtf_total_credito.setText("R$ 0,00");
        jtf_total_credito.setName("jtf_total_credito"); // NOI18N
        jtf_total_credito.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_total_creditoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_total_creditoFocusLost(evt);
            }
        });
        jp_locacao.add(jtf_total_credito, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 130, 30));

        jb_adicionar_locacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/edit_add.png"))); // NOI18N
        jb_adicionar_locacao.setToolTipText("Incluir");
        jb_adicionar_locacao.setName("jb_adicionar_locacao"); // NOI18N
        jb_adicionar_locacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_adicionar_locacaoActionPerformed(evt);
            }
        });
        jb_adicionar_locacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_adicionar_locacaoKeyPressed(evt);
            }
        });
        jp_locacao.add(jb_adicionar_locacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 30, 30));

        jb_remover_locacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/edit_remove.png"))); // NOI18N
        jb_remover_locacao.setToolTipText("Excluir");
        jb_remover_locacao.setName("jb_remover_locacao"); // NOI18N
        jb_remover_locacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_remover_locacaoActionPerformed(evt);
            }
        });
        jp_locacao.add(jb_remover_locacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 30, 30));

        jtf_saldo.setEditable(false);
        jtf_saldo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtf_saldo.setText("R$ 0,00");
        jtf_saldo.setName("jtf_saldo"); // NOI18N
        jtf_saldo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_saldoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_saldoFocusLost(evt);
            }
        });
        jp_locacao.add(jtf_saldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, 180, 30));

        jLabel30.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel30.setText("Saldo:");
        jLabel30.setName("jLabel30"); // NOI18N
        jp_locacao.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 70, 30));

        jcb_tipo_servico.setName("jcb_tipo_servico"); // NOI18N
        jp_locacao.add(jcb_tipo_servico, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 250, -1));

        jtf_data_lancamento.setName("jtf_data_lancamento"); // NOI18N
        jtf_data_lancamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_data_lancamentoFocusLost(evt);
            }
        });
        jp_locacao.add(jtf_data_lancamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 110, -1));

        getContentPane().add(jp_locacao);
        jp_locacao.setBounds(10, 100, 830, 404);

        setSize(new java.awt.Dimension(867, 564));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        carregarTipoLancamento();
        jtf_nome_cliente.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F10) {
            enviarDadosLocacao();
        }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
    }//GEN-LAST:event_formKeyReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
//        ((DefaultTableModel) jtbl_recebimento.getModel()).setRowCount(0);
//        jtbl_recebimento.updateUI();
        setStatusTela(false);
        janelapai.setStatusTela(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

private void jb_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_clienteActionPerformed
    consultarClienteAtendimento();
}//GEN-LAST:event_jb_clienteActionPerformed

private void jtf_nome_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nome_clienteKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        consultarClienteAtendimento();
    }
}//GEN-LAST:event_jtf_nome_clienteKeyPressed

private void jtf_nome_clienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_nome_clienteFocusLost

}//GEN-LAST:event_jtf_nome_clienteFocusLost

    private void jtf_total_debitoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_total_debitoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_debitoFocusLost

    private void jtf_total_debitoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_total_debitoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_debitoFocusGained

    private void jtf_total_creditoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_total_creditoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_creditoFocusLost

    private void jtf_total_creditoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_total_creditoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_creditoFocusGained

    private void jb_remover_locacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_remover_locacaoActionPerformed
        excluirProduto();
    }//GEN-LAST:event_jb_remover_locacaoActionPerformed

    private void jb_adicionar_locacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_adicionar_locacaoActionPerformed
        adicionarLancamento();
    }//GEN-LAST:event_jb_adicionar_locacaoActionPerformed

    private void jtf_valor_lancamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_lancamentoFocusLost
        moeda = new Moeda();
        jtf_valor_lancamento.setText(moeda.setPrecoFormat(jtf_valor_lancamento.getText()));
    }//GEN-LAST:event_jtf_valor_lancamentoFocusLost

    private void jtf_valor_lancamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_lancamentoFocusGained
        jtf_valor_lancamento.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (jtf_valor_lancamento.getText().trim().equals("RS")) {
                    JOptionPane.showMessageDialog(null, "Informe o preço");
                    jtf_valor_lancamento.requestFocus();
                    return false;
                } else {
//                    jtf_tipo_midia.requestFocus();
                    return true;
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_lancamentoFocusGained

    private void jb_adicionar_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_adicionar_locacaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            adicionarItemLocado(copiaLocacao);
        }
    }//GEN-LAST:event_jb_adicionar_locacaoKeyPressed

    private void jb_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_clienteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_clienteKeyPressed

    private void jtf_saldoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_saldoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_saldoFocusGained

    private void jtf_saldoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_saldoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_saldoFocusLost

    private void jtf_data_lancamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_data_lancamentoFocusLost
        try {

            if (jtf_data_lancamento.getText().trim().length() < 10) {
                jtf_data_lancamento.setForeground(Color.red);
                jtf_data_lancamento.requestFocus();
            } else if (jtf_data_lancamento.getText().equals("  /  /    ")) {
                jtf_data_lancamento.setForeground(Color.red);
                jtf_data_lancamento.requestFocus();
            } else {
                if (validaData(jtf_data_lancamento.getText())) {

                    jtf_data_lancamento.setForeground(Color.black);
                        //                        jtf_cpf_cliente.requestFocus();

                } else {
                    jtf_data_lancamento.setForeground(Color.red);
                    jtf_data_lancamento.requestFocus();
                }

            }
        } catch (ParseException ex) {
            Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
            jtf_data_lancamento.setForeground(Color.red);
            jtf_data_lancamento.requestFocus();
        } catch (NumberFormatException ex) {
            Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
            jtf_data_lancamento.setText("  /  /    ");
            jtf_data_lancamento.setForeground(Color.red);
            jtf_data_lancamento.requestFocus();
        }
    }//GEN-LAST:event_jtf_data_lancamentoFocusLost

    public void consultarClienteAtendimento() {
        ConsultaClienteAtendimento consultaCliente = new ConsultaClienteAtendimento();
        consultaCliente.janelapaiRecebimento = this;
        consultaCliente.setVisible(true);
        consultaCliente.jtf_consulta.setText(jtf_nome_cliente.getText().trim());
        setStatusTela(false);

    }

    private TelaPrincipal_Interface telaPrincipal;

    public void setTelaPrincipal(TelaPrincipal_Interface telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Recebimento().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jb_adicionar_locacao;
    private javax.swing.JButton jb_cliente;
    private javax.swing.JButton jb_remover_locacao;
    private javax.swing.JComboBox jcb_tipo_servico;
    private javax.swing.JLabel jl_codigo_locacao;
    public static javax.swing.JPanel jp_locacao;
    public static javax.swing.JTable jtbl_recebimento;
    public static javax.swing.JTextField jtf_codigo_cliente;
    public static javax.swing.JFormattedTextField jtf_data_lancamento;
    public static javax.swing.JTextField jtf_nome_cliente;
    public static javax.swing.JTextField jtf_saldo;
    public static javax.swing.JTextField jtf_total_credito;
    public static javax.swing.JTextField jtf_total_debito;
    private javax.swing.JTextField jtf_valor_lancamento;
    // End of variables declaration//GEN-END:variables

    private void enviarDadosLocacao() {
//        if (verificarCampos() == true) {
//            EntradaCaixa entradaCaixa;
//            entradaCaixa = new EntradaCaixa();
//            entradaCaixa.setVisible(true);
//            entradaCaixa.janelapaiLocacao = this;
//        }
    }

    public void setJanelaPai(TelaPrincipal janelapai) {
        this.janelapai = janelapai;
    }

    public void limparCampos() {
//        jtf_codigo_cliente.setText("");
//        jtf_codigo_consulta_locacao.setText("");
//        jtf_valor_locacao.setText("");
//        jtf_tipo_midia.setText("");
//        jtf_diaria.setText("");
    }

    private void excluirProduto() {
        removeObjeto(jtbl_recebimento);
    }

    public void removeObjeto(JTable tb) {
        if (tb != null) {
            DefaultTableModel row = (DefaultTableModel) jtbl_recebimento.getModel();
            if (tb.getSelectedRow() != -1) {
                int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
                if (selectedOption == JOptionPane.YES_NO_OPTION) {
                    retirarValordoTotal(String.valueOf(row.getValueAt(tb.getSelectedRow(), 2)));
                    row.removeRow(tb.getSelectedRow());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um Objeto");
            }
        }
    }

    public boolean verificarCampos() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_codigo_cliente.getText().equals("")) {
            msgERRO = msgERRO + " *Cliente\n";
        }

        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);

            return false;
        } else {
            return true;
        }
    }

    public boolean verificarItemLancamento() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_data_lancamento.getText().trim().length() != 10) {
            msgERRO = msgERRO + " *Data Inválida\n";
        }

        if (jtf_valor_lancamento.getText().trim().equals("R$ 0,00") || jtf_valor_lancamento.getText().trim().equals("R$")) {
            msgERRO = msgERRO + " *Valor Inválido\n";
        }

        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            jtf_nome_objeto_locacao.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public void adicionarLancamento() {

        if (verificarItemLancamento() == true) {
            tipoServico = new TipoServico();
            lancamento = new Lancamento();

            ItemDbGrid hashDbGrid = (ItemDbGrid) jcb_tipo_servico.getSelectedItem();

            tipoServico = (TipoServico) hashDbGrid.getObjeto();
            lancamento.setValor(moeda.getPrecoFormato(jtf_valor_lancamento.getText()));
            lancamento.setTipoServico(tipoServico);
            lancamento.setDependente(dependente);

            pool = new Pool();
            LancamentoDAO lancamentoDAO = new LancamentoDAO(pool);

            ArquivoConfiguracao conf = new ArquivoConfiguracao();

            Usuario usuario = new Usuario();
            usuario.setCod_usuario(Integer.parseInt(conf.readPropertie("codigo_usuario")));

            lancamento.setUsuario(usuario);
            lancamentoDAO.salvarLancamento(lancamento);
            limparItemLancado();
            carregarClienteDependente(dependente);

        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel adicionar ");
        }
    }

    public void adicionarValorTotal(String valor) {
        moeda = new Moeda();
        Double valor_total;
        Double valor_adicionar;
        valor_adicionar = moeda.getPrecoFormato(valor);

        valor_total = moeda.getPrecoFormato(jtf_total_credito.getText());

        valor_total = valor_total + valor_adicionar;

        jtf_total_credito.setText(moeda.setPrecoFormat(String.valueOf(valor_total)));

    }

    public void retirarValordoTotal(String valor) {
        moeda = new Moeda();
        Double valor_total;
        Double valor_remover;
        valor_remover = moeda.getPrecoFormato(valor);

        valor_total = moeda.getPrecoFormato(jtf_total_credito.getText());

        valor_total = valor_total - valor_remover;

        jtf_total_credito.setText(moeda.setPrecoFormat(String.valueOf(valor_total)));

    }

    public void limparItemLancado() {
        jtf_data_lancamento.setText("");
        jcb_tipo_servico.setSelectedIndex(0);
        jtf_valor_lancamento.setText("R$ 0,00");

    }

    public void statusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }

    public void carregarTipoLancamento() {
        List<TipoServico> tipos;
        pool = new Pool();
        TipoServicoDAO tipoServicoDAO = new TipoServicoDAO(pool);
        tipos = tipoServicoDAO.getTipoServicos();

        if (tipos.isEmpty()) {

        } else {
            for (int i = 0; i < tipos.size(); i++) {
                ItemDbGrid hashDbGrid = new ItemDbGrid(tipos.get(i), tipos.get(i).getDescricao());
                jcb_tipo_servico.addItem(hashDbGrid);
                System.out.println(hashDbGrid);
            }
        }
    }

    public void carregarLancamentos(Cliente cliente) {
        if (cliente != null) {
            DefaultTableModel tb_recebimentos = (DefaultTableModel) jtbl_recebimento.getModel();
            int rows = tb_recebimentos.getRowCount();
            for (int i = rows - 1; i >= 0; i--) {
                tb_recebimentos.removeRow(i);
            }
            try {
                pool = new Pool();
                lancamentos = new ArrayList<Lancamento>();
                LancamentoDAO lancamentoDAO = new LancamentoDAO(pool);
                lancamentos = lancamentoDAO.getLancamentos(cliente);

                for (int i = 0; i < lancamentos.size(); i++) {
                    SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

                    String data_lancamento;
                    data_lancamento = out.format(in.parse(lancamentos.get(i).getData_lancamento().toString()));

                    String valor;
                    moeda = new Moeda();
                    valor = String.valueOf(lancamentos.get(i).getValor());

                    valor = moeda.setPrecoFormat(valor);

                    DefaultTableModel row = (DefaultTableModel) jtbl_recebimento.getModel();
                    row.addRow(new Object[]{data_lancamento, lancamentos.get(i).getTipoServico().getCodigo_tipo_servico(),
                        lancamentos.get(i).getTipoServico().getDescricao(), lancamentos.get(i).getTipoServico().getTipo(), valor, lancamentos.get(i).getUsuario().getLogin()});
                }

            } catch (SQLException ex) {
                Logger.getLogger(Recebimento.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(Recebimento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void carregarClienteDependente(Dependente dependente) {
        if (dependente != null) {
            Recebimento.dependente = dependente;
            jtf_total_debito.setText("R$ 0,00");

            jtf_nome_cliente.setText(dependente.getNome_dependente());
            jtf_codigo_cliente.setText(String.valueOf(dependente.getCliente().getCodigo_cliente()));
            Moeda moeda = new Moeda();

            Double debito;
            pool = new Pool();
            DependenteDAO dependenteDAO = new DependenteDAO(pool);

            lancamento = new Lancamento();
            lancamento = dependenteDAO.getClienteDependente(dependente.getCliente().getCodigo_cliente());
            if (lancamento.getSaldo() < 0) {
                lancamento.setSaldo(lancamento.getSaldo() * (-1));
                jtf_total_debito.setText(moeda.setPrecoFormat(String.valueOf(lancamento.getSaldo())));
                jtf_total_debito.setCaretColor(Color.black);
            } else {
                jtf_saldo.setText(moeda.setPrecoFormat(String.valueOf(lancamento.getSaldo())));
                jtf_saldo.setCaretColor(Color.red);
            }

            jtf_total_credito.setText(moeda.setPrecoFormat(String.valueOf(lancamento.getCredito())));
            jtf_total_debito.setText(moeda.setPrecoFormat(String.valueOf(lancamento.getDebito())));

            jtf_data_lancamento.requestFocus();

            //Limpa tabela depois de selecionar novo cliente
            DefaultTableModel tb_locacao = (DefaultTableModel) jtbl_recebimento.getModel();
            int rows = tb_locacao.getRowCount();
            for (int i = rows - 1; i >= 0; i--) {
                tb_locacao.removeRow(i);
            }

            carregarLancamentos(dependente.getCliente());
        }
    }

    public void setStatusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }

}
