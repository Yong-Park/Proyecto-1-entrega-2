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
public class DefunTest {
    
    public DefunTest() {
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

    
    @Test
    public void testFuncion() {
        System.out.println("funcion");
        ArrayList<String> ope = new ArrayList<String>();
       
       ope.add("Defun");
       ope.add("FTOC");
       ope.add("TEMP");
       ope.add("/");
       ope.add("-");
       ope.add("TEMP");
       ope.add("32");
       ope.add("1.8");
       
        String expResult = "5.0";
        String result = Defun.funcion(ope , 41.0f);
        assertEquals(expResult, result);
    }

    
    

    


    
    
    }
    
}
