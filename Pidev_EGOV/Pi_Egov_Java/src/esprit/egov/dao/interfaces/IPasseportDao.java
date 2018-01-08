/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.dao.interfaces;


import esprit.egov.entities.Passeport;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author boumaiza
 */
public interface IPasseportDao {
     public List<Passeport> select();
     
      public Passeport getBynumCinUtilisateur(int numCinUtilisateur);
      public List<Passeport> DisplayAllPasseport();
      public void deletePasseport(int numPasseport);
      public void addPasseport(Passeport passeport);
      public void updatePasseport(Passeport b);
      public int StatCategorie(String categorie);
    
}
