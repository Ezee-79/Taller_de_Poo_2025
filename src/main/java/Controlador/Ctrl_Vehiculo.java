package Controlador;

import java.util.ArrayList;
import java.util.Scanner;

import Modelo.Colectivo;
import Modelo.Minibus;
import Modelo.Vehiculo;

public class Ctrl_Vehiculo {
    private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    private Scanner sc = new Scanner(System.in);
    private Minibus minibus = new Minibus();
    private Colectivo colectivo = new Colectivo();

    public Ctrl_Vehiculo() {
    }

    public void setVehiculo(int tipo) {
        if (tipo == 1) {
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
            bodega = (sc.nextInt() == 0) ? true : false;
            minibus.setAireAcondicionado(aireAcondicionado);

            vehiculos.add(minibus);
            minibus = new Minibus();
        } else {
            boolean pisoDoble;

            System.out.print("Patente: ");
            colectivo.setPatente(sc.nextLine());

            System.out.print("Capacidad: ");
            colectivo.setCapacidad(sc.nextInt());

            System.out.print("Seleccione una opcion: [0.Falso][1.Verdadero]");
            System.out.print("Cuenta con piso doble: ");
            pisoDoble = (sc.nextInt() == 0) ? true : false;
            colectivo.setPisoDoble(pisoDoble);

            vehiculos.add(colectivo);
            colectivo = new Colectivo();
        }
    }

    public void agregarVehiculo() {
        System.out.println("Ingresa los datos solicitados para el nuevo vehiculo:\n");
        System.out.println("Seleccione el tipo: [1.MiniBus][2.Colectivo]");
        setVehiculo(sc.nextInt());
    }
}
