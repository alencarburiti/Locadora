package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.controller.SiscomController;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.bean.Lancamento;
import br.com.locadora.model.bean.Objeto;
import br.com.locadora.model.bean.Produto;
import br.com.locadora.model.bean.PromocaoLocacao;
import br.com.locadora.model.dao.CopiaDAO;
import br.com.locadora.model.dao.DependenteDAO;
import br.com.locadora.model.dao.DiariaDAO;
import br.com.locadora.model.dao.LancamentoDAO;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.LimitadorTexto;
import br.com.locadora.util.Moeda;
import br.com.locadora.util.TemaInterface;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
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
    public List<Diaria> promocoes;
    public Diaria diariaCombo;
    public PromocaoLocacao promocao;

    public AtendimentoLocacao() {
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
        jb_adicionar_locacao = new javax.swing.JButton();
        jb_remover_locacao = new javax.swing.JButton();
        jcb_codigo_barras_locacao = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jcb_promocao = new javax.swing.JComboBox();
        jl_debito_locacao = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jtf_debito_total_locacao = new javax.swing.JTextField();
        jtf_valor_total_locacao = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jb_finalizar = new javax.swing.JButton();
        jb_limpar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
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
        jtf_nome_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_nome_clienteActionPerformed(evt);
            }
        });
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                    .addComponent(jtf_codigo_cliente))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtf_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10))
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

        jp_locacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens Locação"));
        jp_locacao.setName("jp_locacao"); // NOI18N

        jtf_valor_locacao.setEditable(false);
        jtf_valor_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_valor_locacao.setText("R$ 0,00");
        jtf_valor_locacao.setName("jtf_valor_locacao"); // NOI18N
        jtf_valor_locacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_valor_locacaoActionPerformed(evt);
            }
        });
        jtf_valor_locacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_valor_locacaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_valor_locacaoFocusLost(evt);
            }
        });

        jtf_tipo_midia.addKeyListener(new java.awt.event.KeyAdapter() {     // cria um listener ouvinte de digitação do fieldNumero

            public void keyReleased(java.awt.event.KeyEvent evt) {  // cria um ouvinte para cada tecla pressionada

                jtf_tipo_midia.setText(jtf_tipo_midia.getText().replaceAll("[^0-9]", "")); // faz com que pegue o texto a cada tecla digitada, e substituir tudo que não(^) seja numero  por ""

            }
        });
        jtf_tipo_midia.setEditable(false);
        jtf_tipo_midia.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
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

        jtf_diaria.setEditable(false);
        jtf_diaria.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_diaria.setName("jtf_diaria"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel3.setText("Nome Objeto");
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel5.setText("Valor");
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel6.setText("Promoção");
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel13.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel13.setText("Diária");
        jLabel13.setName("jLabel13"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jtbl_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtbl_locacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código de Barras", "Nome Objeto", "Valor", "Diária", "Censura", "Promoção"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
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
        jtbl_locacao.setName("jtbl_locacao"); // NOI18N
        jtbl_locacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbl_locacaoKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtbl_locacao);
        if (jtbl_locacao.getColumnModel().getColumnCount() > 0) {
            jtbl_locacao.getColumnModel().getColumn(0).setPreferredWidth(30);
            jtbl_locacao.getColumnModel().getColumn(1).setPreferredWidth(150);
            jtbl_locacao.getColumnModel().getColumn(2).setPreferredWidth(30);
            jtbl_locacao.getColumnModel().getColumn(3).setPreferredWidth(30);
            jtbl_locacao.getColumnModel().getColumn(4).setPreferredWidth(20);
        }

        jtf_nome_objeto_locacao.setEditable(false);
        jtf_nome_objeto_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
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

        jl_codigo_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jl_codigo_locacao.setText("Código de Barras");
        jl_codigo_locacao.setName("jl_codigo_locacao"); // NOI18N

        jtf_codigo_consulta_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
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

        jButton1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pesquisar.png"))); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
        jb_remover_locacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_remover_locacaoKeyPressed(evt);
            }
        });

        jcb_codigo_barras_locacao.setSelected(true);
        jcb_codigo_barras_locacao.setText("Usar Código de Barras");
        jcb_codigo_barras_locacao.setName("jcb_codigo_barras_locacao"); // NOI18N
        jcb_codigo_barras_locacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_codigo_barras_locacaoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel7.setText("Tipo Mídia");
        jLabel7.setName("jLabel7"); // NOI18N

        jcb_promocao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_promocao.setMaximumRowCount(20);
        jcb_promocao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        jcb_promocao.setName("jcb_promocao"); // NOI18N
        jcb_promocao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_promocaoActionPerformed(evt);
            }
        });
        jcb_promocao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcb_promocaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jcb_promocaoFocusLost(evt);
            }
        });
        jcb_promocao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcb_promocaoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jcb_promocaoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jp_locacaoLayout = new javax.swing.GroupLayout(jp_locacao);
        jp_locacao.setLayout(jp_locacaoLayout);
        jp_locacaoLayout.setHorizontalGroup(
            jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_locacaoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_locacaoLayout.createSequentialGroup()
                        .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_valor_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_locacaoLayout.createSequentialGroup()
                                .addComponent(jtf_diaria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jtf_tipo_midia, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jp_locacaoLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_locacaoLayout.createSequentialGroup()
                                .addComponent(jcb_promocao, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jb_adicionar_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jb_remover_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jp_locacaoLayout.createSequentialGroup()
                        .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_codigo_consulta_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_codigo_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jp_locacaoLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(280, 280, 280))
                            .addGroup(jp_locacaoLayout.createSequentialGroup()
                                .addComponent(jtf_nome_objeto_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jcb_codigo_barras_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2))
                .addGap(20, 20, 20))
        );
        jp_locacaoLayout.setVerticalGroup(
            jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_locacaoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_codigo_locacao)
                    .addComponent(jLabel3))
                .addGap(0, 0, 0)
                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_locacaoLayout.createSequentialGroup()
                        .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_codigo_consulta_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_nome_objeto_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jp_locacaoLayout.createSequentialGroup()
                                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7))
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtf_diaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtf_tipo_midia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcb_promocao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jb_adicionar_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jb_remover_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jp_locacaoLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, 0)
                                .addComponent(jtf_valor_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jcb_codigo_barras_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jp_locacaoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jb_adicionar_locacao, jb_remover_locacao, jcb_promocao, jtf_diaria, jtf_tipo_midia});

        jp_locacaoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jcb_codigo_barras_locacao, jtf_codigo_consulta_locacao, jtf_nome_objeto_locacao, jtf_valor_locacao});

        jl_debito_locacao.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jl_debito_locacao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jl_debito_locacao.setText("Devedor:");
        jl_debito_locacao.setName("jl_debito_locacao"); // NOI18N

        jLabel27.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Total:");
        jLabel27.setName("jLabel27"); // NOI18N

        jtf_debito_total_locacao.setEditable(false);
        jtf_debito_total_locacao.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
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

        jtf_valor_total_locacao.setEditable(false);
        jtf_valor_total_locacao.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
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

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel2.setName("jPanel2"); // NOI18N

        jb_finalizar.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jb_finalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/ok.png"))); // NOI18N
        jb_finalizar.setText("Finalizar");
        jb_finalizar.setName("jb_finalizar"); // NOI18N
        jb_finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_finalizarActionPerformed(evt);
            }
        });
        jb_finalizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_finalizarKeyPressed(evt);
            }
        });

        jb_limpar.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jb_limpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/limpar.png"))); // NOI18N
        jb_limpar.setText("Limpar");
        jb_limpar.setName("jb_limpar"); // NOI18N
        jb_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_limparActionPerformed(evt);
            }
        });
        jb_limpar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_limparKeyPressed(evt);
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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jb_finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jb_limpar)
                .addGap(10, 10, 10)
                .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jb_finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jb_limpar)
                        .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/BROADWAY-LOGIN.png"))); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl_debito_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jtf_debito_total_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jtf_valor_total_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0))
                    .addComponent(jp_locacao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(747, 747, 747)
                        .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jp_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_debito_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_debito_total_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_valor_total_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(848, 594));
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
    ConsultaClienteAtendimento consultaCliente = new ConsultaClienteAtendimento();
    consultaCliente.janelapaiLocacao = this;
    consultaCliente.setVisible(true);
    consultaCliente.jtf_consulta.setText(jtf_nome_cliente.getText().trim());
    setStatusTela(false);
}//GEN-LAST:event_jb_clienteActionPerformed

