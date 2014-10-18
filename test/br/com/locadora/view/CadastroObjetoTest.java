/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.view;

import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.bean.Genero;
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
public class CadastroObjetoTest {
    
    public CadastroObjetoTest() {
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
     * Test of main method, of class CadastroObjeto.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        CadastroObjeto.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTela method, of class CadastroObjeto.
     */
    @Test
    public void testSetTela() {
        System.out.println("setTela");
        String permissao = "";
        CadastroObjeto instance = new CadastroObjeto();
        instance.setTela(permissao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificarCampos method, of class CadastroObjeto.
     */
    @Test
    public void testVerificarCampos() {
        System.out.println("verificarCampos");
        CadastroObjeto instance = new CadastroObjeto();
        boolean expResult = false;
        boolean result = instance.verificarCampos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificarCamposCopia method, of class CadastroObjeto.
     */
    @Test
    public void testVerificarCamposCopia() {
        System.out.println("verificarCamposCopia");
        CadastroObjeto instance = new CadastroObjeto();
        boolean expResult = false;
        boolean result = instance.verificarCamposCopia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatusTela method, of class CadastroObjeto.
     */
    @Test
    public void testSetStatusTela() {
        System.out.println("setStatusTela");
        boolean status = false;
        CadastroObjeto instance = new CadastroObjeto();
        instance.setStatusTela(status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificar_campo_copia method, of class CadastroObjeto.
     */
    @Test
    public void testVerificar_campo_copia() {
        System.out.println("verificar_campo_copia");
        CadastroObjeto instance = new CadastroObjeto();
        boolean expResult = false;
        boolean result = instance.verificar_campo_copia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificaTabela method, of class CadastroObjeto.
     */
    @Test
    public void testVerificaTabela() {
        System.out.println("verificaTabela");
        CadastroObjeto instance = new CadastroObjeto();
        boolean expResult = false;
        boolean result = instance.verificaTabela();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of carregaDiaria method, of class CadastroObjeto.
     */
    @Test
    public void testCarregaDiaria() {
        System.out.println("carregaDiaria");
        Diaria diaria = null;
        CadastroObjeto instance = new CadastroObjeto();
        instance.carregaDiaria(diaria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of carregaGenero method, of class CadastroObjeto.
     */
    @Test
    public void testCarregaGenero() {
        System.out.println("carregaGenero");
        Genero genero = null;
        CadastroObjeto instance = new CadastroObjeto();
        instance.carregaGenero(genero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRequestDiaria method, of class CadastroObjeto.
     */
    @Test
    public void testSetRequestDiaria() {
        System.out.println("setRequestDiaria");
        CadastroObjeto instance = new CadastroObjeto();
        instance.setRequestDiaria();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRequestGenero method, of class CadastroObjeto.
     */
    @Test
    public void testSetRequestGenero() {
        System.out.println("setRequestGenero");
        CadastroObjeto instance = new CadastroObjeto();
        instance.setRequestGenero();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getObjetoDiaria method, of class CadastroObjeto.
     */
    @Test
    public void testGetObjetoDiaria() {
        System.out.println("getObjetoDiaria");
        Diaria expResult = null;
        Diaria result = CadastroObjeto.getObjetoDiaria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getObjetoGenero method, of class CadastroObjeto.
     */
    @Test
    public void testGetObjetoGenero() {
        System.out.println("getObjetoGenero");
        Genero expResult = null;
        Genero result = CadastroObjeto.getObjetoGenero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
