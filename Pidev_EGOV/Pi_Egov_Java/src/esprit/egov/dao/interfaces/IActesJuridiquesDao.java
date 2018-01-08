/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.dao.interfaces;

import esprit.egov.entities.ActesJuridiques;
import java.util.List;

/**
 *
 * @author macbookpro
 */
public interface IActesJuridiquesDao {
    int addActeJuridique(ActesJuridiques acte);
    
    List<ActesJuridiques> ListerActes();
    
    ActesJuridiques FindActeById(int idActe);
    
    void CondamnerUti(int idActe, String NumCin);
    
}
