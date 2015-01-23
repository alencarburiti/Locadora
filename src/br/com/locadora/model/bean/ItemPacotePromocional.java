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
public class ItemPacotePromocional {

    private Integer codigo_item_pacote_promocional;
    private PacotePromocional pacotePromocional;
    private Boolean Status;
    private Diaria diaria;

    public Integer getCodigo_item_pacote_promocional() {
        return codigo_item_pacote_promocional;
    }

    public void setCodigo_item_pacote_promocional(Integer codigo_item_pacote_promocional) {
        this.codigo_item_pacote_promocional = codigo_item_pacote_promocional;
    }

    public PacotePromocional getPacotePromocional() {
        return pacotePromocional;
    }

    public void setPacotePromocional(PacotePromocional pacotePromocional) {
        this.pacotePromocional = pacotePromocional;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean Status) {
        this.Status = Status;
    }

    public Diaria getDiaria() {
        return diaria;
    }

    public void setDiaria(Diaria diaria) {
        this.diaria = diaria;
    }

}
