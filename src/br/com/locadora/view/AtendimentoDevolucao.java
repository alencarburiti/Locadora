package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.controller.SiscomController;
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.ItemLocacao;
import br.com.locadora.model.bean.Objeto;
import br.com.locadora.model.bean.Produto;
import br.com.locadora.model.dao.DependenteDAO;
import br.com.locadora.model.dao.LocacaoDAO;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.Moeda;
import static br.com.locadora.view.AtendimentoLocacao.jtbl_locacao;
import static br.com.locadora.view.AtendimentoLocacao.jtf_codigo_cliente;
import static br.com.locadora.view.AtendimentoLocacao.jtf_debito_total_locacao;
import static br.com.locadora.view.AtendimentoLocacao.jtf_nome_cliente;
import static br.com.locadora.view.AtendimentoLocacao.jtf_valor_total_locacao;
import static br.com.locadora.view.Recebimento.jtf_nome_objeto_locacao;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class AtendimentoDevolucao extends javax.swing.JFrame implements AtendimentoDevolucao_InterFace {

    public DecimalFormat formatoPreco;
    public MaskFormatter formatoData;
    public String permissao;
    public Cliente cliente;
    public static Dependente dependente = new Dependente();
    public Objeto objeto;
    public Copia copiaLocacao;
    public Copia copiaDevolucao;
    public List<Copia> copias;
    public static List<Copia> copiasLocacao = new ArrayList<Copia>();
    public List<Produto> produtos;
    public Produto produto;
    private Date data;
    public InterfacePool pool;
    public SiscomController controller;
    public TelaPrincipal janelapai;
    public static List<ItemLocacao> itensDevolucao = new ArrayList<ItemLocacao>();
    public ItemLocacao itemDevolucao;
    public Moeda moeda;

    public AtendimentoDevolucao() {
        initComponents();
    }

    public void setTela(String permissao) {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jtp_locacao = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbl_devolucao = new javax.swing.JTable();
        jtf_nome_objeto_devolucao = new javax.swing.JTextField();
        jl_codigo_devolucao = new javax.swing.JLabel();
        jtf_codigo_consulta_devolucao = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jtf_valor_total = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jtf_debito_total_devolucao = new javax.swing.JTextField();
        jcb_codigo_barras_devolucao = new javax.swing.JCheckBox();
        jLabel34 = new javax.swing.JLabel();
        jtf_valor_a_pagar = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jtf_valor_multa = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtf_codigo_cliente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtf_nome_cliente = new javax.swing.JTextField();
        jb_cliente = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        jDesktopPane1.setName("jDesktopPane1"); // NOI18N
        jDesktopPane1.setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atendimento");
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

        jtp_locacao.setName("jtp_locacao"); // NOI18N
        jtp_locacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtp_locacaoFocusGained(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens"));
        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("Nome Objeto");
        jLabel4.setName("jLabel4"); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 300, -1));

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        jtbl_devolucao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código de Barras", "Nome Objeto", "Data Locação", "Á Pagar", "Valor Multa", "Dia Atraso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbl_devolucao.setName("jtbl_devolucao"); // NOI18N
        jScrollPane3.setViewportView(jtbl_devolucao);
        if (jtbl_devolucao.getColumnModel().getColumnCount() > 0) {
            jtbl_devolucao.getColumnModel().getColumn(0).setPreferredWidth(40);
            jtbl_devolucao.getColumnModel().getColumn(1).setPreferredWidth(100);
            jtbl_devolucao.getColumnModel().getColumn(2).setPreferredWidth(30);
            jtbl_devolucao.getColumnModel().getColumn(4).setPreferredWidth(20);
            jtbl_devolucao.getColumnModel().getColumn(5).setPreferredWidth(20);
        }

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 780, 220));

        jtf_nome_objeto_devolucao.setEditable(false);
        jtf_nome_objeto_devolucao.setName("jtf_nome_objeto_devolucao"); // NOI18N
        jtf_nome_objeto_devolucao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_nome_objeto_devolucaoFocusGained(evt);
            }
        });
        jtf_nome_objeto_devolucao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_nome_objeto_devolucaoKeyPressed(evt);
            }
        });
        jPanel3.add(jtf_nome_objeto_devolucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 270, -1));

        jl_codigo_devolucao.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jl_codigo_devolucao.setText("Código do Objeto");
        jl_codigo_devolucao.setName("jl_codigo_devolucao"); // NOI18N
        jPanel3.add(jl_codigo_devolucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jtf_codigo_consulta_devolucao.setName("jtf_codigo_consulta_devolucao"); // NOI18N
        jtf_codigo_consulta_devolucao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_codigo_consulta_devolucaoFocusGained(evt);
            }
        });
        jtf_codigo_consulta_devolucao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_codigo_consulta_devolucaoKeyPressed(evt);
            }
        });
        jPanel3.add(jtf_codigo_consulta_devolucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 120, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pesquisar.png"))); // NOI18N
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 30, 30));

        jLabel32.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel32.setText("Total");
        jLabel32.setName("jLabel32"); // NOI18N
        jPanel3.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 390, 60, 30));

        jtf_valor_total.setEditable(false);
        jtf_valor_total.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtf_valor_total.setText("R$ 0,00");
        jtf_valor_total.setName("jtf_valor_total"); // NOI18N
        jtf_valor_total.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_valor_totalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_valor_totalFocusLost(evt);
            }
        });
        jPanel3.add(jtf_valor_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 390, 130, 30));

        jLabel33.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel33.setText("Débito Total");
        jLabel33.setName("jLabel33"); // NOI18N
        jPanel3.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, 100, 30));

        jtf_debito_total_devolucao.setEditable(false);
        jtf_debito_total_devolucao.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtf_debito_total_devolucao.setText("R$ 0,00");
        jtf_debito_total_devolucao.setName("jtf_debito_total_devolucao"); // NOI18N
        jtf_debito_total_devolucao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_debito_total_devolucaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_debito_total_devolucaoFocusLost(evt);
            }
        });
        jPanel3.add(jtf_debito_total_devolucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 300, 130, 30));

        jcb_codigo_barras_devolucao.setSelected(true);
        jcb_codigo_barras_devolucao.setText("Usar Código de Barras");
        jcb_codigo_barras_devolucao.setName("jcb_codigo_barras_devolucao"); // NOI18N
        jcb_codigo_barras_devolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_codigo_barras_devolucaoActionPerformed(evt);
            }
        });
        jPanel3.add(jcb_codigo_barras_devolucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, 30));

        jLabel34.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel34.setText("Á Pagar");
        jLabel34.setName("jLabel34"); // NOI18N
        jPanel3.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 330, 90, 30));

        jtf_valor_a_pagar.setEditable(false);
        jtf_valor_a_pagar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtf_valor_a_pagar.setText("R$ 0,00");
        jtf_valor_a_pagar.setName("jtf_valor_a_pagar"); // NOI18N
        jtf_valor_a_pagar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_valor_a_pagarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_valor_a_pagarFocusLost(evt);
            }
        });
        jPanel3.add(jtf_valor_a_pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 330, 130, 30));

        jLabel35.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel35.setText("Multa");
        jLabel35.setName("jLabel35"); // NOI18N
        jPanel3.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 360, 90, 30));

        jtf_valor_multa.setEditable(false);
        jtf_valor_multa.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtf_valor_multa.setText("R$ 0,00");
        jtf_valor_multa.setName("jtf_valor_multa"); // NOI18N
        jtf_valor_multa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_valor_multaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_valor_multaFocusLost(evt);
            }
        });
        jPanel3.add(jtf_valor_multa, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 360, 130, 30));

        jButton11.setText("Finalizar");
        jButton11.setName("jButton11"); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 110, 50));

        jButton10.setText("Limpar");
        jButton10.setName("jButton10"); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 100, 50));

        jtp_locacao.addTab("Devolução", jPanel3);

        getContentPane().add(jtp_locacao);
        jtp_locacao.setBounds(0, 90, 850, 480);

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
        jPanel1.add(jb_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 30, -1));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 500, 80);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Atendente"));
        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "alencarburiti", "teste\t", "eliesioxavier", "Item 4" }));
        jComboBox1.setName("jComboBox1"); // NOI18N
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/reload.png"))); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        getContentPane().add(jPanel2);
        jPanel2.setBounds(610, 10, 200, 80);

        setSize(new java.awt.Dimension(871, 608));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtf_codigo_consulta_devolucao.requestFocus();

        if (jcb_codigo_barras_devolucao.isSelected() == true) {
            jl_codigo_devolucao.setText("Código de Barras");
            jtf_codigo_consulta_devolucao.requestFocus();
        } else {
            jl_codigo_devolucao.setText("Código dó Objeto");
            jtf_codigo_consulta_devolucao.requestFocus();
        }
    }//GEN-LAST:event_formWindowOpened

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
    }//GEN-LAST:event_formKeyReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
