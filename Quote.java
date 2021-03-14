import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Quote {
    public String opQuote (String aString){
        char ch  = aString.charAt(0);
        String resultado = "Este no es";
        if (ch == '\'' || ch == 'q' ){
            resultado  = aString.toUpperCase();
            resultado = resultado.replace("'", "");
            resultado = resultado.replace("QUOTE", "");
        }
        else{
            System.out.println("Syntax Error");
        }
        return  resultado;
    }

    @Test
    public void testOpQuote(){
        assertEquals("( 1 + 3 )", opQuote("quote ( 1 + 3 )"));
        assertEquals("( + 4  5 )", opQuote("' ( + 4  5 )"));

    }
}


