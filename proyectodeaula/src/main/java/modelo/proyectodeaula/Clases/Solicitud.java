
package modelo.proyectodeaula.Clases;

public class Solicitud {
    private int tiposolicitud;
    private String descripcion;
    private String estado;
    private int radicado;
    private Usuario usuariosolicitud;
    private String fecha;

    public void setTiposolicitud(int tiposolicitud) {
        this.tiposolicitud = tiposolicitud;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setRadicado(int radicado) {
        this.radicado = radicado;
    }

    public void setUsuariosolicitud(Usuario usuariosolicitud) {
        this.usuariosolicitud = usuariosolicitud;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTiposolicitud() {
        return tiposolicitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public int getRadicado() {
        return radicado;
    }

    public Usuario getUsuariosolicitud() {
        return usuariosolicitud;
    }

    public String getFecha() {
        return fecha;
    }
    
    
}
