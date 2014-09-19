package br.com.locadora.model.command;

import br.com.locadora.model.bean.Genero;
import br.com.locadora.model.dao.InterfaceGeneroDAO;
import br.com.locadora.model.dao.InterfaceGeneroDAO;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.view.MenuGenero;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultarGenero implements InterfaceCommand {

    private final InterfaceGeneroDAO generoDAO;
    public List<Genero> generos;
    public Genero genero;

    public ConsultarGenero(InterfaceGeneroDAO generoDAO) {
        super();
        this.generoDAO = generoDAO;
    }

    public String execute() {

            if (MenuGenero.jrb_codigo.isSelected() == true) {
                genero = null;
                try {
                    genero = generoDAO.getGenero_codigo(Integer.parseInt(MenuGenero.jtf_pesquisar_genero.getText().trim()));
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultarGenero.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    mostrar_Genero(genero);
                } catch (ParseException ex) {
                    Logger.getLogger(ConsultarGenero.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                generos = null;
                try {
                    generos = generoDAO.getGenero_nome(MenuGenero.jtf_pesquisar_genero.getText().trim());
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultarGenero.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    mostrar_Generos(generos);
                } catch (ParseException ex) {
                    Logger.getLogger(ConsultarGenero.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
     
        return "OK";
    }

    public void mostrar_Generos(List<Genero> generos) throws ParseException {
        DefaultTableModel tableModel = (DefaultTableModel) MenuGenero.jtbl_genero.getModel();
        tableModel.setNumRows(0);

        if (generos.size() == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum dado encontrado");
        } else {

            for (int i = 0; i < generos.size(); i++) {

                genero = new Genero();
                
                genero.setCodigo_genero(generos.get(i).getCodigo_genero());
                genero.setNome_genero(generos.get(i).getNome_genero());

                DefaultTableModel row = (DefaultTableModel) MenuGenero.jtbl_genero.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(genero, genero.getNome_genero());
                row.addRow(new Object[]{genero.getCodigo_genero(), hashDbGrid});
            }
            MenuGenero.generos = generos;
        }

    }

    public void mostrar_Genero(Genero Genero) throws ParseException {
        DefaultTableModel tableModel = (DefaultTableModel) MenuGenero.jtbl_genero.getModel();
        tableModel.setNumRows(0);

        if (Genero == null) {

        } else {

            DefaultTableModel row = (DefaultTableModel) MenuGenero.jtbl_genero.getModel();
            ItemDbGrid hashDbGrid = new ItemDbGrid(genero, genero.getNome_genero());
            row.addRow(new Object[]{genero.getCodigo_genero(), hashDbGrid});

        }
    }

}
