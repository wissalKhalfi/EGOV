/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.gui;

import esprit.egov.dao.classes.ContratMariageDao;
import esprit.egov.dao.classes.PermisDao;
import esprit.egov.entities.ContratMariage;
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
public class listeContratMariageAdmin extends AbstractTableModel{
    
    private List <ContratMariage> contratMariage=new ArrayList <ContratMariage>();
    ContratMariageDao edao=null ;

    String [] colunmTab= {"id_contrat","date_mariage","id_epoux","id_epouse","Validation"};  
    private Object getContratMariage;
    
public listeContratMariageAdmin() {
     contratMariage = new ContratMariageDao().select();
     
    }

    
    

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
           case 0:
                return contratMariage.get(rowIndex).getId_contrat();
            case 1:
                return contratMariage.get(rowIndex).getDate_mariage();
            case 2:
                return "" + contratMariage.get(rowIndex).getId_epoux();
            case 3:
                return  contratMariage.get(rowIndex).getId_epouse();
                case 4:
                return  contratMariage.get(rowIndex).getValidation();
                
            default:
                return null;
        }
    }

    public String[] getData() {
        return colunmTab;
    }
    
    

     public static void SupprimerContratMariage(int c){
           List<ContratMariage> contratMariage1 = new ArrayList<ContratMariage>();
           ContratMariageDao contratMariageDao = new  ContratMariageDao();
           
            contratMariage1= contratMariageDao.select();
           contratMariageDao.deleteContratMariage(contratMariage1.get(c).getId_contrat());
           
}

    @Override
    public int getRowCount() {
       
      return contratMariage.size();
    }

    @Override
    public int getColumnCount() {
       return colunmTab.length;
    }
     
     
}

