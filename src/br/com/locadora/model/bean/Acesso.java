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
public class Acesso {

    private Integer codigo_acesso;
    private String action;
    private Integer ler;
    private Integer escrever;
    private Integer deletar;
    private Usuario usuario;

    public Integer getCodigo_acesso() {
        return codigo_acesso;
    }

    public void setCodigo_acesso(Integer codigo_acesso) {
        this.codigo_acesso = codigo_acesso;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getLer() {
        return ler;
    }

    public void setLer(Integer ler) {
        this.ler = ler;
    }

    public Integer getEscrever() {
        return escrever;
    }

    public void setEscrever(Integer escrever) {
        this.escrever = escrever;
    }

    public Integer getDeletar() {
        return deletar;
    }

    public void setDeletar(Integer deletar) {
        this.deletar = deletar;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
