/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.tests;

import esprit.egov.dao.classes.Appel_offreDao;
import esprit.egov.dao.interfaces.IAppel_offreDao;
import esprit.egov.entities.Appel_offre;



/**
 *
 * @author Mehdi
 */
public class Test {

    public static void main(String[] args) {
        IAppel_offreDao appel_offreDao = new Appel_offreDao();
        Appel_offre a = appel_offreDao.findAppel_offreById(null);
    }
}
