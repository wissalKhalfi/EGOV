/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.gui;

import esprit.egov.dao.classes.PasseportDao;
import esprit.egov.dao.classes.PermisDao;
import esprit.egov.entities.Passeport;
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
public class listePasseportAdmin extends AbstractTableModel{
    
    private List <Passeport> passeport=new ArrayList <Passeport>();
    PasseportDao edao=null ;

    String [] colunmTab= {"numPasseport","dateDelivrance","dateValidite","couleurYeux","Validation"};  
    private Object getPasseport;
    
public listePasseportAdmin() {
     passeport = new PasseportDao().select();
     
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
    
    

     public static void SupprimerPasseport(int c){
           List<Passeport> passeport1 = new ArrayList<Passeport>();
           PasseportDao passeportDao = new  PasseportDao();
           
            passeport1= passeportDao.select();
           passeportDao.deletePasseport(passeport1.get(c).getNumPasseport());
           
}

    @Override
    public int getRowCount() {
       
      return passeport.size();
    }

    @Override
    public int getColumnCount() {
       return colunmTab.length;
    }
     
     
}

