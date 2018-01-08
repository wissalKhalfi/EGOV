/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.compte;

import edu.esprit.piegov.entites.Ccp;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;

/**
 *
 * @author USER
 */
public class CompteDetail extends Form implements CommandListener, Runnable{
    
    Ccp cd;
    Command backCmd = new Command("Retour", Command.EXIT, 0);
    Command supprimer = new Command("supprimer", Command.EXIT, 0);
    Command modifier = new Command("modifier", Command.EXIT, 0);

    Thread t2;
  public CompteDetail(String title) {
        super(title);
    }

    public CompteDetail(Ccp cd) {
        super("Consultation d'un compte");
        this.cd = cd;
        addCommand(backCmd);
        addCommand(supprimer);
        addCommand(modifier);
        setCommandListener(this);
        t2 = new Thread(this);
        t2.start();
    }

    public void commandAction(Command c, Displayable d) {
        if (c == backCmd) {
            utils.StaticMidlet.disp.setCurrent(new AjoutecCompte());

        }
    }

    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
