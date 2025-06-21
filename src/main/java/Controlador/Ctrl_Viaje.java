/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.*;

import Excepciones.IngresoInvalidoExcepcion;
/**
 *
 * @author Gaston PC
 */
import Modelo.*;

public class Ctrl_Viaje {
    private ArrayList<Viaje> listaViajes = new ArrayList<>();
    Scanner sc;
    Scanner scL;
    Viaje viaje;

    public Ctrl_Viaje() {
    }

    public void planificarViaje(Ctrl_Chofer ctrlCho, Ctrl_Vehiculo ctrlV, Ctrl_Ciudad ctrlCiu)
            throws IngresoInvalidoExcepcion, InputMismatchException {
        sc = new Scanner(System.in);
        scL = new Scanner(System.in);
        // ESTO LO PODRIAMOS BORRAR PORQUE SI TENEMOS MIL CIUDADES NO PODEMOS MOSTRAR TODAS POR PANTALLA.
        // QUE EL USUARIO ESCRIBA LA CIUDAD Y EL PROGRAMA LE DIGA SI EXISTE O NO ESA CIUDAD.
        // ESTO LO IMPLEMENTE MAS ABAJO, ESTA TODO COMENTADO. SI LO QUIEREN DESCARTAR LO BORRAN JAJAJA.
        System.out.println("Ciudades disponibles");
        for (int i = 0; i < ctrlCiu.getCiudades().size(); i++) {
            System.out.println((i + 1) + "-" + ctrlCiu.getCiudades().get(i).getNombre());
        }

        System.out.print("Seleccione ciudad de origen: ");
        int origenx = sc.nextInt() - 1;
        sc.nextLine();

        System.out.print("Seleccione ciudad de destino: ");
        int destinox = sc.nextInt() - 1;
        sc.nextLine();

        Ciudad origen = ctrlCiu.getCiudades().get(origenx);
        Ciudad destino = ctrlCiu.getCiudades().get(destinox);
        /*
        System.out.print("Ingrese ciudad de origen: ");
        String origenx = scL.nextLine();
        origenx = origenx.trim();
        if (!origenx.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE INGRESAR NUMEROS]");
        } else if (origenx.isEmpty()) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE DEJAR EL CAMPO VACIO]");
        }
        
        System.out.print("ingrese ciudad de destino: ");
        String destinox = scL.nextLine();
        if (!destinox.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE INGRESAR NUMEROS]");
        } else if (destinox.isEmpty()) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE DEJAR EL CAMPO VACIO]");
        }

        Ciudad origen;
        Ciudad destino;
        for(Ciudad c : ctrlCiu.getCiudades()){
            if(c.getNombre().equalsIgnoreCase(origenx)){
                origen = c;
            } else if(c.getNombre().equalsIgnoreCase(destinox)){
                destino = c;
            }
        }

        if(origen == null || destino == null){
            throw new IngresoInvalidoExcepcion("[ERROR: NO SE ENCONTRO UNA O NINGUNA CIUDAD]");
        }
         */
        // fecha viaje
        System.out.print("Ingrese la fecha del viaje (DD/MM/AAAA): ");
        String fecha = sc.nextLine();
        fecha = fecha.trim();
        if(!fecha.matches("\\d{2}/\\d{2}/\\d{4}")){
            throw new IngresoInvalidoExcepcion("[ERROR: NO SE INGRESO EL FORMATO CORRECTO]");
        } else if(fecha.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE INGRESAR LETRAS]");
        }

        // horarios del viaje
        System.out.print("Ingrese horario de salida (HH:MM): ");
        String salida = sc.nextLine();
        salida = salida.trim();
        if(!salida.matches("\\d{2}:\\d{2}")){
            throw new IngresoInvalidoExcepcion("[ERROR: NO SE INGRESO EL FORMATO CORRECTO]");
        } else if(salida.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE INGRESAR LETRAS]");
        }

        System.out.print("Ingrese horario de llegada (HH:MM): ");
        String llegada = sc.nextLine();
        if(!llegada.matches("\\d{2}:\\d{2}")){
            throw new IngresoInvalidoExcepcion("[ERROR: NO SE INGRESO EL FORMATO CORRECTO]");
        } else if(llegada.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE INGRESAR LETRAS]");
        }

        // agregar chofer a viaje
        Chofer c = null;
        for (Chofer p : ctrlCho.getChoferes()) {
            if (p.isEstaDisponible() == true) {
                c = p;
            }
        }
        if(c == null){
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
        if(v == null){
            throw new IngresoInvalidoExcepcion("[ERROR: NO SE ENCONTRO VEHICULO DISPONIBLE]");
        }

        // Viaje completo
        Viaje viaje = new Viaje(fecha, salida, llegada, c, v, origen, destino);
        listaViajes.add(viaje);
        sc.nextLine();
        System.out.println("**************************************************");
        System.out.println("El VIAJE PROGRAMADO CON EXITO");
        System.out.println("**************************************************");
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

    if (listaViajes.isEmpty()) return;

    System.out.print("Ingrese el numero del viaje a eliminar: ");
    int opcion = sc.nextInt();

    if (opcion < 1 || opcion > listaViajes.size()) {
        System.out.println("[ERROR: Numero inválido]");
        return;
    }

    Viaje eliminado = listaViajes.remove(opcion - 1);
    System.out.println("El viaje fue eliminado con exito.");
}

    
    //Metodo para editar un viaje
    public void editarViaje(Ctrl_Ciudad ctrlCiu) throws InputMismatchException {
    Scanner sc = new Scanner(System.in);

    mostrarViajesConIndice();
    if (listaViajes.isEmpty()) return;

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

    
    
    //metodo mostar viaje
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
}
