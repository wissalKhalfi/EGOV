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
public class Passeport {
    private int numPasseport;
    private String couleurYeux;
    private String validation;
    private Date dateDelivrance;
    private Date dateValidite;

    public Passeport(int numPasseport, String couleurYeux) {
        this.numPasseport = numPasseport;
        this.couleurYeux = couleurYeux;
    }

    public Passeport(String couleurYeux, String validation) {
        this.couleurYeux = couleurYeux;
        this.validation = validation;
    }

    public Passeport(String couleurYeux, String validation, Date dateDelivrance) {
        this.couleurYeux = couleurYeux;
        this.validation = validation;
        this.dateDelivrance = dateDelivrance;
    }
    
    
    
    public Passeport()
    {}

    public Passeport(int numPasseport, String couleurYeux, String validation, Date dateDelivrance, Date dateValidite) {
        this.numPasseport = numPasseport;
        this.couleurYeux = couleurYeux;
        this.validation = validation;
        this.dateDelivrance = dateDelivrance;
        this.dateValidite = dateValidite;
    }

    public Passeport(String couleurYeux, String validation, Date dateDelivrance, Date dateValidite) {
        this.couleurYeux = couleurYeux;
        this.validation = validation;
        this.dateDelivrance = dateDelivrance;
        this.dateValidite = dateValidite;
    }

    
    public int getNumPasseport() {
        return numPasseport;
    }

    public void setNumPasseport(int numPasseport) {
        this.numPasseport = numPasseport;
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
    
    
    
    
    
}
