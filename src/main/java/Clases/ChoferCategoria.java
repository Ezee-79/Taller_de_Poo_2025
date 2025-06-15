package Clases;

public class ChoferCategoria {
    private Chofer chofer;
    private Categoria categoria;
    private String fechaVencimiento;

    public ChoferCategoria() {
    }

    public ChoferCategoria(Chofer chofer, Categoria categoria, String fechaVencimiento) {
        this.chofer = chofer;
        this.categoria = categoria;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Chofer getChofer() {
        return chofer;
    }

    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
