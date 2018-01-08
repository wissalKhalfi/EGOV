/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.ccp;

import edu.esprit.piegov.entites.Ccp;
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
public class UpdateCompte extends Form implements CommandListener,Runnable, ItemStateListener{
    Ccp ccpinsatance;
    Command saveCmd = new Command("Enregistrer", Command.SCREEN, 0);
    Command precedent = new Command("Retour", Command.EXIT, 0);
    
    private TextField code_ccp;
    private TextField solde_actuel;
    private DateField date_dernier_retirement;
    private DateField date_dernier_versement;
    private TextField dernier_versement;
    private TextField dernier_retirement;
    private DateField date_creation;
    Thread t;
 
    public UpdateCompte() {
        super("modifier ccp");
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
    url = "http://localhost/piegov/UpdateCcp.php";
        try {
//            ?offre_nom=test&offre_description=test&offre_prix=10&offre_reference=14
            url += "?num_ccp="+ListeCompte.num_ccp;
            url += "&code_ccp="+code_ccp.getString().trim() ;
            url += "&solde_actuel="+solde_actuel.getString().trim();
            url += "&date_dernier_retirement="+date_dernier_retirement.getDate().getTime();
            url += "&date_dernier_versement=" +date_dernier_versement.getDate().getTime() ;
            url += "&dernier_versement="+dernier_versement.getString();
            url += "&dernier_retirement="+dernier_retirement.getString();
            url += "&date_creation="+date_creation.getDate().getTime();
            System.out.println(url);
                        
            HttpConnection hc = (HttpConnection) Connector.open(url.replace(' ', '+'));
            StringBuffer sb = new StringBuffer();
            int ch;
            
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {                    
                    sb.append((char)ch);
                }
                
           
                    utils.StaticMidlet.disp.setCurrent(new Alert("result", "modification avec succes", null, AlertType.CONFIRMATION));

                
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void commandAction(Command c, Displayable d) {
             if (c == saveCmd) {
            modifier();

        }

        if (c == precedent) {
    utils.StaticMidlet.disp.setCurrent(new ListeCompte ());

            
        }
    }

    public void run() {

  
        code_ccp = new TextField("code_ccp", null, 30, TextField.ANY);
        solde_actuel = new TextField("solde_actuel", null, 50, TextField.ANY);
        dernier_versement = new TextField("dernier_versement", null, 50, TextField.ANY);
        dernier_retirement = new TextField("dernier_retirement", null, 50, TextField.ANY);
        date_dernier_retirement = new DateField("date_dernier_retirement", DateField.DATE);
        date_dernier_versement = new DateField("date_dernier_versement", DateField.DATE);
        date_creation = new DateField("date_creation", DateField.DATE);

        append(code_ccp);
        append(solde_actuel);
        append(dernier_versement);
        append(dernier_retirement);
        append(date_dernier_retirement);
        append(date_dernier_versement);
        append(date_creation);
     

    }    

    public void itemStateChanged(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}


