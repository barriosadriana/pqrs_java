package modelo.proyectodeaula.menus;

import OpcionesMenus.Opciones_Funcionario;
import java.util.Scanner;
import modelo.proyectodeaula.Clases.Usuario;

public class MenuFuncionario {

    public static void MenuFuncionario(Usuario usuario) {

        Scanner teclado = new Scanner(System.in);
        Opciones_Funcionario op = new Opciones_Funcionario();
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
                           **************************
                           1: Mostrar   Solicitudes
                           2: Responder Solicitudes
                           3: Generar Reportes
                           4: Salir
                           **************************""");
            System.out.print("opcion: ");
            opcion = teclado.nextInt();
            op.opcionesFuncionario(opcion);
            
        } while (opcion != 4);
    }
}
