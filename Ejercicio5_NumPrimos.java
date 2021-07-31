/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradleproject1;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Default
 */
public class Ejercicio5_NumPrimos {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// TODO code application logic here
        String continuar = "S";
        while("S".equals(continuar) || "s".equals(continuar)){
            System.out.println("\n\n############################################");
            System.out.println("# INGRESAR UNA CADENA DE NUMEROS DECIMALES #");
            System.out.println("# SE BUSCARA LA POSICION DE NUMEROS PRIMOS #");
            System.out.println("############################################\n");
            System.out.println("* Ingrese hasta 10 numeros decimales, separados por coma(,)...");
            Scanner entradaTeclado = new Scanner(System.in);
            String cadenaIngresada = entradaTeclado.nextLine();
            String[] cadenaDecimales = cadenaIngresada.split(",");
            System.out.println("\n\n|---------|--------------|");        
            System.out.println("| DECIMAL | NUMERO PRIMO |");        
            System.out.println("|---------|--------------|");    
            llenarArray(cadenaDecimales);
            System.out.println("\n\nDESEAS REALIZAR OTRO CALCULO [S/N] ? ");
            continuar = String.valueOf(entradaTeclado.nextLine());
            System.out.println(continuar);
        }
        if (continuar != "S") {System.out.println("\n\nH A S T A   L A   V I S T A !!!");}
    }
    
    static void llenarArray(String[] cadenaNumeros){
        Numeros listaNumeros = new Numeros();
        listaNumeros.setNumero(cadenaNumeros);
        int[] numResultado = listaNumeros.getNumero();
        BuscarNumeroPrimo listaNumerosPrimos = new BuscarNumeroPrimo();
        String[] numPrimos = listaNumerosPrimos.getNumeroPrimo(numResultado);
        for(int i = 0; i < 10; i++){
            System.out.println("| " + String.valueOf(numResultado[i]) + espacios(String.valueOf(numResultado[i]), 8) + "|      " + 
                                      String.valueOf(numPrimos[i]) + espacios(String.valueOf(numPrimos[i]), 8) + "|");            
            System.out.println("|---------|--------------|");    
        }
    }
    
    static boolean esNumeroPrimo(Integer numero){
      if (numero == 0 || numero == 1 || numero == 4) 
        return false;

      for (int x = 2; x < numero / 2; x++) 
        if (numero % x == 0)
          return false;
      return true;
    }
    
    static String espacios(String cadena, int cantidad){
       String espacioEnBlanco = "";
       int cantidadEspacios = cantidad - cadena.length();
       for(int i=0; i<cantidadEspacios; i++)
           espacioEnBlanco = espacioEnBlanco + " ";
       return espacioEnBlanco;
    }

    // Función que sirve para validar si la cadena ingresada es numérica o no
    static boolean validarSonDigitos(String cadIngresada){
        boolean esFormatoNumerico = true;
        for (int i=0; i < cadIngresada.length(); i++) {
            if (Character.isDigit(cadIngresada.charAt(i)) == false) { 
                esFormatoNumerico = false;
                break;
            } 
        }
        return esFormatoNumerico;
    }
}

class Numeros {
    private int[]  numeros = new int[10];
    private String[] cadNumeros = new String[10];
    public Numeros(){
    }   
    public void setNumero(String[] num){ 
        if (num.length < 10)
            for (int i = 0; i < num.length; i++)
                this.numeros[i] = (num[i].trim().length() > 0) ? Integer.valueOf(num[i].trim()) : 0; 
        else
            for (int i = num.length; i < 10; i++)
                this.numeros[i] = 0;
    }
    public int[] getNumero() { 
        return numeros; 
    }
}

class BuscarNumeroPrimo {
    private int[] numeros = new int[10];
    private String[] numerosPrimos = new String[10];
    
    public BuscarNumeroPrimo(){
    }   
    public void setNumeroPrimo(int[] num){ 
        numeros = num;
    }
    public String[] getNumeroPrimo(int[] num) { 
        for(int i = 0; i < 10; i++)
            numerosPrimos[i] = (Ejercicio5_NumPrimos.esNumeroPrimo(num[i]) ==  false) ? "" : "X";
        return numerosPrimos; 
    }
}
