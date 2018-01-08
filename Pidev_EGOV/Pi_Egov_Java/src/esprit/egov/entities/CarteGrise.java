/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.entities;

import java.util.Date;

/**
 *
 * @author Aya
 */
public class CarteGrise {
     private int id_carte_grise;
     private String marque_vehicule;
     private String num_serie_vehicule;
     private String type_vehicule;
     private Date date_achat_vehicule;
     private String couleur_vehicule;
     private int  num_cinUtilisateur;
     private String validation;
     
     
     
     
    public CarteGrise(int id_carte_grise,String marque_vehicule, String num_serie_vehicule, String type_vehicule, Date date_achat_vehicule, String couleur_vehicule, int  num_cinUtilisateur,String validation) {
        this.id_carte_grise = id_carte_grise;
        this.marque_vehicule = marque_vehicule;
        this.num_serie_vehicule = num_serie_vehicule;
         this.type_vehicule = type_vehicule;
        this.date_achat_vehicule = date_achat_vehicule;
        this.couleur_vehicule = couleur_vehicule;
        this.num_cinUtilisateur = num_cinUtilisateur;
        this.validation = validation;
    }
    

    public CarteGrise() {
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

    public String getCouleur_vehicule() {
        return couleur_vehicule;
    }

    public void setCouleur_vehicule(String couleur_vehicule) {
        this.couleur_vehicule = couleur_vehicule;
    }

    public int getNum_cinUtilisateur() {
        return num_cinUtilisateur;
    }

    public void setNum_cinUtilisateur(int num_cinUtilisateur) {
        this.num_cinUtilisateur = num_cinUtilisateur;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }
     
     
     
     
    
}
