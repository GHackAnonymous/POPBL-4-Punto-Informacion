/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.sinInteraccion;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author GHackAnonymous
 */
public class AdministradorController implements Initializable {

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
    void irLog(ActionEvent event) {
        panelLog.setVisible(true);
    }

    @FXML
    void anadir(ActionEvent event) {
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
