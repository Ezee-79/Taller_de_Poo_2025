/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 * Excepción personalizada utilizada para indicar errores en la validación de ingreso de datos.
 * <p>
 * Esta excepción se lanza cuando el usuario ingresa datos inválidos,
 * como caracteres no permitidos, campos vacíos o formatos incorrectos.
 * </p>
 * 
 * @author Gaston. 
 * @author Denis.
 * @author Enzo.
 */
public class IngresoInvalidoExcepcion extends Exception {
    private String mensaje;

      /**
     * Constructor que recibe un mensaje descriptivo del error.
     * 
     * @param mensaje mensaje de error personalizado.
     */
    public IngresoInvalidoExcepcion(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Devuelve el mensaje de error asociado a esta excepción.
     * 
     * @return mensaje de error.
     */
    public String getMensaje() {
        return mensaje;
    }
}
