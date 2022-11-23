package modelo.proyectodeaula.Controladores;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import modelo.proyectodeaula.Clases.Respuesta;
import util.Cargar_ArrayList;
import static util.Validador.numerosMenu;

public class Control_Respuesta {

    /**
     * metodo para registrar una respuesta de una solicitud
     */
    public void registroRespuesta() {
        Control_Solicitud control = new Control_Solicitud();
        Control_Respuesta resp = new Control_Respuesta();
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
        Cargar_ArrayList.Respuestas.add(objeto1);
        control.actualizarEstadoRespuesta(radicado);
        resp.favorableono();

    }

    public void favorableono() {
        int opcion = 0;
        do {
            System.out.println("""
                         -----------------------------
                         Indique si es favorable o no
                         1: Si
                         2: No
                     
                         """);
            opcion = numerosMenu();
            if (opcion == 1) {
                Cargar_ArrayList.Favorable = Cargar_ArrayList.Favorable + 1;
            }
            if (opcion == 2) {
                Cargar_ArrayList.Nofavorable = Cargar_ArrayList.Nofavorable + 1;
            }
        } while (opcion != 1 && opcion != 2);

    }

    /**
     * metodo para mostrar la respuesta deseada este metodo primero valida si
     * hay respuestas creadas requiere como parametro
     *
     * @param radicado ( el cual se digita en el menu)
     */
    public void mostrarRespuesta(int radicado) {
        if (validarRespuestas() == true) {
            System.out.println("***** No hay respuestas disponibles *****");
            System.out.println("==========================================\n");
        } else {
            for (Respuesta i : Cargar_ArrayList.Respuestas) {
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
        if (Cargar_ArrayList.Respuestas.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
