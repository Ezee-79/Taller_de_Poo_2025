package Modelo;

/* Enzo */
public class Colectivo extends Vehiculo {
    private boolean tienePisoDoble;

    public Colectivo() {
    }

    public Colectivo(String patente, int capacidad, boolean tienePisoDoble) {
        super(patente, capacidad);
        this.tienePisoDoble = tienePisoDoble;
    }

    public boolean isTienePisoDoble() {
        return tienePisoDoble;
    }

    public void setTienePisoDoble(boolean tienePisoDoble) {
        this.tienePisoDoble = tienePisoDoble;
    }

    @Override
    public String toString() {
        String pisoDoble = (tienePisoDoble) ? "Si" : "No";

        return "COLECTIVO{\n"
                + " Patente: " + getPatente() + ",\n"
                + " Capacidad: " + getCapacidad() + ",\n"
                + " Piso Doble: " + pisoDoble + "}";
    }
}
