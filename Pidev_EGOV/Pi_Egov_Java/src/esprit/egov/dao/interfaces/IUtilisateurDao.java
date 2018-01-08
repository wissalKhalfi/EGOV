/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.dao.interfaces;

import esprit.egov.entities.ActesJuridiques;
import esprit.egov.entities.ListeActes;
import esprit.egov.entities.Utilisateur;
import java.awt.Image;
import java.util.Date;
import java.util.List;
import java.util.*;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author macbookpro
 */
public interface IUtilisateurDao {

    String SeConnecter(String login, String password);

    void addExtraitNaissance(Utilisateur utilisateur);

    void updateExtraitNaissance(Utilisateur utilisateur);

    Utilisateur showExtraitNaissance(Date dateNaissance, String nom, String prenom);

    Utilisateur showExtraitNaissance(int id);

    List<Utilisateur> findAll();

    List<Utilisateur> findAllEN();

    List<Utilisateur> ListerDemandesEN();

    Utilisateur findUtilisateurByDateNaiss(Date dateNaissance);

    List<Utilisateur> findUtilisateurByNom(String n);

    Utilisateur findUtilisateurByAdresse(String adresse);

    Utilisateur findUtilisateurById(int id);

    List<Utilisateur> findUtilisateurByNomPrenomDateNaiss(String nom, String prenom, Date dateNaissance);

    int findUtiByNomPrenomDateNaiss(String nom, String prenom, Date dateNaissance);

    void accepterDemandeEN(int id);

    void RefuserDemandeEN(int id);

    void addCin(Utilisateur utilisateur);

    List<Utilisateur> ListerDemandesCin();

    Image findUtiPhotoByid(int id);

    void accepterDemandeCin(int id);

    void RefuserDemandeCin(int id);

    List<Utilisateur> findAllCin();

    List<Utilisateur> findUtilisateurByCIN(String cin);

    Utilisateur findUtiByCIN(String cin);

    int StatSexe(String sexe);

    public Utilisateur getByIduti(int id_uti);

    public Utilisateur showAttestationResidence(Date dateNaissance, String nom, String prenom);

    public void addAttestaionResidence(Utilisateur uti);

    public Utilisateur getById_uti(int id);
}
