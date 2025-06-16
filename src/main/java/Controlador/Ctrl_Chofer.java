package Controlador;

import java.util.ArrayList;
import java.util.Scanner;
import Modelo.Chofer;

public class Ctrl_Chofer {
    private ArrayList<Chofer> choferes = new ArrayList<Chofer>();
    private Scanner sc = new Scanner(System.in);

    private Chofer chofer = new Chofer();

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

    public void agregarChofer() {
        System.out.println("Ingresa los datos solicitados para el nuevo chofer:\n");
        setChofer();
        choferes.add(chofer);
        chofer = new Chofer();
    }

    public void editarChofer(long dni) {
        int posicion = 0;
        for (int i = 0; i < choferes.size(); i++) {
            if (choferes.get(i).getDni() == dni) {
                chofer = choferes.get(i);
                break;
            } else {
                System.out.println("El chofer no fue encontrado.");
            }
        }

        if (chofer != null) {
            System.out.println("Edita los datos del chofer seleccionado:\n");
            setChofer();
            choferes.set(posicion, chofer);
            chofer = new Chofer();
        }
    }

    public void eliminarChofer(long dni) {
        int tamaño = choferes.size();
        choferes.remove(chofer);

        if (tamaño < choferes.size()) {
            System.out.println("El chofer fue eliminado de la lista.");
        } else {
            System.out.println("El chofer no fue encontrado.");
        }
    }

    public void mostrarChofer(long dni) {
        for (int i = 0; i < choferes.size(); i++) {
            if (choferes.get(i).getDni() == dni) {
                chofer = choferes.get(i);
                break;
            } else {
                System.out.println("El chofer no fue encontrado.");
            }
        }

        System.out.println("Chofer encontrado:\n");
        chofer.toString();
    }
}
