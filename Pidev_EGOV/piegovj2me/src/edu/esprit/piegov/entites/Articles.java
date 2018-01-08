/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.piegov.entites;


import java.io.InputStream;
import java.util.Date;


/**
 *
 * @author USER
 */
public class Articles {
    
    private int id_article;
    private String titre_article;
    private Date date_article;
//    private Blob image_article;
    private String texte_article;
    private int priorite_pub;
    private String type;
    private InputStream fin ;

    public InputStream getFin() {
        return fin;
    }

    public void setFin(InputStream fin) {
        this.fin = fin;
    }
    public Articles(int id_article, String titre_article, Date date_article, String texte_article, int priorite_pub, String type) {
        this.id_article = id_article;
        this.titre_article = titre_article;
        this.date_article = date_article;
     //   this.image_article = image_article;
        this.texte_article = texte_article;
        this.priorite_pub = priorite_pub;
        this.type = type;
    }

    public Articles() {
    }

    public Articles(int id, String titre, Date sqlDatecreation, InputStream is, String texte, int priorite, String type) {
        this.id_article = id;
        this.titre_article = titre;
        this.date_article = sqlDatecreation;
        this.fin = is;
        this.texte_article = texte;
        this.priorite_pub = priorite;
        this.type = type;
       
    }

    public int getId_article() {
        return id_article;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    public String getTitre_article() {
        return titre_article;
    }

    public void setTitre_article(String titre_article) {
        this.titre_article = titre_article;
    }

    public Date getDate_article() {
        return date_article;
    }

    public void setDate_article(Date date_article) {
        this.date_article = date_article;
    }

//    public Blob getImage_article() {
//        return image_article;
//    }

//    public void setImage_article(Blob image_article) {
//        this.image_article = image_article;
//    }

    public String getTexte_article() {
        return texte_article;
    }

    public void setTexte_article(String texte_article) {
        this.texte_article = texte_article;
    }

    public int getPriorite_pub() {
        return priorite_pub;
    }

    public void setPriorite_pub(int priorite_pub) {
        this.priorite_pub = priorite_pub;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

  
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id_article;
        return hash;
    }

 

    public String toString() {
        return "Articles{" + "id_article=" + id_article + ", titre_article=" + titre_article + ", date_article=" + date_article +  ", texte_article=" + texte_article + ", priorite_pub=" + priorite_pub + ", type=" + type + '}';
    }
    
    
    
}
