/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egov_mobile.gui;


import egov_mobile.Midlet;
import egov_mobile.entities.Permis;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;

/**
 *
 * @author USER
 */
public class afficheListePermis1 extends Form implements CommandListener, Runnable {

    Permis cd;
    Command backCmd = new Command("Retour", Command.EXIT, 0);
    Command supprimer = new Command("supprimer", Command.EXIT, 0);
    Command modifier = new Command("modifier", Command.EXIT, 0);

    Thread t2;

    public afficheListePermis1(String title) {
        super(title);
    }

    public afficheListePermis1(Permis cd) {
        super("Consultation d'un permis");
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
            Midlet.INSTANCE.disp.setCurrent(new AjoutPermis());

        }
    }

    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
