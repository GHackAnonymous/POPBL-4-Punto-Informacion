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
public class Anuncio {
    int idAnuncio;
    String descripcion;
    Date fecha;

    public Anuncio(int idAnuncio, String descripcion, Date fecha) {
        this.idAnuncio = idAnuncio;
        this.descripcion = descripcion;
        this.fecha = fecha;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
