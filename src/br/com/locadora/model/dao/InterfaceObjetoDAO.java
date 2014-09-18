package br.com.locadora.model.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.locadora.model.bean.Objeto;

public interface InterfaceObjetoDAO {

    public abstract void excluir(Integer codigo) throws SQLException;
    public abstract Objeto salvar(Objeto cliente) throws SQLException;
    public abstract void atualizar(Objeto cliente) throws SQLException;
    public abstract Objeto getObjeto_codigo(Integer codigo_cliente) throws SQLException;
    public abstract Objeto getObjeto_nome(String nome_objeto) throws SQLException;    
    public abstract List<Objeto> getObjetos() throws SQLException;
}
