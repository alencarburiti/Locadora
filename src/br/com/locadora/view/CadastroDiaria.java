/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CadastroDiaria.java
 *
 * Created on 23/05/2011, 20:12:16
 */
package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.controller.SiscomController;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.bean.PromocaoDevolucao;
import br.com.locadora.model.bean.PromocaoLocacao;
import br.com.locadora.model.dao.DiariaDAO;
import br.com.locadora.model.dao.UsuarioDAO;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.LimitadorTexto;
import br.com.locadora.util.Moeda;
import br.com.locadora.util.UnaccentedDocument;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author ALENCAR
 */
public class CadastroDiaria extends javax.swing.JFrame {

    public MenuDiaria janelapai;
    public Diaria diaria;
    public PromocaoLocacao promocaoLocacao;
    public PromocaoDevolucao promocaoDevolucao;
    public ConsultaDiariaObjeto janelapaiConsulta;
    public List<Diaria> generos;
    public AcessoUsuario acesso;
    public List<Diaria> itensPromocaoLocacao;
    public List<Diaria> itensPromocaoDevolucao;
    public Moeda moeda;
    public MaskFormatter formatoHora;

    /**
     * Creates new form DestinoCadastroGUI
     */
    public CadastroDiaria() {
        initComponents();
        janelapai = null;
        itensPromocaoLocacao = new ArrayList<Diaria>();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox2 = new javax.swing.JCheckBox();
        jb_salvar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jcb_quinta = new javax.swing.JCheckBox();
        jcb_sexta = new javax.swing.JCheckBox();
        jcb_sabado = new javax.swing.JCheckBox();
        jcb_domingo = new javax.swing.JCheckBox();
        jcb_segunda = new javax.swing.JCheckBox();
        jcb_terca = new javax.swing.JCheckBox();
        jcb_quarta = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jtf_nome_diaria = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtf_codigo_diaria = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtf_valor = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jLabel6 = new javax.swing.JLabel();
        jtf_dias = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jLabel7 = new javax.swing.JLabel();
        jtf_relocacao = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jLabel15 = new javax.swing.JLabel();
        jtf_dias_maximo = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jcb_acumulativo = new javax.swing.JCheckBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jtf_valor_promocao_locacao = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jLabel5 = new javax.swing.JLabel();
        jtf_ordem = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jLabel8 = new javax.swing.JLabel();
        jb_eliminar_promocao_locacao = new javax.swing.JButton();
        jb_adicionar_promocao_locacao = new javax.swing.JButton();
        jtf_descricao_locacao = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jLabel12 = new javax.swing.JLabel();
        jcb_a_vista_locacao = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        jtf_locar_quantidade = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jtf_ganhar_quantidade = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_promocao_locacao = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jb_eliminar_promocao_devolucao = new javax.swing.JButton();
        jb_adicionar_promocao_devolucao = new javax.swing.JButton();
        jtf_descricao_devolucao = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jLabel14 = new javax.swing.JLabel();
        jcb_a_vista_devolucao = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtf_valor_promocao_devolucao = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        try  {
            formatoHora = new MaskFormatter("##:##:##");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");
        }
        jtf_horas_antecipada = new JFormattedTextField(formatoHora);
        try  {
            formatoHora = new MaskFormatter("##:##:##");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");
        }
        jtf_horario_locacao = new JFormattedTextField(formatoHora);
        try  {
            formatoHora = new MaskFormatter("##:##:##");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");
        }
        jtf_horario_devolucao = new JFormattedTextField(formatoHora);
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_promocao_devolucao = new javax.swing.JTable();

        jCheckBox2.setText("jCheckBox2");
        jCheckBox2.setName("jCheckBox2"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrando Diária");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
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
        jb_salvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_salvarKeyPressed(evt);
            }
        });
        getContentPane().add(jb_salvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, -1, 35));

        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/exit.png"))); // NOI18N
        jb_cancelar.setText("Sair");
        jb_cancelar.setName("jb_cancelar"); // NOI18N
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, -1, 35));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dias de Promoção"));
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jcb_quinta.setSelected(true);
        jcb_quinta.setText("Quinta");
        jcb_quinta.setName("jcb_quinta"); // NOI18N
        jPanel1.add(jcb_quinta, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        jcb_sexta.setSelected(true);
        jcb_sexta.setText("Sexta");
        jcb_sexta.setName("jcb_sexta"); // NOI18N
        jPanel1.add(jcb_sexta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, -1, -1));

        jcb_sabado.setSelected(true);
        jcb_sabado.setText("Sábado");
        jcb_sabado.setName("jcb_sabado"); // NOI18N
        jPanel1.add(jcb_sabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, -1, -1));

        jcb_domingo.setSelected(true);
        jcb_domingo.setText("Domingo");
        jcb_domingo.setName("jcb_domingo"); // NOI18N
        jcb_domingo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_domingoActionPerformed(evt);
            }
        });
        jPanel1.add(jcb_domingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jcb_segunda.setSelected(true);
        jcb_segunda.setText("Segunda");
        jcb_segunda.setName("jcb_segunda"); // NOI18N
        jPanel1.add(jcb_segunda, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        jcb_terca.setSelected(true);
        jcb_terca.setText("Terça");
        jcb_terca.setName("jcb_terca"); // NOI18N
        jPanel1.add(jcb_terca, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        jcb_quarta.setSelected(true);
        jcb_quarta.setText("Quarta");
        jcb_quarta.setName("jcb_quarta"); // NOI18N
        jPanel1.add(jcb_quarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 370, 130));

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtf_nome_diaria.setName("jtf_nome_diaria"); // NOI18N
        jtf_nome_diaria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_nome_diariaKeyPressed(evt);
            }
        });
        jPanel2.add(jtf_nome_diaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 190, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Nome");
        jLabel3.setName("jLabel3"); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Código Diária");
        jLabel2.setName("jLabel2"); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jtf_codigo_diaria.setEditable(false);
        jtf_codigo_diaria.setName("jtf_codigo_diaria"); // NOI18N
        jPanel2.add(jtf_codigo_diaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 90, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("Valor");
        jLabel4.setName("jLabel4"); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        jtf_nome_diaria.setDocument(new UnaccentedDocument());
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
        jtf_valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_valorKeyPressed(evt);
            }
        });
        jPanel2.add(jtf_valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 90, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setText("Minimo Dias");
        jLabel6.setName("jLabel6"); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jtf_dias.addKeyListener(new java.awt.event.KeyAdapter() {     // cria um listener ouvinte de digitação do fieldNumero
            public void keyReleased(java.awt.event.KeyEvent evt) {  // cria um ouvinte para cada tecla pressionada
                jtf_dias.setText(jtf_dias.getText().replaceAll("[^0-9]", "")); // faz com que pegue o texto a cada tecla digitada, e substituir tudo que não(^) seja numero  por ""
            }   });
            jtf_dias.setText("1");
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
            jPanel2.add(jtf_dias, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 70, -1));

            jLabel7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
            jLabel7.setText("Relocação");
            jLabel7.setName("jLabel7"); // NOI18N
            jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 70, -1));

            jtf_nome_diaria.setDocument(new UnaccentedDocument());
            jtf_relocacao.setText("R$ 0,00");
            jtf_relocacao.setName("jtf_relocacao"); // NOI18N
            jtf_relocacao.addFocusListener(new java.awt.event.FocusAdapter() {
                public void focusGained(java.awt.event.FocusEvent evt) {
                    jtf_relocacaoFocusGained(evt);
                }
                public void focusLost(java.awt.event.FocusEvent evt) {
                    jtf_relocacaoFocusLost(evt);
                }
            });
            jtf_relocacao.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    jtf_relocacaoKeyPressed(evt);
                }
            });
            jPanel2.add(jtf_relocacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 80, -1));

            jLabel15.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
            jLabel15.setText("Máximo Dias");
            jLabel15.setName("jLabel15"); // NOI18N
            jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

            jtf_dias.addKeyListener(new java.awt.event.KeyAdapter() {     // cria um listener ouvinte de digitação do fieldNumero
                public void keyReleased(java.awt.event.KeyEvent evt) {  // cria um ouvinte para cada tecla pressionada
                    jtf_dias.setText(jtf_dias.getText().replaceAll("[^0-9]", "")); // faz com que pegue o texto a cada tecla digitada, e substituir tudo que não(^) seja numero  por ""
                }   });
                jtf_dias_maximo.setText("1");
                jtf_dias_maximo.setName("jtf_dias_maximo"); // NOI18N
                jtf_dias_maximo.addFocusListener(new java.awt.event.FocusAdapter() {
                    public void focusGained(java.awt.event.FocusEvent evt) {
                        jtf_dias_maximoFocusGained(evt);
                    }
                });
                jtf_dias_maximo.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        jtf_dias_maximoKeyPressed(evt);
                    }
                });
                jPanel2.add(jtf_dias_maximo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 70, -1));

                jcb_acumulativo.setText("Acumulativo");
                jcb_acumulativo.setName("jcb_acumulativo"); // NOI18N
                jPanel2.add(jcb_acumulativo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, -1, -1));

                getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 430, 130));

                jTabbedPane1.setName("jTabbedPane1"); // NOI18N

                jPanel4.setName("jPanel4"); // NOI18N
                jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalhes"));
                jPanel3.setName("jPanel3"); // NOI18N
                jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jtf_nome_diaria.setDocument(new UnaccentedDocument());
                jtf_valor_promocao_locacao.setText("R$ 0,00");
                jtf_valor_promocao_locacao.setName("jtf_valor_promocao_locacao"); // NOI18N
                jtf_valor_promocao_locacao.addFocusListener(new java.awt.event.FocusAdapter() {
                    public void focusGained(java.awt.event.FocusEvent evt) {
                        jtf_valor_promocao_locacaoFocusGained(evt);
                    }
                    public void focusLost(java.awt.event.FocusEvent evt) {
                        jtf_valor_promocao_locacaoFocusLost(evt);
                    }
                });
                jtf_valor_promocao_locacao.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        jtf_valor_promocao_locacaoKeyPressed(evt);
                    }
                });
                jPanel3.add(jtf_valor_promocao_locacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 100, 30));

                jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
                jLabel5.setText("Valor Promoção");
                jLabel5.setName("jLabel5"); // NOI18N
                jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, 20));

                jtf_ordem.addKeyListener(new java.awt.event.KeyAdapter() {     // cria um listener ouvinte de digitação do fieldNumero
                    public void keyReleased(java.awt.event.KeyEvent evt) {  // cria um ouvinte para cada tecla pressionada
                        jtf_ordem.setText(jtf_ordem.getText().replaceAll("[^0-9]", "")); // faz com que pegue o texto a cada tecla digitada, e substituir tudo que não(^) seja numero  por ""
                    }   });
                    jtf_ordem.setName("jtf_ordem"); // NOI18N
                    jtf_ordem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jtf_ordemActionPerformed(evt);
                        }
                    });
                    jtf_ordem.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusGained(java.awt.event.FocusEvent evt) {
                            jtf_ordemFocusGained(evt);
                        }
                    });
                    jtf_ordem.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                            jtf_ordemKeyPressed(evt);
                        }
                    });
                    jPanel3.add(jtf_ordem, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 50, -1));

                    jLabel8.setText("Ordem");
                    jLabel8.setName("jLabel8"); // NOI18N
                    jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, 20));

                    jb_eliminar_promocao_locacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/edit_remove.png"))); // NOI18N
                    jb_eliminar_promocao_locacao.setToolTipText("Excluir");
                    jb_eliminar_promocao_locacao.setName("jb_eliminar_promocao_locacao"); // NOI18N
                    jb_eliminar_promocao_locacao.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jb_eliminar_promocao_locacaoActionPerformed(evt);
                        }
                    });
                    jb_eliminar_promocao_locacao.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                            jb_eliminar_promocao_locacaoKeyPressed(evt);
                        }
                    });
                    jPanel3.add(jb_eliminar_promocao_locacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, 30, 30));

                    jb_adicionar_promocao_locacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/edit_add.png"))); // NOI18N
                    jb_adicionar_promocao_locacao.setToolTipText("Incluir");
                    jb_adicionar_promocao_locacao.setName("jb_adicionar_promocao_locacao"); // NOI18N
                    jb_adicionar_promocao_locacao.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jb_adicionar_promocao_locacaoActionPerformed(evt);
                        }
                    });
                    jb_adicionar_promocao_locacao.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                            jb_adicionar_promocao_locacaoKeyPressed(evt);
                        }
                    });
                    jPanel3.add(jb_adicionar_promocao_locacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 30, 30));

                    jtf_nome_diaria.setDocument(new UnaccentedDocument());
                    jtf_descricao_locacao.setName("jtf_descricao_locacao"); // NOI18N
                    jtf_descricao_locacao.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusGained(java.awt.event.FocusEvent evt) {
                            jtf_descricao_locacaoFocusGained(evt);
                        }
                    });
                    jtf_descricao_locacao.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                            jtf_descricao_locacaoKeyPressed(evt);
                        }
                    });
                    jPanel3.add(jtf_descricao_locacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 220, -1));

                    jLabel12.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
                    jLabel12.setText("Descrição");
                    jLabel12.setName("jLabel12"); // NOI18N
                    jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

                    jcb_a_vista_locacao.setText("Aplicar esta promoção apenas para pagamentos à vista.");
                    jcb_a_vista_locacao.setName("jcb_a_vista_locacao"); // NOI18N
                    jPanel3.add(jcb_a_vista_locacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

                    jLabel16.setText("Locar Qtd.");
                    jLabel16.setName("jLabel16"); // NOI18N
                    jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

                    jtf_locar_quantidade.addKeyListener(new java.awt.event.KeyAdapter() {     // cria um listener ouvinte de digitação do fieldNumero
                        public void keyReleased(java.awt.event.KeyEvent evt) {  // cria um ouvinte para cada tecla pressionada
                            jtf_locar_quantidade.setText(jtf_locar_quantidade.getText().replaceAll("[^0-9]", "")); // faz com que pegue o texto a cada tecla digitada, e substituir tudo que não(^) seja numero  por ""
                        }   });
                        jtf_locar_quantidade.setName("jtf_locar_quantidade"); // NOI18N
                        jtf_locar_quantidade.addFocusListener(new java.awt.event.FocusAdapter() {
                            public void focusGained(java.awt.event.FocusEvent evt) {
                                jtf_locar_quantidadeFocusGained(evt);
                            }
                        });
                        jtf_locar_quantidade.addKeyListener(new java.awt.event.KeyAdapter() {
                            public void keyPressed(java.awt.event.KeyEvent evt) {
                                jtf_locar_quantidadeKeyPressed(evt);
                            }
                        });
                        jPanel3.add(jtf_locar_quantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 70, -1));

                        jtf_ganhar_quantidade.addKeyListener(new java.awt.event.KeyAdapter() {     // cria um listener ouvinte de digitação do fieldNumero
                            public void keyReleased(java.awt.event.KeyEvent evt) {  // cria um ouvinte para cada tecla pressionada
                                jtf_ganhar_quantidade.setText(jtf_ganhar_quantidade.getText().replaceAll("[^0-9]", "")); // faz com que pegue o texto a cada tecla digitada, e substituir tudo que não(^) seja numero  por ""
                            }   });
                            jtf_ganhar_quantidade.setName("jtf_ganhar_quantidade"); // NOI18N
                            jtf_ganhar_quantidade.addFocusListener(new java.awt.event.FocusAdapter() {
                                public void focusGained(java.awt.event.FocusEvent evt) {
                                    jtf_ganhar_quantidadeFocusGained(evt);
                                }
                            });
                            jtf_ganhar_quantidade.addKeyListener(new java.awt.event.KeyAdapter() {
                                public void keyPressed(java.awt.event.KeyEvent evt) {
                                    jtf_ganhar_quantidadeKeyPressed(evt);
                                }
                            });
                            jPanel3.add(jtf_ganhar_quantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 70, -1));

                            jLabel17.setText("Ganha Qtd.");
                            jLabel17.setName("jLabel17"); // NOI18N
                            jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, -1, -1));

                            jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 770, 100));

                            jScrollPane1.setName("jScrollPane1"); // NOI18N

                            jtbl_promocao_locacao.setModel(new javax.swing.table.DefaultTableModel(
                                new Object [][] {

                                },
                                new String [] {
                                    "Código", "Descrição", "Locar Qtd.", "Ganhar Qtd.", "Valor Promoção", "À vista", "Ordem"
                                }
                            ) {
                                Class[] types = new Class [] {
                                    java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class
                                };
                                boolean[] canEdit = new boolean [] {
                                    false, false, false, false, false, false, false
                                };

                                public Class getColumnClass(int columnIndex) {
                                    return types [columnIndex];
                                }

                                public boolean isCellEditable(int rowIndex, int columnIndex) {
                                    return canEdit [columnIndex];
                                }
                            });
                            jtbl_promocao_locacao.setName("jtbl_promocao_locacao"); // NOI18N
                            jtbl_promocao_locacao.addMouseListener(new java.awt.event.MouseAdapter() {
                                public void mouseClicked(java.awt.event.MouseEvent evt) {
                                    jtbl_promocao_locacaoMouseClicked(evt);
                                }
                            });
                            jtbl_promocao_locacao.addKeyListener(new java.awt.event.KeyAdapter() {
                                public void keyPressed(java.awt.event.KeyEvent evt) {
                                    jtbl_promocao_locacaoKeyPressed(evt);
                                }
                            });
                            jScrollPane1.setViewportView(jtbl_promocao_locacao);
                            if (jtbl_promocao_locacao.getColumnModel().getColumnCount() > 0) {
                                jtbl_promocao_locacao.getColumnModel().getColumn(0).setPreferredWidth(5);
                                jtbl_promocao_locacao.getColumnModel().getColumn(1).setPreferredWidth(150);
                                jtbl_promocao_locacao.getColumnModel().getColumn(2).setPreferredWidth(20);
                                jtbl_promocao_locacao.getColumnModel().getColumn(3).setPreferredWidth(20);
                                jtbl_promocao_locacao.getColumnModel().getColumn(4).setPreferredWidth(40);
                                jtbl_promocao_locacao.getColumnModel().getColumn(5).setPreferredWidth(20);
                                jtbl_promocao_locacao.getColumnModel().getColumn(6).setPreferredWidth(20);
                            }

                            jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 770, 150));

                            jLabel1.setText("* Selecione item na Tabela para verificar dias de promoção");
                            jLabel1.setName("jLabel1"); // NOI18N
                            jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

                            jTabbedPane1.addTab("Promoção Locação", jPanel4);

                            jPanel5.setName("jPanel5"); // NOI18N
                            jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                            jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalhes"));
                            jPanel6.setName("jPanel6"); // NOI18N
                            jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                            jLabel9.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
                            jLabel9.setText("Horário Locação");
                            jLabel9.setName("jLabel9"); // NOI18N
                            jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, 20));

                            jb_eliminar_promocao_devolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/edit_remove.png"))); // NOI18N
                            jb_eliminar_promocao_devolucao.setToolTipText("Excluir");
                            jb_eliminar_promocao_devolucao.setName("jb_eliminar_promocao_devolucao"); // NOI18N
                            jb_eliminar_promocao_devolucao.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    jb_eliminar_promocao_devolucaoActionPerformed(evt);
                                }
                            });
                            jb_eliminar_promocao_devolucao.addKeyListener(new java.awt.event.KeyAdapter() {
                                public void keyPressed(java.awt.event.KeyEvent evt) {
                                    jb_eliminar_promocao_devolucaoKeyPressed(evt);
                                }
                            });
                            jPanel6.add(jb_eliminar_promocao_devolucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 40, 30, 30));

                            jb_adicionar_promocao_devolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/edit_add.png"))); // NOI18N
                            jb_adicionar_promocao_devolucao.setToolTipText("Incluir");
                            jb_adicionar_promocao_devolucao.setName("jb_adicionar_promocao_devolucao"); // NOI18N
                            jb_adicionar_promocao_devolucao.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    jb_adicionar_promocao_devolucaoActionPerformed(evt);
                                }
                            });
                            jb_adicionar_promocao_devolucao.addKeyListener(new java.awt.event.KeyAdapter() {
                                public void keyPressed(java.awt.event.KeyEvent evt) {
                                    jb_adicionar_promocao_devolucaoKeyPressed(evt);
                                }
                            });
                            jPanel6.add(jb_adicionar_promocao_devolucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 40, 30, 30));

                            jtf_nome_diaria.setDocument(new UnaccentedDocument());
                            jtf_descricao_devolucao.setName("jtf_descricao_devolucao"); // NOI18N
                            jtf_descricao_devolucao.addFocusListener(new java.awt.event.FocusAdapter() {
                                public void focusGained(java.awt.event.FocusEvent evt) {
                                    jtf_descricao_devolucaoFocusGained(evt);
                                }
                            });
                            jtf_descricao_devolucao.addKeyListener(new java.awt.event.KeyAdapter() {
                                public void keyPressed(java.awt.event.KeyEvent evt) {
                                    jtf_descricao_devolucaoKeyPressed(evt);
                                }
                            });
                            jPanel6.add(jtf_descricao_devolucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 210, -1));

                            jLabel14.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
                            jLabel14.setText("Descrição");
                            jLabel14.setName("jLabel14"); // NOI18N
                            jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

                            jcb_a_vista_devolucao.setText("Aplicar esta promoção apenas para pagamentos à vista.");
                            jcb_a_vista_devolucao.setName("jcb_a_vista_devolucao"); // NOI18N
                            jPanel6.add(jcb_a_vista_devolucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

                            jLabel18.setText("Horas antecipada");
                            jLabel18.setName("jLabel18"); // NOI18N
                            jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, -1, 20));

                            jLabel10.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
                            jLabel10.setText("Horário Devolução");
                            jLabel10.setName("jLabel10"); // NOI18N
                            jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, 20));

                            jLabel11.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
                            jLabel11.setText("Valor");
                            jLabel11.setName("jLabel11"); // NOI18N
                            jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, -1, 20));

                            jtf_nome_diaria.setDocument(new UnaccentedDocument());
                            jtf_valor_promocao_devolucao.setText("R$ 0,00");
                            jtf_valor_promocao_devolucao.setName("jtf_valor_promocao_devolucao"); // NOI18N
                            jtf_valor_promocao_devolucao.addFocusListener(new java.awt.event.FocusAdapter() {
                                public void focusGained(java.awt.event.FocusEvent evt) {
                                    jtf_valor_promocao_devolucaoFocusGained(evt);
                                }
                                public void focusLost(java.awt.event.FocusEvent evt) {
                                    jtf_valor_promocao_devolucaoFocusLost(evt);
                                }
                            });
                            jtf_valor_promocao_devolucao.addKeyListener(new java.awt.event.KeyAdapter() {
                                public void keyPressed(java.awt.event.KeyEvent evt) {
                                    jtf_valor_promocao_devolucaoKeyPressed(evt);
                                }
                                public void keyReleased(java.awt.event.KeyEvent evt) {
                                    jtf_valor_promocao_devolucaoKeyReleased(evt);
                                }
                            });
                            jPanel6.add(jtf_valor_promocao_devolucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 90, 30));

                            jtf_horas_antecipada.setText("00:00:00");
                            jtf_horas_antecipada.setName("jtf_horas_antecipada"); // NOI18N
                            jtf_horas_antecipada.addFocusListener(new java.awt.event.FocusAdapter() {
                                public void focusLost(java.awt.event.FocusEvent evt) {
                                    jtf_horas_antecipadaFocusLost(evt);
                                }
                            });
                            jtf_horas_antecipada.addKeyListener(new java.awt.event.KeyAdapter() {
                                public void keyPressed(java.awt.event.KeyEvent evt) {
                                    jtf_horas_antecipadaKeyPressed(evt);
                                }
                            });
                            jPanel6.add(jtf_horas_antecipada, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 100, 30));

                            jtf_horario_locacao.setText("00:00:00");
                            jtf_horario_locacao.setName("jtf_horario_locacao"); // NOI18N
                            jtf_horario_locacao.addFocusListener(new java.awt.event.FocusAdapter() {
                                public void focusLost(java.awt.event.FocusEvent evt) {
                                    jtf_horario_locacaoFocusLost(evt);
                                }
                            });
                            jtf_horario_locacao.addKeyListener(new java.awt.event.KeyAdapter() {
                                public void keyTyped(java.awt.event.KeyEvent evt) {
                                    jtf_horario_locacaoKeyTyped(evt);
                                }
                                public void keyPressed(java.awt.event.KeyEvent evt) {
                                    jtf_horario_locacaoKeyPressed(evt);
                                }
                            });
                            jPanel6.add(jtf_horario_locacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 100, 30));

                            jtf_horario_devolucao.setText("00:00:00");
                            jtf_horario_devolucao.setName("jtf_horario_devolucao"); // NOI18N
                            jtf_horario_devolucao.addFocusListener(new java.awt.event.FocusAdapter() {
                                public void focusLost(java.awt.event.FocusEvent evt) {
                                    jtf_horario_devolucaoFocusLost(evt);
                                }
                            });
                            jtf_horario_devolucao.addKeyListener(new java.awt.event.KeyAdapter() {
                                public void keyPressed(java.awt.event.KeyEvent evt) {
                                    jtf_horario_devolucaoKeyPressed(evt);
                                }
                            });
                            jPanel6.add(jtf_horario_devolucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 100, 30));

                            jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 770, 100));

                            jScrollPane2.setName("jScrollPane2"); // NOI18N

                            jtbl_promocao_devolucao.setModel(new javax.swing.table.DefaultTableModel(
                                new Object [][] {

                                },
                                new String [] {
                                    "Código", "Descrição", "Horário Locação", "Horário Devolução", "Horas Antecipada", "Valor Promoção", "À vista"
                                }
                            ) {
                                Class[] types = new Class [] {
                                    java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
                                };
                                boolean[] canEdit = new boolean [] {
                                    false, false, false, false, false, false, false
                                };

                                public Class getColumnClass(int columnIndex) {
                                    return types [columnIndex];
                                }

                                public boolean isCellEditable(int rowIndex, int columnIndex) {
                                    return canEdit [columnIndex];
                                }
                            });
                            jtbl_promocao_devolucao.setName("jtbl_promocao_devolucao"); // NOI18N
                            jtbl_promocao_devolucao.addMouseListener(new java.awt.event.MouseAdapter() {
                                public void mouseClicked(java.awt.event.MouseEvent evt) {
                                    jtbl_promocao_devolucaoMouseClicked(evt);
                                }
                            });
                            jtbl_promocao_devolucao.addKeyListener(new java.awt.event.KeyAdapter() {
                                public void keyPressed(java.awt.event.KeyEvent evt) {
                                    jtbl_promocao_devolucaoKeyPressed(evt);
                                }
                            });
                            jScrollPane2.setViewportView(jtbl_promocao_devolucao);
                            if (jtbl_promocao_devolucao.getColumnModel().getColumnCount() > 0) {
                                jtbl_promocao_devolucao.getColumnModel().getColumn(0).setPreferredWidth(5);
                                jtbl_promocao_devolucao.getColumnModel().getColumn(1).setPreferredWidth(150);
                                jtbl_promocao_devolucao.getColumnModel().getColumn(2).setPreferredWidth(50);
                                jtbl_promocao_devolucao.getColumnModel().getColumn(3).setPreferredWidth(50);
                                jtbl_promocao_devolucao.getColumnModel().getColumn(4).setPreferredWidth(50);
                                jtbl_promocao_devolucao.getColumnModel().getColumn(5).setPreferredWidth(40);
                                jtbl_promocao_devolucao.getColumnModel().getColumn(6).setPreferredWidth(20);
                            }

                            jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 770, 160));

                            jTabbedPane1.addTab("Promoção Devolução", jPanel5);

                            getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 830, 350));

                            setSize(new java.awt.Dimension(854, 576));
                            setLocationRelativeTo(null);
                        }// </editor-fold>//GEN-END:initComponents

    private void jb_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salvarActionPerformed
        enviaDados();
    }//GEN-LAST:event_jb_salvarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtf_nome_diaria.requestFocus();
        this.setEnabled(true);
    }//GEN-LAST:event_formWindowOpened

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        janelapai.setStatusTela(true);
        setVisible(false);
        janelapai.enviaDados();
    }//GEN-LAST:event_jb_cancelarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        janelapai.setStatusTela(true);
        setVisible(false);
        janelapai.enviaDados();
    }//GEN-LAST:event_formWindowClosed

    private void jtf_valorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valorFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valorFocusGained

    private void jtf_valorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_dias.requestFocus();
        }
        acionarAtalho(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valorKeyPressed

    private void jtf_valor_promocao_locacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_promocao_locacaoFocusGained
        jtf_valor_promocao_locacao.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_promocao_locacaoFocusGained

    private void jtf_valor_promocao_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valor_promocao_locacaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_locar_quantidade.requestFocus();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_promocao_locacaoKeyPressed

    private void jtf_diasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_diasFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_diasFocusGained

    private void jtf_diasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_diasKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_dias_maximo.requestFocus();
        }
        acionarAtalho(evt);

        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_diasKeyPressed

    private void jtf_relocacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_relocacaoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_relocacaoFocusGained

    private void jtf_relocacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_relocacaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (jtf_relocacao.getText().equals("")) {
                jtf_relocacao.setText("R$ 0,00");
            } else {
                moeda = new Moeda();
                jtf_relocacao.setText(moeda.setPrecoFormat(jtf_relocacao.getText()));
            }
            jb_salvar.requestFocus();
        }

        acionarAtalho(evt);
