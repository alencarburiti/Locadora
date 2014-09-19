package br.com.locadora.model.command;

import br.com.locadora.model.bean.Genero;
import br.com.locadora.model.dao.InterfaceGeneroDAO;
import br.com.locadora.view.CadastroGenero;
import static br.com.locadora.view.CadastroGenero.jtf_nome_genero;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class CadastrarGenero implements InterfaceCommand {

    private final InterfaceGeneroDAO generoDAO;

    public CadastrarGenero(InterfaceGeneroDAO generoDAO) {
        super();
        this.generoDAO = generoDAO;
    }

    
    public String execute() {

        try {

            Genero genero = new Genero();
            genero.setNome_genero(CadastroGenero.jtf_nome_genero.getText());

            generoDAO.salvar(genero);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Problemas com a gravação: ");

            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido: " + e.getMessage());

            e.printStackTrace();
        }
        return "OK";
    }
 
    public void verificaCadastro() {
//        GeneroDAO genero = new GeneroDAO();
//        generos = genero.listarGeneroDescricao(jtf_nome_genero.getText().trim());
//        validaCadastro(generos);
    }
    public void validaCadastro(List<Genero> generos) {//verifica cadastro existente que retornou de uma lista

        if (generos.size() == 0) {
//            cadastroGenero();
        } else {
            JOptionPane.showMessageDialog(null, "Genero existente");
            jtf_nome_genero.requestFocus();
        }
    }
}
