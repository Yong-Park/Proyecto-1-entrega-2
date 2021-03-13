public class ATOM {

    public void verificar (){

        if (!validarnumero()){

            System.out.println("Nill");
        }
        else {

            System.out.println("T");
        }
    }


    public String validarnumero (ArrayList<String> dato){

        
        String igualar="";
        String resultado = "";
        //arraylist para los numeros y otro para el signo
        ArrayList<String> palabra = new ArrayList<String>();

        for(int i=0; i<dato.size();i++){
            //obtener segun la variable
            String s =dato.get(i);
            if(s.equals("atom") || s.equals("Atom") ){
                palabra.add(s);
            }
        }
        return dato.matches("[0-100]");
    }

}