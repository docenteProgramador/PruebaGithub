/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciopruebagithub;

import java.util.Scanner;

public class EjercicioPruebaGitHub {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        final double IMPUESTO = 0.15;

        // Matriz de inventario
        int[][] inventario = {
            {50, 35, 40},
            {30, 45, 25},
            {20, 15, 30},
            {100, 80, 90}
        };

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

                            int codigo = ObtenerCodigoProducto(categoria, producto);
                            String nombre = ObtenerNombreProducto(categoria, producto);
                            double precio = ObtenerPrecioProducto(categoria, producto);

                            int existencia = ObtenerExistencia(
                                    inventario, categoria, producto);

                            System.out.println("\n=================================");
                            System.out.println("       PRODUCTO SELECCIONADO");
                            System.out.println("=================================");

                            System.out.println("Codigo: " + codigo);
                            System.out.println("Producto: " + nombre);
                            System.out.printf("Precio: L. %.2f%n", precio);
                            System.out.println("Existencia: " + existencia);

                            int cantidad = ValidacionCantidad(sc);

                            if (cantidad <= existencia) {

                                double subtotal = CalcularSubtotal(
                                        cantidad, precio);

                                System.out.println("\n=================================");
                                System.out.println("       RESUMEN DE COMPRA");
                                System.out.println("=================================");

                                System.out.println("Producto: " + nombre);
                                System.out.println("Cantidad: " + cantidad);
                                System.out.printf(
                                        "Precio: L. %.2f%n", precio);
                                System.out.printf(
                                        "Subtotal: L. %.2f%n", subtotal);

                                inventario[categoria - 1][producto - 1]
                                        = inventario[categoria - 1][producto - 1]
                                        - cantidad;

                                System.out.println(
                                        "Compra registrada correctamente.");
                                System.out.println(
                                        "Nueva existencia: "
                                        + inventario[categoria - 1][producto - 1]);

                            } else {

                                System.out.println("\nNo hay suficiente");
                                System.out.println("inventario disponible.");
                                System.out.println(
                                        "Existencia actual: " + existencia);

                            }

                        }

                    }

                    break;

                case 2:

                    System.out.println("\nSelecciono: Buscar Producto");
                    break;

                case 3:

                    MostrarInventario(inventario);
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


    public static int ObtenerCodigoProducto(
            int categoria, int producto) {

        int codigo = 0;

        if (categoria == 1) {

            if (producto == 1) {
                codigo = 101;
            } else if (producto == 2) {
                codigo = 102;
            } else if (producto == 3) {
                codigo = 103;
            }

        } else if (categoria == 2) {

            if (producto == 1) {
                codigo = 201;
            } else if (producto == 2) {
                codigo = 202;
            } else if (producto == 3) {
                codigo = 203;
            }

        } else if (categoria == 3) {

            if (producto == 1) {
                codigo = 301;
            } else if (producto == 2) {
                codigo = 302;
            } else if (producto == 3) {
                codigo = 303;
            }

        } else if (categoria == 4) {

            if (producto == 1) {
                codigo = 401;
            } else if (producto == 2) {
                codigo = 402;
            } else if (producto == 3) {
                codigo = 403;
            }

        }

        return codigo;

    }//Fin de Funcion ObtenerCodigoProducto


    public static String ObtenerNombreProducto(
            int categoria, int producto) {

        String nombre = "";

        if (categoria == 1) {

            if (producto == 1) {
                nombre = "Arquiteja";
            } else if (producto == 2) {
                nombre = "Thermotecho";
            } else if (producto == 3) {
                nombre = "Lamina Lisa";
            }

        } else if (categoria == 2) {

            if (producto == 1) {
                nombre = "Canal C";
            } else if (producto == 2) {
                nombre = "Tubo Cuadrado";
            } else if (producto == 3) {
                nombre = "Angulo";
            }

        } else if (categoria == 3) {

            if (producto == 1) {
                nombre = "Martillo";
            } else if (producto == 2) {
                nombre = "Taladro";
            } else if (producto == 3) {
                nombre = "Flexometro";
            }

        } else if (categoria == 4) {

            if (producto == 1) {
                nombre = "Tornillos";
            } else if (producto == 2) {
                nombre = "Bisagras";
            } else if (producto == 3) {
                nombre = "Remaches";
            }

        }

        return nombre;

    }//Fin de Funcion ObtenerNombreProducto


    public static double ObtenerPrecioProducto(
            int categoria, int producto) {

        double precio = 0;

        if (categoria == 1) {

            if (producto == 1) {
                precio = 1250;
            } else if (producto == 2) {
                precio = 950;
            } else if (producto == 3) {
                precio = 850;
            }

        } else if (categoria == 2) {

            if (producto == 1) {
                precio = 1200;
            } else if (producto == 2) {
                precio = 850;
            } else if (producto == 3) {
                precio = 650;
            }

        } else if (categoria == 3) {

            if (producto == 1) {
                precio = 350;
            } else if (producto == 2) {
                precio = 2500;
            } else if (producto == 3) {
                precio = 175;
            }

        } else if (categoria == 4) {

            if (producto == 1) {
                precio = 50;
            } else if (producto == 2) {
                precio = 75;
            } else if (producto == 3) {
                precio = 60;
            }

        }

        return precio;

    }//Fin de Funcion ObtenerPrecioProducto


    public static int ValidacionCantidad(Scanner sc) {

        int cantidad = 0;

        do {

            System.out.print(
                    "\nIngrese la cantidad que desea comprar: ");

            cantidad = sc.nextInt();

            if (cantidad <= 0) {

                System.out.println("Cantidad invalida.");
                System.out.println(
                        "La cantidad debe ser mayor que cero.");

            }

        } while (cantidad <= 0);

        return cantidad;

    }//Fin de Funcion ValidacionCantidad


    public static double CalcularSubtotal(
            int cantidad, double precio) {

        double subtotal = 0;

        subtotal = cantidad * precio;

        return subtotal;

    }//Fin de Funcion CalcularSubtotal


    public static int ObtenerExistencia(
            int[][] inventario, int categoria, int producto) {

        int existencia = 0;

        existencia = inventario[categoria - 1][producto - 1];

        return existencia;

    }//Fin de Funcion ObtenerExistencia


    public static void MostrarInventario(int[][] inventario) {

        System.out.println("\n========================================");
        System.out.println("           INVENTARIO ACTUAL");
        System.out.println("========================================");

        for (int i = 0; i < inventario.length; i++) {

            System.out.println("\nCategoria " + (i + 1));

            for (int j = 0; j < inventario[i].length; j++) {

                String nombre = ObtenerNombreProducto(i + 1, j + 1);
                int codigo = ObtenerCodigoProducto(i + 1, j + 1);

                System.out.println(
                        "Codigo: " + codigo
                        + "\tProducto: " + nombre
                        + "\tExistencia: " + inventario[i][j]);

            }//Fin Ciclo FOR Productos

        }//Fin Ciclo FOR Categorias

    }//Fin de Funcion MostrarInventario

}//Fin de Class