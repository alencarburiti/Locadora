/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.locadora.model.bean;

import java.util.Date;

/**
 *
 * @author alencarburiti
 */
public class ItemLocacao {
    private Integer codigo_item_locacao;
    private Copia copia;    
    private Date data_devolucao;
    private Date data_locacao;    
    private Locacao locacao;
    private Double valor_multa;
    private Integer dias_multa;

    public Integer getCodigo_item_locacao() {
        return codigo_item_locacao;
    }

    public void setCodigo_item_locacao(Integer codigo_item_locacao) {
        this.codigo_item_locacao = codigo_item_locacao;
    }

    public Copia getCopia() {
        return copia;
    }

    public void setCopia(Copia copia) {
        this.copia = copia;
    }

    public Date getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public Date getData_locacao() {
        return data_locacao;
    }

    public void setData_locacao(Date data_locacao) {
        this.data_locacao = data_locacao;
    }

    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }

    public Double getValor_multa() {
        return valor_multa;
    }

    public void setValor_multa(Double valor_multa) {
        this.valor_multa = valor_multa;
    }

    public Integer getDias_multa() {
        return dias_multa;
    }

    public void setDias_multa(Integer dias_multa) {
        this.dias_multa = dias_multa;
    }
    
    
    
    
}
