/*
Integrantes
Yong Bum Park, 20117
Jorge Caballeros Pérez, 20079
Rolando Natanael Girón, 20029
*/ 
import java.util.ArrayList;
public class ATOM {

    
    /** 
     * @param dato
     * @return String
     */
    public String validar (ArrayList<String> dato){

        //arraylist para agregar la palabra atom y dejar solo el valor
        ArrayList<String> palabra = new ArrayList<String>();

        //Se guarda la palabra en el array
        for(String s : dato){
            if(s.equals("atom")){
                //no pasa nada
            }else{
                palabra.add(s);
            }
        }
        //revisar si solo es una candena y no tiene mas de una
        if(palabra.size()==1){
            return "True";
        }else{
            return "False";
        }
    }

}