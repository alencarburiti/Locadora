package br.com.locadora.model.command;

import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.dao.InterfaceDiariaDAO;
import br.com.locadora.view.CadastroDiaria;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CadastrarDiaria implements InterfaceCommand {

    private final InterfaceDiariaDAO diariaDAO;

    public CadastrarDiaria(InterfaceDiariaDAO diariaDAO) {
        super();
        this.diariaDAO = diariaDAO;
    }

    
    public String execute() {

        try {

            Diaria diaria = new Diaria();
            diaria.setNome_diaria(CadastroDiaria.jtf_nome_diaria.getText());
            diaria.setValor(getPrecoFormato((String) CadastroDiaria.jtf_valor.getText()));
            diaria.setValor_promocao(getPrecoFormato((String) CadastroDiaria.jtf_valor_promocao.getText()));
            diaria.setMultas(getPrecoFormato((String) CadastroDiaria.jtf_relocacao.getText()));
            diaria.setDias(Integer.parseInt((String) CadastroDiaria.jtf_dias.getText()));
            diaria.setMaximo_dias(Integer.parseInt((String) CadastroDiaria.jtf_dias_maximo.getText()));
            diaria.setAcumulativo(CadastroDiaria.jcb_acumulativo.isSelected());
            diaria = diariaDAO.salvar(diaria);
            CadastroDiaria.jtf_codigo_diaria.setText(diaria.getCodigo_diaria().toString());
            
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Problemas com a gravação: ");

            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido: " + e.getMessage());

            e.printStackTrace();
        }
        return "OK";
    }
 public Double getPrecoFormato(String preco) {
        Double precoFormatado = 0.0;
        try {
            preco = preco.replace("R", "");
            preco = preco.replace("$", "");
            preco = preco.replace(",", ".");
            preco = preco.replace(" ", "");
            precoFormatado = Double.parseDouble(preco.trim());

            //this.objFuncionario.setSalario(getSalarioFormat(jTSalario.getText())); pegar valor em double

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Valor Informado Incorreto!\nInforme um valor com o seguinte formato:\nEx: 100,00");
        }
        return precoFormatado;
    }
}
