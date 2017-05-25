/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.basedatos;

//Importar librería JDBC completa
import java.sql.*;

/**
 *
 * @author GHackAnonymous
 */

public class ConexionBD {
    
    private String ip = "127.0.0.1";
    private String user = "root";
    private String pass = "";
    private String nombreBD = "popbl4";
    
    private String jdbcDriver = "com.mysql.jdbc.Driver";  
    private String urlBD = "jdbc:mysql://"+ip+"/"+nombreBD+"";
    
    public void Conexion(){
    }
    
}
