import java.util.ArrayList;
import java.util.Collections;

public class Predicado{

    public String revisar (ArrayList<String> dato){
        
        String data1;
        String data2;
        Float num1;
        Float num2;
        //arraylist para los numeros y otro para el signo
        ArrayList<Float> numeros = new ArrayList<Float>();
        ArrayList<String> letra  = new ArrayList<String>();
        ArrayList<String> signos = new ArrayList<String>();
        //lectura de los datos
        for(String s : dato){
            if(isNumeric(s)){
                numeros.add(Float.parseFloat(s));
            }else if(s.equals("equal") || s.equals(">") || s.equals("<")){
                if(s.equals("equal")){
                    signos.add("==");
                }else{
                    signos.add(s);
                }
            }else{
                if(s.equals("Cond")){
                    //no pasa nada
                }else{
                    letra.add(s);
                }
            }
        }
        //revisar para enviar resultado
        if(signos.get(0).equals("==")){
            if(numeros.size()==2){
                num1 = numeros.get(0);
                numeros.remove(0);
                num2= numeros.get(0);
                numeros.remove(0);
                if(num1.equals(num2)){  
                    return "True";
                }else{
                    return "False";
                }
            }else if(numeros.size()==1 && letra.size()==1){
                return "False";
            }else{
                data1 = letra.get(0);
                letra.remove(0);
                data2 = letra.get(0);
                letra.remove(0);
                if(data1.equals(data2)){
                    return "True";
                }else{
                    return "False";
                }
            }
        }else if(signos.get(0).equals("<")){
            if(numeros.size()==2){
                num1 = numeros.get(0);
                numeros.remove(0);
                num2= numeros.get(0);
                numeros.remove(0);
                if(num1 < num2){
                    return "True";
                }else if(numeros.size()==1 && letra.size()==1){
                    return "False";
                }else{
                    return "False";
                }
            }else{
                return "False";
            }
        }else if(signos.get(0).equals(">")){
            if(numeros.size()==2){
                num1 = numeros.get(0);
                numeros.remove(0);
                num2= numeros.get(0);
                numeros.remove(0);
                if(num1 > num2){
                    return "True";
                }else if(numeros.size()==1 && letra.size()==1){
                    return "False";
                }else{
                    return "False";
                }
            }else{
                return "False";
            }
        }
        return "no se puede"; 
    }

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
