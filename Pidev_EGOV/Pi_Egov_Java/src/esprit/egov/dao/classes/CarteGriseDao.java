/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.dao.classes;

import esprit.egov.dao.interfaces.IPermisDao;
import esprit.egov.dao.interfaces.ICarteGriseDao;
import esprit.egov.entities.CarteGrise;
import esprit.egov.entities.Permis;
import esprit.egov.entities.Utilisateur;
import esprit.egov.gui.GestionCarteGrise;
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
 * @author Aya
 */
public class CarteGriseDao implements ICarteGriseDao {

    private final Connection connection;
    private Object MyConnection;

    public CarteGriseDao() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void addCarteGrise(CarteGrise carteGrise) {
        try {
            String req = "INSERT INTO carte_grise( marque_vehicule, num_serie_vehicule, type_vehicule, date_achat_vehicule, couleur_vehicue )  values (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req);

            ps.setString(1, carteGrise.getMarque_vehicule());
            ps.setString(2, carteGrise.getNum_serie_vehicule());
            ps.setString(3, carteGrise.getType_vehicule());
            ps.setDate(4, new Date(carteGrise.getDate_achat_vehicule().getTime()));
            ps.setString(5, carteGrise.getCouleur_vehicule());
            //ps.setInt(1,carteGrise.getNum_cinUtilisateur());
            //  ps.setInt(5,1);
            ps.executeUpdate();
            GestionCarteGrise add = new GestionCarteGrise();
            add.setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    
   
    public List<CarteGrise> select() {
        List<CarteGrise> list = new ArrayList<>();
        String requete = "select id_carte_grise,marque_vehicule,num_serie_vehicule,type_vehicule,couleur_vehicue,num_cinUtilisateur,validation from carte_grise";
        try {
            Statement statement = connection
                    .createStatement();

            ResultSet res = statement.executeQuery(requete);
            while (res.next()) {
                CarteGrise pr = new CarteGrise();

                pr.setId_carte_grise(res.getInt("id_carte_grise"));
                pr.setMarque_vehicule(res.getString("marque_vehicule"));
                pr.setNum_serie_vehicule(res.getString("num_serie_vehicule"));
                pr.setType_vehicule(res.getString("type_vehicule"));
              //pr.setDate_achat_vehicule(res.getDate("date_achat_vehicule"));
                pr.setCouleur_vehicule(res.getString("couleur_vehicue"));
                pr.setNum_cinUtilisateur(res.getInt("num_cinUtilisateur"));
                pr.setValidation(res.getString("validation"));

                list.add(pr);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des stocks " + ex.getMessage());
            return null;
        }
    }

  
 @Override
     public void updateCarteGrise(CarteGrise c) {
        try {
            Statement ste = connection.createStatement();
            String req2 = "update carte_grise set marque_vehicule = '"+c.getMarque_vehicule()+"',num_serie_vehicule = '"+c.getNum_serie_vehicule()+"'type_vehicule = '"+c.getType_vehicule()+"',couleur_vehicue = '"+c.getCouleur_vehicule()+"',"+"where id_carte_grise="+c.getId_carte_grise();
            //ste.executeUpdate(req2);
            JOptionPane.showMessageDialog(null, "Votre modification est effectué avec succés", "Inscription",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(CarteGriseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
}
         
    @Override
     public void deleteCarteGrise(int id_carte_grise_){
        String requete = "delete from carte_grise where id_carte_grise=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id_carte_grise_);
             
            
           // ResultSet resultat = ps.executeQuery();
            ps.executeUpdate();
            System.out.println("carte grise supprimée");
            JOptionPane.showMessageDialog(null, "Suppression effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
        
        
 
    
    
    }
     
     
     
         
    @Override
       public CarteGrise getByIdCarteGrise(int id_carte_grise)
 {
       
        
        CarteGrise carteGrise = new CarteGrise();
       // String requete = "select id_carte_grise,marque_vehicule,num_serie_vehicule,type_vehicule,couleur_vehicue,num_cinUtilisateur,validation from carte_grise";
       
        String requete = "select * from carte_grise where id_carte_grise=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id_carte_grise);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
               
                
                
                carteGrise.setId_carte_grise(resultat.getInt("id_carte_grise"));
                carteGrise.setMarque_vehicule(resultat.getString("marque_vehicule"));
                carteGrise.setNum_serie_vehicule(resultat.getString("num_serie_vehicule"));
                carteGrise.setType_vehicule(resultat.getString("type_vehicule"));
              //pr.setDate_achat_vehicule(res.getDate("date_achat_vehicule"));
                carteGrise.setCouleur_vehicule(resultat.getString("couleur_vehicue"));
                carteGrise.setNum_cinUtilisateur(resultat.getInt("num_cinUtilisateur"));
                carteGrise.setValidation(resultat.getString("validation"));

            }
            return carteGrise;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    
    }
       
       
       
    
}
