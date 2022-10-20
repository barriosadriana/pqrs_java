package modelo.proyectodeaula.menus;

import java.util.Scanner;
import static modelo.proyectodeaula.Controladores.cargarUsuarios.cargarUsuarios;
import static modelo.proyectodeaula.menus.inicioSesion.iniciosesion;

public class MenuPrincipal {

    public static void main(String[] args) {
        if (cargarUsuarios() == true) {
            Scanner teclado = new Scanner(System.in);
            int opcion = 0;
            while (opcion < 3) {
                System.out.println("""
                           ***********************
                           ---- Menu Principal ----
                           1: Registrar Usuario
                           2: Iniciar   Seccion
                           3: Salir
                           ***********************\n""");
                System.out.print("Ingrese su opcion: ");
                opcion = teclado.nextInt();
                if (opcion == 1) {
                    //RegistrarUsuario();
                }
                if (opcion == 2) {
                    iniciosesion();
                } else {
                    System.out.print("""
                                     ****************************
                                     ----Finalizado con exito----
                                     ****************************""");
                }
            }
        } else {
            System.out.println("""
                               *************************************************
                               ----Ocurrio un error al leer la base de datos----
                               ----        Finalizando programa             ----
                               *************************************************
                               """);
        }
    }
}
