import java.util.ArrayList;
public class ATOM {

    public void verificar (){
        //Si no se encuentran números del 0 al 100 en el método validarnumero
        if (!validarnumero()){
            //Se imprime Nill (False)
            System.out.println("Nill");
        }
        //Si se encuentran números del 0 al 100 en el método validarnumero
        else {
            //Se imprime T (True)
            System.out.println("T");
        }
    }


    public String validarnumero (ArrayList<String> dato){

        
        //arraylist para agregar la palabra atom y dejar solo el valor
        ArrayList<String> palabra = new ArrayList<String>();

        //Se guarda la palabra en el array
        for(int i=0; i<dato.size();i++){
            String s =dato.get(i);
            if(s.equals("atom") || s.equals("Atom") ){
                palabra.add(s);
            }
        }
        //Se retornan solo los númeors del 0 al 100
        return dato.matches("[0-100]");
    }

}