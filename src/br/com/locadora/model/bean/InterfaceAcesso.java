/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model.bean;

/**
 *
 * @author alencarburiti
 */
public class InterfaceAcesso {

    private String descricao;
    private Integer codigo_interface;
    private String tipo;

    public InterfaceAcesso(String string, int aInt, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCodigo_interface() {
        return codigo_interface;
    }

    public void setCodigo_interface(Integer codigo_interface) {
        this.codigo_interface = codigo_interface;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
