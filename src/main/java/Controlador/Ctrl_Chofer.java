package Controlador;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import Modelo.Chofer;
import Excepciones.*;


/**
 * Clase controladora encargada de gestionar choferes.
 * Permite agregar, editar, eliminar y mostrar choferes, tambien muestra aquellos que estan disponibles para su asignacion a un viaje.
 * Se encarga también de validar los datos ingresados por el usuario.
 * 
 * @author Gaston. 
 * @author Denis.
 * @author Enzo.
 * @see Modelo.Chofer.
 */
public class Ctrl_Chofer {
    private ArrayList<Chofer> choferes = new ArrayList<Chofer>();
    private Scanner scL;
    private Scanner scI;
    private Chofer chofer;

    /**
     * Constructor que inicializa la lista de choferes con algunos valores por defecto.
     */
    public Ctrl_Chofer() {
        choferes.add(new Chofer("ABC123", 10100100, "Enzo", "Portillo"));
        choferes.add(new Chofer("DEF456", 20200200, "Ezequiel", "Romero"));
        choferes.add(new Chofer("GHI789", 30300300, "Denis", "Chang"));
    }

    /**
     * Permite ingresar o modificar los datos de un chofer.
     * Lanza excepciones si los datos ingresados no son del mismo tipo.
     * 
     * @throws IngresoInvalidoExcepcion si se ingresan datos inválidos.
     * @throws InputMismatchException si se produce un error en el tipo de entrada.
     */
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

    /**
     * Agrega un nuevo chofer a la lista cuyos datos son ingresados por consola.
     * 
     * @throws IngresoInvalidoExcepcion si se ingresan datos inválidos.
     * @throws InputMismatchException si se produce un error en el tipo de entrada.
     */
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

     /**
     * Se busca un chofer por su Dni y si hay una coincidencia se editan sus datos.
     * 
     * @throws IngresoInvalidoExcepcion si el DNI o los nuevos datos son inválidos.
     * @throws InputMismatchException si se produce un error en el tipo de entrada.
     */
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

    /**
     * Se busca un chofer por su Dni y si hay una coincidencia se lo elimina de la lista.
     * 
     * @throws IngresoInvalidoExcepcion
     * @throws InputMismatchException
     */
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

    /**
     * Se busca un chofer por su Dni y si hay una coincidencia se muestran sus datos.
     * 
     * @throws IngresoInvalidoExcepcion
     * @throws InputMismatchException
     */
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

    /**
     * Retorna una lista compuesta de objetos {@link Chofer}.
     * 
     * @return lista de {@link Chofer}.
     */
    public ArrayList<Chofer> getChoferes() {
        return choferes;
    }

    /**
     * Define una nueva lista de choferes.
     * 
     * @param choferes una nueva lista de choferes.
     */
    public void setChoferes(ArrayList<Chofer> choferes) {
        this.choferes = choferes;
    }

    /**
     * Retorna los datos de un {@link chofer}.
     * 
     * @return un objeto {@link chofer}.
     */
    public Chofer getChofer() {
        return chofer;
    }

    /**
     * Asigna los datos de un chofer.
     * 
     * @param chofer define un objeto {@link Chofer} a asignar.
     */
    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }
}
