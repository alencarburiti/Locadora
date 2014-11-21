/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DestinoCadastroGUI.java
 *
 * Created on 23/05/2011, 20:12:16
 */
package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.bean.Genero;
import br.com.locadora.model.dao.DiariaDAO;
import br.com.locadora.util.LimitadorTexto;
import br.com.locadora.util.Moeda;
import br.com.locadora.util.UnaccentedDocument;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ALENCAR
 */
public class AtualizaDiaria extends javax.swing.JFrame {

    private Diaria diaria;
    public MenuDiaria janelapai;
    public Moeda moeda;

    /**
     * Creates new form DestinoCadastroGUI
     */
    public AtualizaDiaria() {
        initComponents();
    }

    public AtualizaDiaria(Diaria diaria) {
        this.diaria = diaria;
        initComponents();
        System.out.println("Código Diária: " + this.diaria.getCodigo_diaria());
        jtf_codigo_diaria.setText(String.valueOf(this.diaria.getCodigo_diaria()));
        jtf_nome_diaria.setText(this.diaria.getNome_diaria());
        jtf_dias.setText(this.diaria.getDias().toString());
        moeda = new Moeda();

        jtf_valor.setText(moeda.setPrecoFormat(this.diaria.getValor().toString()));
        jtf_multa.setText(moeda.setPrecoFormat(this.diaria.getMultas().toString()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jb_salvar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        jtf_nome_diaria = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtf_codigo_diaria = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtf_valor = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jLabel7 = new javax.swing.JLabel();
        jtf_valor_promocao = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jLabel8 = new javax.swing.JLabel();
        jtf_dias = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jLabel9 = new javax.swing.JLabel();
        jtf_multa = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jPanel1 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterando Diária");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jb_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/gravar_registro.gif"))); // NOI18N
        jb_salvar.setText("Salvar");
        jb_salvar.setName("jb_salvar"); // NOI18N
        jb_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_salvarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_salvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, 35));

        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/exit.png"))); // NOI18N
        jb_cancelar.setText("Cancelar");
        jb_cancelar.setName("jb_cancelar"); // NOI18N
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, 35));

        jtf_nome_diaria.setName("jtf_nome_diaria"); // NOI18N
        jtf_nome_diaria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_nome_diariaKeyPressed(evt);
            }
        });
        getContentPane().add(jtf_nome_diaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 280, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("Nome");
        jLabel4.setName("jLabel4"); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText("Código Diária");
        jLabel5.setName("jLabel5"); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jtf_codigo_diaria.setEditable(false);
        jtf_codigo_diaria.setName("jtf_codigo_diaria"); // NOI18N
        getContentPane().add(jtf_codigo_diaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 90, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setText("Valor");
        jLabel6.setName("jLabel6"); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jtf_nome_diaria.setDocument(new UnaccentedDocument());
        jtf_valor.setText("R$ 0,00");
        jtf_valor.setName("jtf_valor"); // NOI18N
        jtf_valor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_valorFocusGained(evt);
            }
        });
        jtf_valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_valorKeyPressed(evt);
            }
        });
        getContentPane().add(jtf_valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 90, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel7.setText("Valor Promoção");
        jLabel7.setName("jLabel7"); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        jtf_nome_diaria.setDocument(new UnaccentedDocument());
        jtf_valor_promocao.setText("R$ 0,00");
        jtf_valor_promocao.setName("jtf_valor_promocao"); // NOI18N
        jtf_valor_promocao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_valor_promocaoFocusGained(evt);
            }
        });
        jtf_valor_promocao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_valor_promocaoKeyPressed(evt);
            }
        });
        getContentPane().add(jtf_valor_promocao, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 90, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel8.setText("Dias");
        jLabel8.setName("jLabel8"); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, -1, -1));

        jtf_dias.addKeyListener(new java.awt.event.KeyAdapter() {     // cria um listener ouvinte de digitação do fieldNumero
            public void keyReleased(java.awt.event.KeyEvent evt) {  // cria um ouvinte para cada tecla pressionada
                jtf_dias.setText(jtf_dias.getText().replaceAll("[^0-9]", "")); // faz com que pegue o texto a cada tecla digitada, e substituir tudo que não(^) seja numero  por ""
            }   });
            jtf_dias.setName("jtf_dias"); // NOI18N
            jtf_dias.addFocusListener(new java.awt.event.FocusAdapter() {
                public void focusGained(java.awt.event.FocusEvent evt) {
                    jtf_diasFocusGained(evt);
                }
            });
            jtf_dias.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    jtf_diasKeyPressed(evt);
                }
            });
            getContentPane().add(jtf_dias, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 90, -1));

            jLabel9.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
            jLabel9.setText("Multas");
            jLabel9.setName("jLabel9"); // NOI18N
            getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

            jtf_nome_diaria.setDocument(new UnaccentedDocument());
            jtf_multa.setText("R$ 0,00");
            jtf_multa.setName("jtf_multa"); // NOI18N
            jtf_multa.addFocusListener(new java.awt.event.FocusAdapter() {
                public void focusGained(java.awt.event.FocusEvent evt) {
                    jtf_multaFocusGained(evt);
                }
            });
            jtf_multa.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    jtf_multaKeyPressed(evt);
                }
            });
            getContentPane().add(jtf_multa, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 90, -1));

            jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dias de Promoção"));
            jPanel1.setName("jPanel1"); // NOI18N

            jCheckBox1.setSelected(true);
            jCheckBox1.setText("Domingo");
            jCheckBox1.setName("jCheckBox1"); // NOI18N
            jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jCheckBox1ActionPerformed(evt);
                }
            });
            jPanel1.add(jCheckBox1);

            jCheckBox3.setSelected(true);
            jCheckBox3.setText("Segunda");
            jCheckBox3.setName("jCheckBox3"); // NOI18N
            jPanel1.add(jCheckBox3);

            jCheckBox4.setSelected(true);
            jCheckBox4.setText("Terça");
            jCheckBox4.setName("jCheckBox4"); // NOI18N
            jPanel1.add(jCheckBox4);

            jCheckBox5.setSelected(true);
            jCheckBox5.setText("Quarta");
            jCheckBox5.setName("jCheckBox5"); // NOI18N
            jPanel1.add(jCheckBox5);

            jCheckBox6.setSelected(true);
            jCheckBox6.setText("Quinta");
            jCheckBox6.setName("jCheckBox6"); // NOI18N
            jPanel1.add(jCheckBox6);

            jCheckBox7.setSelected(true);
            jCheckBox7.setText("Sexta");
            jCheckBox7.setName("jCheckBox7"); // NOI18N
            jPanel1.add(jCheckBox7);

            jCheckBox8.setSelected(true);
            jCheckBox8.setText("Sábado");
            jCheckBox8.setName("jCheckBox8"); // NOI18N
            jPanel1.add(jCheckBox8);

            getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 380, 90));

            setSize(new java.awt.Dimension(434, 311));
            setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

    private void jb_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salvarActionPerformed
        alteraDiaria();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_salvarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtf_nome_diaria.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        retornaJanelaPai();
    }//GEN-LAST:event_jb_cancelarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        retornaJanelaPai();
    }//GEN-LAST:event_formWindowClosed

    private void jtf_valorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valorFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valorFocusGained

    private void jtf_valorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_valor_promocao.requestFocus();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valorKeyPressed

    private void jtf_valor_promocaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_promocaoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_promocaoFocusGained

    private void jtf_valor_promocaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valor_promocaoKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_dias.requestFocus();
        }
        acionarAtalho(evt);// TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_promocaoKeyPressed

    private void jtf_diasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_diasFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_diasFocusGained

    private void jtf_diasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_diasKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_multa.requestFocus();
        }
        acionarAtalho(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_diasKeyPressed

    private void jtf_multaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_multaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_multaFocusGained

    private void jtf_multaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_multaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_salvar.requestFocus();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_multaKeyPressed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jtf_nome_diariaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nome_diariaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_valor.requestFocus();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nome_diariaKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AtualizaDiaria().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JCheckBox jCheckBox1;
    public static javax.swing.JCheckBox jCheckBox3;
    public static javax.swing.JCheckBox jCheckBox4;
    public static javax.swing.JCheckBox jCheckBox5;
    public static javax.swing.JCheckBox jCheckBox6;
    public static javax.swing.JCheckBox jCheckBox7;
    public static javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_salvar;
    public static javax.swing.JTextField jtf_codigo_diaria;
    public static javax.swing.JTextField jtf_dias;
    public static javax.swing.JTextField jtf_multa;
    public static javax.swing.JTextField jtf_nome_diaria;
    public static javax.swing.JTextField jtf_valor;
    public static javax.swing.JTextField jtf_valor_promocao;
    // End of variables declaration//GEN-END:variables
    Genero destino = new Genero();

    public void alimentaCampos(List<MenuGenero> destinos) {
    }

    private void alteraDiaria() {
        if (verificarCampos()) {
            InterfacePool pool;
            pool = new Pool();
            moeda = new Moeda();

            DiariaDAO diariaDAO = new DiariaDAO(pool);
            diaria.setCodigo_diaria(Integer.parseInt(jtf_codigo_diaria.getText()));
            diaria.setNome_diaria(jtf_nome_diaria.getText().trim());

            diaria.setValor(moeda.getPrecoFormato(jtf_valor.getText()));
            diaria.setDias(Integer.parseInt(jtf_dias.getText()));
            diaria.setMultas(moeda.getPrecoFormato(jtf_multa.getText()));
            diariaDAO.atualizar(diaria);
            JOptionPane.showMessageDialog(null, "Alteração efetuada com sucesso");
            janelapai.enviaDados();
            retornaJanelaPai();
        }
    }

    public boolean verificarCampos() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_nome_diaria.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Descrição\n";
        }
        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            return false;
        } else {
            return true;
        }

    }

    public void retornaJanelaPai() {
        setVisible(false);
//        janelapai.listarDestino();
        janelapai.setEnabled(true);
        janelapai.setVisible(true);
        janelapai.request();
    }

    public void acionarAtalho(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F10) {
            alteraDiaria();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            setVisible(false);
            janelapai.setStatusTela(true);
        }
    }
}
