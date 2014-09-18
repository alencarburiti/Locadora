package br.com.locadora.model.command;

import java.sql.SQLException;



public class AtualizarProduto implements InterfaceCommand {

	private InterfaceProdutoDAO produtoDAO;
	
	public AtualizarProduto(InterfaceProdutoDAO produtoDAO) {
		super();
		this.produtoDAO = produtoDAO;
	}
	
	public String execute() {
//		try {
//			Produto produto = new Produto();			
//			produto.setCodigo(Integer.valueOf(request.getParameter("codigo")));
//			produto.setDescricao(request.getParameter("descricao"));
//			
//			produtoDAO.atualizar(produto);
//			request.setAttribute("mensagem", "Pe�a / Servi�o ("+produto.getDescricao()+") atualizado com sucesso!");			
//		} catch (SQLException e) {
//			request.setAttribute("mensagem", "Problemas com a atualiza��o: "+e.getMessage());
//			e.printStackTrace();
//		} catch (NumberFormatException e){
//			request.setAttribute("mensagem", "Valor inv�lido: "+e.getMessage());
//			e.printStackTrace();
//		}
//		request.setAttribute("titulo", "Atualiza��o - Pe�as e Servi�os");		
		return "SiscomController?cmd=consultarProduto";	}

}
