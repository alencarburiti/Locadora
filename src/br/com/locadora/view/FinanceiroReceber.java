package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.controller.SiscomController;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.Devolucao;
import br.com.locadora.model.bean.Lancamento;
import br.com.locadora.model.bean.Locacao;
import br.com.locadora.model.bean.TipoServico;
import br.com.locadora.model.bean.Usuario;
import br.com.locadora.model.bean.Venda;
import br.com.locadora.model.dao.LancamentoDAO;
import br.com.locadora.model.dao.TipoServicoDAO;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.Colorir;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.Moeda;
import br.com.locadora.util.TemaInterface;
import java.awt.Color;
import java.awt.event.KeyEvent;
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
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.MaskFormatter;

public class FinanceiroReceber extends javax.swing.JFrame {

    public DecimalFormat formatoPreco;
    public MaskFormatter formatoData;
    public String permissao;
    public Cliente cliente;
    public static Dependente dependente = new Dependente();
    private Date data;
    public InterfacePool pool;
    public SiscomController controller;
    public Financeiro janelapai;
    public AtendimentoLocacao janelapai2;
    public AtendimentoDevolucao janelapai3;
    public AtendimentoVenda janelapai4;
    public Moeda moeda;
    public List<Lancamento> lancamentos;
    public Lancamento lancamento;
    public TipoServico tipoServico;
    public AcessoUsuario acesso;
    public LancamentoRecebimento lancamentoRecebimento;
    
    public FinanceiroReceber() {
        initComponents();
        TemaInterface.getInterface(this);
        janelapai = null;
        janelapai2 = null;
    }
    
    public FinanceiroReceber(Dependente dependente) {
        initComponents();
        TemaInterface.getInterface(this);
        janelapai = null;
        janelapai2 = null;
        
        carregarClienteDependente(dependente);
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
        jb_adicionar_locacao = new javax.swing.JButton();
        jcb_tipo_servico = new javax.swing.JComboBox();
        try  {
            formatoData = new MaskFormatter("##/##/####");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");
        }
        jtf_data_lancamento = new JFormattedTextField(formatoData);
        jLabel2 = new javax.swing.JLabel();
        jl_saldo = new javax.swing.JLabel();
        jtf_saldo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jb_receber = new javax.swing.JButton();
        jb_cancelar1 = new javax.swing.JButton();

        jDesktopPane1.setName("jDesktopPane1"); // NOI18N
        jDesktopPane1.setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Financeiro - Contas À Receber");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));
        jPanel1.setName("jPanel1"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel1.setText("Código ");
        jLabel1.setName("jLabel1"); // NOI18N

        jtf_codigo_cliente.setEditable(false);
        jtf_codigo_cliente.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_codigo_cliente.setName("jtf_codigo_cliente"); // NOI18N

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel10.setText("Cliente");
        jLabel10.setName("jLabel10"); // NOI18N

        jtf_nome_cliente.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
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

        jb_cliente.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pesquisar.png"))); // NOI18N
        jb_cliente.setName("jb_cliente"); // NOI18N
        jb_cliente.setPreferredSize(new java.awt.Dimension(28, 28));
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_codigo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtf_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_codigo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jb_cliente, jtf_codigo_cliente, jtf_nome_cliente});

        jp_locacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Recebimentos"));
        jp_locacao.setName("jp_locacao"); // NOI18N

