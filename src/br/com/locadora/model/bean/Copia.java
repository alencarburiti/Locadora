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
public class Copia {
    private Integer codigo_copia;
    private Integer codigo_interno;
    private String localizacao;
    private String idioma;
    private String legenda;
    private Date data_aquisicao;
    private Double preco_custo;
    private Objeto objeto; 
    private String status;
    private String codigo_barras;

    public Integer getCodigo_copia() {
        return codigo_copia;
    }

    public void setCodigo_copia(Integer codigo_copia) {
        this.codigo_copia = codigo_copia;
    }

    public Integer getCodigo_interno() {
        return codigo_interno;
    }

    public void setCodigo_interno(Integer codigo_interno) {
        this.codigo_interno = codigo_interno;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    public Date getData_aquisicao() {
        return data_aquisicao;
    }

    public void setData_aquisicao(Date data_aquisicao) {
        this.data_aquisicao = data_aquisicao;
    }

    public Double getPreco_custo() {
        return preco_custo;
    }

    public void setPreco_custo(Double preco_custo) {
        this.preco_custo = preco_custo;
    }

    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCodigo_barras() {
        return codigo_barras;
    }

    public void setCodigo_barras(String codigo_barras) {
        this.codigo_barras = codigo_barras;
    }

    
    
}
