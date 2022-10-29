package modelo.proyectodeaula.menus;

import OpcionesMenus.Opciones_Menu_Administrador;
import java.util.Scanner;
import modelo.proyectodeaula.Clases.Usuario;

public class MenuAdministrador {

    public static void MenuAdministrador(Usuario usuario) {
        Opciones_Menu_Administrador menu = new Opciones_Menu_Administrador();
        Scanner teclado = new Scanner(System.in);
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
            System.out.print("Ingrese la opcion: ");
            opcion = teclado.nextInt();
            menu.opcionesAdministrador(opcion);
        }while(opcion !=4);
    }
}


