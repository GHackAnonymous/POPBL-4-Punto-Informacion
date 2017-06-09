/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.sinInteraccion;

import java.util.Date;

/**
 *
 * @author Alex
 */
public abstract  class Anuncio {
    private int idAnuncio;
    private String titulo;
    private String URL_Foto;
    private String ubicacion;
    private String contacto;
    private String horarios;
    private String descripcion;
    private String fecha;

    public Anuncio() {}
    
    public Anuncio(int idAnuncio, String descripcion, String fecha, String titulo,
            String URL, String Ubicacion, String contacto, String horarios) {
        this.idAnuncio = idAnuncio;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.titulo = titulo;
        this.URL_Foto = URL;
        this.ubicacion = Ubicacion;
        this.contacto = contacto;
        this.horarios = horarios;
    }

    public int getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getURL_Foto() {
        return URL_Foto;
    }

    public void setURL_Foto(String URL_Foto) {
        this.URL_Foto = URL_Foto;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }
    
    @Override
    public String toString() {
        return "Anuncio{" + "titulo=" + titulo + ", ubicacion=" + ubicacion + 
                ", contacto=" + contacto + ", horarios=" + horarios + ", "
                + "descripcion=" + descripcion + '}';
    }
    
}
