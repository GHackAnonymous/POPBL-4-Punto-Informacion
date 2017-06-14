/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.controladorMain;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import popbl4.app.admin.Log;
import popbl4.app.basedatos.ConexionBD;
import popbl4.app.basedatos.GeneradorSQL;
import popbl4.app.olimexRS232.ConexionRS232;
import popbl4.app.sinInteraccion.Anuncio;

/**
 *
 * @author GHackAnonymous
 */
public class Controlador {
    
    
    private ConexionBD conexionBD;
    private ConexionRS232 conexionRS232;
    private List<Anuncio> lista;
    private GeneradorSQL generadorSQL;
    

    public Controlador() throws IOException {
        lista = new ArrayList<>();
        conexionBD = new ConexionBD();
        conexionBD.IniciarConexion();
        conexionRS232 = new ConexionRS232();
        generadorSQL = new GeneradorSQL();
    }
    
    public List<Anuncio> InicializarAnuncios() throws SQLException, ClassNotFoundException{
       /* for(int i = 0; i < 20; i++){
            lista.add(new Anuncio(i, "Mercadona es una compañía española de distribución con sede en el municipio de Tabernes Blanques y origen en Puebla de Farnals, los dos pertenecientes a la provincia de Valencia.\n" +
"\n" +
"Mercadona cuenta con 1588 supermercados1 repartidos entre todas las provincias españolas,2 "
                    + "con una sala de ventas de una superficie media de 1300 m², que responden al "
                    + "modelo llamado comercio urbano de proximidad, y mantienen un surtido en a"
                    + "limentación, droguería, perfumería y complementos donde incluyen sus "
                    + "propias marcas blancas, junto con otras marcas comerciales", 
                    "20/1/1111", "Mercadona","img/barPAcko.png"," Mediana y gran distribución. 1588 supermercados", 
                    "900 500 103", "10:00 - 22:00"));
        }*/
       
       ResultSet rs = conexionBD.genericoSelect(generadorSQL.generaSelectGastronomia());
       List<Anuncio> listaGastronomia = conexionBD.getAnunciosList("gastronomia",rs);
       
       rs = conexionBD.genericoSelect(generadorSQL.generaSelectTiendas());
       List<Anuncio> listaTiendas = conexionBD.getAnunciosList("tiendas",rs);
       
       rs = conexionBD.genericoSelect(generadorSQL.generaSelectServicios());
       List<Anuncio> listaServicios = conexionBD.getAnunciosList("servicios",rs);
       
       List<Anuncio> lista = new ArrayList<>(listaGastronomia);
       lista.addAll(listaTiendas);
       lista.addAll(listaServicios);


       
        return lista;
    }
    public List<Log> InicializarLog() throws SQLException, ClassNotFoundException{

       ResultSet rs = conexionBD.genericoSelect(generadorSQL.generaSelectLog());
       List<Log> listaLog = conexionBD.getLogList(rs);

        return listaLog;
    }
    
    /*public void obtenerDatos(String a) throws SQLException {
        
        ResultSet set = conexionBD.genericoSelect(a);
        for(int i = 0; i < set.getMetaData().getColumnCount(); i++){
            set.getArray(a);
        }
    }*/

    
}
