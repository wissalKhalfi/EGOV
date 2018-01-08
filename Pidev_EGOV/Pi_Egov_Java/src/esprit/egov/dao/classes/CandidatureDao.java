/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.dao.classes;

import esprit.egov.dao.interfaces.ICandidatureDao;
import esprit.egov.entities.Candidature;
import esprit.egov.technique.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mouad
 */
public class CandidatureDao implements ICandidatureDao{
    private Connection conn;

    public CandidatureDao() {
            conn = DataSource.getInstance().getConnection();

    }

    @Override
    public List<Candidature> findAll() {
List<Candidature> listeCandidatures = new ArrayList<>();
        String requete = "select * from candidature";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Candidature candidature = new Candidature();
                candidature.setId_candidature(resultat.getInt(1));
                candidature.setEtat(resultat.getString(2));
                candidature.setUtilisateur(resultat.getString(3));
                candidature.setEntreprise(resultat.getInt(4));
                candidature.setCV(resultat.getString(5));
                listeCandidatures.add(candidature);
            }
            return listeCandidatures;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des candidatures " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void addCandidature(Candidature candidature) {
 try {
            String req = "insert into candidature (etat,candidat,entreprise,cv) values (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, candidature.getEtat());
            ps.setString(2, candidature.getUtilisateur());
            ps.setInt(3, candidature.getEntreprise());
            ps.setString(4, candidature.getCV());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CandidatureDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateCandidature(Candidature candidature) {
        String requete = "update `candidature` set `etat`=? where id_candidature=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, candidature.getEtat());
            ps.setInt(2, candidature.getId_candidature());

            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }

    }

    @Override
    public void removeDepotById(int id_candidature) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Candidature findCandidatureById(int id_candidature) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
