/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 * Clase abstracta para una Persona que cuenta con un dni, nombre y apellido.
 * Usado para entidades como Chofer y otras personas que cuenten con las mismas caracteristicas.
 * 
 * @author Gaston. 
 * @author Denis.
 * @author Enzo.
 */
public abstract class Persona {
    private long dni;
    private String nombre;
    private String apellido;

    /**
     * Constructor por defecto.
     */
    public Persona() {
    }

    /**
     * Constructor por parametros.
     * 
     * @param dni          documento nacional de identidad de la persona.
     * @param nombre       nombre correspondiente de la persona.  
     * @param apellido     apellido correspondiente de la persona.  
     */
    public Persona(long dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    /**
     * Metodo que asigna un dni a un objeto.
     * 
     * @param dni dni que se asignara a un objeto.
     */
    // set
    public void setDni(long dni) {
        this.dni = dni;
    }

    /**
     * Metodo que asigna un nombre a un objeto.
     * 
     * @param nombre nombre que se asignara a un objeto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que asigna un apellido a un objeto.
     * 
     * @param apellido apellido que se asignara a un objeto.
     */
    public void setApellido(String apeliido) {
        this.apellido = apeliido;
    }

    // gett

    /**
     * Metodo que retorna el dni del objeto.
     *
     * @return dni del objeto asociado.
     */
    public long getDni() {
        return dni;
    }

    /**
     * Metodo que retorna el nombre del objeto.
     *
     * @return nombre del objeto asociado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que retorna el apellido del objeto.
     *
     * @return apellido del objeto asociado.
     */
    public String getApellido() {
        return apellido;
    }

}