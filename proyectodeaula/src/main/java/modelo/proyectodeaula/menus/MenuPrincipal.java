package modelo.proyectodeaula.menus;

import OpcionesMenus.Opciones_Menu_Principal;
import java.util.Scanner;
import static util.Cargar_ArrayList.cargarDatos;

public class MenuPrincipal {
    
    public static void main(String[] args) {
        cargarDatos();
        Opciones_Menu_Principal op = new Opciones_Menu_Principal();
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("""
                           ***********************
                           ---- Menu Principal ----
                           1: Registrar Usuario
                           2: Iniciar   Seccion
                           3: Salir
                           ***********************\n""");
            System.out.print("Ingrese su opcion: ");
            opcion = teclado.nextInt();
            op.opcionesMenuPrincipal(opcion);
        } while (opcion != 3);
    }
}
