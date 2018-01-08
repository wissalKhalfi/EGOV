/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.dao.classes;

import com.itextpdf.text.*;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import esprit.egov.dao.interfaces.IPermisDao;
import esprit.egov.entities.Permis;
import esprit.egov.entities.Utilisateur;
import esprit.egov.technique.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import esprit.egov.gui.GestionPermis;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.io.FileOutputStream;
import javax.swing.text.Document;



/**
 *
 * @author Aya
 */
public class PermisDao implements IPermisDao{

        private final Connection connection;
    private Object MyConnection;
    
    public PermisDao() {
        connection = DataSource.getInstance().getConnection();
    }
    
////    @Override
////    public void addPermis(Permis permis) {
////       
////               String requete = "insert into Permis (categorie_permis,validation) values (?,?)";
////        try {
////            System.out.println("2");
////            
////            PreparedStatement ps = connection.prepareStatement(requete);
////                  ps.setString(1, permis.getCategorie_permis());
////                 
////                //ps.setDate(6, (Date) permis.getDate());
////              //  ps.setDate(6,  new Date( permis.getDate_creation_permis().getTime()));
////                  
////                  ps.setString(1, permis.getValidation());
////                  //ps.setDate(6, new Date(permis.getDate_creation_permis().getTime()));
////                  
////            
////
////           // ps.setInt(10, d.getVendeur().getId_vendeur());
////            
////           
////
////            
////              
////            ps.executeUpdate();
////            System.out.println("Ajout effectuée avec succès");
////            JOptionPane.showMessageDialog(null, "Ajout effectué avec succès");
////        } catch (SQLException ex) {
////           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
////            System.out.println("erreur lors de l'insertion "+ex.getMessage());
////            JOptionPane.showMessageDialog(null, "erreur lors de l'insertion "+ex.getMessage());
////
////        }
////        
////        
////    }
   
    
        @Override
    public void addPermis(Permis permis) {
        
       try {
            String req = "insert into Permis (numPermis,date_creation_permis,categorie_permis,Date_validite_permis) values (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req);
           
            ps.setInt(1,permis.getNumPermis());
            //ps.setDate(2, (java.sql.Date) permis.getDate_creation_permis());
            ps.setDate(2,  new Date( permis.getDate_creation_permis().getTime()));
            ps.setString(3,permis.getCategorie_permis());
            //ps.setDate(4, (java.sql.Date) permis.getDate_validite_permis());
            ps.setDate(4,  new Date( permis.getDate_validite_permis().getTime()));
            
            // ps.setString(5,permis.getValidation());
            
            // ps.setInt(5,1);
            ps.executeUpdate();
            GestionPermis add=new GestionPermis ();
            add.setVisible(true);
            
        
        } catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

        
    
  @Override
public List<Permis> select() {
        List<Permis> list = new ArrayList<>();
        String requete = "select * from permis";
        try {
            Statement statement = connection
                    .createStatement();
           
            ResultSet res = statement.executeQuery(requete);
            while (res.next()) {
                Permis pr = new Permis();
                
                pr.setNumPermis(res.getInt("numPermis"));
                pr.setDate_creation_permis(res.getDate("Date_creation_permis"));
                pr.setCategorie_permis(res.getString("Categorie_permis"));
                pr.setDate_validite_permis(res.getDate("Date_validite_permis"));
               pr.setNumCinUtilisateur(res.getString("numCinUtilisateur"));
                pr.setValidation(res.getString("Validation"));

                list.add(pr);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des stocks " + ex.getMessage());
            return null;
        }
    }

       
    
    @Override
       public Permis getBynumCinUtilisateur(int numPermis) {
       
        Permis permis = new Permis();
        String requete = "select * from permis where numPermis=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, numPermis);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                permis.setNumPermis(resultat.getInt(1));
                permis.setDate_creation_permis(resultat.getDate(2));
                permis.setCategorie_permis(resultat.getString(3));
                permis.setDate_validite_permis(resultat.getDate(4));
                permis.setNumCinUtilisateur(resultat.getString(5));
                permis.setValidation(resultat.getString(6));

            }
            return permis;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    
    }
    
    @Override
    public List<Permis> DisplayAllPermis(){


        List<Permis> listePermis = new ArrayList<Permis>();

        String requete = "select * from permis";
        try {
           Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                Permis permis =new Permis();
               
                permis.setNumPermis(resultat.getInt(1));
               permis.setDate_creation_permis(resultat.getDate(2));
               permis.setCategorie_permis(resultat.getString(3));
                permis.setDate_validite_permis(resultat.getDate(4));
               permis.setNumCinUtilisateur(resultat.getString(5));
                permis.setValidation(resultat.getString(6));
                
                
                listePermis.add(permis);
            }
            return listePermis;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
    }
    
    
    
    @Override
     public void deletePermis(int numPermis){
        String requete = "delete from permis where numPermis=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, numPermis);
             
            
           // ResultSet resultat = ps.executeQuery();
            ps.executeUpdate();
            System.out.println("Permis supprimé");
            JOptionPane.showMessageDialog(null, "Suppression effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }
     
    
       
     
     
//     public void updateTimbre(Timbre b) {
//        try {
//            Statement ste = connection.createStatement();
//            String req2 = "update timbre set prix = '"+b.getPrix()+"',numSerie = '"+b.getNumSerie()+"',type = '"+b.getType()+"'"+"where id="+b.getId();
//            ste.executeUpdate(req2);
//            JOptionPane.showMessageDialog(null, "Votre modification est effectué avec succés", "Inscription",
//                    JOptionPane.INFORMATION_MESSAGE);
//        } catch (SQLException ex) {
//            Logger.getLogger(TimbreDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//}
     
     
      
//        @Override
//     public void updatePermis(Permis b) {
//        try {
//            Statement ste = connection.createStatement();
//            String req2 = "update permis set date_creation_permis = "+b.getDate_creation_permis()+",categorie_permis = "+b.getCategorie_permis()+"Date_validite_permis = "+b.getDate_validite_permis()+", where numPermis="+b.getNumPermis();
//              //String requete = "update permis set date_creation_permis=?,categorie_permis=?,Date_validite_permis=?,numPermis=? where numPermis=?";
//            ste.executeUpdate(req2);
//            JOptionPane.showMessageDialog(null, "Votre modification est effectué avec succés", "Inscription",
//                    JOptionPane.INFORMATION_MESSAGE);
//        } catch (SQLException ex) {
//            Logger.getLogger(PermisDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//}
     
        @Override
 public void updatePermis(Permis p) {
        try {
            String requete = "update permis set date_creation_permis=?,categorie_permis=?,date_validite_permis=? WHERE numPermis=? ";
            PreparedStatement ps = connection.prepareStatement(requete);

            
            ps.setDate(1, (Date) p.getDate_creation_permis());
            ps.setString(2, p.getCategorie_permis());
            ps.setDate(3, (Date) p.getDate_validite_permis());
            ps.setInt(4, p.getNumPermis());
//            ps.setInt(5, p.getCategorie_permis());
//          ps.setInt(6, carteedinar.getNum_carte());

            ps.executeUpdate();
            System.out.println("Modification effectué avec succés");
        } catch (SQLException ex) {
            Logger.getLogger(PermisDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     
      
    public Utilisateur showExtraitNaissance(Date dateNaissance, String nom, String prenom) {
        String requete = "select * from utilisateur where nom=? AND prenom=? AND date_naissance=?";

        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setDate(3, (java.sql.Date) dateNaissance);
            ResultSet resultat = ps.executeQuery();
            //IDepotDao depotDao = new DepotDao();
            Utilisateur uti = new Utilisateur();
            while (resultat.next()) {

                uti.setNom(resultat.getString(1));
            }
            return uti;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }
       
    }
     
     
     
     
     
         public Permis showPermis(int numPermis) {
        String requete = "select * from permis where numPermis=? ";

        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, numPermis);
            ResultSet resultat = ps.executeQuery();
            //IDepotDao depotDao = new DepotDao();
            Permis permis = new Permis();
            while (resultat.next()) {

                permis.setNumPermis(resultat.getInt(1));
            }
            return permis;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }
       
    }
    

          @Override
    public int StatCategorie(String categorie_permis) {
         try {
            String req="SELECT COUNT(*) FROM permis WHERE (categorie_permis like ?)";
            PreparedStatement ps=connection.prepareStatement(req);
            ps.setString(1,categorie_permis);
            ResultSet resultat=ps.executeQuery();
            while (resultat.next()) {
                return resultat.getInt(1);
                    
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return 0;
    }
}





