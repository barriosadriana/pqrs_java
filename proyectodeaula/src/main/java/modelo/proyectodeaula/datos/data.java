
package modelo.proyectodeaula.datos;
import modelo.proyectodeaula.Clases.Usuario;

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
