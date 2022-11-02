
package modelo.proyectodeaula.Clases;

public class Usuario {
    private String nombre;
    private String apellido;
    private String tipodeidentificacion;
    private String numerodeidentificacion;
    private int id;
    private String rol;
    private String contraseña;

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTipodeidentificacion(String tipodeidentificacion) {
        this.tipodeidentificacion = tipodeidentificacion;
    }

    public void setNumerodeidentificacion(String numerodeidentificacion) {
        this.numerodeidentificacion = numerodeidentificacion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTipodeidentificacion() {
        return tipodeidentificacion;
    }

    public String getNumerodeidentificacion() {
        return numerodeidentificacion;
    }

    public int getId() {
        return id;
    }

    public String getRol() {
        return rol;
    }
     
}
