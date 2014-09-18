package br.com.locadora.model.command;

import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.Objeto;
import br.com.locadora.model.dao.InterfaceCopiaDAO;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.view.CadastroObjeto;
import static br.com.locadora.view.CadastroObjeto.jtbl_copia;
import static br.com.locadora.view.CadastroObjeto.jtf_localizacao;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
            copia.setCodigo_interno(Integer.parseInt(CadastroObjeto.jtf_codigo_interno.getText()));
            copia.setLocalizacao(CadastroObjeto.jtf_localizacao.getText());
            copia.setIdioma((String) CadastroObjeto.jcb_idioma.getSelectedItem());
            copia.setLegenda((String) CadastroObjeto.jcb_legenda.getSelectedItem());
            copia.setPreco_custo(CadastroObjeto.getPrecoFormato((String) CadastroObjeto.jtf_preco_custo.getText()));
            try {
                copia.setData_aquisicao(new SimpleDateFormat("dd/MM/yyyy").parse((String) CadastroObjeto.jtf_data_aquisicao.getText()));
            } catch (ParseException ex) {
                Logger.getLogger(CadastrarCopia.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                copiaDAO.salvar(copia);
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
            copia.setLocalizacao(jtf_localizacao.getText());

            DefaultTableModel row = (DefaultTableModel) CadastroObjeto.jtbl_copia.getModel();
            ItemDbGrid hashDbGrid = new ItemDbGrid(copia, copia.getLocalizacao());
            row.addRow(new Object[]{copia.getCodigo_copia(), copia.getCodigo_interno(), hashDbGrid, copia.getIdioma(), copia.getLegenda()});
            
            CadastroObjeto.jtf_codigo_interno.setText("");
            CadastroObjeto.jtf_localizacao.setText("");
            CadastroObjeto.jcb_idioma.setSelectedIndex(0);
            CadastroObjeto.jcb_legenda.setSelectedIndex(0);
            CadastroObjeto.jtf_preco_custo.setText("R$ 0,00");
            CadastroObjeto.jtf_codigo_interno.requestFocus();
//        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel adicionar ");
//        }
    }
}
