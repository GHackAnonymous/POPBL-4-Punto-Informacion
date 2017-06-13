/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.basedatos;

//Importar librería JDBC completa
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import popbl4.app.sinInteraccion.Anuncio;

/**
 *
 * @author GHackAnonymous
 */

public class ConexionBD {
    
    private String ip = "127.0.0.1";
    private String usuario = "root";
    private String contraseña = "";
    private String nombreBD = "scott";
    
    private String driver = "com.mysql.jdbc.Driver";  
    private String urlBD = "jdbc:mysql://"+ip+"/"+nombreBD+"";
    
    private Connection conexion = null;
    private Statement orden = null;
    
    public void IniciarConexion(){
        
        
        try{
	    //Cosas raras con el JDBC, MIRAR
            System.out.println("Entro ");
	    Class.forName("com.mysql.jdbc.Driver");  //Class.forName(), método para cargar drivers

	    //Abrir conexión
	    //System.out.println("Hacer conexión...");
	    conexion = DriverManager.getConnection(urlBD,usuario,contraseña);
            System.out.println("Se conecto");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Anuncio> genericoSelect(String select) {
        try {
            orden = conexion.createStatement();
            try {
                return getEmployeeList(orden.executeQuery(select));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private static List<Anuncio> getEmployeeList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Employee objects
        List<Anuncio> empList = new ArrayList<>();
 
        while (rs.next()) {
            //Employee emp = new Employee();
            /*emp.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
            emp.setFirstName(rs.getString("FIRST_NAME"));
            emp.setLastName(rs.getString("LAST_NAME"));
            emp.setEmail(rs.getString("EMAIL"));
            emp.setPhoneNumber(rs.getString("PHONE_NUMBER"));
            emp.setHireDate(rs.getDate("HIRE_DATE"));
            emp.setJobId(rs.getString("JOB_ID"));
            emp.setSalary(rs.getInt("SALARY"));
            emp.setCommissionPct(rs.getDouble("COMMISSION_PCT"));
            emp.setManagerId(rs.getInt("MANAGER_ID"));
            emp.setDepartmantId(rs.getInt("DEPARTMENT_ID"));
            //Add employee to the ObservableList
            empList.add(emp);*/
        }
        //return empList (ObservableList of Employees)
        return empList;
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
