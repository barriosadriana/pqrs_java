/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Registro;

import java.util.Scanner;
import modelo.proyectodeaula.Clases.Usuario;

public class Registro_Usuario_Administrador {
     
    /**
     * metodo para registrar usuarios desde el menu administrador donde este
     * puede digitar el rol del cual pertenece el usuario
     * @return user
     */
    public Usuario RegistrarUsuarioAdministrador() {
        Scanner teclado = new Scanner(System.in);
        Usuario user = new Usuario();
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
        System.out.print("Ingrese su numero de identificacion: ");
        String numerodeidentificacion = teclado.nextLine();
        user.setNumerodeidentificacion(numerodeidentificacion);
        System.out.print("Ingrese una contraseña: ");
        String contraseña = teclado.nextLine();
        user.setContraseña(contraseña);
        int random = (int) (Math.random() * 99 + 1);
        user.setId(random);
        System.out.print("Ingrese el rol: ");
        String rol = teclado.nextLine();
        user.setRol(rol);
        System.out.print("\n");
        System.out.print("**** Usuario Registrado ****\n"
                + "Su usuario es: " + user.getId() + "\n"
                + "Su Contraseña es: " + user.getContraseña() + "\n");
        return user;
    }
}
