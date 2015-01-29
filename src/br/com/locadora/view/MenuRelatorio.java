/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConsultarProdutoGUI.java
 *
 * Created on 02/06/2011, 03:08:41
 */
package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.controller.SiscomController;
import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.ItemLocacao;
import br.com.locadora.model.dao.LocacaoDAO;
import br.com.locadora.relatorios.RelatorioClientePendente;
import br.com.locadora.relatorios.RelatorioFluxoCaixaDetalhado;
import br.com.locadora.relatorios.RelatorioLocacaoAberta;
import br.com.locadora.relatorios.RelatorioLocacaoRelocacao;
import br.com.locadora.relatorios.RelatorioMaisLocados;
import br.com.locadora.util.Data;
import br.com.locadora.util.TemaInterface;
import static br.com.locadora.view.CadastraAlteraObjeto.jtf_data_aquisicao;
import static br.com.locadora.view.Financeiro.jtf_data_final;
import static br.com.locadora.view.Financeiro.jtf_data_inicial;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author ALENCAR
 */
public class MenuRelatorio extends javax.swing.JFrame {

    public TelaPrincipal janelapai;
    public List<ItemLocacao> itens;
    public Copia copia;
    public InterfacePool pool;
    public SiscomController controller;
    public static List<ItemLocacao> itensDevolucao;
    public LocacaoDAO locacaoDAO;
    public MaskFormatter formatoData;

