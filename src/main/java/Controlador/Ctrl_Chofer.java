package Controlador;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Modelo.Categoria;
import Modelo.Chofer;
import Modelo.ChoferCategoria;
import Modelo.EnumCategoria;
import Excepciones.*;

/* Enzo */
public class Ctrl_Chofer {
    private ArrayList<ChoferCategoria> choferes = new ArrayList<ChoferCategoria>();
    private ChoferCategoria choferCateg;
    private Scanner scL;
    private Scanner scI;

    // CONSTRUCTOR.
    public Ctrl_Chofer() {
        choferCateg = new ChoferCategoria(
                new Chofer("ABC123", 10100100, "Enzo", "Portillo"),
                new Categoria(EnumCategoria.MINIBUS));
        choferes.add(choferCateg);

        choferCateg = new ChoferCategoria(
                new Chofer("DEF456", 20200200, "Ezequiel", "Romero"),
                new Categoria(EnumCategoria.COLECTIVO));
        choferes.add(choferCateg);

        choferCateg = new ChoferCategoria(
                new Chofer("GHI789", 30300300, "Denis", "Chang"),
                new Categoria(EnumCategoria.AMBOS));
        choferes.add(choferCateg);
    }

    // INGRESAMOS NUEVOS DATOS AL OBJETO CHOFER.
    public void setChofer() throws IngresoInvalidoExcepcion, InputMismatchException {
        scI = new Scanner(System.in);
        scL = new Scanner(System.in);

        if (choferCateg == null) {
            choferCateg = new ChoferCategoria();
        } else {
            System.out.println("\n[DATOS ACTUALES DEL CHOFER]\n"
                    + choferCateg.getChofer().toString() + "\n"
                    + "{CATEGORIA: " + choferCateg.getCategoria().getTipo().name() + "\n"
                    + "FECHA DE VENCIMIENTO: " + choferCateg.getFechaVencimiento() + "}");
        }

        System.out.println("\nINGRESAR LOS SIGUIENTES DATOS");
        System.out.print("NOMBRE: ");
        String nombre = scL.nextLine();
        nombre = nombre.trim();
        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE INGRESAR NUMEROS O ESPACIOS]");
        } else if (nombre.isEmpty()) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE DEJAR EL CAMPO VACIO]");
        }

        System.out.print("APELLIDO: ");
        String apellido = scL.nextLine();
        apellido = apellido.trim();
        if (!apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE INGRESAR NUMEROS]");
        } else if (apellido.isEmpty()) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE DEJAR EL CAMPO VACIO]");
        }

        System.out.print("DNI: ");
        long dni = scI.nextLong();
        if (dni < 1000000 || dni > 99999999) {
            throw new IngresoInvalidoExcepcion("[ERROR: DEBE INGRESAR 7-8 DIGITOS]");
        }

        for (ChoferCategoria c : choferes) {
            if (c.getChofer().getDni() == dni) {
                throw new IngresoInvalidoExcepcion("[ERROR: YA EXISTE UN CHOFER CON EL DNI INGRESADO]");
            }
        }

        System.out.print("NUMERO DE LICENCIA: ");
        String nroLicencia = scL.nextLine();
        nroLicencia = nroLicencia.trim();
        if (nroLicencia.isEmpty()) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE DEJAR EL CAMPO VACIO]");
        } else if (nroLicencia.contains(" ")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE INGRESAR ESPACIOS]");
        }

        System.out.print("CATEGORIA [1.MINIBUS][2.COLECTIVO][3.AMBOS]: ");
        int enumC = scI.nextInt();
        if (enumC != 1 && enumC != 2 && enumC != 3) {
            throw new IngresoInvalidoExcepcion("[ERROR: DEBE INGRESAR UNA DE LAS OPCIONES SUGERIDAS]");
        }

        if (enumC == 1) {
            choferCateg.getCategoria().setTipo(EnumCategoria.MINIBUS);
        } else if (enumC == 2) {
            choferCateg.getCategoria().setTipo(EnumCategoria.COLECTIVO);
        } else if (enumC == 3) {
            choferCateg.getCategoria().setTipo(EnumCategoria.AMBOS);
        }

        System.out.print("INGRESAR FECHA DE VENCIMIENTO: ");
        String fecha = scL.nextLine();
        if (!fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO SE INGRESO EL FORMATO CORRECTO]");
        } else if (fecha.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE INGRESAR LETRAS]");
        }

        choferCateg.getChofer().setNombre(nombre);
        choferCateg.getChofer().setApellido(apellido);
        choferCateg.getChofer().setDni(dni);
        choferCateg.getChofer().setNroLicencia(nroLicencia);
        choferCateg.setFechaVencimiento(fecha);
    }

    // AGREGAMOS NUEVO CHOFER A LA LISTA.
    public void agregarChofer() throws IngresoInvalidoExcepcion, InputMismatchException {
        System.out.println("***************************************************");
        System.out.println("[COMPLETA LOS DATOS PARA AGREGAR UN NUEVO CHOFER]");
        choferCateg = null;
        setChofer();
        choferes.add(choferCateg);
        System.out.println("\n[NUEVO CHOFER AGREGADO A LA LISTA]");
        System.out.println("***************************************************\n");
    }

    // BUSCAMOS EL CHOFER EN LA LISTA POR DNI, SI SE ENCUENTRA SE EDITAN LOS DATOS.
    public void editarChofer() throws IngresoInvalidoExcepcion, InputMismatchException {
        scI = new Scanner(System.in);
        System.out.println("***************************************************");
        System.out.print("INGRESAR DNI DEL CHOFER A EDITAR: ");
        long dni = scI.nextLong();
        if (dni < 1000000 || dni > 99999999) {
            throw new IngresoInvalidoExcepcion("[ERROR: DEBE INGRESAR 7-8 DIGITOS]");
        }

        boolean encontrado = false;
        int indice = 0;
        for (ChoferCategoria c : choferes) {
            if (c.getChofer().getDni() == dni) {
                choferCateg = c;
                encontrado = true;
                indice = choferes.indexOf(c);
                break;
            }
        }

        if (encontrado) {
            System.out.println("\n[INGRESAR LOS NUEVOS DATOS PARA EL CHOFER]\n");
            setChofer();
            choferes.set(indice, choferCateg);
            System.out.println("\n[EL CHOFER HA SIDO MODIFICADO]");
        } else {
            System.out.println("\n[EL CHOFER NO FUE ENCONTRADO]");
        }

        System.out.println("***************************************************\n");
    }

    // BUSCAMOS UN CHOFER EN LA LISTA POR DNI, SI SE ENCUENTRA SE ELIMINA.
    public void eliminarChofer() throws IngresoInvalidoExcepcion, InputMismatchException {
        scI = new Scanner(System.in);
        System.out.println("***************************************************");
        System.out.print("INGRESAR DNI DEL CHOFER A ELIMINAR: ");
        long dni = scI.nextLong();
        if (dni < 1000000 || dni > 99999999) {
            throw new IngresoInvalidoExcepcion("[ERROR: DEBE INGRESAR 7-8 DIGITOS]");
        }

        boolean encontrado = false;
        for (ChoferCategoria c : choferes) {
            if (c.getChofer().getDni() == dni) {
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
        scI = new Scanner(System.in);
        System.out.println("***************************************************");
        System.out.print("INGRESAR DNI DEL CHOFER A MOSTRAR: ");
        long dni = scI.nextLong();
        if (dni < 1000000 || dni > 99999999) {
            throw new IngresoInvalidoExcepcion("[ERROR: DEBE INGRESAR 7-8 DIGITOS]");
        }

        boolean encontrado = false;
        for (ChoferCategoria c : choferes) {
            if (c.getChofer().getDni() == dni) {
                System.out.println("\n[CHOFER ENCONTRADO]\n");
                encontrado = true;

                System.out.println(c.getChofer().toString() + "\n"
                        + "{CATEGORIA: " + c.getCategoria().getTipo().name() + "\n"
                        + "FECHA DE VENCIMIENTO: " + c.getFechaVencimiento() + "}");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("\n[EL CHOFER NO FUE ENCONTRADO]");
        }

        System.out.println("***************************************************\n");
    }

    // GET LISTA DE CHOFERES.
    public ArrayList<ChoferCategoria> getLista() {
        return choferes;
    }
}
