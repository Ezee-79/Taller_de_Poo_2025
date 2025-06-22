/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Vista;

import java.util.*;
import Controlador.*;
import Excepciones.*;

public class Rutas_SA {
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
                        ctrl.planificarViaje(ctrlC, ctrlV);
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

    public static void main(String[] args) {
        Ctrl_Viaje ctrlViaje = new Ctrl_Viaje();
        Ctrl_Chofer ctrlChofer = new Ctrl_Chofer();
        Ctrl_Vehiculo ctrlVehiculo = new Ctrl_Vehiculo();

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
                        menuViajes(sc, ctrlViaje, ctrlVehiculo, ctrlChofer);
                        break;
                    case 4:
                        ctrlViaje.mostrarViajes();
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