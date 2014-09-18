/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.locadora.model.bean;

import java.util.Date;
import java.util.List;

/**
 *
 * @author alencarburiti
 */
public class Cliente {
    private Integer codigo_cliente;
    private String nome_cliente;
    private String nome_empresa_trabalho;
    private String profissao;
    private String cpf;
    private Date data_nascimento;
    private Date data_cadastro;
    private String endereco;
    private String bairro;
    private String complemento;
    private String cidade;
    private String estado;
    private Telefone telefone;
    private String email;
    private Dependente dependente;
    private String login;
    private String senha;
    private String observacao;
    private String status;

    
    public Cliente() {
        
    }
    
    public Cliente(Integer codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }
    
    /**
     * @return the codigo_cliente
     */
    public Integer getCodigo_cliente() {
        return codigo_cliente;
    }

    /**
     * @param codigo_cliente the codigo_cliente to set
     */
    public void setCodigo_cliente(Integer codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    /**
     * @return the nome_cliente
     */
    public String getNome_cliente() {
        return nome_cliente;
    }

    /**
     * @param nome_cliente the nome_cliente to set
     */
    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    /**
     * @return the nome_empresa_trabalho
     */
    public String getNome_empresa_trabalho() {
        return nome_empresa_trabalho;
    }

    /**
     * @param nome_empresa_trabalho the nome_empresa_trabalho to set
     */
    public void setNome_empresa_trabalho(String nome_empresa_trabalho) {
        this.nome_empresa_trabalho = nome_empresa_trabalho;
    }

    /**
     * @return the profissao
     */
    public String getProfissao() {
        return profissao;
    }

    /**
     * @param profissao the profissao to set
     */
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the data_nascimento
     */
    public Date getData_nascimento() {
        return data_nascimento;
    }

    /**
     * @param data_nascimento the data_nascimento to set
     */
    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    /**
     * @return the data_cadastro
     */
    public Date getData_cadastro() {
        return data_cadastro;
    }

    /**
     * @param data_cadastro the data_cadastro to set
     */
    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the telefone
     */
    public Telefone getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the dependente
     */
    public Dependente getDependente() {
        return dependente;
    }

    /**
     * @param dependente the dependente to set
     */
    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    
    
    
}
