package modelo.proyectodeaula.menus;

import OpcionesMenus.Opciones_Funcionario;
import modelo.proyectodeaula.Clases.Usuario;
import util.Validador;

public class MenuFuncionario {

    public static void MenuFuncionario(Usuario usuario) {

        Opciones_Funcionario op = new Opciones_Funcionario();
        int opcion = 0;
        do {
            System.out.print("""
                               *************************
                             
                                         MENU 
                             
                               """);
            System.out.println("Bienvenido " + usuario.getNombre() + " "
                    + usuario.getApellido());
            System.out.println("Indique que desea hacer: \n");
            System.out.println("""
                           1: Mostrar   Solicitudes Pendientes
                           2: Responder Solicitudes
                           3: Generar Reportes
                           4: Salir
                               
                           **************************\n""");
            opcion = Validador.numerosMenu();
            op.opcionesFuncionario(opcion);
            
        } while (opcion != 4);
    }
}
