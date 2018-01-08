/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.dao.interfaces;

import esprit.egov.entities.Ccp;
import java.util.Vector;

/**
 *
 * @author USER
 */
public interface ICcpDao <T>{
      void addCcp(T Ccp);
    void modifyCcp(T Ccp);
    void removeCcp (T Ccp);
    Vector<Ccp> findAll();
    Ccp findCcp(int num_ccp);
    Ccp findCcpbycode(int code_ccp);
    
}
