
package util;
import java.util.ArrayList;
import modelo.proyectodeaula.Clases.Respuesta;
import modelo.proyectodeaula.Clases.Solicitud;
import modelo.proyectodeaula.Clases.Usuario;
import modelo.proyectodeaula.Controladores.UsuarioController;

public class Cargar_ArrayList {
    public static Usuario CurrentUser;
    public static int Favorable;
    public static int Nofavorable;
    public static ArrayList<Usuario> Usuarios;
    public static ArrayList<Solicitud> Solicitudes;
    public static ArrayList<Respuesta> Respuestas;
    
        public static void cargarDatos() {
        UsuarioController user = new UsuarioController();
        Cargar_ArrayList.Usuarios = user.getUsuarios();
        Cargar_ArrayList.Solicitudes= new ArrayList();
        Cargar_ArrayList.Respuestas= new ArrayList();
        Cargar_ArrayList.Favorable=0;
        Cargar_ArrayList.Nofavorable=0;
    }

    
    
}
