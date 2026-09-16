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

                    int categoria = menuCategorias(sc);

                    if (categoria != 5) {

                        int producto = menuProductos(sc, categoria);

                        if (producto != 4) {

                            System.out.println("\nProducto seleccionado correctamente.");
                            System.out.println("Categoria: " + categoria);
                            System.out.println("Producto: " + producto);

                        }

                    }

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


    public static int menuCategorias(Scanner sc) {

        int opcion;

        do {

            System.out.println("\n====================================");
            System.out.println("      CATEGORIAS DE PRODUCTOS");
            System.out.println("====================================");
            System.out.println("1. Laminas");
            System.out.println("2. Perfiles");
            System.out.println("3. Herramientas");
            System.out.println("4. Accesorios");
            System.out.println("5. Volver");
            System.out.print("Seleccione una categoria: ");

            opcion = sc.nextInt();

            if (opcion < 1 || opcion > 5) {

                System.out.println("Opcion invalida.");

            }

        } while (opcion < 1 || opcion > 5);

        return opcion;

    }//Fin de Funcion menuCategorias


    public static int menuProductos(Scanner sc, int categoria) {

        int opcion;

        do {

            System.out.println("\n====================================");
            System.out.println("        PRODUCTOS DISPONIBLES");
            System.out.println("====================================");

            switch (categoria) {

                case 1:

                    System.out.println("1. Arquiteja");
                    System.out.println("2. Thermotecho");
                    System.out.println("3. Lamina Lisa");

                    break;

                case 2:

                    System.out.println("1. Canal C");
                    System.out.println("2. Tubo Cuadrado");
                    System.out.println("3. Angulo");

                    break;

                case 3:

                    System.out.println("1. Martillo");
                    System.out.println("2. Taladro");
                    System.out.println("3. Flexometro");

                    break;

                case 4:

                    System.out.println("1. Tornillos");
                    System.out.println("2. Bisagras");
                    System.out.println("3. Remaches");

                    break;

            }//Fin Switch

            System.out.println("4. Volver");
            System.out.print("Seleccione un producto: ");

            opcion = sc.nextInt();

            if (opcion < 1 || opcion > 4) {

                System.out.println("Opcion invalida.");

            }

        } while (opcion < 1 || opcion > 4);

        return opcion;

    }//Fin de Funcion menuProductos

}//Fin de Class
