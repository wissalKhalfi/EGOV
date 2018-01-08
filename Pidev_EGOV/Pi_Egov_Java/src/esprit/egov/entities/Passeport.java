/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.entities;

import java.sql.Date;



/**
 *
 * @author boumaiza
 */
public class Passeport {
    private int numPasseport;
    private Date dateDelivrance;
    private Date dateValidite;
    private String couleurYeux;
    private String validation;
    private int numCinUtilisateur;

    public Passeport() {
    }

    public Passeport(int numPasseport, Date dateDelivrance, Date dateValidite, String couleurYeux, String validation, int numCinUtilisateur) {
        this.numPasseport = numPasseport;
        this.dateDelivrance = dateDelivrance;
        this.dateValidite = dateValidite;
        this.couleurYeux = couleurYeux;
        this.validation = validation;
        this.numCinUtilisateur = numCinUtilisateur;
    }

    public Passeport(Date dateDelivrance, Date dateValidite, String couleurYeux, String validation, int numCinUtilisateur) {
        this.dateDelivrance = dateDelivrance;
        this.dateValidite = dateValidite;
        this.couleurYeux = couleurYeux;
        this.validation = validation;
        this.numCinUtilisateur = numCinUtilisateur;
    }

    public int getNumPasseport() {
        return numPasseport;
    }

    public void setNumPasseport(int numPasseport) {
        this.numPasseport = numPasseport;
    }

    public Date getDateDelivrance() {
        return dateDelivrance;
    }

    public void setDateDelivrance(Date dateDelivrance) {
        this.dateDelivrance = dateDelivrance;
    }

    public Date getDateValidite() {
        return dateValidite;
    }

    public void setDateValidite(Date dateValidite) {
        this.dateValidite = dateValidite;
    }

    public String getCouleurYeux() {
        return couleurYeux;
    }

    public void setCouleurYeux(String couleurYeux) {
        this.couleurYeux = couleurYeux;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

    public int getNumCinUtilisateur() {
        return numCinUtilisateur;
    }

    public void setNumCinUtilisateur(int numCinUtilisateur) {
        this.numCinUtilisateur = numCinUtilisateur;
    }

    @Override
    public String toString() {
        return "Passeport{" + "numPasseport=" + numPasseport + ", dateDelivrance=" + dateDelivrance + ", dateValidite=" + dateValidite + ", couleurYeux=" + couleurYeux + ", validation=" + validation + ", numCinUtilisateur=" + numCinUtilisateur + '}';
    }
    
    
    
    
    
}
