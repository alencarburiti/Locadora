package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.LancamentoConta;
import br.com.locadora.model.dao.LancamentoContaDAO;
import br.com.locadora.model.dao.UsuarioDAO;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.Colorir;
import br.com.locadora.util.Data;
import br.com.locadora.util.Moeda;
import br.com.locadora.util.TemaInterface;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.MaskFormatter;

public class FinanceiroPagar extends javax.swing.JFrame {

    public InterfacePool pool;
    public TelaPrincipal janelapai;
    public Moeda moeda;
    public AcessoUsuario acesso;
    public MaskFormatter formatoData;
    public List<LancamentoConta> contas;
    public LancamentoConta lancamentoConta;
    public LancamentoFinanceiro lancamentoFinanceiro;

    public FinanceiroPagar() {
        initComponents();
        TemaInterface.getInterface(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jPanel3 = new javax.swing.JPanel();
        try  {
            formatoData = new MaskFormatter("##/##/####");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");
        }
        jtf_data_inicial = new JFormattedTextField(formatoData);
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        try  {
            formatoData = new MaskFormatter("##/##/####");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");
        }
        jtf_data_final = new JFormattedTextField(formatoData);
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_contas = new javax.swing.JTable();
        jl_rodape = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jb_altera_lancamento = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jDesktopPane1.setName("jDesktopPane1"); // NOI18N
        jDesktopPane1.setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Financeiro - Contas à pagar");
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

        jDesktopPane2.setName("jDesktopPane2"); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));
        jPanel3.setName("jPanel3"); // NOI18N

        jtf_data_inicial.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_data_inicial.setName("jtf_data_inicial"); // NOI18N
        jtf_data_inicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_data_inicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_data_inicialFocusLost(evt);
            }
        });
        jtf_data_inicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_data_inicialKeyPressed(evt);
            }
        });

        jLabel2.setText("Data Inicial");
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText("Data Final");
        jLabel3.setName("jLabel3"); // NOI18N

        jtf_data_final.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_data_final.setName("jtf_data_final"); // NOI18N
        jtf_data_final.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_data_finalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_data_finalFocusLost(evt);
            }
        });
        jtf_data_final.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_data_finalKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_data_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_data_final, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(10, 10, 10))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtf_data_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtf_data_final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jtbl_contas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtbl_contas.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtbl_contas.setForeground(new java.awt.Color(0, 153, 0));
        jtbl_contas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fornecedor", "Descrição", "Documento", "Preço Duplicata", "Vencimento", "Valor Pago", "Data Pagamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbl_contas.setGridColor(new java.awt.Color(153, 153, 153));
        jtbl_contas.setName("jtbl_contas"); // NOI18N
        jtbl_contas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_contasMouseClicked(evt);
            }
        });
        jtbl_contas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbl_contasKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtbl_contas);
        if (jtbl_contas.getColumnModel().getColumnCount() > 0) {
            jtbl_contas.getColumnModel().getColumn(0).setPreferredWidth(150);
            jtbl_contas.getColumnModel().getColumn(1).setPreferredWidth(150);
            jtbl_contas.getColumnModel().getColumn(2).setPreferredWidth(50);
            jtbl_contas.getColumnModel().getColumn(3).setPreferredWidth(30);
            jtbl_contas.getColumnModel().getColumn(4).setPreferredWidth(50);
            jtbl_contas.getColumnModel().getColumn(5).setPreferredWidth(30);
            jtbl_contas.getColumnModel().getColumn(6).setPreferredWidth(50);
        }

        jl_rodape.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jl_rodape.setText("Total à pagar: R$ 0,00 - Total pago: R$ 0,00");
        jl_rodape.setName("jl_rodape"); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/novo_registro.gif"))); // NOI18N
        jButton1.setText("Novo Lançamento");
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/delete.gif"))); // NOI18N
        jButton2.setText("Excluir Lançamento");
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/reload.png"))); // NOI18N
        jButton3.setName("jButton3"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jb_altera_lancamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/alterar_registro.gif"))); // NOI18N
        jb_altera_lancamento.setText("Atualizar Lançamento");
        jb_altera_lancamento.setName("jb_altera_lancamento"); // NOI18N
        jb_altera_lancamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_altera_lancamentoActionPerformed(evt);
            }
        });

        jMenuBar1.setName("jMenuBar1"); // NOI18N

        jMenu3.setText("Cadastro");
        jMenu3.setName("jMenu3"); // NOI18N

        jMenuItem3.setText("Fornecedor");
        jMenuItem3.setName("jMenuItem3"); // NOI18N
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        jMenu1.setText("Lançamento");
        jMenu1.setName("jMenu1"); // NOI18N

        jMenuItem1.setText("Novo Lançamento");
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem4.setText("Alterar Lançamento");
        jMenuItem4.setName("jMenuItem4"); // NOI18N
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem2.setText("Excluir Lançamento");
        jMenuItem2.setName("jMenuItem2"); // NOI18N
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Sair");
        jMenu2.setName("jMenu2"); // NOI18N
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(767, 767, 767)
                                .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(498, 498, 498)
                                .addComponent(jl_rodape, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(10, 10, 10)
                        .addComponent(jb_altera_lancamento)
                        .addGap(10, 10, 10)
                        .addComponent(jButton2)
                        .addGap(10, 10, 10)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jb_altera_lancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jl_rodape)
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Calendar primeiroDia = Calendar.getInstance();
        primeiroDia.set(Calendar.DAY_OF_MONTH, 1);

        Calendar ultimoDia = Calendar.getInstance();
        ultimoDia.add(Calendar.MONTH, 1);
        ultimoDia.set(Calendar.DAY_OF_MONTH, 1);
        ultimoDia.add(Calendar.DAY_OF_MONTH, -1);

        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

        String data_inicial = out.format(primeiroDia.getTime());
        String data_final = out.format(ultimoDia.getTime());

        jtf_data_inicial.setText(data_inicial);
        jtf_data_final.setText(data_final);
        
        consultarContas();
    }//GEN-LAST:event_formWindowOpened

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F10) {
//            abrirCaixa();
        }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
    }//GEN-LAST:event_formKeyReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ((DefaultTableModel) jtbl_contas.getModel()).setRowCount(0);
        jtbl_contas.updateUI();
        retornaJanelaPai();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void jtbl_contasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_contasKeyPressed

