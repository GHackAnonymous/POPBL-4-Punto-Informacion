/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.olimexRS232;

import java.util.Observable;
import popbl4.app.sinInteraccion.FXMLDocumentController;

/**
 *
 * @author GHackAnonymous
 */
public class SlideBloqueado extends Observable{
     boolean slideActivo = false;

    public SlideBloqueado() {}

    public boolean isSlideActivo() {
        return slideActivo;
    }

    public void setSlideActivo(boolean slideActivo) {
        this.slideActivo = slideActivo;
        System.out.println("Se cambia la variable a: "+this.slideActivo);
        this.setChanged();
	this.notifyObservers();
    }
    
}
