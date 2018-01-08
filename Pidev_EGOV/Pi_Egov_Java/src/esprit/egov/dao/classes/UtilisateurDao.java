/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.dao.classes;

import esprit.egov.dao.interfaces.IUtilisateurDao;
import esprit.egov.entities.ActesJuridiques;
import esprit.egov.entities.ListeActes;
import esprit.egov.entities.Utilisateur;
import esprit.egov.gui.GestionEn;
import esprit.egov.technique.DataSource;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import esprit.egov.dao.classes.ActesJuridiquesDao;
import esprit.egov.dao.interfaces.IActesJuridiquesDao;
import esprit.egov.gui.GestionAttestationDeResidence;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author macbookpro
 */
public class UtilisateurDao implements IUtilisateurDao {

    private Connection connection;

    public UtilisateurDao() {
        connection = DataSource.getInstance().getConnection();
    }
    
    @Override
    public String SeConnecter(String login, String password){
        try {
            String req="select * from fos_user where (username like ?) and (password like ?)";
            PreparedStatement ps=connection.prepareStatement(req);
            ps.setString(1,login);
            ps.setString(2, password);
            ResultSet resultat=ps.executeQuery();
            while (resultat.next()) {
                System.out.println(resultat.getString(15));
                return resultat.getString(15);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return null;
       
    }

    @Override
    public void addExtraitNaissance(Utilisateur uti) {

        try {
            String req = "insert into utilisateur (nom,prenom,date_naissance,lieu_naissance,nom_pere,prenom_pere,nom_mere,prenom_mere,sexe,validation) values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, uti.getNom());
            ps.setString(2, uti.getPrenom());
            ps.setDate(3, new java.sql.Date(uti.getDateNaissance().getTime()));
            ps.setString(4, uti.getLieuNaissance());
            ps.setString(5, uti.getNomPere());
            ps.setString(6, uti.getPrenomPere());
            ps.setString(7, uti.getNomMere());
            ps.setString(8, uti.getPrenomMere());
            ps.setString(9, uti.getSexe());
            ps.setInt(10, 1);
            ps.executeUpdate();
            GestionEn add = new GestionEn();
            add.setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void updateExtraitNaissance(Utilisateur utilisateur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Utilisateur> findAll() {
        List<Utilisateur> demandesEN = new ArrayList<>();
        String requete = " SELECT * FROM utilisateur";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            IUtilisateurDao utilisateurDAO = new UtilisateurDao();
            while (resultat.next()) {
                Utilisateur Utilisateur = new Utilisateur();
                Utilisateur.setNom(resultat.getString(3));
                Utilisateur.setPrenom(resultat.getString(4));
                Utilisateur.setDateNaissance(resultat.getDate(6));
                Utilisateur.setLieuNaissance(resultat.getString(7));
                Utilisateur.setNomPere(resultat.getString(9));
                Utilisateur.setPrenomPere(resultat.getString(10));
                Utilisateur.setNomMere(resultat.getString(11));
                Utilisateur.setPrenomMere(resultat.getString(12));
                Utilisateur.setSexe(resultat.getString(13));

                demandesEN.add(Utilisateur);
            }
            return demandesEN;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des demandes " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Utilisateur> findAllEN() {
        List<Utilisateur> demandesEN = new ArrayList<>();
        String requete = " SELECT * FROM utilisateur WHERE validation > 1 ";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            IUtilisateurDao utilisateurDAO = new UtilisateurDao();
            while (resultat.next()) {
                Utilisateur Utilisateur = new Utilisateur();
                Utilisateur.setIduti(resultat.getInt(1));
                Utilisateur.setNom(resultat.getString(3));
                Utilisateur.setPrenom(resultat.getString(4));
                Utilisateur.setDateNaissance(resultat.getDate(6));
                Utilisateur.setLieuNaissance(resultat.getString(7));
                Utilisateur.setNomPere(resultat.getString(9));
                Utilisateur.setPrenomPere(resultat.getString(10));
                Utilisateur.setNomMere(resultat.getString(11));
                Utilisateur.setPrenomMere(resultat.getString(12));
                Utilisateur.setSexe(resultat.getString(13));

                demandesEN.add(Utilisateur);
            }
            return demandesEN;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des demandes " + ex.getMessage());
            return null;
        }
    }

    @Override
    public Utilisateur findUtilisateurByDateNaiss(Date dateNaissance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateur findUtilisateurByAdresse(String adresse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateur showExtraitNaissance(Date dateNaissance, String nom, String prenom) {
        String requete = "select * from utilisateur where nom=? AND prenom=? AND date_naissance=?";

        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setDate(3, (java.sql.Date) dateNaissance);
            ResultSet resultat = ps.executeQuery();
            //IDepotDao depotDao = new DepotDao();
            Utilisateur uti = new Utilisateur();
            while (resultat.next()) {

                uti.setNom(resultat.getString(1));
            }
            return uti;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }

    }
    
    @Override
    public Utilisateur showExtraitNaissance(int id) {
        String requete = "select * from utilisateur where id_uti=?";

        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            Utilisateur Utilisateur = new Utilisateur();
            while (resultat.next()) {                
                Utilisateur.setIduti(resultat.getInt(1));
                Utilisateur.setNom(resultat.getString(3));
                Utilisateur.setPrenom(resultat.getString(4));
                Utilisateur.setDateNaissance(resultat.getDate(6));
                Utilisateur.setLieuNaissance(resultat.getString(7));
                Utilisateur.setNomPere(resultat.getString(9));
                Utilisateur.setPrenomPere(resultat.getString(10));
                Utilisateur.setNomMere(resultat.getString(11));
                Utilisateur.setPrenomMere(resultat.getString(12));
                Utilisateur.setSexe(resultat.getString(13));
            }
            return Utilisateur;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }

    }

    @Override
    public List<Utilisateur> ListerDemandesEN() {
        List<Utilisateur> demandesEN = new ArrayList<>();
        String requete = " SELECT * FROM utilisateur WHERE validation=1";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            IUtilisateurDao utilisateurDAO = new UtilisateurDao();
            while (resultat.next()) {
                Utilisateur Utilisateur = new Utilisateur();
                Utilisateur.setIduti(resultat.getInt(1));
                Utilisateur.setNom(resultat.getString(3));
                Utilisateur.setPrenom(resultat.getString(4));
                Utilisateur.setDateNaissance(resultat.getDate(6));
                Utilisateur.setLieuNaissance(resultat.getString(7));
                Utilisateur.setNomPere(resultat.getString(9));
                Utilisateur.setPrenomPere(resultat.getString(10));
                Utilisateur.setNomMere(resultat.getString(11));
                Utilisateur.setPrenomMere(resultat.getString(12));
                Utilisateur.setSexe(resultat.getString(13));

                demandesEN.add(Utilisateur);
            }
            return demandesEN;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des demandes " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Utilisateur> findUtilisateurByNomPrenomDateNaiss(String nom, String prenom, Date dateNaissance) {
        List<Utilisateur> EN = new ArrayList<>();
        String requete = " SELECT * FROM utilisateur WHERE nom=? AND prenom=? AND date_naissance like ?";
        try {

            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setDate(3, (java.sql.Date) dateNaissance);
            ResultSet resultat = ps.executeQuery(requete);
            IUtilisateurDao utilisateurDAO = new UtilisateurDao();
            while (resultat.next()) {
                Utilisateur Utilisateur = new Utilisateur();
                Utilisateur.setNom(resultat.getString(3));
                Utilisateur.setPrenom(resultat.getString(4));
                Utilisateur.setDateNaissance(resultat.getDate(6));
                Utilisateur.setLieuNaissance(resultat.getString(7));
                Utilisateur.setNomPere(resultat.getString(9));
                Utilisateur.setPrenomPere(resultat.getString(10));
                Utilisateur.setNomMere(resultat.getString(11));
                Utilisateur.setPrenomMere(resultat.getString(12));
                Utilisateur.setSexe(resultat.getString(13));

                EN.add(Utilisateur);
            }
            return EN;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des demandes " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void accepterDemandeEN(int id) {
        try {
            String req = "UPDATE Utilisateur SET validation = 2 WHERE id_uti=?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void RefuserDemandeEN(int id) {
        try {
            String req = "UPDATE Utilisateur SET validation = 3 WHERE id_uti=?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Utilisateur> findUtilisateurByNom(String n) {
        List<Utilisateur> EN = new ArrayList<>();
        System.out.println("Nom:  " + n);
        String requete = " SELECT * FROM utilisateur WHERE nom LIKE '(?)' ";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, "%" + n + "%");
            ResultSet resultat = ps.executeQuery(requete);
            System.out.println(resultat.toString());
            IUtilisateurDao utilisateurDAO = new UtilisateurDao();
            while (resultat.next()) {
                Utilisateur Utilisateur = new Utilisateur();
                Utilisateur.setNom(resultat.getString(3));
                Utilisateur.setPrenom(resultat.getString(4));
                Utilisateur.setDateNaissance(resultat.getDate(6));
                Utilisateur.setLieuNaissance(resultat.getString(7));
                Utilisateur.setNomPere(resultat.getString(9));
                Utilisateur.setPrenomPere(resultat.getString(10));
                Utilisateur.setNomMere(resultat.getString(11));
                Utilisateur.setPrenomMere(resultat.getString(12));
                Utilisateur.setSexe(resultat.getString(13));

                EN.add(Utilisateur);
            }
            return EN;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void addCin(Utilisateur uti) {
        int id = 0;
        String requete = " select * from utilisateur where (nom like ?) and (prenom like ?) and (date_naissance like ? )  "
                + "and(lieu_naissance like ?) and (nom_pere like ?) ";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, uti.getNom());
            ps.setString(2, uti.getPrenom());
            Date dateNaiss = uti.getDateNaissance();
            java.sql.Date sqlDate = new java.sql.Date(dateNaiss.getTime());
            ps.setDate(3, sqlDate);
            ps.setString(4, uti.getLieuNaissance());
            ps.setString(5, uti.getNomPere());
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                id = resultat.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement de l'utilisateur " + ex.getMessage());

        }
        try {
            String req = "UPDATE Utilisateur "
                    + "SET validation = 3 , num_cin = ?, statut_social = ? ,adresse= ? , photo= ?  "
                    + "WHERE id_uti= ?";
            PreparedStatement p = connection.prepareStatement(req);
            p.setString(1, "TN" + id);
            p.setString(2, uti.getStatutSocial());
            p.setString(3, uti.getAdresse());
            FileInputStream is = null;
            try {
                is = new FileInputStream(new File(uti.getPhoto().getAbsolutePath()));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            p.setBlob(4, is);
            p.setInt(5, id);
            p.executeUpdate();
            GestionEn add = new GestionEn();
            add.setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int findUtiByNomPrenomDateNaiss(String nom, String prenom, Date dateNaissance) {

        String requete = " select * from utilisateur where (nom like ?) and (prenom like ?) and (date_naissance like ? )  limit 1  ";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setDate(3, new java.sql.Date(dateNaissance.getTime()));
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                return resultat.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des demandes " + ex.getMessage());

        }
        return -1;
    }

    @Override
    public Utilisateur findUtilisateurById(int id) {
        String requete = " SELECT * FROM utilisateur WHERE id_uti = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.setMaxRows(1);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Utilisateur Utilisateur = new Utilisateur();
                Utilisateur.setNom(resultat.getString(3));
                Utilisateur.setPrenom(resultat.getString(4));
                Utilisateur.setDateNaissance(resultat.getDate(6));
                Utilisateur.setLieuNaissance(resultat.getString(7));
                Utilisateur.setNomPere(resultat.getString(9));
                Utilisateur.setPrenomPere(resultat.getString(10));
                Utilisateur.setNomMere(resultat.getString(11));
                Utilisateur.setPrenomMere(resultat.getString(12));
                Utilisateur.setSexe(resultat.getString(13));

                return Utilisateur;
            }
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement " + ex.getMessage());

        }
        return null;
    }

    @Override
    public List<Utilisateur> ListerDemandesCin() {
        List<Utilisateur> demandesCin = new ArrayList<>();
        String requete = " SELECT * FROM utilisateur WHERE validation=3";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            IUtilisateurDao utilisateurDAO = new UtilisateurDao();
            while (resultat.next()) {
                Utilisateur Utilisateur = new Utilisateur();
                Utilisateur.setIduti(resultat.getInt(1));
                Utilisateur.setNom(resultat.getString(3));
                Utilisateur.setPrenom(resultat.getString(4));
                Utilisateur.setDateNaissance(resultat.getDate(6));
                Utilisateur.setLieuNaissance(resultat.getString(7));
                Utilisateur.setNomPere(resultat.getString(9));
                Utilisateur.setPrenomPere(resultat.getString(10));
                Utilisateur.setNomMere(resultat.getString(11));
                Utilisateur.setPrenomMere(resultat.getString(12));
                Utilisateur.setSexe(resultat.getString(13));
                Utilisateur.setAdresse(resultat.getString(14));
                Utilisateur.setProfession(resultat.getString(17));
                Utilisateur.setStatutSocial(resultat.getString(8));
                Blob blob = resultat.getBlob(16);
                File photo = null;
                Utilisateur.setPhoto(photo);

                demandesCin.add(Utilisateur);
            }
            return demandesCin;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des demandes " + ex.getMessage());
           
        }
         return null;
    }

    @Override
    public Image findUtiPhotoByid(int id) {
       String requete = " select * from utilisateur where (id_uti like ?)  ";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                 byte[] img = resultat.getBytes(16);
                 ImageIcon photo= new ImageIcon(img);
                 Image im=photo.getImage();
                 return im;
            }
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement de la photo " + ex.getMessage());

        }
        return null;
    }

    @Override
    public void accepterDemandeCin(int id) {
        try {
            String req = "UPDATE Utilisateur SET validation = 4, date_delivrence_cin = ? WHERE id_uti=?";
            PreparedStatement ps = connection.prepareStatement(req);
            java.sql.Timestamp date_curr = new java.sql.Timestamp(new java.util.Date().getTime());
            ps.setTimestamp(1, date_curr);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void RefuserDemandeCin(int id) {
       try {
            String req = "UPDATE Utilisateur SET validation = 5 WHERE id_uti=?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Utilisateur> findAllCin() {
         List<Utilisateur> demandesCin = new ArrayList<>();
        String requete = " SELECT * FROM utilisateur WHERE validation >= 4 ";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                Utilisateur Utilisateur = new Utilisateur();
                Utilisateur.setIduti(resultat.getInt(1));
                Utilisateur.setNumCin(resultat.getString(2));
                Utilisateur.setNom(resultat.getString(3));
                Utilisateur.setPrenom(resultat.getString(4));
                Utilisateur.setDateNaissance(resultat.getDate(6));
                Utilisateur.setLieuNaissance(resultat.getString(7));
                Utilisateur.setNomPere(resultat.getString(9));
                Utilisateur.setPrenomPere(resultat.getString(10));
                Utilisateur.setNomMere(resultat.getString(11));
                Utilisateur.setPrenomMere(resultat.getString(12));
                Utilisateur.setSexe(resultat.getString(13));                
                Utilisateur.setAdresse(resultat.getString(14));
                Utilisateur.setProfession(resultat.getString(17));
                Utilisateur.setStatutSocial(resultat.getString(8));
                Utilisateur.setDateDelivrenceCin(resultat.getDate(15));
                demandesCin.add(Utilisateur);
            }
            return demandesCin;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des demandes " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Utilisateur> findUtilisateurByCIN(String cin) {
        List<Utilisateur> Cin = new ArrayList<>();
     String requete = " select * from utilisateur where (num_cin like ?)  ";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, cin);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
              Utilisateur Utilisateur = new Utilisateur();
                Utilisateur.setIduti(resultat.getInt(1));
                Utilisateur.setNom(resultat.getString(3));
                Utilisateur.setPrenom(resultat.getString(4));
                Utilisateur.setDateNaissance(resultat.getDate(6));
                Utilisateur.setLieuNaissance(resultat.getString(7));
                Utilisateur.setNomPere(resultat.getString(9));
                Utilisateur.setPrenomPere(resultat.getString(10));
                Utilisateur.setNomMere(resultat.getString(11));
                Utilisateur.setPrenomMere(resultat.getString(12));
                Utilisateur.setSexe(resultat.getString(13));                
                Utilisateur.setAdresse(resultat.getString(14));
                Utilisateur.setProfession(resultat.getString(17));
                Utilisateur.setStatutSocial(resultat.getString(8));
                Utilisateur.setDateDelivrenceCin(resultat.getDate(15));
                Cin.add(Utilisateur);
            }
            return Cin;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement  " + ex.getMessage());

        }
        return null;  
    }

    @Override
    public Utilisateur findUtiByCIN(String cin) {
         String requete = "select * from utilisateur where num_cin=?";

        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1,cin);
            ResultSet resultat = ps.executeQuery();
            Utilisateur Utilisateur = new Utilisateur();
            while (resultat.next()) {                
                Utilisateur.setIduti(resultat.getInt(1));
                Utilisateur.setNumCin(resultat.getString(2));
                Utilisateur.setNom(resultat.getString(3));
                Utilisateur.setPrenom(resultat.getString(4));
                Utilisateur.setDateNaissance(resultat.getDate(6));
                Utilisateur.setLieuNaissance(resultat.getString(7));
                Utilisateur.setStatutSocial(resultat.getString(8));
                Utilisateur.setNomPere(resultat.getString(9));
                Utilisateur.setPrenomPere(resultat.getString(10));
                Utilisateur.setNomMere(resultat.getString(11));
                Utilisateur.setPrenomMere(resultat.getString(12));
                Utilisateur.setSexe(resultat.getString(13));                
                Utilisateur.setAdresse(resultat.getString(14));
                Utilisateur.setDateDelivrenceCin(resultat.getDate(15));
                Utilisateur.setProfession(resultat.getString(17));
            }
            return Utilisateur;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }
    }

    
   

    @Override
    public int StatSexe(String sexe) {
         try {
            String req="SELECT COUNT(*) FROM utilisateur WHERE (sexe like ?)";
            PreparedStatement ps=connection.prepareStatement(req);
            ps.setString(1,sexe);
            ResultSet resultat=ps.executeQuery();
            while (resultat.next()) {
                return resultat.getInt(1);
                    
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return 0;
    }
     public void addAttestaionResidence(Utilisateur uti) {
       

        try {
            String req = "insert into utilisateur (nom,prenom,date_naissance,lieu_naissance,nom_pere,prenom_pere,nom_mere,prenom_mere,sexe,validation) values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, uti.getNom());
            ps.setString(2, uti.getPrenom());
           // ps.setDate(3, new java.sql.Date(uti.getDateNaissance().getTime()));
             ps.setDate(3,  new java.sql.Date( uti.getDateNaissance().getTime()));
            ps.setString(4, uti.getLieuNaissance());
            ps.setString(5, uti.getNomPere());
            ps.setString(6, uti.getPrenomPere());
            ps.setString(7, uti.getNomMere());
            ps.setString(8, uti.getPrenomMere());
            ps.setString(9, uti.getSexe());
            ps.setInt(10, 1);
            ps.executeUpdate();
            GestionAttestationDeResidence add = new GestionAttestationDeResidence();
            add.setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    

    @Override
       public Utilisateur getByIduti(int id_uti) {
       
        Utilisateur uti = new Utilisateur();
        String requete = "select * from utilisateur where id_uti=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id_uti);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
               ps.setString(1, uti.getNom());
            ps.setString(2, uti.getPrenom());
           // ps.setDate(3, new java.sql.Date(uti.getDateNaissance().getTime()));
             ps.setDate(3,  new java.sql.Date( uti.getDateNaissance().getTime()));
            ps.setString(4, uti.getLieuNaissance());
            ps.setString(5, uti.getNomPere());
            ps.setString(6, uti.getPrenomPere());
            ps.setString(7, uti.getNomMere());
            ps.setString(8, uti.getPrenomMere());
            ps.setString(9, uti.getSexe());
            
            }
            return uti;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    
    }

       
       
        
    @Override
       public Utilisateur getById_uti(int id) {
       
        Utilisateur uti = new Utilisateur();
        String requete = "select nom,prenom,lieu_naissance,nom_pere,prenom_pere,nom_mere,prenom_mere,sexe from utilisateur where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                   ps.setString(1, uti.getNom());
            ps.setString(2, uti.getPrenom());
           // ps.setDate(3, new java.sql.Date(uti.getDateNaissance().getTime()));
            // ps.setDate(3,  new java.sql.Date( uti.getDateNaissance().getTime()));
            ps.setString(4, uti.getLieuNaissance());
            ps.setString(5, uti.getNomPere());
            ps.setString(6, uti.getPrenomPere());
            ps.setString(7, uti.getNomMere());
            ps.setString(8, uti.getPrenomMere());
            ps.setString(9, uti.getSexe());
            
            

            }
            return uti;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    
    }
       
       
       
       
       
       
       
       
    @Override
    public Utilisateur showAttestationResidence(Date dateNaissance, String nom, String prenom) {
        String requete = "select * from utilisateur where nom=? AND prenom=? AND date_naissance=?";

        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setDate(3, (java.sql.Date) dateNaissance);
            ResultSet resultat = ps.executeQuery();
            //IDepotDao depotDao = new DepotDao();
            Utilisateur uti = new Utilisateur();
            while (resultat.next()) {

                uti.setNom(resultat.getString(1));
            }
            return uti;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }
       
    }
}
