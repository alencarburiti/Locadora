package br.com.locadora.model.dao;

import br.com.locadora.model.bean.Diaria;
import java.sql.SQLException;
import java.util.List;

public interface InterfaceDiariaDAO {

	public abstract void excluir(Integer codigo) throws SQLException;
	public abstract void salvar(Diaria diaria) throws SQLException;
	public abstract void atualizar(Diaria diaria) throws SQLException;
	public abstract Diaria getDiaria(Integer codigo) throws SQLException;
	public abstract List<Diaria> getDiarias(String nome_diaria) throws SQLException;
	public abstract List<Diaria> getDiarias() throws SQLException;
}

