package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.controller.SiscomController;
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.ItemLocacao;
import br.com.locadora.model.bean.Objeto;
import br.com.locadora.model.bean.Produto;
import br.com.locadora.model.dao.CopiaDAO;
import br.com.locadora.model.dao.LocacaoDAO;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.LimitadorTexto;
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

public class Atendimento extends javax.swing.JFrame implements Atendimento_InterFace {

    public DecimalFormat formatoPreco;
    public MaskFormatter formatoData;
    public String permissao;
    public Cliente cliente;
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

    public Atendimento() throws SQLException {
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
        jtf_valor = new javax.swing.JTextField();
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
        jcb_bolsa = new javax.swing.JCheckBox();
        jButton7 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        /*try  {          
            Locale BRAZIL = new Locale("pt","BR");  
            DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);
            formatoPreco = new DecimalFormat("¤ ###,###,##0.00",REAL);  
        }    catch (Exception erro)  
        {    
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");  
        }
        */
        jtf_preco8 = new javax.swing.JTextField();
        /*try  {          
            Locale BRAZIL = new Locale("pt","BR");  
            DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);
            formatoPreco = new DecimalFormat("¤ ###,###,##0.00",REAL);  
        }    catch (Exception erro)  
        {    
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");  
        }
        */
        jtf_preco5 = new javax.swing.JTextField();
        jcb_codigo_barras_locacao = new javax.swing.JCheckBox();
        jb_adicionar_locacao = new javax.swing.JButton();
        jb_remover_locacao = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbl_devolucao = new javax.swing.JTable();
        jtf_nome_objeto_devolucao = new javax.swing.JTextField();
        jl_codigo_devolucao = new javax.swing.JLabel();
        jtf_codigo_consulta_devolucao = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jb_adicionar_devolucao = new javax.swing.JButton();
        jb_remover_devolucao = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        /*try  {          
            Locale BRAZIL = new Locale("pt","BR");  
            DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);
            formatoPreco = new DecimalFormat("¤ ###,###,##0.00",REAL);  
        }    catch (Exception erro)  
        {    
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");  
        }
        */
        jtf_preco11 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        /*try  {          
            Locale BRAZIL = new Locale("pt","BR");  
            DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);
            formatoPreco = new DecimalFormat("¤ ###,###,##0.00",REAL);  
        }    catch (Exception erro)  
        {    
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");  
        }
        */
        jtf_preco12 = new javax.swing.JTextField();
        jcb_codigo_barras_devolucao = new javax.swing.JCheckBox();
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

        jp_locacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens"));
        jp_locacao.setName("jp_locacao"); // NOI18N
        jp_locacao.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtf_valor.setEditable(false);
        jtf_valor.setText("R$ 0,00");
        jtf_valor.setName("jtf_valor"); // NOI18N
        jtf_valor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_valorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_valorFocusLost(evt);
            }
        });
        jp_locacao.add(jtf_valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 100, -1));

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
                "Código de Barras", "Nome Objeto", "Valor", "Diária", "Bolsa"
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
        jl_codigo_locacao.setText("Código Cópia");
        jl_codigo_locacao.setName("jl_codigo_locacao"); // NOI18N
        jp_locacao.add(jl_codigo_locacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jtf_codigo_consulta_locacao.setName("jtf_codigo_consulta_locacao"); // NOI18N
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

        jcb_bolsa.setText("Bolsa");
        jcb_bolsa.setName("jcb_bolsa"); // NOI18N
        jcb_bolsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_bolsaActionPerformed(evt);
            }
        });
        jp_locacao.add(jcb_bolsa, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, -1, -1));

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
        jLabel28.setText("Crédito Total");
        jLabel28.setName("jLabel28"); // NOI18N
        jp_locacao.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 130, 30));

        jtf_preco8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jtf_preco8.setText("R$ 0,00");
        jtf_preco8.setName("jtf_preco8"); // NOI18N
        jtf_preco8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_preco8FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_preco8FocusLost(evt);
            }
        });
        jp_locacao.add(jtf_preco8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, 180, 40));

        jtf_preco5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jtf_preco5.setText("R$ 0,00");
        jtf_preco5.setName("jtf_preco5"); // NOI18N
        jtf_preco5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_preco5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_preco5FocusLost(evt);
            }
        });
        jp_locacao.add(jtf_preco5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 180, 40));

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
                "Código de Barras", "Nome Objeto", "Data Locação", "Data Devolução", "Valor Locado", "Valor Multa", "Dia Multa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false
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
            jtbl_devolucao.getColumnModel().getColumn(4).setPreferredWidth(30);
            jtbl_devolucao.getColumnModel().getColumn(5).setPreferredWidth(20);
            jtbl_devolucao.getColumnModel().getColumn(6).setPreferredWidth(20);
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
        jl_codigo_devolucao.setText("Código Cópia");
        jl_codigo_devolucao.setName("jl_codigo_devolucao"); // NOI18N
        jPanel3.add(jl_codigo_devolucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jtf_codigo_consulta_devolucao.setName("jtf_codigo_consulta_devolucao"); // NOI18N
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

        jButton4.setText("Devolver");
        jButton4.setName("jButton4"); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, -1, 40));

        jButton5.setText("Devolver Todos");
        jButton5.setName("jButton5"); // NOI18N
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, -1, 40));

        jButton10.setText("Finalizar");
        jButton10.setName("jButton10"); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 340, 130, 50));

        jb_adicionar_devolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/edit_add.png"))); // NOI18N
        jb_adicionar_devolucao.setToolTipText("Incluir");
        jb_adicionar_devolucao.setName("jb_adicionar_devolucao"); // NOI18N
        jb_adicionar_devolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_adicionar_devolucaoActionPerformed(evt);
            }
        });
        jPanel3.add(jb_adicionar_devolucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 30, 30));

        jb_remover_devolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/edit_remove.png"))); // NOI18N
        jb_remover_devolucao.setToolTipText("Excluir");
        jb_remover_devolucao.setName("jb_remover_devolucao"); // NOI18N
        jb_remover_devolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_remover_devolucaoActionPerformed(evt);
            }
        });
        jPanel3.add(jb_remover_devolucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 30, 30));

        jLabel32.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel32.setText("Total");
        jLabel32.setName("jLabel32"); // NOI18N
        jPanel3.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 60, 30));

        jtf_preco11.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jtf_preco11.setText("R$ 0,00");
        jtf_preco11.setName("jtf_preco11"); // NOI18N
        jtf_preco11.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_preco11FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_preco11FocusLost(evt);
            }
        });
        jPanel3.add(jtf_preco11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 180, 40));

        jLabel33.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel33.setText("Crédito Total");
        jLabel33.setName("jLabel33"); // NOI18N
        jPanel3.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 130, 30));

        jtf_preco12.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jtf_preco12.setText("R$ 0,00");
        jtf_preco12.setName("jtf_preco12"); // NOI18N
        jtf_preco12.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_preco12FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_preco12FocusLost(evt);
            }
        });
        jPanel3.add(jtf_preco12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, 180, 40));

        jcb_codigo_barras_devolucao.setSelected(true);
        jcb_codigo_barras_devolucao.setText("Usar Código de Barras");
        jcb_codigo_barras_devolucao.setName("jcb_codigo_barras_devolucao"); // NOI18N
        jcb_codigo_barras_devolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_codigo_barras_devolucaoActionPerformed(evt);
            }
        });
        jPanel3.add(jcb_codigo_barras_devolucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, 30));

        jtp_locacao.addTab("Devolução", jPanel3);

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
        jPanel1.setBounds(10, 10, 510, 80);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Atendente"));
        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "alencarburiti", "teste\t", "eliesioxavier", "Item 4" }));
        jComboBox1.setName("jComboBox1"); // NOI18N
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/reload.png"))); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        getContentPane().add(jPanel2);
        jPanel2.setBounds(520, 10, 200, 80);

        setSize(new java.awt.Dimension(853, 564));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if (jcb_codigo_barras_locacao.isSelected() == true) {
            jl_codigo_locacao.setText("Código de Barras");
            jtf_codigo_consulta_locacao.requestFocus();
        } else {
            jl_codigo_locacao.setText("Código da Cópia");
            jtf_codigo_consulta_locacao.requestFocus();
        }
        jtf_nome_cliente.requestFocus();

        if (jcb_codigo_barras_devolucao.isSelected() == true) {
            jl_codigo_devolucao.setText("Código de Barras");
            jtf_codigo_consulta_devolucao.requestFocus();
        } else {
            jl_codigo_devolucao.setText("Código da Cópia");
            jtf_codigo_consulta_devolucao.requestFocus();
        }
    }//GEN-LAST:event_formWindowOpened

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
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
    ConsultaClienteAtendimento consultaCliente = new ConsultaClienteAtendimento();
    consultaCliente.setTelaAtendimento(this);
    consultaCliente.janelapai = this;
    consultaCliente.setVisible(true);
    consultaCliente.jtf_consulta.setText(jtf_nome_cliente.getText().trim());
