/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.gui;

import esprit.egov.dao.classes.ContratMariageDao;
import java.util.ArrayList;
import java.util.List;
import esprit.egov.entities.ContratMariage;
import esprit.egov.entities.Passeport;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aya
 */
public class listeContratMariage extends AbstractTableModel  {
    
    
     List<ContratMariage> contratMariage = new ArrayList<ContratMariage>();
     String [] colunmTab= {"id_contrat","date_mariage","id_epoux","id_epouse","Validation"};  
    public listeContratMariage() {

    ContratMariageDao contratMariageDAO=new ContratMariageDao();
    
    contratMariage=contratMariageDAO.DisplayAllContratMariage();
    
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

    




    
}
