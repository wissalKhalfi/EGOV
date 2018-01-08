/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.Utilisateur;


import edu.esprit.pidev.DAO.UtilisateurDAO;
import edu.esprit.piegov.entites.Utilisateur;
import java.util.Date;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextField;

/**
 *
 * @author macbookpro
 */
public class UtilisateurAdd extends Form implements CommandListener, Runnable {

    TextField tfNom = new TextField("Nom : ", "", 50, TextField.ANY);
    TextField tfPrenom = new TextField("Prenom : ", "", 50, TextField.ANY);
    TextField tflieu = new TextField("Lieu de naissance : ", "", 50, TextField.ANY);
    String items[] = {"Masculin", "Feminin"};
    ChoiceGroup sexe = new ChoiceGroup("Sexe", Choice.POPUP, items, null);
    DateField dateNaiss = new DateField("Date de naissance", DateField.DATE);
    Command cmdEnregistrer = new Command("Enregistrer", Command.SCREEN, 0);
    Command cmdBack = new Command("Back", Command.EXIT, 0);

    public UtilisateurAdd() {

        super("Utilsateur");
        append(tfNom);
        append(tfPrenom);
        append(sexe);
        append(dateNaiss);
        append(tflieu);
        addCommand(cmdEnregistrer);
        addCommand(cmdBack);
        setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdBack) {
           utils.StaticMidlet.disp.setCurrent(new UtilisateurList());
        }
        if (c == cmdEnregistrer) {
            Thread th = new Thread(this);
            th.start();
        }
    }

    public void run() {
        String strsexe = sexe.getSelectedIndex() == 0 ? "Masculin" : "Feminin";
        String strNom = tfNom.getString();
        String strPrenom = tfPrenom.getString();
        String strLieu = tflieu.getString();
        Date dateN = dateNaiss.getDate();
        boolean result;
        if (strsexe != null && strNom != null && strPrenom != null && dateN != null) {
            result = new UtilisateurDAO().insert(new Utilisateur(strNom, strPrenom, strsexe, strLieu, dateN));
            Alert alert = new Alert("Résultat");
            if (result) {
                alert.setType(AlertType.CONFIRMATION);
                alert.setString("Utilisateur ajouté avec succés");
                utils.StaticMidlet.disp.setCurrent(alert, new UtilisateurList());
            } else {
                alert.setType(AlertType.ERROR);
                alert.setString("L'ajout de l'utilisateur a échoué");
              utils.StaticMidlet.disp.setCurrent(alert);
            }
        }
    }

}
