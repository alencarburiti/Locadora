/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.locadora.view;

import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.bean.Genero;

/**
 *
 * @author ALENCAR
 */
public interface CadastroObjeto_InterFace {
    public void carregaDiaria(Diaria diaria);
    public void carregaGenero(Genero genero);
    public void setStatusTela(boolean status);
    public void setRequestDiaria();
    public void setRequestGenero();
}
