package modelo.proyectodeaula.Controladores;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import modelo.proyectodeaula.Clases.Usuario;

public class cargarUsuarios {

    public static boolean cargarUsuarios() {
        try {
            File usuarios = new File("C:\\repositorio\\pqrs_java\\proyectodeaula\\Usuarios_Creados.txt");
            Scanner scanner = new Scanner(usuarios);

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

                Usuario persona = new Usuario();
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                persona.setTipodeidentificacion(tipodeidentificacion);
                persona.setNumerodeidentificacion(numerodeidentificacion);
                persona.setId(id);
                persona.setRol(rol);
                persona.setContraseña(contraseña);

                Control_Usuario.Usuarios.add(persona);

            }

        } catch (FileNotFoundException ex) {
            return false;
        }
        return true;
    }
}
