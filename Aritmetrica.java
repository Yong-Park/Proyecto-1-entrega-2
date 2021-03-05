import java.util.Scanner;
import javax.print.DocFlavor.READER;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Aritmetrica {
    public String operacion(){
        ArrayList<String> operandos = new ArrayList<String>();
        List<String> al = new ArrayList<String>();
        //ingresar el codigo que desee y convertirlo en un arraylist
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el codigo: ");
        String data = scanner.nextLine();
        String[] str = data.split(" ");
	    al = Arrays.asList(str);
        for(String s: al){
            operandos.add(s);
        }
        //revisar
        boolean revision = verificar(operandos);
        //si es FALSE regresar que no es un dato aritmetrico, de lo contrario operar
        if(revision==true){
            //operar
            String resultado= calcular(operandos);
            return resultado;
        }else{
            return "Este no es una operacion Aritmetrica";
        }
        
        
    }

    public boolean verificar(ArrayList<String> ope){
        //verificar que solo sea Aritmetrica el codigo ingresado
        boolean resultado = true;
        if(ope.contains("Defun")){
            resultado = false;
        }else if(ope.contains(">")){
            resultado = false;
        }else if(ope.contains("<")){
            resultado = false;
        }else if(ope.contains("=")){
            resultado = false;
        }else if(ope.contains("atom")){
            resultado = false;
        }else if(ope.contains("setq"))
            resultado = false;
        return resultado;
    }

    public String calcular(ArrayList<String> ope){
        Float num1 = 0f;
        Float num2=0f;
        String operacion;
        Float resultado = 0f;
        //arraylist para los numeros y otro para el signo
        ArrayList<Float> numeros = new ArrayList<Float>();
        ArrayList<String> signos = new ArrayList<String>();

        for(int i=0; i<ope.size();i++){
            //obtener segun la variable
            String s =ope.get(i);
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                signos.add(s);
            }else{
                float f; 
                try{
                    f = Float.parseFloat(s);
                    numeros.add(f);
                }catch(Exception e){
                    
                }
            }
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
                    resultado = num2 - num1; 
                }else if(operacion.equals("/")){
                    resultado = num2 / num1;
                }else if(operacion.equals("*")){
                    resultado = num1 * num2;
                }
                //agregar el resultado al stack
                numeros.add(resultado);
            }
        }
        //resultado
        if(numeros.size()>=2){
            return "Este no se puede operar";
        }else{
            String resultadoTexto = String.valueOf(resultado);
            return resultadoTexto;
        }
        
    }
}
