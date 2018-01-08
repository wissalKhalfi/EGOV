/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egov_mobile.gui;

import egov_mobile.Midlet;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import java.io.IOException;
import javax.microedition.lcdui.*;
//import com.esprit.mooc.test.Midlet;

/**
 *
 * @author damine
 */
public class GestionPermis extends Canvas {
    
    String slector = "";
    int w, h;
    private String[] arrMenu = new String[]{"Ajouter Permis", "Consulter liste Permis","statistique Categorie","Acceuil"};
    public Image img = null;
    private int startArr = 0;
    private int endArr = 4;
    private int kursor = 0;
    private int y;
    
    public GestionPermis() {
        w = getWidth();
        h = getHeight();
        try {
            img = Image.createImage("/egov_mobile/handler/splash.png");
            //img = Image.createImage("C:\\Users\\Aya\\Pictures");
        } catch (IOException e) {
        }
    }
    
    protected void paint(Graphics g) {
        if (img != null) {
//background
            g.setColor(0, 151, 167);
            g.fillRect(0, 0, w, h);
            g.drawImage(img, w / 2, h / 2, g.HCENTER | g.VCENTER);
//header
            g.setColor(255, 255, 255);
            Font huruf = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_LARGE);
            g.setFont(huruf);
            g.drawString("Elephents World", w - w + 15, h - h + 10, g.TOP | g.LEFT);
            g.drawLine(0, h - h + 30, w, h - h + 30);
        }
        y = 0;
        for (int i = startArr; i < endArr; i++) {
            if (kursor == i) {
                g.setColor(0, 128, 142);
                g.fillRoundRect(w - w + 15, h - h + 50 + y, w - 30, h - h + 32, 10, 10);
                g.setColor(255, 255, 255);
                g.drawRoundRect(w - w + 15, h - h + 50 + y, w - 30, h - h + 32, 10, 10);
            }
            g.setColor(255, 255, 255);
            Font teks = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_MEDIUM);
            g.setFont(teks);
            g.drawString(arrMenu[i], w / 2, h - h + 57 + y, g.TOP | g.HCENTER);
            y += 40;
        }
    }
    
    protected void keyPressed(int keyCode) {
        super.keyPressed(keyCode);
        if (getGameAction(keyCode) == DOWN) {
            kursor += 1;
            if (kursor == endArr) {
                kursor = endArr;
                startArr += 1;
                endArr += 1;
            }
            if (kursor == arrMenu.length) {
                startArr = arrMenu.length - 4;
                endArr = arrMenu.length;
                kursor = endArr - 1;
            }
            repaint();
        } else if (getGameAction(keyCode) == UP) {
            if (kursor <= 0) {
                startArr = 0;
                endArr = 4;
                kursor = 1;
            } else if (kursor == startArr) {
                kursor = startArr;
                startArr -= 1;
                endArr -= 1;
            }
            kursor -= 1;
            repaint();
        } else if (getGameAction(keyCode) == FIRE) {
            if (kursor == 0) {
               Midlet.INSTANCE.disp.setCurrent(new AjoutPermis());
            }
             if (kursor == 1) {
               Midlet.INSTANCE.disp.setCurrent(new afficheListePermis()); 
            }
              if (kursor == 2) {
               Midlet.INSTANCE.disp.setCurrent(new Statistique());
            }
             if (kursor == 3) {
                 Midlet.INSTANCE.disp.setCurrent(new MenuEroute());
            }
        }
        
    }
}