package Modelo;

/**
 * Clase que define la categoria de un vehiculo.
 * 
 * La categoría está definida por un valor del enumerador {@link EnumCategoria}.
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
     * @param tipo el tipo de categoría segun lo contenido en {@link EnumCategoria}.
     */
    public Categoria(EnumCategoria tipo) {
        this.tipo = tipo;
    }

    /**
     * Asigna un tipo de categoría.
     *
     * @param tipo el tipo de categoría, representado por {@link EnumCategoria}.
     */
    public void setTipo(EnumCategoria tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna el tipo de categoría asignado.
     *
     * @return el tipo de categoría como {@link EnumCategoria}.
     */
    public EnumCategoria getTipo() {
        return tipo;
    }
}