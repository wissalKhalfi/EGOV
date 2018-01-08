/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.adapters;

import esprit.egov.dao.interfaces.IArticlesDao;
import esprit.egov.dao.classes.ArticlesDao;
import esprit.egov.entities.Articles;
import esprit.egov.entities.CarteEdinar;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class ActualiteModel extends AbstractTableModel{

    String[] elements = {"id_article", "titre_article", "date_article", "type"};
    Vector<Articles> cartes;
    Vector<Articles> rows;

    public ActualiteModel() {
        cartes = new Vector<Articles>();
        rows = new Vector<Articles>();
       IArticlesDao a = new ArticlesDao(); 
        cartes = a.findAll();
        for (Articles d : cartes) {
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
                return rows.get(rowIndex).getId_article();
            case 1:
                return rows.get(rowIndex).getTitre_article();
            case 2:
                return rows.get(rowIndex).getDate_article();
            case 3:
                return rows.get(rowIndex).getType();
            default:
                return null;
        }
    }

}

    

