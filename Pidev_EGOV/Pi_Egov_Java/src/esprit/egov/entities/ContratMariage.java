/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.entities;

import java.util.Date;


/**
 *
 * @author boumaiza
 */
public class ContratMariage {
    private Integer id_contrat;
    private Date date_mariage;
    private String id_epoux;
    private String id_epouse;
    private String validation;
    private Integer numCinUtilisateur;

    public ContratMariage() {
    }
    

    public ContratMariage(Integer id_contrat, Date date_mariage, String id_epoux, String id_epouse, String validation, Integer numCinUtilisateur) {
        this.id_contrat = id_contrat;
        this.date_mariage = date_mariage;
        this.id_epoux = id_epoux;
        this.id_epouse = id_epouse;
        this.validation = validation;
        this.numCinUtilisateur = numCinUtilisateur;
    }

    public ContratMariage(Date date_mariage, String id_epoux, String id_epouse, String validation, Integer numCinUtilisateur) {
        this.date_mariage = date_mariage;
        this.id_epoux = id_epoux;
        this.id_epouse = id_epouse;
        this.validation = validation;
        this.numCinUtilisateur = numCinUtilisateur;
    }

    public Integer getId_contrat() {
        return id_contrat;
    }

    public void setId_contrat(Integer id_contrat) {
        this.id_contrat = id_contrat;
    }

    public Date getDate_mariage() {
        return date_mariage;
    }

    public void setDate_mariage(Date date_mariage) {
        this.date_mariage = date_mariage;
    }

    public String getId_epoux() {
        return id_epoux;
    }

    public void setId_epoux(String id_epoux) {
        this.id_epoux = id_epoux;
    }

    public String getId_epouse() {
        return id_epouse;
    }

    public void setId_epouse(String id_epouse) {
        this.id_epouse = id_epouse;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

    public Integer getNumCinUtilisateur() {
        return numCinUtilisateur;
    }

    public void setNumCinUtilisateur(Integer numCinUtilisateur) {
        this.numCinUtilisateur = numCinUtilisateur;
    }
    
    
    
    
}
