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
import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.bean.ItemLocacao;
import br.com.locadora.model.bean.Objeto;
import br.com.locadora.model.dao.CopiaDAO;
import br.com.locadora.model.dao.LocacaoDAO;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.Moeda;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALENCAR
 */
public class ConsultaCopiaDevolucao extends javax.swing.JFrame {

//    public AtendimentoLocacao janelapaiLocacao;
    public AtendimentoDevolucao janelapaiDevolucao;
    public List<ItemLocacao> itens;
    public Copia copia;
    public InterfacePool pool;
    public SiscomController controller;
    public static List<ItemLocacao> itensDevolucao;
    public LocacaoDAO locacaoDAO;

    public ConsultaCopiaDevolucao() {
        initComponents();
        janelapaiDevolucao = null;
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
        jb_cancelar = new javax.swing.JButton();
        jb_ok = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jtf_consulta = new javax.swing.JTextField();
        jb_buscar = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtbl_locacao_aberto = new javax.swing.JTable();
        jrb_ator = new javax.swing.JRadioButton();
        jrb_codigo_barras = new javax.swing.JRadioButton();
        jrb_codigo = new javax.swing.JRadioButton();
        jrb_titulo = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Objeto");
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/exit.png"))); // NOI18N
        jb_cancelar.setText("Cancelar");
        jb_cancelar.setName("jb_cancelar"); // NOI18N
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 110, 40));

        jb_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/ok.png"))); // NOI18N
        jb_ok.setText("OK");
        jb_ok.setName("jb_ok"); // NOI18N
        jb_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_okActionPerformed(evt);
            }
        });
        getContentPane().add(jb_ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 80, 40));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta Objeto"));
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtf_consulta.setName("jtf_consulta"); // NOI18N
        jtf_consulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_consultaKeyPressed(evt);
            }
        });
        jPanel1.add(jtf_consulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 450, -1));

        jb_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/ok.png"))); // NOI18N
        jb_buscar.setName("jb_buscar"); // NOI18N
        jb_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_buscarActionPerformed1(evt);
            }
        });
        jPanel1.add(jb_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, -1, -1));

        jScrollPane6.setName("jScrollPane6"); // NOI18N

        jtbl_locacao_aberto.setUpdateSelectionOnSort(false);
        jtbl_locacao_aberto.setVerifyInputWhenFocusTarget(false);
        jtbl_locacao_aberto.setDefaultEditor(Object.class, null);
        jtbl_locacao_aberto.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount() == 2){
                    botaoOK(jtbl_locacao_aberto);

                }}});
                jtbl_locacao_aberto.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {

                    },
                    new String [] {
                        "Código Barras", "Objeto", "Data Locação", "Data Devolução", "Valor Multa", "Dia atraso"
                    }
                ) {
                    Class[] types = new Class [] {
                        java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                    };
                    boolean[] canEdit = new boolean [] {
                        false, false, false, false, false, false
                    };

                    public Class getColumnClass(int columnIndex) {
                        return types [columnIndex];
                    }

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                    }
                });
                jtbl_locacao_aberto.setName("jtbl_locacao_aberto"); // NOI18N
                jtbl_locacao_aberto.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        jtbl_locacao_abertoKeyPressed(evt);
                    }
                });
                jScrollPane6.setViewportView(jtbl_locacao_aberto);

                jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 770, 210));

                getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 810, 280));

                buttonGroup1.add(jrb_ator);
                jrb_ator.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
                jrb_ator.setText("Ator");
                jrb_ator.setName("jrb_ator"); // NOI18N
                jrb_ator.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jrb_atorActionPerformed(evt);
                    }
                });
                getContentPane().add(jrb_ator, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

                buttonGroup1.add(jrb_codigo_barras);
                jrb_codigo_barras.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
                jrb_codigo_barras.setText("Código de Barras");
                jrb_codigo_barras.setName("jrb_codigo_barras"); // NOI18N
                jrb_codigo_barras.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jrb_codigo_barrasActionPerformed(evt);
                    }
                });
                getContentPane().add(jrb_codigo_barras, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

                buttonGroup1.add(jrb_codigo);
                jrb_codigo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
                jrb_codigo.setText("Código Objeto");
                jrb_codigo.setName("jrb_codigo"); // NOI18N
                jrb_codigo.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jrb_codigoActionPerformed(evt);
                    }
                });
                getContentPane().add(jrb_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

                buttonGroup1.add(jrb_titulo);
                jrb_titulo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
                jrb_titulo.setSelected(true);
                jrb_titulo.setText("Título");
                jrb_titulo.setName("jrb_titulo"); // NOI18N
                jrb_titulo.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jrb_tituloActionPerformed(evt);
                    }
                });
                getContentPane().add(jrb_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

                setSize(new java.awt.Dimension(832, 410));
                setLocationRelativeTo(null);
            }// </editor-fold>//GEN-END:initComponents

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        setVisible(false);
        if ((janelapaiDevolucao != null)) {
            janelapaiDevolucao.setEnabled(true);
            janelapaiDevolucao.setVisible(true);
            //telaCadastroObjeto.setStatusTela(false);
        }

}//GEN-LAST:event_jb_cancelarActionPerformed

    private void jb_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_okActionPerformed
        if (jtbl_locacao_aberto.getSelectedRow() == 1) {
            botaoOK(jtbl_locacao_aberto);
        }
}//GEN-LAST:event_jb_okActionPerformed
    public void botaoOK(JTable tb) {
        if (tb.getSelectedRow() != -1) {
            setVisible(false);
            ItemLocacao itemLinha = tbItemLocacaoLinhaSelecionada(jtbl_locacao_aberto);
            if ((janelapaiDevolucao != null) && (itemLinha != null)) {
                janelapaiDevolucao.setEnabled(true);
                janelapaiDevolucao.setVisible(true);
                janelapaiDevolucao.consultarCopiaLocada(itemLinha.getCopia().getCodigo_barras());
//                janelapaiDevolucao.adicionarItemDevolvido(itemLinha);
//                telaAtendimentoDevolucao.carregarCopiaDevolucao(itemLinha);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Copia");
        }
    }

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        setVisible(false);
        if ((janelapaiDevolucao != null)) {
            janelapaiDevolucao.setEnabled(true);
            janelapaiDevolucao.setVisible(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if (!janelapaiDevolucao.jtf_codigo_cliente.getText().equals("")) {
            controller = new SiscomController();
            controller.processarRequisicao("consultarLocacao");
        } else {
            jtf_consulta.requestFocus();
        }
    }//GEN-LAST:event_formWindowOpened

    private void jb_buscarActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_buscarActionPerformed1
        try {
            if (jrb_codigo.isSelected() == true) {
                if (jtf_consulta.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Informe um código");
                } else {
                    listaCopia_codigo_objeto(Integer.parseInt(jtf_consulta.getText().trim()));
                }
            } else if (jrb_titulo.isSelected() == true) {
                listaCopia_titulo(jtf_consulta.getText().trim());
            } else if (jrb_codigo_barras.isSelected() == true) {
                listaCopia_codigo_barras(jtf_consulta.getText().trim());
            } else {
                listaCopia_ator(jtf_consulta.getText().trim());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaCopiaDevolucao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jb_buscarActionPerformed1

    private void jrb_codigo_barrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_codigo_barrasActionPerformed
        jtf_consulta.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_codigo_barrasActionPerformed

    private void jrb_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_codigoActionPerformed
        jtf_consulta.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_codigoActionPerformed

    private void jrb_tituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_tituloActionPerformed
        jtf_consulta.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_tituloActionPerformed

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowDeactivated

    private void jtf_consultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_consultaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            try {
                if (jrb_codigo.isSelected() == true) {
                    if (jtf_consulta.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Informe um código");
                    } else {
                        listaCopia_codigo_objeto(Integer.parseInt(jtf_consulta.getText().trim()));
                    }
                } else if (jrb_titulo.isSelected() == true) {
                    listaCopia_titulo(jtf_consulta.getText().trim());
                } else if (jrb_codigo_barras.isSelected() == true) {
                    listaCopia_codigo_barras(jtf_consulta.getText().trim());
                } else {
                    listaCopia_ator(jtf_consulta.getText().trim());
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConsultaCopiaDevolucao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_consultaKeyPressed

    private void jtbl_locacao_abertoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_locacao_abertoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            jtf_consulta.requestFocus();
        }
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            botaoOK(jtbl_locacao_aberto);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_locacao_abertoKeyPressed

    private void jrb_atorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_atorActionPerformed
        jtf_consulta.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_atorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ConsultaCopiaDevolucao().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JButton jb_buscar;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_ok;
    private javax.swing.JRadioButton jrb_ator;
    private javax.swing.JRadioButton jrb_codigo;
    private javax.swing.JRadioButton jrb_codigo_barras;
    private javax.swing.JRadioButton jrb_titulo;
    public static javax.swing.JTable jtbl_locacao_aberto;
    private javax.swing.JTextField jtf_consulta;
    // End of variables declaration//GEN-END:variables
    
    public ItemLocacao tbItemLocacaoLinhaSelecionada(JTable tb) {
        ItemLocacao itemSelecionada = null;
        if (tb.getSelectedRow() != -1) {
            itemSelecionada = new ItemLocacao();

            itemSelecionada.setCodigo_item_locacao(itensDevolucao.get(tb.getSelectedRow()).getCodigo_item_locacao());
            itemSelecionada.setValor_multa(itensDevolucao.get(tb.getSelectedRow()).getValor_multa());
            itemSelecionada.setDias_multa(itensDevolucao.get(tb.getSelectedRow()).getDias_multa());
            itemSelecionada.setData_locacao(itensDevolucao.get(tb.getSelectedRow()).getData_locacao());
            itemSelecionada.setValor_locado(itensDevolucao.get(tb.getSelectedRow()).getValor_locado());
            itemSelecionada.setValor_pago(itensDevolucao.get(tb.getSelectedRow()).getValor_pago());

            Diaria diaria = new Diaria();
            diaria.setDias(itensDevolucao.get(tb.getSelectedRow()).getCopia().getObjeto().getDiaria().getDias());
            diaria.setCodigo_diaria(itensDevolucao.get(tb.getSelectedRow()).getCopia().getObjeto().getDiaria().getCodigo_diaria());

            Objeto objeto = new Objeto();
            objeto.setDiaria(diaria);
            objeto.setDescricao_objeto(itensDevolucao.get(tb.getSelectedRow()).getCopia().getObjeto().getDescricao_objeto());

            Copia copia = new Copia();
            copia.setObjeto(objeto);
            copia.setCodigo_copia(itensDevolucao.get(tb.getSelectedRow()).getCopia().getCodigo_copia());
            copia.setCodigo_barras(itensDevolucao.get(tb.getSelectedRow()).getCopia().getCodigo_barras());

            itemSelecionada.setCopia(copia);

        }
        return itemSelecionada;
    }

    public void listaCopia_codigo_objeto(Integer codigo_objeto) throws SQLException {
        pool = new Pool();
        locacaoDAO = new LocacaoDAO(pool);
        itens = null;
        itens = locacaoDAO.getCopiaCodigoObjeto(codigo_objeto);
        mostrar_locacoes(itens);
    }

    public void listaCopia_titulo(String titulo) {
        pool = new Pool();
        locacaoDAO = new LocacaoDAO(pool);
        itens = null;
        itens = locacaoDAO.getCopiaDevolucaoTitulo(titulo);
        mostrar_locacoes(itens);
    }

    public void listaCopia_ator(String ator) {
        pool = new Pool();
        locacaoDAO = new LocacaoDAO(pool);
        itens = null;
        itens = locacaoDAO.getCopiaDevolucaoAtor(ator);
        mostrar_locacoes(itens);
    }

    public void listaCopia_codigo_barras(String codigo_barras) {
        pool = new Pool();
        locacaoDAO = new LocacaoDAO(pool);
        itens = null;
        itens = locacaoDAO.getCopiaDevolucaoCodigoBarras(codigo_barras);
        mostrar_locacoes(itens);
    }

    public void listaTodasCopias() throws SQLException {
        pool = new Pool();
        CopiaDAO copiaDAO = new CopiaDAO(pool);
//        copias = copiaDAO.getTodasCopias();
//        mostraCopia(copias);
    }

    public void mostrar_locacoes(List<ItemLocacao> itemLocacoes) {

        try {
            DefaultTableModel tableModel = (DefaultTableModel) ConsultaCopiaDevolucao.jtbl_locacao_aberto.getModel();
            tableModel.setNumRows(0);

            if (itemLocacoes.size() == 0) {
                JOptionPane.showMessageDialog(null, "Objeto não encontrado");
                jtf_consulta.requestFocus();
            } else {

                for (int i = 0; i < itemLocacoes.size(); i++) {

                    ItemLocacao itemLocacao = new ItemLocacao();
                    itemLocacao.setCodigo_item_locacao(itemLocacoes.get(i).getCodigo_item_locacao());

                    itemLocacao.setValor_multa(itemLocacoes.get(i).getValor_multa());
                    itemLocacao.setDias_multa(itemLocacoes.get(i).getDias_multa());
                    itemLocacao.setData_locacao(itemLocacoes.get(i).getData_locacao());
                    itemLocacao.setData_devolucao(itemLocacoes.get(i).getData_devolucao());

                    Diaria diaria = new Diaria();
                    diaria.setDias(itemLocacoes.get(i).getCopia().getObjeto().getDiaria().getDias());

                    Objeto objeto = new Objeto();
                    objeto.setDiaria(diaria);
                    objeto.setDescricao_objeto(itemLocacoes.get(i).getCopia().getObjeto().getDescricao_objeto());

                    Copia copia = new Copia();
                    copia.setObjeto(objeto);
                    copia.setCodigo_barras(itemLocacoes.get(i).getCopia().getCodigo_barras());

                    itemLocacao.setCopia(copia);

                    SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

                    String data_locacao;
                    data_locacao = out.format(in.parse(itemLocacoes.get(i).getData_locacao().toString()));
                    String data_devolucao = out.format(in.parse(itemLocacoes.get(i).getData_devolucao().toString()));

                    Moeda moeda = new Moeda();

                    DefaultTableModel row = (DefaultTableModel) ConsultaCopiaDevolucao.jtbl_locacao_aberto.getModel();
                    ItemDbGrid hashDbGrid = new ItemDbGrid(itemLocacao, itemLocacao.getCopia().getObjeto().getDescricao_objeto());
                    row.addRow(new Object[]{itemLocacao.getCopia().getCodigo_barras(), hashDbGrid, data_locacao, data_devolucao,
                        moeda.setPrecoFormat(String.valueOf(itemLocacao.getValor_multa())), itemLocacao.getDias_multa()});

                }
                ConsultaCopiaDevolucao.itensDevolucao = itemLocacoes;
                jtbl_locacao_aberto.requestFocus();
                jtbl_locacao_aberto.setSelectionMode(1);
            }
        } catch (ParseException ex) {
            Logger.getLogger(ConsultaCopiaDevolucao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void acionarAtalho(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F10) {
            botaoOK(jtbl_locacao_aberto);
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            setVisible(false);
            janelapaiDevolucao.setStatusTela(true);
        }
    }
}
