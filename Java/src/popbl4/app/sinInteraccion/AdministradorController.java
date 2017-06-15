/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.sinInteraccion;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.css.CssMetaData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import popbl4.app.admin.Administrador;
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
    private JFXButton bAceptar;
    
    // LOGIN
    @FXML
    private Pane panelLogin;
    @FXML
    private TextField textNick;
    @FXML
    private PasswordField textClave;
    @FXML
    private Label labelError;
    
    // Textos de Anuncio
    @FXML
    private TextField textTitulo;
    @FXML
    private TextField textURLFoto;
    @FXML
    private TextField textUbicaccion;
    @FXML
    private TextField textContacto;
    @FXML
    private TextField textHorarios;
    @FXML
    private TextField textDescripcion;
    @FXML
    private TextField textFecha;
    
    //Servicio
    @FXML
    private TextField textURLFotoServicios;
    @FXML
    private TextField textPrecio;
    
    //Gastronomia
    @FXML
    private TextField textNombreMenu;
    @FXML
    private TextField textIngredientes;
    @FXML
    private TextField textPrecioMenu;

    //Tiendas y Productos
    //Tienda
    @FXML
    private TextField textNombreTienda;
    //Producto
    @FXML
    private TextField textNombreProducto;
    @FXML
    private TextField textPrecioProducto;
    @FXML
    private TextField textURLFotoProducto;


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
        Anuncio aux = null;
        Menu m = null;
        Productos p = null;
        
        
        
        if(comboAnuncios.getSelectionModel().isSelected(2)){
            //Gastronomia
            aux = new Gastronomia();
            if (aux instanceof Gastronomia){
                m = new Menu();
                m.setNombre(textNombreMenu.getText());
                m.setIngedientes(textIngredientes.getText());
                m.setPrecio(textPrecioMenu.getText());
                ((Gastronomia)aux).setMenu(m);
            }
        }else if(comboAnuncios.getSelectionModel().isSelected(0)){
            //Tienda
            
            aux = new Tiendas();
            
            if(aux instanceof Tiendas){
                ((Tiendas)aux).setNombre(textNombreTienda.getText());

                p = new Productos();
                p.setNombre(textNombreProducto.getText());
                p.setPrecio(textPrecioProducto.getText());
                p.setUrl_foto_producto(textURLFotoProducto.getText()); 
                ((Tiendas)aux).setProducto(p);
            }
        }else if(comboAnuncios.getSelectionModel().isSelected(1)){
            //servicio
            
            aux = new Servicios();
            
            if (aux instanceof Servicios){
                ((Servicios)aux).setUrl_foto_servicio(textURLFotoServicios.getText());
                ((Servicios)aux).setPrecios(textPrecio.getText());
            }
        }
        
        aux.setTitulo(textTitulo.getText());
        aux.setURL_Foto(textURLFoto.getText());
        aux.setUbicacion(textUbicaccion.getText());
        aux.setContacto(textContacto.getText());
        aux.setHorarios(textHorarios.getText());
        aux.setDescripcion(textDescripcion.getText());
        aux.setFecha(textFecha.getText());
        
        boolean b = cont.InsertatAnuncio(aux,m,p);
        
        if(b == true){
            resetearTextField();
        
            bAceptar.setStyle("-fx-background-color:GREEN");
        }else{
            bAceptar.setStyle("-fx-background-color:RED");
        }
    }
    private void editableTextField(){
        textNombreMenu.setEditable(true);
        textIngredientes.setEditable(true);
        textPrecioMenu.setEditable(true);
        textNombreTienda.setEditable(true);
        textNombreProducto.setEditable(true);
        textPrecioProducto.setEditable(true);
        textURLFotoProducto.setEditable(true); 
        textURLFotoServicios.setEditable(true);
        textPrecio.setEditable(true);
        textTitulo.setEditable(true);
        textURLFoto.setEditable(true);
        textUbicaccion.setEditable(true);
        textContacto.setEditable(true);
        textHorarios.setEditable(true);
        textDescripcion.setEditable(true);
        textFecha.setEditable(true);
    }
    private void resetearTextField(){
        textNombreMenu.setText("");
        textIngredientes.setText("");
        textPrecioMenu.setText("");
        textNombreTienda.setText("");
        textNombreProducto.setText("");
        textPrecioProducto.setText("");
        textURLFotoProducto.setText(""); 
        textURLFotoServicios.setText("");
        textPrecio.setText("");
        textTitulo.setText("");
        textURLFoto.setText("");
        textUbicaccion.setText("");
        textContacto.setText("");
        textHorarios.setText("");
        textDescripcion.setText("");
        textFecha.setText("");
        bAceptar.setStyle("-fx-background-color:#ccc");
    }
    @FXML
    void selectCombo(ActionEvent event) {
        editableTextField();
        if(comboAnuncios.getSelectionModel().isSelected(2)){
            panelTiendas.setVisible(false);
            panelServicios.setVisible(false);
            panelGastronomia.setVisible(true);
        }else if(comboAnuncios.getSelectionModel().isSelected(0)){
            panelServicios.setVisible(false);
            panelGastronomia.setVisible(false);
            panelTiendas.setVisible(true);
        }else if(comboAnuncios.getSelectionModel().isSelected(1)){
            panelGastronomia.setVisible(false);
            panelTiendas.setVisible(false);
            panelServicios.setVisible(true);
        }
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
        
        resetearTextField();
        
        animar(panelAdministrador, "right");
        animar(panelAnadir, "centeRight");       
        //panelAnadir.setVisible(false);
        //panelAdministrador.setVisible(true);
    }
    @FXML
    void botonLogout(ActionEvent event) {
        animar(panelLogin, "right");
        animar(panelAdministrador, "centeRight");  
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
    @FXML
    void botonAtrasLogin(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));  
        
        
        Parent home_page_parent = (Parent)fxmlLoader.load();
        
        FXMLDocumentController controller = fxmlLoader.<FXMLDocumentController>getController();
        controller.pasarControlador(cont);

        Scene home_page_scene = new Scene(home_page_parent);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        
        stage.setScene(home_page_scene);
        stage.show();
    }
    @FXML
    void pulsarBotonLogin(ActionEvent event) throws ClassNotFoundException {
        Administrador aux = new Administrador();
	aux.setUsername(textNick.getText());
	aux.setContraseña(textClave.getText());
        
        boolean login = cont.login(aux);
	if(login == true){
            //Cambiar de pantalla
            login = false;
            textNick.setText("");
            textClave.setText("");
            
            labelError.setVisible(false);
            animar(panelLogin, "leftCenter");
            animar(panelAdministrador, "left");
            //panelAdministrador.setVisible(false);
            panelAdministrador.setVisible(true);
	}else{
            labelError.setVisible(true);
            //Hacer lo que se quiera)
	}
    }
}
