/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.basedatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import  popbl4.app.admin.Administrador;
import  popbl4.app.admin.Log;
import  popbl4.app.interactuador.Informacion;
import  popbl4.app.sinInteraccion.Anuncio;
import popbl4.app.sinInteraccion.Gastronomia;
import popbl4.app.sinInteraccion.Menu;
import popbl4.app.sinInteraccion.Productos;
import popbl4.app.sinInteraccion.Servicios;
import popbl4.app.sinInteraccion.Tiendas;

/**
 *
 * @author GHackAnonymous
 */
public class GeneradorSQL {
    
    public String generaSelectAdministrador(){
        return "SELECT * FROM administrador";
    }
    public String generaInsertAdministrador(Administrador adminstrador){
        return "INSERT INTO administrador "
                + "(nick, nombre, clave) "
                + "VALUES ('"+adminstrador.getUsername()+"',"
                + "'"+adminstrador.getNombre()+"',"
                + "'"+adminstrador.getContraseña()+"');";  
    }
    public String generaUpdateAdministrador(Administrador adminstrador){
        return "UPDATE administrador" +
                "SET nick = '"+adminstrador.getUsername()+"',"
                + "nombre = '"+adminstrador.getNombre()+"',"
                + "clave = '"+adminstrador.getContraseña()+"'" +
                "WHERE id_admin = "+adminstrador.getIdAdministrador()+";"; 
        
    }
    public String generaSelectAnuncios(){
        return "SELECT * FROM anuncios";
    }
    public String generaInsertAnuncios(Connection c, Anuncio anuncio,Menu m, Productos p){

        PreparedStatement stmt1=null;
        PreparedStatement stmt2=null;
        PreparedStatement stmt3=null;
        PreparedStatement stmt4=null;
        PreparedStatement stmt5=null;
        PreparedStatement stmt6=null;
        
        
        try {
            c.setAutoCommit(false);
            stmt1 = c.prepareStatement("INSERT INTO anuncios ( titulo, descripcion, url_foto_anuncio, ubicacion, contacto, horarios, fecha_anuncio) VALUES (?,?,?,?,?,?,?);");
            stmt1.setString(1,anuncio.getTitulo());
            stmt1.setString(2,anuncio.getDescripcion());
            stmt1.setString(3,anuncio.getURL_Foto());
            stmt1.setString(4,anuncio.getUbicacion());
            stmt1.setString(5,anuncio.getContacto());
            stmt1.setString(6,anuncio.getHorarios());
            stmt1.setString(7,anuncio.getFecha());
            stmt1.executeUpdate();
            if (anuncio instanceof Gastronomia){
                if(m != null){
                    stmt2 = c.prepareStatement("INSERT INTO menu (nombre_menu, ingedientes, precio) VALUES (?, ?, ?);");
                    stmt2.setString(1,m.getNombre());
                    stmt2.setString(2,m.getIngedientes());
                    stmt2.setString(3,m.getPrecio());
                    stmt2.executeUpdate();
                }
            
                stmt3 = c.prepareStatement("INSERT INTO gastronomia (id_menu, id_anuncios_gastronomia) VALUES ((select id_menu from menu where nombre_menu = ?),(select id_anuncios from anuncios where titulo = ?));");
                stmt3.setString(1,m.getNombre());
                stmt3.setString(2,anuncio.getTitulo());
                stmt3.executeUpdate();
                
                
            }else if(anuncio instanceof Tiendas){
                if(p != null){
                    stmt4 = c.prepareStatement("INSERT INTO productos (nombre_producto, precio, url_foto_producto, id_anuncios_productos) VALUES (?, ?, ?,(select id_anuncios from anuncios where titulo = ? ));");
                    stmt4.setString(1,p.getNombre());
                    stmt4.setString(2,p.getPrecio());
                    stmt4.setString(3,p.getPrecio());
                    stmt4.setString(4,anuncio.getTitulo());
                    stmt4.executeUpdate();
                }
                stmt5 = c.prepareStatement("INSERT INTO tiendas (nombre_tienda,id_producto,id_anuncios_tiendas)VALUES (?,(select id_producto from productos where nombre_producto = ?),(select id_anuncios from anuncios where titulo = ?));");
                stmt5.setString(1,((Tiendas)anuncio).getNombre());
                stmt5.setString(2,p.getNombre());
                stmt5.setString(3,anuncio.getTitulo());
                stmt5.executeUpdate();
            }else if(anuncio instanceof Servicios){
                stmt6 = c.prepareStatement("INSERT INTO Servicios (url_foto_servicio,precios,id_anuncios_servicios)VALUES (?,? ,(select id_anuncios from anuncios where titulo = ?));");
                stmt6.setString(1,((Servicios)anuncio).getUrl_foto_servicio());
                stmt6.setString(2,((Servicios)anuncio).getPrecios());
                stmt6.setString(3,anuncio.getTitulo());
                stmt6.executeUpdate();
            }
            c.commit();
            return "a";
        } catch (SQLException ex) {
            Logger.getLogger(GeneradorSQL.class.getName()).log(Level.SEVERE, null, ex);
            try {
                c.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(GeneradorSQL.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return null;
        }    
    }
    public String generaSelectComprobarAdmin(Administrador admin){
        return "Select nick,clave from administradores " 
	+"where nick = '" + admin.getUsername()+"'"
	+ " AND clave = '" + admin.getContraseña() + "';";
    }
    public String generaUpdateAnuncios(Anuncio anuncio){
        return "UPDATE administrador" +
                "SET descripcion = '"+anuncio.getDescripcion()+"',"
                + "fecha = "+new SimpleDateFormat("dd/MM/yyyy").format(anuncio.getFecha())+"" +
                "WHERE id_anuncios = "+anuncio.getIdAnuncio()+";"; 
    }
    public String generaSelectGastronomia(){
        return "select * from gastronomia G join menu M " +
                "on M.id_menu = G.id_menu join anuncios A " +
                "on A.id_anuncios = G.id_anuncios_gastronomia;";
    }
    public String generaSelectTiendas(){
        return "select * from tiendas T join productos P " +
                "on P.id_producto = T.id_producto join anuncios A " +
                "on A.id_anuncios = P.id_anuncios_productos;";
    }
    public String generaSelectServicios(){
        return "select * from servicios S join anuncios A " +
                "on S.id_anuncios_servicios = A.id_anuncios;";
    }
    public String generaSelectInformacion(int tipo){
        return "SELECT * FROM info where id_info = "+tipo+";";
        
    }
    public String generaInsertInformacion(Informacion informacion){
        return "INSERT INTO info "
                + "() "
                + "VALUES ();";  
    }
    public String generaUpdateInformacion(Informacion informacion){
        return null; //no tiene sentido modificar algo que no tiene mas que un id
    }
    public String generaSelectLog(){
        return "SELECT * FROM logs";
    }
    public String generaInsertLog(Log log){
        return "INSERT INTO logs "
                + "(contenido, id_tipo, id_admin) "
                + "VALUES ('"+log.getContenido()+"',"
                + ""+log.getIdTipo()+","
                + ""+log.getIdAdmin()+");";  
    }
    public String generaUpdateLog(Log log){
        return "UPDATE administrador" +
                "SET contenido = '"+log.getContenido()+"',"
                + "id_tipo = "+log.getIdTipo()+","
                + "id_admin = "+log.getIdAdmin()+","
                + "WHERE id_log = "+log.getIdLog()+";"; 
    }
}