//        ((DefaultTableModel) jtbl_locacao.getModel()).setRowCount(0);
//        jtbl_locacao.updateUI();
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

private void jb_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_clienteActionPerformed
    ConsultaClienteAtendimento consultaCliente = new ConsultaClienteAtendimento();
    consultaCliente.setTelaAtendimento(this);
    consultaCliente.janelapaiDevolucao = this;
    consultaCliente.setVisible(true);
    jtf_codigo_cliente.setText("");
//    consultaCliente.jtf_consulta.setText(jtf_nome_cliente.getText().trim());
//    setStatusTela(false);
    // TODO add your handling code here:
}//GEN-LAST:event_jb_clienteActionPerformed

private void jtf_nome_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nome_clienteKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        ConsultaClienteAtendimento consultaCliente = new ConsultaClienteAtendimento();
        consultaCliente.setTelaAtendimento(this);;
        consultaCliente.janelapaiDevolucao = this;
        consultaCliente.setVisible(true);
        jtf_codigo_cliente.setText("");
        consultaCliente.jtf_consulta.setText(jtf_nome_cliente.getText().trim());
    }
}//GEN-LAST:event_jtf_nome_clienteKeyPressed

private void jtf_nome_clienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_nome_clienteFocusLost

}//GEN-LAST:event_jtf_nome_clienteFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ConsultaCopiaDevolucao copiaDevolucao = new ConsultaCopiaDevolucao();
        copiaDevolucao.setTelaAtendimento(this);
        copiaDevolucao.janelapaiDevolucao = this;
        copiaDevolucao.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jtf_nome_objeto_devolucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nome_objeto_devolucaoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nome_objeto_devolucaoKeyPressed

    private void jtf_nome_objeto_devolucaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_nome_objeto_devolucaoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nome_objeto_devolucaoFocusGained

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        jtf_codigo_cliente.setText("");
        jtf_nome_cliente.setText("");
        jtf_valor_total.setText("R$ 0,00");
        jtf_debito_total_devolucao.setText("R$ 0,00");

        DefaultTableModel tb_devolucao = (DefaultTableModel) jtbl_devolucao.getModel();
        int rows = tb_devolucao.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            tb_devolucao.removeRow(i);
        }
        jtf_codigo_consulta_devolucao.setText("");
        jtf_codigo_consulta_devolucao.requestFocus();

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jtp_locacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtp_locacaoFocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_jtp_locacaoFocusGained

    private void jtf_valor_totalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_totalFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_totalFocusGained

    private void jtf_valor_totalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_totalFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_totalFocusLost

    private void jtf_debito_total_devolucaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_debito_total_devolucaoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_debito_total_devolucaoFocusGained

    private void jtf_debito_total_devolucaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_debito_total_devolucaoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_debito_total_devolucaoFocusLost

    private void jcb_codigo_barras_devolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_codigo_barras_devolucaoActionPerformed
        if (jcb_codigo_barras_devolucao.isSelected() == true) {
            jl_codigo_devolucao.setText("Código de Barras");
            jtf_codigo_consulta_devolucao.requestFocus();
        } else {
            jl_codigo_devolucao.setText("Código do Objeto");
            jtf_codigo_consulta_devolucao.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_codigo_barras_devolucaoActionPerformed

    private void jtf_codigo_consulta_devolucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_codigo_consulta_devolucaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            if (jcb_codigo_barras_devolucao.isSelected() == true) {
                consultarCopiaLocada(jtf_codigo_consulta_devolucao.getText().trim());
            } else {
//                    devolver_consulta_codigo_barras(jtf_codigo_consulta_devolucao.getText().trim());
            }

            if (jcb_codigo_barras_devolucao.isSelected() == true) {

            } else {
//                    devolver_consulta_codigo_barras(jtf_codigo_consulta_devolucao.getText().trim());
            }

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_codigo_consulta_devolucaoKeyPressed

    private void jtf_codigo_consulta_devolucaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_codigo_consulta_devolucaoFocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_codigo_consulta_devolucaoFocusGained

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        enviarDadosDevolucao();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jtf_valor_a_pagarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_a_pagarFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_a_pagarFocusGained

    private void jtf_valor_a_pagarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_a_pagarFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_a_pagarFocusLost

    private void jtf_valor_multaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_multaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_multaFocusGained

    private void jtf_valor_multaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_multaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_multaFocusLost
    public static boolean validaData(String dataString) throws java.text.ParseException {
        if (!dataString.equals("")) {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Calendar cal = new GregorianCalendar();
            Date dataDigitada = new Date(df.parse(dataString).getTime());
            Date dataAtual = new Date(System.currentTimeMillis());

            // gerando o calendar
            cal.setTime(df.parse(dataString));

            // separando os dados da string para comparacao e validacao
            String[] data = dataString.split("/");
            String dia = data[0];
            String mes = data[1];
            String ano = data[2];

            // testando se ha discrepancia entre a data que foi
            // inserida no caledar e a data que foi passada como
            // string. se houver diferenca, a data passada era
            // invalida
            if ((new Integer(dia)).intValue() != (new Integer(cal.get(Calendar.DAY_OF_MONTH))).intValue()) {
                // dia nao casou
                return (false);
            }
            if ((new Integer(mes)).intValue() != (new Integer(cal.get(Calendar.MONTH) + 1)).intValue()) {
                // mes nao casou

                return (false);
            }
            if ((new Integer(ano)).intValue() != (new Integer(cal.get(Calendar.YEAR))).intValue()) {
                // ano nao casou

                return (false);
            }
            if (dataDigitada.after(dataAtual)) {
                // data maior que atual
                return (false);
            }
        }
        return (true);
    }

    private TelaPrincipal_Interface telaPrincipal;

    public void setTelaPrincipal(TelaPrincipal_Interface telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
    }

    public boolean validaDataVencimento(String dataString) throws ParseException {
        if (!dataString.equals("")) {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Calendar cal = new GregorianCalendar();
            Date dataDigitada = new Date(df.parse(dataString).getTime());
            Date dataAtual = new Date(System.currentTimeMillis());

            // gerando o calendar
            cal.setTime(df.parse(dataString));

            // separando os dados da string para comparacao e validacao
            String[] data = dataString.split("/");
            String dia = data[0];
            String mes = data[1];
            String ano = data[2];
            // testando se hah discrepancia entre a data que foi
            // inserida no caledar e a data que foi passada como
            // string. se houver diferenca, a data passada era
            // invalida
            if ((new Integer(dia)).intValue() != (new Integer(cal.get(Calendar.DAY_OF_MONTH))).intValue()) {
                // dia nao caso
                return false;
            } else if ((new Integer(mes)).intValue() != (new Integer(cal.get(Calendar.MONTH) + 1)).intValue()) {
                // mes nao casou
                return false;
            } else if ((new Integer(ano)).intValue() != (new Integer(cal.get(Calendar.YEAR))).intValue()) {
                // ano nao casou
                return false;
            } else if (dataAtual.after(dataDigitada)) {
                // data maior que atual
                return false;
            }
        }
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new AtendimentoDevolucao().setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jb_cliente;
    private javax.swing.JCheckBox jcb_codigo_barras_devolucao;
    private javax.swing.JLabel jl_codigo_devolucao;
    public static javax.swing.JTable jtbl_devolucao;
    public static javax.swing.JTextField jtf_codigo_cliente;
    private javax.swing.JTextField jtf_codigo_consulta_devolucao;
    public static javax.swing.JTextField jtf_debito_total_devolucao;
    public static javax.swing.JTextField jtf_nome_cliente;
    private javax.swing.JTextField jtf_nome_objeto_devolucao;
    public static javax.swing.JTextField jtf_valor_a_pagar;
    public static javax.swing.JTextField jtf_valor_multa;
    public static javax.swing.JTextField jtf_valor_total;
    private javax.swing.JTabbedPane jtp_locacao;
    // End of variables declaration//GEN-END:variables

    private void enviarDadosDevolucao() {
        if (verificarCampos() == true) {
            EntradaCaixaDevolucao entradaCaixaDevolucao;
            entradaCaixaDevolucao = new EntradaCaixaDevolucao();
            entradaCaixaDevolucao.setVisible(true);
            entradaCaixaDevolucao.janelapaiDevolucao = this;
        }
    }

    public void setJanelaPai(TelaPrincipal janelapai) {
        if (janelapai != null) {
            this.janelapai = janelapai;
        } else {
            JOptionPane.showMessageDialog(null, "Janela pai sem referência");
        }
    }

    public void removeObjeto(JTable tb) {
        if (tb != null) {
            DefaultTableModel row = (DefaultTableModel) jtbl_devolucao.getModel();
            if (tb.getSelectedRow() != -1) {
                int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
                if (selectedOption == JOptionPane.YES_NO_OPTION) {
                    row.removeRow(tb.getSelectedRow());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um Objeto");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Tabela vazia");
        }
    }

    public boolean verificarCampos() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_codigo_cliente.getText().equals("")) {
            msgERRO = msgERRO + " *Cliente\n";
        }

        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            jtf_codigo_consulta_devolucao.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public void adicionarItemDevolvido(ItemLocacao itemLocacao) {
        if (itemLocacao != null) {
            if (verificaTabela(itemLocacao) == false) {
                try {
                    SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
                    
                    Moeda moeda = new Moeda();
                    String data_locacao;
                    data_locacao = out.format(in.parse(itemLocacao.getData_locacao().toString()));

                    Double devedor;
                    Double valor_locado;
                    Double valor_pago;
                    Double multa;
                    
                    valor_locado = itemLocacao.getValor_locado();
                    valor_pago = itemLocacao.getValor_pago();
                    multa = itemLocacao.getValor_multa();
                    devedor = valor_locado - valor_pago;
                    adicionarAPagar(devedor);
                    adicionarMulta(multa);
                    adicionarValorTotal(devedor+multa);
                    
                    DefaultTableModel row = (DefaultTableModel) AtendimentoDevolucao.jtbl_devolucao.getModel();
                    ItemDbGrid hashDbGrid = new ItemDbGrid(itemLocacao, itemLocacao.getCopia().getObjeto().getDescricao_objeto());
                    row.addRow(new Object[]{itemLocacao.getCopia().getCodigo_barras(), hashDbGrid, data_locacao,
                        moeda.setPrecoFormat(String.valueOf(devedor)),
                    moeda.setPrecoFormat(String.valueOf(itemLocacao.getValor_multa())), itemLocacao.getDias_multa()});

                    itensDevolucao.add(itemLocacao);
                    limparItemDevolvido();
                } catch (ParseException ex) {
                    Logger.getLogger(AtendimentoDevolucao.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Esta cópia já foi adicionada");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Objeto inválido para adicionar");
        }
    }

    public void limparItemDevolvido() {
        jtf_nome_objeto_devolucao.setText("");
        jtf_codigo_consulta_devolucao.setText("");
        jtf_codigo_consulta_devolucao.requestFocus();
    }

    public void statusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }

    public void carregarCopiaDevolucao(ItemLocacao itemDev) {

        if (itemDev != null) {
            this.itemDevolucao = itemDev;
            if (jcb_codigo_barras_devolucao.isSelected() == true) {
                if (!itemDevolucao.getCopia().getCodigo_barras().equals("")) {
                    jtf_codigo_consulta_devolucao.setText(itemDevolucao.getCopia().getCodigo_barras());
                } else {
                    System.out.println("Error ao carregar cópia");
                }
            } else {
                jtf_codigo_consulta_devolucao.setText(String.valueOf(itemDevolucao.getCopia().getCodigo_copia()));
            }
            jtf_nome_objeto_devolucao.setText(itemDevolucao.getCopia().getObjeto().getDescricao_objeto());

        } else {
            JOptionPane.showMessageDialog(null, "Error grave no método carregarCopiaDevolucao");
        }

    }

    public void carregarClienteDependente(Dependente dependente) {
        if (dependente != null) {
            AtendimentoDevolucao.dependente = dependente;
            jtf_debito_total_devolucao.setText("R$ 0,00");

            jtf_nome_cliente.setText(dependente.getNome_dependente());
            jtf_codigo_cliente.setText(String.valueOf(dependente.getCliente().getCodigo_cliente()));
            Moeda moeda = new Moeda();

            String debito;
            pool = new Pool();
            DependenteDAO dependenteDAO = new DependenteDAO(pool);
            
            debito = dependenteDAO.getClienteDependente(Integer.parseInt(jtf_codigo_cliente.getText()));
            debito = moeda.setPrecoFormat(debito);
            jtf_debito_total_devolucao.setText(debito);

            jtf_codigo_consulta_devolucao.requestFocus();

            //Limpa tabela depois de selecionar novo cliente
            DefaultTableModel tb_devolucao = (DefaultTableModel) jtbl_devolucao.getModel();
            int rows = tb_devolucao.getRowCount();
            for (int i = rows - 1; i >= 0; i--) {
                tb_devolucao.removeRow(i);
            }

            jtf_valor_total.setText("R$ 0,00");

        }
    }

    public void setStatusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);

    }

    public void consultarCopiaLocada(String codigo_barras) {
        try {
            pool = new Pool();
            LocacaoDAO locacaoDAO = new LocacaoDAO(pool);

            itemDevolucao = new ItemLocacao();
            if (!codigo_barras.equals("")) {
                if (jtf_codigo_cliente.getText().equals("")) {
                    itemDevolucao = locacaoDAO.getLocacaoAberta(codigo_barras);
                    if (itemDevolucao != null) {
                        carregarClienteDependente(itemDevolucao.getDependente());
                        adicionarItemDevolvido(itemDevolucao);
                    } else {
                        JOptionPane.showMessageDialog(null, "Código de Barra inválido");
                    }
                } else {
                    itemDevolucao = locacaoDAO.getLocacaoAberta(dependente.getCodigo_dependente(), codigo_barras);
                    if (itemDevolucao != null) {
                        adicionarItemDevolvido(itemDevolucao);
                    } else {
                        JOptionPane.showMessageDialog(null, "Código de Barra inválido para Cliente");
                    }
                }
            } else {
                System.out.print("Código de barras vazio");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas com a consulta");
            ex.printStackTrace();
        }
    }

    public void devolver_consulta_codigo_objeto(String codigo_barras) {
        if (!codigo_barras.equals("")) {            
            itemDevolucao = new ItemLocacao();
            if (itemDevolucao != null) {
                carregarCopiaDevolucao(itemDevolucao);
            } else {
                JOptionPane.showMessageDialog(null, "Código de Barra inválido");
            }
        }
    }

    public boolean verificaTabela(ItemLocacao itemLocacao) {

        boolean tabela = true;
        if (jtbl_devolucao.getRowCount() == 0) {
            return false;

        } else if (jtbl_devolucao.getRowCount() > 0) {
            int linhas = jtbl_devolucao.getRowCount();

            for (int i = 0; i < linhas; i++) {
                tabela = itemLocacao.getCopia().getCodigo_barras().equals(jtbl_devolucao.getValueAt(i, 0));
                if (tabela == true) {
                    break;
                }
            }
        }

        return tabela;
    }
    
    public void adicionarValorTotal(Double valor) {
        moeda = new Moeda();
        Double valor_total;
        Double valor_adicionar;
        valor_adicionar = valor;

        valor_total = moeda.getPrecoFormato(jtf_valor_total.getText());

        valor_total = valor_total + valor_adicionar;

        jtf_valor_total.setText(moeda.setPrecoFormat(String.valueOf(valor_total)));
    }
    
    public void adicionarAPagar(Double valor) {
        moeda = new Moeda();
        Double valor_total;
        Double valor_adicionar;
        valor_adicionar = valor;

        valor_total = moeda.getPrecoFormato(jtf_valor_a_pagar.getText());

        valor_total = valor_total + valor_adicionar;

        jtf_valor_a_pagar.setText(moeda.setPrecoFormat(String.valueOf(valor_total)));
    }
    public void adicionarMulta(Double valor) {
        moeda = new Moeda();
        Double valor_total;
        Double valor_adicionar;
        valor_adicionar = valor;

        valor_total = moeda.getPrecoFormato(jtf_valor_multa.getText());

        valor_total = valor_total + valor_adicionar;

        jtf_valor_multa.setText(moeda.setPrecoFormat(String.valueOf(valor_total)));
    }
}