// TODO add your handling code here:
    }//GEN-LAST:event_jtf_relocacaoKeyPressed

    private void jcb_domingoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_domingoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_domingoActionPerformed

    private void jtf_nome_diariaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nome_diariaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_valor.requestFocus();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nome_diariaKeyPressed

    private void jtf_ordemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_ordemFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_ordemFocusGained

    private void jtf_ordemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_ordemKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_adicionar_promocao_locacao.requestFocus();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_ordemKeyPressed

    private void jtf_ordemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_ordemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_ordemActionPerformed

    private void jb_adicionar_promocao_locacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_adicionar_promocao_locacaoActionPerformed
        adicionarPromocaoLocacao();
    }//GEN-LAST:event_jb_adicionar_promocao_locacaoActionPerformed

    private void jb_adicionar_promocao_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_adicionar_promocao_locacaoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            adicionarPromocaoLocacao();

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_adicionar_promocao_locacaoKeyPressed

    private void jb_eliminar_promocao_locacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_eliminar_promocao_locacaoActionPerformed

        excluirPromocaoLocacao();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_eliminar_promocao_locacaoActionPerformed

    private void jtf_descricao_locacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_descricao_locacaoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_descricao_locacaoFocusGained

    private void jtf_descricao_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_descricao_locacaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_valor_promocao_locacao.requestFocus();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_descricao_locacaoKeyPressed

    private void jtf_valor_promocao_locacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_promocao_locacaoFocusLost
        if (jtf_valor_promocao_locacao.getText().equals("")) {
            jtf_valor_promocao_locacao.setText("R$ 0,00");
        } else {
            moeda = new Moeda();
            jtf_valor_promocao_locacao.setText(moeda.setPrecoFormat(jtf_valor_promocao_locacao.getText()));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_promocao_locacaoFocusLost

    private void jtf_dias_maximoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_dias_maximoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_dias_maximoFocusGained

    private void jtf_dias_maximoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_dias_maximoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_relocacao.requestFocus();
        }
        acionarAtalho(evt);

        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_dias_maximoKeyPressed

    private void jtf_locar_quantidadeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_locar_quantidadeFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_locar_quantidadeFocusGained

    private void jtf_locar_quantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_locar_quantidadeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_ganhar_quantidade.requestFocus();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_locar_quantidadeKeyPressed

    private void jtf_ganhar_quantidadeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_ganhar_quantidadeFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_ganhar_quantidadeFocusGained

    private void jtf_ganhar_quantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_ganhar_quantidadeKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_ordem.requestFocus();
        }
        acionarAtalho(evt);// TODO add your handling code here:
    }//GEN-LAST:event_jtf_ganhar_quantidadeKeyPressed

    private void jb_eliminar_promocao_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_eliminar_promocao_locacaoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            excluirPromocaoLocacao();

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_eliminar_promocao_locacaoKeyPressed

    private void jtf_valorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valorFocusLost
        if (jtf_valor.getText().equals("")) {
            jtf_valor.setText("R$ 0,00");
        } else {
            moeda = new Moeda();
            jtf_valor.setText(moeda.setPrecoFormat(jtf_valor.getText()));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valorFocusLost

    private void jtf_relocacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_relocacaoFocusLost
        if (jtf_relocacao.getText().equals("")) {
            jtf_relocacao.setText("R$ 0,00");
        } else {
            moeda = new Moeda();
            jtf_relocacao.setText(moeda.setPrecoFormat(jtf_relocacao.getText()));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_relocacaoFocusLost

    private void jb_salvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_salvarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            enviaDados();
        }
        acionarAtalho(evt);

        // TODO add your handling code here:
    }//GEN-LAST:event_jb_salvarKeyPressed

    private void jtbl_promocao_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_promocao_locacaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jcb_domingo.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getDomingo());
            jcb_segunda.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getSegunda());
            jcb_terca.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getTerca());
            jcb_quarta.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getQuarta());
            jcb_quinta.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getQuinta());
            jcb_sexta.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getSexta());
            jcb_sabado.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getSabado());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_promocao_locacaoKeyPressed

    private void jtbl_promocao_locacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_promocao_locacaoMouseClicked
        jcb_domingo.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getDomingo());
        jcb_segunda.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getSegunda());
        jcb_terca.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getTerca());
        jcb_quarta.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getQuarta());
        jcb_quinta.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getQuinta());
        jcb_sexta.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getSexta());
        jcb_sabado.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getSabado());
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_promocao_locacaoMouseClicked

    private void jb_eliminar_promocao_devolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_eliminar_promocao_devolucaoActionPerformed
        excluirPromocaoDevolucao();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_eliminar_promocao_devolucaoActionPerformed

    private void jb_eliminar_promocao_devolucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_eliminar_promocao_devolucaoKeyPressed
                acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            excluirPromocaoDevolucao();

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_eliminar_promocao_devolucaoKeyPressed

    private void jb_adicionar_promocao_devolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_adicionar_promocao_devolucaoActionPerformed
        adicionarPromocaoDevolucao();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_adicionar_promocao_devolucaoActionPerformed

    private void jb_adicionar_promocao_devolucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_adicionar_promocao_devolucaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            adicionarPromocaoDevolucao();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_adicionar_promocao_devolucaoKeyPressed

    private void jtf_descricao_devolucaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_descricao_devolucaoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_descricao_devolucaoFocusGained

    private void jtf_descricao_devolucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_descricao_devolucaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_horario_locacao.requestFocus();
        }
        acionarAtalho(evt);

        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_descricao_devolucaoKeyPressed

    private void jtbl_promocao_devolucaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_promocao_devolucaoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_promocao_devolucaoMouseClicked

    private void jtbl_promocao_devolucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_promocao_devolucaoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_promocao_devolucaoKeyPressed

    private void jtf_valor_promocao_devolucaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_promocao_devolucaoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_promocao_devolucaoFocusGained

    private void jtf_valor_promocao_devolucaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_promocao_devolucaoFocusLost
        if (jtf_valor_promocao_devolucao.getText().equals("")) {
            jtf_valor_promocao_devolucao.setText("R$ 0,00");
        } else {
            moeda = new Moeda();
            jtf_valor_promocao_devolucao.setText(moeda.setPrecoFormat(jtf_valor_promocao_devolucao.getText()));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_promocao_devolucaoFocusLost

    private void jtf_valor_promocao_devolucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valor_promocao_devolucaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_adicionar_promocao_devolucao.requestFocus();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_promocao_devolucaoKeyPressed

    private void jtf_horas_antecipadaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_horas_antecipadaFocusLost
        jtf_horas_antecipada.setText(validarHora(jtf_horas_antecipada.getText()));
    }//GEN-LAST:event_jtf_horas_antecipadaFocusLost

    private void jtf_horas_antecipadaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_horas_antecipadaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_valor_promocao_devolucao.requestFocus();
        }
        acionarAtalho(evt);

        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_horas_antecipadaKeyPressed

    private void jtf_horario_locacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_horario_locacaoFocusLost
        jtf_horario_locacao.setText(validarHora(jtf_horario_locacao.getText()));
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_horario_locacaoFocusLost

    private void jtf_horario_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_horario_locacaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_horario_devolucao.requestFocus();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_horario_locacaoKeyPressed

    private void jtf_horario_devolucaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_horario_devolucaoFocusLost
        jtf_horario_devolucao.setText(validarHora(jtf_horario_devolucao.getText()));
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_horario_devolucaoFocusLost

    private void jtf_horario_devolucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_horario_devolucaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_horas_antecipada.requestFocus();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_horario_devolucaoKeyPressed

    private void jtf_horario_locacaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_horario_locacaoKeyTyped

