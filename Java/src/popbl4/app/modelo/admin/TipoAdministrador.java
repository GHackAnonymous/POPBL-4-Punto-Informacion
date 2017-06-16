/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.modelo.admin;

/**
 *
 * @author Alex
 */
public class TipoAdministrador {
    private int idTipoAdmin;
    private String tipo;
    private int idAdmin;

    public TipoAdministrador() {}
    
    public TipoAdministrador(int idTipoAdmin, String tipo, int idAdmin) {
        this.idTipoAdmin = idTipoAdmin;
        this.tipo = tipo;
        this.idAdmin = idAdmin;
    }

    public int getIdTipoAdmin() {
        return idTipoAdmin;
    }

    public void setIdTipoAdmin(int idTipoAdmin) {
        this.idTipoAdmin = idTipoAdmin;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }
}
