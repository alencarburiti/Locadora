package br.com.locadora.model.command;

import br.com.locadora.model.dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.Map;



public class VerificarAutorizacao implements InterfaceCommand {

	private UsuarioDAO usuarioDAO;
	public VerificarAutorizacao(UsuarioDAO usuarioDAO) {
		super();
		this.usuarioDAO = usuarioDAO;
	}
	
        public String execute() {
//		String cmd = request.getParameter("cmd");
//		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario"); 
//		if(usuario == null)
//			return "SiscomController?cmd=acessarUsuario";
//		try {
//			Map<String, Acesso> acessos = acessoDAO.getAcessosUsuario(usuario.getCodigo());
//			Acesso acesso = acessos.get(cmd); 
//			if(acesso != null && acesso.getFuncionario_codigo() != usuario.getCodigo())
//			{
//				request.setAttribute("titulo", "Acesso negado");
//				request.setAttribute("mensagem", "Nome/C�d. da transa��o: "+acesso.getDescricao()+" / "+acesso.getComando());
//				return "acesso_negado.jsp";
//			}
//		} catch (SQLException e) {
//			request.setAttribute("mensagem", "Problemas com acesso ao banco de dados: "+e.getMessage());
//			e.printStackTrace();
//		}
		return null;
	}

}
