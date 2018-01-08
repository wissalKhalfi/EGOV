/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.entities;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author macbookpro
 */
public class ActesJuridiques {
   
    private int idActe;
    private String titreActe;
    private Date dateActe;
    private String descActe;

    public ActesJuridiques(String titreActe, Date dateActe, String descActe) {
        this.titreActe = titreActe;
        this.dateActe = dateActe;
        this.descActe = descActe;
    }

    public ActesJuridiques() {
    }

    public int getIdActe() {
        return idActe;
    }

    public String getTitreActe() {
        return titreActe;
    }

    public Date getDateActe() {
        return dateActe;
    }

    public String getDescActe() {
        return descActe;
    }

    public void setIdActe(int idActe) {
        this.idActe = idActe;
    }

    public ActesJuridiques(int idActe) {
        this.idActe = idActe;
    }

    public void setTitreActe(String titreActe) {
        this.titreActe = titreActe;
    }

    public void setDateActe(Date dateActe) {
        this.dateActe = dateActe;
    }

    public void setDescActe(String descActe) {
        this.descActe = descActe;
    }

    @Override
    public String toString() {
        return "ActesJuridiques{" + "idActe=" + idActe + ", titreActe=" + titreActe + ", dateActe=" + dateActe + ", descActe=" + descActe + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idActe;
        hash = 59 * hash + Objects.hashCode(this.titreActe);
        hash = 59 * hash + Objects.hashCode(this.dateActe);
        hash = 59 * hash + Objects.hashCode(this.descActe);
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
        final ActesJuridiques other = (ActesJuridiques) obj;
        if (this.idActe != other.idActe) {
            return false;
        }
        if (!Objects.equals(this.titreActe, other.titreActe)) {
            return false;
        }
        if (!Objects.equals(this.dateActe, other.dateActe)) {
            return false;
        }
        if (!Objects.equals(this.descActe, other.descActe)) {
            return false;
        }
        return true;
    }

  
}
