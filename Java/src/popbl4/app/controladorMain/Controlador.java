/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.controladorMain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import popbl4.app.basedatos.ConexionBD;
import popbl4.app.olimexRS232.ConexionRS232;
import popbl4.app.sinInteraccion.Anuncio;
import popbl4.app.sinInteraccion.FXMLDocumentController;
import popbl4.app.sinInteraccion.VistaAnuncio;

/**
 *
 * @author GHackAnonymous
 */
public class Controlador {
    
    
    private ConexionBD conexionBD;
    private ConexionRS232 conexionRS232;
    private VistaAnuncio vistaAnuncio;
    private List<Anuncio> lista;
    

    public Controlador() throws IOException {
        lista = new ArrayList<>();
        conexionBD = new ConexionBD();
        conexionRS232 = new ConexionRS232();
        vistaAnuncio = new  VistaAnuncio();
    }
    
    public List<Anuncio> InicializarAnuncios(){
        for(int i = 0; i < 20; i++){
            lista.add(new Anuncio(i, "Esto es un anuncio", "20/1/1111", "Bar Packo","img/barPAcko.png","Calle X Barrio X El Puto Mundo", "Packo EL Puto Amo (943035494)", "10:00 - 22:00"));
        }
        return lista;
    }

    
}
