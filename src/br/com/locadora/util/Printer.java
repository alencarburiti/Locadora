/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.util;

import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.ItemLocacao;
import br.com.locadora.model.bean.Usuario;
import br.com.locadora.view.EntradaCaixa;
import br.com.locadora.view.EntradaCaixaDevolucao;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.swing.JOptionPane;

/**
 *
 * @author alencarburiti
 */
public class Printer {

    public File arquivo;

    public void comprovanteLocacao(List<ItemLocacao> itens, Dependente dependente, Usuario usuario) {
        //ESCREVER TXT    
        String nome_arquivo = "Imprimir/comprovanteLocacao_" + dependente.getNome_dependente() + ".txt";
        try {
            arquivo = new File(nome_arquivo);
            arquivo.delete();
            arquivo.deleteOnExit();
            arquivo.createNewFile();
            if (arquivo.exists() && !arquivo.isDirectory()) {

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
                linhasTxt.println("Cliente: " + dependente.getNome_dependente());
                linhasTxt.println("Usuário: " + usuario.getNome_usuario());
                linhasTxt.println("===========================================");
                linhasTxt.println(String.format("%-6s", "Cód    Descrição            Prev   Valor"));
                //dados da tabela

                Moeda moeda = new Moeda();

                for (int x = 0; x < itens.size(); x++) {
                    linhasTxt.print(String.format("%05d  ", itens.get(x).getCopia().getObjeto().getCodigo_objeto()));

                    String espelho = "dd/MM/yyyy";
                    SimpleDateFormat dateFormat = new SimpleDateFormat(espelho);
                    String data_formatada = dateFormat.format(itens.get(x).getData_prevista());
                    data_formatada = data_formatada.substring(0, 5);

                    linhasTxt.print(String.format("%-21s", itens.get(x).getCopia().getObjeto().getDescricao_objeto()));
                    linhasTxt.print(String.format("%-7s", data_formatada));
                    linhasTxt.print(moeda.setPrecoFormat(String.valueOf(itens.get(x).getCopia().getObjeto().getDiaria().getValor())));
                    linhasTxt.println();
                }
                Double total_locacao = moeda.getPrecoFormato(EntradaCaixa.jtf_valor_total_a_pagar.getText());
                Double desconto = moeda.getPrecoFormato(EntradaCaixa.jtf_desconto.getText());
                Double subTotal = total_locacao - desconto;

                linhasTxt.println("===========================================");
                linhasTxt.println("Débito Anterior (-):        " + EntradaCaixa.jtf_debito_anterior.getText());
                linhasTxt.println("Valor Locação (-):          " + EntradaCaixa.jtf_valor_total_locacao.getText());
                linhasTxt.println("Valor Desconto (+):         " + EntradaCaixa.jtf_desconto.getText());
                linhasTxt.println("SubTotal (=):               " + moeda.setPrecoFormat(String.valueOf(subTotal)));
                linhasTxt.println("Valor Pago (+):             " + EntradaCaixa.jtf_valor_pago.getText());
                linhasTxt.println("Troco (-):                  " + EntradaCaixa.jtf_troco.getText());
                linhasTxt.println("===========================================");
                linhasTxt.println("Termo de Responsabilidade: Estou ciente que");
                linhasTxt.println("os DVD’s que foram por mim alugados, ou com");
                linhasTxt.println("minha autorização, deverão ser devolvidos no");
                linhasTxt.println("mesmo estado de conservação, e que qualquer ");
                linhasTxt.println("dano ou perda, eu me comprometo a pagar o ");
                linhasTxt.println("valor da Nota Fiscal do Filme. ");
                linhasTxt.println("De acordo:                                 ");
                linhasTxt.println("                                           ");
                linhasTxt.println("___________________________________________");
                linhasTxt.println("Cliente: " + dependente.getNome_dependente());
                linhasTxt.println("===========================================");
                linhasTxt.println("        OBRIGADO PELA PREFERÊNCIA          ");
                linhasTxt.println("   INFORMACOES PARA FECHAMENTO DE CONTA    ");

                int i = 0;
                while (i < 10) {
                    i++;
                    linhasTxt.println();
                }
                arquivoTxt.close();

            } else {
                //se naum existir
                arquivo.createNewFile();
                //criaTxt();
            }
        } catch (IOException error) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontradao");
        }
    }

    public void comprovanteDevolucao(List<ItemLocacao> itens, Dependente dependente, Usuario usuario) {
        //ESCREVER TXT    
        String nome_arquivo = "Imprimir/comprovanteDevolucao_" + dependente.getNome_dependente() + ".txt";
        try {
            arquivo = new File(nome_arquivo);
            arquivo.delete();
            arquivo.deleteOnExit();
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
                linhasTxt.println("********* Comprovante de Devolução ********");
                linhasTxt.println("===========================================");
                linhasTxt.println("Cliente: " + dependente.getNome_dependente());
                linhasTxt.println("Usuário: " + usuario.getNome_usuario());
                linhasTxt.println("===========================================");
                linhasTxt.println(String.format("%-6s", "Cód    Descrição            Prev   Dev"));
                //dados da tabela

                Moeda moeda = new Moeda();

                for (int x = 0; x < itens.size(); x++) {
                    linhasTxt.print(String.format("%05d  ", itens.get(x).getCopia().getObjeto().getCodigo_objeto()));

                    String espelho = "dd/MM/yyyy";
                    SimpleDateFormat dateFormat = new SimpleDateFormat(espelho);
                    String data_prevista = dateFormat.format(itens.get(x).getData_prevista());
                    data_prevista = data_prevista.substring(0, 5);

                    String data_devolucao = dateFormat.format(itens.get(x).getData_devolucao());
                    data_devolucao = data_devolucao.substring(0, 5);

                    linhasTxt.print(String.format("%-21s", itens.get(x).getCopia().getObjeto().getDescricao_objeto()));
                    linhasTxt.print(String.format("%-7s", data_prevista));
                    linhasTxt.print(data_devolucao);
                    linhasTxt.println();
                }
                Double total_devolucao = moeda.getPrecoFormato(EntradaCaixaDevolucao.jtf_total_a_pagar.getText());
                Double desconto = moeda.getPrecoFormato(EntradaCaixaDevolucao.jtf_desconto.getText());
                Double subTotal = total_devolucao - desconto;

                linhasTxt.println("===========================================");
                linhasTxt.println("Débito Anterior (-):        " + EntradaCaixaDevolucao.jtf_debito_anterior.getText());
                linhasTxt.println("Débito Devolução (-):       " + EntradaCaixaDevolucao.jtf_debito_devolucao.getText());
                linhasTxt.println("Valor Desconto (+):         " + EntradaCaixaDevolucao.jtf_desconto.getText());
                linhasTxt.println("SubTotal (=):               " + moeda.setPrecoFormat(String.valueOf(subTotal)));
                linhasTxt.println("Valor Pago (+):             " + EntradaCaixaDevolucao.jtf_valor_pago.getText());
                linhasTxt.println("Troco (-):                  " + EntradaCaixaDevolucao.jtf_troco.getText());
                linhasTxt.println("===========================================");
                linhasTxt.println("Termo de Responsabilidade: Estou ciente que");
                linhasTxt.println("os DVD’s que foram por mim alugados, ou com");
                linhasTxt.println("minha autorização, deverão ser devolvidos no");
                linhasTxt.println("mesmo estado de conservação, e que qualquer ");
                linhasTxt.println("dano ou perda, eu me comprometo a pagar o ");
                linhasTxt.println("valor da Nota Fiscal do Filme. ");
                linhasTxt.println("De acordo:                                 ");
                linhasTxt.println("                                           ");
                linhasTxt.println("___________________________________________");
                linhasTxt.println("Cliente: " + dependente.getNome_dependente());
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
            JOptionPane.showMessageDialog(null, "Arquivo não encontradao");
        }
    }

    public boolean imprimirArquivo(String nome_arquivo) throws PrintException {
        // imprime arquivo 
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        try {
            if (!conf.readPropertie("impressora_principal").equals("")) {
                detectaImpressoras(conf.readPropertie("impressora_principal"));
                java.io.InputStream is = new FileInputStream(nome_arquivo);
                Scanner sc = new Scanner(is);
                while (sc.hasNextLine()) {
                    String linhas = sc.nextLine();
                    imprime(linhas);
                }
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Impressora não detectada");
                return false;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro encontrado ao imprimir comanda.");
            return false;
        }
    }

    public static List<String> retornaImpressoras() {
        try {
            List<String> listaImpressoras = new ArrayList<String>();
            DocFlavor df = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
            PrintService[] ps = PrintServiceLookup.lookupPrintServices(df, null);
            for (PrintService p : ps) {
                listaImpressoras.add(p.getName());
            }
            return listaImpressoras;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static PrintService impressora; // O Atributo citado anteriormente  

    public void detectaImpressoras(String impressoraSelecionada) {  //Passa por parâmetro o nome salvo da impressora  
        try {
            DocFlavor df = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
            PrintService[] ps = PrintServiceLookup.lookupPrintServices(df, null);
            for (PrintService p : ps) {
                if (p.getName() != null && p.getName().contains(impressoraSelecionada)) {
                    impressora = p;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Impressora não detectada");
        }
    }

    public boolean imprime(String texto) throws PrintException {

        if (impressora == null) {
            JOptionPane.showMessageDialog(null, "Nennhuma impressora foi encontrada. Instale uma impressora padrão \r\n(Generic Text Only) e reinicie o programa.");
            return false;
        } else {

            DocPrintJob dpj = impressora.createPrintJob();
            InputStream stream = new ByteArrayInputStream((texto + "\n").getBytes());
            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            Doc doc = new SimpleDoc(stream, flavor, null);
            dpj.print(doc, null);
            return true;

        }

    }

//    public void acionarGuilhotina(){  
//        imprime(""+(char)27+(char)109);  
//    }  
}
