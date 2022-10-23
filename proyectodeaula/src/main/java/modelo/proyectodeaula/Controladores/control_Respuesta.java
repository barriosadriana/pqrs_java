package modelo.proyectodeaula.Controladores;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import modelo.proyectodeaula.Clases.Respuesta;

public class Control_Respuesta {

    /**
     * metodo para crear el ArrayList respuestas y retornar este mismo
     *
     * @return respuestas
     */
    public ArrayList<Respuesta> getRespuesta() {
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        return respuestas;
    }

    /**
     * metodo para registrar una respuesta de una solicitud
     */
    public void registroRespuesta() {
        Control_Solicitud control = new Control_Solicitud();
        ArrayList<Respuesta> respuestas = this.getRespuesta();
        Scanner teclado = new Scanner(System.in);
        String fecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        Respuesta objeto1 = new Respuesta();
        System.out.println("-------------------\n");
        System.out.print("Ingrese el numero de radicado a responder: ");
        int radicado = teclado.nextInt();
        teclado.nextLine();
        objeto1.setRadicado(radicado);
        System.out.println("\n----Ingrese su respuesta----");
        String respuesta = teclado.nextLine();
        objeto1.setRespuesta(respuesta);
        System.out.print("Ingrese el nombre del funcionario que esta respondiendo la solicitud: ");
        String funcionario = teclado.nextLine();
        objeto1.setFuncionario(funcionario);
        objeto1.setFecha(fecha);
        respuestas.add(objeto1);
        control.actualizarEstadoRespuesta(radicado);

    }

    /**
     * metodo para mostrar la respuesta deseada este metodo primero valida si
     * hay respuestas creadas requiere como parametro
     *
     * @param radicado ( el cual se digita en el menu)
     */
    public void mostrarRespuesta(int radicado) {
        ArrayList<Respuesta> respuestas = this.getRespuesta();
        if (validarRespuestas() == true) {
            System.out.print("----No hay respuestas disponibles----");
            System.out.print("\n\n");
        } else {
            for (Respuesta i : respuestas) {
                if (i.getRadicado() == radicado) {
                    System.out.print("Respuesta: " + i.getRespuesta() + "\n\n");
                }
            }
        }
    }

    /**
     * metodo para validar si el ArrayList respuestas tiene datos o no
     *
     * @return true o false dependiendo si tiene datos o no
     */
    public boolean validarRespuestas() {
        ArrayList<Respuesta> respuestas = this.getRespuesta();
        if (respuestas.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
