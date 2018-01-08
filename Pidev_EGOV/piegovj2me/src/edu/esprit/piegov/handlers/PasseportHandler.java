package edu.esprit.piegov.handlers;

import edu.esprit.piegov.entites.Passeport;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author boumaiza
 */
public class PasseportHandler extends DefaultHandler {

    private Vector passeportVector;

    public PasseportHandler() {
        passeportVector = new Vector();
    }

    public Passeport[] getPasseport() {
        Passeport[] passeport = new Passeport[passeportVector.size()];
        passeportVector.copyInto(passeport);
        return passeport;
    }

    String selectedBalise = "";
    Passeport selectedPasseport;

    public void startElement(String string, String string1, String qName, Attributes atrbts) throws SAXException {
        if (qName.equals("passeport")) {
            selectedPasseport = new Passeport();
        } else if (qName.equals("numPasseport")) {
            selectedBalise = "numPasseport";
        } else if (qName.equals("couleurYeux")) {
            selectedBalise = "couleurYeux";
        } else if (qName.equals("dateDelivrance")) {
            selectedBalise = "dateDelivrance";
        }
    }

    public void endElement(String string, String string1, String qName) throws SAXException {
        if (qName.equals("passeport")) {

            passeportVector.addElement(selectedPasseport);
            selectedPasseport = null;
        } else if (qName.equals("numPasseport")) {
            selectedBalise = "";
        } else if (qName.equals("couleurYeux")) {
            selectedBalise = "";
        } else if (qName.equals("dateDelivrance")) {
            selectedBalise = "";
        }
        
    }

    public void characters(char[] chars, int i, int i1) throws SAXException {
        if (selectedPasseport != null) {
            if (selectedBalise.equals("numPasseport")) {
                selectedPasseport.setNumPasseport(Integer.parseInt(new String(chars, i, i1)));
                System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("couleurYeux")) {
                selectedPasseport.setCouleurYeux(new String(chars, i, i1));
                System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("dateDelivrance")) {
                selectedPasseport.setDateDelivrance(null);
                System.out.println(new String(chars, i, i1));
            }
            
        }
    }
}