
 package Modelo;

public class Categoria {
    private EnumCategoria tipo;

    public Categoria (EnumCategoria tipo) {
        this.tipo = tipo;
    }

    //set

    public void setTipo(EnumCategoria tipo) {
        this.tipo = tipo;
    }

    //get
    public EnumCategoria getTipo() {
        return tipo;
    }
}


