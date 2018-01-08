/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.dao.interfaces;

import esprit.egov.entities.Entreprise;
import java.util.List;

/**
 *
 * @author mouad
 */
public interface IEntrepriseDao {
        List<Entreprise> findAll();

    void addEntreprise(Entreprise entreprise);

    void updateEntreprise(Entreprise entreprise);

    void removeEntrepriseById(int code_fiscal);

    Entreprise findEntrepriseById(int code_fiscal);
}
