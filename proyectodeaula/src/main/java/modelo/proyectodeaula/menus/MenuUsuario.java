package modelo.proyectodeaula.menus;

import OpcionesMenus.Opciones_Usuarios;
import modelo.proyectodeaula.Clases.Usuario;
import util.Validador;

public class MenuUsuario {
    
    public static int ShowMenuUsuario(Usuario usuario) {
        int opcion = 0;
        Opciones_Usuarios opcionmenu = new Opciones_Usuarios();
        
        do {
            System.out.print("""
                               *************************
                             
                                         MENU 
                             
                               """);
            System.out.println("Bienvenido " + usuario.getNombre() + " "
                    + usuario.getApellido());
            System.out.println("Indique que desea hacer:  \n");
            System.out.println("""                           
                           1: Registrar Solicitud
                           2: Consultar Solicitud
                           3: Salir
                               
                           *************************\n""");
            opcion = Validador.numerosMenu();
            opcionmenu.opcionesUsuario(opcion);
        } while (opcion != 3);
        return opcion;
    }
}
