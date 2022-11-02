
package Registro;

import java.util.Scanner;
import modelo.proyectodeaula.Clases.Usuario;
import util.Validador;

public class RegistroUsuario {
    /**
     * Metodo para registrar un usuario.
     * @return 
     */
   public Usuario registerUsuario (){
        Usuario user = new Usuario();
        Scanner teclado = new Scanner(System.in);
        System.out.println("\n ----   Registro De Usuario ----\n");
        System.out.print("Ingrese su nombre: ");
        String nombre = teclado.nextLine();
        user.setNombre(nombre);
        System.out.print("Ingrese su apellido: ");
        String apellido = teclado.nextLine();
        user.setApellido(apellido);
        System.out.print("Ingrese su tipo de identificacion: ");
        String tipodeidentificacion = teclado.nextLine();
        user.setTipodeidentificacion(tipodeidentificacion);
        String numerodeidentificacion = Validador.numeros();
        user.setNumerodeidentificacion(numerodeidentificacion);
        System.out.print("Ingrese una contraseña: ");
        String contraseña = teclado.nextLine();
        user.setContraseña(contraseña);
        int random = (int) (Math.random() * 99 + 1);
        user.setId(random);
        user.setRol("ciudadano");
        System.out.print("\n");
        System.out.print("**** Usuario Registrado ****\n"
                + "\nSu usuario es: " + user.getId() + "\n"
                + "Su Contraseña es: " + user.getContraseña() + "\n\n");
    return user;
    }
    
}
