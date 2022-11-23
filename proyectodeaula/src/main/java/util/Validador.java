package util;

import java.util.Scanner;

public class Validador {

    public static boolean isNumeric(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static String numeros() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese su numero de identificacion: ");
        String numerodeidentificacion = teclado.nextLine();
        String num = "";

        do {
            if (Validador.isNumeric(numerodeidentificacion) == true) {
                num = numerodeidentificacion;
            } else {
                System.out.println("***** Opcion invalida *****");
                System.out.print("Ingrese su numero de identificacion: ");
                numerodeidentificacion = teclado.nextLine();
                num = numerodeidentificacion;
            }
        } while (Validador.isNumeric(numerodeidentificacion) == false);
        return num;
    }

    public static int numerosMenu() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese su opcion: ");
        String opcion = teclado.nextLine();
        int opc = 0;
        do {
            if (Validador.isNumeric(opcion) == true) {
                opc = Integer.parseInt(opcion);
            } else {
                System.out.println("===========================");
                System.out.println("***** Opcion invalida *****");
                System.out.println("===========================");
                System.out.print("Ingrese una opcion valida: ");
                opcion = teclado.nextLine();
                System.out.println("===========================");
            }
        } while (Validador.isNumeric(opcion) == false);
        opc = Integer.parseInt(opcion);
        return opc;
    }

    public static int numeroIdUsuario() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese su usuario: ");
        String user = teclado.nextLine();
        int userId = 0;
        do {
            if (Validador.isNumeric(user) == true) {
                userId = Integer.parseInt(user);
            } else {
                System.out.println("===========================");
                System.out.println("***** Opcion invalida *****");
                System.out.println("===========================");
                System.out.print("Ingrese una opcion valida: ");
                user = teclado.nextLine();
                System.out.println("===========================");
            }
        } while (Validador.isNumeric(user) == false);
        userId = Integer.parseInt(user);
        return userId;
    }
}
