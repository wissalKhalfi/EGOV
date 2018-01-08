/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.adapters;

import esprit.egov.dao.classes.CarteEdinarDao;
import esprit.egov.entities.CarteEdinar;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class CarteEdinarModel extends AbstractTableModel {

    String[] elements = {"num_cartes", "code_cartes", "solde actuel", "Date Création"};
    Vector<CarteEdinar> cartes;
    Vector<CarteEdinar> rows;

    public CarteEdinarModel() {
        cartes = new Vector<CarteEdinar>();
        rows = new Vector<CarteEdinar>();
        CarteEdinarDao cd = new CarteEdinarDao();
        cartes = cd.findAll();
        for (CarteEdinar d : cartes) {
            rows.add(d);

        }
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return elements.length;
    }

    public String getColumnName(int i) {
        return elements[i];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rows.get(rowIndex).getNum_carte();
            case 1:
                return rows.get(rowIndex).getCode_carte();
            case 2:
                return rows.get(rowIndex).getSolde_actuel();
            case 3:
                return rows.get(rowIndex).getDate_creation();
            default:
                return null;
        }
    }

}
