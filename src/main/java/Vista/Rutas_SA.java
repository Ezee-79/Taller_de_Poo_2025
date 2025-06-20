/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Vista;

import java.util.*;
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

    private static void menuCiudades(Scanner sc, Ctrl_Ciudad ctrl) {
        System.out.print("\n* SUBMENU CIUDADES *\n"
                + "[1.AGREGAR CIUDAD]\n"
                + "[2.EDITAR CIUDAD]\n"
                + "[3.ELIMINAR CIUDAD]\n"
                + "[4.MOSTRAR CIUDAD]\n"
                + "[0.VOLVER]\n"
                + "INGRESE UNA OPCION: ");
    }

    private static void menuViajes(Scanner sc, Ctrl_Viaje ctrl) {
        System.out.print("\n* SUBMENU VIAJES *\n"
                + "[1.AGREGAR VIAJE]\n"
                + "[2.EDITAR VIAJE]\n"
                + "[3.ELIMINAR VIAJE]\n"
                + "[4.MOSTRAR VIAJE]\n"
                + "[0.VOLVER]\n"
                + "INGRESE UNA OPCION: ");
    }

    public static void main(String[] args) {
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
                    + "[3.GESTIONAR CIUDADES]\n"
                    + "[4.GESTIONAR VIAJES]\n"
                    + "[5.MOSTRAR VIAJES PROGRAMADOS]\n"
                    + "[6.MOSTRAR VIAJES DE UN VEHICULO]\n"
                    + "[7.MOSTRAR VIAJES DE CADA CHOFER]\n"
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
                    menuChoferes(sc, new Ctrl_Chofer());
                    break;
                case 2:
                    menuVehiculos(sc, new Ctrl_Vehiculo());
                    break;
                case 3:
                    menuCiudades(sc, new Ctrl_Ciudad());
                    break;
                case 4:
                    menuViajes(sc, new Ctrl_Viaje());
                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                default:
                    System.out.println("[INGRESO INVALIDO]");
                    break;
            }

        } while (!finalizar);
    }
}