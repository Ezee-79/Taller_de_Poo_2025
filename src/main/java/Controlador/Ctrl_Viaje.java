/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import Modelo.*;
import Excepciones.IngresoInvalidoExcepcion;


/**
 * Clase controladora encargada de gestionar las operaciones relacionadas con los viajes,
 * como planificar, editar, eliminar y mostrar viajes programados.
 * 
 * Gestiona además la asignación de choferes y vehículos disponibles para los viajes.
 * 
 * @author Gaston. 
 * @author Denis.
 * @author Enzo.
 */

import Modelo.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Excepciones.IngresoInvalidoExcepcion;


public class Ctrl_Viaje {
    private ArrayList<Viaje> listaViajes = new ArrayList<>();
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

        viaje = new Viaje("30/07/2025",
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
                ctrlV.getVehiculos().get(3),
                new Ciudad("Concordia", EnumProvincia.ENTRE_RIOS),
                new Ciudad("Ubajay", EnumProvincia.ENTRE_RIOS));
        viaje.setCodigo(1);
        ctrlC.getChoferes().get(0).getChofer().agregarViaje(viaje);
        ctrlV.getVehiculos().get(3).agregarViaje(viaje);
        listaViajes.add(viaje);

        viaje = new Viaje("20/07/2025",
                "10:00",
                "11:45",
                ctrlC.getChoferes().get(2).getChofer(),
                ctrlV.getVehiculos().get(2),
                new Ciudad("Concordia", EnumProvincia.ENTRE_RIOS),
                new Ciudad("Colon", EnumProvincia.ENTRE_RIOS));
        viaje.setCodigo(2);
        ctrlC.getChoferes().get(0).getChofer().agregarViaje(viaje);
        ctrlV.getVehiculos().get(2).agregarViaje(viaje);
        listaViajes.add(viaje);
    }

    public void setViaje() throws IngresoInvalidoExcepcion, InputMismatchException {
        scI = new Scanner(System.in);

    /**
     * Permite planificar un nuevo viaje solicitando datos al usuario desde la consola.
     * Verifica la validez de entradas y asigna un chofer y vehículo disponible.
     * 
     * @param ctrlCho Controlador de choferes.
     * @param ctrlV Controlador de vehículos.
     * @throws IngresoInvalidoExcepcion Si alguna entrada del usuario es inválida.
     * @throws InputMismatchException Si ocurre un error en el tipo de entrada.
     */
    public void planificarViaje(Ctrl_Chofer ctrlCho, Ctrl_Vehiculo ctrlV)
            throws IngresoInvalidoExcepcion, InputMismatchException {
        sc = new Scanner(System.in);

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
        if (!fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {

        System.out.print("Ingrese la fecha de salida del viaje (DD/MM/AAAA): ");
        String fechaSalida = sc.nextLine();
        fechaSalida = fechaSalida.trim();
        if (!fechaSalida.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO SE INGRESO EL FORMATO CORRECTO]");
        } else if (fechaSalida.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE INGRESAR LETRAS]");
        }

        System.out.print("Ingrese la fecha de llegada del viaje (DD/MM/AAAA): ");
        String fechaLlegada = sc.nextLine();
        fechaLlegada = fechaLlegada.trim();
        if (!fechaLlegada.matches("\\d{2}/\\d{2}/\\d{4}")) {

            throw new IngresoInvalidoExcepcion("[ERROR: NO SE INGRESO EL FORMATO CORRECTO]");
        } else if (fechaLlegada.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE INGRESAR LETRAS]");
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
        String salidaV = "";
        String llegadaV = "";

        if (opcionv == 1) {
            for (Vehiculo p : ctrlV.getVehiculos()) {
                if (p instanceof Minibus) {
                    boolean disponible = true;
                    for (Viaje y : p.getViajesProgramados()) {
                        salidaV = y.getHorarioSalida();
                        llegadaV = y.getHorarioLlegada();
                        LocalDate fechaP = LocalDate.parse(fecha, formatter);
                        LocalDate fechaV = LocalDate.parse(y.getFecha(), formatter);

                        if (!fechaP.equals(fechaV)) {
                            continue;
                        }

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
                        salidaV = y.getHorarioSalida();
                        llegadaV = y.getHorarioLlegada();

                        LocalDate fechaP = LocalDate.parse(fecha, formatter);
                        LocalDate fechaV = LocalDate.parse(y.getFecha(), formatter);

                        if (!fechaP.equals(fechaV)) {
                            continue;
                        }

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
            throw new IngresoInvalidoExcepcion("[ERROR: NO SE ENCONTRO VEHICULO DISPONIBLE]");
        }


        // agregar chofer a viaje
        Chofer c = null;
        for (ChoferCategoria x : ctrlC.getChoferes()) {
            if (x.getCategoria().getTipo() == enumCateg) {
                boolean disponible = true;
                for (Viaje y : x.getChofer().getViajesProgramados()) {
                    salidaV = y.getHorarioSalida();
                    llegadaV = y.getHorarioLlegada();

                    LocalDate fechaP = LocalDate.parse(fecha, formatter);
                    LocalDate fechaV = LocalDate.parse(y.getFecha(), formatter);

                    if (!fechaP.equals(fechaV)) {
                        continue;
                    }

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
            throw new IngresoInvalidoExcepcion("[ERROR: NO SE ENCONTRO CHOFER DISPONIBLE]");

        // Viaje completo
        Viaje viaje = new Viaje(fechaSalida, fechaLlegada, salida, llegada, c, v, origen, destino);
        listaViajes.add(viaje);
        sc.nextLine();

        System.out.println("**************************************************");
        System.out.println("VIAJE PROGRAMADO CON EXITO");
        System.out.println("**************************************************");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime horaLlegada = LocalDateTime.parse(fechaLlegada + " " + llegada, formatter);
        if (!horaLlegada.isAfter(LocalDateTime.now())) {
            viaje.setEstadoViaje(EstadoViaje.TERMINADO);
        } else {
            viaje.setEstadoViaje(EstadoViaje.EN_CURSO);

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
        /*
         * DateTimeFormatter formatter =
         * DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
         * LocalDateTime horaLlegada = LocalDateTime.parse(llegada, formatter);
         * if (!horaLlegada.isAfter(LocalDateTime.now())) {
         * viaje.setEstadoViaje(EstadoViaje.TERMINADO);
         * } else {
         * viaje.setEstadoViaje(EstadoViaje.EN_CURSO);
         * }
         */
    }

    /**
     * Muestra un listado de los viajes registrados con su índice.
     */
    public void mostrarViajesConIndice() {
        if (listaViajes.isEmpty()) {
            System.out.println("No hay viajes programados.");
        } else {
            System.out.println("==== VIAJES DISPONIBLES ====");
            for (int i = 0; i < listaViajes.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + listaViajes.get(i).getResumen());
            }
            System.out.println("============================");
        }
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


    // Metodo para editar un viaje
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

    /**
     * Permite editar las ciudades de origen y destino de un viaje.
     * 
     * @throws InputMismatchException Si el valor ingresado no es numérico.
     */
    public void editarViaje() throws InputMismatchException {
        Scanner sc = new Scanner(System.in);

        mostrarViajesConIndice();
        if (listaViajes.isEmpty())
            return;

        System.out.print("Ingrese el numero del viaje a editar: ");
        int opcion = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        if (opcion < 1 || opcion > listaViajes.size()) {
            System.out.println("[ERROR: Numero invalido]");
            return;
        }

        Viaje viaje = listaViajes.get(opcion - 1);

        // Mostrar ciudades disponibles
        ArrayList<Ciudad> ciudades = ctrlCiu.getCiudades();
        System.out.println("\nCiudades disponibles:");
        for (int i = 0; i < ciudades.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + ciudades.get(i).getNombre());
        }

        // Seleccionar nueva ciudad de origen
        System.out.print("Seleccione nueva ciudad de origen: ");
        int origenIndex = sc.nextInt() - 1;
        sc.nextLine();

        // Validar selección
        if (origenIndex < 0 || origenIndex >= ciudades.size()) {
            System.out.println("[ERROR: Ciudad origen no valida]");
            return;

        }

        if (!encontrado) {
            System.out.println("[EL VIAJE NO FUE ENCONTRADO]");
        }
    }

    /**
     * Muestra los detalles completos de un viaje.
     */
    public void mostrarViaje() {
        scI = new Scanner(System.in);

        System.out.println("INGRESAR CODIGO DE VIAJE: ");
        int codigo = scI.nextInt();

        boolean encontrado = false;
        for (Viaje v : listaViajes) {
            if (v.getCodigo() == codigo) {
                System.out.println(viaje.toString());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("[EL VIAJE NO FUE ENCONTRADO]");
        }
    }


    public void mostrarViajesProgramados() {

    /**
     * Muestra todos los viajes registrados con su información completa.
     */
    public void mostrarViajes() {

        if (listaViajes.isEmpty()) {
            System.out.println("[NO HAY VIAJES PROGRAMADOS]");
        } else {
            for (Viaje viaje : listaViajes) {
                System.out.println(viaje.toString() + "\n");
            }
        }
    }


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
        for (Viaje viaje : listaViajes) {
            if (viaje.getVehiculo().getPatente().equals(patente) && viaje.getVehiculo() instanceof Colectivo) {
                encontrado = true;
                if (viaje.getEstadoViaje() != EstadoViaje.TERMINADO) {
                    System.out.println(viaje.toString());

     /**
     * Muestra los viajes en curso asociados a un vehículo de tipo Colectivo según su patente.
     * Solo se muestran viajes en estado En_curso.
     */
    public void mostrarViajesVehiculo() {
        
        boolean encontrado = false;
        
        if (listaViajes.isEmpty()) {
            System.out.println("No hay viajes cargados.");
            return;
        }
        System.out.print("Ingresar patente del colectivo a revisar:");
        String patente = sc.nextLine();
        for (Viaje viaje : listaViajes) {
            if (viaje.getVehiculo().getPatente().equals(patente) && viaje.getVehiculo() instanceof Colectivo) {
                if (viaje.getEstadoViaje() == EstadoViaje.EN_CURSO) {
                    System.out.println(viaje);
                    encontrado = true;

                }
            }
        }

        if (!encontrado) {

            System.out.println("[EL VEHICULO NO TIENE VIAJES PENDIENTES]");
        }

            System.out.println("ERROR: NO HAY DATOS COINCIDENTES");
        }

    }

    /**
     * Cuenta y muestra la cantidad de viajes realizados por un chofer específico,
     * utilizando el DNI ingresado por el usuario.
     */
    public void mostrarViajesChoferes() {

        System.out.println("CANTIDAD DE VIAJES FINALIZADOS POR CADA CHOFER DE COLECTIVOS:");
        for (ChoferCategoria c : ctrlC.getChoferes()) {
            if (c.getCategoria().getTipo() == EnumCategoria.COLECTIVO
                    || c.getCategoria().getTipo() == EnumCategoria.AMBOS) {
                System.out.println("[EL CHOFER CON DNI " + c.getChofer().getDni()
                        + " HA FINALIZADO: " + c.getChofer().getViajesFinalizados().size() + " VIAJES]");


        if (listaViajes.isEmpty()) {
            System.out.println("No hay viajes cargados.");
            return;
        }

        System.out.print("Ingresar el dni del chofer a revisar:");
        long dni = sc.nextLong();
        sc.nextLine();
        int cantViajes = 0;
        for (Viaje viaje : listaViajes) {
            if ((viaje.getChofer().getDni()) == (dni) && viaje.getVehiculo() instanceof Colectivo
                    && viaje.getEstadoViaje() == EstadoViaje.TERMINADO) {
                cantViajes = cantViajes + 1;

            }
        }
        System.out.println ("Cantidad de viajes realizados por el chofer: " + cantViajes);
    }
}