    public MenuRelatorio() {
        initComponents();
        TemaInterface.getInterface(this);
        janelapai = null;       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jtf_consulta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jb_gerar_relatorio = new javax.swing.JButton();
        jb_sair = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        try  {
            formatoData = new MaskFormatter("##/##/####");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");
        }
        jtf_data_inicial = new JFormattedTextField(formatoData);
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        try  {
            formatoData = new MaskFormatter("##/##/####");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");
        }
        jtf_data_final = new JFormattedTextField(formatoData);
        jPanel4 = new javax.swing.JPanel();
        jrb_quantidade_locacao_relocacao = new javax.swing.JRadioButton();
        jrb_locacao_em_aberto = new javax.swing.JRadioButton();
        jrb_fluxo_caixa_detalhado = new javax.swing.JRadioButton();
        jrb_clientes_pendentes = new javax.swing.JRadioButton();
        jrb_mais_locado = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro Titulo do Objeto"));
        jPanel1.setName("jPanel1"); // NOI18N

        jtf_consulta.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_consulta.setName("jtf_consulta"); // NOI18N
        jtf_consulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_consultaKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel1.setText("Titulo do Objeto");
        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(207, 207, 207))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtf_consulta)
                        .addGap(0, 0, 0))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(jtf_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel2.setName("jPanel2"); // NOI18N

        jb_gerar_relatorio.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_gerar_relatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pdficon.jpg.png"))); // NOI18N
        jb_gerar_relatorio.setText("Gerar");
        jb_gerar_relatorio.setName("jb_gerar_relatorio"); // NOI18N
        jb_gerar_relatorio.setPreferredSize(new java.awt.Dimension(100, 40));
        jb_gerar_relatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_gerar_relatorioActionPerformed(evt);
            }
        });
        jb_gerar_relatorio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_gerar_relatorioKeyPressed(evt);
            }
        });

        jb_sair.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/sair.png"))); // NOI18N
        jb_sair.setText("Sair");
        jb_sair.setName("jb_sair"); // NOI18N
        jb_sair.setPreferredSize(new java.awt.Dimension(100, 40));
        jb_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_sairActionPerformed(evt);
            }
        });
        jb_sair.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_sairKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jb_gerar_relatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jb_sair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jb_gerar_relatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_sair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro com Data"));
        jPanel3.setName("jPanel3"); // NOI18N

        jtf_data_inicial.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_data_inicial.setName("jtf_data_inicial"); // NOI18N
        jtf_data_inicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_data_inicialActionPerformed(evt);
            }
        });
        jtf_data_inicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_data_inicialFocusLost(evt);
            }
        });
        jtf_data_inicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_data_inicialKeyPressed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel31.setText("Data Inicial");
        jLabel31.setName("jLabel31"); // NOI18N

        jLabel32.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel32.setText("Data Final");
        jLabel32.setName("jLabel32"); // NOI18N

        jtf_data_final.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_data_final.setName("jtf_data_final"); // NOI18N
        jtf_data_final.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_data_finalActionPerformed(evt);
            }
        });
        jtf_data_final.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_data_finalFocusLost(evt);
            }
        });
        jtf_data_final.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_data_finalKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtf_data_inicial)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtf_data_final)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(0, 0, 0)
                        .addComponent(jtf_data_final, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(0, 0, 0)
                        .addComponent(jtf_data_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos"));
        jPanel4.setName("jPanel4"); // NOI18N

        buttonGroup1.add(jrb_quantidade_locacao_relocacao);
        jrb_quantidade_locacao_relocacao.setSelected(true);
        jrb_quantidade_locacao_relocacao.setText("Quantidade de Locação | Relocação");
        jrb_quantidade_locacao_relocacao.setName("jrb_quantidade_locacao_relocacao"); // NOI18N
        jrb_quantidade_locacao_relocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_quantidade_locacao_relocacaoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrb_locacao_em_aberto);
        jrb_locacao_em_aberto.setText("Locacões em Aberto");
        jrb_locacao_em_aberto.setName("jrb_locacao_em_aberto"); // NOI18N
        jrb_locacao_em_aberto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_locacao_em_abertoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrb_fluxo_caixa_detalhado);
        jrb_fluxo_caixa_detalhado.setText("Fluxo de Caixa Detalhado");
        jrb_fluxo_caixa_detalhado.setName("jrb_fluxo_caixa_detalhado"); // NOI18N
        jrb_fluxo_caixa_detalhado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_fluxo_caixa_detalhadoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrb_clientes_pendentes);
        jrb_clientes_pendentes.setText("Clientes Pendentes");
        jrb_clientes_pendentes.setName("jrb_clientes_pendentes"); // NOI18N
        jrb_clientes_pendentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_clientes_pendentesActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrb_mais_locado);
        jrb_mais_locado.setText("Mais Locados");
        jrb_mais_locado.setName("jrb_mais_locado"); // NOI18N
        jrb_mais_locado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_mais_locadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jrb_quantidade_locacao_relocacao)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrb_locacao_em_aberto)
                            .addComponent(jrb_fluxo_caixa_detalhado)
                            .addComponent(jrb_clientes_pendentes)
                            .addComponent(jrb_mais_locado))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jrb_quantidade_locacao_relocacao)
                .addGap(0, 0, 0)
                .addComponent(jrb_locacao_em_aberto)
                .addGap(0, 0, 0)
                .addComponent(jrb_fluxo_caixa_detalhado)
                .addGap(0, 0, 0)
                .addComponent(jrb_clientes_pendentes)
                .addGap(0, 0, 0)
                .addComponent(jrb_mais_locado)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        setVisible(false);
        if (janelapai != null) {
            janelapai.setStatusTela(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
                Calendar primeiroDia = Calendar.getInstance();
        primeiroDia.set(Calendar.DAY_OF_MONTH, 1);

        Calendar ultimoDia = Calendar.getInstance();
        ultimoDia.add(Calendar.MONTH, 1);
        ultimoDia.set(Calendar.DAY_OF_MONTH, 1);
        ultimoDia.add(Calendar.DAY_OF_MONTH, -1);

        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

        String data_inicial = out.format(primeiroDia.getTime());
        String data_final = out.format(ultimoDia.getTime());

        jtf_data_inicial.setText(data_inicial);
        jtf_data_final.setText(data_final);

        
        jtf_consulta.requestFocus();

    }//GEN-LAST:event_formWindowOpened

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowDeactivated

    private void jtf_consultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_consultaKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_data_inicial.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_consultaKeyPressed

    private void jtf_data_inicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_data_inicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_inicialActionPerformed

    private void jtf_data_inicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_data_inicialFocusLost
        try {

            if (jtf_data_inicial.getText().trim().length() < 10) {
                jtf_data_inicial.setForeground(Color.red);
//                jtf_data_inicial.requestFocus();
            } else if (jtf_data_inicial.getText().equals("  /  /    ")) {
                jtf_data_inicial.setForeground(Color.red);
//                jtf_data_inicial.requestFocus();
            } else {
                if (validaData(jtf_data_inicial.getText())) {

                    jtf_data_inicial.setForeground(Color.black);

                } else {
                    jtf_data_inicial.setForeground(Color.red);
//                    jtf_data_inicial.requestFocus();
                }

            }
        } catch (NumberFormatException ex) {
            jtf_data_inicial.setText("  /  /    ");
            jtf_data_inicial.setForeground(Color.red);
//            jtf_data_inicial.requestFocus();
        } catch (ParseException ex) {
            Logger.getLogger(MenuRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jtf_data_inicialFocusLost

    private void jtf_data_inicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_data_inicialKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_data_final.requestFocus();
        }        
    // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_inicialKeyPressed

    private void jtf_data_finalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_data_finalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_finalActionPerformed

    private void jtf_data_finalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_data_finalFocusLost
        try {
            Data data = new Data();
            int idade;

            if (jtf_data_final.getText().trim().length() < 10) {
                jtf_data_final.setForeground(Color.red);
//                jtf_data_final.requestFocus();
            } else if (jtf_data_final.getText().equals("  /  /    ")) {
                jtf_data_final.setForeground(Color.red);
//                jtf_data_final.requestFocus();
            } else {
                if (validaData(jtf_data_final.getText())) {

                    jtf_data_final.setForeground(Color.black);

                } else {
                    jtf_data_final.setForeground(Color.red);
//                    jtf_data_final.requestFocus();
                }

            }
        } catch (ParseException ex) {
            jtf_data_final.setForeground(Color.red);
//            jtf_data_final.requestFocus();
        } catch (NumberFormatException ex) {
            jtf_data_final.setText("  /  /    ");
            jtf_data_final.setForeground(Color.red);
//            jtf_data_final.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_finalFocusLost

    private void jtf_data_finalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_data_finalKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_gerar_relatorio.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_finalKeyPressed

    private void jrb_quantidade_locacao_relocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_quantidade_locacao_relocacaoActionPerformed
        jtf_consulta.setEnabled(true);
        jtf_consulta.requestFocus();
        jtf_data_inicial.setEnabled(true);
        jtf_data_final.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_quantidade_locacao_relocacaoActionPerformed

    private void jb_gerar_relatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_gerar_relatorioActionPerformed

        SimpleDateFormat in = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");

        String dataInicial = null;
        String dataFinal = null;
        try {
            dataInicial = out.format(in.parse(jtf_data_inicial.getText()));
            dataFinal = out.format(in.parse(jtf_data_final.getText()));
        } catch (ParseException ex) {

        }

        String titulo = jtf_consulta.getText().trim();

        pool = new Pool();

        if (jrb_quantidade_locacao_relocacao.isSelected() == true) {
            RelatorioLocacaoRelocacao rel = new RelatorioLocacaoRelocacao(pool);
            rel.gerarRelatorio(dataInicial, dataFinal, titulo);
        } else if (jrb_locacao_em_aberto.isSelected() == true) {
            RelatorioLocacaoAberta rel = new RelatorioLocacaoAberta(pool);
            rel.gerarRelatorio(dataInicial, dataFinal, titulo);
        } else if (jrb_fluxo_caixa_detalhado.isSelected() == true) {
            RelatorioFluxoCaixaDetalhado rel = new RelatorioFluxoCaixaDetalhado(pool);
            rel.gerarRelatorio(dataInicial, dataFinal);
        } else if (jrb_clientes_pendentes.isSelected() == true) {
            RelatorioClientePendente rel = new RelatorioClientePendente(pool);
            rel.gerarRelatorio();
        } else if (jrb_mais_locado.isSelected() == true) {
            RelatorioMaisLocados rel = new RelatorioMaisLocados(pool);
            rel.gerarRelatorio(dataInicial, dataFinal, titulo);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_gerar_relatorioActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void jrb_fluxo_caixa_detalhadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_fluxo_caixa_detalhadoActionPerformed
        jtf_consulta.setEnabled(false);
        jtf_data_final.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_fluxo_caixa_detalhadoActionPerformed

    private void jrb_locacao_em_abertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_locacao_em_abertoActionPerformed
        jtf_consulta.setEnabled(true);
        jtf_consulta.requestFocus();
        jtf_data_inicial.setEnabled(true);
        jtf_data_final.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_locacao_em_abertoActionPerformed

    private void jrb_clientes_pendentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_clientes_pendentesActionPerformed
        jtf_consulta.setEnabled(false);
        jtf_data_inicial.setEnabled(false);
        jtf_data_final.setEnabled(false);
        jb_gerar_relatorio.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_clientes_pendentesActionPerformed

    private void jrb_mais_locadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_mais_locadoActionPerformed
        jtf_consulta.setEnabled(true);
        jtf_consulta.requestFocus();
        jtf_data_inicial.setEnabled(true);
        jtf_data_final.setEnabled(true);
// TODO add your handling code here:
    }//GEN-LAST:event_jrb_mais_locadoActionPerformed

    private void jb_gerar_relatorioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_gerar_relatorioKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_gerar_relatorio.doClick();
        }  
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_gerar_relatorioKeyPressed

    private void jb_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_sairActionPerformed
        retornarJanelaPai();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_sairActionPerformed

    private void jb_sairKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_sairKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_sairKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MenuRelatorio().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton jb_gerar_relatorio;
    private javax.swing.JButton jb_sair;
    private javax.swing.JRadioButton jrb_clientes_pendentes;
    private javax.swing.JRadioButton jrb_fluxo_caixa_detalhado;
    private javax.swing.JRadioButton jrb_locacao_em_aberto;
    private javax.swing.JRadioButton jrb_mais_locado;
    private javax.swing.JRadioButton jrb_quantidade_locacao_relocacao;
    private javax.swing.JTextField jtf_consulta;
    public static javax.swing.JFormattedTextField jtf_data_final;
    public static javax.swing.JFormattedTextField jtf_data_inicial;
    // End of variables declaration//GEN-END:variables

    public void acionarAtalho(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
           retornarJanelaPai();
        }
    }
    
    public void retornarJanelaPai(){
        setVisible(false);
        if(janelapai != null){
            janelapai.setStatusTela(true);            
        }
    }

    public boolean verificarCamposData() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_data_inicial.getText().trim().length() < 10 && jtf_data_final.getText().trim().length() < 10) {
            msgERRO = msgERRO + " *Data Inicial\n";
        }

        if (jtf_data_inicial.getText().trim().length() < 10 && jtf_data_final.getText().trim().length() < 10) {
            msgERRO = msgERRO + " *Data Inicial\n";
        }

        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);

            jtf_data_aquisicao.requestFocus();

            return false;
        } else {
            return true;
        }

    }

    public static boolean validaData(String dataString) throws java.text.ParseException {

        if (!dataString.equals("")) {

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
            return (true);
        }
        return false;
    }
}
