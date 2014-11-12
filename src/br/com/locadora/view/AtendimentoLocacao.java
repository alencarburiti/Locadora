package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.controller.SiscomController;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.Lancamento;
import br.com.locadora.model.bean.Objeto;
import br.com.locadora.model.bean.Produto;
import br.com.locadora.model.dao.CopiaDAO;
import br.com.locadora.model.dao.DependenteDAO;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.LimitadorTexto;
import br.com.locadora.util.Moeda;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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

public class AtendimentoLocacao extends javax.swing.JFrame {

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
    public InterfacePool pool;
    public SiscomController controller;
    public TelaPrincipal janelapai;
    public Moeda moeda;
    public Lancamento lancamento;
    public static AcessoUsuario acesso = new AcessoUsuario();

    public AtendimentoLocacao() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jtp_locacao = new javax.swing.JTabbedPane();
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
        jtf_valor_locacao = new javax.swing.JTextField();
        jtf_tipo_midia = new javax.swing.JTextField(new LimitadorTexto(11), "",10);
        jtf_diaria = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_locacao = new javax.swing.JTable();
        jtf_nome_objeto_locacao = new javax.swing.JTextField();
        jl_codigo_locacao = new javax.swing.JLabel();
        jtf_codigo_consulta_locacao = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jtf_debito_total_locacao = new javax.swing.JTextField();
        jtf_valor_total_locacao = new javax.swing.JTextField();
        jcb_codigo_barras_locacao = new javax.swing.JCheckBox();
        jb_adicionar_locacao = new javax.swing.JButton();
        jb_remover_locacao = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        jDesktopPane2 = new javax.swing.JDesktopPane();
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
        setTitle("Atendimento Locação");
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

