package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.controller.SiscomController;
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.FornecedorModel;
import br.com.locadora.model.bean.ItemLocacao;
import br.com.locadora.model.bean.Objeto;
import br.com.locadora.model.bean.Produto;
import br.com.locadora.model.dao.FornecedorDAO;
import br.com.locadora.util.Data;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.LimitadorTexto;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class Atendimento extends javax.swing.JFrame implements Atendimento_InterFace {

    public FornecedorModel objfornecedor;
    public DecimalFormat formatoPreco;
    public MaskFormatter formatoData;
    public ListSelectionModel lsmItem;
    public String permissao;
    public Copia copia;
    public static List<ItemLocacao> itemLocacaoes;

    public Atendimento() throws SQLException {
        initComponents();
        Data mostraData = new Data();
        mostraData.le_data();        
        jftf_data_locacao.setText(mostraData.dia + "/" + mostraData.mes + "/" + mostraData.ano);
    }

    public void setTela(String permissao) {
        if (permissao.equals("usuario")) {
            jb_fornecedor.setEnabled(false);
        } else {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jb_salvar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
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
        jb_adicionar_locacao = new javax.swing.JButton();
        jb_remover_locacao = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_locacao = new javax.swing.JTable();
        jtf_nome_objeto = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jtf_codigo_copia = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        /*try  {          
            Locale BRAZIL = new Locale("pt","BR");  
            DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);
            formatoPreco = new DecimalFormat("¤ ###,###,##0.00",REAL);  
        }    catch (Exception erro)  
        {    
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");  
        }
        */
        jtf_valor_promocao = new javax.swing.JTextField();
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
        jLabel9 = new javax.swing.JLabel();
        try  {
            formatoData = new MaskFormatter("##/##/####");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");
        }
        jftf_data_locacao = new JFormattedTextField(formatoData);
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbl_devolucao = new javax.swing.JTable();
        jtf_nome_objeto_devolucao = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jtf_codigo_copia_devolucao = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
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
        jb_fornecedor = new javax.swing.JButton();

        jDesktopPane1.setName("jDesktopPane1"); // NOI18N
        jDesktopPane1.setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Locacao");
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

        jb_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/gravar_registro.gif"))); // NOI18N
        jb_salvar.setText("Salvar");
        jb_salvar.setName("jb_salvar"); // NOI18N
        jb_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_salvarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_salvar);
        jb_salvar.setBounds(680, 10, 76, 35);

        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/exit.png"))); // NOI18N
        jb_cancelar.setText("Cancelar");
        jb_cancelar.setName("jb_cancelar"); // NOI18N
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_cancelar);
        jb_cancelar.setBounds(780, 10, 89, 35);

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
        jp_locacao.add(jtf_valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 80, -1));

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
        jp_locacao.add(jtf_tipo_midia, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 70, -1));

        jtf_diaria.setEditable(false);
        jtf_diaria.setName("jtf_diaria"); // NOI18N
        jp_locacao.add(jtf_diaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 70, -1));

        jb_adicionar_locacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/edit_add.png"))); // NOI18N
        jb_adicionar_locacao.setToolTipText("Incluir");
        jb_adicionar_locacao.setName("jb_adicionar_locacao"); // NOI18N
        jb_adicionar_locacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_adicionar_locacaoActionPerformed(evt);
            }
        });
        jp_locacao.add(jb_adicionar_locacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 30, 30));

        jb_remover_locacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/edit_remove.png"))); // NOI18N
        jb_remover_locacao.setToolTipText("Excluir");
        jb_remover_locacao.setName("jb_remover_locacao"); // NOI18N
        jb_remover_locacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_remover_locacaoActionPerformed(evt);
            }
        });
        jp_locacao.add(jb_remover_locacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 30, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Nome Objeto");
        jLabel3.setName("jLabel3"); // NOI18N
        jp_locacao.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 300, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText("Valor");
        jLabel5.setName("jLabel5"); // NOI18N
        jp_locacao.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 50, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setText("Tipo Mídia");
        jLabel6.setName("jLabel6"); // NOI18N
        jp_locacao.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 70, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel13.setText("Diária");
        jLabel13.setName("jLabel13"); // NOI18N
        jp_locacao.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jtbl_locacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Cópia", "Código Interno", "Nome Objeto", "Valor", "Valor Promocional", "Diária", "Bolsa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false
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
            jtbl_locacao.getColumnModel().getColumn(1).setHeaderValue("Código Interno");
            jtbl_locacao.getColumnModel().getColumn(2).setPreferredWidth(150);
            jtbl_locacao.getColumnModel().getColumn(3).setPreferredWidth(30);
            jtbl_locacao.getColumnModel().getColumn(4).setPreferredWidth(30);
            jtbl_locacao.getColumnModel().getColumn(5).setPreferredWidth(30);
            jtbl_locacao.getColumnModel().getColumn(6).setPreferredWidth(20);
        }

        jp_locacao.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 780, 200));

        jtf_nome_objeto.setName("jtf_nome_objeto"); // NOI18N
        jtf_nome_objeto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_nome_objetoFocusGained(evt);
            }
        });
        jtf_nome_objeto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_nome_objetoKeyPressed(evt);
            }
        });
        jp_locacao.add(jtf_nome_objeto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 410, -1));

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel14.setText("Código Cópia");
        jLabel14.setName("jLabel14"); // NOI18N
        jp_locacao.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jtf_codigo_copia.setName("jtf_codigo_copia"); // NOI18N
        jp_locacao.add(jtf_codigo_copia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 80, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pesquisar.png"))); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jp_locacao.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 30, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel8.setText("Valor Promocional");
        jLabel8.setName("jLabel8"); // NOI18N
        jp_locacao.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 110, -1));

        jtf_valor_promocao.setEditable(false);
        jtf_valor_promocao.setText("R$ 0,00");
        jtf_valor_promocao.setName("jtf_valor_promocao"); // NOI18N
        jtf_valor_promocao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_valor_promocaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_valor_promocaoFocusLost(evt);
            }
        });
        jp_locacao.add(jtf_valor_promocao, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 80, -1));

        jcb_bolsa.setText("Bolsa");
        jcb_bolsa.setName("jcb_bolsa"); // NOI18N
        jcb_bolsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_bolsaActionPerformed(evt);
            }
        });
        jp_locacao.add(jcb_bolsa, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, -1));

        jButton7.setText("Finalizar");
        jButton7.setName("jButton7"); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jp_locacao.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, -1, -1));

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

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel9.setText("Data/Hora da Locação");
        jLabel9.setName("jLabel9"); // NOI18N
        jp_locacao.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 170, 10));

        jftf_data_locacao.setName("jftf_data_locacao"); // NOI18N
        jp_locacao.add(jftf_data_locacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 100, -1));

        jtp_locacao.addTab("Locação", jp_locacao);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens"));
        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("Nome Objeto");
        jLabel4.setName("jLabel4"); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 300, -1));

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        jtbl_devolucao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Código Interno", "Objeto", "Devolvido", "Data", "Valor Locado", "Valor Multa", "Dia Multa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, true, true
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
            jtbl_devolucao.getColumnModel().getColumn(0).setResizable(false);
            jtbl_devolucao.getColumnModel().getColumn(0).setPreferredWidth(20);
            jtbl_devolucao.getColumnModel().getColumn(1).setResizable(false);
            jtbl_devolucao.getColumnModel().getColumn(1).setPreferredWidth(20);
            jtbl_devolucao.getColumnModel().getColumn(2).setPreferredWidth(150);
            jtbl_devolucao.getColumnModel().getColumn(3).setPreferredWidth(30);
            jtbl_devolucao.getColumnModel().getColumn(4).setPreferredWidth(30);
            jtbl_devolucao.getColumnModel().getColumn(5).setPreferredWidth(30);
        }

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 770, 200));

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
        jPanel3.add(jtf_nome_objeto_devolucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 410, -1));

        jLabel18.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel18.setText("Código Cópia");
        jLabel18.setName("jLabel18"); // NOI18N
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jtf_codigo_copia_devolucao.setEditable(false);
        jtf_codigo_copia_devolucao.setName("jtf_codigo_copia_devolucao"); // NOI18N
        jPanel3.add(jtf_codigo_copia_devolucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 80, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pesquisar.png"))); // NOI18N
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 30, -1));

        jButton4.setText("Devolver");
        jButton4.setName("jButton4"); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jButton5.setText("Devolver Todos");
        jButton5.setName("jButton5"); // NOI18N
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, -1, -1));

        jButton6.setText("Locações Abertas");
        jButton6.setName("jButton6"); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 180, 40));

        jButton10.setText("Finalizar");
        jButton10.setName("jButton10"); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, -1, -1));

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
        jtp_locacao.setBounds(30, 120, 850, 450);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("Código ");
        jLabel1.setName("jLabel1"); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 100, -1));

        jtf_codigo_cliente.setEditable(false);
        jtf_codigo_cliente.setName("jtf_codigo_cliente"); // NOI18N
        jPanel1.add(jtf_codigo_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 88, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel10.setText("Cliente");
        jLabel10.setName("jLabel10"); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        jtf_nome_cliente.setEditable(false);
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
        jPanel1.add(jtf_nome_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 450, -1));

        jb_fornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pesquisar.png"))); // NOI18N
        jb_fornecedor.setName("jb_fornecedor"); // NOI18N
        jb_fornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_fornecedorActionPerformed(evt);
            }
        });
        jPanel1.add(jb_fornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 30, -1));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 20, 620, 90);

        setSize(new java.awt.Dimension(919, 621));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void jb_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salvarActionPerformed

}//GEN-LAST:event_jb_salvarActionPerformed

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        ((DefaultTableModel) jtbl_locacao.getModel()).setRowCount(0);
        jtbl_locacao.updateUI();
        this.setVisible(false);
}//GEN-LAST:event_jb_cancelarActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
    }//GEN-LAST:event_formKeyReleased
    Produto produtoCombo;
    FornecedorModel fornecedorCombo;
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ((DefaultTableModel) jtbl_locacao.getModel()).setRowCount(0);
        jtbl_locacao.updateUI();
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

