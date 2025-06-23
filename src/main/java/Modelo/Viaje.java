/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 * Representa un viaje realizado por un vehículo conducido por un chofer entre dos ciudades en una fecha y horarios determinados.
 * 
 * Contiene detalles como la fecha del viaje, horarios de salida y llegada, chofer, vehículo asignado,
 * ciudades de origen y destino, y el estado del viaje.
 * 
 * @author Gaston. 
 * @author Denis.
 * @author Enzo.
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

    /**
     * Constructor que inicializa un nuevo viaje con sus datos principales.
     *
     * @param fecha la fecha del viaje (formato sugerido: dd/MM/yyyy).
     * @param horarioSalida la hora de salida del viaje (formato sugerido: HH:mm).
     * @param horarioLlegada la hora de llegada estimada (formato sugerido: HH:mm).
     * @param chofer el chofer asignado al viaje.
     * @param vehiculo el vehículo asignado al viaje.
     * @param ciudadOrigen la ciudad de origen del viaje.
     * @param ciudadDestino la ciudad de destino del viaje.
     * @param estado situacion en la que transcurre el viaje.
     */
    public Viaje(String fecha, String horarioSalida, String horarioLlegada, Chofer chofer, Vehiculo vehiculo,
            Ciudad ciudadOrigen, Ciudad ciudadDestino, EstadoViaje estado) {
        this.fecha = fecha;
        this.horarioSalida = horarioSalida;
        this.horarioLlegada = horarioLlegada;
        this.chofer = chofer;
        this.ciudadDestino = ciudadDestino;
        this.ciudadOrigen = ciudadOrigen;
        this.vehiculo = vehiculo;
        this.estado = estado.
    }

    /**
     * Establece la fecha del viaje.
     *
     * @param fecha nueva fecha del viaje.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Establece el horario de llegada del viaje.
     *
     * @param horarioLlegada nuevo horario de llegada del viaje.
     */
    public void setHorarioLlegada(String horarioLlegada) {
        this.horarioLlegada = horarioLlegada;
    }

    /**
     * Establece el horario de salida del viaje.
     *
     * @param horarioSalida nuevo horario de salida del viaje.
     */
    public void setHorarioSalida(String horarioSalida) {
        this.horarioSalida = horarioSalida;
    }

    /**
     * Establece el chofer del viaje.
     *
     * @param chofer nueva Chofer para el viaje.
     */
    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }

    /**
     * Establece el vehiculo del viaje.
     *
     * @param  vehiculo nuevo vehiculo del viaje.
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Establece la ciudad de partida del viaje.
     *
     * @param ciudadOrigen nueva ciudad de salida del viaje.
     */
    public void setCiudadOrigen(Ciudad ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    /**
     * Establece la ciudad destino del viaje.
     *
     * @param fecha  ciudadDestino nueva ciudad de destino del viaje.
     */
    public void setCiudadDestino(Ciudad ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    /**
     * Establece el estado actual del viaje (ejemplo, En_curso, Terminado).
     *
     * @param estado el nuevo estado del viaje.
     */
    public void setEstadoViaje(EstadoViaje estado) {
        this.estado = estado;
    }

    /**
     * Devuelve la fecha del viaje.
     *
     * @return la fecha del viaje.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Devuelve el horario de llegada del viaje.
     *
     * @return el horario de llegada del viaje.
     */
    public String getHorarioLlegada() {
        return horarioLlegada;
    }

    /**
     * Devuelve el horario de salida del viaje.
     *
     * @return el horario de salida del viaje.
     */
    public String getHorarioSalida() {
        return horarioSalida;
    }

    /**
     * Devuelve el chofer del viaje.
     *
     * @return el chofer del viaje.
     */
    public Chofer getChofer() {
        return chofer;
    }

    /**
     * Devuelve el vehiculo del viaje.
     *
     * @return el vehiculo del viaje.
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Devuelve la ciudad de partida del viaje.
     *
     * @return la ciudad de partida del viaje.
     */
    public Ciudad getCiudadOrigen() {
        return ciudadOrigen;
    }

    /**
     * Devuelve la ciudad destino del viaje.
     *
     * @return la ciudad destino del viaje.
     */
    public Ciudad getCiudadDestino() {
        return ciudadDestino;
    }

    /**
     * Devuelve el estado actual del viaje.
     *
     * @return el estado del viaje
     */
    public EstadoViaje getEstadoViaje() {
        return estado;
    }

    /**
     * Devuelve una representación en formato texto de todos los datos del viaje.
     *
     * @return una cadena con los datos del viaje.
     */
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

    /**
     * Devuelve un resumen del viaje.
     *
     * @return un resumen del viaje.
     */
    public String getResumen() {
        return ciudadOrigen.getNombre() + " a " + ciudadDestino.getNombre() + " - " + fecha + " - " + "Salida:"
                + horarioSalida + "Llegada:" + horarioLlegada;
    }

}
