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
public class Dependente {
    private Integer codigo_dependente;
    private Cliente cliente;
    private String nome_dependente;

    /**
     * @return the codigo_dependente
     */
    public Integer getCodigo_dependente() {
        return codigo_dependente;
    }

    /**
     * @param codigo_dependente the codigo_dependente to set
     */
    public void setCodigo_dependente(Integer codigo_dependente) {
        this.codigo_dependente = codigo_dependente;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the nome_dependente
     */
    public String getNome_dependente() {
        return nome_dependente;
    }

    /**
     * @param nome_dependente the nome_dependente to set
     */
    public void setNome_dependente(String nome_dependente) {
        this.nome_dependente = nome_dependente;
    }
    
    
    
}
