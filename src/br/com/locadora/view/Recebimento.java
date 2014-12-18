package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.controller.SiscomController;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Cliente;
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
import br.com.locadora.util.TemaInterface;
import static br.com.locadora.view.AtendimentoLocacao.jtf_nome_objeto_locacao;
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
    AcessoUsuario acesso;

    public Recebimento() {
        initComponents();
        TemaInterface.getInterface(this);
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
        jb_remover_locacao = new javax.swing.JButton();
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
        jLabel27 = new javax.swing.JLabel();
        jtf_total_credito = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jtf_total_debito = new javax.swing.JTextField();
        jl_saldo = new javax.swing.JLabel();
        jtf_saldo = new javax.swing.JTextField();

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
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_codigo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jtf_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jb_cliente))
                .addGap(10, 10, 10))
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

        jl_codigo_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jl_codigo_locacao.setText("Serviço");
        jl_codigo_locacao.setName("jl_codigo_locacao"); // NOI18N

        jb_adicionar_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
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

        jb_remover_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_remover_locacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/edit_remove.png"))); // NOI18N
        jb_remover_locacao.setToolTipText("Excluir");
        jb_remover_locacao.setName("jb_remover_locacao"); // NOI18N
        jb_remover_locacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_remover_locacaoActionPerformed(evt);
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
                .addGap(10, 10, 10)
                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jp_locacaoLayout.createSequentialGroup()
                        .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcb_tipo_servico, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_codigo_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_locacaoLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jp_locacaoLayout.createSequentialGroup()
                                .addComponent(jtf_data_lancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jtf_valor_lancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jb_adicionar_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jb_remover_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(10, 10, 10))
        );
        jp_locacaoLayout.setVerticalGroup(
            jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_locacaoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
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
                    .addComponent(jb_adicionar_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_remover_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jp_locacaoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jb_adicionar_locacao, jb_remover_locacao, jcb_tipo_servico, jtf_data_lancamento, jtf_valor_lancamento});

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/BROADWAY-LOGIN.png"))); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel27.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Total Crédito:");
        jLabel27.setName("jLabel27"); // NOI18N

        jtf_total_credito.setEditable(false);
        jtf_total_credito.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
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

        jLabel28.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Total Débito:");
        jLabel28.setName("jLabel28"); // NOI18N

        jtf_total_debito.setEditable(false);
        jtf_total_debito.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
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

        jl_saldo.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jl_saldo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jl_saldo.setText("Devedor:");
        jl_saldo.setName("jl_saldo"); // NOI18N

        jtf_saldo.setEditable(false);
        jtf_saldo.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(566, 566, 566)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtf_total_credito, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(20, 20, 20)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(474, 474, 474)
                                    .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jp_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jl_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtf_saldo, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(jtf_total_debito))))
                .addGap(20, 20, 20))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jtf_saldo, jtf_total_credito, jtf_total_debito});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jp_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_total_credito, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_total_debito, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jtf_saldo, jtf_total_credito, jtf_total_debito});

        setSize(new java.awt.Dimension(842, 610));
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
        Moeda moeda = new Moeda();
        if (jtf_valor_lancamento.getText().equals("R$ 0,00")) {
            jtf_valor_lancamento.setText("");
        } else {
            jtf_valor_lancamento.setText(moeda.setPrecoFormat(jtf_valor_lancamento.getText()));
        }
        jtf_valor_lancamento.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (jtf_valor_lancamento.getText().trim().equals("RS 0,00")) {
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
            jb_adicionar_locacao.doClick();
        }
        acionarAtalho(evt);

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
                new Recebimento().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jb_adicionar_locacao;
    private javax.swing.JButton jb_cliente;
    private javax.swing.JButton jb_remover_locacao;
    private javax.swing.JComboBox jcb_tipo_servico;
    private javax.swing.JLabel jl_codigo_locacao;
    private javax.swing.JLabel jl_saldo;
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
            usuario.setCodigo_usuario(Integer.parseInt(conf.readPropertie("codigo_usuario")));
            lancamento.setCaixa(Integer.parseInt(conf.readPropertie("caixa")));
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
            System.out.println(lancamento.getSaldo());
            if (lancamento.getSaldo() < 0) {
                lancamento.setSaldo(lancamento.getSaldo() * (-1));
                jtf_saldo.setText(moeda.setPrecoFormat(String.valueOf(lancamento.getSaldo())));
                jtf_saldo.setCaretColor(Color.black);
                jtf_saldo.setForeground(Color.black);
                jl_saldo.setText("Saldo:");
            } else if (lancamento.getSaldo() > 0) {
                jtf_saldo.setText(moeda.setPrecoFormat(String.valueOf(lancamento.getSaldo())));
                jtf_saldo.setCaretColor(Color.red);
                jtf_saldo.setForeground(Color.red);
                jl_saldo.setText("Devedor:");
            } else {
                jl_saldo.setText("Saldo:");
                jtf_saldo.setForeground(Color.black);
                jtf_saldo.setText("R$ 0,00");
            }

            jtf_total_credito.setText(moeda.setPrecoFormat(String.valueOf(lancamento.getCredito())));
            jtf_total_debito.setText(moeda.setPrecoFormat(String.valueOf(lancamento.getDebito())));

            jcb_tipo_servico.requestFocus();

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

    public void acionarAtalho(java.awt.event.KeyEvent evt) {

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            setVisible(false);
            janelapai.setStatusTela(true);
        }

    }
}
