package edu.esprit.piegov.gui;


import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amine
 */
public class Gallery extends Canvas implements CommandListener{

    
    int width = getWidth();
    int height = getHeight();
    
    GalleryImage[] img;
    int maxSize = 10;
    int nbrElement;
    
    int currentPos;
    
    boolean showDesc = false;
    boolean isPlaying = false;
    
    Timer timer;
    GalleryTimerTask galleryTT;
    
    Displayable nextDisplayable = null;
    Command nextCmd;
    
    Player player;
    boolean musicOn = true;
    Command ppCmd = new Command("Musique Off", Command.SCREEN, 0);
    
    public Gallery(){
        setCommandListener(this);
        addCommand(ppCmd);
        
        currentPos = 0;
        img = new GalleryImage[maxSize];
        nbrElement = 0;
        
        timer = new Timer();
        galleryTT = new GalleryTimerTask();
        
        //InputStream in = getClass().getResourceAsStream("/assets/IntroEyeoftheTigerFinal.wav");
        InputStream in = getClass().getResourceAsStream("/assets/test-wav.wav");
        try {
            player = Manager.createPlayer(in, "audio/x-wav");
            player.setLoopCount(-1);
            player.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }
    
    protected void paint(Graphics g) {
        g.setColor(0,0,0);
        g.fillRect(0, 0, width, height);
        
        if (nbrElement == 0)
        {
            g.setColor(255,255,255);
            g.drawString("pas d'image",width/2,height/2 ,Graphics.BASELINE|Graphics.HCENTER);
        }
        else
        {
            g.drawImage(img[currentPos].img, 0, 0, Graphics.TOP|Graphics.LEFT);
        
            if (showDesc)
            {
                g.setColor(190,190,190);
                g.fillRect(0, (int)(height*0.92), width, (int)(height*0.8)+1);

                //System.out.println(img.desc);
                g.setColor(255,255,255);
                g.drawString(img[currentPos].desc,width/2,height ,Graphics.BOTTOM|Graphics.HCENTER);
            }
        }
        
        
    }
    
    
    
    protected void keyReleased(int keyCode) {
        
        int keyG = getGameAction(keyCode);
        
        if (isPlaying){
            timer.cancel();
            
            showDesc = false;
            isPlaying = false;
        }
        else
        {
            switch (keyG){
            case UP:
                showDesc = true;
                repaint();
                break;
             case DOWN:
                showDesc = false;
                repaint();
                break;
            case RIGHT:
                showDesc = false;
                
                currentPos++;
                if (currentPos == nbrElement)
                    currentPos=0;
                
                repaint();
                
                break;
            case LEFT:
                showDesc = false;
                
                currentPos--;
                if (currentPos < 0)
                    currentPos=nbrElement-1;
                
                repaint();
                break;
            case FIRE:
                showDesc = true;
                isPlaying = true;
                
                timer.schedule(galleryTT, 500,3000);
                
                break;
            }
        }
        
    }
    
    
    //utils
    public void addElementToGallery(Image image,String description){
        if (image != null){
            img[nbrElement] = new GalleryImage(image, description);
            nbrElement++;
        }
    }
    
    public void addExitCommand(String label, Displayable nextDisplayable){
        this.nextDisplayable = nextDisplayable;
        nextCmd = new Command(label,Command.EXIT,0);
        addCommand(nextCmd);
    }
    
    //static utils
    public static Image getImageByUrl(String url){
        Image res = null;
        
        try{
            
            HttpConnection http = (HttpConnection) Connector.open(url);
            DataInputStream dataStream = http.openDataInputStream();
            
            int imgSize = (int) http.getLength();
            byte[] data = new byte[imgSize];
            
            dataStream.readFully(data);
            
            res = Image.createImage(data, 0, imgSize);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return res;
    }
    
    public static Image getImageByName(String name){
        Image res = null;
        
        try {
            res = Image.createImage(name);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return res;
    }

    public void commandAction(Command c, Displayable d) {
        if (c == nextCmd){
            player.close();
            utils.StaticMidlet.disp.setCurrent(nextDisplayable);
        }
        else if (c == ppCmd){
            try {
                
                if (musicOn == false){
                    player.start();
                    removeCommand(ppCmd);
                    ppCmd = new Command("Musique Off", Command.SCREEN, 0);
                    addCommand(ppCmd);
                }
                else{
                    player.stop();
                    removeCommand(ppCmd);
                    ppCmd = new Command("Musique On", Command.SCREEN, 0);
                    addCommand(ppCmd);
                }
                musicOn = !musicOn;
            } catch (MediaException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    //classes
    private class GalleryImage{
        String desc;
        Image img;
        
        public GalleryImage(){}
        
        public GalleryImage(Image img, String desc){
            this.img = CreateScaledImage(img, width, height);
            this.desc = desc;
        }
        
        private Image CreateScaledImage( Image imgOldImage, int iNewWidth, int iNewHeight  )
        {

           Image imgNewImage = null;
           int iOldWidth = imgOldImage.getWidth();
           int iOldHeight = imgOldImage.getHeight();

           int iOldRGBArray[] = new int[iOldWidth * iOldHeight];
           imgOldImage.getRGB(iOldRGBArray, 0, iOldWidth, 0, 0, iOldWidth, iOldHeight);
           int iNewRGBArray[] = new int[iNewWidth * iNewHeight];

           for (int yy = 0; yy < iNewHeight; yy++)
           {
              int dy = yy * iOldHeight / iNewHeight;

              for (int xx = 0; xx < iNewWidth; xx++)
              {
                 int dx = xx * iOldWidth / iNewWidth;

                 iNewRGBArray[(iNewWidth * yy) + xx] = iOldRGBArray[(iOldWidth * dy) + dx];
              }
           }

           imgNewImage = Image.createRGBImage(iNewRGBArray, iNewWidth, iNewHeight, true);

           return imgNewImage;

        }
    }
    
    private class GalleryTimerTask extends TimerTask{

        public void run() {
            if (isPlaying){
                currentPos++;
                if (currentPos == nbrElement)
                    currentPos = 0;
                
                repaint();
            }
        }
        
    }
}
