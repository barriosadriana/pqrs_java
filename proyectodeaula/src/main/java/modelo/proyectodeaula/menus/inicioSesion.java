
package modelo.proyectodeaula.menus;

import java.util.Scanner;
import static modelo.proyectodeaula.Controladores.control_Usuario.validarUsuario;
import static modelo.proyectodeaula.Controladores.control_Usuario.validarUsuariosRegistrados;

public class inicioSesion {
    public static void iniciosesion(){
        Scanner teclado = new Scanner(System.in);
        int usuario=0;
        String contraseña="";
        if (!validarUsuariosRegistrados()) {
            System.out.println("\n----  Login   ----\n");
            System.out.print("Ingrese su usuario: ");
            usuario = teclado.nextInt();teclado.nextLine();
            System.out.print("Ingrese su contraseña: ");
            contraseña= teclado.nextLine();
            System.out.print("\n\n");
            validarUsuario(usuario,contraseña);
        }
        else{
            System.out.print("""
                             
                                ----- No se encuentran usuarios registrados----
                                -----    por favor cree su usuario    ---------
                             
                             
                             """);
        }
    }    
}
