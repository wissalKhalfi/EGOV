/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.piegov.Passeport;


import edu.esprit.pidev.DAO.PasseportDAO;
import edu.esprit.piegov.entites.Passeport;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;

/**
 *
 * @author boumaiza
 */
public class PasseportList extends List implements CommandListener, Runnable {

    Command cmdAjout = new Command("Ajouter un Passeport", Command.SCREEN, 0);
    Command cmdExit = new Command("Exit", Command.EXIT, 0);
    Command cmdRech = new Command("Rechercher", Command.SCREEN, 3);

    public PasseportList() {
        super("Liste Passeport", List.IMPLICIT);
        addCommand(cmdAjout);
        addCommand(cmdExit);
        addCommand(cmdRech);
        setCommandListener(this);
        Thread th = new Thread(this);
        th.start();

    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdAjout) {
          utils.StaticMidlet.disp.setCurrent(new PasseportAdd());
        }
        if (c == cmdExit) {
            utils.StaticMidlet.mainMid.notifyDestroyed();
        }
        if (c == cmdRech) {
          utils.StaticMidlet.disp.setCurrent(new FindPasseportt());
        }
    }

    public void run() {
        Passeport[] passeport = new PasseportDAO().select();
        if (passeport.length > 0) {
            for (int i = 0; i < passeport.length; i++) {
                append(passeport[i].getNumPasseport() + " - " + passeport[i].getCouleurYeux(), null);
            }
        }
    }
}
