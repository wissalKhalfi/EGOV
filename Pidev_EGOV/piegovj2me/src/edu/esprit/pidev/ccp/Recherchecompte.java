/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.ccp;

import java.io.DataInputStream;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;

/**
 *
 * @author USER
 */
public class Recherchecompte extends Form implements CommandListener {

    HttpConnection http;
    DataInputStream dataStream;

    Command rechercherCmd = new Command("Rechercher", Command.SCREEN, 3);
    Command precedent = new Command("Retour", Command.EXIT, 0);
    TextField CritereTF = new TextField("Num_carte:", null, 1000, TextField.ANY);

    public Recherchecompte() {
        super("Recherche Compte");
        append(CritereTF);
        this.setCommandListener(this);
        addCommand(rechercherCmd);
        addCommand(precedent);
            
    }
    public void commandAction(Command c, Displayable d) {
        if (c == rechercherCmd) {
            if (validerFormulaire()) {
                utils.StaticMidlet.disp.setCurrent(new ListeCompte(Integer.parseInt(CritereTF.getString())));
            }
        }
    }
  private boolean validerFormulaire() {
        boolean continuer = true;
        String erreur = "";
        
        if (CritereTF.getString().length() == 0){
            continuer = false;
            erreur += "Saisir un num_carte de recherche \n";
        }
        
        if (!continuer){
            utils.StaticMidlet.disp.setCurrent(new Alert("erreur", erreur, null, AlertType.ERROR));
        }
        
        return continuer;
        }
 }
