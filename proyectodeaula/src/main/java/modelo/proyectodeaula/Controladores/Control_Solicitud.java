package modelo.proyectodeaula.Controladores;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.proyectodeaula.Clases.Solicitud;
import util.Cargar_ArrayList;

public class Control_Solicitud {

    /*
    metodo para guardar Solicitudes
     */
    public void addSolicitudes(Solicitud solicitud) {
        Cargar_ArrayList.Solicitudes.add(solicitud);
    }

    /**
     * metodo para consultar el estado de la solicitud el cual les muestra todos
     * los datos de la solicitud registrada y el estado de esta misma
     *
     * requiere como parametro
     *
     * @param radicado (el numero de radicado generado cuando se registro la
     * solicitud)
     */
    public void consultarEstado(int radicado) {
        Control_Respuesta resp = new Control_Respuesta();
        for (Solicitud i : Cargar_ArrayList.Solicitudes) {
            if (i.getRadicado() == radicado) {
                System.out.println("\n\nTipo Solicitud: "
                        + tiposdesolicitud(i.getTiposolicitud())
                        + "\n" + "Descripcion: " + i.getDescripcion() + "\n"
                        + "Estado: " + i.getEstado() + "\n" + "Fecha de creacion: "
                        + i.getFecha() + "\n");
                resp.mostrarRespuesta(i.getRadicado());
            }
        }
    }

    /**
     * metodo para retornar los diferentes tipos de solicitud se requiere como
     * parametro
     *
     * @param tiposolicitud ( la cual se digita al momento de registrar la
     * solicitud)
     * @return si es peticion, queja, reclamo o sugerencia, si no es ninguna
     * retorna null
     */
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

    /**
     * metodo para verificar si el ArrayList de solicitudes tiene datos o esta
     * vacio dependiendo de esto retorna si tiene datos o no
     *
     * @return true ( si este esta vacio si tiene datos retorna un false)
     */
    public boolean validarSolicitudes() {
        if (Cargar_ArrayList.Solicitudes.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * este metodo funciona para consultar la solicitud registrada previamente
     * en el sistema primero valida si hay solicitudes registradas( si no hay
     * imprime que no hay solicitudes registradas) si tiene solicitudes
     * registradas le pide como parametro el numero de radicado para validar
     * esta misma
     *
     *
     * requiere como parametros para funcionar
     *
     * @param opcion (la cual se digita en el menu)
     */
    public void consultarSolicitud(int opcion) {
        Control_Solicitud control = new Control_Solicitud();
        Scanner teclado = new Scanner(System.in);
        if (opcion == 2) {
            if (control.validarSolicitudes() == true) {
                System.out.print("\nNo hay solicitudes registradas");
                System.out.print("\n");
            } else {
                System.out.print("Ingrese el numero de radicado: ");
                int radicado = teclado.nextInt();
                control.consultarEstado(radicado);
            }
        }
    }

    /**
     * metodo para mostrar solicitudes en estado pendiente imprime datos en
     * especificos de los ArrayList
     */
    public void mostrarSolicitudes() {
        for (Solicitud i : Cargar_ArrayList.Solicitudes) {
            if ("pendiente".equals(i.getEstado())) {
                System.out.print(
                        "--------------------------------------------------------"
                        + "\n" + "Nombres: " + i.getUsuariosolicitud().getNombre()
                        + "\n" + "Apellidos: " + i.getUsuariosolicitud().getApellido()
                        + "\n" + "Tipo de documento: "
                        + i.getUsuariosolicitud().getTipodeidentificacion()
                        + "\n" + "Numero de identificacion: "
                        + i.getUsuariosolicitud().getNumerodeidentificacion()
                        + "\n" + "Tipo Solicitud: " + tiposdesolicitud(i.getTiposolicitud())
                        + "\n" + "Descripcion: " + i.getDescripcion()
                        + "\n" + "Estado: " + i.getEstado()
                        + "\n" + "# de radicado: " + i.getRadicado()
                        + "\n" + "Fecha de creacion: " + i.getFecha()
                        + "\n" + "--------------------------------------------------------\n\n");
            }
        }

    }

    /*
    metodo para actualizar el estado de la solicitud de pendiente a resuelta
     */
    public void actualizarEstadoRespuesta(int radicado) {
        for (Solicitud i : Cargar_ArrayList.Solicitudes) {
            if (radicado == i.getRadicado()) {
                i.setEstado("resuelta");
            }
        }
    }

    /*
    metodo para decir cuantas solicitudes pendientes existen
     */
    public void reporteSolicitudesPendientes() {
        Control_Solicitud control = new Control_Solicitud();
        int solicitudespendientes = 0;
        if (control.validarSolicitudes() == true) {
            System.out.println("El total de solicitudes pendientes son 0");
        } else {
            for (Solicitud i : Cargar_ArrayList.Solicitudes) {
                if (i.getEstado() == "pendiente") {
                    solicitudespendientes++;
                }
                System.out.println("Las solicitudes pendientes son: " + solicitudespendientes);
            }
        }
    }

    /*
    metodo para decir cuantas solicitudes resueltas existen
     */
    public void reporteSolicitudesResueltas() {
        int solicitudesresueltas = 0;
        Control_Solicitud control = new Control_Solicitud();
        if (control.validarSolicitudes() == true) {
            System.out.println("El total de solicitudes resueltas son 0");
        } else {
            for (Solicitud i : Cargar_ArrayList.Solicitudes) {
                if (i.getEstado() == "resuelta") {
                    solicitudesresueltas++;
                }
                System.out.println("Las solicitudes resueltas son: " + solicitudesresueltas);
            }

        }
    }

    /*
    metodo para imprimir cuantas solicitudes en estado pendiente y resueltas existen.
     */
    public void reporteSolicitudesTotal() {
        Control_Solicitud control = new Control_Solicitud();
        if (control.validarSolicitudes() == true) {
            System.out.println("El total de solicitudes son 0");
        } else {
            System.out.println("El total de las solicitudes son: " + Cargar_ArrayList.Solicitudes.size());
        }
    }
    public void solicitudesFavorables(){
        Control_Solicitud control = new Control_Solicitud();
        if (control.validarSolicitudes() == true) {
            System.out.println("El total de solicitudes favorables son 0");}
        else{
            System.out.println("El total de solicitudes favorables son: "+Cargar_ArrayList.Favorable);
        }
    }
    public void solicitudesNoFavorables(){
        Control_Solicitud control = new Control_Solicitud();
        if (control.validarSolicitudes() == true) {
            System.out.println("El total de solicitudes No favorables son 0");}
        else{
            System.out.println("El total de solicitudes No favorables son: "+Cargar_ArrayList.Nofavorable);
        }
    }
}
