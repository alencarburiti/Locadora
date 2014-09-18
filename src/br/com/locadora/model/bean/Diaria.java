/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model.bean;

/**
 *
 * @author Alencar
 */
public class Diaria {

    private Integer codigo_diaria;
    private String nome_diaria;
    private Double valor;
    private Double valor_promocao;
    private Integer dias;
    private Double multas;

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
    
}
