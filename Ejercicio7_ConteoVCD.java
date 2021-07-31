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
public class Ejercicio7_ConteoVCD {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entradaTeclado;
        String cadenaIngresada;
        String continuar = "S";
        while("S".equals(continuar) || "s".equals(continuar)){
            System.out.println("\n\n################################################################");
            System.out.println("# CONTAR VOCALES, CONSONANTES Y DIGITOS EN UNA CADENA DE TEXTO #");
            System.out.println("################################################################\n");
            System.out.println("* INGRESE UNA CADENA...");
            entradaTeclado = new Scanner(System.in);
            cadenaIngresada = entradaTeclado.nextLine();
            Ejercicio7_ConteoVCD.contarCaracteres(cadenaIngresada);

            System.out.println("\nDESEAS INGRESAR OTRA CADENA [S/N] ? ");
            continuar = String.valueOf(entradaTeclado.nextLine());
        }
        if (!"S".equals(continuar)) {System.out.println("\nH A S T A   L A   V I S T A !!!");}
    }

    static void contarCaracteres(String cadenaIngresada) {
        String vocalesCadena = "aeiou", digitosCadena = "1234567890";
        int vocales = 0, consonantes = 0, digitos = 0;
        String cadena = cadenaIngresada.toLowerCase();
        for(int i = 0; i < cadena.length(); ++i)
        {
            char caracter = cadena.charAt(i);
            if (vocalesCadena.contains(String.valueOf(caracter)))
                ++vocales;
            else if(digitosCadena.contains(String.valueOf(caracter)))
                ++digitos;
            else if((caracter >= 'a' && caracter <= 'z') || (caracter >= 'A' && caracter <= 'Z'))
                ++consonantes;
        }
        System.out.println("\n\nTotal Vocales:      " + vocales);
        System.out.println("Total consonantes:  " + consonantes);
        System.out.println("Total Digitos       " + digitos);
    }
}
