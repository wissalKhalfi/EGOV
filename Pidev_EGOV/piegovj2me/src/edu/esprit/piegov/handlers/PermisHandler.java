package edu.esprit.piegov.handlers;

import edu.esprit.piegov.entites.Permis;
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
public class PermisHandler extends DefaultHandler {

    private Vector passeportVector;

    public PermisHandler() {
        passeportVector = new Vector();
    }

    public Permis[] getPermis() {
        Permis[] permis = new Permis[passeportVector.size()];
        passeportVector.copyInto(permis);
        return permis;
    }

    String selectedBalise = "";
    Permis selectedPermis;

    public void startElement(String string, String string1, String qName, Attributes atrbts) throws SAXException {
        if (qName.equals("permis")) {
            
            selectedPermis= new Permis();
        } else if (qName.equals("numPermis")) {
            selectedBalise = "numPermis";
        } else if (qName.equals("categorie_permis")) {
            selectedBalise = "categorie_permis";
        } 
    }

    public void endElement(String string, String string1, String qName) throws SAXException {
        if (qName.equals("permis")) {

            passeportVector.addElement(selectedPermis);
            selectedPermis = null;
        } else if (qName.equals("numPermis")) {
            selectedBalise = "";
        } else if (qName.equals("categorie_permis")) {
            selectedBalise = "";
        } 
        
    }

    public void characters(char[] chars, int i, int i1) throws SAXException {
        if (selectedPermis != null) {
            if (selectedBalise.equals("numPermis")) {
                selectedPermis.setNumPermis(Integer.parseInt(new String(chars, i, i1)));
                System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("categorie_permis")) {
                selectedPermis.setCategorie_permis(new String(chars, i, i1));
                System.out.println(new String(chars, i, i1));
            }
            
        }
    }
}