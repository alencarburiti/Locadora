package br.com.locadora.model.command;

import br.com.locadora.model.dao.InterfaceUsuarioDAO;
import java.sql.SQLException;



public class AtualizarUsuario implements InterfaceCommand {

	private InterfaceUsuarioDAO usuarioDAO;
	
	public AtualizarUsuario(InterfaceUsuarioDAO usuarioDAO) {
		super();
		this.usuarioDAO = usuarioDAO;
	}
	public String execute() {
//		try {
//			Usuario usuario = new Usuario();
//			usuario.setAcesso(request.getParameter("acesso"));
//			usuario.setCodigo(Integer.valueOf(request.getParameter("codigo")));
//			usuario.setNome(request.getParameter("nome"));
//			usuario.setCargo(request.getParameter("cargo"));
//			usuario.setDepartamento(request.getParameter("departamento"));
//			usuario.setEmail(request.getParameter("email"));
//			usuario.setTelefone(request.getParameter("telefone"));			
//			usuario.setLogin(request.getParameter("login"));
//			usuario.setSenha(request.getParameter("senha"));
//			
//			usuarioDAO.atualizar(usuario);
//			request.setAttribute("mensagem", "Usu�rio ("+usuario.getNome()+") atualizado com sucesso!");			
//		} catch (SQLException e) {
//			request.setAttribute("mensagem", "Problemas com a atualiza��o: "+e.getMessage());
//			e.printStackTrace();
//		} catch (NumberFormatException e){
//			request.setAttribute("mensagem", "Valor inv�lido: "+e.getMessage());
//			e.printStackTrace();
//		}
//		request.setAttribute("titulo", "Consultar - Funcion�rio");
//		
		return "SiscomController?cmd=consultarUsuario";	}

}
