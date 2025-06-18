/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author Gaston PC
 */
import java.util.*;
import Modelo.Ciudad;
import Modelo.EnumProvincia;

public class Ctrl_Ciudad {
     private ArrayList<Ciudad> ciudades = new ArrayList<>();
     
     public void registrarCiudad(Scanner sc){
         System.out.print("Ingrese el nombre de la ciudad: ");
         String nombre = sc.nextLine();
         
         System.out.println("Seleccione la provincia:");
         EnumProvincia [] provincias = EnumProvincia.values();
         
         for(int i = 0; i < provincias.length; i++){
             System.out.println(i+1 + "-" + provincias[i]);
         }
         
         int seleccion = sc.nextInt();
         sc.nextLine();
         
         EnumProvincia provincia = provincias[seleccion -1];
         
         
          Ciudad ciudad = new Ciudad(nombre, provincia);
          ciudades.add(ciudad);
          System.out.println("Ciudad agregada correctamente.");
         
     }
        public ArrayList<Ciudad> getCiudades() {
        return ciudades;
          }
     
     
     
}
