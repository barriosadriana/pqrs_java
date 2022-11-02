package Registro;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import modelo.proyectodeaula.Clases.Solicitud;
import modelo.proyectodeaula.menus.Tipo_Solicitudes;
import util.Cargar_ArrayList;

public class Registro_Solicitudes {

    /**
     * metodo para registrar una solicitud de un ciudadano
     *
     * @return soli
     */
    public Solicitud RegistroSolicitud() {
        Tipo_Solicitudes menu = new Tipo_Solicitudes();
        Scanner teclado = new Scanner(System.in);
        Solicitud soli = new Solicitud();
        String fecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
        .format(Calendar.getInstance().getTime());
        int tiposolicitud = menu.tipo_Solicitudes();
        soli.setTiposolicitud(tiposolicitud);
        System.out.println("\n---- Descripcion de la solicitud ----\n ");
        String descripcion = teclado.nextLine();
        soli.setDescripcion(descripcion);
        soli.setEstado("pendiente");
        soli.setUsuariosolicitud(Cargar_ArrayList.CurrentUser);
        int random = (int) (Math.random() * 9999 + 1);
        soli.setRadicado(random);
        soli.setFecha(fecha);
        System.out.print("""
                         
                         -------------------------------------------
                         Su solicitud ha sido registrada exitosamente
                         """);
        System.out.println("Su numero de radicado es: " + random);
        System.out.println("Fecha de creacion: " + fecha);
        System.out.print("-------------------------------------------\n\n");
        return soli;

    }

}
