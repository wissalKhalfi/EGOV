/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.dao.classes;

import esprit.egov.dao.interfaces.IArticlesDao;
import esprit.egov.entities.Articles;
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
public class ArticlesDao implements IArticlesDao<Articles> {

    private Connection connection;
    public ArticlesDao() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void addArticle(Articles article) {
        try {
            String req = "insert into articles(id_article,titre_article,date_article,image_article,texte_article,priorite_pub,type) values (?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, article.getId_article());
            ps.setString(2, article.getTitre_article());
            ps.setDate(3, article.getDate_article());
            ps.setBlob(4, article.getFin());
            ps.setString(5, article.getTexte_article());
            ps.setInt(6, article.getPriorite_pub());
            ps.setString(7, article.getType());
            ps.executeUpdate();
            System.out.println("Insertion effectué avec succés");

        } catch (SQLException ex) {
            Logger.getLogger(CarteEdinarDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Vector findAll() {
        Vector<Articles> listecarte = new Vector<>();
        String requete = "select * from articles";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Articles carte = new Articles();
                carte.setId_article(resultat.getInt(1));
                carte.setTitre_article(resultat.getString(2));
                carte.setDate_article(resultat.getDate(3));
                carte.setType(resultat.getString(7));
                listecarte.add(carte);
            }
            return listecarte;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des cartes " + ex.getMessage());
            return null;
        }
    }

    @Override
    public Vector findArticlestype(String type) {
        try {
            Vector<Articles> listearticle = new Vector<>();
            String requete = "select * from articles where type=?";
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, type);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Articles article = new Articles();
                article.setId_article(resultat.getInt(1));
                article.setTitre_article(resultat.getString(2));
                article.setDate_article(resultat.getDate(3));
                article.setImage_article(resultat.getBlob(4));
                article.setTexte_article(resultat.getString(5));
                article.setType(resultat.getString(7));
                listearticle.add(article);
            }
            return listearticle;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des articles " + ex.getMessage());
            return null;
        }

    }

    @Override
    public void modifyArticle(Articles article) {
    }

    @Override
    public void removeArticle(Articles article) {
        try {
            String requete = "delete from  articles where id_article=?";
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, article.getId_article());
            ps.executeUpdate();
            System.out.println("Carte supprimé");
        } catch (SQLException ex) {
            Logger.getLogger(CarteEdinarDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Articles findArticlesid(int id) {
        Articles carte = new Articles();
        String requete = "select * from articles where id_article=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                carte.setId_article(resultat.getInt(1));
                carte.setTitre_article(resultat.getString(2));
                carte.setDate_article(resultat.getDate(3));
                carte.setType(resultat.getString(7));

            }
            return carte;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du catégorie " + ex.getMessage());
            return null;
        }
    }
}
