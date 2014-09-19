package br.com.locadora.model.command;

import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.bean.ItemLocacao;
import br.com.locadora.model.bean.Locacao;
import br.com.locadora.model.bean.Objeto;
import br.com.locadora.model.dao.InterfaceClienteDAO;
import br.com.locadora.model.dao.InterfaceCopiaDAO;
import br.com.locadora.model.dao.InterfaceLocacaoDAO;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.view.Atendimento;
import static br.com.locadora.view.Atendimento.itemLocacaoes;
import br.com.locadora.view.MenuCliente;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultarLocacao implements InterfaceCommand {

    private InterfaceLocacaoDAO locacaoDAO;
    private InterfaceClienteDAO clienteDAO;
    private InterfaceCopiaDAO copiaDAO;

    public ConsultarLocacao(InterfaceLocacaoDAO locacaoDAO, InterfaceClienteDAO clienteDAO, InterfaceCopiaDAO copiaDAO) {
        super();
        this.clienteDAO = clienteDAO;
        this.copiaDAO = copiaDAO;
        this.locacaoDAO = locacaoDAO;
    }

    public String execute() {

        try {

            List<ItemLocacao> itens = new ArrayList();
            JOptionPane.showMessageDialog(null, Atendimento.jtf_codigo_cliente.getText());

            itens = locacaoDAO.getLocacao_codigo(Integer.parseInt(Atendimento.jtf_codigo_cliente.getText()));
            for (int i = 0; i < Atendimento.jtbl_locacao.getRowCount(); i++) {
                ItemLocacao itemLocacao = new ItemLocacao();

                Copia copia = new Copia();
                copia.setCodigo_copia((Integer) Atendimento.jtbl_locacao.getValueAt(i, 0));
//                itemLocacao.setLocacao(locacao);
                itemLocacao.setCopia(copia);
                itemLocacao.setData_locacao(new SimpleDateFormat("dd/MM/yyyy").parse((String) Atendimento.jftf_data_locacao.getText()));
                itens.add(itemLocacao);
            }
            mostrar_locacoes(itens);
//            locacaoDAO.salvarItem(itens);
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Problemas com a gravação: ");

            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido: " + e.getMessage());

            e.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(ConsultarLocacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "OK";
    }

    public void mostrar_locacoes(List<ItemLocacao> itemLocacoes) throws ParseException {
        DefaultTableModel tableModel = (DefaultTableModel) Atendimento.jtbl_devolucao.getModel();
        tableModel.setNumRows(0);

        if (itemLocacoes.size() == 0) {

        } else {

            for (int i = 0; i < itemLocacoes.size(); i++) {

                ItemLocacao itemLocacao = new ItemLocacao();
                itemLocacao.setCodigo_item_locacao(itemLocacoes.get(i).getCodigo_item_locacao());

                itemLocacao.setValor_multa(itemLocacoes.get(i).getValor_multa());
                itemLocacao.setDias_multa(itemLocacoes.get(i).getDias_multa());
                itemLocacao.setData_locacao(itemLocacoes.get(i).getData_locacao());

                Diaria diaria = new Diaria();
                diaria.setDias(itemLocacoes.get(i).getCopia().getObjeto().getDiaria().getDias());

                Objeto objeto = new Objeto();
                objeto.setDiaria(diaria);
                objeto.setDescricao_objeto(itemLocacoes.get(i).getCopia().getObjeto().getDescricao_objeto());

                Copia copia = new Copia();
                copia.setObjeto(objeto);

                itemLocacao.setCopia(copia);

                SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

                String data_locacao = out.format(in.parse(itemLocacoes.get(i).getData_locacao().toString()));

                DefaultTableModel row = (DefaultTableModel) Atendimento.jtbl_devolucao.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(itemLocacao, itemLocacao.getCopia().getObjeto().getDescricao_objeto());
                row.addRow(new Object[]{itemLocacao.getCodigo_item_locacao(),itemLocacao.getCodigo_item_locacao(), hashDbGrid, "Não", data_locacao, itemLocacao.getValor_multa(), 
                    itemLocacao.getValor_multa(), itemLocacao.getDias_multa() });
                
            }
            Atendimento.itemLocacaoes = itemLocacaoes;
        }

    }

}
