/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egov_mobile.gui;

//import com.esprit.egov.Midlet;
//import com.esprit.egov.entities.Permis;
import egov_mobile.Midlet;
import egov_mobile.entities.Permis;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.Ticker;

/**
 *
 * @author Helmi
 */
public class Statistique extends Canvas implements CommandListener
{
    static Permis p;
    int w=getWidth();
    int h=getHeight();
     Display disp ;  
     Command cmdBack = new Command("Back", Command.EXIT, 0);
       Command Retour= new Command("Retour", Command.SCREEN, 0);
       Command Noter = new Command("bleu: A*rouge: B*vert:noPermis", Command.SCREEN, 0);
      
        ChoiceGroup l1=new ChoiceGroup("Menu", List.EXCLUSIVE);
       
 
     
    public Statistique() 
    {
        
     super();
             l1.append("Consulter", null); 
        l1.append("Ajouter", null); 
        l1.append("Localisation", null);
         addCommand(Noter);
         addCommand(cmdBack);
        setCommandListener(this);
    }
    

    protected void paint(Graphics g) 
    {
        g.setColor(255,255,255);
        g.fillRect(0, 0, w, h);
        g.setColor(0, 255, 0);
        g.fillArc(0, h/2-90,240,160, 0, 46);
        g.setColor(255, 0, 0);
        g.fillArc(0, h/2-90,240,160, 46, 55);
        g.setColor(0, 0, 255);
        g.fillArc(0, h/2-90,240,160, 101, 259);
         
    }

    public void commandAction(Command c, Displayable d) 
    {
     
          if (c == cmdBack) {
            Midlet.INSTANCE.disp.setCurrent(new Menu());
        }
        
    }

    private void append(StringItem st) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
