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
public class Ejercicio9_Anagrama {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String continuar = "S";
        while("S".equals(continuar) || "s".equals(continuar)){
            System.out.println("\n\n############");        
            System.out.println("# ANAGRAMA #");        
            System.out.println("############\n");        
            System.out.println("* INGRESE UN VALOR PARA LA PRIMER CADENA...");
            Scanner entradaTeclado = new Scanner(System.in);
            String cadenaIngresada1 = entradaTeclado.nextLine();
            System.out.println("* INGRESE UN VALOR PARA LA SEGUNDA CADENA...");
            entradaTeclado = new Scanner(System.in);
            String cadenaIngresada2 = entradaTeclado.nextLine();
            if (cadenaIngresada1.replace(" ","").length() != cadenaIngresada2.replace(" ","").length())
                System.out.println("LAS DOS CADENAS SON DIFERENTES!");                   
            else if (Ejercicio9_Anagrama.validarAnagrama(cadenaIngresada1, cadenaIngresada2))
                System.out.println("\n=> LAS CADENAS INGRESADAS << S I   S O N   U N   A N A G R A M A >>");
            else
                System.out.println("\n=> LAS CADENAS << N O   S O N   U N   A N A G R A M A >>");

            System.out.println("\n\nDESEAS REALIZAR OTRO CALCULO [S/N] ? ");
            continuar = String.valueOf(entradaTeclado.nextLine());
            System.out.println(continuar);
        }
        if (continuar != "S") {System.out.println("\n\n:) - H A S T A   L A   V I S T A !!!");}
    }
    
    // Función que sirve para validar si la cadena ingresada es numérica o no
    static boolean validarAnagrama(String cadena1, String cadena2){
        cadena1 = cadena1.toUpperCase();
        cadena2 = cadena2.toUpperCase();
        if(cadena1.length() == cadena2.length())
            for(int i = 0; i < cadena1.length(); i++)
                if(!cadena2.contains(String.valueOf(cadena1.charAt(i))))
                    return false;
        return true;
    }
}
