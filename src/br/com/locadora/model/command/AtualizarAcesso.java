package br.com.locadora.model.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;



public class AtualizarAcesso implements InterfaceCommand {

    public String execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//	private AcessoDAO acessoDAO;
//	public AtualizarAcesso(AcessoDAO acessoDAO) {
//		super();
//		this.acessoDAO = acessoDAO;
//	}
//	public String execute(HttpServletRequest request,
//			HttpServletResponse response) {
//		Enumeration parametros = request.getParameterNames();
//		List<Acesso> acessos = new ArrayList<Acesso>();
//		while(parametros.hasMoreElements())
//		{
//			String paramAcesso = (String) parametros.nextElement();
//			Acesso acesso = new Acesso();
//			try {
//				acesso.setAcesso_codigo(Integer.parseInt(paramAcesso));
//				acesso.setFuncionario_codigo(Integer.parseInt(request.getParameter("codigo")));
//				acessos.add(acesso);
//			} catch (NumberFormatException e) {
//				//N�o tratar exce��o
//			}
//		}
//		
//		try {
//			acessoDAO.excluir(Integer.parseInt(request.getParameter("codigo")));
//			acessoDAO.salvar(acessos);
//			request.setAttribute("mensagem", "Acessos atualizados com sucesso!");
//		} catch (SQLException e) {
//			request.setAttribute("mensagem", "Problemas com a atualiza��o: "+e.getMessage());
//			e.printStackTrace();
//		}
//		request.setAttribute("titulo", "Consulta - Usu�rio");
//		return "SiscomController?cmd=consultarUsu�rio";
//	}

}
