/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Bar.java
 *
 * Created on 31/07/2009, 23:10:24
 */
package br.com.locadora.barcode;

import br.com.locadora.util.Printer;
import br.com.locadora.view.TelaPrincipal;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.jbars.Barcode;

/**
 *
 * @author boskyn
 */
public class Bar extends javax.swing.JFrame {

    private Color corBarraSelecionada = Color.BLACK;
    private Color corTextoSelecionada = Color.BLACK;
    private Image imagem1;
    private Image imagem2;
    private Image imagem3;
    private Image imagem4;
    public TelaPrincipal janelapai;

    /**
     * Creates new form Bar
     */
    public Bar() {
        initComponents();

    }

    private String getCodigo(int selectedIndex) {
        switch (selectedIndex) {
            case 0:
                return Barcode.TYPE_CODE128;
            case 1:
                return Barcode.TYPE_CODE93;
            case 2:
                return Barcode.TYPE_INTERLEAVED2OF5;
            default:
                return Barcode.TYPE_CODE128;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        imagemLabel1 = new javax.swing.JLabel();
        imagemLabel4 = new javax.swing.JLabel();
        imagemLabel2 = new javax.swing.JLabel();
        imagemLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtf_codigo_1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        altura = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        fonteSize = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        paletaCorBarra = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        paletaCorTexto = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        codigoEscolha = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        rotacao = new javax.swing.JSpinner();
        jtf_codigo_3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtf_codigo_2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtf_codigo_4 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jb_gerar_barra = new javax.swing.JButton();
        jb_imprimir = new javax.swing.JButton();
        jb_salvar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerar BarCode ");
        setName("frm_barcode"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        imagemLabel1.setBackground(new java.awt.Color(254, 254, 254));
        imagemLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        imagemLabel4.setBackground(new java.awt.Color(254, 254, 254));
        imagemLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        imagemLabel2.setBackground(new java.awt.Color(254, 254, 254));
        imagemLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        imagemLabel3.setBackground(new java.awt.Color(254, 254, 254));
        imagemLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagemLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagemLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagemLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagemLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagemLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(imagemLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(imagemLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(imagemLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(76, 76, 76)), "Atributos"));

        jLabel2.setText("Código 1:");

        jtf_codigo_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_codigo_1KeyPressed(evt);
            }
        });

        jLabel3.setText("Altura:");

        altura.setModel(new javax.swing.SpinnerNumberModel(70, 0, 200, 1));

        jLabel4.setText("Fonte Size:");

        fonteSize.setModel(new javax.swing.SpinnerNumberModel(10, 0, 50, 1));

        jLabel5.setText("Cor da Barra:");

