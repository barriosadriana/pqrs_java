/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.proyectodeaula.datos;
import modelo.proyectodeaula.Clases.usuario;

/**
 *
 * @author Pc Master
 */
public class data {
    
    public usuario usuarioLogueado;
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

    public usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public void setUsuarioLogueado(usuario usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }
}
