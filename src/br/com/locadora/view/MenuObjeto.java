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
import br.com.locadora.controller.SiscomController;
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.util.ItemDbGrid;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class MenuObjeto extends javax.swing.JFrame {

    String permissao;

    public MenuObjeto() {
        initComponents();
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
    }
    TelaPrincipal janelapai;

    public void setJanelaPai(TelaPrincipal janelapai) {

        janelapai = janelapai;
        permissao = janelapai.permissao;

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
        jrb_cpf = new javax.swing.JRadioButton();
        jrb_detalhado = new javax.swing.JRadioButton();
        jrb_descricao = new javax.swing.JRadioButton();
        jl_pesquisar_destino = new javax.swing.JLabel();
        jb_buscar = new javax.swing.JButton();
        jtf_consulta = new javax.swing.JTextField();
        jb_sair = new javax.swing.JButton();
        jb_novo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbl_cliente = new javax.swing.JTable();
        jb_alterar = new javax.swing.JButton();
        jb_excluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciamento de Objetos");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultas"));
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(jrb_cpf);
        jrb_cpf.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jrb_cpf.setSelected(true);
        jrb_cpf.setText("Código");
        jrb_cpf.setName("jrb_cpf"); // NOI18N
        jrb_cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_cpfActionPerformed(evt);
            }
        });
        jPanel1.add(jrb_cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 27, -1, -1));

        buttonGroup1.add(jrb_detalhado);
        jrb_detalhado.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jrb_detalhado.setText("Ator");
        jrb_detalhado.setName("jrb_detalhado"); // NOI18N
        jPanel1.add(jrb_detalhado, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        buttonGroup1.add(jrb_descricao);
        jrb_descricao.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jrb_descricao.setText("Título");
        jrb_descricao.setName("jrb_descricao"); // NOI18N
        jrb_descricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_descricaoActionPerformed(evt);
            }
        });
        jPanel1.add(jrb_descricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jl_pesquisar_destino.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jl_pesquisar_destino.setText("Parâmetro");
        jl_pesquisar_destino.setName("jl_pesquisar_destino"); // NOI18N
        jPanel1.add(jl_pesquisar_destino, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 62, -1, -1));

        jb_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/ok.png"))); // NOI18N
        jb_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_buscarActionPerformed1(evt);
            }
        });
        jPanel1.add(jb_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, -1, -1));

        jtf_consulta.setName("jtf_consulta"); // NOI18N
        jPanel1.add(jtf_consulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 520, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 688, 109));

        jb_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/exit.png"))); // NOI18N
        jb_sair.setText("Sair");
        jb_sair.setName("jb_sair"); // NOI18N
        jb_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_sairActionPerformed(evt);
            }
        });
        getContentPane().add(jb_sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, -1, 33));

        jb_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/novo_registro.gif"))); // NOI18N
        jb_novo.setText("Novo");
        jb_novo.setName("jb_novo"); // NOI18N
        jb_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_novoActionPerformed(evt);
            }
        });
        getContentPane().add(jb_novo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Lote", "Preço", "Quantidade", "Vencimento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jTable1.setName("jTable1"); // NOI18N
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 688, 150));

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        jtbl_cliente.setUpdateSelectionOnSort(false);
        jtbl_cliente.setVerifyInputWhenFocusTarget(false);
        jtbl_cliente.setDefaultEditor(Object.class, null);
        jtbl_cliente.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount() == 1){
                    //    listarItem();
                }}});
                jtbl_cliente.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {

                    },
                    new String [] {
                        "Código", "Nome", "Data Nascimento", "CPF", "Email", "Status"
                    }
                ) {
                    Class[] types = new Class [] {
                        java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
                jtbl_cliente.setName("jtbl_cliente"); // NOI18N
                jtbl_cliente.getTableHeader().setReorderingAllowed(false);
                jScrollPane3.setViewportView(jtbl_cliente);
                if (jtbl_cliente.getColumnModel().getColumnCount() > 0) {
                    jtbl_cliente.getColumnModel().getColumn(0).setPreferredWidth(20);
                    jtbl_cliente.getColumnModel().getColumn(1).setPreferredWidth(100);
                    jtbl_cliente.getColumnModel().getColumn(2).setPreferredWidth(30);
                    jtbl_cliente.getColumnModel().getColumn(3).setPreferredWidth(30);
                    jtbl_cliente.getColumnModel().getColumn(4).setPreferredWidth(30);
                    jtbl_cliente.getColumnModel().getColumn(5).setPreferredWidth(30);
                }

                getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 688, 166));

                jb_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/alterar_registro.gif"))); // NOI18N
                jb_alterar.setText("Alterar");
                jb_alterar.setName("jb_alterar"); // NOI18N
                jb_alterar.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_alterarActionPerformed(evt);
                    }
                });
                getContentPane().add(jb_alterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, -1));

                jb_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/delete.gif"))); // NOI18N
                jb_excluir.setText("Excluir");
                jb_excluir.setName("jb_excluir"); // NOI18N
                jb_excluir.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_excluirActionPerformed(evt);
                    }
                });
                getContentPane().add(jb_excluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, -1, -1));

                setSize(new java.awt.Dimension(752, 568));
                setLocationRelativeTo(null);
            }// </editor-fold>//GEN-END:initComponents

    private void jb_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_buscarActionPerformed

