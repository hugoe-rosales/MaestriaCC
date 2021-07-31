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
public class Ejercicio6_NumRomanos {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String continuar = "S";
        while("S".equals(continuar) || "s".equals(continuar)){
            System.out.println("\n\n##########################################################");
            System.out.println("# CADENA DE NUMEROS ROMANOS Y SU EQUIVALENCIA EN DECIMAL #");
            System.out.println("#               DE HASTA 10 CARACTERES                   #");
            System.out.println("##########################################################\n");
            System.out.println("* Ingrese hasta 10 numeros Romanos, separados por coma(,)...");
            Scanner entradaTeclado = new Scanner(System.in);
            String cadenaIngresada = entradaTeclado.nextLine();
            String[] numerosRomanos = cadenaIngresada.split(",");
            System.out.println("\n\n|--------|---------|");        
            System.out.println("| ROMANO | DECIMAL |");        
            System.out.println("|--------|---------|");        
            for(int i=0; i < numerosRomanos.length; i++){
                int resultado = Ejercicio6_NumRomanos.conversorRomanoDecimal(numerosRomanos[i].toUpperCase());
                String resultadoRomano = (resultado != 0) ? String.valueOf(resultado) : "N/A" ;
                System.out.println("  " + String.valueOf(numerosRomanos[i]).replace(" ", "") + espacios(numerosRomanos[i]) + resultadoRomano);        
                System.out.println("|--------|---------|");        
            }
            System.out.println("\n\nDESEAS REALIZAR OTRO CALCULO [S/N] ? ");
            continuar = String.valueOf(entradaTeclado.nextLine());
            System.out.println(continuar);
        }
        if (continuar != "S") {System.out.println("\n\nH A S T A   L A   V I S T A !!!");}
    }
    
    // Función para el agregado de espacios en blanco a la cadena de salida.
    static String espacios(String cadena){
       String espacioEnBlanco = "";
       int cantidadEspacios = 10 - cadena.length();
       for(int i=0; i<cantidadEspacios; i++)
           espacioEnBlanco = espacioEnBlanco + " ";
       return espacioEnBlanco;
    }
    
    // Funcion que sirve para convertir el número Romano a Decimal.
    public static int conversorRomanoDecimal(String romano)
    {
        String numerosRomanos = "XLVICMD";
        int decimal = 0;
       // String numeroRomano = romano;
        for(int x = 0; x < romano.length(); x++)
        {
            if (numerosRomanos.contains(String.valueOf(romano.charAt(x)))){
                char numeroDecimal = romano.charAt(x);
                if (numeroDecimal == 'M')
                    decimal += 1000;
                else if (numeroDecimal == 'D')
                    decimal += 500;
                else if (numeroDecimal == 'C')
                    decimal += 100;
                else if (numeroDecimal == 'L')
                    decimal += 50;
                else if (numeroDecimal == 'X')
                    decimal += 10;
                else if (numeroDecimal == 'V')
                    decimal += 5;
                else if (numeroDecimal == 'I')
                    decimal += 1;
            }
            else if (romano.charAt(x) != ' ')
            {
                decimal = 0;
                break;
            }
        }
        if (decimal != 0)
        {
            if (romano.contains("IV") || romano.contains("IX"))
                decimal = decimal - 2;
            if (romano.contains("XL") || romano.contains("XC"))
                decimal = decimal - 20;
            if (romano.contains("CD") || romano.contains("CM"))
                decimal = decimal - 100;
        }
        return decimal;
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
