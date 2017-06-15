/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.olimexRS232;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import popbl4.app.controladorMain.Controlador;

/**
 *
 * @author GHackAnonymous
 */
public class HiloRS extends Thread{

    Controlador cont;
    ConexionRS232 rs232;
    SlideBloqueado slideBlo;
    Timeline oneSecondsWonder;
    String detectar = null;
    
    public HiloRS(Controlador cont,ConexionRS232 rs232,SlideBloqueado slideBlo) {
        this.cont = cont;
        this.rs232 = rs232;
        this.slideBlo = slideBlo;
    }   
    /*public HiloRS(Controlador cont,ConexionRS232 rs232,SlideBloqueado slideBlo) {
        this.cont = cont;
        this.rs232 = rs232;
        this.slideBlo = slideBlo;
        
        
        oneSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
        
            boolean activo = false;
            
            @Override
            public void handle(ActionEvent event) {

               if(activo == false){
                    detectar = rs232.leerUsart();

                    if(detectar != null){
                        System.out.println("Detectar: "+detectar);
                        cont.getSlideBlo().setSlideActivo(true); 
                        activo = true;
                    }
                        
                }
            }
        }));
        oneSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        oneSecondsWonder.play();
        
        
        
    }*/
    @Override
    public void run(){
     comprobar();
    }
    public void comprobar(){
    
        String detectar = null;
        do{
            detectar = rs232.leerUsart();
            
            if(detectar != null){
                System.out.println("Detectar: "+detectar);
                slideBlo.setSlideActivo(true);
            }
        }while(detectar == null);

    }
}
