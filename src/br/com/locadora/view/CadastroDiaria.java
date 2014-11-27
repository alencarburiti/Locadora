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
import br.com.locadora.model.bean.Promocao;
import br.com.locadora.model.dao.DiariaDAO;
import br.com.locadora.model.dao.UsuarioDAO;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.LimitadorTexto;
import br.com.locadora.util.Moeda;
import br.com.locadora.util.UnaccentedDocument;
import static br.com.locadora.view.AtualizaDiaria.jtf_ganhar_quantidade;
import static br.com.locadora.view.AtualizaDiaria.jtf_locar_quantidade;
import static br.com.locadora.view.AtualizaDiaria.jtf_ordem;
import static br.com.locadora.view.AtualizaDiaria.jtf_relocacao;
import static br.com.locadora.view.AtualizaDiaria.jtf_valor_promocao;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALENCAR
 */
public class CadastroDiaria extends javax.swing.JFrame {

    public MenuDiaria janelapai;
    public Diaria diaria;
    public Promocao promocao;
    public ConsultaDiariaObjeto janelapaiConsulta;
    public List<Diaria> generos;
    public AcessoUsuario acesso;
    public List<Diaria> itensPromocao;
    public Moeda moeda;

    /**
     * Creates new form DestinoCadastroGUI
     */
    public CadastroDiaria() {
        initComponents();
        janelapai = null;
        itensPromocao = new ArrayList<Diaria>();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_promocao = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jtf_valor_promocao = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jLabel5 = new javax.swing.JLabel();
        jtf_ordem = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jLabel8 = new javax.swing.JLabel();
        jb_eliminar1 = new javax.swing.JButton();
        jb_adicionar_promocao = new javax.swing.JButton();
        jtf_descricao_promocao = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jLabel12 = new javax.swing.JLabel();
        jcb_a_vista = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        jtf_hora_antecipada = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jtf_locar_quantidade = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jtf_ganhar_quantidade = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jLabel17 = new javax.swing.JLabel();

        jCheckBox2.setText("jCheckBox2");
        jCheckBox2.setName("jCheckBox2"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrando Diária");
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
        jb_salvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_salvarKeyPressed(evt);
            }
        });
        getContentPane().add(jb_salvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, -1, 35));

        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/exit.png"))); // NOI18N
        jb_cancelar.setText("Cancelar");
        jb_cancelar.setName("jb_cancelar"); // NOI18N
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, -1, 35));

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 360, 130));

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

                jScrollPane1.setName("jScrollPane1"); // NOI18N

                jtbl_promocao.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {

                    },
                    new String [] {
                        "Código", "Descrição", "Valor Promoção", "Hora Antecipada", "Locar Qtd.", "Ganhar Qtd.", "À vista", "Ordem"
                    }
                ) {
                    Class[] types = new Class [] {
                        java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class
                    };
                    boolean[] canEdit = new boolean [] {
                        false, false, false, false, false, false, false, false
                    };

                    public Class getColumnClass(int columnIndex) {
                        return types [columnIndex];
                    }

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                    }
                });
                jtbl_promocao.setName("jtbl_promocao"); // NOI18N
                jScrollPane1.setViewportView(jtbl_promocao);
                if (jtbl_promocao.getColumnModel().getColumnCount() > 0) {
                    jtbl_promocao.getColumnModel().getColumn(0).setPreferredWidth(20);
                    jtbl_promocao.getColumnModel().getColumn(6).setResizable(false);
                    jtbl_promocao.getColumnModel().getColumn(6).setPreferredWidth(20);
                    jtbl_promocao.getColumnModel().getColumn(7).setResizable(false);
                    jtbl_promocao.getColumnModel().getColumn(7).setPreferredWidth(20);
                }

                getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 800, 200));

                jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalhes"));
                jPanel3.setName("jPanel3"); // NOI18N
                jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jtf_nome_diaria.setDocument(new UnaccentedDocument());
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
                jtf_valor_promocao.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        jtf_valor_promocaoKeyPressed(evt);
                    }
                });
                jPanel3.add(jtf_valor_promocao, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 90, 30));

                jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
                jLabel5.setText("Valor Promoção");
                jLabel5.setName("jLabel5"); // NOI18N
                jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, 20));

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
                    jPanel3.add(jtf_ordem, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, 50, -1));

                    jLabel8.setText("Ordem");
                    jLabel8.setName("jLabel8"); // NOI18N
                    jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, -1, 20));

                    jb_eliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/edit_remove.png"))); // NOI18N
                    jb_eliminar1.setToolTipText("Excluir");
                    jb_eliminar1.setName("jb_eliminar1"); // NOI18N
                    jb_eliminar1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jb_eliminar1ActionPerformed(evt);
                        }
                    });
                    jb_eliminar1.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                            jb_eliminar1KeyPressed(evt);
                        }
                    });
                    jPanel3.add(jb_eliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, 30, 30));

                    jb_adicionar_promocao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/edit_add.png"))); // NOI18N
                    jb_adicionar_promocao.setToolTipText("Incluir");
                    jb_adicionar_promocao.setName("jb_adicionar_promocao"); // NOI18N
                    jb_adicionar_promocao.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jb_adicionar_promocaoActionPerformed(evt);
                        }
                    });
                    jb_adicionar_promocao.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                            jb_adicionar_promocaoKeyPressed(evt);
                        }
                    });
                    jPanel3.add(jb_adicionar_promocao, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, 30, 30));

                    jtf_nome_diaria.setDocument(new UnaccentedDocument());
                    jtf_descricao_promocao.setName("jtf_descricao_promocao"); // NOI18N
                    jtf_descricao_promocao.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusGained(java.awt.event.FocusEvent evt) {
                            jtf_descricao_promocaoFocusGained(evt);
                        }
                    });
                    jtf_descricao_promocao.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                            jtf_descricao_promocaoKeyPressed(evt);
                        }
                    });
                    jPanel3.add(jtf_descricao_promocao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 240, -1));

                    jLabel12.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
                    jLabel12.setText("Descrição");
                    jLabel12.setName("jLabel12"); // NOI18N
                    jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

                    jcb_a_vista.setText("Aplicar esta promoção apenas para pagamentos à vista.");
                    jcb_a_vista.setName("jcb_a_vista"); // NOI18N
                    jPanel3.add(jcb_a_vista, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

                    jLabel13.setText("Horas antecipada");
                    jLabel13.setName("jLabel13"); // NOI18N
                    jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, 20));

                    jtf_hora_antecipada.setText("00:00");
                    jtf_hora_antecipada.setName("jtf_hora_antecipada"); // NOI18N
                    jPanel3.add(jtf_hora_antecipada, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 110, 30));

                    jLabel16.setText("Locar Qtd.");
                    jLabel16.setName("jLabel16"); // NOI18N
                    jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, -1, -1));

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
                        jPanel3.add(jtf_locar_quantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 70, -1));

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
                            jPanel3.add(jtf_ganhar_quantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 70, -1));

                            jLabel17.setText("Ganha Qtd.");
                            jLabel17.setName("jLabel17"); // NOI18N
                            jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, -1, -1));

                            getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 800, 100));

                            setSize(new java.awt.Dimension(849, 563));
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
    }//GEN-LAST:event_jb_cancelarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        janelapai.setStatusTela(true);
        setVisible(false);
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

    private void jtf_valor_promocaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_promocaoFocusGained
        jtf_valor_promocao.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_promocaoFocusGained

    private void jtf_valor_promocaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valor_promocaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_locar_quantidade.requestFocus();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_promocaoKeyPressed

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
            jb_adicionar_promocao.requestFocus();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_ordemKeyPressed

    private void jtf_ordemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_ordemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_ordemActionPerformed

    private void jb_adicionar_promocaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_adicionar_promocaoActionPerformed
        adicionarPromocao();
    }//GEN-LAST:event_jb_adicionar_promocaoActionPerformed

    private void jb_adicionar_promocaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_adicionar_promocaoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            adicionarPromocao();

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_adicionar_promocaoKeyPressed

    private void jb_eliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_eliminar1ActionPerformed

        excluirPromocao();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_eliminar1ActionPerformed

    private void jtf_descricao_promocaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_descricao_promocaoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_descricao_promocaoFocusGained

    private void jtf_descricao_promocaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_descricao_promocaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_valor_promocao.requestFocus();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_descricao_promocaoKeyPressed

    private void jtf_valor_promocaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_promocaoFocusLost
        if (jtf_valor_promocao.getText().equals("")) {
            jtf_valor_promocao.setText("R$ 0,00");
        } else {
            moeda = new Moeda();
            jtf_valor_promocao.setText(moeda.setPrecoFormat(jtf_valor_promocao.getText()));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_promocaoFocusLost

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

    private void jb_eliminar1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_eliminar1KeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            excluirPromocao();

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_eliminar1KeyPressed

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
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CadastroDiaria().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_adicionar_promocao;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_eliminar1;
    private javax.swing.JButton jb_salvar;
    private javax.swing.JCheckBox jcb_a_vista;
    public static javax.swing.JCheckBox jcb_acumulativo;
    public static javax.swing.JCheckBox jcb_domingo;
    public static javax.swing.JCheckBox jcb_quarta;
    public static javax.swing.JCheckBox jcb_quinta;
    public static javax.swing.JCheckBox jcb_sabado;
    public static javax.swing.JCheckBox jcb_segunda;
    public static javax.swing.JCheckBox jcb_sexta;
    public static javax.swing.JCheckBox jcb_terca;
    private javax.swing.JTable jtbl_promocao;
    public static javax.swing.JTextField jtf_codigo_diaria;
    public static javax.swing.JTextField jtf_descricao_promocao;
    public static javax.swing.JTextField jtf_dias;
    public static javax.swing.JTextField jtf_dias_maximo;
    public static javax.swing.JTextField jtf_ganhar_quantidade;
    private javax.swing.JTextField jtf_hora_antecipada;
    public static javax.swing.JTextField jtf_locar_quantidade;
    public static javax.swing.JTextField jtf_nome_diaria;
    public static javax.swing.JTextField jtf_ordem;
    public static javax.swing.JTextField jtf_relocacao;
    public static javax.swing.JTextField jtf_valor;
    public static javax.swing.JTextField jtf_valor_promocao;
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
            jtf_descricao_promocao.requestFocus();
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

    public boolean verificarCamposPromocao() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_descricao_promocao.getText().equals("")) {
            msgERRO = msgERRO + " *Descrição Promoção\n";
        }
        if (jtf_valor_promocao.getText().equals("") || jtf_valor_promocao.getText().equals("R$ 0,00")) {
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

    public void adicionarPromocao() {

        if (jtf_codigo_diaria.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Salvar primeiro a Diária");
        } else {
            if (verificarCamposPromocao() == true) {
                diaria = new Diaria();
                diaria.setCodigo_diaria(Integer.parseInt(jtf_codigo_diaria.getText()));

                moeda = new Moeda();

                promocao = new Promocao();
                promocao.setDiaria(diaria);
                promocao.setDescricao_promocao(jtf_descricao_promocao.getText());
                promocao.setValor_promocao(moeda.getPrecoFormato(jtf_valor_promocao.getText()));
                promocao.setOrderm(Integer.parseInt(jtf_ordem.getText()));
                promocao.setPagamento_a_vista(jcb_a_vista.isSelected());
                promocao.setDomingo(jcb_domingo.isSelected());
                promocao.setSegunda(jcb_segunda.isSelected());
                promocao.setTerca(jcb_terca.isSelected());
                promocao.setQuarta(jcb_quarta.isSelected());
                promocao.setQuinta(jcb_quinta.isSelected());
                promocao.setSexta(jcb_sexta.isSelected());
                promocao.setSabado(jcb_sabado.isSelected());
                promocao.setLocar_quantidade(Integer.parseInt(jtf_locar_quantidade.getText()));
                promocao.setGanhar_quantidade(Integer.parseInt(jtf_ganhar_quantidade.getText()));

                diaria.setPromocao(promocao);
                pool = new Pool();
                DiariaDAO diariaDAO = new DiariaDAO(pool);

                diaria = diariaDAO.salvarPromocao(diaria);
                diaria.setCodigo_diaria(Integer.parseInt(jtf_codigo_diaria.getText()));
                carregarPromocoes(diaria);
                itensPromocao.add(diaria);

                limparPromocao();

            }
        }
    }

    private void limparPromocao() {
        jtf_descricao_promocao.setText("");
        jtf_valor_promocao.setText("R$ 0,00");
        jtf_hora_antecipada.setText("");
        jtf_locar_quantidade.setText("");
        jtf_ganhar_quantidade.setText("");
        jtf_ordem.setText("");

    }

    private void excluirPromocao() {
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        AcessoUsuario acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuDiaria");

        try {

            if (acesso.getDeletar() == 0) {
                DefaultTableModel row = (DefaultTableModel) jtbl_promocao.getModel();
                if (jtbl_promocao.getSelectedRow() != -1) {
                    int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
                    if (selectedOption == JOptionPane.YES_NO_OPTION) {
                        pool = new Pool();
                        DiariaDAO diariaDAO = new DiariaDAO(pool);
                        promocao = new Promocao();
                        promocao.setCodigo_promocao(Integer.parseInt((String) jtbl_promocao.getValueAt(jtbl_promocao.getSelectedRow(), 0).toString()));

                        try {
                            diariaDAO.excluirPromocao(promocao.getCodigo_promocao());
                            row.removeRow(jtbl_promocao.getSelectedRow());
                            carregarPromocoes(diaria);
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

    public void carregarPromocoes(Diaria diaria) {
        for (int i = 0; i < jtbl_promocao.getRowCount(); i++) {
            jtbl_promocao.remove(i);
        }
        pool = new Pool();
        DiariaDAO diariaDAO = new DiariaDAO(pool);

        itensPromocao = null;
        itensPromocao = diariaDAO.getDiariaPromocao(diaria);

        for (int i = 0; i < itensPromocao.size(); i++) {
            DefaultTableModel row = (DefaultTableModel) jtbl_promocao.getModel();
            ItemDbGrid hashDbGrid = new ItemDbGrid(itensPromocao.get(i), itensPromocao.get(i).getPromocao().getDescricao_promocao());
            row.addRow(new Object[]{itensPromocao.get(i).getPromocao().getCodigo_promocao(), hashDbGrid,
                moeda.setPrecoFormat(String.valueOf(itensPromocao.get(i).getPromocao().getValor_promocao())),
                itensPromocao.get(i).getPromocao().getHora_antecipada(), itensPromocao.get(i).getPromocao().getLocar_quantidade(),
                itensPromocao.get(i).getPromocao().getGanhar_quantidade(), itensPromocao.get(i).getPromocao().getPagamento_a_vista(),
                itensPromocao.get(i).getPromocao().getOrderm()});
        }

    }
}
