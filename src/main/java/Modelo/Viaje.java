/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Gaston PC
 */
public class Viaje {
    private String fecha;
    private String horarioSalida;
    private String horarioLlegada;
    private Chofer chofer;
    private Vehiculo vehiculo;
    private Ciudad ciudadOrigen;
    private Ciudad ciudadDestino;
    private EstadoViaje estado;

    public Viaje(String fecha, String horarioSalida, String horarioLlegada, Chofer chofer, Vehiculo vehiculo,
            Ciudad ciudadOrigen, Ciudad ciudadDestino) {
        this.fecha = fecha;
        this.horarioSalida = horarioSalida;
        this.horarioLlegada = horarioLlegada;
        this.chofer = chofer;
        this.ciudadDestino = ciudadDestino;
        this.ciudadOrigen = ciudadOrigen;
        this.vehiculo = vehiculo;
    }

    // set
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHorarioLlegada(String horarioLlegada) {
        this.horarioLlegada = horarioLlegada;
    }

    public void setHorarioSalida(String horarioSalida) {
        this.horarioSalida = horarioSalida;
    }

    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setCiudadOrigen(Ciudad ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public void setCiudadDestino(Ciudad ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public void setEstadoViaje(EstadoViaje estado) {
        this.estado = estado;
    }

    // get
    public String getFecha() {
        return fecha;
    }

    public String getHorarioLlegada() {
        return horarioLlegada;
    }

    public String getHorarioSalida() {
        return horarioSalida;
    }

    public Chofer getChofer() {
        return chofer;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Ciudad getCiudadOrigen() {
        return ciudadOrigen;
    }

    public Ciudad getCiudadDestino() {
        return ciudadDestino;
    }

    public EstadoViaje getEstadoViaje() {
        return estado;
    }

    @Override
    public String toString() {
        return "VIAJE{\n"
                + " Fecha " + getFecha() + ",\n"
                + " Horario de salida " + getHorarioSalida() + ",\n"
                + " Horario de  llegada" + getHorarioLlegada() + ",\n"
                + " Chofer designado: " + getChofer() + ",\n"
                + " Vehiculo designado: " + getVehiculo() + ",\n"
                + " Ciudad de partida: " + getCiudadOrigen() + ",\n"
                + " Ciudad destino: " + getCiudadDestino() + "}";
    }

    public String getResumen() {
        return ciudadOrigen.getNombre() + " a " + ciudadDestino.getNombre() + " - " + fecha + " - " + "Salida:"
                + horarioSalida + "Llegada:" + horarioLlegada;
    }

}
