/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.entities;

/**
 *
 * @author mouad
 */
public class Entreprise {
        private int code_fiscal;
    private String adresse;
    private String nom;
    private String email;
    private String pwd_entreprise;

    public Entreprise() {
    }

    public Entreprise(int code_fiscal, String adresse, String nom, String email, String pwd_entreprise) {
        this.code_fiscal = code_fiscal;
        this.adresse = adresse;
        this.nom = nom;
        this.email = email;
        this.pwd_entreprise = pwd_entreprise;
    }

    public int getCode_fiscal() {
        return code_fiscal;
    }

    public void setCode_fiscal(int code_fiscal) {
        this.code_fiscal = code_fiscal;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd_entreprise() {
        return pwd_entreprise;
    }

    public void setPwd_entreprise(String pwd_entreprise) {
        this.pwd_entreprise = pwd_entreprise;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Entreprise other = (Entreprise) obj;
        if (this.code_fiscal != other.code_fiscal) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entreprise{" + "code_fiscal=" + code_fiscal + ", adresse=" + adresse + ", nom=" + nom + ", email=" + email + ", pwd_entreprise=" + pwd_entreprise + '}';
    }

}
