/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradleproject1;
import java.util.Scanner;

/**
 *
 * @author Default
 */
public class Ejercicio4_Tablas {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        String continuar = "S";
        while("S".equals(continuar) || "s".equals(continuar)){
            System.out.println("\n\n#########################");
            System.out.println("# TABLAS DE MULTIPLICAR #");
            System.out.println("#########################\n");
            System.out.println("* INGRESE EL NUMERO DE TABLA ...");
            //Scanner entradaTeclado1 = new Scanner(System.in);
            int numero = Integer.valueOf(entrada.nextLine());
            System.out.println("* INGRESE EL RANGO...");
            //Scanner entradaTeclado2 = new Scanner(System.in);
            int rango = Integer.valueOf(entrada.nextLine());
            Ejercicio4_Tablas.menuOpciones(numero, rango);
            System.out.println("DESEAS REALIZAR OTRO CALCULO [S/N] ? ");
            continuar = String.valueOf(entrada.nextLine());
            System.out.println(continuar);
        }
        if (continuar != "S") {System.out.println("H A S T A   L A   V I S T A !!!");}
    }
    
    // Función que sirve para realizar el cálculo de la Tabla de Multiplicar
    static void menuOpciones(int numeroIngresado1, int numeroIngresado2){
        for(int i=1; i<=numeroIngresado2; i++)
        {
            int resultado = numeroIngresado1 * i;
            String num1 = String.valueOf(numeroIngresado1);
            String cadenaSalida = String.valueOf(numeroIngresado1) + " x " + String.valueOf(i) + " = " + String.valueOf(resultado);
            System.out.println(cadenaSalida);
        }
    }

    // Función que sirve para validar si la cadena ingresada es numérica.
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
