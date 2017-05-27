/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.controladorMain;

import popbl4.app.basedatos.ConexionBD;
import popbl4.app.olimexRS232.ConexionRS232;
import popbl4.app.sinInteraccion.VistaAnuncio;

/**
 *
 * @author GHackAnonymous
 */
public class Controlador {
    
    private ConexionBD conexionBD;
    private ConexionRS232 conexionRS232;
    private VistaAnuncio vistaAnuncio;

    public Controlador() {
        conexionBD = new ConexionBD();
        conexionRS232 = new ConexionRS232();
        vistaAnuncio = new  VistaAnuncio();
    }
    
}
