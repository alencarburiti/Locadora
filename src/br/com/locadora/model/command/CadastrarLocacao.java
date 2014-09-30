package br.com.locadora.model.command;

import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.ItemLocacao;
import br.com.locadora.model.bean.Locacao;
import br.com.locadora.model.dao.InterfaceClienteDAO;
import br.com.locadora.model.dao.InterfaceCopiaDAO;
import br.com.locadora.model.dao.InterfaceLocacaoDAO;
import br.com.locadora.view.Atendimento;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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

            Dependente dependente = new Dependente();
            Cliente cliente = new Cliente();
            
            dependente.setCodigo_dependente(Atendimento.dependente.getCodigo_dependente());
            
            cliente.setCodigo_cliente(Integer.parseInt(Atendimento.jtf_codigo_cliente.getText()));
            
            Locacao locacao = new Locacao();
            locacao.setCliente(cliente);            
            locacao.setDependente(dependente);
            
            locacao = locacaoDAO.salvar(locacao);
            
            List<ItemLocacao> itens = new ArrayList();
            for (int i = 0; i < Atendimento.jtbl_locacao.getRowCount(); i++) {
                ItemLocacao itemLocacao = new ItemLocacao();
                
                Copia copia = new Copia();
                copia.setCodigo_copia(Atendimento.copiasLocacao.get(i).getCodigo_copia());
                itemLocacao.setValor_locado(Atendimento.copiasLocacao.get(i).getObjeto().getDiaria().getValor());
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
