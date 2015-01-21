/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EntradaGUI.java
 *
 * Created on 27/05/2011, 15:13:50
 */
package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.controller.SiscomController;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Objeto;
import br.com.locadora.model.dao.ObjetoDAO;
import br.com.locadora.model.dao.UsuarioDAO;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.TemaInterface;
import static br.com.locadora.view.MenuObjeto.jtf_consulta;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MenuObjeto extends javax.swing.JFrame {

    public String permissao;
    public InterfacePool pool;
    public SiscomController controller;
    public static List<Objeto> objetos = new ArrayList<Objeto>();
    public TelaPrincipal janelapai;
    public static Objeto objeto;
    public AcessoUsuario acesso;
    public CadastraAlteraObjeto cadastraAlteraObjeto;

    public MenuObjeto() {
        initComponents();
        TemaInterface.getInterface(this);
        cadastraAlteraObjeto = null;
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
        jrb_codigo = new javax.swing.JRadioButton();
        jrb_ator = new javax.swing.JRadioButton();
        jrb_titulo = new javax.swing.JRadioButton();
        jl_pesquisar_destino = new javax.swing.JLabel();
        jb_buscar = new javax.swing.JButton();
        jtf_consulta = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbl_objeto = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jb_novo = new javax.swing.JButton();
        jb_alterar = new javax.swing.JButton();
        jb_excluir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciamento de Objetos");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta Objeto"));
        jPanel1.setName("jPanel1"); // NOI18N

        buttonGroup1.add(jrb_codigo);
        jrb_codigo.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jrb_codigo.setText("Código");
        jrb_codigo.setName("jrb_codigo"); // NOI18N
        jrb_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_codigoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrb_ator);
        jrb_ator.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jrb_ator.setText("Elenco");
        jrb_ator.setName("jrb_ator"); // NOI18N
        jrb_ator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_atorActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrb_titulo);
        jrb_titulo.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jrb_titulo.setSelected(true);
        jrb_titulo.setText("Título");
        jrb_titulo.setName("jrb_titulo"); // NOI18N
        jrb_titulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_tituloActionPerformed(evt);
            }
        });

        jl_pesquisar_destino.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jl_pesquisar_destino.setText("Parâmetro");
        jl_pesquisar_destino.setName("jl_pesquisar_destino"); // NOI18N

        jb_buscar.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jb_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pesquisar.png"))); // NOI18N
        jb_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_buscarActionPerformed1(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrb_titulo)
                            .addComponent(jl_pesquisar_destino))
                        .addGap(10, 10, 10)
                        .addComponent(jrb_ator)
                        .addGap(10, 10, 10)
                        .addComponent(jrb_codigo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtf_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jb_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jb_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jrb_titulo)
                                .addGap(10, 10, 10)
                                .addComponent(jl_pesquisar_destino))
                            .addComponent(jrb_ator)
                            .addComponent(jrb_codigo))
                        .addGap(10, 10, 10)
                        .addComponent(jtf_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jb_buscar, jtf_consulta});

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        jtbl_objeto.setUpdateSelectionOnSort(false);
        jtbl_objeto.setVerifyInputWhenFocusTarget(false);
        jtbl_objeto.setDefaultEditor(Object.class, null);
        jtbl_objeto.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount() == 1){
                    //    listarItem();
                }}});
                jtbl_objeto.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
                jtbl_objeto.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {

                    },
                    new String [] {
                        "Código", "Descrição Objeto", "Título Original", "Elenco"
                    }
                ) {
                    Class[] types = new Class [] {
                        java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
                    };
                    boolean[] canEdit = new boolean [] {
                        false, false, false, false
                    };

                    public Class getColumnClass(int columnIndex) {
                        return types [columnIndex];
                    }

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                    }
                });
                jtbl_objeto.setName("jtbl_objeto"); // NOI18N
                jtbl_objeto.getTableHeader().setReorderingAllowed(false);
                jtbl_objeto.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        jtbl_objetoMouseClicked(evt);
                    }
                });
                jtbl_objeto.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        jtbl_objetoKeyPressed(evt);
                    }
                });
                jScrollPane3.setViewportView(jtbl_objeto);
                if (jtbl_objeto.getColumnModel().getColumnCount() > 0) {
                    jtbl_objeto.getColumnModel().getColumn(0).setPreferredWidth(10);
                    jtbl_objeto.getColumnModel().getColumn(1).setPreferredWidth(200);
                    jtbl_objeto.getColumnModel().getColumn(2).setPreferredWidth(200);
                    jtbl_objeto.getColumnModel().getColumn(3).setPreferredWidth(100);
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

                jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/BROADWAY-LOGIN.png"))); // NOI18N
                jLabel2.setName("jLabel2"); // NOI18N

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
                            .addComponent(jScrollPane3)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                );

                pack();
                setLocationRelativeTo(null);
            }// </editor-fold>//GEN-END:initComponents

    private void jb_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_buscarActionPerformed

}//GEN-LAST:event_jb_buscarActionPerformed

    private void jb_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_novoActionPerformed
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuObjeto");
        try {
            if (acesso.getEscrever() == true) {
                if (cadastraAlteraObjeto == null) {
                    cadastraAlteraObjeto = new CadastraAlteraObjeto();
                    cadastraAlteraObjeto.janelapai = this;
                    cadastraAlteraObjeto.setVisible(true);
                    this.setStatusTela(false);
                    cadastraAlteraObjeto.setTitle("Cadastrando Objeto");
                } else {
                    cadastraAlteraObjeto.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }


}//GEN-LAST:event_jb_novoActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        setVisible(false);
        if (janelapai != null) {
            janelapai.setStatusTela(true);
        }
    }//GEN-LAST:event_formWindowClosed

    private void jb_buscarActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_buscarActionPerformed1
        buscarDados();
    }//GEN-LAST:event_jb_buscarActionPerformed1

    private void jrb_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_codigoActionPerformed
        jtf_consulta.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_codigoActionPerformed

    private void jb_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_alterarActionPerformed
        alterar();

        // TODO add your handling code here:
    }//GEN-LAST:event_jb_alterarActionPerformed

    private void jb_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_excluirActionPerformed
        excluirObjeto();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_excluirActionPerformed

    private void jrb_tituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_tituloActionPerformed
        jtf_consulta.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_tituloActionPerformed

    private void jtf_consultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_consultaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buscarDados();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_consultaKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtf_consulta.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jrb_atorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_atorActionPerformed
        jtf_consulta.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_atorActionPerformed

    private void jtbl_objetoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_objetoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            alterar();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_objetoKeyPressed

    private void jtbl_objetoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_objetoMouseClicked
        if (evt.getClickCount() > 1) {
            alterar();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_objetoMouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MenuObjeto().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jb_alterar;
    private javax.swing.JButton jb_buscar;
    private javax.swing.JButton jb_excluir;
    private javax.swing.JButton jb_novo;
    private javax.swing.JLabel jl_pesquisar_destino;
    public static javax.swing.JRadioButton jrb_ator;
    public static javax.swing.JRadioButton jrb_codigo;
    public static javax.swing.JRadioButton jrb_titulo;
    public static javax.swing.JTable jtbl_objeto;
    public static javax.swing.JTextField jtf_consulta;
    // End of variables declaration//GEN-END:variables

    public Objeto tbObjetoLinhaSelecionada(JTable tb) {
        if (tb != null && tb.getSelectedRow() != -1) {
            objeto = new Objeto();
            objeto.setCodigo_objeto(objetos.get(tb.getSelectedRow()).getCodigo_objeto());
            objeto.setTitulo(objetos.get(tb.getSelectedRow()).getTitulo());
            objeto.setTitulo_original(objetos.get(tb.getSelectedRow()).getTitulo_original());
            objeto.setTipo_movimento(objetos.get(tb.getSelectedRow()).getTipo_movimento());
            objeto.setProducao(objetos.get(tb.getSelectedRow()).getProducao());
            objeto.setDuracao(objetos.get(tb.getSelectedRow()).getDuracao());
            objeto.setTipo_midia(objetos.get(tb.getSelectedRow()).getTipo_midia());
            objeto.setGenero(objetos.get(tb.getSelectedRow()).getGenero());
            objeto.setElenco(objetos.get(tb.getSelectedRow()).getElenco());
            objeto.setSinopse(objetos.get(tb.getSelectedRow()).getSinopse());
            objeto.setCensura(objetos.get(tb.getSelectedRow()).getCensura());
        } else {
            objeto = null;
        }
        return objeto;
    }

    public void buscarDados() {
        controller = new SiscomController();
        controller.processarRequisicao("consultarObjeto");
    }

    public void setStatusTela(boolean status) {

        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);

    }

    private void excluirObjeto() {
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuObjeto");

        try {
            if (acesso.getDeletar() == true) {
                DefaultTableModel row = (DefaultTableModel) jtbl_objeto.getModel();
                if (jtbl_objeto.getSelectedRow() != -1) {
                    int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
                    if (selectedOption == JOptionPane.YES_NO_OPTION) {
                        pool = new Pool();
                        ObjetoDAO objetoDAO = new ObjetoDAO(pool);
                        objeto = new Objeto();
                        objeto.setCodigo_objeto(objetos.get(jtbl_objeto.getSelectedRow()).getCodigo_objeto());

                        try {
                            objetoDAO.excluir(objeto.getCodigo_objeto());
                            row.removeRow(jtbl_objeto.getSelectedRow());
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Este registro não pode ser excluído pois está referenciado em outra tabela");
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um objeto");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }
    }

    public void acionarAtalho(java.awt.event.KeyEvent evt) {

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            setVisible(false);
            janelapai.setStatusTela(true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            excluirObjeto();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            jtf_consulta.requestFocus();
        }
    }

    private void alterar() {
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuObjeto");

        try {
            if (acesso.getEscrever() == true) {
                objeto = tbObjetoLinhaSelecionada(jtbl_objeto);
                if (objeto != null) {

                    if (cadastraAlteraObjeto == null) {
                        cadastraAlteraObjeto = new CadastraAlteraObjeto(objeto);
                        cadastraAlteraObjeto.janelapai = this;
                        cadastraAlteraObjeto.setVisible(true);
                        this.setStatusTela(false);
                        cadastraAlteraObjeto.setTitle("Alterando Objeto");
                    } else {
                        cadastraAlteraObjeto.setVisible(true);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um objeto");
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
}
