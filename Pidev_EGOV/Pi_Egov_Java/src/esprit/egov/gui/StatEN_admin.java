/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.gui;

import esprit.egov.dao.classes.UtilisateurDao;
import esprit.egov.dao.interfaces.IUtilisateurDao;
import esprit.egov.entities.Utilisateur;
import java.awt.BorderLayout;
import java.text.MessageFormat;
import java.util.List;
import java.awt.PrintGraphics.*;
import java.io.File;
import java.io.IOException;
import java.text.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author macbookpro
 */
public class StatEN_admin extends javax.swing.JFrame {

    public StatEN_admin() throws IOException {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        PrenomMère = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanelChart = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        ListeDemandesEN = new javax.swing.JMenuItem();
        ListeEN = new javax.swing.JMenuItem();
        StatEN = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        ListeDemandesCin = new javax.swing.JMenuItem();
        ListeCin = new javax.swing.JMenuItem();
        StatCin = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        ActesJuri = new javax.swing.JMenuItem();
        ListeDemandesB3 = new javax.swing.JMenuItem();
        ListeB3 = new javax.swing.JMenuItem();
        StatB3 = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem3.setText("jMenuItem3");

        PrenomMère.setText("Nom Mère");
        PrenomMère.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrenomMèreActionPerformed(evt);
            }
        });

        jLabel8.setText("Prénom mère:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                showGraphe(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel1.setText("E-gov");

        javax.swing.GroupLayout jPanelChartLayout = new javax.swing.GroupLayout(jPanelChart);
        jPanelChart.setLayout(jPanelChartLayout);
        jPanelChartLayout.setHorizontalGroup(
            jPanelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 553, Short.MAX_VALUE)
        );
        jPanelChartLayout.setVerticalGroup(
            jPanelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 285, Short.MAX_VALUE)
        );

        jMenu1.setText("Extraits de naissances");

        ListeDemandesEN.setText("Liste demandes");
        ListeDemandesEN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListeDemandesENActionPerformed(evt);
            }
        });
        jMenu1.add(ListeDemandesEN);

        ListeEN.setText("Liste extraits");
        ListeEN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListeENActionPerformed(evt);
            }
        });
        jMenu1.add(ListeEN);

        StatEN.setText("Statistiques");
        jMenu1.add(StatEN);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Cartes d'identité nationale");

        ListeDemandesCin.setText("Liste Demandes");
        ListeDemandesCin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListeDemandesCinActionPerformed(evt);
            }
        });
        jMenu2.add(ListeDemandesCin);

        ListeCin.setText("Liste CIN");
        ListeCin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListeCinActionPerformed(evt);
            }
        });
        jMenu2.add(ListeCin);

        StatCin.setText("Statistiques");
        jMenu2.add(StatCin);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Bulletins numéro 3");

        ActesJuri.setText("Actes juridiques");
        ActesJuri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActesJuriActionPerformed(evt);
            }
        });
        jMenu3.add(ActesJuri);

        ListeDemandesB3.setText("Liste demandes");
        ListeDemandesB3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListeDemandesB3ActionPerformed(evt);
            }
        });
        jMenu3.add(ListeDemandesB3);

        ListeB3.setText("Liste B3");
        jMenu3.add(ListeB3);

        StatB3.setText("Statistiques");
        jMenu3.add(StatB3);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jPanelChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ListeDemandesENActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListeDemandesENActionPerformed
        StatEN_admin add = null;
        try {
            add = new StatEN_admin();
        } catch (IOException ex) {
            Logger.getLogger(StatEN_admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        add.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ListeDemandesENActionPerformed

    private void ListeDemandesCinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListeDemandesCinActionPerformed
        ListeDemandesCin_admin add = new ListeDemandesCin_admin();
        add.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ListeDemandesCinActionPerformed

    private void ListeDemandesB3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListeDemandesB3ActionPerformed
        ListeCondamnes_admin add = new ListeCondamnes_admin();
        add.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ListeDemandesB3ActionPerformed

    private void PrenomMèreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrenomMèreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrenomMèreActionPerformed

    private void ListeENActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListeENActionPerformed
        RechercheEN_admin add = new RechercheEN_admin();
        add.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ListeENActionPerformed

    private void ListeCinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListeCinActionPerformed
        RechercheCin_admin add = new RechercheCin_admin();
        add.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ListeCinActionPerformed

    private void ActesJuriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActesJuriActionPerformed
        ListeActesJuridiques_admin listeAJ = new ListeActesJuridiques_admin();
        listeAJ.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ActesJuriActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        
    }//GEN-LAST:event_formComponentShown

    private void showGraphe(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_showGraphe
       IUtilisateurDao utiDao = new UtilisateurDao();
        int f = utiDao.StatSexe("feminin");
        int M = utiDao.StatSexe("masculin");
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("feminin", new Double(f));
        dataset.setValue("masculin", new Double(M));
        JFreeChart graphe = ChartFactory.createPieChart3D("Exemple Cammemeberg", dataset, true, true, false);
        ChartPanel chartpanel = new ChartPanel(graphe);
        chartpanel.setDomainZoomable(true);
        jPanelChart.add(chartpanel, BorderLayout.NORTH);
        this.add(jPanelChart);
    }//GEN-LAST:event_showGraphe

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StatEN_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StatEN_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StatEN_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StatEN_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new StatEN_admin().setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(StatEN_admin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ActesJuri;
    private javax.swing.JMenuItem ListeB3;
    private javax.swing.JMenuItem ListeCin;
    private javax.swing.JMenuItem ListeDemandesB3;
    private javax.swing.JMenuItem ListeDemandesCin;
    private javax.swing.JMenuItem ListeDemandesEN;
    private javax.swing.JMenuItem ListeEN;
    private javax.swing.JTextField PrenomMère;
    private javax.swing.JMenuItem StatB3;
    private javax.swing.JMenuItem StatCin;
    private javax.swing.JMenuItem StatEN;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanelChart;
    // End of variables declaration//GEN-END:variables
}