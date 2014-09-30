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
    private String tipo_dependente;
    private String debito;

    public Integer getCodigo_dependente() {
        return codigo_dependente;
    }

    public void setCodigo_dependente(Integer codigo_dependente) {
        this.codigo_dependente = codigo_dependente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNome_dependente() {
        return nome_dependente;
    }

    public void setNome_dependente(String nome_dependente) {
        this.nome_dependente = nome_dependente;
    }

    public String getTipo_dependente() {
        return tipo_dependente;
    }

    public void setTipo_dependente(String tipo_dependente) {
        this.tipo_dependente = tipo_dependente;
    }

    public String getDebito() {
        return debito;
    }

    public void setDebito(String debito) {
        this.debito = debito;
    }

}
