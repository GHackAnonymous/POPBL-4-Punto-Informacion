/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.modelo.interactuador;

/**
 *
 * @author Alex
 */
public class Informacion {
    
    // no deveria tenar algo mas como la descripcion?
    
    private int idInformacion;
    private String descripcionInformacion;
    private String fotoInformacion;

    public Informacion() {}
    
    public Informacion(int idInformacion) {
        this.idInformacion = idInformacion;
    }

    public int getIdInformacion() {
        return idInformacion;
    }

    public void setIdInformacion(int idInformacion) {
        this.idInformacion = idInformacion;
    }

    public String getDescripcionInformacion() {
        return descripcionInformacion;
    }

    public void setDescripcionInformacion(String descripcionInformacion) {
        this.descripcionInformacion = descripcionInformacion;
    }

    public String getFotoInformacion() {
        return fotoInformacion;
    }

    public void setFotoInformacion(String fotoInformacion) {
        this.fotoInformacion = fotoInformacion;
    }
    
}
