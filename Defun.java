/*
Integrantes
Yong Bum Park, 20117
Jorge Caballeros Pérez, 20009
Rolando Natanael Girón, 20029
*/ 
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Defun {
    static ArrayList<String> condicionNumero = new ArrayList<String>();
      /** 
       * @param ope
       * @return String
       */
      static String funcion(ArrayList<String> ope, float dato){
        Float num1 = 0f;
        Float num2=0f;
        String operacion;
        Float resultado = 0f;
        int contador = 0;
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> operaciones = new ArrayList<String>();
        ArrayList<String> cond = new ArrayList<String>();
        ArrayList<String> condiciones = new ArrayList<String>();
        ArrayList<String> condSeparado = new ArrayList<String>(); 
        Stack<Integer> stk = new Stack<>();
        boolean ciclo =true;
        boolean condicion = false;
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
        for(int i=0; i<numeros.size(); i++){
            if(numeros.get(i)==0){
                numeros.set(i, dato);
            }
        }
        
        Collections.reverse(numeros);
        //revisar si tiene cond o no
        if(operaciones.contains("cond")){
            operaciones.remove(0);
            //separarlo por t
            for(int i=0;i<operaciones.size();i++){
                if(operaciones.get(i).equals("t")){
                    condicion=true;
                    
                //agregar estos que son parte de la condicion antes de la operacion
                }else{
                    if(condicion==false){
                        cond.add(operaciones.get(i));
                    }
                }
            }
           
            //separar los condiciones
            do{
                condSeparado.add(cond.get(0));
                if(isNumeric(cond.get(0))){
                    condicionNumero.add(cond.get(0));
                }
                cond.remove(0);
                
                contador++;
                if(contador==4){
                    condiciones.add(condSeparado.toString());
                    condSeparado.clear();
                    contador=0;
                }                    
            }while(cond.size()!=0);
            
            if(condiciones.size()==2){
                //fibonacci
                //el fibonacci de recursividad sin utilizar un metodo ya definido aun no funciona por el cual buscar solucion
                
                int valorFactorial = (int)dato;
                boolean seguimiento = true;
                do{
                    if(valorFactorial == Integer.parseInt(condicionNumero.get(0))){
                        seguimiento=false;  
                    }else if(valorFactorial == Integer.parseInt(condicionNumero.get(2))){
                        stk.push(Integer.parseInt(condicionNumero.get(3)));
                        seguimiento=false;
                    }else{
                        stk.push(0);
                        stk.push(1);
                        if(dato>2){
                            for(int i=0; i<(dato-2); i++){
                                int x = stk.peek();
                                int y = stk.get(stk.size()-2);
                                x = x + y;
                                stk.push(x);
                            }
                        }
                        
                        seguimiento = false;
                    }
                }while(seguimiento);
                condicionNumero.clear();
                String resultadoTexto = stk.toString();
                return resultadoTexto;
            }else if(condiciones.size()==1){
                //factorial
                //aplicar la recursividad sin la necesidad de utilizar metodos ya definido.
                boolean seguimiento = true;
                //para guardar y utilizar recursividad
                int valorFactorial;
                do{
                    if((dato) == Integer.parseInt(condicionNumero.get(0))){
                        stk.push(Integer.parseInt(condicionNumero.get(1)));
                        seguimiento = false;
                    }else{
                        stk.push(1);
                        for(int i=2; i<=(dato); i++){
                            valorFactorial = stk.peek();
                            valorFactorial = valorFactorial * i;
                            stk.push(valorFactorial);
                        }
                        seguimiento = false;
                    }
                }while(seguimiento);
                condicionNumero.clear();
                String resultadoTexto = String.valueOf(stk.peek());
                stk.clear();
                return resultadoTexto;
            }
            return "Este no se puede operar";
        }else{
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
