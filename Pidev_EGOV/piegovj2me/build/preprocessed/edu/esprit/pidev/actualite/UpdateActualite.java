/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.actualite;

import edu.esprit.piegov.entites.Articles;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemStateListener;
import javax.microedition.lcdui.TextField;

/**
 *
 * @author USER
 */
public class UpdateActualite extends Form implements CommandListener, Runnable, ItemStateListener {

    Articles article;
    HttpConnection http;
    DataInputStream dataStream;
    Command enregistrer = new Command("Enregistrer", Command.SCREEN, 3);
    Command retour = new Command("Retour", Command.EXIT, 0);
    private TextField titre_article;
    private TextField text_article;
    private DateField date_article;
    private TextField priorite_pub;
    private TextField type;
    Thread t;

    public UpdateActualite() {
        super("modifier carte");
        addCommand(enregistrer);
        addCommand(retour);
        t = new Thread(this);

        this.setItemStateListener(this);
        this.setCommandListener(this);
        t.start();
    }

    private void modifier() {
        System.out.println("modification time");
        String url = "";
        url = "http://localhost/piegov/UpdateActualite.php";
        try {
//            ?offre_nom=test&offre_description=test&offre_prix=10&offre_reference=14
            url += "?titre_article=" + titre_article.getString().trim() + "&date_article=" + date_article.getDate().getTime() + "&texte_article=" + text_article.getString().trim() + "&priorite_pub=" + priorite_pub.getString().trim() + "&type=" + type.getString().trim();
            System.out.println(url);

            HttpConnection hc = (HttpConnection) Connector.open(url.replace(' ', '+'));
            StringBuffer sb = new StringBuffer();
            int ch;

            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            while ((ch = dis.read()) != -1) {
                sb.append((char) ch);
            }

            utils.StaticMidlet.disp.setCurrent(new Alert("result", "modification avec succes", null, AlertType.CONFIRMATION));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void commandAction(Command c, Displayable d) {
        if (c == enregistrer) {
            modifier();

        }

        if (c == retour) {
            utils.StaticMidlet.disp.setCurrent(new ListeActualite());

        }
    }

    public void run() {
        titre_article = new TextField("titre_article", null, 50, TextField.ANY);
        text_article = new TextField("text_article", null, 200, TextField.ANY);
        priorite_pub = new TextField("priorite_pub", null, 50, TextField.ANY);
        type = new TextField("type", null, 50, TextField.ANY);
        date_article = new DateField("date_article", DateField.DATE);
//        Calendar cal= Calendar.getInstance();
//        cal.setTime(date_dernier_retirement.getDate());
//        String date = cal.get(Calendar.YEAR) + "-" + ( cal.get(Calendar.MONTH)+1  ) + "-" + cal.get(Calendar.DAY_OF_MONTH);

        append(titre_article);
        append(text_article);
        append(priorite_pub);
        append(type);
        append(date_article);

    }
    
    public void itemStateChanged(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
