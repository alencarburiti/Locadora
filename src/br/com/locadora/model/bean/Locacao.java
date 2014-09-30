/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model.bean;

import java.util.List;

/**
 *
 * @author alencarburiti
 */
public class Locacao {

    private Integer codigo_locacao;
    private Cliente cliente;
    private Dependente dependente;
    private List<ItemLocacao> itemLocacao;

    public Integer getCodigo_locacao() {
        return codigo_locacao;
    }

    public void setCodigo_locacao(Integer codigo_locacao) {
        this.codigo_locacao = codigo_locacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemLocacao> getItemLocacao() {
        return itemLocacao;
    }

    public void setItemLocacao(List<ItemLocacao> itemLocacao) {
        this.itemLocacao = itemLocacao;
    }

    public Dependente getDependente() {
        return dependente;
    }

    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }

}
