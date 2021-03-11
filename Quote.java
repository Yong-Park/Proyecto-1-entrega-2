public class Quote {
    public String opQuote (String aString){
        char ch  = aString.charAt(0);
        char  ch2 = aString.charAt(2);
        String resultado = "Este no es";
        if (ch == '\'' && ch2 == '('){
            resultado  = aString.toUpperCase();
        }
        else{
            System.out.println("Syntax Error");
        }

        return  resultado;
    }
}
