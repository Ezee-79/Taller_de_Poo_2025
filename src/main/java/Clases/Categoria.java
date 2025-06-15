
 package Clases;

public class Categoria {
    private NCategoria tipo;

    public Categoria (NCategoria tipo) {
        this.tipo = tipo;
    }

    //set

    public void setTipo(NCategoria tipo) {
        this.tipo = tipo;
    }

    //get
    public NCategoria getTipo() {
        return tipo;
    }
}


