package Controlador;

import java.util.ArrayList;
import java.util.Scanner;

import Modelo.Colectivo;
import Modelo.Minibus;
import Modelo.Vehiculo;

/* Enzo */
public class Ctrl_Vehiculo {
    private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    private Scanner sc = new Scanner(System.in);
    private Minibus minibus = new Minibus();
    private Colectivo colectivo = new Colectivo();
    private Vehiculo vehiculo;

    // CONSTRUCTOR
    public Ctrl_Vehiculo() {
    }

    // INGRESO DE DATOS PARA MINIBUS.
    public void setMinibus() {
        boolean bodega = false;
        boolean aireAcondicionado = false;

        System.out.print("Patente: ");
        minibus.setPatente(sc.nextLine());

        System.out.print("Capacidad: ");
        minibus.setCapacidad(sc.nextInt());

        System.out.print("Seleccione una opcion: [0.Falso][1.Verdadero]");
        System.out.print("Cuenta con bodega: ");
        bodega = (sc.nextInt() == 0) ? true : false;
        minibus.setTieneBodega(bodega);

        System.out.print("Cuenta con aire acondicionado: ");
        aireAcondicionado = (sc.nextInt() == 0) ? true : false;
        minibus.setAireAcondicionado(aireAcondicionado);
    }

    // INGRESO DE DATOS PARA COLECTIVO.
    public void setColectivo() {
        boolean pisoDoble;

        System.out.print("Patente: ");
        colectivo.setPatente(sc.nextLine());

        System.out.print("Capacidad: ");
        colectivo.setCapacidad(sc.nextInt());

        System.out.print("Seleccione una opcion: [0.Falso][1.Verdadero]");
        System.out.print("Cuenta con piso doble: ");
        pisoDoble = (sc.nextInt() == 0) ? true : false;
        colectivo.setPisoDoble(pisoDoble);
    }

    // AGREGAMOS UN NUEVO VEHICULO A LA LISTA SEGUN LA OPCION INGRESADA.
    public void agregarVehiculo() {
        System.out.println("Ingresa los datos solicitados para el nuevo vehiculo:\n");
        System.out.println("Seleccione el tipo: [1.MiniBus][2.Colectivo]");
        if (sc.nextInt() == 1) {
            setMinibus();
            vehiculos.add(minibus);
            minibus = new Minibus();
        } else {
            setColectivo();
            vehiculos.add(colectivo);
            colectivo = new Colectivo();
        }
    }

    // BUSCAMOS UN VEHICULO SEGUN PATENTE, SI SE ENCUENTRA SE EDITAN SUS DATOS SEGUN
    // SU TIPO.
    public void editarVehiculo(String patente) {
        int posicion = 0;
        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getPatente().equals(patente)) {
                vehiculo = vehiculos.get(i);
            }
        }

        if (vehiculo != null) {
            System.out.println("Edita los datos del vehiculo seleccionado:\n");
            if (vehiculos.getClass().isInstance(Minibus.class)) {
                minibus = (Minibus) vehiculo;
                setMinibus();
                vehiculos.set(posicion, minibus);
                minibus = new Minibus();
            } else {
                colectivo = (Colectivo) vehiculo;
                setColectivo();
                vehiculos.set(posicion, colectivo);
                colectivo = new Colectivo();
            }
        } else {
            System.out.println("El vehiculo no fue encontrado.");
        }
    }

    // SE BUSCA UN VEHICULO EN LA LISTA, SI SE ENCUENTRA SE ELIMINA.
    public void eliminarVehiculo(String patente) {
        boolean modificado = false;

        for (Vehiculo v : vehiculos) {
            if (v.getPatente().equals(patente)) {
                vehiculos.remove(v);
                modificado = true;
                break;
            }
        }

        if (modificado == true) {
            System.out.println("El vehiculo fue eliminado de la lista.");
        } else {
            System.out.println("El vehiculo no fue encontrado.");
        }
    }

    // SE BUSCA UN VEHICULO EN LA LISTA, SI SE ENCUENTRA SE MUESTRAN SUS DATOS.
    public void mostrarChofer(String patente) {
        for (Vehiculo v : vehiculos) {
            if (v.getPatente().equals(patente)) {
                System.out.println("Vehiculo encontrado:");
                v.toString();
                break;
            }
        }
    }
}