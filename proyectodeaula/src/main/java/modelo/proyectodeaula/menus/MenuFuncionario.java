package modelo.proyectodeaula.menus;

import java.util.Scanner;
import static modelo.proyectodeaula.Controladores.control_Respuesta.registroRespuesta;
import static modelo.proyectodeaula.Controladores.control_Solicitud.consultarSolicitudes;
import static modelo.proyectodeaula.Controladores.control_Solicitud.reporteSolicitudesPendientes;
import static modelo.proyectodeaula.Controladores.control_Solicitud.reporteSolicitudesResueltas;
import static modelo.proyectodeaula.Controladores.control_Solicitud.reporteSolicitudesTotal;
import static modelo.proyectodeaula.Controladores.control_Solicitud.validarSolicitudes;

public class menuFuncionario {

    public static void MenuFuncionario() {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        while (opcion < 3) {
            System.out.println("""
                           **************************
                           1: Mostrar   Solicitudes
                           2: Responder Solicitudes
                           3: Generar Reportes
                           4: Salir
                           **************************""");
            System.out.print("opcion: ");
            opcion = teclado.nextInt();
            if (opcion == 1) {
                if (validarSolicitudes() == true) {
                    System.out.print("\nNo hay solicitudes registradas");
                    System.out.print("\n");
                } else {
                    consultarSolicitudes();
                }
            }
            if (opcion == 2) {
                if (validarSolicitudes() == true) {
                    System.out.print("\nNo hay solicitudes registradas");
                    System.out.print("\n");
                } else {
                    registroRespuesta();
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
                    reporteSolicitudesPendientes();
                }
                if (opciones == 2) {
                    reporteSolicitudesResueltas();
                }
                if (opciones == 3) {
                    reporteSolicitudesTotal();
                }
            }
        }
    }
}
