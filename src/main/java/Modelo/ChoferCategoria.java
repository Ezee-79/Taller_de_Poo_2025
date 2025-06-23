package Modelo;

/**
 * Clase que representa que la categoria del vehiculo que se le asigna a un chofer.
 * y hasta cuando debe hacerlo.
 * @author Gaston. 
 * @author Denis.
 * @author Enzo.
 */
public class ChoferCategoria {
    private Chofer chofer;
    private Categoria categoria;
    private String fechaVencimiento;

    /**
     * Constructor por defecto.
     */
    public ChoferCategoria() {
    }

    /**
     * Constructor parametrizado.
     * 
     * @param chofer  el {@link chofer} asociado.
     * @param categoria la {@link categoría}  que puede conducir.
     * @param fechaVencimiento La fecha hasta la cual debe trabajar en esa categoria.
     */
    public ChoferCategoria(Chofer chofer, Categoria categoria, String fechaVencimiento) {
        this.chofer = chofer;
        this.categoria = categoria;
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * Devuelve el chofer asociado.
     * 
     * @return el objeto {@link Chofer}.
     */
    public Chofer getChofer() {
        return chofer;
    }

    /**
     * Establece el chofer asociado.
     * 
     * @param chofer el objeto {@link Chofer}.
     */
    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }

    /**
     * Devuelve la categoría asignada al chofer.
     * 
     * @return el objeto {@link Categoria}.
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría asignada al chofer.
     * 
     * @param categoria el objeto {@link Categoria}.
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * Devuelve la fecha de vencimiento de la categoría.
     * 
     * @return fecha en formato String.
     */
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

     /**
     * Establece la fecha de vencimiento de la categoría.
     * 
     * @param fechaVencimiento la fecha en formato String.
     */
    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
