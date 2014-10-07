package br.com.locadora.model.command;

import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.ItemLocacao;
import br.com.locadora.model.bean.Locacao;
import br.com.locadora.model.dao.InterfaceClienteDAO;
import br.com.locadora.model.dao.InterfaceCopiaDAO;
import br.com.locadora.model.dao.InterfaceLocacaoDAO;
import br.com.locadora.util.Moeda;
import br.com.locadora.view.AtendimentoLocacao;
import br.com.locadora.view.EntradaCaixa;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            
            dependente.setCodigo_dependente(AtendimentoLocacao.dependente.getCodigo_dependente());
            
            cliente.setCodigo_cliente(Integer.parseInt(AtendimentoLocacao.jtf_codigo_cliente.getText()));
            
            Locacao locacao = new Locacao();
            locacao.setCliente(cliente);            
            locacao.setDependente(dependente);
            
            locacao = locacaoDAO.salvar(locacao);
            
            List<ItemLocacao> itens = new ArrayList();
            Double valor_pago;
            Moeda moeda = new Moeda();
            valor_pago = moeda.getPrecoFormato(EntradaCaixa.jtf_valor_pago.getText());
            for (int i = 0; i < AtendimentoLocacao.jtbl_locacao.getRowCount(); i++) {
                ItemLocacao itemLocacao = new ItemLocacao();
                
                Copia copia = new Copia();
                copia.setCodigo_copia(AtendimentoLocacao.copiasLocacao.get(i).getCodigo_copia());
                copia.setStatus("1");
                
                itemLocacao.setValor_locado(AtendimentoLocacao.copiasLocacao.get(i).getObjeto().getDiaria().getValor());
                if(valor_pago > 0){
                    if(valor_pago < itemLocacao.getValor_locado()){
                        itemLocacao.setValor_pago(valor_pago);                        
                    }else{
                        itemLocacao.setValor_pago(itemLocacao.getValor_locado());   
                        valor_pago = valor_pago - itemLocacao.getValor_locado();
                    }
                }else{
                    itemLocacao.setValor_pago(0.00);   
                }
                itemLocacao.setLocacao(locacao);
                itemLocacao.setCopia(copia);
                itens.add(itemLocacao);
                
                copiaDAO.alterarStatusFilme(copia);
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
