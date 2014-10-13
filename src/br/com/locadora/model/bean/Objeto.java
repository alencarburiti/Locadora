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
public class Objeto {

    private Integer codigo_objeto;
    private String descricao_objeto;
    private String tipo_movimento;
    private String titulo_original;
    private String producao;
    private String duracao;
    private String descricao_resumida;
    private String midia;
    private Integer censura;
    private String tipo_midia;
    private Diaria diaria;
    private Genero genero;
    private Integer saldo;
    private Integer disponivel;
    private String elenco;
    private String sinopse;

    public Integer getCodigo_objeto() {
        return codigo_objeto;
    }

    public void setCodigo_objeto(Integer codigo_objeto) {
        this.codigo_objeto = codigo_objeto;
    }

    public String getDescricao_objeto() {
        return descricao_objeto;
    }

    public void setDescricao_objeto(String descricao_objeto) {
        this.descricao_objeto = descricao_objeto;
    }

    public String getTipo_movimento() {
        return tipo_movimento;
    }

    public void setTipo_movimento(String tipo_movimento) {
        this.tipo_movimento = tipo_movimento;
    }

    public String getTitulo_original() {
        return titulo_original;
    }

    public void setTitulo_original(String titulo_original) {
        this.titulo_original = titulo_original;
    }

    public String getProducao() {
        return producao;
    }

    public void setProducao(String producao) {
        this.producao = producao;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getDescricao_resumida() {
        return descricao_resumida;
    }

    public void setDescricao_resumida(String descricao_resumida) {
        this.descricao_resumida = descricao_resumida;
    }

    public String getMidia() {
        return midia;
    }

    public void setMidia(String midia) {
        this.midia = midia;
    }

    public String getTipo_midia() {
        return tipo_midia;
    }

    public void setTipo_midia(String tipo_midia) {
        this.tipo_midia = tipo_midia;
    }

    public Diaria getDiaria() {
        return diaria;
    }

    public void setDiaria(Diaria diaria) {
        this.diaria = diaria;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public Integer getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Integer disponivel) {
        this.disponivel = disponivel;
    }

    public String getElenco() {
        return elenco;
    }

    public void setElenco(String elenco) {
        this.elenco = elenco;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public Integer getCensura() {
        return censura;
    }

    public void setCensura(Integer censura) {
        this.censura = censura;
    }

}
