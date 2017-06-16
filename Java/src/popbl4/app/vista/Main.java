/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author GHackAnonymous
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));  
        
        
        Parent home_page_parent = (Parent)fxmlLoader.load();

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
