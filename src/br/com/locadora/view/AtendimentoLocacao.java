package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.bean.Lancamento;
import br.com.locadora.model.bean.Objeto;
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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AtendimentoLocacao extends javax.swing.JFrame {

    public Dependente dependente;
    public List<Copia> copias;
    public List<Copia> copiasLocacao;
    public Copia copiaAtendimento;
    public InterfacePool pool;
    public TelaPrincipal janelapai;
    public Moeda moeda;
    public Lancamento lancamento;
    public AcessoUsuario acesso;
    public List<Diaria> promocoes;
    public Diaria diariaCombo;
    public PromocaoLocacao promocao;
    public DiariaDAO diariaDAO;

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
                .addContainerGap(10, Short.MAX_VALUE))
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
        jb_adicionar_locacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_adicionar_locacaoMouseClicked(evt);
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
        jcb_promocao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcb_promocaoKeyPressed(evt);
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
                .addGap(10, 10, 10))
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
                .addGap(100, 100, 100)
                .addComponent(jb_finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jb_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
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
                .addGap(20, 20, 20)
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
                                .addComponent(jtf_valor_total_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jp_locacao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(747, 747, 747)
                        .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_valor_total_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
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
            abrirCaixa();
        }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
    }//GEN-LAST:event_formKeyReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ((DefaultTableModel) jtbl_locacao.getModel()).setRowCount(0);
        jtbl_locacao.updateUI();
        retornaJanelaPai();
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
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            consultarObjeto();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            consultarCliente();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_codigo_consulta_locacaoKeyPressed

    private void jb_adicionar_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_adicionar_locacaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                if (jcb_codigo_barras_locacao.isSelected() == true) {

//                    if (consultarCodigoDeBarras(jtf_codigo_consulta_locacao.getText().trim()) == true) {
                        if (copiaAtendimento != null) {                            
                            adicionarItemLocado(copiaAtendimento);
                        }
//                    }
                } else {
                    locar_consulta_codigo_objeto(Integer.parseInt(jtf_codigo_consulta_locacao.getText().trim()));
                    if (copiaAtendimento != null) {
                        adicionarItemLocado(copiaAtendimento);
                    }
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Código do Objeto deve ser número");
            }
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
        retornaJanelaPai();
    }//GEN-LAST:event_jb_cancelarActionPerformed

    private void jb_finalizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_finalizarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            abrirCaixa();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_finalizarKeyPressed

    private void jcb_codigo_barras_locacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_codigo_barras_locacaoActionPerformed
        if(jcb_codigo_barras_locacao.isSelected() == true){
            jl_codigo_locacao.setText("Código de Barras");              
        } else {
            jl_codigo_locacao.setText("Código do Objeto");
        }
            jtf_codigo_consulta_locacao.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_codigo_barras_locacaoActionPerformed

    private void jcb_promocaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcb_promocaoKeyPressed

        try {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                jb_adicionar_locacao.requestFocus();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_promocaoKeyPressed

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

    private void jb_finalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_finalizarMouseClicked
        if (evt.getClickCount() == 1) {
            abrirCaixa();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_finalizarMouseClicked

    private void jb_adicionar_locacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_adicionar_locacaoMouseClicked
        if (evt.getClickCount() == 1) {
            try {
                if (jcb_codigo_barras_locacao.isSelected() == true) {

                    if (consultarCodigoDeBarras(jtf_codigo_consulta_locacao.getText().trim()) == true) {
                        if (copiaAtendimento != null) {
                            adicionarItemLocado(copiaAtendimento);
                        }
                    }
                } else {
                    locar_consulta_codigo_objeto(Integer.parseInt(jtf_codigo_consulta_locacao.getText().trim()));
                    if (copiaAtendimento != null) {
                        adicionarItemLocado(copiaAtendimento);
                    }
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Código do Objeto deve ser número");
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_adicionar_locacaoMouseClicked

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

    public void consultarObjeto() {
        try {
            if (!jtf_codigo_cliente.getText().equals("")) {
                if (jcb_codigo_barras_locacao.isSelected() == true) {
                    consultarCodigoDeBarras(jtf_codigo_consulta_locacao.getText().trim());
                } else {
                    locar_consulta_codigo_objeto(Integer.parseInt(jtf_codigo_consulta_locacao.getText().trim()));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Informe primeiro um Cliente");
                jtf_codigo_cliente.requestFocus();
            }

        } catch (Exception e) {            
            JOptionPane.showMessageDialog(null, "Consulta por Código do Objeto inválida.");
        }
    }

    public void consultarCliente() {
        ConsultaCopiaLocacao copiaCliente = new ConsultaCopiaLocacao();
        copiaCliente.janelapai = this;
        copiaCliente.setVisible(true);
        setStatusTela(false);
    }

    private void abrirCaixa() {
        if (verificarCampos() == true) {
            if (jtbl_locacao.getRowCount() > 0) {
                EntradaCaixaLocacao entradaCaixa;
                entradaCaixa = new EntradaCaixaLocacao();
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
                    for (int i = 0; i < copiasLocacao.size(); i++) {
                        System.out.println("Antes de deletar: " + copiasLocacao.get(i).getCodigo_barras());
                    }

                    int index_remove = tb.getSelectedRow();
                    System.out.println("Linha deletada: " + index_remove);
                    row.removeRow(tb.getSelectedRow());
                    copiasLocacao.remove(index_remove);

                    for (int i = 0; i < copiasLocacao.size(); i++) {
                        System.out.println("Depois de deletar: " + copiasLocacao.get(i).getCodigo_barras());
                    }
                    dobleCheckPromocao();
                    recalcularValorTotal();
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
        this.copiaAtendimento = copia;
        if (verificarItemLocacao() == true) {
            if (verificaTabela(copiaAtendimento) == false) {
            jcb_promocao.setSelectedItem(jcb_promocao.getSelectedIndex());
            ItemDbGrid hashDbGrid1 = (ItemDbGrid) jcb_promocao.getSelectedItem();
            diariaCombo = (Diaria) hashDbGrid1.getObjeto();  
                
                //Consulta se foi assistido anteriormente e avisa ao Cliente
                pool = new Pool();
                CopiaDAO copiaDAO = new CopiaDAO(pool);
                String assistido_anteriormente;
                assistido_anteriormente = copiaDAO.getQuantidadeAssistida(dependente.getCodigo_dependente(), copiaAtendimento.getCodigo_barras());
                if (!"".equals(assistido_anteriormente)) {
                    int selectedOption = JOptionPane.showConfirmDialog(this, assistido_anteriormente, "Atenção", JOptionPane.YES_NO_OPTION);
                    if (selectedOption == JOptionPane.YES_NO_OPTION) {
                        //Caso o cliente queira relocar 
                        adicionaItemTabela(copiaAtendimento, diariaCombo);

                    } else {
                        limparItemLocado();
                        jtf_codigo_consulta_locacao.requestFocus();
                    }
                } else {
                    //Locar sem confirmacao
                    adicionaItemTabela(copiaAtendimento, diariaCombo);

                }
            } else {
                JOptionPane.showMessageDialog(null, "Última cópia disponível já foi adicionada: " + copiaAtendimento.getCodigo_barras());
                jtf_codigo_consulta_locacao.requestFocus();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel adicionar ");
        }
    }

    public void alimentarTabelaCopia(Copia copia) {
        this.copiaAtendimento = copia;
        if(copiaAtendimento != null){
            DefaultTableModel row = (DefaultTableModel) jtbl_locacao.getModel();
            ItemDbGrid hashDbGrid = new ItemDbGrid(copiaAtendimento, copiaAtendimento.getObjeto().getTitulo());
            row.addRow(new Object[]{copiaAtendimento.getCodigo_barras(),
                hashDbGrid, moeda.setPrecoFormat(String.valueOf(copiaAtendimento.getObjeto().getDiaria().getPromocaoLocacao().getValor_promocao_locacao())),
                copiaAtendimento.getObjeto().getDiaria().getDias(), copiaAtendimento.getObjeto().getCensura(), copiaAtendimento.getObjeto().getDiaria().getPromocaoLocacao().getDescricao()});

            copiasLocacao.add(copia);
                        limparItemLocado();
                        jtf_codigo_consulta_locacao.requestFocus();
        }
    }

    public void adicionaItemTabela(Copia copia, Diaria diariaCombo) {
        this.copiaAtendimento = copia;
        Date d = new Date();
        Calendar c = new GregorianCalendar();
        c.setTime(d);
        int dia = c.get(c.DAY_OF_WEEK);

        System.out.println("Dia da Semana: " + dia);                                                                      
        
        try {

            System.out.println("====================Inciar Verificação para Diária: " + diariaCombo.getCodigo_diaria());
            System.out.println("Tamanho da tabela: " + jtbl_locacao.getRowCount());
            System.out.println("Tamanho da lista de Copias Locacao: " + copiasLocacao.size());
            System.out.println("Hoje: " + dia + " Dia Promocao: " + diariaCombo.getPromocaoLocacao().getDomingo());
            System.out.println("Hoje: " + dia + " Dia Promocao: " + diariaCombo.getPromocaoLocacao().getSegunda());
            System.out.println("Hoje: " + dia + " Dia Promocao: " + diariaCombo.getPromocaoLocacao().getTerca());
            System.out.println("Hoje: " + dia + " Dia Promocao: " + diariaCombo.getPromocaoLocacao().getQuarta());
            System.out.println("Hoje: " + dia + " Dia Promocao: " + diariaCombo.getPromocaoLocacao().getQuinta());
            System.out.println("Hoje: " + dia + " Dia Promocao: " + diariaCombo.getPromocaoLocacao().getSexta());
            System.out.println("Hoje: " + dia + " Dia Promocao: " + diariaCombo.getPromocaoLocacao().getSabado());

            if (diariaCombo.getPromocaoLocacao().getDomingo() == true && dia == 1) {
                System.out.println("Descrição da Promoção: " + diariaCombo.getPromocaoLocacao().getDescricao());
                if (diariaCombo.getPromocaoLocacao().getGanhar_quantidade() > 0) {
                    System.out.println("Calcular promocao Loca Ganha");
                    //Calcula quantos são necessários levar para ganhar X                       
                    copia.getObjeto().setDiaria(calculaPromocaoLocaGanha(diariaCombo));
                    //Inserir dados na tabela
                    alimentarTabelaCopia(copiaAtendimento);                    
                } else {
                    System.out.println("Calcular promocao Simples semanal");
                    System.out.println("Valor promoção: " + moeda.setPrecoFormat(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao())));
                    //Inserir a promocao do combo no objeto
                    copia.getObjeto().setDiaria(diariaCombo);
                    //Inserir dados na tabela
                    alimentarTabelaCopia(copiaAtendimento);
                }
            } else if (diariaCombo.getPromocaoLocacao().getSegunda() == true && dia == 2) {
                System.out.println("Descrição da Promoção: " + diariaCombo.getPromocaoLocacao().getDescricao());
                if (diariaCombo.getPromocaoLocacao().getGanhar_quantidade() > 0) {
                    System.out.println("Calcular promocao Loca Ganha");
                    //Calcula quantos são necessários levar para ganhar X                       
                    copia.getObjeto().setDiaria(calculaPromocaoLocaGanha(diariaCombo));
                    //Inserir dados na tabela
                    alimentarTabelaCopia(copiaAtendimento);                    
                } else {
                    System.out.println("Calcular promocao Simples semanal");
                    System.out.println("Valor promoção: " + moeda.setPrecoFormat(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao())));
                    //Inserir a promocao do combo no objeto
                    copia.getObjeto().setDiaria(diariaCombo);
                    //Inserir dados na tabela
                    alimentarTabelaCopia(copiaAtendimento);
                }
            } else if (diariaCombo.getPromocaoLocacao().getTerca() == true && dia == 3) {
                System.out.println("Descrição da Promoção: " + diariaCombo.getPromocaoLocacao().getDescricao());
                if (diariaCombo.getPromocaoLocacao().getGanhar_quantidade() > 0) {
                    System.out.println("Calcular promocao Loca Ganha");
                    //Calcula quantos são necessários levar para ganhar X                       
                    copia.getObjeto().setDiaria(calculaPromocaoLocaGanha(diariaCombo));
                    //Inserir dados na tabela
                    alimentarTabelaCopia(copiaAtendimento);                    
                } else {
                    System.out.println("Calcular promocao Simples semanal");
                    System.out.println("Valor promoção: " + moeda.setPrecoFormat(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao())));
                    //Inserir a promocao do combo no objeto
                    copia.getObjeto().setDiaria(diariaCombo);
                    //Inserir dados na tabela
                    alimentarTabelaCopia(copiaAtendimento);
                }
            } else if (diariaCombo.getPromocaoLocacao().getQuarta() == true && dia == 4) {
                System.out.println("Descrição da Promoção: " + diariaCombo.getPromocaoLocacao().getDescricao());
                if (diariaCombo.getPromocaoLocacao().getGanhar_quantidade() > 0) {
                    System.out.println("Calcular promocao Loca Ganha");
                    //Calcula quantos são necessários levar para ganhar X                       
                    copia.getObjeto().setDiaria(calculaPromocaoLocaGanha(diariaCombo));
                    //Inserir dados na tabela
                    alimentarTabelaCopia(copiaAtendimento);                    
                } else {
                    System.out.println("Calcular promocao Simples semanal");
                    System.out.println("Valor promoção: " + moeda.setPrecoFormat(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao())));
                    //Inserir a promocao do combo no objeto
                    copia.getObjeto().setDiaria(diariaCombo);
                    //Inserir dados na tabela
                    alimentarTabelaCopia(copiaAtendimento);
                }
            } else if (diariaCombo.getPromocaoLocacao().getQuinta() == true && dia == 5) {
                System.out.println("Descrição da Promoção: " + diariaCombo.getPromocaoLocacao().getDescricao());
                if (diariaCombo.getPromocaoLocacao().getGanhar_quantidade() > 0) {
                    System.out.println("Calcular promocao Loca Ganha");
                    //Calcula quantos são necessários levar para ganhar X                       
                    copia.getObjeto().setDiaria(calculaPromocaoLocaGanha(diariaCombo));
                    //Inserir dados na tabela
                    alimentarTabelaCopia(copiaAtendimento);                    
                } else {
                    System.out.println("Calcular promocao Simples semanal");
                    System.out.println("Valor promoção: " + moeda.setPrecoFormat(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao())));
                    //Inserir a promocao do combo no objeto
                    copia.getObjeto().setDiaria(diariaCombo);
                    //Inserir dados na tabela
                    alimentarTabelaCopia(copiaAtendimento);
                }
            } else if (diariaCombo.getPromocaoLocacao().getSexta() == true && dia == 6) {
                System.out.println("Descrição da Promoção: " + diariaCombo.getPromocaoLocacao().getDescricao());
                if (diariaCombo.getPromocaoLocacao().getGanhar_quantidade() > 0) {
                    System.out.println("Calcular promocao Loca Ganha");
                    //Calcula quantos são necessários levar para ganhar X                       
                    copia.getObjeto().setDiaria(calculaPromocaoLocaGanha(diariaCombo));
                    //Inserir dados na tabela
                    alimentarTabelaCopia(copiaAtendimento);                    
                } else {
                    System.out.println("Calcular promocao Simples semanal");
                    System.out.println("Valor promoção: " + moeda.setPrecoFormat(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao())));
                    //Inserir a promocao do combo no objeto
                    copia.getObjeto().setDiaria(diariaCombo);
                    //Inserir dados na tabela
                    alimentarTabelaCopia(copiaAtendimento);
                }
            } else if (diariaCombo.getPromocaoLocacao().getSabado() == true && dia == 7) {
                System.out.println("Descrição da Promoção: " + diariaCombo.getPromocaoLocacao().getDescricao());
                if (diariaCombo.getPromocaoLocacao().getGanhar_quantidade() > 0) {
                    System.out.println("Calcular promocao Loca Ganha");
                    //Calcula quantos são necessários levar para ganhar X                       
                    copia.getObjeto().setDiaria(calculaPromocaoLocaGanha(diariaCombo));
                    //Inserir dados na tabela
                    alimentarTabelaCopia(copiaAtendimento);                    
                } else {
                    System.out.println("Calcular promocao Simples semanal");
                    System.out.println("Valor promoção: " + moeda.setPrecoFormat(String.valueOf(diariaCombo.getPromocaoLocacao().getValor_promocao_locacao())));
                    //Inserir a promocao do combo no objeto
                    copia.getObjeto().setDiaria(diariaCombo);
                    //Inserir dados na tabela
                    alimentarTabelaCopia(copiaAtendimento);
                }
            } else {                
                
                System.out.println("Sem promoção existente para o dia");
                System.out.println("Valor normal: " + moeda.setPrecoFormat(String.valueOf(copiaAtendimento.getObjeto().getDiaria().getValor())));
                //Alimentar a tabela
                
                PromocaoLocacao semPromocao = new PromocaoLocacao();
                semPromocao.setCodigo_promocao_locacao(0);
                
                Diaria diariaSemPromocao = copiaAtendimento.getObjeto().getDiaria();
                diariaSemPromocao.setPromocaoLocacao(semPromocao);
                Objeto objetoSemPromocao = copiaAtendimento.getObjeto();
                objetoSemPromocao.setDiaria(diariaSemPromocao);
                
                copiaAtendimento.setObjeto(objetoSemPromocao);
                
                DefaultTableModel row = (DefaultTableModel) jtbl_locacao.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(copiaAtendimento, copiaAtendimento.getObjeto().getTitulo());
                row.addRow(new Object[]{copiaAtendimento.getCodigo_barras(),
                    hashDbGrid, moeda.setPrecoFormat(String.valueOf(copiaAtendimento.getObjeto().getDiaria().getValor())),
                    copiaAtendimento.getObjeto().getDiaria().getDias(), copiaAtendimento.getObjeto().getCensura()});

                copiasLocacao.add(copia);
                limparItemLocado();
                jtf_codigo_consulta_locacao.requestFocus();
            }
            recalcularValorTotal();
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Sem promoção existente para o dia");
                System.out.println("Valor normal: " + moeda.setPrecoFormat(String.valueOf(copiaAtendimento.getObjeto().getDiaria().getValor())));
                //Alimentar a tabela
                
                PromocaoLocacao semPromocao = new PromocaoLocacao();
                semPromocao.setCodigo_promocao_locacao(0);
                
                Diaria diariaSemPromocao = copiaAtendimento.getObjeto().getDiaria();
                diariaSemPromocao.setPromocaoLocacao(semPromocao);
                Objeto objetoSemPromocao = copiaAtendimento.getObjeto();
                objetoSemPromocao.setDiaria(diariaSemPromocao);
                
                copiaAtendimento.setObjeto(objetoSemPromocao);
                
                DefaultTableModel row = (DefaultTableModel) jtbl_locacao.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(copiaAtendimento, copiaAtendimento.getObjeto().getTitulo());
                row.addRow(new Object[]{copiaAtendimento.getCodigo_barras(),
                    hashDbGrid, moeda.setPrecoFormat(String.valueOf(copiaAtendimento.getObjeto().getDiaria().getValor())),
                    copiaAtendimento.getObjeto().getDiaria().getDias(), copiaAtendimento.getObjeto().getCensura()});

                copiasLocacao.add(copia);
                limparItemLocado();
                jtf_codigo_consulta_locacao.requestFocus();
                recalcularValorTotal();
        }
    }

    public void recalcularValorTotal() {

        moeda = new Moeda();
        Double valor_total = 0.00;
        for (int i = 0; i < jtbl_locacao.getRowCount(); i++) {
            Double valor_adicionar = moeda.getPrecoFormato(jtbl_locacao.getValueAt(i, 2).toString());
            valor_total = valor_total + valor_adicionar;
        }
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
            this.copiaAtendimento = copia;
            moeda = new Moeda();

            pool = new Pool();
            diariaDAO = new DiariaDAO(pool);
//            promocoes = new ArrayList<Diaria>();
            if (jcb_codigo_barras_locacao.isSelected() == true) {
                jtf_codigo_consulta_locacao.setText(copia.getCodigo_barras());
            } else {
                jtf_codigo_consulta_locacao.setText(copia.getObjeto().getCodigo_objeto().toString());
            }

            jtf_nome_objeto_locacao.setText(copia.getObjeto().getTitulo());
            jtf_diaria.setText(String.valueOf(copia.getObjeto().getDiaria().getDias()));
            jtf_valor_locacao.setText(moeda.setPrecoFormat(String.valueOf(copia.getObjeto().getDiaria().getValor())));
            jtf_tipo_midia.setText(copia.getObjeto().getTipo_midia());

            promocoes = diariaDAO.getDiariaPromocao(copia.getObjeto().getDiaria());

            System.out.println("Quantidade de promoções para Diária: " + promocoes.size());
            System.out.println("Tamanho do inicial do combo antes de limpar: " + jcb_promocao.getItemCount());

            jcb_promocao.removeAllItems();

            System.out.println("Tamanho combo após limpar: " + jcb_promocao.getItemCount());

            if (promocoes.size() > 0) {
                for (int i = 0; i < promocoes.size(); i++) {

                    ItemDbGrid hashDbGrid = new ItemDbGrid(promocoes.get(i), promocoes.get(i).getPromocaoLocacao().getDescricao());
                    jcb_promocao.addItem(hashDbGrid);

                    System.out.println("=================================================================");
                    System.out.println("Código da promoção no ComboBox: " + promocoes.get(i).getPromocaoLocacao().getCodigo_promocao_locacao());                    
                    System.out.println("Nome da promoção no ComboBox: " + promocoes.get(i).getPromocaoLocacao().getDescricao());
                    System.out.println("Valor da promoção no ComboBox: " + promocoes.get(i).getPromocaoLocacao().getValor_promocao_locacao());
                    System.out.println("=================================================================");
                }                
            } else {
                Diaria diaria = new Diaria();
                ItemDbGrid hashDbGrid = new ItemDbGrid(diaria, "Sem promoção");
                jcb_promocao.addItem(hashDbGrid);
            }

            Date d = new Date();
            Calendar c = new GregorianCalendar();
            c.setTime(d);            
            int dia = c.get(c.DAY_OF_WEEK);
            
            if (promocoes.size() > 0) {
                for (int i = 0; i < jcb_promocao.getItemCount(); i++) {
                    if (promocoes.get(i).getPromocaoLocacao().getDomingo() == true && dia == 1) {
                        jcb_promocao.setSelectedIndex(i);
                        break;
                    } else if (promocoes.get(i).getPromocaoLocacao().getSegunda() == true && dia == 2) {
                        jcb_promocao.setSelectedIndex(i);
                        break;
                    } else if (promocoes.get(i).getPromocaoLocacao().getTerca() == true && dia == 3) {
                        jcb_promocao.setSelectedIndex(i);
                        break;
                    } else if (promocoes.get(i).getPromocaoLocacao().getQuarta() == true && dia == 4) {
                        jcb_promocao.setSelectedIndex(i);
                        break;
                    } else if (promocoes.get(i).getPromocaoLocacao().getQuinta() == true && dia == 5) {
                        jcb_promocao.setSelectedIndex(i);
                        break;
                    } else if (promocoes.get(i).getPromocaoLocacao().getSexta() == true && dia == 6) {
                        jcb_promocao.setSelectedIndex(i);
                        break;
                    } else if (promocoes.get(i).getPromocaoLocacao().getSabado() == true && dia == 7) {
                        jcb_promocao.setSelectedIndex(i);
                        break;
                    }
                }
            }
            jb_adicionar_locacao.requestFocus();
        }
    }

    public void carregarClienteDependente(Dependente dependente) {
        if (dependente != null) {
            copiasLocacao = new ArrayList<>();
            this.dependente = dependente;
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

        lancamento = lancDAO.getDebito(cliente);

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

    public boolean consultarCodigoDeBarras(String codigo_barras) {
        boolean retorno = false;
        try {
            pool = new Pool();
            copias = null;
            CopiaDAO copiaDAO = new CopiaDAO(pool);
            //Checar se a cópia existe
            if (copiaDAO.getCopia_existente(codigo_barras) == true) {

                copias = copiaDAO.getCopia_codigo_barras(codigo_barras);
                //Checar se a cópia esta disponivel
                if (copias.get(0).getStatus().equals("Disponível")) {
                    //Checar a censura para o filme dizendo inapropriado para idade
                    if (checkCensura(copias.get(0).getObjeto().getCensura(), dependente.getData_nascimento()) == true) {
                        //Carregar as copias e os campos com as informações
                        carregarCopiaLocacao(copias.get(0));
                        retorno = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Filme inapropriado para este Cliente");
                        retorno = false;
                    }
                } else {
                    SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
                    String data_prevista = "";
                    try {
                        if (copias.get(0).getData_prevista() != null) {
                            data_prevista = out.format(in.parse(copias.get(0).getData_prevista().toString()));
                        }
                    } catch (ParseException ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    JOptionPane.showMessageDialog(null, "Cópia indisponivel no momento. Devolução prevista para " + data_prevista);
                    retorno = false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Código de Barra inválido e/ou não cadastrado");
                retorno = false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AtendimentoLocacao.class.getName()).log(Level.SEVERE, null, ex);
            return retorno = false;
        }
        return retorno;
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
                            consultarCodigoDeBarras(codigo_barras);
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
            abrirCaixa();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            retornaJanelaPai();
        }
    }

    private void retornaJanelaPai() {
        setVisible(false);
        if (janelapai != null) {
            janelapai.setStatusTela(true);
        }
    }

    public Diaria calculaPromocaoLocaGanha(Diaria diaria) {

        for (int i = 0; i < jtbl_locacao.getRowCount(); i++) {
            System.out.println("Iniciar Verificação: " + copiasLocacao.get(i).getObjeto().getTitulo());
            System.out.println("Código Diária - Diária: " + diaria.getCodigo_diaria() + " Código Diária - Cópia: " + copiasLocacao.get(i).getObjeto().getDiaria().getCodigo_diaria());
            System.out.println("Posição: " + i + " Locar: " + copiasLocacao.get(i).getObjeto().getDiaria().getPromocaoLocacao().getLocar_quantidade());
            System.out.println("Posição: " + i + " Ganhar: " + copiasLocacao.get(i).getObjeto().getDiaria().getPromocaoLocacao().getGanhar_quantidade());

            if (diaria.getPromocaoLocacao().getCodigo_promocao_locacao().equals(copiasLocacao.get(i).getObjeto().getDiaria().getPromocaoLocacao().getCodigo_promocao_locacao())) {
                if (!jtbl_locacao.getValueAt(i, 2).equals("R$ 0,00")) {
                    diaria.setQuantidade_filme(diaria.getQuantidade_filme() + 1);
                    System.out.println("Quantidade de filme inseridos: " + diaria.getQuantidade_filme());
                }
                if (jtbl_locacao.getValueAt(i, 2).equals("R$ 0,00")) {
                    diaria.setGanhados(diaria.getGanhados() + 1);
                    System.out.println("Quantidade de filme ganhados: " + diaria.getGanhados());
                }
            }
            
        }

        System.out.println("Locar quantidade: " + diaria.getPromocaoLocacao().getLocar_quantidade());
        System.out.println("Ganhar quantidade: " + diaria.getPromocaoLocacao().getGanhar_quantidade());

        if (diaria.getQuantidade_filme() >= diaria.getPromocaoLocacao().getLocar_quantidade()) {
            int ganhar;
            ganhar = (diaria.getQuantidade_filme() / diaria.getPromocaoLocacao().getLocar_quantidade());
            System.out.println("Ganhar: " + ganhar);
//            ganhar = ganhar * diaria.getPromocaoLocacao().getGanhar_quantidade();
//            System.out.println("Ganhar: " + ganhar);
            if (ganhar > 0) {
                int ganhados = 0;
//                for (int i = 0; i < jtbl_locacao.getRowCount(); i++) {
//                    if (jtbl_locacao.getValueAt(i, 2).equals("R$ 0,00")) {
//                        ganhados = ganhados + 1;
//                    }
//                }
                System.out.println("Ganhados: " + ganhados);
                promocao = new PromocaoLocacao();
                if (ganhar > diaria.getGanhados()) {
                    diaria.getPromocaoLocacao().setValor_promocao_locacao(0.0);
                } else {
                    int resultado = ganhados - ganhar;
                    while (resultado > 0) {
                        for (int i = 0; i < jtbl_locacao.getRowCount(); i++) {
                            if (diaria.getPromocaoLocacao().getCodigo_promocao_locacao() == copiasLocacao.get(i).getObjeto().getDiaria().getPromocaoLocacao().getCodigo_promocao_locacao()) {
                                if (jtbl_locacao.getValueAt(i, 2).equals("R$ 0,00")) {
                                    copiasLocacao.get(i).getObjeto().getDiaria().getPromocaoLocacao().setValor_promocao_locacao(diaria.getPromocaoLocacao().getValor_promocao_locacao());
                                    jtbl_locacao.setValueAt(moeda.setPrecoFormat(copiasLocacao.get(i).getObjeto().getDiaria().getPromocaoLocacao().getValor_promocao_locacao().toString()), i, 2);
                                    break;
                                }
                            }
                        }
                        resultado = resultado - 1;
                    }
                }
            }
        }
        return diaria;
    }

    public void dobleCheckPromocao() {
        pool = new Pool();        
        DiariaDAO diaDAO = new DiariaDAO(pool);
        diaDAO = new DiariaDAO(pool);
        
        List<Diaria> dias = diaDAO.getDiariaPromocao();
        for (int i = 0; i < dias.size(); i++) {

            for (int j = 0; j < jtbl_locacao.getRowCount(); j++) {
                if (dias.get(i).getPromocaoLocacao().getCodigo_promocao_locacao().equals(copiasLocacao.get(j).getObjeto().getDiaria().getPromocaoLocacao().getCodigo_promocao_locacao())) {
                    if (!jtbl_locacao.getValueAt(j, 2).equals("R$ 0,00")) {
                        dias.get(i).setQuantidade_filme(dias.get(i).getQuantidade_filme() + 1);
                        System.out.println("Quantidade de filme: " + dias.get(i).getQuantidade_filme());
                    }
                    if (jtbl_locacao.getValueAt(j, 2).equals("R$ 0,00")) {
                        dias.get(i).setGanhados(dias.get(i).getGanhados() + 1);
                        System.out.println("Quantidade de filme ganhados: " + dias.get(i).getGanhados());
                    }
                }
            }
            System.out.println(dias.get(i).getPromocaoLocacao().getDescricao() + "Quantidade de filme: " + dias.get(i).getQuantidade_filme());
            if (dias.get(i).getQuantidade_filme() >= dias.get(i).getPromocaoLocacao().getLocar_quantidade()) {
                int ganhar;
                ganhar = (dias.get(i).getQuantidade_filme() / dias.get(i).getPromocaoLocacao().getLocar_quantidade());
                System.out.println("Ganhar: " + ganhar);
                ganhar = ganhar * dias.get(i).getPromocaoLocacao().getGanhar_quantidade();

                System.out.println("Ganhar DoubleCheck: " + ganhar);
                if (ganhar > 0) {
//                    int ganhados = 0;
//                    for (int x = 0; x < jtbl_locacao.getRowCount(); x++) {
//                        if (jtbl_locacao.getValueAt(x, 2).equals("R$ 0,00")) {
//                            ganhados = ganhados + 1;
//                        }
//                    }
                    System.out.println("Ganhados DoubleCheck: " + dias.get(i).getGanhados());
                    System.out.println("Ganhar DoubleCheck: " + ganhar);

                    if (ganhar > dias.get(i).getGanhados()) {
                        for (int z = 0; z < jtbl_locacao.getRowCount(); z++) {
                            if (dias.get(i).getPromocaoLocacao().getCodigo_promocao_locacao() == copiasLocacao.get(z).getObjeto().getDiaria().getPromocaoLocacao().getCodigo_promocao_locacao()) {
                                copiasLocacao.get(z).getObjeto().getDiaria().getPromocaoLocacao().setValor_promocao_locacao(0.0);
                                jtbl_locacao.setValueAt(moeda.setPrecoFormat(copiasLocacao.get(z).getObjeto().getDiaria().getPromocaoLocacao().getValor_promocao_locacao().toString()), i, 2);
                                System.out.println("Colocar promocação:");
                                dobleCheckPromocao();
                                break;
                            }

                        }
                    } else {
                        int resultado = dias.get(i).getGanhados() - ganhar;
                        while (resultado > 0) {
                            for (int y = 0; y < jtbl_locacao.getRowCount(); y++) {
                                if (dias.get(i).getPromocaoLocacao().getCodigo_promocao_locacao() == copiasLocacao.get(y).getObjeto().getDiaria().getPromocaoLocacao().getCodigo_promocao_locacao()) {
                                    if (jtbl_locacao.getValueAt(y, 2).equals("R$ 0,00")) {
                                        copiasLocacao.get(y).getObjeto().getDiaria().getPromocaoLocacao().setValor_promocao_locacao(dias.get(i).getPromocaoLocacao().getValor_promocao_locacao());
                                        jtbl_locacao.setValueAt(moeda.setPrecoFormat(copiasLocacao.get(y).getObjeto().getDiaria().getPromocaoLocacao().getValor_promocao_locacao().toString()), y, 2);
                                        System.out.println("Retirar promocação:" + dias.get(i).getPromocaoLocacao().getValor_promocao_locacao());
                                        break;
                                    }
                                }
                            }
                            resultado = resultado - 1;
                        }
                    }
                }
            }
            else {
                for (int y = 0; y < jtbl_locacao.getRowCount(); y++) {
                    if (dias.get(i).getPromocaoLocacao().getCodigo_promocao_locacao() == copiasLocacao.get(y).getObjeto().getDiaria().getPromocaoLocacao().getCodigo_promocao_locacao()) {
                        if (jtbl_locacao.getValueAt(y, 2).equals("R$ 0,00")) {
                            copiasLocacao.get(y).getObjeto().getDiaria().getPromocaoLocacao().setValor_promocao_locacao(dias.get(i).getPromocaoLocacao().getValor_promocao_locacao());
                            jtbl_locacao.setValueAt(moeda.setPrecoFormat(copiasLocacao.get(y).getObjeto().getDiaria().getPromocaoLocacao().getValor_promocao_locacao().toString()), y, 2);
                            break;
                        }
                    }
                }
            }
        }

    }

}
