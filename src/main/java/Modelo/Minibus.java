package Modelo;
/* Enzo */
public class Minibus extends Vehiculo {
    private boolean tieneBodega;
    private boolean aireAcondicionado;

    //CONSTRUCTORES.
    public Minibus() {
    }

    public Minibus(String patente, int capacidad, boolean tieneBodega, boolean aireAcondicionado) {
        super(patente, capacidad);
        this.tieneBodega = tieneBodega;
        this.aireAcondicionado = aireAcondicionado;
    }

    //SETTERS & GETTERS
    public boolean isTieneBodega() {
        return tieneBodega;
    }

    public void setTieneBodega(boolean tieneBodega) {
        this.tieneBodega = tieneBodega;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }
}
