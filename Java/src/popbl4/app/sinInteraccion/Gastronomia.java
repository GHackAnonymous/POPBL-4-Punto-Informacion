/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.sinInteraccion;

/**
 *
 * @author GHackAnonymous
 */
public class Gastronomia extends Anuncio{
    private int id_gastronomia;
    private String id_menu;
    private int id_anuncios;

    public Gastronomia() {}

    public Gastronomia(int id_gastronomia, String id_menu, int id_anuncios, 
            String descripcion, String fecha, String titulo, 
            String URL, String Ubicacion, String contacto, String horarios) {
        
        super(id_anuncios, descripcion, fecha, titulo, URL, Ubicacion, contacto, 
                horarios);
        
        this.id_gastronomia = id_gastronomia;
        this.id_menu = id_menu;
        this.id_anuncios = id_anuncios;
    }
    
    public int getId_gastronomia() {
        return id_gastronomia;
    }

    public void setId_gastronomia(int id_gastronomia) {
        this.id_gastronomia = id_gastronomia;
    }

    public String getId_menu() {
        return id_menu;
    }

    public void setId_menu(String id_menu) {
        this.id_menu = id_menu;
    }

    public int getId_anuncios() {
        return id_anuncios;
    }

    public void setId_anuncios(int id_anuncios) {
        this.id_anuncios = id_anuncios;
    }

    @Override
    public String toString() {
        return "Gastronomia{" + "id_gastronomia=" + id_gastronomia + 
                ", id_menu=" + id_menu + ", id_anuncios=" + id_anuncios + '}';
    }
    
    
}
