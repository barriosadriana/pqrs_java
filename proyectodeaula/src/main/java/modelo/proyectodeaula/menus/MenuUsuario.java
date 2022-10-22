package modelo.proyectodeaula.menus;

import java.util.Scanner;
import modelo.proyectodeaula.Controladores.Control_Solicitud;

public class MenuUsuario {

    public static void MenuUsuario(int usuario) {
        Control_Solicitud control = new Control_Solicitud();
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
            switch (opcion) {
                case 1 ->
                    control.RegistroSolicitud();
                case 2 ->
                    control.consultarSolicitud(opcion);
                case 3 ->
                    System.out.print("Finalizado con exito");
                default ->
                    System.out.print("----Opcion Incorrecta----");
            }
            opcion=0;
        }
    }
}
