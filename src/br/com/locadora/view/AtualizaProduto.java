/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AtualizaProduto.java
 *
 * Created on 26/05/2011, 08:37:47
 */
package br.com.locadora.view;

import br.com.locadora.model.dao.ProdutoDAO;
import br.com.locadora.model.bean.Produto;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.LimitadorTexto;
import br.com.locadora.util.TemaInterface;
import br.com.locadora.util.UnaccentedDocument;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author ALENCAR
 */
public class AtualizaProduto extends javax.swing.JFrame {

    public MenuProduto janelapai;
    public Produto objproduto;
    public List<Produto> produtos;

    /**
     * Creates new form ProdutoAlterarGUI
     */
    public AtualizaProduto() {
        initComponents();
        TemaInterface.getInterface(this);
    }

    public AtualizaProduto(Produto produto) {
        this.objproduto = produto;
        initComponents();
        TemaInterface.getInterface(this);
        jtf_codigo.setText(String.valueOf(produto.getCod_produto()));
        jtf_nome.setText(String.valueOf(produto.getNome_produto()));
        jtf_concentração.setText(String.valueOf(produto.getConcentraçao()));
        jtf_estoqueIdeal.setText(String.valueOf(produto.getEstoque_ideal()));
        jtf_estoqueMinimo.setText(String.valueOf(produto.getEstoque_minimo()));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jb_salvar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jtf_estoqueMinimo = new javax.swing.JTextField(11);
        jLabel4 = new javax.swing.JLabel();
        jtf_nome = new javax.swing.JTextField(new LimitadorTexto(80), "",10);
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtf_codigo = new javax.swing.JTextField();
        jtf_estoqueIdeal = new javax.swing.JTextField(new LimitadorTexto(11), "",10);
        jcb_unidade = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jcb_grupo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jtf_concentração = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jcb_sub = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterando Produto");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jb_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/medicalpharm/image/gravar_registro.gif"))); // NOI18N
        jb_salvar.setText("Salvar");
        jb_salvar.setName("jb_salvar"); // NOI18N
        jb_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_salvarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_salvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, 35));

        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/medicalpharm/image/exit.png"))); // NOI18N
        jb_cancelar.setText("Cancelar");
        jb_cancelar.setName("jb_cancelar"); // NOI18N
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, 35));

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel14.setText("Nome comercial");
        jLabel14.setName("jLabel14"); // NOI18N
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jtf_estoqueMinimo.setName("jtf_estoqueMinimo"); // NOI18N
        jtf_estoqueMinimo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_estoqueMinimoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_estoqueMinimoFocusLost(evt);
            }
        });
        getContentPane().add(jtf_estoqueMinimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 80, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("Grupo *");
        jLabel4.setName("jLabel4"); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, -1));

        jtf_nome.setDocument(new UnaccentedDocument());
        jtf_nome.setName("jtf_nome"); // NOI18N
        jtf_nome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_nomeFocusGained(evt);
            }
        });
        jtf_nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_nomeKeyPressed(evt);
            }
        });
        getContentPane().add(jtf_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 420, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel8.setText("Estoque Minimo *");
        jLabel8.setName("jLabel8"); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText("Unidade *");
        jLabel5.setName("jLabel5"); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel7.setText("Estoque Ideal *");
        jLabel7.setName("jLabel7"); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, -1, -1));

        jtf_codigo.setEditable(false);
        jtf_codigo.setName("jtf_codigo"); // NOI18N
        getContentPane().add(jtf_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 94, -1));

        jtf_estoqueIdeal.setName("jtf_estoqueIdeal"); // NOI18N
        jtf_estoqueIdeal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_estoqueIdealFocusGained(evt);
            }
        });
        getContentPane().add(jtf_estoqueIdeal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 80, -1));

        jcb_unidade.setEditable(true);
        jcb_unidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        jcb_unidade.setName("jcb_unidade"); // NOI18N
        jcb_unidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_unidadeActionPerformed(evt);
            }
        });
        getContentPane().add(jcb_unidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 70, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Produto / Apresentação *");
        jLabel3.setName("jLabel3"); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jcb_grupo.setEditable(true);
        jcb_grupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        jcb_grupo.setName("jcb_grupo"); // NOI18N
        jcb_grupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_grupoActionPerformed(evt);
            }
        });
        getContentPane().add(jcb_grupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 120, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("Código");
        jLabel1.setName("jLabel1"); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jtf_concentração.setDocument(new UnaccentedDocument());
        jtf_concentração.setName("jtf_concentração"); // NOI18N
        jtf_concentração.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_concentraçãoFocusGained(evt);
            }
        });
        jtf_concentração.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_concentraçãoKeyPressed(evt);
            }
        });
        getContentPane().add(jtf_concentração, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 420, -1));

        jLabel2.setText("Observação: Os campos com asteristico na frente são obrigatórios ");
        jLabel2.setName("jLabel2"); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jButton2.setText("...");
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 30, -1));

        jButton1.setText("...");
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 30, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel9.setText("Sub-Grupo*");
        jLabel9.setName("jLabel9"); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, -1, -1));

        jcb_sub.setEditable(true);
        jcb_sub.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        jcb_sub.setName("jcb_sub"); // NOI18N
        jcb_sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_subActionPerformed(evt);
            }
        });
        jcb_sub.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcb_subFocusGained(evt);
            }
        });
        getContentPane().add(jcb_sub, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 130, -1));

        setSize(new java.awt.Dimension(482, 333));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jb_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salvarActionPerformed
        alterarProduto();
}//GEN-LAST:event_jb_salvarActionPerformed

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        janelapai.setEnabled(true);
        janelapai.setVisible(true);

        setVisible(false);
        // TODO add your handling code here:
}//GEN-LAST:event_jb_cancelarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        janelapai.setEnabled(true);
        janelapai.setVisible(true);

        setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void jtf_estoqueMinimoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_estoqueMinimoFocusLost
    }//GEN-LAST:event_jtf_estoqueMinimoFocusLost
