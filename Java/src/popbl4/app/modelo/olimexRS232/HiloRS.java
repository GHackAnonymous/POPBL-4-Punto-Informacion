/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.modelo.olimexRS232;

import javafx.animation.Timeline;
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