        paletaCorBarra.setText("Paleta");
        paletaCorBarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paletaCorBarraActionPerformed(evt);
            }
        });

        jLabel6.setText("Cor do texto:");

        paletaCorTexto.setText("Paleta");
        paletaCorTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paletaCorTextoActionPerformed(evt);
            }
        });

        jLabel7.setText("Tipo de código:");

        codigoEscolha.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CODE128", "CODE93", "INTERLEAVED2OF5" }));

        jLabel8.setText("Rotação:");

        rotacao.setModel(new javax.swing.SpinnerNumberModel(0, 0, 360, 90));

        jtf_codigo_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_codigo_3KeyPressed(evt);
            }
        });

        jLabel9.setText("Código 3:");

        jtf_codigo_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_codigo_2KeyPressed(evt);
            }
        });

        jLabel10.setText("Código 2:");

        jLabel11.setText("Código 4:");

        jtf_codigo_4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_codigo_4KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codigoEscolha, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(179, 179, 179))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(paletaCorTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(paletaCorBarra)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fonteSize, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(altura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rotacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtf_codigo_1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtf_codigo_2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_codigo_3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_codigo_4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtf_codigo_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jtf_codigo_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtf_codigo_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jtf_codigo_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(codigoEscolha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(paletaCorBarra))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(paletaCorTexto)
                            .addComponent(jLabel4)
                            .addComponent(fonteSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(altura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(rotacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));

        jb_gerar_barra.setText("Gerar Barra");
        jb_gerar_barra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_gerar_barraActionPerformed(evt);
            }
        });
        jPanel3.add(jb_gerar_barra);

        jb_imprimir.setText("Imprimir");
        jb_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_imprimirActionPerformed(evt);
            }
        });
        jPanel3.add(jb_imprimir);

        jb_salvar.setText("Salvar");
        jb_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_salvarActionPerformed(evt);
            }
        });
        jPanel3.add(jb_salvar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jb_gerar_barraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_gerar_barraActionPerformed

        imagem1 = Barcode.createImage(getCodigo(codigoEscolha.getSelectedIndex()), jtf_codigo_1.getText(),
                new Float(altura.getValue().toString()), Font.SERIF, Integer.parseInt(fonteSize.getValue().toString()),
                true, Barcode.ALIGN_CENTER, Font.ITALIC, corBarraSelecionada, corTextoSelecionada,
                Integer.parseInt(rotacao.getValue().toString()));
        imagemLabel1.setIcon(new ImageIcon(imagem1));

        imagem2 = Barcode.createImage(getCodigo(codigoEscolha.getSelectedIndex()), jtf_codigo_2.getText(),
                new Float(altura.getValue().toString()), Font.SERIF, Integer.parseInt(fonteSize.getValue().toString()),
                true, Barcode.ALIGN_CENTER, Font.ITALIC, corBarraSelecionada, corTextoSelecionada,
                Integer.parseInt(rotacao.getValue().toString()));
        imagemLabel2.setIcon(new ImageIcon(imagem2));

        imagem3 = Barcode.createImage(getCodigo(codigoEscolha.getSelectedIndex()), jtf_codigo_3.getText(),
                new Float(altura.getValue().toString()), Font.SERIF, Integer.parseInt(fonteSize.getValue().toString()),
                true, Barcode.ALIGN_CENTER, Font.ITALIC, corBarraSelecionada, corTextoSelecionada,
                Integer.parseInt(rotacao.getValue().toString()));
        imagemLabel3.setIcon(new ImageIcon(imagem3));

        imagem4 = Barcode.createImage(getCodigo(codigoEscolha.getSelectedIndex()), jtf_codigo_4.getText(),
                new Float(altura.getValue().toString()), Font.SERIF, Integer.parseInt(fonteSize.getValue().toString()),
                true, Barcode.ALIGN_CENTER, Font.ITALIC, corBarraSelecionada, corTextoSelecionada,
                Integer.parseInt(rotacao.getValue().toString()));
        imagemLabel4.setIcon(new ImageIcon(imagem4));

    }//GEN-LAST:event_jb_gerar_barraActionPerformed

    private void paletaCorBarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paletaCorBarraActionPerformed
        // TODO add your handling code here:
        corBarraSelecionada = JColorChooser.showDialog(this, "Cor da Barra", corBarraSelecionada);
        paletaCorBarra.setBackground(corBarraSelecionada);
    }//GEN-LAST:event_paletaCorBarraActionPerformed

    private void paletaCorTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paletaCorTextoActionPerformed
        // TODO add your handling code here:
        corTextoSelecionada = JColorChooser.showDialog(this, "Cor da Barra", corTextoSelecionada);
        paletaCorTexto.setBackground(corTextoSelecionada);
}//GEN-LAST:event_paletaCorTextoActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        setVisible(false);
        janelapai.setStatusTela(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void jtf_codigo_1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_codigo_1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_codigo_2.requestFocus();
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_codigo_1KeyPressed

    private void jtf_codigo_2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_codigo_2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_codigo_3.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_codigo_2KeyPressed

    private void jtf_codigo_3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_codigo_3KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_codigo_4.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_codigo_3KeyPressed

    private void jtf_codigo_4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_codigo_4KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_gerar_barra.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_codigo_4KeyPressed

    private void jb_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_imprimirActionPerformed
        String arquivo = "Etiqueta/Etiqueta.pdf";
        File file = new File(arquivo);
        Document document = new Document();
        try {

            com.itextpdf.text.Image imageEnvio1 = com.itextpdf.text.Image.getInstance(imagem1, null);
            com.itextpdf.text.Image imageEnvio2 = com.itextpdf.text.Image.getInstance(imagem2, null);
            com.itextpdf.text.Image imageEnvio3 = com.itextpdf.text.Image.getInstance(imagem3, null);
            com.itextpdf.text.Image imageEnvio4 = com.itextpdf.text.Image.getInstance(imagem4, null);

            
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            
            Paragraph p = new Paragraph();
            p.add(new Paragraph());
            p.add(new Paragraph());
            
            p.add(new Chunk(imageEnvio1, 0, -40));

            p.add(new Chunk(imageEnvio2, 40, -40));

            p.add(new Chunk(imageEnvio3, 80, -40));

            p.add(new Chunk(imageEnvio4, 120, -40));

            document.add(p);

            document.close();
        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
            System.out.println("Erro!");
        }
        
        try {
            Printer printer = new Printer();
            printer.printPDF(file);
            
//            HPTPDFPrintService printService = new HPTPDFPrintService(arquivo);  
//            printService.print();  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        
    }//GEN-LAST:event_jb_imprimirActionPerformed

    private void jb_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salvarActionPerformed

        String arquivo = "Etiqueta/Etiqueta.pdf";
        File file = new File(arquivo);
        JFileChooser jfile = new JFileChooser(file);
        jfile.showSaveDialog(this);
        Document document = new Document();
        try {

            com.itextpdf.text.Image imageEnvio1 = com.itextpdf.text.Image.getInstance(imagem1, null);
            com.itextpdf.text.Image imageEnvio2 = com.itextpdf.text.Image.getInstance(imagem2, null);
            com.itextpdf.text.Image imageEnvio3 = com.itextpdf.text.Image.getInstance(imagem3, null);
            com.itextpdf.text.Image imageEnvio4 = com.itextpdf.text.Image.getInstance(imagem4, null);

            if (jfile.getSelectedFile() != null) {
                PdfWriter.getInstance(document, new FileOutputStream(jfile.getSelectedFile()));
                document.open();
            } else {

                PdfWriter.getInstance(document, new FileOutputStream(file));
                document.open();
            }

            Paragraph p = new Paragraph();
            p.add(new Paragraph());
            p.add(new Paragraph());
            
            p.add(new Chunk(imageEnvio1, 0, -40));

            p.add(new Chunk(imageEnvio2, 40, -40));

            p.add(new Chunk(imageEnvio3, 80, -40));

            p.add(new Chunk(imageEnvio4, 120, -40));

            document.add(p);

            document.close();
        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
            System.out.println("Erro!");
        }
        
// TODO add your handling code here:
    }//GEN-LAST:event_jb_salvarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    new Bar().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Bar.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Bar.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Bar.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Bar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner altura;
    private javax.swing.JComboBox codigoEscolha;
    private javax.swing.JSpinner fonteSize;
    private javax.swing.JLabel imagemLabel1;
    private javax.swing.JLabel imagemLabel2;
    private javax.swing.JLabel imagemLabel3;
    private javax.swing.JLabel imagemLabel4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jb_gerar_barra;
    private javax.swing.JButton jb_imprimir;
    private javax.swing.JButton jb_salvar;
    private javax.swing.JTextField jtf_codigo_1;
    private javax.swing.JTextField jtf_codigo_2;
    private javax.swing.JTextField jtf_codigo_3;
    private javax.swing.JTextField jtf_codigo_4;
    private javax.swing.JButton paletaCorBarra;
    private javax.swing.JButton paletaCorTexto;
    private javax.swing.JSpinner rotacao;
    // End of variables declaration//GEN-END:variables


}