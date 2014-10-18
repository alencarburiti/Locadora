/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.view;

import br.com.locadora.model.bean.Genero;
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
public class MenuGeneroTest {
    
    public MenuGeneroTest() {
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
     * Test of main method, of class MenuGenero.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MenuGenero.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarDados method, of class MenuGenero.
     */
    @Test
    public void testBuscarDados() {
        System.out.println("buscarDados");
        MenuGenero instance = new MenuGenero();
        instance.buscarDados();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tbGeneroLinhaSelecionada method, of class MenuGenero.
     */
    @Test
    public void testTbGeneroLinhaSelecionada() {
        System.out.println("tbGeneroLinhaSelecionada");
        JTable tb = null;
        MenuGenero instance = new MenuGenero();
        Genero expResult = null;
        Genero result = instance.tbGeneroLinhaSelecionada(tb);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of request method, of class MenuGenero.
     */
    @Test
    public void testRequest() {
        System.out.println("request");
        MenuGenero instance = new MenuGenero();
        instance.request();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeGenero method, of class MenuGenero.
     */
    @Test
    public void testRemoveGenero() {
        System.out.println("removeGenero");
        JTable tb = null;
        MenuGenero instance = new MenuGenero();
        Genero expResult = null;
        Genero result = instance.removeGenero(tb);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTelaPrincipal method, of class MenuGenero.
     */
    @Test
    public void testSetTelaPrincipal() {
        System.out.println("setTelaPrincipal");
        TelaPrincipal_Interface telaPrincipal = null;
        MenuGenero instance = new MenuGenero();
        instance.setTelaPrincipal(telaPrincipal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatusTela method, of class MenuGenero.
     */
    @Test
    public void testSetStatusTela() {
        System.out.println("setStatusTela");
        boolean status = false;
        MenuGenero instance = new MenuGenero();
        instance.setStatusTela(status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterar method, of class MenuGenero.
     */
    @Test
    public void testAlterar() {
        System.out.println("alterar");
        MenuGenero instance = new MenuGenero();
        instance.alterar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
