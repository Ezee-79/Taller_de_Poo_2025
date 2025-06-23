package Modelo;

/**
 * Clase que representa un minibus, se especifica si tiene una bodega y aire acondicionado,
 * extiende de la clase Vehiculo.
 * @author Gaston. 
 * @author Denis.
 * @author Enzo.
 * 
 */

/* Enzo */
public class Minibus extends Vehiculo {
    private boolean tieneBodega;
    private boolean tieneAire;

    /**
     * Constructor por defecto.
     */
    // CONSTRUCTORES.
    public Minibus() {
    }

    /**
     * Constructor parametrizado
     * 
     * @param patente       patente del minibus, heredado de Vehiculo.
     * @param capacidad     capacidad de maxima de pasajeros, heredado de Vehiculo.
     * @param tieneBodega   si el minibus tiene una bodega o no.  
     * @param tieneAire     indica si tiene aire acondicionado.
     */
    public Minibus(String patente, int capacidad, boolean tieneBodega, boolean tieneAire) {
        super(patente, capacidad);
        this.tieneBodega = tieneBodega;
        this.tieneAire = tieneAire;
    }

    /**
     * Metodo que indica si un minibus tiene una bodega.
     * 
     * @return true si tiene, sino false.
     */
    // SETTERS & GETTERS
    public boolean isTieneBodega() {
        return tieneBodega;
    }

    /**
     * Asigna el hecho que tenga o no una bodega.
     * 
     * @param tieneBodega valor booleano si posee bodega.
     */
    public void setTieneBodega(boolean tieneBodega) {
        this.tieneBodega = tieneBodega;
    }

    /**
     * Metodo que indica si el minibus cuenta con aire acondicionado.
     * 
     * @return  true si tiene, sino false.
     */
    public boolean isTieneAire() {
        return tieneAire;
    }

    /**
     * Asigna si cuenta con aire acondicionado.
     * 
     * @param tieneAire valor booleano de disponer aire acondicionado.
     */
    public void setTieneAire(boolean tieneAire) {
        this.tieneAire = tieneAire;
    }

    /**
     * Representacion de los datos impresos del minibus.
     * 
     * @return cadena de datos del minibus.
     */
    // TOSTRING.
    @Override
    public String toString() {
        String bodega = (tieneBodega) ? "Si" : "No";
        String aire = (tieneAire) ? "Si" : "No";

        return "MINIBUS{\n"
                + " Patente: " + getPatente() + ",\n"
                + " Capacidad: " + getCapacidad() + ",\n"
                + " Bodega: " + bodega + ",\n"
                + " Aire Acondicionado: " + aire + "}";
    }
}
