/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.dao.classes;

import esprit.egov.dao.interfaces.IEntrepriseDao;
import esprit.egov.entities.Entreprise;
import esprit.egov.technique.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mouad
 */
public class EntrepriseDao implements IEntrepriseDao{
    private Connection conn;

    public EntrepriseDao() {
           conn = DataSource.getInstance().getConnection();
    }

    @Override
    public List<Entreprise> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addEntreprise(Entreprise entreprise) {
try {
            String req = "insert into entreprise (nom) values (?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, entreprise.getNom());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EntrepriseDao.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public void updateEntreprise(Entreprise entreprise) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeEntrepriseById(int code_fiscal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entreprise findEntrepriseById(int code_fiscal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
}
