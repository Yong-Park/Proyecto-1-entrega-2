/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class QuoteTest {
    
    public QuoteTest() {
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
     * Test of opQuote method, of class Quote.
     */
    @Test
    public void testOpQuote() {
        System.out.println("opQuote");
        String aString = "quote ( 1 + 2 )";
        Quote instance = new Quote();
        String expResult = " ( 1 + 2 )";
        String result = instance.opQuote(aString);
        assertEquals(expResult, result);
       
    }
    
}
