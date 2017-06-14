/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.sinInteraccion;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import popbl4.app.admin.Log;
import popbl4.app.controladorMain.Controlador;

/**
 * FXML Controller class
 *
 * @author GHackAnonymous
 */
public class AdministradorController implements Initializable {

    Controlador cont;
    
    public void pasarControlador(Controlador cont) {
        this.cont = cont;
    }

    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }  
    
    @FXML
    private Pane panelAdministrador;
    @FXML
    private Pane panelLog;
    @FXML
    private Pane panelAnadir;
    @FXML
    private Pane panelServicios;
    @FXML
    private Pane panelAnuncio;
    @FXML
    private Pane panelGastronomia;
    @FXML
    private ComboBox<?> comboAnuncios;
    @FXML
    private Pane panelTiendas;
    @FXML
    private ListView<Log> listaLog;

    @FXML
    void irLog(ActionEvent event) throws SQLException, ClassNotFoundException {
        
        List<Log> lista = cont.InicializarLog();
        
       if(listaLog.getItems().size()>0 && listaLog.getItems() != null){
            listaLog.getItems().removeAll(lista);
            
        } 
       if(lista.size() != listaLog.getItems().size()){ 
        for(int i = 0; i < lista.size(); i++){
             listaLog.getItems().add(lista.get(i));
        }
       }
        
        panelAdministrador.setVisible(false);
        panelLog.setVisible(true);
    }

    @FXML
    void anadir(ActionEvent event) {
        panelAdministrador.setVisible(false);
        panelAnadir.setVisible(true);
    }
    
    @FXML
    void Aceptar(ActionEvent event) {

    }
    @FXML
    void selectCombo(ActionEvent event) {
        
    }
    @FXML
    void botonAtras(ActionEvent event) {
        panelAnadir.setVisible(false);
        panelAdministrador.setVisible(true);
    }
    @FXML
    void botonAtrasLog(ActionEvent event) {
        panelLog.setVisible(false);
        panelAdministrador.setVisible(true);
    }
    @FXML
    void botonLogout(ActionEvent event) {

    }
}
