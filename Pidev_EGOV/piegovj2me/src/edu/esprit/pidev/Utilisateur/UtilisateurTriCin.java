/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.Utilisateur;


import edu.esprit.pidev.DAO.UtilisateurDAO;
import edu.esprit.piegov.entites.Utilisateur;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;

/**
 *
 * @author macbookpro
 */
public class UtilisateurTriCin extends List implements CommandListener, Runnable {
    
    Command cmdAjout = new Command("Ajouter un utilisateur", Command.SCREEN, 0);
    Command cmdExit = new Command("Exit", Command.EXIT, 0);
    Command rechercherCmd = new Command("Rechercher", Command.SCREEN, 3);
    String type;

    public UtilisateurTriCin(String type) {
        
        super("Résultats recherche", List.IMPLICIT);
        this.type=type;
        addCommand(cmdAjout);
        addCommand(cmdExit);
        addCommand(rechercherCmd);
        
        setCommandListener(this);
        Thread th = new Thread(this);
        th.start();
    }
    
    public void commandAction(Command c, Displayable d) {
        if (c == cmdAjout) {
         utils.StaticMidlet.disp.setCurrent(new UtilisateurAdd());
        }
        if (c == cmdExit) {
            utils.StaticMidlet.mainMid.notifyDestroyed();
        }
        if (c == rechercherCmd) {
           utils.StaticMidlet.disp.setCurrent(new UtilisateurFind());
        }
        
    }

    
   
    
    public void run() {
        
        String strCritere = type.toString();
        
        Utilisateur[] utilisateurs = new UtilisateurDAO().find(strCritere);
      
         
        if (utilisateurs.length > 0) {
            for (int i = 0; i < utilisateurs.length; i++) {
                append(utilisateurs[i].getNom() + " - " + utilisateurs[i].getPrenom() +" - " + utilisateurs[i].getDateNaissance() + " - " + utilisateurs[i].getLieuNaissance() +  " - " + utilisateurs[i].getSexe(), null);
            }
        }
         
        
    }
    
}