        jtp_locacao.setName("jtp_locacao"); // NOI18N
        jtp_locacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtp_locacaoFocusGained(evt);
            }
        });

        jp_locacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens"));
        jp_locacao.setName("jp_locacao"); // NOI18N
        jp_locacao.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtf_valor_locacao.setEditable(false);
        jtf_valor_locacao.setText("R$ 0,00");
        jtf_valor_locacao.setName("jtf_valor_locacao"); // NOI18N
        jtf_valor_locacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_valor_locacaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_valor_locacaoFocusLost(evt);
            }
        });
        jp_locacao.add(jtf_valor_locacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 100, -1));

        jtf_tipo_midia.addKeyListener(new java.awt.event.KeyAdapter() {     // cria um listener ouvinte de digitação do fieldNumero

            public void keyReleased(java.awt.event.KeyEvent evt) {  // cria um ouvinte para cada tecla pressionada

                jtf_tipo_midia.setText(jtf_tipo_midia.getText().replaceAll("[^0-9]", "")); // faz com que pegue o texto a cada tecla digitada, e substituir tudo que não(^) seja numero  por ""

            }
        });
        jtf_tipo_midia.setEditable(false);
        jtf_tipo_midia.setName("jtf_tipo_midia"); // NOI18N
        jtf_tipo_midia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_tipo_midiaFocusGained(evt);
            }
        });
        jtf_tipo_midia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_tipo_midiaKeyPressed(evt);
            }
        });
        jp_locacao.add(jtf_tipo_midia, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 90, -1));

        jtf_diaria.setEditable(false);
        jtf_diaria.setName("jtf_diaria"); // NOI18N
        jp_locacao.add(jtf_diaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 50, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Nome Objeto");
        jLabel3.setName("jLabel3"); // NOI18N
        jp_locacao.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 300, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText("Valor");
        jLabel5.setName("jLabel5"); // NOI18N
        jp_locacao.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 50, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setText("Tipo Mídia");
        jLabel6.setName("jLabel6"); // NOI18N
        jp_locacao.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 70, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel13.setText("Diária");
        jLabel13.setName("jLabel13"); // NOI18N
        jp_locacao.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, -1, -1));

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jtbl_locacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código de Barras", "Nome Objeto", "Valor", "Diária", "Censura"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
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
        jtbl_locacao.setName("jtbl_locacao"); // NOI18N
        jScrollPane2.setViewportView(jtbl_locacao);
        if (jtbl_locacao.getColumnModel().getColumnCount() > 0) {
            jtbl_locacao.getColumnModel().getColumn(0).setPreferredWidth(20);
            jtbl_locacao.getColumnModel().getColumn(1).setResizable(false);
            jtbl_locacao.getColumnModel().getColumn(1).setPreferredWidth(200);
            jtbl_locacao.getColumnModel().getColumn(2).setPreferredWidth(30);
            jtbl_locacao.getColumnModel().getColumn(3).setPreferredWidth(30);
            jtbl_locacao.getColumnModel().getColumn(4).setPreferredWidth(20);
        }

        jp_locacao.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 780, 220));

        jtf_nome_objeto_locacao.setEditable(false);
        jtf_nome_objeto_locacao.setName("jtf_nome_objeto_locacao"); // NOI18N
        jtf_nome_objeto_locacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_nome_objeto_locacaoFocusGained(evt);
            }
        });
        jtf_nome_objeto_locacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_nome_objeto_locacaoKeyPressed(evt);
            }
        });
        jp_locacao.add(jtf_nome_objeto_locacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 270, -1));

        jl_codigo_locacao.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jl_codigo_locacao.setText("Código do Objeto");
        jl_codigo_locacao.setName("jl_codigo_locacao"); // NOI18N
        jp_locacao.add(jl_codigo_locacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jtf_codigo_consulta_locacao.setName("jtf_codigo_consulta_locacao"); // NOI18N
        jtf_codigo_consulta_locacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_codigo_consulta_locacaoFocusGained(evt);
            }
        });
        jtf_codigo_consulta_locacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_codigo_consulta_locacaoKeyPressed(evt);
            }
        });
        jp_locacao.add(jtf_codigo_consulta_locacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 120, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pesquisar.png"))); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jp_locacao.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 30, 30));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/ok.png"))); // NOI18N
        jButton7.setText("Finalizar");
        jButton7.setName("jButton7"); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jp_locacao.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 340, 110, 50));

        jLabel27.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel27.setText("Total");
        jLabel27.setName("jLabel27"); // NOI18N
        jp_locacao.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 60, 30));

        jLabel28.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel28.setText("Débito Total");
        jLabel28.setName("jLabel28"); // NOI18N
        jp_locacao.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 130, 30));

        jtf_debito_total_locacao.setEditable(false);
        jtf_debito_total_locacao.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jtf_debito_total_locacao.setText("R$ 0,00");
        jtf_debito_total_locacao.setName("jtf_debito_total_locacao"); // NOI18N
        jtf_debito_total_locacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_debito_total_locacaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_debito_total_locacaoFocusLost(evt);
            }
        });
        jp_locacao.add(jtf_debito_total_locacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, 180, 40));

        jtf_valor_total_locacao.setEditable(false);
        jtf_valor_total_locacao.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jtf_valor_total_locacao.setText("R$ 0,00");
        jtf_valor_total_locacao.setName("jtf_valor_total_locacao"); // NOI18N
        jtf_valor_total_locacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_valor_total_locacaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_valor_total_locacaoFocusLost(evt);
            }
        });
        jp_locacao.add(jtf_valor_total_locacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 180, 40));

        jcb_codigo_barras_locacao.setSelected(true);
        jcb_codigo_barras_locacao.setText("Usar Código de Barras");
        jcb_codigo_barras_locacao.setName("jcb_codigo_barras_locacao"); // NOI18N
        jcb_codigo_barras_locacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_codigo_barras_locacaoActionPerformed(evt);
            }
        });
        jp_locacao.add(jcb_codigo_barras_locacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 180, 30));

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
        jp_locacao.add(jb_adicionar_locacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 40, 30, 30));

        jb_remover_locacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/edit_remove.png"))); // NOI18N
        jb_remover_locacao.setToolTipText("Excluir");
        jb_remover_locacao.setName("jb_remover_locacao"); // NOI18N
        jb_remover_locacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_remover_locacaoActionPerformed(evt);
            }
        });
        jp_locacao.add(jb_remover_locacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, 30, 30));

        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/exit.png"))); // NOI18N
        jb_cancelar.setText("Sair");
        jb_cancelar.setMaximumSize(new java.awt.Dimension(101, 33));
        jb_cancelar.setName("jb_cancelar"); // NOI18N
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });
        jp_locacao.add(jb_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 340, 90, 50));

        jtp_locacao.addTab("Locação", jp_locacao);

        getContentPane().add(jtp_locacao);
        jtp_locacao.setBounds(10, 100, 850, 450);

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
        jPanel1.setBounds(20, 20, 500, 80);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Atendente"));
        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "alencarburiti", "teste\t", "eliesioxavier", "Item 4" }));
        jComboBox1.setName("jComboBox1"); // NOI18N
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/reload.png"))); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        getContentPane().add(jPanel2);
        jPanel2.setBounds(600, 20, 200, 80);

        setSize(new java.awt.Dimension(880, 573));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        System.out.println("Escrever: " + acesso.getEscrever());
        if (acesso.getEscrever() == 1) {
            jtf_codigo_cliente.setEnabled(false);
            jtf_codigo_consulta_locacao.setEnabled(false);
            jtf_debito_total_locacao.setEnabled(false);
            jtf_diaria.setEnabled(false);
            jtf_nome_cliente.setEnabled(false);
            jtf_nome_objeto_locacao.setEnabled(false);
        }

        if (jcb_codigo_barras_locacao.isSelected() == true) {
            jl_codigo_locacao.setText("Código de Barras");
        } else {
            jl_codigo_locacao.setText("Código dó Objeto");
        }
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
        ((DefaultTableModel) jtbl_locacao.getModel()).setRowCount(0);
        jtbl_locacao.updateUI();
        this.setVisible(false);
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
    jtf_codigo_consulta_locacao.requestFocus();
}//GEN-LAST:event_jtf_nome_clienteFocusLost

    private void jtf_debito_total_locacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_debito_total_locacaoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_debito_total_locacaoFocusLost

    private void jtf_debito_total_locacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_debito_total_locacaoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_debito_total_locacaoFocusGained

    private void jtf_valor_total_locacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_total_locacaoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_total_locacaoFocusLost

    private void jtf_valor_total_locacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_total_locacaoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_total_locacaoFocusGained

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        enviarDadosLocacao();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jtf_codigo_cliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe primeiro um cliente");
        } else {
            ConsultaCopiaLocacao copiaCliente = new ConsultaCopiaLocacao();
            copiaCliente.janelapai = this;
            copiaCliente.setVisible(true);
            setStatusTela(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtf_nome_objeto_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nome_objeto_locacaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ConsultaCopiaLocacao copiaCliente = new ConsultaCopiaLocacao();
            copiaCliente.janelapai = this;
            copiaCliente.setVisible(true);
            setStatusTela(false);
        }
    }//GEN-LAST:event_jtf_nome_objeto_locacaoKeyPressed

    private void jtf_nome_objeto_locacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_nome_objeto_locacaoFocusGained
    }//GEN-LAST:event_jtf_nome_objeto_locacaoFocusGained

    private void jb_remover_locacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_remover_locacaoActionPerformed
        excluirProduto();
    }//GEN-LAST:event_jb_remover_locacaoActionPerformed

    private void jb_adicionar_locacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_adicionar_locacaoActionPerformed
        adicionarItemLocado(copiaLocacao);
    }//GEN-LAST:event_jb_adicionar_locacaoActionPerformed

    private void jtf_tipo_midiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_tipo_midiaKeyPressed

    }//GEN-LAST:event_jtf_tipo_midiaKeyPressed

    private void jtf_tipo_midiaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_tipo_midiaFocusGained
        jtf_tipo_midia.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (jtf_tipo_midia.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "Informe a quantidade");
                    jtf_tipo_midia.requestFocus();
                    return false;
                } else {
                    jtf_diaria.requestFocus();
                    return true;
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_tipo_midiaFocusGained

    private void jtf_valor_locacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_locacaoFocusLost
        moeda = new Moeda();
        jtf_valor_locacao.setText(moeda.setPrecoFormat(jtf_valor_locacao.getText()));
    }//GEN-LAST:event_jtf_valor_locacaoFocusLost

    private void jtf_valor_locacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_locacaoFocusGained
        jtf_valor_locacao.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (jtf_valor_locacao.getText().trim().equals("RS")) {
                    JOptionPane.showMessageDialog(null, "Informe o preço");
                    jtf_valor_locacao.requestFocus();
                    return false;
                } else {
                    jtf_tipo_midia.requestFocus();
                    return true;
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_locacaoFocusGained

    private void jtp_locacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtp_locacaoFocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_jtp_locacaoFocusGained

    private void jcb_codigo_barras_locacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_codigo_barras_locacaoActionPerformed
        if (jcb_codigo_barras_locacao.isSelected() == true) {
            jl_codigo_locacao.setText("Código de Barras");
            jtf_codigo_consulta_locacao.requestFocus();
        } else {
            jl_codigo_locacao.setText("Código do Objeto");
            jtf_codigo_consulta_locacao.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_codigo_barras_locacaoActionPerformed

    private void jtf_codigo_consulta_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_codigo_consulta_locacaoKeyPressed

        try {

            if (!jtf_codigo_cliente.getText().equals("")) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (jcb_codigo_barras_locacao.isSelected() == true) {
                        locar_consulta_codigo_barras(jtf_codigo_consulta_locacao.getText().trim());
                    } else {
                        locar_consulta_codigo_objeto(Integer.parseInt(jtf_codigo_consulta_locacao.getText().trim()));
                    }
                } else if (evt.getKeyCode() == KeyEvent.VK_F6) {
                    ConsultaCopiaLocacao copiaCliente = new ConsultaCopiaLocacao();
                    copiaCliente.janelapai = this;
                    copiaCliente.setVisible(true);
                    setStatusTela(false);
                } else if (evt.getKeyCode() == KeyEvent.VK_F10) {
                    enviarDadosLocacao();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Informe primeiro um Cliente");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Código do Objeto deve ser número");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_codigo_consulta_locacaoKeyPressed

    private void jtf_codigo_consulta_locacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_codigo_consulta_locacaoFocusGained


    }//GEN-LAST:event_jtf_codigo_consulta_locacaoFocusGained

    private void jb_adicionar_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_adicionar_locacaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            adicionarItemLocado(copiaLocacao);
        }
    }//GEN-LAST:event_jb_adicionar_locacaoKeyPressed

    private void jb_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_clienteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_clienteKeyPressed

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        setVisible(false);
        janelapai.setStatusTela(true);
    }//GEN-LAST:event_jb_cancelarActionPerformed

    public void consultarClienteAtendimento() {
        ConsultaClienteAtendimento consultaCliente = new ConsultaClienteAtendimento();
        consultaCliente.janelapaiLocacao = this;
        consultaCliente.setVisible(true);
        consultaCliente.jtf_consulta.setText(jtf_nome_cliente.getText().trim());
        setStatusTela(false);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AtendimentoLocacao().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jb_adicionar_locacao;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_cliente;
    private javax.swing.JButton jb_remover_locacao;
    private javax.swing.JCheckBox jcb_codigo_barras_locacao;
    private javax.swing.JLabel jl_codigo_locacao;
    public static javax.swing.JPanel jp_locacao;
    public static javax.swing.JTable jtbl_locacao;
    public static javax.swing.JTextField jtf_codigo_cliente;
    private javax.swing.JTextField jtf_codigo_consulta_locacao;
    public static javax.swing.JTextField jtf_debito_total_locacao;
    private javax.swing.JFormattedTextField jtf_diaria;
    public static javax.swing.JTextField jtf_nome_cliente;
    public static javax.swing.JTextField jtf_nome_objeto_locacao;
    private javax.swing.JTextField jtf_tipo_midia;
    private javax.swing.JTextField jtf_valor_locacao;
    public static javax.swing.JTextField jtf_valor_total_locacao;
    private javax.swing.JTabbedPane jtp_locacao;
    // End of variables declaration//GEN-END:variables

    private void enviarDadosLocacao() {
        if (verificarCampos() == true) {
            EntradaCaixa entradaCaixa;
            entradaCaixa = new EntradaCaixa();
            entradaCaixa.setVisible(true);
            setStatusTela(false);
            entradaCaixa.janelapaiLocacao = this;
        }
    }

    public void setJanelaPai(TelaPrincipal janelapai) {
        this.janelapai = janelapai;
    }

    public void limparCampos() {
        jtf_codigo_cliente.setText("");
        jtf_codigo_consulta_locacao.setText("");
        jtf_valor_locacao.setText("");
        jtf_tipo_midia.setText("");
        jtf_diaria.setText("");
    }

    private void excluirProduto() {
        removeObjeto(jtbl_locacao);
    }

    public void removeObjeto(JTable tb) {
        if (tb != null) {
            DefaultTableModel row = (DefaultTableModel) jtbl_locacao.getModel();
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
            jtf_nome_objeto_locacao.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public boolean verificarItemLocacao() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_codigo_consulta_locacao.getText().equals("")) {
            msgERRO = msgERRO + " *Cópia\n";
        }

        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            jtf_nome_objeto_locacao.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public void adicionarItemLocado(Copia copia) {
        if (verificarItemLocacao() == true) {

            String valor;
            moeda = new Moeda();
            valor = String.valueOf(copia.getObjeto().getDiaria().getValor());

            valor = moeda.setPrecoFormat(valor);

            DefaultTableModel row = (DefaultTableModel) jtbl_locacao.getModel();
            ItemDbGrid hashDbGrid = new ItemDbGrid(copia, copia.getObjeto().getDescricao_objeto());
            row.addRow(new Object[]{copia.getCodigo_barras(),
                hashDbGrid, valor, copia.getObjeto().getDiaria().getDias(), copia.getObjeto().getCensura()});

            adicionarValorTotal(valor);
            copiasLocacao.add(copia);
            limparItemLocado();
            jtf_codigo_consulta_locacao.requestFocus();
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel adicionar ");
        }
    }

    public void adicionarValorTotal(String valor) {
        moeda = new Moeda();
        Double valor_total;
        Double valor_adicionar;
        valor_adicionar = moeda.getPrecoFormato(valor);

        valor_total = moeda.getPrecoFormato(jtf_valor_total_locacao.getText());

        valor_total = valor_total + valor_adicionar;

        jtf_valor_total_locacao.setText(moeda.setPrecoFormat(String.valueOf(valor_total)));

    }

    public void retirarValordoTotal(String valor) {
        moeda = new Moeda();
        Double valor_total;
        Double valor_remover;
        valor_remover = moeda.getPrecoFormato(valor);

        valor_total = moeda.getPrecoFormato(jtf_valor_total_locacao.getText());

        valor_total = valor_total - valor_remover;

        jtf_valor_total_locacao.setText(moeda.setPrecoFormat(String.valueOf(valor_total)));

    }

    public void limparItemLocado() {
        jtf_valor_locacao.setText("R$");
        jtf_tipo_midia.setText("");
        jtf_diaria.setText("");
        jtf_codigo_consulta_locacao.setText("");
        jtf_nome_objeto_locacao.setText("");
    }

    public void statusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }

    public void carregarCopiaLocacao(Copia copia) {
        if (copia != null) {
            this.copiaLocacao = copia;

            if (jcb_codigo_barras_locacao.isSelected() == true) {
                jtf_codigo_consulta_locacao.setText(copiaLocacao.getCodigo_barras());
            } else {
                jtf_codigo_consulta_locacao.setText(String.valueOf(copiaLocacao.getObjeto().getCodigo_objeto()));
            }

            jtf_nome_objeto_locacao.setText(copiaLocacao.getObjeto().getDescricao_objeto());

            jtf_diaria.setText(String.valueOf(copiaLocacao.getObjeto().getDiaria().getDias()));

            String valor;
            moeda = new Moeda();
            valor = String.valueOf(copiaLocacao.getObjeto().getDiaria().getValor());
            valor = moeda.setPrecoFormat(valor);

            jtf_valor_locacao.setText(valor);
            jtf_tipo_midia.setText(copiaLocacao.getObjeto().getTipo_midia());

            jb_adicionar_locacao.requestFocus();
        }
    }

    public void carregarClienteDependente(Dependente dependente) {
        if (dependente != null) {
            AtendimentoLocacao.dependente = dependente;
            jtf_debito_total_locacao.setText("R$ 0,00");

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
                jtf_debito_total_locacao.setText(moeda.setPrecoFormat(String.valueOf(lancamento.getSaldo())));
                jtf_debito_total_locacao.setCaretColor(Color.black);
            } else {
                jtf_debito_total_locacao.setText(moeda.setPrecoFormat(String.valueOf(lancamento.getSaldo())));
                jtf_debito_total_locacao.setCaretColor(Color.red);
            }

            jtf_codigo_consulta_locacao.requestFocus();

            //Limpa tabela depois de selecionar novo cliente
            DefaultTableModel tb_locacao = (DefaultTableModel) jtbl_locacao.getModel();
            int rows = tb_locacao.getRowCount();
            for (int i = rows - 1; i >= 0; i--) {
                tb_locacao.removeRow(i);
            }

            jtf_valor_total_locacao.setText("R$ 0,00");

        }
    }

    public void setStatusTela(boolean status) {

        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);

    }

    public void locar_consulta_codigo_barras(String codigo_barras) {

        try {
            pool = new Pool();
            copias = null;
            CopiaDAO copiaDAO = new CopiaDAO(pool);

            if (copiaDAO.getCopia_existente(codigo_barras) == true) {

                String assistido_anteriormente;
                assistido_anteriormente = copiaDAO.getQuantidadeAssistida(dependente.getCodigo_dependente(), codigo_barras);

                copias = copiaDAO.getCopia_codigo_barras(codigo_barras);

                if (copias.size() > 0) {
                    if (checkCensura(copias.get(0).getObjeto().getCensura(), dependente.getData_nascimento()) == true) {
                        if (verificaTabela(copias.get(0)) == false) {
                            if (!"".equals(assistido_anteriormente)) {
                                int selectedOption = JOptionPane.showConfirmDialog(this, assistido_anteriormente, "Atenção", JOptionPane.YES_NO_OPTION);
                                if (selectedOption == JOptionPane.YES_NO_OPTION) {
                                    adicionarItemLocado(copias.get(0));
                                    jtf_codigo_consulta_locacao.requestFocus();
                                } else {
                                    limparItemLocado();
                                }
                            } else {
                                adicionarItemLocado(copias.get(0));
                                jtf_codigo_consulta_locacao.requestFocus();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Última cópia disponível já foi adicionada: " + codigo_barras);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Filme inapropriado para este Cliente");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Cópia indisponivel no momento");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Código de Barra inválido e/ou não cadastrado");
            }

        } catch (SQLException ex) {
            Logger.getLogger(AtendimentoLocacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean checkCensura(int censura, Date data_nascimento) {

        int idade = calcularIdade(data_nascimento);

        if (data_nascimento != null) {
            return idade >= censura;
        }
        return false;

    }

    public int calcularIdade(Date dataNascimento) {
        if (dataNascimento != null) {
            //Calcula a Idade baseado em java.util.Date   
            Calendar dateOfBirth = new GregorianCalendar();

            dateOfBirth.setTime(dataNascimento);

            // Cria um objeto calendar com a data atual
            Calendar today = Calendar.getInstance();

            // Obtém a idade baseado no ano
            int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);

            dateOfBirth.add(Calendar.YEAR, age);

            //se a data de hoje é antes da data de Nascimento, então diminui 1(um)
            if (today.before(dateOfBirth)) {

                age--;

            }

            return age;
        }
        return 0;
    }

    public void locar_consulta_codigo_objeto(Integer codigo_objeto) {

        try {
            pool = new Pool();
            copias = null;
            CopiaDAO copiaDAO = new CopiaDAO(pool);
            if (codigo_objeto != null) {

                if (copiaDAO.getObjeto_existente(codigo_objeto) == true) {

                    copias = copiaDAO.getCopia_codigo_objeto(codigo_objeto, 0, "Locação");

                    if (copias.size() > 0) {
                        String codigo_barras = verificaTabelaObjeto(copias);

                        if (!codigo_barras.equals("")) {
                            locar_consulta_codigo_barras(codigo_barras);

                        } else {
                            JOptionPane.showMessageDialog(null, "Cópia Indisponível");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Cópia indisponivel no momento");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Código de Objeto inválido e/ou não cadastrado");

                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Grave: " + ex);
        }

    }

    public boolean verificaTabela(Copia copia) {

        boolean tabela = true;
        if (jtbl_locacao.getRowCount() == 0) {
            return false;
        } else if (jtbl_locacao.getRowCount() > 0) {
            int linhas = jtbl_locacao.getRowCount();

            for (int i = 0; i < linhas; i++) {
                Copia copiaVerificarTabela = new Copia();

                copiaVerificarTabela.setCodigo_barras((String) jtbl_locacao.getValueAt(i, 0));

                tabela = copiaVerificarTabela.getCodigo_barras().equals(copia.getCodigo_barras());

                if (tabela == true) {
                    break;
                }
            }
        }
        return tabela;
    }

    public String verificaTabelaObjeto(List<Copia> copias) {
        boolean tabela = false;
        String codigo_barras = "";
        if (jtbl_locacao.getRowCount() == 0) {
            codigo_barras = copias.get(0).getCodigo_barras();
        } else if (jtbl_locacao.getRowCount() > 0) {
            int linhas = jtbl_locacao.getRowCount();

            for (int i = 0; i < linhas; i++) {
                System.out.println("Linhas:" + i + " Size: "+ copias.size());                
                for (int x = 0; x < copias.size();) {

                    Copia copiaVerificarTabela = new Copia();

                    copiaVerificarTabela.setCodigo_barras((String) jtbl_locacao.getValueAt(i, 0));

                    tabela = copiaVerificarTabela.getCodigo_barras().equals(copias.get(x).getCodigo_barras());

                    System.out.println(copias.get(x).getCodigo_barras() + " " + tabela + " Posição: " + x);
                    if (tabela == false) {
                        codigo_barras = copias.get(x).getCodigo_barras();
                        break;
                    } else {
                        System.out.println( "Passou pela posição: "+ x);
                        copias.remove(x);
                        x = 0;
                        continue;
                    }
                }
                    System.out.println("Linhas:" + i + " Size: "+ copias.size());
            }

        }

        return codigo_barras;
    }

}
