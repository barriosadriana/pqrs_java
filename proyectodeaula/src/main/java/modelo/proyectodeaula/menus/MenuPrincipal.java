package modelo.proyectodeaula.menus;

import OpcionesMenus.Opciones_Menu_Principal;
import static util.Cargar_ArrayList.cargarDatos;
import util.Validador;

public class MenuPrincipal {
    
    public static void main(String[] args) {
        cargarDatos();
        Opciones_Menu_Principal op = new Opciones_Menu_Principal();
        int opcion = 0;
        do {
            System.out.println("""
                           ***********************
                               
                           ---- Menu Principal ----
                               
                           1: Registrar Usuario
                           2: Iniciar   Seccion
                           3: Salir
                               
                           ***********************\n""");
            opcion = Validador.numerosMenu();
            op.opcionesMenuPrincipal(opcion);
        } while (opcion != 3);
    }
}
