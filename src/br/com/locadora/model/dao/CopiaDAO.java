package br.com.locadora.model.dao;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.bean.Objeto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CopiaDAO implements InterfaceCopiaDAO {

    private InterfacePool pool;

    public CopiaDAO(InterfacePool pool) {
        this.pool = pool;
    }

    @Override
    public void atualizar(Copia copia) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlAtualizar = " UPDATE DIARIA SET bairro=?, celular=?, cep=?, "
                + " cidade=?, cpf_cnpj=?, email=?, endereco=?, estado=?,"
                + " telefone=?, nome=? WHERE codigo = ? ;";

        try {
            ps = con.prepareStatement(sqlAtualizar);

            setPreparedStatement(copia, ps);

            ps.executeUpdate();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
    }

    @Override
    public void alterarStatusFilme(Copia copia) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlAtualizar = " UPDATE COPIA SET DEL_FLAG = ? WHERE CODIGO_COPIA = ? ;";

        try {
            ps = con.prepareStatement(sqlAtualizar);
            
            ps.setString(1, copia.getStatus());
            ps.setInt(2, copia.getCodigo_copia());

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
        String sqlExcluir = "DELETE FROM COPIA WHERE CODIGO_COPIA = ?;";

        try {
            ps = con.prepareStatement(sqlExcluir);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
    }

    public Integer getObjetoDisponivel(Integer codigo_interno) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n"
                + "    COUNT(CODIGO_COPIA) AS QUANTIDADE_DISPONIVEL\n"
                + "FROM\n"
                + "	locadora.OBJETO A,\n"
                + "    locadora.COPIA B\n"
                + "WHERE\n"
                + "	A.CODIGO_OBJETO = B.CODIGO_OBJETO\n"
                + "    AND A.CODIGO_OBJETO = ?\n"
                + "	AND B.DEL_FLAG = 0;";

        Integer quantidade_disponivel;
        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo_interno);

            rs = ps.executeQuery();

            quantidade_disponivel = rs.getInt("QUANTIDADE_DISPONIVEL");
//            if (resultado.size() > 0) {
//                return resultado.get(0);
//            }
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return quantidade_disponivel;
//        return null;
    }

    @Override
    public List<Copia> getCopia(Integer codigo_interno) throws SQLException {
        List<Copia> resultado = new ArrayList<Copia>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n"
                + "	A.CODIGO_COPIA, \n"
                + "	A.CODIGO_BARRAS, \n"
                + "    A.DEL_FLAG,\n"
                + "    A.PRECO_CUSTO,\n"
                + "    B.DESCRICAO_OBJETO,\n"
                + "    B.TIPO_MOVIMENTO,\n"
                + "    B.TIPO_MIDIA,\n"
                + "    A.IDIOMA,\n"
                + "    A.LEGENDA,\n"
                + "    C.DIAS,\n"
                + "    C.VALOR,\n"
                + "    C.VALOR_PROMOCAO\n"
                + "FROM\n"
                + "    locadora.COPIA A,\n"
                + "    locadora.OBJETO B,\n"
                + "    locadora.DIARIA C\n"
                + "WHERE\n"
                + "    A.CODIGO_OBJETO = B.CODIGO_OBJETO\n"
                + "        AND C.CODIGO_DIARIA = B.CODIGO_DIARIA\n"
                + "        AND A.DEL_FLAG = 0\n"
                + "        AND A.DEFECT_FLAG = 0\n"
                + "        AND TIPO_MOVIMENTO = 'Locação'\n"
                + "		AND A.CODIGO_COPIA = ?;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo_interno);

            rs = ps.executeQuery();

            resultado = getListaCopia(rs);
//            if (resultado.size() > 0) {
//                return resultado.get(0);
//            }
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    

    public boolean getCopia_existente(String codigo_barras) throws SQLException {

        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT COUNT(CODIGO_COPIA) AS COUNT FROM COPIA WHERE CODIGO_BARRAS = ? AND DEFECT_FLAG = 0;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, codigo_barras);

            rs = ps.executeQuery();
            Integer quantidade_existente;
            rs.next();

            quantidade_existente = rs.getInt("COUNT");

            if (quantidade_existente > 0) {
                return true;
            }
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return false;
    }

    public boolean getObjeto_existente(Integer codigo_objeto) throws SQLException {

        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT COUNT(CODIGO_OBJETO) AS COUNT FROM OBJETO WHERE CODIGO_OBJETO = ? AND DEL_FLAG = 0;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo_objeto);

            rs = ps.executeQuery();
            Integer quantidade_existente;
            rs.next();

            quantidade_existente = rs.getInt("COUNT");

            if (quantidade_existente > 0) {
                return true;
            }
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return false;
    }

    public List<Copia> getCopia_codigo_barras(String codigo_barras) throws SQLException {
        List<Copia> resultado = new ArrayList<Copia>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n"
                + "	A.CODIGO_COPIA, \n"
                + "	A.OBJETO_CODIGO_OBJETO, \n"
                + "    A.CODIGO_BARRAS,\n"
                + "    A.NUMERO_COPIA,\n"
                + "    A.PRECO_CUSTO,\n"
                + "    A.DEL_FLAG,\n"
                + "    B.DESCRICAO_OBJETO,\n"
                + "    B.CODIGO_OBJETO,\n"
                + "    B.TIPO_MOVIMENTO,\n"
                + "    B.TIPO_MIDIA,\n"
                + "    B.CENSURA,\n"
                + "    A.IDIOMA,\n"
                + "    A.LEGENDA,\n"
                + "    C.DIAS,\n"
                + "    C.VALOR,\n"
                + "    C.VALOR_PROMOCAO\n"
                + "FROM\n"
                + "    locadora.COPIA A,\n"
                + "    locadora.OBJETO B,\n"
                + "    locadora.DIARIA C\n"
                + "WHERE\n"
                + "    A.OBJETO_CODIGO_OBJETO = B.CODIGO_OBJETO\n"
                + "        AND C.CODIGO_DIARIA = B.DIARIA_CODIGO_DIARIA\n"
                + "        AND A.DEL_FLAG = 0\n"
                + "        AND A.DEFECT_FLAG = 0\n"
                + "        AND TIPO_MOVIMENTO = 'Locação'\n"
                + "		AND A.CODIGO_BARRAS = ?;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, codigo_barras);

            rs = ps.executeQuery();

            resultado = getListaCopia(rs);
//            if (resultado.size() > 0) {
//            }
            ps.close();
            return resultado;
        } finally {
            pool.liberarConnection(con);
        }

    }
    
    

    public List<Copia> getCopia_codigo_objeto(Integer codigo_objeto, Integer del_flag, String tipo_movimento) throws SQLException {
        List<Copia> resultado = new ArrayList<Copia>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect_del_flag = "SELECT \n"
                + "	A.CODIGO_COPIA, \n"
                + "	A.OBJETO_CODIGO_OBJETO, \n"
                + "    A.CODIGO_BARRAS,\n"
                + "    A.NUMERO_COPIA,\n"
                + "    A.PRECO_CUSTO,\n"
                + "    A.DEL_FLAG,\n"
                + "    A.DATA_AQUISICAO,\n"
                + "    B.DESCRICAO_OBJETO,\n"
                + "    B.CODIGO_OBJETO,\n"
                + "    B.TIPO_MOVIMENTO,\n"
                + "    B.TIPO_MIDIA,\n"
                + "    B.CENSURA,\n"
                + "    A.IDIOMA,\n"
                + "    A.LEGENDA,\n"
                + "    C.DIAS,\n"
                + "    C.VALOR,\n"
                + "    C.VALOR_PROMOCAO\n"
                + "FROM\n"
                + "    locadora.COPIA A,\n"
                + "    locadora.OBJETO B,\n"
                + "    locadora.DIARIA C\n"
                + "WHERE\n"
                + "    A.OBJETO_CODIGO_OBJETO = B.CODIGO_OBJETO\n"
                + "        AND C.CODIGO_DIARIA = B.DIARIA_CODIGO_DIARIA\n"
                + "        AND A.DEL_FLAG = 0\n"
                + "        AND A.DEFECT_FLAG = 0\n"
                + "        AND TIPO_MOVIMENTO LIKE ?\n"
                + "		AND B.CODIGO_OBJETO = ? ORDER BY CODIGO_COPIA;";

        String sqlSelect = "SELECT \n"
                + "	A.CODIGO_COPIA, \n"
                + "	A.OBJETO_CODIGO_OBJETO, \n"
                + "    A.CODIGO_BARRAS,\n"
                + "    A.NUMERO_COPIA,\n"
                + "    A.PRECO_CUSTO,\n"
                + "    A.DEL_FLAG,\n"
                + "    A.IDIOMA,\n"
                + "    A.LEGENDA,\n"
                + "    A.DATA_AQUISICAO,\n"
                + "    B.DESCRICAO_OBJETO,\n"
                + "    B.CODIGO_OBJETO,\n"
                + "    B.TIPO_MOVIMENTO,\n"
                + "    B.TIPO_MIDIA,\n"
                + "    B.CENSURA,\n"
                + "    C.DIAS,\n"
                + "    C.VALOR,\n"
                + "    C.VALOR_PROMOCAO\n"
                + "FROM\n"
                + "    locadora.COPIA A,\n"
                + "    locadora.OBJETO B,\n"
                + "    locadora.DIARIA C\n"
                + "WHERE\n"
                + "    A.OBJETO_CODIGO_OBJETO = B.CODIGO_OBJETO\n"
                + "        AND C.CODIGO_DIARIA = B.DIARIA_CODIGO_DIARIA\n"
                + "        AND A.DEFECT_FLAG = 0\n"
                + "        AND TIPO_MOVIMENTO LIKE ?\n"
                + "		AND B.CODIGO_OBJETO = ? ORDER BY CODIGO_COPIA;";

        try {
            if (del_flag == 0) {
                ps = con.prepareStatement(sqlSelect_del_flag);
            } else {
                ps = con.prepareStatement(sqlSelect);
            }
            ps.setString(1, "%" + tipo_movimento);
            ps.setInt(2, codigo_objeto);

            rs = ps.executeQuery();

            resultado = getListaCopia(rs);
//            if (resultado.size() > 0) {
//            }
            ps.close();
            return resultado;
        } catch (SQLException ex) {
            Logger.getLogger(CopiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return null;

    }

    public List<Copia> getCopia_titulo(String titulo) throws SQLException {
        List<Copia> resultado = new ArrayList<Copia>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n"
                + "	A.CODIGO_COPIA, \n"
                + "	A.OBJETO_CODIGO_OBJETO, \n"
                + "	A.CODIGO_BARRAS, \n"
                + "    A.DEL_FLAG,\n"
                + "    A.PRECO_CUSTO,\n"
                + "    B.DESCRICAO_OBJETO,\n"
                + "    B.TIPO_MOVIMENTO,\n"
                + "    B.TIPO_MIDIA,\n"
                + "    B.CENSURA,\n"                
                + "    A.IDIOMA,\n"
                + "    A.LEGENDA,\n"
                + "    C.DIAS,\n"
                + "    C.VALOR,\n"
                + "    C.VALOR_PROMOCAO\n"
                + "FROM\n"
                + "    locadora.COPIA A,\n"
                + "    locadora.OBJETO B,\n"
                + "    locadora.DIARIA C\n"
                + "WHERE\n"
                + "    A.OBJETO_CODIGO_OBJETO = B.CODIGO_OBJETO\n"
                + "        AND C.CODIGO_DIARIA = B.DIARIA_CODIGO_DIARIA\n"
                + "        AND A.DEL_FLAG = 0\n"
                + "        AND A.DEFECT_FLAG = 0\n"
                + "        AND TIPO_MOVIMENTO = 'Locação'\n"
                + "		AND B.DESCRICAO_OBJETO LIKE ?;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%" + titulo + "%");

            rs = ps.executeQuery();

            resultado = getListaCopia(rs);
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    

    public List<Copia> getCopia_ator(String ator) throws SQLException {
        List<Copia> resultado = new ArrayList<Copia>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n"
                + "	A.CODIGO_COPIA, \n"
                + "	A.CODIGO_BARRAS, \n"
                + "	A.OBJETO_CODIGO_OBJETO, \n"
                + "    A.DEL_FLAG,\n"
                + "    A.PRECO_CUSTO,\n"
                + "    B.DESCRICAO_OBJETO,\n"
                + "    B.TIPO_MOVIMENTO,\n"
                + "    B.TIPO_MIDIA,\n"
                + "    A.IDIOMA,\n"
                + "    A.LEGENDA,\n"
                + "    C.DIAS,\n"
                + "    C.VALOR,\n"
                + "    C.VALOR_PROMOCAO\n"
                + "FROM\n"
                + "    locadora.COPIA A,\n"
                + "    locadora.OBJETO B,\n"
                + "    locadora.DIARIA C\n"
                + "WHERE\n"
                + "    A.OBJETO_CODIGO_OBJETO = B.CODIGO_OBJETO\n"
                + "        AND C.CODIGO_DIARIA = B.DIARIA_CODIGO_DIARIA\n"
                + "        AND A.DEL_FLAG = 0\n"
                + "        AND A.DEFECT_FLAG = 0\n"
                + "        AND TIPO_MOVIMENTO = 'Locação'\n"
                + "		AND B.ELENCO LIKE ?;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%" + ator + "%");

            rs = ps.executeQuery();

            resultado = getListaCopia(rs);
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    

    @Override
    public List<Copia> getCopias(String nome_copia) throws SQLException {
        List<Copia> resultado = new ArrayList<Copia>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM DIARIA WHERE NOME_DIARIA LIKE ? ORDER BY NOME_DIARIA;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, nome_copia);
            rs = ps.executeQuery();

            resultado = getListaCopia(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    public String getQuantidadeAssistida(Integer codigo_cliente, String codigo_barras) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT \n"
                + "    COUNT(C.LOCACAO_CODIGO_LOCACAO) AS COUNT,\n"
                + "    MAX(DATE_FORMAT(C.DATA_LOCACAO, '%d/%m/%Y')) AS ULTIMA_DATA_LOCACAO\n"
                + "FROM\n"
                + "    locadora.COPIA A,\n"
                + "    locadora.LOCACAO B,\n"
                + "    locadora.ITEM_LOCACAO C,\n"
                + "    locadora.DEPENDENTE D,\n"
                + "    OBJETO E\n"
                + "WHERE\n"
                + "    B.CODIGO_LOCACAO = C.LOCACAO_CODIGO_LOCACAO\n"
                + "        AND B.DEPENDENTE_CODIGO_DEPENDENTE = D.CODIGO_DEPENDENTE\n"
                + "        AND A.CODIGO_COPIA = C.COPIA_CODIGO_COPIA\n"
                + "        AND A.OBJETO_CODIGO_OBJETO = E.CODIGO_OBJETO\n"
                + "        AND E.CODIGO_OBJETO = (SELECT \n"
                + "            OBJETO_CODIGO_OBJETO\n"
                + "        FROM\n"
                + "            COPIA\n"
                + "        WHERE\n"
                + "            CODIGO_BARRAS = ?)		\n"
                + "        AND D.CODIGO_DEPENDENTE = ?;";
        ResultSet rs = null;

        try {
            Integer quantidade_locado;
            String ultima_data_locado;
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, codigo_barras);
            ps.setInt(2, codigo_cliente);

            rs = ps.executeQuery();
            rs.next();
            quantidade_locado = rs.getInt("COUNT");
            ultima_data_locado = rs.getString("ULTIMA_DATA_LOCACAO");

            rs.close();
            ps.close();
            if (quantidade_locado >= 1) {
                return "Cliente já assistiu " + quantidade_locado + ", última vez foi no dia " + ultima_data_locado + ". Deseja locar novamente ?";
            } else {
                return "";
            }
        } finally {
            pool.liberarConnection(con);
        }

    }

    public List<Copia> getTodasCopias() throws SQLException {
        List<Copia> resultado = new ArrayList<Copia>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM DIARIA ORDER BY NOME_DIARIA;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();

            resultado = getListaCopia(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    private List<Copia> getListaCopia(ResultSet rs) throws SQLException {
        List<Copia> resultado = new ArrayList<Copia>();
        while (rs.next()) {
            Copia copia = new Copia();
            Diaria diaria = new Diaria();
            Objeto objeto = new Objeto();

            diaria.setDias(rs.getInt("DIAS"));
            diaria.setValor(rs.getDouble("VALOR"));
            diaria.setValor_promocao(rs.getDouble("VALOR_PROMOCAO"));

            objeto.setDescricao_objeto(rs.getString("DESCRICAO_OBJETO"));
            objeto.setTipo_movimento(rs.getString("TIPO_MOVIMENTO"));
            objeto.setTipo_midia(rs.getString("TIPO_MIDIA"));
            objeto.setCodigo_objeto(rs.getInt("OBJETO_CODIGO_OBJETO"));
            objeto.setCensura(rs.getInt("CENSURA"));

            objeto.setDiaria(diaria);
            copia.setObjeto(objeto);

            copia.setCodigo_copia(rs.getInt("CODIGO_COPIA"));
            copia.setCodigo_barras(rs.getString("CODIGO_BARRAS"));
            copia.setPreco_custo(rs.getDouble("PRECO_CUSTO"));

            copia.setIdioma(rs.getString("IDIOMA"));
            copia.setLegenda(rs.getString("LEGENDA"));
            copia.setData_aquisicao(rs.getDate("DATA_AQUISICAO"));
            copia.setNumero_copia(rs.getInt("NUMERO_COPIA"));

            if (rs.getInt("DEL_FLAG") == 0) {
                copia.setStatus("Disponivel");
            } else {
                copia.setStatus("Indisponivel");
            }

            resultado.add(copia);
        }
        return resultado;
    }

    @Override
    public Copia salvar(Copia copia) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO `locadora`.`COPIA`(`IDIOMA`,`LEGENDA`,`DATA_AQUISICAO`,"
                + "`PRECO_CUSTO`,`OBJETO_CODIGO_OBJETO`,NUMERO_COPIA, CODIGO_BARRAS)VALUES(?,?,?,?,?,?,?);";

        try {
            //Pega o numero da ultima copia adicionada para aquele filme
            ResultSet res;
            Integer numero_copia_max;
            String sql_max = "SELECT \n"
                    + "    CASE\n"
                    + "        WHEN MAX(NUMERO_COPIA) + 1 IS NULL THEN 1\n"
                    + "        ELSE MAX(NUMERO_COPIA) + 1\n"
                    + "    END AS NUMERO_COPIA\n"
                    + "FROM\n"
                    + "    locadora.OBJETO A,\n"
                    + "    locadora.COPIA B\n"
                    + "WHERE\n"
                    + "    A.CODIGO_OBJETO = B.OBJETO_CODIGO_OBJETO\n"
                    + "        AND A.CODIGO_OBJETO = ?;";
            ps = con.prepareStatement(sql_max);
            ps.setInt(1, copia.getObjeto().getCodigo_objeto());
            res = ps.executeQuery();
            res.next();
            numero_copia_max = res.getInt("NUMERO_COPIA");
            copia.setCodigo_barras(copia.getObjeto().getCodigo_objeto() + "-" + numero_copia_max);
            copia.setNumero_copia(numero_copia_max);
            ps = con.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);

            setPreparedStatement1(copia, ps);

            ps.executeUpdate();

            ResultSet rs_teste = ps.getGeneratedKeys();
            if (rs_teste.next()) {

            }
            copia.setCodigo_copia(rs_teste.getInt(1));
            ps.close();
            return copia;
        } finally {
            pool.liberarConnection(con);
        }

    }

    private void setPreparedStatement(Copia copia, PreparedStatement ps)
            throws SQLException {
        Date data_aquisicao = null;
        if (copia.getData_aquisicao() != null) {
            data_aquisicao = new Date(copia.getData_aquisicao().getTime());
        }

        ps.setString(1, copia.getIdioma());
        ps.setString(2, copia.getLegenda());
        ps.setDate(3, data_aquisicao);
        ps.setDouble(4, copia.getPreco_custo());
        ps.setInt(5, copia.getObjeto().getCodigo_objeto());
    }

    private void setPreparedStatement1(Copia copia, PreparedStatement ps)
            throws SQLException {
        Date data_aquisicao = null;
        if (copia.getData_aquisicao() != null) {
            data_aquisicao = new Date(copia.getData_aquisicao().getTime());
        }
        ps.setString(1, copia.getIdioma());
        ps.setString(2, copia.getLegenda());
        ps.setDate(3, data_aquisicao);
        ps.setDouble(4, copia.getPreco_custo());
        ps.setInt(5, copia.getObjeto().getCodigo_objeto());
        ps.setInt(6, copia.getNumero_copia());
        ps.setString(7, copia.getCodigo_barras());
    }

    public List<Copia> getCopias() throws SQLException {
        List<Copia> resultado = new ArrayList<Copia>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM CLIENTE ORDER BY NOME_CLIENTE;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();

            resultado = getListaCopia(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

}
