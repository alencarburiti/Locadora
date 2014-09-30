package br.com.locadora.model.command;

import br.com.locadora.model.bean.Objeto;
import br.com.locadora.model.dao.InterfaceDiariaDAO;
import br.com.locadora.model.dao.InterfaceGeneroDAO;
import br.com.locadora.model.dao.InterfaceObjetoDAO;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.view.MenuDiaria;
import br.com.locadora.view.MenuObjeto;
import java.sql.SQLException;
import java.text.ParseException;
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
            if (MenuObjeto.jrb_codigo.isSelected() == true) {
                if (!MenuObjeto.jtf_consulta.getText().equals("")) {
                    objetos = null;
                    objetos = objetoDAO.getObjeto_codigo(Integer.parseInt(MenuObjeto.jtf_consulta.getText().trim()));
                    System.out.print(objetos.get(0).getCodigo_objeto());
                    mostrar_Objeto(objetos);
                } else {
                    JOptionPane.showMessageDialog(null, "Informe um parâmentro");
                }
            } else if (MenuObjeto.jrb_titulo.isSelected() == true) {
                objetos = null;
                objetos = objetoDAO.getObjeto_objeto(MenuObjeto.jtf_consulta.getText().trim());
                mostrar_Objeto(objetos);
            } else {
                objetos = null;
                objetos = objetoDAO.getObjeto_ator(MenuObjeto.jtf_consulta.getText().trim());
                mostrar_Objeto(objetos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarCopia.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "OK";
    }

    public void mostrar_Objeto(List<Objeto> objetos) {
        DefaultTableModel tableModel = (DefaultTableModel) MenuObjeto.jtbl_objeto.getModel();
        tableModel.setNumRows(0);

        if (objetos.size() > 0) {
            for (Objeto objeto1 : objetos) {
                DefaultTableModel row = (DefaultTableModel) MenuObjeto.jtbl_objeto.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(objeto1, objeto1.getDescricao_objeto());
                row.addRow(new Object[]{objeto1.getCodigo_objeto(), hashDbGrid, objeto1.getTitulo_original(), objeto1.getElenco()});
            }
            MenuObjeto.objetos = objetos;
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum objeto encontrado");
        }
    }

}
