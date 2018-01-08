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
public class Permis {
   
    int numPermis;
    Date date_creation_permis;
    String categorie_permis;
    Date date_validite_permis;
    int numCinUtilisateur;
    String validation;

    public Permis(int numPermis, String categorie_permis) {
        this.numPermis = numPermis;
        this.categorie_permis = categorie_permis;
    }

    public Permis(String categorie_permis, String validation) {
        this.categorie_permis = categorie_permis;
        this.validation = validation;
    }

    public Permis(int numPermis, Date date_creation_permis, String categorie_permis, Date date_validite_permis, int numCinUtilisateur, String validation) {
        this.numPermis = numPermis;
        this.date_creation_permis = date_creation_permis;
        this.categorie_permis = categorie_permis;
        this.date_validite_permis = date_validite_permis;
        this.numCinUtilisateur = numCinUtilisateur;
        this.validation = validation;
    }
    
   
    public Permis() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

    public int getNumPermis() {
        return numPermis;
    }

    public void setNumPermis(int numPermis) {
        this.numPermis = numPermis;
    }

    public Date getDate_creation_permis() {
        return date_creation_permis;
    }

    public void setDate_creation_permis(Date date_creation_permis) {
        this.date_creation_permis = date_creation_permis;
    }

    public String getCategorie_permis() {
        return categorie_permis;
    }

    public void setCategorie_permis(String categorie_permis) {
        this.categorie_permis = categorie_permis;
    }

    public Date getDate_validite_permis() {
        return date_validite_permis;
    }

    public void setDate_validite_permis(Date date_validite_permis) {
        this.date_validite_permis = date_validite_permis;
    }

    public int getNumCinUtilisateur() {
        return numCinUtilisateur;
    }

    public void setNumCinUtilisateur(int numCinUtilisateur) {
        this.numCinUtilisateur = numCinUtilisateur;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }



   
    
    
    
    
    
}
