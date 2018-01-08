/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import esprit.egov.entities.Permis;
import esprit.egov.dao.classes.PermisDao;

/**
 *
 * @author Aya
 */
public class listePermisRechercher extends AbstractTableModel{
      
    List<Permis> permis = new ArrayList<Permis>();
     String [] colunmTab= {"numPermis","Date_creation_permis","Date_validite_permis","Categorie_permis","Validation"};  
    public listePermisRechercher(int num) {
   
    PermisDao permisDAO=new PermisDao();
   // Permis.add(permisDAO.getBynumCinUtilisateur(num));
    permis.add(permisDAO.getBynumCinUtilisateur(num));
   
    
    }
       @Override
    public int getRowCount() {
       return permis.size();    }

    @Override
    public int getColumnCount() {
      return  colunmTab.length;
    }
    

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return permis.get(rowIndex).getNumPermis();
            case 1:
                return permis.get(rowIndex).getDate_creation_permis();
            case 2:
                return "" + permis.get(rowIndex).getDate_validite_permis();
            case 3:
                return  permis.get(rowIndex).getCategorie_permis();
                case 4:
                return  permis.get(rowIndex).getValidation();
                
            default:
                return null;
        }
    }

    public String[] getData() {
        return colunmTab;
    }
    
}
    


    
   

    
    

    

