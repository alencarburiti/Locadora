/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CadastraAlteraProduto.java
 *
 * Created on 25/05/2011, 08:17:54
 */
package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.model.dao.ProdutoDAO;
import br.com.locadora.model.bean.Produto;
import br.com.locadora.util.LimitadorTexto;
import br.com.locadora.util.Moeda;
import br.com.locadora.util.TemaInterface;
import br.com.locadora.util.UnaccentedDocument;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.util.List;

/**
 *
 * @author ALENCAR
 */
public final class CadastraAlteraProduto extends javax.swing.JFrame {

    private TelaPrincipal janela;
    public List<Produto> produtos;
    public MenuProduto janelapai;
    public Produto produto;
    public Moeda moeda;
    public InterfacePool pool;
    public ProdutoDAO produtoDAO;

    /**
     * Creates new form ProdutoCadastroGUI
     */
    public CadastraAlteraProduto() {
        initComponents();
        TemaInterface.getInterface(this);
        janelapai = null;
    }

    public CadastraAlteraProduto(Produto produto) {
        this.produto = produto;
        initComponents();
        TemaInterface.getInterface(this);
        janelapai = null;
        moeda = new Moeda();
        jtf_codigo_produto.setText(produto.getCodigo_produto().toString());
        jtf_nome_produto.setText(produto.getNome_produto());
        jtf_codigo_barras.setText(produto.getCodigo_barras());
        jtf_preco_compra.setText(moeda.setPrecoFormat(produto.getPreco_compra().toString()));
        jtf_preco_venda.setText(moeda.setPrecoFormat(produto.getPreco_venda().toString()));
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
        jb_cancelar = new javax.swing.JButton();
        jb_salvar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jtf_codigo_produto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtf_preco_compra = new javax.swing.JTextField();
        jtf_preco_venda = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtf_nome_produto = new javax.swing.JTextField(new LimitadorTexto(80), "",10);
        jtf_codigo_barras = new javax.swing.JTextField(new LimitadorTexto(80), "",10);
        jLabel5 = new javax.swing.JLabel();

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tfa_similar.setColumns(20);
        tfa_similar.setRows(5);
        tfa_similar.setName("tfa_similar"); // NOI18N
        jScrollPane1.setViewportView(tfa_similar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrando Produto");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
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

        jb_salvar.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/save.png"))); // NOI18N
        jb_salvar.setText("Salvar");
        jb_salvar.setName("jb_salvar"); // NOI18N
        jb_salvar.setPreferredSize(new java.awt.Dimension(100, 40));
        jb_salvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_salvarMouseClicked(evt);
            }
        });
        jb_salvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_salvarKeyPressed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Produto"));
        jPanel1.setName("jPanel1"); // NOI18N

        jtf_codigo_produto.setEditable(false);
        jtf_codigo_produto.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_codigo_produto.setName("jtf_codigo_produto"); // NOI18N

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel11.setText("Preço Venda*");
        jLabel11.setName("jLabel11"); // NOI18N

        jtf_preco_compra.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_preco_compra.setText("R$ 0,00");
        jtf_preco_compra.setName("jtf_preco_compra"); // NOI18N
        jtf_preco_compra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_preco_compraFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_preco_compraFocusLost(evt);
            }
        });
        jtf_preco_compra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_preco_compraKeyPressed(evt);
            }
        });

        jtf_preco_venda.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_preco_venda.setText("R$ 0,00");
        jtf_preco_venda.setName("jtf_preco_venda"); // NOI18N
        jtf_preco_venda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_preco_vendaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_preco_vendaFocusLost(evt);
            }
        });
        jtf_preco_venda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_preco_vendaKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel3.setText("Nome do Produto*");
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel1.setText("Código");
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel4.setText("Código de Barras*");
        jLabel4.setName("jLabel4"); // NOI18N

        jtf_nome_produto.setDocument(new UnaccentedDocument());
        jtf_nome_produto.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_nome_produto.setName("jtf_nome_produto"); // NOI18N
        jtf_nome_produto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_nome_produtoKeyPressed(evt);
            }
        });

        jtf_nome_produto.setDocument(new UnaccentedDocument());
        jtf_codigo_barras.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_codigo_barras.setName("jtf_codigo_barras"); // NOI18N
        jtf_codigo_barras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_codigo_barrasKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel5.setText("Preço Compra*");
        jLabel5.setName("jLabel5"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jtf_codigo_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jtf_preco_compra, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jtf_preco_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jtf_nome_produto, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jtf_codigo_barras)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(jtf_codigo_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(jtf_nome_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel4)
                .addGap(0, 0, 0)
                .addComponent(jtf_codigo_barras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel11))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_preco_compra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_preco_venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jb_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jb_salvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(332, 286));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        retornaJanelaPai();

}//GEN-LAST:event_jb_cancelarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtf_nome_produto.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        retornaJanelaPai();
    }//GEN-LAST:event_formWindowClosed

    private void jtf_nome_produtoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nome_produtoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_codigo_barras.requestFocus();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nome_produtoKeyPressed

    private void jtf_codigo_barrasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_codigo_barrasKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_preco_compra.requestFocus();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_codigo_barrasKeyPressed

    private void jtf_preco_compraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_preco_compraFocusGained
        jtf_preco_compra.selectAll();
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_preco_compraFocusGained

    private void jtf_preco_compraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_preco_compraKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_preco_venda.requestFocus();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_preco_compraKeyPressed

    private void jtf_preco_vendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_preco_vendaFocusGained
        jtf_preco_venda.selectAll();
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_preco_vendaFocusGained

    private void jtf_preco_vendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_preco_vendaKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_salvar.requestFocus();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_preco_vendaKeyPressed

    private void jb_salvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_salvarKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cadastraProduto();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jb_salvarKeyPressed

    private void jb_salvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_salvarMouseClicked
        if (evt.getClickCount() == 1) {
            cadastraProduto();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_salvarMouseClicked

    private void jtf_preco_compraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_preco_compraFocusLost
        moeda = new Moeda();
        jtf_preco_compra.setText(moeda.setPrecoFormat(jtf_preco_compra.getText()));
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_preco_compraFocusLost

    private void jtf_preco_vendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_preco_vendaFocusLost
        moeda = new Moeda();
        jtf_preco_venda.setText(moeda.setPrecoFormat(jtf_preco_venda.getText()));
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_preco_vendaFocusLost

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new CadastraAlteraProduto().setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_salvar;
    private javax.swing.JTextField jtf_codigo_barras;
    private javax.swing.JTextField jtf_codigo_produto;
    private javax.swing.JTextField jtf_nome_produto;
    private javax.swing.JTextField jtf_preco_compra;
    private javax.swing.JTextField jtf_preco_venda;
    private javax.swing.JTextArea tfa_similar;
    // End of variables declaration//GEN-END:variables

    private void cadastraProduto() {
        if (verificarCampos()) {
            produto = new Produto();
            moeda = new Moeda();
            produto.setNome_produto(jtf_nome_produto.getText().trim());
            produto.setCodigo_barras(jtf_codigo_barras.getText().trim());
            produto.setPreco_compra(moeda.getPrecoFormato(jtf_preco_compra.getText()));
            produto.setPreco_venda(moeda.getPrecoFormato(jtf_preco_venda.getText()));
            pool = new Pool();
            produtoDAO = new ProdutoDAO(pool);
            if (jtf_codigo_produto.getText().equals("")) {
                try {
                    produto = produtoDAO.salvar(produto);
                    jtf_codigo_produto.setText(produto.getCodigo_produto().toString());
                    JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
                    this.setTitle("Alterando Produto");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                produto.setCodigo_produto(Integer.parseInt(jtf_codigo_produto.getText()));
                produtoDAO.atualizar(produto);
                JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
            }
        }
    }

    public boolean verificarCampos() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_nome_produto.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Nome Produto\n";
        }

        if (jtf_codigo_barras.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Código de Barras\n";
        }

        if (jtf_preco_compra.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Preço de Compra\n";
        }

        if (jtf_preco_venda.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Preço de Venda\n";
        }

        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            jtf_nome_produto.requestFocus();
            return false;
        } else {
            return true;
        }

    }

    public void setStatusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }

    public void acionarAtalho(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F10) {
            cadastraProduto();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            retornaJanelaPai();
        }
    }

    private void retornaJanelaPai() {
        setVisible(false);

        if (janelapai != null) {
            janelapai.setStatusTela(true);            
            janelapai.consultarProduto();
        }

    }

}
