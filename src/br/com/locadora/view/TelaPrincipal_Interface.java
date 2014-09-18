
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.locadora.view;

import br.com.locadora.model.bean.Usuario;

/**
 *
 * @author ALENCAR
 */
public interface TelaPrincipal_Interface {
    public void setStatusTela(boolean status);
    public void setDesabilitaTela();
    public void carregaUsuario(Usuario usuario);

}
