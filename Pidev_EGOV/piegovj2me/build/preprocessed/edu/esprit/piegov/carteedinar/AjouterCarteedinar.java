/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.piegov.carteedinar;

import edu.esprit.piegov.entites.CarteEdinar;
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
public class AjouterCarteedinar extends Form implements CommandListener, Runnable, ItemStateListener {

    CarteEdinar carteedinar;
    HttpConnection http;
    DataInputStream dataStream;
    Command enregistrer = new Command("Enregistrer", Command.SCREEN, 3);
    Command retour = new Command("Retour", Command.EXIT, 0);

    private TextField num_carte;
    private TextField code_carte;
    private TextField solde_actuel;
    private DateField date_dernier_retirement;
    private DateField date_dernier_versement;
    private TextField dernier_versement;
    private TextField dernier_retirement;
    private DateField date_creation;
//    private String [] categories = {"Musique","Jeux","Sport"};
//    ChoiceGroup categoriesList = new ChoiceGroup("Categories", ChoiceGroup.POPUP,categories ,null);

    Thread t;

    public AjouterCarteedinar() {
        super("AjouterCarteedinar");

        addCommand(enregistrer);
        addCommand(retour);

        t = new Thread(this);

        this.setItemStateListener(this);
        this.setCommandListener(this);
        t.start();

    }

    public void commandAction(Command c, Displayable d) {
        if (c == enregistrer) {
            ajouterCarte();

        }

        if (c == retour) {
    utils.StaticMidlet.disp.setCurrent(new ListeCartes ());

            
        }
    }
    boolean valide = true;

    public boolean validerForlulaire() {

        if (num_carte.getString().equals("")|| code_carte.getString().equals("")||solde_actuel.getString().equals("")||date_dernier_retirement.getDate().equals("")||
                date_dernier_versement.getDate().equals("")||dernier_versement.getString().equals("")||dernier_retirement.getString().equals("")||date_creation.getDate().equals("")) {    

            valide = false;
        }

        return valide;
    }

    private void ajouterCarte() {

        if (validerForlulaire() == false) {
            utils.StaticMidlet.disp.setCurrent(new Alert("Erreur", "veuillez saisir tous les champs", null, AlertType.INFO), new AjouterCarteedinar());

        } else {
            String url = "http://localhost/piegov/InsertCarteEdinar.php";
            try {
                url += "?num_carte=" + num_carte.getString().trim() + "&code_carte=" + code_carte.getString().trim() + "&solde_actuel=" + solde_actuel.getString().trim() + "&date_dernier_retirement=" + date_dernier_retirement.getDate().getTime() + "&date_dernier_versement=" + date_dernier_versement.getDate().getTime() + "&dernier_versement=" + dernier_versement.getString().trim() + "&dernier_retirement=" + dernier_retirement.getString().trim() + "&date_creation=" + date_creation.getDate().getTime();
                System.out.println(url);

                HttpConnection hc = (HttpConnection) Connector.open(url.replace(' ', '+'));
                StringBuffer sb = new StringBuffer();
                int ch;

                DataInputStream dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {
                    sb.append((char) ch);
                }

                utils.StaticMidlet.disp.setCurrent(new Alert("result", "la carte a été créé avec succes", null, AlertType.INFO), new ListeCartes());

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void run() {

        num_carte = new TextField("num_carte", null, 50, TextField.ANY);
        code_carte = new TextField("code_carte", null, 30, TextField.ANY);
        solde_actuel = new TextField("solde_actuel", null, 50, TextField.ANY);
        dernier_versement = new TextField("dernier_versement", null, 50, TextField.ANY);
        dernier_retirement = new TextField("dernier_retirement", null, 50, TextField.ANY);
        date_dernier_retirement = new DateField("date_dernier_retirement", DateField.DATE);
//        Calendar cal= Calendar.getInstance();
//        cal.setTime(date_dernier_retirement.getDate());
//        String date = cal.get(Calendar.YEAR) + "-" + ( cal.get(Calendar.MONTH)+1  ) + "-" + cal.get(Calendar.DAY_OF_MONTH);
        date_dernier_versement = new DateField("date_dernier_versement", DateField.DATE);
        date_creation = new DateField("date_creation", DateField.DATE);

        append(num_carte);
        append(code_carte);
        append(solde_actuel);
        append(dernier_versement);
        append(dernier_retirement);
        append(date_dernier_retirement);
        append(date_dernier_versement);
        append(date_creation);
     

    }

    public void itemStateChanged(Item item) {
    }

}
