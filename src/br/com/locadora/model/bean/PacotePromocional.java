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
public class PacotePromocional {

    private Integer codigo_pacote_promocioanl;
    private String descricao;
    private Integer quantidade_vez;
    private Integer quantidade_mes;
    private Double valor;
    private Diaria diaria;
    private Boolean status;

    public Integer getCodigo_pacote_promocioanl() {
        return codigo_pacote_promocioanl;
    }

    public void setCodigo_pacote_promocioanl(Integer codigo_pacote_promocioanl) {
        this.codigo_pacote_promocioanl = codigo_pacote_promocioanl;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade_vez() {
        return quantidade_vez;
    }

    public void setQuantidade_vez(Integer quantidade_vez) {
        this.quantidade_vez = quantidade_vez;
    }

    public Integer getQuantidade_mes() {
        return quantidade_mes;
    }

    public void setQuantidade_mes(Integer quantidade_mes) {
        this.quantidade_mes = quantidade_mes;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Diaria getDiarias() {
        return diaria;
    }

    public void setDiarias(Diaria diaria) {
        this.diaria = diaria;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
