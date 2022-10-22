package modelo.proyectodeaula.menus;

import java.util.Scanner;
import modelo.proyectodeaula.Controladores.UsuarioController;

public class MenuFuncionario {

    public static void MenuFuncionario() {
        UsuarioController menu = new UsuarioController();
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("""
                           **************************
                           1: Mostrar   Solicitudes
                           2: Responder Solicitudes
                           3: Generar Reportes
                           4: Salir
                           **************************""");
            System.out.print("opcion: ");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1 ->
                    menu.mostrarSolicitudes(opcion);
                case 2 ->
                    menu.responderSolicitudes(opcion);
                case 3 ->
                    menu.mostrarReportes(opcion);
                case 4 ->
                    System.out.println("----Finalizado con exito----");
                default ->
                    System.out.println("----Opcion Incorrecta----");
            }

        } while (opcion < 3);
    }
}
