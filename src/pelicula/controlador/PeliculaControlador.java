/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pelicula.controlador;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import pelicula.modelo.Productora;
import pelicula.vista.PeliculaVista;

/**
 *
 * @author borisperezg
 */
public class PeliculaControlador {
    
    private Productora negocio;
    private PeliculaVista frame;
    
    public PeliculaControlador(PeliculaVista frame){
        negocio = new Productora();
        this.frame = frame;
    }
    
    public void agregarPersona(){
        String nombre = frame.getTxtNombrePersona().getText();
        String apellido = frame.getTxtApellido().getText();
        String fechaNacimiento = frame.getTxtFechaNacimiento().getText();
        String nacionalidad = frame.getCmbPaisNacimiento().getSelectedItem().toString();
        
        negocio.agregarPersona(nombre, apellido, fechaNacimiento, nacionalidad);
        
        limpiarCamposPersona();
        alimentarCombos(nombre, apellido);
    }
    
    public void cancelarPersona(){
        limpiarCamposPersona();
    }
    
    private void limpiarCamposPersona(){
        frame.getTxtNombrePersona().setText("");
        frame.getTxtApellido().setText("");
        frame.getTxtFechaNacimiento().setText("");                        
    }
    
    private void limpiarCamposPelicula(){
        frame.getTxtTitulo().setText("");
        frame.getTxtAnio().setText("");
        frame.getTaSinopsis().setText("");                        
    }
    
    private void bloquearCamposPelicula(){
        frame.getTxtTitulo().setEditable(false);
        frame.getTxtAnio().setEditable(false);
        frame.getTaSinopsis().setEditable(false);
        frame.getCmbPaisPelicula().setEnabled(false);
        frame.getCmbGenero().setEnabled(false);
        
        frame.getTxtTitulo().setBackground(new java.awt.Color(255, 255, 204));
        frame.getTxtAnio().setBackground(new java.awt.Color(255, 255, 204));
        frame.getTaSinopsis().setBackground(new java.awt.Color(255, 255, 204));
    }
    
    private void alimentarCombos(String nombre, String apellido){
        
        /*
        Importante, en realidad no deberían llenarse los combos de esta manera.
        La manera correcta sería solicitándole al negocio que retorne la lista
        de personas. Es decir, invocando el método listarPersonas().
        
        Adicionalmente, solo se deberían listar las personas que no estén ya seleccionados.
        Por ejemplo, si Pedro es actor, no debería salir nuevamente en el 
        combo de Actores. 
        
        Estas dos cosas deberían realizarlas los estudiantes.
        */
        
        DefaultComboBoxModel<String> modelo = (DefaultComboBoxModel<String>)frame.getCmbActor().getModel();
        modelo.addElement(nombre + " " + apellido);
        
        modelo = (DefaultComboBoxModel<String>)frame.getCmbDirector().getModel();
        modelo.addElement(nombre + " " + apellido);
        
        modelo = (DefaultComboBoxModel<String>)frame.getCmbGuionista().getModel();
        modelo.addElement(nombre + " " + apellido);
        
        modelo = (DefaultComboBoxModel<String>)frame.getCmbProductor().getModel();
        modelo.addElement(nombre + " " + apellido);
               
    }
    
    public void agregarActor(){
        
        boolean peliculaRegistrada = negocio.existePelicula();
        
        if(!peliculaRegistrada)
            JOptionPane.showMessageDialog(frame, "Primero debe registrar la película");
        else{
            String nombreCompleto = frame.getCmbActor().getModel().getSelectedItem().toString();
            negocio.agregarActor(nombreCompleto);
            
            // Se llena la lista de actores
            DefaultListModel model = (DefaultListModel)frame.getLstActores().getModel();
            model.removeAllElements();
            
            ArrayList<String> listaActores = negocio.obtenerListaActores();
            model.addAll(listaActores);
        }
    }
    
    public void agregarDirector(){
        
        boolean peliculaRegistrada = negocio.existePelicula();
        
        if(!peliculaRegistrada)
            JOptionPane.showMessageDialog(frame, "Primero debe registrar la película");
        else{
            
        }
    }
    
    public void agregarGuionista(){
        
        boolean peliculaRegistrada = negocio.existePelicula();
        
        if(!peliculaRegistrada)
            JOptionPane.showMessageDialog(frame, "Primero debe registrar la película");
        else{
            
        }
    }
    
    public void agregarProductor(){
        
        boolean peliculaRegistrada = negocio.existePelicula();
        
        if(!peliculaRegistrada)
            JOptionPane.showMessageDialog(frame, "Primero debe registrar la película");
        else{
            
        }
    }
    
    public void agregarPelicula(){
        String titulo = frame.getTxtTitulo().getText();
        String anio = frame.getTxtAnio().getText();
        String sinopsis = frame.getTaSinopsis().getText();
        String genero = frame.getCmbGenero().getSelectedItem().toString();
        String pais = frame.getCmbPaisPelicula().getSelectedItem().toString();
        
        negocio.agregarPelicula(titulo, anio, sinopsis, genero, pais);
        
        bloquearCamposPelicula();
        
    }
    
    public void cancelarPelicula(){
        limpiarCamposPelicula();
    }
}
