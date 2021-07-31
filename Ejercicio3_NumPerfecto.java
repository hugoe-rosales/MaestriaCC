/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradleproject1;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Default
 */
public class Ejercicio3_NumPerfecto {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entradaTeclado = new Scanner(System.in);
        String continuar = "S";
        while("S".equals(continuar) || "s".equals(continuar)){
            boolean digitos = false;
            System.out.println("\n\n##################################");
            System.out.println("# SABER SI UN NUMERO ES PERFECTO #");
            System.out.println("##################################\n");
            System.out.println("* INGRESE UN NUMERO ENTERO...");
            while (digitos == false)
            {
                String numeroIngresado = entradaTeclado.nextLine();
                digitos = Ejercicio3_NumPerfecto.validarSonDigitos(numeroIngresado);
                if (digitos)
                    Ejercicio3_NumPerfecto.CalcularNumeroPerfecto(Integer.parseInt(numeroIngresado));
                else 
                    System.out.print("EL NUMERO INGRESADO, NO ES VALIDO...\nINGRESE NUEVAMENTE UN ENTERO DECIMAL... ");
            }
            System.out.println("DESEAS INGRESAR OTRO NUMERO [S/N] ? ");
            continuar = String.valueOf(entradaTeclado.nextLine());
        }
        if (!"S".equals(continuar)) {System.out.println("H A S T A   L A   V I S T A !!!");}
    }
    
    // Función para el cálculo del número perfecto.
    static void CalcularNumeroPerfecto(int numeroIngresado){
        int suma = 0;
        int posicion = 0;
        for (int i = 1; i < numeroIngresado; i++)
            if (numeroIngresado % i == 0){
               suma = suma + i;
               posicion += 1;
            }
        
        // Es un número "Perfecto"
        if (suma == numeroIngresado)
        {
            Integer numeros[] = new Integer[posicion];
            posicion = 0;
            for (int j = 1; j < numeroIngresado; j++)
                if (numeroIngresado % j == 0) {
                   numeros[posicion] = j;
                   posicion += 1;
                }
            Arrays.sort(numeros, Collections.reverseOrder());
            System.out.printf("\n=>EL NUMERO INGRESADO << E S   U N   N U M E R O   P E R F E C T O >> \n" + String.valueOf(numeroIngresado) + " --> %s", Arrays.toString(numeros) + "\n\n");
        }
        else
            System.out.println("\n=>EL NUMERO INGRESADO  << N O   E S   U N   N U M E R O   P E R F E C T O >>\n\n");
            
        
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
