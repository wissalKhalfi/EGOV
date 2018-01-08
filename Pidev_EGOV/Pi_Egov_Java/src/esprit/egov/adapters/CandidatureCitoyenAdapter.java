/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.adapters;

import esprit.egov.dao.classes.CandidatureDao;
import esprit.egov.dao.interfaces.ICandidatureDao;
import esprit.egov.entities.Candidature;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mouadh
 */
public class CandidatureCitoyenAdapter extends AbstractTableModel {

    String[] headers = {"id_candidature", "etat", "entreprise"};
    List<Candidature> candidatures = new ArrayList<>();
    ICandidatureDao candidatureDao;

    public CandidatureCitoyenAdapter() {
        candidatureDao = new CandidatureDao();
        candidatures = candidatureDao.findAll();
    }

    @Override
    public int getRowCount() {
        return candidatures.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public String getColumnName(int i) {
        return headers[i];
    }

    @Override
    public Object getValueAt(int rowIndex, int colmunIndex) {
        switch (colmunIndex) {
            case 0:
                return candidatures.get(rowIndex).getId_candidature();
            case 1:
                return candidatures.get(rowIndex).getEtat();
            case 2:
                return candidatures.get(rowIndex).getEntreprise();
            default:
                return null;
        }
    }

}
