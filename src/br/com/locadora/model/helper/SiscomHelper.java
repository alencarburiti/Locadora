package br.com.locadora.model.helper;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.command.ConsultarCliente;
import br.com.locadora.model.command.ConsultarDiaria;
import br.com.locadora.model.command.ConsultarGenero;
import br.com.locadora.model.command.ConsultarObjeto;
import br.com.locadora.model.command.InterfaceCommand;
import br.com.locadora.model.dao.ClienteDAO;
import br.com.locadora.model.dao.DiariaDAO;
import br.com.locadora.model.dao.GeneroDAO;
import br.com.locadora.model.dao.ObjetoDAO;
import java.util.HashMap;

public class SiscomHelper {

    private HashMap<String, InterfaceCommand> mapaComandos;

    public SiscomHelper(InterfacePool pool) {

        mapaComandos = new HashMap<String, InterfaceCommand>();

        
        mapaComandos.put("consultarCliente", new ConsultarCliente(new ClienteDAO(pool)));
        mapaComandos.put("consultarGenero", new ConsultarGenero(new GeneroDAO(pool)));
        mapaComandos.put("consultarDiaria", new ConsultarDiaria(new DiariaDAO(pool)));
        mapaComandos.put("consultarObjeto", new ConsultarObjeto(new ObjetoDAO(pool), new GeneroDAO(pool), new DiariaDAO(pool)));
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
