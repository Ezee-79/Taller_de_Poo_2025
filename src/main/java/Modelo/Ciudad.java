package Modelo;
/**
 * Clase que representa una ciudad junto con su provincia correspondiente.
 * 
 * Esta clase se utiliza para ubicarlas dentro del sistema,
 * donde cada ciudad pertenece a una provincia definida por el enumerador {@link EnumProvincia}.
 * 
 * 
 * @author Gaston. 
 * @author Denis.
 * @author Enzo.
 */

public class Ciudad {
    private String nombre;
    private EnumProvincia provincia;

    /**
     * Constructor por defecto.
     */
    public Ciudad() {
    }

    /**
     * Constructor parametrizado.
     * 
     * @param nombre nombre de la ciudad.
     * @param provincia la provincia la cual pertenece la ciudad.
     */
    public Ciudad(String nombre, EnumProvincia provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
    }

     /**
     * Devuelve el nombre de la ciudad.
     * 
     * @return nombre de la ciudad.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la ciudad.
     * 
     * @param nombre nombre de la ciudad.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la provincia a la que pertenece la ciudad.
     * 
     * @return provincia de tipo EnumProvincia.
     */
    public EnumProvincia getProvincia() {
        return provincia;
    }

    /**
     * Establece la provincia de la ciudad.
     * 
     * @param provincia provincia, de tipo EnumProvincia.
     */
    public void setProvincia(EnumProvincia provincia) {
        this.provincia = provincia;
    }
}