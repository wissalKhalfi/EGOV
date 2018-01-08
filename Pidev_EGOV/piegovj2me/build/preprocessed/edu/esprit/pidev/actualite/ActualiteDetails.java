/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.actualite;

import edu.esprit.piegov.entites.Articles;
import java.io.DataInputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;
import javax.microedition.lcdui.Ticker;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ActualiteDetails extends Form implements CommandListener, Runnable {

    Articles cd;
    Command backCmd = new Command("Retour", Command.EXIT, 0);
    Command supprimer = new Command("supprimer", Command.EXIT, 0);
    Command modifier = new Command("modifier", Command.EXIT, 0);

    Thread t2;

    public ActualiteDetails(String title) {
        super(title);
    }

    public ActualiteDetails(Articles cd) {
        super("Consultation d'une actualité");
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
            utils.StaticMidlet.disp.setCurrent(new ListeActualite());

        }
    }

    public void run() {
    }
    }

