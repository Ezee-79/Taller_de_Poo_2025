/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Gaston PC
 */
public class Viaje {
    private String fecha;
    private String horarioSalida;
    private String horarioLlegada;
    
    public Viaje (String fecha, String horarioSalida, String horarioLlegada){
        this.fecha = fecha;
        this.horarioSalida = horarioSalida;
        this.horarioLlegada = horarioLlegada;
    }
    
    // set
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    public void setHorarioLlegada(String horarioLlegada){
        this.horarioLlegada = horarioLlegada;
    }
    public void setHorarioSalida(String horarioSalida){
        this.horarioSalida = horarioSalida;
    }
    
    // get
    public String getFecha(){
        return fecha;
    }
    public String getHorarioLlegada(){
        return horarioLlegada;
    }
    public String getHorarioSalida(){
        return horarioSalida;
    }
    
}
