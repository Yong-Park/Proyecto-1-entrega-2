import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Defun {
    public String funcion(ArrayList<String> ope){
        Float num1 = 0f;
        Float num2=0f;
        String operacion;
        Float resultado = 0f;
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> operaciones = new ArrayList<String>();
        boolean ciclo =true;
        //arraylist para los numeros y otro para el signo
        ArrayList<Float> numeros = new ArrayList<Float>();
        ArrayList<String> signos = new ArrayList<String>();
        ArrayList<String> defun = new ArrayList<String>();
        //agregar la ope a operaciones
        for(int i=0; i<ope.size(); i++){
            operaciones.add(ope.get(i));
        }
        //separar la defun por su inicial y luego con su operacion
        for(int i=0; i<3; i++){;
            defun.add(operaciones.get(0));
            operaciones.remove(operaciones.get(0));
        }
        for(int i=0; i<operaciones.size();i++){
            //obtener segun la variable
            String s =operaciones.get(i);
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                signos.add(s);
            }else{
                if(s.equals(defun.get(2))){
                    numeros.add(0f);
                }
                float f; 
                try{
                    f = Float.parseFloat(s);
                    numeros.add(f);
                }catch(Exception e){
                    
                }
            }
        }
        //pedirle que ingrese el dato para operar
        System.out.println("Ingrese el dato de " + operaciones.get(2));
        float valorFuncion = scanner.nextFloat();
        for(int i=0; i<numeros.size(); i++){
            if(numeros.get(i)==0){
                numeros.set(i, valorFuncion);
            }
        }
        
        Collections.reverse(numeros);
        //operar
        do{
            //revisar si ya hay dos datos y en caso que si revisar tambien si ya hay algun operando
            if(numeros.size()>=2 && signos.size()>=1){
                //operar
                num1 = numeros.get(numeros.size()-1);
                numeros.remove(num1);
                num2 = numeros.get(numeros.size()-1);
                numeros.remove(num2);
                operacion = signos.get(signos.size()-1);
                signos.remove(operacion);
                //operar segun el signo
                if(operacion.equals("+")){
                    resultado = num1 + num2;
                }else if(operacion.equals("-")){
                    resultado = num1 - num2; 
                }else if(operacion.equals("/")){
                    resultado = num1 / num2;
                }else if(operacion.equals("*")){
                    resultado = num1 * num2;
                }
                //agregar el resultado al stack
                numeros.add(resultado);
            }else{
                ciclo=false;
            }
        }while(ciclo);



        //resultado
        if(numeros.size()>=2){
            return "Este no se puede operar";
        }else{
            String resultadoTexto = String.valueOf(resultado);
            return resultadoTexto;
        }    
    }   
}
