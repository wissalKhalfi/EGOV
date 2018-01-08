/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.gui;

import esprit.egov.dao.classes.UtilisateurDao;
import esprit.egov.dao.interfaces.IUtilisateurDao;
import esprit.egov.entities.Utilisateur;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.text.MessageFormat;
import java.util.List;
import java.awt.PrintGraphics.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.MessageFormat;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author macbookpro
 */
public class ShowEN extends javax.swing.JFrame {

    /**
     * Creates new form ShowEN
     */
    public ShowEN() {
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

        DateNaiss2 = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        Back = new javax.swing.JButton();
        Home = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        NomRech = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Pnom = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        DateNaiss1 = new com.toedter.calendar.JDateChooser();
        Trouver = new javax.swing.JButton();
        EN = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Nom = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Prenom = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        DateNaiss = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Sexe = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        LieuNaiss = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        NomPere = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        PrenomPere = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        NomMere = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        PrenomMere = new javax.swing.JLabel();
        Imprimer = new javax.swing.JButton();

        DateNaiss2.setText("jLabel14");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Back.setIcon(new javax.swing.ImageIcon("/Users/macbookpro/Desktop/3A13/PiDev/JavaSprint/Pi_Egov/images/back.png")); // NOI18N
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        Home.setIcon(new javax.swing.ImageIcon("/Users/macbookpro/Desktop/3A13/PiDev/JavaSprint/Pi_Egov/images/home.png")); // NOI18N
        Home.setText("Home");
        Home.setSize(new java.awt.Dimension(40, 20));
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel1.setText("E-gov");

        jLabel11.setText("Nom");

        NomRech.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NomRechKeyReleased(evt);
            }
        });

        jLabel12.setText("Prénom");

        Pnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PnomActionPerformed(evt);
            }
        });

        jLabel13.setText("Date de naissance");

        Trouver.setIcon(new javax.swing.ImageIcon("/Users/macbookpro/Desktop/3A13/PiDev/JavaSprint/Pi_Egov/images/find.png")); // NOI18N
        Trouver.setText("Trouver");
        Trouver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrouverActionPerformed(evt);
            }
        });

        jLabel2.setText("Nom:");

        Nom.setText("Nom...");

        jLabel3.setText("Prénom:");

        Prenom.setText("Prenom...");

        jLabel4.setText("Date de naissance:");

        DateNaiss.setText("Date de naissance...");

        jLabel5.setText("Sexe:");

        Sexe.setText("Sexe...");

        jLabel10.setText("Lieu de naissance:");

        LieuNaiss.setText("Lieu de naissance...");

        jLabel6.setText("Nom pére:");

        NomPere.setText("Nom du père...");

        jLabel7.setText("Prénom pére:");

        PrenomPere.setText("Prénom du père...");

        jLabel9.setText("Nom mère:");

        NomMere.setText("Nom du mére...");

        jLabel8.setText("Prénom mère:");

        PrenomMere.setText("Prénom du mére...");

        javax.swing.GroupLayout ENLayout = new javax.swing.GroupLayout(EN);
        EN.setLayout(ENLayout);
        ENLayout.setHorizontalGroup(
            ENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ENLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(ENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ENLayout.createSequentialGroup()
                        .addGroup(ENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(ENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(ENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nom, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DateNaiss, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NomPere, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Sexe, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LieuNaiss, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(PrenomPere, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NomMere, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PrenomMere, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        ENLayout.setVerticalGroup(
            ENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ENLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(ENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nom))
                .addGap(21, 21, 21)
                .addGroup(ENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Prenom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(DateNaiss))
                .addGap(12, 12, 12)
                .addGroup(ENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Sexe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(LieuNaiss))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(NomPere))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(PrenomPere))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(NomMere))
                .addGap(18, 18, 18)
                .addGroup(ENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(PrenomMere))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        Imprimer.setIcon(new javax.swing.ImageIcon("/Users/macbookpro/Desktop/3A13/PiDev/JavaSprint/Pi_Egov/images/print.png")); // NOI18N
        Imprimer.setText("Imprimer");
        Imprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(EN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(Imprimer)))
                .addGap(110, 110, 110)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NomRech, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Pnom, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DateNaiss1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(Trouver))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(EN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Imprimer)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(NomRech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Pnom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DateNaiss1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(40, 40, 40)
                .addComponent(Trouver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Home)
                    .addComponent(Back)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        GestionEn add = new GestionEn();
        add.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BackActionPerformed

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        Acceuil add = new Acceuil();
        add.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_HomeActionPerformed

    private void NomRechKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NomRechKeyReleased

    }//GEN-LAST:event_NomRechKeyReleased

    private void PnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PnomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PnomActionPerformed

    private void TrouverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrouverActionPerformed

        IUtilisateurDao utiDao = new UtilisateurDao();
        int id = utiDao.findUtiByNomPrenomDateNaiss(NomRech.getText(), Pnom.getText(), DateNaiss1.getDate());
        Utilisateur uti = utiDao.showExtraitNaissance(id);
        Nom.setText(uti.getNom());
        Prenom.setText(uti.getPrenom());
        DateNaiss.setText(uti.getDateNaissance().toString());
        Sexe.setText(uti.getSexe());
        LieuNaiss.setText(uti.getLieuNaissance());
        NomPere.setText(uti.getNomPere());
        PrenomPere.setText(uti.getPrenomPere());
        NomMere.setText(uti.getNomMere());
        PrenomMere.setText(uti.getPrenomMere());

    }//GEN-LAST:event_TrouverActionPerformed

    private void ImprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimerActionPerformed
        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setJobName(" Extrait de naissance");
        pj.setPrintable(new Printable() {
            public int print(Graphics pg, PageFormat pf, int pageNum) {
                if (pageNum > 0) {
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D g2 = (Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                EN.paint(g2);
                return Printable.PAGE_EXISTS;
            }
        });
        if (pj.printDialog() == false) {
            return;
        }

        try {
            pj.print();
        } catch (PrinterException ex) {

        }
    }//GEN-LAST:event_ImprimerActionPerformed

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
            java.util.logging.Logger.getLogger(ShowEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowEN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JLabel DateNaiss;
    private com.toedter.calendar.JDateChooser DateNaiss1;
    private javax.swing.JLabel DateNaiss2;
    private javax.swing.JPanel EN;
    private javax.swing.JButton Home;
    private javax.swing.JButton Imprimer;
    private javax.swing.JLabel LieuNaiss;
    private javax.swing.JLabel Nom;
    private javax.swing.JLabel NomMere;
    private javax.swing.JLabel NomPere;
    private javax.swing.JTextField NomRech;
    private javax.swing.JTextField Pnom;
    private javax.swing.JLabel Prenom;
    private javax.swing.JLabel PrenomMere;
    private javax.swing.JLabel PrenomPere;
    private javax.swing.JLabel Sexe;
    private javax.swing.JButton Trouver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables
}