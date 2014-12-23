package br.com.locadora.model.helper;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.command.AtualizarGenero;
import br.com.locadora.model.command.CadastrarGenero;
import br.com.locadora.model.command.ConsultarCliente;
import br.com.locadora.model.command.ConsultarDiaria;
import br.com.locadora.model.command.ConsultarGenero;
import br.com.locadora.model.command.ConsultarObjeto;
import br.com.locadora.model.command.InterfaceCommand;
import br.com.locadora.model.dao.ClienteDAO;
import br.com.locadora.model.dao.CopiaDAO;
import br.com.locadora.model.dao.DiariaDAO;
import br.com.locadora.model.dao.GeneroDAO;
import br.com.locadora.model.dao.LocacaoDAO;
import br.com.locadora.model.dao.ObjetoDAO;
import java.util.HashMap;

public class SiscomHelper {

    private HashMap<String, InterfaceCommand> mapaComandos;

    public SiscomHelper(InterfacePool pool) {

        mapaComandos = new HashMap<String, InterfaceCommand>();

        
        mapaComandos.put("consultarCliente", new ConsultarCliente(new ClienteDAO(pool)));
//		mapaComandos.put("editarCliente", new EditarCliente(new ClienteDAO(pool)));
//		mapaComandos.put("excluirCliente", new ExcluirCliente(new ClienteDAO(pool)));

        mapaComandos.put("consultarGenero", new ConsultarGenero(new GeneroDAO(pool)));
        mapaComandos.put("cadastrarGenero", new CadastrarGenero(new GeneroDAO(pool)));
        mapaComandos.put("atualizarGenero", new AtualizarGenero(new GeneroDAO(pool)));

        

//                mapaComandos.put("consultarDevolucao", new ConsultarDevolucao(new LocacaoDAO(pool)));

        mapaComandos.put("consultarDiaria", new ConsultarDiaria(new DiariaDAO(pool)));

        mapaComandos.put("consultarObjeto", new ConsultarObjeto(new ObjetoDAO(pool), new GeneroDAO(pool), new DiariaDAO(pool)));
        

//		mapaComandos.put("editarUsuario", new EditarUsuario(new UsuarioDAO(pool)));
//		mapaComandos.put("consultarUsuario", new ConsultarUsuario(new UsuarioDAO(pool)));
//		mapaComandos.put("excluirUsuario", new ExcluirFuncionario(new UsuarioDAO(pool)));
//		mapaComandos.put("atualizarUsuario", new AtualizarUsuario(new UsuarioDAO(pool)));
    }

    public InterfaceCommand getCommand() {
        String cmd = command;
        if (cmd == null || command == null) {
            return mapaComandos.get("acessarUsuario");
        }
        return mapaComandos.get(cmd);
    }

    private String command;

    public void setCommand(String comando) {
        this.command = comando;
    }

}
