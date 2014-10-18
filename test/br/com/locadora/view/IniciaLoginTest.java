/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.view;

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
public class IniciaLoginTest {
    
    public IniciaLoginTest() {
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
     * Test of limparCampos method, of class IniciaLogin.
     */
    @Test
    public void testLimparCampos() {
        System.out.println("limparCampos");
        IniciaLogin instance = new IniciaLogin();
        instance.limparCampos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class IniciaLogin.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        IniciaLogin.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificaLogin method, of class IniciaLogin.
     */
    @Test
    public void testVerificaLogin() {
        System.out.println("verificaLogin");
        IniciaLogin instance = new IniciaLogin();
        boolean expResult = false;
        boolean result = instance.verificaLogin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
