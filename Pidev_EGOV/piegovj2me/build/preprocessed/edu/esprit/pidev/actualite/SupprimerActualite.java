package edu.esprit.pidev.actualite;

import edu.esprit.piegov.entites.Articles;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemStateListener;

public class SupprimerActualite extends Form implements CommandListener,Runnable, ItemStateListener{
    Articles ville_instance;
    HttpConnection http;
    DataInputStream dataStream;
    
    Thread t;

    public SupprimerActualite(Articles ville_instance){
        super("Supprimer Article");
        this.ville_instance = ville_instance;
        
        t = new Thread(this);
        t.start();
        this.setItemStateListener(this);
        this.setCommandListener(this);
        
    }


    public void commandAction(Command c, Displayable d) {
    }

    private void deleteVille(){
        System.out.println("delete time");
        String url = "http://localhost/piegov/DeleteActualite.php";
        try {
            
            url += "?id_article="+ville_instance.getId_article();
            //affichage requete
            
            System.out.println(url);
            
            HttpConnection hc = (HttpConnection) Connector.open(url.replace(' ', '+'));
            StringBuffer sb = new StringBuffer();
            int ch;
            
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {                    
                    sb.append((char)ch);
                }
                
                System.out.println("resultat requete supression "+sb.toString());
                if ("true".equalsIgnoreCase(sb.toString().trim())) 
                {
                    utils.StaticMidlet.disp.setCurrent(new Alert("result", "Actualité supprimée avec succes", null, AlertType.INFO),new ListeActualite());
                }
                else
                {
                    utils.StaticMidlet.disp.setCurrent(new Alert("result", "Echec de la suppression de l'actualité", null, AlertType.ERROR),new ListeActualite());
                }
                   utils.StaticMidlet.disp.setCurrent(new Alert("result", "Actualité supprimée avec succes", null, AlertType.INFO),new ListeActualite());

                
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    
    }
    
    
    public void run() {

            deleteVille();
    }

    public void itemStateChanged(Item item) {
    }
}
