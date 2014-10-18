/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.view;

import java.util.List;
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
public class AtualizaGeneroTest {
    
    public AtualizaGeneroTest() {
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
     * Test of main method, of class AtualizaGenero.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        AtualizaGenero.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alimentaCampos method, of class AtualizaGenero.
     */
    @Test
    public void testAlimentaCampos() {
        System.out.println("alimentaCampos");
        List<MenuGenero> destinos = null;
        AtualizaGenero instance = new AtualizaGenero();
        instance.alimentaCampos(destinos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificarCampos method, of class AtualizaGenero.
     */
    @Test
    public void testVerificarCampos() {
        System.out.println("verificarCampos");
        AtualizaGenero instance = new AtualizaGenero();
        boolean expResult = false;
        boolean result = instance.verificarCampos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retornaJanelaPai method, of class AtualizaGenero.
     */
    @Test
    public void testRetornaJanelaPai() {
        System.out.println("retornaJanelaPai");
        AtualizaGenero instance = new AtualizaGenero();
        instance.retornaJanelaPai();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
