/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model.bean;

import java.util.List;

/**
 *
 * @author Alencar
 */
public class Diaria {

    private Integer codigo_diaria;
    private String nome_diaria;
    private Double valor;
    private Double valor_promocao;
    private Integer dias = 0;
    private Double multas;
    private Integer maximo_dias;
    private Integer dias_previsto = 0;
    private Boolean acumulativo;
    private Integer quantidade_filme = 0;
    private List<Promocao> listPromocao;
    private Promocao promocao;

    /**
     * @return the codigo_diaria
     */
    public Integer getCodigo_diaria() {
        return codigo_diaria;
    }

    /**
     * @param codigo_diaria the codigo_diaria to set
     */
    public void setCodigo_diaria(Integer codigo_diaria) {
        this.codigo_diaria = codigo_diaria;
    }

    /**
     * @return the nome_diaria
     */
    public String getNome_diaria() {
        return nome_diaria;
    }

    /**
     * @param nome_diaria the nome_diaria to set
     */
    public void setNome_diaria(String nome_diaria) {
        this.nome_diaria = nome_diaria;
    }

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @return the valor_promocao
     */
    public Double getValor_promocao() {
        return valor_promocao;
    }

    /**
     * @param valor_promocao the valor_promocao to set
     */
    public void setValor_promocao(Double valor_promocao) {
        this.valor_promocao = valor_promocao;
    }

    /**
     * @return the dias
     */
    public Integer getDias() {
        return dias;
    }

    /**
     * @param dias the dias to set
     */
    public void setDias(Integer dias) {
        this.dias = dias;
    }

    /**
     * @return the multas
     */
    public Double getMultas() {
        return multas;
    }

    /**
     * @param multas the multas to set
     */
    public void setMultas(Double multas) {
        this.multas = multas;
    }

    public Integer getMaximo_dias() {
        return maximo_dias;
    }

    public void setMaximo_dias(Integer maximo_dias) {
        this.maximo_dias = maximo_dias;
    }

    public Boolean getAcumulativo() {
        return acumulativo;
    }

    public void setAcumulativo(Boolean acumulativo) {
        this.acumulativo = acumulativo;
    }

    public Integer getQuantidade_filme() {
        return quantidade_filme;
    }

    public void setQuantidade_filme(Integer quantidade_filme) {
        this.quantidade_filme = quantidade_filme;
    }

    public Integer getDias_previsto() {
        return dias_previsto;
    }

    public void setDias_previsto(Integer dias_previsto) {
        this.dias_previsto = dias_previsto;
    }

    public List<Promocao> getListPromocao() {
        return listPromocao;
    }

    public void setListPromocao(List<Promocao> listPromocao) {
        this.listPromocao = listPromocao;
    }

    public Promocao getPromocao() {
        return promocao;
    }

    public void setPromocao(Promocao promocao) {
        this.promocao = promocao;
    }

}
