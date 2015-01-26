package br.com.locadora.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.bean.ItemPacotePromocional;
import br.com.locadora.model.bean.ItemVenda;
import br.com.locadora.model.bean.PacotePromocional;
import br.com.locadora.model.bean.Produto;
import br.com.locadora.model.bean.Venda;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendaDAO {

    private InterfacePool pool;

    public VendaDAO(InterfacePool pool) {
        this.pool = pool;
    }
    
    public List<ItemVenda> getProdutoPacoteDescricao(String descricao) {        
        List<ItemVenda> resultado = new ArrayList<ItemVenda>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "(SELECT \n" +
            "    NOME_PRODUTO AS DESCRICAO,\n" +
            "    CODIGO_PRODUTO AS CODIGO,\n" +
            "    CODIGO_BARRAS,\n" +
            "    PRECO_VENDA AS VALOR,\n" +
            "    DEL_FLAG,\n" +
            "    1 AS TYPE_PRODUCT\n" +
            "FROM\n" +
            "    PRODUTO WHERE NOME_PRODUTO LIKE ? AND DEL_FLAG = 0) UNION ALL (SELECT \n" +
            "    DESCRICAO,\n" +
            "    CODIGO_PACOTE_PROMOCIONAL AS CODIGO,\n" +
            "    '' AS CODIGO_BARRAS,\n" +
            "    VALOR,\n" +
            "    DEL_FLAG,\n" +
            "    0 AS TYPE_PRODUCT\n" +
            "FROM\n" +
            "    PACOTE_PROMOCIONAL WHERE DESCRICAO LIKE ? AND DEL_FLAG = 0)";
        
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%"+descricao+"%");
            ps.setString(2, "%"+descricao+"%");

            rs = ps.executeQuery();

            resultado = getListaProdutoPacotePromocional(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    public List<ItemVenda> getProdutoPacoteCodigoBarras(String codigo_barras) {        
        List<ItemVenda> resultado = new ArrayList<ItemVenda>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "(SELECT \n" +
            "    NOME_PRODUTO AS DESCRICAO,\n" +
            "    CODIGO_PRODUTO AS CODIGO,\n" +
            "    CODIGO_BARRAS,\n" +
            "    PRECO_VENDA AS VALOR,\n" +
            "    DEL_FLAG,\n" +
            "    1 AS TYPE_PRODUCT\n" +
            "FROM\n" +
            "    PRODUTO WHERE CODIGO_BARRAS = ? AND DEL_FLAG = 0) UNION ALL (SELECT \n" +
            "    DESCRICAO,\n" +
            "    CODIGO_PACOTE_PROMOCIONAL AS CODIGO,\n" +
            "    '' AS CODIGO_BARRAS,\n" +
            "    VALOR,\n" +
            "    DEL_FLAG,\n" +
            "    0 AS TYPE_PRODUCT\n" +
            "FROM\n" +
            "    PACOTE_PROMOCIONAL WHERE CODIGO_BARRAS = ? AND DEL_FLAG = 0)";
        
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, codigo_barras);
            ps.setString(2, codigo_barras);

            rs = ps.executeQuery();

            resultado = getListaProdutoPacotePromocional(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

//    public List<PacotePromocional> getPacotePromocionalDescricao(String descricao) {        
//        List<PacotePromocional> resultado = new ArrayList<PacotePromocional>();
//        Connection con = pool.getConnection();
//        PreparedStatement ps = null;
//        String sqlSelect = "SELECT * FROM PACOTE_PROMOCIONAL WHERE DESCRICAO LIKE ? ORDER BY DESCRICAO LIMIT 0, 50;";
//        ResultSet rs = null;
//
//        try {
//            ps = con.prepareStatement(sqlSelect);
//            ps.setString(1, "%"+descricao+"%");
//
//            rs = ps.executeQuery();
//
//            resultado = getListaPacotePromocional(rs);
//
//            rs.close();
//            ps.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            pool.liberarConnection(con);
//        }
//        return resultado;
//    }
    
    public List<ItemPacotePromocional> getItensPacotePromocional(Integer codigo_pacote_promocional) throws SQLException {        
        List<ItemPacotePromocional> resultado = new ArrayList<ItemPacotePromocional>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM PACOTE_PROMOCIONAL A, ITEM_PACOTE_PROMOCIONAL B, DIARIA C "
                + "WHERE A.CODIGO_PACOTE_PROMOCIONAL = B.PACOTE_PROMOCIONAL_CODIGO_PACOTE_PROMOCIONAL "
                + "AND B.DIARIA_CODIGO_DIARIA = C.CODIGO_DIARIA AND B.PACOTE_PROMOCIONAL_CODIGO_PACOTE_PROMOCIONAL = ? "
                + " ORDER BY NOME_DIARIA LIMIT 0, 50;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo_pacote_promocional);

            rs = ps.executeQuery();

            resultado = getListaItemPacotePromocional(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    private List<PacotePromocional> getListaPacotePromocional(ResultSet rs) throws SQLException {
        List<PacotePromocional> resultado = new ArrayList<PacotePromocional>();
        while (rs.next()) {
            PacotePromocional pacotePromocional = new PacotePromocional();
            pacotePromocional.setCodigo_pacote_promocioanl(rs.getInt("CODIGO_PACOTE_PROMOCIONAL"));
            pacotePromocional.setDescricao(rs.getString("DESCRICAO"));
            pacotePromocional.setQuantidade_troca(rs.getInt("QUANTIDADE_VEZ"));
            pacotePromocional.setQuantidade_mes(rs.getInt("QUANTIDADE_MES"));
            pacotePromocional.setValor(rs.getDouble("VALOR"));

            if(rs.getInt("DEL_FLAG") == 0){
                pacotePromocional.setStatus(true);                
            } else {
                pacotePromocional.setStatus(false);                
            }
            
            resultado.add(pacotePromocional);
        }
        return resultado;
    }
    
    private List<ItemVenda> getListaProdutoPacotePromocional(ResultSet rs) throws SQLException {
        List<ItemVenda> resultado = new ArrayList<ItemVenda>();
        while (rs.next()) {
            ItemVenda itemVenda = new ItemVenda();
            itemVenda.setType_product(Integer.parseInt(rs.getString("TYPE_PRODUCT")));
            System.out.println("Type Product: "+ rs.getString("TYPE_PRODUCT"));
            if(rs.getInt("TYPE_PRODUCT") == 0){      
                PacotePromocional pacotePromocional = new PacotePromocional();
                pacotePromocional.setCodigo_pacote_promocioanl(rs.getInt("CODIGO"));
                pacotePromocional.setDescricao(rs.getString("DESCRICAO"));
                pacotePromocional.setCodigo_barras(rs.getString("CODIGO_BARRAS"));                
                pacotePromocional.setValor(rs.getDouble("VALOR"));
                if(rs.getInt("DEL_FLAG") == 0){
                    pacotePromocional.setStatus(true);
                } else {
                    pacotePromocional.setStatus(false);
                }                
                itemVenda.setPacotePromocional(pacotePromocional);                
            } else if(rs.getInt("TYPE_PRODUCT") == 1){
                Produto produto = new Produto();
                produto.setCodigo_produto(rs.getInt("CODIGO"));
                produto.setNome_produto(rs.getString("DESCRICAO"));
                produto.setCodigo_barras(rs.getString("CODIGO_BARRAS"));                
                produto.setPreco_venda(rs.getDouble("VALOR"));
                if(rs.getInt("DEL_FLAG") == 0){
                    produto.setStatus(true);
                } else {
                    produto.setStatus(false);
                }                
                itemVenda.setProduto(produto);                
            }            
            resultado.add(itemVenda);
        }
        return resultado;
    }
    
    private List<ItemPacotePromocional> getListaItemPacotePromocional(ResultSet rs) throws SQLException {
        List<ItemPacotePromocional> resultado = new ArrayList<ItemPacotePromocional>();
        while (rs.next()) {
            ItemPacotePromocional itemPacotePromocional = new ItemPacotePromocional();
            itemPacotePromocional.setCodigo_item_pacote_promocional(rs.getInt("CODIGO_ITEM_PACOTE_PROMOCIONAL"));
            PacotePromocional pacotePromocional = new PacotePromocional();
            pacotePromocional.setCodigo_pacote_promocioanl(rs.getInt("CODIGO_PACOTE_PROMOCIONAL"));
            
            Diaria diaria = new Diaria();
            diaria.setCodigo_diaria(rs.getInt("CODIGO_DIARIA"));
            diaria.setNome_diaria(rs.getString("NOME_DIARIA"));
            diaria.setDias(rs.getInt("DIAS"));
            diaria.setValor(rs.getDouble("VALOR"));
            
            itemPacotePromocional.setPacotePromocional(pacotePromocional);
            itemPacotePromocional.setDiaria(diaria);

            resultado.add(itemPacotePromocional);
        }
        return resultado;
    }
    

    
    public Venda salvar(Venda venda) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO `locadora`.`venda` ( `dependente_codigo_dependente`, usuario_codigo_usuario) VALUES (?,?);";

        try {
            ps = con.prepareStatement(sqlInsert);

            setPreparedStatement(venda, ps);

            ps.executeUpdate();
            ResultSet res;
            Integer codigo_max;
            String sql_max = "SELECT MAX(CODIGO_VENDA) FROM VENDA";

            ps = con.prepareStatement(sql_max);
            res = ps.executeQuery();
            res.next();
            codigo_max = res.getInt("MAX(CODIGO_VENDA)");
            venda.setCodigo_venda(codigo_max);

            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return venda;
    }
    
    public Venda salvarItens(List<ItemVenda> itens, Venda venda) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO `locadora`.`ITEM_VENDA` (`VENDA_CODIGO_VENDA`,\n" +
            "`TYPE_PRODUCT`,`QUANTIDADE`,`PRECO_TOTAL`,\n" +
            "`PACOTE_PROMOCIONAL_CODIGO_PACOTE_PROMOCIONAL`,\n" +
            "`PRODUTO_CODIGO_PRODUTO`, data_lancamento)VALUES(?,?,?,?,?,?, CURRENT_DATE());";

        try {
            ps = con.prepareStatement(sqlInsert);

            for(int i =0; i < itens.size(); i++){
                ps.setInt(1, venda.getCodigo_venda());
                ps.setInt(2, itens.get(i).getType_product());
                ps.setInt(3, itens.get(i).getQuantidade());
                ps.setDouble(4, itens.get(i).getPreco_total());
                if(itens.get(i).getType_product() == 0){
                    ps.setInt(5, itens.get(i).getPacotePromocional().getCodigo_pacote_promocioanl());
                    ps.setInt(6, 0);
                } else if(itens.get(i).getType_product() == 1){
                    ps.setInt(5, 0);
                    ps.setInt(6, itens.get(i).getProduto().getCodigo_produto());
                }
                ps.executeUpdate();
            }

            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return venda;
    }
    
//    public void salvarItem(ItemPacotePromocional itemPacotePromocional) throws SQLException {
//        Connection con = pool.getConnection();
//        PreparedStatement ps;
//
//        String sqlInsert = "INSERT INTO `locadora`.`ITEM_PACOTE_PROMOCIONAL`\n" +
//            "( `PACOTE_PROMOCIONAL_CODIGO_PACOTE_PROMOCIONAL`, `DIARIA_CODIGO_DIARIA`) VALUES (? , ? );";
//
//        try {
//            ps = con.prepareStatement(sqlInsert);
//            
//            ps.setInt(1, itemPacotePromocional.getPacotePromocional().getCodigo_pacote_promocioanl());
//            ps.setInt(2, itemPacotePromocional.getDiaria().getCodigo_diaria());                        
//
//            ps.executeUpdate();            
//
//            ps.close();
//        } finally {
//            pool.liberarConnection(con);
//        }
//        
//    }

    private void setPreparedStatement(Venda venda, PreparedStatement ps)
            throws SQLException {

        ps.setInt(1, venda.getDependente().getCodigo_dependente());
        ps.setInt(2, venda.getUsuario().getCodigo_usuario());        

    }

//    private void setPreparedStatement1(PacotePromocional pacotePromocional, PreparedStatement ps)
//            throws SQLException {
//        ps.setString(1, pacotePromocional.getDescricao());
//        ps.setInt(2, pacotePromocional.getQuantidade_troca());
//        ps.setInt(3, pacotePromocional.getQuantidade_mes());
//        ps.setDouble(4, pacotePromocional.getValor());
//        if(pacotePromocional.getStatus() == true){
//            ps.setInt(5, 0);
//        } else {
//            ps.setInt(5, 1);
//        }
//        ps.setInt(6, pacotePromocional.getCodigo_pacote_promocioanl());
//    }

}
