/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.compte;

import edu.esprit.pidev.admin.Acceuil_Admin;
import edu.esprit.piegov.carteedinar.ListeCartes;
import edu.esprit.piegov.entites.Ccp;
import edu.esprit.piegov.handlers.CcpHandler;
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
public class ListeCompte extends List implements CommandListener, Runnable{
     String[] listData;
    Ccp[] Ccp;
    static int num_ccp = 0;
    String critere = "";
    static Ccp CarteDetail;

    Command backCmd = new Command("Retour", Command.EXIT, 0);
    Command AddCmd = new Command("Ajouter", Command.SCREEN, 2);
    Command rechercherCmd = new Command("Rechercher", Command.SCREEN, 3);
    Command supprimerCmd = new Command("Supprimer", Command.SCREEN, 3);
    Command BlockerCmd = new Command("Bloquer", Command.SCREEN, 3);
    Command ModifierCmd = new Command("Modifier", Command.SCREEN, 3);
    Command cartesCmd = new Command("ListeComptes", Command.SCREEN, 4);
    Command demoCmd = new Command("audio", Command.SCREEN, 4);
    
    Thread t;


    public ListeCompte() {   
        super("Comptes", IMPLICIT);
        addCommand(backCmd);
        addCommand(AddCmd);
        addCommand(rechercherCmd);
        setCommandListener(this);
        t = new Thread(this);
        t.start();

    }

    public ListeCompte(int num_ccp) {
        super("Résultat de la recherche", IMPLICIT);
        this.num_ccp = num_ccp;
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
     private Ccp[] setAllCartes() {

        Ccp[] carte_table = null;
        String requete = "http://localhost/piegov/selectAllccps.php";
        if (num_ccp > 0) {
            requete = "http://localhost/piegov/selectccpbynum.php?num_ccp=" + num_ccp;
            System.out.println("ccp: requete affichage ccp par num: " + requete);
        }

        try {
            CcpHandler itiHandler = new CcpHandler();
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
        Ccp = setAllCartes();
        if (Ccp != null) {
            if (Ccp.length != 0) {
                listData = new String[Ccp.length];

                for (int i = 0; i < Ccp.length; i++) {
                    listData[i] = "\n Num_ccp            : " + Ccp[i].getNum_ccp()
                            + "\n Code_ccp         : " + Ccp[i].getCode_ccp()
                            + "\n solde_actuel  : " + Ccp[i].getSolde_actuel()
                            + "\n date_dernier_retirement: " + Ccp[i].getDate_dernier_retirement();

                }
            }
        } else {
            append("Pas de comptes", null);
        }
    }
     private void deleteBillet() {
        System.out.println("delete carte");
        String url = "http://localhost/piegov/DeleteCcp.php";
        try {

            url += "?num_ccp=" + num_ccp;
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
                utils.StaticMidlet.disp.setCurrent(new Alert("result", "ccp supprimé avec succes", null, AlertType.INFO), new ListeCompte(0));
            } else {
                utils.StaticMidlet.disp.setCurrent(new Alert("result", "Echec de la suppression du ccp", null, AlertType.ERROR), new ListeCompte(0));
            }
            utils.StaticMidlet.disp.setCurrent(new Alert("result", "ccp supprimé avec succes", null, AlertType.INFO), new ListeCompte(0));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }



    public void commandAction(Command c, Displayable d) {
     if (c == rechercherCmd) {
            utils.StaticMidlet.disp.setCurrent(new Recherchecompte());
        }

                if (c == cartesCmd) {
            utils.StaticMidlet.disp.setCurrent(this);
        }
                if (c == ModifierCmd) {
            utils.StaticMidlet.disp.setCurrent(new UpdateCompte());
        }

        if (List.SELECT_COMMAND == c) {

            CarteDetail = Ccp[this.getSelectedIndex()];
            utils.StaticMidlet.disp.setCurrent(new CompteDetail(Ccp[this.getSelectedIndex()]));

        }
        if (c == AddCmd) {
            utils.StaticMidlet.disp.setCurrent(new AjoutecCompte());

        }
        if (c == backCmd) {
            utils.StaticMidlet.disp.setCurrent(new Acceuil_Admin());

        }

        if (c == supprimerCmd) {
            deleteBillet();
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
