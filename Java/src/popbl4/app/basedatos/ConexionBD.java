/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.basedatos;

//Importar librería JDBC completa
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GHackAnonymous
 */

public class ConexionBD {
    
    private String ip = "127.0.0.1";
    private String usuario = "root";
    private String contraseña = "";
    private String nombreBD = "popbl4";
    
    private String driver = "com.mysql.jdbc.Driver";  
    private String urlBD = "jdbc:mysql://"+ip+"/"+nombreBD+"";
    
    private Connection conexion = null;
    private Statement orden = null;
    
    public void IniciarConexion(){
        
        
        try{
	    //Cosas raras con el JDBC, MIRAR
	    Class.forName("com.mysql.jdbc.Driver");  //Class.forName(), método para cargar drivers

	    //Abrir conexión
	    //System.out.println("Hacer conexión...");
	    conexion = DriverManager.getConnection(urlBD,usuario,contraseña);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet genericoSelect(String select){
        try {
            orden = conexion.createStatement();
            return orden.executeQuery(select);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     public void genericoUpdateInsert(String updateInsert){ 
        //Sirve la misma para update, insert o delete
        try {
            orden = conexion.createStatement();
            orden.executeUpdate(updateInsert);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
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
