/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.gui;

import esprit.egov.dao.classes.ContratMariageDao;
import esprit.egov.dao.classes.PasseportDao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import esprit.egov.entities.Permis;
import esprit.egov.dao.classes.PermisDao;
import esprit.egov.entities.ContratMariage;
import esprit.egov.entities.Passeport;

/**
 *
 * @author Aya
 */
public class listeContratMariageRechercher extends AbstractTableModel{
      
    List<ContratMariage> contratMariage = new ArrayList<ContratMariage>();
     String [] colunmTab= {"id_contrat","date_mariage","id_epoux","id_epouse","Validation"};  
    public listeContratMariageRechercher(int num) {
   
    ContratMariageDao contratMariageDAO=new ContratMariageDao();
   // Permis.add(permisDAO.getBynumCinUtilisateur(num));
    contratMariage.add(contratMariageDAO.getBynumCinUtilisateur(num));
   
    
    }
       @Override
    public int getRowCount() {
       return contratMariage.size();    }

    @Override
    public int getColumnCount() {
      return  colunmTab.length;
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
    
}
    


    
   

    
    

    

