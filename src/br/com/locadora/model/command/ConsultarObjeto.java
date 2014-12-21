package br.com.locadora.model.command;

import br.com.locadora.model.bean.Objeto;
import br.com.locadora.model.dao.InterfaceDiariaDAO;
import br.com.locadora.model.dao.InterfaceGeneroDAO;
import br.com.locadora.model.dao.InterfaceObjetoDAO;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.view.MenuObjeto;
import java.sql.SQLException;
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
                    
                    mostrar_Objeto(objetos);
                } else {
                    JOptionPane.showMessageDialog(null, "Informe um Código");
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
                ItemDbGrid hashDbGrid = new ItemDbGrid(objeto1, objeto1.getTitulo());
                row.addRow(new Object[]{objeto1.getCodigo_objeto(), hashDbGrid, objeto1.getTitulo_original(), objeto1.getElenco()});
                
                System.out.println("0 - Diária alterar código: "+objeto1.getDiaria().getCodigo_diaria());
                System.out.println("0 - Diária alterar descrição: "+objeto1.getDiaria().getNome_diaria());
            }
            MenuObjeto.objetos = objetos;
            
            MenuObjeto.jtbl_objeto.requestFocus();
            MenuObjeto.jtbl_objeto.setSelectionMode(1);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum Objeto encontrado");
        }
    }

}
