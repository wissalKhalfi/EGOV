/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.gui;

import esprit.egov.dao.classes.CarteGriseDao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import esprit.egov.entities.Permis;
import esprit.egov.dao.classes.PermisDao;
import esprit.egov.entities.CarteGrise;

/**
 *
 * @author Aya
 */
public class listeCarteGriseRechercher extends AbstractTableModel{
      
    
    
     private List <CarteGrise> carteGrise=new ArrayList <CarteGrise>();
     String [] colunmTab= {"id_carte_grise","marque_vehicule","num_serie_vehicule","type_vehicule","date_achat_vehicule","couleur_vehicue","num_cinUtilisateur","validation"};  
    public listeCarteGriseRechercher(int id_carte_grise) {
   
        
    CarteGriseDao carteGriseDAO=new CarteGriseDao();
    // int id_carte_grise = 0;
   // Permis.add(permisDAO.getBynumCinUtilisateur(num));
    carteGrise.add(carteGriseDAO.getByIdCarteGrise(id_carte_grise));
   
    
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
    
}
    


    
   

    
    

    

