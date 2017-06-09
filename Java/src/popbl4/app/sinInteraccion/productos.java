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
public class productos extends Anuncio{
    private int id_producto;
    private String nombre;
    private String precio;
    private String url_foto;
    private int id_anuncios;

    public productos() {}

    public productos(int id_producto, String nombre, String precio, 
            String url_foto, int id_anuncios, String descripcion, 
            String fecha, String titulo, String URL, String Ubicacion, 
            String contacto, String horarios) {
        
        super(id_anuncios, descripcion, fecha, titulo, URL, Ubicacion, contacto, 
                horarios);
        
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.url_foto = url_foto;
        this.id_anuncios = id_anuncios;
    }

    
    
    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getUrl_foto() {
        return url_foto;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
    }

    public int getId_anuncios() {
        return id_anuncios;
    }

    public void setId_anuncios(int id_anuncios) {
        this.id_anuncios = id_anuncios;
    }

    @Override
    public String toString() {
        return "productos{" + "id_producto=" + id_producto + ", nombre=" 
                + nombre + ", precio=" + precio + ", url_foto=" + url_foto +
                ", id_anuncios=" + id_anuncios + '}';
    }
    
    
}
