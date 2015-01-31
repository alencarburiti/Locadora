/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.util;

import br.com.locadora.conexao.Pool;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.ItemLocacao;
import br.com.locadora.model.bean.ItemVenda;
import br.com.locadora.model.bean.Lancamento;
import br.com.locadora.model.bean.Usuario;
import br.com.locadora.model.dao.ClienteDAO;
import br.com.locadora.view.EntradaCaixaLocacao;
import br.com.locadora.view.EntradaCaixaDevolucao;
import br.com.locadora.view.EntradaCaixaVenda;
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
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public void comprovanteLocacao(List<ItemLocacao> itens, Dependente dependente, Usuario usuario, Lancamento lancamento) {
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
                linhasTxt.println("Controle Interno: "+ lancamento.getCodigo_lancamento());
                
                if(dependente.getTipo_dependente().equals("Dependente")){
                    Pool pool = new Pool();
                    ClienteDAO clienteDAO = new ClienteDAO(pool);
                    dependente.setCliente(clienteDAO.getCliente_codigo(dependente.getCliente().getCodigo_cliente()));
                    linhasTxt.println("Dependente: " + dependente.getNome_dependente());
                    linhasTxt.println("Titular: " + dependente.getCliente().getNome_cliente());
                } else {
                    linhasTxt.println("Titular: " + dependente.getNome_dependente());
                }
                
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
                    String descricao_objeto = itens.get(x).getCopia().getObjeto().getTitulo();
                    try {
                        linhasTxt.print(String.format("%-21s", descricao_objeto.substring(0, 19)));
                    } catch (Exception e) {
                        linhasTxt.print(String.format("%-21s", descricao_objeto));
                    }
                    linhasTxt.print(String.format("%-7s", data_formatada));
                    
                    linhasTxt.print(moeda.setPrecoFormat(String.valueOf(itens.get(x).getValor_locado())));
                    linhasTxt.println();
                }
                Double total_locacao = moeda.getPrecoFormato(EntradaCaixaLocacao.jtf_valor_total_a_pagar.getText());
                Double desconto = moeda.getPrecoFormato(EntradaCaixaLocacao.jtf_desconto.getText());
                Double subTotal = total_locacao - desconto;

                linhasTxt.println("===========================================");
                linhasTxt.println("Débito Anterior (-):        " + EntradaCaixaLocacao.jtf_saldo.getText());
                linhasTxt.println("Valor Locação (-):          " + EntradaCaixaLocacao.jtf_valor_total_locacao.getText());
                linhasTxt.println("Valor Desconto (+):         " + EntradaCaixaLocacao.jtf_desconto.getText());
                linhasTxt.println("SubTotal (=):               " + moeda.setPrecoFormat(String.valueOf(subTotal)));
                linhasTxt.println("Valor Pago (+):             " + EntradaCaixaLocacao.jtf_valor_pago.getText());
                linhasTxt.println("Troco (-):                  " + EntradaCaixaLocacao.jtf_troco.getText());
                linhasTxt.println("===========================================");
                linhasTxt.println("===========================================");
                linhasTxt.println("Usuário: " + usuario.getNome_usuario());
                linhasTxt.println("===========================================");
                linhasTxt.println("Termo de Responsabilidade: Estou ciente que");
                linhasTxt.println("os DVDs que foram por mim alugados, ou com");
                linhasTxt.println("minha autorizacao, deverão ser devolvidos no");
                linhasTxt.println("mesmo estado de conservação, e que qualquer ");
                linhasTxt.println("dano ou perda, eu me comprometo a pagar o ");
                linhasTxt.println("valor da Nota Fiscal do Filme. ");
                linhasTxt.println("De acordo:                                 ");
                linhasTxt.println("                                           ");
                linhasTxt.println("___________________________________________");
                
                if(dependente.getTipo_dependente().equals("Dependente")){                    
                    linhasTxt.println("Dependente: " + dependente.getNome_dependente());
                    linhasTxt.println("Titular: " + dependente.getCliente().getNome_cliente());
                } else {
                    linhasTxt.println("Titular: " + dependente.getNome_dependente());
                }
                
