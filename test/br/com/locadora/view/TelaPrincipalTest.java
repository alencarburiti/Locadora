/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.view;

import br.com.locadora.model.bean.Usuario;
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
public class TelaPrincipalTest {
    
    public TelaPrincipalTest() {
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
     * Test of main method, of class TelaPrincipal.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        TelaPrincipal.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatusTela method, of class TelaPrincipal.
     */
    @Test
    public void testSetStatusTela() {
        System.out.println("setStatusTela");
        boolean status = false;
        TelaPrincipal instance = new TelaPrincipal();
        instance.setStatusTela(status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of carregaUsuario method, of class TelaPrincipal.
     */
    @Test
    public void testCarregaUsuario() {
        System.out.println("carregaUsuario");
        Usuario usuario = null;
        TelaPrincipal instance = new TelaPrincipal();
        instance.carregaUsuario(usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
