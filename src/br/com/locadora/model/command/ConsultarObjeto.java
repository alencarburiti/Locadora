package br.com.locadora.model.command;

import br.com.locadora.model.bean.Objeto;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.bean.Telefone;
import br.com.locadora.model.dao.InterfaceObjetoDAO;
import br.com.locadora.model.dao.InterfaceDependenteDAO;
import br.com.locadora.model.dao.InterfaceDiariaDAO;
import br.com.locadora.model.dao.InterfaceGeneroDAO;
import br.com.locadora.model.dao.InterfaceObjetoDAO;
import br.com.locadora.model.dao.InterfaceTelefoneDAO;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.Moeda;
import br.com.locadora.view.CadastroObjeto;
import br.com.locadora.view.MenuDiaria;
import br.com.locadora.view.MenuObjeto;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultarObjeto implements InterfaceCommand {

    private InterfaceObjetoDAO objetoDAO;
    private InterfaceGeneroDAO generoDAO;
    private InterfaceDiariaDAO diariaDAO;    
    public Objeto objeto;
    public List<Objeto> objetos;

    public ConsultarObjeto(InterfaceObjetoDAO objetoDAO, InterfaceGeneroDAO generoDAO, InterfaceDiariaDAO diariaDAO) {
        super();
        this.objetoDAO = objetoDAO;
        this.generoDAO = generoDAO;
        this.diariaDAO = diariaDAO;
    }

  
    public String execute() {
        try {
            if (!MenuObjeto.jtf_consulta.getText().equals("")) {
                if (MenuObjeto.jrb_codigo.isSelected() == true) {
                    objeto = null;                    
                    objeto = objetoDAO.getObjeto_codigo(Integer.parseInt(MenuObjeto.jtf_consulta.getText().trim()));
                    mostrarObjeto(objeto);
                } else if (MenuObjeto.jrb_titulo.isSelected() == true) {
                    
                }
//                else {
//                    diarias = null;
//                    diarias = diariaDAO.getDiaria_nome(MenuDiaria.jtf_consulta.getText().trim());
//                    mostrar_Diarias(diarias);
//                }
            } else {

                JOptionPane.showMessageDialog(null, "Informe um parâmentro");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarCopia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ConsultarObjeto.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "OK";
    }

    public void mostrar_Objeto(List<Objeto> objetos) {
        DefaultTableModel tableModel = (DefaultTableModel) MenuDiaria.jtbl_diaria.getModel();
        tableModel.setNumRows(0);
//
//        if (diarias.size() == 0) {
//            JOptionPane.showMessageDialog(null, "Nenhuma diaria encontrada");
//
//        } else {
//            for (int i = 0; i < diarias.size(); i++) {
//                Diaria diaria = new Diaria();
//                diaria.setCodigo_diaria(diarias.get(i).getCodigo_diaria());
//                diaria.setNome_diaria(diarias.get(i).getNome_diaria());
//                diaria.setDias(diarias.get(i).getDias());
//
//                String valor = null;
//                String valor_promocao = null;
//                String multa = null;
//
//                valor = String.valueOf(diarias.get(i).getValor());
//                valor_promocao = String.valueOf(diarias.get(i).getValor_promocao());
//                multa = String.valueOf(diarias.get(i).getMultas());
//
//                Moeda moeda = new Moeda();
//
//                valor = moeda.setPrecoFormat(valor);
//                valor_promocao = moeda.setPrecoFormat(valor_promocao);
//                multa = moeda.setPrecoFormat(multa);
//
//                DefaultTableModel row = (DefaultTableModel) MenuDiaria.jtbl_diaria.getModel();
//                ItemDbGrid hashDbGrid = new ItemDbGrid(diaria, diaria.getNome_diaria());
//                row.addRow(new Object[]{diaria.getCodigo_diaria(), hashDbGrid, diaria.getDias(), valor, valor_promocao, multa});
//            }
//            MenuDiaria.diarias = diarias;
//        }
    }

    public void mostrarObjeto(Objeto objeto) throws ParseException {
        DefaultTableModel tableModel = (DefaultTableModel) MenuObjeto.jtbl_objeto.getModel();
        tableModel.setNumRows(0);

        if (objeto == null) {

        } else {
            
            DefaultTableModel row = (DefaultTableModel) MenuObjeto.jtbl_objeto.getModel();
            ItemDbGrid hashDbGrid = new ItemDbGrid(objeto, objeto.getDescricao_objeto());
            row.addRow(new Object[]{objeto.getCodigo_objeto(), hashDbGrid, objeto.getTitulo_original(), objeto.getElenco()});
        }
        MenuObjeto.objeto = objeto;
    }


}
