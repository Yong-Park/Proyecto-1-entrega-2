/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author GAMING
 */
public class ListaTest {
    
    public ListaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of ConvertirLista method, of class Lista.
     */
    @Test
    public void testConvertirLista() {
        System.out.println("ConvertirLista");
        ArrayList<String> ope = new ArrayList();
        String [] otherLista = {"hola","adios","quetal"};
        for (int i = 0 ; i < otherLista.length ; i++){
            ope.add(otherLista[i]);
        }
        Lista instance = new Lista();
        ArrayList<String> expResult = ope;
        ArrayList<String> result = instance.ConvertirLista(ope);
        assertEquals(expResult, result);
        
    }
    
}
