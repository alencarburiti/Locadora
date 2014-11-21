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
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.dao.ClienteDAO;
import br.com.locadora.model.dao.UsuarioDAO;
import br.com.locadora.util.ArquivoConfiguracao;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MenuCliente extends javax.swing.JFrame {

    public String permissao;
    public TelaPrincipal janelapai;
    public static List<Cliente> clientes;
    public InterfacePool pool;
    public SiscomController controller;
    public AcessoUsuario acesso;
    public Cliente cliente;

    public MenuCliente() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jl_pesquisar_destino = new javax.swing.JLabel();
        jb_buscar = new javax.swing.JButton();
        jtf_consulta = new javax.swing.JTextField();
        jrb_codigo_cliente = new javax.swing.JRadioButton();
        jrb_cpf = new javax.swing.JRadioButton();
        jrb_nome_cliente = new javax.swing.JRadioButton();
        jb_sair = new javax.swing.JButton();
        jb_novo = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbl_cliente = new javax.swing.JTable();
        jb_alterar = new javax.swing.JButton();
        jb_excluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciamento de Clientes");
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta Cliente"));
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_pesquisar_destino.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jl_pesquisar_destino.setText("Parâmetro");
        jl_pesquisar_destino.setName("jl_pesquisar_destino"); // NOI18N
        jPanel1.add(jl_pesquisar_destino, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jb_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pesquisar.png"))); // NOI18N
        jb_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_buscarActionPerformed1(evt);
            }
        });
        jb_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_buscarKeyPressed(evt);
            }
        });
        jPanel1.add(jb_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, -1));

        jtf_consulta.setName("jtf_consulta"); // NOI18N
        jtf_consulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_consultaKeyPressed(evt);
            }
        });
        jPanel1.add(jtf_consulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 300, 30));

        buttonGroup1.add(jrb_codigo_cliente);
        jrb_codigo_cliente.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jrb_codigo_cliente.setText("Código Cliente");
        jrb_codigo_cliente.setName("jrb_codigo_cliente"); // NOI18N
        jrb_codigo_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_codigo_clienteActionPerformed(evt);
            }
        });
        jPanel1.add(jrb_codigo_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        buttonGroup1.add(jrb_cpf);
        jrb_cpf.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jrb_cpf.setText("CPF");
        jrb_cpf.setName("jrb_cpf"); // NOI18N
        jrb_cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_cpfActionPerformed(evt);
            }
        });
        jPanel1.add(jrb_cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        buttonGroup1.add(jrb_nome_cliente);
        jrb_nome_cliente.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jrb_nome_cliente.setSelected(true);
        jrb_nome_cliente.setText("Nome");
        jrb_nome_cliente.setName("jrb_nome_cliente"); // NOI18N
        jrb_nome_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_nome_clienteActionPerformed(evt);
            }
        });
        jPanel1.add(jrb_nome_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 670, 120));

        jb_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/exit.png"))); // NOI18N
        jb_sair.setText("Sair");
        jb_sair.setName("jb_sair"); // NOI18N
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
        getContentPane().add(jb_sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, -1, -1));

        jb_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/novo_registro.gif"))); // NOI18N
        jb_novo.setText("Novo");
        jb_novo.setName("jb_novo"); // NOI18N
        jb_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_novoActionPerformed(evt);
            }
        });
        jb_novo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_novoKeyPressed(evt);
            }
        });
        getContentPane().add(jb_novo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        jScrollPane3.setName("jScrollPane3"); // NOI18N

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
        jtbl_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_clienteMouseClicked(evt);
            }
        });
        jtbl_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbl_clienteKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(jtbl_cliente);
        if (jtbl_cliente.getColumnModel().getColumnCount() > 0) {
            jtbl_cliente.getColumnModel().getColumn(0).setResizable(false);
            jtbl_cliente.getColumnModel().getColumn(0).setPreferredWidth(10);
            jtbl_cliente.getColumnModel().getColumn(1).setPreferredWidth(150);
            jtbl_cliente.getColumnModel().getColumn(2).setPreferredWidth(50);
            jtbl_cliente.getColumnModel().getColumn(3).setPreferredWidth(30);
            jtbl_cliente.getColumnModel().getColumn(4).setPreferredWidth(70);
            jtbl_cliente.getColumnModel().getColumn(5).setPreferredWidth(20);
        }

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 670, 210));

        jb_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/alterar_registro.gif"))); // NOI18N
        jb_alterar.setText("Alterar");
        jb_alterar.setName("jb_alterar"); // NOI18N
        jb_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_alterarActionPerformed(evt);
            }
        });
        jb_alterar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_alterarKeyPressed(evt);
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
        jb_excluir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_excluirKeyPressed(evt);
            }
        });
        getContentPane().add(jb_excluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, -1, -1));

        setSize(new java.awt.Dimension(716, 443));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jb_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_buscarActionPerformed
        buscarDados();
}//GEN-LAST:event_jb_buscarActionPerformed

    private void jb_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_novoActionPerformed
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuCliente");
        try {
            if (acesso.getEscrever() == 0) {
                CadastroCliente cadastroCliente = new CadastroCliente();
                cadastroCliente.janelapai = this;
                cadastroCliente.setVisible(true);
                setStatusTela(false);
                cadastroCliente.acesso = acesso;
            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }
}//GEN-LAST:event_jb_novoActionPerformed

    private void jb_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_sairActionPerformed
        setVisible(false);
        janelapai.setStatusTela(true);
}//GEN-LAST:event_jb_sairActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        setVisible(false);
        janelapai.setStatusTela(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void jb_buscarActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_buscarActionPerformed1
        buscarDados();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_buscarActionPerformed1

    private void jrb_codigo_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_codigo_clienteActionPerformed
        jtf_consulta.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_codigo_clienteActionPerformed

    private void jb_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_alterarActionPerformed
        alterar();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_alterarActionPerformed

    private void jb_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_excluirActionPerformed
        excluirCliente();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_excluirActionPerformed

    private void jtbl_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_clienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_clienteMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtf_consulta.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jtf_consultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_consultaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buscarDados();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_consultaKeyPressed

    private void jrb_nome_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_nome_clienteActionPerformed
        jtf_consulta.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_nome_clienteActionPerformed

    private void jrb_cpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_cpfActionPerformed
        jtf_consulta.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_cpfActionPerformed

    private void jtbl_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_clienteKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            alterar();
        }        
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            excluirCliente();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_clienteKeyPressed

    private void jb_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_buscarKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_buscarKeyPressed

    private void jb_novoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_novoKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_novoKeyPressed

    private void jb_alterarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_alterarKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_alterarKeyPressed

    private void jb_excluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_excluirKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_excluirKeyPressed

    private void jb_sairKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_sairKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_sairKeyPressed

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
                new MenuCliente().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jb_alterar;
    private javax.swing.JButton jb_buscar;
    private javax.swing.JButton jb_excluir;
    private javax.swing.JButton jb_novo;
    private javax.swing.JButton jb_sair;
    private javax.swing.JLabel jl_pesquisar_destino;
    public static javax.swing.JRadioButton jrb_codigo_cliente;
    public static javax.swing.JRadioButton jrb_cpf;
    public static javax.swing.JRadioButton jrb_nome_cliente;
    public static javax.swing.JTable jtbl_cliente;
    public static javax.swing.JTextField jtf_consulta;
    // End of variables declaration//GEN-END:variables

    public void buscarDados() {
        controller = new SiscomController();
        controller.processarRequisicao("consultarCliente");
    }

    public Cliente tbClienteLinhaSelecionada(JTable tb) {

        cliente = new Cliente();
        if (tb != null && tb.getSelectedRow() != -1) {

            cliente.setCodigo_cliente(clientes.get(tb.getSelectedRow()).getCodigo_cliente());
            cliente.setNome_cliente(clientes.get(tb.getSelectedRow()).getNome_cliente());
            cliente.setNome_empresa_trabalho(clientes.get(tb.getSelectedRow()).getNome_empresa_trabalho());
            cliente.setProfissao(clientes.get(tb.getSelectedRow()).getProfissao());
            cliente.setCpf(clientes.get(tb.getSelectedRow()).getCpf());
            cliente.setData_nascimento(clientes.get(tb.getSelectedRow()).getData_nascimento());
            cliente.setEndereco(clientes.get(tb.getSelectedRow()).getEndereco());
            cliente.setBairro(clientes.get(tb.getSelectedRow()).getBairro());
            cliente.setComplemento(clientes.get(tb.getSelectedRow()).getComplemento());
            cliente.setCidade(clientes.get(tb.getSelectedRow()).getCidade());
            cliente.setEstado(clientes.get(tb.getSelectedRow()).getEstado());
            cliente.setEmail(clientes.get(tb.getSelectedRow()).getEmail());

            if (clientes.get(tb.getSelectedRow()).getStatus().equals("A")) {
                cliente.setStatus("Ativo");
            } else {
                cliente.setStatus("Inativo");
            }
            cliente.setStatus(clientes.get(tb.getSelectedRow()).getStatus());
            cliente.setObservacao(clientes.get(tb.getSelectedRow()).getObservacao());

        } else {
            cliente = null;
        }
        return cliente;
    }

    public void alterar() {
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.Locadora.view.MenuCliente");
        try {
            System.out.println("Escrever: " + acesso.getEscrever());
            if (acesso.getEscrever() == 0) {

                cliente = tbClienteLinhaSelecionada(jtbl_cliente);
                if (cliente != null) {
                    AtualizaCliente alteraCliente = new AtualizaCliente(cliente);
                    alteraCliente.janelapai = this;
                    alteraCliente.setVisible(true);
                    setStatusTela(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um cliente");
                    jtf_consulta.requestFocus();
                    System.out.println("Objeto: " + (cliente == null));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }
    }

    public Cliente tbClienteSelecionado(JTable tb) {
        Cliente cliente = null;
        if (tb != null) {
            if (tb.getSelectedRow() != -1) {
                cliente = new Cliente();
                cliente.setCodigo_cliente(clientes.get(tb.getSelectedRow()).getCodigo_cliente());
            }
        }
        return cliente;
    }

    public void setStatusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }

    private void excluirCliente() {
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuCliente");

        try {
            if (acesso.getDeletar() == 0) {
                DefaultTableModel row = (DefaultTableModel) jtbl_cliente.getModel();
                if (jtbl_cliente.getSelectedRow() != -1) {
                    int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
                    if (selectedOption == JOptionPane.YES_NO_OPTION) {
                        pool = new Pool();
                        ClienteDAO clienteDAO = new ClienteDAO(pool);
                        cliente = new Cliente();
                        cliente.setCodigo_cliente(clientes.get(jtbl_cliente.getSelectedRow()).getCodigo_cliente());

                        try {
                            clienteDAO.excluir(cliente.getCodigo_cliente());
                            row.removeRow(jtbl_cliente.getSelectedRow());
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Este registro não pode ser excluído pois está referenciado em outra tabela");
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um cliente");
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
            excluirCliente();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            jtf_consulta.requestFocus();
        }
    }
}
