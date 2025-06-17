package Controlador;


import java.util.ArrayList;
import java.util.Scanner;
import Modelo.Chofer;
/* Enzo */
public class Ctrl_Chofer {
    private ArrayList<Chofer> choferes = new ArrayList<Chofer>();
    private Scanner sc = new Scanner(System.in);
    private Chofer chofer = new Chofer();

    // CONSTRUCTOR.
    public Ctrl_Chofer() {
    }

    // INGRESAMOS NUEVOS DATOS AL OBJETO CHOFER.
    public void setChofer() {
        System.out.print("Nombre: ");
        chofer.setNombre(sc.nextLine());

        System.out.print("Apellido: ");
        chofer.setApellido(sc.nextLine());

        System.out.print("DNI: ");
        chofer.setDni(sc.nextLong());

        System.out.print("Numero de Licencia: ");
        chofer.setNroLicencia(sc.nextLine());
    }

    // AGREGAMOS NUEVO CHOFER A LA LISTA.
    public void agregarChofer() {
        System.out.println("Ingresa los datos solicitados para el nuevo chofer:\n");
        setChofer();
        choferes.add(chofer);
        chofer = new Chofer();
        System.out.println("Chofer creado y agregado a la lista.\n");
    }

    // BUSCAMOS EL CHOFER EN LA LISTA POR DNI, SI SE ENCUENTRA SE EDITAN LOS DATOS.
    public void editarChofer(long dni) {
        int posicion = 0;
        for (int i = 0; i < choferes.size(); i++) {
            if (choferes.get(i).getDni() == dni) {
                chofer = choferes.get(i);
                break;
            }
        }

        if (chofer != null) {
            System.out.println("Edita los datos del chofer seleccionado:\n");
            setChofer();
            choferes.set(posicion, chofer);
            chofer = new Chofer();
            System.out.println("Datos del chofer [DNI: " + dni + "] editados.\n");
        } else {
            System.out.println("El chofer no fue encontrado.\n");
        }
    }

    // BUSCAMOS UN CHOFER EN LA LISTA POR DNI, SI SE ENCUENTRA SE ELIMINA.
    public void eliminarChofer(long dni) {
        boolean modificado = false;

        for (Chofer c : choferes) {
            if (c.getDni() == dni) {
                choferes.remove(c);
                modificado = true;
                break;
            }
        }

        if (modificado == true) {
            System.out.println("El chofer [DNI: " + dni + "] fue eliminado de la lista.\n");
        } else {
            System.out.println("El chofer no fue encontrado.\n");
        }
    }

    // BUSCAMOS UN CHOFER EN LA LISTA, SI SE ENCUENTRA SE MUESTRAN SUS DATOS.
    public void mostrarChofer(long dni) {
        for (Chofer c : choferes) {
            if (c.getDni() == dni) {
                System.out.println("Chofer encontrado:");
                c.toString();
                System.out.println();
                break;
            }
        }
    }
}
