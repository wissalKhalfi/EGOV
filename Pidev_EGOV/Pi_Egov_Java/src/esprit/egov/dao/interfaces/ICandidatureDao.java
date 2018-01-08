/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.dao.interfaces;

import esprit.egov.entities.Candidature;
import java.util.List;

/**
 *
 * @author mouad
 */
public interface ICandidatureDao {

    List<Candidature> findAll();

    void addCandidature(Candidature candidature);

    void updateCandidature(Candidature candidature);

    void removeDepotById(int id_candidature);

    Candidature findCandidatureById(int id_candidature);

}
