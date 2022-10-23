package modelo.proyectodeaula.Controladores;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.proyectodeaula.Clases.Solicitud;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import modelo.proyectodeaula.datos.data;

public class Control_Solicitud {

    /**
     * metodo donde se crea el ArrayList y este mismo se retorna
     *
     * @return solicitudes
     */
    public ArrayList<Solicitud> getSolicitud() {
        ArrayList<Solicitud> solicitudes = new ArrayList<Solicitud>();
        return solicitudes;
    }

    /**
     * metodo para registrar una solicitud de un ciudadano
     */

    public void RegistroSolicitud() {
        ArrayList<Solicitud> solicitudes = this.getSolicitud();
        Scanner teclado = new Scanner(System.in);
        Solicitud objeto1 = new Solicitud();
        String fecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
                .format(Calendar.getInstance().getTime());
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
        solicitudes.add(objeto1);
        System.out.print("""
                         
                         -------------------------------------------
                         Su solicitud ha sido registrada exitosamente
                         """);
        System.out.println("Su numero de radicado es: " + random);
        System.out.println("Fecha de creacion: " + fecha);
        System.out.print("-------------------------------------------\n\n");

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
        ArrayList<Solicitud> solicitudes = this.getSolicitud();
        for (Solicitud i : solicitudes) {
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
        ArrayList<Solicitud> solicitudes = this.getSolicitud();
        if (solicitudes.size() == 0) {
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
        ArrayList<Solicitud> solicitudes = this.getSolicitud();
        for (Solicitud i : solicitudes) {
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
        ArrayList<Solicitud> solicitudes = this.getSolicitud();
        for (Solicitud i : solicitudes) {
            if (radicado == i.getRadicado()) {
                i.setEstado("resuelta");
            }
        }
    }

    /*
    metodo para decir cuantas solicitudes pendientes existen
     */
    public void reporteSolicitudesPendientes() {
        ArrayList<Solicitud> solicitudes = this.getSolicitud();
        int solicitudespendientes = 0;
        for (Solicitud i : solicitudes) {
            if (i.getEstado() == "pendiente") {
                solicitudespendientes++;
            }
            System.out.print("Las solicitudes pendientes son: " + solicitudespendientes);
        }
    }

    /*
    metodo para decir cuantas solicitudes resueltas existen
     */
    public void reporteSolicitudesResueltas() {
        ArrayList<Solicitud> solicitudes = this.getSolicitud();
        int solicitudesresueltas = 0;
        for (Solicitud i : solicitudes) {
            if (i.getEstado() == "resuelta") {
                solicitudesresueltas++;
            }
            System.out.print("Las solicitudes resueltas son: " + solicitudesresueltas);
        }
    }

    /*
    metodo para imprimir cuantas solicitudes en estado pendiente y resueltas existen.
     */
    public void reporteSolicitudesTotal() {
        ArrayList<Solicitud> solicitudes = this.getSolicitud();
        System.out.print("El total de las solicitudes son: " + solicitudes.size());

    }
}
