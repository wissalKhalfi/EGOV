/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.entities;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.Date;
//import java.sql.Date;
/**
 *
 * @author Aya
 */
public class Permis {

    
    
    private int numPermis;
    private Date date_creation_permis;
    private String categorie_permis;
    private Date date_validite_permis;
    private String numCinUtilisateur; 
    private String validation ;

    public Permis(int numPermis, Date date_creation_permis, String categorie_permis, Date date_validite_permis, String numCin, String validation) {
        this.numPermis = numPermis;
        this.date_creation_permis = date_creation_permis;
        this.categorie_permis = categorie_permis;
        this.date_validite_permis = date_validite_permis;
        this.numCinUtilisateur = numCinUtilisateur;
        this.validation = validation;
    }

    public Permis() {
       
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

    public String getNumCinUtilisateur() {
        return numCinUtilisateur;
    }

    public void setNumCinUtilisateur(String numCinUtilisateur) {
        this.numCinUtilisateur = numCinUtilisateur;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

  

    

}
