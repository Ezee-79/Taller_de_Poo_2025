package Clases;


public class Colectivo {
  
public class Colectivo extends Vehiculo {
    private boolean pisoDoble;

    public Colectivo() {
    }

    public Colectivo(String patente, int capacidad, boolean pisoDoble) {
        super(patente, capacidad);
        this.pisoDoble = pisoDoble;
    }

    public boolean isPisoDoble() {
        return pisoDoble;
    }

    public void setPisoDoble(boolean pisoDoble) {
        this.pisoDoble = pisoDoble;
    }

}
