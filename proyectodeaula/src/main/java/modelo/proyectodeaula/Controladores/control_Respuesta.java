package modelo.proyectodeaula.Controladores;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import modelo.proyectodeaula.Clases.respuesta;
import static modelo.proyectodeaula.Controladores.control_Solicitud.actualizarEstadoRespuesta;

public class control_Respuesta {

    public static ArrayList<respuesta> Respuestas = new ArrayList();

    public static void registroRespuesta() {
        Scanner teclado = new Scanner(System.in);
        String fecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        respuesta objeto1 = new respuesta();

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
        Respuestas.add(objeto1);
        actualizarEstadoRespuesta(radicado);

    }

    public static void mostrarRespuesta(int radicado) {
        if (validarRespuestas() == true) {
            System.out.print("----No hay respuestas disponibles----");
            System.out.print("\n\n");
        } else {
            for (respuesta i : Respuestas) {
                if (i.getRadicado() == radicado) {
                    System.out.print("Respuesta: " + i.getRespuesta() + "\n\n");
                }
            }
        }
    }

    public static boolean validarRespuestas() {
        if (Respuestas.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
