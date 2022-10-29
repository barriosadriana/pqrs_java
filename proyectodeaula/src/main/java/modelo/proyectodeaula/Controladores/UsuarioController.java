package modelo.proyectodeaula.Controladores;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.proyectodeaula.Clases.Usuario;
import modelo.proyectodeaula.menus.MenuAdministrador;
import modelo.proyectodeaula.menus.MenuFuncionario;
import modelo.proyectodeaula.menus.MenuUsuario;
import util.Cargar_ArrayList;
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

        ArrayList<Usuario> usuarios = Cargar_ArrayList.Usuarios;
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

    /**
     * Metodo para registrar un usuario.
     */
    public void registrarUsuario(Usuario user) {
        ArrayList<Usuario> usuarios = Cargar_ArrayList.Usuarios;
        usuarios.add(user);
    }

    /**
     * Metodo para validar las credenciales del usuario y dependiendo del tipo
     * de usuario se le desplega el tipo de menu que requiere.Se requiere como
     * parametro
     *
     *
     * @param usuario usuario (el id del usuario con el cual inicia sesion)
     * @param contraseña contraseña ( la contraseña registrada en el sistema)
     */
    public static void validarUsuario(int usuario, String contraseña) {
        boolean credencialesCorrectas = false;
        String rol1 = "";
        UsuarioController controlador = new UsuarioController();
        Usuario currentUser = controlador.buscarUsuario(usuario, contraseña);
        if (currentUser != null) {
            credencialesCorrectas = true;
            Cargar_ArrayList.CurrentUser = currentUser;
        }
        if (credencialesCorrectas == true) {
            if ("ciudadano".equals(currentUser.getRol())) {
                MenuUsuario.ShowMenuUsuario(Cargar_ArrayList.CurrentUser);
            }
            if ("funcionario".equals(currentUser.getRol())) {
                MenuFuncionario.MenuFuncionario(Cargar_ArrayList.CurrentUser);
            }
            if ("administrador".equals(currentUser.getRol())) {
                MenuAdministrador.MenuAdministrador(Cargar_ArrayList.CurrentUser);
            }

        } else {
            System.out.print("""

                                 ---Usuario y/o contraseña incorrecta---

                                 """);
        }

    }

    /**
     * metodo para validar si el ArrayList de usuarios se encuentra vacio o con
     * datos Si esta vacio retorna un True Si tiene datos retorna un False
     */
    public static boolean validarUsuariosRegistrados() {
        UsuarioController controlador = new UsuarioController();

        if (controlador.getUsuarios().size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void consultarSolicitudes() {
        Control_Solicitud control = new Control_Solicitud();
        if (control.validarSolicitudes() == true) {
            System.out.print("\nNo hay solicitudes registradas");
            System.out.print("\n");
        } else {
            control.mostrarSolicitudes();
        }
    }
        /**
         * metodo para listar los usuarios registrados retorna los valores
         * guardados en el ArrayList usuario
         */
        public void usuarios_Registrados() {
        UsuarioController userController = new UsuarioController();
        int index = 1;
        for (Usuario i : userController.getUsuarios()) {
            System.out.println((index++) + ": " + i.getNombre() + " " + i.getApellido() + " "
                    + i.getTipodeidentificacion() + " "
                    + i.getNumerodeidentificacion() + " " + i.getContraseña() + " "
                    + i.getRol() + " " + i.getId());

        }
    }

    /**
     * metodo para mostrar las solicitudes registradas este primero verifica si
     * el ArrayList de solicitudes este vacio o tiene datos si esta vacia
     * imprime que no hay solicitudes registradas si tiene datos muestra las
     * solicitudes pendientes
     *
     *
     * requiere como parametro
     *
     * @param opcion (la cual se digita en el menu)
     */
    public void mostrarSolicitudes(int opcion) {
        Control_Solicitud control = new Control_Solicitud();
        if (control.validarSolicitudes() == true) {
            System.out.print("\nNo hay solicitudes registradas");
            System.out.print("\n");
        } else {
            control.mostrarSolicitudes();
        }
    }

    /**
     * metodo para responder las solicitudes pendientes este primero verifica si
     * el ArrayList de solicitudes este vacio o tiene datos si esta vacia
     * imprime que no hay solicitudes registradas si tiene datos ejecuta el
     * metodo de registrar la respuesta
     *
     * requiere como parametro
     *
     * @param opcion (la cual se digita en el menu)
     */
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

    /**
     * metodo para mostrar menu de Reportes deoendiendo de la opcion que escogas
     * te imprimira el reporte que solicitas
     *
     * requiere como parametro
     *
     * @param opcion (la cual se digita en el menu)
     */
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
