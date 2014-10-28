package br.com.locadora.model.command;

import br.com.locadora.model.bean.Objeto;
import br.com.locadora.model.dao.InterfaceObjetoDAO;
import br.com.locadora.view.AtualizaObjeto;
import static br.com.locadora.view.AtualizaObjeto.diaria;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AtualizarObjeto implements InterfaceCommand {

    private InterfaceObjetoDAO objetoDAO;

    public AtualizarObjeto(InterfaceObjetoDAO objetoDAO) {
        super();
        this.objetoDAO = objetoDAO;
    }

    public String execute() {

        try {
            if (AtualizaObjeto.jtf_codigo_objeto.getText().isEmpty()) {

            } else {
                Objeto objeto = new Objeto();

                objeto.setCodigo_objeto(Integer.parseInt(AtualizaObjeto.jtf_codigo_objeto.getText().trim()));
                objeto.setDescricao_objeto(AtualizaObjeto.jtf_descricao_objeto.getText().trim());
                objeto.setTitulo_original(AtualizaObjeto.jtf_titulo_original.getText().trim());
                objeto.setDescricao_resumida(AtualizaObjeto.jtf_descricao_resumida.getText().trim());
                objeto.setTipo_movimento((String) AtualizaObjeto.jcb_tipo.getSelectedItem());
                objeto.setProducao((String) AtualizaObjeto.jcb_producao.getSelectedItem());
                objeto.setDuracao(AtualizaObjeto.jtf_duracao.getText().trim());
                objeto.setMidia((String) AtualizaObjeto.jcb_midia.getSelectedItem());
                objeto.setTipo_midia((String) AtualizaObjeto.jcb_tipo_midia.getSelectedItem());
                objeto.setGenero(AtualizaObjeto.getObjetoGenero());
                
                System.out.println("5 - Diária alterar código: "+AtualizaObjeto.getObjetoDiaria().getCodigo_diaria());
                System.out.println("5 - Diária alterar descrição: "+AtualizaObjeto.getObjetoDiaria().getNome_diaria());
                      
                objeto.setDiaria(AtualizaObjeto.diaria);
                objeto.setElenco(AtualizaObjeto.jta_elenco.getText());
                objeto.setSinopse(AtualizaObjeto.jta_sinopse.getText());
                objeto.setCensura(Integer.parseInt(AtualizaObjeto.jtf_censura.getText()));
                if (AtualizaObjeto.jrb_ativo.isSelected() == true) {
                    objeto.setStatus("0");
                } else {
                    objeto.setStatus("1");
                }

                objetoDAO.atualizar(objeto);

                AtualizaObjeto.jtf_codigo_objeto.setText(String.valueOf(objeto.getCodigo_objeto()));

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
