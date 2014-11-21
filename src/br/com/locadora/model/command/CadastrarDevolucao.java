package br.com.locadora.model.command;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.ItemLocacao;
import br.com.locadora.model.bean.Lancamento;
import br.com.locadora.model.bean.Locacao;
import br.com.locadora.model.bean.TipoServico;
import br.com.locadora.model.bean.Usuario;
import br.com.locadora.model.dao.DevolucaoDAO;
import br.com.locadora.model.dao.InterfaceClienteDAO;
import br.com.locadora.model.dao.InterfaceCopiaDAO;
import br.com.locadora.model.dao.InterfaceLocacaoDAO;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.Moeda;
import br.com.locadora.view.AtendimentoDevolucao;
import br.com.locadora.view.AtendimentoLocacao;
import br.com.locadora.view.EntradaCaixaDevolucao;
import java.sql.SQLException;
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
            InterfacePool pool = new Pool();
            DevolucaoDAO devolucaoDAO = new DevolucaoDAO(pool);
            Dependente dependente = new Dependente();            
            
            dependente.setCodigo_dependente(AtendimentoDevolucao.dependente.getCodigo_dependente());
            
            Locacao locacao = new Locacao();  
            
            locacao.setDependente(dependente);
            
            Usuario usuario = new Usuario();
            usuario.setCodigo_usuario(EntradaCaixaDevolucao.acesso.getUsuario().getCodigo_usuario());
            
            locacao.setUsuario(usuario);
            
            Double valor_pago;
            Double valor_desconto;
            Double multa;
            Double troco;
            Moeda moeda = new Moeda();
            
            valor_pago = moeda.getPrecoFormato(EntradaCaixaDevolucao.jtf_valor_pago.getText());
            valor_desconto = moeda.getPrecoFormato(EntradaCaixaDevolucao.jtf_desconto.getText()); 
            multa = moeda.getPrecoFormato(EntradaCaixaDevolucao.jtf_debito_devolucao.getText());
            
            troco = moeda.getPrecoFormato(EntradaCaixaDevolucao.jtf_troco.getText());
            
            valor_pago = valor_pago - troco;
            
            ArquivoConfiguracao conf = new ArquivoConfiguracao();
            Lancamento lancamento = new Lancamento();
            lancamento.setCaixa(Integer.parseInt(conf.readPropertie("caixa")));
            lancamento.setUsuario(usuario);
            lancamento.setDependente(dependente);
            TipoServico tipoServico = new TipoServico();
            
            lancamento.setLocacao(locacao);
            
            if(valor_pago > 0 ){
                tipoServico.setCodigo_tipo_servico(7);
                lancamento.setValor(valor_pago);
            
                lancamento.setTipoServico(tipoServico);
                devolucaoDAO.salvarLancamento(lancamento);            
            }                        
            
            if(valor_desconto > 0 ){
                tipoServico.setCodigo_tipo_servico(8);
                lancamento.setValor(valor_desconto);
                
                lancamento.setTipoServico(tipoServico);
                devolucaoDAO.salvarLancamento(lancamento);
            }
            
            if(multa > 0 ){
                tipoServico.setCodigo_tipo_servico(2);
                lancamento.setValor(multa);
                
                lancamento.setTipoServico(tipoServico);
                devolucaoDAO.salvarLancamento(lancamento);
            }
            
            List<ItemLocacao> itens = new ArrayList();
            ItemLocacao itemDevolve;
            Copia copia;
            for (int i = 0; i < AtendimentoDevolucao.jtbl_devolucao.getRowCount(); i++) {

                itemDevolve = new ItemLocacao();
                copia = new Copia();
                copia.setCodigo_copia(AtendimentoDevolucao.itensDevolucao.get(i).getCopia().getCodigo_copia());
                copia.setStatus("0");
                itemDevolve.setCopia(copia);
                itemDevolve.setCodigo_item_locacao(AtendimentoDevolucao.itensDevolucao.get(i).getCodigo_item_locacao());                
                
                Date data = new Date();          
                data.setDate(data.getDate());                         
                
                
                AtendimentoDevolucao.itensDevolucao.get(i).setData_devolucao(data);                        
                
                itens.add(itemDevolve);

                copiaDAO.alterarStatusFilme(itemDevolve.getCopia());
                locacaoDAO.salvarDevolucao(itens);

            }
                EntradaCaixaDevolucao.itens = AtendimentoDevolucao.itensDevolucao;
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido: " + e.getMessage());

            e.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarDevolucao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return "OK";
    }

}
