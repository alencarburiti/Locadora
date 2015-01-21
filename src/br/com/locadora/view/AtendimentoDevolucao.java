package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.bean.ItemLocacao;
import br.com.locadora.model.bean.Lancamento;
import br.com.locadora.model.bean.Objeto;
import br.com.locadora.model.dao.DependenteDAO;
import br.com.locadora.model.dao.DiariaDAO;
import br.com.locadora.model.dao.LocacaoDAO;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.Moeda;
import br.com.locadora.util.TemaInterface;
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
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class AtendimentoDevolucao extends javax.swing.JFrame {

    public DecimalFormat formatoPreco;
    public MaskFormatter formatoData;
    public Cliente cliente;
    public static Dependente dependente = new Dependente();
    public Objeto objeto;
    public Copia copiaDevolucao;
    public static List<Copia> copiasLocacao = new ArrayList<Copia>();
    public InterfacePool pool;
    public TelaPrincipal janelapai;
    public static List<ItemLocacao> itensDevolucao;
    public ItemLocacao itemDevolucao;
    public Moeda moeda;
    public Lancamento lancamento;
    public AcessoUsuario acesso;
    public DiariaDAO diariaDAO;
    public List<Diaria> promocoesDevolucao;
    public ConsultaCopiaDevolucao consultaCopiaDevolucao;

    public AtendimentoDevolucao() {
        initComponents();
        TemaInterface.getInterface(this);
        janelapai = null;
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
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbl_devolucao = new javax.swing.JTable();
        jl_codigo_devolucao = new javax.swing.JLabel();
        jtf_codigo_barras_objeto = new javax.swing.JTextField();
        jb_pesquisar = new javax.swing.JButton();
        jb_adicionar_devolucao = new javax.swing.JButton();
        jb_remover_locacao = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jtf_nome_objeto_devolucao = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jtf_total_a_pagar = new javax.swing.JTextField();
        jl_debito_devolucao = new javax.swing.JLabel();
        jtf_saldo_debito_total = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jtf_valor_total_relocacao = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jtf_total_desconto_entrega_antecipada = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jb_limpar = new javax.swing.JButton();
        jb_finalizar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();

        jDesktopPane1.setName("jDesktopPane1"); // NOI18N
        jDesktopPane1.setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atendimento Devolução");
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
                    .addComponent(jtf_codigo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtf_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens"));
        jPanel3.setName("jPanel3"); // NOI18N

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        jtbl_devolucao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtbl_devolucao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código de Barras", "Nome Objeto", "Data Locação", "Valor Relocação", "Dias Atraso", "Entrega Antecipada Desc."
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
        jtbl_devolucao.setName("jtbl_devolucao"); // NOI18N
        jtbl_devolucao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbl_devolucaoKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(jtbl_devolucao);
        if (jtbl_devolucao.getColumnModel().getColumnCount() > 0) {
            jtbl_devolucao.getColumnModel().getColumn(0).setPreferredWidth(20);
            jtbl_devolucao.getColumnModel().getColumn(1).setPreferredWidth(140);
            jtbl_devolucao.getColumnModel().getColumn(2).setPreferredWidth(20);
            jtbl_devolucao.getColumnModel().getColumn(3).setPreferredWidth(20);
            jtbl_devolucao.getColumnModel().getColumn(4).setPreferredWidth(10);
            jtbl_devolucao.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        jl_codigo_devolucao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jl_codigo_devolucao.setText("Código do Objeto");
        jl_codigo_devolucao.setName("jl_codigo_devolucao"); // NOI18N

        jtf_codigo_barras_objeto.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_codigo_barras_objeto.setName("jtf_codigo_barras_objeto"); // NOI18N
        jtf_codigo_barras_objeto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_codigo_barras_objetoFocusGained(evt);
            }
        });
        jtf_codigo_barras_objeto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_codigo_barras_objetoKeyPressed(evt);
            }
        });

        jb_pesquisar.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pesquisar.png"))); // NOI18N
        jb_pesquisar.setName("jb_pesquisar"); // NOI18N
        jb_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_pesquisarActionPerformed(evt);
            }
        });
        jb_pesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_pesquisarKeyPressed(evt);
            }
        });

        jb_adicionar_devolucao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_adicionar_devolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/edit_add.png"))); // NOI18N
        jb_adicionar_devolucao.setToolTipText("Incluir");
        jb_adicionar_devolucao.setName("jb_adicionar_devolucao"); // NOI18N
        jb_adicionar_devolucao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_adicionar_devolucaoMouseClicked(evt);
            }
        });
        jb_adicionar_devolucao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_adicionar_devolucaoKeyPressed(evt);
            }
        });

        jb_remover_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_remover_locacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/edit_remove.png"))); // NOI18N
        jb_remover_locacao.setToolTipText("Excluir");
        jb_remover_locacao.setName("jb_remover_locacao"); // NOI18N
        jb_remover_locacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_remover_locacaoMouseClicked(evt);
            }
        });
        jb_remover_locacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_remover_locacaoKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel3.setText("Nome Objeto");
        jLabel3.setName("jLabel3"); // NOI18N

        jtf_nome_objeto_devolucao.setEditable(false);
        jtf_nome_objeto_devolucao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_codigo_barras_objeto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_codigo_devolucao))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(50, 50, 50))
                            .addComponent(jtf_nome_objeto_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jb_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jb_adicionar_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jb_remover_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jl_codigo_devolucao)
                            .addGap(0, 0, 0)
                            .addComponent(jtf_codigo_barras_objeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jb_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jb_adicionar_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jb_remover_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, 0)
                        .addComponent(jtf_nome_objeto_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jb_pesquisar, jtf_codigo_barras_objeto});

        jLabel32.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel32.setText("Total À Pagar:");
        jLabel32.setName("jLabel32"); // NOI18N

        jtf_total_a_pagar.setEditable(false);
        jtf_total_a_pagar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtf_total_a_pagar.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtf_total_a_pagar.setText("R$ 0,00");
        jtf_total_a_pagar.setName("jtf_total_a_pagar"); // NOI18N
        jtf_total_a_pagar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_total_a_pagarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_total_a_pagarFocusLost(evt);
            }
        });

        jl_debito_devolucao.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jl_debito_devolucao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jl_debito_devolucao.setText("Débito Total:");
        jl_debito_devolucao.setName("jl_debito_devolucao"); // NOI18N

        jtf_saldo_debito_total.setEditable(false);
        jtf_saldo_debito_total.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtf_saldo_debito_total.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtf_saldo_debito_total.setText("R$ 0,00");
        jtf_saldo_debito_total.setName("jtf_saldo_debito_total"); // NOI18N
        jtf_saldo_debito_total.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_saldo_debito_totalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_saldo_debito_totalFocusLost(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel35.setText("Relocação:");
        jLabel35.setName("jLabel35"); // NOI18N

        jtf_valor_total_relocacao.setEditable(false);
        jtf_valor_total_relocacao.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtf_valor_total_relocacao.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtf_valor_total_relocacao.setText("R$ 0,00");
        jtf_valor_total_relocacao.setName("jtf_valor_total_relocacao"); // NOI18N
        jtf_valor_total_relocacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_valor_total_relocacaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_valor_total_relocacaoFocusLost(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel36.setText("Desconto Entr. Antecipada:");
        jLabel36.setName("jLabel36"); // NOI18N

        jtf_total_desconto_entrega_antecipada.setEditable(false);
        jtf_total_desconto_entrega_antecipada.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtf_total_desconto_entrega_antecipada.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtf_total_desconto_entrega_antecipada.setText("R$ 0,00");
        jtf_total_desconto_entrega_antecipada.setName("jtf_total_desconto_entrega_antecipada"); // NOI18N
        jtf_total_desconto_entrega_antecipada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_total_desconto_entrega_antecipadaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_total_desconto_entrega_antecipadaFocusLost(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/BROADWAY-LOGIN.png"))); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel2.setName("jPanel2"); // NOI18N

        jb_limpar.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jb_limpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/limpar.png"))); // NOI18N
        jb_limpar.setText("Limpar");
        jb_limpar.setName("jb_limpar"); // NOI18N
        jb_limpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_limparMouseClicked(evt);
            }
        });
        jb_limpar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_limparKeyPressed(evt);
            }
        });

        jb_finalizar.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jb_finalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/ok.png"))); // NOI18N
        jb_finalizar.setText("Finalizar");
        jb_finalizar.setName("jb_finalizar"); // NOI18N
        jb_finalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_finalizarMouseClicked(evt);
            }
        });
        jb_finalizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_finalizarKeyPressed(evt);
            }
        });

        jb_cancelar.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/exit.png"))); // NOI18N
        jb_cancelar.setText("Sair");
        jb_cancelar.setMaximumSize(new java.awt.Dimension(101, 33));
        jb_cancelar.setName("jb_cancelar"); // NOI18N
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });
        jb_cancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_cancelarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jb_finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jb_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jtf_total_desconto_entrega_antecipada, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jtf_total_a_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jtf_valor_total_relocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jl_debito_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jtf_saldo_debito_total, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_debito_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_saldo_debito_total, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_valor_total_relocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_total_desconto_entrega_antecipada, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_total_a_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtf_codigo_barras_objeto.requestFocus();

