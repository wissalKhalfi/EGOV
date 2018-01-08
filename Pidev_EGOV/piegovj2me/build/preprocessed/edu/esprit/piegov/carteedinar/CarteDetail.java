/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.piegov.carteedinar;

import edu.esprit.piegov.entites.CarteEdinar;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;

/**
 *
 * @author USER
 */
public class CarteDetail extends Form implements CommandListener, Runnable {

    CarteEdinar cd;
    Command backCmd = new Command("Retour", Command.EXIT, 0);
    Command supprimer = new Command("supprimer", Command.EXIT, 0);
    Command modifier = new Command("modifier", Command.EXIT, 0);

    Thread t2;

    public CarteDetail(String title) {
        super(title);
    }

    public CarteDetail(CarteEdinar cd) {
        super("Consultation d'une carte");
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
            utils.StaticMidlet.disp.setCurrent(new AjouterCarteedinar());

        }
    }

    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
