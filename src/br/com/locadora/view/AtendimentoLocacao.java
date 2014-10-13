package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.controller.SiscomController;
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.Objeto;
import br.com.locadora.model.bean.Produto;
import br.com.locadora.model.dao.CopiaDAO;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.LimitadorTexto;
import br.com.locadora.util.Moeda;
import static br.com.locadora.view.AtendimentoDevolucao.jtf_codigo_cliente;
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
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class AtendimentoLocacao extends javax.swing.JFrame implements AtendimentoLocacao_InterFace {

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
    public Moeda moeda;

    public AtendimentoLocacao() {
        initComponents();
    }

    public void setTela(String permissao) {

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
        jp_locacao1 = new javax.swing.JPanel();
        /*try  {          
            Locale BRAZIL = new Locale("pt","BR");  
            DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);
            formatoPreco = new DecimalFormat("¤ ###,###,##0.00",REAL);  
        }    catch (Exception erro)  
        {    
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");  
        }
        */
        jtf_valor1 = new javax.swing.JTextField();
        jtf_tipo_midia1 = new javax.swing.JTextField(new LimitadorTexto(11), "",10);
        jb_adicionar_locacao1 = new javax.swing.JButton();
        jb_remover_locacao1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtbl_venda = new javax.swing.JTable();
        jtf_nome_objeto1 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jtf_codigo_copia1 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        /*try  {          
            Locale BRAZIL = new Locale("pt","BR");  
            DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);
            formatoPreco = new DecimalFormat("¤ ###,###,##0.00",REAL);  
        }    catch (Exception erro)  
        {    
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");  
        }
        */
        jtf_valor_promocao1 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        /*try  {          
            Locale BRAZIL = new Locale("pt","BR");  
            DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);
            formatoPreco = new DecimalFormat("¤ ###,###,##0.00",REAL);  
        }    catch (Exception erro)  
        {    
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");  
        }
        */
        jtf_valor2 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel30 = new javax.swing.JLabel();
        /*try  {          
            Locale BRAZIL = new Locale("pt","BR");  
            DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);
            formatoPreco = new DecimalFormat("¤ ###,###,##0.00",REAL);  
        }    catch (Exception erro)  
        {    
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");  
        }
        */
        jtf_preco9 = new javax.swing.JTextField();
        /*try  {          
            Locale BRAZIL = new Locale("pt","BR");  
            DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);
            formatoPreco = new DecimalFormat("¤ ###,###,##0.00",REAL);  
        }    catch (Exception erro)  
        {    
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");  
        }
        */
        jtf_preco10 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        /*try  {          
            Locale BRAZIL = new Locale("pt","BR");  
            DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);
            formatoPreco = new DecimalFormat("¤ ###,###,##0.00",REAL);  
        }    catch (Exception erro)  
        {    
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");  
        }
        */
        jtf_preco6 = new javax.swing.JTextField();
        jtf_quantidade2 = new javax.swing.JTextField(new LimitadorTexto(11), "",10);
        try  {      
            formatoData = new MaskFormatter("##/##/####");  
        } 
        catch (Exception erro)  
        {    
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");  
        }
        jftf_vencimento2 = new JFormattedTextField(formatoData);
        jb_adicionar2 = new javax.swing.JButton();
        jb_eliminar2 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jtf_descricao_objeto = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jtf_codigo_objeto = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        /*try  {          
            Locale BRAZIL = new Locale("pt","BR");  
            DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);
            formatoPreco = new DecimalFormat("¤ ###,###,##0.00",REAL);  
        }    catch (Exception erro)  
        {    
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");  
        }
        */
        jtf_preco7 = new javax.swing.JTextField();
        jCheckBox3 = new javax.swing.JCheckBox();
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

        jButton7.setText("Finalizar");
        jButton7.setName("jButton7"); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jp_locacao.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 340, 130, 50));

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

        jtp_locacao.addTab("Locação", jp_locacao);

        jp_locacao1.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens"));
        jp_locacao1.setName("jp_locacao1"); // NOI18N
        jp_locacao1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtf_valor1.setEditable(false);
        jtf_valor1.setText("R$ 0,00");
        jtf_valor1.setName("jtf_valor1"); // NOI18N
        jtf_valor1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_valor1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_valor1FocusLost(evt);
            }
        });
        jp_locacao1.add(jtf_valor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 100, -1));

        jtf_tipo_midia.addKeyListener(new java.awt.event.KeyAdapter() {     // cria um listener ouvinte de digitação do fieldNumero

            public void keyReleased(java.awt.event.KeyEvent evt) {  // cria um ouvinte para cada tecla pressionada

                jtf_tipo_midia.setText(jtf_tipo_midia.getText().replaceAll("[^0-9]", "")); // faz com que pegue o texto a cada tecla digitada, e substituir tudo que não(^) seja numero  por ""

            }
        });
        jtf_tipo_midia1.setName("jtf_tipo_midia1"); // NOI18N
        jtf_tipo_midia1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_tipo_midia1FocusGained(evt);
            }
        });
        jtf_tipo_midia1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_tipo_midia1KeyPressed(evt);
            }
        });
        jp_locacao1.add(jtf_tipo_midia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 70, -1));

        jb_adicionar_locacao1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/edit_add.png"))); // NOI18N
        jb_adicionar_locacao1.setToolTipText("Incluir");
        jb_adicionar_locacao1.setName("jb_adicionar_locacao1"); // NOI18N
        jb_adicionar_locacao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_adicionar_locacao1ActionPerformed(evt);
            }
        });
        jp_locacao1.add(jb_adicionar_locacao1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 30, 30));

        jb_remover_locacao1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/edit_remove.png"))); // NOI18N
        jb_remover_locacao1.setToolTipText("Excluir");
        jb_remover_locacao1.setName("jb_remover_locacao1"); // NOI18N
        jb_remover_locacao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_remover_locacao1ActionPerformed(evt);
            }
        });
        jp_locacao1.add(jb_remover_locacao1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, 30, 30));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel7.setText("Descrição");
        jLabel7.setName("jLabel7"); // NOI18N
        jp_locacao1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 300, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel11.setText("Valor Venda");
        jLabel11.setName("jLabel11"); // NOI18N
        jp_locacao1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 110, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel12.setText("Qtd.");
        jLabel12.setName("jLabel12"); // NOI18N
        jp_locacao1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 70, -1));

        jScrollPane5.setName("jScrollPane5"); // NOI18N

        jtbl_venda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Valor", "Valor Promocional", "Valor Total", "Qtd"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        jtbl_venda.setName("jtbl_venda"); // NOI18N
        jScrollPane5.setViewportView(jtbl_venda);
        if (jtbl_venda.getColumnModel().getColumnCount() > 0) {
            jtbl_venda.getColumnModel().getColumn(0).setPreferredWidth(20);
            jtbl_venda.getColumnModel().getColumn(1).setPreferredWidth(150);
            jtbl_venda.getColumnModel().getColumn(2).setPreferredWidth(30);
            jtbl_venda.getColumnModel().getColumn(3).setPreferredWidth(30);
            jtbl_venda.getColumnModel().getColumn(4).setPreferredWidth(20);
            jtbl_venda.getColumnModel().getColumn(5).setPreferredWidth(30);
        }

        jp_locacao1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 780, 200));

        jtf_nome_objeto1.setName("jtf_nome_objeto1"); // NOI18N
        jtf_nome_objeto1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_nome_objeto1FocusGained(evt);
            }
        });
        jtf_nome_objeto1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_nome_objeto1KeyPressed(evt);
            }
        });
        jp_locacao1.add(jtf_nome_objeto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 410, -1));

        jLabel25.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel25.setText("Código Produto");
        jLabel25.setName("jLabel25"); // NOI18N
        jp_locacao1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jtf_codigo_copia1.setName("jtf_codigo_copia1"); // NOI18N
        jp_locacao1.add(jtf_codigo_copia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 80, -1));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pesquisar.png"))); // NOI18N
        jButton8.setName("jButton8"); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jp_locacao1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 30, -1));

        jLabel26.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel26.setText("Valor Promocional");
        jLabel26.setName("jLabel26"); // NOI18N
        jp_locacao1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 110, -1));

        jtf_valor_promocao1.setEditable(false);
        jtf_valor_promocao1.setText("R$ 0,00");
        jtf_valor_promocao1.setName("jtf_valor_promocao1"); // NOI18N
        jtf_valor_promocao1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_valor_promocao1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_valor_promocao1FocusLost(evt);
            }
        });
        jp_locacao1.add(jtf_valor_promocao1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 100, -1));

        jButton9.setText("Finalizar");
        jButton9.setName("jButton9"); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jp_locacao1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, -1, -1));

        jLabel29.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel29.setText("Valor");
        jLabel29.setName("jLabel29"); // NOI18N
        jp_locacao1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 50, -1));

        jtf_valor2.setEditable(false);
        jtf_valor2.setText("R$ 0,00");
        jtf_valor2.setName("jtf_valor2"); // NOI18N
        jtf_valor2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_valor2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_valor2FocusLost(evt);
            }
        });
        jp_locacao1.add(jtf_valor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 100, -1));

        jCheckBox1.setText("Usar código de Barras");
        jCheckBox1.setName("jCheckBox1"); // NOI18N
        jp_locacao1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, -1, -1));

        jLabel30.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel30.setText("Total");
        jLabel30.setName("jLabel30"); // NOI18N
        jp_locacao1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 60, 30));

        jtf_preco9.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jtf_preco9.setText("R$");
        jtf_preco9.setName("jtf_preco9"); // NOI18N
        jtf_preco9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_preco9FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_preco9FocusLost(evt);
            }
        });
        jp_locacao1.add(jtf_preco9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, 180, 40));

        jtf_preco10.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jtf_preco10.setText("R$");
        jtf_preco10.setName("jtf_preco10"); // NOI18N
        jtf_preco10.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_preco10FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_preco10FocusLost(evt);
            }
        });
        jp_locacao1.add(jtf_preco10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 180, 40));

        jLabel31.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel31.setText("Crédito Total");
        jLabel31.setName("jLabel31"); // NOI18N
        jp_locacao1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 130, 30));

        jtp_locacao.addTab("Vendas", jp_locacao1);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens"));
        jPanel4.setName("jPanel4"); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtf_preco6.setText("R$");
        jtf_preco6.setName("jtf_preco6"); // NOI18N
        jtf_preco6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_preco6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_preco6FocusLost(evt);
            }
        });
        jPanel4.add(jtf_preco6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 80, -1));

        jtf_tipo_midia.addKeyListener(new java.awt.event.KeyAdapter() {     // cria um listener ouvinte de digitação do fieldNumero

            public void keyReleased(java.awt.event.KeyEvent evt) {  // cria um ouvinte para cada tecla pressionada

                jtf_tipo_midia.setText(jtf_tipo_midia.getText().replaceAll("[^0-9]", "")); // faz com que pegue o texto a cada tecla digitada, e substituir tudo que não(^) seja numero  por ""

            }
        });
        jtf_quantidade2.setName("jtf_quantidade2"); // NOI18N
        jtf_quantidade2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_quantidade2FocusGained(evt);
            }
        });
        jtf_quantidade2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_quantidade2KeyPressed(evt);
            }
        });
        jPanel4.add(jtf_quantidade2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 70, -1));

        jftf_vencimento2.setName("jftf_vencimento2"); // NOI18N
        jftf_vencimento2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jftf_vencimento2FocusGained(evt);
            }
        });
        jftf_vencimento2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jftf_vencimento2KeyPressed(evt);
            }
        });
        jPanel4.add(jftf_vencimento2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 70, -1));

        jb_adicionar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/edit_add.png"))); // NOI18N
        jb_adicionar2.setToolTipText("Incluir");
        jb_adicionar2.setName("jb_adicionar2"); // NOI18N
        jb_adicionar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_adicionar2ActionPerformed(evt);
            }
        });
        jPanel4.add(jb_adicionar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 30, 30));

        jb_eliminar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/edit_remove.png"))); // NOI18N
        jb_eliminar2.setToolTipText("Excluir");
        jb_eliminar2.setName("jb_eliminar2"); // NOI18N
        jb_eliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_eliminar2ActionPerformed(evt);
            }
        });
        jPanel4.add(jb_eliminar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 30, 30));

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel19.setText("Nome Objeto");
        jLabel19.setName("jLabel19"); // NOI18N
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 300, -1));

        jLabel20.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel20.setText("Valor");
        jLabel20.setName("jLabel20"); // NOI18N
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 50, -1));

        jLabel21.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel21.setText("Tipo Mídia");
        jLabel21.setName("jLabel21"); // NOI18N
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 70, -1));

        jLabel22.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel22.setText("Diária");
        jLabel22.setName("jLabel22"); // NOI18N
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, -1));

        jScrollPane4.setName("jScrollPane4"); // NOI18N

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Produto", "Lote", "Preço", "Qtd", "Vencimento"
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
        jTable3.setName("jTable3"); // NOI18N
        jScrollPane4.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTable3.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable3.getColumnModel().getColumn(2).setPreferredWidth(30);
            jTable3.getColumnModel().getColumn(3).setPreferredWidth(30);
            jTable3.getColumnModel().getColumn(4).setPreferredWidth(30);
            jTable3.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        jPanel4.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 550, 200));

        jtf_descricao_objeto.setName("jtf_descricao_objeto"); // NOI18N
        jtf_descricao_objeto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_descricao_objetoFocusGained(evt);
            }
        });
        jtf_descricao_objeto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_descricao_objetoKeyPressed(evt);
            }
        });
        jPanel4.add(jtf_descricao_objeto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 410, -1));

        jLabel23.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel23.setText("Código Cópia");
        jLabel23.setName("jLabel23"); // NOI18N
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jtf_codigo_objeto.setEditable(false);
        jtf_codigo_objeto.setName("jtf_codigo_objeto"); // NOI18N
        jPanel4.add(jtf_codigo_objeto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 80, -1));

        jButton3.setText("...");
        jButton3.setName("jButton3"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 30, -1));

        jLabel24.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel24.setText("Valor Promocional");
        jLabel24.setName("jLabel24"); // NOI18N
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 110, -1));

        jtf_preco7.setText("R$");
        jtf_preco7.setName("jtf_preco7"); // NOI18N
        jtf_preco7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_preco7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_preco7FocusLost(evt);
            }
        });
        jPanel4.add(jtf_preco7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 80, -1));

        jCheckBox3.setText("Bolsa");
        jCheckBox3.setName("jCheckBox3"); // NOI18N
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        jPanel4.add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, -1));

        jtp_locacao.addTab("Reservas", jPanel4);

        getContentPane().add(jtp_locacao);
        jtp_locacao.setBounds(0, 90, 850, 450);

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
        jPanel2.setBounds(590, 10, 200, 80);

        setSize(new java.awt.Dimension(867, 564));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if (jcb_codigo_barras_locacao.isSelected() == true) {
            jl_codigo_locacao.setText("Código de Barras");
//            jtf_codigo_consulta_locacao.requestFocus();
        } else {
            jl_codigo_locacao.setText("Código dó Objeto");
//            jtf_codigo_consulta_locacao.requestFocus();
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

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jtf_valor_promocao1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_promocao1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_promocao1FocusLost

    private void jtf_valor_promocao1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_promocao1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_promocao1FocusGained

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jtf_nome_objeto1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nome_objeto1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nome_objeto1KeyPressed

    private void jtf_nome_objeto1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_nome_objeto1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nome_objeto1FocusGained

    private void jb_remover_locacao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_remover_locacao1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_remover_locacao1ActionPerformed

    private void jb_adicionar_locacao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_adicionar_locacao1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_adicionar_locacao1ActionPerformed

    private void jtf_tipo_midia1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_tipo_midia1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_tipo_midia1KeyPressed

    private void jtf_tipo_midia1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_tipo_midia1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_tipo_midia1FocusGained

    private void jtf_valor1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor1FocusLost

    private void jtf_valor1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor1FocusGained

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jtf_preco7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_preco7FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_preco7FocusLost

    private void jtf_preco7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_preco7FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_preco7FocusGained

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jtf_descricao_objetoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_descricao_objetoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_descricao_objetoKeyPressed

    private void jtf_descricao_objetoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_descricao_objetoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_descricao_objetoFocusGained

    private void jb_eliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_eliminar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_eliminar2ActionPerformed

    private void jb_adicionar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_adicionar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_adicionar2ActionPerformed

    private void jftf_vencimento2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jftf_vencimento2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jftf_vencimento2KeyPressed

    private void jftf_vencimento2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftf_vencimento2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jftf_vencimento2FocusGained

    private void jtf_quantidade2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_quantidade2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_quantidade2KeyPressed

    private void jtf_quantidade2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_quantidade2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_quantidade2FocusGained

    private void jtf_preco6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_preco6FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_preco6FocusLost

    private void jtf_preco6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_preco6FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_preco6FocusGained

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        enviarDadosLocacao();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jtf_codigo_cliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe primeiro um cliente");
        } else {
            ConsultaCopiaLocacao copiaCliente = new ConsultaCopiaLocacao();
            copiaCliente.setTelaAtendimento(this);
            copiaCliente.janelapai = this;
            copiaCliente.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtf_nome_objeto_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nome_objeto_locacaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ConsultaCopiaLocacao copiaCliente = new ConsultaCopiaLocacao();
            copiaCliente.setTelaAtendimento(this);
            copiaCliente.janelapai = this;
            copiaCliente.setVisible(true);
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

    private void jtf_valor2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor2FocusGained

    private void jtf_valor2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor2FocusLost

    private void jtf_preco9FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_preco9FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_preco9FocusGained

    private void jtf_preco9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_preco9FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_preco9FocusLost

    private void jtf_preco10FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_preco10FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_preco10FocusGained

    private void jtf_preco10FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_preco10FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_preco10FocusLost

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
                    copiaCliente.setTelaAtendimento(this);
                    copiaCliente.janelapai = this;
                    copiaCliente.setVisible(true);
                } else if (evt.getKeyCode() == KeyEvent.VK_F10) {
                    enviarDadosLocacao();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Informe primeiro um Cliente");
            }
        } catch (NumberFormatException e) {
            Logger.getLogger(AtendimentoLocacao.class.getName()).log(Level.SEVERE, null, e);
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

    public void consultarClienteAtendimento() {
        ConsultaClienteAtendimento consultaCliente = new ConsultaClienteAtendimento();
        consultaCliente.setTelaAtendimento(this);;
        consultaCliente.janelapaiLocacao = this;
        consultaCliente.setVisible(true);
        consultaCliente.jtf_consulta.setText(jtf_nome_cliente.getText().trim());
        setStatusTela(false);

    }

//    public void checarFilmeLocado(Integer codigo_cliente, String codigo_consulta_locacao) {
//        try {
//            pool = new Pool();
//            CopiaDAO copiaDAO = new CopiaDAO(pool);
//            copias = null;
//            String quantidade_locado;
//            
//            quantidade_locado = copiaDAO.getQuantidadeAssistida(codigo_cliente, codigo_consulta_locacao);
//            if (quantidade_locado.equals(objeto)) {
//                carregarCopiaLocacao(copias.get(0));
//            } else {
//                int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
//                if (selectedOption == JOptionPane.YES_NO_OPTION) {
//
//                }
//                JOptionPane.showMessageDialog(null, "Código de Barra inválido");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(AtendimentoLocacao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
    private TelaPrincipal_Interface telaPrincipal;

    public void setTelaPrincipal(TelaPrincipal_Interface telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
    }

//    private void buscarDadosLocacao() {
//        controller = new SiscomController();
//        controller.processarRequisicao("consultarLocacao");
//    }
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
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable3;
    private javax.swing.JButton jb_adicionar2;
    private javax.swing.JButton jb_adicionar_locacao;
    private javax.swing.JButton jb_adicionar_locacao1;
    private javax.swing.JButton jb_cliente;
    private javax.swing.JButton jb_eliminar2;
    private javax.swing.JButton jb_remover_locacao;
    private javax.swing.JButton jb_remover_locacao1;
    private javax.swing.JCheckBox jcb_codigo_barras_locacao;
    private javax.swing.JFormattedTextField jftf_vencimento2;
    private javax.swing.JLabel jl_codigo_locacao;
    public static javax.swing.JPanel jp_locacao;
    private javax.swing.JPanel jp_locacao1;
    public static javax.swing.JTable jtbl_locacao;
    public static javax.swing.JTable jtbl_venda;
    public static javax.swing.JTextField jtf_codigo_cliente;
    private javax.swing.JTextField jtf_codigo_consulta_locacao;
    private javax.swing.JTextField jtf_codigo_copia1;
    private javax.swing.JTextField jtf_codigo_objeto;
    public static javax.swing.JTextField jtf_debito_total_locacao;
    private javax.swing.JTextField jtf_descricao_objeto;
    private javax.swing.JFormattedTextField jtf_diaria;
    public static javax.swing.JTextField jtf_nome_cliente;
    private javax.swing.JTextField jtf_nome_objeto1;
    public static javax.swing.JTextField jtf_nome_objeto_locacao;
    private javax.swing.JTextField jtf_preco10;
    private javax.swing.JTextField jtf_preco6;
    private javax.swing.JTextField jtf_preco7;
    private javax.swing.JTextField jtf_preco9;
    private javax.swing.JTextField jtf_quantidade2;
    private javax.swing.JTextField jtf_tipo_midia;
    private javax.swing.JTextField jtf_tipo_midia1;
    private javax.swing.JTextField jtf_valor1;
    private javax.swing.JTextField jtf_valor2;
    private javax.swing.JTextField jtf_valor_locacao;
    public static javax.swing.JTextField jtf_valor_promocao1;
    public static javax.swing.JTextField jtf_valor_total_locacao;
    private javax.swing.JTabbedPane jtp_locacao;
    // End of variables declaration//GEN-END:variables

    private void enviarDadosLocacao() {
        if (verificarCampos() == true) {
            EntradaCaixa entradaCaixa;
            entradaCaixa = new EntradaCaixa();
            entradaCaixa.setVisible(true);
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
                hashDbGrid, valor, copia.getObjeto().getDiaria().getDias(), copia.getStatus()});

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

//            if (jtf_codigo_cliente.getText().equals("")) {
            jtf_nome_cliente.setText(dependente.getNome_dependente());
            jtf_codigo_cliente.setText(String.valueOf(dependente.getCliente().getCodigo_cliente()));
            Moeda moeda = new Moeda();

            String debito;
            debito = moeda.setPrecoFormat(dependente.getDebito());
            jtf_debito_total_locacao.setText(debito);

            jtf_codigo_consulta_locacao.requestFocus();

            //Limpa tabela depois de selecionar novo cliente
            DefaultTableModel tb_locacao = (DefaultTableModel) jtbl_locacao.getModel();
            int rows = tb_locacao.getRowCount();
            for (int i = rows - 1; i >= 0; i--) {
                tb_locacao.removeRow(i);
            }

            jtf_valor_total_locacao.setText("R$ 0,00");
//            }
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

                    copias = copiaDAO.getCopia_codigo_objeto(codigo_objeto);

                    if (copias.size() > 0) {
//                        if (checkCensura(copias.get(0).getObjeto().getCensura(), dependente.getData_nascimento()) == true) {
                        String codigo_barras = verificaTabelaObjeto(copias);

                        if (!codigo_barras.equals("")) {
                            locar_consulta_codigo_barras(codigo_barras);
//                                String assistido_anteriormente;
//                                assistido_anteriormente = copiaDAO.getQuantidadeAssistida(dependente.getCodigo_dependente(), copias.get(0).getCodigo_barras());
//                                if (!"".equals(assistido_anteriormente)) {
//                                    int selectedOption = JOptionPane.showConfirmDialog(this, assistido_anteriormente, "Atenção", JOptionPane.YES_NO_OPTION);
//                                    if (selectedOption == JOptionPane.YES_NO_OPTION) {
//                                        adicionarItemLocado(copias.get(0));
//                                        jtf_codigo_consulta_locacao.requestFocus();
//                                    } else {
//                                        limparItemLocado();
//                                    }
//                                } else {
//                                    adicionarItemLocado(copias.get(0));
//                                    jtf_codigo_consulta_locacao.requestFocus();
//                                }

                        } else {
                            JOptionPane.showMessageDialog(null, "Cópia Indisponível");
                        }
//                        } else {
//                            JOptionPane.showMessageDialog(null, "Filme inapropriado para este Cliente");
//                        }
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
//                JOptionPane.showMessageDialog(null, "Linhas:" + i + " Size: "+ copias.size());                
                for (int x = 0; x < copias.size();) {

                    Copia copiaVerificarTabela = new Copia();

                    copiaVerificarTabela.setCodigo_barras((String) jtbl_locacao.getValueAt(i, 0));

                    tabela = copiaVerificarTabela.getCodigo_barras().equals(copias.get(x).getCodigo_barras());

//                    JOptionPane.showMessageDialog(null, copias.get(x).getCodigo_barras() + " " + tabela + " Posição: " + x);
                    if (tabela == false) {
                        codigo_barras = copias.get(x).getCodigo_barras();
                        break;
                    } else {
//                        JOptionPane.showMessageDialog(null, "Passou pela posição: "+ x);
                        copias.remove(x);
                        x = 0;
                        continue;
                    }
                }
//                    JOptionPane.showMessageDialog(null, "Linhas:" + i + " Size: "+ copias.size());
            }

        }

        return codigo_barras;
    }

}
