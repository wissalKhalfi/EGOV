/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.dao.classes;

import esprit.egov.dao.interfaces.IActesJuridiquesDao;
import esprit.egov.dao.interfaces.IListeActesDao;
import esprit.egov.dao.interfaces.IUtilisateurDao;
import esprit.egov.entities.ActesJuridiques;
import esprit.egov.entities.ListeActes;
import esprit.egov.entities.Utilisateur;
import esprit.egov.technique.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author macbookpro
 */
public class ListeActesDao implements IListeActesDao  {
     private Connection connection;

    public ListeActesDao() {
        connection = DataSource.getInstance().getConnection();
    }
     
    @Override
    public List<ListeActes> ListerActesParCitoyen(){
        List<ListeActes> Actes = new ArrayList<>();
        String requete = " SELECT * FROM liste_actes";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                
                ListeActes acte = new ListeActes();
                
                acte.setId(resultat.getInt(1));
                Utilisateur uti = new Utilisateur();
                IUtilisateurDao utiDao = new UtilisateurDao();
                uti = utiDao.findUtiByCIN(resultat.getString(3));
                acte.setCitoyen(uti);
                ActesJuridiques aj= new ActesJuridiques();
                IActesJuridiquesDao acteDao = new  ActesJuridiquesDao();
                aj = acteDao.FindActeById(resultat.getInt(2));
                acte.setActe(aj);                                               
                Actes.add(acte);              
            }
            return Actes;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des actes " + ex.getMessage());
           
        }
         return null;
    }
    
    @Override
    public List<ListeActes> TrouverActesParCitoyen(String numCin){
        List<ListeActes> Actes = new ArrayList<>();
        String requete = " SELECT * FROM liste_actes WHERE (citoyen like ?)";
        try {            
           PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1,"%"+numCin+"%");
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                
                ListeActes acte = new ListeActes();
                
                acte.setId(resultat.getInt(1));
                Utilisateur uti = new Utilisateur();
                IUtilisateurDao utiDao = new UtilisateurDao();
                uti = utiDao.findUtiByCIN(resultat.getString(3));
                acte.setCitoyen(uti);
                ActesJuridiques aj= new ActesJuridiques();
                IActesJuridiquesDao acteDao = new  ActesJuridiquesDao();
                aj = acteDao.FindActeById(resultat.getInt(2));
                acte.setActe(aj);                                               
                Actes.add(acte);              
            }
            return Actes;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des actes " + ex.getMessage());
           
        }
         return null;
    }

    @Override
    public List<ListeActes> TrouverCondamnesParActe(int idActe) {
         List<ListeActes> Actes = new ArrayList<>();
        String requete = " SELECT * FROM liste_actes WHERE (acte like ?)";
        try {            
           PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, idActe);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                
                ListeActes acte = new ListeActes();
                
                acte.setId(resultat.getInt(1));
                Utilisateur uti = new Utilisateur();
                IUtilisateurDao utiDao = new UtilisateurDao();
                uti = utiDao.findUtiByCIN(resultat.getString(3));
                acte.setCitoyen(uti);
                ActesJuridiques aj= new ActesJuridiques();
                IActesJuridiquesDao acteDao = new  ActesJuridiquesDao();
                aj = acteDao.FindActeById(resultat.getInt(2));
                acte.setActe(aj);                                               
                Actes.add(acte);              
            }
            return Actes;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des actes " + ex.getMessage());
           
        }
         return null;
    }

    @Override
    public List<ListeActes> TrouverActeCitoyen(String numCin, int idActe) {
     List<ListeActes> Actes = new ArrayList<>();
        String requete = " SELECT * FROM liste_actes WHERE (acte like ?) AND (citoyen like ?)";
        try {            
           PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, idActe);
            ps.setString(2, numCin);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                
                ListeActes acte = new ListeActes();
                
                acte.setId(resultat.getInt(1));
                Utilisateur uti = new Utilisateur();
                IUtilisateurDao utiDao = new UtilisateurDao();
                uti = utiDao.findUtiByCIN(resultat.getString(3));
                acte.setCitoyen(uti);
                ActesJuridiques aj= new ActesJuridiques();
                IActesJuridiquesDao acteDao = new  ActesJuridiquesDao();
                aj = acteDao.FindActeById(resultat.getInt(2));
                acte.setActe(aj);                                               
                Actes.add(acte);              
            }
            return Actes;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des actes " + ex.getMessage());
           
        }
         return null;
    }
    
}
