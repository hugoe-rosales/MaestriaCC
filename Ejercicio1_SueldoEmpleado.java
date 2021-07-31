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
public class Ejercicio1_SueldoEmpleado {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int ciclo = 0;
        String empleados[][] = new String[5][6];
        String opcion = "0";
        while(Integer.valueOf(opcion) != 4)
        {
            System.out.println("\n\n###################################");
            System.out.println("# CALCULO DE SUELDOS DE EMPLEADOS #");
            System.out.println("###################################\n");
            System.out.println("1. INGRESAR INFORMACION DEL EMPLEADO.");
            if (empleados[0][0] != null) { System.out.println("2. MODIFICAR SUELDO x HORA."); }
            if (empleados[0][0] != null) { System.out.println("3. CALCULO DE SALARIO."); }
            System.out.println("4. SALIR.");
            System.out.println("\n=> SELECCIONE UNA OPCION...");
            Scanner entradaTeclado = new Scanner(System.in);
            opcion = entradaTeclado.nextLine();
            if (Integer.valueOf(opcion) == 1){
                  Ejercicio1_SueldoEmpleado.generalesEmpleado(empleados, ciclo);
                  ciclo += 1;
            }
            else if (Integer.valueOf(opcion) == 2){
                if (empleados[0][0] != null)
                {
                    System.out.println("* SUELDO x HORA:          ");
                    entradaTeclado = new Scanner(System.in);
                    empleados[0][3] = String.valueOf(entradaTeclado.nextLine());
                }
                else
                    System.out.println("NO SE HAN INGRESADO LA INFORMACION DEL EMPLEADO.");
            }
            else if (Integer.valueOf(opcion) == 3){
                if (empleados[0][0] != null)
                {
                    double sueldoCalculado = Ejercicio1_SueldoEmpleado.calculoSueldo(Double.parseDouble(empleados[0][3]));
                    sueldoCalculado = Math.round(sueldoCalculado*100.0)/100.0;
                    double horasTrabajadas = sueldoCalculado/Double.valueOf(empleados[0][3]);
                    horasTrabajadas = Math.round(horasTrabajadas);
                    empleados[0][4] = (sueldoCalculado != 0) ? String.valueOf(horasTrabajadas) : "0";
                    empleados[0][5] = (sueldoCalculado != 0) ? String.valueOf(sueldoCalculado) : "0";
                    Ejercicio1_SueldoEmpleado.imrimeSalida(empleados);
                }
                else
                    System.out.println("NO SE HAN INGRESADO LA INFORMACION DEL EMPLEADO.");
            }
            else if (Integer.valueOf(opcion) != 4)
                System.out.print("SELECCIONE UNA OPCION VALIDA [1,2,3 O 4]... ");
            else if (Integer.valueOf(opcion) == 4)
                System.out.print("\n\nH A S T A   L A   V I S T A ! ! !");
        }
    }
    
    static void generalesEmpleado(String empleadoArreglo[][], int c){
        System.out.println("\n\n### INFORMACION GENERAL DEL EMPLEADO ###");
        String[] datosEmpleado = {"* CODIGO:     ", "* NOMBRE:    ", "* DIRECCION: ", "* SUELDO x HORA:          "};
        for (int i = 0; i < 4; i++)
        {
             System.out.println(datosEmpleado[i]);
             Scanner entradaTeclado = new Scanner(System.in);
             empleadoArreglo[c][i] = entradaTeclado.nextLine().toUpperCase();
        }
    }
    
    static double calculoSueldo(double sueldoPorHora){
        System.out.println("\n\n### CALCULAR SUELDO ###");
        System.out.println("* HORAS TRABAJADAS: ");
        Scanner entradaTeclado = new Scanner(System.in);
        double sueldo = Double.parseDouble(String.valueOf(entradaTeclado.nextLine())) * sueldoPorHora;
        return sueldo;
    }

    static String espacios(String cadena, int cantEspacios){
       String espacioEnBlanco = "";
       int cantidadEspacios = cantEspacios - cadena.length();
       for(int i=0; i<cantidadEspacios; i++)
           espacioEnBlanco = espacioEnBlanco + " ";
       return espacioEnBlanco;
    }

    static void imrimeSalida(String[][] empleadoArreglo){
        System.out.println("\n\n|--------------|----------------------------------|----------------------------------|---------------|-----------------|-----------|");        
        System.out.println("| NO. EMPLEADO | NOMBRE                           | DIRECCION                        | SUELDO x HORA | HRS. TRABAJADAS |   TOTAL   |");        
        System.out.println("|--------------|----------------------------------|----------------------------------|---------------|-----------------|-----------|");        
        System.out.println("| " + empleadoArreglo[0][0] + Ejercicio1_SueldoEmpleado.espacios(empleadoArreglo[0][0], 13) + "| " + 
                                  empleadoArreglo[0][1] + Ejercicio1_SueldoEmpleado.espacios(empleadoArreglo[0][1], 33) + "| " + 
                                  empleadoArreglo[0][2] + Ejercicio1_SueldoEmpleado.espacios(empleadoArreglo[0][2], 33) + "| " + 
                                  empleadoArreglo[0][3] + Ejercicio1_SueldoEmpleado.espacios(empleadoArreglo[0][3], 14) + "| " + 
                                  empleadoArreglo[0][4] + Ejercicio1_SueldoEmpleado.espacios(empleadoArreglo[0][4], 16) + "| " +                         
                                  empleadoArreglo[0][5] + Ejercicio1_SueldoEmpleado.espacios(empleadoArreglo[0][5], 10) + "| ");
        System.out.println("|--------------|----------------------------------|----------------------------------|---------------|-----------------|-----------|\n\n");                        
    }
}
