package OpcionesMenus;

import Registro.RegistroUsuario;
import modelo.proyectodeaula.Clases.Usuario;
import modelo.proyectodeaula.Controladores.UsuarioController;
import modelo.proyectodeaula.menus.MenuInicioSesion;

public class Opciones_Menu_Principal {

    public void opcionesMenuPrincipal(int opcion) {
        RegistroUsuario opc = new RegistroUsuario();
        UsuarioController user = new UsuarioController();

        switch (opcion) {
            case 1:
                Usuario user2 = opc.registerUsuario();
                user.registrarUsuario(user2);
                break;

            case 2:
                MenuInicioSesion.iniciosesion();
                break;
            case 3:
                System.out.println("Finalizado Con Exito");
                break;
            default:
                System.out.println("Opcion invalida");
                break;

        }
    }

}