private void jtf_nome_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nome_clienteKeyPressed
    acionarAtalho(evt);
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        jb_cliente.doClick();

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

    private void jb_finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_finalizarActionPerformed
        enviarDadosLocacao();
    }//GEN-LAST:event_jb_finalizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jtf_codigo_cliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe primeiro um cliente");
            jtf_nome_cliente.requestFocus();
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
        removeObjeto(jtbl_locacao);
    }//GEN-LAST:event_jb_remover_locacaoActionPerformed

    private void jb_adicionar_locacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_adicionar_locacaoActionPerformed
        try {

            if (!jtf_codigo_cliente.getText().equals("")) {

                if (jcb_codigo_barras_locacao.isSelected() == true) {
                    locar_consulta_codigo_barras(jtf_codigo_consulta_locacao.getText().trim());
                    adicionarItemLocado(copias.get(0));
                } else {
                    locar_consulta_codigo_objeto(Integer.parseInt(jtf_codigo_consulta_locacao.getText().trim()));
                    adicionarItemLocado(copias.get(0));
                }

            } else {
                JOptionPane.showMessageDialog(null, "Informe primeiro um Cliente");
                jtf_codigo_cliente.requestFocus();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Código do Objeto deve ser número");
        }


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

    private void jtf_codigo_consulta_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_codigo_consulta_locacaoKeyPressed
        try {

            if (!jtf_codigo_cliente.getText().equals("")) {
                acionarAtalho(evt);
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (jcb_codigo_barras_locacao.isSelected() == true) {
                        locar_consulta_codigo_barras(jtf_codigo_consulta_locacao.getText().trim());
                    } else {
                        locar_consulta_codigo_objeto(Integer.parseInt(jtf_codigo_consulta_locacao.getText().trim()));
                    }
                }
                if (evt.getKeyCode() == KeyEvent.VK_F5) {
                    ConsultaCopiaLocacao copiaCliente = new ConsultaCopiaLocacao();
                    copiaCliente.janelapai = this;
                    copiaCliente.setVisible(true);
                    setStatusTela(false);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Informe primeiro um Cliente");
                jtf_codigo_cliente.requestFocus();
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
            jb_adicionar_locacao.doClick();
        }
    }//GEN-LAST:event_jb_adicionar_locacaoKeyPressed

    private void jb_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_clienteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_cliente.doClick();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_clienteKeyPressed

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        setVisible(false);
        janelapai.setStatusTela(true);
    }//GEN-LAST:event_jb_cancelarActionPerformed

    private void jb_finalizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_finalizarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_finalizar.doClick();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_finalizarKeyPressed

    private void jcb_codigo_barras_locacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_codigo_barras_locacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_codigo_barras_locacaoActionPerformed

    private void jcb_promocaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_promocaoActionPerformed
        jcb_promocao.setSelectedItem(jcb_promocao.getSelectedIndex());
    }//GEN-LAST:event_jcb_promocaoActionPerformed

    private void jcb_promocaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcb_promocaoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_promocaoFocusGained

    private void jcb_promocaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcb_promocaoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_promocaoFocusLost

    private void jcb_promocaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcb_promocaoKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jcb_promocao.setSelectedItem(jcb_promocao.getSelectedIndex());
            ItemDbGrid hashDbGrid1 = (ItemDbGrid) jcb_promocao.getSelectedItem();
            diariaCombo = (Diaria) hashDbGrid1.getObjeto();

            System.out.println("====Verificação após seleção com Enter=====================================");
            System.out.println("Código da promoção no ComboBox: " + diariaCombo.getPromocaoLocacao().getCodigo_promocao_locacao());
            System.out.println("Nome da promoção no ComboBox: " + diariaCombo.getPromocaoLocacao().getDescricao());
            System.out.println("Valor da promoção no ComboBox: " + diariaCombo.getPromocaoLocacao().getValor_promocao_locacao());
            System.out.println("Valor do Index: " + jcb_promocao.getSelectedIndex());
            System.out.println("=================================================================");

            jb_adicionar_locacao.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_promocaoKeyPressed

    private void jcb_promocaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcb_promocaoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_promocaoKeyReleased

    private void jb_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_limparActionPerformed
        limparCampos();
        limparItemLocado();
    }//GEN-LAST:event_jb_limparActionPerformed

    private void jb_limparKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_limparKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_limpar.doClick();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_limparKeyPressed

    private void jtf_nome_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_nome_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nome_clienteActionPerformed

    private void jtf_valor_locacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_valor_locacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_locacaoActionPerformed

    private void jb_remover_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_remover_locacaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_remover_locacao.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_remover_locacaoKeyPressed

    private void jtbl_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_locacaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            jb_remover_locacao.doClick();
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jtbl_locacaoKeyPressed

    private void jb_cancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_cancelarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_cancelar.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_cancelarKeyPressed

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
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jb_adicionar_locacao;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_cliente;
    private javax.swing.JButton jb_finalizar;
    private javax.swing.JButton jb_limpar;
    private javax.swing.JButton jb_remover_locacao;
    private javax.swing.JCheckBox jcb_codigo_barras_locacao;
    private javax.swing.JComboBox jcb_promocao;
    private javax.swing.JLabel jl_codigo_locacao;
    private javax.swing.JLabel jl_debito_locacao;
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
    // End of variables declaration//GEN-END:variables

    private void enviarDadosLocacao() {
        if (verificarCampos() == true) {
            if (jtbl_locacao.getRowCount() > 0) {
                EntradaCaixa entradaCaixa;
                entradaCaixa = new EntradaCaixa();
                entradaCaixa.setVisible(true);
                setStatusTela(false);
                entradaCaixa.janelapaiLocacao = this;
            } else {
                JOptionPane.showMessageDialog(null, "Insina um objeto no mínimo");
            }
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
            jtf_nome_cliente.requestFocus();
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
            if (verificaTabela(copia) == false) {

                pool = new Pool();
                CopiaDAO copiaDAO = new CopiaDAO(pool);
                String assistido_anteriormente;
                assistido_anteriormente = copiaDAO.getQuantidadeAssistida(dependente.getCodigo_dependente(), copia.getCodigo_barras());

                if (!"".equals(assistido_anteriormente)) {
                    int selectedOption = JOptionPane.showConfirmDialog(this, assistido_anteriormente, "Atenção", JOptionPane.YES_NO_OPTION);
                    if (selectedOption == JOptionPane.YES_NO_OPTION) {
                        adicionaItemTabela(copia);
                    } else {

                        limparItemLocado();
                        jtf_codigo_consulta_locacao.requestFocus();
                    }
                } else {
                    adicionaItemTabela(copia);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Última cópia disponível já foi adicionada: " + copia.getCodigo_barras());
                jtf_codigo_consulta_locacao.requestFocus();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel adicionar ");
        }
    }

    public void adicionaItemTabela(Copia copia) {
        Date d = new Date();
        Calendar c = new GregorianCalendar();
        c.setTime(d);
        Boolean domingo = false;
        Boolean segunda = false;
        Boolean terca = false;
        Boolean quarta = false;
        Boolean quinta = false;
        Boolean sexta = false;
        Boolean sabado = false;
        int dia = c.get(c.DAY_OF_WEEK);
        switch (dia) {
            case Calendar.SUNDAY:
                domingo = true;
                break;
            case Calendar.MONDAY:
                segunda = true;
                break;
            case Calendar.TUESDAY:
                terca = true;
                break;
            case Calendar.WEDNESDAY:
                quarta = true;
                break;
            case Calendar.THURSDAY:
                quinta = true;
                break;
            case Calendar.FRIDAY:
                sexta = true;
                break;
            case Calendar.SATURDAY:
                sabado = true;
                break;
        }

        System.out.println("====================Inciar Verificação para Diária: " + diariaCombo.getCodigo_diaria());
        System.out.println("Tamanho da tabela: " + jtbl_locacao.getRowCount());
        System.out.println("Tamanho da lista de Copias Locacao: " + copiasLocacao.size());
        System.out.println("Hoje: " + domingo + " Dia Promocao: " + diariaCombo.getPromocaoLocacao().getDomingo());
        System.out.println("Hoje: " + segunda + " Dia Promocao: " + diariaCombo.getPromocaoLocacao().getSegunda());
        System.out.println("Hoje: " + terca + " Dia Promocao: " + diariaCombo.getPromocaoLocacao().getTerca());
        System.out.println("Hoje: " + quarta + " Dia Promocao: " + diariaCombo.getPromocaoLocacao().getQuarta());
        System.out.println("Hoje: " + quinta + " Dia Promocao: " + diariaCombo.getPromocaoLocacao().getQuinta());
        System.out.println("Hoje: " + sexta + " Dia Promocao: " + diariaCombo.getPromocaoLocacao().getSexta());
        System.out.println("Hoje: " + sabado + " Dia Promocao: " + diariaCombo.getPromocaoLocacao().getSabado());
        Diaria diariaLocaGanha;
        if (diariaCombo.getPromocaoLocacao().getDomingo() == true && domingo == true) {
            System.out.println("Descrição da Promoção: " + diariaCombo.getPromocaoLocacao().getDescricao());
            System.out.println("Hoje: " + domingo + " Dia Promocao: " + diariaCombo.getPromocaoLocacao().getDomingo());
            if (diariaCombo.getPromocaoLocacao().getGanhar_quantidade() > 0) {
                System.out.println("Calcular promocao Loca Ganha");
                diariaLocaGanha = calculaPromocaoLocaGanha(diariaCombo);
                DefaultTableModel row = (DefaultTableModel) jtbl_locacao.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(copia, copia.getObjeto().getTitulo());
                row.addRow(new Object[]{copia.getCodigo_barras(),
                    hashDbGrid, moeda.setPrecoFormat(String.valueOf(diariaLocaGanha.getPromocaoLocacao().getValor_promocao_locacao())),
                    copia.getObjeto().getDiaria().getDias(), copia.getObjeto().getCensura(), diariaLocaGanha.getPromocaoLocacao().getDescricao()});

                adicionarValorTotal(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao()));
                copiasLocacao.add(copia);
                limparItemLocado();
                jtf_codigo_consulta_locacao.requestFocus();
            } else {
                System.out.println("Calcular promocao Simples semanal");
                System.out.println("Valor promoção: " + moeda.setPrecoFormat(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao())));
                DefaultTableModel row = (DefaultTableModel) jtbl_locacao.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(copia, copia.getObjeto().getTitulo());
                row.addRow(new Object[]{copia.getCodigo_barras(),
                    hashDbGrid, moeda.setPrecoFormat(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao())),
                    copia.getObjeto().getDiaria().getDias(), copia.getObjeto().getCensura(), diariaCombo.getPromocaoLocacao().getDescricao()});

                adicionarValorTotal(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao()));
                copiasLocacao.add(copia);
                limparItemLocado();
                jtf_codigo_consulta_locacao.requestFocus();

            }
        } else if (diariaCombo.getPromocaoLocacao().getSegunda() == true && segunda == true) {
            System.out.println("Descrição da Promoção: " + diariaCombo.getPromocaoLocacao().getDescricao());
            System.out.println("Hoje: " + segunda + " Dia Promocao: " + diariaCombo.getPromocaoLocacao().getSegunda());
            if (diariaCombo.getPromocaoLocacao().getGanhar_quantidade() > 0) {
                System.out.println("Calcular promocao Loca Ganha");
                diariaLocaGanha = calculaPromocaoLocaGanha(diariaCombo);
                DefaultTableModel row = (DefaultTableModel) jtbl_locacao.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(copia, copia.getObjeto().getTitulo());
                row.addRow(new Object[]{copia.getCodigo_barras(),
                    hashDbGrid, moeda.setPrecoFormat(String.valueOf(diariaLocaGanha.getPromocaoLocacao().getValor_promocao_locacao())),
                    copia.getObjeto().getDiaria().getDias(), copia.getObjeto().getCensura(), diariaLocaGanha.getPromocaoLocacao().getDescricao()});

                adicionarValorTotal(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao()));
                copiasLocacao.add(copia);
                limparItemLocado();
                jtf_codigo_consulta_locacao.requestFocus();
            } else {
                System.out.println("Calcular promocao Simples semanal");
                System.out.println("Valor promoção: " + moeda.setPrecoFormat(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao())));
                DefaultTableModel row = (DefaultTableModel) jtbl_locacao.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(copia, copia.getObjeto().getTitulo());
                row.addRow(new Object[]{copia.getCodigo_barras(),
                    hashDbGrid, moeda.setPrecoFormat(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao())),
                    copia.getObjeto().getDiaria().getDias(), copia.getObjeto().getCensura(), diariaCombo.getPromocaoLocacao().getDescricao()});

                adicionarValorTotal(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao()));
                copiasLocacao.add(copia);
                limparItemLocado();
                jtf_codigo_consulta_locacao.requestFocus();

            }
        } else if (diariaCombo.getPromocaoLocacao().getTerca() == true && terca == true) {
            System.out.println("Descrição da Promoção: " + diariaCombo.getPromocaoLocacao().getDescricao());
            System.out.println("Hoje: " + terca + " Dia Promocao: " + diariaCombo.getPromocaoLocacao().getTerca());
            if (diariaCombo.getPromocaoLocacao().getGanhar_quantidade() > 0) {
                System.out.println("Calcular promocao Loca Ganha");
                diariaLocaGanha = calculaPromocaoLocaGanha(diariaCombo);
                DefaultTableModel row = (DefaultTableModel) jtbl_locacao.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(copia, copia.getObjeto().getTitulo());
                row.addRow(new Object[]{copia.getCodigo_barras(),
                    hashDbGrid, moeda.setPrecoFormat(String.valueOf(diariaLocaGanha.getPromocaoLocacao().getValor_promocao_locacao())),
                    copia.getObjeto().getDiaria().getDias(), copia.getObjeto().getCensura(), diariaLocaGanha.getPromocaoLocacao().getDescricao()});

                adicionarValorTotal(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao()));
                copiasLocacao.add(copia);
                limparItemLocado();
                jtf_codigo_consulta_locacao.requestFocus();
            } else {
                System.out.println("Calcular promocao Simples semanal");
                System.out.println("Valor promoção: " + moeda.setPrecoFormat(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao())));
                DefaultTableModel row = (DefaultTableModel) jtbl_locacao.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(copia, copia.getObjeto().getTitulo());
                row.addRow(new Object[]{copia.getCodigo_barras(),
                    hashDbGrid, moeda.setPrecoFormat(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao())),
                    copia.getObjeto().getDiaria().getDias(), copia.getObjeto().getCensura(), diariaCombo.getPromocaoLocacao().getDescricao()});

                adicionarValorTotal(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao()));
                copiasLocacao.add(copia);
                limparItemLocado();
                jtf_codigo_consulta_locacao.requestFocus();

            }
        } else if (diariaCombo.getPromocaoLocacao().getQuarta() == true && quarta == true) {
            System.out.println("Descrição da Promoção: " + diariaCombo.getPromocaoLocacao().getDescricao());
            System.out.println("Hoje: " + quarta + " Dia Promocao: " + diariaCombo.getPromocaoLocacao().getQuarta());
            if (diariaCombo.getPromocaoLocacao().getGanhar_quantidade() > 0) {
                System.out.println("Calcular promocao Loca Ganha");
                diariaLocaGanha = calculaPromocaoLocaGanha(diariaCombo);
                DefaultTableModel row = (DefaultTableModel) jtbl_locacao.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(copia, copia.getObjeto().getTitulo());
                row.addRow(new Object[]{copia.getCodigo_barras(),
                    hashDbGrid, moeda.setPrecoFormat(String.valueOf(diariaLocaGanha.getPromocaoLocacao().getValor_promocao_locacao())),
                    copia.getObjeto().getDiaria().getDias(), copia.getObjeto().getCensura(), diariaLocaGanha.getPromocaoLocacao().getDescricao()});

                adicionarValorTotal(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao()));
                copiasLocacao.add(copia);
                limparItemLocado();
                jtf_codigo_consulta_locacao.requestFocus();
            } else {
                System.out.println("Calcular promocao Simples semanal");
                System.out.println("Valor promoção: " + moeda.setPrecoFormat(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao())));
                DefaultTableModel row = (DefaultTableModel) jtbl_locacao.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(copia, copia.getObjeto().getTitulo());
                row.addRow(new Object[]{copia.getCodigo_barras(),
                    hashDbGrid, moeda.setPrecoFormat(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao())),
                    copia.getObjeto().getDiaria().getDias(), copia.getObjeto().getCensura(), diariaCombo.getPromocaoLocacao().getDescricao()});

                adicionarValorTotal(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao()));
                copiasLocacao.add(copia);
                limparItemLocado();
                jtf_codigo_consulta_locacao.requestFocus();

            }
        } else if (diariaCombo.getPromocaoLocacao().getQuinta() == true && quinta == true) {
            System.out.println("Descrição da Promoção: " + diariaCombo.getPromocaoLocacao().getDescricao());
            System.out.println("Hoje: " + quinta + " Dia Promocao: " + diariaCombo.getPromocaoLocacao().getQuinta());
            if (diariaCombo.getPromocaoLocacao().getGanhar_quantidade() > 0) {
                System.out.println("Calcular promocao Loca Ganha");
                diariaLocaGanha = calculaPromocaoLocaGanha(diariaCombo);
                DefaultTableModel row = (DefaultTableModel) jtbl_locacao.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(copia, copia.getObjeto().getTitulo());
                row.addRow(new Object[]{copia.getCodigo_barras(),
                    hashDbGrid, moeda.setPrecoFormat(String.valueOf(diariaLocaGanha.getPromocaoLocacao().getValor_promocao_locacao())),
                    copia.getObjeto().getDiaria().getDias(), copia.getObjeto().getCensura(), diariaLocaGanha.getPromocaoLocacao().getDescricao()});

                adicionarValorTotal(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao()));
                copiasLocacao.add(copia);
                limparItemLocado();
                jtf_codigo_consulta_locacao.requestFocus();
            } else {
                System.out.println("Calcular promocao Simples semanal");
                System.out.println("Valor promoção: " + moeda.setPrecoFormat(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao())));
                DefaultTableModel row = (DefaultTableModel) jtbl_locacao.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(copia, copia.getObjeto().getTitulo());
                row.addRow(new Object[]{copia.getCodigo_barras(),
                    hashDbGrid, moeda.setPrecoFormat(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao())),
                    copia.getObjeto().getDiaria().getDias(), copia.getObjeto().getCensura(), diariaCombo.getPromocaoLocacao().getDescricao()});

                adicionarValorTotal(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao()));
                copiasLocacao.add(copia);
                limparItemLocado();
                jtf_codigo_consulta_locacao.requestFocus();

            }
        } else if (diariaCombo.getPromocaoLocacao().getSexta() == true && sexta == true) {
            System.out.println("Descrição da Promoção: " + diariaCombo.getPromocaoLocacao().getDescricao());
            System.out.println("Hoje: " + sexta + " Dia Promocao: " + diariaCombo.getPromocaoLocacao().getSexta());
            if (diariaCombo.getPromocaoLocacao().getGanhar_quantidade() > 0) {
                System.out.println("Calcular promocao Loca Ganha");
                diariaLocaGanha = calculaPromocaoLocaGanha(diariaCombo);
                DefaultTableModel row = (DefaultTableModel) jtbl_locacao.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(copia, copia.getObjeto().getTitulo());
                row.addRow(new Object[]{copia.getCodigo_barras(),
                    hashDbGrid, moeda.setPrecoFormat(String.valueOf(diariaLocaGanha.getPromocaoLocacao().getValor_promocao_locacao())),
                    copia.getObjeto().getDiaria().getDias(), copia.getObjeto().getCensura(), diariaLocaGanha.getPromocaoLocacao().getDescricao()});

                adicionarValorTotal(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao()));
                copiasLocacao.add(copia);
                limparItemLocado();
                jtf_codigo_consulta_locacao.requestFocus();
            } else {
                System.out.println("Calcular promocao Simples semanal");
                System.out.println("Valor promoção: " + moeda.setPrecoFormat(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao())));
                DefaultTableModel row = (DefaultTableModel) jtbl_locacao.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(copia, copia.getObjeto().getTitulo());
                row.addRow(new Object[]{copia.getCodigo_barras(),
                    hashDbGrid, moeda.setPrecoFormat(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao())),
                    copia.getObjeto().getDiaria().getDias(), copia.getObjeto().getCensura(), diariaCombo.getPromocaoLocacao().getDescricao()});

                adicionarValorTotal(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao()));
                copiasLocacao.add(copia);
                limparItemLocado();
                jtf_codigo_consulta_locacao.requestFocus();

            }
        } else if (diariaCombo.getPromocaoLocacao().getSabado() == true && sabado == true) {
            System.out.println("Descrição da Promoção: " + diariaCombo.getPromocaoLocacao().getDescricao());
            System.out.println("Hoje: " + sabado + " Dia Promocao: " + diariaCombo.getPromocaoLocacao().getSabado());
            if (diariaCombo.getPromocaoLocacao().getGanhar_quantidade() > 0) {
                System.out.println("Calcular promocao Loca Ganha");
                diariaLocaGanha = calculaPromocaoLocaGanha(diariaCombo);
                DefaultTableModel row = (DefaultTableModel) jtbl_locacao.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(copia, copia.getObjeto().getTitulo());
                row.addRow(new Object[]{copia.getCodigo_barras(),
                    hashDbGrid, moeda.setPrecoFormat(String.valueOf(diariaLocaGanha.getPromocaoLocacao().getValor_promocao_locacao())),
                    copia.getObjeto().getDiaria().getDias(), copia.getObjeto().getCensura(), diariaLocaGanha.getPromocaoLocacao().getDescricao()});

                adicionarValorTotal(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao()));
                copiasLocacao.add(copia);
                limparItemLocado();
                jtf_codigo_consulta_locacao.requestFocus();
            } else {
                System.out.println("Calcular promocao Simples semanal");
                System.out.println("Valor promoção: " + moeda.setPrecoFormat(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao())));
                DefaultTableModel row = (DefaultTableModel) jtbl_locacao.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(copia, copia.getObjeto().getTitulo());
                row.addRow(new Object[]{copia.getCodigo_barras(),
                    hashDbGrid, moeda.setPrecoFormat(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao())),
                    copia.getObjeto().getDiaria().getDias(), copia.getObjeto().getCensura(), diariaCombo.getPromocaoLocacao().getDescricao()});
                adicionarValorTotal(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao()));
                copiasLocacao.add(copia);
                limparItemLocado();
                jtf_codigo_consulta_locacao.requestFocus();

            }
        } else {
            JOptionPane.showMessageDialog(null, "Escolha outra Promoção");
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
        jtf_valor_locacao.setText("R$ 0,00");
        jtf_tipo_midia.setText("");
        jtf_diaria.setText("");
        jtf_codigo_consulta_locacao.setText("");
        jtf_nome_objeto_locacao.setText("");
        promocoes = null;
        jcb_promocao.removeAllItems();
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
            moeda = new Moeda();
            pool = new Pool();
            DiariaDAO diDAO = new DiariaDAO(pool);
            promocoes = new ArrayList<Diaria>();

            if (jcb_codigo_barras_locacao.isSelected() == true) {
                jtf_codigo_consulta_locacao.setText(copiaLocacao.getCodigo_barras());
            } else {
                jtf_codigo_consulta_locacao.setText(String.valueOf(copiaLocacao.getObjeto().getCodigo_objeto()));
            }

            jtf_nome_objeto_locacao.setText(copiaLocacao.getObjeto().getTitulo());
            jtf_diaria.setText(String.valueOf(copiaLocacao.getObjeto().getDiaria().getDias()));
            jtf_valor_locacao.setText(moeda.setPrecoFormat(String.valueOf(copiaLocacao.getObjeto().getDiaria().getValor())));
            jtf_tipo_midia.setText(copiaLocacao.getObjeto().getTipo_midia());

            promocoes = diDAO.getDiariaPromocao(copia.getObjeto().getDiaria());
            System.out.println("Quantidade de promoções para Diária: " + promocoes.size());
            System.out.println("Tamanho do inicial do combo antes de limpar: " + jcb_promocao.getItemCount());
            jcb_promocao.removeAllItems();
            System.out.println("Tamanho combo após limpar: " + jcb_promocao.getItemCount());

            for (int i = 0; i < promocoes.size(); i++) {

                ItemDbGrid hashDbGrid = new ItemDbGrid(promocoes.get(i), promocoes.get(i).getPromocaoLocacao().getDescricao());
                jcb_promocao.addItem(hashDbGrid);

                System.out.println("=================================================================");
                System.out.println("Código da promoção no ComboBox: " + promocoes.get(i).getPromocaoLocacao().getCodigo_promocao_locacao());
                System.out.println("Código da promoção no ComboBox: " + jcb_promocao.getItemAt(i));
                System.out.println("Nome da promoção no ComboBox: " + promocoes.get(i).getPromocaoLocacao().getDescricao());
                System.out.println("Valor da promoção no ComboBox: " + promocoes.get(i).getPromocaoLocacao().getValor_promocao_locacao());
                System.out.println("=================================================================");
            }

            Date d = new Date();
            Calendar c = new GregorianCalendar();
            c.setTime(d);
            Boolean domingo = false;
            Boolean segunda = false;
            Boolean terca = false;
            Boolean quarta = false;
            Boolean quinta = false;
            Boolean sexta = false;
            Boolean sabado = false;
            int dia = c.get(c.DAY_OF_WEEK);
            switch (dia) {
                case Calendar.SUNDAY:
                    domingo = true;
                    break;
                case Calendar.MONDAY:
                    segunda = true;
                    break;
                case Calendar.TUESDAY:
                    terca = true;
                    break;
                case Calendar.WEDNESDAY:
                    quarta = true;
                    break;
                case Calendar.THURSDAY:
                    quinta = true;
                    break;
                case Calendar.FRIDAY:
                    sexta = true;
                    break;
                case Calendar.SATURDAY:
                    sabado = true;
                    break;
            }

            for (int i = 0; i < jcb_promocao.getItemCount(); i++) {
                if (promocoes.get(i).getPromocaoLocacao().getDomingo() == true && domingo == true) {
                    jcb_promocao.setSelectedIndex(i);
                    break;
                } else if (promocoes.get(i).getPromocaoLocacao().getSegunda() == true && segunda == true) {
                    jcb_promocao.setSelectedIndex(i);
                    break;
                } else if (promocoes.get(i).getPromocaoLocacao().getTerca() == true && terca == true) {
                    jcb_promocao.setSelectedIndex(i);
                    break;
                } else if (promocoes.get(i).getPromocaoLocacao().getQuarta() == true && quarta == true) {
                    jcb_promocao.setSelectedIndex(i);
                    break;
                } else if (promocoes.get(i).getPromocaoLocacao().getQuinta() == true && quinta == true) {
                    jcb_promocao.setSelectedIndex(i);
                    break;
                } else if (promocoes.get(i).getPromocaoLocacao().getSexta() == true && sexta == true) {
                    jcb_promocao.setSelectedIndex(i);
                    break;
                } else if (promocoes.get(i).getPromocaoLocacao().getSabado() == true && sabado == true) {
                    jcb_promocao.setSelectedIndex(i);
                    break;
                }
            }
            jcb_promocao.requestFocus();

        }
    }

    public void carregarClienteDependente(Dependente dependente) {
        if (dependente != null) {
            AtendimentoLocacao.dependente = dependente;
            jtf_debito_total_locacao.setText("R$ 0,00");

            jtf_nome_cliente.setText(dependente.getNome_dependente());
            setTitle("Atendimento Locação - " + dependente.getNome_dependente());
            jtf_codigo_cliente.setText(String.valueOf(dependente.getCliente().getCodigo_cliente()));
            Moeda moeda = new Moeda();

            pool = new Pool();
            DependenteDAO dependenteDAO = new DependenteDAO(pool);

            lancamento = new Lancamento();
            lancamento = dependenteDAO.getClienteDependente(dependente.getCliente().getCodigo_cliente());
            if (lancamento.getSaldo() < 0) {
                lancamento.setSaldo(lancamento.getSaldo() * (-1));
                jtf_debito_total_locacao.setText(moeda.setPrecoFormat(String.valueOf(lancamento.getSaldo())));
                jtf_debito_total_locacao.setForeground(Color.black);
                jl_debito_locacao.setText("Saldo:");
                jtf_codigo_consulta_locacao.setEnabled(true);
            } else if (lancamento.getSaldo() > 0) {
                jtf_debito_total_locacao.setText(moeda.setPrecoFormat(String.valueOf(lancamento.getSaldo())));
                jtf_debito_total_locacao.setForeground(Color.red);
                jl_debito_locacao.setText("Devedor:");
                verificarDebito(dependente.getCliente());
            } else {
                jtf_debito_total_locacao.setText("R$ 0,00");
                jtf_debito_total_locacao.setForeground(Color.black);
                jl_debito_locacao.setText("Saldo:");
                jtf_codigo_consulta_locacao.setEnabled(true);
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

    public void verificarDebito(Cliente cliente) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        pool = new Pool();
        LancamentoDAO lancDAO = new LancamentoDAO(pool);

        Lancamento lancamento = lancDAO.getDebito(cliente);

        if (lancamento != null) {

            Calendar data_inicial = Calendar.getInstance();
            data_inicial.setTime(lancamento.getData_lancamento());
            data_inicial.set(Calendar.HOUR_OF_DAY, 0);
            data_inicial.set(Calendar.MINUTE, 0);
            data_inicial.set(Calendar.SECOND, 0);
            data_inicial.set(Calendar.MILLISECOND, 0);
            data_inicial.getTime();

            Calendar data_final = Calendar.getInstance();
            data_final.set(Calendar.HOUR_OF_DAY, 0);
            data_final.set(Calendar.MINUTE, 0);
            data_final.set(Calendar.SECOND, 0);
            data_final.set(Calendar.MILLISECOND, 0);
            data_final.getTime();

            long intervalo = data_final.getTimeInMillis() - data_inicial.getTimeInMillis();
            int duracaoDebito = (int) (intervalo / (1000 * 60 * 60 * 24 * 30)); // resultado em meses 
            System.out.println("Calculo de dias em Debito:" + duracaoDebito);

            if (duracaoDebito > 3) {
                JOptionPane.showMessageDialog(null, "Cliente com débito desde: " + df.format(lancamento.getData_lancamento()));
                jtf_codigo_consulta_locacao.setEnabled(false);
            } else {
                jtf_codigo_consulta_locacao.setEnabled(true);
            }
        }
    }

    public void locar_consulta_codigo_barras(String codigo_barras) {

        try {
            pool = new Pool();
            copias = null;
            CopiaDAO copiaDAO = new CopiaDAO(pool);

            if (copiaDAO.getCopia_existente(codigo_barras) == true) {

                copias = copiaDAO.getCopia_codigo_barras(codigo_barras);

                if (copias.size() > 0) {
                    if (checkCensura(copias.get(0).getObjeto().getCensura(), dependente.getData_nascimento()) == true) {
                        carregarCopiaLocacao(copias.get(0));
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
                System.out.println("Linhas:" + i + " Size: " + copias.size());
                for (int x = 0; x < copias.size();) {

                    Copia copiaVerificarTabela = new Copia();

                    copiaVerificarTabela.setCodigo_barras((String) jtbl_locacao.getValueAt(i, 0));

                    tabela = copiaVerificarTabela.getCodigo_barras().equals(copias.get(x).getCodigo_barras());

                    System.out.println(copias.get(x).getCodigo_barras() + " " + tabela + " Posição: " + x);
                    if (tabela == false) {
                        codigo_barras = copias.get(x).getCodigo_barras();
                        break;
                    } else {
                        System.out.println("Passou pela posição: " + x);
                        copias.remove(x);
                        x = 0;
                        continue;
                    }
                }
                System.out.println("Linhas:" + i + " Size: " + copias.size());
            }

        }

        return codigo_barras;
    }

    public void acionarAtalho(java.awt.event.KeyEvent evt) {

        if (evt.getKeyCode() == KeyEvent.VK_F10) {
            jb_finalizar.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            setVisible(false);
            janelapai.setStatusTela(true);

        }
    }

    public Diaria calculaPromocaoLocaGanha(Diaria diaria) {
        pool = new Pool();
        List<Diaria> dias = new ArrayList<Diaria>();
        DiariaDAO diaDAO = new DiariaDAO(pool);
        diaDAO = new DiariaDAO(pool);
        dias = diaDAO.getTodasDiarias();

        for (int i = 0; i < AtendimentoLocacao.jtbl_locacao.getRowCount(); i++) {
            System.out.println("Inciar Verificação: " + copiasLocacao.get(i).getObjeto().getTitulo());
            System.out.println("CODIGO DIARIA - DIARIA: " + diaria.getCodigo_diaria() + " CODIGO DIARIA - COPIA: " + AtendimentoLocacao.copiasLocacao.get(i).getObjeto().getDiaria().getCodigo_diaria());
            if (diaria.getCodigo_diaria() == copiasLocacao.get(i).getObjeto().getDiaria().getCodigo_diaria()) {
                if (!jtbl_locacao.getValueAt(i, 2).equals("R$ 0,00")) {
                    diaria.setQuantidade_filme(diaria.getQuantidade_filme() + 1);
                    System.out.println("Quantidade de filme: " + diaria.getQuantidade_filme());
                }
            }
        }

        System.out.println("Locar quantidade: " + diaria.getPromocaoLocacao().getLocar_quantidade());
        System.out.println("Ganhar quantidade: " + diaria.getPromocaoLocacao().getGanhar_quantidade());

        if (diaria.getQuantidade_filme() >= diaria.getPromocaoLocacao().getLocar_quantidade()) {
            int ganhar;
            ganhar = (diaria.getQuantidade_filme() / diaria.getPromocaoLocacao().getLocar_quantidade());
            System.out.println("Ganhar: " + ganhar);
            ganhar = ganhar * diaria.getPromocaoLocacao().getGanhar_quantidade();
            System.out.println("Ganhar: " + ganhar);
            if (ganhar > 0) {
                int ganhados = 0;
                for (int i = 0; i < jtbl_locacao.getRowCount(); i++) {
                    if (jtbl_locacao.getValueAt(i, 2).equals("R$ 0,00")) {
                        ganhados = ganhados + 1;
                    }
                }
                System.out.println("Ganhados: " + ganhados);
                promocao = new PromocaoLocacao();
                if (ganhar > ganhados) {
                    promocao.setValor_promocao_locacao(0.0);
                    promocao.setDescricao(diaria.getPromocaoLocacao().getDescricao());
                    diaria.setPromocaoLocacao(promocao);

                } else {
                    promocao.setValor_promocao_locacao(diaria.getPromocaoLocacao().getValor_promocao_locacao());
                    promocao.setDescricao(diaria.getPromocaoLocacao().getDescricao());
                    diaria.setPromocaoLocacao(promocao);

                }
            }
        }
        return diaria;
    }

}
