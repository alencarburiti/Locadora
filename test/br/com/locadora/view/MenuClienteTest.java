/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.view;

import br.com.locadora.model.bean.Cliente;
import javax.swing.JTable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alencarburiti
 */
public class MenuClienteTest {
    
    public MenuClienteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setJanelaPai method, of class MenuCliente.
     */
    @Test
    public void testSetJanelaPai() {
        System.out.println("setJanelaPai");
        TelaPrincipal janelapai = null;
        MenuCliente instance = new MenuCliente();
        instance.setJanelaPai(janelapai);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class MenuCliente.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MenuCliente.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarDados method, of class MenuCliente.
     */
    @Test
    public void testBuscarDados() {
        System.out.println("buscarDados");
        MenuCliente instance = new MenuCliente();
        instance.buscarDados();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tbClienteLinhaSelecionada method, of class MenuCliente.
     */
    @Test
    public void testTbClienteLinhaSelecionada() {
        System.out.println("tbClienteLinhaSelecionada");
        JTable tb = null;
        MenuCliente instance = new MenuCliente();
        Cliente expResult = null;
        Cliente result = instance.tbClienteLinhaSelecionada(tb);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterar method, of class MenuCliente.
     */
    @Test
    public void testAlterar() {
        System.out.println("alterar");
        MenuCliente instance = new MenuCliente();
        instance.alterar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTelaPrincipal method, of class MenuCliente.
     */
    @Test
    public void testSetTelaPrincipal() {
        System.out.println("setTelaPrincipal");
        TelaPrincipal_Interface telaPrincipal = null;
        MenuCliente instance = new MenuCliente();
        instance.setTelaPrincipal(telaPrincipal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tbClienteSelecionado method, of class MenuCliente.
     */
    @Test
    public void testTbClienteSelecionado() {
        System.out.println("tbClienteSelecionado");
        JTable tb = null;
        MenuCliente instance = new MenuCliente();
        Cliente expResult = null;
        Cliente result = instance.tbClienteSelecionado(tb);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of statusTela method, of class MenuCliente.
     */
    @Test
    public void testStatusTela() {
        System.out.println("statusTela");
        boolean status = false;
        MenuCliente instance = new MenuCliente();
        instance.statusTela(status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
