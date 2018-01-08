/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.gui;

import esprit.egov.dao.classes.ListeActesDao;
import esprit.egov.dao.classes.UtilisateurDao;
import esprit.egov.dao.interfaces.IListeActesDao;
import esprit.egov.dao.interfaces.IUtilisateurDao;
import esprit.egov.entities.ActesJuridiques;
import esprit.egov.entities.ListeActes;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.MessageFormat;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author macbookpro
 */
public class ListeCondamnes_admin extends javax.swing.JFrame {

    /**
     * Creates new form AddEN
     */
    void updateTable() {
        DefaultTableModel model = (DefaultTableModel) ActeCitoyen.getModel();
        model.setRowCount(0);
        IUtilisateurDao utiDao = new UtilisateurDao();
        IListeActesDao listeActeDao = new ListeActesDao ();
        List<ListeActes> listeAc = listeActeDao.ListerActesParCitoyen();
        for (ListeActes ind : listeAc) {
            model.addRow(
                    new Object[]{ind.getId(), ind.getActe().getIdActe(), ind.getCitoyen().getNumCin(), ind.getCitoyen().getNom(), ind.getCitoyen().getPrenom(), ind.getCitoyen().getDateNaissance()
                    }
            );
        }
    }
     void updateTable(String numCin) {
        DefaultTableModel model = (DefaultTableModel) ActeCitoyen.getModel();
        model.setRowCount(0);
        IUtilisateurDao utiDao = new UtilisateurDao();        
        IListeActesDao listeActeDao = new ListeActesDao ();
        List<ListeActes> listeAc = listeActeDao.TrouverActesParCitoyen(numCin);
        for (ListeActes ind : listeAc) {
            model.addRow(
                    new Object[]{ind.getId(), ind.getActe().getIdActe(), ind.getCitoyen().getNumCin(), ind.getCitoyen().getNom(), ind.getCitoyen().getPrenom(), ind.getCitoyen().getDateNaissance()
                    }
            );
        }
    }
    void updateTable(int idActe,String numCin){
         DefaultTableModel model = (DefaultTableModel) ActeCitoyen.getModel();
        model.setRowCount(0);
        IUtilisateurDao utiDao = new UtilisateurDao();
        IListeActesDao listeActeDao = new ListeActesDao ();
        List<ListeActes> listeAc = listeActeDao.TrouverActeCitoyen(numCin,idActe);
        for (ListeActes ind : listeAc) {
            model.addRow(
                    new Object[]{ind.getId(), ind.getActe().getIdActe(), ind.getCitoyen().getNumCin(), ind.getCitoyen().getNom(), ind.getCitoyen().getPrenom(), ind.getCitoyen().getDateNaissance()
                    }
            );
        }
        
    }
     void updateTable(int idActe) {
        DefaultTableModel model = (DefaultTableModel) ActeCitoyen.getModel();
        model.setRowCount(0);
        IUtilisateurDao utiDao = new UtilisateurDao();
        IListeActesDao listeActeDao = new ListeActesDao ();
        List<ListeActes> listeAc = listeActeDao.TrouverCondamnesParActe(idActe);
        for (ListeActes ind : listeAc) {
            model.addRow(
                    new Object[]{ind.getId(), ind.getActe().getIdActe(), ind.getCitoyen().getNumCin(), ind.getCitoyen().getNom(), ind.getCitoyen().getPrenom(), ind.getCitoyen().getDateNaissance()
                    }
            );
        }
    }