//    Grupo grupoCombo;
    private void jcb_grupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_grupoActionPerformed

//        
    }//GEN-LAST:event_jcb_grupoActionPerformed

    private void jcb_unidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_unidadeActionPerformed
//        ItemDbGrid hashDbGrid = (ItemDbGrid) jcb_unidade.getSelectedItem();
//        unidadeCombo = (UnidadeModel) hashDbGrid.getObjeto();
    }//GEN-LAST:event_jcb_unidadeActionPerformed

    private void jtf_nomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_nomeFocusGained
        jtf_nome.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (jtf_nome.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Informe o principio ativo do produto");
                    jtf_nome.requestFocus();
                    return false;
                } else {
                    return true;
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nomeFocusGained

    private void jtf_concentraçãoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_concentraçãoFocusGained
//    jtf_concentração.setInputVerifier(new InputVerifier() {
//    public boolean verify(JComponent input) {
//                if(jtf_concentração.getText().equals("")) {
//                    JOptionPane.showMessageDialog(null, "Informe a concentação do produto");
//                    jtf_concentração.requestFocus();
//                    return false;
//                } else {
//                    return true;
//                }
//            }
//    });
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_concentraçãoFocusGained

    private void jtf_estoqueMinimoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_estoqueMinimoFocusGained
        jtf_estoqueMinimo.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (jtf_estoqueMinimo.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o estoque minimo");
                    jtf_estoqueMinimo.requestFocus();
                    return false;
                } else {
                    return true;
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_estoqueMinimoFocusGained

    private void jtf_estoqueIdealFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_estoqueIdealFocusGained
        jtf_estoqueIdeal.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                Integer estoqueIdeal = 0;
                Integer estoqueMínimo = 0;
                estoqueIdeal = Integer.parseInt(jtf_estoqueIdeal.getText());
                estoqueMínimo = Integer.parseInt(jtf_estoqueMinimo.getText());
                if (jtf_estoqueIdeal.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o estoque ideal");
                    jtf_estoqueIdeal.requestFocus();
                    return false;
                } else if (estoqueIdeal < estoqueMínimo) {
                    JOptionPane.showMessageDialog(null, "Estoque ideal menor que estoque mínimo");
                    jtf_estoqueIdeal.requestFocus();
                    return false;
                } else {
                    return true;
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_estoqueIdealFocusGained

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//    GrupoCadastroGUI grup = new GrupoCadastroGUI();
//    grup.setVisible(true);
//    grup.janelapai3 = this;
//    this.setEnabled(false);
    // TODO add your handling code here:
}//GEN-LAST:event_jButton2ActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//    UnidadeCadastroGUI unid = new UnidadeCadastroGUI();
//    unid.setVisible(true);
//    unid.janelapai3 = this;
//    this.setEnabled(false);
////    ProdutoCadastroGUI prod = new ProdutoCadastroGUI();
////            prod.setVisible(true);
////            prod.janelapai = this;
////            this.setEnabled(false);
//
//    // TODO add your handling code here:
}//GEN-LAST:event_jButton1ActionPerformed

private void jcb_subActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_subActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jcb_subActionPerformed

private void jtf_nomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nomeKeyPressed
    jtf_nome.addKeyListener(new KeyAdapter() {
        public void keyReleased(KeyEvent evt) {
            if (evt.getKeyCode() != KeyEvent.VK_HOME) {
                String s = jtf_nome.getText();
                jtf_nome.setText(s.toUpperCase());
            }
        }
    });

    // TODO add your handling code here:
}//GEN-LAST:event_jtf_nomeKeyPressed

