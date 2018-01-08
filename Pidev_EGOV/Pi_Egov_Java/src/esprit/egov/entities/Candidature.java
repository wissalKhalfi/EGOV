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
public class Candidature {
        private int id_candidature;
        private Integer entreprise;
        private String utilisateur;
        private String etat;
        private String CV;

    public Candidature() {
    }

    public Candidature(int id_candidature, Integer entreprise, String utilisateur, String etat, String CV) {
        this.id_candidature = id_candidature;
        this.entreprise = entreprise;
        this.utilisateur = utilisateur;
        this.etat = etat;
        this.CV = CV;
    }

   

    public void setCV(String CV) {
        this.CV = CV;
    }

    public String getCV() {
        return CV;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id_candidature;
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
        final Candidature other = (Candidature) obj;
        if (this.id_candidature != other.id_candidature) {
            return false;
        }
        return true;
    }

    public int getId_candidature() {
        return id_candidature;
    }

    public void setId_candidature(int id_candidature) {
        this.id_candidature = id_candidature;
    }

    public Integer getEntreprise() {
        return entreprise;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setEntreprise(Integer entreprise) {
        this.entreprise = entreprise;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    } 

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

   

    @Override
    public String toString() {
        return "Candidature{" + "id_candidature=" + id_candidature + ", entreprise=" + entreprise + ", utilisateur=" + utilisateur + ", etat=" + etat + '}';
    }
        
}