    public ListeCondamnes_admin() {
        initComponents();
        updateTable();
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
        Back = new javax.swing.JButton();
        Home = new javax.swing.JButton();
        imprimer = new javax.swing.JButton();
        PanelP = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ActeCitoyen = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        RechCin = new javax.swing.JTextField();
        RechIdActe = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
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

        imprimer.setIcon(new javax.swing.ImageIcon("/Users/macbookpro/Desktop/3A13/PiDev/JavaSprint/Pi_Egov/images/print.png")); // NOI18N
        imprimer.setText("Imprimer");
        imprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimerActionPerformed(evt);
            }
        });

        ActeCitoyen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "id acte", "Num cin", "Nom", "Prénom", "Date de naissance"
            }
        ));
        jScrollPane1.setViewportView(ActeCitoyen);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel1.setText("E-gov");

        jLabel2.setText("Num CIN:");

        RechCin.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                RechCinInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        RechCin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RechCinKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RechCinKeyReleased(evt);
            }
        });

        RechIdActe.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                RechIdActeInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        RechIdActe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RechIdActeKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RechIdActeKeyReleased(evt);
            }
        });

        jLabel3.setText("Id acte:");

        javax.swing.GroupLayout PanelPLayout = new javax.swing.GroupLayout(PanelP);
        PanelP.setLayout(PanelPLayout);
        PanelPLayout.setHorizontalGroup(
            PanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(PanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(PanelPLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(PanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelPLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(RechIdActe, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelPLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(RechCin, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(34, 34, 34))
        );
        PanelPLayout.setVerticalGroup(
            PanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(PanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addGroup(PanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RechCin, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RechIdActe, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
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
        jMenu1.add(ListeEN);

        StatEN.setText("Statistiques");
        jMenu1.add(StatEN);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Cartes d'identité nationale");

        ListeDemandesCin.setText("Liste Demandes");
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
                        .addGap(227, 227, 227)
                        .addComponent(imprimer)
                        .addGap(368, 368, 368)
                        .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Home))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(PanelP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(PanelP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Back)
                    .addComponent(Home)
                    .addComponent(imprimer))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        Acceuil_admin  add=new Acceuil_admin ();
        add.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BackActionPerformed

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        login add = new login();
        add.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_HomeActionPerformed

    private void ListeDemandesENActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListeDemandesENActionPerformed
        RechercheEN_admin add = new RechercheEN_admin();
        add.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ListeDemandesENActionPerformed

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

    private void ListeDemandesB3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListeDemandesB3ActionPerformed
        ListeCondamnes_admin add = new ListeCondamnes_admin();
        this.setVisible(false);
        add.setVisible(true);
    }//GEN-LAST:event_ListeDemandesB3ActionPerformed

    private void RechCinInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_RechCinInputMethodTextChanged
        IUtilisateurDao utiDao = new UtilisateurDao();
        String numCin= RechCin.getText();
        int idActe=Integer.parseInt(RechIdActe.getText());
         if(RechIdActe.getText().isEmpty()){             
               updateTable(numCin);
         }
         else{
             updateTable(idActe,numCin);
         }
       
    }//GEN-LAST:event_RechCinInputMethodTextChanged

    private void RechCinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RechCinKeyTyped
      
    }//GEN-LAST:event_RechCinKeyTyped

    private void RechCinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RechCinKeyReleased
        String numCin= RechCin.getText();
         if(RechIdActe.getText().isEmpty()){             
               updateTable(numCin);
         }
         else{
             int idActe=Integer.parseInt(RechIdActe.getText());
             updateTable(idActe,numCin);
         }
    }//GEN-LAST:event_RechCinKeyReleased

    private void RechIdActeInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_RechIdActeInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_RechIdActeInputMethodTextChanged

    private void RechIdActeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RechIdActeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_RechIdActeKeyTyped

    private void RechIdActeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RechIdActeKeyReleased
        
         String numCin= RechCin.getText();
         if(numCin.isEmpty()){
             int idActe=Integer.parseInt(RechIdActe.getText());
              updateTable(idActe);
         }
         else if(RechIdActe.getText().isEmpty()){
             updateTable(numCin);
             
         }
         else{
             int idActe=Integer.parseInt(RechIdActe.getText());
             updateTable(idActe,numCin);
         }
       
    }//GEN-LAST:event_RechIdActeKeyReleased

    private void imprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimerActionPerformed
        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setJobName(" Actes juridiques");
        pj.setPrintable(new Printable() {
            public int print(Graphics pg, PageFormat pf, int pageNum) {
                if (pageNum > 0) {
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D g2 = (Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                PanelP.paint(g2);
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
    }//GEN-LAST:event_imprimerActionPerformed

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
            java.util.logging.Logger.getLogger(ListeCondamnes_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListeCondamnes_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListeCondamnes_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListeCondamnes_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ListeCondamnes_admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ActeCitoyen;
    private javax.swing.JMenuItem ActesJuri;
    private javax.swing.JButton Back;
    private javax.swing.JButton Home;
    private javax.swing.JMenuItem ListeB3;
    private javax.swing.JMenuItem ListeCin;
    private javax.swing.JMenuItem ListeDemandesB3;
    private javax.swing.JMenuItem ListeDemandesCin;
    private javax.swing.JMenuItem ListeDemandesEN;
    private javax.swing.JMenuItem ListeEN;
    private javax.swing.JPanel PanelP;
    private javax.swing.JTextField RechCin;
    private javax.swing.JTextField RechIdActe;
    private javax.swing.JMenuItem StatB3;
    private javax.swing.JMenuItem StatCin;
    private javax.swing.JMenuItem StatEN;
    private javax.swing.JButton imprimer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
