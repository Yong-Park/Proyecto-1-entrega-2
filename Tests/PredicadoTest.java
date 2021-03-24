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
public class PredicadoTest {
    
    public PredicadoTest() {
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
     * Test of revisar method, of class Predicado.
     */
    @Test
    public void testRevisar() {
        System.out.println("revisar");
        ArrayList<String> dato = new ArrayList<String>();
        dato.add("1");
        dato.add(">");
        dato.add("2");
        Predicado instance = new Predicado();
        String expResult = "False";
        String result = instance.revisar(dato);
        assertEquals(expResult, result);
        
    }

    
    
}
