/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author Gaston PC
 */
import Modelo.Viaje;
import Modelo.Ciudad;
import Modelo.EnumProvincia;
import java.util.*;
import Modelo.*;

public class Ctrl_Viaje {

    private ArrayList<Viaje> listaViajes = new ArrayList<>();
    private ArrayList<Ciudad> listaCiudades = new ArrayList<>();

    public void Ciudades() {
        listaCiudades.add(new Ciudad("Buenos Aires", EnumProvincia.BUENOS_AIRES));
        listaCiudades.add(new Ciudad("Córdoba", EnumProvincia.CORDOBA));
        listaCiudades.add(new Ciudad("Santa fe", EnumProvincia.SANTA_FE));
        listaCiudades.add(new Ciudad("Mendoza", EnumProvincia.MENDOZA));
        listaCiudades.add(new Ciudad("San Miguel de Tucumán", EnumProvincia.TUCUMAN));
        listaCiudades.add(new Ciudad("Catamarca", EnumProvincia.CATAMARCA));
        listaCiudades.add(new Ciudad("Chaco", EnumProvincia.CHACO));
        listaCiudades.add(new Ciudad("La Rioja", EnumProvincia.LA_RIOJA));
        listaCiudades.add(new Ciudad("Chubut", EnumProvincia.CHUBUT));

    }
    
    
    Scanner sc = new Scanner(System.in);

    public void planificarViaje(Scanner sc) {
        

        System.out.println("Ciudades disponibles");
        for (int i = 0; i < listaCiudades.size(); i++) {
            System.out.println((i + 1) + "-" + listaCiudades.get(i).getNombre());
        }
        
        System.out.print("Seleccione ciudad de origen: ");
        int origenx = sc.nextInt() - 1;
        
        System.out.print("Seleccione ciudad de destino: ");
        int destinox = sc.nextInt() - 1;
        sc.nextLine();

        Ciudad origen = listaCiudades.get(origenx);
        Ciudad destino = listaCiudades.get(destinox);

        //fecha viaje
        System.out.print("Ingrese la fecha del viaje: ");
        String fecha = sc.nextLine();

        // horarios del viaje
        System.out.print("Ingrese horario de salida: ");
        String salida = sc.nextLine();

        System.out.print("Ingrese horario de llegada: ");
        String llegada = sc.nextLine();


        //agregar chofer a viaje
        Chofer c;
        for (Chofer p : new Ctrl_Chofer().getChoferes()) {
            if (p.getDisponible() == true) {
                c = p;
            }
        }

        System.out.print("1- MINI BUS ");
        System.out.print("2 - COLECTIVO ");
        System.out.print("Ingrese vehiculo preferido: ");
        int opcionv = sc.nextInt();
        Vehiculo Vtipo;
        
        if (opcionv == 1) {
            for (Vehiculo p : new Ctrl_Vehiculo().getVehiculos()) {
                if (p.getDisponible() == true && p instanceof Minibus) {
                    Vtipo = p;
                }
            }

        } else {

            for (Vehiculo p : new Ctrl_Vehiculo().getVehiculos()) {
                if (p.getDisponible() == true && p instanceof Colectivo) {
                    Vtipo = p;
                }
            }

        }

        // Viaje completo 
        Viaje viaje = new Viaje(fecha, salida, llegada, c, Vtipo, origen, destino);

        listaViajes.add(viaje);

    }

    public void mostrarCiudades() {
        for (Ciudad ciudad : listaCiudades) {
            System.out.println(ciudad.getNombre() + " - " + ciudad.getProvincia());
        }
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

    
    
    public ArrayList<Viaje> getListaViajes() {
        return listaViajes;
    }

    public ArrayList<Ciudad> getListaCiudades() {
        return listaCiudades;
    }

}
