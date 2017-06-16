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
public class Tiendas extends Anuncio{
    private int id_tiendas;
    private String nombre;
    private Productos producto;
    private int id_anuncios;

    public Tiendas() {}
    
    public Tiendas(int id_tiendas, String nombre, Productos producto, 
            int id_anuncios, String descripcion, String fecha, 
            String titulo, String URL, String Ubicacion, String contacto,
            String horarios) {
        super(id_anuncios, descripcion, fecha, titulo, URL, Ubicacion, contacto, 
                horarios);
        
        this.id_tiendas = id_tiendas;
        this.nombre = nombre;
        this.producto = producto;
        this.id_anuncios = id_anuncios;
    }

    public int getId_tiendas() {
        return id_tiendas;
    }

    public void setId_tiendas(int id_tiendas) {
        this.id_tiendas = id_tiendas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos id_producto) {
        this.producto = id_producto;
    }

    public int getId_anuncios() {
        return id_anuncios;
    }

    public void setId_anuncios(int id_anuncios) {
        this.id_anuncios = id_anuncios;
    }

    @Override
    public String toString() {
        return "Tiendas: " + id_tiendas + "-" + nombre;
    }
    
    
}
