package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.Lancamento;
import br.com.locadora.model.bean.Produto;
import br.com.locadora.model.dao.DependenteDAO;
import br.com.locadora.model.dao.LancamentoDAO;
import br.com.locadora.model.dao.ProdutoDAO;
import br.com.locadora.util.Moeda;
import br.com.locadora.util.TemaInterface;
import static br.com.locadora.view.AtendimentoDevolucao.copiasLocacao;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AtendimentoVenda extends javax.swing.JFrame {

    public Dependente dependente;
    public InterfacePool pool;
    public TelaPrincipal janelapai;
    public Moeda moeda;
    public Lancamento lancamento;
    public AcessoUsuario acesso;
    public Produto produtoAtendimento;
    public ProdutoDAO produtoDAO;
    public List<Produto> produtos;
    public List<Produto> produtosVenda;
    public EntradaCaixaVenda entradaCaixaVenda;

    public AtendimentoVenda() {
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
        jtf_preco_venda = new javax.swing.JTextField();
        jtf_quantidade = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_venda = new javax.swing.JTable();
        jtf_nome_produto = new javax.swing.JTextField();
        jl_codigo_locacao = new javax.swing.JLabel();
        jtf_codigo_produto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jb_adicionar_venda = new javax.swing.JButton();
        jb_remover_venda = new javax.swing.JButton();
        jcb_codigo_barras_locacao = new javax.swing.JCheckBox();
        jl_debito_locacao = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jtf_saldo_debito_total = new javax.swing.JTextField();
        jtf_total_venda = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jb_finalizar = new javax.swing.JButton();
        jb_limpar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jtf_total_a_pagar = new javax.swing.JTextField();

        jDesktopPane1.setName("jDesktopPane1"); // NOI18N
        jDesktopPane1.setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atendimento Venda");
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
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_codigo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtf_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10))
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

        jp_locacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens Venda"));
        jp_locacao.setName("jp_locacao"); // NOI18N

        jtf_preco_venda.setEditable(false);
        jtf_preco_venda.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_preco_venda.setText("R$ 0,00");
        jtf_preco_venda.setName("jtf_preco_venda"); // NOI18N
        jtf_preco_venda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_preco_vendaActionPerformed(evt);
            }
        });
        jtf_preco_venda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_preco_vendaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_preco_vendaFocusLost(evt);
            }
        });

        jtf_quantidade.addKeyListener(new java.awt.event.KeyAdapter() {     // cria um listener ouvinte de digitação do fieldNumero

            public void keyReleased(java.awt.event.KeyEvent evt) {  // cria um ouvinte para cada tecla pressionada

                jtf_quantidade.setText(jtf_quantidade.getText().replaceAll("[^0-9]", "")); // faz com que pegue o texto a cada tecla digitada, e substituir tudo que não(^) seja numero  por ""

            }
        });
        jtf_quantidade.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_quantidade.setName("jtf_quantidade"); // NOI18N
        jtf_quantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_quantidadeKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel3.setText("Nome Produto");
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel5.setText("Preço Venda");
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel13.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel13.setText("Qtd.");
        jLabel13.setName("jLabel13"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jtbl_venda.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtbl_venda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código de Barras", "Nome Objeto", "Quantidade", "Preço Unitário", "Preço Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jtbl_venda.setName("jtbl_venda"); // NOI18N
        jtbl_venda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbl_vendaKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtbl_venda);
        if (jtbl_venda.getColumnModel().getColumnCount() > 0) {
            jtbl_venda.getColumnModel().getColumn(0).setPreferredWidth(50);
            jtbl_venda.getColumnModel().getColumn(1).setPreferredWidth(150);
            jtbl_venda.getColumnModel().getColumn(3).setPreferredWidth(30);
            jtbl_venda.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        jtf_nome_produto.setEditable(false);
        jtf_nome_produto.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_nome_produto.setName("jtf_nome_produto"); // NOI18N
        jtf_nome_produto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_nome_produtoFocusGained(evt);
            }
        });
        jtf_nome_produto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_nome_produtoKeyPressed(evt);
            }
        });

        jl_codigo_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jl_codigo_locacao.setText("Código de Barras");
        jl_codigo_locacao.setName("jl_codigo_locacao"); // NOI18N

        jtf_codigo_produto.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_codigo_produto.setName("jtf_codigo_produto"); // NOI18N
        jtf_codigo_produto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_codigo_produtoKeyPressed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pesquisar.png"))); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.setPreferredSize(new java.awt.Dimension(28, 28));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jb_adicionar_venda.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_adicionar_venda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/adicionar_item.png"))); // NOI18N
        jb_adicionar_venda.setToolTipText("Incluir");
        jb_adicionar_venda.setName("jb_adicionar_venda"); // NOI18N
        jb_adicionar_venda.setPreferredSize(new java.awt.Dimension(28, 28));
        jb_adicionar_venda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_adicionar_vendaMouseClicked(evt);
            }
        });
        jb_adicionar_venda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_adicionar_vendaKeyPressed(evt);
            }
        });

        jb_remover_venda.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_remover_venda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/remove_item.png"))); // NOI18N
        jb_remover_venda.setToolTipText("Excluir");
        jb_remover_venda.setName("jb_remover_venda"); // NOI18N
        jb_remover_venda.setPreferredSize(new java.awt.Dimension(28, 28));
        jb_remover_venda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_remover_vendaActionPerformed(evt);
            }
        });
        jb_remover_venda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_remover_vendaKeyPressed(evt);
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

        javax.swing.GroupLayout jp_locacaoLayout = new javax.swing.GroupLayout(jp_locacao);
        jp_locacao.setLayout(jp_locacaoLayout);
        jp_locacaoLayout.setHorizontalGroup(
            jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_locacaoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_locacaoLayout.createSequentialGroup()
                        .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcb_codigo_barras_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jp_locacaoLayout.createSequentialGroup()
                                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jl_codigo_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtf_codigo_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtf_nome_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtf_preco_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addGroup(jp_locacaoLayout.createSequentialGroup()
                                        .addComponent(jtf_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jb_adicionar_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jb_remover_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())
                    .addComponent(jScrollPane2)))
        );
        jp_locacaoLayout.setVerticalGroup(
            jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_locacaoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jp_locacaoLayout.createSequentialGroup()
                        .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_codigo_locacao)
                            .addComponent(jLabel3))
                        .addGap(0, 0, 0)
                        .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_codigo_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_nome_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jp_locacaoLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, 0)
                        .addComponent(jtf_preco_venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_locacaoLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, 0)
                        .addComponent(jtf_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jb_adicionar_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jb_remover_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(jcb_codigo_barras_locacao)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jp_locacaoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jb_adicionar_venda, jb_remover_venda, jtf_quantidade});

        jp_locacaoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jtf_codigo_produto, jtf_nome_produto, jtf_preco_venda});

        jl_debito_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jl_debito_locacao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jl_debito_locacao.setText("Devedor:");
        jl_debito_locacao.setName("jl_debito_locacao"); // NOI18N

        jLabel27.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Total Venda:");
        jLabel27.setName("jLabel27"); // NOI18N

        jtf_saldo_debito_total.setEditable(false);
        jtf_saldo_debito_total.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
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

        jtf_total_venda.setEditable(false);
        jtf_total_venda.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jtf_total_venda.setForeground(new java.awt.Color(255, 51, 51));
        jtf_total_venda.setText("R$ 0,00");
        jtf_total_venda.setName("jtf_total_venda"); // NOI18N
        jtf_total_venda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_total_vendaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_total_vendaFocusLost(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel2.setName("jPanel2"); // NOI18N

        jb_finalizar.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_finalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/finalizar.png"))); // NOI18N
        jb_finalizar.setText("OK");
        jb_finalizar.setName("jb_finalizar"); // NOI18N
        jb_finalizar.setPreferredSize(new java.awt.Dimension(100, 40));
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

        jb_limpar.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_limpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/limpar.png"))); // NOI18N
        jb_limpar.setText("Limpar");
        jb_limpar.setName("jb_limpar"); // NOI18N
        jb_limpar.setPreferredSize(new java.awt.Dimension(100, 40));
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

        jb_cancelar.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/sair.png"))); // NOI18N
        jb_cancelar.setText("Sair");
        jb_cancelar.setMaximumSize(new java.awt.Dimension(101, 33));
        jb_cancelar.setName("jb_cancelar"); // NOI18N
        jb_cancelar.setPreferredSize(new java.awt.Dimension(100, 40));
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
                .addGap(116, 116, 116)
                .addComponent(jb_finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jb_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jb_finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jb_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/BROADWAY-LOGIN.png"))); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel28.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Total À Pagar:");
        jLabel28.setName("jLabel28"); // NOI18N

        jtf_total_a_pagar.setEditable(false);
        jtf_total_a_pagar.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jl_debito_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jtf_saldo_debito_total, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(5, 5, 5)
                                        .addComponent(jtf_total_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(jtf_total_a_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(jp_locacao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(747, 747, 747)
                        .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jp_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_debito_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_saldo_debito_total, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_total_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_total_a_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if (jcb_codigo_barras_locacao.isSelected() == true) {
            jl_codigo_locacao.setText("Código de Barras");
        } else {
            jl_codigo_locacao.setText("Código do Produto");
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
        ((DefaultTableModel) jtbl_venda.getModel()).setRowCount(0);
        jtbl_venda.updateUI();
        retornaJanelaPai();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

private void jb_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_clienteActionPerformed
    ConsultaClienteAtendimento consultaCliente = new ConsultaClienteAtendimento();
    consultaCliente.janelapaiVenda = this;
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
    jtf_codigo_produto.requestFocus();
}//GEN-LAST:event_jtf_nome_clienteFocusLost

    private void jtf_saldo_debito_totalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_saldo_debito_totalFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_saldo_debito_totalFocusLost

    private void jtf_saldo_debito_totalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_saldo_debito_totalFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_saldo_debito_totalFocusGained

    private void jtf_total_vendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_total_vendaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_vendaFocusLost

    private void jtf_total_vendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_total_vendaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_vendaFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jtf_codigo_cliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe primeiro um cliente");
            jtf_nome_cliente.requestFocus();
        } else {
            ConsultaProdutoVenda consultaProdutoVenda = new ConsultaProdutoVenda();
            consultaProdutoVenda.janelapai = this;
            consultaProdutoVenda.setVisible(true);
            setStatusTela(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtf_nome_produtoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nome_produtoKeyPressed

    }//GEN-LAST:event_jtf_nome_produtoKeyPressed

    private void jtf_nome_produtoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_nome_produtoFocusGained
    }//GEN-LAST:event_jtf_nome_produtoFocusGained

    private void jb_remover_vendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_remover_vendaActionPerformed
        removeObjeto(jtbl_venda);
    }//GEN-LAST:event_jb_remover_vendaActionPerformed

    private void jtf_preco_vendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_preco_vendaFocusLost
        moeda = new Moeda();
        jtf_preco_venda.setText(moeda.setPrecoFormat(jtf_preco_venda.getText()));
    }//GEN-LAST:event_jtf_preco_vendaFocusLost

    private void jtf_preco_vendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_preco_vendaFocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_preco_vendaFocusGained

    private void jtf_codigo_produtoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_codigo_produtoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            consultarObjeto();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            consultarCliente();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_codigo_produtoKeyPressed

    private void jb_adicionar_vendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_adicionar_vendaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                if (jcb_codigo_barras_locacao.isSelected() == true) {
                    if (produtoAtendimento != null) {
                        adicionarItemVenda(produtoAtendimento);
                    }
                } else {
                    consultarCodigoProduto(Integer.parseInt(jtf_codigo_produto.getText().trim()));
                    if (produtoAtendimento != null) {
                        adicionarItemVenda(produtoAtendimento);
                    }
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Código do Objeto deve ser número");
            }
        }
    }//GEN-LAST:event_jb_adicionar_vendaKeyPressed

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
        if (jcb_codigo_barras_locacao.isSelected() == true) {
            jl_codigo_locacao.setText("Código de Barras");
        } else {
            jl_codigo_locacao.setText("Código do Objeto");
        }
        jtf_codigo_produto.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_codigo_barras_locacaoActionPerformed

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

    private void jtf_preco_vendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_preco_vendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_preco_vendaActionPerformed

    private void jb_remover_vendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_remover_vendaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_remover_venda.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_remover_vendaKeyPressed

    private void jtbl_vendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_vendaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            jb_remover_venda.doClick();
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jtbl_vendaKeyPressed

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

    private void jb_adicionar_vendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_adicionar_vendaMouseClicked
        if (evt.getClickCount() == 1) {
            try {
                if (jcb_codigo_barras_locacao.isSelected() == true) {

                    if (consultarCodigoDeBarras(jtf_codigo_produto.getText().trim()) == true) {
                        if (produtoAtendimento != null) {
                            adicionarItemVenda(produtoAtendimento);
                        }
                    }
                } else {
                    consultarCodigoProduto(Integer.parseInt(jtf_codigo_produto.getText().trim()));
                    if (produtoAtendimento != null) {
                        adicionarItemVenda(produtoAtendimento);
                    }
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Código do Objeto deve ser número");
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_adicionar_vendaMouseClicked

    private void jtf_total_a_pagarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_total_a_pagarFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_a_pagarFocusGained

    private void jtf_total_a_pagarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_total_a_pagarFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_a_pagarFocusLost

    private void jtf_quantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_quantidadeKeyPressed
                acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_adicionar_venda.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_quantidadeKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AtendimentoVenda().setVisible(true);
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
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jb_adicionar_venda;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_cliente;
    private javax.swing.JButton jb_finalizar;
    private javax.swing.JButton jb_limpar;
    private javax.swing.JButton jb_remover_venda;
    private javax.swing.JCheckBox jcb_codigo_barras_locacao;
    private javax.swing.JLabel jl_codigo_locacao;
    private javax.swing.JLabel jl_debito_locacao;
    public static javax.swing.JPanel jp_locacao;
    public static javax.swing.JTable jtbl_venda;
    public static javax.swing.JTextField jtf_codigo_cliente;
    private javax.swing.JTextField jtf_codigo_produto;
    public static javax.swing.JTextField jtf_nome_cliente;
    public static javax.swing.JTextField jtf_nome_produto;
    private javax.swing.JTextField jtf_preco_venda;
    private javax.swing.JFormattedTextField jtf_quantidade;
    public static javax.swing.JTextField jtf_saldo_debito_total;
    public static javax.swing.JTextField jtf_total_a_pagar;
    public static javax.swing.JTextField jtf_total_venda;
    // End of variables declaration//GEN-END:variables

    public void consultarObjeto() {
        try {
            if (!jtf_codigo_cliente.getText().equals("")) {
                if (jcb_codigo_barras_locacao.isSelected() == true) {
                    consultarCodigoDeBarras(jtf_codigo_produto.getText().trim());
                } else {
                    consultarCodigoProduto(Integer.parseInt(jtf_codigo_produto.getText().trim()));
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
        ConsultaProdutoVenda consultaProdutoVenda = new ConsultaProdutoVenda();
        consultaProdutoVenda.janelapai = this;
        consultaProdutoVenda.setVisible(true);
        setStatusTela(false);
    }

    private void abrirCaixa() {
        if (verificarCampos() == true) {
            if (jtbl_venda.getRowCount() > 0) {                
                entradaCaixaVenda = new EntradaCaixaVenda();
                entradaCaixaVenda.setVisible(true);
                entradaCaixaVenda.janelapaiVenda = this;
                setStatusTela(false);
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
        jtf_codigo_produto.setText("");
        jtf_preco_venda.setText("");        
        jtf_quantidade.setText("");
    }

    public void removeObjeto(JTable tb) {
        if (tb != null) {
            DefaultTableModel row = (DefaultTableModel) jtbl_venda.getModel();
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

    public boolean verificarCamposItemVenda() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_codigo_produto.getText().equals("")) {
            msgERRO = msgERRO + " *Produto\n";
        }
        
        if (jtf_quantidade.getText().equals("")) {
            msgERRO = msgERRO + " *Quantidade\n";
        }

        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            jtf_codigo_produto.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public void adicionarItemVenda(Produto produto) {

        if (verificarCamposItemVenda() == true) {
            moeda = new Moeda();
            DefaultTableModel row = (DefaultTableModel) jtbl_venda.getModel();
            Integer quantidade = Integer.parseInt(jtf_quantidade.getText());
            Double preco_total = quantidade * produto.getPreco_venda();
            produto.setPreco_total(preco_total);
            produto.setQuantidade(quantidade);

            row.addRow(new Object[]{produto.getCodigo_barras(), produto.getNome_produto(),produto.getQuantidade(),
                moeda.setPrecoFormat(produto.getPreco_venda().toString()), moeda.setPrecoFormat(produto.getPreco_total().toString())});

            produtosVenda.add(produto);
            recalcularValorTotal();
            limparItemLocado();
            jtf_codigo_produto.requestFocus();
        } 
    }

    public void recalcularValorTotal() {

        moeda = new Moeda();
        Double total_venda = 0.00;
        Double total_a_pagar = 0.00;
        Double saldo_debito_total = moeda.getPrecoFormato(jtf_saldo_debito_total.getText());
        for (int i = 0; i < jtbl_venda.getRowCount(); i++) {
            Double valor_adicionar = moeda.getPrecoFormato(jtbl_venda.getValueAt(i, 4).toString());
            total_venda = total_venda + valor_adicionar;
        }
        if (jtf_saldo_debito_total.getForeground() == Color.BLACK) {
            if (saldo_debito_total > total_venda) {
                total_a_pagar = 0.00;
            } else {
                total_a_pagar = saldo_debito_total - total_venda;
                if (total_a_pagar < 0) {
                    total_a_pagar = total_a_pagar * (-1);
                }
            }
        } else {
            total_a_pagar = total_venda + saldo_debito_total;
        }
        jtf_total_venda.setText(moeda.setPrecoFormat(String.valueOf(total_venda)));
        jtf_total_a_pagar.setText(moeda.setPrecoFormat(String.valueOf(total_a_pagar)));

    }

    public void limparItemLocado() {
        jtf_codigo_produto.setText("");
        jtf_nome_produto.setText("");
        jtf_preco_venda.setText("R$ 0,00");
        jtf_quantidade.setText("");
    }

    public void statusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }

    public void carregarProdutoVenda(Produto produto) {
        if (produto != null) {
            this.produtoAtendimento = produto;
            moeda = new Moeda();
            jtf_codigo_produto.setText(produto.getCodigo_barras());
            jtf_nome_produto.setText(produto.getNome_produto());
            jtf_preco_venda.setText(moeda.setPrecoFormat(produto.getPreco_venda().toString()));
            jtf_quantidade.requestFocus();
        }
    }

    public void carregarClienteDependente(Dependente dependente) {
        if (dependente != null) {
            produtosVenda = new ArrayList<>();
            this.dependente = dependente;
            jtf_saldo_debito_total.setText("R$ 0,00");

            jtf_nome_cliente.setText(dependente.getNome_dependente());
            setTitle("Atendimento Venda - " + dependente.getNome_dependente());
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
                jl_debito_locacao.setText("Saldo:");
                jtf_codigo_produto.setEnabled(true);
            } else if (lancamento.getSaldo() > 0) {
                jtf_saldo_debito_total.setText(moeda.setPrecoFormat(String.valueOf(lancamento.getSaldo())));
                jtf_saldo_debito_total.setForeground(Color.red);
                jl_debito_locacao.setText("Devedor:");
                verificarDebito(dependente.getCliente());
            } else {
                jtf_saldo_debito_total.setText("R$ 0,00");
                jtf_saldo_debito_total.setForeground(Color.black);
                jl_debito_locacao.setText("Saldo:");
                jtf_codigo_produto.setEnabled(true);
            }

            jtf_codigo_produto.requestFocus();

            //Limpa tabela depois de selecionar novo cliente
            DefaultTableModel tb_locacao = (DefaultTableModel) jtbl_venda.getModel();
            int rows = tb_locacao.getRowCount();
            for (int i = rows - 1; i >= 0; i--) {
                tb_locacao.removeRow(i);
            }

            jtf_total_venda.setText("R$ 0,00");

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
                jtf_codigo_produto.setEnabled(false);
            } else {
                jtf_codigo_produto.setEnabled(true);
            }
        }
    }

    public boolean consultarCodigoDeBarras(String codigo_barras) {
        boolean retorno = false;
        pool = new Pool();
        produtoDAO = new ProdutoDAO(pool);
        produtos = produtoDAO.getProdutoCodigoBarras(jtf_codigo_produto.getText());
        carregarProdutoVenda(produtos.get(0));
        retorno = true;
        return retorno;
    }

    public void consultarCodigoProduto(Integer codigo_objeto) {

        pool = new Pool();
        produtoDAO = new ProdutoDAO(pool);
        if (codigo_objeto != null) {

            produtos = produtoDAO.getProdutoCodigoBarras(jtf_codigo_produto.getText());

            if (produtos.size() > 0) {
                consultarCodigoDeBarras(produtos.get(0).getCodigo_barras());

            } else {
                JOptionPane.showMessageDialog(null, "Produto não encontrado");
            }

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

    private void retornaJanelaPai() {
        setVisible(false);
        if (janelapai != null) {
            janelapai.setStatusTela(true);
            janelapai.atendimentoLocacao = null;
            janelapai = null;
        }
    }

}
