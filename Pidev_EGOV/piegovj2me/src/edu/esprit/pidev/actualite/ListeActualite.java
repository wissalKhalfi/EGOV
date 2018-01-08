/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.actualite;

import edu.esprit.pidev.admin.Acceuil_Admin;
import edu.esprit.piegov.carteedinar.AjouterCarteedinar;
import edu.esprit.piegov.carteedinar.ListeCartes;
import edu.esprit.piegov.carteedinar.Recherchecarte;
import edu.esprit.piegov.carteedinar.UpdateCarteedinar;
import edu.esprit.piegov.entites.Articles;
import edu.esprit.piegov.handlers.ActualiteHandler;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 *
 * @author USER
 */
public class ListeActualite extends List implements CommandListener, Runnable {

    String[] listData;
    Articles[] ActuData;
    String type = "";
    String critere = "";
    static Articles ActualiteDetails;
    Command backCmd = new Command("Retour", Command.EXIT, 0);
    Command AddCmd = new Command("Ajouter", Command.SCREEN, 2);
    Command ActuCmd = new Command("Ajouter", Command.SCREEN, 2);
    Command rechercherCmd = new Command("Rechercher", Command.SCREEN, 3);
    Command supprimerCmd = new Command("Supprimer", Command.SCREEN, 3);
    Command ModifierCmd = new Command("Modifier", Command.SCREEN, 3);
    Thread t;

    public ListeActualite() {
        super("Actualités", IMPLICIT);
        addCommand(backCmd);
        addCommand(AddCmd);
        addCommand(rechercherCmd);
   

        setCommandListener(this);
        t = new Thread(this);
        t.start();
    }

    public ListeActualite(String type) {
        super("Résultat de la recherche", IMPLICIT);
        this.type = type;
        addCommand(backCmd);
        addCommand(supprimerCmd);
        addCommand(ActuCmd);
        addCommand(ModifierCmd);
        setCommandListener(this);
        t = new Thread(this);
        t.start();
    }

    private Articles[] setAllArticles() {

        Articles[] carte_table = null;
        String requete = "http://localhost/piegov/selectAllActus.php";
        if(! type.equals("")) {
            requete = "http://localhost/piegov/selectactubytype.php?type=" + type;
            System.out.println("actulist: requete affichage actualite par type: " + requete);
        }

        try {
            ActualiteHandler itiHandler = new ActualiteHandler();
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            HttpConnection hc = (HttpConnection) Connector.open(requete);
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, itiHandler);
            carte_table = itiHandler.getCartes();

        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        return carte_table;
    }
     

    private void setListData() {
        ActuData = setAllArticles();
        if (ActuData != null) {
            if (ActuData.length != 0) {
                listData = new String[ActuData.length];

                for (int i = 0; i < ActuData.length; i++) {
                    listData[i] = "\n Id_article            : " + ActuData[i].getId_article()
                            + "\n Titre_article          : " + ActuData[i].getTitre_article()
                            + "\n Texte article : " + ActuData[i].getTexte_article()
                            + "\n date_article: " + ActuData[i].getDate_article()
                            + "\n priorite_pub: " + ActuData[i].getPriorite_pub()
                            + "\n Type: " + ActuData[i].getType();

                }
            }
        } else {
            append("Pas d'Actualités", null);
        }
    }

    public void commandAction(Command c, Displayable d) {

        if (c == rechercherCmd) {
            utils.StaticMidlet.disp.setCurrent(new RechercherActualite());
        }

        if (c == ModifierCmd) {
            utils.StaticMidlet.disp.setCurrent(new UpdateActualite());
        }

        if (List.SELECT_COMMAND == c) {

            ActualiteDetails = ActuData[this.getSelectedIndex()];
            utils.StaticMidlet.disp.setCurrent(new ActualiteDetails(ActuData[this.getSelectedIndex()]));

        }
        if (c == AddCmd) {
            utils.StaticMidlet.disp.setCurrent(new AjouterActualite());

        }
        if (c == backCmd) {
            utils.StaticMidlet.disp.setCurrent(new Acceuil_Admin());

        }
        if (c == ActuCmd) {
            utils.StaticMidlet.disp.setCurrent(this);

        }

        if (c == supprimerCmd) 
  
        {
            utils.StaticMidlet.disp.setCurrent(new SupprimerActualite(ActuData[this.getSelectedIndex()]));
            System.out.println(ActuData[this.getSelectedIndex()]);
             }
    }   
    
    public void run() {
        setListData();
        if (listData != null) {
            for (int i = 0; i < listData.length; i++) {
                append(listData[i], null);

            }
        }
    }
}
