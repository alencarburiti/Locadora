package br.com.locadora.model.command;

import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.Telefone;
import br.com.locadora.model.dao.InterfaceClienteDAO;
import br.com.locadora.model.dao.InterfaceDependenteDAO;
import br.com.locadora.model.dao.InterfaceTelefoneDAO;
import br.com.locadora.view.CadastroCliente;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CadastrarCliente implements InterfaceCommand {

    private InterfaceClienteDAO clienteDAO;
    private InterfaceTelefoneDAO telefoneDAO;
    private InterfaceDependenteDAO dependenteDAO;

    public CadastrarCliente(InterfaceClienteDAO clienteDAO, InterfaceTelefoneDAO telefoneDAO, InterfaceDependenteDAO dependenteDAO) {
        super();
        this.clienteDAO = clienteDAO;
        this.telefoneDAO = telefoneDAO;
        this.dependenteDAO = dependenteDAO;
    }

    public String execute() {

        try {

            Cliente cliente = new Cliente();

            cliente.setNome_cliente(CadastroCliente.jtf_nome_cliente.getText());
            cliente.setData_nascimento(new SimpleDateFormat("dd/MM/yyyy").parse((String) CadastroCliente.jtf_data_nascimento.getText()));
            cliente.setCpf(CadastroCliente.jtf_cpf_cliente.getText());
            cliente.setNome_empresa_trabalho(CadastroCliente.jtf_empresa.getText());
            cliente.setProfissao(CadastroCliente.jtf_profissao.getText());
            cliente.setEndereco(CadastroCliente.jtf_endereco.getText());
            cliente.setBairro(CadastroCliente.jtf_bairro.getText());
            cliente.setComplemento(CadastroCliente.jtf_complemento.getText());
            cliente.setCidade(CadastroCliente.jtf_cidade.getText());
            cliente.setEstado(CadastroCliente.jtf_estado.getText());
            cliente.setEmail(CadastroCliente.jtf_email.getText());
            cliente.setObservacao(CadastroCliente.jta_observacao.getText());
            if (CadastroCliente.jrb_ativo.isSelected() == true) {
                cliente.setStatus("0");

            } else {
                cliente.setStatus("1");
            }

            cliente = clienteDAO.salvar(cliente);

            List<Telefone> itens_telefone = new ArrayList();
            for (int i = 0; i < CadastroCliente.jtbl_telefone.getRowCount(); i++) {
                Telefone telefone = new Telefone();
                telefone.setTelefone((String) CadastroCliente.jtbl_telefone.getValueAt(i, 0));
                itens_telefone.add(telefone);
            }

            telefoneDAO.salvar(itens_telefone, cliente);

            Dependente dependente = new Dependente();
            List<Dependente> itens_dependente = new ArrayList();
            dependente.setNome_dependente(cliente.getNome_cliente());
            dependente.setData_nascimento(cliente.getData_nascimento());
            dependente.setTipo_dependente("0");
            itens_dependente.add(dependente);
            for (int i = 0; i < CadastroCliente.jtbl_dependente.getRowCount(); i++) {
                dependente = new Dependente();
                dependente.setNome_dependente((String) CadastroCliente.jtbl_dependente.getValueAt(i, 0));
                dependente.setData_nascimento(new SimpleDateFormat("dd/MM/yyyy").parse((String) CadastroCliente.jtbl_dependente.getValueAt(i, 1)));
                dependente.setTelefone((String) CadastroCliente.jtbl_dependente.getValueAt(i, 2));
                dependente.setParentesco((String) CadastroCliente.jtbl_dependente.getValueAt(i, 3));
                dependente.setCPF((String) CadastroCliente.jtbl_dependente.getValueAt(i, 4));
                dependente.setTipo_dependente("1");
                itens_dependente.add(dependente);
            }

            dependenteDAO.salvar(itens_dependente, cliente);

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Problemas com a gravação: ");

            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido: " + e.getMessage());

            e.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "OK";
    }

}
