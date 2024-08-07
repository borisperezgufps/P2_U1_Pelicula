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
class Pelicula {
    
    private String titulo; 
    private String anio; 
    private String sinopsis;
    private String genero;
    private String pais;
    
    private ArrayList<Persona> actores;

    public Pelicula(String titulo, String anio, String sinopsis, String genero, String pais) {
        this.titulo = titulo;
        this.anio = anio;
        this.sinopsis = sinopsis;
        this.genero = genero;
        this.pais = pais;
        
        actores = new ArrayList<Persona>();
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    public void agregarActor(Persona p){
        actores.add(p);
    }
    
    public ArrayList<String> getActores(){
        
        ArrayList<String> listaActores = new ArrayList<>();
        for (Persona p : actores) {
            listaActores.add(p.getNombre() + " " + p.getApellido());
        }
        return listaActores;
    }
    
}
