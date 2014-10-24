package br.com.locadora.model.dao;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.bean.Lancamento;
import br.com.locadora.model.bean.Objeto;
import br.com.locadora.model.bean.TipoServico;
import br.com.locadora.model.bean.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LancamentoDAO implements InterfaceLancamentoDAO {

    private InterfacePool pool;

    public LancamentoDAO(InterfacePool pool) {
        this.pool = pool;
    }

    @Override
    public void atualizar(Lancamento lancamento) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlAtualizar = " UPDATE lancamento SET bairro=?, celular=?, cep=?, "
                + " cidade=?, cpf_cnpj=?, email=?, endereco=?, estado=?,"
                + " telefone=?, nome=? WHERE codigo = ? ;";

        try {
            ps = con.prepareStatement(sqlAtualizar);

            setPreparedStatement(lancamento, ps);

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
        String sqlExcluir = "DELETE FROM lancamento WHERE codigo = ?;";

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
    public Lancamento getLancamento_nome(String nome_lancamento) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM CLIENTE WHERE NOME_CLIENTE LIKE ?";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%" + nome_lancamento + "%");

            rs = ps.executeQuery();

            List<Lancamento> resultado = getListaLancamento(rs);

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
    public List<Lancamento> getLancamentos(Cliente cliente) throws SQLException {
        List<Lancamento> resultado = new ArrayList<Lancamento>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT \n" +
            "    A.CODIGO_LANCAMENTO,\n" +
            "    DATA_LANCAMENTO,\n" +
            "    C.CODIGO_TIPO_SERVICO,\n" +
            "    C.descricao,\n" +
            "    C.tipo,\n" +
            "    A.VALOR,\n" +
            "    D.LOGIN\n" +
            "FROM\n" +
            "    locadora.lancamento A,\n" +
            "    LOCADORA.DEPENDENTE B,\n" +
            "    LOCADORA.tipo_servico C,\n" +
            "    LOCADORA.USUARIO D\n" +
            "WHERE\n" +
            "    A.dependente_CODIGO_DEPENDENTE = B.CODIGO_DEPENDENTE\n" +
            "        AND A.tipo_servico_codigo_tipo_servico = C.codigo_tipo_servico\n" +
            "        AND A.usuario_CODIGO_USUARIO = D.CODIGO_USUARIO\n" +
            "        AND B.CODIGO_DEPENDENTE IN (SELECT \n" +
            "            CODIGO_DEPENDENTE\n" +
            "        FROM\n" +
            "            LOCADORA.DEPENDENTE\n" +
            "        WHERE\n" +
            "            CLIENTE_CODIGO_CLIENTE = ?)\n" +
            "ORDER BY A.CODIGO_LANCAMENTO DESC;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, cliente.getCodigo_cliente());
            rs = ps.executeQuery();

            resultado = getListaLancamento(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }


    private List<Lancamento> getListaLancamento(ResultSet rs) throws SQLException {
        List<Lancamento> resultado = new ArrayList<Lancamento>();
        while (rs.next()) {
            Lancamento lancamento = new Lancamento();
            lancamento.setData_lancamento(rs.getDate("DATA_LANCAMENTO"));
            
            TipoServico tipo_servico = new TipoServico();
            tipo_servico.setCodigo_tipo_servico(rs.getInt("CODIGO_TIPO_SERVICO"));
            tipo_servico.setDescricao(rs.getString("DESCRICAO"));
            tipo_servico.setTipo(rs.getString("TIPO"));
            lancamento.setTipoServico(tipo_servico);
            
            lancamento.setValor(rs.getDouble("VALOR"));
            
            Usuario usuario = new Usuario();
            usuario.setLogin(rs.getString("LOGIN"));
            lancamento.setUsuario(usuario);
            resultado.add(lancamento);
        }
        return resultado;
    }

    @Override
    public Lancamento salvar(Lancamento lancamento) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO `locadora`.`LOCACAO`(`DEPENDENTE_CODIGO_DEPENDENTE`,USUARIO_CODIGO_USUARIO)VALUES( ?,? );";
        
        String sqlLancamento = "INSERT INTO `locadora`.`lancamento`(`valor`,`dependente_CODIGO_DEPENDENTE`,\n" +
            "`tipo_servico_codigo_tipo_servico`,`usuario_CODIGO_USUARIO`,`lancamento_CODIGO_LOCACAO`)\n" +
            "VALUES(?,?,?,?,?);";

        try {
            ps = con.prepareStatement(sqlInsert);

            setPreparedStatement1(lancamento, ps);

            ps.executeUpdate();
            ResultSet res;
            Integer codigo_max;
            String sql_max = "SELECT MAX(CODIGO_LOCACAO) FROM LOCACAO";

            ps = con.prepareStatement(sql_max);
            res = ps.executeQuery();
            res.next();
            codigo_max = res.getInt("MAX(CODIGO_LOCACAO)");
            lancamento.setCodigo_lancamento(codigo_max);
            
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return lancamento;
    }
    
    
    public void salvarLancamento(Lancamento lancamento) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlLancamento = "INSERT INTO `locadora`.`lancamento`(`valor`,`dependente_CODIGO_DEPENDENTE`,\n" +
            "`tipo_servico_codigo_tipo_servico`,`usuario_CODIGO_USUARIO`,`lancamento_CODIGO_LOCACAO`,data_lancamento)\n" +
            "VALUES(?,?,?,?,?,CURRENT_DATE());";

        try {
            
            ps = con.prepareStatement(sqlLancamento);

            setPreparedStatementLancamento(lancamento, ps);

            ps.executeUpdate();

            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        
    }



    private void setPreparedStatement1(Lancamento lancamento, PreparedStatement ps)
            throws SQLException {

        ps.setInt(1, lancamento.getDependente().getCodigo_dependente());
        ps.setInt(2, lancamento.getUsuario().getCod_usuario());

    }
    
    private void setPreparedStatement(Lancamento lancamento, PreparedStatement ps)
            throws SQLException {

        ps.setInt(1, lancamento.getDependente().getCodigo_dependente());
        ps.setInt(2, lancamento.getUsuario().getCod_usuario());

    }
    
    private void setPreparedStatementLancamento(Lancamento lancamento, PreparedStatement ps)
            throws SQLException {

        ps.setDouble(1, lancamento.getValor());
        ps.setInt(2, lancamento.getDependente().getCodigo_dependente());
        ps.setInt(3, lancamento.getTipoServico().getCodigo_tipo_servico());
        ps.setInt(4, lancamento.getUsuario().getCod_usuario());
        ps.setInt(5, lancamento.getCodigo_lancamento());

    }


}
