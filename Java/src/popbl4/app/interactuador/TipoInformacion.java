/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.interactuador;

/**
 *
 * @author Alex
 */
public class TipoInformacion {
    private int idTipoInformacion;
    private String tipo;
    private int idInformacion;

    public TipoInformacion() {}
    
    public TipoInformacion(int idTipoInformacion, String tipo, int idInformacion) {
        this.idTipoInformacion = idTipoInformacion;
        this.tipo = tipo;
        this.idInformacion = idInformacion;
    }

    public int getIdTipoInformacion() {
        return idTipoInformacion;
    }

    public void setIdTipoInformacion(int idTipoInformacion) {
        this.idTipoInformacion = idTipoInformacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdInformacion() {
        return idInformacion;
    }

    public void setIdInformacion(int idInformacion) {
        this.idInformacion = idInformacion;
    }
}
