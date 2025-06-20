package Controlador;

import java.util.ArrayList;
import java.util.Scanner;
import Modelo.Chofer;

/* Enzo */
public class Ctrl_Chofer {
    private ArrayList<Chofer> choferes = new ArrayList<Chofer>();
    private Scanner scL = new Scanner(System.in);
    private Scanner scI = new Scanner(System.in);
    private Chofer chofer;

    // CONSTRUCTOR.
    public Ctrl_Chofer() {
    }

    // INGRESAMOS NUEVOS DATOS AL OBJETO CHOFER.
    public void setChofer() {
        String nombre;
        String apellido;
        int dni;
        String nroLicencia;

        if (chofer == null) {
            chofer = new Chofer();
        } else {
            System.out.println("[DATOS ACTUALES DEL CHOFER]\n" + chofer.toString());
        }

        System.out.println("\nIngresar los siguientes datos:");
        System.out.print("\nNombre: ");
        nombre = scL.nextLine();

        System.out.print("\nApellido: ");
        apellido = scL.nextLine();

        System.out.print("\nDNI: ");
        dni = scI.nextInt();

        System.out.print("\nNumero de Licencia: ");
        nroLicencia = scL.nextLine();

        chofer.setNombre(nombre);
        chofer.setApellido(apellido);
        chofer.setDni(dni);
        chofer.setNroLicencia(nroLicencia);
    }

    // AGREGAMOS NUEVO CHOFER A LA LISTA.
    public void agregarChofer() {
        System.out.println("***************************************************");
        System.out.println("[COMPLETA LOS DATOS PARA AGREGAR UN NUEVO CHOFER]\n");
        chofer = null;
        setChofer();
        choferes.add(chofer);
        System.out.println("\n[NUEVO CHOFER AGREGADO A LA LISTA]");
        System.out.println("***************************************************\n");
    }

    // BUSCAMOS EL CHOFER EN LA LISTA POR DNI, SI SE ENCUENTRA SE EDITAN LOS DATOS.
    public void editarChofer() {
        System.out.println("***************************************************");
        System.out.print("INGRESAR DNI DEL CHOFER A EDITAR: ");
        long dni = scI.nextLong();

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
    public void eliminarChofer() {
        System.out.println("***************************************************");
        System.out.print("INGRESAR DNI DEL CHOFER A ELIMINAR: ");
        long dni = scI.nextLong();

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
    public void mostrarChofer() {
        System.out.println("***************************************************");
        System.out.print("INGRESAR DNI DEL CHOFER A MOSTRAR: ");
        long dni = scI.nextLong();

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
