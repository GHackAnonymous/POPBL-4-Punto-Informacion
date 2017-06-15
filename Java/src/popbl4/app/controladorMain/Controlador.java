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
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import popbl4.app.admin.Administrador;
import popbl4.app.admin.Log;
import popbl4.app.basedatos.ConexionBD;
import popbl4.app.basedatos.GeneradorSQL;
import popbl4.app.olimexRS232.ConexionRS232;
import popbl4.app.olimexRS232.HiloRS;
import popbl4.app.olimexRS232.SlideBloqueado;
import popbl4.app.sinInteraccion.Anuncio;
import popbl4.app.sinInteraccion.FXMLDocumentController;
import popbl4.app.sinInteraccion.Menu;
import popbl4.app.sinInteraccion.Productos;

/**
 *
 * @author GHackAnonymous
 */
public class Controlador implements Observer{
    
    private ConexionBD conexionBD;
    private ConexionRS232 conexionRS232;
    private List<Anuncio> lista;
    private GeneradorSQL generadorSQL;
    private SlideBloqueado slideBlo;
    private HiloRS hiloRS;
    private FXMLDocumentController o;
    

    public Controlador(FXMLDocumentController o) throws IOException {
        this.o = o;
        lista = new ArrayList<>();
        conexionBD = new ConexionBD();
        conexionBD.IniciarConexion();
        conexionRS232 = new ConexionRS232();
        generadorSQL = new GeneradorSQL();
        slideBlo = new SlideBloqueado();
        hiloRS = new HiloRS(this,conexionRS232,slideBlo);
        System.out.println("Añado Observer");
        slideBlo.addObserver(this);
    }

    public HiloRS getHiloRS() {
        return hiloRS;
    }

    public SlideBloqueado getSlideBlo() {
        return slideBlo;
    }

    public List<Anuncio> InicializarAnuncios() throws SQLException, ClassNotFoundException{
       
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
    public boolean InsertatAnuncio(Anuncio a, Menu m, Productos p){

        
        String s = generadorSQL.generaInsertAnuncios(conexionBD.getConexion(),a, m, p);
        //System.out.println(s);
        //return conexionBD.genericoInsert(s);
       return (s != null) ? true : false;
       
    }

    public boolean login(Administrador admin) throws ClassNotFoundException {
        
        System.out.println(generadorSQL.generaSelectComprobarAdmin(admin)); 
       ResultSet login = conexionBD.genericoSelect(generadorSQL.generaSelectComprobarAdmin(admin));
      
        try {
            
            Administrador lista = conexionBD.getLoginList(login);
            return conexionBD.login(admin, lista.getUsername(), lista.getContraseña());
            
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    } 

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Entra Update");
        this.o.salirSlide();
    }
}
