/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.util;

import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.view.EntradaCaixa;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author alencarburiti
 */
public class ImprimiCupom {

    public void escreverTXTLocacao(List<Copia> copias, Dependente dependente) {
        //ESCREVER TXT    
        try {
            File arquivo = new File("/Users/alencarburiti/Documents/IT/Vc2Development/Siscom_locadora/Imprimir/comprovanteLocacao.txt");
            if (arquivo.exists()) {
                //se existir
                FileWriter arquivoTxt = new FileWriter(arquivo, true);
                PrintWriter linhasTxt = new PrintWriter(arquivoTxt);
                //ACREDITO QUE SO PODE TER 42 CARACTERES
                linhasTxt.println("===========================================");
                linhasTxt.println("          Broadway Video Locadora          ");
                linhasTxt.println("===========================================");
                linhasTxt.println("************* CNPJ 123123123123 ***********");
                linhasTxt.println("********** NAO É DOCUMENTO FISCAL *********");
                linhasTxt.println("===========================================");
                linhasTxt.println("************ Recibo de Locação ************");
                linhasTxt.println("===========================================");
                linhasTxt.println("Cliente: "+dependente.getNome_dependente());
                linhasTxt.println("===========================================");
                linhasTxt.println("Cód  Descrição               Prev     Valor");
                //dados da tabela
                Double sub_total = null;
                for(int x = 0; x < copias.size(); x++){
                    linhasTxt.print(String.format("%7s",copias.get(x).getObjeto().getCodigo_objeto()));
                    linhasTxt.print(String.format("%-10.10s",copias.get(x).getObjeto().getDescricao_objeto()));
                    linhasTxt.print(String.format("%-10.10s",copias.get(x).getObjeto().getDescricao_objeto()));
                    linhasTxt.print(String.format("%10s    ",copias.get(x).getObjeto().getDiaria().getValor()));                                     
                    linhasTxt.println();
                 }
                linhasTxt.println("===========================================");
                linhasTxt.println("Débito Anterior (-): " + EntradaCaixa.jtf_valor_debito_anterior.getText());
                linhasTxt.println("Valor Locação (-): " + EntradaCaixa.jtf_valor_total_locacao.getText());
                linhasTxt.println("Valor Desconto (+): " + EntradaCaixa.jtf_valor_desconto.getText());
                linhasTxt.println("Valor Pago (+): " + EntradaCaixa.jtf_valor_pago.getText());
                linhasTxt.println("Troco (-): ");
                linhasTxt.println("===========================================");                
                linhasTxt.println("De acordo:                                 ");
                linhasTxt.println("                                           ");
                linhasTxt.println("___________________________________________");
                linhasTxt.println("Cliente: "+dependente.getNome_dependente());
                linhasTxt.println("===========================================");
                linhasTxt.println("        OBRIGADO PELA PREFERÊNCIA          ");
                linhasTxt.println("   INFORMACOES PARA FECHAMENTO DE CONTA    ");

                int i = 0;
                while (i < 10) {
                    i++;
                    linhasTxt.println();
                }
                arquivoTxt.close();
                //emiteComanda();

            } else {
                //se naum existir
                arquivo.createNewFile();
                //criaTxt();
            }
        } catch (IOException error) {
            System.out.println("Não encontrei arquivo");
        }
    }

    public void imprimirArquivo() {
        // imprime arquivo 
        try {
            java.io.InputStream is = new FileInputStream("/Users/alencarburiti/Documents/IT/Vc2Development/Siscom_locadora/Imprimir/comprovanteLocacao.txt");
            Scanner sc = new Scanner(is);
            FileOutputStream fs = new FileOutputStream("LPT1:");
            PrintStream ps = new PrintStream(fs);

            while (sc.hasNextLine()) {
                String linhas = sc.nextLine();
                ps.println(linhas);
            }
            fs.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado ao imprimir comanda.");
        }
    }
}
