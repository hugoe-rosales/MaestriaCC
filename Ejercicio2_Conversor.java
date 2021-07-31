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
public class Ejercicio2_Conversor {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean digitos = false;
        System.out.println("\n\n####################################################");
        System.out.println("# CONVERSOR DECIMAL A BINARIO, HEXADECIMAL Y OCTAL #");
        System.out.println("####################################################\n");
        System.out.println("* INGRESE UN NUMERO ENTERO...");
        while (digitos == false)
        {
            Scanner entradaTeclado = new Scanner(System.in);
            String numeroIngresado = entradaTeclado.nextLine();
            digitos = Ejercicio2_Conversor.validarSonDigitos(numeroIngresado);
            if (digitos)
                Ejercicio2_Conversor.menuOpciones(Integer.parseInt(numeroIngresado));
            else 
                System.out.print("EL NUMERO INGRESADO NO ES VALIDO...\nINGRESE NUEVAMENTE UN NUMERO ENTERO, DECIMAL... ");
        }
    }
    
    // Función para mostrar el menú de opciones para conversión de cadena -- "Binario", "Hexadecimal", "Octal"
    static void menuOpciones(int numeroIngresado){
        int opcionSel = 0;
        String resultado = "";
        String conversion = "";
        while (opcionSel != 4)
        {
            System.out.println("EL NUMERO INGRESADO, FUE... [" + numeroIngresado + "]\n\n" +
                               "1. BINARIO\n" + 
                               "2. HEXADECIMAL\n" + 
                               "3. OCTAL\n" + 
                               "4. SALIR\n" + 
                               "* CONVERTIR EL NUMERO INGRESADO, A...? ");

            Scanner opcionSubMenu =  new Scanner(System.in);
            opcionSel = opcionSubMenu.nextInt();
            if (opcionSel < 1 || opcionSel > 4)
              System.out.print("LA OPCION SELECCIONADA -- NO ES INVALIDA --");
            else
            {
                switch(opcionSel){
                    case 1:
                        resultado = Integer.toBinaryString(numeroIngresado);
                        break;
                    case 2:
                        resultado = Integer.toHexString(numeroIngresado);
                        break;
                    case 3:
                        resultado = Integer.toOctalString(numeroIngresado);
                        break;
                }
                conversion = (opcionSel == 1) ? "BINARIO" : (opcionSel == 2) ? "HEXADECIMAL" : "OCTAL";
                System.out.println("DECIMAL -> " + conversion + " = [ " + (String.valueOf(resultado)) + " ]\n\n");
            }
        }
    }
    // Función que sirve para validar si la cadena ingresada es numérica
    static boolean validarSonDigitos(String cadIngresada){
        for (int i=0; i < cadIngresada.length(); i++) {
            if (Character.isDigit(cadIngresada.charAt(i)) == false) 
                return false;
        }
        return true;
    }
}
