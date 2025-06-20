package Controlador;

import java.util.ArrayList;
import java.util.Scanner;

import Modelo.Colectivo;
import Modelo.Minibus;
import Modelo.Vehiculo;

/* Enzo */
public class Ctrl_Vehiculo {
    private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    private Scanner scL = new Scanner(System.in);
    private Scanner scI = new Scanner(System.in);
    private Minibus minibus;
    private Colectivo colectivo;
    private Vehiculo vehiculo;

    // CONSTRUCTOR
    public Ctrl_Vehiculo() {
    }

    // INGRESO DE DATOS DE VEHICULOS SEGUN SU TIPO.
    public void setVehiculo(int tipo) {
        String patente;
        int capacidad;
        boolean bodega;
        boolean aireAcondicionado;
        boolean pisoDoble;

        switch (tipo) {
            case 1:
                if (minibus == null) {
                    minibus = new Minibus();
                } else {
                    System.out.println("[DATOS ACTUALES DEL VEHICULO]\n" + minibus.toString());
                }

                System.out.println("\nIngresar los siguientes datos:");
                System.out.print("\nPatente: ");
                patente = scL.nextLine();

                System.out.print("Capacidad (en Kg): ");
                capacidad = scI.nextInt();

                System.out.println("\nResponder con [0.Falso][1.Verdadero]\n");
                System.out.print("Cuenta con bodega: ");
                bodega = (scI.nextInt() == 1) ? true : false;

                System.out.print("Cuenta con aire acondicionado: ");
                aireAcondicionado = (scI.nextInt() == 1) ? true : false;

                minibus.setPatente(patente);
                minibus.setCapacidad(capacidad);
                minibus.setTieneBodega(bodega);
                minibus.setTieneAire(aireAcondicionado);
                break;
            case 2:
                if (colectivo == null) {
                    colectivo = new Colectivo();
                } else {
                    System.out.println("[DATOS ACTUALES DEL VEHICULO]\n" + colectivo.toString());
                }

                System.out.print("\nPatente: ");
                patente = scL.nextLine();

                System.out.print("Capacidad (en Kg): ");
                capacidad = scI.nextInt();

                System.out.println("\nResponder con [0.Falso][1.Verdadero]\n");
                System.out.print("Cuenta con piso doble: ");
                pisoDoble = (scI.nextInt() == 1) ? true : false;

                colectivo.setPatente(patente);
                colectivo.setCapacidad(capacidad);
                colectivo.setTienePisoDoble(pisoDoble);
                break;
        }
    }

    // AGREGAMOS UN NUEVO VEHICULO A LA LISTA SEGUN LA OPCION INGRESADA.
    public void agregarVehiculo() {
        System.out.println("***************************************************");
        System.out.println("[COMPLETA LOS DATOS PARA AGREGAR UN NUEVO VEHICULO]\n");
        System.out.print("Ingrese el tipo de vehiculo: [1.Minibus][2.Colectivo] -> ");

        switch (scI.nextInt()) {
            case 1:
                minibus = null;
                setVehiculo(1);
                vehiculos.add(minibus);
                break;
            case 2:
                colectivo = null;
                setVehiculo(2);
                vehiculos.add(colectivo);
                break;
            default:
                System.out.println("\n[INGRESO INVALIDO]");
                break;
        }

        System.out.println("\n[NUEVO VEHICULO AGREGADO A LA LISTA]");
        System.out.println("***************************************************\n");
    }

    // BUSCAMOS UN VEHICULO SEGUN PATENTE, SI SE ENCUENTRA SE EDITAN SUS DATOS SEGUN
    // SU TIPO.
    public void editarVehiculo() {
        System.out.println("***************************************************");
        System.out.print("INGRESAR PATENTE DEL VEHICULO A EDITAR: ");
        String patente = scL.nextLine();

        boolean encontrado = false;
        for (Vehiculo v : vehiculos) {
            if (v.getPatente().equals(patente)) {
                vehiculo = v;
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            System.out.println("***************************************************");
            System.out.println("[INGRESAR NUEVOS DATOS PARA EL VEHICULO]");
            System.out.println("[NOTA: COPIA Y PEGA LOS DATOS QUE NO QUIERES EDITAR]\n");

            if (vehiculo instanceof Minibus) {
                minibus = (Minibus) vehiculo;
                setVehiculo(1);
                vehiculos.set(vehiculos.indexOf(minibus), minibus);
            } else {
                colectivo = (Colectivo) vehiculo;
                setVehiculo(2);
                vehiculos.set(vehiculos.indexOf(colectivo), colectivo);
            }

            System.out.println("\n[EL VEHICULO HA SIDO MODIFICADO]");
        } else {
            System.out.println("\n[EL VEHICULO NO FUE ENCONTRADO]");
        }

        System.out.println("***************************************************\n");
    }

    // SE BUSCA UN VEHICULO EN LA LISTA, SI SE ENCUENTRA SE ELIMINA.
    public void eliminarVehiculo() {
        System.out.println("***************************************************");
        System.out.print("INGRESAR PATENTE DEL VEHICULO A ELIMINAR: ");
        String patente = scL.nextLine();

        boolean encontrado = false;
        for (Vehiculo v : vehiculos) {
            if (v.getPatente().equals(patente)) {
                vehiculos.remove(v);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            System.out.println("\n[EL VEHICULO HA SIDO ELIMINADO]");
        } else {
            System.out.println("\n[EL VEHICULO NO FUE ENCONTRADO]");
        }
        System.out.println("***************************************************\n");
    }

    // SE BUSCA UN VEHICULO EN LA LISTA, SI SE ENCUENTRA SE MUESTRAN SUS DATOS.
    public void mostrarVehiculo() {
        System.out.println("***************************************************");
        System.out.print("INGRESAR PATENTE DEL VEHICULO A MOSTRAR: ");
        String patente = scL.nextLine();

        boolean encontrado = false;
        for (Vehiculo v : vehiculos) {
            if (v.getPatente().equals(patente)) {
                System.out.println("\n[VEHICULO ENCONTRADO]\n");
                encontrado = true;

                if (v instanceof Minibus) {
                    minibus = (Minibus) v;
                    System.out.println(minibus.toString());
                } else {
                    colectivo = (Colectivo) v;
                    System.out.println(colectivo.toString());
                }

                break;
            }
        }

        if (!encontrado) {
            System.out.println("\n[EL VEHICULO NO FUE ENCONTRADO]");
        }

        System.out.println("***************************************************\n");
    }
}
