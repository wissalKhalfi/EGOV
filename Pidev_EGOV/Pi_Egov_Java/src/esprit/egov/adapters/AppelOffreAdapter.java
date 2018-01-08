/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.adapters;

import esprit.egov.dao.classes.Appel_offreDao;
import esprit.egov.dao.interfaces.IAppel_offreDao;
import esprit.egov.entities.Appel_offre;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mouadh
 */
public class AppelOffreAdapter extends AbstractTableModel {

    String[] headers = {"id_appel", "objet", "etat","date_deb","date_fin","localisation","profil_demande","entreprise"};
    List<Appel_offre> appelOffres = new ArrayList<>();
    IAppel_offreDao appel_offreDao;

    public AppelOffreAdapter() {
        appel_offreDao = new Appel_offreDao();
        appelOffres = appel_offreDao.findAll();
    }

    @Override
    public int getRowCount() {
        return appelOffres.size();
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
                return appelOffres.get(rowIndex).getId_appel();
            case 1:
                return appelOffres.get(rowIndex).getObjet();
            case 2:
                return appelOffres.get(rowIndex).getEtat();
            case 3:
                return appelOffres.get(rowIndex).getDate_dep();
            case 4:
                return appelOffres.get(rowIndex).getDate_fin();
            case 5:
                return appelOffres.get(rowIndex).getLocalisation();
            case 6:
                return appelOffres.get(rowIndex).getProfil_demander();
            case 7:
                return appelOffres.get(rowIndex).getEntreprise();
            default:
                return null;
        }
    }

    public Appel_offre getValueAt(int rowIndex) {
        return appelOffres.get(rowIndex);
    }
public void refresh(List<Appel_offre> appelOffres){
    //make the changes to the table, then call fireTableChanged
    fireTableChanged(null);

}}
