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
public class Promocao {

    private Integer codigo_promocao;
    private String descricao_promocao;
    private Double valor_promocao;

    private Boolean pagamento_a_vista;
    private Integer orderm;
    private Diaria diaria;

    private Boolean domingo;
    private Boolean segunda;
    private Boolean terca;
    private Boolean quarta;
    private Boolean quinta;
    private Boolean sexta;
    private Boolean sabado;
    private Integer locar_quantidade;
    private Integer ganhar_quantidade;

    private String hora_antecipada;

    public Integer getCodigo_promocao() {
        return codigo_promocao;
    }

    public void setCodigo_promocao(Integer codigo_promocao) {
        this.codigo_promocao = codigo_promocao;
    }

    public String getDescricao_promocao() {
        return descricao_promocao;
    }

    public void setDescricao_promocao(String descricao_promocao) {
        this.descricao_promocao = descricao_promocao;
    }

    public Double getValor_promocao() {
        return valor_promocao;
    }

    public void setValor_promocao(Double valor_promocao) {
        this.valor_promocao = valor_promocao;
    }

    public Boolean getPagamento_a_vista() {
        return pagamento_a_vista;
    }

    public void setPagamento_a_vista(Boolean pagamento_a_vista) {
        this.pagamento_a_vista = pagamento_a_vista;
    }

    public Integer getOrderm() {
        return orderm;
    }

    public void setOrderm(Integer orderm) {
        this.orderm = orderm;
    }

    public Diaria getDiaria() {
        return diaria;
    }

    public void setDiaria(Diaria diaria) {
        this.diaria = diaria;
    }

    public Boolean getDomingo() {
        return domingo;
    }

    public void setDomingo(Boolean domingo) {
        this.domingo = domingo;
    }

    public Boolean getSegunda() {
        return segunda;
    }

    public void setSegunda(Boolean segunda) {
        this.segunda = segunda;
    }

    public Boolean getTerca() {
        return terca;
    }

    public void setTerca(Boolean terca) {
        this.terca = terca;
    }

    public Boolean getQuarta() {
        return quarta;
    }

    public void setQuarta(Boolean quarta) {
        this.quarta = quarta;
    }

    public Boolean getQuinta() {
        return quinta;
    }

    public void setQuinta(Boolean quinta) {
        this.quinta = quinta;
    }

    public Boolean getSexta() {
        return sexta;
    }

    public void setSexta(Boolean sexta) {
        this.sexta = sexta;
    }

    public Boolean getSabado() {
        return sabado;
    }

    public void setSabado(Boolean sabado) {
        this.sabado = sabado;
    }

    public Integer getLocar_quantidade() {
        return locar_quantidade;
    }

    public void setLocar_quantidade(Integer locar_quantidade) {
        this.locar_quantidade = locar_quantidade;
    }

    public Integer getGanhar_quantidade() {
        return ganhar_quantidade;
    }

    public void setGanhar_quantidade(Integer ganhar_quantidade) {
        this.ganhar_quantidade = ganhar_quantidade;
    }

    public String getHora_antecipada() {
        return hora_antecipada;
    }

    public void setHora_antecipada(String hora_antecipada) {
        this.hora_antecipada = hora_antecipada;
    }

}
