import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
class Driver{
    
    /** 
     * @param args
     */
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
            ArrayList<String> revisionNumericos = new ArrayList<String>();
            ArrayList<String> revisionRecursividad = new ArrayList<String>();
            ArrayList<String> comparar = new ArrayList<String>();
            ArrayList<String> derecha = new ArrayList<String>();
            ArrayList<String> izquierda = new ArrayList<String>();
            List<String> al = new ArrayList<String>();
            boolean listas = false;
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
                //para guardar datos numericos
                for(int i=0; i< operandos.size();i++){
                    if(isNumeric(operandos.get(i))){
                        revisionNumericos.add(operandos.get(i));
                    }
                }
                
                //revisar si esta el map y dependiendo de ello
                if(funciones.keySet().size()>0 && !revision.isEmpty()){
                    if(funciones.keySet().contains(revision.get(0))){
                        comparar=funciones.get(revision.get(0));
                        //si tiene defun
                        if(comparar.contains("Defun")){
                            System.out.println("Esta funcion esta guardada");
                            //si usa el mismo nombre pero tiene un contenido distinto
                            if(revision.size()>1){
                                funciones.replace(revision.get(0), operandos);
                            }else{
                                //no cambia el contenido y solo se le llama
                                operandos = funciones.get(revision.get(0));
                                //revisar si esto de abajo me sirve o lo llego a utilizar
                                //guardar la funcion para ver si tiene recursividad
                                for(int i=3; i< operandos.size(); i++){
                                    revisionRecursividad.add(operandos.get(i));
                                }
                                //verificar si en el codigo en si tiene llamada la misma funcion en caso afirmativo
                                //cambiar el dato
                                if(revisionRecursividad.contains(revision.get(0))){
                                    
                                }
                            }   
                        }else{
                            //revisar si tiene alguna varibale que ya este guardada
                            for(int i=0;i<operandos.size();i++){
                                if(funciones.keySet().contains(operandos.get(i))){
                                    String var = funciones.get(operandos.get(i)).toString();
                                    var = var.replace("[", "");
                                    var = var.replace("]", "");
                                    operandos.set(i, var);
                                }
                            }
                        }  
                    }
                }
                /*System.out.println("Esto es de lo de operandos pero sin sus defun y asi: " + revisionRecursividad);
                System.out.println("Esto es de lo operandos: " + operandos);
                System.out.println("Esto es de la revision: " + revision);
                System.out.println("Esto es de la revision de los numeros: " + revisionNumericos);
                System.out.println("Esto es el keyset del map: " + funciones.keySet());
                System.out.println("Esto es el value del map: " + funciones.values());*/
                System.out.println(operandos);
                //si hay la misma cantidad de parentesis correr la funcion
                if(derecha.size()==izquierda.size()){
                    //revisar si tiene 0 parentesis
                    if(derecha.size()==0 && izquierda.size()==0){
                        //este sera una lista
                        listas=true;
                    }
                    System.out.println("Cantidad de parentesis correcta");
                    //revisar el tipo de intruccion que es para realizar la funcion adecuada
                    int opcion = verificar(operandos, listas);
                    //correr segun el tipo
                    //Aritmetrica
                    if(opcion==0){
                        Aritmetrica art = new Aritmetrica();
                        String resultado = art.operacion(operandos);
                        System.out.println(resultado);
                    //Defun
                    }else if(opcion==1){
                        //agregar al map
                        if(funciones.keySet().contains(revision.get(0))){
                            
                        }else{
                            funciones.put(revision.get(0), operandos);
                        }
                        Defun defun = new Defun();
                        String resultado =  defun.funcion(operandos);
                        System.out.println(resultado);
                    //Predicado
                    }else if(opcion==2){
                        Predicado predi = new Predicado();
                        String resultado = predi.revisar(operandos);
                        System.out.println(resultado);

                    //ATOM
                    }else if(opcion==3){
                        ATOM atom = new ATOM();
                        String resultado = atom.validar(operandos);
                        System.out.println(resultado);
                    //SETQ
                    }else if(opcion==4){
                        //agregar al map
                        for(int i=0; i < revision.size();i++){
                            ArrayList<String> valor = new ArrayList<String>();
                            valor.add(revisionNumericos.get(i));
                            funciones.put(revision.get(i), valor);
                            //mostrar el resultado de setq
                            System.out.println(revision.get(i) + "=" + funciones.get(revision.get(i)));
                        }
                    //Quote
                    }else if(opcion ==5){
                        Quote quote = new Quote();
                        String resultado = quote.opQuote(data);
                        System.out.println(resultado);
                    //listas
                    }else if(opcion == 7){
                        Lista lis = new Lista();
                        ArrayList<String> resultado = lis.ConvertirLista(operandos);
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