//        if (jrb_cpf.isSelected() == true) {
//            listar_clientes_cpf();
//        } else if (jrb_descricao.isSelected() == true) {
//            listarEntradas();
//        } else if (jrb_detalhado.isSelected() == true) {
//            listarFornecedor();
//        } else {
//            listarEntradas();
//        }
}//GEN-LAST:event_jb_buscarActionPerformed

    private void jb_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_novoActionPerformed
        try {
            CadastroObjeto cadastroObjeto = new CadastroObjeto();
            cadastroObjeto.janelaPaim = this;
            cadastroObjeto.setVisible(true);
            this.setEnabled(false);
        } catch (SQLException ex) {
            Logger.getLogger(MenuObjeto.class.getName()).log(Level.SEVERE, null, ex);
        }

}//GEN-LAST:event_jb_novoActionPerformed

    private void jb_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_sairActionPerformed
        setVisible(false);
}//GEN-LAST:event_jb_sairActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        setVisible(false);
    }//GEN-LAST:event_formWindowClosed

    private void jb_buscarActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_buscarActionPerformed1
//        if (jrb_cpf.isSelected()) {
//            listar_clientes_cpf();
//        } else if (jrb_descricao.isSelected()) {
//            listarEntradas();
//        } else if (jrb_detalhado.isSelected()) {
//            listarFornecedor();
//        } else {
//            listarEntradas();
//        }
    }//GEN-LAST:event_jb_buscarActionPerformed1

    private void jrb_cpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_cpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_cpfActionPerformed

    private void jb_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_alterarActionPerformed
        alterar();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_alterarActionPerformed

    private void jb_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_excluirActionPerformed
//        excluiGrupo();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_excluirActionPerformed

    private void jrb_descricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_descricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_descricaoActionPerformed

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jb_alterar;
    private javax.swing.JButton jb_buscar;
    private javax.swing.JButton jb_excluir;
    private javax.swing.JButton jb_novo;
    private javax.swing.JButton jb_sair;
    private javax.swing.JLabel jl_pesquisar_destino;
    private javax.swing.JRadioButton jrb_cpf;
    private javax.swing.JRadioButton jrb_descricao;
    private javax.swing.JRadioButton jrb_detalhado;
    public static javax.swing.JTable jtbl_cliente;
    public static javax.swing.JTextField jtf_consulta;
    // End of variables declaration//GEN-END:variables
    private TelaPrincipal_Interface telaPrincipal;//Recebendo tela como parametro para atualização apos pesquisa
    
    List<Cliente> clientes;
    public Cliente tbClienteLinhaSelecionada(JTable tb) {
        Cliente cliente = null;
        if (tb.getSelectedRow() != -1) {
            cliente = new Cliente();
            cliente.setCodigo_cliente(clientes.get(tb.getSelectedRow()).getCodigo_cliente());
        }
        return cliente;
    }
    
    public void alterar() {
//        Cliente cliente = tbClienteLinhaSelecionada(jtbl_cliente);       
//        if (cliente != null) {
//            
//            GrupoAlterarGUI grupoAltera = new GrupoAlterarGUI(grup, sub);
//            grupoAltera.janelapai = this;
//            grupoAltera.setVisible(true);
//            this.setEnabled(false);
//        } else {
//            JOptionPane.showMessageDialog(null, "Selecione um grupo e um sub-grupo");
//            jtf_consulta.requestFocus();
//        }
    }

    public void setTelaPrincipal(TelaPrincipal_Interface telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
    }

    void request() {
        jtf_consulta.requestFocus();
    }

    InterfacePool pool;
    SiscomController controller;

    public void listar_clientes_cpf() {
        controller = new SiscomController();
        controller.processarRequisicao("consultarCliente_cpf");

        if (jtf_consulta.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe o código para procurar");
        } else {
            controller = new SiscomController();
            controller.processarRequisicao("consultarCliente_cpf");
        }
    }
//
//    public void listarFornecedor() {
//        EntradaDAO controlEntrada = new EntradaDAO();
//        entradas = controlEntrada.listarFornecedor(jtf_consulta.getText().trim() + "%");
//        mostrarNotas(entradas);
//    }
//
//    public void listarEntradas() {
//        EntradaDAO controlEntrada = new EntradaDAO();
//        entradas = controlEntrada.listarDescricao("%" + jtf_consulta.getText().trim() + "%");
//        mostrarNotas(entradas);
//
//    }

