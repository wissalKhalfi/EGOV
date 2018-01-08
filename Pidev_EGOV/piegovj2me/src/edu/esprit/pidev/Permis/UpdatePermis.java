/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egov_mobile.gui;


import egov_mobile.Midlet;
import egov_mobile.entities.Permis;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemStateListener;
import javax.microedition.lcdui.TextField;

/**
 *
 * @author USER
 */
public class UpdatePermis extends Form implements CommandListener,Runnable, ItemStateListener{
    Permis permis;
    Command saveCmd = new Command("Enregistrer", Command.SCREEN, 0);
    Command precedent = new Command("Retour", Command.EXIT, 0);
    
     private TextField numPermis;
    private DateField date_creation_permis;
    private TextField categorie_permis;
    private DateField date_validite_permis;
    private TextField numCinUtilisateur;
    private TextField validation;
    Thread t;

    public UpdatePermis() {
        super("modifier permis");
        addCommand(saveCmd);
        addCommand(precedent);
                t = new Thread(this);

        this.setItemStateListener(this);
        this.setCommandListener(this);
        t.start();
    }
    private void modifier()
    {System.out.println("modification time");
    String url="";
    url = "http://localhost/nihelMobile/jme/UpdatePermis.php";
        try {
//            ?offre_nom=test&offre_description=test&offre_prix=10&offre_reference=14
            url += "?numPermis="+afficheListePermis.numPermis;
            url += "&date_creation_permis="+date_creation_permis.getDate().getTime();
            url += "&categorie_permis="+categorie_permis.getString();
            url += "&date_validite_permis=" +date_validite_permis.getDate().getTime() ;
            url += "&numCinUtilisateur="+numCinUtilisateur.getString();
            url += "&validation="+validation.getString();
            
            System.out.println(url);
                        
            HttpConnection hc = (HttpConnection) Connector.open(url.replace(' ', '+'));
            StringBuffer sb = new StringBuffer();
            int ch;
            
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {                    
                    sb.append((char)ch);
                }
                
           
                    Midlet.INSTANCE.disp.setCurrent(new Alert("result", "modification avec succes", null, AlertType.CONFIRMATION));

                
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void commandAction(Command c, Displayable d) {
             if (c == saveCmd) {
            modifier();

        }

        if (c == precedent) {
    Midlet.INSTANCE.disp.setCurrent(new afficheListePermis ());

            
        }
    }

    public void run() {

       numPermis = new TextField("numPermis", null, 50, TextField.ANY);
        date_creation_permis = new DateField("date_creation_permis", DateField.DATE);
        categorie_permis = new TextField("categorie_permis", null, 50, TextField.ANY);
        date_validite_permis = new DateField("date_validite_permis", DateField.DATE);
        //numCinUtilisateur = new TextField("numCinUtilisateur", null, 50, TextField.ANY);
        validation = new TextField("validation", null, 50, TextField.ANY);
        


        append(numPermis);
        append(date_creation_permis);
        append(categorie_permis);
        append(date_validite_permis);
        ///append(numCinUtilisateur);
        append(validation);
     

    }    

    public void itemStateChanged(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