private void jtf_concentraçãoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_concentraçãoKeyPressed
    jtf_concentração.addKeyListener(new KeyAdapter() {
        public void keyReleased(KeyEvent evt) {
            if (evt.getKeyCode() != KeyEvent.VK_HOME) {
                String s = jtf_concentração.getText();
                jtf_concentração.setText(s.toUpperCase());
            }
        }
    });

    // TODO add your handling code here:
}//GEN-LAST:event_jtf_concentraçãoKeyPressed

private void jcb_subFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcb_subFocusGained
// TODO add your handling code here:
}//GEN-LAST:event_jcb_subFocusGained

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AtualizaProduto().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_salvar;
    private javax.swing.JComboBox jcb_grupo;
    private javax.swing.JComboBox jcb_sub;
    private javax.swing.JComboBox jcb_unidade;
    private javax.swing.JTextField jtf_codigo;
    private javax.swing.JTextField jtf_concentração;
    private javax.swing.JTextField jtf_estoqueIdeal;
    private javax.swing.JTextField jtf_estoqueMinimo;
    private javax.swing.JTextField jtf_nome;
    // End of variables declaration//GEN-END:variables
    private void alterarProduto() {
        if (verificarCampos() && validaEstoque()) {

            ItemDbGrid hashDbGrid1 = (ItemDbGrid) jcb_grupo.getSelectedItem();

            ProdutoDAO produtoControl = new ProdutoDAO();
            this.objproduto.setNome_produto(jtf_nome.getText().trim());
            this.objproduto.setConcentraçao(jtf_concentração.getText().trim());
            this.objproduto.setEstoque_ideal(Integer.parseInt(jtf_estoqueIdeal.getText().trim()));
            this.objproduto.setEstoque_minimo(Integer.parseInt(jtf_estoqueMinimo.getText()));
            this.objproduto.setCod_produto(Integer.parseInt(jtf_codigo.getText()));
            produtoControl.alterarProduto(this.objproduto);
            JOptionPane.showMessageDialog(null, "Cadastro Alterado com sucesso");
            retornaJanelaPai();
        }

    }

    public void verificaCadastro() {
        ProdutoDAO prod = new ProdutoDAO();
        produtos = prod.listarProduto(jtf_nome.getText().trim());
        validaCadastro(produtos);
    }

    public void validaCadastro(List<Produto> produto) {//verifica cadastro existente que retornou de uma lista

        if (produto.size() != 1) {
            alterarProduto();
        } else {
            jtf_nome.requestFocus();
            JOptionPane.showMessageDialog(null, "Produto existente");

        }
    }

    public boolean verificarCampos() {
        String msgERRO = "Preencha os campos obrigatórios:\n";
        Integer estoqueIdeal = 0;
        Integer estoqueMínimo = 0;
        estoqueIdeal = Integer.parseInt(jtf_estoqueIdeal.getText());
        estoqueMínimo = Integer.parseInt(jtf_estoqueMinimo.getText());
        if (jtf_nome.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Descrição\n";
        }
        if (jcb_grupo.getSelectedIndex() == 0) {
            msgERRO = msgERRO + " *Grupo\n";
        }
        if (jcb_unidade.getSelectedIndex() == 0) {
            msgERRO = msgERRO + " *Unidade\n";
        }
        if (jtf_estoqueIdeal.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Estoque Ideal\n";
        }
        if (jtf_estoqueMinimo.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Estoque Minimo\n";
        } else if (estoqueIdeal < estoqueMínimo) {
            JOptionPane.showMessageDialog(null, "Estoque ideal menor que estoque mínimo");
            jtf_estoqueIdeal.requestFocus();
            return false;
        }

        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            jtf_nome.requestFocus();
            return false;
        } else {
            return true;
        }

    }

    public void retornaJanelaPai() {
        janelapai.setEnabled(true);
        janelapai.setVisible(true);

        this.setVisible(false);

    }

    public void setStatusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }

    public boolean validaEstoque() {
        Integer estoqueIdeal = 0;
        Integer estoqueMínimo = 0;
        estoqueIdeal = Integer.parseInt(jtf_estoqueIdeal.getText());
        estoqueMínimo = Integer.parseInt(jtf_estoqueMinimo.getText());
        if (estoqueIdeal < estoqueMínimo) {
            JOptionPane.showMessageDialog(null, "Estoque ideal menor que estoque mínimo");
            jtf_estoqueIdeal.requestFocus();
            return false;
        }
        return true;
    }

}
