package OpcionesMenus;

import Registro.Registro_Usuario_Administrador;
import modelo.proyectodeaula.Clases.Usuario;
import modelo.proyectodeaula.Controladores.UsuarioController;
import modelo.proyectodeaula.menus.MenuReportes;

public class Opciones_Menu_Administrador {

    public void opcionesAdministrador(int opcion) {
        Registro_Usuario_Administrador register = new Registro_Usuario_Administrador();
        MenuReportes menu = new MenuReportes();
        UsuarioController user = new UsuarioController();
        switch (opcion) {
            case 1:
                Usuario usuario2 = register.RegistrarUsuarioAdministrador();
                user.registrarUsuario(usuario2);
                break;
            case 2:
                user.consultarSolicitudes();
                break;
            case 3:
                menu.reportes();
                break;
            case 4:
                System.out.println("----Finalizado con exito----");
                break;
        }
    }
}