private void jb_fornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_fornecedorActionPerformed
    ConsultaClienteAtendimento consultaCliente = new ConsultaClienteAtendimento();
    consultaCliente.setTelaAtendimento(this);
    consultaCliente.janelapai = this;
    consultaCliente.setVisible(true);
//    setStatusTela(false);
    // TODO add your handling code here:
}//GEN-LAST:event_jb_fornecedorActionPerformed

private void jtf_nome_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nome_clienteKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        ConsultaClienteAtendimento consultaCliente = new ConsultaClienteAtendimento();
        consultaCliente.setTelaAtendimento(this);;
        consultaCliente.janelapai = this;
        consultaCliente.setVisible(true);
    }
    if (evt.getKeyCode() == KeyEvent.VK_TAB) {
//        ConsultaDiariaObjeto forn = new ConsultaDiariaObjeto();
//        forn.setTelaCadNota(this);;
//        forn.janelapai = this;
//        forn.listaFornecedor(jtf_nome_cliente.getText().trim());
//        forn.setVisible(true);
//        setStatusTela(false);
    }
    // TODO add your handling code here:
}//GEN-LAST:event_jtf_nome_clienteKeyPressed

private void jtf_nome_clienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_nome_clienteFocusLost
    jtf_nome_objeto.requestFocus();
    // TODO add your handling code here:
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
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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

    private void jtf_valor_promocaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_promocaoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_promocaoFocusLost

    private void jtf_valor_promocaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_promocaoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_promocaoFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ConsultaCopiaAtendimento copiaCliente = new ConsultaCopiaAtendimento();
        copiaCliente.setTelaAtendimento(this);
        copiaCliente.janelapai = this;
        copiaCliente.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtf_nome_objetoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nome_objetoKeyPressed
        //        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //            ProdutoConsultarGUI conProduto = new ProdutoConsultarGUI();
            //            conProduto.setTelaCadNota(this);;
            //            conProduto.janelapai = this;
            //            conProduto.listaProduto(jtf_nome_objeto.getText().trim());
            //            conProduto.setVisible(true);
            //            setStatusTela(false);
            //        }
        //        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            //            ProdutoConsultarGUI conProduto = new ProdutoConsultarGUI();
            //            conProduto.setTelaCadNota(this);;
            //            conProduto.janelapai = this;
            //            conProduto.listaProduto(jtf_nome_objeto.getText().trim());
            //            conProduto.setVisible(true);
            //            setStatusTela(false);
            //        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nome_objetoKeyPressed

    private void jtf_nome_objetoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_nome_objetoFocusGained
        jtf_nome_objeto.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (jtf_nome_objeto.getText().trim().equals("")) {

                    return false;
                } else {
                    return true;
                }
            }
        });

        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nome_objetoFocusGained

    private void jb_remover_locacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_remover_locacaoActionPerformed
        excluirProduto();
    }//GEN-LAST:event_jb_remover_locacaoActionPerformed

    private void jb_adicionar_locacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_adicionar_locacaoActionPerformed

        try {
            alimentarItens(copia);
        } catch (ParseException ex) {
            Logger.getLogger(Atendimento.class.getName()).log(Level.SEVERE, null, ex);
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

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        buscarDadosLocacao();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed
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
    private TelaPrincipal_Interface telaPrincipal;

    public void setTelaPrincipal(TelaPrincipal_Interface telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
    }
    private void buscarDadosLocacao() {        
        JOptionPane.showMessageDialog(null, "Teste");
        controller = new SiscomController();
        controller.processarRequisicao("consultarLocacao");  
        JOptionPane.showMessageDialog(null, "Teste");
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
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable3;
    private javax.swing.JButton jb_adicionar2;
    private javax.swing.JButton jb_adicionar_locacao;
    private javax.swing.JButton jb_adicionar_locacao1;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_eliminar2;
    private javax.swing.JButton jb_fornecedor;
    private javax.swing.JButton jb_remover_locacao;
    private javax.swing.JButton jb_remover_locacao1;
    private javax.swing.JButton jb_salvar;
    private javax.swing.JCheckBox jcb_bolsa;
    public static javax.swing.JFormattedTextField jftf_data_locacao;
    private javax.swing.JFormattedTextField jftf_vencimento2;
    public static javax.swing.JPanel jp_locacao;
    private javax.swing.JPanel jp_locacao1;
    public static javax.swing.JTable jtbl_devolucao;
    public static javax.swing.JTable jtbl_locacao;
    public static javax.swing.JTable jtbl_venda;
    public static javax.swing.JTextField jtf_codigo_cliente;
    private javax.swing.JTextField jtf_codigo_copia;
    private javax.swing.JTextField jtf_codigo_copia1;
    private javax.swing.JTextField jtf_codigo_copia_devolucao;
    private javax.swing.JTextField jtf_codigo_objeto;
    private javax.swing.JTextField jtf_descricao_objeto;
    private javax.swing.JFormattedTextField jtf_diaria;
    public static javax.swing.JTextField jtf_nome_cliente;
    private javax.swing.JTextField jtf_nome_objeto;
    private javax.swing.JTextField jtf_nome_objeto1;
    private javax.swing.JTextField jtf_nome_objeto_devolucao;
    private javax.swing.JTextField jtf_preco10;
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
    public static javax.swing.JTextField jtf_valor_promocao;
    public static javax.swing.JTextField jtf_valor_promocao1;
    private javax.swing.JTabbedPane jtp_locacao;
    // End of variables declaration//GEN-END:variables
    public Cliente cliente;
    public Objeto objeto;

    public InterfacePool pool;
    public SiscomController controller;

    private void enviarDadosLocacao() {
//        if (verificarCampos()) {
        controller = new SiscomController();
        controller.processarRequisicao("cadastrarLocacao");
        JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
//            retornaJanelaPai();
//        }
    }

//    public boolean validaNota(EntradaModel entrada) {
//        List<EntradaModel> entradas = new ArrayList();
//        EntradaDAO entr = new EntradaDAO();
//        entradas = entr.validarNota(entrada);
//        if (entradas.size() == 0) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//     EntradaCadastraGUI_Interface TelaEntrada;
//
//     public void setTelaEntradaGUI(EntradaCadastraGUI_Interface TelaEntrada){
//        this.TelaEntrada = TelaEntrada;
//    }
    Produto produto;

    public void setJanelaPai(TelaPrincipal janelapai) {

        janelapai = janelapai;
        permissao = janelapai.permissao;

    }

    public void limparCampos() {
        jtf_codigo_cliente.setText("");
        jtf_codigo_copia.setText("");
        jtf_valor.setText("");
        jtf_valor_promocao.setText("");
        jtf_tipo_midia.setText("");
        jtf_diaria.setText("");
//        jcb_produto.requestFocus();
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

    public boolean verificaCampos() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_codigo_cliente.getText().equals("")) {
            msgERRO = msgERRO + " *Fornecedor\n";
        }

        if (jtbl_locacao.getRowCount() == 0) {
            msgERRO = msgERRO + " *Adicione pelo menos 1 Produto\n";
        }
        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            jtf_nome_objeto.requestFocus();
            return false;
        } else {
            return true;
        }
    }
    List<Produto> produtos;
