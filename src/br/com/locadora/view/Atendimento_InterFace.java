/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.locadora.view;

import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Copia;

/**
 *
 * @author ALENCAR
 */
public interface Atendimento_InterFace {
    public void carregaCliente(Cliente cliente);
    public void carregaCopia(Copia copia);
    public void setStatusTela(boolean status);
    public void setRequestDiaria();
    public void setRequestGenero();
}
