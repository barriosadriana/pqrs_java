package modelo.proyectodeaula.Controladores;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.proyectodeaula.Clases.usuario;
import modelo.proyectodeaula.datos.data;
import static modelo.proyectodeaula.menus.menuAdministrador.MenuAdministrador;
import static modelo.proyectodeaula.menus.menuFuncionario.MenuFuncionario;
import static modelo.proyectodeaula.menus.menuUsuario.MenuUsuario;

public class control_Usuario {

    public static ArrayList<usuario> Usuarios = new ArrayList();

    public static void RegistrarUsuario() {
        Scanner teclado = new Scanner(System.in);
        usuario persona = new usuario();
        
        usuario persona1 = new usuario();
        persona1.setNombre("juan");
        persona1.setApellido("cabarcas");
        persona1.setTipodeidentificacion("cc");
        persona1.setNumerodeidentificacion(100001);
        persona1.setContraseña("juan1");
        persona1.setId(01);
        persona1.setRol("administrador");
        Usuarios.add(persona1);
        
        System.out.println("\n ----   Registro De Usuario ----\n");
        System.out.print("Ingrese su nombre: ");
        String nombre = teclado.nextLine();
        persona.setNombre(nombre);
        System.out.print("Ingrese su apellido: ");
        String apellido = teclado.nextLine();
        persona.setApellido(apellido);
        System.out.print("Ingrese su tipo de identificacion: ");
        String tipodeidentificacion = teclado.nextLine();
        persona.setTipodeidentificacion(tipodeidentificacion);
        System.out.print("Ingrese su numero de identificacion: ");
        int numerodeidentificacion = teclado.nextInt();
        teclado.nextLine();
        persona.setNumerodeidentificacion(numerodeidentificacion);
        System.out.print("Ingrese una contraseña: ");
        String contraseña = teclado.nextLine();
        persona.setContraseña(contraseña);
        int random = (int) (Math.random() * 99 + 1);
        persona.setId(random);
        persona.setRol("ciudadano");
        Usuarios.add(persona);
        System.out.print("\n");
        System.out.print("**** Usuario Registrado ****\n"
                + "\nSu usuario es: " + persona.getId() + "\n"
                + "Su Contraseña es: " + persona.getContraseña() + "\n\n");

    }

    public static void validarUsuario(int usuario, String contraseña) 
    {
        boolean credencialesCorrectas = false;
        String rol1 = "";
        
        for (usuario i : Usuarios) {
            if (i.getId() == usuario && i.getContraseña().equals(contraseña)) {
                credencialesCorrectas = true;
                rol1= i.getRol();
                data.Instanciar().setUsuarioLogueado(i);
            }
        }
        
        if (credencialesCorrectas) 
        {
            if ("ciudadano" == rol1) {
                MenuUsuario(usuario);
            }
            if ("funcionario"== rol1) {
                MenuFuncionario();
            }
            if ("administrador"== rol1) {
                MenuAdministrador();
            }
        }
        else {
            System.out.print("""

                                 ---Usuario y/o contraseña incorrecta---

                                 """);
        }
        
    }

    public static boolean validarUsuariosRegistrados() {
        if (Usuarios.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void RegistrarUsuarioAdministrador() {
        Scanner teclado = new Scanner(System.in);
        usuario persona = new usuario();

        System.out.println("\n ----   Registro De Usuario ----\n");
        System.out.print("Ingrese su nombre: ");
        String nombre = teclado.nextLine();
        persona.setNombre(nombre);
        System.out.print("Ingrese su apellido: ");
        String apellido = teclado.nextLine();
        persona.setApellido(apellido);
        System.out.print("Ingrese su tipo de identificacion: ");
        String tipodeidentificacion = teclado.nextLine();
        persona.setTipodeidentificacion(tipodeidentificacion);
        System.out.print("Ingrese su numero de identificacion: ");
        int numerodeidentificacion = teclado.nextInt();
        teclado.nextLine();
        persona.setNumerodeidentificacion(numerodeidentificacion);
        System.out.print("Ingrese una contraseña: ");
        String contraseña = teclado.nextLine();
        persona.setContraseña(contraseña);
        int random = (int) (Math.random() * 99 + 1);
        persona.setId(random);
        System.out.print("Ingrese el rol: ");
        String rol = teclado.nextLine();
        persona.setRol(rol);
        Usuarios.add(persona);
        System.out.print("\n");
        System.out.print("**** Usuario Registrado ****\n"
                + "Su usuario es: " + persona.getId() + "\n"
                + "Su Contraseña es: " + persona.getContraseña() + "\n");
    }
}
