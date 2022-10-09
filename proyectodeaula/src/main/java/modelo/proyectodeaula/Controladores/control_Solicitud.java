package modelo.proyectodeaula.Controladores;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.proyectodeaula.Clases.solicitud;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static modelo.proyectodeaula.Controladores.control_Respuesta.mostrarRespuesta;
import modelo.proyectodeaula.datos.data;

public class control_Solicitud {

    public static ArrayList<solicitud> Solicitudes = new ArrayList();

    public static void RegistroSolicitud() {
        Scanner teclado = new Scanner(System.in);
        solicitud objeto1 = new solicitud();
        String fecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());

        System.out.println("\n ----   Registro De Solicitudes ----\n");
        System.out.print("""
                         ----Indique el tipo de solicitud----
                         
                         1: Peticion
                         2: Queja
                         3: Reclamo
                         4: Sugerencia
                         """);
        System.out.print("Opcion: ");
        int tiposolicitud = teclado.nextInt();
        teclado.nextLine();
        objeto1.setTiposolicitud(tiposolicitud);
        System.out.println("\n---- Descripcion de la solicitud ----\n ");
        String descripcion = teclado.nextLine();
        objeto1.setDescripcion(descripcion);
        objeto1.setEstado("pendiente");
        int random = (int) (Math.random() * 9999 + 1);
        objeto1.setRadicado(random);
        objeto1.setUsuariosolicitud(data.Instanciar().getUsuarioLogueado());
        objeto1.setFecha(fecha);
        Solicitudes.add(objeto1);
        System.out.print("""
                         
                         -------------------------------------------
                         Su solicitud ha sido registrada exitosamente
                         """);
        System.out.println("Su numero de radicado es: " + random);
        System.out.println("Fecha de creacion: " + fecha);
        System.out.print("-------------------------------------------\n\n");

    }

    public static void consultarEstado(int radicado) {
        for (solicitud i : Solicitudes) {
            if (i.getRadicado() == radicado) {
                System.out.println("\n\nTipo Solicitud: "
                        + tiposdesolicitud(i.getTiposolicitud())
                        + "\n" + "Descripcion: " + i.getDescripcion() + "\n"
                        + "Estado: " + i.getEstado() + "\n" + "Fecha de creacion: "
                        + i.getFecha() + "\n");
                mostrarRespuesta(i.getRadicado());
            }
        }
    }

    public static String tiposdesolicitud(int tiposolicitud) {
        if (tiposolicitud == 1) {
            return "Peticion";
        }
        if (tiposolicitud == 2) {
            return "Queja";
        }
        if (tiposolicitud == 3) {
            return "Reclamo";
        }
        if (tiposolicitud == 4) {
            return "Sugerencia";
        }
        return null;
    }

    public static boolean validarSolicitudes() {
        if (Solicitudes.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void consultarSolicitudes() {
        for (solicitud i : Solicitudes) {
            if ("pendiente".equals(i.getEstado())) {
                System.out.print(
                        "--------------------------------------------------------"
                        + "\n" + "Nombres: " + i.getUsuariosolicitud().getNombre()
                        + "\n" + "Apellidos: " + i.getUsuariosolicitud().getApellido()
                        + "\n" + "Tipo de documento: " + i.getUsuariosolicitud().getTipodeidentificacion()
                        + "\n" + "Numero de identificacion: " + i.getUsuariosolicitud().getNumerodeidentificacion()
                        + "\n" + "Tipo Solicitud: " + tiposdesolicitud(i.getTiposolicitud())
                        + "\n" + "Descripcion: " + i.getDescripcion()
                        + "\n" + "Estado: " + i.getEstado()
                        + "\n" + "# de radicado: " + i.getRadicado()
                        + "\n" + "Fecha de creacion: " + i.getFecha()
                        + "\n" + "--------------------------------------------------------\n\n");
            }
        }

    }

    public static void actualizarEstadoRespuesta(int radicado) {
        for (solicitud i : Solicitudes) {
            if (radicado == i.getRadicado()) {
                i.setEstado("resuelta");
            }
        }
    }
    public static void reporteSolicitudesPendientes(){
        int solicitudespendientes=0;
        for (solicitud i : Solicitudes){
            if(i.getEstado() == "pendiente"){
                solicitudespendientes++;
            }
            System.out.print("Las solicitudes pendientes son: "+solicitudespendientes);
        }
    }
    public static void reporteSolicitudesResueltas(){
        int solicitudesresueltas=0;
        for (solicitud i : Solicitudes){
            if(i.getEstado() == "resuelta"){
                solicitudesresueltas++;
            }
            System.out.print("Las solicitudes resueltas son: "+solicitudesresueltas);
        }
    }
    public static void reporteSolicitudesTotal(){
        System.out.print("El total de las solicitudes son: "+Solicitudes.size());
        
    }
}
