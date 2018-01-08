/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.piegov.carteedinar;

import edu.esprit.pidev.admin.Acceuil_Admin;
import edu.esprit.piegov.entites.CarteEdinar;
import edu.esprit.piegov.handlers.CarteedinarHandler;
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
import utils.StaticMidlet;

/**
 *
 * @author USER
 */
public class ListeCartes extends List implements CommandListener, Runnable {

    String[] listData;
    CarteEdinar[] CarteData;
    static int num_carte = 0;
    String critere = "";
    static CarteEdinar CarteDetail;

    Command backCmd = new Command("Retour", Command.EXIT, 0);
    Command AddCmd = new Command("Ajouter", Command.SCREEN, 2);
    Command rechercherCmd = new Command("Rechercher", Command.SCREEN, 3);
    Command supprimerCmd = new Command("Supprimer", Command.SCREEN, 3);
    Command BlockerCmd = new Command("Bloquer", Command.SCREEN, 3);
    Command ModifierCmd = new Command("Modifier", Command.SCREEN, 3);
    Command cartesCmd = new Command("ListeCartes", Command.SCREEN, 4);
    Command demoCmd = new Command("audio", Command.SCREEN, 4);

    Thread t;

    public ListeCartes() {
        super("Cartes", IMPLICIT);

        addCommand(backCmd);
        addCommand(AddCmd);
        addCommand(rechercherCmd);
        setCommandListener(this);
        t = new Thread(this);
        t.start();

    }

    public ListeCartes(int num_carte) {
        super("Résultat de la recherche", IMPLICIT);
        this.num_carte = num_carte;
        addCommand(backCmd);
        addCommand(supprimerCmd);
        addCommand(BlockerCmd);
        addCommand(cartesCmd);
        addCommand(BlockerCmd);
        addCommand(ModifierCmd);
        
        setCommandListener(this);
        t = new Thread(this);
        t.start();

    }

    private CarteEdinar[] setAllCartes() {

        CarteEdinar[] carte_table = null;
        String requete = "http://localhost/piegov/selectAllcartes.php";
        if (num_carte > 0) {
            requete = "http://localhost/piegov/selectcartebynum.php?num_carte=" + num_carte;
            System.out.println("cartelist: requete affichage carte par num: " + requete);
        }

        try {
            CarteedinarHandler itiHandler = new CarteedinarHandler();
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
        CarteData = setAllCartes();
        if (CarteData != null) {
            if (CarteData.length != 0) {
                listData = new String[CarteData.length];

                for (int i = 0; i < CarteData.length; i++) {
                    listData[i] = "\n Num_carte            : " + CarteData[i].getNum_carte()
                            + "\n Code_carte          : " + CarteData[i].getCode_carte()
                            + "\n solde_actuel  : " + CarteData[i].getSolde_actuel()
                            + "\n date_dernier_retirement: " + CarteData[i].getDate_dernier_retirement();

                }
            }
        } else {
            append("Pas de cartes", null);
        }
    }


    private void deleteBillet() {
        System.out.println("delete carte");
        String url = "http://localhost/piegov/DeleteCarteEdinar.php";
        try {

            url += "?num_carte=" + num_carte;
            //affichage requete

            System.out.println(url);

            HttpConnection hc = (HttpConnection) Connector.open(url.replace(' ', '+'));
            StringBuffer sb = new StringBuffer();
            int ch;

            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            while ((ch = dis.read()) != -1) {
                sb.append((char) ch);
            }

            System.out.println("resultat requete supression " + sb.toString());
            if ("true".equalsIgnoreCase(sb.toString().trim())) {
                utils.StaticMidlet.disp.setCurrent(new Alert("result", "Carte supprimé avec succes", null, AlertType.INFO), new ListeCartes(0));
            } else {
                utils.StaticMidlet.disp.setCurrent(new Alert("result", "Echec de la suppression de billets", null, AlertType.ERROR), new ListeCartes(0));
            }
            utils.StaticMidlet.disp.setCurrent(new Alert("result", "Carte supprimé avec succes", null, AlertType.INFO), new ListeCartes(0));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void commandAction(Command c, Displayable d) {

        if (c == rechercherCmd) {
            utils.StaticMidlet.disp.setCurrent(new Recherchecarte());
        }

                if (c == cartesCmd) {
            utils.StaticMidlet.disp.setCurrent(this);
        }
                if (c == ModifierCmd) {
            utils.StaticMidlet.disp.setCurrent(new UpdateCarteedinar());
        }

        if (List.SELECT_COMMAND == c) {

            CarteDetail = CarteData[this.getSelectedIndex()];
            utils.StaticMidlet.disp.setCurrent(new CarteDetail(CarteData[this.getSelectedIndex()]));

        }
        if (c == AddCmd) {
            utils.StaticMidlet.disp.setCurrent(new AjouterCarteedinar());

        }
        if (c == backCmd) {
            utils.StaticMidlet.disp.setCurrent(new Acceuil_Admin());

        }

        if (c == supprimerCmd) {
            deleteBillet();
        }
        if (c == rechercherCmd) {
            utils.StaticMidlet.disp.setCurrent(new Recherchecarte());

        }
    

//
//        if (c == AddCmd) {
//            utils.StaticMidlet.disp.setCurrent(new EvenementAjout());
//        }
//        if (c == backCmd) {
//                        if(Session.isAdherent())
//            {
//             MenuEvenementAdherent1 mf = new MenuEvenementAdherent1(StaticMidlet.disp);
//              mf.show();            }
//            else if (Session.isPrestataire())
//            {
////                utils.StaticMidlet.disp.setCurrent(new OffresAccueilPrestataire());
//              MenuEvenementPrestataire1 mf = new MenuEvenementPrestataire1(StaticMidlet.disp);
//              mf.show(); 
//            }
//        }
//        if (c == evenementsCmd) {
//            utils.StaticMidlet.disp.setCurrent(new EvenementListAdherent());
//        }
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
