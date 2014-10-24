/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.util;

import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.ItemLocacao;
import br.com.locadora.view.EntradaCaixa;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author alencarburiti
 */
public class ImprimiCupom {
    public File arquivo;
    public void escreverTXTLocacao(List<ItemLocacao> itens, Dependente dependente) {
        //ESCREVER TXT    
        String nome_arquivo = "/Users/alencarburiti/Documents/IT/Vc2Development/Siscom_locadora/Imprimir/comprovanteLocacao_"+dependente.getNome_dependente()+".txt";
        try {
            arquivo = new File(nome_arquivo);
            arquivo.delete();
            arquivo = new File(nome_arquivo);
            arquivo.createNewFile();
            if (arquivo.exists()) {
                //se existir
                FileWriter arquivoTxt = new FileWriter(arquivo, true);
                PrintWriter linhasTxt = new PrintWriter(arquivoTxt);
                //ACREDITO QUE SO PODE TER 42 CARACTERES
                linhasTxt.println("===========================================");
                linhasTxt.println("          Broadway Video Locadora          ");
                linhasTxt.println("===========================================");
                linhasTxt.println("********** CNPJ 73.411.457/0001-62 ********");
                linhasTxt.println("               R. 18 Qd, 164               ");
                linhasTxt.println("  Setor Central, Goianésia - GO, 76380-000 ");
                linhasTxt.println("               (62) 3353-4030              ");                 
                linhasTxt.println("===========================================");
                linhasTxt.println("********** NAO É DOCUMENTO FISCAL *********");
                linhasTxt.println("===========================================");
                linhasTxt.println("************ Recibo de Locação ************");
                linhasTxt.println("===========================================");
                linhasTxt.println("Cliente: "+dependente.getNome_dependente());
                linhasTxt.println("===========================================");
                linhasTxt.println(String.format("%-6s","Cód    Descrição            Prev   Valor"));
                //dados da tabela
                
                Moeda moeda = new Moeda();
                
                for(int x = 0; x < itens.size(); x++){
                    linhasTxt.print(String.format("%05d  ",itens.get(x).getCopia().getObjeto().getCodigo_objeto()));                    
                                        
                String espelho = "dd/MM/yyyy";
                SimpleDateFormat dateFormat = new SimpleDateFormat(espelho);  
                String data_formatada = dateFormat.format(itens.get(x).getData_prevista());
                data_formatada = data_formatada.substring(0, 5);
                    
                    linhasTxt.print(String.format("%-21s",itens.get(x).getCopia().getObjeto().getDescricao_objeto()));
                    linhasTxt.print(String.format("%-7s",data_formatada));
                    linhasTxt.print(moeda.setPrecoFormat(String.valueOf(itens.get(x).getCopia().getObjeto().getDiaria().getValor())));
                    linhasTxt.println();
                 }
                Double total_locacao = moeda.getPrecoFormato(EntradaCaixa.jtf_valor_total_a_pagar.getText());
                Double desconto = moeda.getPrecoFormato(EntradaCaixa.jtf_valor_desconto.getText());
                Double subTotal = total_locacao - desconto;
                
                linhasTxt.println("===========================================");
                linhasTxt.println("Débito Anterior (-):        " + EntradaCaixa.jtf_valor_debito_anterior.getText());                        
                linhasTxt.println("Valor Locação (-):          " + EntradaCaixa.jtf_valor_total_locacao.getText());
                linhasTxt.println("Valor Desconto (+):         " + EntradaCaixa.jtf_valor_desconto.getText());
                linhasTxt.println("SubTotal (=):               " + moeda.setPrecoFormat(String.valueOf(subTotal)));
                linhasTxt.println("Valor Pago (+):             " + EntradaCaixa.jtf_valor_pago.getText());
                linhasTxt.println("Troco (-):                  " + EntradaCaixa.jtf_valor_troco.getText());
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

    public void imprimirArquivo(String nome_arquivo) {
        // imprime arquivo 
        try {
            java.io.InputStream is = new FileInputStream(nome_arquivo);
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
