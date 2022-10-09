
package modelo.proyectodeaula.Clases;

public class solicitud {
    private int tiposolicitud;
    private String descripcion;
    private String estado;
    private int radicado;
    private usuario usuariosolicitud;
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

    public void setUsuariosolicitud(usuario usuariosolicitud) {
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

    public usuario getUsuariosolicitud() {
        return usuariosolicitud;
    }

    public String getFecha() {
        return fecha;
    }
    
    
}
