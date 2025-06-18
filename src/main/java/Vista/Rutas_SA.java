/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Vista;

/**
 *
 * @author Gaston PC
 */
//import java.util.*;

import Controlador.Ctrl_Chofer;
import Controlador.Ctrl_Vehiculo;

public class Rutas_SA {
    public static void main(String[] args) {

        // PRUEBA PARA COMPROBAR EL FUNCIONAMIENTO DE LOS CONTROLADORES.

        // CREAMOS UN CONTROLADOR PARA CHOFERES.
        Ctrl_Chofer ctrlC = new Ctrl_Chofer();

        // CREAMOS UN CHOFER Y LO AGREGAMOS A LA LISTA.
        ctrlC.agregarChofer();

        // BUSCAMOS EL CHOFER POR DNI Y LO MOSTRAMOS.
        ctrlC.mostrarChofer(123);

        // BUSCAMOS EL CHOFER POR DNI Y LO EDITAMOS.
        ctrlC.editarChofer(123);

        // BUSCAMOS EL CHOFER EDITADO Y LO MOSTRAMOS.
        ctrlC.mostrarChofer(321);

        // BUSCAMOS EL CHOFER POR DNI Y LO ELIMINAMOS.
        ctrlC.eliminarChofer(321);

        // LO MISMO QUE ARRIBA PERO CON VEHICULOS.
        Ctrl_Vehiculo ctrlV = new Ctrl_Vehiculo();

        ctrlV.agregarVehiculo();

        ctrlV.mostrarVehiculo("123");

        ctrlV.editarVehiculo("123");

        ctrlV.mostrarVehiculo("321");

        ctrlV.eliminarVehiculo("321");

        /*
         * Scanner sc = new Scanner(System.in);
         * //SistemaGestion sistema = new SistemaGestion();
         * int opcion;
         * 
         * do {
         * System.out.println("Menu Principal - RUTAS S.A");
         * System.out.println("\n");
         * System.out.println("1. Registrar chofer");
         * System.out.println("2. Registrar vehículo");
         * System.out.println("3. Planificar viaje entre ciudades");
         * System.out.println("4. Asociar vehículo y chofer a un viaje");
         * System.out.println("5. Mostrar todos los viajes programados");
         * System.out.println("6. Informe de viajes de un colectivo");
         * System.out.
         * println("7. Informe de viajes realizados por choferes de colectivos");
         * System.out.println("0. Salir");
         * System.out.print("Seleccione una opción: ");
         * opcion = sc.nextInt();
         * 
         * sc.nextLine();
         * 
         * switch(opcion){
         * case 1:
         * System.out.println("Ingrese los datos del chofer");
         * //sistema.registrarChofer(sc);
         * break;
         * case 2:
         * System.out.println("Ingrese los datos del vehiculo");
         * //sistema.registrarVehiculo(sc);
         * break;
         * case 3:
         * System.out.println("Ingresar los datos del viaje");
         * //sistema.planificarViaje(sc);
         * break;
         * case 4:
         * System.out.println("Ingrese el chofer y el vehiculo");
         * //sistema.asociarChoferYVehiculo(sc);
         * break;
         * case 5:
         * System.out.println("Informacion sobre los viajes:");
         * //sistema.mostrarViajesProgramados();
         * break;
         * case 6:
         * System.out.println("Ingrese");
         * //sistema.informeViajesPorColectivo(sc);
         * break;
         * case 7:
         * System.out.println("");
         * //sistema.informeViajesPorChoferesColectivos();
         * break;
         * case 0:
         * System.out.println("Saliendo del sistema.");
         * break;
         * default:
         * System.out.println("¡Error opcion inválida. Intente de nuevo!.");
         * }
         * 
         * }while (opcion !=0);
         * sc.close();
         */
    }
}
