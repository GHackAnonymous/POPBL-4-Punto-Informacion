/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.sinInteraccion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import popbl4.app.controladorMain.Controlador;
import popbl4.app.olimexRS232.ConexionRS232;
import popbl4.app.olimexRS232.HiloRS;
import popbl4.app.olimexRS232.SlideBloqueado;

/**
 *
 * @author GHackAnonymous
 */
public class VistaAnuncio extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //Controlador cont = new Controlador();
        /*ConexionRS232 conexionRS232 = new ConexionRS232();
        SlideBloqueado slideBlo = new SlideBloqueado();
        HiloRS hiloRS = new HiloRS(cont,conexionRS232,slideBlo); 
        hiloRS.run();*/
        /*FXMLLoader loader= new FXMLLoader();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       
        FXMLDocumentController controller = fxmlLoader.<FXMLDocumentController>getController();
        controller.pasarControlador(cont);
        
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        
        stage.show();*/
        
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));  
        
        
        Parent home_page_parent = (Parent)fxmlLoader.load();
        
        FXMLDocumentController controller = fxmlLoader.<FXMLDocumentController>getController();
        //controller.pasarControlador(cont);
        
        //HiloRS hiloRS = new HiloRS(controller.cont,controller.cont.getConexionRS232(),controller.cont.getSlideBlo());

        Scene home_page_scene = new Scene(home_page_parent);
        
        stage.setScene(home_page_scene);
        stage.show();
        
        
        
    }
    
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        
        launch(args);
    }
    
}
