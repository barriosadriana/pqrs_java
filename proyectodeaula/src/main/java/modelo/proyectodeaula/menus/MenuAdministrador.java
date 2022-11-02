package modelo.proyectodeaula.menus;

import OpcionesMenus.Opciones_Menu_Administrador;
import modelo.proyectodeaula.Clases.Usuario;
import util.Validador;

public class MenuAdministrador {

    public static void MenuAdministrador(Usuario usuario) {
        Opciones_Menu_Administrador menu = new Opciones_Menu_Administrador();
        int opcion = 0;
        do {
            System.out.print("""
                               *************************
                                         MENU 
                               """);
            System.out.println("Bienvenido " + usuario.getNombre() + " "
                    + usuario.getApellido());
            System.out.println("Indique que desea hacer \n");
            System.out.println("""
                           ***************************
                           1: Crear Usuarios
                           2: Consultar Solicitudes
                           3: Reportes
                           4: Salir
                           ***************************""");
            opcion = Validador.numerosMenu();
            menu.opcionesAdministrador(opcion);
        }while(opcion !=4);
    }
}


