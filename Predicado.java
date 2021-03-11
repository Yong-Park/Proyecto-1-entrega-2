import java.util.ArrayList;
import java.util.Collections;


public class Predicado{

    public String equal (ArrayList<String> dato){
        
        Float num1 = 0f;
        Float num2=0f;
        String igualar="";
        String resultado = "";
        //arraylist para los numeros y otro para el signo
        ArrayList<Float> numeros = new ArrayList<Float>();
        ArrayList<String> signos = new ArrayList<String>();

        for(int i=0; i<dato.size();i++){
            //obtener segun la variable
            String s =dato.get(i);
            if(s.equals("<") || s.equals(">") ){
                signos.add(s);
            }else{
                float f; 
                try{
                    f = Float.parseFloat(s);
                    numeros.add(f);
                }catch(Exception e){
                    
                }
            }
        }
        Collections.reverse(numeros);
        //revisar si ya hay dos datos y en caso que si revisar tambien si ya hay algun operando
        do{
            //operar
            num1 = numeros.get(numeros.size()-1);
            numeros.remove(numeros.size()-1);
            num2 = numeros.get(numeros.size()-1);
            numeros.remove(numeros.size()-1);
            operacion = signos.get(signos.size()-1);
            signos.remove(operacion);
            //operar segun el signo
            if(igualar.equals(">")){
                if (num1 > num2){
                    resultado = num1 + "es Mayor que " + num2;
                }
                
            }else if(igualar.equals("<")){
                if (num1 < num2){
                    resultado = num1 + "es Mayor que " + num2;
                }
            }else if(igualar.equals("=")){
                if (num1 < num2){
                    resultado = num1 + "es Igual que " + num2;
                }
            }

            //agregar el resultado al stack
            numeros.add(resultado);  
        }while(!signos.isEmpty());
        
        //resultado
        if(numeros.size()>=2){
            return "Este no se puede operar";
        }else{
            String resultadoTexto = String.valueOf(resultado);
            return resultadoTexto;
        }
        return a; 
    }
}
