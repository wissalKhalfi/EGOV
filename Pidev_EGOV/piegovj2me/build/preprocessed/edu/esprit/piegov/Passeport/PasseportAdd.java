/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.piegov.Passeport;

import edu.esprit.pidev.DAO.PasseportDAO;
import edu.esprit.piegov.entites.Passeport;
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
import javax.microedition.lcdui.TextField;

/**
 *
 * @author boumaiza
 */
public class PasseportAdd extends Form implements CommandListener, Runnable {
     String items[] = {"Marron","Noire"};
    ChoiceGroup tfCouleur = new ChoiceGroup("Couleur :", Choice.POPUP,items,null);
    TextField tfVal = new TextField("code v alidation : ", "", 50, TextField.ANY);
   DateField dateD = new DateField("date de delivrance", DateField.DATE);
//    TextField dateV = new TextField("date de validite", "", 50, TextField.ANY);

    Command cmdEnregistrer = new Command("Enregistrer", Command.SCREEN, 0);
    Command cmdBack = new Command("Back", Command.EXIT, 0);

    public PasseportAdd() {
        super("Passeport");

        append(tfCouleur);
        append(tfVal);
        append(dateD);
//                append(dateV);
        addCommand(cmdEnregistrer);
        addCommand(cmdBack);
        setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdBack) {
           utils.StaticMidlet.disp.setCurrent(new PasseportList());
        }
        if (c == cmdEnregistrer) {
            Thread th = new Thread(this);
            th.start();
        }

    }

    public void run() {
        String strCouleur = tfCouleur.getSelectedIndex() == 0 ? "Marron" : "Noire";
//        System.out.println(strCouleur);
        String  strVal = tfVal.getString() ;
       // System.out.println(strVal+ strCouleur);
    Date strDateD = dateD.getDate();
//        String strDateV = dateV.getString();
        boolean result ;
        if(strCouleur != null && strVal != null && strDateD !=null){
         result= new PasseportDAO().insert(new Passeport(strCouleur,strVal,strDateD));
        Alert alert = new Alert("Résultat");
        if (result) {
            alert.setType(AlertType.CONFIRMATION);
            alert.setString("Passeport ajouté avec succés");
             utils.StaticMidlet.disp.setCurrent(alert,new PasseportList());
        } else {
            alert.setType(AlertType.ERROR);
            alert.setString("Ajout du passeport échoué");
             utils.StaticMidlet.disp.setCurrent(alert);
        }
    }

}
}