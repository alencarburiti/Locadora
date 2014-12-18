/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

/**
 *
 * @author alencarburiti
 */
public class ArquivoConfiguracao {
    
    private ResourceBundle config;
    private String impressora;
    
    public String readPropertie(String propertie){
        File configFile = new File("config.properties");
        String valor_property = "";
        try {
            FileReader reader = new FileReader(configFile);
            Properties props = new Properties();
            props.load(reader);

            valor_property = props.getProperty(propertie);

            System.out.println("Property: " + propertie + " - Valor: "+ valor_property);
            reader.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo de configuração não encontrado.\n Favor entrar em contato com o administrador do Sistema");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Favor entrar em contato com o administrador do Sistema. Error: " +propertie);
            ex.printStackTrace();
        }
        return valor_property;
    }
    
    public void writePropertie(String key, String valor){
        File configFile = new File("config.properties");
 
        try {
            FileReader reader = new FileReader(configFile);
            Properties props = new Properties();
            props.load(reader);
            props.setProperty(key, valor);
            FileWriter writer = new FileWriter(configFile);
            props.store(writer, null);
            writer.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo de configuração não encontrado.\n Favor entrar em contato com o administrador do Sistema");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Favor entrar em contato com o administrador do Sistema. Error: " +key+ " "+ valor);
        }
    }
        
}
