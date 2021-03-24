import java.util.ArrayList;

/*
FuncionesExtra
Integrantes
Yong Bum Park, 20117
Jorge Caballeros Pérez, 20079
Rolando Natanael Girón, 20029
*/ 

public class FuncionesExtra{
    // menu
    public static void menu() {
        System.out.println("-------------------");
        System.out.println("Bien venidos");
        System.out.println("Estos son los tipos que puede realizar este interprete");
        System.out.println("-------------------");
        System.out.println("Aritmetrica");
        System.out.println("Defun");
        System.out.println("Predicado (<,>,=)");
        System.out.println("ATOM");
        System.out.println("SETQ");
        System.out.println("-------------------");
    }
    
    
    /** 
     * @param ope
     * @param list
     * @return int
     */
    //revisar
    public static int verificar(ArrayList<String> ope, boolean list){
        //regresa  si no es ninguno de estos y seria una aritmetrica
        int resultado = 0;
        if(ope.contains("Defun")){
            resultado = 1;
            return resultado;
        }else if(ope.contains(">")){
            resultado = 2;
            return resultado;
        }else if(ope.contains("<")){
            resultado = 2;
            return resultado;
        }else if(ope.contains("equal")){
            resultado = 2;
            return resultado;
        }else if(ope.contains("atom")){
            resultado = 3;
            return resultado;
        }else if(ope.contains("setq")){
            resultado = 4;
            return resultado;
        }else if(ope.contains("quote") || ope.contains("'")){
            resultado = 5;
            return resultado;
        }else if(ope.isEmpty()){
            resultado = 6;
            return resultado;
        }else if(list==true){
            resultado = 7 ;
            return resultado;
        }else if(ope.contains("Cond")){
            resultado = 2;
            return resultado;
        }
        return resultado;
        
    }

    
    /** 
     * @param str
     * @return boolean
     */
    //is numeric
    public static boolean isNumeric(String str) { 
        try {  
          Double.parseDouble(str);  
          return true;
        } catch(NumberFormatException e){  
          return false;  
        }  
      }
}