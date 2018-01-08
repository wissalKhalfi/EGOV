/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.entities;

import java.util.Objects;

/**
 *
 * @author macbookpro
 */
public class ListeActes {
  
    private int id;
    private ActesJuridiques acte;
    private Utilisateur citoyen;
    
    public ListeActes() {
    }

    public ListeActes(int id, ActesJuridiques acte, Utilisateur citoyen) {
        this.id = id;
        this.acte = acte;
        this.citoyen = citoyen;
    }

    public int getId() {
        return id;
    }

    public ActesJuridiques getActe() {
        return acte;
    }

    public Utilisateur getCitoyen() {
        return citoyen;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setActe(ActesJuridiques acte) {
        this.acte = acte;
    }

    public void setCitoyen(Utilisateur citoyen) {
        this.citoyen = citoyen;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.acte);
        hash = 67 * hash + Objects.hashCode(this.citoyen);
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
        final ListeActes other = (ListeActes) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.acte, other.acte)) {
            return false;
        }
        if (!Objects.equals(this.citoyen, other.citoyen)) {
            return false;
        }
        return true;
    }

    
    

}