//                linhasTxt.println("Cliente: " + dependente.getNome_dependente());
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
            }
        } catch (IOException error) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontradao");
        }
    }

    public void comprovanteDevolucao(List<ItemLocacao> itens, Dependente dependente, Usuario usuario, Lancamento lancamento) {
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
                linhasTxt.println("Controle Interno: "+ lancamento.getCodigo_lancamento());

                
                if(dependente.getTipo_dependente().equals("Dependente")){
                    Pool pool = new Pool();
                    ClienteDAO clienteDAO = new ClienteDAO(pool);
                    dependente.setCliente(clienteDAO.getCliente_codigo(dependente.getCliente().getCodigo_cliente()));
                    linhasTxt.println("Dependente: " + dependente.getNome_dependente());
                    linhasTxt.println("Titular: " + dependente.getCliente().getNome_cliente());
                } else {
                    linhasTxt.println("Titular: " + dependente.getNome_dependente());
                }
                
//                linhasTxt.println("Cliente: " + dependente.getNome_dependente());
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
                    
                    String descricao_objeto = itens.get(x).getCopia().getObjeto().getTitulo();
                    try {
                        linhasTxt.print(String.format("%-21s", descricao_objeto.substring(0, 19)));
                    } catch (Exception e) {
                        linhasTxt.print(String.format("%-21s", descricao_objeto));
                    }
                    
//                    linhasTxt.print(String.format("%-21s", itens.get(x).getCopia().getObjeto().getTitulo()));
                    linhasTxt.print(String.format("%-7s", data_prevista));
                    linhasTxt.print(data_devolucao);
                    linhasTxt.println();
                }
                Double total_devolucao = moeda.getPrecoFormato(EntradaCaixaDevolucao.jtf_total_a_pagar.getText());
                Double desconto = moeda.getPrecoFormato(EntradaCaixaDevolucao.jtf_desconto.getText());
                Double desconto_entrega_antecipada = moeda.getPrecoFormato(EntradaCaixaDevolucao.jtf_desconto_entrega_antecipada.getText());
                Double subTotal = total_devolucao - (desconto );

                linhasTxt.println("===========================================");
                linhasTxt.println("Débito Anterior (-):        " + EntradaCaixaDevolucao.jtf_saldo.getText());
                linhasTxt.println("Débito Devolução (-):       " + EntradaCaixaDevolucao.jtf_total_relocacao.getText());
                linhasTxt.println("Valor Desconto (+):         " + EntradaCaixaDevolucao.jtf_desconto.getText());
                linhasTxt.println("Valor Desc. Dev. Antec. (+):" + EntradaCaixaDevolucao.jtf_desconto_entrega_antecipada.getText());
                linhasTxt.println("SubTotal (=):               " + moeda.setPrecoFormat(String.valueOf(subTotal)));
                linhasTxt.println("Valor Pago (+):             " + EntradaCaixaDevolucao.jtf_valor_pago.getText());
                linhasTxt.println("Troco (-):                  " + EntradaCaixaDevolucao.jtf_troco.getText());
                linhasTxt.println("===========================================");
                linhasTxt.println("Usuário: " + usuario.getNome_usuario());
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
                if(dependente.getTipo_dependente().equals("Dependente")){                    
                    linhasTxt.println("Dependente: " + dependente.getNome_dependente());
                    linhasTxt.println("Titular: " + dependente.getCliente().getNome_cliente());
                } else {
                    linhasTxt.println("Titular: " + dependente.getNome_dependente());
                }
