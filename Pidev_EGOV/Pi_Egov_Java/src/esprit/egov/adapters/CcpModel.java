/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.adapters;


import esprit.egov.dao.classes.CcpDao;
import esprit.egov.entities.Ccp;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class CcpModel extends AbstractTableModel {


    String[] elements = {"num_comptes", "code_comptes", "solde actuel", "Date Création"};
    Vector<Ccp> comptes;
    Vector<Ccp> rows;

    public CcpModel() {
        comptes = new Vector<Ccp>();
        rows = new Vector<Ccp>();
        CcpDao cd = new CcpDao();
        comptes = cd.findAll();
        for (Ccp d : comptes) {
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
                return rows.get(rowIndex).getNum_ccp();
            case 1:
                return rows.get(rowIndex).getCode_ccp();
            case 2:
                return rows.get(rowIndex).getSolde_actuel();
            case 3:
                return rows.get(rowIndex).getDate_creation();
            default:
                return null;
        }
    }

}

    

