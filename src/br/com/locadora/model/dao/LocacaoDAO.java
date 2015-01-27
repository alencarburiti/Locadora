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
import br.com.locadora.model.bean.PromocaoLocacao;
import br.com.locadora.model.bean.Usuario;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public void salvarRelocacao(List<ItemLocacao> itens) {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlAtualizar = " UPDATE ITEM_LOCACAO SET DIAS_RELOCACAO = ?, VALOR_RELOCACAO = ? WHERE COPIA_CODIGO_COPIA = ? AND DEL_FLAG = 0 ;";

        try {
            ps = con.prepareStatement(sqlAtualizar);
            
            for(int i = 0; i < itens.size(); i++){
                ps.setInt(1, itens.get(i).getDias_multa());
                ps.setDouble(2, itens.get(i).getValor_multa());
                ps.setInt(3, itens.get(i).getCopia().getCodigo_copia());
                ps.executeUpdate();
            }
            

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        String sqlSelect = "SELECT \n"
                + "    C.CODIGO_LOCACAO,\n"
                + "    D.CODIGO_ITEM_LOCACAO,\n"
                + "    D.VALOR_LOCADO,\n"
                + "    D.DATA_PREVISTA,\n"                
                + "    D.VALOR_PAGO,\n"
                + "    D.PROMOCAO_LOCACAO_CODIGO_PROMOCAO_LOCACAO,\n"
                + "    E.CODIGO_DEPENDENTE,\n"
                + "    E.CLIENTE_CODIGO_CLIENTE,\n"
                + "    E.NOME_DEPENDENTE,\n"
                + "    A.TITULO AS TITULO,\n"
                + "    A.CODIGO_OBJETO,\n" 
                + "    F.DIAS AS DIARIA,\n"
                + "    B.CODIGO_BARRAS,\n"
                + "    B.CODIGO_COPIA,\n"
                + "    F.CODIGO_DIARIA,\n"
                + "    F.MULTAS AS VALOR_MULTA_DIA,\n"
                + "    D.DATA_LOCACAO AS DATA_LOCACAO,\n"                
                + "    CURRENT_DATE AS DATA_ATUAL,\n"+
                "    (CASE\n" +
            "        WHEN (CURRENT_DATE - DATE(DATA_LOCACAO)) <= (DATA_PREVISTA - DATE(DATA_LOCACAO)) THEN 0\n" +
            "        ELSE (CURRENT_DATE - DATE(DATA_LOCACAO)) - (DATA_PREVISTA - DATE(DATA_LOCACAO))\n" +
            "    END) AS DIAS_MULTA,\n" +
            "    CASE\n" +
            "        WHEN\n" +
            "            ((CURRENT_DATE - DATE(DATA_LOCACAO)) - (DATA_PREVISTA - DATE(DATA_LOCACAO)) * F.MULTAS) IS NULL\n" +
            "                OR ((CURRENT_DATE - DATE(DATA_LOCACAO)) - (DATA_PREVISTA - DATE(DATA_LOCACAO)) * F.MULTAS < 0)\n" +
            "        THEN\n" +
            "            0\n" +
            "        ELSE (CURRENT_DATE - DATE(DATA_LOCACAO) - (DATA_PREVISTA - DATE(DATA_LOCACAO))) * F.MULTAS\n" +
            "    END AS VALOR_MULTA\n" 
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
                + "        AND B.DIARIA_CODIGO_DIARIA = F.CODIGO_DIARIA\n"
                + "        AND D.DEL_FLAG = 1\n"
                + "        AND A.TIPO_MOVIMENTO = 'LOCACAO'\n"
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
                + "                        AND DP.CODIGO_DEPENDENTE = ?));";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo_dependente);

            rs = ps.executeQuery();

            resultado = getListaLocacoes(rs);

            ps.close();
        } catch (ParseException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                + "    A.TITULO,\n"
                + "    A.CODIGO_OBJETO,\n"
                + "    F.DIAS AS DIARIA,\n"
                + "    F.CODIGO_DIARIA,\n"
                + "    F.MULTAS AS VALOR_MULTA_DIA,\n"
                + "    B.CODIGO_BARRAS,\n"
                + "    B.CODIGO_COPIA,\n"
                + "    D.DATA_LOCACAO AS DATA_LOCACAO,\n"
                + "    D.PROMOCAO_LOCACAO_CODIGO_PROMOCAO_LOCACAO,\n"
                + "    CURRENT_DATE AS DATA_ATUAL,\n"+
                "    (CASE\n" +
            "        WHEN (CURRENT_DATE - DATE(DATA_LOCACAO)) <= (DATA_PREVISTA - DATE(DATA_LOCACAO)) THEN 0\n" +
            "        ELSE (CURRENT_DATE - DATE(DATA_LOCACAO)) - (DATA_PREVISTA - DATE(DATA_LOCACAO))\n" +
            "    END) AS DIAS_MULTA,\n" +
            "    CASE\n" +
            "        WHEN\n" +
            "            ((CURRENT_DATE - DATE(DATA_LOCACAO)) - (DATA_PREVISTA - DATE(DATA_LOCACAO)) * F.MULTAS) IS NULL\n" +
            "                OR ((CURRENT_DATE - DATE(DATA_LOCACAO)) - (DATA_PREVISTA - DATE(DATA_LOCACAO)) * F.MULTAS < 0)\n" +
            "        THEN\n" +
            "            0\n" +
            "        ELSE (CURRENT_DATE - DATE(DATA_LOCACAO) - (DATA_PREVISTA - DATE(DATA_LOCACAO))) * F.MULTAS\n" +
            "    END AS VALOR_MULTA\n" 
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
                + "        AND B.DIARIA_CODIGO_DIARIA = F.CODIGO_DIARIA\n"
                + "        AND D.DEL_FLAG = 1\n"
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
        } catch (ParseException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                + "    D.PROMOCAO_LOCACAO_CODIGO_PROMOCAO_LOCACAO,\n"
                + "    E.CODIGO_DEPENDENTE,\n"
                + "    E.NOME_DEPENDENTE,\n"
                + "    E.CLIENTE_CODIGO_CLIENTE,\n"
                + "    A.TITULO,\n"
                + "    A.CODIGO_OBJETO,\n"
                + "    A.CODIGO_OBJETO,\n" 
                + "    F.DIAS AS DIARIA,\n"
                + "    F.CODIGO_DIARIA,\n"
                + "    B.CODIGO_BARRAS,\n"
                + "    B.CODIGO_COPIA,\n"
                + "    F.MULTAS AS VALOR_MULTA_DIA,\n"
                + "    D.DATA_LOCACAO AS DATA_LOCACAO,\n"                
                + "    CURRENT_DATE AS DATA_ATUAL,\n"+
                "    (CASE\n" +
            "        WHEN (CURRENT_DATE - DATE(DATA_LOCACAO)) <= (DATA_PREVISTA - DATE(DATA_LOCACAO)) THEN 0\n" +
            "        ELSE (CURRENT_DATE - DATE(DATA_LOCACAO)) - (DATA_PREVISTA - DATE(DATA_LOCACAO))\n" +
            "    END) AS DIAS_MULTA,\n" +
            "    CASE\n" +
            "        WHEN\n" +
            "            ((CURRENT_DATE - DATE(DATA_LOCACAO)) - (DATA_PREVISTA - DATE(DATA_LOCACAO)) * F.MULTAS) IS NULL\n" +
            "                OR ((CURRENT_DATE - DATE(DATA_LOCACAO)) - (DATA_PREVISTA - DATE(DATA_LOCACAO)) * F.MULTAS < 0)\n" +
            "        THEN\n" +
            "            0\n" +
            "        ELSE (CURRENT_DATE - DATE(DATA_LOCACAO) - (DATA_PREVISTA - DATE(DATA_LOCACAO))) * F.MULTAS\n" +
            "    END AS VALOR_MULTA \n" 
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
                + "        AND B.DIARIA_CODIGO_DIARIA = F.CODIGO_DIARIA\n"
                + "        AND D.DEL_FLAG = 1\n"
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
        } catch (ParseException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    private List<ItemLocacao> getListaLocacoes(ResultSet rs) throws SQLException, ParseException {
        List<ItemLocacao> resultado = new ArrayList<ItemLocacao>();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        while (rs.next()) {
            ItemLocacao itemLocacao = new ItemLocacao();
            itemLocacao.setCodigo_item_locacao(rs.getInt("CODIGO_ITEM_LOCACAO"));
            itemLocacao.setValor_multa(rs.getDouble("VALOR_MULTA"));
            itemLocacao.setDias_multa(rs.getInt("DIAS_MULTA"));
            
            String dataString = rs.getString("DATA_LOCACAO");
            Date dataLocacao = format.parse(dataString);
            itemLocacao.setData_locacao(dataLocacao);
            
            itemLocacao.setData_prevista(rs.getDate("DATA_PREVISTA"));
            itemLocacao.setValor_locado(rs.getDouble("VALOR_LOCADO"));
            itemLocacao.setValor_pago(rs.getDouble("VALOR_PAGO"));

            PromocaoLocacao promocaoLocacao = new PromocaoLocacao();
            promocaoLocacao.setCodigo_promocao_locacao(rs.getInt("PROMOCAO_LOCACAO_CODIGO_PROMOCAO_LOCACAO"));
            
            Diaria diaria = new Diaria();
            diaria.setDias(rs.getInt("DIARIA"));
            diaria.setCodigo_diaria(rs.getInt("CODIGO_DIARIA"));
            diaria.setPromocaoLocacao(promocaoLocacao);

            Objeto objeto = new Objeto();            
            objeto.setCodigo_objeto(rs.getInt("CODIGO_OBJETO"));
            objeto.setTitulo(rs.getString("TITULO"));

            Copia copia = new Copia();
            copia.setDiaria(diaria);
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

        String sqlLancamento = "INSERT INTO `locadora`.`lancamento`(`valor`,`dependente_CODIGO_DEPENDENTE`,\n"
                + "`tipo_servico_codigo_tipo_servico`,`usuario_CODIGO_USUARIO`,`locacao_CODIGO_LOCACAO`)\n"
                + "VALUES(?,?,?,?,?);";

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

    public void salvarLancamento(List<Lancamento> lancamentos) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlLancamento = "INSERT INTO `lancamento`(`valor`,`dependente_CODIGO_DEPENDENTE`,\n"
                + "`tipo_servico_codigo_tipo_servico`,`usuario_CODIGO_USUARIO`,`locacao_CODIGO_LOCACAO`,data_lancamento, "
                + "caixa_codigo_caixa, cliente_codigo_cliente)\n"
                + "VALUES(?,?,?,?,?,CURRENT_DATE(),?, ?);";

        try {

            ps = con.prepareStatement(sqlLancamento);

            for(int i = 0; i < lancamentos.size(); i++){
                ps.setDouble(1, lancamentos.get(i).getValor());
                ps.setInt(2, lancamentos.get(i).getDependente().getCodigo_dependente());
                ps.setInt(3, lancamentos.get(i).getTipoServico().getCodigo_tipo_servico());
                ps.setInt(4, lancamentos.get(i).getUsuario().getCodigo_usuario());
                ps.setInt(5, lancamentos.get(i).getLocacao().getCodigo_locacao());
                ps.setInt(6, lancamentos.get(i).getCaixa());
                ps.setInt(7, lancamentos.get(i).getDependente().getCliente().getCodigo_cliente());
                ps.executeUpdate();
            }


            ps.close();
        } finally {
            pool.liberarConnection(con);
        }

    }

    public void salvarItem(List<ItemLocacao> itemLocacao) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO `locadora`.`ITEM_LOCACAO`(`COPIA_CODIGO_COPIA`, `LOCACAO_CODIGO_LOCACAO`, `DATA_LOCACAO`, `VALOR_LOCADO`,"
                + " `VALOR_PAGO`, DATA_PREVISTA, DEL_FLAG, PROMOCAO_LOCACAO_CODIGO_PROMOCAO_LOCACAO, "
                + "ITEM_VENDA_CODIGO_ITEM_VENDA  )VALUES( ?, ?, CURRENT_TIMESTAMP(), ?, ?, ?, ?, ?, ? );";

        try {
            ps = con.prepareStatement(sqlInsert);

            for (int i = 0; i < itemLocacao.size(); i++) {

                java.sql.Date data_prevista = null;
                if (itemLocacao.get(i).getData_prevista() != null) {
                    data_prevista = new java.sql.Date(itemLocacao.get(i).getData_prevista().getTime());
                }

                ps.setInt(1, itemLocacao.get(i).getCopia().getCodigo_copia());
                ps.setInt(2, itemLocacao.get(i).getLocacao().getCodigo_locacao());
                ps.setDouble(3, itemLocacao.get(i).getValor_locado());
                ps.setDouble(4, itemLocacao.get(i).getValor_pago());
                ps.setDate(5, (java.sql.Date) data_prevista);
                ps.setInt(6, 1);
                if(itemLocacao.get(i).getCopia().getDiaria().getPromocaoLocacao().getCodigo_promocao_locacao() != 0){
                    System.out.println("Código da Promoção locação: "+ itemLocacao.get(i).getCopia().getDiaria().getPromocaoLocacao().getCodigo_promocao_locacao());
                    ps.setInt(7, itemLocacao.get(i).getCopia().getDiaria().getPromocaoLocacao().getCodigo_promocao_locacao());                    
                } else {
                    ps.setInt(7, 0);
                }
                if(itemLocacao.get(i).getCopia().getDiaria().getPacotePromocional().getCodigo_pacote_promocioanl()!= 0){
                    System.out.println("Código do Pacote Promocional: "+ itemLocacao.get(i).getCopia().getDiaria().getPacotePromocional().getCodigo_pacote_promocioanl());
                    ps.setInt(8, itemLocacao.get(i).getCopia().getDiaria().getPacotePromocional().getItemVenda().getCodigo_item_venda());                    
                } else {
                    ps.setInt(8, 0);
                }
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

                ps.setInt(1, 0);
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
        ps.setInt(6, lancamento.getCaixa());
        ps.setInt(7, lancamento.getDependente().getCliente().getCodigo_cliente());

    }

    private List<ItemLocacao> getListaLocacaoAberta(ResultSet rs) throws SQLException, ParseException {
        List<ItemLocacao> resultado = new ArrayList<ItemLocacao>();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        while (rs.next()) {
            ItemLocacao itemLocacao = new ItemLocacao();
            itemLocacao.setCodigo_item_locacao(rs.getInt("CODIGO_ITEM_LOCACAO"));
            itemLocacao.setValor_multa(rs.getDouble("VALOR_MULTA"));
            itemLocacao.setDias_multa(rs.getInt("DIAS_MULTA"));
            
            String dataString = rs.getString("DATA_LOCACAO");
            Date dataLocacao = format.parse(dataString);
            itemLocacao.setData_locacao(dataLocacao);
            
            itemLocacao.setValor_pago(rs.getDouble("VALOR_PAGO"));
            itemLocacao.setValor_locado(rs.getDouble("VALOR_LOCADO"));
            itemLocacao.setData_prevista(rs.getDate("DATA_PREVISTA"));

            PromocaoLocacao promocaoLocacao = new PromocaoLocacao();
            promocaoLocacao.setCodigo_promocao_locacao(rs.getInt("PROMOCAO_LOCACAO_CODIGO_PROMOCAO_LOCACAO"));
            
            Diaria diaria = new Diaria();
            diaria.setDias(rs.getInt("DIARIA"));
            diaria.setCodigo_diaria(rs.getInt("CODIGO_DIARIA"));            
            diaria.setPromocaoLocacao(promocaoLocacao);
            
            Objeto objeto = new Objeto();
            objeto.setTitulo(rs.getString("TITULO"));
            objeto.setCodigo_objeto(rs.getInt("CODIGO_OBJETO"));

            Copia copia = new Copia();
            copia.setDiaria(diaria);
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

    public List<ItemLocacao> getCopiaCodigoObjeto(Integer codigo_objeto) {
        List<ItemLocacao> resultado = new ArrayList<ItemLocacao>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n" +
            "    C.CODIGO_LOCACAO,\n" +
            "    D.CODIGO_ITEM_LOCACAO,\n" +
            "    D.VALOR_LOCADO,\n" +
            "    D.DATA_PREVISTA,\n" +
            "    D.VALOR_PAGO,\n" +
            "    D.PROMOCAO_LOCACAO_CODIGO_PROMOCAO_LOCACAO,\n"+
            "    E.CODIGO_DEPENDENTE,\n" +
            "    E.NOME_DEPENDENTE,\n" +
            "    E.CLIENTE_CODIGO_CLIENTE,\n" +
            "    A.TITULO AS TITULO,\n" +
                "    A.CODIGO_OBJETO,\n" +
            "    F.DIAS AS DIARIA,\n" +
            "    B.CODIGO_BARRAS,\n" +
            "    B.CODIGO_COPIA,\n" +
            "    F.MULTAS AS VALOR_MULTA_DIA,\n" +
            "    F.CODIGO_DIARIA,\n" +
            "    D.DATA_LOCACAO AS DATA_LOCACAO,\n" +
            "    DATA_PREVISTA,\n" +
            "    CURRENT_DATE AS DATA_ATUAL,\n" +
            "    (CASE\n" +
            "        WHEN (CURRENT_DATE - DATE(DATA_LOCACAO)) <= (DATA_PREVISTA - DATE(DATA_LOCACAO)) THEN 0\n" +
            "        ELSE (CURRENT_DATE - DATE(DATA_LOCACAO)) - (DATA_PREVISTA - DATE(DATA_LOCACAO))\n" +
            "    END) AS DIAS_MULTA,\n" +
            "    CASE\n" +
            "        WHEN\n" +
            "            ((CURRENT_DATE - DATE(DATA_LOCACAO)) - (DATA_PREVISTA - DATE(DATA_LOCACAO)) * F.MULTAS) IS NULL\n" +
            "                OR ((CURRENT_DATE - DATE(DATA_LOCACAO)) - (DATA_PREVISTA - DATE(DATA_LOCACAO)) * F.MULTAS < 0)\n" +
            "        THEN\n" +
            "            0\n" +
            "        ELSE (CURRENT_DATE - DATE(DATA_LOCACAO) - (DATA_PREVISTA - DATE(DATA_LOCACAO))) * F.MULTAS\n" +
            "    END AS VALOR_MULTA,\n" +
            "    F.MULTAS\n" +
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
            "        AND B.DIARIA_CODIGO_DIARIA = F.CODIGO_DIARIA\n" +
            "        AND D.DEL_FLAG = 1\n" +
            "        AND A.TIPO_MOVIMENTO = 'LOCACAO'\n" +
            "        AND A.CODIGO_OBJETO = ?;\n" +
            "        ";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo_objeto);

            rs = ps.executeQuery();

            resultado = getListaLocacoes(rs);

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    public List<ItemLocacao> getCopiaDevolucaoCodigoBarras(String codigo_barras, Integer codigo_cliente) {
        List<ItemLocacao> resultado = new ArrayList<ItemLocacao>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n" +
            "    C.CODIGO_LOCACAO,\n" +
            "    D.CODIGO_ITEM_LOCACAO,\n" +
            "    D.VALOR_LOCADO,\n" +
            "    D.DATA_PREVISTA,\n" +
            "    D.VALOR_PAGO,\n" +
            "    E.CODIGO_DEPENDENTE,\n" +
            "    E.NOME_DEPENDENTE,\n" +
            "    E.CLIENTE_CODIGO_CLIENTE,\n" +
            "    A.TITULO AS TITULO,\n" +
            "    A.CODIGO_OBJETO,\n" +
            "    F.DIAS AS DIARIA,\n" +
            "    B.CODIGO_BARRAS,\n" +
            "    B.CODIGO_COPIA,\n" +
            "    F.MULTAS AS VALOR_MULTA_DIA,\n" +
            "    F.CODIGO_DIARIA,\n" +
            "    D.DATA_LOCACAO AS DATA_LOCACAO,\n" +
            "    DATA_PREVISTA,\n" +
            "    CURRENT_DATE AS DATA_ATUAL,\n" +
            "    (CASE\n" +
            "        WHEN (CURRENT_DATE - DATE(DATA_LOCACAO)) <= (DATA_PREVISTA - DATE(DATA_LOCACAO)) THEN 0\n" +
            "        ELSE (CURRENT_DATE - DATE(DATA_LOCACAO)) - (DATA_PREVISTA - DATE(DATA_LOCACAO))\n" +
            "    END) AS DIAS_MULTA,\n" +
            "    CASE\n" +
            "        WHEN\n" +
            "            ((CURRENT_DATE - DATE(DATA_LOCACAO)) - (DATA_PREVISTA - DATE(DATA_LOCACAO)) * F.MULTAS) IS NULL\n" +
            "                OR ((CURRENT_DATE - DATE(DATA_LOCACAO)) - (DATA_PREVISTA - DATE(DATA_LOCACAO)) * F.MULTAS < 0)\n" +
            "        THEN\n" +
            "            0\n" +
            "        ELSE (CURRENT_DATE - DATE(DATA_LOCACAO) - (DATA_PREVISTA - DATE(DATA_LOCACAO))) * F.MULTAS\n" +
            "    END AS VALOR_MULTA,\n" +
            "    F.MULTAS\n" +
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
            "        AND B.DIARIA_CODIGO_DIARIA = F.CODIGO_DIARIA\n" +
            "        AND D.DEL_FLAG = 1\n" +
            "        AND A.TIPO_MOVIMENTO = 'LOCACAO'\n" +
            "        AND E.CLIENTE_CODIGO_CLIENTE = ? \n" +
            "        AND B.CODIGO_BARRAS = ?;\n" +
            "        ";
        
        String sqlSelect1 = "SELECT \n" +
            "    C.CODIGO_LOCACAO,\n" +
            "    D.CODIGO_ITEM_LOCACAO,\n" +
            "    D.VALOR_LOCADO,\n" +
            "    D.DATA_PREVISTA,\n" +
            "    D.VALOR_PAGO,\n" +
            "    E.CODIGO_DEPENDENTE,\n" +
            "    E.NOME_DEPENDENTE,\n" +
            "    E.CLIENTE_CODIGO_CLIENTE,\n" +
            "    A.TITULO AS TITULO,\n" +
            "    A.CODIGO_OBJETO,\n" +
            "    F.DIAS AS DIARIA,\n" +
            "    B.CODIGO_BARRAS,\n" +
            "    B.CODIGO_COPIA,\n" +
            "    F.MULTAS AS VALOR_MULTA_DIA,\n" +
            "    F.CODIGO_DIARIA,\n" +
            "    D.DATA_LOCACAO AS DATA_LOCACAO,\n" +
            "    DATA_PREVISTA,\n" +
            "    CURRENT_DATE AS DATA_ATUAL,\n" +
            "    (CASE\n" +
            "        WHEN (CURRENT_DATE - DATE(DATA_LOCACAO)) <= (DATA_PREVISTA - DATE(DATA_LOCACAO)) THEN 0\n" +
            "        ELSE (CURRENT_DATE - DATE(DATA_LOCACAO)) - (DATA_PREVISTA - DATE(DATA_LOCACAO))\n" +
            "    END) AS DIAS_MULTA,\n" +
            "    CASE\n" +
            "        WHEN\n" +
            "            ((CURRENT_DATE - DATE(DATA_LOCACAO)) - (DATA_PREVISTA - DATE(DATA_LOCACAO)) * F.MULTAS) IS NULL\n" +
            "                OR ((CURRENT_DATE - DATE(DATA_LOCACAO)) - (DATA_PREVISTA - DATE(DATA_LOCACAO)) * F.MULTAS < 0)\n" +
            "        THEN\n" +
            "            0\n" +
            "        ELSE (CURRENT_DATE - DATE(DATA_LOCACAO) - (DATA_PREVISTA - DATE(DATA_LOCACAO))) * F.MULTAS\n" +
            "    END AS VALOR_MULTA,\n" +
            "    F.MULTAS\n" +
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
            "        AND B.DIARIA_CODIGO_DIARIA = F.CODIGO_DIARIA\n" +
            "        AND D.DEL_FLAG = 1\n" +
            "        AND A.TIPO_MOVIMENTO = 'LOCACAO'\n" +                
            "        AND B.CODIGO_BARRAS = ?;\n" +
            "        ";

        try {
            
            if(codigo_cliente == 0){
                ps = con.prepareStatement(sqlSelect1);                
                ps.setString(1, codigo_barras);
            }else {
                ps = con.prepareStatement(sqlSelect);
                ps.setInt(1, codigo_cliente);                
                ps.setString(2, codigo_barras);
            }

            rs = ps.executeQuery();

            resultado = getListaLocacoes(rs);

            ps.close();
            return resultado;
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;

    }

    public List<ItemLocacao> getCopiaDevolucaoTitulo(String titulo, Integer codigo_cliente) {
        List<ItemLocacao> resultado = new ArrayList<ItemLocacao>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n" +
            "    C.CODIGO_LOCACAO,\n" +
            "    D.CODIGO_ITEM_LOCACAO,\n" +
            "    D.VALOR_LOCADO,\n" +
            "    D.DATA_PREVISTA,\n" +
            "    D.VALOR_PAGO,\n" +
            "    D.PROMOCAO_LOCACAO_CODIGO_PROMOCAO_LOCACAO,\n" +
            "    E.CODIGO_DEPENDENTE,\n" +
            "    E.NOME_DEPENDENTE,\n" +
            "    E.CLIENTE_CODIGO_CLIENTE,\n" +
            "    A.TITULO AS TITULO,\n" +
            "    A.CODIGO_OBJETO,\n" +
            "    F.DIAS AS DIARIA,\n" +
            "    B.CODIGO_BARRAS,\n" +
            "    B.CODIGO_COPIA,\n" +
            "    F.MULTAS AS VALOR_MULTA_DIA,\n" +
            "    F.CODIGO_DIARIA,\n" +
            "    D.DATA_LOCACAO AS DATA_LOCACAO,\n" +
            "    DATA_PREVISTA,\n" +
            "    CURRENT_DATE AS DATA_ATUAL,\n" +
            "    (CASE\n" +
            "        WHEN (CURRENT_DATE - DATE(DATA_LOCACAO)) <= (DATA_PREVISTA - DATE(DATA_LOCACAO)) THEN 0\n" +
            "        ELSE (CURRENT_DATE - DATE(DATA_LOCACAO)) - (DATA_PREVISTA - DATE(DATA_LOCACAO))\n" +
            "    END) AS DIAS_MULTA,\n" +
            "    CASE\n" +
            "        WHEN\n" +
            "            ((CURRENT_DATE - DATE(DATA_LOCACAO)) - (DATA_PREVISTA - DATE(DATA_LOCACAO)) * F.MULTAS) IS NULL\n" +
            "                OR ((CURRENT_DATE - DATE(DATA_LOCACAO)) - (DATA_PREVISTA - DATE(DATA_LOCACAO)) * F.MULTAS < 0)\n" +
            "        THEN\n" +
            "            0\n" +
            "        ELSE (CURRENT_DATE - DATE(DATA_LOCACAO) - (DATA_PREVISTA - DATE(DATA_LOCACAO))) * F.MULTAS\n" +
            "    END AS VALOR_MULTA,\n" +
            "    F.MULTAS\n" +
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
            "        AND B.DIARIA_CODIGO_DIARIA = F.CODIGO_DIARIA\n" +
            "        AND D.DEL_FLAG = 1\n" +
            "        AND A.TIPO_MOVIMENTO = 'LOCACAO'\n" +
            "        AND E.CLIENTE_CODIGO_CLIENTE = ? \n" +
            "        AND A.TITULO LIKE ?;\n" +
            "        ";
        
        String sqlSelect1 = "SELECT \n" +
            "    C.CODIGO_LOCACAO,\n" +
            "    D.CODIGO_ITEM_LOCACAO,\n" +
            "    D.VALOR_LOCADO,\n" +
            "    D.DATA_PREVISTA,\n" +
            "    D.VALOR_PAGO,\n" +
            "    D.PROMOCAO_LOCACAO_CODIGO_PROMOCAO_LOCACAO,\n" +
            "    E.CODIGO_DEPENDENTE,\n" +
            "    E.NOME_DEPENDENTE,\n" +
            "    E.CLIENTE_CODIGO_CLIENTE,\n" +
            "    A.TITULO AS TITULO,\n" +
            "    A.CODIGO_OBJETO,\n" +
            "    F.DIAS AS DIARIA,\n" +
            "    B.CODIGO_BARRAS,\n" +
            "    B.CODIGO_COPIA,\n" +
            "    F.MULTAS AS VALOR_MULTA_DIA,\n" +
            "    F.CODIGO_DIARIA,\n" +
            "    D.DATA_LOCACAO AS DATA_LOCACAO,\n" +
            "    DATA_PREVISTA,\n" +
            "    CURRENT_DATE AS DATA_ATUAL,\n" +
            "    (CASE\n" +
            "        WHEN (CURRENT_DATE - DATE(DATA_LOCACAO)) <= (DATA_PREVISTA - DATE(DATA_LOCACAO)) THEN 0\n" +
            "        ELSE (CURRENT_DATE - DATE(DATA_LOCACAO)) - (DATA_PREVISTA - DATE(DATA_LOCACAO))\n" +
            "    END) AS DIAS_MULTA,\n" +
            "    CASE\n" +
            "        WHEN\n" +
            "            ((CURRENT_DATE - DATE(DATA_LOCACAO)) - (DATA_PREVISTA - DATE(DATA_LOCACAO)) * F.MULTAS) IS NULL\n" +
            "                OR ((CURRENT_DATE - DATE(DATA_LOCACAO)) - (DATA_PREVISTA - DATE(DATA_LOCACAO)) * F.MULTAS < 0)\n" +
            "        THEN\n" +
            "            0\n" +
            "        ELSE (CURRENT_DATE - DATE(DATA_LOCACAO) - (DATA_PREVISTA - DATE(DATA_LOCACAO))) * F.MULTAS\n" +
            "    END AS VALOR_MULTA,\n" +
            "    F.MULTAS\n" +
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
            "        AND B.DIARIA_CODIGO_DIARIA = F.CODIGO_DIARIA\n" +
            "        AND D.DEL_FLAG = 1\n" +
            "        AND A.TIPO_MOVIMENTO = 'LOCACAO'\n" +            
            "        AND A.TITULO LIKE ?;\n" +
            "        ";

        try {
            if(codigo_cliente == 0){
                ps = con.prepareStatement(sqlSelect1);                
                ps.setString(1, "%" + titulo + "%");                
            }else {
                ps = con.prepareStatement(sqlSelect);
                ps.setInt(1, codigo_cliente);                
                ps.setString(2, "%" + titulo + "%");                
            }
            rs = ps.executeQuery();

            resultado = getListaLocacoes(rs);
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    public List<ItemLocacao> getCopiaDevolucaoAtor(String ator, Integer codigo_cliente) {
        List<ItemLocacao> resultado = new ArrayList<ItemLocacao>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n" +
            "    C.CODIGO_LOCACAO,\n" +
            "    D.CODIGO_ITEM_LOCACAO,\n" +
            "    D.VALOR_LOCADO,\n" +
            "    D.DATA_PREVISTA,\n" +
            "    D.VALOR_PAGO,\n" +
            "    D.PROMOCAO_LOCACAO_CODIGO_PROMOCAO_LOCACAO,\n" +                
            "    E.CODIGO_DEPENDENTE,\n" +
            "    E.NOME_DEPENDENTE,\n" +
            "    E.CLIENTE_CODIGO_CLIENTE,\n" +
            "    A.TITULO AS TITULO,\n" +
                "    A.CODIGO_OBJETO,\n" +
            "    F.DIAS AS DIARIA,\n" +
            "    B.CODIGO_BARRAS,\n" +
            "    B.CODIGO_COPIA,\n" +
            "    F.MULTAS AS VALOR_MULTA_DIA,\n" +
            "    F.CODIGO_DIARIA,\n" +
            "    D.DATA_LOCACAO AS DATA_LOCACAO,\n" +
            "    DATA_PREVISTA,\n" +
            "    CURRENT_DATE AS DATA_ATUAL,\n" +
            "    (CASE\n" +
            "        WHEN (CURRENT_DATE - DATE(DATA_LOCACAO)) <= (DATA_PREVISTA - DATE(DATA_LOCACAO)) THEN 0\n" +
            "        ELSE (CURRENT_DATE - DATE(DATA_LOCACAO)) - (DATA_PREVISTA - DATE(DATA_LOCACAO))\n" +
            "    END) AS DIAS_MULTA,\n" +
            "    CASE\n" +
            "        WHEN\n" +
            "            ((CURRENT_DATE - DATE(DATA_LOCACAO)) - (DATA_PREVISTA - DATE(DATA_LOCACAO)) * F.MULTAS) IS NULL\n" +
            "                OR ((CURRENT_DATE - DATE(DATA_LOCACAO)) - (DATA_PREVISTA - DATE(DATA_LOCACAO)) * F.MULTAS < 0)\n" +
            "        THEN\n" +
            "            0\n" +
            "        ELSE (CURRENT_DATE - DATE(DATA_LOCACAO) - (DATA_PREVISTA - DATE(DATA_LOCACAO))) * F.MULTAS\n" +
            "    END AS VALOR_MULTA,\n" +
            "    F.MULTAS\n" +
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
            "        AND B.DIARIA_CODIGO_DIARIA = F.CODIGO_DIARIA\n" +
            "        AND D.DEL_FLAG = 1\n" +
            "        AND A.TIPO_MOVIMENTO = 'LOCACAO'\n" +
            "        AND E.CLIENTE_CODIGO_CLIENTE = ? \n" +
            "        AND A.ELENCO LIKE ?;\n" +
            "        ";
        
        String sqlSelect1 = "SELECT \n" +
            "    C.CODIGO_LOCACAO,\n" +
            "    D.CODIGO_ITEM_LOCACAO,\n" +
            "    D.VALOR_LOCADO,\n" +
            "    D.DATA_PREVISTA,\n" +
            "    D.VALOR_PAGO,\n" +
            "    D.PROMOCAO_LOCACAO_CODIGO_PROMOCAO_LOCACAO,\n" +                
            "    E.CODIGO_DEPENDENTE,\n" +
            "    E.NOME_DEPENDENTE,\n" +
            "    E.CLIENTE_CODIGO_CLIENTE,\n" +
            "    A.TITULO AS TITULO,\n" +
                "    A.CODIGO_OBJETO,\n" +
            "    F.DIAS AS DIARIA,\n" +
            "    B.CODIGO_BARRAS,\n" +
            "    B.CODIGO_COPIA,\n" +
            "    F.MULTAS AS VALOR_MULTA_DIA,\n" +
            "    F.CODIGO_DIARIA,\n" +
            "    D.DATA_LOCACAO AS DATA_LOCACAO,\n" +
            "    DATA_PREVISTA,\n" +
            "    CURRENT_DATE AS DATA_ATUAL,\n" +
            "    (CASE\n" +
            "        WHEN (CURRENT_DATE - DATE(DATA_LOCACAO)) <= (DATA_PREVISTA - DATE(DATA_LOCACAO)) THEN 0\n" +
            "        ELSE (CURRENT_DATE - DATE(DATA_LOCACAO)) - (DATA_PREVISTA - DATE(DATA_LOCACAO))\n" +
            "    END) AS DIAS_MULTA,\n" +
            "    CASE\n" +
            "        WHEN\n" +
            "            ((CURRENT_DATE - DATE(DATA_LOCACAO)) - (DATA_PREVISTA - DATE(DATA_LOCACAO)) * F.MULTAS) IS NULL\n" +
            "                OR ((CURRENT_DATE - DATE(DATA_LOCACAO)) - (DATA_PREVISTA - DATE(DATA_LOCACAO)) * F.MULTAS < 0)\n" +
            "        THEN\n" +
            "            0\n" +
            "        ELSE (CURRENT_DATE - DATE(DATA_LOCACAO) - (DATA_PREVISTA - DATE(DATA_LOCACAO))) * F.MULTAS\n" +
            "    END AS VALOR_MULTA,\n" +
            "    F.MULTAS\n" +
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
            "        AND B.DIARIA_CODIGO_DIARIA = F.CODIGO_DIARIA\n" +
            "        AND D.DEL_FLAG = 1\n" +
            "        AND A.TIPO_MOVIMENTO = 'LOCACAO'\n" +
            "        AND A.ELENCO LIKE ?;\n" +
            "        ";

        try {
            if(codigo_cliente == 0){
                ps = con.prepareStatement(sqlSelect1);                
                ps.setString(1, "%"+ator+"%");
            }else {
                ps = con.prepareStatement(sqlSelect);
                ps.setInt(1, codigo_cliente);                
                ps.setString(2, "%"+ator+"%");
            }

            rs = ps.executeQuery();

            resultado = getListaLocacoes(rs);
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    public List<ItemLocacao> getObjetoHistoricoLocacaoes(String nome_cliente, String nome_objeto) {
        List<ItemLocacao> resultado = new ArrayList<ItemLocacao>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT DATA_LOCACAO, DATA_PREVISTA, DATA_DEVOLUCAO, VALOR_LOCADO, TITULO, NOME_DEPENDENTE, NOME_USUARIO FROM LOCACAO E, ITEM_LOCACAO A, COPIA B, OBJETO C, DEPENDENTE D,\n" +
            "USUARIO F\n" +
            "WHERE A.COPIA_CODIGO_COPIA = B.CODIGO_COPIA\n" +
            "AND B.OBJETO_CODIGO_OBJETO = C.CODIGO_OBJETO\n" +
            "AND A.LOCACAO_CODIGO_LOCACAO = E.CODIGO_LOCACAO\n" +
            "AND E.DEPENDENTE_CODIGO_DEPENDENTE = D.CODIGO_DEPENDENTE\n" +
            "AND E.USUARIO_CODIGO_USUARIO = F.CODIGO_USUARIO\n" +
            "AND NOME_DEPENDENTE LIKE ?\n" +
            "AND TITULO LIKE ? ORDER BY DATA_LOCACAO, TITULO DESC LIMIT 0, 200;";
        
        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%"+nome_cliente+"%");
            ps.setString(2, "%"+nome_objeto+"%");
            
            rs = ps.executeQuery();
            
            resultado = getListaHistoricoLocacoes(rs);
            
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    private List<ItemLocacao> getListaHistoricoLocacoes(ResultSet rs) throws SQLException, ParseException {
        List<ItemLocacao> resultado = new ArrayList<ItemLocacao>();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        while (rs.next()) {
            Copia copia = new Copia();
            Objeto objeto = new Objeto();
            objeto.setTitulo(rs.getString("TITULO"));
            copia.setObjeto(objeto);
            Usuario usuario = new Usuario();
            usuario.setNome_usuario(rs.getString("NOME_USUARIO"));
            
            ItemLocacao itemLocacao = new ItemLocacao();
            itemLocacao.setCopia(copia);            
            
            String dataString = rs.getString("DATA_LOCACAO");
            Date dataLocacao = format.parse(dataString);
            itemLocacao.setData_locacao(dataLocacao);
                        
            itemLocacao.setData_prevista(rs.getDate("DATA_PREVISTA"));
            itemLocacao.setData_devolucao(rs.getDate("DATA_DEVOLUCAO"));
            itemLocacao.setValor_locado(rs.getDouble("VALOR_LOCADO"));
            
            Locacao locacao = new Locacao();
            Dependente dependente = new Dependente();
            dependente.setNome_dependente(rs.getString("NOME_DEPENDENTE"));
            locacao.setDependente(dependente);
            locacao.setUsuario(usuario);
            itemLocacao.setLocacao(locacao);
                        
            resultado.add(itemLocacao);
        }
        return resultado;
    }
}
