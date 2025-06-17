package Modelo;
/* Enzo */
public class Ciudad {
    private String nombre;
    private EnumProvincia provincia;

    public Ciudad() {
    }

    public Ciudad(String nombre, EnumProvincia provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public EnumProvincia getProvincia() {
        return provincia;
    }

    public void setProvincia(EnumProvincia provincia) {
        this.provincia = provincia;
    }
}
