/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MenuDiaria.java
 *
 * Created on 02/06/2011, 00:56:52
 */
package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.controller.SiscomController;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.dao.DiariaDAO;
import br.com.locadora.model.dao.UsuarioDAO;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.TemaInterface;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALENCAR
 */
public class MenuDiaria extends javax.swing.JFrame {

    public String tipoCadastro;
    public TelaPrincipal janelapai;
    public static List<Diaria> diarias;
    public InterfacePool pool;
    public SiscomController controller;
    public Diaria diaria;
    public AcessoUsuario acesso;
    public AtualizaDiaria atualizaDiaria;

    /**
     * Creates new form DiariaGUI
     */
    public MenuDiaria() {
        initComponents();
        TemaInterface.getInterface(this);
        atualizaDiaria = null;
    }

    public void setTela(String permissao) {
        if (permissao.equals("usuario")) {
            jb_novo.setEnabled(false);
            jb_alterar.setEnabled(false);
            jb_excluir.setEnabled(false);
        } else {
        }
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
        jPanel1 = new javax.swing.JPanel();
        jrb_codigo_diaria = new javax.swing.JRadioButton();
        jrb_descricao = new javax.swing.JRadioButton();
        jl_pesquisar_destino = new javax.swing.JLabel();
        jb_buscar = new javax.swing.JButton();
        jtf_consulta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_diaria = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jb_novo = new javax.swing.JButton();
        jb_alterar = new javax.swing.JButton();
        jb_excluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciamento de Diárias");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta Diária"));
        jPanel1.setName("jPanel1"); // NOI18N

        buttonGroup1.add(jrb_codigo_diaria);
        jrb_codigo_diaria.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jrb_codigo_diaria.setText("Código");
        jrb_codigo_diaria.setName("jrb_codigo_diaria"); // NOI18N

        buttonGroup1.add(jrb_descricao);
        jrb_descricao.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jrb_descricao.setSelected(true);
        jrb_descricao.setText("Descrição");
        jrb_descricao.setName("jrb_descricao"); // NOI18N

        jl_pesquisar_destino.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jl_pesquisar_destino.setText("Parâmetro");
        jl_pesquisar_destino.setName("jl_pesquisar_destino"); // NOI18N

        jb_buscar.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jb_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pesquisar.png"))); // NOI18N
        jb_buscar.setName("jb_buscar"); // NOI18N
        jb_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_buscarActionPerformed(evt);
            }
        });

        jtf_consulta.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jtf_consulta.setName("jtf_consulta"); // NOI18N
        jtf_consulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_consultaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jrb_descricao)
                        .addGap(10, 10, 10)
                        .addComponent(jrb_codigo_diaria))
                    .addComponent(jl_pesquisar_destino)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtf_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jb_buscar)))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jb_buscar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrb_descricao)
                            .addComponent(jrb_codigo_diaria))
                        .addGap(10, 10, 10)
                        .addComponent(jl_pesquisar_destino)
                        .addGap(10, 10, 10)
                        .addComponent(jtf_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jb_buscar, jtf_consulta});

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jtbl_diaria.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtbl_diaria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Valor", "Dias", "Multa"
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
        jtbl_diaria.setUpdateSelectionOnSort(false);

        jtbl_diaria.setVerifyInputWhenFocusTarget(false);
        jtbl_diaria.setDefaultEditor(Object.class, null);
        jtbl_diaria.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount() == 2){
                    alterar();
                }}});
                jtbl_diaria.setName("jtbl_diaria"); // NOI18N
                jtbl_diaria.getTableHeader().setReorderingAllowed(false);
                jtbl_diaria.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        jtbl_diariaMouseClicked(evt);
                    }
                });
                jtbl_diaria.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        jtbl_diariaKeyPressed(evt);
                    }
                });
                jScrollPane1.setViewportView(jtbl_diaria);
                if (jtbl_diaria.getColumnModel().getColumnCount() > 0) {
                    jtbl_diaria.getColumnModel().getColumn(0).setPreferredWidth(10);
                    jtbl_diaria.getColumnModel().getColumn(1).setPreferredWidth(200);
                    jtbl_diaria.getColumnModel().getColumn(2).setPreferredWidth(30);
                    jtbl_diaria.getColumnModel().getColumn(3).setPreferredWidth(20);
                    jtbl_diaria.getColumnModel().getColumn(4).setPreferredWidth(30);
                }

                jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
                jPanel2.setName("jPanel2"); // NOI18N
                jPanel2.setLayout(new java.awt.GridBagLayout());

                jb_novo.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
                jb_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/novo_registro.gif"))); // NOI18N
                jb_novo.setText("Novo");
                jb_novo.setName("jb_novo"); // NOI18N
                jb_novo.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_novoActionPerformed(evt);
                    }
                });
                jPanel2.add(jb_novo, new java.awt.GridBagConstraints());

                jb_alterar.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
                jb_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/alterar_registro.gif"))); // NOI18N
                jb_alterar.setText("Alterar");
                jb_alterar.setName("jb_alterar"); // NOI18N
                jb_alterar.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_alterarActionPerformed(evt);
                    }
                });
                jPanel2.add(jb_alterar, new java.awt.GridBagConstraints());

                jb_excluir.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
                jb_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/delete.gif"))); // NOI18N
                jb_excluir.setText("Excluir");
                jb_excluir.setName("jb_excluir"); // NOI18N
                jb_excluir.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_excluirActionPerformed(evt);
                    }
                });
                jPanel2.add(jb_excluir, new java.awt.GridBagConstraints());

                jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/BROADWAY-LOGIN.png"))); // NOI18N
                jLabel1.setName("jLabel1"); // NOI18N

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                );

                pack();
                setLocationRelativeTo(null);
            }// </editor-fold>//GEN-END:initComponents

    private void jb_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_novoActionPerformed
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuDiaria");
        try {
            if (acesso.getEscrever() == 0) {
                CadastroDiaria cadastroDiaria = new CadastroDiaria();
                cadastroDiaria.janelapai = this;
                cadastroDiaria.setVisible(true);
                setStatusTela(false);
                cadastroDiaria.acesso = acesso;
            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }
    }//GEN-LAST:event_jb_novoActionPerformed

    private void jb_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_alterarActionPerformed
        alterar();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_alterarActionPerformed

    private void jb_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_excluirActionPerformed
        excluirDiaria();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_excluirActionPerformed

    private void jb_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_buscarActionPerformed
        enviaDados();
    }//GEN-LAST:event_jb_buscarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        setVisible(false);
        janelapai.setStatusTela(true);
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtf_consulta.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jtf_consultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_consultaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            enviaDados();
        }
        acionarAtalho(evt);


    }//GEN-LAST:event_jtf_consultaKeyPressed

    private void jtbl_diariaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_diariaKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            alterar();
        }
    }//GEN-LAST:event_jtbl_diariaKeyPressed

    private void jtbl_diariaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_diariaMouseClicked
        if(evt.getClickCount() > 1){
            alterar(); 
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_diariaMouseClicked
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MenuDiaria().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_alterar;
    public static javax.swing.JButton jb_buscar;
    private javax.swing.JButton jb_excluir;
    private javax.swing.JButton jb_novo;
    private javax.swing.JLabel jl_pesquisar_destino;
    public static javax.swing.JRadioButton jrb_codigo_diaria;
    public static javax.swing.JRadioButton jrb_descricao;
    public static javax.swing.JTable jtbl_diaria;
    public static javax.swing.JTextField jtf_consulta;
    // End of variables declaration//GEN-END:variables

    public void enviaDados() {
        controller = new SiscomController();
        controller.processarRequisicao("consultarDiaria");
    }

    public Diaria tbDiariaLinhaSelecionada(JTable tb) {

        if (tb.getSelectedRow() != -1) {
            diaria = new Diaria();
            diaria.setCodigo_diaria(diarias.get(tb.getSelectedRow()).getCodigo_diaria());
            diaria.setNome_diaria(diarias.get(tb.getSelectedRow()).getNome_diaria());
            diaria.setDias(diarias.get(tb.getSelectedRow()).getDias());
            diaria.setValor(diarias.get(tb.getSelectedRow()).getValor());
            diaria.setMultas(diarias.get(tb.getSelectedRow()).getMultas());
            diaria.setMaximo_dias(diarias.get(tb.getSelectedRow()).getMaximo_dias());
            diaria.setAcumulativo(diarias.get(tb.getSelectedRow()).getAcumulativo());
        } else {
            diaria = null;
        }
        return diaria;
    }

    public void request() {
        jtf_consulta.requestFocus();
        // TODO add your handling code here:
    }

    private void excluirDiaria() {
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuDiaria");

        try {
            if (acesso.getDeletar() == 0) {
                DefaultTableModel row = (DefaultTableModel) jtbl_diaria.getModel();
                if (jtbl_diaria.getSelectedRow() != -1) {
                    int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
                    if (selectedOption == JOptionPane.YES_NO_OPTION) {
                        pool = new Pool();
                        DiariaDAO diariaDAO = new DiariaDAO(pool);
                        diaria = new Diaria();
                        diaria.setCodigo_diaria(diarias.get(jtbl_diaria.getSelectedRow()).getCodigo_diaria());

                        try {
                            diariaDAO.excluir(diaria.getCodigo_diaria());
                            row.removeRow(jtbl_diaria.getSelectedRow());
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
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }
    }

    public void setStatusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }

    public void alterar() {

        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuDiaria");

        try {
            if (acesso.getEscrever() == 0) {

                diaria = tbDiariaLinhaSelecionada(jtbl_diaria);
                System.out.println("Objeto: " + (diaria == null));
                if (diaria != null) {
                    if(atualizaDiaria == null){
                        atualizaDiaria = new AtualizaDiaria(diaria);
                        atualizaDiaria.janelapai = this;
                        atualizaDiaria.setVisible(true);
                        setEnabled(false);
                    } else {
                        atualizaDiaria.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma Diária");
                    jtf_consulta.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }

    }

    public void acionarAtalho(java.awt.event.KeyEvent evt) {

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            setVisible(false);
            janelapai.setStatusTela(true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            excluirDiaria();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            jtf_consulta.requestFocus();
        }
    }
}