//        if (jcb_codigo_barras_devolucao.isSelected() == true) {
            jl_codigo_devolucao.setText("Código de Barras");
//            jtf_codigo_barras_objeto.requestFocus();
//        } else {
//            jl_codigo_devolucao.setText("Código dó Objeto");
//            jtf_codigo_barras_objeto.requestFocus();
//        }
    }//GEN-LAST:event_formWindowOpened

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        acionarAtalho(evt);
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
    }//GEN-LAST:event_formKeyReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        retornaJanelaPai();
    }//GEN-LAST:event_formWindowClosed

private void jb_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_clienteActionPerformed
    ConsultaClienteAtendimento consultaCliente = new ConsultaClienteAtendimento();
    consultaCliente.janelapaiDevolucao = this;
    consultaCliente.setVisible(true);
    jtf_codigo_cliente.setText("");
    setStatusTela(false);
    // TODO add your handling code here:
}//GEN-LAST:event_jb_clienteActionPerformed

private void jtf_nome_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nome_clienteKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_F5) {
        jb_cliente.doClick();
    }
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        jtf_codigo_barras_objeto.requestFocus();
    }
    acionarAtalho(evt);
}//GEN-LAST:event_jtf_nome_clienteKeyPressed

private void jtf_nome_clienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_nome_clienteFocusLost

}//GEN-LAST:event_jtf_nome_clienteFocusLost

    private void jtf_total_a_pagarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_total_a_pagarFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_a_pagarFocusGained

    private void jtf_total_a_pagarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_total_a_pagarFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_a_pagarFocusLost

    private void jtf_saldo_debito_totalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_saldo_debito_totalFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_saldo_debito_totalFocusGained

    private void jtf_saldo_debito_totalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_saldo_debito_totalFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_saldo_debito_totalFocusLost

    private void jtf_valor_total_relocacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_total_relocacaoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_total_relocacaoFocusGained

    private void jtf_valor_total_relocacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_total_relocacaoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_total_relocacaoFocusLost

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        retornaJanelaPai();
    }//GEN-LAST:event_jb_cancelarActionPerformed

    private void jb_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_clienteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ConsultaClienteAtendimento consultaCliente = new ConsultaClienteAtendimento();
            consultaCliente.janelapaiDevolucao = this;
            consultaCliente.setVisible(true);
            jtf_codigo_cliente.setText("");
            consultaCliente.jtf_consulta.setText(jtf_nome_cliente.getText().trim());
            setStatusTela(false);
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_clienteKeyPressed

    private void jb_finalizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_finalizarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            abrirCaixa();
        }
        acionarAtalho(evt);

        // TODO add your handling code here:
    }//GEN-LAST:event_jb_finalizarKeyPressed

    private void jb_cancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_cancelarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_cancelar.doClick();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_cancelarKeyPressed

    private void jb_limparKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_limparKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_limpar.doClick();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_limparKeyPressed

    private void jtf_total_desconto_entrega_antecipadaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_total_desconto_entrega_antecipadaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_desconto_entrega_antecipadaFocusGained

    private void jtf_total_desconto_entrega_antecipadaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_total_desconto_entrega_antecipadaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_desconto_entrega_antecipadaFocusLost

    private void jb_pesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_pesquisarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_finalizar.requestFocus();
        }
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            jb_pesquisar.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_pesquisarKeyPressed

    private void jb_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_pesquisarActionPerformed
        if(consultaCopiaDevolucao == null){
            consultaCopiaDevolucao = new ConsultaCopiaDevolucao();
            consultaCopiaDevolucao.janelapaiDevolucao = this;
            consultaCopiaDevolucao.setVisible(true);
            setStatusTela(false);            
        } else {
            consultaCopiaDevolucao.setVisible(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_pesquisarActionPerformed

    private void jtf_codigo_barras_objetoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_codigo_barras_objetoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            consultarCopiaLocada(jtf_codigo_barras_objeto.getText().trim());
        }
        acionarAtalho(evt);

        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            if(consultaCopiaDevolucao == null){
                consultaCopiaDevolucao = new ConsultaCopiaDevolucao();
                consultaCopiaDevolucao.janelapaiDevolucao = this;
                consultaCopiaDevolucao.setVisible(true);
                this.setVisible(false);
            } else {
                consultaCopiaDevolucao.setVisible(true);
            }
        } 
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_codigo_barras_objetoKeyPressed

    private void jtf_codigo_barras_objetoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_codigo_barras_objetoFocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_codigo_barras_objetoFocusGained

    private void jtbl_devolucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_devolucaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            removeObjeto(jtbl_devolucao);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_devolucaoKeyPressed

    private void jb_finalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_finalizarMouseClicked
        if(evt.getClickCount() == 1){
            abrirCaixa();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_finalizarMouseClicked

    private void jb_limparMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_limparMouseClicked
        if(evt.getClickCount() == 1){
            limparDados();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_limparMouseClicked

    private void jb_adicionar_devolucaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_adicionar_devolucaoMouseClicked
        if (evt.getClickCount() == 1) {
            try {
                if (itemDevolucao != null) {
                    adicionarItemDevolvido(itemDevolucao);
                }
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Código do Objeto deve ser número");
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_adicionar_devolucaoMouseClicked

    private void jb_adicionar_devolucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_adicionar_devolucaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                if (itemDevolucao != null) {
                    adicionarItemDevolvido(itemDevolucao);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Código do Objeto deve ser número");
            }
        }
    }//GEN-LAST:event_jb_adicionar_devolucaoKeyPressed

    private void jb_remover_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_remover_locacaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            removeObjeto(jtbl_devolucao);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_remover_locacaoKeyPressed

    private void jb_remover_locacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_remover_locacaoMouseClicked
        if(evt.getClickCount() == 1){
            removeObjeto(jtbl_devolucao);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_remover_locacaoMouseClicked

    private void jtf_nome_objeto_devolucaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_nome_objeto_devolucaoFocusGained

    }//GEN-LAST:event_jtf_nome_objeto_devolucaoFocusGained

    private void jtf_nome_objeto_devolucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nome_objeto_devolucaoKeyPressed
        
    }//GEN-LAST:event_jtf_nome_objeto_devolucaoKeyPressed
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
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jb_adicionar_devolucao;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_cliente;
    private javax.swing.JButton jb_finalizar;
    private javax.swing.JButton jb_limpar;
    private javax.swing.JButton jb_pesquisar;
    private javax.swing.JButton jb_remover_locacao;
    private javax.swing.JLabel jl_codigo_devolucao;
    public static javax.swing.JLabel jl_debito_devolucao;
    public static javax.swing.JTable jtbl_devolucao;
    public static javax.swing.JTextField jtf_codigo_barras_objeto;
    public static javax.swing.JTextField jtf_codigo_cliente;
    public static javax.swing.JTextField jtf_nome_cliente;
    public static javax.swing.JTextField jtf_nome_objeto_devolucao;
    public static javax.swing.JTextField jtf_saldo_debito_total;
    public static javax.swing.JTextField jtf_total_a_pagar;
    public static javax.swing.JTextField jtf_total_desconto_entrega_antecipada;
    public static javax.swing.JTextField jtf_valor_total_relocacao;
    // End of variables declaration//GEN-END:variables

    public void abrirCaixa(){
        if (verificarCampos() == true) {
            EntradaCaixaDevolucao entradaCaixaDevolucao = new EntradaCaixaDevolucao();
            entradaCaixaDevolucao.janelapaiDevolucao = this;
            entradaCaixaDevolucao.setVisible(true);
            setStatusTela(false);
        }
    }
    
    public void removeObjeto(JTable tb) {
        if (tb != null) {
            DefaultTableModel row = (DefaultTableModel) jtbl_devolucao.getModel();
            if (tb.getSelectedRow() != -1) {
                int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
                if (selectedOption == JOptionPane.YES_NO_OPTION) {
                    int index_remove = tb.getSelectedRow();
                    System.out.println("Linha deletada: " + index_remove);
                    
                    itensDevolucao.remove(index_remove);
                    row.removeRow(tb.getSelectedRow());
                    recalcularValores();
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
            jtf_codigo_barras_objeto.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public String convertMilisHora(long resultado) {
        long conversaoSegundos = TimeUnit.MILLISECONDS.toSeconds(resultado);
        String retornodeHoras;
        int hr = (int) (conversaoSegundos / 3600);
        int rem = (int) (conversaoSegundos % 3600);
        int mn = rem / 60;
        int sec = rem % 60;
        String hrStr = (hr < 10 ? "0" : "") + hr;
        String mnStr = (mn < 10 ? "0" : "") + mn;
        String secStr = (sec < 10 ? "0" : "") + sec;
        retornodeHoras = (hrStr + ":" + mnStr + ":" + secStr);
        return retornodeHoras;
    }

    public Double calcularDescontoEntregaAntecipado(ItemLocacao itemLocacao) {
        Double desconto_entrega_antecipada = 0.00;
        String retornodeHoras;
        Calendar cal;
        long resultado;
        try {
            pool = new Pool();
            diariaDAO = new DiariaDAO(pool);
            promocoesDevolucao = null;
            promocoesDevolucao = diariaDAO.getDiariaPromocaoDevolucao(itemLocacao.getCopia().getDiaria());

            DateFormat df_data_hora_locada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            DateFormat df_data = new java.text.SimpleDateFormat("dd/MM/yyyy");
            DateFormat df_hora = new SimpleDateFormat("HH:mm:ss");
            System.out.println("===============Calculo Desconto Entrega Antecipada=============");
            System.out.println("Data e Hora Locada: " + df_data_hora_locada.format(itemLocacao.getData_locacao()));

            if (promocoesDevolucao.size() > 0) {

                for (int i = 0; i < promocoesDevolucao.size(); i++) {
                    System.out.println("===============Inicio Calculo=============");
                    String df_horario_locacao = promocoesDevolucao.get(i).getPromocaoDevolucao().getHorario_locacao();
                    String df_horario_devolucao = promocoesDevolucao.get(i).getPromocaoDevolucao().getHorario_devolucao();
                    String df_horas_antecipada = promocoesDevolucao.get(i).getPromocaoDevolucao().getHora_antecipada();

                    Date horario_locacao;
                    Date horario_devolucao;
                    Date horas_antecipada = df_hora.parse(df_horas_antecipada);

                    cal = Calendar.getInstance();
                    cal.setTime(itemLocacao.getData_locacao());
                    cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH));
                    String data = new SimpleDateFormat("dd/MM/yyyy").format(cal.getTime());

                    String data_locacao_promocao = data + " " + df_horario_locacao;
                    horario_locacao = df_data_hora_locada.parse(data_locacao_promocao);
                    System.out.println("Horário Locação: " + df_data_hora_locada.format(horario_locacao));

                    Date data_devolucao = Calendar.getInstance().getTime();
                    Date horas_24 = df_hora.parse("24:00:00");

                    //Transformar a data apenas em horas
                    resultado = 0;
                    resultado = itemLocacao.getData_locacao().getTime();
                    retornodeHoras = convertMilisHora(resultado);
                    Date data_locacao = df_hora.parse(retornodeHoras);

                    //Tempo gasto para devolver                    
                    resultado = 0;
                    resultado = data_devolucao.getTime() - itemLocacao.getData_locacao().getTime();
                    retornodeHoras = convertMilisHora(resultado);
                    Date quantidade_horas_antecipada = df_hora.parse(retornodeHoras);

                    //Horas antecipadas
                    Calendar cal_hora_antecipada = Calendar.getInstance();
                    cal_hora_antecipada.setTime(horas_antecipada);

                    //Adicionar as horas de antecipacao no horario de locacao e inserir em nova variavel
                    cal = Calendar.getInstance();
                    cal.setTime(horario_locacao);
                    cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) + cal_hora_antecipada.get(Calendar.HOUR_OF_DAY));
                    cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + cal_hora_antecipada.get(Calendar.MINUTE));
                    cal.set(Calendar.SECOND, cal.get(Calendar.SECOND) + cal_hora_antecipada.get(Calendar.SECOND));

                    System.out.println("Previsão de Entrega: " + df_data_hora_locada.format(cal.getTime()));

                    System.out.println("Horas antecipadas para Entrega: " + df_hora.format(horas_antecipada));
                    horas_antecipada = cal.getTime();
                    Calendar hora_atual = Calendar.getInstance();

                    Calendar data_inicial = Calendar.getInstance();
                    data_inicial.setTime(horario_locacao);
                    data_inicial.set(Calendar.HOUR_OF_DAY, 0);
                    data_inicial.set(Calendar.MINUTE, 0);
                    data_inicial.set(Calendar.SECOND, 0);
                    data_inicial.set(Calendar.MILLISECOND, 0);
                    data_inicial.getTime();

                    Calendar data_final = Calendar.getInstance();
                    data_final.setTime(horas_antecipada);
                    data_final.set(Calendar.HOUR_OF_DAY, 0);
                    data_final.set(Calendar.MINUTE, 0);
                    data_final.set(Calendar.SECOND, 0);
                    data_final.set(Calendar.MILLISECOND, 0);
                    data_final.getTime();

                    System.out.println("Verificar se a Entrega será em dias diferentes: " + (data_final.after(data_inicial)));

                    if (data_final.after(data_inicial)) {

                        cal = Calendar.getInstance();
                        cal.setTime(itemLocacao.getData_locacao());
                        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
                        String d1 = new SimpleDateFormat("dd/MM/yyyy").format(cal.getTime());

                        String data_devolucao_promocao = d1 + " " + df_horario_devolucao;
                        horario_devolucao = df_data_hora_locada.parse(data_devolucao_promocao);
                        System.out.println("Horário Devolução: " + df_data_hora_locada.format(horario_devolucao));

                    } else {
                        cal = Calendar.getInstance();
                        cal.setTime(itemLocacao.getData_locacao());
                        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH));
                        String d1 = new SimpleDateFormat("dd/MM/yyyy").format(cal.getTime());

                        String data_devolucao_promocao = d1 + " " + df_horario_devolucao;
                        horario_devolucao = df_data_hora_locada.parse(data_devolucao_promocao);
                        System.out.println("Horário Devolução: " + df_data_hora_locada.format(horario_devolucao));
                    }

                    System.out.println("Data da Locação ---> " + df_hora.format(itemLocacao.getData_locacao().getTime()));
                    System.out.println("Data da Devolução ---> " + df_hora.format(data_devolucao.getTime()));

                    System.out.println("Condição 1 --> antecipada_permitida >= antecipada  ---> " + (horas_antecipada.getTime() >= quantidade_horas_antecipada.getTime()));
                    if (horas_antecipada.getTime() >= quantidade_horas_antecipada.getTime()) {

                        System.out.println("Condição 2 ---> (data_locacao > horario_locacao) ---> " + (data_locacao.getTime() > horario_locacao.getTime()));
                        System.out.println("Param. 1 ---> " + data_locacao);
                        System.out.println("Param. 2 ---> " + horario_locacao);
                        System.out.println("Condição 2.1 ---> data_locacao < horario_devolucao ---> " + (data_locacao.getTime() < horario_devolucao.getTime()));
                        System.out.println("Param. 1 ---> " + data_locacao);
                        System.out.println("Param. 2 ---> " + horario_devolucao);

                        if (itemLocacao.getData_locacao().getTime() > horario_locacao.getTime() && itemLocacao.getData_locacao().getTime() < horario_devolucao.getTime()) {

                            System.out.println("Condição 3.1 ---> (data_devolucao < horario_devolucao) ---> " + (data_devolucao.getTime() < horario_devolucao.getTime()));
                            System.out.println("Param. 1 ---> " + data_devolucao);
                            System.out.println("Param. 2 ---> " + horario_devolucao);
                            if (data_devolucao.getTime() < horario_devolucao.getTime()) {
                                desconto_entrega_antecipada = promocoesDevolucao.get(i).getPromocaoDevolucao().getValor_promocao_devolucao();
                                System.out.println("Desconto: " + desconto_entrega_antecipada);
                                System.out.println("Com desconto");
                                break;
                            } else {
                                desconto_entrega_antecipada = 0.00;
                                System.out.println("Demorou devolver ");
                            }
                        } else {
                            desconto_entrega_antecipada = 0.00;
                            System.out.println("Fora do periodo de locacao e devolucao");
                        }

                    } else {
                        desconto_entrega_antecipada = 0.00;
                        System.out.println("Tempo excedido");
                    }
                    System.out.println("===============Fim Calculo=============");
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(AtendimentoDevolucao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return desconto_entrega_antecipada;

    }

    public void recalcularValores(){
        moeda = new Moeda();
        Double relocacao = 0.00;
        Double descontos = 0.00;
        Double valor_total;
        
        for(int i = 0; i < jtbl_devolucao.getRowCount(); i++){
            relocacao = relocacao + moeda.getPrecoFormato(jtbl_devolucao.getValueAt(i, 3).toString());
            descontos = descontos + moeda.getPrecoFormato(jtbl_devolucao.getValueAt(i, 5).toString());
        }
        
        Double saldo_debito_anterior;
        
        if(jtf_saldo_debito_total.getForeground() == Color.RED){
            saldo_debito_anterior = moeda.getPrecoFormato(jtf_saldo_debito_total.getText());
//            saldo_debito_anterior = saldo_debito_anterior * (-1);
            valor_total = (saldo_debito_anterior + relocacao) - descontos;
            if(valor_total > 0){
                jtf_total_a_pagar.setText(moeda.setPrecoFormat(valor_total.toString()));
            } else {
                jtf_total_a_pagar.setText("R$ 0,00");
            }
        } else {
            saldo_debito_anterior = moeda.getPrecoFormato(jtf_saldo_debito_total.getText());
            valor_total = (saldo_debito_anterior + descontos) - relocacao;
            if(valor_total > 0){                
                jtf_total_a_pagar.setText("R$ 0,00");
            } else {
                valor_total = valor_total * (-1);
                jtf_total_a_pagar.setText(moeda.setPrecoFormat(valor_total.toString()));            
            }
        }
        
        jtf_valor_total_relocacao.setText(moeda.setPrecoFormat(relocacao.toString()));
        jtf_total_desconto_entrega_antecipada.setText(moeda.setPrecoFormat(descontos.toString()));
        
    }
    
    public void carregarCopiaDevolucao(ItemLocacao itemDevolucao){
        if(itemDevolucao != null){
            jtf_codigo_barras_objeto.setText(itemDevolucao.getCopia().getCodigo_barras());
            jtf_nome_objeto_devolucao.setText(itemDevolucao.getCopia().getObjeto().getTitulo());
            jb_adicionar_devolucao.requestFocus();
        }
        
    }
    
    public void adicionarItemDevolvido(ItemLocacao itemLocacao) {

        moeda = new Moeda();
        DateFormat df_data_hora_locada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        if (itemLocacao != null) {
            if (verificaTabela(itemLocacao) == false) {

                Double desconto_entrega_antecipada;
                
                if(itemLocacao.getValor_multa() > 0){
                    desconto_entrega_antecipada = 0.00;
                } else if (itemLocacao.getCopia().getDiaria().getPromocaoLocacao().getCodigo_promocao_locacao() == 0){
                    desconto_entrega_antecipada = calcularDescontoEntregaAntecipado(itemLocacao);                                        
                }else {
                    desconto_entrega_antecipada = 0.00;
                }
                
                DefaultTableModel row = (DefaultTableModel) jtbl_devolucao.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(itemLocacao, itemLocacao.getCopia().getObjeto().getTitulo());
                row.addRow(new Object[]{itemLocacao.getCopia().getCodigo_barras(), hashDbGrid, df_data_hora_locada.format(itemLocacao.getData_locacao()),
                    moeda.setPrecoFormat(itemLocacao.getValor_multa().toString()), itemLocacao.getDias_multa(),
                    moeda.setPrecoFormat(desconto_entrega_antecipada.toString())});
                
                recalcularValores();
                itensDevolucao.add(itemLocacao);
                limparItemDevolvido();
            } else {
                JOptionPane.showMessageDialog(null, "Esta cópia já foi adicionada");
                jtf_codigo_barras_objeto.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Objeto inválido para adicionar");
        }

    }

    public void limparItemDevolvido() {
        jtf_codigo_barras_objeto.setText("");
        jtf_nome_objeto_devolucao.setText("");
        jtf_codigo_barras_objeto.requestFocus();
    }

    public void setStatusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }

    public void carregarClienteDependente(Dependente dependente) {
        if (dependente != null) {
            AtendimentoDevolucao.dependente = dependente;
            jtf_saldo_debito_total.setText("R$ 0,00");

            jtf_nome_cliente.setText(dependente.getNome_dependente());
            setTitle("Atendimento Devolução - " + dependente.getNome_dependente());
            jtf_codigo_cliente.setText(String.valueOf(dependente.getCliente().getCodigo_cliente()));
            Moeda moeda = new Moeda();

            pool = new Pool();
            DependenteDAO dependenteDAO = new DependenteDAO(pool);

            lancamento = new Lancamento();
            lancamento = dependenteDAO.getClienteDependente(dependente.getCliente().getCodigo_cliente());
            if (lancamento.getSaldo() < 0) {
                lancamento.setSaldo(lancamento.getSaldo() * (-1));
                jtf_saldo_debito_total.setText(moeda.setPrecoFormat(String.valueOf(lancamento.getSaldo())));
                jtf_saldo_debito_total.setForeground(Color.black);
                jl_debito_devolucao.setText("Saldo Total:");
            } else if (lancamento.getSaldo() > 0) {
                jtf_saldo_debito_total.setText(moeda.setPrecoFormat(String.valueOf(lancamento.getSaldo())));
                jtf_saldo_debito_total.setForeground(Color.red);
                jl_debito_devolucao.setText("Débito Total:");
            } else {
                jtf_saldo_debito_total.setText("R$ 0,00");
                jl_debito_devolucao.setText("Saldo:");
                jtf_saldo_debito_total.setForeground(Color.black);
            }

            jtf_codigo_barras_objeto.requestFocus();

            //Limpa tabela depois de selecionar novo cliente
            DefaultTableModel tb_devolucao = (DefaultTableModel) jtbl_devolucao.getModel();
            int rows = tb_devolucao.getRowCount();
            for (int i = rows - 1; i >= 0; i--) {
                tb_devolucao.removeRow(i);
            }

            jtf_total_a_pagar.setText("R$ 0,00");
            itensDevolucao = new ArrayList<ItemLocacao>();
        }
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
                        carregarCopiaDevolucao(itemDevolucao);
//                        adicionarItemDevolvido(itemDevolucao);
                    } else {
                        JOptionPane.showMessageDialog(null, "Código de Barra inválido");
                    }
                } else {
                    itemDevolucao = locacaoDAO.getLocacaoAberta(dependente.getCodigo_dependente(), codigo_barras);
                    if (itemDevolucao != null) {
                        carregarCopiaDevolucao(itemDevolucao);
//                        adicionarItemDevolvido(itemDevolucao);
                    } else {
                        JOptionPane.showMessageDialog(null, "Código de Barra inválido para Cliente");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Código de Barra inválido");
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
       
    private void retornaJanelaPai() {
        setVisible(false);
        if (janelapai != null) {
            janelapai.setStatusTela(true);
            janelapai.atendimentoDevolucao = null;
            janelapai = null;
        }
    }

    public void acionarAtalho(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F10) {
            abrirCaixa();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            retornaJanelaPai();
        }
    }

    private void limparDados() {
        jtf_codigo_cliente.setText("");
        jtf_nome_cliente.setText("");
        jtf_total_a_pagar.setText("R$ 0,00");
        jtf_total_desconto_entrega_antecipada.setText("R$ 0,00");
        jtf_saldo_debito_total.setText("R$ 0,00");

        DefaultTableModel tb_devolucao = (DefaultTableModel) jtbl_devolucao.getModel();
        int rows = tb_devolucao.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            tb_devolucao.removeRow(i);
        }
        jtf_codigo_barras_objeto.setText("");
        jtf_codigo_barras_objeto.requestFocus();
    }

}
