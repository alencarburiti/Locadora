package br.com.locadora.model.dao;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.bean.ItemLocacao;
import br.com.locadora.model.bean.Lancamento;
import br.com.locadora.model.bean.Locacao;
import br.com.locadora.model.bean.Objeto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public List<ItemLocacao> getLocacao_codigo(Integer codigo_dependente) throws SQLException {

        List<ItemLocacao> resultado = new ArrayList<ItemLocacao>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n" +
            "    C.CODIGO_LOCACAO,\n" +
            "    D.CODIGO_ITEM_LOCACAO,\n" +
            "    D.VALOR_LOCADO,\n" +
            "    D.VALOR_PAGO,\n" +
            "    A.DESCRICAO_OBJETO AS DESCRICAO_OBJETO,\n" +
            "    F.DIAS AS DIARIA,\n" +
            "    B.CODIGO_BARRAS,\n" +
            "    B.CODIGO_COPIA,\n" +
            "    F.MULTAS AS VALOR_MULTA_DIA,\n" +
            "    D.DATA_LOCACAO AS DATA_LOCACAO,\n" +
            "    ADDDATE(D.DATA_LOCACAO, F.DIAS) AS DATA_DEVOLUCAO,\n" +
            "    CURRENT_DATE AS DATA_ATUAL,\n" +
            "    (case\n" +
            "        when\n" +
            "            ((CURRENT_DATE - D.DATA_LOCACAO) - F.DIAS) IS NULL\n" +
            "                OR ((CURRENT_DATE - D.DATA_LOCACAO) - F.DIAS) < 0\n" +
            "        then\n" +
            "            0\n" +
            "        else ((CURRENT_DATE - D.DATA_LOCACAO) - F.DIAS)\n" +
            "    end) AS DIAS_MULTA,\n" +
            "    CASE\n" +
            "        WHEN\n" +
            "            ((((CURRENT_DATE - D.DATA_LOCACAO) - F.DIAS)) * F.MULTAS) IS NULL\n" +
            "                OR (((CURRENT_DATE - D.DATA_LOCACAO) - F.DIAS)) < 0\n" +
            "        THEN\n" +
            "            0\n" +
            "        ELSE ((((CURRENT_DATE - D.DATA_LOCACAO) - F.DIAS)) * F.MULTAS)\n" +
            "    END AS VALOR_MULTA\n" +
            "FROM\n" +
            "    OBJETO A,\n" +
            "    COPIA B,\n" +
            "    LOCACAO C,\n" +
            "    ITEM_LOCACAO D,\n" +
            "    DEPENDENTE E,\n" +
            "    DIARIA F\n" +
            "WHERE\n" +
            "    A.CODIGO_OBJETO = B.OBJETO_CODIGO_OBJETO\n" +
            "        AND C.DEPENDENTE_CODIGO_DEPENDENTE = E.CODIGO_DEPENDENTE\n" +
            "        AND C.CODIGO_LOCACAO = D.LOCACAO_CODIGO_LOCACAO\n" +
            "        AND D.COPIA_CODIGO_COPIA = B.CODIGO_COPIA\n" +
            "        AND A.DIARIA_CODIGO_DIARIA = F.CODIGO_DIARIA\n" +
            "        AND D.DEL_FLAG = 0\n" +
            "        AND A.TIPO_MOVIMENTO = 'LOCACAO'\n" +
            "        AND E.CODIGO_DEPENDENTE IN (SELECT \n" +
            "            CODIGO_DEPENDENTE\n" +
            "        FROM\n" +
            "            DEPENDENTE\n" +
            "        WHERE\n" +
            "            CLIENTE_CODIGO_CLIENTE IN (SELECT \n" +
            "                    CODIGO_CLIENTE\n" +
            "                FROM\n" +
            "                    CLIENTE CL,\n" +
            "                    DEPENDENTE DP\n" +
            "                WHERE\n" +
            "                    CL.CODIGO_CLIENTE = DP.CLIENTE_CODIGO_CLIENTE\n" +
            "                        AND DP.CODIGO_DEPENDENTE = ?));";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo_dependente);

            rs = ps.executeQuery();

            resultado = getListaLocacoes(rs);

            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    public ItemLocacao getLocacaoAberta(String codigo_barras) throws SQLException {

        List<ItemLocacao> resultado = new ArrayList<ItemLocacao>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n"
                + "    E.NOME_DEPENDENTE,\n"
                + "    E.CODIGO_DEPENDENTE,\n"
                + "    E.CLIENTE_CODIGO_CLIENTE,\n"
                + "    C.CODIGO_LOCACAO,\n"
                + "    D.CODIGO_ITEM_LOCACAO,\n"
                + "    D.VALOR_LOCADO,\n"
                + "    D.VALOR_PAGO,\n"
                + "    D.DATA_PREVISTA,\n"
                + "    A.DESCRICAO_OBJETO,\n"
                + "    A.CODIGO_OBJETO,\n"
                + "    F.DIAS AS DIARIA,\n"
                + "    B.CODIGO_BARRAS,\n"
                + "    B.CODIGO_COPIA,\n"
                + "    F.MULTAS AS VALOR_MULTA_DIA,\n"
                + "    D.DATA_LOCACAO AS DATA_LOCACAO,\n"
                + "    CURRENT_DATE AS DATA_ATUAL,\n"
                + "    (case\n"
                + "        when ((CURRENT_DATE - D.DATA_LOCACAO) - F.DIAS) IS NULL OR ((CURRENT_DATE - D.DATA_LOCACAO) - F.DIAS)<0 then 0\n"
                + "        else ((CURRENT_DATE - D.DATA_LOCACAO) - F.DIAS)\n"
                + "    end) AS DIAS_MULTA,\n"
                + "    CASE\n"
                + "        WHEN ((((CURRENT_DATE - D.DATA_LOCACAO) - F.DIAS)) * F.MULTAS) IS NULL OR ((((CURRENT_DATE - D.DATA_LOCACAO) - F.DIAS)) * F.MULTAS) < 0 THEN 0\n"
                + "        ELSE ((((CURRENT_DATE - D.DATA_LOCACAO) - F.DIAS)) * F.MULTAS)\n"
                + "    END AS VALOR_MULTA\n"
                + "FROM\n"
                + "    OBJETO A,\n"
                + "    COPIA B,\n"
                + "    LOCACAO C,\n"
                + "    ITEM_LOCACAO D,\n"
                + "    DEPENDENTE E,\n"
                + "    DIARIA F\n"
                + "WHERE\n"
                + "    A.CODIGO_OBJETO = B.OBJETO_CODIGO_OBJETO\n"
                + "        AND C.DEPENDENTE_CODIGO_DEPENDENTE = E.CODIGO_DEPENDENTE\n"
                + "        AND C.CODIGO_LOCACAO = D.LOCACAO_CODIGO_LOCACAO\n"
                + "        AND D.COPIA_CODIGO_COPIA = B.CODIGO_COPIA\n"
                + "        AND A.DIARIA_CODIGO_DIARIA = F.CODIGO_DIARIA\n"
                + "        AND D.DEL_FLAG = 0\n"
                + "        AND B.DEL_FLAG = 1\n"
                + "        AND A.TIPO_MOVIMENTO = 'LOCACAO'\n"
                + "        AND B.CODIGO_BARRAS = ?;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, codigo_barras);

            rs = ps.executeQuery();

            resultado = getListaLocacaoAberta(rs);

            if (resultado.size() > 0) {
                return resultado.get(0);
            }

            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return null;
    }

    //Consulta no banco de dados a locação aberta passando como parametro o código do dependente e o código de Barras
    public ItemLocacao getLocacaoAberta(Integer codigo_dependente, String codigo_barras) throws SQLException {

        List<ItemLocacao> resultado = new ArrayList<ItemLocacao>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n"
                + "    C.CODIGO_LOCACAO,\n"
                + "    D.VALOR_LOCADO,\n"
                + "    D.VALOR_PAGO,\n"
                + "    D.DATA_PREVISTA,\n"
                + "    D.CODIGO_ITEM_LOCACAO,\n"
                + "    A.DESCRICAO_OBJETO,\n"
                + "    A.CODIGO_OBJETO,\n"
                + "    F.DIAS AS DIARIA,\n"
                + "    B.CODIGO_BARRAS,\n"
                + "    B.CODIGO_COPIA,\n"
                + "    F.MULTAS AS VALOR_MULTA_DIA,\n"
                + "    D.DATA_LOCACAO AS DATA_LOCACAO,\n"
                + "    ADDDATE(D.DATA_LOCACAO, F.DIAS) AS DATA_DEVOLUCAO,\n"
                + "    CURRENT_DATE AS DATA_ATUAL,\n"
                + "    (case\n"
                + "        when ((CURRENT_DATE - D.DATA_LOCACAO) - F.DIAS) IS NULL OR ((CURRENT_DATE - D.DATA_LOCACAO) - F.DIAS) < 0 then 0\n"
                + "        else ((CURRENT_DATE - D.DATA_LOCACAO) - F.DIAS)\n"
                + "    end) AS DIAS_MULTA,\n"
                + "    CASE\n"
                + "        WHEN ((((CURRENT_DATE - D.DATA_LOCACAO) - F.DIAS)) * F.MULTAS) IS NULL  OR ((((CURRENT_DATE - D.DATA_LOCACAO) - F.DIAS)) * F.MULTAS)<0  THEN 0\n"
                + "        ELSE ((((CURRENT_DATE - D.DATA_LOCACAO) - F.DIAS)) * F.MULTAS)\n"
                + "    END AS VALOR_MULTA\n"
                + "FROM\n"
                + "    OBJETO A,\n"
                + "    COPIA B,\n"
                + "    LOCACAO C,\n"
                + "    ITEM_LOCACAO D,\n"
                + "    DEPENDENTE E,\n"
                + "    DIARIA F\n"
                + "WHERE\n"
                + "    A.CODIGO_OBJETO = B.OBJETO_CODIGO_OBJETO\n"
                + "        AND C.DEPENDENTE_CODIGO_DEPENDENTE = E.CODIGO_DEPENDENTE\n"
                + "        AND C.CODIGO_LOCACAO = D.LOCACAO_CODIGO_LOCACAO\n"
                + "        AND D.COPIA_CODIGO_COPIA = B.CODIGO_COPIA\n"
                + "        AND A.DIARIA_CODIGO_DIARIA = F.CODIGO_DIARIA\n"
                + "        AND D.DEL_FLAG = 0\n"
                + "        AND B.DEL_FLAG = 1\n"
                + "        AND A.TIPO_MOVIMENTO = 'LOCACAO'\n"
                + "        AND B.CODIGO_BARRAS = ?\n"
                + "        AND E.CODIGO_DEPENDENTE IN (SELECT \n"
                + "            CODIGO_DEPENDENTE\n"
                + "        FROM\n"
                + "            DEPENDENTE\n"
                + "        WHERE\n"
                + "            CLIENTE_CODIGO_CLIENTE IN (SELECT \n"
                + "                    CODIGO_CLIENTE\n"
                + "                FROM\n"
                + "                    CLIENTE CL,\n"
                + "                    DEPENDENTE DP\n"
                + "                WHERE\n"
                + "                    CL.CODIGO_CLIENTE = DP.CLIENTE_CODIGO_CLIENTE\n"
                + "                        AND DP.CODIGO_DEPENDENTE = ?))";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, codigo_barras);
            ps.setInt(2, codigo_dependente);

            rs = ps.executeQuery();

            resultado = getListaLocacoes(rs);

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

    private List<ItemLocacao> getListaLocacoes(ResultSet rs) throws SQLException {
        List<ItemLocacao> resultado = new ArrayList<ItemLocacao>();
        while (rs.next()) {
            ItemLocacao itemLocacao = new ItemLocacao();
            itemLocacao.setCodigo_item_locacao(rs.getInt("CODIGO_ITEM_LOCACAO"));
            itemLocacao.setValor_multa(rs.getDouble("VALOR_MULTA"));
            itemLocacao.setDias_multa(rs.getInt("DIAS_MULTA"));
            itemLocacao.setData_locacao(rs.getDate("DATA_LOCACAO"));
            itemLocacao.setData_devolucao(rs.getDate("DATA_DEVOLUCAO"));
            itemLocacao.setValor_locado(rs.getDouble("VALOR_LOCADO"));
            itemLocacao.setValor_pago(rs.getDouble("VALOR_PAGO"));            
        
            Diaria diaria = new Diaria();
            diaria.setDias(rs.getInt("DIARIA"));

            Objeto objeto = new Objeto();
            objeto.setDiaria(diaria);
            objeto.setDescricao_objeto(rs.getString("DESCRICAO_OBJETO"));

            Copia copia = new Copia();
            copia.setObjeto(objeto);

            Dependente dependente = new Dependente();
            dependente.setCodigo_dependente(Integer.MIN_VALUE);

            copia.setCodigo_barras(rs.getString("CODIGO_BARRAS"));
            copia.setCodigo_copia(rs.getInt("CODIGO_COPIA"));
            itemLocacao.setCopia(copia);

            resultado.add(itemLocacao);
        }
        return resultado;
    }

    private List<Locacao> getListaLocacao(ResultSet rs) throws SQLException {
        List<Locacao> resultado = new ArrayList<Locacao>();
        while (rs.next()) {

        }
        return resultado;
    }

    @Override
    public Locacao salvar(Locacao locacao) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO `locadora`.`LOCACAO`(`DEPENDENTE_CODIGO_DEPENDENTE`,USUARIO_CODIGO_USUARIO)VALUES( ?,? );";
        
        String sqlLancamento = "INSERT INTO `locadora`.`lancamento`(`valor`,`dependente_CODIGO_DEPENDENTE`,\n" +
            "`tipo_servico_codigo_tipo_servico`,`usuario_CODIGO_USUARIO`,`locacao_CODIGO_LOCACAO`)\n" +
            "VALUES(?,?,?,?,?);";

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
    
    
    public void salvarLancamento(Lancamento lancamento) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlLancamento = "INSERT INTO `locadora`.`lancamento`(`valor`,`dependente_CODIGO_DEPENDENTE`,\n" +
            "`tipo_servico_codigo_tipo_servico`,`usuario_CODIGO_USUARIO`,`locacao_CODIGO_LOCACAO`,data_lancamento)\n" +
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

    public void salvarItem(List<ItemLocacao> itemLocacao) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO `locadora`.`ITEM_LOCACAO`(`COPIA_CODIGO_COPIA`, `LOCACAO_CODIGO_LOCACAO`, `DATA_LOCACAO`, `VALOR_LOCADO`,"
                + " `VALOR_PAGO`, DATA_PREVISTA)VALUES( ?, ?, CURRENT_DATE(), ?, ?, ? );";

        try {
            ps = con.prepareStatement(sqlInsert);

            for (int i = 0; i < itemLocacao.size(); i++) {

                Date data_locacao = null;
                if (itemLocacao.get(i).getData_locacao() != null) {
                    data_locacao = new Date(itemLocacao.get(i).getData_locacao().getTime());
                }
                
                Date data_prevista = null;
                if (itemLocacao.get(i).getData_prevista() != null) {
                    data_prevista = new Date(itemLocacao.get(i).getData_prevista().getTime());
                }

                ps.setInt(1, itemLocacao.get(i).getCopia().getCodigo_copia());
                ps.setInt(2, itemLocacao.get(i).getLocacao().getCodigo_locacao());
                ps.setDouble(3, itemLocacao.get(i).getValor_locado());
                ps.setDouble(4, itemLocacao.get(i).getValor_pago());
                ps.setDate(5, data_prevista);
                ps.executeUpdate();

            }

            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        //return locacao;
    }

    public void salvarDevolucao(List<ItemLocacao> itemLocacao) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "UPDATE `locadora`.`ITEM_LOCACAO`\n"
                + "SET\n"
                + "`DATA_DEVOLUCAO` = CURRENT_DATE() ,\n"
                + "`DEL_FLAG` = ?\n"
                + "WHERE `CODIGO_ITEM_LOCACAO` = ?;";

        try {
            ps = con.prepareStatement(sqlInsert);

            for (int i = 0; i < itemLocacao.size(); i++) {
                
                ps.setInt(1, 1);
                ps.setInt(2, itemLocacao.get(i).getCodigo_item_locacao());
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


    }

    private void setPreparedStatement1(Locacao locacao, PreparedStatement ps)
            throws SQLException {

        ps.setInt(1, locacao.getDependente().getCodigo_dependente());
        ps.setInt(2, locacao.getUsuario().getCodigo_usuario());

    }
    
    private void setPreparedStatementLancamento(Lancamento lancamento, PreparedStatement ps)
            throws SQLException {

        ps.setDouble(1, lancamento.getValor());
        ps.setInt(2, lancamento.getDependente().getCodigo_dependente());
        ps.setInt(3, lancamento.getTipoServico().getCodigo_tipo_servico());
        ps.setInt(4, lancamento.getUsuario().getCodigo_usuario());
        ps.setInt(5, lancamento.getLocacao().getCodigo_locacao());

    }

    private List<ItemLocacao> getListaLocacaoAberta(ResultSet rs) throws SQLException {
        List<ItemLocacao> resultado = new ArrayList<ItemLocacao>();
        while (rs.next()) {
            ItemLocacao itemLocacao = new ItemLocacao();
            itemLocacao.setCodigo_item_locacao(rs.getInt("CODIGO_ITEM_LOCACAO"));
            itemLocacao.setValor_multa(rs.getDouble("VALOR_MULTA"));
            itemLocacao.setDias_multa(rs.getInt("DIAS_MULTA"));
            itemLocacao.setData_locacao(rs.getDate("DATA_LOCACAO"));
            itemLocacao.setValor_pago(rs.getDouble("VALOR_PAGO"));
            itemLocacao.setValor_locado(rs.getDouble("VALOR_LOCADO"));
            itemLocacao.setData_prevista(rs.getDate("DATA_PREVISTA"));

            Diaria diaria = new Diaria();
            diaria.setDias(rs.getInt("DIARIA"));

            Objeto objeto = new Objeto();
            objeto.setDiaria(diaria);
            objeto.setDescricao_objeto(rs.getString("DESCRICAO_OBJETO"));
            objeto.setCodigo_objeto(rs.getInt("CODIGO_OBJETO"));

            Copia copia = new Copia();
            copia.setObjeto(objeto);

            Dependente dependente = new Dependente();
            dependente.setCodigo_dependente(rs.getInt("CODIGO_DEPENDENTE"));
            dependente.setNome_dependente(rs.getString("NOME_DEPENDENTE"));

            Cliente cliente = new Cliente();
            cliente.setCodigo_cliente(rs.getInt("CLIENTE_CODIGO_CLIENTE"));

            dependente.setCliente(cliente);

            copia.setCodigo_barras(rs.getString("CODIGO_BARRAS"));
            copia.setCodigo_copia(rs.getInt("CODIGO_COPIA"));
            itemLocacao.setCopia(copia);
            itemLocacao.setDependente(dependente);
            resultado.add(itemLocacao);
        }
        return resultado;
    }

}
