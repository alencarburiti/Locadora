package br.com.locadora.model.dao;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Telefone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelefoneDAO implements InterfaceTelefoneDAO {

	private InterfacePool pool;

	public TelefoneDAO(InterfacePool pool) {
		this.pool = pool;
	}

	@Override
	public void atualizar(Telefone telefone) throws SQLException {
		Connection con = pool.getConnection();
		PreparedStatement ps = null;
		String sqlAtualizar = " UPDATE telefone SET bairro=?, celular=?, cep=?, "
				+ " cidade=?, cpf_cnpj=?, email=?, endereco=?, estado=?,"
				+ " telefone=?, nome=? WHERE codigo = ? ;";

		try {
			ps = con.prepareStatement(sqlAtualizar);

			setPreparedStatement(telefone, ps);

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
		String sqlExcluir = "DELETE FROM telefone WHERE codigo = ?;";

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
	public Telefone getTelefone(String nome) throws SQLException {
		Connection con = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlSelect = "SELECT * FROM telefone WHERE nome like ?";

		try {
			ps = con.prepareStatement(sqlSelect);
			ps.setString(1, "%" + nome + "%");

			rs = ps.executeQuery();

			List<Telefone> resultado = getListaTelefone(rs);

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
	public Telefone getTelefone(Integer codigo) throws SQLException {
		Connection con = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlSelect = "SELECT * FROM telefone WHERE codigo = ?;";

		try {
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);

			rs = ps.executeQuery();

			List<Telefone> resultado = getListaTelefone(rs);
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
	public List<Telefone> getTelefones() throws SQLException {
		List<Telefone> resultado = new ArrayList<Telefone>();
		Connection con = pool.getConnection();
		PreparedStatement ps = null;
		String sqlSelect = "SELECT * FROM CLIENTE ORDER BY NOME; ";
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(sqlSelect);
			rs = ps.executeQuery();

			resultado = getListaTelefone(rs);

			rs.close();
			ps.close();
		} finally {
			pool.liberarConnection(con);
		}
		return resultado;
	}

	private List<Telefone> getListaTelefone(ResultSet rs) throws SQLException {
		List<Telefone> resultado = new ArrayList<Telefone>();
		while (rs.next()) {
			Telefone telefone = new Telefone();
//			telefone.setBairro(rs.getString("bairro"));
			// telefone.setCelular(rs.getString("celular"));
			// telefone.setCep(rs.getString("cep"));
			// telefone.setCidade(rs.getString("cidade"));
			// telefone.setCodigo(rs.getInt("codigo"));
			// telefone.setRegistro(rs.getString("cpf_cnpj"));
			// telefone.setEmail(rs.getString("email"));
			// telefone.setEndereco(rs.getString("endereco"));
			// telefone.setEstado(rs.getString("estado"));
			// telefone.setTelefone(rs.getString("telefone"));
//			telefone.setNome(rs.getString("nome"));
			resultado.add(telefone);
		}
		return resultado;
	}
        
	@Override
	public void salvar(List<Telefone> telefones, Cliente cliente) throws SQLException {
		Connection con = pool.getConnection();
		PreparedStatement ps;

		String sqlInsert = "INSERT INTO LOCADORA.TELEFONE (TELEFONE, CODIGO_CLIENTE) VALUES" +
                            "( ? ,? );";

		try {
			ps = con.prepareStatement(sqlInsert);

                for (int i = 0; i < telefones.size(); i++) {			
                        ps.setString(1, telefones.get(i).getTelefone());
                        ps.setInt(2, cliente.getCodigo_cliente());
			ps.executeUpdate();
                    
                }                
                       
			ps.close();
		} finally {
			pool.liberarConnection(con);
		}
                
	}

	private void setPreparedStatement(Telefone telefone, PreparedStatement ps)
			throws SQLException {
//		ps.setString(1, telefone.getNome_telefone());
//		ps.setString(2, telefone.getNome_empresa_trabalho());
//		ps.setString(3, telefone.getProfissao());
//		ps.setString(4, telefone.getCpf());
//                ps.setString(5, telefone.getData_nascimento());
//		ps.setString(7, telefone.getEndereco());
//		ps.setString(9, telefone.getBairro());
//                ps.setString(8, telefone.getComplemento());
//		ps.setString(10, telefone.getCidade());
//		ps.setString(12, telefone.getEstado());
//		ps.setString(11, telefone.getEmail());
//                ps.setString(13, telefone.getLogin());
//		ps.setString(14, telefone.getSenha());
//		ps.setString(15, telefone.getObservacao());
//		ps.setString(16, telefone.getStatus());
	}
        
	
}
