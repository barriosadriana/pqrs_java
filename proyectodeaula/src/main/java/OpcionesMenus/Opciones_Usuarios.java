package OpcionesMenus;

import Registro.Registro_Solicitudes;
import modelo.proyectodeaula.Clases.Solicitud;
import modelo.proyectodeaula.Controladores.Control_Solicitud;

public class Opciones_Usuarios {

    public void opcionesUsuario(int opcion) {
        Registro_Solicitudes register = new Registro_Solicitudes();
        Control_Solicitud control = new Control_Solicitud();
        switch (opcion) {
            case 1:
                Solicitud Solicitud = register.RegistroSolicitud();
                control.addSolicitudes(Solicitud);
                break;
            case 2:
                control.consultarSolicitud(opcion);
                break;
            case 3:
                System.out.println("===============================");
                System.out.println("**** Finalizado con exito ****");
                System.out.println("===============================");
                break;
            default:
                System.out.println("===========================");
                System.out.println("***** Opcion invalida *****");
                System.out.println("===========================");
                break;
        }
    }

}
