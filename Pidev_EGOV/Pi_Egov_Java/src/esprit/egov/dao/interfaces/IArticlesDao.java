/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.dao.interfaces;

import esprit.egov.entities.Articles;
import java.util.Vector;

/**
 *
 * @author USER
 * @param <T>
 */
public interface IArticlesDao<T> {
    
    void addArticle(T article);
    void modifyArticle(T article );
    void removeArticle(T article);
    Vector<Articles> findAll();
    Vector<Articles> findArticlestype(String type);
    Articles findArticlesid(int id);
    
}
