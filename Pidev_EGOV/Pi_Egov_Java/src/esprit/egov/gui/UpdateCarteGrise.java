/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.gui;

import esprit.egov.dao.classes.CarteGriseDao;
import esprit.egov.dao.classes.PermisDao;
import esprit.egov.entities.CarteGrise;
import esprit.egov.entities.Permis;

/**
 *
 * @author macbookpro
 */
public class UpdateCarteGrise extends javax.swing.JFrame {

    /**
     * Creates new form UpdateEN
     */
    public UpdateCarteGrise() {
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

        Back = new javax.swing.JButton();
        Home = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        marque_vehicule = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        num_serie_vehicule = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        type_vehicule = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        bleu = new javax.swing.JRadioButton();
        blanc = new javax.swing.JRadioButton();
        noir = new javax.swing.JRadioButton();
        rouge = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        id_carte_grise = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        Home.setText("Home");
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });

        Update.setText("update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel1.setText("E-gov");

        jLabel2.setText("Marque Vehicule:");

        marque_vehicule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marque_vehiculeActionPerformed(evt);
            }
        });

        jLabel3.setText("num serie vehicule:");

        num_serie_vehicule.setText("num_serie_vehicule");
        num_serie_vehicule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num_serie_vehiculeActionPerformed(evt);
            }
        });

        jLabel6.setText("type vehicule:");

        type_vehicule.setText("type_vehicule");
        type_vehicule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type_vehiculeActionPerformed(evt);
            }
        });

        jLabel5.setText("couleur vehicule:");

        bleu.setText("bleu");
        bleu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bleuActionPerformed(evt);
            }
        });

        blanc.setText("blanc");
        blanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blanccActionPerformed(evt);
            }
        });

        noir.setText("noir");
        noir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noirActionPerformed(evt);
            }
        });

        rouge.setText("rouge");
        rouge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rougeActionPerformed(evt);
            }
        });

        jLabel4.setText("id de votre carte grise:");

        id_carte_grise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_carte_griseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(316, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(155, 155, 155)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(marque_vehicule, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(type_vehicule, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(noir)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                    .addComponent(rouge))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(bleu)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(blanc)))
                            .addComponent(num_serie_vehicule, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(196, 196, 196))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(id_carte_grise, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(283, 283, 283))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id_carte_grise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(marque_vehicule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(num_serie_vehicule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(type_vehicule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bleu)
                            .addComponent(blanc)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noir)
                    .addComponent(rouge))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Back)
                    .addComponent(Update)
                    .addComponent(Home)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        GestionCarteGrise add=new GestionCarteGrise();
        add.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BackActionPerformed

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        Acceuil add=new Acceuil ();
        add.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_HomeActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        CarteGriseDao carteGriseDao = new CarteGriseDao();
       CarteGrise carteGrise=new CarteGrise();
        //b.setDate_creation_permis(Integer.parseInt(date_creation_permis.getText()));
       
       // carteGrise.setId_carte_grise(Integer.parseInt(id_carte_grise.getText()));
        carteGrise.setMarque_vehicule(marque_vehicule.getText());
         carteGrise.setNum_serie_vehicule(num_serie_vehicule.getText());
         carteGrise.setType_vehicule(type_vehicule.getText());
         
       // b.setCategorie_permis(Integer.parseInt(categorie_permis.getText()));
         
        if(bleu.isSelected()){
           carteGrise.setCouleur_vehicule(bleu.getText()); 
        }
        if(blanc.isSelected()){
           carteGrise.setCouleur_vehicule(blanc.getText()); 
        }
        if(noir.isSelected()){
           carteGrise.setCouleur_vehicule(noir.getText()); 
        }
        if(rouge.isSelected()){
           carteGrise.setCouleur_vehicule(rouge.getText()); 
        }
        

        carteGriseDao.updateCarteGrise(carteGrise);
        
    }//GEN-LAST:event_UpdateActionPerformed

    private void marque_vehiculeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marque_vehiculeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_marque_vehiculeActionPerformed

    private void num_serie_vehiculeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num_serie_vehiculeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_num_serie_vehiculeActionPerformed

    private void type_vehiculeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type_vehiculeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_type_vehiculeActionPerformed

    private void bleuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bleuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bleuActionPerformed

    private void blanccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blanccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_blanccActionPerformed

    private void noirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noirActionPerformed

    private void rougeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rougeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rougeActionPerformed

    private void id_carte_griseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_carte_griseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_carte_griseActionPerformed

 
    
    
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
            java.util.logging.Logger.getLogger(UpdateCarteGrise.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateCarteGrise.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateCarteGrise.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateCarteGrise.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new UpdateCarteGrise().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Home;
    private javax.swing.JButton Update;
    private javax.swing.JRadioButton blanc;
    private javax.swing.JRadioButton bleu;
    private javax.swing.JTextField id_carte_grise;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField marque_vehicule;
    private javax.swing.JRadioButton noir;
    private javax.swing.JTextField num_serie_vehicule;
    private javax.swing.JRadioButton rouge;
    private javax.swing.JTextField type_vehicule;
    // End of variables declaration//GEN-END:variables
}