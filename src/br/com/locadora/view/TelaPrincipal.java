package br.com.locadora.view;

import br.com.locadora.model.bean.Usuario;
import br.com.locadora.util.Backup;
import br.com.locadora.util.Restaurar;
import java.io.IOException;
import javax.swing.*;

public class TelaPrincipal extends javax.swing.JFrame implements TelaPrincipal_Interface {

    public IniciaLogin janelaPai;
    public IniciaLogin janelaLogin;
    public static Usuario usuario;
    public String usuarioNome;
    public Integer codUsuario;
    public String login;
    public String permissao;
    public IniciaLogin loginInicia;
    public AtendimentoLocacao atendimentoLocacao;
    public AtendimentoDevolucao atendimentoDevolucao;
    public Recebimento recebimento;

    public TelaPrincipal() {

        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuBar5 = new javax.swing.JMenuBar();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenuBar6 = new javax.swing.JMenuBar();
        jMenu11 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        jMenuBar7 = new javax.swing.JMenuBar();
        jMenu13 = new javax.swing.JMenu();
        jMenu14 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        label_data = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jlabel_usuario = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMB_Cadastro = new javax.swing.JMenuBar();
        menu_cadastros = new javax.swing.JMenu();
        jmi_cliente = new javax.swing.JMenuItem();
        jmi_produto = new javax.swing.JMenuItem();
        jmi_fornecedor = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenu15 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuitem_sair = new javax.swing.JMenuItem();
        menu_movimentos2 = new javax.swing.JMenu();
        jmi_entrada1 = new javax.swing.JMenuItem();
        jmi_entrada4 = new javax.swing.JMenuItem();
        jmi_entrada5 = new javax.swing.JMenuItem();
        menu_movimentos = new javax.swing.JMenu();
        jmi_entrada = new javax.swing.JMenuItem();
        jmi_entrada2 = new javax.swing.JMenuItem();
        jMenu17 = new javax.swing.JMenu();
        menu_relatórios = new javax.swing.JMenu();
        menu_relatórios1 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jmi_backup = new javax.swing.JMenuItem();
        jmi_recover = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu16 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        menu_relatórios2 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();

        jFrame1.setName("jFrame1"); // NOI18N

        jMenuBar1.setName("jMenuBar1"); // NOI18N

        jMenu1.setText("File");
        jMenu1.setName("jMenu1"); // NOI18N
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenu2.setName("jMenu2"); // NOI18N
        jMenuBar1.add(jMenu2);

        jMenuBar2.setName("jMenuBar2"); // NOI18N

        jMenu3.setText("File");
        jMenu3.setName("jMenu3"); // NOI18N
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenu4.setName("jMenu4"); // NOI18N
        jMenuBar2.add(jMenu4);

        jMenuBar3.setName("jMenuBar3"); // NOI18N

        jMenu5.setText("File");
        jMenu5.setName("jMenu5"); // NOI18N
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenu6.setName("jMenu6"); // NOI18N
        jMenuBar3.add(jMenu6);

        jMenuBar4.setName("jMenuBar4"); // NOI18N

        jMenu7.setText("File");
        jMenu7.setName("jMenu7"); // NOI18N
        jMenuBar4.add(jMenu7);

        jMenu8.setText("Edit");
        jMenu8.setName("jMenu8"); // NOI18N
        jMenuBar4.add(jMenu8);

        jMenuBar5.setName("jMenuBar5"); // NOI18N

        jMenu9.setText("File");
        jMenu9.setName("jMenu9"); // NOI18N
        jMenuBar5.add(jMenu9);

        jMenu10.setText("Edit");
        jMenu10.setName("jMenu10"); // NOI18N
        jMenuBar5.add(jMenu10);

        jMenuBar6.setName("jMenuBar6"); // NOI18N

        jMenu11.setText("File");
        jMenu11.setName("jMenu11"); // NOI18N
        jMenuBar6.add(jMenu11);

        jMenu12.setText("Edit");
        jMenu12.setName("jMenu12"); // NOI18N
        jMenuBar6.add(jMenu12);

        jMenuBar7.setName("jMenuBar7"); // NOI18N

        jMenu13.setText("File");
        jMenu13.setName("jMenu13"); // NOI18N
        jMenuBar7.add(jMenu13);

        jMenu14.setText("Edit");
        jMenu14.setName("jMenu14"); // NOI18N
        jMenuBar7.add(jMenu14);

        jMenuItem2.setText("jMenuItem2");
        jMenuItem2.setName("jMenuItem2"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Siscom Locadora");
        setExtendedState(MAXIMIZED_BOTH);
        setFocusable(false);
        setIconImages(null);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_data.setName("label_data"); // NOI18N
        getContentPane().add(label_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(1243, 632, -1, -1));

        jToolBar1.setRollover(true);
        jToolBar1.setName("jToolBar1"); // NOI18N

        jlabel_usuario.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jlabel_usuario.setText("Usuário: ");
        jlabel_usuario.setName("jlabel_usuario"); // NOI18N
        jToolBar1.add(jlabel_usuario);

        jLabel4.setText("                                                                                                                                                                ");
        jLabel4.setName("jLabel4"); // NOI18N
        jToolBar1.add(jLabel4);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Desenvolvido por Alencar Santos Buriti Júnior                                             ");
        jLabel3.setName("jLabel3"); // NOI18N
        jToolBar1.add(jLabel3);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 1340, 25));

