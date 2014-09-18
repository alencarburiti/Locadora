package br.com.locadora.model.command;

import java.sql.SQLException;

public class ConsultarProduto implements InterfaceCommand {

	private InterfaceProdutoDAO produtoDAO;
	
	public ConsultarProduto(InterfaceProdutoDAO produtoDAO) {
		super();
		this.produtoDAO = produtoDAO;
	}

	public String execute() {
//		request.setAttribute("titulo", "Consulta - Pe�as e Servi�os");
//		
//		try {
//			request.setAttribute("produtos", produtoDAO.getProdutos());
//		} catch (SQLException e) {
//			request.setAttribute("mensagem", "Problemas com acesso a base de dados!");
//			e.printStackTrace();
//		}
//		
		return "consulta_produto.jsp";
	}

}
