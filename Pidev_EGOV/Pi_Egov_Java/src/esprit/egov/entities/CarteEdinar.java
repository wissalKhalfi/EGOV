/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.entities;

import java.sql.Date;


/**
 *
 * @author USER
 */
public class CarteEdinar {
    private int num_carte;
    private int code_carte;
    private int solde_actuel;
    private Date date_dernier_retirement;
    private int dernier_retirement;
    private Date date_creation;
    private Date date_dernier_versement;
    private int dernier_versement;
    private int validator_creation;
    private int validator_recuperation;
    private int validator_changement;
    private int validator_renouvellement;
    private int validator_blockage;
    private int validator_deblockage;
    private String reponseq1;
    private String reponseq2;
    private String reponseq3;

    public CarteEdinar(int num_carte, int code_carte, int solde_actuel, Date date_dernier_retirement, int dernier_retirement, Date date_creation, Date date_dernier_versement, int dernier_versement, int validator_creation, int validator_recuperation, int validator_changement, int validator_renouvellement, int validator_blockage, int validator_deblockage, String reponseq1, String reponseq2, String reponseq3) {
        this.num_carte = num_carte;
        this.code_carte = code_carte;
        this.solde_actuel = solde_actuel;
        this.date_dernier_retirement = date_dernier_retirement;
        this.dernier_retirement = dernier_retirement;
        this.date_creation = date_creation;
        this.date_dernier_versement = date_dernier_versement;
        this.dernier_versement = dernier_versement;
        this.validator_creation = validator_creation;
        this.validator_recuperation = validator_recuperation;
        this.validator_changement = validator_changement;
        this.validator_renouvellement = validator_renouvellement;
        this.validator_blockage = validator_blockage;
        this.validator_deblockage = validator_deblockage;
        this.reponseq1 = reponseq1;
        this.reponseq2 = reponseq2;
        this.reponseq3 = reponseq3;
    }

    public CarteEdinar(int num_carte, int code_carte, int solde_actuel, Date date_creation, Date date_dernier_versement, int dernier_versement) {
        this.num_carte = num_carte;
        this.code_carte = code_carte;
        this.solde_actuel = solde_actuel;
        this.date_creation = date_creation;
        this.date_dernier_versement = date_dernier_versement;
        this.dernier_versement = dernier_versement;
    }

    public CarteEdinar() {
    }

    public int getNum_carte() {
        return num_carte;
    }

    public void setNum_carte(int num_carte) {
        this.num_carte = num_carte;
    }

    public int getCode_carte() {
        return code_carte;
    }

    public void setCode_carte(int code_carte) {
        this.code_carte = code_carte;
    }

    public int getSolde_actuel() {
        return solde_actuel;
    }

    public void setSolde_actuel(int solde_actuel) {
        this.solde_actuel = solde_actuel;
    }

    public Date getDate_dernier_retirement() {
        return date_dernier_retirement;
    }

    public void setDate_dernier_retirement(Date date_dernier_retirement) {
        this.date_dernier_retirement = date_dernier_retirement;
    }

    public int getDernier_retirement() {
        return dernier_retirement;
    }

    public void setDernier_retirement(int dernier_retirement) {
        this.dernier_retirement = dernier_retirement;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public Date getDate_dernier_versement() {
        return date_dernier_versement;
    }

    public void setDate_dernier_versement(Date date_dernier_versement) {
        this.date_dernier_versement = date_dernier_versement;
    }

    public int getDernier_versement() {
        return dernier_versement;
    }

    public void setDernier_versement(int dernier_versement) {
        this.dernier_versement = dernier_versement;
    }

    public int getValidator_creation() {
        return validator_creation;
    }

    public void setValidator_creation(int validator_creation) {
        this.validator_creation = validator_creation;
    }

    public int getValidator_recuperation() {
        return validator_recuperation;
    }

    public void setValidator_recuperation(int validator_recuperation) {
        this.validator_recuperation = validator_recuperation;
    }

    public int getValidator_changement() {
        return validator_changement;
    }

    public void setValidator_changement(int validator_changement) {
        this.validator_changement = validator_changement;
    }

    public int getValidator_renouvellement() {
        return validator_renouvellement;
    }

    public void setValidator_renouvellement(int validator_renouvellement) {
        this.validator_renouvellement = validator_renouvellement;
    }

    public int getValidator_blockage() {
        return validator_blockage;
    }

    public void setValidator_blockage(int validator_blockage) {
        this.validator_blockage = validator_blockage;
    }

    public int getValidator_deblockage() {
        return validator_deblockage;
    }

    public void setValidator_deblockage(int validator_deblockage) {
        this.validator_deblockage = validator_deblockage;
    }

    public String getReponseq1() {
        return reponseq1;
    }

    public void setReponseq1(String reponseq1) {
        this.reponseq1 = reponseq1;
    }

    public String getReponseq2() {
        return reponseq2;
    }

    public void setReponseq2(String reponseq2) {
        this.reponseq2 = reponseq2;
    }

    public String getReponseq3() {
        return reponseq3;
    }

    public void setReponseq3(String reponseq3) {
        this.reponseq3 = reponseq3;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.num_carte;
        hash = 71 * hash + this.code_carte;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CarteEdinar other = (CarteEdinar) obj;
        if (this.num_carte != other.num_carte) {
            return false;
        }
        if (this.code_carte != other.code_carte) {
            return false;
        }
        return true;
    }
    
    
}
