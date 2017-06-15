/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.sinInteraccion;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
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
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
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
    ChangeListener<Anuncio> lineser = null;
    
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
    private TitledPane titleTiendas;
    
    @FXML
    private TitledPane titleServicios;
    
    @FXML
    private TitledPane titleGastronomia;
     
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
        if(titleGastronomia.isExpanded()){ //Para saver el tipo selecionado
            inicializarLista(titleGastronomia.getText());
        }else if(titleServicios.isExpanded()){
            inicializarLista(titleServicios.getText());
        }else if(titleTiendas.isExpanded()){
            inicializarLista(titleTiendas.getText());
        }
        
        
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
    
    void inicializarLista(String tipo) {
      /*  if(listaAnuncios.getItems().size()>0){
            int a =  0;
            for(int i = listaAnuncios.getItems().size(); i >= 0; i--){
                listaAnuncios.getItems().remove(a);
                a++;
            }
        }*/
        if(listaAnuncios.getItems().size()>0 && listaAnuncios.getItems() != null){
            listaAnuncios.getItems().removeAll(list);
            
        }
        if(lineser != null){
                listaAnuncios.getSelectionModel().selectedItemProperty().removeListener(lineser);
        }else{
            lineser = new ChangeListener<Anuncio>() {
                @Override
                public void changed(ObservableValue<? extends Anuncio> observable, Anuncio oldValue, Anuncio newValue) {
                    verAnuncio(newValue);
                } 
            };
        }
        
        for(int i = 0; i < list.size(); i++){
            if(tipo.equalsIgnoreCase("Gastronomia")){
                if(list.get(i) instanceof Gastronomia){
                    listaAnuncios.getItems().add(list.get(i));
                }
            }else if(tipo.equalsIgnoreCase("Tiendas")){
                if(list.get(i) instanceof Tiendas){
                    listaAnuncios.getItems().add(list.get(i)); 
                }
            }else if(tipo.equalsIgnoreCase("Servicios")){
                if(list.get(i) instanceof Servicios){
                   listaAnuncios.getItems().add(list.get(i)); 
                }
            }
        }
        listaAnuncios.getSelectionModel().selectedItemProperty().addListener(lineser);
    }

    void actualizarLista(String tipo, List<Anuncio> l){
         for(int i = 0; i < list.size(); i++){
            if(tipo.equalsIgnoreCase("Gastronomia")){
                if(list.get(i) instanceof Gastronomia){
                    listaAnuncios.getItems().add(list.get(i)); 
                }
            }else if(tipo.equalsIgnoreCase("Tiendas")){
                if(list.get(i) instanceof Tiendas){
                    listaAnuncios.getItems().add(list.get(i)); 
                }
            }else if(tipo.equalsIgnoreCase("Servicios")){
                if(list.get(i) instanceof Servicios){
                   listaAnuncios.getItems().add(list.get(i));  
                }
            }
         }
    }
    
     private void verAnuncio(Anuncio newValue) {
         if(newValue!= null){
            inicializaAnuncio(newValue);
            panelAnuncio.setVisible(true);
            animar(panelAnuncios, "leftCenter");
            animar(panelAnuncio, "left");
         }
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
    @FXML
    void backMenuPrincipal(ActionEvent event) {
        animar(panelTipoAnuncio, "leftCenter");
        animar(panelMenuPrincipal, "left");
    }
    void inicializaAnuncio(Anuncio a) {
        tituloAnuncio.setText(a.getTitulo());
        labeInfoText.setText(a.getDescripcion());

        imagenAnuncio.setImage(new Image("file:.\\src\\fotos\\"+a.getURL_Foto()));
        
        labelUbicacion.setText(a.getUbicacion()); 
        labelContacto.setText(a.getContacto());
    }
    
    @FXML
    void irAdministrador(ActionEvent event) throws IOException {
        
        //FXMLLoader fxmlLoader = FXMLLoader(getClass().getResource("Administrador.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Administrador.fxml"));  
        
        
        Parent home_page_parent = (Parent)fxmlLoader.load();
        
        AdministradorController controller = fxmlLoader.<AdministradorController>getController();
        controller.pasarControlador(cont);

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
            //inicializarLista();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
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

    private FXMLLoader FXMLLoader(URL resource) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
