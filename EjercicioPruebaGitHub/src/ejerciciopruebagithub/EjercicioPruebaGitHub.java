/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciopruebagithub;

import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioPruebaGitHub {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        final double IMPUESTO = 0.15;

        //Numero inicial para las facturas
        int numeroFactura = 1000;

        //Acumuladores de la venta
        double acumuladoVenta = 0;
        int totalProductosVendidos = 0;

        //Lista para registrar las compras
        ArrayList<String> compras = new ArrayList<>();

        //Matriz de inventario
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
                            int codigo = ObtenerCodigoProducto(
                                    categoria, producto);
                            String nombre = ObtenerNombreProducto(
                                    categoria, producto);
                            double precio = ObtenerPrecioProducto(
                                    categoria, producto);
                            int existencia = ObtenerExistencia(
                                    inventario, categoria, producto);

                            System.out.println("\n================================");
                            System.out.println("     PRODUCTO SELECCIONADO");
                            System.out.println("================================");
                            System.out.println("Codigo: " + codigo);
                            System.out.println("Producto: " + nombre);
                            System.out.printf("Precio: L. %.2f%n", precio);
                            System.out.println("Existencia: " + existencia);

                            int cantidad = ValidacionCantidad(sc);
                            if (cantidad <= existencia) {
                                double subtotal =
                                        CalcularSubtotal(cantidad, precio);

                                //Acumular venta
                                acumuladoVenta =
                                        acumuladoVenta + subtotal;

                                //Acumular productos vendidos
                                totalProductosVendidos =
                                        totalProductosVendidos + cantidad;

                                //Actualizar inventario
                                inventario[categoria - 1][producto - 1] =
                                        inventario[categoria - 1][producto - 1]
                                        - cantidad;

                                //Registrar compra
                                String registro =
                                        codigo + " - " + nombre
                                        + " - Cantidad: " + cantidad
                                        + " - Subtotal: L. "
                                        + String.format("%.2f", subtotal);

                                compras.add(registro);

                                System.out.println("\nCompra registrada.");
                                System.out.printf(
                                        "Subtotal: L. %.2f%n",
                                        subtotal);
                                System.out.println(
                                        "Nueva existencia: "
                                        + inventario[categoria - 1]
                                                [producto - 1]);
                                System.out.println(
                                        "Productos registrados: "
                                        + compras.size());
                            } else {
                                System.out.println(
                                        "\nNo hay suficiente inventario.");
                                System.out.println(
                                        "Existencia disponible: "
                                        + existencia);
                            }
                        }
                    }
                    break;

                case 2:
                    BuscarProducto(sc, inventario);
                    break;
                case 3:
                    MostrarInventario(inventario);
                    break;
                case 4:
                    if (acumuladoVenta > 0) {
                        numeroFactura++;
                        MostrarReporte(
                                compras,
                                acumuladoVenta,
                                totalProductosVendidos,
                                IMPUESTO,
                                numeroFactura,
                                sc);
                        MostrarEstadisticas(
                                compras,
                                acumuladoVenta,
                                totalProductosVendidos);
                    } else {
                        System.out.println(
                                "\nNo existen ventas registradas.");
                    }
                    break;
                case 5:

                    System.out.println("\n================================");
                    System.out.println("       SISTEMA DE VENTAS");
                    System.out.println("================================");
                    System.out.println("Programa finalizado.");
                    System.out.println(
                            "Gracias por su compra, lo esperamos pronto...");
                    break;
                default:
                    System.out.println("\nOpcion incorrecta.");
                    System.out.println(
                            "Ingrese una opcion del 1 al 5.");
                    break;
                    }//Fin Switch
        } while (opcion != 5);
    }//Fin de Main


    // Muestra el menu principal
    public static void MostrarMenuPrincipal() {

        System.out.println("\n========================================");
        System.out.println("             FERRETERIA");
        System.out.println("               CEUTEC");
        System.out.println("========================================");
        System.out.println("1. Realizar Venta");
        System.out.println("2. Buscar Producto");
        System.out.println("3. Consultar Inventario");
        System.out.println("4. Reporte de Ventas");
        System.out.println("5. Salir");
        System.out.println("----------------------------------------");
    }//Fin de Funcion MostrarMenuPrincipal

    // Muestra las categorias
    public static int menuCategorias(Scanner sc) {

        int opcion;
        do {
            System.out.println("\n================================");
            System.out.println("      CATEGORIAS DE PRODUCTOS");
            System.out.println("================================");
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

    // Muestra los productos de cada categoria
    public static int menuProductos(
            Scanner sc, int categoria) {
        int opcion;
        do {
            System.out.println("\n================================");
            System.out.println("       PRODUCTOS DISPONIBLES");
            System.out.println("================================");
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
                    System.out.println("3. Piocha");
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


    // Obtiene el codigo del producto
    public static int ObtenerCodigoProducto(
            int categoria, int producto) {

        int codigo = 0;

        if (categoria == 1) {
            if (producto == 1) {
                codigo = 101;
            } else if (producto == 2) {
                codigo = 102;
            } else {
                codigo = 103;
            }
        } else if (categoria == 2) {
            if (producto == 1) {
                codigo = 201;
            } else if (producto == 2) {
                codigo = 202;
            } else {
                codigo = 203;
            }
        } else if (categoria == 3) {
            if (producto == 1) {
                codigo = 301;
            } else if (producto == 2) {
                codigo = 302;
            } else {
                codigo = 303;
            }
        } else if (categoria == 4) {
            if (producto == 1) {
                codigo = 401;
            } else if (producto == 2) {
                codigo = 402;
            } else {
                codigo = 403;
            }
        }
        return codigo;
    }//Fin de Funcion ObtenerCodigoProducto


    //Obtener el nombre del producto
    public static String ObtenerNombreProducto(
            int categoria, int producto) {

        String nombre = "";
        if (categoria == 1) {
            if (producto == 1) {
                nombre = "Arquiteja";
            } else if (producto == 2) {
                nombre = "Thermotecho";
            } else {
                nombre = "Lamina Lisa";
            }
            
        } else if (categoria == 2) {
            if (producto == 1) {
                nombre = "Canal C";
            } else if (producto == 2) {
                nombre = "Tubo Cuadrado";
            } else {
                nombre = "Angulo";
            }

        } else if (categoria == 3) {
            if (producto == 1) {
                nombre = "Martillo";
            } else if (producto == 2) {
                nombre = "Taladro";
            } else {
                nombre = "Flexometro";
            }

        } else if (categoria == 4) {
            if (producto == 1) {
                nombre = "Tornillos";
            } else if (producto == 2) {
                nombre = "Bisagras";
            } else {
                nombre = "Remaches";
            }
        }
        return nombre;
    }//Fin de Funcion ObtenerNombreProducto


    // Obtiene el precio del producto
    public static double ObtenerPrecioProducto(
            int categoria, int producto) {

        double precio = 0;

        if (categoria == 1) {
            if (producto == 1) {
                precio = 1250;
            } else if (producto == 2) {
                precio = 950;
            } else {
                precio = 850;
            }

        } else if (categoria == 2) {
            if (producto == 1) {
                precio = 1200;
            } else if (producto == 2) {
                precio = 850;
            } else {
                precio = 650;
            }

        } else if (categoria == 3) {
            if (producto == 1) {
                precio = 350;
            } else if (producto == 2) {
                precio = 2500;
            } else {
                precio = 175;
            }

        } else if (categoria == 4) {
            if (producto == 1) {
                precio = 50;
            } else if (producto == 2) {
                precio = 75;
            } else {
                precio = 60;
            }
        }
        return precio;
    }//Fin de Funcion ObtenerPrecioProducto


    // Valida que la cantidad sea mayor que cero
    public static int ValidacionCantidad(Scanner sc) {

        int cantidad;

        do {
            System.out.print(
                    "\nIngrese la cantidad que desea comprar: ");
            cantidad = sc.nextInt();

            if (cantidad <= 0) {

                System.out.println(
                        "La cantidad debe ser mayor que cero.");
            }
        } while (cantidad <= 0);
        return cantidad;
    }//Fin de Funcion ValidacionCantidad


    // Calcula el subtotal
    public static double CalcularSubtotal(
            int cantidad, double precio) {

        return cantidad * precio;

    }//Fin de Funcion CalcularSubtotal


    // Obtiene la existencia del inventario
    public static int ObtenerExistencia(
            int[][] inventario,
            int categoria,
            int producto) {

        return inventario[categoria - 1][producto - 1];

    }//Fin de Funcion ObtenerExistencia


    // Muestra todo el inventario
    public static void MostrarInventario(
            int[][] inventario) {

        System.out.println("\n========================================");
        System.out.println("           INVENTARIO ACTUAL");
        System.out.println("========================================");

        // Ciclo para las categorias
        for (int i = 0; i < inventario.length; i++) {

            System.out.println(
                    "\nCategoria " + (i + 1));

            // Ciclo para los productos
            for (int j = 0;
                    j < inventario[i].length;
                    j++) {

                int codigo =
                        ObtenerCodigoProducto(i + 1, j + 1);

                String nombre =
                        ObtenerNombreProducto(i + 1, j + 1);

                System.out.println(
                        "Codigo: " + codigo
                        + "\tProducto: " + nombre
                        + "\tExistencia: "
                        + inventario[i][j]);

            }//Fin Ciclo FOR Productos

        }//Fin Ciclo FOR Categorias

    }//Fin de Funcion MostrarInventario


    // Obtiene el porcentaje de descuento
    public static double ObtenerPorcentajeDescuento(
            double subtotal) {

        double porcentaje;

        if (subtotal < 5000) {

            porcentaje = 0;

        } else if (subtotal < 10000) {

            porcentaje = 0.05;

        } else if (subtotal < 20000) {

            porcentaje = 0.10;

        } else {

            porcentaje = 0.15;

        }

        return porcentaje;
    }//Fin de Funcion ObtenerPorcentajeDescuento


    // Muestra las compras guardadas
    public static void MostrarCompras(
            ArrayList<String> compras) {

        System.out.println("\n========================================");
        System.out.println("          COMPRAS REALIZADAS");
        System.out.println("========================================");

        // Ciclo para recorrer las compras
        for (int i = 0; i < compras.size(); i++) {

            System.out.println(
                    (i + 1) + ". " + compras.get(i));
        }//Fin Ciclo FOR

        System.out.println(
                "Total de compras: " + compras.size());
    }//Fin de Funcion MostrarCompras


    // Selecciona la forma de pago
    public static int SeleccionarFormaPago(
            Scanner sc) {

        int opcion;

        do {

            System.out.println("\n================================");
            System.out.println("          FORMA DE PAGO");
            System.out.println("================================");
            System.out.println("1. Efectivo");
            System.out.println("2. Tarjeta");
            System.out.println("3. Transferencia");

            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            if (opcion < 1 || opcion > 3) {

                System.out.println(
                        "Opcion de pago invalida.");

            }

        } while (opcion < 1 || opcion > 3);
        return opcion;
    }//Fin de Funcion SeleccionarFormaPago


    // Obtiene el nombre de la forma de pago
    public static String ObtenerFormaPago(
            int opcion) {

        String formaPago = "";

        switch (opcion) {

            case 1:

                formaPago = "Efectivo";
                break;

            case 2:

                formaPago = "Tarjeta";
                break;

            case 3:

                formaPago = "Transferencia";
                break;
        }
        return formaPago;
    }//Fin de Funcion ObtenerFormaPago


    // Busca un producto utilizando su codigo
    public static void BuscarProducto(
            Scanner sc, int[][] inventario) {

        System.out.println("\n================================");
        System.out.println("        BUSCAR PRODUCTO");
        System.out.println("================================");

        System.out.print("Ingrese el codigo del producto: ");
        int codigoBuscado = sc.nextInt();

        boolean encontrado = false;

        // Recorre las categorias
        for (int i = 0; i < inventario.length; i++) {

            // Recorre los productos
            for (int j = 0; j < inventario[i].length; j++) {

                int codigo =
                        ObtenerCodigoProducto(i + 1, j + 1);

                if (codigo == codigoBuscado) {

                    String nombre =
                            ObtenerNombreProducto(i + 1, j + 1);

                    double precio =
                            ObtenerPrecioProducto(i + 1, j + 1);

                    System.out.println(
                            "\nProducto encontrado.");

                    System.out.println(
                            "Codigo: " + codigo);

                    System.out.println(
                            "Producto: " + nombre);

                    System.out.printf(
                            "Precio: L. %.2f%n",
                            precio);

                    System.out.println(
                            "Existencia: "
                            + inventario[i][j]);

                    encontrado = true;
                }
            }//Fin Ciclo FOR Productos
        }//Fin Ciclo FOR Categorias
        if (!encontrado) {
            System.out.println(
                    "\nNo existe un producto con ese codigo.");
        }
    }//Fin de Funcion BuscarProducto


    // Muestra las estadisticas de ventas
    public static void MostrarEstadisticas(
            ArrayList<String> compras,
            double totalVentas,
            int productosVendidos) {

        double promedioCompra =
                totalVentas / compras.size();

        System.out.println("\n========================================");
        System.out.println("        ESTADISTICAS DE VENTAS");
        System.out.println("========================================");

        System.out.println(
                "Cantidad de compras: " + compras.size());

        System.out.println(
                "Productos vendidos: " + productosVendidos);

        System.out.printf(
                "Total de ventas: L. %.2f%n",
                totalVentas);

        System.out.printf(
                "Promedio por compra: L. %.2f%n",
                promedioCompra);

        System.out.println("========================================");
    }//Fin de Funcion MostrarEstadisticas


    // Muestra el reporte de la venta
    public static void MostrarReporte(
            ArrayList<String> compras,
            double subtotal,
            int productosVendidos,
            double impuesto,
            int numeroFactura,
            Scanner sc) {

        double porcentaje =
                ObtenerPorcentajeDescuento(subtotal);

        double descuento =
                subtotal * porcentaje;

        double subtotalDescuento =
                subtotal - descuento;

        double valorImpuesto =
                subtotalDescuento * impuesto;

        double total =
                subtotalDescuento + valorImpuesto;

        MostrarCompras(compras);

        System.out.println("\n========================================");
        System.out.println("             FACTURA");
        System.out.println("========================================");

        System.out.println(
                "Numero de factura: " + numeroFactura);

        System.out.println(
                "Productos vendidos: "
                + productosVendidos);

        System.out.printf(
                "Subtotal: L. %.2f%n",
                subtotal);

        System.out.printf(
                "Descuento: %.0f%%%n",
                porcentaje * 100);

        System.out.printf(
                "Valor descuento: L. %.2f%n",
                descuento);

        System.out.printf(
                "Subtotal con descuento: L. %.2f%n",
                subtotalDescuento);

        System.out.printf(
                "ISV 15%%: L. %.2f%n",
                valorImpuesto);

        System.out.printf(
                "TOTAL A PAGAR: L. %.2f%n",
                total);

        int pago = SeleccionarFormaPago(sc);

        System.out.println(
                "Forma de pago: "
                + ObtenerFormaPago(pago));
        System.out.println("========================================");
    }//Fin de Funcion MostrarReporte
}//Fin de Class