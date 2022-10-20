/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.proyectodeaula.datos;
import modelo.proyectodeaula.Clases.Usuario;

/**
 *
 * @author Pc Master
 */
public class data {
    
    public Usuario usuarioLogueado;
    private static data _data;
    
    private data() {
        
    }

    public static data Instanciar() {
        if (_data == null) 
        {
            _data = new data();
            return _data;
        }
        else {
            return _data;
        }
    }

    public Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public void setUsuarioLogueado(Usuario usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }
}
