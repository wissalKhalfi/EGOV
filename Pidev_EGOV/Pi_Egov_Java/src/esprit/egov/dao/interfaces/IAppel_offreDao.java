/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.dao.interfaces;

import esprit.egov.entities.Appel_offre;
import java.util.List;

/**
 *
 * @author mouadh
 */
public interface IAppel_offreDao {

    List<Appel_offre> findAll();
    List<Appel_offre> findByID();

    void addAppel_offre(Appel_offre appel_offre);

    void updateAppel_offre(Appel_offre appel_offre);

    void removeAppel_offreById(Appel_offre appel_offre);

    Appel_offre findAppel_offreById(Appel_offre appel_offre);
}
