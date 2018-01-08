package googlemapapiproject;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.midlet.MIDlet;
import com.jappit.midmaps.googlemaps.*;
import edu.esprit.piegov.Passeport.Menu;


import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;

public class GoogleMapsMoveCanvas extends GoogleMapsTestCanvas implements GoogleStaticMapHandler, CommandListener {

    GoogleMaps gMaps = null;
    GoogleStaticMap map = null;
    Command EXIT = new Command("Exit", Command.EXIT, 0);
	Command zoomInCommand, zoomOutCommand;

    public GoogleMapsMoveCanvas(String title) {
        super(title);
		addCommand(zoomInCommand = new Command("Zoom in", Command.OK, 1));
		addCommand(zoomOutCommand = new Command("Zoom out", Command.OK, 1));
        
        gMaps = new GoogleMaps();

        map = gMaps.createMap(getWidth(), getHeight(), GoogleStaticMap.FORMAT_PNG);
        GoogleMapsMarker marker = new GoogleMapsMarker(new GoogleMapsCoordinates(36.899313, 10.188750));
        marker.setColor(GoogleStaticMap.COLOR_RED);
        marker.setSize(GoogleMapsMarker.SIZE_MID);
        marker.setLabel('S');
        
        map.addMarker(marker);

        map.setHandler(this);

        map.setCenter(new GoogleMapsCoordinates(36.899313, 10.188750));

        map.setZoom(8);

        map.update();
        addCommand(EXIT);
        setCommandListener(this);
    }

    protected void paint(Graphics g) {
        map.draw(g, 0, 0, Graphics.TOP | Graphics.LEFT);
    }

    public void GoogleStaticMapUpdateError(GoogleStaticMap map, int errorCode, String errorMessage) {
        showError("map error: " + errorCode + ", " + errorMessage);
    }

    public void GoogleStaticMapUpdated(GoogleStaticMap map) {
        repaint();
    }

    protected void keyPressed(int key) {
        int gameAction = getGameAction(key);

        if (gameAction == Canvas.UP || gameAction == Canvas.RIGHT || gameAction == Canvas.DOWN || gameAction == Canvas.LEFT) {
            map.move(gameAction);
        }
    }

    public void commandAction(Command c, Displayable d) {
        if (c == EXIT) {
           utils.StaticMidlet.disp.setCurrent(new Menu());

        }
        super.commandAction(c, d);
		
		if(c == zoomInCommand)
			map.zoomIn();
		else if(c == zoomOutCommand)
			map.zoomOut();
    }
}
