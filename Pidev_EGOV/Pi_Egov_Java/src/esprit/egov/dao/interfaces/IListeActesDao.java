/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.dao.interfaces;

import esprit.egov.entities.ListeActes;
import java.util.List;

/**
 *
 * @author macbookpro
 */
public interface IListeActesDao {
    
    
    List<ListeActes> ListerActesParCitoyen();
    
    List<ListeActes> TrouverActesParCitoyen(String numCin);
    
    List<ListeActes> TrouverCondamnesParActe(int idActe);
    
    List<ListeActes> TrouverActeCitoyen(String numCin,int idActe);
    
}
