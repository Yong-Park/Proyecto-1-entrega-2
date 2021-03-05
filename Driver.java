import java.util.Scanner;
class Driver{
    //correr el programa
    public static void main (String[] args){
        boolean ciclo=true;
        do{
            //recibir el tipo 
            int opcion = menu();
            //correr segun el tipo
            //Aritmetrica
            if(opcion==1){
                Aritmetrica art = new Aritmetrica();
                String resultado = art.operacion();
                System.out.println(resultado);
            //Defun
            }else if(opcion==2){

            //Predicado
            }else if(opcion==3){
                
            //ATOM
            }else if(opcion==4){
                
            //SETQ
            }else if(opcion==5){
                
            //Salir
            }else if(opcion==6){
                System.out.println("Gracias espero que vuelvas pronto");
                ciclo=false;
            }
        } while (ciclo);
    }

    // menu
    public static int menu() {
        System.out.println("-------------------");
        System.out.println("Bien venidos");
        System.out.println("-------------------");
        System.out.println("1. Aritmetrica");
        System.out.println("2. Defun");
        System.out.println("3. Predicado (<,>,=)");
        System.out.println("4. ATOM");
        System.out.println("5. SETQ");
        System.out.println("6. Salir");
        System.out.println("-------------------");
        System.out.println("Seleccione uno");
        int opcion = seleccion();
        return opcion;
    }
    public static int seleccion(){
        //definir el scanner
        Scanner scanner  = new Scanner(System.in);
        //pedir el numero de opcion
        boolean ciclo_numero=true;
        int opcion_numero=0;
        do{
            try{
                String opcion = scanner.nextLine();
                //verificar que sea una opcion adecuada
                opcion_numero = Integer.parseInt(opcion);
                if(opcion_numero>=1 && opcion_numero<=6){
                    ciclo_numero=false;
                }else{
                    System.out.println("Porfavor escoja una de las opcioens que se presentan en el menu");
                }
            }catch(Exception e){
                System.out.println("Ingersa solo datos numericos");
            }
        }while(ciclo_numero);
        return opcion_numero;
    }
}

