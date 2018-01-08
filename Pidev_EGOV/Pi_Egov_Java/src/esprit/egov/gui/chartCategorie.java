/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.gui;

import esprit.egov.dao.classes.PermisDao;
import esprit.egov.dao.classes.UtilisateurDao;
import esprit.egov.dao.interfaces.IUtilisateurDao;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.JButton;

/**
 *
 * @author macbookpro
 */
public class chartCategorie extends JFrame  {
    DefaultPieDataset dataset;
    JFreeChart graphe;
    ChartPanel cp;
     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        statPermis ch = new statPermis();
        ch.setVisible(true);
        
    } 
    public chartCategorie(){
     PermisDao utiDao = new PermisDao();
        int f = utiDao.StatCategorie("A");
        int M = utiDao.StatCategorie("A+B");
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("A", new Double(f));
        dataset.setValue("A+B", new Double(M));
        
        graphe= ChartFactory.createPieChart3D("Exemple Cammemeberg", dataset, true,true ,false )  ;
        cp= new ChartPanel(graphe);
        JButton jButton1 = new javax.swing.JButton();
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(10,10,100,100);
        this.add(jButton1);       
        this.add(cp);
        this.pack();
        this.setVisible(true);
    }
    
    public static void main(String[] args){
       chartCategorie pchart=new chartCategorie();
    }
    
}
