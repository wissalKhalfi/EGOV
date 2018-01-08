/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.dao.classes;

import esprit.egov.gui.Carteedinar;
import esprit.egov.dao.interfaces.ICarteEdinarDao;
import esprit.egov.entities.CarteEdinar;
import esprit.egov.technique.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class CarteEdinarDao implements ICarteEdinarDao<CarteEdinar> {

    private Connection connection;

    public CarteEdinarDao() {
         connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void addCarteEdinar(CarteEdinar carteedinar) {
        try {
            String req = "insert into carte_edinar(num_carte,code_carte,solde_actuel,date_creation,date_dernier_versement,dernier_versement) values (?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, carteedinar.getNum_carte());
            ps.setInt(2, carteedinar.getCode_carte());
            ps.setInt(3, carteedinar.getSolde_actuel());
            ps.setDate(4, carteedinar.getDate_creation());
            ps.setDate(5, carteedinar.getDate_dernier_versement());
            ps.setInt(6, carteedinar.getDernier_versement());
            ps.executeUpdate();
            System.out.println("Insertion effectué avec succés");

        } catch (SQLException ex) {
            Logger.getLogger(CarteEdinarDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void removeCarteEdinar(CarteEdinar carteedinar) {
        try {
            String requete = "delete from  carte_edinar where num_carte=?";
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, carteedinar.getNum_carte());
            ps.executeUpdate();
            System.out.println("Carte supprimé");
        } catch (SQLException ex) {
            Logger.getLogger(CarteEdinarDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Vector<CarteEdinar> findAll() {

        Vector<CarteEdinar> listecarte = new Vector<>();
        String requete = "select * from carte_edinar";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                CarteEdinar carte = new CarteEdinar();
                carte.setNum_carte(resultat.getInt(1));
                carte.setCode_carte(resultat.getInt(2));
                carte.setSolde_actuel(resultat.getInt(3));
                carte.setDate_creation(resultat.getDate(6));
                listecarte.add(carte);
            }
            return listecarte;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des cartes " + ex.getMessage());
            return null;
        }
    }

    @Override
    public CarteEdinar findCarteEdinarnum_carte(int num_carte) {
        CarteEdinar carte = new CarteEdinar();
        String requete = "select * from carte_edinar where num_carte=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, num_carte);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                carte.setNum_carte(resultat.getInt(1));
                carte.setCode_carte(resultat.getInt(2));
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
    public CarteEdinar findCarteEdinarcode_carte(int code_carte) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override

    public void modifyCarteEdinar(CarteEdinar carteedinar) {
        try {
            String requete = "update carte_edinar set code_carte=?,solde_actuel=?,date_creation=?,date_dernier_versement=?,dernier_versement=? WHERE num_carte=? ";
            PreparedStatement ps = connection.prepareStatement(requete);

            ps.setInt(1, carteedinar.getCode_carte());
            ps.setInt(2, carteedinar.getSolde_actuel());
            ps.setDate(3, carteedinar.getDate_creation());
            ps.setDate(4, carteedinar.getDate_dernier_versement());
            ps.setInt(5, carteedinar.getDernier_versement());
            ps.setInt(6, carteedinar.getNum_carte());

            ps.executeUpdate();
            System.out.println("Modification effectué avec succés");
        } catch (SQLException ex) {
            Logger.getLogger(CarteEdinarDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
