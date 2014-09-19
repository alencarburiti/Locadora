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
import javax.swing.table.DefaultTableModel;

public class ConsultarCliente implements InterfaceCommand {

    private final InterfaceClienteDAO clienteDAO;

    public ConsultarCliente(InterfaceClienteDAO clienteDAO) {
        super();
        this.clienteDAO = clienteDAO;
    }

    List<Cliente> clientes;
    Cliente cliente;

    public String execute() {

        try {
            if (MenuCliente.jrb_codigo_cliente.isSelected() == true) {
                cliente = null;
                cliente = clienteDAO.getCliente_codigo(Integer.parseInt(jtf_consulta.getText().trim()));
                mostrar_clientes(cliente);
            } else if (MenuCliente.jrb_nome_cliente.isSelected() == true) {
                cliente = null;
                cliente = clienteDAO.getCliente_nome(jtf_consulta.getText().trim());
                mostrar_clientes(cliente);
            } else if (MenuCliente.jrb_cpf.isSelected() == true) {
                cliente = null;
                cliente = clienteDAO.getCliente_cpf(jtf_consulta.getText().trim());
                mostrar_clientes(cliente);
            } else {
                clientes = null;
                clientes = clienteDAO.getClientes();
                mostrar_clientes(clientes);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Problemas com a consulta: ");

            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido: " + e.getMessage());

            e.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(ConsultarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "OK";
    }

    public void mostrar_clientes(List<Cliente> clientes) throws ParseException {
        DefaultTableModel tableModel = (DefaultTableModel) MenuCliente.jtbl_cliente.getModel();
        tableModel.setNumRows(0);

        if (clientes.size() == 0) {

        } else {

            for (int i = 0; i < clientes.size(); i++) {

                Cliente cliente = new Cliente();

                cliente.setCodigo_cliente(clientes.get(i).getCodigo_cliente());
                cliente.setNome_cliente(clientes.get(i).getNome_cliente());
                cliente.setNome_empresa_trabalho(clientes.get(i).getNome_empresa_trabalho());
                cliente.setProfissao(clientes.get(i).getProfissao());
                cliente.setCpf(clientes.get(i).getCpf());
                cliente.setData_nascimento(clientes.get(i).getData_nascimento());
                cliente.setEndereco(clientes.get(i).getEndereco());
                cliente.setBairro(clientes.get(i).getBairro());
                cliente.setComplemento(clientes.get(i).getComplemento());
                cliente.setCidade(clientes.get(i).getCidade());
                cliente.setEstado(clientes.get(i).getEstado());
                cliente.setEmail(clientes.get(i).getEmail());

                cliente.setStatus(clientes.get(i).getStatus());
                
                if (cliente.getStatus().equals("A")) {
                    cliente.setStatus("Ativo");
                } else {
                    cliente.setStatus("Inativo");
                }
                cliente.setObservacao(clientes.get(i).getObservacao());

                SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

                String data_nascimento = out.format(in.parse(clientes.get(i).getData_nascimento().toString()));

                DefaultTableModel row = (DefaultTableModel) MenuCliente.jtbl_cliente.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(cliente, cliente.getNome_cliente());
                row.addRow(new Object[]{cliente.getCodigo_cliente(), hashDbGrid, data_nascimento, cliente.getCpf(), cliente.getEmail(), cliente.getStatus()});
            }
            MenuCliente.clientes = clientes;
        }

    }

    public void mostrar_clientes(Cliente cliente) throws ParseException {
        DefaultTableModel tableModel = (DefaultTableModel) MenuCliente.jtbl_cliente.getModel();
        tableModel.setNumRows(0);

        if (cliente == null) {

        } else {

            SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

            String data_nascimento = out.format(in.parse(cliente.getData_nascimento().toString()));

            DefaultTableModel row = (DefaultTableModel) MenuCliente.jtbl_cliente.getModel();
            ItemDbGrid hashDbGrid = new ItemDbGrid(cliente, cliente.getNome_cliente());
            row.addRow(new Object[]{cliente.getCodigo_cliente(), hashDbGrid, data_nascimento, cliente.getCpf(), cliente.getEmail(), cliente.getStatus()});

        }
    }

}
