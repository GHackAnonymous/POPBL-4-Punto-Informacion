/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.modelo.anuncios;

/**
 *
 * @author GHackAnonymous
 */
public class Menu {
    
    private int id_menu;
    private String nombre;
    private String ingedientes;
    private String precio;

    public Menu() {}
    
    public Menu(int id_menu, String nombre, String ingedientes, String precio) {
        this.id_menu = id_menu;
        this.nombre = nombre;
        this.ingedientes = ingedientes;
        this.precio = precio;
    }

    public int getId_menu() {
        return id_menu;
    }

    public void setId_menu(int id_menu) {
        this.id_menu = id_menu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIngedientes() {
        return ingedientes;
    }

    public void setIngedientes(String ingedientes) {
        this.ingedientes = ingedientes;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Menu{" + "id_menu=" + id_menu + ", nombre=" + nombre + 
                ", ingedientes=" + ingedientes + ", precio=" + precio + '}';
    }
}
