/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Vista;

import java.util.Scanner;

import Controlador.Ctrl_Chofer;
import Controlador.Ctrl_Ciudad;
import Controlador.Ctrl_Vehiculo;
import Controlador.Ctrl_Viaje;

public class Rutas_SA {

    private static void menuChoferes(Scanner sc, Ctrl_Chofer ctrl) {
        boolean volver = false;
        int opcion = 0;
        do {
            System.out.print("\n* SUBMENU CHOFERES *\n"
                    + "[1.AGREGAR CHOFER]\n"
                    + "[2.EDITAR CHOFER]\n"
                    + "[3.ELIMINAR CHOFER]\n"
                    + "[4.MOSTRAR CHOFER]\n"
                    + "[0.VOLVER]\n"
                    + "INGRESE UNA OPCION: ");
            opcion = sc.nextInt();
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
                default:
                    System.out.println("[INGRESO INVALIDO]");
                    break;
            }
        } while (!volver);
    }

    private static void menuVehiculos(Scanner sc, Ctrl_Vehiculo ctrl) {
        boolean volver = false;
        int opcion = 0;
        do {
            System.out.print("\n* SUBMENU VEHICULOS *\n"
                    + "[1.AGREGAR VEHICULO]\n"
                    + "[2.EDITAR VEHICULO]\n"
                    + "[3.ELIMINAR VEHICULO]\n"
                    + "[4.MOSTRAR VEHICULO]\n"
                    + "[0.VOLVER]\n"
                    + "INGRESE UNA OPCION: ");

            opcion = sc.nextInt();
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
                default:
                    System.out.println("[INGRESO INVALIDO]");
                    break;
            }
        } while (!volver);
    }

    private static void menuViajes(Scanner sc, Ctrl_Viaje ctrl) {
        boolean volver = false;
        int opcion = 0;
        do {
            System.out.print("\n* SUBMENU VIAJES *\n"
                    + "[1.AGREGAR VIAJE]\n"
                    + "[2.EDITAR VIAJE]\n"
                    + "[3.ELIMINAR VIAJE]\n"
                    + "[4.MOSTRAR VIAJE]\n"
                    + "[0.VOLVER]\n"
                    + "INGRESE UNA OPCION: ");

            opcion = sc.nextInt();
            switch (opcion) {
                case 0:
                    volver = true;
                    break;
                case 1:
                    ctrl.planificarViaje();
                    break;
                case 2:
                    // ctrl.editarViaje();
                    break;
                case 3:
                    // ctrl.eliminarViaje();
                    break;
                case 4:
                    // ctrl.mostrarViaje();
                    break;
                default:
                    System.out.println("[INGRESO INVALIDO]");
                    break;
            }
        } while (!volver);
    }

    public static void main(String[] args) {
        Ctrl_Chofer ctrlChofer = new Ctrl_Chofer();
        Ctrl_Vehiculo ctrlVehiculo = new Ctrl_Vehiculo();
        Ctrl_Viaje ctrlViaje = new Ctrl_Viaje();

        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        boolean finalizar;

        System.out.println("**************************************************");
        System.out.println("*             BIENVENIDO A RUTAS S.A             *");
        System.out.println("**************************************************");
        do {
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

            finalizar = false;
            switch (opcion) {
                case 0:
                    finalizar = true;
                    System.out.print("[EL PROGRAMA HA FINALIZADO]");
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
                    ctrlViaje.mostrarViajes();
                    break;
                case 5:
                    ctrlViaje.mostrarViajesVehiculo();
                    break;
                case 6:
                    ctrlViaje.mostrarViajesChoferes();
                    break;
            }
        } while (!finalizar);
    }
}