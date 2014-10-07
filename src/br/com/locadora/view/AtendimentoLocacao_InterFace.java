/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.locadora.view;

import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.ItemLocacao;

/**
 *
 * @author ALENCAR
 */
public interface AtendimentoLocacao_InterFace {
    public void carregarClienteDependente(Dependente dependente);
    public void carregarCopiaLocacao(Copia copia);
    public void setStatusTela(boolean status);    
}