//    public void listarProduto() {
//        ProdutoDAO prod = new ProdutoDAO();
//        produtos = prod.listarProdutos();
//        mostraProdutos(produtos);
//
//    }
//
//    public void mostraProdutos(List<ProdutoModel> produtos){
////       if(jcb_produto.getSelectedIndex()==0){
////           
////       }
//        //jcb_produto.removeAllItems();
//        if (produtos.size() == 0 ){
//           JOptionPane.showMessageDialog(this,"Nenhum produto encontrado");
//
//        } else {
//            for(int i = 0; i<produtos.size(); i++){//ou i<destino.size() para retornar todos
//                Produto produtoModel = new Produto();
//                produtoModel.setCod_produto(produtos.get(i).getCod_produto());
//                produtoModel.setNome_produto(produtos.get(i).getNome_produto());
//                produtoModel.setConcentraçao(produtos.get(i).getConcentraçao());
//                produtoModel.setEstoque(produtos.get(i).getEstoque());
//                produtoModel.setEstoque_ideal(produtos.get(i).getEstoque_ideal());
//                produtoModel.setEstoque_minimo(produtos.get(i).getEstoque_minimo());
//                produtoModel.setGrupo(produtos.get(i).getGrupo());;
//                produtoModel.setUnidade(produtos.get(i).getUnidade());
//                produtoModel.setUltimo_preco(produtos.get(i).getUltimo_preco());
//                ItemDbGrid hashDbGrid = new ItemDbGrid(produtoModel, produtoModel.getNome_produto());
//                jcb_produto.addItem(hashDbGrid);
////                S20BinaryLookup  teste = new S20BinaryLookup(jcb_produto);
//                AutoCompletion auto = new AutoCompletion(jcb_produto);
//
//            }
//         }
//     }
    List<FornecedorModel> fornecedores;

    public void listarFornecedor() {
        FornecedorDAO forn = new FornecedorDAO();
        fornecedores = forn.listarForncedores();
        mostraFornecedores(fornecedores);

    }

    public void mostraFornecedores(List<FornecedorModel> fornecedores) {
//        jcb_fornecedor.removeAllItems();
        if (fornecedores.size() == 0) {
            JOptionPane.showMessageDialog(this, "Nenhum fornecedor encontrado");

        } else {
            for (int i = 0; i < fornecedores.size(); i++) {
                FornecedorModel fornecedorModel = new FornecedorModel();
                fornecedorModel.setCod_fornecedor(fornecedores.get(i).getCod_fornecedor());
                fornecedorModel.setRazao_social(fornecedores.get(i).getRazao_social());
                fornecedorModel.setNome_fantasia(fornecedores.get(i).getNome_fantasia());
                fornecedorModel.setEndereço(fornecedores.get(i).getEndereço());
                fornecedorModel.setCNPJ(fornecedores.get(i).getCNPJ());
                fornecedorModel.setTelefone(fornecedores.get(i).getTelefone());
                fornecedorModel.setFax(fornecedores.get(i).getFax());
                fornecedorModel.setCidade(fornecedores.get(i).getCidade());
                fornecedorModel.setCEP(fornecedores.get(i).getCEP());
                fornecedorModel.setEstado(fornecedores.get(i).getEstado());
                fornecedorModel.setInsc_municipal(fornecedores.get(i).getInsc_municipal());
                fornecedorModel.setInsc_estadual(fornecedores.get(i).getInsc_estadual());
                fornecedorModel.setNome_vendedor(fornecedores.get(i).getNome_vendedor());
                fornecedorModel.setTel_vendedor(fornecedores.get(i).getTel_vendedor());

                ItemDbGrid hashDbGrid = new ItemDbGrid(fornecedorModel, fornecedorModel.getRazao_social());
//            jcb_fornecedor.addItem(hashDbGrid);
                //    AutoCompletion auto = new AutoCompletion(jcb_fornecedor);
            }
        }
    }

    public boolean verificarItem() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_codigo_copia.getText().equals("")) {
            msgERRO = msgERRO + " *Produto\n";
        }

        if (jtf_valor.getText().equals("R$")) {
            msgERRO = msgERRO + " *Preço\n";
        }
        if (jtf_tipo_midia.getText().equals("")) {
            msgERRO = msgERRO + " *Quantidade\n";
        }
        if (jtf_diaria.getText().equals("  /  /    ")) {
            msgERRO = msgERRO + " *Vencimento\n";
        }

        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            jtf_nome_objeto.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public void alimentarItens(Copia copia) throws ParseException {
//        if (verificarItem() && (verificaTabela() == true)) {

        String valor = null;
        String valor_promocao = null;

        valor = String.valueOf(copia.getObjeto().getDiaria().getValor());
        valor_promocao = String.valueOf(copia.getObjeto().getDiaria().getValor_promocao());

        valor = setPrecoFormat(valor);
        valor_promocao = setPrecoFormat(valor_promocao);

        DefaultTableModel row = (DefaultTableModel) jtbl_locacao.getModel();
        ItemDbGrid hashDbGrid = new ItemDbGrid(copia, copia.getObjeto().getDescricao_objeto());
        row.addRow(new Object[]{copia.getCodigo_copia(), copia.getCodigo_interno(),
            hashDbGrid, valor, valor_promocao, copia.getObjeto().getDiaria().getDias(), copia.getStatus()});

//            limparItem();
        jtf_nome_objeto.requestFocus();
//        } else {
//            //JOptionPane.showMessageDialog(null, "Não foi possivel adicionar ");
//        }
    }
    private Date data;

