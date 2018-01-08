/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.piegov.handlers;

import edu.esprit.piegov.entites.Articles;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author USER
 */
public class ActualiteHandler  extends DefaultHandler {

    private Vector actualites;
    String id_articleTag = "close";
    String titre_articleTag = "close";
    String date_articleTag = "close";
    String texte_articleTag = "close";
    String priorite_pubTag = "close";
    String typeTag = "close";
   

 
    public ActualiteHandler() {
       actualites  = new Vector();
    }

    public Articles[] getCartes() {
        Articles[] articles = new Articles[actualites.size()];
        actualites.copyInto(articles);
        return articles;
    }
    private Articles currentarticle;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equals("articles")) {
            currentarticle = new Articles();  
            
        } else if (qName.equals("id_article")) {
            id_articleTag = "open";
        } else if (qName.equals("titre_article")) {
            titre_articleTag = "open";
        } else if (qName.equals("date_article")) {
            date_articleTag = "open";
        } else if (qName.equals("texte_article")) {
            texte_articleTag = "open";
        } else if (qName.equals("priorite_pub")) {
            priorite_pubTag = "open";
        } else if (qName.equals("type")) {
            typeTag = "open";
        } 
          

    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

          if (qName.equals("articles")) {
            actualites.addElement(currentarticle);
            currentarticle = null;
            
        } else if (qName.equals("id_article")) {
            id_articleTag = "close";
        } else if (qName.equals("titre_article")) {
            titre_articleTag = "close";
        } else if (qName.equals("date_article")) {
            date_articleTag = "close";
        } else if (qName.equals("texte_article")) {
            texte_articleTag = "close";
        } else if (qName.equals("priorite_pub")) {
            priorite_pubTag = "close";
        } else if (qName.equals("type")) {
            typeTag = "close";
        } 
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        try {
            if (currentarticle != null) {
                // don't forget to trim excess spaces from the ends of the string
                String value = new String(ch, start, length).trim();

                if (id_articleTag.equals("open")) {
                    currentarticle.setId_article(Integer.parseInt(value));
//                    System.out.println("reference time event");
                }
                 else if (titre_articleTag.equals("open")) {
                    currentarticle.setTitre_article(value);

                } else if (typeTag.equals("open")) {
                    currentarticle.setType(value);

                } else if (texte_articleTag.equals("open")) {
                    currentarticle.setTexte_article(value);
                } else if (date_articleTag.equals("open")) {
                    String[] strDate  = split(value, "-");
                    System.out.println(""+value);
                    Date d = new Date();
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.YEAR, Integer.parseInt(strDate[0]));
                    calendar.set(Calendar.MONTH, Integer.parseInt(strDate[1]));
                    calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(strDate[2]));
                   d.setTime(calendar.getTime().getTime());
                    currentarticle.setDate_article(d);
                }
                  
             
            }
        } catch (Exception e) {
        }

}
    private String[] split(String original,String separator) {
    Vector nodes = new Vector();
    // Parse nodes into vector
    int index = original.indexOf(separator);
    while(index >= 0) {
        nodes.addElement( original.substring(0, index) );
        original = original.substring(index+separator.length());
        index = original.indexOf(separator);
    }
    // Get the last node
    nodes.addElement( original );

     // Create split string array
    String[] result = new String[ nodes.size() ];
    if( nodes.size() > 0 ) {
        for(int loop = 0; loop < nodes.size(); loop++)
        {
            result[loop] = (String)nodes.elementAt(loop);
            System.out.println(result[loop]);
        }

    }
   return result;
}
}