//                linhasTxt.println("Cliente: " + dependente.getNome_dependente());
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
            }
        } catch (IOException error) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontradao");
        }
    }
    
    public void comprovanteVenda(List<ItemVenda> itens, Dependente dependente, Usuario usuario, Lancamento lancamento) {
        //ESCREVER TXT    
        String nome_arquivo = "Imprimir/comprovanteVenda_" + dependente.getNome_dependente() + ".txt";
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
                linhasTxt.println("Controle Interno: "+ lancamento.getCodigo_lancamento());
                if(dependente.getTipo_dependente().equals("Dependente")){
                    Pool pool = new Pool();
                    ClienteDAO clienteDAO = new ClienteDAO(pool);
                    dependente.setCliente(clienteDAO.getCliente_codigo(dependente.getCliente().getCodigo_cliente()));
                    linhasTxt.println("Dependente: " + dependente.getNome_dependente());
                    linhasTxt.println("Titular: " + dependente.getCliente().getNome_cliente());
                } else {
                    linhasTxt.println("Titular: " + dependente.getNome_dependente());
                }
//                linhasTxt.println("Cliente: " + dependente.getNome_dependente());
                linhasTxt.println("===========================================");
                linhasTxt.println(String.format("%-6s", "Cód    Descrição          P. Unt.  P. Total"));
                //dados da tabela

                Moeda moeda = new Moeda();

                for (int x = 0; x < itens.size(); x++) {
                    if(itens.get(x).getType_product() == 0){
                        linhasTxt.print(String.format("%05d  ", itens.get(x).getPacotePromocional().getCodigo_pacote_promocioanl()));

                        String nome_produto = itens.get(x).getQuantidade()+ "x"+itens.get(x).getPacotePromocional().getDescricao();
                        try {
                            linhasTxt.print(String.format("%-19s", nome_produto.substring(0, 17)));
                        } catch (Exception e) {
                            linhasTxt.print(String.format("%-19s", nome_produto));
                        }

                        linhasTxt.print(String.format("%-8s", moeda.setPrecoFormat(itens.get(x).getPacotePromocional().getValor().toString())));
                        
                    } else if(itens.get(x).getType_product() == 1){
                        linhasTxt.print(String.format("%05d  ", itens.get(x).getProduto().getCodigo_produto()));

                        String nome_produto = itens.get(x).getQuantidade()+ "x"+itens.get(x).getProduto().getNome_produto();
                        try {
                            linhasTxt.print(String.format("%-19s", nome_produto.substring(0, 17)));
                        } catch (Exception e) {
                            linhasTxt.print(String.format("%-19s", nome_produto));
                        }

                        linhasTxt.print(String.format("%-8s", moeda.setPrecoFormat(itens.get(x).getProduto().getPreco_venda().toString())));
                    }
                    linhasTxt.print(String.format("%-8s", moeda.setPrecoFormat(itens.get(x).getPreco_total().toString())));
//                    linhasTxt.print(data_devolucao);
                    linhasTxt.println();
                }
                Double total_venda = moeda.getPrecoFormato(EntradaCaixaVenda.jtf_valor_total_a_pagar.getText());
                Double desconto = moeda.getPrecoFormato(EntradaCaixaVenda.jtf_desconto.getText());                
                Double subTotal = total_venda - (desconto );

                linhasTxt.println("===========================================");
                linhasTxt.println("Débito Anterior (-):        " + EntradaCaixaVenda.jtf_saldo.getText());
                linhasTxt.println("Total Venda (-):            " + EntradaCaixaVenda.jtf_valor_total_venda.getText());
                linhasTxt.println("Valor Desconto (+):         " + EntradaCaixaVenda.jtf_desconto.getText());                
                linhasTxt.println("SubTotal (=):               " + moeda.setPrecoFormat(String.valueOf(subTotal)));
                linhasTxt.println("Valor Pago (+):             " + EntradaCaixaVenda.jtf_valor_pago.getText());
                linhasTxt.println("Troco (-):                  " + EntradaCaixaVenda.jtf_troco.getText());
                linhasTxt.println("===========================================");
                linhasTxt.println("Usuário: " + usuario.getNome_usuario());
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
                if(dependente.getTipo_dependente().equals("Dependente")){                    
                    linhasTxt.println("Dependente: " + dependente.getNome_dependente());
                    linhasTxt.println("Titular: " + dependente.getCliente().getNome_cliente());
                } else {
                    linhasTxt.println("Titular: " + dependente.getNome_dependente());
                }
//                linhasTxt.println("Cliente: " + dependente.getNome_dependente());
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
            }
        } catch (IOException error) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontradao");
        }
    }

    public boolean imprimirArquivo(String nome_arquivo) {
        // imprime arquivo 
        boolean cond = false;
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        try {
            if (!conf.readPropertie("impressora_principal").equals("")) {
                detectaImpressoras(conf.readPropertie("impressora_principal"));
                
                InputStream is = new FileInputStream(nome_arquivo);
                
                
                Scanner sc = new Scanner(is);
                if (impressora != null) {
                    while (sc.hasNextLine()) {
                        String linhas = sc.nextLine();
//                        System.out.println(linhas);
                        if (imprime(linhas) == true) {
                            cond = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Nennhuma impressora foi encontrada. Instale uma impressora padrão \r\n(Generic Text Only) e reinicie o programa.");
                            cond = false;
                            break;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nennhuma impressora foi encontrada. Instale uma impressora padrão \r\n(Generic Text Only) e reinicie o programa.");
                    cond = false;
                }

            } else {
                JOptionPane.showMessageDialog(null, "Impressora não detectada");
                cond = false;
            }
            return cond;
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro encontrado ao imprimir comanda.");
            return cond;
        } catch (PrintException ex) {
            Logger.getLogger(Printer.class.getName()).log(Level.SEVERE, null, ex);
            return cond;
        }
    }
    
//    public boolean emiteComanda(String nome_arquivo){
////        boolean cond = false;
//        ArquivoConfiguracao conf = new ArquivoConfiguracao();
//       try {
//           if (!conf.readPropertie("impressora_principal").equals("")) {
//               InputStream is = new FileInputStream(nome_arquivo);
//                
//                Scanner sc = new Scanner(is);
//                FileOutputStream fs = new FileOutputStream("Bematech_USB " + conf.readPropertie("impressora_principal"));
//                PrintStream ps = new PrintStream(fs);
//
//                while(sc.hasNextLine()){
//                    String linhas = sc.nextLine();
//                    ps.println(linhas);
//                }
//                fs.close(); 
//                return true;
//           } else {
//               JOptionPane.showMessageDialog(null, "Impressora não detectada");
//               return false;
//           }
//        } catch (IOException ex) {
//            JOptionPane.showMessageDialog(null, "Erro encontrado ao imprimir comanda.");
//            return false;
//        }        
//   }
    

    public void printPDF(File f){
        boolean cond = false;
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        try{
            if (!conf.readPropertie("impressora_alternativa").equals("")) {
                detectaImpressoras(conf.readPropertie("impressora_alternativa"));                
            } 
            
            DocFlavor dflavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            PrintService[] impressoras = PrintServiceLookup.lookupPrintServices(dflavor, null);
            for(PrintService ps : impressoras){
                System.out.println("Impressora Encontrada: "+ps.getName());
                if(ps.getName().contains(conf.readPropertie("impressora_alternativa"))){
                    System.out.println("Impressora Selecionada: "+ps.getName());
                    impressora = ps;
                    break;
                }
            }
            DocPrintJob dpj = impressora.createPrintJob();  
            FileInputStream fis = new FileInputStream(f);
            byte[] buffer = new byte[fis.available()];
            int buff = 0;
            while((buff = fis.available()) != 0){
                fis.read(buffer, 0, buff);
            }
            System.out.println(new String(buffer));
            InputStream stream = new ByteArrayInputStream(buffer);  
            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;  
            Doc doc = new SimpleDoc(stream, flavor, null);  
            dpj.print(doc, null);
            
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Configurar impressora Alternativa");
            //e.printStackTrace();
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

        try {
            DocPrintJob dpj = impressora.createPrintJob();
            InputStream stream = new ByteArrayInputStream((texto + "\n").getBytes("UTF-8"));
//            InputStream stream = new ByteArrayInputStream((texto + "\n").getBytes()); 
            System.out.println(texto);
            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            Doc doc = new SimpleDoc(stream, flavor, null);
            dpj.print(doc, null);
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
            return false;

        }

    }

}
