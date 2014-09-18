package br.com.locadora.model.command;

import java.sql.SQLException;



public class CadastrarProduto implements InterfaceCommand {

	private InterfaceProdutoDAO produtoDAO;
	
	
	public CadastrarProduto(InterfaceProdutoDAO produtoDAO) {
		super();
		this.produtoDAO = produtoDAO;
	}


	
	public String execute() {
//		
//		try {
//			Produto produto = new Produto();
//			produto.setDescricao(request.getParameter("descricao"));
//
//			produtoDAO.salvar(produto);
//			request.setAttribute("mensagem", "Produto ("+produto.getDescricao()+") gravado com sucesso!");
//		} catch (SQLException e) {
//			request.setAttribute("mensagem", "Problemas com a grava��o: "+e.getMessage());			
//			e.printStackTrace();
//		}catch (NumberFormatException e) {
//			request.setAttribute("mensagem", "Valor inv�lido: "+e.getMessage());			
//			e.printStackTrace();
//		}
//		request.setAttribute("titulo", "Cadastro - Pe�as e Servi�os");
		return "SiscomController?cmd=editarProduto";
	}

}
