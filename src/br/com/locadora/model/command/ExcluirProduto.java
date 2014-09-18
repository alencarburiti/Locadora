package br.com.locadora.model.command;

import java.sql.SQLException;



public class ExcluirProduto implements InterfaceCommand {

	private InterfaceProdutoDAO produtoDAO;
	
	public ExcluirProduto(InterfaceProdutoDAO produtoDAO) {
		super();
		this.produtoDAO = produtoDAO;
	}
	
	public String execute() {
//
//		try {
//			produtoDAO.excluir(Integer.valueOf(request.getParameter("codigo")));
//			request.setAttribute("mensagem", "Pe�a / Servi�o exclu�do com sucesso!");
//		} catch (NumberFormatException e) {
//			request.setAttribute("mensagem", "C�digo inv�lido: "+request.getParameter("codigo"));			
//			e.printStackTrace();
//		} catch (SQLException e) {
//			request.setAttribute("mensagem", "Problemas com a base de dados: "+e.getMessage());			
//			e.printStackTrace();
//		}
//		request.setAttribute("titulo", "Consulta - produtoDAO");
		return "SiscomController?cmd=consultarProduto";
	}

}
