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
public class Servicios extends Anuncio{
    private int id_servicios;
    private String url_foto_servicio;
    private String precios;
    private int id_anuncios;

    
    public Servicios() {}
    
    public Servicios(int id_servicios, String url_foto_servicio, String precios,
            int id_anuncios, int idAnuncio, String descripcion, String fecha, 
            String titulo, String URL, String Ubicacion, String contacto, 
            String horarios) {
        super(idAnuncio, descripcion, fecha, titulo, URL, Ubicacion, contacto, 
                horarios);
        this.id_servicios = id_servicios;
        this.url_foto_servicio = url_foto_servicio;
        this.precios = precios;
        this.id_anuncios = id_anuncios;
    }

    public int getId_servicios() {
        return id_servicios;
    }

    public void setId_servicios(int id_servicios) {
        this.id_servicios = id_servicios;
    }

    public String getUrl_foto_servicio() {
        return url_foto_servicio;
    }

    public void setUrl_foto_servicio(String url_foto_servicio) {
        this.url_foto_servicio = url_foto_servicio;
    }

    public String getPrecios() {
        return precios;
    }

    public void setPrecios(String precios) {
        this.precios = precios;
    }

    public int getId_anuncios() {
        return id_anuncios;
    }

    public void setId_anuncios(int id_anuncios) {
        this.id_anuncios = id_anuncios;
    }

    @Override
    public String toString() {
        return "Servicios{" + "id_servicios=" + id_servicios + 
                ", url_foto_servicio=" + url_foto_servicio + 
                ", precios=" + precios + ", id_anuncios=" + id_anuncios + '}';
    }
}
