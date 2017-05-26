/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.admin;

import java.util.Date;

/**
 *
 * @author Alex
 */
public class Dispositivo {
    private int idDispositivo;
    private String nombre;
    private Date fecha;

    public Dispositivo() {}
    
    public Dispositivo(int idDispositivo, String nombre, Date fecha) {
        this.idDispositivo = idDispositivo;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public int getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(int idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
