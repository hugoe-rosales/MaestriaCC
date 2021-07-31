/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradleproject1;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Default
 */
public class Ejercicio8_AdivinaNumero {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        
        Scanner entradaTeclado;
        int opcion = 0;
        boolean digitos = false;
        while (opcion != 3)
        {
            System.out.println("\n\n###################################");
            System.out.println("# ADIVINAR EL NUMERO QUE PENSASTE #");
            System.out.println("###################################\n");
            System.out.println("* 1. vs COMPUTADORA.");
            System.out.println("* 2. vs APLICACION ADIVINA TU NUMERO.");
            System.out.println("* 3. SALIR.");
            System.out.println("\n=> SELECCIONE UNA OPCION...");
            entradaTeclado = new Scanner(System.in);
            opcion = Integer.parseInt(entradaTeclado.nextLine());
            digitos = Ejercicio8_AdivinaNumero.validarSonDigitos(entradaTeclado.nextLine());
            if (digitos){
                switch(opcion){
                    case 1:
                        Ejercicio8_AdivinaNumero.contraComputadora(entradaTeclado);
                        break;
                    case 2:
                        Ejercicio8_AdivinaNumero.contraAplicacion(entradaTeclado);
                        break;                        
                }        
            }
            else 
                System.out.print("LA OPCION SELECCIONADA NO ES VALIDA...\nSELECCIONE UNA OPCION CORRECTA[1,2 o 3]... ");
        }
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
    
    static void contraComputadora(Scanner entrada) throws InterruptedException{
        Random r = new Random();
        int numUsuario;
        int intentos = 1;
        int numComputadora = +r.nextInt(101);
        String mensaje = "";
        
        System.out.println("[COMPUTADORA] DICE... YA TENGO MI NUMERO, ES TU TURNO DE ADIVINAR...");
        Thread.sleep(1000);
        
        System.out.println("* INGRESA UN NUMERO ENTRE EL 1 y 100 !!*");
        numUsuario = Integer.parseInt(entrada.nextLine());
        
        while(numUsuario != numComputadora){
            mensaje = (numComputadora < numUsuario) ? "MENOR" : "MAYOR";
            System.out.print("[COMPUTADORA] DICE... MI NUMERO ES " + mensaje + ", INGRESA OTRO NUMERO, INTENTO " + intentos + ": ");
            numUsuario = Integer.parseInt(entrada.nextLine());
            intentos++;
        }
        System.out.println("\n[COMPUTADORA] DICE... FELICIDADES, ADIVINASTE EN   [ " + intentos + " ]   INTENTOS...");
        System.out.println("\n\nESPERE UN MOMENTO...  REDIRIGIENDO AUTOMATICAMENTE AL MENU PRINCIPAL...");
        Thread.sleep(7000);
    }
    
    static void contraAplicacion(Scanner entrada) throws InterruptedException{
        int numeroComputadora = new Random().nextInt(101);
        int maximo = 101, minimo = 0;
        int intentos = 0;
        String opcion = "";        

        System.out.println("[COMPUTADORA] DICE... PIENSA EN UN NUMERO ENTRE EL 1 Y EL 100...");
        Thread.sleep(5000);
      
        System.out.println("\n=>PRESIONA LAS LETRAS [M]AYOR, M[E]NOR o [I]GUAL...");
        while(!opcion.equals("I") && !opcion.equals("i")){
            System.out.println("[COMPUTADORA] DICE... SERA EL SIGUIENTE NUMERO: " + numeroComputadora );
            opcion = entrada.nextLine();
            if(opcion.equals("M") || opcion.equals("m"))
                minimo = numeroComputadora; 
            else if(opcion.equals("E") || opcion.equals("E"))
                maximo = numeroComputadora; 
            numeroComputadora = (int) ( maximo + minimo ) / 2;            
            intentos++;
        }
        System.out.println("\n[COMPUTADORA] DICE... ADIVINE EN   [ " + intentos + " ]   INTENTOS...");
        System.out.println("\n\nESPERE UN MOMENTO...  REDIRIGIENDO AUTOMATICAMENTE AL MENU PRINCIPAL...");
        Thread.sleep(7000);
    }
}
