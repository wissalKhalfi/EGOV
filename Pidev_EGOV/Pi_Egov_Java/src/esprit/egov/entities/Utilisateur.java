/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.entities;

import java.io.File;
import java.util.Date;

/**
 *
 * @author macbookpro
 */
public class Utilisateur {
     private int iduti;
    private String numCin;
    private String nom;
    private String prenom;
    private String type;
    private Date dateNaissance;
    private String lieuNaissance;
    private String statutSocial;
    private String nomPere;
    private String prenomPere;
    private String nomMere;
    private String prenomMere;
    private String sexe;
    private String adresse;
    private Date dateDelivrenceCin;
    private File photo;
    private String profession;
    private File empreinte;
    private int codeEmpreinte;
    private int idAgent;
    private ListeActes listesActes;
    private int $ccp;
    //private $fosUserId;
    private int numPermis;
    private int carteGrise;
    private int numPasseport;
    private int csc;
    private int validation;

    public Utilisateur() {
    }

    public int getIduti() {
        return iduti;
    }

    public String getNumCin() {
        return numCin;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getType() {
        return type;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public String getStatutSocial() {
        return statutSocial;
    }

    public String getNomPere() {
        return nomPere;
    }

    public String getPrenomPere() {
        return prenomPere;
    }

    public String getNomMere() {
        return nomMere;
    }

    public String getPrenomMere() {
        return prenomMere;
    }

    public String getSexe() {
        return sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public Date getDateDelivrenceCin() {
        return dateDelivrenceCin;
    }

    public File getPhoto() {
        return photo;
    }

    public String getProfession() {
        return profession;
    }

    public File getEmpreinte() {
        return empreinte;
    }

    public int getCodeEmpreinte() {
        return codeEmpreinte;
    }

    public int getIdAgent() {
        return idAgent;
    }

    public ListeActes getListesActes() {
        return listesActes;
    }

    public int get$ccp() {
        return $ccp;
    }

    public int getNumPermis() {
        return numPermis;
    }

    public int getCarteGrise() {
        return carteGrise;
    }

    public int getNumPasseport() {
        return numPasseport;
    }

    public int getCsc() {
        return csc;
    }

    public int getValidation() {
        return validation;
    }

    public void setIduti(int iduti) {
        this.iduti = iduti;
    }

    public void setNumCin(String numCin) {
        this.numCin = numCin;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public void setStatutSocial(String statutSocial) {
        this.statutSocial = statutSocial;
    }

    public void setNomPere(String nomPere) {
        this.nomPere = nomPere;
    }

    public void setPrenomPere(String prenomPere) {
        this.prenomPere = prenomPere;
    }

    public void setNomMere(String nomMere) {
        this.nomMere = nomMere;
    }

    public void setPrenomMere(String prenomMere) {
        this.prenomMere = prenomMere;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setDateDelivrenceCin(Date dateDelivrenceCin) {
        this.dateDelivrenceCin = dateDelivrenceCin;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setEmpreinte(File empreinte) {
        this.empreinte = empreinte;
    }

    public void setCodeEmpreinte(int codeEmpreinte) {
        this.codeEmpreinte = codeEmpreinte;
    }

    public void setIdAgent(int idAgent) {
        this.idAgent = idAgent;
    }

    public void setListesActes(ListeActes listesActes) {
        this.listesActes = listesActes;
    }

    public void set$ccp(int $ccp) {
        this.$ccp = $ccp;
    }

    public void setNumPermis(int numPermis) {
        this.numPermis = numPermis;
    }

    public void setCarteGrise(int carteGrise) {
        this.carteGrise = carteGrise;
    }

    public void setNumPasseport(int numPasseport) {
        this.numPasseport = numPasseport;
    }

    public void setCsc(int csc) {
        this.csc = csc;
    }

    public void setValidation(int validation) {
        this.validation = validation;
    }

   
    
    
    
}
