package modelo.proyectodeaula.menus;

import OpcionesMenus.Opciones_Reportes;
import util.Validador;

public class MenuReportes {

    public void reportes() {
        Opciones_Reportes report = new Opciones_Reportes();
        int opcion =0;
        do{
            System.out.print("""
                               ------Indique que reporte desea------
                             
                             1: Numero total de solicitudes pendientes.
                             2: Numero total de solicitudes resueltas.
                             3: Numero total de solicitudes ingresadas al sistema.
                             4: Salir
                             
                             """);
        opcion = Validador.numerosMenu();
        report.opcionesReportes(opcion);
        }while(opcion !=4);
    }
}
