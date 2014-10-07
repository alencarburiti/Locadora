/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.locadora.view;

import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.ItemLocacao;

/**
 *
 * @author ALENCAR
 */
public interface AtendimentoDevolucao_InterFace {
    public void carregarClienteDependente(Dependente dependente);    
    public void carregarCopiaDevolucao(ItemLocacao itemLocacao);
    public void setStatusTela(boolean status);    
}
