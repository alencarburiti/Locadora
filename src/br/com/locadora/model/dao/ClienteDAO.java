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
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO implements InterfaceClienteDAO {

    private InterfacePool pool;

    public ClienteDAO(InterfacePool pool) {
        this.pool = pool;
    }

    @Override
    public void atualizar(Cliente cliente) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareCall("{CALL SP_UPDATE_CLIENTE_BY_PK(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            
            setPreparedStatement(cliente, ps);

            ps.execute();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
    }

    @Override
    public void excluir(Integer codigo) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlExcluir = "DELETE FROM CLIENTE WHERE CODIGO_CLIENTE = ?;";

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
    public List<Cliente> getCliente_nome(String nome_cliente) throws SQLException {
        List<Cliente> resultado = new ArrayList<Cliente>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM CLIENTE WHERE NOME_CLIENTE LIKE ? ORDER BY NOME_CLIENTE LIMIT 0, 50;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%" + nome_cliente + "%");

            rs = ps.executeQuery();

            resultado = getListaCliente(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    @Override
    public Cliente getCliente_cpf(String cpf) {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM CLIENTE WHERE CPF = ? ORDER BY NOME_CLIENTE LIMIT 0, 50;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, cpf);

            rs = ps.executeQuery();

            List<Cliente> resultado = getListaCliente(rs);

            if (resultado.size() > 0) {
                return resultado.get(0);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return null;
    }
    
    
    public Cliente getCliente_cpf(String cpf, Integer codigo_cliente) {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM CLIENTE WHERE CPF = ? AND CODIGO_CLIENTE = ? ORDER BY NOME_CLIENTE LIMIT 0, 50;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, cpf);
            ps.setInt(2, codigo_cliente);

            rs = ps.executeQuery();

            List<Cliente> resultado = getListaCliente(rs);

            if (resultado.size() > 0) {
                return resultado.get(0);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        String sqlSelect = "SELECT * FROM CLIENTE WHERE CODIGO_CLIENTE = ? LIMIT 0, 50;";

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
        String sqlSelect = "SELECT * FROM CLIENTE ORDER BY NOME_CLIENTE LIMIT 0, 50;";
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

    @Override
    public List<Cliente> getClientes_codigo(Integer codigo_cliente) throws SQLException {
        List<Cliente> resultado = new ArrayList<Cliente>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM CLIENTE ORDER BY NOME_CLIENTE LIMIT 0, 50;";
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
        String sqlSelect = "SELECT * FROM locadora.DEPENDENTE WHERE NOME_DEPENDENTE LIKE ? ORDER BY NOME_DEPENDENTE LIMIT 0, 50;";
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
            cliente.setCpf(rs.getString("CPF"));
            cliente.setData_nascimento(rs.getDate("DATA_NASCIMENTO"));
            cliente.setEndereco(rs.getString("ENDERECO"));
            cliente.setBairro(rs.getString("BAIRRO"));
            cliente.setComplemento(rs.getString("COMPLEMENTO"));
            cliente.setCidade(rs.getString("CIDADE"));
            cliente.setEstado(rs.getString("ESTADO"));
            cliente.setEmail(rs.getString("EMAIL"));
            cliente.setStatus(rs.getString("DEL_FLAG"));
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
                + "`CIDADE`,`ESTADO`,`EMAIL`,`LOGIN`,`SENHA`,`OBSERVACAO`,`DEL_FLAG`) VALUES"
                + "( ? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? );";

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
        ps.setInt(1, cliente.getCodigo_cliente());
        ps.setString(2, cliente.getNome_cliente());
        ps.setString(3, cliente.getNome_empresa_trabalho());
        ps.setString(4, cliente.getProfissao());
        ps.setString(5, cliente.getCpf());
        ps.setDate(6, data_nascimento);
        ps.setString(7, cliente.getEndereco());
        ps.setString(8, cliente.getBairro());
        ps.setString(9, cliente.getComplemento());
        ps.setString(10, cliente.getCidade());
        ps.setString(11, cliente.getEstado());
        ps.setString(12, cliente.getEmail());
        ps.setString(13, cliente.getObservacao());
        ps.setString(14, cliente.getStatus());

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
