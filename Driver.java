import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
class Driver{
    //correr el programa
    public static void main (String[] args){
        HashMap <String, ArrayList<String>> funciones = new HashMap<String, ArrayList<String>>();
        boolean ciclo=true;
        do{
            //recibir el tipo 
            menu();
            //ingresar el codigo
            ArrayList<String> operandos = new ArrayList<String>();
            ArrayList<String> revision = new ArrayList<String>();
            ArrayList<String> comparar = new ArrayList<String>();
            ArrayList<String> derecha = new ArrayList<String>();
            ArrayList<String> izquierda = new ArrayList<String>();
            List<String> al = new ArrayList<String>();
            //ingresar el codigo que desee y convertirlo en un arraylist
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingresa el codigo: ");
            String data = scanner.nextLine();
            try{
                String[] str = data.split(" ");
                al = Arrays.asList(str);
                for(String s: al){
                    if(s.equals("(")){
                        izquierda.add(s);
                    }else if(s.equals(")")){
                        derecha.add(s);
                    }else{
                        operandos.add(s);
                    }
                }
                //guardar solo el nombre del tipo de operacion
                for(int i=0; i < operandos.size(); i++){
                    if(operandos.get(i).equals("Defun") || operandos.get(i).equals(">") || operandos.get(i).equals("<") || operandos.get(i).equals("=") || operandos.get(i).equals("atom") || operandos.get(i).equals("setq") || operandos.get(i).equals("+") || operandos.get(i).equals("-") || operandos.get(i).equals("*") || operandos.get(i).equals("/") || isNumeric(operandos.get(i))){
                        //no pasa nada
                    }else{
                        revision.add(operandos.get(i));
                    }
                }
                //revisar si esta el map y dependiendo de ello
                if(funciones.keySet().size()>0 && !revision.isEmpty()){
                    if(funciones.keySet().contains(revision.get(0))){
                        comparar=funciones.get(revision.get(0));
                        //si tiene defun
                        if(comparar.contains("Defun")){
                            System.out.println("Esta funcion esta guardada");
                            operandos = funciones.get(revision.get(0));
                        }
                    }
                }

                //si hay la misma cantidad de parentesis correr la funcion
                if(derecha.size()==izquierda.size()){
                    System.out.println("Cantidad de parentesis correcta");
                    //revisar el tipo de intruccion que es para realizar la funcion adecuada
                    int opcion = verificar(operandos);
                    //correr segun el tipo

                    //Aritmetrica
                    if(opcion==0){
                        Aritmetrica art = new Aritmetrica();
                        String resultado = art.operacion(operandos);
                        System.out.println(resultado);
                    //Defun
                    }else if(opcion==1){
                        //agregar al map
                        funciones.put(revision.get(0), operandos);
                        Defun defun = new Defun();
                        String resultado =  defun.funcion(operandos);
                        System.out.println(resultado);
                    //Predicado
                    }else if(opcion==2){
                        
                    //ATOM
                    }else if(opcion==3){
                        
                    //SETQ
                    }else if(opcion==4){
                        
                    //Quote
                    }else if(opcion ==5){
                        Quote quote = new Quote();
                        String resultado = quote.opQuote(data);
                        System.out.println(resultado);
                    }
                }else{
                    System.out.println("Cantidad de Parentesis incorrecta");
                }
            //Salir
            }catch(Exception e){
                System.out.println("Espero que vuelvas pronto");
                ciclo =false;
            }
            
        } while (ciclo);
    }

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
    
    //revisar
    public static int verificar(ArrayList<String> ope){
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
        }else if(ope.contains("=")){
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
        }
        return resultado;
        
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

