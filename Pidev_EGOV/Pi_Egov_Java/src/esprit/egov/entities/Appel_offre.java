/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.entities;

import java.util.Date;

/**
 *
 * @author mouad
 */
public class Appel_offre {
     private int id_appel;
    private String objet;
    private String etat;
    private String localisation;
    private String profil_demander;
    private Date date_dep;
    private Date date_fin;
    private Utilisateur citoyen;
    private Entreprise entreprise;

    public Appel_offre() {
    }

    public Appel_offre(int id_appel, String objet, String etat, String localisation, String profil_demander, Date date_dep, Date date_fin, Utilisateur citoyen, Entreprise entreprise) {
        this.id_appel = id_appel;
        this.objet = objet;
        this.etat = etat;
        this.localisation = localisation;
        this.profil_demander = profil_demander;
        this.date_dep = date_dep;
        this.date_fin = date_fin;
        this.citoyen = citoyen;
        this.entreprise = entreprise;
    }

    public int getId_appel() {
        return id_appel;
    }

    public void setId_appel(int id_appel) {
        this.id_appel = id_appel;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getProfil_demander() {
        return profil_demander;
    }

    public void setProfil_demander(String profil_demander) {
        this.profil_demander = profil_demander;
    }

    public Date getDate_dep() {
        return date_dep;
    }

    public void setDate_dep(Date date_dep) {
        this.date_dep = date_dep;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public Utilisateur getCitoyen() {
        return citoyen;
    }

    public void setCitoyen(Utilisateur citoyen) {
        this.citoyen = citoyen;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id_appel;
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
        final Appel_offre other = (Appel_offre) obj;
        if (this.id_appel != other.id_appel) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Appel_offre{" + "id_appel=" + id_appel + ", objet=" + objet + ", etat=" + etat + ", localisation=" + localisation + ", profil_demander=" + profil_demander + ", date_dep=" + date_dep + ", date_fin=" + date_fin + ", citoyen=" + citoyen + ", entreprise=" + entreprise + '}';
    }
    
}
