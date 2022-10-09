package modelo.proyectodeaula.menus;

import java.util.Scanner;
import static modelo.proyectodeaula.Controladores.control_Solicitud.RegistroSolicitud;
import static modelo.proyectodeaula.Controladores.control_Solicitud.consultarEstado;
import static modelo.proyectodeaula.Controladores.control_Solicitud.validarSolicitudes;

public class menuUsuario {

    public static void MenuUsuario(int usuario) {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        while (opcion < 3) {
            System.out.println("""
                           *************************
                                MENU CIUDADANO
                           
                           1: Registrar Solicitud
                           2: Consultar Solicitud
                           3: Salir
                           
                           *************************\n""");
            System.out.print("Ingrese su opcion: ");
            opcion = teclado.nextInt();
            if (opcion == 1) {
                RegistroSolicitud();
            }
            if (opcion == 2) {
                if (validarSolicitudes() == true) {
                    System.out.print("\nNo hay solicitudes registradas");
                    System.out.print("\n");
                } else {
                    System.out.print("Ingrese el numero de radicado: ");
                    int radicado = teclado.nextInt();
                    consultarEstado(radicado);
                }
            }
        }
    }
}
