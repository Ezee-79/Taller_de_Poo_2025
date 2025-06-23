/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author Gaston PC
 */
import Modelo.*;

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

    public Ctrl_Viaje() {
    }

    public Ctrl_Viaje(Ctrl_Vehiculo ctrlV, Ctrl_Chofer ctrlC) {
        this.ctrlC = ctrlC;
        this.ctrlV = ctrlV;

        viaje = new Viaje("30/07/2025",
                "10:00",
                "15:00",
                ctrlC.getLista().get(0).getChofer(),
                ctrlV.getVehiculos().get(0),
                new Ciudad("Concordia", EnumProvincia.ENTRE_RIOS),
                new Ciudad("Colon", EnumProvincia.ENTRE_RIOS));
        viaje.setCodigo(0);
        ctrlC.getLista().get(0).getChofer().agregarViaje(viaje);
        listaViajes.add(viaje);

        viaje = new Viaje("20/07/2025",
                "15:00",
                "18:30",
                ctrlC.getLista().get(1).getChofer(),
                ctrlV.getVehiculos().get(3),
                new Ciudad("Concordia", EnumProvincia.ENTRE_RIOS),
                new Ciudad("Ubajay", EnumProvincia.ENTRE_RIOS));
        viaje.setCodigo(1);
        ctrlC.getLista().get(0).getChofer().agregarViaje(viaje);
        listaViajes.add(viaje);

        viaje = new Viaje("20/07/2025",
                "10:00",
                "11:45",
                ctrlC.getLista().get(3).getChofer(),
                ctrlV.getVehiculos().get(3),
                new Ciudad("Concordia", EnumProvincia.ENTRE_RIOS),
                new Ciudad("Colon", EnumProvincia.ENTRE_RIOS));
        viaje.setCodigo(1);
        ctrlC.getLista().get(0).getChofer().agregarViaje(viaje);
        listaViajes.add(viaje);
    }

    public void setViaje() throws IngresoInvalidoExcepcion, InputMismatchException {
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
        if (!fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO SE INGRESO EL FORMATO CORRECTO]");
        } else if (fecha.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
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

        // agregar chofer a viaje
        Chofer c = null;
        for (ChoferCategoria x : ctrlC.getLista()) {
            if (x.getCategoria().getTipo() == enumCateg
                    && x.getChofer().isEstaDisponible()) {
                c = x.getChofer();
            }
        }
        if (c == null) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO SE ENCONTRO CHOFER DISPONIBLE]");
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
        }

        if (!encontrado) {
            System.out.println("[EL VIAJE NO FUE ENCONTRADO]");
        }
    }

    // metodo mostar viaje
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
                }
            }
        }

        if (!encontrado) {
            System.out.println("[EL VEHICULO NO TIENE VIAJES PENDIENTES]");
        }
    }

    public void mostrarViajesChoferes() {
        System.out.println("CANTIDAD DE VIAJES FINALIZADOS POR CADA CHOFER DE COLECTIVOS:");
        int cantViajes = 0;
        for (ChoferCategoria c : ctrlC.getLista()) {
            if (c.getCategoria().getTipo() == EnumCategoria.COLECTIVO
                    || c.getCategoria().getTipo() == EnumCategoria.AMBOS) {
                System.out.println("[EL CHOFER CON DNI " + c.getChofer().getDni()
                        + " HA FINALIZADO: " + c.getChofer().getViajesFinalizados().size() + " VIAJES]");
            }
        }
    }
}
