package modelo.proyectodeaula.menus;

import java.util.Scanner;
import modelo.proyectodeaula.Controladores.UsuarioController;

public class MenuPrincipal {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        UsuarioController user = new UsuarioController();
        int opcion = 0;
        do{
            System.out.println("""
                           ***********************
                           ---- Menu Principal ----
                           1: Registrar Usuario
                           2: Iniciar   Seccion
                           3: Salir
                           ***********************\n""");
            System.out.print("Ingrese su opcion: ");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1 ->
                    user.registerUsuario();
                case 2 ->
                    MenuInicioSesion.iniciosesion();
                case 3 ->
                    System.out.println("Finalizado Con Exito");
                default ->
                    System.out.println("Opcion invalida");}
        }while(opcion >3);
    }
}
