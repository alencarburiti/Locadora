package br.com.locadora.model.command;

import java.sql.SQLException;


import br.com.locadora.model.bean.Usuario;
import br.com.locadora.model.dao.InterfaceUsuarioDAO;

public class AcessarUsuario {

	private InterfaceUsuarioDAO usuarioDAO;
	public AcessarUsuario(InterfaceUsuarioDAO usuarioDAO) {
		super();
		this.usuarioDAO = usuarioDAO;
	}
	
	public String execute() {
//		Usuario usuario = null;
//		String login = request.getParameter("login");
//		String senha = request.getParameter("senha");
//		request.setAttribute("titulo", "Acesso Sistema Comercial");
//		
//		if(login == null)
//			return "login_usuario.jsp";
//		
//		try {
//			usuario = usuarioDAO.getUsuario(login);
//		} catch (SQLException e) {
//			request.setAttribute("mensagem", "Problemas com a base de dados: "+e.getMessage());
//			e.printStackTrace();
//		}
//
//		if(usuario == null || !usuario.getSenha().equals(senha))
//		{
//			request.setAttribute("mensagem", "Login ou senha inv�lido(s)");
//			return "login_usuario.jsp";
//		}
//		request.getSession().setAttribute("usuario", usuario);
//		return "SiscomController?cmd=iniciarSiscom";
	
return "OK";
}
}