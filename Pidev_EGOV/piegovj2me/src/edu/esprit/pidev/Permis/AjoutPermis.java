/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.esprit.piegov.entites.Permis;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
//import javax.microedition.lcdui.ChoiceGroup;
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
public class AjoutPermis extends Form implements CommandListener, Runnable, ItemStateListener {

    Permis carteedinar;
    HttpConnection http;
    DataInputStream dataStream;
    Command enregistrer = new Command("Enregistrer", Command.SCREEN, 3);
    Command retour = new Command("Retour", Command.EXIT, 0);

    private TextField numPermis;
    private DateField date_creation_permis;
    private TextField categorie_permis;
    private DateField date_validite_permis;
    private TextField numCinUtilisateur;
    private TextField validation;
    
//    private String [] categories = {"Musique","Jeux","Sport"};
//    ChoiceGroup categoriesList = new ChoiceGroup("Categories", ChoiceGroup.POPUP,categories ,null);

    Thread t;

    public AjoutPermis() {
        super("AjouterPermis");

        addCommand(enregistrer);
        addCommand(retour);

        t = new Thread(this);

        this.setItemStateListener(this);
        this.setCommandListener(this);
        t.start();

    }

    public void commandAction(Command c, Displayable d) {
        if (c == enregistrer) {
            ajouterPermis();

        }

        if (c == retour) {
      utils.StaticMidlet.disp.setCurrent(new MenuEroute());

            
        }
    }
    boolean valide = true;

    public boolean validerForlulaire() {

        if (numPermis.getString().equals("")) {
            valide = false;
        }

        return valide;
    }

    private void ajouterPermis() {

        if (validerForlulaire() == false) {
             utils.StaticMidlet.disp.setCurrent(new Alert("Erreur", "veuillez saisir tous les champs", null, AlertType.INFO), new AjoutPermis());

        } else {
            String url = "http://localhost/nihelMobile/jme/insert.php";
            //String url ="file:///C:/wamp/www/nihelMobile/jme/insert.php";
            try {
                url += "?numPermis=" + numPermis.getString().trim() + "&date_creation_permis=" + date_creation_permis.getDate().getTime() + "&categorie_permis=" + categorie_permis.getString().trim() + "&date_validite_permis=" + date_validite_permis.getDate().getTime()+ "&numCinUtilisateur=" + numCinUtilisateur.getString().trim() + "&validation=" + validation.getString().trim() ;
                System.out.println(url);

                HttpConnection hc = (HttpConnection) Connector.open(url.replace(' ', '+'));
                StringBuffer sb = new StringBuffer();
                int ch;

                DataInputStream dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {
                    sb.append((char) ch);
                }

                 utils.StaticMidlet.disp.setCurrent(new Alert("result", "la carte a été créé avec succes", null, AlertType.INFO), new afficheListePermis());

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void run() {

        numPermis = new TextField("numPermis", null, 50, TextField.ANY);
        date_creation_permis = new DateField("date_creation_permis", DateField.DATE);
        categorie_permis = new TextField("categorie_permis", null, 50, TextField.ANY);
        date_validite_permis = new DateField("date_validite_permis", DateField.DATE);
        numCinUtilisateur = new TextField("numCinUtilisateur", null, 50, TextField.ANY);
        validation = new TextField("validation", null, 50, TextField.ANY);
        
//        Calendar cal= Calendar.getInstance();
//        cal.setTime(date_dernier_retirement.getDate());
//        String date = cal.get(Calendar.YEAR) + "-" + ( cal.get(Calendar.MONTH)+1  ) + "-" + cal.get(Calendar.DAY_OF_MONTH);
       // date_dernier_versement = new DateField("date_dernier_versement", DateField.DATE);
       //date_creation = new DateField("date_creation", DateField.DATE);

        append(numPermis);
        append(date_creation_permis);
        append(categorie_permis);
        append(date_validite_permis);
        append(numCinUtilisateur);
        append(validation);

     

    }

    public void itemStateChanged(Item item) {
    }

}
