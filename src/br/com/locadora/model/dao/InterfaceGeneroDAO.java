package br.com.locadora.model.dao;

import br.com.locadora.model.bean.Genero;
import java.sql.SQLException;
import java.util.List;

public interface InterfaceGeneroDAO {

	public abstract void excluir(Integer codigo) throws SQLException;
	public abstract void salvar(Genero genero) throws SQLException;
	public abstract void atualizar(Genero genero) throws SQLException;
	public abstract Genero getGenero(Integer codigo) throws SQLException;
	public abstract List<Genero> getGeneros(String nome_genero) throws SQLException;
	public abstract List<Genero> getGeneros() throws SQLException;
}

