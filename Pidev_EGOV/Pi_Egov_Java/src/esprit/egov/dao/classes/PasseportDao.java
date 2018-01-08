/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.dao.classes;

import esprit.egov.dao.interfaces.IPasseportDao;
import esprit.egov.entities.Passeport;
import esprit.egov.entities.Permis;
import esprit.egov.entities.Utilisateur;
import esprit.egov.gui.GestionPasseport;
import esprit.egov.gui.GestionPermis;
import esprit.egov.technique.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author boumaiza
 */
public class PasseportDao implements IPasseportDao {

    private final Connection connection;
    private Object MyConnection;

    public PasseportDao() {
        connection = DataSource.getInstance().getConnection();
    }
    
    
    @Override
    public void addPasseport(Passeport passeport) {
try {
            String req = "insert into passeport (numPasseport,dateDelivrance,dateValidite,couleurYeux) values (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req);
           
            ps.setInt(1,passeport.getNumPasseport());
            //ps.setDate(2, (java.sql.Date) permis.getDate_creation_permis());
            ps.setDate(2,  new Date( passeport.getDateDelivrance().getTime()));
            ps.setDate(3,  new Date( passeport.getDateValidite().getTime()));
            ps.setString(4,passeport.getCouleurYeux());
            //ps.setDate(4, (java.sql.Date) permis.getDate_validite_permis());
          
            
            // ps.setString(5,permis.getValidation());
            
            // ps.setInt(5,1);
            ps.executeUpdate();
            GestionPasseport add=new GestionPasseport();
            add.setVisible(true);
            
        
        } catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
           }

    @Override
    public List<Passeport> select() {
 List<Passeport> list = new ArrayList<>();
        String requete = "select * from passeport";
        try {
            Statement statement = connection
                    .createStatement();
           
            ResultSet res = statement.executeQuery(requete);
            while (res.next()) {
                Passeport pr = new Passeport();
                
                pr.setNumPasseport(res.getInt("numPasseport"));
//                pr.setDateDelivrance(res.getDate("dateDelivrance"));
//                pr.setDateValidite(res.getDate("dateValidite"));
                pr.setCouleurYeux(res.getString("couleurYeux"));
               pr.setNumCinUtilisateur(res.getInt("numCinUtilisateur"));
                pr.setValidation(res.getString("Validation"));
                
                list.add(pr);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des stocks " + ex.getMessage());
            return null;
        }    }

    @Override
    public Passeport getBynumCinUtilisateur(int numPasseport) {
  Passeport passeport = new Passeport();
        String requete = "SELECT numPasseport,dateDelivrance,dateValidite,couleurYeux,validation FROM passeport WHERE numPasseport=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, numPasseport);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                passeport.setNumPasseport(resultat.getInt(1));
                passeport.setDateDelivrance(resultat.getDate(2));
                passeport.setDateValidite(resultat.getDate(3));
                passeport.setCouleurYeux(resultat.getString(4));
                
              // passeport.setNumCinUtilisateur(resultat.getInt(5));
                passeport.setValidation(resultat.getString(5));

            }
            return passeport;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
        }

    @Override
    public List<Passeport> DisplayAllPasseport() {
        
        List<Passeport> listePasseport = new ArrayList<Passeport>();

        String requete = "SELECT numPasseport,dateDelivrance,dateValidite,couleurYeux,validation FROM passeport WHERE numPasseport=?";
        try {
           Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                Passeport passeport =new Passeport();
               
                passeport.setNumPasseport(resultat.getInt(1));
               passeport.setDateDelivrance(resultat.getDate(2));
               passeport.setDateValidite(resultat.getDate(3));
                passeport.setCouleurYeux(resultat.getString(4));
               //passeport.setNumCinUtilisateur(resultat.getInt(5));
                passeport.setValidation(resultat.getString(5));
                
                
                listePasseport.add(passeport);
            }
            return listePasseport;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
    }
    
    
    
//    @Override
//     public void deletePermis(int numPermis){
//        String requete = "delete from permis where numPermis=?";
//        try {
//            PreparedStatement ps = connection.prepareStatement(requete);
//            ps.setInt(1, numPermis);
//             
//            
//           // ResultSet resultat = ps.executeQuery();
//            ps.executeUpdate();
//            System.out.println("Permis supprimé");
//            JOptionPane.showMessageDialog(null, "Suppression effectuée avec succès");
//        } catch (SQLException ex) {
//           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("erreur lors de la suppression "+ex.getMessage());
//        }
//    }
//    }

    @Override
    public void deletePasseport(int numPasseport) {
     String requete = "delete from passeport where numPasseport=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, numPasseport);
             
            
           // ResultSet resultat = ps.executeQuery();
            ps.executeUpdate();
            System.out.println("Passeport supprimé");
            JOptionPane.showMessageDialog(null, "Suppression effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }    }

    

    

    @Override
    public int StatCategorie(String couleurYeux) {
        try {
            String req="SELECT COUNT(*) FROM passeport WHERE (couleurYeux like ?)";
            PreparedStatement ps=connection.prepareStatement(req);
            ps.setString(1,couleurYeux);
            ResultSet resultat=ps.executeQuery();
            while (resultat.next()) {
                return resultat.getInt(1);
                    
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return 0;
    }

    @Override
    public void updatePasseport(Passeport b) {

        try {
            String requete = "update passeport set dateDelivrance=?,dateValidite=?,couleurYeux=? WHERE numPasseport=? ";
            PreparedStatement ps = connection.prepareStatement(requete);

            
            ps.setDate(1, (Date) b.getDateDelivrance());
            
            ps.setDate(2, (Date) b.getDateValidite());
            ps.setString(3, b.getCouleurYeux());
            ps.setInt(4, b.getNumPasseport());
//            ps.setInt(5, p.getCategorie_permis());
//          ps.setInt(6, carteedinar.getNum_carte());

            ps.executeUpdate();
            System.out.println("Modification effectué avec succés");
        } catch (SQLException ex) {
            Logger.getLogger(PermisDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    }
    


