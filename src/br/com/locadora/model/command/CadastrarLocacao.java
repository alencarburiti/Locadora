package br.com.locadora.model.command;

import br.com.locadora.conexao.Pool;
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.bean.ItemLocacao;
import br.com.locadora.model.bean.Lancamento;
import br.com.locadora.model.bean.Locacao;
import br.com.locadora.model.bean.Objeto;
import br.com.locadora.model.bean.TipoServico;
import br.com.locadora.model.bean.Usuario;
import br.com.locadora.model.dao.DiariaDAO;
import br.com.locadora.model.dao.InterfaceClienteDAO;
import br.com.locadora.model.dao.InterfaceCopiaDAO;
import br.com.locadora.model.dao.InterfaceLocacaoDAO;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.Moeda;
import br.com.locadora.view.AtendimentoLocacao;
import br.com.locadora.view.EntradaCaixa;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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

            Usuario usuario = new Usuario();
            usuario.setCodigo_usuario(EntradaCaixa.acesso.getUsuario().getCodigo_usuario());

            locacao.setUsuario(usuario);

            Double valor_pago;
            Double troco;
            Double valor_desconto;
            Moeda moeda = new Moeda();

            valor_pago = moeda.getPrecoFormato(EntradaCaixa.jtf_valor_pago.getText());
            valor_desconto = moeda.getPrecoFormato(EntradaCaixa.jtf_desconto.getText());
            troco = moeda.getPrecoFormato(EntradaCaixa.jtf_troco.getText());

            valor_pago = valor_pago - troco;
            Lancamento lancamento = new Lancamento();
            lancamento.setUsuario(usuario);
            lancamento.setDependente(dependente);
            TipoServico tipoServico = new TipoServico();

            ArquivoConfiguracao conf = new ArquivoConfiguracao();

            //Envia a gravação da locação e envia o lancamento de caixa
            locacao = locacaoDAO.salvar(locacao);
            lancamento.setLocacao(locacao);
            lancamento.setCaixa(Integer.parseInt(conf.readPropertie("caixa")));

            //Lançamento de crédito e de débito
            if (valor_pago > 0) {
                //Lançamento de débito primeiro
                tipoServico.setCodigo_tipo_servico(1);
                lancamento.setValor(moeda.getPrecoFormato(EntradaCaixa.jtf_valor_total_locacao.getText()));

                lancamento.setTipoServico(tipoServico);
                locacaoDAO.salvarLancamento(lancamento);
                //Lançamento de crédito
                tipoServico.setCodigo_tipo_servico(6);
                lancamento.setValor(valor_pago);

                lancamento.setTipoServico(tipoServico);
                locacaoDAO.salvarLancamento(lancamento);

            } else {
                tipoServico.setCodigo_tipo_servico(1);
                lancamento.setValor(moeda.getPrecoFormato(EntradaCaixa.jtf_valor_total_locacao.getText()));

                lancamento.setTipoServico(tipoServico);
                locacaoDAO.salvarLancamento(lancamento);
            }

            if (valor_desconto > 0) {
                //Lançamento de crédito como desconto
                tipoServico.setCodigo_tipo_servico(3);
                lancamento.setValor(valor_desconto);

                lancamento.setTipoServico(tipoServico);
                locacaoDAO.salvarLancamento(lancamento);
            }

            List<ItemLocacao> itens = new ArrayList();
            List<Diaria> dias = new ArrayList<Diaria>();
            Pool pool = new Pool();
            DiariaDAO diaDAO = new DiariaDAO(pool);
            dias = diaDAO.getTodasDiarias();
            for (int i = 0; i < AtendimentoLocacao.jtbl_locacao.getRowCount(); i++) {
                System.out.println("Inciar Verificação: "+ AtendimentoLocacao.copiasLocacao.get(i).getObjeto().getDescricao_objeto());
                System.out.println("Acumulativo: "+AtendimentoLocacao.copiasLocacao.get(i).getObjeto().getDiaria().getAcumulativo());
                if (AtendimentoLocacao.copiasLocacao.get(i).getObjeto().getDiaria().getAcumulativo() == true) {
                    for (int j = 0; j < dias.size(); j++) {
                        if (dias.size() > 0) {
                            System.out.println("CODIGO DIARIA - DIARIA: "+dias.get(j).getCodigo_diaria()+ " CODIGO DIARIA - COPIA: "+AtendimentoLocacao.copiasLocacao.get(i).getObjeto().getDiaria().getCodigo_diaria());
                            if (dias.get(j).getCodigo_diaria() == AtendimentoLocacao.copiasLocacao.get(i).getObjeto().getDiaria().getCodigo_diaria()) {

                                if ((dias.get(j).getQuantidade_filme() * AtendimentoLocacao.copiasLocacao.get(i).getObjeto().getDiaria().getDias()) < AtendimentoLocacao.copiasLocacao.get(i).getObjeto().getDiaria().getMaximo_dias()) {
                                    dias.get(j).setQuantidade_filme(dias.get(j).getQuantidade_filme() + 1);
                                    dias.get(j).setDias_previsto(dias.get(j).getDias_previsto() + 1);
                                    System.out.println("Quantidade de filme: " + dias.get(j).getQuantidade_filme() + " Dias Previsto: " + dias.get(j).getDias_previsto());
                                } else {
                                    dias.get(j).setQuantidade_filme(dias.get(j).getQuantidade_filme() + 1);
                                    System.out.println("Quantidade de filme: " + dias.get(j).getQuantidade_filme() + " Dias Previsto: " + dias.get(j).getDias_previsto());
                                }

                            }
                        } 
                    }
                }
            }

            for (int i = 0; i < AtendimentoLocacao.jtbl_locacao.getRowCount(); i++) {
                ItemLocacao itemLocacao = new ItemLocacao();
                Objeto objeto = new Objeto();
                objeto.setCodigo_objeto(AtendimentoLocacao.copiasLocacao.get(i).getObjeto().getCodigo_objeto());
                objeto.setDescricao_objeto(AtendimentoLocacao.copiasLocacao.get(i).getObjeto().getDescricao_objeto());

                Diaria diaria = new Diaria();
                diaria.setValor(AtendimentoLocacao.copiasLocacao.get(i).getObjeto().getDiaria().getValor());

                objeto.setDiaria(diaria);

                Copia copia = new Copia();
                copia.setObjeto(objeto);
                copia.setCodigo_copia(AtendimentoLocacao.copiasLocacao.get(i).getCodigo_copia());
                copia.setStatus("1");

                itemLocacao.setValor_locado(AtendimentoLocacao.copiasLocacao.get(i).getObjeto().getDiaria().getValor());
                if (valor_pago > 0) {
                    if (valor_pago < itemLocacao.getValor_locado()) {
                        itemLocacao.setValor_pago(valor_pago);
                    } else {
                        itemLocacao.setValor_pago(itemLocacao.getValor_locado());
                        valor_pago = valor_pago - itemLocacao.getValor_locado();
                    }
                } else {
                    itemLocacao.setValor_pago(0.00);
                }
                itemLocacao.setLocacao(locacao);
                itemLocacao.setCopia(copia);

                //Inserir a lógica da promoção de objetos e para cada um sera gravada  a data prevista de devolucao no banco e somar
                //conforme quantidade e regra de negócio
                Date data = new Date();
                for (int d = 0; d < dias.size(); d++) {
                    if (dias.get(d).getCodigo_diaria() == AtendimentoLocacao.copiasLocacao.get(i).getObjeto().getDiaria().getCodigo_diaria()) {
                        data.setDate(data.getDate() + dias.get(d).getDias_previsto());
                        System.out.println("Data prevista: " + data);
                    }
                }

                itemLocacao.setData_prevista(data);
                itens.add(itemLocacao);

                copiaDAO.alterarStatusFilme(copia);
            }
            EntradaCaixa.itens = itens;

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
