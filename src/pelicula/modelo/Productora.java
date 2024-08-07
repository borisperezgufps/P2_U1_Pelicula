/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pelicula.modelo;

import java.util.ArrayList;

/**
 *
 * @author borisperezg
 */
public class Productora {
    
    private Pelicula pel;
    private ArrayList<Persona> personas;

    public Productora() {
        personas = new ArrayList<Persona>();
    }
    
    public void agregarPersona(String nombre, String apellido, String anioNacimiento, String nacionalidad){
        Persona p = new Persona(nombre, apellido, anioNacimiento, nacionalidad);
        personas.add(p);
    }
    
    public ArrayList<String> listarPersonas(){
        
        ArrayList<String> retorno = new ArrayList<String>();
        
        for (Persona p : personas) {
            retorno.add(p.getNombre() + " " + p.getApellido());
        }
        
        return retorno;
    }
    
    public boolean existePelicula(){
        if(pel!=null)
            return true;
        return false;
    }

    public void agregarPelicula(String titulo, String anio, String sinopsis, String genero, String pais) {
        pel = new Pelicula(titulo, anio, sinopsis, genero, pais);
    }
    
    public void agregarActor(String nombreApellidos){
        for (Persona persona : personas) {
            String nombreCompleto = persona.getNombre() + " " + persona.getApellido();
            if(nombreCompleto.equals(nombreApellidos)){
                pel.agregarActor(persona);
                return;
            }
        }
    }
    
    public ArrayList<String> obtenerListaActores(){
        return pel.getActores();
    }
}
