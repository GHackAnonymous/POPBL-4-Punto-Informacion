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
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.layout.HBox;
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
    Contador contador;

    //Slide define
    
    private final double IMG_WIDTH = 600;
    private final double IMG_HEIGHT = 400;
    
    private final int NUM_OF_IMGS = 3;
    private final int SLIDE_FREQ = 4; //En segundos
    
    public void pasarControlador(Controlador cont) {
        this.cont = cont;
    }
    
    //Slide
    
    @FXML
    public Pane panelSlide;
    
    @FXML
    private HBox imgContainer;
    
    @FXML
    private ImageView imagenSlide1;

    @FXML
    private ImageView imagenSlide3;

    @FXML
    private ImageView imagenSlide2;

    
     @FXML
    private Label tituloAnuncio;
     
     @FXML
    private Label labeInfoText;
     
     @FXML
    private ImageView imagenAnuncio, carteleraImg;
     
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
    public Pane panelMenuPrincipal;
    
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
    
    //panel informacion
    
    @FXML
    private Button  btnInfo, btnCultura, btnTurismo,btnHistoria, btnMap;
    
    private Button botonActual;
    private Pane panelActual;
    
    @FXML
     private Pane panelHistoria;
     
     @FXML
    private Pane panelInfoInfo, cartelera;
     
     @FXML
    private Pane panelTurismo;
     
     @FXML
    private Pane panelCultura;
     
     @FXML
    private Pane panelMapa;

    public HBox getImgContainer() {
        return imgContainer;
    }
     
     
     
     @FXML
    void mostrarInformacion(ActionEvent event) {
        panelActual.setVisible(false);
        panelActual = panelInfoInfo;
        botonActual.setStyle("-fx-background-color: #fff;");
        botonActual = btnInfo;
        botonActual.setStyle("-fx-background-color: #ccc;");
        panelInfoInfo.setVisible(true);
        
        
    }
    
      @FXML
    void mostrarCultura(ActionEvent event) {
        panelActual.setVisible(false);
        panelActual = panelCultura;
        botonActual.setStyle("-fx-background-color: #fff;");
        botonActual = btnCultura;
        botonActual.setStyle("-fx-background-color: #ccc;");
        panelCultura.setVisible(true);
    }
    
       @FXML
    void mostrarTurismo(ActionEvent event) {
        panelActual.setVisible(false);
        panelActual = panelTurismo;
        botonActual.setStyle("-fx-background-color: #fff;");
        botonActual = btnTurismo;
        botonActual.setStyle("-fx-background-color: #ccc;");
        panelTurismo.setVisible(true);
    }
    
       @FXML
    void mostrarHistoria(ActionEvent event) {
        panelActual.setVisible(false);
        panelActual = panelHistoria;
        botonActual.setStyle("-fx-background-color: #fff;");
        botonActual = btnHistoria;
        botonActual.setStyle("-fx-background-color: #ccc;");
        panelHistoria.setVisible(true);
    }
    
         @FXML
    void mostarMapa(ActionEvent event) {
        panelActual.setVisible(false);
        panelActual = panelMapa;
        botonActual.setStyle("-fx-background-color: #fff;");
        botonActual = btnMap;
        botonActual.setStyle("-fx-background-color: #ccc;");
        panelMapa.setVisible(true);
    }
    
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
                    carteleraImg.setImage(new Image("file:.\\src\\fotos\\menu.jpg"));
                }
            }else if(tipo.equalsIgnoreCase("Tiendas")){
                if(list.get(i) instanceof Tiendas){
                    listaAnuncios.getItems().add(list.get(i)); 
                    carteleraImg.setImage(new Image("file:.\\src\\fotos\\productos.jpg"));
                }
            }else if(tipo.equalsIgnoreCase("Servicios")){
                if(list.get(i) instanceof Servicios){
                   listaAnuncios.getItems().add(list.get(i)); 
                   carteleraImg.setImage(new Image("file:.\\src\\fotos\\cine.png"));
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
                    carteleraImg.setImage(new Image("file:.\\src\\fotos\\menu.jpg"));
                }
            }else if(tipo.equalsIgnoreCase("Tiendas")){
                if(list.get(i) instanceof Tiendas){
                    listaAnuncios.getItems().add(list.get(i)); 
                    carteleraImg.setImage(new Image("file:.\\src\\fotos\\productos.jpg"));
                }
            }else if(tipo.equalsIgnoreCase("Servicios")){
                if(list.get(i) instanceof Servicios){
                   listaAnuncios.getItems().add(list.get(i));  
                   carteleraImg.setImage(new Image("file:.\\src\\fotos\\cine.png"));
                }
            }
         }
    }
    
     @FXML
    void vaerCartelera(ActionEvent event) {
        cartelera.setVisible(true);
    }
    
    @FXML 
    void volverAnuncio(ActionEvent event) {
        cartelera.setVisible(false);
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
        
        int intcontador = contador.getCont();
        
        cont.insertaLog(intcontador);
        
        contador.setCont(0);
        contador.setCuento(false);
        
        
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
            startAnimation(imgContainer);
            cont = new Controlador(this);
            
            list = cont.InicializarAnuncios();
            
            panelActual = panelInfoInfo;
            botonActual = btnInfo;
            
            //startAnimation(imgContainer);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void empezarDetector(ActionEvent event) {
        cont.getHiloRS().run();
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

    //ANIMACION Slide
    public void startAnimation(final HBox hbox) {
        EventHandler<ActionEvent> slideAction = (ActionEvent t) -> {
            TranslateTransition trans = new TranslateTransition(Duration.seconds(1.5), hbox);
            trans.setByX(-IMG_WIDTH);
            trans.setInterpolator(Interpolator.EASE_BOTH);
            trans.play();
        };
        EventHandler<ActionEvent> resetAction = (ActionEvent t) -> {
            TranslateTransition trans = new TranslateTransition(Duration.seconds(1), hbox);
            trans.setByX((NUM_OF_IMGS - 1) * IMG_WIDTH);
            trans.setInterpolator(Interpolator.EASE_BOTH);
            trans.play();
        };
 
        List<KeyFrame> keyFrames = new ArrayList<>();
        for (int i = 1; i <= NUM_OF_IMGS; i++) {
            if (i == NUM_OF_IMGS) {
                keyFrames.add(new KeyFrame(Duration.seconds(i * SLIDE_FREQ), resetAction));
            } else {
                keyFrames.add(new KeyFrame(Duration.seconds(i * SLIDE_FREQ), slideAction));
            }
        }
        Timeline anim = new Timeline(keyFrames.toArray(new KeyFrame[NUM_OF_IMGS]));
 
        anim.setCycleCount(Timeline.INDEFINITE);
        anim.playFromStart();
    }
    public void salirSlide(){
        if(cont.getSlideBlo().isSlideActivo() == true){
            contador = new Contador();
           System.out.println("Entra if");
            panelSlide.setVisible(false); 
            panelMenuPrincipal.setVisible(true);
            //animar(panelSlide, "centeRight");
            //animar(panelMenuPrincipal, "right");
       }else{
           System.out.println("Entra else");
            panelSlide.setVisible(true);
            panelInformacion.setVisible(false);
            panelHelp.setVisible(false);
            panelMenuPrincipal.setVisible(false);
            panelAnuncios.setVisible(false);
            panelTipoAnuncio.setVisible(false);
            panelAnuncio.setVisible(false);
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
}
