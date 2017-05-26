/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.admin;

/**
 *
 * @author Alex
 */
public class Administrador {
    private int idAdministrador;
    private String username, nombre, contraseña;
	
    
    public Administrador() {}
    
    public Administrador(int idAdministrador, String username, String nombre, String contraseña) {
        this.idAdministrador = idAdministrador;
        this.username = username;
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
