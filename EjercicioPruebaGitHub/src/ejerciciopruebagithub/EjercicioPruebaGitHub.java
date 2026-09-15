/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciopruebagithub;

import java.util.Scanner;

/**
 *
 * @author jaasi
 */
public class EjercicioPruebaGitHub {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
         int opcion = 0;

        // Constante del impuesto sobre ventas
        final double IMPUESTO = 0.15;

        do {

            MostrarMenuPrincipal();

            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("\nSelecciono: Realizar Venta");
                    break;

                case 2:
                    System.out.println("\nSelecciono: Buscar Producto");
                    break;

                case 3:
                    System.out.println("\nSelecciono: Consultar Inventario");
                    break;

                case 4:
                    System.out.println("\nSelecciono: Reporte de Ventas");
                    break;

                case 5:
                    System.out.println("\n=================================");
                    System.out.println("      SISTEMA DE VENTAS");
                    System.out.println("=================================");
                    System.out.println("Programa finalizado.");
                    System.out.println("Gracias por utilizar el sistema.");
                    break;

                default:
                    System.out.println("\nOpcion incorrecta.");
                    System.out.println("Ingrese una opcion del 1 al 5.");
                    break;

            }//Fin Switch

        } while (opcion != 5);
        
    }//Fin de Main
    
     public static void MostrarMenuPrincipal() {

        System.out.println("\n========================================");
        System.out.println("       SISTEMA DE VENTAS");
        System.out.println("          FERRETERIA");
        System.out.println("========================================");
        System.out.println("1. Realizar Venta");
        System.out.println("2. Buscar Producto");
        System.out.println("3. Consultar Inventario");
        System.out.println("4. Reporte de Ventas");
        System.out.println("5. Salir");
        System.out.println("========================================");

    }//Fin de Funcion MostrarMenuPrincipal
    
}//Fin de class
