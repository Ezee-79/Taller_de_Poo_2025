package Controlador;

import java.util.ArrayList;
import java.util.Scanner;
import Modelo.Chofer;

public class Ctrl_Chofer {
    private ArrayList<Chofer> choferes = new ArrayList<Chofer>();
    private Scanner sc = new Scanner(System.in);
    private Chofer chofer = new Chofer();

    public Ctrl_Chofer() {
    }

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
            }
        }

        if (chofer != null) {
            System.out.println("Edita los datos del chofer seleccionado:\n");
            setChofer();
            choferes.set(posicion, chofer);
            chofer = new Chofer();
        } else {
            System.out.println("El chofer no fue encontrado.");
        }
    }

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
            System.out.println("El chofer fue eliminado de la lista.");
        } else{
            System.out.println("El chofer no fue encontrado.");
        }
    }

    public void mostrarChofer(long dni) {
        for (Chofer c : choferes) {
            if (c.getDni() == dni) {
                System.out.println("Chofer encontrado:\n");
                c.toString();
                break;
            }
        }
    }
}
