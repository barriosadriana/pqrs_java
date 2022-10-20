
package modelo.proyectodeaula.Controladores;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.proyectodeaula.Clases.Usuario;
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
     * @param  userId
     *         Id del usuario
     * @param  password
     *         Contraseña del usuario
     *
     * @return  objeto Usuario persistido en el archivo plano
     */
    public Usuario findUsuario(int userId, String password){
        
        ArrayList<Usuario> usuarios= this.getUsuarios();
        for(Usuario user : usuarios){
            if(user.getId()==userId && user.getContraseña().equals(password)){
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
     * @return  Lista de los usuarios
     */
    public ArrayList<Usuario> getUsuarios() {
        //TODO: Investigue que son los Generics en java
        ArrayList<Usuario> usuarios=new ArrayList<Usuario>();
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
    
    public void saveUsuario(Usuario usuario){
        
    }
}
