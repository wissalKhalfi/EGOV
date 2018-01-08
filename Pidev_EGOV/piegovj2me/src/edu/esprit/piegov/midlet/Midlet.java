package edu.esprit.piegov.midlet;



import edu.esprit.pidev.admin.Acceuil_Admin;
import edu.esprit.piegov.gui.IntroCanvas;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.*;

//import utils.Functions;

public class Midlet extends MIDlet implements CommandListener{
    Display display = Display.getDisplay(this);
    public void startApp() 
    {
        utils.StaticMidlet.mainMid = this;
        utils.StaticMidlet.disp = display;
//      display.setCurrent(new AccueilPrestataire());
//        display.setCurrent(new EventoCanvas());
//        display.setCurrent(new Authentification());
        display.setCurrent(new IntroCanvas());
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
      
    }

}
