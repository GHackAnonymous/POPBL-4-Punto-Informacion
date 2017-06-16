/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.sinInteraccion;

import java.util.List;

/**
 *
 * @author GHackAnonymous
 */
public class Gastronomia extends Anuncio{
    private int id_gastronomia;
    private Menu menu;
    private int id_anuncios;
    private String titulo;

    public Gastronomia() {}

    public Gastronomia(int id_gastronomia, Menu menu, int id_anuncios, 
            String descripcion, String fecha, String titulo, 
            String URL, String Ubicacion, String contacto, String horarios) {
        
        super(id_anuncios, descripcion, fecha, titulo, URL, Ubicacion, contacto, 
                horarios);
        
        this.id_gastronomia = id_gastronomia;
        this.menu = menu;
        this.id_anuncios = id_anuncios;
        this.titulo = titulo;
    }
    
    public int getId_gastronomia() {
        return id_gastronomia;
    }

    public void setId_gastronomia(int id_gastronomia) {
        this.id_gastronomia = id_gastronomia;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getId_anuncios() {
        return id_anuncios;
    }

    public void setId_anuncios(int id_anuncios) {
        this.id_anuncios = id_anuncios;
    }

    @Override
    public String toString() {
        return "Gastronomia: " + id_gastronomia +   "-" + titulo ;
    }
    
    
}
