package Modelo;

/**
 * Clase que define la categoria de un vehiculo entre minibus y colectivo.
 * 
 * La categoría está definida por un valor del enumerador EnumCategoria.
 * 
 * @author Gaston. 
 * @author Denis.
 * @author Enzo.
 */

public class Categoria {
    private EnumCategoria tipo;

    /**
     * Constructor por defecto.
     */
    public Categoria() {
    }

    /**
     * Constructor con parámetros.
     * Permite crear una categoría directamente con un tipo definido.
     * 
     * @param tipo el tipo de categoría segun lo contenido en enumCategoria.
     */
    public Categoria(EnumCategoria tipo) {
        this.tipo = tipo;
    }

    public void setTipo(EnumCategoria tipo) {
        this.tipo = tipo;
    }

    public EnumCategoria getTipo() {
        return tipo;
    }
}