// TODO add your handling code here:
    }//GEN-LAST:event_jtf_horario_locacaoKeyTyped

    private void jtf_valor_promocao_devolucaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valor_promocao_devolucaoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_promocao_devolucaoKeyReleased
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CadastroDiaria().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jb_adicionar_promocao_devolucao;
    private javax.swing.JButton jb_adicionar_promocao_locacao;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_eliminar_promocao_devolucao;
    private javax.swing.JButton jb_eliminar_promocao_locacao;
    private javax.swing.JButton jb_salvar;
    private javax.swing.JCheckBox jcb_a_vista_devolucao;
    private javax.swing.JCheckBox jcb_a_vista_locacao;
    public static javax.swing.JCheckBox jcb_acumulativo;
    public static javax.swing.JCheckBox jcb_domingo;
    public static javax.swing.JCheckBox jcb_quarta;
    public static javax.swing.JCheckBox jcb_quinta;
    public static javax.swing.JCheckBox jcb_sabado;
    public static javax.swing.JCheckBox jcb_segunda;
    public static javax.swing.JCheckBox jcb_sexta;
    public static javax.swing.JCheckBox jcb_terca;
    private javax.swing.JTable jtbl_promocao_devolucao;
    private javax.swing.JTable jtbl_promocao_locacao;
    public static javax.swing.JTextField jtf_codigo_diaria;
    public static javax.swing.JTextField jtf_descricao_devolucao;
    public static javax.swing.JTextField jtf_descricao_locacao;
    public static javax.swing.JTextField jtf_dias;
    public static javax.swing.JTextField jtf_dias_maximo;
    public static javax.swing.JTextField jtf_ganhar_quantidade;
    public static javax.swing.JFormattedTextField jtf_horario_devolucao;
    public static javax.swing.JFormattedTextField jtf_horario_locacao;
    public static javax.swing.JFormattedTextField jtf_horas_antecipada;
    public static javax.swing.JTextField jtf_locar_quantidade;
    public static javax.swing.JTextField jtf_nome_diaria;
    public static javax.swing.JTextField jtf_ordem;
    public static javax.swing.JTextField jtf_relocacao;
    public static javax.swing.JTextField jtf_valor;
    public static javax.swing.JTextField jtf_valor_promocao_devolucao;
    public static javax.swing.JTextField jtf_valor_promocao_locacao;
    // End of variables declaration//GEN-END:variables

    private void retornaJanelaPai() {
        setVisible(false);

        if (janelapai != null) {
            janelapai.setEnabled(true);
            janelapai.setVisible(true);
            janelapai.request();
        }
        if (janelapaiConsulta != null) {
            janelapaiConsulta.setEnabled(true);
            janelapaiConsulta.setVisible(true);

        }

    }

    InterfacePool pool;
    SiscomController controller;

    private void enviaDados() {
        if (verificarCampos()) {
            controller = new SiscomController();
            controller.processarRequisicao("cadastrarDiaria");
            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
            jtf_descricao_locacao.requestFocus();
//            retornaJanelaPai();
        }
    }

    public boolean verificarCampos() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_nome_diaria.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Descrição\n";
        }
        if (jtf_valor.getText().trim().equals("") || jtf_valor.getText().trim().equals("R$ 0,00")) {
            msgERRO = msgERRO + " *Valor Locação\n";
        }
        if (jtf_relocacao.getText().trim().equals("") || jtf_relocacao.getText().trim().equals("R$ 0,00")) {
            msgERRO = msgERRO + " *Valor Relocação\n";
        }
        if (Integer.parseInt(jtf_dias.getText()) < 0) {
            msgERRO = msgERRO + " *Dias\n";
        }
        if (Integer.parseInt(jtf_dias_maximo.getText()) < 0) {
            msgERRO = msgERRO + " *Dias Máximo\n";
        }
        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            return false;
        } else {
            return true;
        }

    }

    public void acionarAtalho(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F10) {
            enviaDados();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            setVisible(false);
            janelapai.setStatusTela(true);
        }
    }

    public boolean verificarCamposPromocaoLocacao() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_descricao_locacao.getText().equals("")) {
            msgERRO = msgERRO + " *Descrição Promoção\n";
        }
        if (jtf_valor_promocao_locacao.getText().equals("") || jtf_valor_promocao_locacao.getText().equals("R$ 0,00")) {
            msgERRO = msgERRO + " *Valor Promoção\n";
        }
        if (Integer.parseInt(jtf_locar_quantidade.getText()) < 0) {
            msgERRO = msgERRO + " *Locar Quantidade\n";
        }
        if (Integer.parseInt(jtf_ganhar_quantidade.getText()) < 0) {
            msgERRO = msgERRO + " *Ganhar Quantidade\n";
        }
        if (jtf_ordem.getText().equals("")) {
            msgERRO = msgERRO + " *Ordem\n";
        }
        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);

            return false;
        } else {
            return true;
        }

    }

    public boolean verificarCamposPromocaoDevolucao() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_descricao_devolucao.getText().equals("")) {
            msgERRO = msgERRO + " *Descrição Promoção Devolução\n";
        }
        if (jtf_valor_promocao_devolucao.getText().equals("") || jtf_valor_promocao_devolucao.getText().equals("R$ 0,00")) {
            msgERRO = msgERRO + " *Valor Promoção Devolução\n";
        }

        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);

            return false;
        } else {
            return true;
        }

    }

    public void adicionarPromocaoLocacao() {

        if (jtf_codigo_diaria.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Salvar primeiro a Diária");
        } else {
            if (verificarCamposPromocaoLocacao() == true) {
                diaria = new Diaria();
                diaria.setCodigo_diaria(Integer.parseInt(jtf_codigo_diaria.getText()));

                moeda = new Moeda();

                promocaoLocacao = new PromocaoLocacao();
                promocaoLocacao.setDiaria(diaria);
                promocaoLocacao.setDescricao(jtf_descricao_locacao.getText());
                promocaoLocacao.setValor_promocao_locacao(moeda.getPrecoFormato(jtf_valor_promocao_locacao.getText()));
                promocaoLocacao.setOrderm(Integer.parseInt(jtf_ordem.getText()));
                promocaoLocacao.setPagamento_a_vista(jcb_a_vista_locacao.isSelected());
                promocaoLocacao.setDomingo(jcb_domingo.isSelected());
                promocaoLocacao.setSegunda(jcb_segunda.isSelected());
                promocaoLocacao.setTerca(jcb_terca.isSelected());
                promocaoLocacao.setQuarta(jcb_quarta.isSelected());
                promocaoLocacao.setQuinta(jcb_quinta.isSelected());
                promocaoLocacao.setSexta(jcb_sexta.isSelected());
                promocaoLocacao.setSabado(jcb_sabado.isSelected());
                promocaoLocacao.setLocar_quantidade(Integer.parseInt(jtf_locar_quantidade.getText()));
                promocaoLocacao.setGanhar_quantidade(Integer.parseInt(jtf_ganhar_quantidade.getText()));

                diaria.setPromocaoLocacao(promocaoLocacao);
                pool = new Pool();
                DiariaDAO diariaDAO = new DiariaDAO(pool);

                diaria = diariaDAO.salvarPromocaoLocacao(diaria);
                diaria.setCodigo_diaria(Integer.parseInt(jtf_codigo_diaria.getText()));
                carregarPromocoesLocacao(diaria);
                itensPromocaoLocacao.add(diaria);

                limparPromocaoLocacao();

            }
        }
    }

    public void adicionarPromocaoDevolucao() {

        if (jtf_codigo_diaria.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Salvar primeiro a Diária");
        } else {
            if (verificarCamposPromocaoDevolucao() == true) {
                diaria = new Diaria();
                diaria.setCodigo_diaria(Integer.parseInt(jtf_codigo_diaria.getText()));

                moeda = new Moeda();

                promocaoDevolucao = new PromocaoDevolucao();
                promocaoDevolucao.setDiaria(diaria);
                promocaoDevolucao.setDescricao(jtf_descricao_devolucao.getText());
                promocaoDevolucao.setValor_promocao_devolucao(moeda.getPrecoFormato(jtf_valor_promocao_devolucao.getText()));
                promocaoDevolucao.setPagamento_a_vista(jcb_a_vista_devolucao.isSelected());
                promocaoDevolucao.setHorario_locacao(jtf_horario_locacao.getText());
                promocaoDevolucao.setHorario_devolucao(jtf_horario_devolucao.getText());
                promocaoDevolucao.setHora_antecipada(jtf_horas_antecipada.getText());

                diaria.setPromocaoDevolucao(promocaoDevolucao);

                pool = new Pool();
                DiariaDAO diariaDAO = new DiariaDAO(pool);

                diaria = diariaDAO.salvarPromocaoDevolucao(diaria);
                diaria.setCodigo_diaria(Integer.parseInt(jtf_codigo_diaria.getText()));
                carregarPromocoesDevolucao(diaria);
                itensPromocaoDevolucao.add(diaria);

                limparPromocaoDevolucao();

            }
        }
    }

    private void limparPromocaoLocacao() {
        jtf_descricao_locacao.setText("");
        jtf_valor_promocao_locacao.setText("R$ 0,00");
        jtf_locar_quantidade.setText("");
        jtf_ganhar_quantidade.setText("");
        jtf_ordem.setText("");
        jtf_descricao_locacao.requestFocus();

    }

    private void limparPromocaoDevolucao() {
        jtf_descricao_devolucao.setText("");
        jtf_valor_promocao_devolucao.setText("R$ 0,00");
        jtf_horario_locacao.setText("00:00");
        jtf_horario_devolucao.setText("00:00");
        jtf_horas_antecipada.setText("00:00");
        jtf_descricao_devolucao.requestFocus();
    }

    private void excluirPromocaoLocacao() {
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        AcessoUsuario acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuDiaria");

        try {

            if (acesso.getDeletar() == 0) {
                DefaultTableModel row = (DefaultTableModel) jtbl_promocao_locacao.getModel();
                if (jtbl_promocao_locacao.getSelectedRow() != -1) {
                    int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
                    if (selectedOption == JOptionPane.YES_NO_OPTION) {
                        pool = new Pool();
                        DiariaDAO diariaDAO = new DiariaDAO(pool);
                        promocaoLocacao = new PromocaoLocacao();
                        promocaoLocacao.setCodigo_promocao_locacao(Integer.parseInt((String) jtbl_promocao_locacao.getValueAt(jtbl_promocao_locacao.getSelectedRow(), 0).toString()));

                        try {
                            diariaDAO.excluirPromocaoLocacao(promocaoLocacao.getCodigo_promocao_locacao());
                            row.removeRow(jtbl_promocao_locacao.getSelectedRow());
                            carregarPromocoesLocacao(diaria);
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Este registro não pode ser excluído pois está referenciado em outra tabela");
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma diária");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }
    }
    
    private void excluirPromocaoDevolucao() {
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        AcessoUsuario acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuDiaria");

        try {

            if (acesso.getDeletar() == 0) {
                DefaultTableModel row = (DefaultTableModel) jtbl_promocao_devolucao.getModel();
                if (jtbl_promocao_devolucao.getSelectedRow() != -1) {
                    int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
                    if (selectedOption == JOptionPane.YES_NO_OPTION) {
                        pool = new Pool();
                        DiariaDAO diariaDAO = new DiariaDAO(pool);
                        promocaoDevolucao = new PromocaoDevolucao();
                        promocaoDevolucao.setCodigo_promocao_devolucao(Integer.parseInt((String) jtbl_promocao_devolucao.getValueAt(jtbl_promocao_devolucao.getSelectedRow(), 0).toString()));

                        try {
                            diariaDAO.excluirPromocaoDevolucao(promocaoDevolucao.getCodigo_promocao_devolucao());
                            row.removeRow(jtbl_promocao_devolucao.getSelectedRow());
                            carregarPromocoesLocacao(diaria);
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Este registro não pode ser excluído pois está referenciado em outra tabela");
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma diária");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }
    }

    public void carregarPromocoesDevolucao(Diaria diaria) {
        DefaultTableModel tableModel = (DefaultTableModel) jtbl_promocao_devolucao.getModel();
        tableModel.setNumRows(0);

        pool = new Pool();
        DiariaDAO diariaDAO = new DiariaDAO(pool);

        itensPromocaoDevolucao = null;
        itensPromocaoDevolucao = diariaDAO.getDiariaPromocaoDevolucao(diaria);

        for (int i = 0; i < itensPromocaoDevolucao.size(); i++) {
            DefaultTableModel row = (DefaultTableModel) jtbl_promocao_devolucao.getModel();
            ItemDbGrid hashDbGrid = new ItemDbGrid(itensPromocaoDevolucao.get(i), itensPromocaoDevolucao.get(i).getPromocaoDevolucao().getDescricao());
            row.addRow(new Object[]{itensPromocaoDevolucao.get(i).getPromocaoDevolucao().getCodigo_promocao_devolucao(), hashDbGrid,
                itensPromocaoDevolucao.get(i).getPromocaoDevolucao().getHorario_locacao(), itensPromocaoDevolucao.get(i).getPromocaoDevolucao().getHorario_devolucao(),
                itensPromocaoDevolucao.get(i).getPromocaoDevolucao().getHora_antecipada(),
                moeda.setPrecoFormat(String.valueOf(itensPromocaoDevolucao.get(i).getPromocaoDevolucao().getValor_promocao_devolucao())),
                itensPromocaoDevolucao.get(i).getPromocaoDevolucao().getPagamento_a_vista()});
        }

    }

    public void carregarPromocoesLocacao(Diaria diaria) {
        DefaultTableModel tableModel = (DefaultTableModel) jtbl_promocao_locacao.getModel();
        tableModel.setNumRows(0);

        pool = new Pool();
        DiariaDAO diariaDAO = new DiariaDAO(pool);

        itensPromocaoLocacao = null;
        itensPromocaoLocacao = diariaDAO.getDiariaPromocao(diaria);

        for (int i = 0; i < itensPromocaoLocacao.size(); i++) {
            DefaultTableModel row = (DefaultTableModel) jtbl_promocao_locacao.getModel();
            ItemDbGrid hashDbGrid = new ItemDbGrid(itensPromocaoLocacao.get(i), itensPromocaoLocacao.get(i).getPromocaoLocacao().getDescricao());
            row.addRow(new Object[]{itensPromocaoLocacao.get(i).getPromocaoLocacao().getCodigo_promocao_locacao(), hashDbGrid,                
                itensPromocaoLocacao.get(i).getPromocaoLocacao().getLocar_quantidade(),
                itensPromocaoLocacao.get(i).getPromocaoLocacao().getGanhar_quantidade(), 
                moeda.setPrecoFormat(String.valueOf(itensPromocaoLocacao.get(i).getPromocaoLocacao().getValor_promocao_locacao())),
                itensPromocaoLocacao.get(i).getPromocaoLocacao().getPagamento_a_vista(),
                itensPromocaoLocacao.get(i).getPromocaoLocacao().getOrderm()});
        }

    }

        public String validarHora(String str) {
        String hora = null;
        String minuto = null;
        String segundos = null;

        try {
            System.out.println("Minutos antes: " + str.substring(2));
            if (Integer.valueOf(str.substring(0, 2)) > 23) {
                hora = "23" + str.substring(2);
            } else {
                hora = str;
            }

            System.out.println("Horas: " + hora);
            System.out.println("Minutos: " + hora.substring(3, 5));
            System.out.println("Segundo: " + hora.substring(6, 8));

            if (Integer.valueOf(hora.substring(3, 5)) > 59) {
                minuto = hora.substring(0, 2) + ":59:" + hora.substring(6, 8);
            } else {
                minuto = hora;
            }
            System.out.println("Minutos depois: " + minuto);
            if (Integer.valueOf(minuto.substring(6, 8)) > 59) {
                segundos = minuto.substring(0, 2) + ":59:"+"59";
            } else {
                segundos = hora;
            }

            System.out.println("Horário final: " + segundos);
        } catch (Exception ex) {
            segundos = "00:00:00";
        }
        return segundos;
    }

}
