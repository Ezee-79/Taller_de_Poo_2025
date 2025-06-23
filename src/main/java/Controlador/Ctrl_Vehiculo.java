package Controlador;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Excepciones.IngresoInvalidoExcepcion;
import Modelo.Colectivo;
import Modelo.Minibus;
import Modelo.Vehiculo;

/**
 * Clase controladora encargada de gestionar vehiculos.
 * Permite agregar, editar, eliminar y mostrar los vehiculos, diferenciados
 * entre minibuses y colectivos.
 * 
 * @author Gaston.
 * @author Denis.
 * @author Enzo.
 */
public class Ctrl_Vehiculo {
    private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    private Scanner scL;
    private Scanner scI;
    private Minibus minibus;
    private Colectivo colectivo;
    private Vehiculo vehiculo;

    /**
     * Constructor por defecto, con algunos vehiculos predefinidos.
     */
    public Ctrl_Vehiculo() {
        vehiculos.add(new Minibus("A1", 10, true, true));
        vehiculos.add(new Colectivo("B2", 50, true));
        vehiculos.add(new Minibus("C3", 20, false, false));
        vehiculos.add(new Colectivo("D4", 30, false));
    }

    /**
     * Se ingresan los datos del vehiculo.
     * Según el tipo se crea un {@link Minibus} (1) o un {@link Colectivo} (2).
     * 
     * @param tipo parametro para distinguir si un vehiculo es un minibus (1) o un
     *             colectivo (2).
     * @throws IngresoInvalidoExcepcion si los datos ingresados no son válidos.
     * @throws InputMismatchException   si el tipo de entrada es incorrecto.
     */
    public void setVehiculo(int tipo) throws IngresoInvalidoExcepcion, InputMismatchException {
        scI = new Scanner(System.in);
        scL = new Scanner(System.in);

        if (tipo == 1 && minibus == null) {
            minibus = new Minibus();
        } else if (tipo == 1 && minibus != null) {
            System.out.println("[DATOS ACTUALES DEL VEHICULO]\n" + minibus.toString());
        } else if (tipo == 2 && colectivo == null) {
            colectivo = new Colectivo();
        } else if (tipo == 2 && colectivo != null) {
            System.out.println("[DATOS ACTUALES DEL VEHICULO]\n" + colectivo.toString());
        }

        System.out.println("\nINGRESAR LOS SIGUIENTES DATOS:");
        System.out.print("PATENTE: ");
        String patente = scL.nextLine();
        patente = patente.toUpperCase().trim();
        if (patente.isEmpty()) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE DEJAR EL CAMPO VACIO]");
        } else if (patente.contains(" ")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE INGRESAR ESPACIOS]");
        }

        for (Vehiculo v : vehiculos) {
            if (v.getPatente().equals(patente)) {
                throw new IngresoInvalidoExcepcion("[ERROR: YA EXISTE UN VEHICULO CON LA PATENTE INGRESADA]");
            }
        }

        System.out.print("CAPACIDAD DE PERSONAS: ");
        int capacidad = scI.nextInt();
        if (capacidad < 0 && capacidad > 50) {
            throw new IngresoInvalidoExcepcion("[ERROR: FUERA DEL RANGO DE 0 A 50]");
        }

        switch (tipo) {
            case 1:
                System.out.println("\nRESPONDER CON [0.FALSO][1.VERDADERO]");
                System.out.print("CUENTA CON BODEGA: ");
                int VoF = scI.nextInt();
                if (VoF != 0 && VoF != 1) {
                    throw new IngresoInvalidoExcepcion("[ERROR: SOLO PUEDE INGRESAR LAS OPCIONES SUGERIDAS]");
                }
                boolean bodega = (VoF == 1) ? true : false;

                System.out.print("CUENTA CON AIRE ACONDICIONADO: ");
                VoF = scI.nextInt();
                if (VoF != 0 && VoF != 1) {
                    throw new IngresoInvalidoExcepcion("[ERROR: SOLO PUEDE INGRESAR LAS OPCIONES SUGERIDAS]");
                }
                boolean aireAcondicionado = (VoF == 1) ? true : false;

                minibus.setPatente(patente);
                minibus.setCapacidad(capacidad);
                minibus.setTieneBodega(bodega);
                minibus.setTieneAire(aireAcondicionado);
                break;
            case 2:
                System.out.println("\nRESPONDER CON [0.FALSO][1.VERDADERO]\n");
                System.out.print("CUENTA CON DOBLE PISO: ");
                VoF = scI.nextInt();
                if (VoF != 0 && VoF != 1) {
                    throw new IngresoInvalidoExcepcion("[ERROR: SOLO PUEDE INGRESAR LAS OPCIONES SUGERIDAS]");
                }
                boolean pisoDoble = (VoF == 1) ? true : false;

                colectivo.setPatente(patente);
                colectivo.setCapacidad(capacidad);
                colectivo.setTienePisoDoble(pisoDoble);
                break;
        }
    }

    /**
     * Se ingresan los datos del vehiculo.
     * 
     * @throws IngresoInvalidoExcepcion
     * @throws InputMismatchException
     */
    public void agregarVehiculo() throws IngresoInvalidoExcepcion, InputMismatchException {
        System.out.println("***************************************************");
        System.out.println("[COMPLETA LOS DATOS PARA AGREGAR UN NUEVO VEHICULO]\n");
        System.out.print("INGRESAR TIPO DE VEHICULO CON [1.MINIBUS][2.COLECTIVO]: ");
        scI = new Scanner(System.in);
        int tipo = scI.nextInt();
        if (tipo != 1 && tipo != 2) {
            throw new IngresoInvalidoExcepcion("[ERROR: SOLO PUEDE INGRESAR LAS OPCIONES SUGERIDAS]");
        }

        switch (tipo) {
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
        }

        System.out.println("\n[NUEVO VEHICULO AGREGADO A LA LISTA]");
        System.out.println("***************************************************\n");
    }

    /**
     * Se ingresa una patente por scanner para identificar al vehiculo cuyos datos
     * se quieran editar.
     * 
     * @throws IngresoInvalidoExcepcion si el ingreso de la patente esta vacio o
     *                                  tiene espacios.
     */
    public void editarVehiculo() throws IngresoInvalidoExcepcion {
        scL = new Scanner(System.in);

        System.out.println("***************************************************");
        System.out.print("INGRESAR PATENTE DEL VEHICULO A EDITAR: ");
        String patente = scL.nextLine();
        patente = patente.toUpperCase().trim();
        if (patente.isEmpty()) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE DEJAR EL CAMPO VACIO]");
        } else if (patente.contains(" ")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE INGRESAR ESPACIOS]");
        }

        boolean encontrado = false;
        int indice = 0;
        for (Vehiculo v : vehiculos) {
            if (v.getPatente().equals(patente)) {
                vehiculo = v;
                indice = vehiculos.indexOf(v);
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
                vehiculos.set(indice, minibus);
            } else {
                colectivo = (Colectivo) vehiculo;
                setVehiculo(2);
                vehiculos.set(indice, colectivo);
            }

            System.out.println("\n[EL VEHICULO HA SIDO MODIFICADO]");
        } else {
            System.out.println("\n[EL VEHICULO NO FUE ENCONTRADO]");
        }

        System.out.println("***************************************************\n");
    }

    /**
     * Se ingresa una patente por scanner para identificar al vehiculo que se quiera
     * eliminar de la lista.
     * 
     * @throws IngresoInvalidoExcepcion si el ingreso de la patente esta vacio o
     *                                  tiene espacios.
     */
    public void eliminarVehiculo() throws IngresoInvalidoExcepcion {
        scL = new Scanner(System.in);

        System.out.println("***************************************************");
        System.out.print("INGRESAR PATENTE DEL VEHICULO A ELIMINAR: ");
        String patente = scL.nextLine();
        patente = patente.toUpperCase().trim();
        if (patente.isEmpty()) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE DEJAR EL CAMPO VACIO]");
        } else if (patente.contains(" ")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE INGRESAR ESPACIOS]");
        }

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

    /**
     * Metodo para mostrar los datos de un vehiculo ingresando su patente
     * correspondiente.
     * 
     * @throws IngresoInvalidoExcepcion si el ingreso de la patente esta vacio o
     *                                  tiene espacios.
     */
    public void mostrarVehiculo() throws IngresoInvalidoExcepcion {
        scL = new Scanner(System.in);

        System.out.println("***************************************************");
        System.out.print("INGRESAR PATENTE DEL VEHICULO A MOSTRAR: ");
        String patente = scL.nextLine();
        patente = patente.toUpperCase().trim();
        if (patente.isEmpty()) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE DEJAR EL CAMPO VACIO]");
        } else if (patente.contains(" ")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE INGRESAR ESPACIOS]");
        }

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

    // GETTERS.

    /**
     * Retorna la lista de vehiculos actual.
     * 
     * @return la lista de vehiculos.
     */

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Define una nueva lista de vehiculos.
     * 
     * @param vehiculos nueva lista de vehiculos a definir.
     */
    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     * Retorna los datos del {@link Vehiculo} referenciado.
     * 
     * @return un objeto {@link vehiculo}.
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Define los datos de un vehiculo.
     *
     * @param vehiculo un objeto de {@link Vehiculo} a asignar como actual.
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
