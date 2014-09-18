package br.com.locadora.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.Cliente;
import java.sql.Date;

public class ClienteDAO implements InterfaceClienteDAO {

	private InterfacePool pool;

	public ClienteDAO(InterfacePool pool) {
		this.pool = pool;
	}

	@Override
	public void atualizar(Cliente cliente) throws SQLException {
		Connection con = pool.getConnection();
		PreparedStatement ps = null;
		String sqlAtualizar = " UPDATE cliente SET bairro=?, celular=?, cep=?, "
				+ " cidade=?, cpf_cnpj=?, email=?, endereco=?, estado=?,"
				+ " telefone=?, nome=? WHERE codigo = ? ;";

		try {
			ps = con.prepareStatement(sqlAtualizar);

			setPreparedStatement(cliente, ps);

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
		String sqlExcluir = "DELETE FROM cliente WHERE codigo = ?;";

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
	public Cliente getCliente_nome(String nome_cliente) throws SQLException {
		Connection con = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlSelect = "SELECT * FROM CLIENTE WHERE NOME_CLIENTE LIKE ?";

		try {
			ps = con.prepareStatement(sqlSelect);
			ps.setString(1, "%" + nome_cliente + "%");

			rs = ps.executeQuery();

			List<Cliente> resultado = getListaCliente(rs);

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
	public Cliente getCliente_cpf(String cpf) throws SQLException {
		Connection con = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlSelect = "SELECT * FROM CLIENTE WHERE CPF ?";

		try {
			ps = con.prepareStatement(sqlSelect);
			ps.setString(1, cpf);

			rs = ps.executeQuery();

			List<Cliente> resultado = getListaCliente(rs);

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
	public Cliente getCliente_codigo(Integer codigo_cliente) throws SQLException {
		Connection con = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlSelect = "SELECT * FROM CLIENTE WHERE CODIGO_CLIENTE = ?;";

		try {
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo_cliente);

			rs = ps.executeQuery();

			List<Cliente> resultado = getListaCliente(rs);
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
	public List<Cliente> getClientes() throws SQLException {
		List<Cliente> resultado = new ArrayList<Cliente>();
		Connection con = pool.getConnection();
		PreparedStatement ps = null;
		String sqlSelect = "SELECT * FROM CLIENTE ORDER BY NOME_CLIENTE;";
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(sqlSelect);
			rs = ps.executeQuery();

			resultado = getListaCliente(rs);

			rs.close();
			ps.close();
		} finally {
			pool.liberarConnection(con);
		}
		return resultado;
	}
        
        public List<Cliente> getClientes_nome(String nome_cliente) throws SQLException {
		List<Cliente> resultado = new ArrayList<Cliente>();
		Connection con = pool.getConnection();
		PreparedStatement ps = null;
		String sqlSelect = "SELECT * FROM CLIENTE WHERE NOME_CLIENTE LIKE ? ORDER BY NOME_CLIENTE;";
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(sqlSelect);
                        ps.setString(1, nome_cliente);
                        
			rs = ps.executeQuery();

			resultado = getListaCliente(rs);

			rs.close();
			ps.close();
		} finally {
			pool.liberarConnection(con);
		}
		return resultado;
	}

	private List<Cliente> getListaCliente(ResultSet rs) throws SQLException {
		List<Cliente> resultado = new ArrayList<Cliente>();
		while (rs.next()) {
			Cliente cliente = new Cliente();
			cliente.setCodigo_cliente(rs.getInt("CODIGO_CLIENTE"));
                        cliente.setNome_cliente(rs.getString("NOME_CLIENTE"));                        
                        cliente.setNome_empresa_trabalho(rs.getString("NOME_EMPRESA_TRABALHO"));
                        cliente.setProfissao(rs.getString("PROFISSAO"));
                        cliente.setNome_empresa_trabalho(rs.getString("NOME_EMPRESA_TRABALHO"));
                        cliente.setCpf(rs.getString("CPF"));
                        cliente.setData_nascimento(rs.getDate("DATA_NASCIMENTO"));
                        cliente.setEndereco(rs.getString("ENDERECO"));
                        cliente.setBairro(rs.getString("BAIRRO"));			 
                        cliente.setComplemento(rs.getString("COMPLEMENTO"));
                        cliente.setCidade(rs.getString("CIDADE"));
			cliente.setEstado(rs.getString("ESTADO"));
			cliente.setEmail(rs.getString("EMAIL"));                        
			cliente.setStatus(rs.getString("STATUS"));
			cliente.setObservacao(rs.getString("OBSERVACAO"));			
			resultado.add(cliente);
		}
		return resultado;
	}
        
	@Override
	public Cliente salvar(Cliente cliente) throws SQLException {
		Connection con = pool.getConnection();
		PreparedStatement ps;

		String sqlInsert = "INSERT INTO `locadora`.`CLIENTE`(`NOME_CLIENTE`,`NOME_EMPRESA_TRABALHO`,"
                        + "`PROFISSAO`,`CPF`,`DATA_NASCIMENTO`,`ENDERECO`,`BAIRRO`,`COMPLEMENTO`,"
                        + "`CIDADE`,`ESTADO`,`EMAIL`,`LOGIN`,`SENHA`,`OBSERVACAO`,`STATUS`) VALUES" +
                            "( ? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? );";

		try {
			ps = con.prepareStatement(sqlInsert);

			setPreparedStatement1(cliente, ps);

			ps.executeUpdate();
                        ResultSet res;
                        Integer codigo_max;
                        String sql_max = "SELECT MAX(CODIGO_CLIENTE) FROM CLIENTE";
                        
                        ps = con.prepareStatement(sql_max);
                        res = ps.executeQuery();
                        res.next();
                        codigo_max = res.getInt("MAX(CODIGO_CLIENTE)");
                        cliente.setCodigo_cliente(codigo_max);
            
			ps.close();
		} finally {
			pool.liberarConnection(con);
		}
                return cliente;
	}

	private void setPreparedStatement(Cliente cliente, PreparedStatement ps)
			throws SQLException {
            
            Date data_nascimento = null;
            if (cliente.getData_nascimento() != null) {
                data_nascimento = new Date(cliente.getData_nascimento().getTime());
            }
            
		ps.setString(1, cliente.getNome_cliente());
		ps.setString(2, cliente.getNome_empresa_trabalho());
		ps.setString(3, cliente.getProfissao());
		ps.setString(4, cliente.getCpf());
                ps.setDate(5, data_nascimento);
		ps.setString(7, cliente.getEndereco());
		ps.setString(9, cliente.getBairro());
                ps.setString(8, cliente.getComplemento());
		ps.setString(10, cliente.getCidade());
		ps.setString(12, cliente.getEstado());
		ps.setString(11, cliente.getEmail());
                ps.setString(13, cliente.getLogin());
		ps.setString(14, cliente.getSenha());
		ps.setString(15, cliente.getObservacao());
		ps.setString(16, cliente.getStatus());
	}
        
	
        private void setPreparedStatement1(Cliente cliente, PreparedStatement ps)
			throws SQLException {
            Date data_nascimento = null;
            if (cliente.getData_nascimento() != null) {
                data_nascimento = new Date(cliente.getData_nascimento().getTime());
            }
            
		ps.setString(1, cliente.getNome_cliente());
		ps.setString(2, cliente.getNome_empresa_trabalho());
		ps.setString(3, cliente.getProfissao());
		ps.setString(4, cliente.getCpf());
                ps.setDate(5, data_nascimento);
		ps.setString(6, cliente.getEndereco());
		ps.setString(7, cliente.getBairro());
                ps.setString(8, cliente.getComplemento());
		ps.setString(9, cliente.getCidade());
		ps.setString(10, cliente.getEstado());
		ps.setString(11, cliente.getEmail());
                ps.setString(12, cliente.getLogin());
		ps.setString(13, cliente.getSenha());
		ps.setString(14, cliente.getObservacao());
		ps.setString(15, cliente.getStatus());
	}

}