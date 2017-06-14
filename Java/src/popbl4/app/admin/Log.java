/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.admin;

/**
 *
 * @author GHackAnonymous
 */
public class Log {
    
    private int idLog = 0;
    private String contenido = "";
    private int idTipo = 0;
    private int idAdmin = 0;

    public Log() {}
    
    public Log(int idLog, String contenido, int idTipo, int idAdmin) {
        this.idLog = idLog;
        this.contenido = contenido;
        this.idTipo = idTipo;
        this.idAdmin = idAdmin;
    }
    
    public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    @Override
    public String toString() {
        return "Log{" + "idLog=" + idLog + ", contenido=" + contenido +
                ", idTipo=" + idTipo + ", idAdmin=" + idAdmin + '}';
    }

}
