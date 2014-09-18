package br.com.locadora.model.command;

import br.com.locadora.model.dao.InterfaceUsuarioDAO;
import java.sql.SQLException;



public class CadastrarUsuario implements InterfaceCommand {

	private InterfaceUsuarioDAO usuarioDAO;

	public CadastrarUsuario(InterfaceUsuarioDAO usuarioDAO) {
		super();
		this.usuarioDAO = usuarioDAO;
	}

	
	public String execute() {
//		try {
//			Usuario usuario = new Usuario();
//
//			usuario.setAcesso(request.getParameter("acesso"));
//			usuario.setNome(request.getParameter("nome"));
//			usuario.setCargo(request.getParameter("cargo"));
//			usuario.setDepartamento(request.getParameter("departamento"));
//			usuario.setEmail(request.getParameter("email"));
//			usuario.setTelefone(request.getParameter("telefone"));
//			usuario.setLogin(request.getParameter("login"));
//			usuario.setSenha(request.getParameter("senha"));
//
//			usuarioDAO.salvar(usuario);
//			request.setAttribute("mensagem",
//					"Usu�rio (" + usuario.getNome()
//							+ ") gravado com sucesso!");
//		} catch (SQLException e) {
//			request.setAttribute("mensagem",
//					"Problemas com a grava��o: " + e.getMessage());
//			e.printStackTrace();
//		} catch (NumberFormatException e) {
//			request.setAttribute("mensagem",
//					"Valor inv�lido: " + e.getMessage());
//			e.printStackTrace();
//		}
//		request.setAttribute("titulo", "Cadastro - Usu�rio");

		return "SiscomController?cmd=editarUsuario";
	}

}
