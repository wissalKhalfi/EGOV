/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.dao.classes;

import esprit.egov.dao.interfaces.IAppel_offreDao;
import esprit.egov.entities.Appel_offre;
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

/**
 *
 * @author mouad
 */
public class Appel_offreDao implements IAppel_offreDao {

    private Connection conn;

    public Appel_offreDao() {
        conn = DataSource.getInstance().getConnection();
    }

    @Override
    public List<Appel_offre> findAll() {
        List<Appel_offre> listeAppel_offre = new ArrayList<>();
        String requete = "select * from appel_offre";
        try {
            Statement statement = conn
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Appel_offre appel_offre = new Appel_offre();
                appel_offre.setId_appel(resultat.getInt(1));
                appel_offre.setObjet(resultat.getString(2));
                appel_offre.setEtat(resultat.getString(3));
                appel_offre.setDate_dep(resultat.getDate(4));
                appel_offre.setDate_fin(resultat.getDate(5));
                appel_offre.setLocalisation(resultat.getString(6));
                appel_offre.setProfil_demander(resultat.getString(7));
                listeAppel_offre.add(appel_offre);
            }
            return listeAppel_offre;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des appels d'offres " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void addAppel_offre(Appel_offre appel_offre) {
        try {
            String req = "insert into appel_offre (objet,date_deb,date_fin,localisation,profil_demande) values (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, appel_offre.getObjet());
            ps.setDate(2, new java.sql.Date(appel_offre.getDate_dep().getTime()));
            ps.setDate(3, new java.sql.Date(appel_offre.getDate_fin().getTime()));
            ps.setString(4, appel_offre.getLocalisation());
            ps.setString(5, appel_offre.getProfil_demander());
            ps.executeUpdate();
                        System.out.println("Mise à jour effectuée avec succès");

        } catch (SQLException ex) {
            System.out.println("erreur lors de l'ajout " + ex.getMessage());
        }
    }

    @Override
    public void updateAppel_offre(Appel_offre appel_offre) {
        String requete = "update `appel_offre` set `objet`=?, `date_deb`=?, `date_fin`=?,`localisation`=?,`profil_demande`=?  where id_appel=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, appel_offre.getObjet());
            ps.setDate(2, new java.sql.Date(appel_offre.getDate_dep().getTime()));
            ps.setDate(3, new java.sql.Date(appel_offre.getDate_fin().getTime()));
            ps.setString(4, appel_offre.getLocalisation());
            ps.setString(5, appel_offre.getProfil_demander());
            ps.setInt(6, appel_offre.getId_appel());

            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    @Override
    public void removeAppel_offreById(Appel_offre appel_offre) {
        String requete = "DELETE FROM `appel_offre` where id_appel=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, appel_offre.getId_appel());
            ps.executeUpdate();
            System.out.println("delete effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    @Override
    public Appel_offre findAppel_offreById(Appel_offre appel_offre) {
        String requete = "select * from appel_offre where id_appel=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, appel_offre.getId_appel());
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                appel_offre.setId_appel(resultat.getInt(1));
            }
            return appel_offre;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche " + ex.getMessage());
            return null;
        }
    }
    @Override
    public List<Appel_offre> findByID() {
        List<Appel_offre> listeAppel_offre = new ArrayList<>();
        String requete = "select * from appel_offre where id_appel=?";
        try {
            Statement statement = conn
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Appel_offre appel_offre = new Appel_offre();
                appel_offre.setId_appel(resultat.getInt(1));
                appel_offre.setObjet(resultat.getString(2));
                appel_offre.setEtat(resultat.getString(3));
                appel_offre.setDate_dep(resultat.getDate(4));
                appel_offre.setDate_fin(resultat.getDate(5));
                appel_offre.setLocalisation(resultat.getString(6));
                appel_offre.setProfil_demander(resultat.getString(7));
                listeAppel_offre.add(appel_offre);
            }
            return listeAppel_offre;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des appels d'offres " + ex.getMessage());
            return null;
        }
        
    }

    
}
