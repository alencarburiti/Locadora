package br.com.locadora.model.command;

import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.ItemLocacao;
import br.com.locadora.model.bean.Locacao;
import br.com.locadora.model.bean.Telefone;
import br.com.locadora.model.dao.InterfaceClienteDAO;
import br.com.locadora.model.dao.InterfaceCopiaDAO;
import br.com.locadora.model.dao.InterfaceDependenteDAO;
import br.com.locadora.model.dao.InterfaceLocacaoDAO;
import br.com.locadora.model.dao.InterfaceTelefoneDAO;
import br.com.locadora.view.Atendimento;
import br.com.locadora.view.CadastroCliente;
import br.com.locadora.view.MenuCliente;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CadastrarLocacao implements InterfaceCommand {

    private InterfaceLocacaoDAO locacaoDAO;
    private InterfaceClienteDAO clienteDAO;
    private InterfaceCopiaDAO copiaDAO;

    public CadastrarLocacao(InterfaceLocacaoDAO locacaoDAO, InterfaceClienteDAO clienteDAO, InterfaceCopiaDAO copiaDAO) {
        super();
        this.clienteDAO = clienteDAO;
        this.copiaDAO = copiaDAO;
        this.locacaoDAO = locacaoDAO;
    }

    
    public String execute() {

        try {

            Cliente cliente = new Cliente();

            cliente.setCodigo_cliente(Integer.parseInt(Atendimento.jtf_codigo_cliente.getText()));
            
            Locacao locacao = new Locacao();
            locacao.setCliente(cliente);
            
            locacao = locacaoDAO.salvar(locacao);
            
            List<ItemLocacao> itens = new ArrayList();
            for (int i = 0; i < Atendimento.jtbl_locacao.getRowCount(); i++) {
                ItemLocacao itemLocacao = new ItemLocacao();
                
                Copia copia = new Copia();
                copia.setCodigo_copia((Integer) Atendimento.jtbl_locacao.getValueAt(i, 0));
                itemLocacao.setLocacao(locacao);
                itemLocacao.setCopia(copia);
                itens.add(itemLocacao);
            }
            
            locacaoDAO.salvarItem(itens);
            
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
