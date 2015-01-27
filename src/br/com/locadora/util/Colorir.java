/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.util;

import br.com.locadora.view.ConsultaClienteAtendimento;
import br.com.locadora.view.Financeiro;
import java.awt.Color;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author alencarburiti
 */
public class Colorir extends DefaultTableCellRenderer {
    
    public Financeiro janelapai1;
    public ConsultaClienteAtendimento janelapai2;
    
    public Colorir(Financeiro financeiro, ConsultaClienteAtendimento consultaClienteAtendimento){
        janelapai1 = financeiro;
        janelapai2 = consultaClienteAtendimento;
    }

    private Color fDarkGreen = Color.green.darker();

    @Override
    public JComponent getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {

        JComponent renderer = (JComponent) super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column
        );

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = new GregorianCalendar();
        Date data_vencimento = null;
        try {
            data_vencimento = new Date(df.parse(table.getValueAt(row, 5).toString()).getTime());
        } catch (ParseException ex) {

        }
        Date dataAtual = new Date(System.currentTimeMillis());
        if (isSelected == false) {
                
            if(janelapai1 != null){
                if (data_vencimento.before(dataAtual) && table.getValueAt(row, 7).toString().equals("")) {
                    System.out.println("Data de vencimento: "+ data_vencimento);
                    System.out.println("Data atual: "+ dataAtual);
                    renderer.setForeground(Color.RED);
                    System.out.println("Vencido");
                } else if (!table.getValueAt(row, 7).toString().equals("")) {
                    renderer.setForeground(fDarkGreen);
                    System.out.println("Pago");
                } else if (data_vencimento.after(dataAtual)) {
                    renderer.setForeground(Color.BLACK);
                    System.out.println("A vencer");
                } else {
                    renderer.setForeground(Color.red);
                    System.out.println("Não pagou");              
                }                
            } else if(janelapai2 != null){
                if(table.getValueAt(row, 3).toString().equals("Cliente")){
                    renderer.setForeground(fDarkGreen);
                } else {
                    renderer.setForeground(Color.red);
                }
            }

        }

        return renderer;
    }
}
