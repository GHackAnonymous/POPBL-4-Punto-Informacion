/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.sinInteraccion;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import popbl4.app.controladorMain.Controlador;

/**
 *
 * @author GHackAnonymous
 */
public class FXMLDocumentController implements Initializable {
    Controlador cont;
    List<Anuncio> list;
    
     @FXML
    private ListView<Anuncio> listaAnuncios;
    
    @FXML
    private JFXButton botonAdmin;

    @FXML
    private Button botonHelp;

    @FXML
    private JFXButton botonBloqueo;

    @FXML
    private Button botonAnuncios;

    @FXML
    private Pane panelMenuPrincipal;
    
     @FXML
    private Pane panelAnuncios;
     
     @FXML
    private Pane panelTipoAnuncio;

    @FXML
    void irAnuncios(ActionEvent event) {
        panelTipoAnuncio.setVisible(false);
        panelAnuncios.setVisible(true);
    }
    
    void inicializarLista() {
        for(int i = 0; i < 20; i++){
            listaAnuncios.getItems().add(list.get(i)); 
        }
    }
    
     @FXML
    void irTipoAnuncio(ActionEvent event) {
           panelTipoAnuncio.setVisible(true);
           panelMenuPrincipal.setVisible(false);
    }
    
      @FXML
    void backMenu(ActionEvent event) {
        panelMenuPrincipal.setVisible(true);
        panelAnuncios.setVisible(false);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            cont = new Controlador();
            list = cont.InicializarAnuncios();
            inicializarLista();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