//    setStatusTela(false);
    // TODO add your handling code here:
}//GEN-LAST:event_jb_clienteActionPerformed

private void jtf_nome_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nome_clienteKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        ConsultaClienteAtendimento consultaCliente = new ConsultaClienteAtendimento();
        consultaCliente.setTelaAtendimento(this);;
        consultaCliente.janelapai = this;
        consultaCliente.setVisible(true);
        consultaCliente.jtf_consulta.setText(jtf_nome_cliente.getText().trim());
    }
}//GEN-LAST:event_jtf_nome_clienteKeyPressed

private void jtf_nome_clienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_nome_clienteFocusLost
    jtf_nome_objeto_locacao.requestFocus();
}//GEN-LAST:event_jtf_nome_clienteFocusLost

    private void jtf_preco8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_preco8FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_preco8FocusLost

    private void jtf_preco8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_preco8FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_preco8FocusGained

    private void jtf_preco5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_preco5FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_preco5FocusLost

    private void jtf_preco5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_preco5FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_preco5FocusGained

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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        tbDevolverLinhaSelecionada(jtbl_devolucao);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ConsultaCopiaDevolucao copiaDevolucao = new ConsultaCopiaDevolucao();
        copiaDevolucao.setTelaAtendimento(this);
        copiaDevolucao.janelapai = this;
        copiaDevolucao.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jtf_nome_objeto_devolucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nome_objeto_devolucaoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nome_objeto_devolucaoKeyPressed

    private void jtf_nome_objeto_devolucaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_nome_objeto_devolucaoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nome_objeto_devolucaoFocusGained

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        enviarDadosLocacao();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jcb_bolsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_bolsaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_bolsaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ConsultaCopiaLocacao copiaCliente = new ConsultaCopiaLocacao();
        copiaCliente.setTelaAtendimento(this);
        copiaCliente.janelapai = this;
        copiaCliente.setVisible(true);
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

    private void jtf_valorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valorFocusLost
        jtf_valor.setText(setPrecoFormat(jtf_valor.getText()));
    }//GEN-LAST:event_jtf_valorFocusLost

    private void jtf_valorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valorFocusGained
        jtf_valor.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (jtf_valor.getText().trim().equals("RS")) {
                    JOptionPane.showMessageDialog(null, "Informe o preço");
                    jtf_valor.requestFocus();
                    return false;
                } else {
                    jtf_tipo_midia.requestFocus();
                    return true;
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valorFocusGained

    private void jtf_valor2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor2FocusGained

    private void jtf_valor2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor2FocusLost

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        enviarDadosDevolucao();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

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

    private void jb_adicionar_devolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_adicionar_devolucaoActionPerformed
        adicionarItemDevolvido(itemDevolucao);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_adicionar_devolucaoActionPerformed

    private void jb_remover_devolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_remover_devolucaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_remover_devolucaoActionPerformed

    private void jtf_preco11FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_preco11FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_preco11FocusGained

    private void jtf_preco11FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_preco11FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_preco11FocusLost

    private void jtf_preco12FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_preco12FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_preco12FocusGained

    private void jtf_preco12FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_preco12FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_preco12FocusLost

    private void jcb_codigo_barras_locacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_codigo_barras_locacaoActionPerformed
        if (jcb_codigo_barras_locacao.isSelected() == true) {
            jl_codigo_locacao.setText("Código de Barras");
            jtf_codigo_consulta_locacao.requestFocus();
        } else {
            jl_codigo_locacao.setText("Código da Cópia");
            jtf_codigo_consulta_locacao.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_codigo_barras_locacaoActionPerformed

    private void jtf_codigo_consulta_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_codigo_consulta_locacaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (jcb_codigo_barras_locacao.isSelected() == true) {
                locar_consulta_codigo_barras(jtf_codigo_consulta_locacao.getText().trim());
            } else {

            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_codigo_consulta_locacaoKeyPressed

    private void jcb_codigo_barras_devolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_codigo_barras_devolucaoActionPerformed
        if (jcb_codigo_barras_devolucao.isSelected() == true) {
            jl_codigo_devolucao.setText("Código de Barras");
            jtf_codigo_consulta_devolucao.requestFocus();
        } else {
            jl_codigo_devolucao.setText("Código da Cópia");
            jtf_codigo_consulta_devolucao.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_codigo_barras_devolucaoActionPerformed

    private void jtf_codigo_consulta_devolucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_codigo_consulta_devolucaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (jcb_codigo_barras_devolucao.isSelected() == true) {
                devolver_consulta_codigo_barras(jtf_codigo_consulta_devolucao.getText().trim());
            } else {

            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_codigo_consulta_devolucaoKeyPressed
    public static boolean validaData(String dataString) throws java.text.ParseException {

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
        return (true);
    }
    public void checarFilmeLocado(){
        try {
            pool = new Pool();
            CopiaDAO copiaDAO = new CopiaDAO(pool);
            copias = null;
            Integer quantidade_locado;
            quantidade_locado = copiaDAO.checarFilme(Integer.parseInt(jtf_codigo_cliente.getText()),jtf_codigo_consulta_locacao.getText());
            if (quantidade_locado > 0) {
                carregarCopiaLocacao(copias.get(0));
            } else {
                int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
                if (selectedOption == JOptionPane.YES_NO_OPTION) {
                
                }
                JOptionPane.showMessageDialog(null, "Código de Barra inválido");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Atendimento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private TelaPrincipal_Interface telaPrincipal;

    public void setTelaPrincipal(TelaPrincipal_Interface telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
    }

    private void buscarDadosLocacao() {
        controller = new SiscomController();
        controller.processarRequisicao("consultarLocacao");
    }

    public boolean validaDataVencimento(String dataString) throws ParseException {
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
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new Atendimento().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Atendimento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable3;
    private javax.swing.JButton jb_adicionar2;
    private javax.swing.JButton jb_adicionar_devolucao;
    private javax.swing.JButton jb_adicionar_locacao;
    private javax.swing.JButton jb_adicionar_locacao1;
    private javax.swing.JButton jb_cliente;
    private javax.swing.JButton jb_eliminar2;
    private javax.swing.JButton jb_remover_devolucao;
    private javax.swing.JButton jb_remover_locacao;
    private javax.swing.JButton jb_remover_locacao1;
    private javax.swing.JCheckBox jcb_bolsa;
    private javax.swing.JCheckBox jcb_codigo_barras_devolucao;
    private javax.swing.JCheckBox jcb_codigo_barras_locacao;
    private javax.swing.JFormattedTextField jftf_vencimento2;
    private javax.swing.JLabel jl_codigo_devolucao;
    private javax.swing.JLabel jl_codigo_locacao;
    public static javax.swing.JPanel jp_locacao;
    private javax.swing.JPanel jp_locacao1;
    public static javax.swing.JTable jtbl_devolucao;
    public static javax.swing.JTable jtbl_locacao;
    public static javax.swing.JTable jtbl_venda;
    public static javax.swing.JTextField jtf_codigo_cliente;
    private javax.swing.JTextField jtf_codigo_consulta_devolucao;
    private javax.swing.JTextField jtf_codigo_consulta_locacao;
    private javax.swing.JTextField jtf_codigo_copia1;
    private javax.swing.JTextField jtf_codigo_objeto;
    private javax.swing.JTextField jtf_descricao_objeto;
    private javax.swing.JFormattedTextField jtf_diaria;
    public static javax.swing.JTextField jtf_nome_cliente;
    private javax.swing.JTextField jtf_nome_objeto1;
    private javax.swing.JTextField jtf_nome_objeto_devolucao;
    public static javax.swing.JTextField jtf_nome_objeto_locacao;
    private javax.swing.JTextField jtf_preco10;
    private javax.swing.JTextField jtf_preco11;
    private javax.swing.JTextField jtf_preco12;
    private javax.swing.JTextField jtf_preco5;
    private javax.swing.JTextField jtf_preco6;
    private javax.swing.JTextField jtf_preco7;
    private javax.swing.JTextField jtf_preco8;
    private javax.swing.JTextField jtf_preco9;
    private javax.swing.JTextField jtf_quantidade2;
    private javax.swing.JTextField jtf_tipo_midia;
    private javax.swing.JTextField jtf_tipo_midia1;
    private javax.swing.JTextField jtf_valor;
    private javax.swing.JTextField jtf_valor1;
    private javax.swing.JTextField jtf_valor2;
    public static javax.swing.JTextField jtf_valor_promocao1;
    private javax.swing.JTabbedPane jtp_locacao;
    // End of variables declaration//GEN-END:variables

    private void enviarDadosLocacao() {
        if (verificarCampos() == true) {
            controller = new SiscomController();
            controller.processarRequisicao("cadastrarLocacao");
//            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
        }
        DefaultTableModel tb_locacao = (DefaultTableModel) Atendimento.jtbl_locacao.getModel();
        int rows = tb_locacao.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            tb_locacao.removeRow(i);
        }
    }

    private void enviarDadosDevolucao() {
        if (verificarCampos() == true) {
            controller = new SiscomController();
            controller.processarRequisicao("cadastrarDevolucao");
//            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
        }
        DefaultTableModel tb_devolucao = (DefaultTableModel) Atendimento.jtbl_devolucao.getModel();
        int rows = tb_devolucao.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            tb_devolucao.removeRow(i);
        }

    }

    public void setJanelaPai(TelaPrincipal janelapai) {
        this.janelapai = janelapai;
        permissao = janelapai.permissao;
    }

    public void limparCampos() {
        jtf_codigo_cliente.setText("");
        jtf_codigo_consulta_locacao.setText("");
        jtf_valor.setText("");
        jtf_tipo_midia.setText("");
        jtf_diaria.setText("");
    }

    private void excluirProduto() {
        removeProduto(jtbl_locacao);
    }

    public void removeProduto(JTable tb) {
        DefaultTableModel row = (DefaultTableModel) jtbl_locacao.getModel();
        if (tb.getSelectedRow() != -1) {
            int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
            if (selectedOption == JOptionPane.YES_NO_OPTION) {
                row.removeRow(tb.getSelectedRow());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto");
        }
    }

    public Double getPrecoFormato(String preco) {
        Double precoFormatado = 0.0;
        try {
            preco = preco.replace("R", "");
            preco = preco.replace("$", "");
            preco = preco.replace(",", ".");
            preco = preco.replace(" ", "");
            precoFormatado = Double.parseDouble(preco.trim());

            //this.objFuncionario.setSalario(getSalarioFormat(jTSalario.getText())); pegar valor em double
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Valor Informado Incorreto!\nInforme um valor com o seguinte formato:\nEx: 100,00");
        }
        return precoFormatado;
    }

    public String setPrecoFormat(String preco) {
        DecimalFormat dFormat = new DecimalFormat();
        dFormat.applyPattern("R$ #0.00");
        return dFormat.format(getPrecoFormato(preco));
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
            valor = String.valueOf(copia.getObjeto().getDiaria().getValor());
            valor = setPrecoFormat(valor);

            DefaultTableModel row = (DefaultTableModel) jtbl_locacao.getModel();
            ItemDbGrid hashDbGrid = new ItemDbGrid(copia, copia.getObjeto().getDescricao_objeto());
            row.addRow(new Object[]{copia.getCodigo_barras(),
                hashDbGrid, valor, copia.getObjeto().getDiaria().getDias(), copia.getStatus()});

            copiasLocacao.add(copia);
            limparItemLocado();
            jtf_codigo_consulta_locacao.requestFocus();
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel adicionar ");
        }
    }

    public void adicionarItemDevolvido(ItemLocacao itemLocacao) {

        try {
            SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

            String data_locacao;
            data_locacao = out.format(in.parse(itemLocacao.getData_locacao().toString()));

            DefaultTableModel row = (DefaultTableModel) Atendimento.jtbl_devolucao.getModel();
            ItemDbGrid hashDbGrid = new ItemDbGrid(itemLocacao, itemLocacao.getCopia().getObjeto().getDescricao_objeto());
            row.addRow(new Object[]{itemLocacao.getCopia().getCodigo_barras(), hashDbGrid, data_locacao, "", itemLocacao.getValor_multa(),
                itemLocacao.getValor_multa(), itemLocacao.getDias_multa()});

            itensDevolucao.add(itemLocacao);
            limparItemDevolvido();
        } catch (ParseException ex) {
            Logger.getLogger(Atendimento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void limparItemDevolvido() {
        jtf_nome_objeto_devolucao.setText("");
        jtf_codigo_consulta_devolucao.setText("");
        jtf_nome_objeto_devolucao.requestFocus();
        jtf_codigo_consulta_devolucao.requestFocus();
    }

    public void limparItemLocado() {
        jtf_valor.setText("R$");
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
        this.copiaLocacao = copia;

        if (jcb_codigo_barras_locacao.isSelected() == true) {
            jtf_codigo_consulta_locacao.setText(copiaLocacao.getCodigo_barras());
        } else {
            jtf_codigo_consulta_locacao.setText(String.valueOf(copiaLocacao.getCodigo_copia()));
        }

        jtf_nome_objeto_locacao.setText(copiaLocacao.getObjeto().getDescricao_objeto());

        jtf_diaria.setText(String.valueOf(copiaLocacao.getObjeto().getDiaria().getDias()));

        String valor;
        valor = String.valueOf(copiaLocacao.getObjeto().getDiaria().getValor());
        valor = setPrecoFormat(valor);

        jtf_valor.setText(valor);
        jtf_tipo_midia.setText(copiaLocacao.getObjeto().getTipo_midia());
        
        jb_adicionar_locacao.requestFocus();

    }

    public void carregarCopiaDevolucao(ItemLocacao itemDev) {

        this.itemDevolucao = itemDev;
        if (jcb_codigo_barras_devolucao.isSelected() == true) {
            jtf_codigo_consulta_devolucao.setText(itemDevolucao.getCopia().getCodigo_barras());
        } else {
            jtf_codigo_consulta_devolucao.setText(String.valueOf(itemDevolucao.getCopia().getCodigo_copia()));
        }
        jtf_nome_objeto_devolucao.setText(itemDevolucao.getCopia().getObjeto().getDescricao_objeto());

    }

    public void carregaCliente(Cliente cliente) {
        this.cliente = cliente;
        jtf_nome_cliente.setText(cliente.getNome_cliente());
        jtf_codigo_cliente.setText(String.valueOf(cliente.getCodigo_cliente()));

        //Limpa tabela depois de selecionar novo cliente
        DefaultTableModel tb_devolucao = (DefaultTableModel) Atendimento.jtbl_devolucao.getModel();
        int rows = tb_devolucao.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            tb_devolucao.removeRow(i);
        }
        jtf_codigo_consulta_locacao.requestFocus();
    }

    public void setStatusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);

    }

    public void setRequestDiaria() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setRequestGenero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void locar_consulta_codigo_barras(String codigo_barras) {
        
        
        
            
            
        
        
        try {
            pool = new Pool();
            Integer quantidade_locado;
            copias = null;
            
            CopiaDAO copiaDAO = new CopiaDAO(pool);
            
            quantidade_locado = copiaDAO.checarFilme(Integer.parseInt(jtf_codigo_cliente.getText()),jtf_codigo_consulta_locacao.getText());
            if (quantidade_locado > 0) {
                int selectedOption = JOptionPane.showConfirmDialog(this, "Cliente já assistiu " + quantidade_locado+ ". Deseja locar novamente ?", "Atenção", JOptionPane.YES_NO_OPTION);
                if (selectedOption == JOptionPane.YES_NO_OPTION) {
                    copias = copiaDAO.getCopia_codigo_barras(codigo_barras);
                    if (copias.size() > 0) {
                        carregarCopiaLocacao(copias.get(0));
                    } else {
                        JOptionPane.showMessageDialog(null, "Código de Barra inválido");
                    }
                } else{
                    
                }                
            } else {
                copias = copiaDAO.getCopia_codigo_barras(codigo_barras);
                if (copias.size() > 0) {
                    carregarCopiaLocacao(copias.get(0));
                } else {
                    JOptionPane.showMessageDialog(null, "Código de Barra inválido");
                }                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Atendimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void devolver_consulta_codigo_barras(String codigo_barras) {
        try {
            pool = new Pool();
            LocacaoDAO locacaoDAO = new LocacaoDAO(pool);

            itemDevolucao = new ItemLocacao();
            itemDevolucao = locacaoDAO.getLocacao_codigo_barras(codigo_barras);

            if (itemDevolucao != null) {
                carregarCopiaDevolucao(itemDevolucao);
                jb_adicionar_devolucao.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Código de Barra inválido");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas com a consulta");
            ex.printStackTrace();
        }
    }

    public void tbDevolverLinhaSelecionada(JTable tb) {
        ItemLocacao item_selecionado = null;
        if (tb.getSelectedRow() != -1) {
            item_selecionado = new ItemLocacao();
            item_selecionado.setData_devolucao(data);

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            dateFormat.format(date);

            DefaultTableModel row = (DefaultTableModel) Atendimento.jtbl_devolucao.getModel();
            row.setValueAt(dateFormat.format(date), jtbl_devolucao.getSelectedRow(), 3);
        }
    }
}