//    public void mostrarNotas(List<EntradaModel> entradas) {
//        DefaultTableModel tableModel = (DefaultTableModel) jtbl_cliente.getModel();
//        tableModel.setNumRows(0);
//
//        if (entradas.size() == 0) {
//            JOptionPane.showMessageDialog(this, "Nenhuma entrada encontrada");
//
//        } else {
//
//            for (int i = 0; i < entradas.size(); i++) {
//                try {
//                    EntradaModel entrada = new EntradaModel();
//                    entrada.setIdEntrada(entradas.get(i).getIdEntrada());
//                    entrada.setLancamento(entradas.get(i).getLancamento());
//                    Date data;
//
//                    SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
//                    SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
//
//                    String lancamento = out.format(in.parse(entradas.get(i).getLancamento().toString()));
//                    String emissao = out.format(in.parse(entradas.get(i).getEmissao().toString()));
//
//                    entrada.setFornecedor(entradas.get(i).getFornecedor());
//                    entrada.setNotaFiscal(entradas.get(i).getNotaFiscal());
//                    entrada.setnSérie(entradas.get(i).getnSérie());
//                    entrada.setEmissao(entradas.get(i).getEmissao());
//
//                    DefaultTableModel row = (DefaultTableModel) jtbl_cliente.getModel();
//                    ItemDbGrid hashDbGrid = new ItemDbGrid(entrada, entrada.getFornecedor().getRazao_social());
//                    row.addRow(new Object[]{entrada.getIdEntrada(), lancamento, hashDbGrid, entrada.getNotaFiscal(), entrada.getnSérie(), emissao});
//                } catch (ParseException ex) {
//                    Logger.getLogger(MenuObjeto.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//            }
//        }
//
//    }

//    public void listarItem() {
//        EntradaModel entrada = tbNotaSelecionada(jtbl_cliente);
//        if (entrada != null) {
//            EntradaDAO controlEntrada = new EntradaDAO();
//            Integer nota;
//            nota = entrada.getIdEntrada();
//            //controlEntrada.listarItens(entrada.getIdEntrada());
//            entradaItens = controlEntrada.listarItens(nota);
//            mostrarItens(entradaItens);
//        } else {
//            JOptionPane.showMessageDialog(null, "Selecione uma nota");
//            jtf_consulta.requestFocus();
//        }
//    }
//
//    public EntradaModel tbNotaSelecionada(JTable tb) {
//        EntradaModel entrada = null;
//        if (tb.getSelectedRow() != -1) {
//            entrada = new EntradaModel();
////            entrada.setIdEntrada(entradas.get(tb.getSelectedRow()).getIdEntrada());
//
//        }
//        return entrada;
//
//    }

//    public void mostrarItens(List<EntradaItem> entradaItens) {
//        ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
//        jTable1.updateUI();
//
//        if (entradaItens.size() == 0) {
//            JOptionPane.showMessageDialog(this, "Nenhum item encontrado");
//
//        } else {
//
//            String preço = null;
//
//            for (int i = 0; i < entradaItens.size(); i++) {
//                try {
//                    //ou i<destino.size() para retornar todos
//                    EntradaItem entradaItemModel = new EntradaItem();
//                    entradaItemModel.setProduto(entradaItens.get(i).getProduto());
//                    entradaItemModel.setLote(entradaItens.get(i).getLote());
//                    entradaItemModel.setQnt(entradaItens.get(i).getQnt());
//                    entradaItemModel.setPreco(entradaItens.get(i).getPreco());
//                    entradaItemModel.setVencimento(entradaItens.get(i).getVencimento());
//
//                    preço = String.valueOf(entradaItens.get(i).getPreco());
//                    preço = setPrecoFormat(preço);
//
//                    SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
//                    SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
//
//                    String vencimento = out.format(in.parse(entradaItens.get(i).getVencimento().toString()));
//
//                    DefaultTableModel row = (DefaultTableModel) jTable1.getModel();
//                    ItemDbGrid hashDbGrid = new ItemDbGrid(entradaItemModel, entradaItemModel.getProduto().getNome_produto());
//                    row.addRow(new Object[]{hashDbGrid, entradaItemModel.getLote(),
//                        preço, entradaItemModel.getQnt(), vencimento});
//                } catch (ParseException ex) {
//                    Logger.getLogger(MenuObjeto.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//            }
//            //   JOptionPane.showMessageDialog(null, preço);
//        }
//
//    }

//    public void statusTela(boolean status) {
//        if (status) {
//            this.setVisible(status);
//        }
//        this.setEnabled(status);
//    }

    public Double getPrecoFormato(String preco) {
        Double precoFormatado = 0.0;
        try {
            preco = preco.replace("R", "");
            preco = preco.replace("$", "");
            preco = preco.replace(",", ".");
            preco = preco.replace(" ", "");
            precoFormatado = Double.parseDouble(preco.trim());

            //this.objFuncionario.setSalario(getSalarioFormat(jTSalario.getText())); pegar valor em double
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Valor Informado Incorreto!\nInforme um valor com o seguinte formato:\nEx: 100,00");
        }
        return precoFormatado;
    }

    public String setPrecoFormat(String preco) {
        DecimalFormat dFormat = new DecimalFormat();
        dFormat.applyPattern("R$ #0.00");
        return dFormat.format(getPrecoFormato(preco));
    }
}