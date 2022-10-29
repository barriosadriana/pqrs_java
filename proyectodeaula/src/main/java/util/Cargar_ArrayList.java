
package util;
import java.util.ArrayList;
import modelo.proyectodeaula.Clases.Solicitud;
import modelo.proyectodeaula.Clases.Usuario;
import modelo.proyectodeaula.Controladores.Control_Solicitud;
import modelo.proyectodeaula.Controladores.UsuarioController;

public class Cargar_ArrayList {
    public static Usuario CurrentUser;
    public static ArrayList<Usuario> Usuarios;
    public static ArrayList<Solicitud> Solicitudes;
    
        public static void cargarDatos() {
        UsuarioController user = new UsuarioController();
        Control_Solicitud control = new Control_Solicitud();
        Cargar_ArrayList.Usuarios = user.getUsuarios();
        Cargar_ArrayList.Solicitudes = control.getSolicitud();
    }

    
    
}
