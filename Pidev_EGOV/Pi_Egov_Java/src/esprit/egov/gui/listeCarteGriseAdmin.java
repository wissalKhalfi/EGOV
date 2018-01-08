/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.gui;

import esprit.egov.dao.classes.CarteGriseDao;
import esprit.egov.dao.classes.PermisDao;
import esprit.egov.entities.CarteGrise;
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
public class listeCarteGriseAdmin extends AbstractTableModel{
    
    
   
    
    private List <CarteGrise> carteGrise=new ArrayList <CarteGrise>();
    CarteGriseDao edao=null ;
    String [] colunmTab= {"id_carte_grise","marque_vehicule","num_serie_vehicule","type_vehicule","date_achat_vehicule","couleur_vehicue","num_cinUtilisateur","validation"};  
    private Object getCarteGrise;
    
    
public listeCarteGriseAdmin() {
     carteGrise = new CarteGriseDao().select();
    }

    @Override
    public int getRowCount() {

        return carteGrise.size();    }

    @Override
    public int getColumnCount() {
      return  colunmTab.length;
    }
    

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
             case 0:
                return carteGrise.get(rowIndex).getId_carte_grise();
            case 1:
                return carteGrise.get(rowIndex).getMarque_vehicule();
            case 2:
                return carteGrise.get(rowIndex).getNum_serie_vehicule();
            case 3:
                return "" + carteGrise.get(rowIndex).getType_vehicule();
            case 4:
                return  carteGrise.get(rowIndex).getDate_achat_vehicule();
                
            case 5:
                return  carteGrise.get(rowIndex).getCouleur_vehicule();
            case 6:
                return  carteGrise.get(rowIndex).getNum_cinUtilisateur();
                
            case 7:
                return  carteGrise.get(rowIndex).getValidation();
                
            default:
                return null;
        }
    }

    public String[] getData() {
        return colunmTab;
    }
    
    

     public static void SupprimerCarteGrise(int c){
           List<CarteGrise> carteGrise = new ArrayList<CarteGrise>();
           CarteGriseDao cateGriseDao = new  CarteGriseDao();
           
            carteGrise= cateGriseDao.select();
           cateGriseDao.deleteCarteGrise(carteGrise.get(c).getId_carte_grise());
           
}
     
     
}

