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
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
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
    private Label tituloAnuncio;
     
     @FXML
    private Label labeInfoText;
     
     @FXML
    private ImageView imagenAnuncio;
     
      @FXML
    private Label labelUbicacion;
      
      @FXML
    private Label labelContacto;
    
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
    private Pane panelInformacion;
    
    @FXML
    private Pane panelHelp;

    @FXML
    private Pane panelMenuPrincipal;
    
     @FXML
    private Pane panelAnuncios;
     
     @FXML
    private Pane panelTipoAnuncio;
     
      @FXML
    private Pane panelAnuncio;
     
     @FXML
    void backMenuInfo(ActionEvent event) {
        animar(panelInformacion, "leftCenter");
        animar(panelMenuPrincipal, "left");
    }
    
     @FXML
    void mostrarHelp(ActionEvent event) {
        panelHelp.setVisible(true);
        animar(panelHelp, "top");
    }
    
    @FXML
    void volverHelp(ActionEvent event) {
       // panelHelp
       animar(panelHelp, "up");
       
    }

    @FXML
    void irAnuncios(ActionEvent event) {
        animar(panelTipoAnuncio, "leftCenter");
        animar(panelAnuncios, "left");
        //panelTipoAnuncio.setVisible(false);
        panelAnuncios.setVisible(true);
    }
    
    @FXML
    void irInformacion(ActionEvent event) {
        panelInformacion.setVisible(true);
        animar(panelMenuPrincipal, "leftCenter");
        animar(panelInformacion, "left");
    }
    
    void inicializarLista() {
        for(int i = 0; i < list.size(); i++){
            listaAnuncios.getItems().add(list.get(i)); 
        }
        listaAnuncios.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Anuncio>() {
            @Override
            public void changed(ObservableValue<? extends Anuncio> observable, Anuncio oldValue, Anuncio newValue) {
                verAnuncio(newValue);
            } 
        });
    }
    
    void actualizarLista(List<Anuncio> l){
        for(int i = 0; i < l.size(); i++){
            listaAnuncios.getItems().add(l.get(i)); 
        }
    }
    
     private void verAnuncio(Anuncio newValue) {
         inicializaAnuncio(newValue);
         panelAnuncio.setVisible(true);
           animar(panelAnuncios, "leftCenter");
           animar(panelAnuncio, "left");
                
       }
     @FXML
    void volverListaAnuncios(ActionEvent event) {
        panelAnuncio.setVisible(true);
           animar(panelAnuncio, "leftCenter");
           animar(panelAnuncios, "left");
    }
    
     @FXML
    void irTipoAnuncio(ActionEvent event) {
           
           panelTipoAnuncio.setVisible(true);
           animar(panelMenuPrincipal, "centeRight");
           animar(panelTipoAnuncio, "right");
           //panelMenuPrincipal.setVisible(false);
    }
    
      @FXML
    void backMenu(ActionEvent event) {
        animar(panelAnuncios, "leftCenter");
        animar(panelMenuPrincipal, "left");
        //panelMenuPrincipal.setVisible(true);
        //panelAnuncios.setVisible(false);
    }
    
    void inicializaAnuncio(Anuncio a) {
        tituloAnuncio.setText(a.getTitulo());
        labeInfoText.setText(a.getDescripcion());
        //imagenAnuncio.setImage(a.getURL_Foto());
        labelUbicacion.setText(a.getUbicacion()); 
        labelContacto.setText(a.getContacto());
    }
    
    @FXML
    void irAdministrador(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Administrador.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        
        stage.setScene(home_page_scene);
        stage.show();
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
          if(mode.equals("up")){
           p.setLayoutX(0.0d);
           p.setLayoutY(0.0d);
           Timeline time = new Timeline();
           time.getKeyFrames().addAll(
           new KeyFrame(Duration.ZERO, new KeyValue(p.layoutYProperty(), 0.0d)), new KeyFrame(Duration.millis(300.d), new KeyValue(p.layoutYProperty(), -400.0d)));
           time.play();
          }
          
          if(mode.equals("centeRight")){
           p.setLayoutX(0.0d);
           p.setLayoutY(0.0d);
           Timeline time = new Timeline();
           time.getKeyFrames().addAll(
           new KeyFrame(Duration.ZERO, new KeyValue(p.layoutXProperty(), 0.0d)), new KeyFrame(Duration.millis(300.d), new KeyValue(p.layoutXProperty(), 600.0d)));
           time.play();
          }
          
           if(mode.equals("right")){
           p.setLayoutX(-600.0d);
           p.setLayoutY(0.0d);
           Timeline time = new Timeline();
           time.getKeyFrames().addAll(
           new KeyFrame(Duration.ZERO, new KeyValue(p.layoutXProperty(), -600.0d)), new KeyFrame(Duration.millis(300.d), new KeyValue(p.layoutXProperty(), 0.0d)));
           time.play();
          }
          
    }

    private static class ChangeListenerImpl implements ChangeListener<String> {

        public ChangeListenerImpl() {
        }

        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private static class ChangeListenerImplImpl extends ChangeListenerImpl {

        public ChangeListenerImplImpl() {
        }
    }
    
}
