
package modelo.proyectodeaula.menus;

import java.util.Scanner;
import modelo.proyectodeaula.Controladores.UsuarioController;
import util.Validador;

public class MenuInicioSesion {
    public static void iniciosesion(){
        
        Scanner teclado = new Scanner(System.in);
        int usuario=0;
        String contraseña="";
        if (!UsuarioController.validarUsuariosRegistrados()) {
            System.out.println("\n----  Login   ----\n");
            usuario = Validador.numeroIdUsuario();
            System.out.print("Ingrese su contraseña: ");
            contraseña= teclado.nextLine();
            System.out.print("\n\n");
            UsuarioController.validarUsuario(usuario,contraseña);
        }
        else{
            System.out.print("""
                             
                                ----- No se encuentran usuarios registrados----
                                -----    por favor cree su usuario    ---------
                             
                             
                             """);
        }
    }    
}
