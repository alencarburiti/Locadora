package br.com.locadora.model.command;

import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.dao.InterfaceClienteDAO;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.view.MenuCliente;
import static br.com.locadora.view.MenuCliente.jtf_consulta;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultarCliente implements InterfaceCommand {

    private final InterfaceClienteDAO clienteDAO;
    private List<Cliente> clientes;
    private Cliente cliente;


    public ConsultarCliente(InterfaceClienteDAO clienteDAO) {
        super();
        this.clienteDAO = clienteDAO;
    }

    
    public String execute() {

        try {

            if (MenuCliente.jrb_codigo_cliente.isSelected() == true) {                
                    cliente = null;
                    cliente = clienteDAO.getCliente_codigo(Integer.parseInt(jtf_consulta.getText().trim()));
                    mostrar_clientes(cliente);                
            } else if (MenuCliente.jrb_cpf.isSelected() == true) {
                if (!MenuCliente.jtf_consulta.getText().equals("")) {
                    cliente = null;
                    cliente = clienteDAO.getCliente_cpf(jtf_consulta.getText().trim());
                    mostrar_clientes(cliente);
                } else {
                    JOptionPane.showMessageDialog(null, "Informe o CPF");
                }
            } else {
                clientes = null;
                clientes = clienteDAO.getCliente_nome(jtf_consulta.getText().trim());
                mostrar_clientes(clientes);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "Problemas com a consulta: ");            
        } catch (NumberFormatException e) {            
            JOptionPane.showMessageDialog(null, "Valor inválido");
        } catch (ParseException ex) {
            Logger.getLogger(ConsultarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "OK";
    }

    public void mostrar_clientes(List<Cliente> clientes) throws ParseException {
        DefaultTableModel tableModel = (DefaultTableModel) MenuCliente.jtbl_cliente.getModel();
        tableModel.setNumRows(0);

        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
        } else {

            for (Cliente cliente1 : clientes) {
                
                cliente = new Cliente();
                cliente.setCodigo_cliente(cliente1.getCodigo_cliente());
                cliente.setNome_cliente(cliente1.getNome_cliente());
                cliente.setNome_empresa_trabalho(cliente1.getNome_empresa_trabalho());
                cliente.setProfissao(cliente1.getProfissao());
                cliente.setCpf(cliente1.getCpf());
                cliente.setData_nascimento(cliente1.getData_nascimento());
                cliente.setEndereco(cliente1.getEndereco());
                cliente.setBairro(cliente1.getBairro());
                cliente.setComplemento(cliente1.getComplemento());
                cliente.setCidade(cliente1.getCidade());
                cliente.setEstado(cliente1.getEstado());
                cliente.setEmail(cliente1.getEmail());
                cliente.setStatus(cliente1.getStatus());
                if (cliente.getStatus().equals("0")) {
                    cliente.setStatus("Ativo");
                } else {
                    cliente.setStatus("Inativo");
                }
                cliente.setObservacao(cliente1.getObservacao());
                SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
                String data_nascimento = out.format(in.parse(cliente1.getData_nascimento().toString()));
                DefaultTableModel row = (DefaultTableModel) MenuCliente.jtbl_cliente.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(cliente, cliente.getNome_cliente());
                row.addRow(new Object[]{cliente.getCodigo_cliente(), hashDbGrid, data_nascimento, cliente.getCpf(), cliente.getEmail(), cliente.getStatus()});
            }
            MenuCliente.clientes = clientes;
            
            
            MenuCliente.jtbl_cliente.requestFocus();
            MenuCliente.jtbl_cliente.setSelectionMode(1);
        }

    }

    public void mostrar_clientes(Cliente cliente) throws ParseException {
        DefaultTableModel tableModel = (DefaultTableModel) MenuCliente.jtbl_cliente.getModel();
        tableModel.setNumRows(0);

        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
        } else {

            if (cliente.getStatus().equals("0")) {
                cliente.setStatus("Ativo");
            } else {
                cliente.setStatus("Inativo");
            }

            SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

            String data_nascimento = out.format(in.parse(cliente.getData_nascimento().toString()));

            DefaultTableModel row = (DefaultTableModel) MenuCliente.jtbl_cliente.getModel();
            ItemDbGrid hashDbGrid = new ItemDbGrid(cliente, cliente.getNome_cliente());
            row.addRow(new Object[]{cliente.getCodigo_cliente(), hashDbGrid, data_nascimento, cliente.getCpf(), cliente.getEmail(), cliente.getStatus()});

            MenuCliente.jtbl_cliente.requestFocus();
            MenuCliente.jtbl_cliente.setSelectionMode(1);
        }
    }

}
