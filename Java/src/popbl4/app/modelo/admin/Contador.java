/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.modelo.admin;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

/**
 *
 * @author GHackAnonymous
 */
public class Contador{
    
    int cont = 0;
    Timeline oneSecondsWonder;
    boolean cuento = true;
    public Contador(){
        oneSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
            if(cuento){
                cont++;
                System.out.println(cont);
            }
        }
        }));
        oneSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        oneSecondsWonder.play();
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public Timeline getOneSecondsWonder() {
        return oneSecondsWonder;
    }

    public void setOneSecondsWonder(Timeline oneSecondsWonder) {
        this.oneSecondsWonder = oneSecondsWonder;
    }

    public boolean isCuento() {
        return cuento;
    }

    public void setCuento(boolean cuento) {
        this.cuento = cuento;
    }
    
}
