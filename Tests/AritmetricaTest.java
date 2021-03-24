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
public class AritmetricaTest {
    
    public AritmetricaTest() {
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
     * Test of operacion method, of class Aritmetrica.
     */
    @Test
    public void testOperacion() {
        System.out.println("operacion");
        ArrayList<String> ope = new ArrayList<String>();
        Aritmetrica instance = new Aritmetrica();
        ope.add("1");
        ope.add("+");
        ope.add("2");
        String expResult = "3.0";
        String result = instance.operacion(ope);
        assertEquals(expResult, result);
        
    }
    
}
