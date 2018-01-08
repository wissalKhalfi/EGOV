/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.dao.interfaces;

import esprit.egov.entities.ContratMariage;
import java.util.List;

/**
 *
 * @author boumaiza
 */
public interface IContratMariageDao {
    public List<ContratMariage> select();
     
      public ContratMariage getBynumCinUtilisateur(int id_contrat);
      public List<ContratMariage> DisplayAllContratMariage();
      public void deleteContratMariage(int id_contrat);
      public void addContratMariage(ContratMariage contratMariage);
      public void updateContratMariage(ContratMariage b);
      //public int StatCategorie(String categorie);
    
}
