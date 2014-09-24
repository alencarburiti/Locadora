package br.com.locadora.model.command;

import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.Objeto;
import br.com.locadora.model.dao.InterfaceCopiaDAO;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.Moeda;
import br.com.locadora.view.CadastroObjeto;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class CadastrarCopia implements InterfaceCommand {

    private final InterfaceCopiaDAO copiaDAO;

    public CadastrarCopia(InterfaceCopiaDAO copiaDAO) {
        super();
        this.copiaDAO = copiaDAO;
    }

    public String execute() {

        try {

            Copia copia = new Copia();
            Objeto objeto = new Objeto();
            objeto.setCodigo_objeto(Integer.parseInt(CadastroObjeto.jtf_codigo_objeto.getText()));
            copia.setObjeto(objeto);

            copia.setIdioma((String) CadastroObjeto.jcb_idioma.getSelectedItem());
            copia.setLegenda((String) CadastroObjeto.jcb_legenda.getSelectedItem());
            copia.setPreco_custo(CadastroObjeto.getPrecoFormato((String) CadastroObjeto.jtf_preco_custo.getText()));

            try {
                copia.setData_aquisicao(new SimpleDateFormat("dd/MM/yyyy").parse((String) CadastroObjeto.jtf_data_aquisicao.getText()));
            } catch (ParseException ex) {
                Logger.getLogger(CadastrarCopia.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                copia = copiaDAO.salvar(copia);
                alimentarCopia(copia);
            } catch (SQLException ex) {
                Logger.getLogger(CadastrarCopia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(CadastrarCopia.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (NumberFormatException e) {
            System.out.println("Valor inválido: " + e.getMessage());

            e.printStackTrace();
        }
        return "OK";
    }

    public void alimentarCopia(Copia copia) throws ParseException {

//          if (verificar_campo_copia() == true) { //&& (verificaTabela()
        String preco_custo = null;
        preco_custo = String.valueOf(copia.getPreco_custo());
        Moeda moeda = new Moeda();
        preco_custo = moeda.setPrecoFormat(preco_custo);

        DefaultTableModel row = (DefaultTableModel) CadastroObjeto.jtbl_copia.getModel();
        ItemDbGrid hashDbGrid = new ItemDbGrid(copia, copia.getCodigo_barras());
        row.addRow(new Object[]{copia.getCodigo_copia(), copia.getNumero_copia(), hashDbGrid, copia.getIdioma(), copia.getLegenda(), preco_custo, CadastroObjeto.jtf_data_aquisicao.getText()});

        CadastroObjeto.jcb_idioma.setSelectedIndex(0);
        CadastroObjeto.jcb_legenda.setSelectedIndex(0);
        CadastroObjeto.jtf_preco_custo.setText("R$ 0,00");

//        } else {
//            JOptionPane.showMessageDialog(null, "Não foi possivel adicionar ");
//        }
    }
}
