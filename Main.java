/*
Integrantes
Yong Bum Park, 20117
Jorge Caballeros Pérez, 20009
Rolando Natanael Girón, 20029
*/ 
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
            FuncionesExtra.menu();
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
                    if(operandos.get(i).equals("Defun") || operandos.get(i).equals(">") || operandos.get(i).equals("<") || operandos.get(i).equals("=") || operandos.get(i).equals("atom") || operandos.get(i).equals("setq") || operandos.get(i).equals("+") || operandos.get(i).equals("-") || operandos.get(i).equals("*") || operandos.get(i).equals("/") || FuncionesExtra.isNumeric(operandos.get(i))){
                        //no pasa nada
                    }else{
                        revision.add(operandos.get(i));
                    }
                }
                //para guardar datos numericos
                for(int i=0; i< operandos.size();i++){
                    if(FuncionesExtra.isNumeric(operandos.get(i))){
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
                //si hay la misma cantidad de parentesis correr la funcion
                if(derecha.size()==izquierda.size()){
                    //revisar si tiene 0 parentesis
                    if(derecha.size()==0 && izquierda.size()==0){
                        //este sera una lista
                        listas=true;
                    }
                    System.out.println("Cantidad de parentesis correcta");
                    //revisar el tipo de intruccion que es para realizar la funcion adecuada
                    int opcion = FuncionesExtra.verificar(operandos, listas);
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
                        System.out.println("Ingrse el valor de " + operandos.get(2));
                        Float valordata = scanner.nextFloat();
                        String resultado =  defun.funcion(operandos, valordata);
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
                    }else if(opcion==8){
                        ciclo=false;
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
}