// TODO add your handling code here:
    }//GEN-LAST:event_jtbl_contasKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        novoLancamento();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtf_data_inicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_data_inicialFocusLost
        try {
            if (jtf_data_inicial.getText().trim().length() < 10) {
                jtf_data_inicial.setForeground(Color.red);
            } else if (jtf_data_inicial.getText().equals("  /  /    ")) {
                jtf_data_inicial.setForeground(Color.red);
            }
        } catch (NumberFormatException ex) {            
            jtf_data_inicial.setText("  /  /    ");
            jtf_data_inicial.setForeground(Color.red);
        }
    }//GEN-LAST:event_jtf_data_inicialFocusLost

    private void jtf_data_inicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_data_inicialKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_data_final.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_inicialKeyPressed

    private void jtf_data_finalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_data_finalFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_finalFocusLost

    private void jtf_data_finalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_data_finalKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_finalKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        excluirLancamento();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        novoLancamento();
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        consultarContas();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jb_altera_lancamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_altera_lancamentoActionPerformed
        alterarLancamento();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_altera_lancamentoActionPerformed

    private void jtbl_contasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_contasMouseClicked
        if (evt.getClickCount() > 1) {
            alterarLancamento();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_contasMouseClicked

    private void jtf_data_inicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_data_inicialFocusGained
        jtf_data_inicial.setSelectionStart(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_inicialFocusGained

    private void jtf_data_finalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_data_finalFocusGained
        jtf_data_final.setSelectionStart(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_finalFocusGained

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        alterarLancamento();
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        excluirLancamento();
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FinanceiroPagar().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jb_altera_lancamento;
    private javax.swing.JLabel jl_rodape;
    public static javax.swing.JTable jtbl_contas;
    public static javax.swing.JFormattedTextField jtf_data_final;
    public static javax.swing.JFormattedTextField jtf_data_inicial;
    // End of variables declaration//GEN-END:variables

    public LancamentoConta tbFornecedorLinhaSelecionada(JTable tb) {

        if (tb.getSelectedRow() != -1) {
            lancamentoConta = contas.get(tb.getSelectedRow());
        } else {
            lancamentoConta = null;
        }
        return lancamentoConta;
    }

    public void alterarLancamento() {
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuCliente");
        try {
            if (acesso.getEscrever() == true) {
                lancamentoConta = tbFornecedorLinhaSelecionada(jtbl_contas);
                if (lancamentoConta != null) {
                    lancamentoFinanceiro = new LancamentoFinanceiro(lancamentoConta);
                    lancamentoFinanceiro.janelapai = this;
                    lancamentoFinanceiro.setVisible(true);                    
                    lancamentoFinanceiro.acesso = acesso;
                } else {
                    lancamentoFinanceiro.setVisible(true);                    
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
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
//            abrirCaixa();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            retornaJanelaPai();
        }
    }

    private void retornaJanelaPai() {
        setVisible(false);
        if (janelapai != null) {
            janelapai.setStatusTela(true);
            janelapai.atendimentoLocacao = null;
            janelapai = null;
        }
    }

    private void mostrarContas(List<LancamentoConta> contas) throws ParseException {
        DefaultTableModel tableModel = (DefaultTableModel) jtbl_contas.getModel();
        tableModel.setNumRows(0);

        if (contas.size() == 0) {
            JOptionPane.showMessageDialog(null, "Nenhuma conta encontrada");

        } else {
            moeda = new Moeda();
            Double total = 0.00;
            Double total_pago = 0.00;
            for (int i = 0; i < contas.size(); i++) {
                total = total + contas.get(i).getValor();
                total_pago = total_pago + contas.get(i).getValorPago();

                SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
                String data_vencimento = out.format(in.parse(contas.get(i).getData_vencimento().toString()));
                String data_pagamento = "";
                try {
                    data_pagamento = out.format(in.parse(contas.get(i).getData_pagamento().toString()));
                } catch (Exception e) {
                }

                DefaultTableModel row = (DefaultTableModel) jtbl_contas.getModel();

                row.addRow(new Object[]{contas.get(i).getFornecedor().getNome_fantasia(),
                    contas.get(i).getDescricao(), contas.get(i).getDocumento(),
                    moeda.setPrecoFormat(contas.get(i).getValor().toString()),
                    data_vencimento,
                    moeda.setPrecoFormat(contas.get(i).getValorPago().toString()),
                    data_pagamento});
            }

            TableCellRenderer tcr = new Colorir();
            TableColumn column = jtbl_contas.getColumnModel().getColumn(0);
            column.setCellRenderer(tcr);
            column = jtbl_contas.getColumnModel().getColumn(1);
            column.setCellRenderer(tcr);
            column = jtbl_contas.getColumnModel().getColumn(2);
            column.setCellRenderer(tcr);
            column = jtbl_contas.getColumnModel().getColumn(3);
            column.setCellRenderer(tcr);
            column = jtbl_contas.getColumnModel().getColumn(4);
            column.setCellRenderer(tcr);
            column = jtbl_contas.getColumnModel().getColumn(5);
            column.setCellRenderer(tcr);
            column = jtbl_contas.getColumnModel().getColumn(6);
            column.setCellRenderer(tcr);
            
            String rodape = "Total Pago: " + moeda.setPrecoFormat(total_pago.toString()) + " - Total à pagar:  "
                    + moeda.setPrecoFormat(total.toString());
            jl_rodape.setText(rodape);
            
            jtbl_contas.requestFocus();
        }

    }

    public void consultarContas() {
        SimpleDateFormat in = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");

        String dataInicial = null;
        String dataFinal = null;
        try {
            dataInicial = out.format(in.parse(jtf_data_inicial.getText()));
            dataFinal = out.format(in.parse(jtf_data_final.getText()));
        } catch (ParseException ex) {
//            Logger.getLogger(MenuRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }

        pool = new Pool();
        LancamentoContaDAO lancDAO = new LancamentoContaDAO(pool);
        contas = lancDAO.getLancamentoContas(dataInicial, dataFinal);

        try {
            mostrarContas(contas);
        } catch (ParseException ex) {
            Logger.getLogger(FinanceiroPagar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void novoLancamento() {
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuCliente");
        try {
            if (acesso.getEscrever() == true) {
                LancamentoFinanceiro lancamentoFinanceiro = new LancamentoFinanceiro();
                lancamentoFinanceiro.janelapai = this;
                lancamentoFinanceiro.setVisible(true);
                lancamentoFinanceiro.acesso = acesso;
            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }
    }

    private void excluirLancamento() {
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuCliente");
        try {
            if (acesso.getDeletar() == true) {
                
                lancamentoConta = tbFornecedorLinhaSelecionada(jtbl_contas);
                if (lancamentoConta != null) {
                    pool = new Pool();
                    LancamentoContaDAO lancamentoDAO = new LancamentoContaDAO(pool);
                    lancamentoDAO.excluir(lancamentoConta.getCodigo_lancamento_contas());                    
                    consultarContas();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }
    }

}
