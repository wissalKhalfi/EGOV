/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.gui;

import esprit.egov.dao.classes.PasseportDao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import esprit.egov.entities.Permis;
import esprit.egov.dao.classes.PermisDao;
import esprit.egov.entities.Passeport;

/**
 *
 * @author Aya
 */
public class listePasseportRechercher extends AbstractTableModel{
      
    List<Passeport> passeport = new ArrayList<Passeport>();
     String [] colunmTab= {"numPasseport","dateDelivrance","dateValidite","couleurYeux","Validation"};  
    public listePasseportRechercher(int num) {
   
    PasseportDao passeportDAO=new PasseportDao();
   // Permis.add(permisDAO.getBynumCinUtilisateur(num));
    passeport.add(passeportDAO.getBynumCinUtilisateur(num));
   
    
    }
       @Override
    public int getRowCount() {
       return passeport.size();    }

    @Override
    public int getColumnCount() {
      return  colunmTab.length;
    }
    

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return passeport.get(rowIndex).getNumPasseport();
            case 1:
                return passeport.get(rowIndex).getDateDelivrance();
            case 2:
                return "" + passeport.get(rowIndex).getDateValidite();
            case 3:
                return  passeport.get(rowIndex).getCouleurYeux();
                case 4:
                return  passeport.get(rowIndex).getValidation();
                
            default:
                return null;
        }
    }

    public String[] getData() {
        return colunmTab;
    }
    
}
    


    
   

    
    

    

