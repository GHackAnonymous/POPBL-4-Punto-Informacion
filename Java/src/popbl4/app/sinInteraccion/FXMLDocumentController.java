/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.sinInteraccion;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import popbl4.app.controladorMain.Controlador;

/**
 *
 * @author GHackAnonymous
 */
public class FXMLDocumentController implements Initializable {
    Controlador cont;
    List<Anuncio> list;
    
     @FXML
    private JFXListView<Anuncio> listaAnuncios;
    
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
        animar(panelTipoAnuncio, "leftCenter");
        animar(panelAnuncios, "left");
        //panelTipoAnuncio.setVisible(false);
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
           animar(panelMenuPrincipal, "leftCenter");
           animar(panelTipoAnuncio, "left");
           //panelMenuPrincipal.setVisible(false);
    }
    
      @FXML
    void backMenu(ActionEvent event) {
        animar(panelAnuncios, "leftCenter");
        animar(panelMenuPrincipal, "left");
        //panelMenuPrincipal.setVisible(true);
        //panelAnuncios.setVisible(false);
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

        private void animar(Pane p, String mode) {
          if(mode.equals("top")){
           p.setLayoutX(0.0d);
           p.setLayoutY(-400.0d);
           Timeline time = new Timeline();
           time.getKeyFrames().addAll(
           new KeyFrame(Duration.ZERO, new KeyValue(p.layoutYProperty(), -400.0d)), new KeyFrame(Duration.millis(300.d), new KeyValue(p.layoutYProperty(), 0.0d)));
           time.play();
          }
          if(mode.equals("left")){
                p.setLayoutX(600.0d);
                p.setLayoutY(0.0d);
                Timeline time = new Timeline();
                time.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, new KeyValue(p.layoutXProperty(), 600.0d)), new KeyFrame(Duration.millis(300.d), new KeyValue(p.layoutXProperty(), 0.0d)));
                time.play();
          }
            if(mode.equals("leftCenter")){
                p.setLayoutX(0.0d);
                p.setLayoutY(0.0d);
               Timeline time = new Timeline();
           time.getKeyFrames().addAll(
           new KeyFrame(Duration.ZERO, new KeyValue(p.layoutXProperty(), 0.0d)), new KeyFrame(Duration.millis(300.d), new KeyValue(p.layoutXProperty(), -600.0d)));
           time.play();
          }
          
    }
    
}
