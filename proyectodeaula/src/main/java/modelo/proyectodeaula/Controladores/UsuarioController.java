package modelo.proyectodeaula.Controladores;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.proyectodeaula.Clases.Usuario;
import modelo.proyectodeaula.datos.data;
import modelo.proyectodeaula.menus.MenuAdministrador;
import modelo.proyectodeaula.menus.MenuFuncionario;
import modelo.proyectodeaula.menus.MenuUsuario;
import util.ConfigurationHelper;

/**
 *
 * @author ronald.cuello
 */
public class UsuarioController {

    /**
     * Metodo para buscar un usuario en la base de datos.
     *
     *
     * @param userId Id del usuario
     * @param password Contraseña del usuario
     *
     * @return objeto Usuario persistido en el archivo plano
     */
    public Usuario buscarUsuario(int userId, String password) {

        ArrayList<Usuario> usuarios = this.getUsuarios();
        for (Usuario user : usuarios) {
            if (user.getId() == userId && user.getContraseña().equals(password)) {
                return user;
            }
        }

        //Usuario no encontrado
        return null;
    }

    /**
     * Metodo para listar todos los usuarios de un archivo plano
     *
     *
     *
     * @return Lista de los usuarios
     */
    public ArrayList<Usuario> getUsuarios() {
        //TODO: Investigue que son los Generics en java
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            File archivo = new File(ConfigurationHelper.UsuarioPath);
            Scanner scanner = new Scanner(archivo);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();

                String[] usuarios_creados = linea.split(",");
                String nombre = usuarios_creados[0];
                String apellido = usuarios_creados[1];
                String tipodeidentificacion = usuarios_creados[2];
                int numerodeidentificacion = Integer.parseInt(usuarios_creados[3]);
                int id = Integer.parseInt(usuarios_creados[4]);
                String rol = usuarios_creados[5];
                String contraseña = usuarios_creados[6];

                Usuario user = new Usuario();
                user.setNombre(nombre);
                user.setApellido(apellido);
                user.setTipodeidentificacion(tipodeidentificacion);
                user.setNumerodeidentificacion(numerodeidentificacion);
                user.setId(id);
                user.setRol(rol);
                user.setContraseña(contraseña);

                usuarios.add(user);

            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
        return usuarios;
    }

    public void registerUsuario() {
        ArrayList<Usuario> usuarios = this.getUsuarios();
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
        System.out.print("Ingrese su numero de identificacion: ");
        int numerodeidentificacion = teclado.nextInt();
        teclado.nextLine();
        user.setNumerodeidentificacion(numerodeidentificacion);
        System.out.print("Ingrese una contraseña: ");
        String contraseña = teclado.nextLine();
        user.setContraseña(contraseña);
        int random = (int) (Math.random() * 99 + 1);
        user.setId(random);
        user.setRol("ciudadano");
        usuarios.add(user);
        System.out.print("\n");
        System.out.print("**** Usuario Registrado ****\n"
                + "\nSu usuario es: " + user.getId() + "\n"
                + "Su Contraseña es: " + user.getContraseña() + "\n\n");
    }

    public static void validarUsuario(int usuario, String contraseña) {
        boolean credencialesCorrectas = false;
        String rol1 = "";
        UsuarioController controlador = new UsuarioController();
        Usuario currentUser = controlador.buscarUsuario(usuario, contraseña);
        if (currentUser != null) {
            credencialesCorrectas = true;
            rol1 = currentUser.getRol();
            data.Instanciar().setUsuarioLogueado(currentUser);
        }
        if (credencialesCorrectas == true) {
            if ("ciudadano".equals(rol1)) {
                MenuUsuario.MenuUsuario(usuario);
            }
            if ("funcionario".equals(rol1)) {
                MenuFuncionario.MenuFuncionario();
            }
            if ("administrador".equals(rol1)) {
                MenuAdministrador.MenuAdministrador();
            }
        } else {
            System.out.print("""

                                 ---Usuario y/o contraseña incorrecta---

                                 """);
        }

    }

    public static boolean validarUsuariosRegistrados() {
        UsuarioController controlador = new UsuarioController();

        if (controlador.getUsuarios().size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void RegistrarUsuarioAdministrador() {
        ArrayList<Usuario> usuarios = this.getUsuarios();
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
        int numerodeidentificacion = teclado.nextInt();
        teclado.nextLine();
        user.setNumerodeidentificacion(numerodeidentificacion);
        System.out.print("Ingrese una contraseña: ");
        String contraseña = teclado.nextLine();
        user.setContraseña(contraseña);
        int random = (int) (Math.random() * 99 + 1);
        user.setId(random);
        System.out.print("Ingrese el rol: ");
        String rol = teclado.nextLine();
        user.setRol(rol);
        usuarios.add(user);
        System.out.print("\n");
        System.out.print("**** Usuario Registrado ****\n"
                + "Su usuario es: " + user.getId() + "\n"
                + "Su Contraseña es: " + user.getContraseña() + "\n");
    }

    public static void usuarios_Registrados() {
        UsuarioController userController = new UsuarioController();
        int index = 1;
        for (Usuario i : userController.getUsuarios()) {
            System.out.println((index++) + ": " + i.getNombre() + " " + i.getApellido() + " "
                    + i.getTipodeidentificacion() + " "
                    + i.getNumerodeidentificacion() + " " + i.getContraseña() + " "
                    + i.getRol() + " " + i.getId());

        }
    }

    public void mostrarSolicitudes(int opcion) {
        Control_Solicitud control = new Control_Solicitud();
        if (control.validarSolicitudes() == true) {
            System.out.print("\nNo hay solicitudes registradas");
            System.out.print("\n");
        } else {
            control.consultarSolicitudes();
        }
    }

    public void responderSolicitudes(int opcion) {
        Control_Solicitud control = new Control_Solicitud();
        Control_Respuesta resp = new Control_Respuesta();
        if (control.validarSolicitudes() == true) {
            System.out.print("\nNo hay solicitudes registradas");
            System.out.print("\n");
        } else {
            resp.registroRespuesta();
        }
    }

    public void mostrarReportes(int opcion) {
        Control_Solicitud control = new Control_Solicitud();
        Scanner teclado = new Scanner(System.in);
        if (opcion == 3) {
            System.out.print("""
                               ------Indique que reporte desea------
                             
                             1: Numero total de solicitudes pendientes.
                             2: Numero total de solicitudes resueltas.
                             3: Numero total de solicitudes ingresadas al sistema.
                             
                             """);
            System.out.print("Opcion: ");
            int opciones = teclado.nextInt();
            switch (opciones) {
                case 1 ->
                    control.reporteSolicitudesPendientes();
                case 2 ->
                    control.reporteSolicitudesResueltas();
                case 3 ->
                    control.reporteSolicitudesTotal();
                default ->
                    System.out.print("----Opcion incorrecta----");
            }
        }
    }
}
