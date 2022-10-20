package modelo.proyectodeaula.Controladores;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.proyectodeaula.Clases.Usuario;
import modelo.proyectodeaula.datos.data;
import modelo.proyectodeaula.menus.MenuAdministrador;
import modelo.proyectodeaula.menus.MenuFuncionario;
import modelo.proyectodeaula.menus.MenuUsuario;

public class Control_Usuario {

    public static ArrayList<Usuario> Usuarios = new ArrayList();
    
    public static void RegistrarUsuario() {
        Scanner teclado = new Scanner(System.in);
        Usuario persona = new Usuario();

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
        
        //Buscar usuarios en el archivo
        UsuarioController controlador=new UsuarioController();
        Usuario currentUser = controlador.findUsuario(usuario, contraseña);
        
        if(currentUser!=null){
            credencialesCorrectas = true;
            rol1= currentUser.getRol();
            data.Instanciar().setUsuarioLogueado(currentUser);
        }
        
        /*for (Usuario i : usuarios) {
            if (i.getId() == usuario && i.getContraseña().equals(contraseña)) {
                credencialesCorrectas = true;
                rol1= i.getRol();
                data.Instanciar().setUsuarioLogueado(i);
            }
        }*/
        
        if (credencialesCorrectas == true) 
        {
            if ("ciudadano".equals(rol1)) {
                MenuUsuario.MenuUsuario(usuario);
            }
            if ("funcionario".equals(rol1)) {
                MenuFuncionario.MenuFuncionario();
            }
            if ("administrador".equals(rol1)) {
                MenuAdministrador.MenuAdministrador();
            }
        }
        else {
            System.out.print("""

                                 ---Usuario y/o contraseña incorrecta---

                                 """);
        }
        
    }

    public static boolean validarUsuariosRegistrados() {
        UsuarioController controlador=new UsuarioController();
        
        if (controlador.getUsuarios().size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void RegistrarUsuarioAdministrador() {
        Scanner teclado = new Scanner(System.in);
        Usuario persona = new Usuario();

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
    public static void usuarios_Registrados(){
        UsuarioController userController=new UsuarioController();
        int index = 1;
        for (Usuario i : userController.getUsuarios()) {
            System.out.println((index++)+": "+i.getNombre()+" "+i.getApellido()+" " + i.getTipodeidentificacion()+" "
                    +i.getNumerodeidentificacion()+" "+i.getContraseña()+ " "+ i.getRol()+ " "+i.getId());
            
        }
    }
}
