package br.com.locadora.model.command;

import br.com.locadora.model.bean.Genero;
import br.com.locadora.model.dao.InterfaceGeneroDAO;
import br.com.locadora.view.AtualizaGenero;
import java.sql.SQLException;

public class AtualizarGenero implements InterfaceCommand {

    private InterfaceGeneroDAO generoDAO;

    public AtualizarGenero(InterfaceGeneroDAO generoDAO) {
        super();
        this.generoDAO = generoDAO;
    }

    
    public String execute() {

        try {

            Genero genero = new Genero();

            genero.setCodigo_genero(Integer.parseInt(AtualizaGenero.jtf_codigo_genero.getText()));
            genero.setNome_genero(AtualizaGenero.jtf_nome_genero.getText());

            generoDAO.atualizar(genero);

            

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Problemas com a gravação: ");

            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido: " + e.getMessage());

            e.printStackTrace();
        }
        return "OK";
    }
    

}
