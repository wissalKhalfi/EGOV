/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egov_mobile.gui;

//import edu.esprit.pidev.admin.Acceuil_Admin;
//import edu.esprit.piegov.entites.CarteEdinar;
//import edu.esprit.piegov.gui.videoForm;
//import edu.esprit.piegov.handlers.CarteedinarHandler;
import egov_mobile.Midlet;
import egov_mobile.entities.Permis;
import egov_mobile.handler.PermisHandler;
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
//import utils.StaticMidlet;

/**
 *
 * @author USER
 */
public class afficheListePermis extends List implements CommandListener, Runnable {

    String[] listData;
    Permis[] permis;
    static int numPermis = 0;
    String critere = "";
    static Permis afficheListePermis1;

    Command backCmd = new Command("Retour", Command.EXIT, 0);
    Command AddCmd = new Command("Ajouter", Command.SCREEN, 2);
    Command rechercherCmd = new Command("Rechercher", Command.SCREEN, 3);
    Command supprimerCmd = new Command("Supprimer", Command.SCREEN, 3);
    Command BlockerCmd = new Command("Bloquer", Command.SCREEN, 3);
    Command ModifierCmd = new Command("Modifier", Command.SCREEN, 3);
    Command cartesCmd = new Command("ListePermis", Command.SCREEN, 4);
    Command demoCmd = new Command("audio", Command.SCREEN, 4);

    Thread t;

    public afficheListePermis() {
        super("Permis", IMPLICIT);

        addCommand(backCmd);
        addCommand(AddCmd);
        addCommand(rechercherCmd);
        addCommand(supprimerCmd);
        addCommand(ModifierCmd);
        addCommand(cartesCmd);
        setCommandListener(this);
        t = new Thread(this);
        t.start();

    }

    public afficheListePermis(int numPermis) {
        super("Résultat de la recherche", IMPLICIT);
        this.numPermis = numPermis;
        addCommand(backCmd);
        addCommand(supprimerCmd);
        addCommand(BlockerCmd);
        addCommand(cartesCmd);
        addCommand(BlockerCmd);
        addCommand(ModifierCmd);
        addCommand(demoCmd);
        setCommandListener(this);
        t = new Thread(this);
        t.start();

    }

    private Permis[] setAllPermis() {

        Permis[] permis_table = null;
        String requete = "http://localhost/nihelMobile/jme/select.php";
        if (numPermis > 0) {
            requete = "http://localhost/nihelMobile/jme/selectByNumPermis.php?numPermis=" + numPermis;
            System.out.println("permislist: requete affichage permis par numPermis: " + requete);
        }

        try {
            PermisHandler itiHandler = new PermisHandler();
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            HttpConnection hc = (HttpConnection) Connector.open(requete);
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, itiHandler);
            permis_table = itiHandler.getPermis();

        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        return permis_table;
    }
 
    private void setListData() {
        permis = setAllPermis();
        if (permis != null) {
            if (permis.length != 0) {
                listData = new String[permis.length];

                for (int i = 0; i < permis.length; i++) {
                    listData[i] = "\n NumPermis            : " + permis[i].getNumPermis()
                            + "\n date_creation_permis          : " + permis[i].getDate_creation_permis()
                            + "\n categorie_permis  : " + permis[i].getCategorie_permis()
                            + "\n date_validite_permis: " + permis[i].getDate_validite_permis()
                            + "\n numCinUtilisateur  : " + permis[i].getNumCinUtilisateur()
                            + "\n validation : " + permis[i].getValidation();

                }
            }
        } else {
            append("Pas de Permis", null);
        }
    }


    private void deletePermis() {
        System.out.println("delete permis");
        String url = "http://localhost/nihelMobile/jme/DeletePermis.php";
        try {

            url += "?numPermis=" + numPermis;
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
                Midlet.INSTANCE.disp.setCurrent(new Alert("result", "Permis supprimé avec succes", null, AlertType.INFO), new afficheListePermis(0));
            } else {
                Midlet.INSTANCE.disp.setCurrent(new Alert("result", "Echec de la suppression de Permis", null, AlertType.ERROR), new afficheListePermis(0));
            }
            Midlet.INSTANCE.disp.setCurrent(new Alert("result", "Permis supprimé avec succes", null, AlertType.INFO), new afficheListePermis(0));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void commandAction(Command c, Displayable d) {

        if (c == rechercherCmd) {
            Midlet.INSTANCE.disp.setCurrent(new RecherchePermis());
        }

                if (c == cartesCmd) {
            Midlet.INSTANCE.disp.setCurrent(new afficheListePermis());
        }
                if (c == ModifierCmd) {
            Midlet.INSTANCE.disp.setCurrent(new UpdatePermis());
        }

        if (List.SELECT_COMMAND == c) {

            afficheListePermis1 = permis[this.getSelectedIndex()];
            Midlet.INSTANCE.disp.setCurrent(new afficheListePermis1(permis[this.getSelectedIndex()]));

        }
        if (c == AddCmd) {
            Midlet.INSTANCE.disp.setCurrent(new AjoutPermis());

        }
        if (c == backCmd) {
            Midlet.INSTANCE.disp.setCurrent(new MenuEroute());

        }

        if (c == supprimerCmd) {
            deletePermis();
        }
        if (c == rechercherCmd) {
            Midlet.INSTANCE.disp.setCurrent(new RecherchePermis());

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
