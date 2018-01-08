/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.DAO;

import edu.esprit.piegov.entites.Permis;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author boumaiza
 */
public class CarteGriseDAO {
    
    
    Permis[] permis;
    
    public boolean insert(Permis permis){
        try {
            System.out.println(" categorie :"+permis.getCategorie_permis());
            System.out.println(" passport val :"+permis.getValidation());
           // HttpConnection hc = (HttpConnection)Connector.open("http://localhost/pidev/insert.php?eq1="+passeport.getCouleurYeux()+"&CouleurYeux="+passeport.getValidation());
           HttpConnection hc = (HttpConnection)Connector.open("http://127.0.0.1/jme/insert.php?categorie_permis="+permis.getCategorie_permis()+"&validation="+permis.getValidation());
       
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
    
   public Permis[] select(){
       try {
            PermisHandler passportHandlers = new PermisHandler();
            // get a parser object
            SAXParser SAXparser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://127.0.0.1/jme/select.php");//people.xml est un exemple
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            SAXparser.parse(dis, passportHandlers);
            // display the result
            permis = passportHandlers.getPermis();
             return permis;
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        } catch (SAXException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

             return null;
   }
   
    public Permis[] Find(String numPermis){
        Permis[] Permis = null;
        //String requete="http://localhost/pidev/SelectBillet.php";
        
//    if(! label.equals(""))
//        {   System.out.println("Billetlist : CRITERE_VIDE() " +! (prix==0));
        String requete ;
            requete="http://127.0.0.1/jme/Find.php?numPermis="+numPermis;
//            System.out.println("Billetlist: requete affichage billet par prix: "+requete);
//        }   
       
        
        try {
           // BilletsHandler offreHandler = new BilletsHandler();
            PermisHandler PassHandler = new PermisHandler();
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            HttpConnection hc = (HttpConnection) Connector.open(requete);
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, PassHandler);
            // display the result
             Permis = PassHandler.getPermis();
        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        return Permis;
    }
}
