/*
Integrantes
Yong Bum Park, 20117
Jorge Caballeros Pérez, 20009
Rolando Natanael Girón, 20029
*/ 
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

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
        //pedirle que ingrese el dato para operar
        /*System.out.println("Ingrese el dato de " + defun.get(2));
        float valorFuncion = scanner.nextFloat();*/
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
            //dependiendo del tamano ejecutar fibonacci o factorial
            ArrayList<Integer> cadenaResultado = new ArrayList<Integer>();
            if(condiciones.size()==2){
                //fibonacci
                //el fibonacci de recursividad sin utilizar un metodo ya definido aun no funciona por el cual buscar solucion
                /*
                int valorFactorial = (int)dato;
                int valorFactorialRestar = (int)dato;
                int y = 0;
                int t1 = 1;
                int t2;
                boolean seguimiento = true;
                do{
                    if(valorFactorial == Integer.parseInt(condicionNumero.get(0))){
                        cadenaResultado.add(Integer.parseInt(condicionNumero.get(1)));
                        seguimiento=false;  
                    }else if(valorFactorial == Integer.parseInt(condicionNumero.get(2))){
                        cadenaResultado.add(Integer.parseInt(condicionNumero.get(3)));
                        seguimiento=false;
                    }else{
                        for(int i = 0; i<valorFactorial; i++){
                            t2 = y;
                            y = t1 +  y;
                            t1 = t2;
                            cadenaResultado.add(t1);
                        }
                        seguimiento = false;
                    }
                }while(seguimiento);
                System.out.println("obtenido del cadenas: " + cadenaResultado);*/
                //enviar mas datos
                for(int l=0 ; l<(int)dato ; l++){
                    cadenaResultado.add(fibonacci(l));
                }
                condicionNumero.clear();
                String resultadoTexto = cadenaResultado.toString();
                return resultadoTexto;
            }else if(condiciones.size()==1){
                //factorial
                //aplicar la recursividad sin la necesidad de utilizar metodos ya definido.
                boolean seguimiento = true;
                //para guardar y utilizar recursividad
                int valorFactorial = (int)dato;
                int valorFactorialRestar = (int)dato;
                do{
                    if(valorFactorial == Integer.parseInt(condicionNumero.get(0))){
                        valorFactorial = Integer.parseInt(condicionNumero.get(1));
                        seguimiento = false;
                    }else{
                        if(valorFactorialRestar==1){
                            seguimiento = false;
                        }else{
                            valorFactorial = valorFactorial * (valorFactorialRestar-1);
                            valorFactorialRestar--;
                        }
                    }
                }while(seguimiento);
                condicionNumero.clear();
                String resultadoTexto = String.valueOf(valorFactorial);
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
     * @param n
     * @return int
     */
    //metodo de fibonacci
    
    public static int fibonacci (int n){
        
        if (n==Integer.parseInt(condicionNumero.get(0))) {  // caso base
            return Integer.parseInt(condicionNumero.get(1));
        }
        else if (n==Integer.parseInt(condicionNumero.get(2))){  // caso base
            return Integer.parseInt(condicionNumero.get(3));
        }
        else{ //error
            
            return fibonacci(n-1) + fibonacci(n-2);  //función recursiva
            //System.out.println("Debes ingresar un tamaño mayor o igual a 1");
            //return -1; 
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
