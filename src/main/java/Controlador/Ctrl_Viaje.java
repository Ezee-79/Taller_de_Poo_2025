/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Excepciones.IngresoInvalidoExcepcion;
import Modelo.*;

/**
 * Clase controladora encargada de gestionar las operaciones relacionadas con
 * los viajes,
 * como planificar, editar, eliminar y mostrar viajes programados.
 * 
 * Gestiona además la asignación de choferes y vehículos disponibles para los
 * viajes.
 * 
 * @author Gaston.
 * @author Denis.
 * @author Enzo.
 */

public class Ctrl_Viaje {
    private ArrayList<Viaje> listaViajes = new ArrayList<Viaje>();
    private Ctrl_Vehiculo ctrlV;
    private Ctrl_Chofer ctrlC;
    private Viaje viaje;
    private Scanner scI;
    private Scanner scL;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Constructor por defecto de la clase Ctrl_Viaje.
     */
    public Ctrl_Viaje() {
    }

    public Ctrl_Viaje(Ctrl_Vehiculo ctrlV, Ctrl_Chofer ctrlC) {
        this.ctrlC = ctrlC;
        this.ctrlV = ctrlV;
        /* VIAJES PRECARGADOS PARA REALIZAR PRUEBAS.
        viaje = new Viaje("20/07/2025",
                "10:00",
                "15:00",
                ctrlC.getChoferes().get(0).getChofer(),
                ctrlV.getVehiculos().get(0),
                new Ciudad("Concordia", EnumProvincia.ENTRE_RIOS),
                new Ciudad("Colon", EnumProvincia.ENTRE_RIOS));
        viaje.setCodigo(0);
        ctrlC.getChoferes().get(0).getChofer().agregarViaje(viaje);
        ctrlV.getVehiculos().get(0).agregarViaje(viaje);
        listaViajes.add(viaje);

        viaje = new Viaje("20/07/2025",
                "15:00",
                "18:30",
                ctrlC.getChoferes().get(1).getChofer(),
                ctrlV.getVehiculos().get(1),
                new Ciudad("Concordia", EnumProvincia.ENTRE_RIOS),
                new Ciudad("Ubajay", EnumProvincia.ENTRE_RIOS));
        viaje.setCodigo(1);
        ctrlC.getChoferes().get(1).getChofer().agregarViaje(viaje);
        ctrlV.getVehiculos().get(1).agregarViaje(viaje);
        listaViajes.add(viaje);

        viaje = new Viaje("20/07/2025",
                "18:00",
                "19:45",
                ctrlC.getChoferes().get(2).getChofer(),
                ctrlV.getVehiculos().get(1),
                new Ciudad("Concordia", EnumProvincia.ENTRE_RIOS),
                new Ciudad("Colon", EnumProvincia.ENTRE_RIOS));
        viaje.setCodigo(2);
        ctrlC.getChoferes().get(2).getChofer().agregarViaje(viaje);
        ctrlV.getVehiculos().get(1).agregarViaje(viaje);
        listaViajes.add(viaje);
        */
    }