        jMB_Cadastro.setName("jMB_Cadastro"); // NOI18N

        menu_cadastros.setMnemonic('C');
        menu_cadastros.setText("Cadastro");
        menu_cadastros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_cadastrosActionPerformed(evt);
            }
        });

        jmi_cliente.setMnemonic('P');
        jmi_cliente.setText("Cliente");
        jmi_cliente.setName("jmi_cliente"); // NOI18N
        jmi_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_clienteActionPerformed(evt);
            }
        });
        menu_cadastros.add(jmi_cliente);

        jmi_produto.setMnemonic('P');
        jmi_produto.setText("Produto");
        jmi_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_produtoActionPerformed(evt);
            }
        });
        menu_cadastros.add(jmi_produto);

        jmi_fornecedor.setMnemonic('F');
        jmi_fornecedor.setText("Fornecedor");
        jmi_fornecedor.setName("jmi_fornecedor"); // NOI18N
        jmi_fornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_fornecedorActionPerformed(evt);
            }
        });
        jmi_fornecedor.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jmi_fornecedorAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        menu_cadastros.add(jmi_fornecedor);

        jSeparator4.setName("jSeparator4"); // NOI18N
        menu_cadastros.add(jSeparator4);

        jMenu15.setText("Locadora");
        jMenu15.setName("jMenu15"); // NOI18N

        jMenuItem4.setText("Objeto");
        jMenuItem4.setName("jMenuItem4"); // NOI18N
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem4);

        jMenuItem5.setText("Gênero");
        jMenuItem5.setName("jMenuItem5"); // NOI18N
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem5);

        jMenuItem11.setText("Diária");
        jMenuItem11.setName("jMenuItem11"); // NOI18N
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem11);

        jMenuItem3.setText("Gerar Código de Barras");
        jMenuItem3.setName("jMenuItem3"); // NOI18N
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem3);

        jMenuItem12.setText("Idioma");
        jMenuItem12.setName("jMenuItem12"); // NOI18N
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem12);

        jMenuItem13.setText("Legenda");
        jMenuItem13.setName("jMenuItem13"); // NOI18N
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem13);

        jMenuItem14.setText("Mídia");
        jMenuItem14.setName("jMenuItem14"); // NOI18N
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem14);

        jMenuItem15.setText("Tipo de Objeto");
        jMenuItem15.setName("jMenuItem15"); // NOI18N
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem15);

        menu_cadastros.add(jMenu15);

        jSeparator2.setName("jSeparator2"); // NOI18N
        menu_cadastros.add(jSeparator2);

        menuitem_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/exit.png"))); // NOI18N
        menuitem_sair.setText("Sair");
        menuitem_sair.setName("menuitem_sair"); // NOI18N
        menuitem_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitem_sairActionPerformed(evt);
            }
        });
        menu_cadastros.add(menuitem_sair);

        jMB_Cadastro.add(menu_cadastros);

        menu_movimentos2.setMnemonic('M');
        menu_movimentos2.setText("Financeiro");
        menu_movimentos2.setName("menu_movimentos2"); // NOI18N

        jmi_entrada1.setText("Recebimento");
        jmi_entrada1.setName("jmi_entrada1"); // NOI18N
        jmi_entrada1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_entrada1ActionPerformed1(evt);
            }
        });
        menu_movimentos2.add(jmi_entrada1);

        jmi_entrada4.setText("A Pagar");
        jmi_entrada4.setName("jmi_entrada4"); // NOI18N
        jmi_entrada4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_entrada4ActionPerformed1(evt);
            }
        });
        menu_movimentos2.add(jmi_entrada4);

        jmi_entrada5.setText("A Receber");
        jmi_entrada5.setName("jmi_entrada5"); // NOI18N
        jmi_entrada5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_entrada5ActionPerformed1(evt);
            }
        });
        menu_movimentos2.add(jmi_entrada5);

        jMB_Cadastro.add(menu_movimentos2);

        menu_movimentos.setMnemonic('M');
        menu_movimentos.setText("Movimento");
        menu_movimentos.setName("menu_movimentos"); // NOI18N

        jmi_entrada.setText("Locação");
        jmi_entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_entradaActionPerformed1(evt);
            }
        });
        menu_movimentos.add(jmi_entrada);

        jmi_entrada2.setText("Devolução");
        jmi_entrada2.setName("jmi_entrada2"); // NOI18N
        jmi_entrada2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_entrada2ActionPerformed1(evt);
            }
        });
        menu_movimentos.add(jmi_entrada2);

        jMB_Cadastro.add(menu_movimentos);

        jMenu17.setText("Consultas");
        jMenu17.setName("jMenu17"); // NOI18N
        jMB_Cadastro.add(jMenu17);

        menu_relatórios.setMnemonic('R');
        menu_relatórios.setText("Relatório");
        menu_relatórios.setName("menu_relatórios"); // NOI18N
        menu_relatórios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_relatóriosActionPerformed(evt);
            }
        });
        jMB_Cadastro.add(menu_relatórios);

        menu_relatórios1.setMnemonic('R');
        menu_relatórios1.setText("Utilitários");
        menu_relatórios1.setName("menu_relatórios1"); // NOI18N
        menu_relatórios1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_relatórios1ActionPerformed(evt);
            }
        });

        jMenuItem9.setText("Calculadora ");
        jMenuItem9.setName("jMenuItem9"); // NOI18N
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed1(evt);
            }
        });
        menu_relatórios1.add(jMenuItem9);

        jmi_backup.setText("Backup");
        jmi_backup.setName("jmi_backup"); // NOI18N
        jmi_backup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_backupActionPerformed(evt);
            }
        });
        menu_relatórios1.add(jmi_backup);

        jmi_recover.setText("Restaurar Backup");
        jmi_recover.setName("jmi_recover"); // NOI18N
        jmi_recover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_recoverActionPerformed(evt);
            }
        });
        menu_relatórios1.add(jmi_recover);

        jSeparator3.setName("jSeparator3"); // NOI18N
        menu_relatórios1.add(jSeparator3);

        jMenuItem1.setText("Trocar de usuário");
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menu_relatórios1.add(jMenuItem1);

        jSeparator1.setName("jSeparator1"); // NOI18N
        menu_relatórios1.add(jSeparator1);

        jMB_Cadastro.add(menu_relatórios1);

        jMenu16.setText("Configurações");
        jMenu16.setName("jMenu16"); // NOI18N

        jMenuItem6.setText("Cadastro Usuário");
        jMenuItem6.setName("jMenuItem6"); // NOI18N
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu16.add(jMenuItem6);

        jMenuItem7.setText("Acesso");
        jMenuItem7.setName("jMenuItem7"); // NOI18N
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu16.add(jMenuItem7);

        jMB_Cadastro.add(jMenu16);

        menu_relatórios2.setMnemonic('R');
        menu_relatórios2.setText("Ajuda");
        menu_relatórios2.setName("menu_relatórios2"); // NOI18N
        menu_relatórios2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_relatórios2ActionPerformed(evt);
            }
        });

        jMenuItem10.setText("Help!");
        jMenuItem10.setName("jMenuItem10"); // NOI18N
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        menu_relatórios2.add(jMenuItem10);

        jMB_Cadastro.add(menu_relatórios2);

        setJMenuBar(jMB_Cadastro);

        setSize(new java.awt.Dimension(1268, 745));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuitem_entradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitem_entradaActionPerformed

    }//GEN-LAST:event_menuitem_entradaActionPerformed

    private void jmi_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_produtoActionPerformed
        MenuProduto produtoGUI = new MenuProduto();
        produtoGUI.setTelaPrincipal(this);
        produtoGUI.setTela(permissao);
        produtoGUI.setVisible(true);
        setStatusTela(false);
    }//GEN-LAST:event_jmi_produtoActionPerformed

    private void jmi_entradaActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_entradaActionPerformed1
        atendimentoLocacao = new AtendimentoLocacao();
        atendimentoLocacao.setVisible(true);
        atendimentoLocacao.setTelaPrincipal(this);
        atendimentoLocacao.setJanelaPai(this);
        atendimentoLocacao.setVisible(true);
        setStatusTela(false);


    }//GEN-LAST:event_jmi_entradaActionPerformed1

    private void menu_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_sairActionPerformed
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_menu_sairActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        MenuGenero menuGenero = new MenuGenero();
        menuGenero.setTelaPrincipal(this);
        menuGenero.setVisible(true);
        setStatusTela(false);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void menu_cadastrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_cadastrosActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_menu_cadastrosActionPerformed

    private void menuitem_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitem_sairActionPerformed
        System.exit(0);
        // TODO add your handling code here:
}//GEN-LAST:event_menuitem_sairActionPerformed

    private void jmi_fornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_fornecedorActionPerformed
        MenuFornecedor fornecedorMenu = new MenuFornecedor();
        fornecedorMenu.setTelaPrincipal(this);
        fornecedorMenu.setVisible(true);
        setStatusTela(false);
    }//GEN-LAST:event_jmi_fornecedorActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void jmi_fornecedorAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jmi_fornecedorAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_fornecedorAncestorAdded

    private void timer1OnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timer1OnTime


    }//GEN-LAST:event_timer1OnTime

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        Acesso acesso = new Acesso();
        acesso.setTelaPrincipal(this);
        acesso.setVisible(true);
        setStatusTela(false);

    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void menu_relatóriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_relatóriosActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_menu_relatóriosActionPerformed

    private void menu_relatórios1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_relatórios1ActionPerformed
        System.exit(0);
        loginInicia = new IniciaLogin();
        loginInicia.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_menu_relatórios1ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        try {
            Runtime.getRuntime().exec("calc");
        } catch (IOException exc) {
        }        // TODO add your handling code here:
}//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void menu_relatórios2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_relatórios2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menu_relatórios2ActionPerformed

    private void jMenuItem9ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed1
        try {
            Runtime.getRuntime().exec("calc");
        } catch (IOException exc) {
        }          // TODO add your handling code here:
}//GEN-LAST:event_jMenuItem9ActionPerformed1

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        setVisible(false);
        loginInicia = new IniciaLogin();
        loginInicia.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

