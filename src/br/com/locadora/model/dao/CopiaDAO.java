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
import java.util.ArrayList;
import java.util.List;

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
    public void excluir(Integer codigo) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlExcluir = "DELETE FROM DIARIA WHERE CODIGO_DIARIA = ?;";

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
    public List<Copia> getCopia(Integer codigo_interno) throws SQLException {
        List<Copia> resultado = new ArrayList<Copia>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n"
                + "	A.CODIGO_COPIA, \n"
                + "    A.CODIGO_INTERNO,\n"
                + "    A.DEL_FLAG,\n"
                + "    B.DESCRICAO_OBJETO,\n"
                + "    B.TIPO_MOVIMENTO,\n"
                + "    B.TIPO_MIDIA,\n"
                + "    A.LOCALIZACAO,\n"
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
                + "		AND A.CODIGO_INTERNO = ?;";

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
    
    
    public List<Copia> getCopia_titulo(String titulo) throws SQLException {
        List<Copia> resultado = new ArrayList<Copia>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n"
                + "	A.CODIGO_COPIA, \n"
                + "    A.CODIGO_INTERNO,\n"
                + "    A.DEL_FLAG,\n"
                + "    B.DESCRICAO_OBJETO,\n"
                + "    B.TIPO_MOVIMENTO,\n"
                + "    B.TIPO_MIDIA,\n"
                + "    A.LOCALIZACAO,\n"
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
                + "		AND B.TITULO_ORIGINAL LIKE ?;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%"+titulo+"%");

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
                + "    A.CODIGO_INTERNO,\n"
                + "    A.DEL_FLAG,\n"
                + "    B.DESCRICAO_OBJETO,\n"
                + "    B.TIPO_MOVIMENTO,\n"
                + "    B.TIPO_MIDIA,\n"
                + "    A.LOCALIZACAO,\n"
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
                + "		AND B.ELENCO LIKE ?;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%"+ator+"%");

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
            
            objeto.setDiaria(diaria);
            copia.setObjeto(objeto);
            
            copia.setCodigo_copia(rs.getInt("CODIGO_COPIA"));
            copia.setCodigo_interno(rs.getInt("CODIGO_INTERNO"));
            copia.setIdioma(rs.getString("IDIOMA"));
            copia.setLegenda(rs.getString("LEGENDA"));
            copia.setLocalizacao(rs.getString("LOCALIZACAO"));
            if(rs.getInt("DEL_FLAG")== 0){
                copia.setStatus("Disponivel");
            }else{
                copia.setStatus("Indisponivel");
            }
            
            
            resultado.add(copia);
        }
        return resultado;
    }

    @Override
    public void salvar(Copia copia) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO `locadora`.`COPIA`(`CODIGO_INTERNO`,"
                + "`LOCALIZACAO`,`IDIOMA`,`LEGENDA`,`DATA_AQUISICAO`,"
                + "`PRECO_CUSTO`,`CODIGO_OBJETO`)VALUES(?,?,?,?,?,?,?);";

        try {
            ps = con.prepareStatement(sqlInsert);

            setPreparedStatement1(copia, ps);

            ps.executeUpdate();
            ps.close();
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

        ps.setInt(1, copia.getCodigo_interno());
        ps.setString(2, copia.getLocalizacao());
        ps.setString(3, copia.getIdioma());
        ps.setString(4, copia.getLegenda());
        ps.setDate(5, data_aquisicao);
        ps.setDouble(6, copia.getPreco_custo());
        ps.setInt(7, copia.getObjeto().getCodigo_objeto());
    }

    private void setPreparedStatement1(Copia copia, PreparedStatement ps)
            throws SQLException {
        Date data_aquisicao = null;
        if (copia.getData_aquisicao() != null) {
            data_aquisicao = new Date(copia.getData_aquisicao().getTime());
        }

        ps.setInt(1, copia.getCodigo_interno());
        ps.setString(2, copia.getLocalizacao());
        ps.setString(3, copia.getIdioma());
        ps.setString(4, copia.getLegenda());
        ps.setDate(5, data_aquisicao);
        ps.setDouble(6, copia.getPreco_custo());
        ps.setInt(7, copia.getObjeto().getCodigo_objeto());
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
