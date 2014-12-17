package br.com.locadora.barcode;  
  
import java.awt.print.PageFormat;  
import java.awt.print.Pageable;
import java.awt.print.Paper;  
import java.awt.print.PrinterException;  
import java.awt.print.PrinterJob;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
import java.util.Properties;  
  
import javax.print.PrintException;  
import javax.print.PrintService;  
import javax.print.PrintServiceLookup;  
import javax.print.attribute.HashPrintRequestAttributeSet;  
import javax.print.attribute.PrintRequestAttributeSet;  
import javax.print.attribute.standard.JobName;  
import javax.print.attribute.standard.PageRanges;  
import org.jpedal.PdfDecoder;
import org.jpedal.exception.PdfException;
  
//import org.jpedal.PdfDecoder;  
//import org.jpedal.exception.PdfException;  
  
public class HPTPDFPrintService {  
  
    private String                   fileName          = null;  
    private FileInputStream          fileInput         = null;  
    private PrintService[]           services          = null;  
    private PrintService             defaultPrinter    = null;  
    private PrinterJob               printerJob        = null;  
    private PrintRequestAttributeSet printerAttributes = null;  
    private PdfDecoder               decoder           = null;  
    private Paper                    paper             = null;  
    private PageFormat               pageFormat        = null;  
      
    public HPTPDFPrintService(String fileName)  {  
        this.fileName = fileName;  
    }  
      
      
    private void configurePage(double width, double height) {  
          
        double polegada    = 0.393700787;  
        double paperWidth  = (width / 10) * polegada * 72;  
        double paperHeight = (height / 10) * polegada * 72;  
          
        this.paper = new Paper();  
        this.paper.setSize(paperWidth, paperHeight);  
        this.paper.setImageableArea(0, 0, this.paper.getWidth(), this.paper.getHeight());  
          
        this.pageFormat = printerJob.defaultPage();  
        this.pageFormat.setPaper(this.paper);  
        this.decoder.setPageFormat(pageFormat);  
    }  
      
    private void loadConfiguration() throws FileNotFoundException, PdfException {  
        File file      = new File(fileName);  
        String jobName = file.getName().substring(0, file.getName().lastIndexOf("."));   
        this.fileInput = new FileInputStream(file);  
        this.services = PrintServiceLookup.lookupPrintServices(null, null);  
        /* Impressora padr�o */  
        this.defaultPrinter    = PrintServiceLookup.lookupDefaultPrintService();  
        if (this.defaultPrinter == null) {  
            this.defaultPrinter = this.services[this.services.length-1];  
        }  
          
        this.printerAttributes = new HashPrintRequestAttributeSet();  
        this.printerAttributes.add(new JobName(jobName, null));  
        this.decoder = new PdfDecoder();  
        this.decoder.openPdfFile(this.fileName);  
        this.printerJob = PrinterJob.getPrinterJob();  
    }  
      
    private void releaseConfiguration() throws IOException {  
        this.fileInput.close();  
        this.fileInput         = null;  
        this.services          = null;  
        this.defaultPrinter    = null;  
        this.printerAttributes = null;  
        this.decoder.closePdfFile();  
        this.decoder           = null;  
        this.printerJob        = null;  
    }  
      
      
    private void loadPageConfiguration() throws FileNotFoundException, IOException {  
        File file = new File("HPTPDFPrintService.properties");  
          
        float defaultHeight = 210f;  
        float defaultWidth  = 290f;  
          
        if (!file.exists()) {  
            /* se o arquivo de configura��o n�o for encontrador  
             * � usado o padr�o A4*/  
            configurePage(defaultHeight, defaultWidth);  
            return;  
        }  
          
        FileInputStream fileIn = new FileInputStream(file);  
        Properties properties = new Properties();  
        properties.load(fileIn);  
          
        String strHeight = properties.getProperty("paper.height");  
        String strWidth  = properties.getProperty("paper.width");  
          
        float height = 0f;  
        float width  = 0f;  
          
        try {  
            height = Float.parseFloat(strHeight);  
            width  = Float.parseFloat(strWidth);  
        } catch (NumberFormatException e) {  
            height = defaultHeight;  
            width = defaultWidth;  
        }  
        configurePage(height, width);  
    }  
      
    public void print() throws PrintException,   
            FileNotFoundException, IOException, PdfException, PrinterException  {  
        loadConfiguration();  
        try {  
            this.printerAttributes.add(new PageRanges(1, decoder.getPageCount()));  
              
            loadPageConfiguration();  
            this.decoder.setTextPrint(PdfDecoder.TEXT);  
            this.printerJob.setPageable((Pageable) this.decoder);  
              
            if (this.printerJob.printDialog(this.printerAttributes)) {  
                this.printerJob.print(this.printerAttributes);  
            }  
            releaseConfiguration();  
        } finally {  
        }  
    }  
}  