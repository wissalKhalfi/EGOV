/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.dao.classes;

import esprit.egov.dao.interfaces.IActesJuridiquesDao;
import esprit.egov.entities.ActesJuridiques;
import esprit.egov.entities.Utilisateur;
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
 * @author macbookpro
 */
public class ActesJuridiquesDao implements IActesJuridiquesDao {
    private Connection connection;

    public ActesJuridiquesDao() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public int addActeJuridique(ActesJuridiques acte) {
       try {
            String req = "insert into actes_juridiques (titre_acte,date_acte,desc_acte) values (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, acte.getTitreActe());
            ps.setDate(2, new java.sql.Date(acte.getDateActe().getTime()) );
            ps.setString(3, acte.getDescActe());
            int count = ps.executeUpdate();
           return count;
            

        } catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
       return 0;
    }
    

    @Override
    public List<ActesJuridiques> ListerActes() {
        List<ActesJuridiques> Actes = new ArrayList<>();
        String requete = " SELECT * FROM actes_juridiques";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                ActesJuridiques acte = new ActesJuridiques();
                acte.setIdActe(resultat.getInt(1));
                acte.setTitreActe(resultat.getString(2));
                acte.setDateActe(resultat.getDate(3));
                acte.setDescActe(resultat.getString(4));
                Actes.add(acte);              
            }
            return Actes;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des actes " + ex.getMessage());
           
        }
         return null;
    }
   @Override
    public ActesJuridiques FindActeById(int idActe){
       String requete = "select * from actes_juridiques where id_acte=?";

        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, idActe);
            ResultSet resultat = ps.executeQuery();
            ActesJuridiques acte = new ActesJuridiques();
            while (resultat.next()) {   
                acte.setIdActe(resultat.getInt(1));
                acte.setDateActe(resultat.getDate(3));
                acte.setDescActe(resultat.getString(4));
                acte.setTitreActe(resultat.getString(2));
            }
            return acte;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement de l'acte" + ex.getMessage());
            return null;
        } 
    }
@Override
    public void CondamnerUti(int idActe, String NumCin){
     try {
            String req = "insert into liste_actes (acte,citoyen) values (?,?)";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1,idActe);
            ps.setString(2,NumCin);ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
    }
    
}
