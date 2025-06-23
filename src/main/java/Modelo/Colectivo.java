package Modelo;

/**
 * Clase que representa un colectivo y se especifica si tiene un piso doble, extiende de {@link Vehiculo}.
 * 
 * @author Gaston. 
 * @author Denis.
 * @author Enzo.
 */

public class Colectivo extends Vehiculo {
    private boolean tienePisoDoble;

    /**
     * Constructor por defecto.
     */
    public Colectivo() {
    }

    /**
     * Constructor parametrizado.
     *  
     * @param patente patente del colectivo.
     * @param capacidad cantidad máxima de pasajeros.
     * @param tienePisoDoble indica si el colectivo es de doble piso.
     */
    public Colectivo(String patente, int capacidad, boolean tienePisoDoble) {
        super(patente, capacidad);
        this.tienePisoDoble = tienePisoDoble;
    }

     /**
     * Devuelve si el colectivo tiene doble piso.
     * 
     * @return {@code true} si tiene doble piso, {@code false} si no.
     */
    public boolean isTienePisoDoble() {
        return tienePisoDoble;
    }

    /**
     * Establece si el colectivo tiene doble piso.
     * 
     * @param tienePisoDoble valor booleano para indicar si tiene doble piso.
     */
    public void setTienePisoDoble(boolean tienePisoDoble) {
        this.tienePisoDoble = tienePisoDoble;
    }

     /**
     * Devuelve una representación en cadena del objeto Colectivo.
     * 
     * @return cadena con la información del colectivo.
     */
    @Override
    public String toString() {
        String pisoDoble = (tienePisoDoble) ? "Si" : "No";

        return "COLECTIVO{\n"
                + " Patente: " + getPatente() + ",\n"
                + " Capacidad: " + getCapacidad() + ",\n"
                + " Piso Doble: " + pisoDoble + "}";
    }
}
