package Controlador;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import Modelo.Chofer;
import Excepciones.*;

/* Enzo */
public class Ctrl_Chofer {
    private ArrayList<Chofer> choferes = new ArrayList<Chofer>();
    private Scanner scL;
    private Scanner scI;
    private Chofer chofer;

    // CONSTRUCTOR.
    public Ctrl_Chofer() {
        choferes.add(new Chofer("ABC123", 10100100, "Enzo", "Portillo"));
        choferes.add(new Chofer("DEF456", 20200200, "Ezequiel", "Romero"));
        choferes.add(new Chofer("GHI789", 30300300, "Denis", "Chang"));
    }

    // INGRESAMOS NUEVOS DATOS AL OBJETO CHOFER.
    public void setChofer() throws IngresoInvalidoExcepcion, InputMismatchException {
        String nombre;
        String apellido;
        long dni;
        String nroLicencia;

        if (chofer == null) {
            chofer = new Chofer();
        } else {
            System.out.println("\n[DATOS ACTUALES DEL CHOFER]\n" + chofer.toString());
        }

        System.out.println("\nINGRESAR LOS SIGUIENTES DATOS");
        System.out.print("NOMBRE: ");
        nombre = scL.nextLine();
        nombre = nombre.trim();
        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE INGRESAR NUMEROS O ESPACIOS]");
        } else if (nombre.isEmpty()) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE DEJAR EL CAMPO VACIO]");
        }

        System.out.print("APELLIDO: ");
        apellido = scL.nextLine();
        apellido = apellido.trim();
        if (!apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE INGRESAR NUMEROS]");
        } else if (apellido.isEmpty()) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE DEJAR EL CAMPO VACIO]");
        }

        System.out.print("DNI: ");
        dni = scI.nextLong();
        if (dni < 1000000 || dni > 99999999) {
            throw new IngresoInvalidoExcepcion("[ERROR: DEBE INGRESAR 7-8 DIGITOS]");
        }

        System.out.print("NUMERO DE LICENCIA: ");
        nroLicencia = scL.nextLine();
        nroLicencia = nroLicencia.trim();
        if (nroLicencia.isEmpty()) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE DEJAR EL CAMPO VACIO]");
        } else if (nroLicencia.contains(" ")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE INGRESAR ESPACIOS]");
        }

        chofer.setNombre(nombre);
        chofer.setApellido(apellido);
        chofer.setDni(dni);
        chofer.setNroLicencia(nroLicencia);
    }

    // AGREGAMOS NUEVO CHOFER A LA LISTA.
    public void agregarChofer() throws IngresoInvalidoExcepcion, InputMismatchException {
        System.out.println("***************************************************");
        System.out.println("[COMPLETA LOS DATOS PARA AGREGAR UN NUEVO CHOFER]");
        chofer = null;
        scI = new Scanner(System.in);
        scL = new Scanner(System.in);
        setChofer();
        choferes.add(chofer);
        System.out.println("\n[NUEVO CHOFER AGREGADO A LA LISTA]");
        System.out.println("***************************************************\n");
    }

    // BUSCAMOS EL CHOFER EN LA LISTA POR DNI, SI SE ENCUENTRA SE EDITAN LOS DATOS.
    public void editarChofer() throws IngresoInvalidoExcepcion, InputMismatchException {
        System.out.println("***************************************************");
        System.out.print("INGRESAR DNI DEL CHOFER A EDITAR: ");

        scI = new Scanner(System.in);
        scL = new Scanner(System.in);
        long dni = scI.nextLong();
        if (dni < 1000000 || dni > 99999999) {
            throw new IngresoInvalidoExcepcion("[ERROR: DEBE INGRESAR 7-8 DIGITOS]");
        }

        boolean encontrado = false;
        for (Chofer c : choferes) {
            if (c.getDni() == dni) {
                chofer = c;
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            System.out.println("\n[INGRESAR LOS NUEVOS DATOS PARA EL CHOFER]\n");
            setChofer();
            choferes.set(choferes.indexOf(chofer), chofer);
            chofer = new Chofer();
            System.out.println("\n[EL CHOFER HA SIDO MODIFICADO]");
        } else {
            System.out.println("\n[EL CHOFER NO FUE ENCONTRADO]");
        }

        System.out.println("***************************************************\n");
    }

    // BUSCAMOS UN CHOFER EN LA LISTA POR DNI, SI SE ENCUENTRA SE ELIMINA.
    public void eliminarChofer() throws IngresoInvalidoExcepcion, InputMismatchException {
        System.out.println("***************************************************");
        System.out.print("INGRESAR DNI DEL CHOFER A ELIMINAR: ");

        scI = new Scanner(System.in);
        scL = new Scanner(System.in);
        long dni = scI.nextLong();
        if (dni < 1000000 || dni > 99999999) {
            throw new IngresoInvalidoExcepcion("[ERROR: DEBE INGRESAR 7-8 DIGITOS]");
        }

        boolean encontrado = false;
        for (Chofer c : choferes) {
            if (c.getDni() == dni) {
                choferes.remove(c);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            System.out.println("\n[EL CHOFER HA SIDO ELIMINADO]");
        } else {
            System.out.println("\n[EL CHOFER NO FUE ENCONTRADO]");
        }
        System.out.println("***************************************************\n");
    }

    // BUSCAMOS UN CHOFER EN LA LISTA, SI SE ENCUENTRA SE MUESTRAN SUS DATOS.
    public void mostrarChofer() throws IngresoInvalidoExcepcion, InputMismatchException {
        System.out.println("***************************************************");
        System.out.print("INGRESAR DNI DEL CHOFER A MOSTRAR: ");

        scI = new Scanner(System.in);
        scL = new Scanner(System.in);
        long dni = scI.nextLong();
        if (dni < 1000000 || dni > 99999999) {
            throw new IngresoInvalidoExcepcion("[ERROR: DEBE INGRESAR 7-8 DIGITOS]");
        }

        boolean encontrado = false;
        for (Chofer c : choferes) {
            if (c.getDni() == dni) {
                System.out.println("\n[CHOFER ENCONTRADO]\n");
                encontrado = true;

                System.out.println(c.toString());
                break;
            }
        }

        if (!encontrado) {
            System.out.println("\n[EL CHOFER NO FUE ENCONTRADO]");
        }

        System.out.println("***************************************************\n");
    }

    // GETTERS & SETTERS.
    public ArrayList<Chofer> getChoferes() {
        return choferes;
    }

    public void setChoferes(ArrayList<Chofer> choferes) {
        this.choferes = choferes;
    }

    public Chofer getChofer() {
        return chofer;
    }

    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }
}
