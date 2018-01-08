/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.gui;

import java.util.ArrayList;
import java.util.List;
import esprit.egov.dao.classes.PasseportDao;
import esprit.egov.entities.Passeport;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aya
 */
public class listePasseport extends AbstractTableModel  {
    
    
     List<Passeport> passeport = new ArrayList<Passeport>();
     String [] colunmTab= {"numPasseport","dateDelivrance","dateValidite","couleurYeux","Validation"};  
    public listePasseport() {

    PasseportDao passeportDAO=new PasseportDao();
    
    passeport=passeportDAO.DisplayAllPasseport();
    
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

    




    
}
