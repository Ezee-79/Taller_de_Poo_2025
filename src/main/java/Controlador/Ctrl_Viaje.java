/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 *
 * @author Gaston PC
 */
import Modelo.*;

import Excepciones.IngresoInvalidoExcepcion;

public class Ctrl_Viaje {
    private ArrayList<Viaje> listaViajes = new ArrayList<>();
    Scanner sc;
    Scanner scL;
    Viaje viaje;

    public Ctrl_Viaje() {
    }

    public void planificarViaje(Ctrl_Chofer ctrlCho, Ctrl_Vehiculo ctrlV)
            throws IngresoInvalidoExcepcion, InputMismatchException {
        sc = new Scanner(System.in);
        scL = new Scanner(System.in);

        System.out.println("[PROVINCIAS DISPONIBLES]");
        int indice = 1;
        for (EnumProvincia p : EnumProvincia.values()) {
            System.out.println("[" + indice + ". " + p.name() + "]");
            indice++;
        }

        System.out.println("INGRESAR PROVINCIA DE PARTIDA: ");
        int origenNum = sc.nextInt();
        if (origenNum < 0 || origenNum > 23) {
            throw new IngresoInvalidoExcepcion("[ERROR: SOLO PUEDE INGRESAR LAS OPCIONES SUGERIDAS]");
        }

        System.out.println("INGRESAR PROVINCIA DE DESTINO: ");
        int destinoNum = sc.nextInt();
        if (destinoNum < 0 || destinoNum > 23) {
            throw new IngresoInvalidoExcepcion("[ERROR: SOLO PUEDE INGRESAR LAS OPCIONES SUGERIDAS]");
        }

        EnumProvincia origenP = null;
        EnumProvincia destinoP = null;
        indice = 1;
        for (EnumProvincia p : EnumProvincia.values()) {
            origenP = (indice == origenNum) ? p : null;
            destinoP = (indice == destinoNum) ? p : null;
            indice++;
        }

        System.out.print("Ingrese ciudad de origen: ");
        String origenC = scL.nextLine();
        origenC = origenC.trim();
        if (!origenC.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE INGRESAR NUMEROS]");
        } else if (origenC.isEmpty()) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE DEJAR EL CAMPO VACIO]");
        }

        System.out.print("ingrese ciudad de destino: ");
        String destinoC = scL.nextLine();
        if (!destinoC.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE INGRESAR NUMEROS]");
        } else if (destinoC.isEmpty()) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE DEJAR EL CAMPO VACIO]");
        }

        Ciudad origen = new Ciudad(origenC, origenP);
        Ciudad destino = new Ciudad(destinoC, destinoP);

        // fecha viaje
        System.out.print("Ingrese la fecha del viaje (DD/MM/AAAA): ");
        String fecha = sc.nextLine();
        fecha = fecha.trim();
        if (!fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO SE INGRESO EL FORMATO CORRECTO]");
        } else if (fecha.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE INGRESAR LETRAS]");
        }

        // horarios del viaje
        System.out.print("Ingrese horario de salida (HH:MM): ");
        String salida = sc.nextLine();
        salida = salida.trim();
        if (!salida.matches("\\d{2}:\\d{2}")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO SE INGRESO EL FORMATO CORRECTO]");
        } else if (salida.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE INGRESAR LETRAS]");
        }

        System.out.print("Ingrese horario de llegada (HH:MM): ");
        String llegada = sc.nextLine();
        if (!llegada.matches("\\d{2}:\\d{2}")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO SE INGRESO EL FORMATO CORRECTO]");
        } else if (llegada.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE INGRESAR LETRAS]");
        }

        // agregar chofer a viaje
        Chofer c = null;
        for (Chofer p : ctrlCho.getChoferes()) {
            if (p.isEstaDisponible() == true) {
                c = p;
            }
        }
        if (c == null) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO SE ENCONTRO CHOFER DISPONIBLE]");
        }

        System.out.print("1- MINI BUS ");
        System.out.print("2 - COLECTIVO \n");
        System.out.print("Ingrese vehiculo preferido: ");
        int opcionv = sc.nextInt();
        Vehiculo v = null;
        if (opcionv == 1) {
            for (Vehiculo p : ctrlV.getVehiculos()) {
                if (p.isEstaDisponible() == true && p instanceof Minibus) {
                    v = p;
                }
            }
        } else {
            for (Vehiculo p : ctrlV.getVehiculos()) {
                if (p.isEstaDisponible() == true && p instanceof Colectivo) {
                    v = p;
                }
            }
        }
        if (v == null) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO SE ENCONTRO VEHICULO DISPONIBLE]");
        }

        // Viaje completo
        Viaje viaje = new Viaje(fecha, salida, llegada, c, v, origen, destino);
        listaViajes.add(viaje);
        sc.nextLine();

        System.out.println("**************************************************");
        System.out.println("VIAJE PROGRAMADO CON EXITO");
        System.out.println("**************************************************");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime horaLlegada = LocalDateTime.parse(llegada, formatter);
        if (!horaLlegada.isAfter(LocalDateTime.now())) {
            viaje.setEstadoViaje(EstadoViaje.TERMINADO);
        } else {
            viaje.setEstadoViaje(EstadoViaje.EN_CURSO);
        }

    }

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
    public void eliminarViaje() throws InputMismatchException {
        Scanner sc = new Scanner(System.in);

        mostrarViajesConIndice();

        if (listaViajes.isEmpty())
            return;

        System.out.print("Ingrese el numero del viaje a eliminar: ");
        int opcion = sc.nextInt();

        if (opcion < 1 || opcion > listaViajes.size()) {
            System.out.println("[ERROR: Numero inválido]");
            return;
        }

        Viaje eliminado = listaViajes.remove(opcion - 1);
        System.out.println("El viaje fue eliminado con exito.");
    }

    // Metodo para editar un viaje
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

        // Seleccionar nueva ciudad de destino
        System.out.print("Seleccione nueva ciudad de destino: ");
        int destinoIndex = sc.nextInt() - 1;
        sc.nextLine();

        if (destinoIndex < 0 || destinoIndex >= ciudades.size()) {
            System.out.println("[ERROR: Ciudad destino no valida]");
            return;
        }

        // Asignar nuevas ciudades al viaje
        viaje.setCiudadOrigen(ciudades.get(origenIndex));
        viaje.setCiudadDestino(ciudades.get(destinoIndex));

        System.out.println("El viaje fue editado correctamente.");
    }

    // metodo mostar viaje
    public void mostrarViaje() {
        Scanner sc = new Scanner(System.in);

        if (listaViajes.isEmpty()) {
            System.out.println("No hay viajes cargados.");
            return;
        }

        System.out.println("==== VIAJES DISPONIBLES ====");
        for (int i = 0; i < listaViajes.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + listaViajes.get(i).getResumen());
        }
        System.out.println("============================");

        System.out.print("Seleccione el numero del viaje para ver detalles: ");
        int seleccion = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        if (seleccion < 1 || seleccion > listaViajes.size()) {
            System.out.println("[ERROR: Numero invalido]");
            return;
        }

        Viaje viaje = listaViajes.get(seleccion - 1);

        System.out.println("\n===== DETALLES DEL VIAJE =====");
        System.out.println(viaje.toString());
        System.out.println("===============================");
    }

    public void mostrarViajes() {
        if (listaViajes.isEmpty()) {
            System.out.println("No hay ningun viaje programado.");
        } else {
            for (Viaje viaje : listaViajes) {
                System.out.println(viaje.toString());
            }
        }
    }

    public void mostrarViajesVehiculo() {
        System.out.print("Ingresar patente del colectivo a revisar:");
        String patente = sc.nextLine();
        for (Viaje viaje : listaViajes) {
            if (viaje.getVehiculo().getPatente().equals(patente) && viaje.getVehiculo() instanceof Colectivo) {
                if (viaje.getEstadoViaje() == EstadoViaje.EN_CURSO) {
                    System.out.println(viaje);
                }
            } else {
                System.out.print("Ocurrio un error inesperado: patente equivocada o no perteneciente a un colectivo");
            }
        }
    }

    public void mostrarViajesChoferes() {
        System.out.print("Ingresar el dni del chofer a revisar:");
        long dni = sc.nextLong();
        int cantViajes = 0;
        for (Viaje viaje : listaViajes) {
            if ((viaje.getChofer().getDni()) == (dni) && viaje.getVehiculo() instanceof Colectivo
                    && viaje.getEstadoViaje() == EstadoViaje.TERMINADO) {
                cantViajes = cantViajes + 1;
            }
        }
    }
}
