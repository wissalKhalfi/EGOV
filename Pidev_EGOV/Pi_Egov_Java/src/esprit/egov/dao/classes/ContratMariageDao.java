/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.dao.classes;

import esprit.egov.dao.interfaces.IContratMariageDao;
import esprit.egov.entities.ContratMariage;
import esprit.egov.entities.Utilisateur;
import esprit.egov.gui.GestionContratMariage;

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
import sun.text.normalizer.ICUBinary;

/**
 *
 * @author boumaiza
 */
public class ContratMariageDao implements IContratMariageDao {

    private final Connection connection;
    private Object MyConnection;

    public ContratMariageDao() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void addContratMariage(ContratMariage contratMariage) {
        try {
            String req = "insert into contratmariage (id_contrat,date_mariage,id_epoux,id_epouse) values (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req);

            ps.setInt(1, contratMariage.getId_contrat());
            //ps.setDate(2, (java.sql.Date) permis.getDate_creation_permis());
            ps.setDate(2, new Date(contratMariage.getDate_mariage().getTime()));
            // ps.setDate(3,  new Date( passeport.getDateValidite().getTime()));
            ps.setString(3, contratMariage.getId_epoux());
            ps.setString(4, contratMariage.getId_epouse());
            //ps.setDate(4, (java.sql.Date) permis.getDate_validite_permis());

            // ps.setString(5,permis.getValidation());
            // ps.setInt(5,1);
            ps.executeUpdate();
            GestionContratMariage add = new GestionContratMariage();
            add.setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<ContratMariage> select() {
        List<ContratMariage> list = new ArrayList<>();
        String requete = "select * from contratmariage";
        try {
            Statement statement = connection
                    .createStatement();

            ResultSet res = statement.executeQuery(requete);
            while (res.next()) {
                ContratMariage pr = new ContratMariage();

                pr.setId_contrat(res.getInt("id_contrat"));
                //pr.setDate_mariage(res.getDate("date_mariage"));
                pr.setId_epoux(res.getString("id_epoux"));
                pr.setId_epouse(res.getString("id_epouse"));
                pr.setNumCinUtilisateur(res.getInt("numCinUtilisateur"));
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
    public ContratMariage getBynumCinUtilisateur(int id_contrat) {
        ContratMariage contratMariage = new ContratMariage();
        String requete = "SELECT id_contrat,date_mariage,id_epoux,id_epouse,validation FROM contratmariage WHERE id_contrat=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id_contrat);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                contratMariage.setId_contrat(resultat.getInt(1));
                contratMariage.setDate_mariage(resultat.getDate(2));

                contratMariage.setId_epoux(resultat.getString(3));
                contratMariage.setId_epouse(resultat.getString(4));

                contratMariage.setValidation(resultat.getString(5));

            }
            return contratMariage;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<ContratMariage> DisplayAllContratMariage() {
        List<ContratMariage> listeContratMariage = new ArrayList<ContratMariage>();

        String requete = "SELECT id_contrat,date_mariage,id_epoux,id_epouse,validation FROM contratmariage WHERE id_contrat=?";
        try {
           Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                ContratMariage contratMariage =new ContratMariage();
               
                contratMariage.setId_contrat(resultat.getInt(1));
               contratMariage.setDate_mariage(resultat.getDate(2));
               //contratMariage.setId_epoux(resultat.getDate(3));
                contratMariage.setId_epoux(resultat.getString(3));
                contratMariage.setId_epouse(resultat.getString(4));
               //passeport.setNumCinUtilisateur(resultat.getInt(5));
                contratMariage.setValidation(resultat.getString(5));
                
                
                listeContratMariage.add(contratMariage);
            }
            return listeContratMariage;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
    }

    @Override
    public void deleteContratMariage(int id_contrat) {
        String requete = "delete from contratmariage where id_contrat=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id_contrat);
             
            
           // ResultSet resultat = ps.executeQuery();
            ps.executeUpdate();
            System.out.println("contrat supprimé");
            JOptionPane.showMessageDialog(null, "Suppression effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }   
    }

    @Override
    public void updateContratMariage(ContratMariage b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
