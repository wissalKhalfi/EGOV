/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.gui;

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
public class chartSexe extends JFrame  {
    DefaultPieDataset dataset;
    JFreeChart graphe;
    ChartPanel cp;
     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        Ecitoyennite ch = new Ecitoyennite();
        ch.setVisible(true);
        
    } 
    public chartSexe(){
     IUtilisateurDao utiDao = new UtilisateurDao();
        int f = utiDao.StatSexe("feminin");
        int M = utiDao.StatSexe("masculin");
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("feminin", new Double(f));
        dataset.setValue("masculin", new Double(M));
        
        graphe= ChartFactory.createPieChart3D("Repartition des citoyens par sexe", dataset, true,true ,false )  ;
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
       chartSexe pchart=new chartSexe();
    }
    
}