private void jmi_backupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_backupActionPerformed
    Backup backup = new Backup();
    backup.setVisible(true);
}//GEN-LAST:event_jmi_backupActionPerformed

private void jmi_recoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_recoverActionPerformed
    Restaurar recover = new Restaurar();
    recover.setVisible(true);
}//GEN-LAST:event_jmi_recoverActionPerformed

    private void jmi_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_clienteActionPerformed
        MenuCliente cliente_principal;
        cliente_principal = new MenuCliente();
        cliente_principal.setTelaPrincipal(this);
        cliente_principal.setVisible(true);
        setStatusTela(false);
    }//GEN-LAST:event_jmi_clienteActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        MenuDiaria menuDiaria = new MenuDiaria();
        menuDiaria.setTelaPrincipal(this);
        menuDiaria.setVisible(true);
        setStatusTela(false);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        MenuObjeto menuObjeto = new MenuObjeto();
        menuObjeto.setTelaPrincipal(this);
        menuObjeto.setVisible(true);
        setStatusTela(false);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        MenuIdioma menuIdioma = new MenuIdioma();
        menuIdioma.setTelaPrincipal(this);
        menuIdioma.setVisible(true);
        setStatusTela(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        MenuLegenda menuLegenda = new MenuLegenda();
        menuLegenda.janelapai = this;
        menuLegenda.setVisible(true);
        setStatusTela(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JOptionPane.showMessageDialog(null, "Em construção");
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        JOptionPane.showMessageDialog(null, "Em construção");
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        JOptionPane.showMessageDialog(null, "Em construção");
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jmi_entrada5ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_entrada5ActionPerformed1
        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_entrada5ActionPerformed1

    private void jmi_entrada4ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_entrada4ActionPerformed1
        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_entrada4ActionPerformed1

    private void jmi_entrada1ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_entrada1ActionPerformed1
        recebimento = new Recebimento();
        recebimento.setStatusTela(true);
        setStatusTela(false);
        recebimento.janelapai = this;
        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_entrada1ActionPerformed1

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        MenuUsuario menuUsuario = new MenuUsuario();
        menuUsuario.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jmi_entrada2ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_entrada2ActionPerformed1
        atendimentoDevolucao = new AtendimentoDevolucao();
        atendimentoDevolucao.setVisible(true);
        atendimentoDevolucao.setTelaPrincipal(this);
        atendimentoDevolucao.setJanelaPai(this);
        atendimentoDevolucao.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_entrada2ActionPerformed1

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TelaPrincipal().setVisible(true);

            }
        });

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMB_Cadastro;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu17;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuBar jMenuBar5;
    private javax.swing.JMenuBar jMenuBar6;
    private javax.swing.JMenuBar jMenuBar7;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel jlabel_usuario;
    private javax.swing.JMenuItem jmi_backup;
    private javax.swing.JMenuItem jmi_cliente;
    private javax.swing.JMenuItem jmi_entrada;
    private javax.swing.JMenuItem jmi_entrada1;
    private javax.swing.JMenuItem jmi_entrada2;
    private javax.swing.JMenuItem jmi_entrada4;
    private javax.swing.JMenuItem jmi_entrada5;
    private javax.swing.JMenuItem jmi_fornecedor;
    private javax.swing.JMenuItem jmi_produto;
    private javax.swing.JMenuItem jmi_recover;
    private javax.swing.JLabel label_data;
    private javax.swing.JMenu menu_cadastros;
    private javax.swing.JMenu menu_movimentos;
    private javax.swing.JMenu menu_movimentos2;
    private javax.swing.JMenu menu_relatórios;
    private javax.swing.JMenu menu_relatórios1;
    private javax.swing.JMenu menu_relatórios2;
    private javax.swing.JMenuItem menuitem_sair;
    // End of variables declaration//GEN-END:variables

    public void setStatusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }

    public void carregaUsuario(Usuario usuario) {
        if (usuario != null) {
            TelaPrincipal.usuario = usuario;
            jlabel_usuario.setText("Usuário: " + usuario.getNome_usuario());
        } else {
            JOptionPane.showMessageDialog(null, "Usuário não foi carregado com sucesso");
        }
    }

}
