/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Vista;

import java.util.*;
import Controlador.*;
import Excepciones.*;

/**
 * Clase principal del sistema Rutas S.A. que contiene el menú de interacción con el usuario.
 * Permite gestionar choferes, vehículos y viajes mediante un menú de consola.
 * 
 * Ofrece submenús para realizar operaciones como agregar, editar, eliminar y mostrar registros.
 * Controla también excepciones personalizadas y errores de entrada del usuario.
 * 
 * @author Gaston. 
 * @author Denis.
 * @author Enzo.
 */
public class Rutas_SA {
    
    /**
     * Muestra el submenú de gestión de choferes y permite realizar operaciones
     * como agregar, editar, eliminar o mostrar choferes.
     * 
     * @param sc   Scanner utilizado para capturar entradas desde consola.
     * @param ctrl Controlador de choferes.
     */
    private static void menuChoferes(Scanner sc, Ctrl_Chofer ctrl) {
        int opcion;
        boolean volver = false;
        do {
            sc = new Scanner(System.in);
            try {
                System.out.print("\n* SUBMENU CHOFERES *\n"
                        + "[1.AGREGAR CHOFER]\n"
                        + "[2.EDITAR CHOFER]\n"
                        + "[3.ELIMINAR CHOFER]\n"
                        + "[4.MOSTRAR CHOFER]\n"
                        + "[0.VOLVER]\n"
                        + "INGRESE UNA OPCION: ");
                opcion = sc.nextInt();
                if (opcion < 0 || opcion > 4) {
                    throw new IngresoInvalidoExcepcion("[ERROR: SOLO PUEDE INGRESAR LAS OPCIONES SUGERIDAS]");
                }
                switch (opcion) {
                    case 0:
                        volver = true;
                        break;
                    case 1:
                        ctrl.agregarChofer();
                        break;
                    case 2:
                        ctrl.editarChofer();
                        break;
                    case 3:
                        ctrl.eliminarChofer();
                        break;
                    case 4:
                        ctrl.mostrarChofer();
                        break;
                }
            } catch (IngresoInvalidoExcepcion e) {
                System.out.println("\n" + e.getMensaje());
            } catch (InputMismatchException e) {
                System.out.println("\n[ERROR: NO PUEDE INGRESAR LETRAS EN UN CAMPO NUMERICO]");
            }
        } while (!volver);
    }

    /**
     * Muestra el submenú de gestión de vehiculos y permite realizar operaciones
     * como agregar, editar, eliminar o mostrar vehiculos.
     * 
     * @param sc   Scanner utilizado para capturar entradas desde consola.
     * @param ctrl Controlador de vehiculos.
     */
    private static void menuVehiculos(Scanner sc, Ctrl_Vehiculo ctrl) {
        int opcion;
        boolean volver = false;
        do {
            sc = new Scanner(System.in);
            try {
                System.out.print("\n* SUBMENU VEHICULOS *\n"
                        + "[1.AGREGAR VEHICULO]\n"
                        + "[2.EDITAR VEHICULO]\n"
                        + "[3.ELIMINAR VEHICULO]\n"
                        + "[4.MOSTRAR VEHICULO]\n"
                        + "[0.VOLVER]\n"
                        + "INGRESE UNA OPCION: ");
                opcion = sc.nextInt();
                if (opcion < 0 || opcion > 4) {
                    throw new IngresoInvalidoExcepcion("[ERROR: SOLO PUEDE INGRESAR LAS OPCIONES SUGERIDAS]");
                }
                switch (opcion) {
                    case 0:
                        volver = true;
                        break;
                    case 1:
                        ctrl.agregarVehiculo();
                        break;
                    case 2:
                        ctrl.editarVehiculo();
                        break;
                    case 3:
                        ctrl.eliminarVehiculo();
                        break;
                    case 4:
                        ctrl.mostrarVehiculo();
                        break;
                }
            } catch (IngresoInvalidoExcepcion e) {
                System.out.println("\n" + e.getMensaje());
            } catch (InputMismatchException e) {
                System.out.println("[ERROR: NO PUEDE INGRESAR LETRAS EN UN CAMPO NUMERICO]");
            }
        } while (!volver);
    }


