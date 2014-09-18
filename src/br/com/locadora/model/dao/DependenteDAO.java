package br.com.locadora.model.dao;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Dependente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DependenteDAO implements InterfaceDependenteDAO {

	private InterfacePool pool;

	public DependenteDAO(InterfacePool pool) {
		this.pool = pool;
	}

	@Override
	public void atualizar(Dependente dependente) throws SQLException {
		Connection con = pool.getConnection();
		PreparedStatement ps = null;
		String sqlAtualizar = " UPDATE dependente SET bairro=?, celular=?, cep=?, "
				+ " cidade=?, cpf_cnpj=?, email=?, endereco=?, estado=?,"
				+ " dependente=?, nome=? WHERE codigo = ? ;";

		try {
			ps = con.prepareStatement(sqlAtualizar);

			setPreparedStatement(dependente, ps);

			ps.executeUpdate();
			ps.close();
		} finally {
			pool.liberarConnection(con);
		}
	}

	@Override
	public void excluir(Integer codigo) throws SQLException {
		Connection con = pool.getConnection();
		PreparedStatement ps = null;
		String sqlExcluir = "DELETE FROM dependente WHERE codigo = ?;";

		try {
			ps = con.prepareStatement(sqlExcluir);
			ps.setInt(1, codigo);
			ps.executeUpdate();
			ps.close();
		} finally {
			pool.liberarConnection(con);
		}
	}
	@Override
	public Dependente getDependente(String nome) throws SQLException {
		Connection con = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlSelect = "SELECT * FROM dependente WHERE nome like ?";

		try {
			ps = con.prepareStatement(sqlSelect);
			ps.setString(1, "%" + nome + "%");

			rs = ps.executeQuery();

			List<Dependente> resultado = getListaDependente(rs);

			if (resultado.size() > 0) {
				return resultado.get(0);
			}
			ps.close();
		} finally {
			pool.liberarConnection(con);
		}
		return null;
	}

	@Override
	public Dependente getDependente(Integer codigo) throws SQLException {
		Connection con = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlSelect = "SELECT * FROM dependente WHERE codigo = ?;";

		try {
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);

			rs = ps.executeQuery();

			List<Dependente> resultado = getListaDependente(rs);
			if (resultado.size() > 0) {
				return resultado.get(0);
			}
			ps.close();
		} finally {
			pool.liberarConnection(con);
		}
		return null;
	}

	@Override
	public List<Dependente> getDependentes() throws SQLException {
		List<Dependente> resultado = new ArrayList<Dependente>();
		Connection con = pool.getConnection();
		PreparedStatement ps = null;
		String sqlSelect = "SELECT * FROM CLIENTE ORDER BY NOME; ";
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(sqlSelect);
			rs = ps.executeQuery();

			resultado = getListaDependente(rs);

			rs.close();
			ps.close();
		} finally {
			pool.liberarConnection(con);
		}
		return resultado;
	}

	private List<Dependente> getListaDependente(ResultSet rs) throws SQLException {
		List<Dependente> resultado = new ArrayList<Dependente>();
		while (rs.next()) {
			Dependente dependente = new Dependente();
//			dependente.setBairro(rs.getString("bairro"));
			// dependente.setCelular(rs.getString("celular"));
			// dependente.setCep(rs.getString("cep"));
			// dependente.setCidade(rs.getString("cidade"));
			// dependente.setCodigo(rs.getInt("codigo"));
			// dependente.setRegistro(rs.getString("cpf_cnpj"));
			// dependente.setEmail(rs.getString("email"));
			// dependente.setEndereco(rs.getString("endereco"));
			// dependente.setEstado(rs.getString("estado"));
			// dependente.setDependente(rs.getString("dependente"));
//			dependente.setNome(rs.getString("nome"));
			resultado.add(dependente);
		}
		return resultado;
	}
        
	@Override
	public void salvar(List<Dependente> dependentes, Cliente cliente) throws SQLException {
		Connection con = pool.getConnection();
		PreparedStatement ps;

		String sqlInsert = "INSERT INTO LOCADORA.DEPENDENTE (NOME_DEPENDENTE, CODIGO_CLIENTE) VALUES" +
                            "( ? ,? );";

		try {
			ps = con.prepareStatement(sqlInsert);

                for (int i = 0; i < dependentes.size(); i++) {			
                        ps.setString(1, dependentes.get(i).getNome_dependente());                        
                        ps.setInt(2, cliente.getCodigo_cliente());
			ps.executeUpdate();
                    
                }                
                       
			ps.close();
		} finally {
			pool.liberarConnection(con);
		}
                
	}

	private void setPreparedStatement(Dependente dependente, PreparedStatement ps)
			throws SQLException {
//		ps.setString(1, dependente.getNome_dependente());
//		ps.setString(2, dependente.getNome_empresa_trabalho());
//		ps.setString(3, dependente.getProfissao());
//		ps.setString(4, dependente.getCpf());
//                ps.setString(5, dependente.getData_nascimento());
//		ps.setString(7, dependente.getEndereco());
//		ps.setString(9, dependente.getBairro());
//                ps.setString(8, dependente.getComplemento());
//		ps.setString(10, dependente.getCidade());
//		ps.setString(12, dependente.getEstado());
//		ps.setString(11, dependente.getEmail());
//                ps.setString(13, dependente.getLogin());
//		ps.setString(14, dependente.getSenha());
//		ps.setString(15, dependente.getObservacao());
//		ps.setString(16, dependente.getStatus());
	}
        
	
}
