/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author Gaston PC
 */
import java.util.*;

import Excepciones.IngresoInvalidoExcepcion;
import Modelo.Ciudad;
import Modelo.EnumProvincia;

public class Ctrl_Ciudad {
    private ArrayList<Ciudad> ciudades = new ArrayList<>();
    Scanner scL;
    Scanner scI;

    public Ctrl_Ciudad() {
        ciudades.add(new Ciudad("La Plata", EnumProvincia.BUENOS_AIRES));
        ciudades.add(new Ciudad("San Fernando del Valle de Catamarca", EnumProvincia.CATAMARCA));
        ciudades.add(new Ciudad("Resistencia", EnumProvincia.CHACO));
        ciudades.add(new Ciudad("Rawson", EnumProvincia.CHUBUT));
        ciudades.add(new Ciudad("Cordoba", EnumProvincia.CORDOBA));
        ciudades.add(new Ciudad("Corrientes", EnumProvincia.CORRIENTES));
        ciudades.add(new Ciudad("Parana", EnumProvincia.ENTRE_RIOS));
        ciudades.add(new Ciudad("Formosa", EnumProvincia.FORMOSA));
        ciudades.add(new Ciudad("San Salvador de Jujuy", EnumProvincia.JUJUY));
        ciudades.add(new Ciudad("Santa Rosa", EnumProvincia.LA_PAMPA));
        ciudades.add(new Ciudad("La Rioja", EnumProvincia.LA_RIOJA));
        ciudades.add(new Ciudad("Mendoza", EnumProvincia.MENDOZA));
        ciudades.add(new Ciudad("Posadas", EnumProvincia.MISIONES));
        ciudades.add(new Ciudad("Neuquen", EnumProvincia.NEUQUEN));
        ciudades.add(new Ciudad("Viedma", EnumProvincia.RIO_NEGRO));
        ciudades.add(new Ciudad("Salta", EnumProvincia.SALTA));
        ciudades.add(new Ciudad("San Juan", EnumProvincia.SAN_JUAN));
        ciudades.add(new Ciudad("San Luis", EnumProvincia.SAN_LUIS));
        ciudades.add(new Ciudad("Rio Gallegos", EnumProvincia.SANTA_CRUZ));
        ciudades.add(new Ciudad("Santa Fe", EnumProvincia.SANTA_FE));
        ciudades.add(new Ciudad("Santiago del Estero", EnumProvincia.SANTIAGO_DEL_ESTERO));
        ciudades.add(new Ciudad("Ushuaia", EnumProvincia.TIERRA_DEL_FUEGO));
        ciudades.add(new Ciudad("San Miguel de Tucuman", EnumProvincia.TUCUMAN));
    }

    public void registrarCiudad() throws IngresoInvalidoExcepcion, InputMismatchException {
        scL = new Scanner(System.in);
        scI = new Scanner(System.in);

        System.out.print("Ingrese el nombre de la ciudad: ");
        String nombre = scL.nextLine();
        nombre = nombre.trim();
        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE INGRESAR NUMEROS O ESPACIOS]");
        } else if (nombre.isEmpty()) {
            throw new IngresoInvalidoExcepcion("[ERROR: NO PUEDE DEJAR EL CAMPO VACIO]");
        }

        System.out.println("Seleccione la provincia:");
        EnumProvincia[] provincias = EnumProvincia.values();

        for (int i = 0; i < provincias.length; i++) {
            System.out.println(i + 1 + "-" + provincias[i]);
        }

        int seleccion = scI.nextInt();
        if (seleccion < 0 && seleccion > 23) {
            throw new IngresoInvalidoExcepcion("[ERROR: SOLO PUEDE INGRESAR LAS OPCIONES SUGERIDAS]");
        }
        scI.nextLine();

        EnumProvincia provincia = provincias[seleccion - 1];

        Ciudad ciudad = new Ciudad(nombre, provincia);
        ciudades.add(ciudad);
        System.out.println("Ciudad agregada correctamente.");
    }

    public ArrayList<Ciudad> getCiudades() {
        return ciudades;
    }
    
    public Ciudad buscarCiudadPorNombre(String nombre) {
    for (Ciudad c : ciudades) {
        if (c.getNombre().equalsIgnoreCase(nombre)) {
            return c;
        }
    }
    return null;
}

}