    private static void menuViajes(Scanner sc, Ctrl_Viaje ctrl) {

    /**
     * Muestra el submenú de gestión de viajes y permite realizar operaciones
     * como planificar, editar, eliminar o mostrar viajes.
     *
     * @param sc     Scanner utilizado para capturar entradas desde consola.
     * @param ctrl   Controlador de viajes, encargado de gestionar las operaciones sobre viajes.
     * @param ctrlV  Controlador de vehículos, utilizado para asociar vehículos a los viajes.
     * @param ctrlC  Controlador de choferes, utilizado para asociar choferes a los viajes.
     */
    private static void menuViajes(Scanner sc, Ctrl_Viaje ctrl, Ctrl_Vehiculo ctrlV, Ctrl_Chofer ctrlC) {

        int opcion;
        boolean volver = false;
        do {
            sc = new Scanner(System.in);
            try {
                System.out.print("\n* SUBMENU VIAJES *\n"
                        + "[1.AGREGAR VIAJE]\n"
                        + "[2.EDITAR VIAJE]\n"
                        + "[3.ELIMINAR VIAJE]\n"
                        + "[4.MOSTRAR VIAJE]\n"
                        + "[0.VOLVER]\n"
                        + "INGRESE UNA OPCION: ");
                opcion = sc.nextInt();
                if (opcion < 0 || opcion > 4) {
                    throw new IngresoInvalidoExcepcion("[ERROR: SOLO PUEDE INGRESAR LAS OPCIONES SUGERIDAS]");
                }
                switch (opcion) {
                    case 0:
                        volver = true;
                        break;
                    case 1:
                        ctrl.planificarViaje();
                        break;
                    case 2:
                        ctrl.editarViaje();
                        break;
                    case 3:
                        ctrl.eliminarViaje();
                        break;
                    case 4:
                        ctrl.mostrarViaje();
                        break;
                }
            } catch (IngresoInvalidoExcepcion e) {
                System.out.println("\n" + e.getMensaje());
            } catch (InputMismatchException e) {
                System.out.println("[ERROR: NO PUEDE INGRESAR LETRAS EN UN CAMPO NUMERICO]");
            }
        } while (!volver);
    }

    /**
     * Método principal que lanza el sistema Rutas S.A.
     * Presenta el menú principal y delega a los submenús correspondientes
     * para gestionar choferes, vehículos y viajes.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Ctrl_Chofer ctrlChofer = new Ctrl_Chofer();
        Ctrl_Vehiculo ctrlVehiculo = new Ctrl_Vehiculo();
        Ctrl_Viaje ctrlViaje = new Ctrl_Viaje(ctrlVehiculo, ctrlChofer);

        Scanner sc;
        int opcion;
        boolean finalizar = false;

        System.out.println("**************************************************");
        System.out.println("*             BIENVENIDO A RUTAS S.A             *");
        System.out.println("**************************************************");
        do {
            sc = new Scanner(System.in);
            try {
                System.out.print("\n* MENU PRINCIPAL *\n"
                        + "[1.GESTIONAR CHOFERES]\n"
                        + "[2.GESTIONAR VEHICULOS]\n"
                        + "[3.GESTIONAR VIAJES]\n"
                        + "[4.MOSTRAR VIAJES PROGRAMADOS]\n"
                        + "[5.MOSTRAR VIAJES HA REALIZAR DE UN VEHICULO]\n"
                        + "[6.MOSTRAR VIAJES REALIZADOS DE CADA CHOFER]\n"
                        + "[0.FINALIZAR]\n"
                        + "INGRESE UNA OPCION: ");
                opcion = sc.nextInt();
                if (opcion < 0 || opcion > 6) {
                    throw new IngresoInvalidoExcepcion("[ERROR: SOLO PUEDE INGRESAR LAS OPCIONES SUGERIDAS]");
                }

                switch (opcion) {
                    case 0:
                        finalizar = true;
                        sc.close();
                        System.out.println("\n[EL PROGRAMA HA FINALIZADO]");
                        System.out.println("**************************************************");
                        break;
                    case 1:
                        menuChoferes(sc, ctrlChofer);
                        break;
                    case 2:
                        menuVehiculos(sc, ctrlVehiculo);
                        break;
                    case 3:
                        menuViajes(sc, ctrlViaje);
                        break;
                    case 4:
                        ctrlViaje.mostrarViajesProgramados();
                        break;
                    case 5:
                        ctrlViaje.mostrarViajesVehiculo();
                        break;
                    case 6:
                        ctrlViaje.mostrarViajesChoferes();
                        break;
                }
            } catch (IngresoInvalidoExcepcion e) {
                System.out.println("\n" + e.getMensaje());
            } catch (InputMismatchException e) {
                System.out.println("\n[ERROR: NO PUEDE INGRESAR LETRAS EN UN CAMPO NUMERICO]");
            }
        } while (!finalizar);
    }
}