    /**
     * Permite planificar un nuevo viaje solicitando datos al usuario desde la
     * consola.
     * Verifica la validez de entradas y asigna un chofer y vehículo disponible.
     * 
     * @param ctrlCho Controlador de choferes.
     * @param ctrlV   Controlador de vehículos.
     * @throws IngresoInvalidoExcepcion Si alguna entrada del usuario es inválida.
     * @throws InputMismatchException   Si ocurre un error en el tipo de entrada.
     */
    public void setViaje() throws IngresoInvalidoExcepcion, InputMismatchException, DateTimeParseException {
        scI = new Scanner(System.in);
        scL = new Scanner(System.in);

        if (viaje == null) {
            viaje = new Viaje();
        } else {
            System.out.println(viaje.toString());
        }

        System.out.println("[PROVINCIAS DISPONIBLES]");
        int indice = 1;
        for (EnumProvincia p : EnumProvincia.values()) {
            System.out.println("[" + indice + ". " + p.name() + "]");
            indice++;
        }

        System.out.print("INGRESAR PROVINCIA DE SALIDA: ");
        int origenNum = scI.nextInt();
        if (origenNum < 0 || origenNum > 23) {
            throw new IngresoInvalidoExcepcion("[ERROR: SOLO PUEDE INGRESAR LAS OPCIONES SUGERIDAS]");
        }

        System.out.print("INGRESAR PROVINCIA DE DESTINO: ");
        int destinoNum = scI.nextInt();
        if (destinoNum < 0 || destinoNum > 23) {
            throw new IngresoInvalidoExcepcion("[ERROR: SOLO PUEDE INGRESAR LAS OPCIONES SUGERIDAS]");
        }

        EnumProvincia origenP = null;
        EnumProvincia destinoP = null;
        indice = 1;
        for (EnumProvincia p : EnumProvincia.values()) {
            if (indice == origenNum) {
                origenP = p;
            }
            if (indice == destinoNum) {
                destinoP = p;
            }
            indice++;
        }

        System.out.print("INGRESAR CIUDAD DE SALIDA: ");
        String origenC = scL.nextLine();
        origenC = origenC.trim();
        if (!origenC.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE INGRESAR NUMEROS]");
        } else if (origenC.isEmpty()) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE DEJAR EL CAMPO VACIO]");
        }

        System.out.print("INGRESAR CIUDAD DE DESTINO: ");
        String destinoC = scL.nextLine();
        if (!destinoC.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE INGRESAR NUMEROS]");
        } else if (destinoC.isEmpty()) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE DEJAR EL CAMPO VACIO]");
        }

        Ciudad origen = new Ciudad(origenC, origenP);
        Ciudad destino = new Ciudad(destinoC, destinoP);

        // fecha viaje

        System.out.print("INGRESAR FECHA DE SALIDA (DD/MM/AAAA): ");
        String fecha = scL.nextLine();
        fecha = fecha.trim();

        LocalDate fechaP = LocalDate.parse(fecha, formatter);
        if (!fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO SE INGRESO EL FORMATO CORRECTO]");
        } else if (fecha.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE INGRESAR LETRAS]");
        } else if (fechaP.isBefore(LocalDate.now())) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE PONER UNA FECHA ANTERIOR A LA ACTUAL]");
        }

        // horarios del viaje
        System.out.print("INGRESAR HORARIO DE SALIDA (HH:MM): ");
        String salida = scL.nextLine();
        salida = salida.trim();
        if (!salida.matches("\\d{2}:\\d{2}")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO SE INGRESO EL FORMATO CORRECTO]");
        } else if (salida.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE INGRESAR LETRAS]");
        }

        System.out.print("INGRESAR HORARIO DE LLEGADA (HH:MM): ");
        String llegada = scL.nextLine();
        if (!llegada.matches("\\d{2}:\\d{2}")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO SE INGRESO EL FORMATO CORRECTO]");
        } else if (llegada.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE INGRESAR LETRAS]");
        }

        System.out.print("INGRESAR TIPO DE VEHICULO [1.MINIBUS][2.COLECTIVO]: ");
        int opcionv = scI.nextInt();
        if (opcionv != 1 && opcionv != 2) {
            throw new IngresoInvalidoExcepcion("[ERROR: SOLO PUEDE INGRESAR LAS OPCIONES SUGERIDAS]");
        }
        EnumCategoria enumCateg = (opcionv == 1) ? EnumCategoria.MINIBUS : EnumCategoria.COLECTIVO;

        Vehiculo v = null;
        if (opcionv == 1) {
            for (Vehiculo p : ctrlV.getVehiculos()) {
                if (p instanceof Minibus) {
                    boolean disponible = true;

                    for (Viaje y : p.getViajesProgramados()) {
                        String salidaV = y.getHorarioSalida();
                        String llegadaV = y.getHorarioLlegada();

                        if (LocalTime.parse(salidaV).isBefore(LocalTime.parse(llegada))
                                && LocalTime.parse(salida).isBefore(LocalTime.parse(llegadaV))) {
                            disponible = false;
                            break;
                        }
                    }

                    if (disponible) {
                        v = p;
                        break;
                    }
                } else {
                    continue;
                }
            }
        } else {
            for (Vehiculo p : ctrlV.getVehiculos()) {
                if (p instanceof Colectivo) {
                    boolean disponible = true;

                    for (Viaje y : p.getViajesProgramados()) {
                        String salidaV = y.getHorarioSalida();
                        String llegadaV = y.getHorarioLlegada();

                        if (LocalTime.parse(salidaV).isBefore(LocalTime.parse(llegada))
                                && LocalTime.parse(salida).isBefore(LocalTime.parse(llegadaV))) {
                            disponible = false;
                            break;
                        }
                    }

                    if (disponible) {
                        v = p;
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        if (v == null) {
            throw new IngresoInvalidoExcepcion("[NO SE ENCONTRO VEHICULO DISPONIBLE]");
        }

        // agregar chofer a viaje
        Chofer c = null;
        for (ChoferCategoria x : ctrlC.getChoferes()) {
            if (x.getCategoria().getTipo() == enumCateg
                    || x.getCategoria().getTipo() == EnumCategoria.AMBOS) {
                boolean disponible = true;

                for (Viaje y : x.getChofer().getViajesProgramados()) {

                    fechaP = LocalDate.parse(fecha, formatter);
                    LocalDate fechaV = LocalDate.parse(y.getFecha(), formatter);
                    if (!fechaP.equals(fechaV)) {
                        continue;
                    }

                    String salidaV = y.getHorarioSalida();
                    String llegadaV = y.getHorarioLlegada();

                    System.out.println(salidaV);
                    System.out.println(llegadaV);
                    if (LocalTime.parse(salidaV).isBefore(LocalTime.parse(llegada))
                            && LocalTime.parse(salida).isBefore(LocalTime.parse(llegadaV))) {
                        disponible = false;
                        break;
                    }
                }

                if (disponible) {
                    c = x.getChofer();
                    break;
                }
            } else {
                continue;
            }
        }
        if (c == null) {
            throw new IngresoInvalidoExcepcion("[NO SE ENCONTRO CHOFER DISPONIBLE]");
        }

        // Viaje completo
        viaje.setChofer(c);
        viaje.setVehiculo(v);
        viaje.setCiudadDestino(destino);
        viaje.setCiudadOrigen(origen);
        viaje.setFecha(fecha);
        viaje.setHorarioSalida(salida);
        viaje.setHorarioLlegada(llegada);

        int codigo = (viaje.getCodigo() == -1) ? listaViajes.size() : viaje.getCodigo();
        viaje.setCodigo(codigo);

        c.agregarViaje(viaje);
        v.agregarViaje(viaje);
    }

    public void planificarViaje()
            throws IngresoInvalidoExcepcion, InputMismatchException {
        System.out.println("***************************************************");
        System.out.println("[COMPLETA LOS DATOS PARA AGREGAR UN NUEVO VIAJE]");
        viaje = null;
        setViaje();
        listaViajes.add(viaje);
        System.out.println("\n[NUEVO VIAJE AGREGADO A LA LISTA]");
        System.out.println("***************************************************\n");
    }

    // Metodo para eliminar un viaje
    /**
     * Elimina un viaje de la lista según el índice seleccionado por el usuario.
     * 
     * @throws InputMismatchException Si el valor ingresado no es numérico.
     */
    // Metodo para eliminar un viaje
    public void eliminarViaje() throws InputMismatchException {
        scI = new Scanner(System.in);

        System.out.println("INGRESAR CODIGO DE VIAJE: ");
        int codigo = scI.nextInt();

        boolean encontrado = false;
        for (Viaje v : listaViajes) {
            if (v.getCodigo() == codigo) {
                listaViajes.remove(v);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            System.out.println("[EL VIAJE FUE ELIMINADO]");
        } else {
            System.out.println("[EL VIAJE NO FUE ENCONTRADO]");
        }
    }

    /**
     * Permite editar las ciudades de origen y destino de un viaje.
     * 
     * @throws InputMismatchException Si el valor ingresado no es numérico.
     */
    public void editarViaje() throws InputMismatchException, IngresoInvalidoExcepcion {
        scI = new Scanner(System.in);

        System.out.println("INGRESAR CODIGO DE VIAJE: ");
        int codigo = scI.nextInt();

        boolean encontrado = false;
        for (Viaje v : listaViajes) {
            if (v.getCodigo() == codigo) {
                viaje = v;
                setViaje();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("[EL VIAJE NO FUE ENCONTRADO]");
        }
    }

    public void mostrarViaje() {
        scI = new Scanner(System.in);

        System.out.println("INGRESAR CODIGO DE VIAJE: ");
        int codigo = scI.nextInt();

        boolean encontrado = false;
        for (Viaje v : listaViajes) {
            if (v.getCodigo() == codigo) {
                System.out.println(v.toString());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("[EL VIAJE NO FUE ENCONTRADO]");
        }
    }

    /**
     * Muestra todos los viajes registrados con su información completa.
     */
    public void mostrarViajesProgramados() {
        if (listaViajes.isEmpty()) {
            System.out.println("[NO HAY VIAJES PROGRAMADOS]");
        } else {
            for (Viaje viaje : listaViajes) {
                System.out.println(viaje.toString() + "\n");
            }
        }
    }

    /**
     * Muestra los viajes programados asociados a un vehículo de tipo Colectivo
     * según su patente.
     */
    public void mostrarViajesVehiculo() throws IngresoInvalidoExcepcion {
        scL = new Scanner(System.in);
        System.out.print("INGRESAR PATENTE DEL VEHICULO A REVISAR: ");
        String patente = scL.nextLine();
        if (patente.isEmpty()) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE DEJAR EL CAMPO VACIO]");
        } else if (patente.contains(" ")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE INGRESAR ESPACIOS]");
        }

        boolean encontrado = false;
        for (Vehiculo c : ctrlV.getVehiculos()) {
            if (c.getPatente().equals(patente) && c instanceof Colectivo) {
                encontrado = true;

                if (c.getViajesProgramados().isEmpty()) {
                    System.out.println("[EL VEHICULO NO TIENE VIAJES PROGRAMADOS]");
                    break;
                }

                for (Viaje v : c.getViajesProgramados()) {
                    System.out.println(v.toString());
                }
                break;
            }
        }

        if (!encontrado) {
            System.out.println("[EL VEHICULO NO FUE ENCONTRADO]");
        }
    }

    /**
     * Cuenta y muestra la cantidad de viajes realizados por un chofer específico,
     * utilizando el DNI ingresado por el usuario.
     */
    public void mostrarViajesChoferes() {
        System.out.println("CANTIDAD DE VIAJES FINALIZADOS POR CADA CHOFER DE COLECTIVOS:");
        for (ChoferCategoria c : ctrlC.getChoferes()) {
            int cantViajes = 0;
            if (c.getCategoria().getTipo() == EnumCategoria.COLECTIVO
                    || c.getCategoria().getTipo() == EnumCategoria.AMBOS) {
                for (Viaje v : c.getChofer().getViajesFinalizados()) {
                    if (v.getVehiculo() instanceof Colectivo) {
                        cantViajes++;
                    }
                }
                System.out.println("[EL CHOFER CON DNI " + c.getChofer().getDni()
                        + " HA FINALIZADO: " + cantViajes + " VIAJES]");
            }
        }
    }
}
