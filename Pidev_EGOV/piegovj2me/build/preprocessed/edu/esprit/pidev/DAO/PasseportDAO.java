/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.DAO;
import  edu.esprit.piegov.handlers.PasseportHandler;
import edu.esprit.piegov.entites.Passeport;
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
public class PasseportDAO {
    
    
    Passeport[] passeports;
    public String encode(String txt) {
        int compteur = txt.length();
        String ret = "";
        for (int i = 0; i < compteur; i++) {
            if (txt.charAt(i) == ' ') {
                ret += "%20";
            } else {
                ret += txt.charAt(i);
            }
        }
        return ret;
    }
    
    public boolean insert(Passeport passeport){
        try {
//            System.out.println(" passport color :"+passeport.getCouleurYeux());
//            System.out.println(" passport val :"+passeport.getValidation());
           // HttpConnection hc = (HttpConnection)Connector.open("http://localhost/pidev/insert.php?eq1="+passeport.getCouleurYeux()+"&CouleurYeux="+passeport.getValidation());
        

            System.out.println(encode(passeport.getDateDelivrance().toString()));
            HttpConnection hc = (HttpConnection)Connector.open(encode("http://localhost/piegov/insertPassport.php?couleurYeux="  +passeport.getCouleurYeux().trim() +"&validation="+passeport.getValidation().trim() +"&dateDelivrance="+passeport.getDateDelivrance().toString().trim()));
       
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
    
   public Passeport[] select(){
       try {
            PasseportHandler passportHandlers = new PasseportHandler();
            // get a parser object
            SAXParser SAXparser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/piegov/selectPassport.php");//people.xml est un exemple
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            SAXparser.parse(dis, passportHandlers);
            // display the result
            passeports = passportHandlers.getPasseport();
             return passeports;
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        } catch (SAXException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

             return null;
   }
   
   
   public Passeport[] Find(String numPasseport){
        Passeport[] passePorts = null;
        //String requete="http://localhost/pidev/SelectBillet.php";
        
//    if(! label.equals(""))
//        {   System.out.println("Billetlist : CRITERE_VIDE() " +! (prix==0));
        String requete ;
            requete="http://localhost/piegov/FindPassport.php?numPasseport="+numPasseport;
//            System.out.println("Billetlist: requete affichage billet par prix: "+requete);
//        }   
       
        
        try {
           // BilletsHandler offreHandler = new BilletsHandler();
            PasseportHandler PassHandler = new PasseportHandler();
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            HttpConnection hc = (HttpConnection) Connector.open(requete);
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, PassHandler);
            // display the result
             passePorts = PassHandler.getPasseport();
        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        return passePorts;
    }
    
}