//    public boolean verificaTabela() {
//
//        boolean tabela = true;
//        if (jtbl_locacao.getRowCount() == 0) {
//            return true;
//
//        } else if (jtbl_locacao.getRowCount() > 0) {
//            int linhas = jtbl_locacao.getRowCount();
//
//            for (int i = 0; i < linhas; i++) {
////                EntradaItem ent = new EntradaItem();
////                ent.setProduto(new Produto((Integer) jtbl_locacao.getValueAt(i, 0)));
//
//                String lote = null;
//                lote = jtf_nome_objeto.getText();
//
//                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//
//                String venc = null;
//                venc = (String) jtbl_locacao.getValueAt(i, 5);
//
//                try {
////                    ent.setVencimento(dateFormat.parse(venc));
//                } catch (ParseException ex) {
//                    Logger.getLogger(Atendimento.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                data = null;
//                try {
//                    data = (dateFormat.parse(jtf_diaria.getText()));
//                } catch (ParseException ex) {
//                    Logger.getLogger(Atendimento.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//                if (ent.getProduto().getCod_produto() == produto.getCod_produto()) {
//                    ent.setLote((String) jtbl_locacao.getValueAt(i, 2));
//
//                    if (ent.getLote().equals(lote)) {
//
//                        JOptionPane.showMessageDialog(null, "Este lote já foi inserido para este produto");
//                        tabela = false;
//
//                    } else if (ent.getVencimento() == data) {
//                        JOptionPane.showMessageDialog(null, "Este vencimento já foi inserido para um lote neste produto");
//                        tabela = false;
//
//                    } else {
//                        tabela = true;
//                    }
//                }
//            }
//
//            return tabela;
//        }
//        return tabela;
//    }
//
//    public boolean verificaTabela() {
//        boolean produtoExistente = false;
//
//        if (jTable1.getRowCount() == 0) {
//            produtoExistente = true;
//
//        } else {
//            produtoExistente = false;
//        }
//
//
//
//        if (jTable1.getRowCount() > 0) {
//            for (int i = 0; i < jTable1.getRowCount(); i++) {
//                ItemDbGrid hashDb = (ItemDbGrid) jTable1.getValueAt(i, 0);
//                EntradaItem entradaItem = (EntradaItem) hashDb.getObjeto();
//                entradaItemModel = entradaItem;
//                if (entradaItemModel.getProduto().getCod_produto() == produtoCombo.getCod_produto()) {
//                    JOptionPane.showMessageDialog(null, "Este produto já foi inserido");
//                    produtoExistente = false;
//                } else {
//                    produtoExistente = true;
//                }
//            }
//            return produtoExistente;
//        }
//        return produtoExistente;
//    }
    public void limparItem() {

//        jtf_lote.setText("");
        jtf_valor.setText("R$");
        jtf_tipo_midia.setText("");
        jtf_diaria.setText("");
        jtf_codigo_copia.setText("");
        jtf_nome_objeto.setText("");
//        jtf_concentracao.setText("");
    }

    public void statusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }

    public void carregaCopia(Copia copia) {
        this.copia = copia;
        jtf_codigo_copia.setText(String.valueOf(copia.getCodigo_copia()));
        jtf_nome_objeto.setText(copia.getObjeto().getDescricao_objeto());
        jtf_diaria.setText(String.valueOf(copia.getObjeto().getDiaria().getDias()));

        String valor = null;
        String valor_promocao = null;

        valor = String.valueOf(copia.getObjeto().getDiaria().getValor());
        valor_promocao = String.valueOf(copia.getObjeto().getDiaria().getValor_promocao());

        valor = setPrecoFormat(valor);
        valor_promocao = setPrecoFormat(valor_promocao);

        jtf_valor.setText(valor);
        jtf_valor_promocao.setText(valor_promocao);
        jtf_tipo_midia.setText(copia.getObjeto().getTipo_midia());
    }

    public void carregaCliente(Cliente cliente) {
        this.cliente = cliente;
        jtf_nome_cliente.setText(cliente.getNome_cliente());
        jtf_codigo_cliente.setText(String.valueOf(cliente.getCodigo_cliente()));
//        jtf_nome_objeto.requestFocus();
    }

    public void setStatusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);

    }

    public void setRequestProd() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setRequestForn() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setRequestDiaria() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setRequestGenero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
