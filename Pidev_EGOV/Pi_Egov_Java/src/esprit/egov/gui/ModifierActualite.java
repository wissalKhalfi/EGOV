/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.gui;

import esprit.egov.dao.classes.ArticlesDao;
import esprit.egov.entities.Articles;
import java.io.File;
import java.text.SimpleDateFormat;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author USER
 */
public class ModifierActualite extends javax.swing.JFrame {

    /**
     * Creates new form ModifierActualite
     */
    String s;
    public ModifierActualite() {
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

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/pidev/Icon/searchicon.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 40, 20));

        jTextField2.setBackground(new java.awt.Color(0, 153, 204));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 260, 30));

        jTextField5.setBackground(new java.awt.Color(0, 153, 255));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 250, 30));

        jTextField4.setBackground(new java.awt.Color(0, 153, 255));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 250, 20));

        jTextField8.setBackground(new java.awt.Color(0, 153, 255));
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 250, 20));

        jTextField6.setBackground(new java.awt.Color(0, 153, 255));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 250, 30));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/pidev/Icon/Enregistrerbutton.png"))); // NOI18N
        jButton2.setText("jButton1");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 100, 40));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/pidev/Icon/retouricone.PNG"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 70, 40));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Titre article");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 100, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Date article");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 134, -1, 30));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("image article");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("priorite pub");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 194, -1, 20));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("type");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jButton4.setText("choisir une image");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 250, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/pidev/Icon/Modifierarticle.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed

    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ArticlesDao cd = new ArticlesDao();
        Articles carte = new Articles();
        int m = Integer.parseInt(jTextField2.getText());
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        carte = cd.findArticlesid(m);
        //        String n = String.valueOf(carte.getNum_carte());
        //        String c = String.valueOf(carte.getCode_carte());
        //        String s = String.valueOf(carte.getSolde_actuel());
        //        String[] t = {n, c, s, "Modifier"};
        //        model.addRow(t);
        //        jTable2.getColumn("e").setCellRenderer(new ButtonRender());
        //        jTable2.getColumn("e").setCellEditor(new ButtonEditor(new JTextField()));
        jTextField6.setText(carte.getTitre_article());
        jTextField5.setText(format.format(carte.getDate_article()));
        jTextField8.setText(Integer.toString(carte.getPriorite_pub()));
        jTextField5.setText(format.format(carte.getDate_article()));
        jTextField4.setText(carte.getType());

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            ArticlesDao cd = new ArticlesDao();
            Articles carte = new Articles();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date date =  format.parse(jTextField5.getText());
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            carte.setTitre_article(jTextField6.getText());
            carte.setPriorite_pub(Integer.parseInt(jTextField4.getText()));
            carte.setType(Integer.parseInt(jTextField5.getText()));
            carte.setDate_article(sqlDate);
            cd.modifyArticle(carte);
        } catch (ParseException ex) {
            Logger.getLogger(Modifieredinar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Carteedinar rech = new Carteedinar();
        rech.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
JFileChooser fileChooser = new JFileChooser(); 
fileChooser.setCurrentDirectory(new File(System.getProperty("user.home"))); 
FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
fileChooser.addChoosableFileFilter(filter);
int result = fileChooser.showSaveDialog(null); 
if(result == JFileChooser.APPROVE_OPTION){ File selectedFile = fileChooser.getSelectedFile(); 
String path = selectedFile.getAbsolutePath(); 
s = path; }
else if(result == JFileChooser.CANCEL_OPTION)
{ System.out.println("No Data"); } 
                                           
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(ModifierActualite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifierActualite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifierActualite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifierActualite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifierActualite().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}