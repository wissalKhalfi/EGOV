/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.piegov.handlers;

import edu.esprit.piegov.entites.Utilisateur;
import java.util.Date;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author macbookpro
 */
public class UtilisateurHandler extends DefaultHandler {
    
     private Vector utilisateurVector;

    public UtilisateurHandler() {
        utilisateurVector = new Vector();
    }

    public Utilisateur[] getUtilisateur() {
        Utilisateur[] utilisateur = new Utilisateur[utilisateurVector.size()];
        utilisateurVector.copyInto(utilisateur);
        return utilisateur;
    }
    String selectedBalise = "";
    Utilisateur selectedUtilisateur;

    public void startElement(String string, String string1, String qName, Attributes atrbts) throws SAXException {
        if (qName.equals("utilisateur")) {
            selectedUtilisateur = new Utilisateur();
        } else if (qName.equals("nom")) {
            selectedBalise = "nom";
        } else if (qName.equals("prenom")) {
            selectedBalise = "prenom";
        } else if (qName.equals("date_naissance")) {
            selectedBalise = "date_naissance";
        } else if (qName.equals("lieu_naissance")) {
            selectedBalise = "lieu_naissance";
        }  else if (qName.equals("sexe")) {
            selectedBalise = "sexe";
        } 
    }
    public void endElement(String string, String string1, String qName) throws SAXException {
        if (qName.equals("utilisateur")) {

            utilisateurVector.addElement(selectedUtilisateur);
            selectedUtilisateur = null;
        } else if (qName.equals("nom")) {
            selectedBalise = "";
        } else if (qName.equals("prenom")) {
            selectedBalise = "";
        } else if (qName.equals("date_naissance")) {
            selectedBalise = "";
        } else if (qName.equals("lieu_naissance")) {
            selectedBalise = "";
        }  else if (qName.equals("sexe")) {
            selectedBalise = "";
        } 
        
    }
    
    public void characters(char[] chars, int i, int i1) throws SAXException {
        if (selectedUtilisateur != null) {
            if (selectedBalise.equals("nom")) {
                selectedUtilisateur.setNom(new String(chars, i, i1));
                System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("prenom")) {
                selectedUtilisateur.setPrenom(new String(chars, i, i1));
                System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("date_naissance")) {
                selectedUtilisateur.setDateNaissance(null);
                System.out.println(new String(chars, i, i1));
            }
             if (selectedBalise.equals("lieu_naissance")) {
                selectedUtilisateur.setLieuNaissance(new String(chars, i, i1));
                System.out.println(new String(chars, i, i1));
            }
              if (selectedBalise.equals("sexe")) {
                selectedUtilisateur.setSexe(new String(chars, i, i1));
                System.out.println(new String(chars, i, i1));
            }
            
        }
    }
  
}
