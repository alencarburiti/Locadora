package br.com.locadora.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.ItemLocacao;
import br.com.locadora.model.bean.Locacao;
import java.sql.Date;

public class LocacaoDAO implements InterfaceLocacaoDAO {

    private InterfacePool pool;

    public LocacaoDAO(InterfacePool pool) {
        this.pool = pool;
    }

    @Override
    public void atualizar(Locacao locacao) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlAtualizar = " UPDATE locacao SET bairro=?, celular=?, cep=?, "
                + " cidade=?, cpf_cnpj=?, email=?, endereco=?, estado=?,"
                + " telefone=?, nome=? WHERE codigo = ? ;";

        try {
            ps = con.prepareStatement(sqlAtualizar);

            setPreparedStatement(locacao, ps);

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
        String sqlExcluir = "DELETE FROM locacao WHERE codigo = ?;";

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
    public Locacao getLocacao_nome(String nome_locacao) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM CLIENTE WHERE NOME_CLIENTE LIKE ?";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%" + nome_locacao + "%");

            rs = ps.executeQuery();

            List<Locacao> resultado = getListaLocacao(rs);

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
    public Locacao getLocacao_cpf(String cpf) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM CLIENTE WHERE CPF ?";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, cpf);

            rs = ps.executeQuery();

            List<Locacao> resultado = getListaLocacao(rs);

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
    public Locacao getLocacao_codigo(Integer codigo_locacao) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM CLIENTE WHERE CODIGO_CLIENTE = ?;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo_locacao);

            rs = ps.executeQuery();

            List<Locacao> resultado = getListaLocacao(rs);
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
    public List<Locacao> getLocacaos() throws SQLException {
        List<Locacao> resultado = new ArrayList<Locacao>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM CLIENTE ORDER BY NOME_CLIENTE;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();

            resultado = getListaLocacao(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    public List<Locacao> getLocacaos_nome(String nome_locacao) throws SQLException {
        List<Locacao> resultado = new ArrayList<Locacao>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM CLIENTE WHERE NOME_CLIENTE LIKE ? ORDER BY NOME_CLIENTE;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, nome_locacao);

            rs = ps.executeQuery();

            resultado = getListaLocacao(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    private List<Locacao> getListaLocacao(ResultSet rs) throws SQLException {
        List<Locacao> resultado = new ArrayList<Locacao>();
        while (rs.next()) {
            Locacao locacao = new Locacao();
            locacao.setCodigo_locacao(rs.getInt("CODIGO_CLIENTE"));
//                        locacao.setNome_locacao(rs.getString("NOME_CLIENTE"));                        
//                        locacao.setNome_empresa_trabalho(rs.getString("NOME_EMPRESA_TRABALHO"));
//                        locacao.setProfissao(rs.getString("PROFISSAO"));
//                        locacao.setNome_empresa_trabalho(rs.getString("NOME_EMPRESA_TRABALHO"));
//                        locacao.setCpf(rs.getString("CPF"));
//                        locacao.setData_nascimento(rs.getDate("DATA_NASCIMENTO"));
//                        locacao.setEndereco(rs.getString("ENDERECO"));
//                        locacao.setBairro(rs.getString("BAIRRO"));			 
//                        locacao.setComplemento(rs.getString("COMPLEMENTO"));
//                        locacao.setCidade(rs.getString("CIDADE"));
//			locacao.setEstado(rs.getString("ESTADO"));
//			locacao.setEmail(rs.getString("EMAIL"));                        
//			locacao.setStatus(rs.getString("STATUS"));
//			locacao.setObservacao(rs.getString("OBSERVACAO"));			
            resultado.add(locacao);
        }
        return resultado;
    }

    @Override
    public Locacao salvar(Locacao locacao) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO `locadora`.`LOCACAO`(`CODIGO_CLIENTE`)VALUES( ? );";

        try {
            ps = con.prepareStatement(sqlInsert);

            setPreparedStatement1(locacao, ps);

            ps.executeUpdate();
            ResultSet res;
            Integer codigo_max;
            String sql_max = "SELECT MAX(CODIGO_LOCACAO) FROM LOCACAO";

            ps = con.prepareStatement(sql_max);
            res = ps.executeQuery();
            res.next();
            codigo_max = res.getInt("MAX(CODIGO_LOCACAO)");
            locacao.setCodigo_locacao(codigo_max);

            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return locacao;
    }

    public void salvarItem(List<ItemLocacao> itemLocacao) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO `locadora`.`ITEM_LOCACAO`(`CODIGO_COPIA`, `CODIGO_LOCACAO`)VALUES( ?, ? );";

        try {
            ps = con.prepareStatement(sqlInsert);

            for (int i = 0; i < itemLocacao.size(); i++) {
                ps.setInt(1, itemLocacao.get(i).getCopia().getCodigo_copia());
                ps.setInt(2, itemLocacao.get(i).getLocacao().getCodigo_locacao());
                ps.executeUpdate();

            }

            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        //return locacao;
    }

    private void setPreparedStatement(Locacao locacao, PreparedStatement ps)
            throws SQLException {

//            Date data_nascimento = null;
//            if (locacao.getData_nascimento() != null) {
//                data_nascimento = new Date(locacao.getData_nascimento().getTime());
//            }
//            
//		ps.setString(1, locacao.getNome_locacao());
//		ps.setString(2, locacao.getNome_empresa_trabalho());
//		ps.setString(3, locacao.getProfissao());
//		ps.setString(4, locacao.getCpf());
//                ps.setDate(5, data_nascimento);
//		ps.setString(7, locacao.getEndereco());
//		ps.setString(9, locacao.getBairro());
//                ps.setString(8, locacao.getComplemento());
//		ps.setString(10, locacao.getCidade());
//		ps.setString(12, locacao.getEstado());
//		ps.setString(11, locacao.getEmail());
//                ps.setString(13, locacao.getLogin());
//		ps.setString(14, locacao.getSenha());
//		ps.setString(15, locacao.getObservacao());
//		ps.setString(16, locacao.getStatus());
    }

    private void setPreparedStatement1(Locacao locacao, PreparedStatement ps)
            throws SQLException {

        ps.setInt(1, locacao.getCliente().getCodigo_cliente());

    }

}
