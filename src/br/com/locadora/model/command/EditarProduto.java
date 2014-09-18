package br.com.locadora.model.command;

import java.sql.SQLException;

public class EditarProduto implements InterfaceCommand {

	private InterfaceProdutoDAO produtoDAO;
	
	public EditarProduto(InterfaceProdutoDAO produtoDAO) {
		super();
		this.produtoDAO = produtoDAO;
	}

	
	public String execute() {
//		
//		if(request.getParameter("codigo") == null)
//		{
//			request.setAttribute("titulo", "Cadastro - Pe�as e Servi�os");
//			return "cadastro_produto.jsp";
//		}
//		
//		try {
//			request.setAttribute("produto", produtoDAO.getProduto(Integer.valueOf(request.getParameter("codigo"))));
//		} catch (NumberFormatException e) {
//			request.setAttribute("mensagem", "Valor do c�digo inv�lido: "+request.getParameter("codigo"));
//		} catch (SQLException e) {
//			request.setAttribute("mensagem", "Problema com o acesso a base de dados: "+e.getMessage());
//			e.printStackTrace();
//		}
//		request.setAttribute("titulo", "Atualiza��o - Pe�as e Servi�os");
//		
		return "atualiza_produto.jsp";
	}

}
