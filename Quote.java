/*
Integrantes
Yong Bum Park, 20117
Jorge Caballeros Pérez, 20009
Rolando Natanael Girón, 20029
*/ 
public class Quote {
    
    /** 
     * @param aString
     * @return String
     */
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
}