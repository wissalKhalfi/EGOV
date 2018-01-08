package  edu.esprit.piegov.gui;
import edu.esprit.pidev.admin.Acceuil_Admin;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class IntroCanvas extends Canvas {

        int width = getWidth();
        int height = getHeight();
        
        Image backgroundImage;
        
        float chargement = 0;
        int angle = 0;
        
        Timer timer;
        public IntroCanvas(){
            try {
                
                backgroundImage = Image.createImage("/assets/arriere_plan.jpg");
            } catch (IOException ex) {
                System.out.println("probleme lors du chargement de l'image.");
            }
            
            timer = new Timer();
            TestTimerTask task = new TestTimerTask(this);
            timer.schedule(task,150,150);
        }

        protected void paint(Graphics g) {
            
            //mettre le backgroung image
            g.drawImage(backgroundImage, 0, 0, Graphics.TOP|Graphics.LEFT);
            
//            g.setColor(69, 69, 69);
            g.setColor(255, 255, 255);
           //ecrire le pourcentage du chargement
            g.drawString(chargement+"%", width/2, height/2+50, Graphics.BASELINE|Graphics.HCENTER);
            
           //tracer le cercle de chargement
            g.drawArc(width/2-50, height/2, 100, 100, angle, 90);
            
            
        }
        
        private class TestTimerTask extends TimerTask{
            IntroCanvas canva;
            int nbr = 0;
            public TestTimerTask(IntroCanvas canva){
                this.canva = canva;
            }
            
            public final void run(){
                if (nbr != 8)
                {
                    if (canva.angle == 360)
                    {
                        canva.angle = 90;
                        nbr++;
                        canva.chargement += 12.5;
                    }
                    else
                        canva.angle += 90;
                
                    canva.repaint();
                }
                else
                {
                    timer.cancel();
                    utils.StaticMidlet.disp.setCurrent(new Acceuil_Admin());
                }
                
            }
    }
}