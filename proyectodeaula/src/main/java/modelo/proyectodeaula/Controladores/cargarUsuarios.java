package modelo.proyectodeaula.Controladores;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import modelo.proyectodeaula.Clases.usuario;
import static modelo.proyectodeaula.Controladores.control_Usuario.Usuarios;

public class cargarUsuarios {

    public static void cargarUsuarios() {
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

                usuario persona = new usuario();
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                persona.setTipodeidentificacion(tipodeidentificacion);
                persona.setNumerodeidentificacion(numerodeidentificacion);
                persona.setId(id);
                persona.setRol(rol);
                persona.setContraseña(contraseña);

                Usuarios.add(persona);

            }

        } catch (FileNotFoundException ex) {
            System.out.println("Ocurrio un error al leer archivo");
        }
    }
}
