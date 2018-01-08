/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.DAO;


import edu.esprit.piegov.entites.Utilisateur;
import edu.esprit.piegov.handlers.UtilisateurHandler;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Date;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author macbookpro
 */
public class UtilisateurDAO {
       
    Utilisateur[] utilisateurs;
    
    public boolean insert( Utilisateur  Utilisateur){
        try {
         
           HttpConnection hc = (HttpConnection)Connector.open("http://localhost/piegov/insertUser.php?nom="+Utilisateur.getNom()  +"&prenom="+Utilisateur.getPrenom()+"&sexe="+Utilisateur.getSexe() +"&lieu="+Utilisateur.getLieuNaissance()  +"&dateN"+Utilisateur.getDateNaissance().getTime());
       
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
           StringBuffer sb = new StringBuffer();
           int ch;
            while ((ch = dis.read())!=-1) {
                sb.append((char)ch);                
            }
            if (sb.toString().trim().equals("success")) {
                return true;
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
   public Utilisateur[] select(){
       try {
            UtilisateurHandler UtilisateurHandlers = new UtilisateurHandler();
            SAXParser SAXparser = SAXParserFactory.newInstance().newSAXParser();
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/piegov/selectUser.php");
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            SAXparser.parse(dis, UtilisateurHandlers);
            utilisateurs = UtilisateurHandlers.getUtilisateur();
            return utilisateurs ;
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        } catch (SAXException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
             return null;
   }
   public Utilisateur[] find(String type){
       try {
            UtilisateurHandler UtilisateurHandlers = new UtilisateurHandler();
            SAXParser SAXparser = SAXParserFactory.newInstance().newSAXParser();
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/piegov/findUser.php?type=" + type);
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            SAXparser.parse(dis, UtilisateurHandlers);
            utilisateurs = UtilisateurHandlers.getUtilisateur();
            return utilisateurs ;
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        } catch (SAXException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
             return null;
   }
    
}
