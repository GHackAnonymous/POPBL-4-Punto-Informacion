/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.basedatos;

import java.text.SimpleDateFormat;
import  popbl4.app.admin.Administrador;
import  popbl4.app.admin.Log;
import  popbl4.app.interactuador.Informacion;
import  popbl4.app.sinInteraccion.Anuncio;
import popbl4.app.sinInteraccion.Gastronomia;
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
    public String generaInsertAnuncios(Anuncio anuncio){
        
        String query = "";
        
        query +="BEGIN TRANSACTION"+ 
        "INSERT INTO anuncios "
                + "(id_anuncios, titulo, descripcion,"+ 
                " url_foto, ubicacion, contacto, horarios, fecha) "
                + "VALUES ('"+anuncio.getTitulo()+"',"
                + "'"+anuncio.getDescripcion()+"',"
                + "'"+anuncio.getURL_Foto()+"',"
                + "'"+anuncio.getUbicacion()+"',"
                + "'"+anuncio.getContacto()+"',"
                + "'"+anuncio.getHorarios()+"',"
                + ""+new SimpleDateFormat("dd/MM/yyyy").format(anuncio.getFecha())+""+
                "Select @error01 = @@error";
                if (anuncio instanceof Gastronomia){
                    query +="INSERT INTO gastronomia "
                    + "(id_menu, id_anuncios) "
                    + "VALUES ("+((Gastronomia)anuncio).getMenu().getId_menu()+","
                    + ""+((Gastronomia)anuncio).getId_anuncios()+"";
                }else if(anuncio instanceof Tiendas){
                    query +="INSERT INTO tiendas "
                    + "(nombre,id_producto,id_anuncios) "
                    + "VALUES ("+((Tiendas)anuncio).getNombre()+","
                    + ""+((Tiendas)anuncio).getProducto().getId_producto()+","
                    + ""+((Tiendas)anuncio).getId_anuncios()+"";
                }else if(anuncio instanceof Servicios){
                    query +="INSERT INTO Servicios "
                    + "(url_foto_servicio,precios,id_anuncios)"
                    + "VALUES ("+((Servicios)anuncio).getUrl_foto_servicio()+","
                    + ""+((Servicios)anuncio).getPrecios()+","
                    + ""+((Servicios)anuncio).getId_anuncios()+"";
                }
                query +="Select @error02 = @@error"
                +"IF @error01 = 0 AND @error02 = 0"
                +"COMMIT TRANSACTION"
                +"ELSE"
                +"ROLLBACK TRANSACTION";
        
                return query;
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
    public String generaSelectInformacion(){
        return "SELECT * FROM info";
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
        return "INSERT INTO info "
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
