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
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
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
        for(int i = listaLog.getItems().size(); i < lista.size(); i++){
             listaLog.getItems().add(lista.get(i));
        }
       }
        animar(panelAdministrador, "leftCenter");
        animar(panelLog, "left");
        //panelAdministrador.setVisible(false);
        panelLog.setVisible(true);
    }

    @FXML
    void anadir(ActionEvent event) {
        animar(panelAdministrador, "leftCenter");
        animar(panelAnadir, "left");
        //panelAdministrador.setVisible(false);
        panelAnadir.setVisible(true);
    }
    
    @FXML
    void Aceptar(ActionEvent event) {

    }
    @FXML
    void selectCombo(ActionEvent event) {
        
    }
    @FXML
    void botonAtrasLog(ActionEvent event) {

        animar(panelAdministrador, "right");
        animar(panelLog, "centeRight");
        //panelAnadir.setVisible(false);
        //panelAdministrador.setVisible(true);
    }
    @FXML
    void botonAtrasAñadir(ActionEvent event) {
        
        animar(panelAdministrador, "right");
        animar(panelAnadir, "centeRight");       
        //panelAnadir.setVisible(false);
        //panelAdministrador.setVisible(true);
    }
    @FXML
    void botonLogout(ActionEvent event) {

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
}
