/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.gui;

import esprit.egov.dao.classes.PermisDao;
import esprit.egov.entities.Permis;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aya
 */
public class listePermisAdmin extends AbstractTableModel{
    
    private List <Permis> permis=new ArrayList <Permis>();
    PermisDAO edao=null ;
    String [] colunmTab= {"numPermis","Date_creation_permis","Date_validite_permis","Categorie_permis","Validation"};  
    private Object getPermis;
    
public listePermisAdmin() {
     permis = new PermisDao().select();
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
    
    

     public static void SupprimerPermis(int c){
           List<Permis> permis = new ArrayList<Permis>();
           PermisDao permisDao = new  PermisDao();
           
            permis= permisDao.select();
           permisDao.deletePermis(permis.get(c).getNumPermis());
           
}
     
     
}