        jtf_valor_lancamento.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
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
        jtf_valor_lancamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_valor_lancamentoKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel3.setText("Data Lançamento");
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel5.setText("Valor");
        jLabel5.setName("jLabel5"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jtbl_recebimento.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtbl_recebimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Controle Interno", "Data Lançamento", "Descrição", "Tipo", "Valor Total", "Valor Devedor", "Cliente/Dependente", "Usuário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbl_recebimento.setName("jtbl_recebimento"); // NOI18N
        jtbl_recebimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_recebimentoMouseClicked(evt);
            }
        });
        jtbl_recebimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbl_recebimentoKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtbl_recebimento);
        if (jtbl_recebimento.getColumnModel().getColumnCount() > 0) {
            jtbl_recebimento.getColumnModel().getColumn(0).setPreferredWidth(70);
            jtbl_recebimento.getColumnModel().getColumn(1).setPreferredWidth(70);
            jtbl_recebimento.getColumnModel().getColumn(2).setPreferredWidth(120);
            jtbl_recebimento.getColumnModel().getColumn(3).setPreferredWidth(5);
            jtbl_recebimento.getColumnModel().getColumn(4).setPreferredWidth(50);
            jtbl_recebimento.getColumnModel().getColumn(5).setPreferredWidth(50);
            jtbl_recebimento.getColumnModel().getColumn(6).setPreferredWidth(80);
            jtbl_recebimento.getColumnModel().getColumn(7).setPreferredWidth(80);
        }

        jl_codigo_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jl_codigo_locacao.setText("Depósito");
        jl_codigo_locacao.setName("jl_codigo_locacao"); // NOI18N

        jb_adicionar_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_adicionar_locacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/adicionar_item.png"))); // NOI18N
        jb_adicionar_locacao.setToolTipText("Incluir");
        jb_adicionar_locacao.setName("jb_adicionar_locacao"); // NOI18N
        jb_adicionar_locacao.setPreferredSize(new java.awt.Dimension(28, 28));
        jb_adicionar_locacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_adicionar_locacaoMouseClicked(evt);
            }
        });
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

        jcb_tipo_servico.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_tipo_servico.setName("jcb_tipo_servico"); // NOI18N
        jcb_tipo_servico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcb_tipo_servicoKeyPressed(evt);
            }
        });

        jtf_data_lancamento.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_data_lancamento.setName("jtf_data_lancamento"); // NOI18N
        jtf_data_lancamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_data_lancamentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_data_lancamentoFocusLost(evt);
            }
        });
        jtf_data_lancamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_data_lancamentoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jp_locacaoLayout = new javax.swing.GroupLayout(jp_locacao);
        jp_locacao.setLayout(jp_locacaoLayout);
        jp_locacaoLayout.setHorizontalGroup(
            jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_locacaoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jp_locacaoLayout.createSequentialGroup()
                        .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_codigo_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcb_tipo_servico, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(jtf_data_lancamento))
                        .addGap(5, 5, 5)
                        .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jp_locacaoLayout.createSequentialGroup()
                                .addComponent(jtf_valor_lancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jb_adicionar_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(363, Short.MAX_VALUE))))
        );
        jp_locacaoLayout.setVerticalGroup(
            jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_locacaoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_codigo_locacao)
                    .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel3)))
                .addGap(0, 0, 0)
                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcb_tipo_servico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_data_lancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_valor_lancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_adicionar_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
        );

        jp_locacaoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jb_adicionar_locacao, jcb_tipo_servico, jtf_data_lancamento, jtf_valor_lancamento});

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/BROADWAY-LOGIN.png"))); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jl_saldo.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jl_saldo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jl_saldo.setText("Devedor:");
        jl_saldo.setName("jl_saldo"); // NOI18N

        jtf_saldo.setEditable(false);
        jtf_saldo.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
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

        jLabel4.setText("Tipo: D = Débito: C = Crédito ");
        jLabel4.setName("jLabel4"); // NOI18N

        jPanel2.setName("jPanel2"); // NOI18N

        jb_receber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/money_bag-2.png"))); // NOI18N
        jb_receber.setText("Receber");
        jb_receber.setName("jb_receber"); // NOI18N
        jb_receber.setPreferredSize(new java.awt.Dimension(100, 40));
        jb_receber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_receberActionPerformed(evt);
            }
        });

        jb_cancelar1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_cancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/sair.png"))); // NOI18N
        jb_cancelar1.setText("Sair");
        jb_cancelar1.setMaximumSize(new java.awt.Dimension(101, 33));
        jb_cancelar1.setName("jb_cancelar1"); // NOI18N
        jb_cancelar1.setPreferredSize(new java.awt.Dimension(100, 40));
        jb_cancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelar1ActionPerformed(evt);
            }
        });
        jb_cancelar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_cancelar1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jb_receber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_cancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_receber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_cancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jl_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jtf_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jp_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jp_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtf_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jl_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Calendar data_atual = Calendar.getInstance();               
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        String data_inicial = out.format(data_atual.getTime());       
        jtf_data_lancamento.setText(data_inicial);    
        
        carregarTipoLancamento();
        jtf_nome_cliente.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F10) {
//            enviarDadosLocacao();
        }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
    }//GEN-LAST:event_formKeyReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        retornarJanelaPai();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

private void jb_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_clienteActionPerformed
    consultarClienteAtendimento();
}//GEN-LAST:event_jb_clienteActionPerformed

private void jtf_nome_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nome_clienteKeyPressed
    acionarAtalho(evt);
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        consultarClienteAtendimento();
    }
}//GEN-LAST:event_jtf_nome_clienteKeyPressed

