/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.piegov.handlers;

import edu.esprit.piegov.entites.Ccp;
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
public class CcpHandler  extends DefaultHandler

{private Vector ccps;
    String num_ccpTag = "close";
    String code_cppTag = "close";
    String solde_actuelTag = "close";
    String date_dernier_retirementTag = "close";
    String date_dernier_versementTag = "close";
    String dernier_versementTag = "close";
    String date_creationTag = "close";
    String dernier_retirementTag = "close";

 
    public CcpHandler() {
        ccps = new Vector();
    }

    public Ccp[] getCartes() {
        Ccp[] ccpss = new Ccp[ccps.size()];
        ccps.copyInto(ccpss);
        return ccpss;
    }
    private Ccp currentcp;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equals("ccp")) {
            currentcp = new Ccp();  
            
        } else if (qName.equals("num_ccp")) {
            num_ccpTag = "open";
        } else if (qName.equals("code_ccp")) {
            code_cppTag = "open";
        } else if (qName.equals("solde_actuel")) {
            solde_actuelTag = "open";
        } else if (qName.equals("date_dernier_retirement")) {
            date_dernier_retirementTag = "open";
        } else if (qName.equals("date_creation")) {
            date_creationTag = "open";
        } else if (qName.equals("dernier_retirement")) {
            dernier_retirementTag = "open";
        } else if (qName.equals("date_dernier_versement")) {
            date_dernier_versementTag = "open";
        } else if (qName.equals("dernier_versement")) {
            dernier_versementTag = "open";
        }

    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("ccp")) {
           ccps.addElement(currentcp);
           currentcp  = null;
        } else if (qName.equals("num_ccp")) {
            num_ccpTag = "close";
        } else if (qName.equals("code_ccp")) {
            code_cppTag = "close";
        } else if (qName.equals("solde_actuel")) {
            solde_actuelTag = "close";
        } else if (qName.equals("date_dernier_retirement")) {
            date_dernier_retirementTag = "close";
        } else if (qName.equals("date_creation")) {
            date_creationTag = "close";
        } else if (qName.equals("dernier_retirement")) {
            dernier_retirementTag = "close";
        } else if (qName.equals("date_dernier_versement")) {
            date_dernier_versementTag = "close";
        } else if (qName.equals("dernier_versement")) {
            dernier_versementTag = "close";
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        try {
            if (currentcp != null) {
                // don't forget to trim excess spaces from the ends of the string
                String value = new String(ch, start, length).trim();

                if (num_ccpTag.equals("open")) {
                    currentcp.setNum_ccp(Integer.parseInt(value));
//                    System.out.println("reference time event");
                } else if (code_cppTag.equals("open")) {
                     currentcp.setCode_ccp(Integer.parseInt(value));

                } else if (solde_actuelTag.equals("open")) {
                    currentcp.setSolde_actuel(Integer.parseInt(value));
                } else if (date_dernier_retirementTag.equals("open")) {
                    String[] strDate  = split(value, "-");
                    System.out.println(""+value);
                    Date d = new Date();
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.YEAR, Integer.parseInt(strDate[0]));
                    calendar.set(Calendar.MONTH, Integer.parseInt(strDate[1]));
                    calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(strDate[2]));
                   d.setTime(calendar.getTime().getTime());
                    currentcp.setDate_dernier_retirement(d);
                }
                else if (date_dernier_versementTag.equals("open")) {
                    String[] strDate  = split(value, "-");
                    System.out.println(""+value);
                    Date d = new Date();
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.YEAR, Integer.parseInt(strDate[0]));
                    calendar.set(Calendar.MONTH, Integer.parseInt(strDate[1]));
                    calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(strDate[2]));
                   d.setTime(calendar.getTime().getTime());
                    currentcp.setDate_dernier_versement(d);
                }
                     else if (date_dernier_versementTag.equals("open")) {
                    String[] strDate  = split(value, "-");
                    System.out.println(""+value);
                    Date d = new Date();
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.YEAR, Integer.parseInt(strDate[0]));
                    calendar.set(Calendar.MONTH, Integer.parseInt(strDate[1]));
                    calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(strDate[2]));
                   d.setTime(calendar.getTime().getTime());
                    currentcp.setDate_dernier_versement(d);
                }
                else if (dernier_retirementTag.equals("open")) {
                    currentcp.setDernier_retirement(Integer.parseInt(value));
                } 
                 else if (dernier_versementTag.equals("open")) {
                    currentcp.setDernier_versement(Integer.parseInt(value));}
             
             
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
