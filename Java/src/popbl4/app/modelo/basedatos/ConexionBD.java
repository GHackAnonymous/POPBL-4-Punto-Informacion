/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.modelo.basedatos;

//Importar librería JDBC completa
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import popbl4.app.modelo.admin.Administrador;
import popbl4.app.modelo.admin.Log;
import popbl4.app.modelo.interactuador.Informacion;
import popbl4.app.modelo.anuncios.Anuncio;
import popbl4.app.modelo.anuncios.Gastronomia;
import popbl4.app.modelo.anuncios.Menu;
import popbl4.app.modelo.anuncios.Productos;
import popbl4.app.modelo.anuncios.Servicios;
import popbl4.app.modelo.anuncios.Tiendas;

/**
 *
 * @author GHackAnonymous
 */

public class ConexionBD {
    
    private String ip = "127.0.0.1";
    private String usuario = "root";
    private String contraseña = "";
    private String nombreBD = "basedatos";
    
    private String driver = "com.mysql.jdbc.Driver";  
    private String urlBD = "jdbc:mysql://"+ip+"/"+nombreBD+"";
    
    private Connection conexion = null;
    private Statement orden = null;

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    
    
    
    public void IniciarConexion(){
        
        
        try{
	    //Cosas raras con el JDBC, MIRAR
            System.out.println("Entro ");
	    Class.forName("com.mysql.jdbc.Driver");  //Class.forName(), método para cargar drivers

	    //Abrir conexión
	    conexion = DriverManager.getConnection(urlBD,usuario,contraseña);
            System.out.println("Se conecto");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet genericoSelect(String select) {
        try {
            orden = conexion.createStatement();
            return orden.executeQuery(select);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Anuncio> getAnunciosList(String tipo, ResultSet rs) throws SQLException, ClassNotFoundException {
        
        List<Anuncio> listaAnuncios= new ArrayList<>();
 
        while (rs != null && rs.next()) {
            Anuncio aux = null;
            if(tipo.equalsIgnoreCase("gastronomia")){
                aux = new Gastronomia();
                Menu menu = new Menu(); 
                ((Gastronomia) aux).setId_gastronomia(rs.getInt("id_gastronomia"));
                menu.setId_menu(rs.getInt("id_menu"));
                menu.setNombre(rs.getString("nombre_menu"));
                menu.setIngedientes(rs.getString("ingedientes"));
                menu.setPrecio(rs.getString("precio"));
                ((Gastronomia) aux).setMenu(menu);
                ((Gastronomia) aux).setId_anuncios(rs.getInt("id_anuncios_gastronomia"));
            }else if(tipo.equalsIgnoreCase("tiendas")){
                aux = new Tiendas();
                Productos producto = new Productos();
                
                ((Tiendas) aux).setId_tiendas(rs.getInt("id_tiendas"));
                ((Tiendas) aux).setNombre(rs.getString("nombre_tienda"));
                
                producto.setId_producto(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre_producto"));
                producto.setPrecio(rs.getString("precio"));
                producto.setUrl_foto_producto(rs.getString("url_foto_producto"));
                producto.setId_anuncios(rs.getInt("id_anuncios_productos"));
                ((Tiendas) aux).setProducto(producto);
                
                ((Tiendas) aux).setId_anuncios(rs.getInt("id_anuncios_tiendas"));
            }else if(tipo.equalsIgnoreCase("servicios")){
                aux = new Servicios();
                
                ((Servicios) aux).setId_servicios(rs.getInt("id_servicios"));
                ((Servicios) aux).setUrl_foto_servicio(rs.getString("url_foto_servicio"));
                ((Servicios) aux).setPrecios(rs.getString("precios"));
                ((Servicios) aux).setId_anuncios(rs.getInt("id_anuncios_servicios"));
                
            }
            aux.setIdAnuncio(rs.getInt("id_anuncios"));
            aux.setTitulo(rs.getString("titulo"));
            aux.setDescripcion(rs.getString("descripcion"));
            aux.setURL_Foto(rs.getString("url_foto_anuncio"));
            aux.setUbicacion(rs.getString("ubicacion"));
            aux.setContacto(rs.getString("contacto"));
            aux.setHorarios(rs.getString("horarios"));
            aux.setFecha(rs.getString("fecha_anuncio"));
            
           
            listaAnuncios.add(aux);
        }
       
        return listaAnuncios;
    }
    public Informacion getInformacion(ResultSet rs) throws SQLException, ClassNotFoundException {
        Informacion info = null;
        while (rs != null && rs.next()) {
            info = new Informacion();
            info.setIdInformacion(rs.getInt("id_info"));
            info.setDescripcionInformacion(rs.getString("tipo"));
            info.setFotoInformacion(rs.getString("url_foto_info"));
        }
        return info;
    }
     public boolean genericoInsert(String Insert){ 
        
       
        try {
            orden = conexion.createStatement();
            orden.execute(Insert);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public List<Log> getLogList(ResultSet rs) throws SQLException, ClassNotFoundException {
        
        List<Log> listaLog= new ArrayList<>();
 
        while (rs != null && rs.next()) {
            Log aux = new Log();
            
            aux.setIdLog(rs.getInt("id_log"));
            aux.setContenido(rs.getString("contenido"));
            aux.setIdTipo(rs.getInt("id_tipo"));
            aux.setIdAdmin(rs.getInt("id_admin"));
            
            
            listaLog.add(aux);
        }
        
        return listaLog;
    }
    public Administrador getLoginList(ResultSet rs) throws SQLException, ClassNotFoundException {
       
        Administrador aux = new Administrador();
 
        while(rs.next()){
            aux.setUsername(rs.getString("nick"));
            aux.setContraseña(rs.getString("clave"));
        }
        return aux;
    }
    public boolean login(Administrador admin, String nick, String clave) throws SQLException {
       
        if(admin.getUsername().equals(nick) && 
                 admin.getContraseña().equals(clave)){
                return true;
            }else{
                return false;
            }
        }

    public void CerrarConexion(){
        
        
        try{
            if(orden != null)
                orden.close();
            if(conexion != null)
                conexion.close();
        }catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
