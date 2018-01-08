/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.dao.interfaces;

import esprit.egov.entities.CarteEdinar;
import java.util.Vector;

/**
 *
 * @author USER
 * @param <T>
 */
public interface ICarteEdinarDao<T> {
    void addCarteEdinar(T carteedinar);
    void modifyCarteEdinar(T carteedinar );
    void removeCarteEdinar (T carteedinar);
    Vector<CarteEdinar> findAll();
    CarteEdinar findCarteEdinarnum_carte(int num_carte);
    CarteEdinar findCarteEdinarcode_carte(int code_carte);
   
}
