/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.dao.interfaces;

import esprit.egov.entities.Permis;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Aya
 */
public interface IPermisDao {
    
    //void addPermis(Permis permis);
      public List<Permis> select();
     
      public Permis getBynumCinUtilisateur(int numCinUtilisateur);
      public List<Permis> DisplayAllPermis();
      public void deletePermis(int numPermis);
      public void addPermis(Permis permis);
      public void updatePermis(Permis b);
      public int StatCategorie(String categorie);
      
    
      
    
}
