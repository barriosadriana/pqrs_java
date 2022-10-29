package OpcionesMenus;

import modelo.proyectodeaula.Controladores.Control_Solicitud;

public class Opciones_Reportes {

    public void opcionesReportes(int opcion) {
        Control_Solicitud control = new Control_Solicitud();
        switch (opcion) {
            case 1:
                control.reporteSolicitudesPendientes();
                break;
            case 2:
                control.reporteSolicitudesResueltas();
                break;
            case 3:
                control.reporteSolicitudesTotal();
                break;
            case 4:
                System.out.println("-------------------------------------");
                break;
            default:
                System.out.println("----Opcion Incorrecta----");
                break;
        }
    }
}
