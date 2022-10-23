package modelo.proyectodeaula.menus;

import java.util.Scanner;
import modelo.proyectodeaula.Controladores.Control_Solicitud;
import modelo.proyectodeaula.Controladores.UsuarioController;


public class MenuAdministrador {

    public static void MenuAdministrador() {
        Control_Solicitud control = new Control_Solicitud();
        UsuarioController user = new UsuarioController();
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        while (opcion < 4) {
            System.out.println("""
                           ***************************
                           1: Crear Usuarios
                           2: Consultar Solicitudes
                           3: Reportes
                           4: Salir
                           ***************************""");
            System.out.print("Ingrese la opcion: ");
            opcion = teclado.nextInt();
            if (opcion == 1) {
                user.RegistrarUsuarioAdministrador();
            }
            if (opcion == 2) {
                if (control.validarSolicitudes() == true) {
                    System.out.print("\nNo hay solicitudes registradas");
                    System.out.print("\n");
                } else {
                    control.mostrarSolicitudes();
                }
            }
            if (opcion == 3) {
                System.out.print("""
                               ------Indique que reporte desea------
                             
                             1: Numero total de solicitudes pendientes.
                             2: Numero total de solicitudes resueltas.
                             3: Numero total de solicitudes ingresadas al sistema.
                             
                             """);
                System.out.print("Opcion: ");
                int opciones = teclado.nextInt();
                if (opciones == 1) {
                    control.reporteSolicitudesPendientes();
                }
                if (opciones == 2) {
                    control.reporteSolicitudesResueltas();
                }
                if (opciones == 3) {
                    control.reporteSolicitudesTotal();
                }
            }
        }
    }
}
