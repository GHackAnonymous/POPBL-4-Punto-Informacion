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
public class Productos{
    private int id_producto;
    private String nombre;
    private String precio;
    private String url_foto_producto;
    private int id_anuncios;

    public Productos() {}
    
    public Productos(int id_producto, String nombre, String precio, 
            String url_foto_producto, int id_anuncios) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.url_foto_producto = url_foto_producto;
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

    public String getUrl_foto_producto() {
        return url_foto_producto;
    }

    public void setUrl_foto_producto(String url_foto) {
        this.url_foto_producto = url_foto;
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
                + nombre + ", precio=" + precio + ", url_foto=" + url_foto_producto +
                ", id_anuncios=" + id_anuncios + '}';
    }
    
    
}
