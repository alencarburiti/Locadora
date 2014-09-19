package br.com.locadora.model.command;

import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.Telefone;
import br.com.locadora.model.dao.InterfaceClienteDAO;
import br.com.locadora.model.dao.InterfaceDependenteDAO;
import br.com.locadora.model.dao.InterfaceTelefoneDAO;
import br.com.locadora.view.AtualizaCliente;
import br.com.locadora.view.CadastroCliente;
import br.com.locadora.view.MenuCliente;
import static br.com.locadora.view.MenuCliente.clientes;
import static br.com.locadora.view.MenuCliente.jtbl_cliente;
import static br.com.locadora.view.MenuCliente.jtf_consulta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class AtualizarCliente implements InterfaceCommand {

    private InterfaceClienteDAO clienteDAO;
    private InterfaceTelefoneDAO telefoneDAO;
    private InterfaceDependenteDAO dependenteDAO;

    public AtualizarCliente(InterfaceClienteDAO clienteDAO, InterfaceTelefoneDAO telefoneDAO, InterfaceDependenteDAO dependenteDAO) {
        super();
        this.clienteDAO = clienteDAO;
        this.telefoneDAO = telefoneDAO;
        this.dependenteDAO = dependenteDAO;
    }

    
    public String execute() {

        try {

            Cliente cliente = new Cliente();

            cliente.setNome_cliente(CadastroCliente.jtf_nome_cliente.getText());
//            cliente.setData_nascimento(CadastroCliente.jtf_data_nascimento.getText());
            cliente.setCpf(CadastroCliente.jtf_cpf.getText());
            cliente.setNome_empresa_trabalho(CadastroCliente.jtf_empresa.getText());
            cliente.setProfissao(CadastroCliente.jtf_profissao.getText());
            cliente.setEndereco(CadastroCliente.jtf_endereco.getText());
            cliente.setBairro(CadastroCliente.jtf_bairro.getText());
            cliente.setComplemento(CadastroCliente.jtf_complemento.getText());
            cliente.setCidade(CadastroCliente.jtf_cidade.getText());
            cliente.setEstado(CadastroCliente.jtf_estado.getText());
            cliente.setEmail(CadastroCliente.jtf_email.getText());
            cliente.setObservacao(CadastroCliente.jta_observacao.getText());

            cliente = clienteDAO.salvar(cliente);
            
            List<Telefone> itens_telefone = new ArrayList();
            for (int i = 0; i < CadastroCliente.jtbl_telefone.getRowCount(); i++) {
                Telefone telefone = new Telefone();
                telefone.setTelefone((String) CadastroCliente.jtbl_telefone.getValueAt(i, 0));
                itens_telefone.add(telefone);
            }
            
            telefoneDAO.salvar(itens_telefone, cliente);
            
            List<Dependente> itens_dependente = new ArrayList();
            for (int i = 0; i < CadastroCliente.jtbl_dependente.getRowCount(); i++) {
                Dependente dependente = new Dependente();
                dependente.setNome_dependente((String) CadastroCliente.jtbl_dependente.getValueAt(i, 0));
                itens_dependente.add(dependente);
            }
            
            dependenteDAO.salvar(itens_dependente, cliente);
            

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Problemas com a gravação: ");

            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido: " + e.getMessage());

            e.printStackTrace();
        }
        return "OK";
    }
    

}
