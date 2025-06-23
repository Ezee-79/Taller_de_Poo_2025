/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 * Representa un viaje realizado por un vehículo conducido por un chofer entre dos ciudades en una fecha y horarios determinados.
 * 
 * Contiene detalles como la fecha del viaje, horarios de salida y llegada, {@link Chofer}, {@link Vehículo} asignado,
 * {@link Ciudad} de origen y destino, y el estado del viaje.
 * 
 * @author Gaston. 
 * @author Denis.
 * @author Enzo.
 */
public class Viaje {
    private String fechaSalida;    
    private String fechaLlegada;
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
     * @param fechaSalida la fecha de salida del viaje (formato sugerido: dd/MM/yyyy).
     * @param fechaLlegada la fecha de llegada del viaje a su destino(formato sugerido: dd/MM/yyyy).
     * @param horarioSalida la hora de salida del viaje (formato sugerido: HH:mm).
     * @param horarioLlegada la hora de llegada estimada (formato sugerido: HH:mm).
     * @param chofer el {@link Chofer} asignado al viaje.
     * @param vehiculo el {@link Vehiculo} asignado al viaje.
     * @param ciudadOrigen la {@link Ciudad} de origen del viaje.
     * @param ciudadDestino la {@link Ciudad} de destino del viaje.
     */
    public Viaje(String fechaSalida, String fechaLlegada, String horarioSalida, String horarioLlegada, Chofer chofer, Vehiculo vehiculo,
            Ciudad ciudadOrigen, Ciudad ciudadDestino) {
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.horarioSalida = horarioSalida;
        this.horarioLlegada = horarioLlegada;
        this.chofer = chofer;
        this.ciudadDestino = ciudadDestino;
        this.ciudadOrigen = ciudadOrigen;
        this.vehiculo = vehiculo;
    }

    /**
     * Establece la fecha de salida del viaje.
     *
     * @param fecha nueva fecha de salida del viaje.
     */
    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * Establece la fecha de llegada del viaje.
     *
     * @param fecha nueva fecha de llegada del viaje.
     */
    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
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
     * @param chofer nuevo {@link Chofer} para el viaje.
     */
    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }

    /**
     * Establece el vehiculo del viaje.
     *
     * @param  vehiculo nuevo {@link Vehiculo} del viaje.
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Establece la ciudad de partida del viaje.
     *
     * @param ciudadOrigen nueva {@link Ciudad} de salida del viaje.
     */
    public void setCiudadOrigen(Ciudad ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    /**
     * Establece la ciudad destino del viaje.
     *
     * @param ciudadDestino nueva {@link Ciudad} de destino del viaje.
     */
    public void setCiudadDestino(Ciudad ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    /**
     * Establece el estado actual del viaje (ejemplo, EN_CURSO, TERMINADO).
     *
     * @param estado el nuevo estado del viaje.
     */
    public void setEstadoViaje(EstadoViaje estado) {
        this.estado = estado;
    }

    /**
     * Devuelve la fecha de salida del viaje.
     *
     * @return la fecha del viaje.
     */
    public String getFechaSalida() {
        return fechaSalida;
    }

    /**
     * Devuelve la fecha de salida del viaje.
     *
     * @return la fecha del viaje.
     */
    public String getFechaLlegada() {
        return fechaLlegada;
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
     * @return el @{@link Chofer} del viaje.
     */
    public Chofer getChofer() {
        return chofer;
    }

    /**
     * Devuelve el vehiculo del viaje.
     *
     * @return el {@link Vehiculo} del viaje.
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Devuelve la ciudad de partida del viaje.
     *
     * @return la {@link Ciudad} de partida del viaje.
     */
    public Ciudad getCiudadOrigen() {
        return ciudadOrigen;
    }

    /**
     * Devuelve la ciudad destino del viaje.
     *
     * @return la {@link Ciudad} destino del viaje.
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
                + " Fecha de salida: " + getFechaSalida() + ",\n"
                + " Fecha de llegada: " + getFechaLlegada() + ",\n"
                + " Horario de salida: " + getHorarioSalida() + ",\n"
                + " Horario de  llegada:" + getHorarioLlegada() + ",\n"
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
        return ciudadOrigen.getNombre() + " a " + ciudadDestino.getNombre() + " - " + "fecha: " + getFechaSalida() + " - " + "Salida:"
                + horarioSalida + "Llegada:" + horarioLlegada;
    }

}
