package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.controller.SiscomController;
import br.com.locadora.model.bean.Acesso;
import br.com.locadora.model.bean.Usuario;
import br.com.locadora.model.dao.UsuarioDAO;
import br.com.locadora.util.ImprimiCupom;
import br.com.locadora.util.LimitadorTexto;
import br.com.locadora.util.Moeda;
import br.com.locadora.util.UnaccentedDocument;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALENCAR
 */
public final class EntradaCaixaDevolucao extends javax.swing.JFrame {

    public AtendimentoLocacao janelapaiLocacao;
    public AtendimentoDevolucao janelapaiDevolucao;
    public InterfacePool pool;
    public SiscomController controller;
    public String action;

    /**
     * Creates new form ProdutoCadastroGUI
     */
    public EntradaCaixaDevolucao() {
        initComponents();
        janelapaiLocacao = null;
        janelapaiDevolucao = null;
    }

    //public ProdutoConsultarGUI janelapaim;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tfa_similar = new javax.swing.JTextArea();
        jb_imprimir = new javax.swing.JButton();
        jb_salvar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jtf_login = new javax.swing.JTextField();
        label2 = new java.awt.Label();
        jpf_senha = new javax.swing.JPasswordField();
        jb_logar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jtf_total_locacao = new javax.swing.JTextField(new LimitadorTexto(80), "",10);
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtf_valor_desconto = new javax.swing.JTextField(new LimitadorTexto(80), "",10);
        jLabel6 = new javax.swing.JLabel();
        jtf_valor_pago = new javax.swing.JTextField(new LimitadorTexto(80), "",10);
        jLabel7 = new javax.swing.JLabel();
        jtf_troco = new javax.swing.JTextField(new LimitadorTexto(80), "",10);
        jtf_debito_atual = new javax.swing.JTextField(new LimitadorTexto(80), "",10);
        jLabel10 = new javax.swing.JLabel();
        jtf_debito_atual1 = new javax.swing.JTextField(new LimitadorTexto(80), "",10);
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jtf_total_multa = new javax.swing.JTextField(new LimitadorTexto(80), "",10);
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtf_total_a_pagar = new javax.swing.JTextField(new LimitadorTexto(80), "",10);
        jb_cancelar1 = new javax.swing.JButton();

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tfa_similar.setColumns(20);
        tfa_similar.setRows(5);
        tfa_similar.setName("tfa_similar"); // NOI18N
        jScrollPane1.setViewportView(tfa_similar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Caixa");
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
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jb_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/printer.png"))); // NOI18N
        jb_imprimir.setText("Imprimir");
        jb_imprimir.setEnabled(false);
        jb_imprimir.setMaximumSize(new java.awt.Dimension(101, 33));
        jb_imprimir.setName("jb_imprimir"); // NOI18N
        jb_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_imprimirActionPerformed(evt);
            }
        });
        getContentPane().add(jb_imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 530, -1, 35));

        jb_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/ok.png"))); // NOI18N
        jb_salvar.setText("Finalizar");
        jb_salvar.setName("jb_salvar"); // NOI18N
        jb_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_salvarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_salvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 530, -1, 35));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Verificar Permissão"));
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        label1.setName("label1"); // NOI18N
        label1.setText("Login:");
        jPanel1.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 50, -1));

        jtf_login.setEditable(false);
        jtf_login.setName("jtf_login"); // NOI18N
        jtf_login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_loginKeyPressed(evt);
            }
        });
        jPanel1.add(jtf_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 150, -1));

        label2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        label2.setName("label2"); // NOI18N
        label2.setText("Senha:");
        jPanel1.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        jpf_senha.setName("jpf_senha"); // NOI18N
        jpf_senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpf_senhaKeyPressed(evt);
            }
        });
        jPanel1.add(jpf_senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 150, -1));

        jb_logar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/http___iconesbr.oficinadanet.com_8533_16x16.png"))); // NOI18N
        jb_logar.setText("OK !");
        jb_logar.setName("jb_logar"); // NOI18N
        jb_logar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_logarActionPerformed(evt);
            }
        });
        jPanel1.add(jb_logar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 81, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 430, 90));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Caixa"));
        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtf_total_locacao.setDocument(new UnaccentedDocument());
        jtf_total_locacao.setEditable(false);
        jtf_total_locacao.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jtf_total_locacao.setForeground(new java.awt.Color(204, 0, 0));
        jtf_total_locacao.setText("R$ 0,00");
        jtf_total_locacao.setName("jtf_total_locacao");
        jtf_total_locacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_total_locacaoActionPerformed(evt);
            }
        });
        jtf_total_locacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_total_locacaoFocusGained(evt);
            }
        });
        jtf_total_locacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_total_locacaoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_total_locacaoKeyReleased(evt);
            }
        });
        jPanel2.add(jtf_total_locacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 170, -1));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel1.setText("Total Locação:");
        jLabel1.setName("jLabel1"); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel5.setText("Valor Desconto:");
        jLabel5.setName("jLabel5"); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jtf_total_locacao.setDocument(new UnaccentedDocument());
        jtf_valor_desconto.setEditable(false);
        jtf_valor_desconto.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jtf_valor_desconto.setText("R$ 0,00");
        jtf_valor_desconto.setName("jtf_valor_desconto"); // NOI18N
        jtf_valor_desconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_valor_descontoActionPerformed(evt);
            }
        });
        jtf_valor_desconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_valor_descontoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_valor_descontoFocusLost(evt);
            }
        });
        jtf_valor_desconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_valor_descontoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_valor_descontoKeyReleased(evt);
            }
        });
        jPanel2.add(jtf_valor_desconto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 170, -1));

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel6.setText("Valor Pago:");
        jLabel6.setName("jLabel6"); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jtf_total_locacao.setDocument(new UnaccentedDocument());
        jtf_valor_pago.setEditable(false);
        jtf_valor_pago.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jtf_valor_pago.setText("R$ 0,00");
        jtf_valor_pago.setName("jtf_valor_pago"); // NOI18N
        jtf_valor_pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_valor_pagoActionPerformed(evt);
            }
        });
        jtf_valor_pago.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_valor_pagoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_valor_pagoFocusLost(evt);
            }
        });
        jtf_valor_pago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_valor_pagoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_valor_pagoKeyReleased(evt);
            }
        });
        jPanel2.add(jtf_valor_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 170, -1));

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel7.setText("Troco");
        jLabel7.setName("jLabel7"); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jtf_total_locacao.setDocument(new UnaccentedDocument());
        jtf_troco.setEditable(false);
        jtf_troco.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jtf_troco.setText("R$ 0,00");
        jtf_troco.setName("jtf_troco"); // NOI18N
        jtf_troco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_trocoActionPerformed(evt);
            }
        });
        jtf_troco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_trocoFocusGained(evt);
            }
        });
        jtf_troco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_trocoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_trocoKeyReleased(evt);
            }
        });
        jPanel2.add(jtf_troco, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 170, -1));

        jtf_total_locacao.setDocument(new UnaccentedDocument());
        jtf_debito_atual.setEditable(false);
        jtf_debito_atual.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jtf_debito_atual.setForeground(new java.awt.Color(204, 0, 0));
        jtf_debito_atual.setText("R$ 0,00");
        jtf_debito_atual.setName("jtf_debito_atual"); // NOI18N
        jtf_debito_atual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_debito_atualActionPerformed(evt);
            }
        });
        jtf_debito_atual.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_debito_atualFocusGained(evt);
            }
        });
        jtf_debito_atual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_debito_atualKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_debito_atualKeyReleased(evt);
            }
        });
        jPanel2.add(jtf_debito_atual, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 170, -1));

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel10.setText("Crédito Atual");
        jLabel10.setName("jLabel10"); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jtf_total_locacao.setDocument(new UnaccentedDocument());
        jtf_debito_atual1.setEditable(false);
        jtf_debito_atual1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jtf_debito_atual1.setForeground(new java.awt.Color(51, 0, 255));
        jtf_debito_atual1.setText("R$ 0,00");
        jtf_debito_atual1.setName("jtf_debito_atual1"); // NOI18N
        jtf_debito_atual1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_debito_atual1ActionPerformed(evt);
            }
        });
        jtf_debito_atual1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_debito_atual1FocusGained(evt);
            }
        });
        jtf_debito_atual1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_debito_atual1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_debito_atual1KeyReleased(evt);
            }
        });
        jPanel2.add(jtf_debito_atual1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 170, -1));

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel11.setText("Débito Atual");
        jLabel11.setName("jLabel11"); // NOI18N
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dinheiro", "Cartão de Crédito", "Cartão de Débito", "Video Card" }));
        jComboBox1.setName("jComboBox1"); // NOI18N
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 170, 40));

        jtf_total_locacao.setDocument(new UnaccentedDocument());
        jtf_total_multa.setEditable(false);
        jtf_total_multa.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jtf_total_multa.setForeground(new java.awt.Color(204, 0, 0));
        jtf_total_multa.setText("R$ 0,00");
        jtf_total_multa.setName("jtf_total_multa"); // NOI18N
        jtf_total_multa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_total_multaActionPerformed(evt);
            }
        });
        jtf_total_multa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_total_multaFocusGained(evt);
            }
        });
        jtf_total_multa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_total_multaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_total_multaKeyReleased(evt);
            }
        });
        jPanel2.add(jtf_total_multa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 170, -1));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel2.setText("Multa:");
        jLabel2.setName("jLabel2"); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel3.setText("Total Á Pagar:");
        jLabel3.setName("jLabel3"); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jtf_total_locacao.setDocument(new UnaccentedDocument());
        jtf_total_a_pagar.setEditable(false);
        jtf_total_a_pagar.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jtf_total_a_pagar.setForeground(new java.awt.Color(204, 0, 0));
        jtf_total_a_pagar.setText("R$ 0,00");
        jtf_total_a_pagar.setName("jtf_total_a_pagar"); // NOI18N
        jtf_total_a_pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_total_a_pagarActionPerformed(evt);
            }
        });
        jtf_total_a_pagar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_total_a_pagarFocusGained(evt);
            }
        });
        jtf_total_a_pagar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_total_a_pagarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_total_a_pagarKeyReleased(evt);
            }
        });
        jPanel2.add(jtf_total_a_pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 170, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 360, 410));

        jb_cancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/exit.png"))); // NOI18N
        jb_cancelar1.setText("Fechar");
        jb_cancelar1.setMaximumSize(new java.awt.Dimension(101, 33));
        jb_cancelar1.setName("jb_cancelar1"); // NOI18N
        jb_cancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelar1ActionPerformed(evt);
            }
        });
        getContentPane().add(jb_cancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 530, -1, 35));

        setSize(new java.awt.Dimension(477, 606));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jb_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_imprimirActionPerformed
        ImprimiCupom imprimir = new ImprimiCupom();
        imprimir.escreverTXTLocacao(AtendimentoLocacao.copiasLocacao, AtendimentoDevolucao.dependente);
        imprimir.imprimirArquivo();

}//GEN-LAST:event_jb_imprimirActionPerformed
    private void retornaJanelaPai() {
        setVisible(false);

        if (janelapaiLocacao != null) {
            janelapaiLocacao.setEnabled(true);
            janelapaiLocacao.setVisible(true);
//            janelapai.request();
        }

    }
    private void jb_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salvarActionPerformed
        finalizarCaixa();
        
}//GEN-LAST:event_jb_salvarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jpf_senha.requestFocus();
        if (janelapaiLocacao != null) {
            action = "ENTRADA_CAIXA_LOCACAO";
            jtf_debito_atual.setText(AtendimentoLocacao.jtf_debito_total_locacao.getText());
            jtf_total_locacao.setText(AtendimentoLocacao.jtf_valor_total_locacao.getText());
        } else if (janelapaiDevolucao != null) {
            action = "ENTRADA_CAIXA_DEVOLUCAO";
            jtf_total_locacao.setText(AtendimentoDevolucao.jtf_valor_a_pagar.getText());
            jtf_total_multa.setText(AtendimentoDevolucao.jtf_valor_multa.getText());
            jtf_total_a_pagar.setText(AtendimentoDevolucao.jtf_valor_total.getText());
            jtf_debito_atual.setText(AtendimentoDevolucao.jtf_debito_total_devolucao.getText());
        }
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        retornaJanelaPai();
    }//GEN-LAST:event_formWindowClosed

    private void jtf_total_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_total_locacaoKeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_locacaoKeyPressed
    private void jtf_total_locacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_total_locacaoFocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_locacaoFocusGained

    private void jtf_total_locacaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_total_locacaoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_locacaoKeyReleased

    private void jtf_total_locacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_total_locacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_locacaoActionPerformed

    private void jtf_valor_descontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_valor_descontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_descontoActionPerformed

    private void jtf_valor_descontoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_descontoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_descontoFocusGained

    private void jtf_valor_descontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valor_descontoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_descontoKeyPressed

    private void jtf_valor_descontoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valor_descontoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_descontoKeyReleased

    private void jtf_valor_pagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_valor_pagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_pagoActionPerformed

    private void jtf_valor_pagoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_pagoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_pagoFocusGained

    private void jtf_valor_pagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valor_pagoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_pagoKeyPressed

    private void jtf_valor_pagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valor_pagoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_pagoKeyReleased

    private void jtf_trocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_trocoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_trocoActionPerformed

    private void jtf_trocoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_trocoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_trocoFocusGained

    private void jtf_trocoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_trocoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_trocoKeyPressed

    private void jtf_trocoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_trocoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_trocoKeyReleased

    private void jtf_debito_atualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_debito_atualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_debito_atualActionPerformed

    private void jtf_debito_atualFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_debito_atualFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_debito_atualFocusGained

    private void jtf_debito_atualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_debito_atualKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_debito_atualKeyPressed

    private void jtf_debito_atualKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_debito_atualKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_debito_atualKeyReleased

    private void jtf_debito_atual1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_debito_atual1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_debito_atual1ActionPerformed

    private void jtf_debito_atual1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_debito_atual1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_debito_atual1FocusGained

    private void jtf_debito_atual1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_debito_atual1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_debito_atual1KeyPressed

    private void jtf_debito_atual1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_debito_atual1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_debito_atual1KeyReleased

    private void jtf_valor_pagoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_pagoFocusLost
        Moeda moeda = new Moeda();

        Double troco;
        Double desconto;
        Double total_locacao;
        Double valor_pago;
        Double debito_atual;

        total_locacao = moeda.getPrecoFormato(jtf_total_a_pagar.getText());
        desconto = moeda.getPrecoFormato(jtf_valor_desconto.getText());
        valor_pago = moeda.getPrecoFormato(jtf_valor_pago.getText());
        debito_atual = moeda.getPrecoFormato(jtf_debito_atual.getText());

        troco = valor_pago - (total_locacao - desconto);
        if (troco > 0) {
            jtf_troco.setText(moeda.setPrecoFormat(String.valueOf(troco)));
        } else {
            jtf_troco.setText("R$ 0,00");
        }

        jtf_valor_pago.setText(moeda.setPrecoFormat(String.valueOf(valor_pago)));

        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_pagoFocusLost

    private void jtf_loginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_loginKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jpf_senha.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_loginKeyPressed

    private void jpf_senhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpf_senhaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            entrar();
        }
    }//GEN-LAST:event_jpf_senhaKeyPressed

    private void jb_logarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_logarActionPerformed
        entrar();
    }//GEN-LAST:event_jb_logarActionPerformed

    private void jtf_valor_descontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_descontoFocusLost
        Moeda moeda = new Moeda();
        jtf_valor_desconto.setText(moeda.setPrecoFormat(String.valueOf(jtf_valor_desconto.getText())));
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_descontoFocusLost

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F10) {
            finalizarCaixa();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void jb_cancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_cancelar1ActionPerformed

    private void jtf_total_multaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_total_multaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_multaActionPerformed

    private void jtf_total_multaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_total_multaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_multaFocusGained

    private void jtf_total_multaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_total_multaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_multaKeyPressed

    private void jtf_total_multaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_total_multaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_multaKeyReleased

    private void jtf_total_a_pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_total_a_pagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_a_pagarActionPerformed

    private void jtf_total_a_pagarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_total_a_pagarFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_a_pagarFocusGained

    private void jtf_total_a_pagarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_total_a_pagarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_a_pagarKeyPressed

    private void jtf_total_a_pagarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_total_a_pagarKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_a_pagarKeyReleased

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new EntradaCaixaDevolucao().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_cancelar1;
    private javax.swing.JButton jb_imprimir;
    private javax.swing.JButton jb_logar;
    private javax.swing.JButton jb_salvar;
    private javax.swing.JPasswordField jpf_senha;
    public static javax.swing.JTextField jtf_debito_atual;
    public static javax.swing.JTextField jtf_debito_atual1;
    private javax.swing.JTextField jtf_login;
    public static javax.swing.JTextField jtf_total_a_pagar;
    public static javax.swing.JTextField jtf_total_locacao;
    public static javax.swing.JTextField jtf_total_multa;
    public static javax.swing.JTextField jtf_troco;
    public static javax.swing.JTextField jtf_valor_desconto;
    public static javax.swing.JTextField jtf_valor_pago;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JTextArea tfa_similar;
    // End of variables declaration//GEN-END:variables

    public void setTela(String permissao) {
        if (permissao.equals("usuario")) {
//            jb_novo.setEnabled(false);
//            jb_alterar1.setEnabled(false);
//            jb_excluir1.setEnabled(false);
        } else {
        }
    }

    public void setStatusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }

    private void entrar() {

        if (validaLogin()) {
            if (verificaLogin()) {
                jtf_login.setText(acesso.getUsuario().getLogin());
                if (acesso.getEscrever() == 0) {

                    jtf_valor_desconto.setEditable(true);
                    jtf_valor_pago.setEditable(true);
                    jtf_valor_desconto.requestFocus();
                } else {
                    jtf_valor_desconto.setText("R$ 0,00");
                    jtf_valor_pago.setEditable(true);
                    jtf_valor_pago.requestFocus();
                }
                ///Faz alguma coisa interessante
            } else {
                jpf_senha.requestFocus();
                jpf_senha.setText("");
            }
        }
    }

    private boolean validaLogin() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jpf_senha.getPassword().equals("")) {
            msgERRO = msgERRO + " *Senha\n";
        }

        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            return false;
        } else {
            return true;
        }

    }

    public List<Usuario> usuarios;
    public static Acesso acesso;

    public boolean verificaLogin() {
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        acesso = usuarioControl.verificarPermissao(jpf_senha.getText().trim(), action);

        //verifica a senha
        char[] senha = jpf_senha.getPassword();
        char[] senhaDoBanco = acesso.getUsuario().getSenha().toCharArray();

        // verifica o tamanho da senha
        if (senha.length != senhaDoBanco.length) {
            JOptionPane.showMessageDialog(null, "Senha incorreta");
            return false; // se for diferente, retorna falso
        } else {
            for (int i = 0; i < senha.length; i++) {
                if (senha[i] != senhaDoBanco[i]) {
                    JOptionPane.showMessageDialog(null, "Senha incorreta");
                    return false; // se for diferente, retorna falso
                }
            }
        }

        return true;
    }
    public void finalizarCaixa(){
        if (janelapaiDevolucao != null) {
            
            controller = new SiscomController();
            controller.processarRequisicao("cadastrarDevolucao");

            jb_salvar.setEnabled(false);
            jb_imprimir.setEnabled(true);
            
            DefaultTableModel tb_devolucao = (DefaultTableModel) AtendimentoDevolucao.jtbl_devolucao.getModel();
            int rows = tb_devolucao.getRowCount();
            for (int i = rows - 1; i >= 0; i--) {
                tb_devolucao.removeRow(i);
            }
            AtendimentoDevolucao.jtf_codigo_cliente.setText("");
            AtendimentoDevolucao.jtf_nome_cliente.setText("");

            AtendimentoDevolucao.jtf_valor_total.setText("R$ 0,00");
            AtendimentoDevolucao.jtf_debito_total_devolucao.setText("R$ 0,00");
        }
        
        setVisible(false);
    }

}
