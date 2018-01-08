package edu.esprit.piegov.Passeport;


import java.io.DataInputStream;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;

public class FindPasseportt extends Form implements CommandListener, Runnable {

    HttpConnection http;
    DataInputStream dataStream;

//    commands
    Command rechercherCmd = new Command("Rechercher", Command.SCREEN, 3);
    Command precedent = new Command("Retour", Command.EXIT, 0);

    //    form elements
    TextField CritereTF = new TextField("num Passeport:", null, 1000, TextField.ANY);

    public FindPasseportt() {
        super("Rechercher Passeport");
        append(CritereTF);
        this.setCommandListener(this);
        addCommand(rechercherCmd);
        addCommand(precedent);
    }    
    
    public void commandAction(Command c, Displayable d) {
        if (c == rechercherCmd) {
            if (validerFormulaire()) {
              utils.StaticMidlet.disp.setCurrent(new PasseportSearchResult(CritereTF.getString()));
            }
        }
        if (c == precedent) {
          
        }
        
    }
    
    private boolean validerFormulaire() {
        boolean continuer = true;
        String erreur = "";
        
        if (CritereTF.getString().length() == 0) {
            continuer = false;
            erreur += "Saisir un prix de recherche \n";
        }
        
        if (!continuer) {
//            utils.StaticMidlet.disp.setCurrent(new Alert("erreur", erreur, null, AlertType.ERROR));
        }
        
        return continuer;
    }
    
    public void run() {
    }
    
}
