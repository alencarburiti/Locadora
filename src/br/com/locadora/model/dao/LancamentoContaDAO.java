/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model.dao;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.Fornecedor;
import br.com.locadora.model.bean.LancamentoConta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALENCAR
 */
public class LancamentoContaDAO {

    private InterfacePool pool;

    public LancamentoContaDAO(InterfacePool pool) {
        this.pool = pool;
    }

    
    public void salvar(LancamentoConta lancamentoConta) {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO `locadora`.`lancamento_conta`(`DESCRICAO`,`DOCUMENTO`,`VALOR_A_PAGAR`,\n" +
            "`VALOR_PAGO`,`DATA_LANCAMENTO`,`DATA_VENCIMENTO`,`DATA_PAGAMENTO`,\n" +
            "`FORNECEDOR_CODIGO_FORNECEDOR`) VALUES(?,?,?,?,current_date(),?,?,?);";

        try {
            ps = con.prepareStatement(sqlInsert);

            setPreparedStatement(lancamentoConta, ps);

            ps.executeUpdate();
            
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(LancamentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }        
    }

    public void atualizar(LancamentoConta lancamentoConta) {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlUpdate = "UPDATE `locadora`.`lancamento_conta` SET `DESCRICAO` = ?,`DOCUMENTO` = ?,\n" +
            "`VALOR_A_PAGAR` = ?,`VALOR_PAGO` = ?,`DATA_VENCIMENTO` = ?,\n" +
            "`DATA_PAGAMENTO` = ?,`FORNECEDOR_CODIGO_FORNECEDOR` = ? WHERE `CODIGO_LANCAMENTO_CONTA` = ?;";
        try {
            ps = con.prepareStatement(sqlUpdate);

            setPreparedStatement1(lancamentoConta, ps);

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(LancamentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
    }

    
    public void excluir(Integer codigo) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlExcluir = "DELETE FROM LANCAMENTO_CONTA WHERE CODIGO_LANCAMENTO_CONTA = ?;";

        try {
            ps = con.prepareStatement(sqlExcluir);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
    }
    
    public List<LancamentoConta> getLancamentoContas(String dataInicial, String dataFinal) {
        List<LancamentoConta> resultado = new ArrayList<LancamentoConta>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM locadora.lancamento_conta A, FORNECEDOR B WHERE A.FORNECEDOR_CODIGO_FORNECEDOR = B.CODIGO_FORNECEDOR "
                + "AND  DATA_VENCIMENTO BETWEEN ? AND ? ORDER BY DATA_VENCIMENTO ;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, dataInicial);
            ps.setString(2, dataFinal);

            rs = ps.executeQuery();

            resultado = getListaLancamentoContas(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }        

//    public boolean excluiFornecedor(Fornecedor fornecedor) {
//
//        try {
//            Conexao conexao = new Conexao();
//            pstm = (PreparedStatement) conexao.conecta().prepareStatement(excluiFornecedor);
//            pstm.setInt(1, fornecedor.getCod_fornecedor());
//            pstm.executeUpdate();
//            conexao.desconecta();
//            return true;
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Este registro não pode ser excluído pois está referenciado em outra tabela");
//            return false;
//        }
//    }
//
//    public List<Fornecedor> listarForncedor(String razao_social) {
//        List<Fornecedor> fornecedor = new ArrayList();
//        try {
//            ResultSet rs;
//            Conexao conexao = new Conexao();
//            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaFornecedor);
//            pstm.setString(1, razao_social);
//            rs = pstm.executeQuery();
//            Fornecedor forn;
//            while (rs.next()) {
//                forn = new Fornecedor();
//                forn.setCod_fornecedor(rs.getInt("idfornecedor"));
//                forn.setRazao_social(rs.getString("razaoSocial"));
//                forn.setNome_fantasia(rs.getString("nomeFantasia"));
//                forn.setCNPJ(rs.getString("cnpj"));
//                forn.setTelefone(rs.getString("telefone"));
//                forn.setFax(rs.getString("fax"));
//                forn.setEndereço(rs.getString("endereco"));
//                forn.setInsc_estadual(rs.getString("inscricaoEstadual"));
//                forn.setInsc_municipal(rs.getString("inscricaoMunicipal"));
//                forn.setNome_vendedor(rs.getString("nomeVendedor"));
//                forn.setTel_vendedor(rs.getString("telefoneVendedor"));
//                forn.setCEP(rs.getString("cep"));
//                forn.setEstado(rs.getString("estado"));
//                forn.setCidade(rs.getString("cidade"));
//                fornecedor.add(forn);
//
//            }
//            conexao.desconecta();
//            rs.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return fornecedor;
//    }
//
//    public List<Fornecedor> listarForncedorCodigo(String cod_fornecedor) {
//        List<Fornecedor> fornecedor = new ArrayList();
//        try {
//            ResultSet rs;
//            Conexao conexao = new Conexao();
//            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaFornecedorCodigo);
//            pstm.setString(1, cod_fornecedor);
//            rs = pstm.executeQuery();
//            Fornecedor forn;
//            while (rs.next()) {
//                forn = new Fornecedor();
//                forn.setCod_fornecedor(rs.getInt("idfornecedor"));
//                forn.setRazao_social(rs.getString("razaoSocial"));
//                forn.setNome_fantasia(rs.getString("nomeFantasia"));
//                forn.setCNPJ(rs.getString("cnpj"));
//                forn.setTelefone(rs.getString("telefone"));
//                forn.setFax(rs.getString("fax"));
//                forn.setEndereço(rs.getString("endereco"));
//                forn.setInsc_estadual(rs.getString("inscricaoEstadual"));
//                forn.setInsc_municipal(rs.getString("inscricaoMunicipal"));
//                forn.setNome_vendedor(rs.getString("nomeVendedor"));
//                forn.setTel_vendedor(rs.getString("telefoneVendedor"));
//                forn.setCEP(rs.getString("cep"));
//                forn.setEstado(rs.getString("estado"));
//                forn.setCidade(rs.getString("cidade"));
//                fornecedor.add(forn);
//
//            }
//            conexao.desconecta();
//            rs.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return fornecedor;
//    }
//
//    public List<Fornecedor> listarForncedorDescricao(String razao_social) {
//        List<Fornecedor> fornecedor = new ArrayList();
//        try {
//            ResultSet rs;
//            Conexao conexao = new Conexao();
//            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaFornecedorDescricao);
//            pstm.setString(1, razao_social);
//            rs = pstm.executeQuery();
//            Fornecedor forn;
//            while (rs.next()) {
//                forn = new Fornecedor();
//                forn.setCod_fornecedor(rs.getInt("idfornecedor"));
//                forn.setRazao_social(rs.getString("razaoSocial"));
//                forn.setNome_fantasia(rs.getString("nomeFantasia"));
//                forn.setCNPJ(rs.getString("cnpj"));
//                forn.setTelefone(rs.getString("telefone"));
//                forn.setFax(rs.getString("fax"));
//                forn.setEndereço(rs.getString("endereco"));
//                forn.setInsc_estadual(rs.getString("inscricaoEstadual"));
//                forn.setInsc_municipal(rs.getString("inscricaoMunicipal"));
//                forn.setNome_vendedor(rs.getString("nomeVendedor"));
//                forn.setTel_vendedor(rs.getString("telefoneVendedor"));
//                forn.setCEP(rs.getString("cep"));
//                forn.setEstado(rs.getString("estado"));
//                forn.setCidade(rs.getString("cidade"));
//                fornecedor.add(forn);
//
//            }
//            conexao.desconecta();
//            rs.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return fornecedor;
//    }
//
//    public List<Fornecedor> listarForncedorDescricao1(String razao_social, String cnpj) {
//        List<Fornecedor> fornecedor = new ArrayList();
//        try {
//            ResultSet rs;
//            Conexao conexao = new Conexao();
//            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaFornecedorDescricao1);
//            pstm.setString(1, razao_social);
//            pstm.setString(2, cnpj);
//            rs = pstm.executeQuery();
//            Fornecedor forn;
//            while (rs.next()) {
//                forn = new Fornecedor();
//                forn.setCod_fornecedor(rs.getInt("idfornecedor"));
//                forn.setRazao_social(rs.getString("razaoSocial"));
//                forn.setNome_fantasia(rs.getString("nomeFantasia"));
//                forn.setCNPJ(rs.getString("cnpj"));
//                forn.setTelefone(rs.getString("telefone"));
//                forn.setFax(rs.getString("fax"));
//                forn.setEndereço(rs.getString("endereco"));
//                forn.setInsc_estadual(rs.getString("inscricaoEstadual"));
//                forn.setInsc_municipal(rs.getString("inscricaoMunicipal"));
//                forn.setNome_vendedor(rs.getString("nomeVendedor"));
//                forn.setTel_vendedor(rs.getString("telefoneVendedor"));
//                forn.setCEP(rs.getString("cep"));
//                forn.setEstado(rs.getString("estado"));
//                forn.setCidade(rs.getString("cidade"));
//                fornecedor.add(forn);
//
//            }
//            conexao.desconecta();
//            rs.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return fornecedor;
//    }
//
//    public List<Fornecedor> listarForncedores() {
//        List<Fornecedor> fornecedor = new ArrayList();
//        try {
//            ResultSet rs;
//            Conexao conexao = new Conexao();
//            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
//            rs = pstm.executeQuery();
//            Fornecedor forn;
//            while (rs.next()) {
//                forn = new Fornecedor();
//                forn.setCod_fornecedor(rs.getInt("idfornecedor"));
//                forn.setRazao_social(rs.getString("razaoSocial"));
//                forn.setNome_fantasia(rs.getString("nomeFantasia"));
//                forn.setCNPJ(rs.getString("cnpj"));
//                forn.setTelefone(rs.getString("telefone"));
//                forn.setFax(rs.getString("fax"));
//                forn.setEndereço(rs.getString("endereco"));
//                forn.setInsc_estadual(rs.getString("inscricaoEstadual"));
//                forn.setInsc_municipal(rs.getString("inscricaoMunicipal"));
//                forn.setNome_vendedor(rs.getString("nomeVendedor"));
//                forn.setTel_vendedor(rs.getString("telefoneVendedor"));
//                forn.setCEP(rs.getString("cep"));
//                forn.setEstado(rs.getString("estado"));
//                forn.setCidade(rs.getString("cidade"));
//                fornecedor.add(forn);
//
//            }
//            conexao.desconecta();
//            rs.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return fornecedor;
//    }
//
//    public List<Fornecedor> consultaCNPJ(String cnpj) {
//        List<Fornecedor> fornecedor = new ArrayList();
//        try {
//            ResultSet rs;
//            Conexao conexao = new Conexao();
//            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultacnpj);
//            pstm.setString(1, cnpj);
//            rs = pstm.executeQuery();
//            Fornecedor forn;
//            while (rs.next()) {
//                forn = new Fornecedor();
//                forn.setCod_fornecedor(rs.getInt("idfornecedor"));
//                forn.setRazao_social(rs.getString("razaoSocial"));
//                forn.setNome_fantasia(rs.getString("nomeFantasia"));
//                forn.setCNPJ(rs.getString("cnpj"));
//                forn.setTelefone(rs.getString("telefone"));
//                forn.setFax(rs.getString("fax"));
//                forn.setEndereço(rs.getString("endereco"));
//                forn.setInsc_estadual(rs.getString("inscricaoEstadual"));
//                forn.setInsc_municipal(rs.getString("inscricaoMunicipal"));
//                forn.setNome_vendedor(rs.getString("nomeVendedor"));
//                forn.setTel_vendedor(rs.getString("telefoneVendedor"));
//                forn.setCEP(rs.getString("cep"));
//                forn.setEstado(rs.getString("estado"));
//                forn.setCidade(rs.getString("cidade"));
//                fornecedor.add(forn);
//
//            }
//            conexao.desconecta();
//            rs.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return fornecedor;
//    }
    private void setPreparedStatement(LancamentoConta lancamentoConta, PreparedStatement ps)
            throws SQLException {
        
        Date data_vencimento = null;
        Date data_pagamento = null;
        if (lancamentoConta.getData_vencimento()!= null) {
            data_vencimento = new Date(lancamentoConta.getData_vencimento().getTime());
        }
        if (lancamentoConta.getData_pagamento()!= null) {
            data_pagamento = new Date(lancamentoConta.getData_pagamento().getTime());
        }
        ps.setString(1, lancamentoConta.getDescricao());
        ps.setString(2, lancamentoConta.getDocumento());
        ps.setDouble(3, lancamentoConta.getValor());
        ps.setDouble(4, lancamentoConta.getValorPago());
        ps.setDate(5, data_vencimento);
        ps.setDate(6, data_pagamento);
        ps.setInt(7, lancamentoConta.getFornecedor().getCodigo_fornecedor());
        
    }

    private void setPreparedStatement1(LancamentoConta lancamentoConta, PreparedStatement ps)
            throws SQLException {
        
        Date data_vencimento = null;
        Date data_pagamento = null;
        if (lancamentoConta.getData_vencimento()!= null) {
            data_vencimento = new Date(lancamentoConta.getData_vencimento().getTime());
        }
        if (lancamentoConta.getData_pagamento()!= null) {
            data_pagamento = new Date(lancamentoConta.getData_pagamento().getTime());
        }
        ps.setString(1, lancamentoConta.getDescricao());
        ps.setString(2, lancamentoConta.getDocumento());
        ps.setDouble(3, lancamentoConta.getValor());
        ps.setDouble(4, lancamentoConta.getValorPago());
        ps.setDate(5, data_vencimento);
        ps.setDate(6, data_pagamento);
        ps.setInt(7, lancamentoConta.getFornecedor().getCodigo_fornecedor());
        ps.setInt(8, lancamentoConta.getCodigo_lancamento_contas());
        
    }


    private List<LancamentoConta> getListaLancamentoContas(ResultSet rs) throws SQLException {
        List<LancamentoConta> resultado = new ArrayList<LancamentoConta>();
        while (rs.next()) {
            LancamentoConta lancamentosContas = new LancamentoConta();
            lancamentosContas.setCodigo_lancamento_contas(rs.getInt("CODIGO_LANCAMENTO_CONTA"));
            lancamentosContas.setDescricao(rs.getString("DESCRICAO"));
            lancamentosContas.setDocumento(rs.getString("DOCUMENTO"));
            lancamentosContas.setValor(rs.getDouble("VALOR_A_PAGAR"));
            lancamentosContas.setValorPago(rs.getDouble("VALOR_PAGO"));
            lancamentosContas.setData_vencimento(rs.getDate("DATA_VENCIMENTO"));
            lancamentosContas.setData_pagamento(rs.getDate("DATA_PAGAMENTO"));
            
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setCodigo_fornecedor(rs.getInt("CODIGO_FORNECEDOR"));
            fornecedor.setNome_fantasia(rs.getString("NOME_FANTASIA"));
            lancamentosContas.setFornecedor(fornecedor);
            resultado.add(lancamentosContas);
        }
        return resultado;
    }
}