private void jtf_nome_clienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_nome_clienteFocusLost

}//GEN-LAST:event_jtf_nome_clienteFocusLost

    private void jtf_valor_lancamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_lancamentoFocusLost
        moeda = new Moeda();
        jtf_valor_lancamento.setText(moeda.setPrecoFormat(jtf_valor_lancamento.getText()));
    }//GEN-LAST:event_jtf_valor_lancamentoFocusLost

    private void jtf_valor_lancamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_lancamentoFocusGained
        Moeda moeda = new Moeda();
        if (jtf_valor_lancamento.getText().equals("R$ 0,00")) {
            jtf_valor_lancamento.setText("");
        } else {
            jtf_valor_lancamento.setText(moeda.setPrecoFormat(jtf_valor_lancamento.getText()));
        }        
        jtf_valor_lancamento.selectAll();
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_lancamentoFocusGained

    private void jb_adicionar_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_adicionar_locacaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            adicionarLancamento();
        }
        acionarAtalho(evt);

    }//GEN-LAST:event_jb_adicionar_locacaoKeyPressed

    private void jb_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_clienteKeyPressed
        acionarAtalho(evt);
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
                } else {
                    jtf_data_lancamento.setForeground(Color.red);
                    jtf_data_lancamento.requestFocus();
                }

            }
        } catch (ParseException ex) {
            jtf_data_lancamento.setForeground(Color.red);
            jtf_data_lancamento.requestFocus();
        } catch (NumberFormatException ex) {
            jtf_data_lancamento.setText("  /  /    ");
            jtf_data_lancamento.setForeground(Color.red);
            jtf_data_lancamento.requestFocus();
        }
    }//GEN-LAST:event_jtf_data_lancamentoFocusLost

    private void jtf_data_lancamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_data_lancamentoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_valor_lancamento.requestFocus();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_lancamentoKeyPressed

    private void jtf_valor_lancamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valor_lancamentoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_adicionar_locacao.requestFocus();
        }
        acionarAtalho(evt);

        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_lancamentoKeyPressed

    private void jcb_tipo_servicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcb_tipo_servicoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_data_lancamento.requestFocus();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_tipo_servicoKeyPressed

    private void jb_adicionar_locacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_adicionar_locacaoMouseClicked
        if (evt.getClickCount() == 1) {
            adicionarLancamento();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_adicionar_locacaoMouseClicked

    private void jb_receberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_receberActionPerformed
        alterarItemLancamento();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_receberActionPerformed

    private void jtbl_recebimentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_recebimentoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_receber.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_recebimentoKeyPressed

    private void jtbl_recebimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_recebimentoMouseClicked
        if (evt.getClickCount() > 1) {
            jb_receber.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_recebimentoMouseClicked

    private void jb_cancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelar1ActionPerformed
        retornarJanelaPai();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_cancelar1ActionPerformed

    private void jb_cancelar1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_cancelar1KeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_cancelar1.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_cancelar1KeyPressed

    private void jb_adicionar_locacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_adicionar_locacaoActionPerformed
        adicionarLancamento();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_adicionar_locacaoActionPerformed

    private void jtf_data_lancamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_data_lancamentoFocusGained
        jtf_data_lancamento.selectAll();
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_lancamentoFocusGained

    public void consultarClienteAtendimento() {
        ConsultaClienteAtendimento consultaCliente = new ConsultaClienteAtendimento();
        consultaCliente.janelapaiRecebimento = this;
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
                new FinanceiroReceber().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jb_adicionar_locacao;
    private javax.swing.JButton jb_cancelar1;
    private javax.swing.JButton jb_cliente;
    private javax.swing.JButton jb_receber;
    private javax.swing.JComboBox jcb_tipo_servico;
    private javax.swing.JLabel jl_codigo_locacao;
    private javax.swing.JLabel jl_saldo;
    public static javax.swing.JPanel jp_locacao;
    public static javax.swing.JTable jtbl_recebimento;
    public static javax.swing.JTextField jtf_codigo_cliente;
    public static javax.swing.JFormattedTextField jtf_data_lancamento;
    public static javax.swing.JTextField jtf_nome_cliente;
    public static javax.swing.JTextField jtf_saldo;
    private javax.swing.JTextField jtf_valor_lancamento;
    // End of variables declaration//GEN-END:variables

    private void excluirProduto() {
        removeObjeto(jtbl_recebimento);
    }

    public void removeObjeto(JTable tb) {
        if (tb != null) {
            DefaultTableModel row = (DefaultTableModel) jtbl_recebimento.getModel();
            if (tb.getSelectedRow() != -1) {
                int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
                if (selectedOption == JOptionPane.YES_NO_OPTION) {                    
                    carregarClienteDependente(dependente);
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

        if(jtf_codigo_cliente.getText().equals("")){
            msgERRO = msgERRO + " *Cliente\n";
        }
        
        if (jtf_data_lancamento.getText().trim().length() != 10) {
            msgERRO = msgERRO + " *Data Inválida\n";
        }

        if (jtf_valor_lancamento.getText().trim().equals("R$ 0,00") || jtf_valor_lancamento.getText().trim().equals("R$")) {
            msgERRO = msgERRO + " *Valor Inválido\n";
        }

        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            jcb_tipo_servico.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public void adicionarLancamento() {

        if (verificarItemLancamento() == true) {
            ArquivoConfiguracao conf = new ArquivoConfiguracao();
            lancamento = new Lancamento();
            
            ItemDbGrid hashDbGrid = (ItemDbGrid) jcb_tipo_servico.getSelectedItem();
            tipoServico = new TipoServico();
            tipoServico = (TipoServico) hashDbGrid.getObjeto();

            lancamento.setValor_total(moeda.getPrecoFormato(jtf_valor_lancamento.getText()));
            lancamento.setTipoServico(tipoServico);
            lancamento.setDependente(dependente);
            Usuario usuario = new Usuario();
            usuario.setCodigo_usuario(Integer.parseInt(conf.readPropertie("codigo_usuario")));
            lancamento.setCaixa(Integer.parseInt(conf.readPropertie("caixa")));
            lancamento.setUsuario(usuario);
            lancamento.setLocacao(new Locacao());
            lancamento.setDevolucao(new Devolucao());
            lancamento.setVenda(new Venda());

            pool = new Pool();
            LancamentoDAO lancamentoDAO = new LancamentoDAO(pool);
            lancamentoDAO.salvarLancamento(lancamento);
            limparItemLancado();
            carregarClienteDependente(dependente);            
        } 
    }    

    public void limparItemLancado() {
        Calendar data_atual = Calendar.getInstance();               
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        String data_inicial = out.format(data_atual.getTime());       
        jtf_data_lancamento.setText(data_inicial);   
        
        jcb_tipo_servico.setSelectedIndex(0);
        jtf_valor_lancamento.setText("R$ 0,00");
    }

    public void statusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
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

                    moeda = new Moeda();

                    DefaultTableModel row = (DefaultTableModel) jtbl_recebimento.getModel();
                    row.addRow(new Object[]{lancamentos.get(i).getCodigo_lancamento(), data_lancamento,
                        lancamentos.get(i).getTipoServico().getDescricao(),
                        lancamentos.get(i).getTipoServico().getTipo(),
                        moeda.setPrecoFormat(lancamentos.get(i).getValor_total().toString()),
                        moeda.setPrecoFormat(lancamentos.get(i).getDevedor().toString()),
                        lancamentos.get(i).getDependente().getNome_dependente(),
                        lancamentos.get(i).getUsuario().getNome_usuario()});
                }

                TableCellRenderer tcr = new Colorir(null, null, this);
                TableColumn column = jtbl_recebimento.getColumnModel().getColumn(0);
                column.setCellRenderer(tcr);
                column = jtbl_recebimento.getColumnModel().getColumn(1);
                column.setCellRenderer(tcr);
                column = jtbl_recebimento.getColumnModel().getColumn(2);
                column.setCellRenderer(tcr);
                column = jtbl_recebimento.getColumnModel().getColumn(3);
                column.setCellRenderer(tcr);
                column = jtbl_recebimento.getColumnModel().getColumn(4);
                column.setCellRenderer(tcr);
                column = jtbl_recebimento.getColumnModel().getColumn(5);
                column.setCellRenderer(tcr);
                column = jtbl_recebimento.getColumnModel().getColumn(6);
                column.setCellRenderer(tcr);
                column = jtbl_recebimento.getColumnModel().getColumn(7);
                column.setCellRenderer(tcr);

            } catch (ParseException ex) {
                Logger.getLogger(FinanceiroReceber.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void carregarClienteDependente(Dependente dependente) {
        if (dependente != null) {
            FinanceiroReceber.dependente = dependente;            

            jtf_nome_cliente.setText(dependente.getNome_dependente());
            jtf_codigo_cliente.setText(String.valueOf(dependente.getCliente().getCodigo_cliente()));
            Moeda moeda = new Moeda();

            pool = new Pool();
            lancamentos = new ArrayList<Lancamento>();
            LancamentoDAO lancamentoDAO = new LancamentoDAO(pool);
            lancamentos = lancamentoDAO.getLancamentos(dependente.getCliente());
            Double credito = 0.00;
            Double debito = 0.00;
            Double saldo = 0.00;
            Double devedor = 0.00;
            int quantidade_lancamento_aberto = 0;
            for(int i = 0; i < lancamentos.size(); i++){                
                if(lancamentos.get(i).getTipoServico().getTipo().equals("C")){                    
                    saldo = saldo + lancamentos.get(i).getSaldo();
                }else {
                    if(lancamentos.get(i).getDevedor() > 0){
                        quantidade_lancamento_aberto = quantidade_lancamento_aberto + 1;                        
                    }
                    devedor = devedor + lancamentos.get(i).getDevedor();
                }
            }
            
            Double saldo_total = saldo - devedor;
           
            if (saldo_total >= 0) {
                jtf_saldo.setText(moeda.setPrecoFormat(String.valueOf(saldo_total.toString())));
                jtf_saldo.setForeground(Color.black);
                jl_saldo.setText("Saldo:");                
            } else {
                saldo_total = saldo_total*(-1);
                jtf_saldo.setText(moeda.setPrecoFormat(String.valueOf(saldo_total.toString())));
                jtf_saldo.setForeground(Color.red);
                jl_saldo.setText("Devedor:");                
            }
            
            jcb_tipo_servico.requestFocus();

            //Limpa tabela depois de selecionar novo cliente
            DefaultTableModel tb_locacao = (DefaultTableModel) jtbl_recebimento.getModel();
            int rows = tb_locacao.getRowCount();
            for (int i = rows - 1; i >= 0; i--) {
                tb_locacao.removeRow(i);
            }

            carregarLancamentos(dependente.getCliente());

            jtbl_recebimento.requestFocus();
            jtbl_recebimento.setSelectionMode(0);
        }
    }

    public void setStatusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }

    public void acionarAtalho(java.awt.event.KeyEvent evt) {

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            setVisible(false);
            janelapai.setStatusTela(true);
        }

    }

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

            // testando se hah discrepancia entre a data que foi
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
            return (true);
        }
        return false;
    }

    public void retornarJanelaPai() {
        setVisible(false);
        if (janelapai != null) {
            janelapai.setStatusTela(true);
            janelapai.consultarContas();
        } else if(janelapai2 != null){
            janelapai2.setStatusTela(true);
            janelapai2.carregarClienteDependente(dependente);
        } else if(janelapai3 != null){
            janelapai3.setStatusTela(true);
            janelapai3.carregarClienteDependente(dependente);
        } else if(janelapai4 != null){
            janelapai4.setStatusTela(true);
            janelapai4.carregarClienteDependente(dependente);
        }
    }

    public Lancamento tbLancamentoLinhaSelecionada(JTable tb) {

        lancamento = new Lancamento();
        if (tb != null && tb.getSelectedRow() != -1) {
            lancamento = lancamentos.get(tb.getSelectedRow());
        } else {
            lancamento = null;
        }
        return lancamento;
    }

    public void alterarItemLancamento() {
        lancamento = tbLancamentoLinhaSelecionada(jtbl_recebimento);
        if (lancamento != null) {
            if (lancamentoRecebimento == null) {
                lancamentoRecebimento = new LancamentoRecebimento(lancamento);
                lancamentoRecebimento.janelapai = this;
                lancamentoRecebimento.setVisible(true);                
                this.setEnabled(false);
            } else {
                lancamentoRecebimento.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Lançamento");
            jtf_nome_cliente.requestFocus();
        }
    }
    
    public void carregarTipoLancamento() {
        List<TipoServico> tipos;
        pool = new Pool();
        TipoServicoDAO tipoServicoDAO = new TipoServicoDAO(pool);
        tipos = tipoServicoDAO.getTipoServicos("R");

        if (tipos.isEmpty()) {

        } else {
            for (int i = 0; i < tipos.size(); i++) {
                ItemDbGrid hashDbGrid = new ItemDbGrid(tipos.get(i), tipos.get(i).getDescricao());
                jcb_tipo_servico.addItem(hashDbGrid);
                System.out.println(hashDbGrid);
            }
        }
    }
}
