package br.com.locadora.model.command;

import br.com.locadora.model.bean.ItemLocacao;
import br.com.locadora.model.dao.InterfaceClienteDAO;
import br.com.locadora.model.dao.InterfaceCopiaDAO;
import br.com.locadora.model.dao.InterfaceLocacaoDAO;
import br.com.locadora.view.Atendimento;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CadastrarDevolucao implements InterfaceCommand {

    private InterfaceLocacaoDAO locacaoDAO;
    private InterfaceClienteDAO clienteDAO;
    private InterfaceCopiaDAO copiaDAO;

    public CadastrarDevolucao(InterfaceLocacaoDAO locacaoDAO, InterfaceClienteDAO clienteDAO, InterfaceCopiaDAO copiaDAO) {
        super();
        this.clienteDAO = clienteDAO;
        this.copiaDAO = copiaDAO;
        this.locacaoDAO = locacaoDAO;
    }

    
    public String execute() {

        try {

            List<ItemLocacao> itens = new ArrayList();
            ItemLocacao itemDevolve;
            for (int i = 0; i < Atendimento.jtbl_devolucao.getRowCount(); i++) {
                if(!Atendimento.jtbl_devolucao.getValueAt(i, 3).equals("")){
                    itemDevolve = new ItemLocacao();
                    itemDevolve.setCodigo_item_locacao(Atendimento.itensDevolucao.get(i).getCodigo_item_locacao());
                    itemDevolve.setData_devolucao(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse((String) Atendimento.jtbl_devolucao.getValueAt(i, 3)));
                    itens.add(itemDevolve);

                    locacaoDAO.salvarDevolucao(itens);                    
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido: " + e.getMessage());

            e.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarDevolucao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarDevolucao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return "OK";
    }

}