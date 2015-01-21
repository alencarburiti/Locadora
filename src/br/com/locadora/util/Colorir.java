/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.util;

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
            data_vencimento = new Date(df.parse(table.getValueAt(row, 4).toString()).getTime());
        } catch (ParseException ex) {

        }
        Date dataAtual = new Date(System.currentTimeMillis());
        if (isSelected == false) {
                
            if (data_vencimento.before(dataAtual) && table.getValueAt(row, 6).toString().equals("")) {
                System.out.println("Data de vencimento: "+ data_vencimento);
                System.out.println("Data atual: "+ dataAtual);
//                renderer.setBackground(Color.RED);
                renderer.setForeground(Color.RED);
                System.out.println("Vencido");
            } else if (!table.getValueAt(row, 6).toString().equals("")) {
//                renderer.setBackground(fDarkGreen);
                renderer.setForeground(fDarkGreen);
                System.out.println("Pago");
            } else if (data_vencimento.after(dataAtual)) {
//                renderer.setBackground(Color.WHITE);
                renderer.setForeground(Color.BLACK);
                System.out.println("A vencer");
            } else {
//                renderer.setBackground(Color.YELLOW);
                renderer.setForeground(Color.red);
                System.out.println("Não pagou");              
            }

        }

        return renderer;
    }
}
