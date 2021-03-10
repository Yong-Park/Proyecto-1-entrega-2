import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
class Driver{
    //correr el programa
    public static void main (String[] args){
        boolean ciclo=true;
        do{
            //recibir el tipo 
            menu();
            //ingresar el codigo
            ArrayList<String> operandos = new ArrayList<String>();
            ArrayList<String> derecha = new ArrayList<String>();
            ArrayList<String> izquierda = new ArrayList<String>();
            List<String> al = new ArrayList<String>();
            //ingresar el codigo que desee y convertirlo en un arraylist
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingresa el codigo: ");
            String data = scanner.nextLine();
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
                }else if(opcion==5){
                    Quote quote = new Quote();
                    String resultado = quote.opQuote(data);
                    System.out.println(resultado);
                //Salir
                }else if(opcion==6){
                    System.out.println("Gracias espero que vuelvas pronto");
                    ciclo=false;
                }
            }else{
                System.out.println("Cantidad de Parentesis incorrecta");
            }
            
        } while (ciclo);
    }

    // menu
    public static void menu() {
        System.out.println("-------------------");
        System.out.println("Bien venidos");
        System.out.println("Estos son los tipos que puede realizar este interprete");
        System.out.println("-------------------");
        System.out.println("1. Aritmetrica");
        System.out.println("2. Defun");
        System.out.println("3. Predicado (<,>,=)");
        System.out.println("4. ATOM");
        System.out.println("5. SETQ");
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
        }
        else if(ope.contains("quote") || ope.contains("´")){
            resultado = 5;
            return resultado;
        }else if(ope.isEmpty()){
            resultado = 6;
            return resultado;
        }
        return resultado;
        
    }
}

