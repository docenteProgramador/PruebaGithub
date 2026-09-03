/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciopruebagithub;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Escenario 1: Registro de huéspedes y reservas El hotel necesita llevar un
 * registro basico de los huespedes que desean realizar una reserva, asi como la
 * informacion relacionada con su estadia. 
 * Tenemos: 
 * Registrar el nombre del huésped. 
 * Registrar la cantidad de noches de la estadía. 
 * Seleccionar el tipo de habitación que desea reservar. 
 * Validar la información ingresada por el huésped. 
 * Confirmar la reserva solicitada. 
 * Mostrar la información correspondiente a la reserva realizada. 
 * Valor agregado: Colocar un Calendario en donde se le pida al usuario
 * el dia que entrada, y luego de eso genere el de salida.
 * 
 * //Colocar un ciclo While( Para la fecha en donde el usuario ingrese del 1 al 31, y tambien tiene que coincidir con el mes)
 * que se coloque error si la persona coloca un 33 y un mes mayor a 12 y menor al ano 2026
 * En la fecha colocar una funcion
 * // Limite de la cantidad de noches
 * 
 * @author angie
 */
public class ProyectoProgra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        //Declaracion de Variables
        String nombreHuesped = "";
        int cantidadNoches = 0;
        int tipoHabitacion = 0;
        char confirmacion = '@';
        double precioHabitacion = 0;
        double totalReserva = 0;
        int dia = 0;
        int mes = 0;
        int año = 0;
        //Variables de fecha - Libreria LocalDate
        LocalDate fechaEntrada = null;
        LocalDate fechaSalida = null;
        boolean fechaValida = false;
        
        //Variables de hora - Libreria LocalTime
        LocalTime horaEntrada = LocalTime.of(15, 0);
        LocalTime horaSalida = LocalTime.of(12, 0);
        
        
        System.out.println("======== SISTEMA DE REGISTRO DE HUESPED =======");

        System.out.println("Ingrese el nombre del huesped: ");
        nombreHuesped = sc.nextLine(); //Lee toda la línea que escriba el usuario.Por eso usamos nextLine() para el nombre del huésped, porque puede tener nombre y apellido.

        do {
            //Seleccion de Habitaciones
            System.out.println("\nSeleccione el tipo de habitacion");
            System.out.println("1. Habitacion Sencilla");
            System.out.println("2. Habitacion Doble");
            System.out.println("3. Suite");
            System.out.println("Respuesta:");

            tipoHabitacion = sc.nextInt(); //Lee un número entero.
            switch (tipoHabitacion) {
                case 1:
                    System.out.println("Selecciono Habitacion Sencilla");

                    break;

                case 2:
                    System.out.println("Selecciono Habitacion Doble");

                    break;

                case 3:
                    System.out.println("Selecciono Habitacion Suite");

                    break;

                default:
                    System.out.println("Tipo de habitacion no valido, la opcion es de 1 al 3");
                    break;
            } //Fin de Switch

            switch (tipoHabitacion) {
                case 1:
                    precioHabitacion = 50;
                    break;

                case 2:
                    precioHabitacion = 80;
                    break;

                case 3:
                    precioHabitacion = 120;
                    break;
            }//Fin de Switch de precios

        }//Fin de Do
        while (tipoHabitacion < 1 || tipoHabitacion > 3); //Mientras la habitación sea menor que 1 O mayor que 3, vuelve a mostrar el menú.

        //Registro de Noches
        do {
            System.out.println("Ingrese la cantidad de noches:");
            cantidadNoches = sc.nextInt();

            if (cantidadNoches <= 0) {
                System.out.println("Cantidad de noches no valida");
            }

        }//Fin de do 
        while (cantidadNoches <= 0); //¿La cantidad de noches es menor o igual a cero? 0 <= 0 V

      do {
            do {
                System.out.println("Ingrese el dia de entrada:");
                dia = sc.nextInt();
                if (dia < 1 || dia > 31) {
                    System.out.println("Dia no valido, debe ser entre 1 y 31");
                }
            } while (dia < 1 || dia > 31);
            
            do {
                System.out.println("Ingrese el mes de entrada:");
                mes = sc.nextInt();
                if (mes < 1 || mes > 12) {
                    System.out.println("Mes no valido, tiene que ser mayor a 1 y menor a 12");
                }
            } while (mes < 1 || mes > 12);
                
            do {
                System.out.println("Ingrese el año de entrada:");
                año = sc.nextInt();
                if (año != 2026) {
                    System.out.println("Año no valido, tiene que ser el año actual (2026)");
                }
            } while (año != 2026);

    try {
        fechaEntrada = LocalDate.of(año, mes, dia);
        fechaValida = true;

    } catch (Exception e) {
        System.out.println("Fecha no valida, ingrese ano, mes y dia conforme a calendario");
        fechaValida = false;
    }

} while (!fechaValida);

        fechaSalida = fechaEntrada.plusDays(cantidadNoches);
        
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        totalReserva = precioHabitacion * cantidadNoches;

        System.out.println("");
        System.out.println("Desea confirmar la reserva? (S/N) --- ");
        System.out.println("Respuesta: ");
        confirmacion = sc.next().toUpperCase().charAt(0); // Next : Lee solamente hasta encontrar un espacio.

        if (confirmacion == 'S') {
            System.out.println("Reserva Confirmada");
            System.out.println("");

            System.out.println("Detalles de la reserva:");
            System.out.println("Nombre: " + nombreHuesped);
            System.out.println("Cantidad de noches: " + cantidadNoches);
            System.out.println("Tipo de habitacion: " + tipoHabitacion);
            System.out.println("Precio por noche: $" + precioHabitacion);
            System.out.println("Total a pagar: $" + totalReserva);
            System.out.println("Fecha de entrada: " + fechaEntrada.format(formatoFecha));
            System.out.println("Fecha de salida: " + fechaSalida.format(formatoFecha));
            System.out.println("Horario de entrada: " + horaEntrada);
            System.out.println("Horario de salida: " + horaSalida);
            
            System.out.println("");
            System.out.println("¿Desea realizar el Check-in? (S/N)");
            System.out.println("Respuesta:");

            char realizarCheckIn = sc.next().toUpperCase().charAt(0);

            if (realizarCheckIn == 'S') {
            System.out.println("Check-in realizado correctamente.");
            System.out.println("Hora de entrada: " + horaEntrada);
            } else {
            System.out.println("Check-in no realizado.");
        }

        }//fin if
        else {
            System.out.println("Reserva no confirmada");
        }

    }//Fin main
    
}//Fin de class