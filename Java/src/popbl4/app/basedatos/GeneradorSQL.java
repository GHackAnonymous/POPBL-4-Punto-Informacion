/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.basedatos;

import java.text.SimpleDateFormat;
import java.util.Date;
import  popbl4.app.admin.Administrador;
import  popbl4.app.admin.Log;
import  popbl4.app.interactuador.Informacion;
import  popbl4.app.sinInteraccion.Anuncio;

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
                + "(id_admin, nick, nombre, clave) "
                + "VALUES ("+adminstrador.getIdAdministrador()+","
                + "'"+adminstrador.getUsername()+"',"
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
         return "INSERT INTO anuncios "
                + "(id_anuncios, titulo, descripcion,"+ 
                " url_foto, ubicacion, contacto, horarios, fecha) "
                + "VALUES ("+anuncio.getIdAnuncio()+","
                + "'"+anuncio.getTitulo()+"',"
                + "'"+anuncio.getDescripcion()+"',"
                + "'"+anuncio.getURL_Foto()+"',"
                + "'"+anuncio.getUbicacion()+"',"
                + "'"+anuncio.getContacto()+"',"
                + "'"+anuncio.getHorarios()+"',"
                + "'"+new SimpleDateFormat("dd/MM/yyyy").format(anuncio.getFecha())+";";  
    }
    public String generaUpdateAnuncios(Anuncio anuncio){
        return "UPDATE anuncios" +
                "SET titulo = "+anuncio.getTitulo()+"',"
                + "descripcion = '"+anuncio.getDescripcion()+"',"
                + "url_foto = '"+anuncio.getURL_Foto()+"',"
                + "ubicacion = '"+anuncio.getUbicacion()+"',"
                + "contacto = '"+anuncio.getContacto()+"',"
                + "horarios = '"+anuncio.getHorarios()+"',"
                + "fecha = '"+new SimpleDateFormat("dd/MM/yyyy").format(anuncio.getFecha())+"'" +
                "WHERE id_anuncios = "+anuncio.getIdAnuncio()+";"; 
    }
    public String generaSelectInformacion(){
        return "SELECT * FROM info";
    }
    public String generaInsertInformacion(Informacion informacion){
        return "INSERT INTO info "
                + "(id_info) "
                + "VALUES ("+informacion.getIdInformacion()+");";  
    }
    public String generaUpdateInformacion(Informacion informacion){
        return null; //no tiene sentido modificar algo que no tiene mas que un id
    }
    public String generaSelectLog(){
        return "SELECT * FROM logs";
    }
    public String generaInsertLog(Log log){
        return "INSERT INTO info "
                + "(id_log, contenido, id_tipo, id_admin) "
                + "VALUES ("+log.getIdLog()+","
                + "'"+log.getContenido()+"',"
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
