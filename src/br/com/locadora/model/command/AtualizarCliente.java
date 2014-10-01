package br.com.locadora.model.command;

import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.Telefone;
import br.com.locadora.model.dao.InterfaceClienteDAO;
import br.com.locadora.model.dao.InterfaceDependenteDAO;
import br.com.locadora.model.dao.InterfaceTelefoneDAO;
import br.com.locadora.view.AtualizaCliente;
import br.com.locadora.view.CadastroCliente;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

            cliente.setCodigo_cliente(Integer.parseInt(AtualizaCliente.jtf_codigo_cliente.getText()));
            cliente.setNome_cliente(AtualizaCliente.jtf_nome_cliente.getText());
            try {
                cliente.setData_nascimento(new SimpleDateFormat("dd/MM/yyyy").parse((String) AtualizaCliente.jtf_data_nascimento.getText()));
            } catch (ParseException ex) {
                Logger.getLogger(AtualizarCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            cliente.setCpf(AtualizaCliente.jtf_cpf.getText());
            cliente.setNome_empresa_trabalho(AtualizaCliente.jtf_empresa.getText());
            cliente.setProfissao(AtualizaCliente.jtf_profissao.getText());
            cliente.setEndereco(AtualizaCliente.jtf_endereco.getText());
            cliente.setBairro(AtualizaCliente.jtf_bairro.getText());
            cliente.setComplemento(AtualizaCliente.jtf_complemento.getText());
            cliente.setCidade(AtualizaCliente.jtf_cidade.getText());
            cliente.setEstado(AtualizaCliente.jtf_estado.getText());
            cliente.setEmail(AtualizaCliente.jtf_email.getText());
            cliente.setObservacao(AtualizaCliente.jta_observacao.getText());
            
            if(AtualizaCliente.jrb_ativo.isSelected() == true){
                cliente.setStatus("0");
            }else{
                cliente.setStatus("1");
            }

            clienteDAO.atualizar(cliente);
            
//            List<Telefone> itens_telefone = new ArrayList();
//            for (int i = 0; i < CadastroCliente.jtbl_telefone.getRowCount(); i++) {
//                Telefone telefone = new Telefone();
//                telefone.setTelefone((String) CadastroCliente.jtbl_telefone.getValueAt(i, 0));
//                itens_telefone.add(telefone);
//            }
//            
//            telefoneDAO.salvar(itens_telefone, cliente);
//            
//            List<Dependente> itens_dependente = new ArrayList();
//            for (int i = 0; i < CadastroCliente.jtbl_dependente.getRowCount(); i++) {
//                Dependente dependente = new Dependente();
//                dependente.setNome_dependente((String) CadastroCliente.jtbl_dependente.getValueAt(i, 0));
//                itens_dependente.add(dependente);
//            }
//            
//            dependenteDAO.salvar(itens_dependente, cliente);
            

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
