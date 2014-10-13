package br.com.locadora.model.dao;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Dependente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
    public boolean excluir(Integer codigo) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlExcluir = "DELETE FROM LOCADORA.DEPENDENTE WHERE CODIGO_DEPENDENTE = ?;";

        try {
            ps = con.prepareStatement(sqlExcluir);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Este registro não pode ser excluído pois está referenciado em outra tabela");
            return false;
        }finally {
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

    public List<Dependente> getClienteDependente(String nome_cliente_dependente) throws SQLException {
        List<Dependente> resultado = new ArrayList<Dependente>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n" +
            "    B.CLIENTE_CODIGO_CLIENTE,\n" +
            "    B.NOME_DEPENDENTE,\n" +
            "    B.DATA_NASCIMENTO,\n" +
            "    B.TIPO_DEPENDENTE,\n" +
            "    (CASE\n" +
            "        WHEN (TIPO_DEPENDENTE = 0) THEN 'Cliente'\n" +
            "        ELSE 'Dependente'\n" +
            "    end) AS TIPO,\n" +
            "    B.DEL_FLAG,\n" +
            "    B.CODIGO_DEPENDENTE,\n" +
            "    (SELECT \n" +
            "            (CASE\n" +
            "                    WHEN SUM(VALOR_PAGO - VALOR_LOCADO) IS NULL THEN 0\n" +
            "                    ELSE SUM(VALOR_PAGO - VALOR_LOCADO)\n" +
            "                END) AS DEVEDOR\n" +
            "        FROM\n" +
            "            LOCADORA.LOCACAO LC,\n" +
            "            LOCADORA.ITEM_LOCACAO IL,\n" +
            "            LOCADORA.DEPENDENTE DP\n" +
            "        WHERE\n" +
            "            LC.CODIGO_LOCACAO = IL.LOCACAO_CODIGO_LOCACAO\n" +
            "                AND LC.DEPENDENTE_CODIGO_DEPENDENTE = DP.CODIGO_DEPENDENTE\n" +
            "                AND DP.CODIGO_DEPENDENTE IN (SELECT \n" +
            "                    CODIGO_DEPENDENTE\n" +
            "                FROM\n" +
            "                    LOCADORA.DEPENDENTE\n" +
            "                WHERE\n" +
            "                    CLIENTE_CODIGO_CLIENTE IN (SELECT \n" +
            "                            B.CLIENTE_CODIGO_CLIENTE\n" +
            "                        FROM\n" +
            "                            LOCADORA.CLIENTE A,\n" +
            "                            LOCADORA.DEPENDENTE B\n" +
            "                        WHERE\n" +
            "                            A.CODIGO_CLIENTE = B.CLIENTE_CODIGO_CLIENTE\n" +
            "                                AND B.NOME_DEPENDENTE LIKE ?))) AS DEVEDOR\n" +
            "FROM\n" +
            "    LOCADORA.CLIENTE A,\n" +
            "    LOCADORA.DEPENDENTE B\n" +
            "WHERE\n" +
            "    A.CODIGO_CLIENTE = B.CLIENTE_CODIGO_CLIENTE\n" +
            "        AND B.NOME_DEPENDENTE LIKE ?;\n" +
            ";";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%" + nome_cliente_dependente + "%");
            ps.setString(2, "%" + nome_cliente_dependente + "%");

            rs = ps.executeQuery();

            resultado = getListaClienteDependente(rs);

            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    public String getClienteDependente(Integer codigo_cliente) {
        List<Dependente> resultado = new ArrayList<Dependente>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String devedor = null;
        String sqlSelect = "SELECT \n" +
            "    (CASE\n" +
            "        WHEN SUM(VALOR_PAGO - VALOR_LOCADO) IS NULL THEN 0\n" +
            "        ELSE SUM(VALOR_PAGO - VALOR_LOCADO)\n" +
            "    END) AS DEVEDOR\n" +
            "FROM\n" +
            "    LOCADORA.LOCACAO LC,\n" +
            "    LOCADORA.ITEM_LOCACAO IL,\n" +
            "    LOCADORA.DEPENDENTE DP\n" +
            "WHERE\n" +
            "    LC.CODIGO_LOCACAO = IL.LOCACAO_CODIGO_LOCACAO\n" +
            "        AND LC.DEPENDENTE_CODIGO_DEPENDENTE = DP.CODIGO_DEPENDENTE\n" +
            "        AND DP.CODIGO_DEPENDENTE IN (SELECT \n" +
            "            CODIGO_DEPENDENTE\n" +
            "        FROM\n" +
            "            LOCADORA.DEPENDENTE\n" +
            "        WHERE\n" +
            "            CLIENTE_CODIGO_CLIENTE = ?);";            

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo_cliente);

            rs = ps.executeQuery();
            rs.next();
            
            devedor = rs.getString("DEVEDOR");
            
            resultado = getListaClienteDependente(rs);

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DependenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return devedor;
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

    public List<Dependente> getDependentes(Integer codigo_cliente) throws SQLException {
        List<Dependente> resultado = new ArrayList<Dependente>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM locadora.DEPENDENTE WHERE CLIENTE_CODIGO_CLIENTE = ? AND TIPO_DEPENDENTE = 1 ORDER BY NOME_DEPENDENTE;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo_cliente);
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
            dependente.setCodigo_dependente(rs.getInt("CODIGO_DEPENDENTE"));
            dependente.setNome_dependente(rs.getString("NOME_DEPENDENTE"));
            dependente.setTipo_dependente(rs.getString("TIPO_DEPENDENTE"));
            dependente.setData_nascimento(rs.getDate("DATA_NASCIMENTO"));
            dependente.setParentesco(rs.getString("PARENTESCO"));
            dependente.setTelefone(rs.getString("TELEFONE"));

            Cliente cliente = new Cliente();
            cliente.setCodigo_cliente(rs.getInt("CLIENTE_CODIGO_CLIENTE"));

            dependente.setCliente(cliente);

            resultado.add(dependente);
        }
        return resultado;
    }

    private List<Dependente> getListaClienteDependente(ResultSet rs) throws SQLException {
        List<Dependente> resultado = new ArrayList<Dependente>();
        while (rs.next()) {
            Dependente dependente = new Dependente();
            dependente.setCodigo_dependente(rs.getInt("CODIGO_DEPENDENTE"));
            dependente.setNome_dependente(rs.getString("NOME_DEPENDENTE"));
            dependente.setData_nascimento(rs.getDate("DATA_NASCIMENTO"));
            if (rs.getInt("TIPO_DEPENDENTE") == 0) {
                dependente.setTipo_dependente("Cliente");

            } else {
                dependente.setTipo_dependente("Dependente");
            }
            dependente.setDebito(rs.getString("DEVEDOR"));

            Cliente cliente = new Cliente();
            cliente.setCodigo_cliente(rs.getInt("CLIENTE_CODIGO_CLIENTE"));
            if (rs.getInt("DEL_FLAG") == 0) {
                cliente.setStatus("Ativo");

            } else {
                cliente.setStatus("Inativo");
            }

            dependente.setCliente(cliente);

            resultado.add(dependente);
        }
        return resultado;
    }

    @Override
    public void salvar(List<Dependente> dependentes, Cliente cliente) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO LOCADORA.DEPENDENTE (NOME_DEPENDENTE, CLIENTE_CODIGO_CLIENTE, TIPO_DEPENDENTE, "
                + "DATA_NASCIMENTO, CPF, TELEFONE, PARENTESCO) VALUES"
                + "( ? ,?, ?, ?, ?, ?, ? );";

        try {
            ps = con.prepareStatement(sqlInsert);
            Date data_nascimento = null;
            for (int i = 0; i < dependentes.size(); i++) {
                if (dependentes.get(i).getData_nascimento() != null) {
                    data_nascimento = new Date(dependentes.get(i).getData_nascimento().getTime());
                }
                ps.setString(1, dependentes.get(i).getNome_dependente());
                ps.setInt(2, cliente.getCodigo_cliente());
                ps.setInt(3, Integer.parseInt(dependentes.get(i).getTipo_dependente()));
                ps.setDate(4, data_nascimento);
                ps.setString(5, dependentes.get(i).getCPF());
                ps.setString(6, dependentes.get(i).getTelefone());
                ps.setString(7, dependentes.get(i).getParentesco());
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
