package modelo.proyectodeaula.menus;

import util.Validador;

public class Tipo_Solicitudes {

    public int tipo_Solicitudes() {
        int tiposolicitud = 0;
        do {
            System.out.println("\n ----   Registro De Solicitudes ----\n");
            System.out.print("""
                         ----Indique el tipo de solicitud----
                         
                         1: Peticion
                         2: Queja
                         3: Reclamo
                         4: Sugerencia
                             
                         """);
            tiposolicitud = Validador.numerosMenu();
            if(tiposolicitud != 1 && tiposolicitud != 2 && tiposolicitud != 3 && tiposolicitud != 4){
                System.out.println("===========================");
                System.out.println("***** Opcion invalida *****");
                System.out.println("===========================");
        }
        } while (tiposolicitud != 1 && tiposolicitud != 2 && tiposolicitud != 3 && tiposolicitud != 4);

        return tiposolicitud;
    }
}
