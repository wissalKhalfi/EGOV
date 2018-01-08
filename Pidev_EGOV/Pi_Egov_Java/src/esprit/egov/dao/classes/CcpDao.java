/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.dao.classes;

import esprit.egov.entities.Ccp;
import esprit.egov.dao.interfaces.ICcpDao;
import esprit.egov.technique.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author USER
 */
public class CcpDao implements ICcpDao<Ccp>{
    
    private Connection connection;


    public CcpDao() {
            connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void addCcp(Ccp Ccp) {
        try {
            String req = "insert into ccp(num_ccp,code_ccp,solde_actuel,date_creation,date_dernier_versement,dernier_versement) values (?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, Ccp.getNum_ccp());
            ps.setInt(2, Ccp.getCode_ccp());
            ps.setInt(3, Ccp.getSolde_actuel());
            ps.setDate(4, Ccp.getDate_creation());
            ps.setDate(5, Ccp.getDate_dernier_versement());
            ps.setInt(6, Ccp.getDernier_versement());
            ps.executeUpdate();
            System.out.println("Insertion effectué avec succés");

        } catch (SQLException ex) {
            Logger.getLogger(CarteEdinarDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    

    @Override
    public void modifyCcp(Ccp Ccp) {
        try {
            String requete = "update ccp set code_ccp=?,solde_actuel=?,date_creation=?,date_dernier_versement=?,dernier_versement=? WHERE num_ccp=? ";
            PreparedStatement ps = connection.prepareStatement(requete);

            ps.setInt(1, Ccp.getCode_ccp());
            ps.setInt(2, Ccp.getSolde_actuel());
            ps.setDate(3, Ccp.getDate_creation());
            ps.setDate(4, Ccp.getDate_dernier_versement());
            ps.setInt(5, Ccp.getDernier_versement());
            ps.setInt(6, Ccp.getNum_ccp());

            ps.executeUpdate();
            System.out.println("Modification effectué avec succés");
        } catch (SQLException ex) {
            Logger.getLogger(CarteEdinarDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        }

    @Override
    public void removeCcp(Ccp Ccp) {
          try {
            String requete = "delete from  ccp where num_ccp=?";
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, Ccp.getNum_ccp());
            ps.executeUpdate();
            System.out.println("Compte supprimé");
        } catch (SQLException ex) {
            Logger.getLogger(CarteEdinarDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Vector<Ccp> findAll() {
   {

        Vector<Ccp> listecompte = new Vector<>();
        String requete = "select * from ccp";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Ccp ccp = new Ccp();
                ccp.setNum_ccp(resultat.getInt(1));
                ccp.setCode_ccp(resultat.getInt(2));
                ccp.setSolde_actuel(resultat.getInt(3));
                ccp.setDate_creation(resultat.getDate(6));
                listecompte.add(ccp);
            }
            return listecompte;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des cartes " + ex.getMessage());
            return null;
        }
   }}


 
    @Override
    public Ccp findCcp(int num_ccp) {
        Ccp carte = new Ccp();
        String requete = "select * from ccp where num_ccp=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, num_ccp);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                carte.setNum_ccp(resultat.getInt(1));
                carte.setCode_ccp(resultat.getInt(2));
                carte.setSolde_actuel(resultat.getInt(3));
                carte.setDate_creation(resultat.getDate(6));
                carte.setDate_dernier_versement(resultat.getDate(7));
                carte.setDernier_versement(resultat.getInt(8));

            }
            return carte;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du catégorie " + ex.getMessage());
            return null;
        }
    }
    
    @Override
    public Ccp findCcpbycode(int code_ccp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
