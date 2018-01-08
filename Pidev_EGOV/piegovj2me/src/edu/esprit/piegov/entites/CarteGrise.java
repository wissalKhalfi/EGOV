/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.piegov.entites;

import java.util.Date;

/**
 *
 * @author boumaiza
 */
public class CarteGrise {
   
    int id_carte_grise;
    String marque_vehicule;
    String num_serie_vehicule;
    String type_vehicule;
    Date date_achat_vehicule;
    String couleur_vehicue;
    String num_cinUtilisateur;
    String validation;
    
    

    public CarteGrise(int id_carte_grise, String marque_vehicule) {
        this.id_carte_grise = id_carte_grise;
        this.marque_vehicule = marque_vehicule;
    }

    public CarteGrise(String marque_vehicule, String validation) {
        this.marque_vehicule = marque_vehicule;
        this.validation = validation;
    }

    public CarteGrise(int id_carte_grise, String marque_vehicule, String num_serie_vehicule, String type_vehicule, Date date_achat_vehicule, String couleur_vehicue, String num_cinUtilisateur, String validation) {
        this.id_carte_grise = id_carte_grise;
        this.marque_vehicule = marque_vehicule;
        this.num_serie_vehicule = num_serie_vehicule;
        this.type_vehicule = type_vehicule;
        this.date_achat_vehicule = date_achat_vehicule;
        this.couleur_vehicue = couleur_vehicue;
        this.num_cinUtilisateur = num_cinUtilisateur;
        this.validation = validation;
    }

    public CarteGrise(int id_carte_grise, String marque_vehicule, String num_serie_vehicule, String type_vehicule, String couleur_vehicue, String validation) {
        this.id_carte_grise = id_carte_grise;
        this.marque_vehicule = marque_vehicule;
        this.num_serie_vehicule = num_serie_vehicule;
        this.type_vehicule = type_vehicule;
        this.couleur_vehicue = couleur_vehicue;
        this.validation = validation;
    }

 
    
   
    public CarteGrise() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_carte_grise() {
        return id_carte_grise;
    }

    public void setId_carte_grise(int id_carte_grise) {
        this.id_carte_grise = id_carte_grise;
    }

    public String getMarque_vehicule() {
        return marque_vehicule;
    }

    public void setMarque_vehicule(String marque_vehicule) {
        this.marque_vehicule = marque_vehicule;
    }

    public String getNum_serie_vehicule() {
        return num_serie_vehicule;
    }

    public void setNum_serie_vehicule(String num_serie_vehicule) {
        this.num_serie_vehicule = num_serie_vehicule;
    }

    public String getType_vehicule() {
        return type_vehicule;
    }

    public void setType_vehicule(String type_vehicule) {
        this.type_vehicule = type_vehicule;
    }

    public Date getDate_achat_vehicule() {
        return date_achat_vehicule;
    }

    public void setDate_achat_vehicule(Date date_achat_vehicule) {
        this.date_achat_vehicule = date_achat_vehicule;
    }

    public String getCouleur_vehicue() {
        return couleur_vehicue;
    }

    public void setCouleur_vehicue(String couleur_vehicue) {
        this.couleur_vehicue = couleur_vehicue;
    }

    public String getNum_cinUtilisateur() {
        return num_cinUtilisateur;
    }

    public void setNum_cinUtilisateur(String num_cinUtilisateur) {
        this.num_cinUtilisateur = num_cinUtilisateur;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

 
    
    
    
    
}
