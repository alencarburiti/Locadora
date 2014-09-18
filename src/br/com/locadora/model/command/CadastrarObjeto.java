package br.com.locadora.model.command;

import br.com.locadora.model.bean.Objeto;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.Telefone;
import br.com.locadora.model.dao.InterfaceObjetoDAO;
import br.com.locadora.model.dao.InterfaceDependenteDAO;
import br.com.locadora.model.dao.InterfaceDiariaDAO;
import br.com.locadora.model.dao.InterfaceGeneroDAO;
import br.com.locadora.model.dao.InterfaceObjetoDAO;
import br.com.locadora.model.dao.InterfaceTelefoneDAO;
import br.com.locadora.view.CadastroObjeto;
import br.com.locadora.view.MenuObjeto;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CadastrarObjeto implements InterfaceCommand {

    private InterfaceObjetoDAO objetoDAO;
    private InterfaceGeneroDAO generoDAO;
    private InterfaceDiariaDAO diariaDAO;

    public CadastrarObjeto(InterfaceObjetoDAO objetoDAO, InterfaceGeneroDAO generoDAO, InterfaceDiariaDAO diariaDAO) {
        super();
        this.objetoDAO = objetoDAO;
        this.generoDAO = generoDAO;
        this.diariaDAO = diariaDAO;
    }

    public String execute() {

        try {
            if (CadastroObjeto.jtf_codigo_objeto.getText().isEmpty()) {
                Objeto objeto = new Objeto();

                objeto.setDescricao_objeto(CadastroObjeto.jtf_descricao_objeto.getText().trim());
                objeto.setTitulo_original(CadastroObjeto.jtf_titulo_original.getText().trim());
                objeto.setDescricao_resumida(CadastroObjeto.jtf_descricao_resumida.getText().trim());
                objeto.setTipo_movimento((String) CadastroObjeto.jcb_tipo.getSelectedItem());
                objeto.setProducao((String) CadastroObjeto.jcb_producao.getSelectedItem());
                objeto.setDuracao(CadastroObjeto.jtf_duracao.getText().trim());
                objeto.setMidia((String) CadastroObjeto.jcb_midia.getSelectedItem());
                objeto.setTipo_midia((String) CadastroObjeto.jcb_tipo_midia.getSelectedItem());
                objeto.setGenero(CadastroObjeto.getObjetoGenero());
                objeto.setDiaria(CadastroObjeto.getObjetoDiaria());

                objeto = objetoDAO.salvar(objeto);

                CadastroObjeto.jtf_codigo_objeto.setText(String.valueOf(objeto.getCodigo_objeto()));
//            List<Telefone> itens_telefone = new ArrayList();
//            for (int i = 0; i < CadastroObjeto.jtbl_telefone.getRowCount(); i++) {
//                Telefone telefone = new Telefone();
//                telefone.setTelefone((String) CadastroObjeto.jtbl_telefone.getValueAt(i, 0));
//                itens_telefone.add(telefone);
//            }
//            
//            telefoneDAO.salvar(itens_telefone, objeto);
//            

            } else {
                
            }

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
