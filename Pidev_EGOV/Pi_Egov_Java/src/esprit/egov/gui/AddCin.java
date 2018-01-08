/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.gui;

import esprit.egov.dao.classes.UtilisateurDao;
import esprit.egov.dao.interfaces.IUtilisateurDao;
import esprit.egov.entities.Utilisateur;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author macbookpro
 */
public class AddCin extends javax.swing.JFrame {

    /**
     * Creates new form AddEN
     */
    public AddCin() {
        initComponents();
    }

    AddCin(int id) {
        initComponents();
        Utilisateur Utilisateur = new Utilisateur();
        IUtilisateurDao utiDao = new UtilisateurDao();
        Utilisateur = utiDao.findUtilisateurById(id);
        DateNaiss.setDate(Utilisateur.getDateNaissance());
        Nom.setText(Utilisateur.getNom());
        Prenom.setText(Utilisateur.getPrenom());
        LieuNaiss.setText(Utilisateur.getLieuNaissance());
        NomPére.setText(Utilisateur.getNomPere());
        PrenomPére.setText(Utilisateur.getPrenomPere());
        NomMère.setText(Utilisateur.getNomMere());
        PrenomMère.setText(Utilisateur.getPrenomMere());
              
       if ( Utilisateur.getSexe().equalsIgnoreCase("feminin") ||Utilisateur.getSexe().equalsIgnoreCase("Feminin") ) {
           Feminin.setSelected(true);  
        }
       if(Utilisateur.getSexe().equalsIgnoreCase("masculin") ||Utilisateur.getSexe().equalsIgnoreCase("Masculin") ){
           Masculin.setSelected(true);
        } 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        Back = new javax.swing.JButton();
        Home = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Nom = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Prenom = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Masculin = new javax.swing.JRadioButton();
        Feminin = new javax.swing.JRadioButton();
        NomPére = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        PrenomPére = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        PrenomMère = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        NomMère = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        valider = new javax.swing.JButton();
        Rset = new javax.swing.JButton();
        DateNaiss = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        LieuNaiss = new javax.swing.JTextField();
        imageLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Adresse = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Profession = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        StatutSocial = new javax.swing.JComboBox();

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

        jLabel2.setText("Nom:");

        Nom.setText("Nom");
        Nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomActionPerformed(evt);
            }
        });

        jLabel3.setText("Prénom:");

        Prenom.setText("Prenom");
        Prenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrenomActionPerformed(evt);
            }
        });

        jLabel4.setText("Date de naissance:");

        jLabel5.setText("Sexe:");

        buttonGroup1.add(Masculin);
        Masculin.setText("Masculin");
        Masculin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MasculinActionPerformed(evt);
            }
        });

        buttonGroup1.add(Feminin);
        Feminin.setText("Feminin");
        Feminin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FemininActionPerformed(evt);
            }
        });

        NomPére.setText("Nom Pére");
        NomPére.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomPéreActionPerformed(evt);
            }
        });

        jLabel6.setText("Nom pére:");

        PrenomPére.setText("Prénom Pére");
        PrenomPére.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrenomPéreActionPerformed(evt);
            }
        });

        jLabel7.setText("Prénom pére:");

        PrenomMère.setText("Nom Mère");
        PrenomMère.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrenomMèreActionPerformed(evt);
            }
        });

        jLabel8.setText("Prénom mère:");

        NomMère.setText("Nom Mère");
        NomMère.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomMèreActionPerformed(evt);
            }
        });

        jLabel9.setText("Nom mère:");

        valider.setIcon(new javax.swing.ImageIcon("/Users/macbookpro/Desktop/3A13/PiDev/JavaSprint/Pi_Egov/images/Save.png")); // NOI18N
        valider.setText("Envoyer demande");
        valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerActionPerformed(evt);
            }
        });

        Rset.setIcon(new javax.swing.ImageIcon("/Users/macbookpro/Desktop/3A13/PiDev/JavaSprint/Pi_Egov/images/reset.png")); // NOI18N
        Rset.setText("Reset");
        Rset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RsetActionPerformed(evt);
            }
        });

        jLabel10.setText("Lieu de naissance:");

        LieuNaiss.setText("Lieu naissance");
        LieuNaiss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LieuNaissActionPerformed(evt);
            }
        });

        imageLabel.setText("Appuyer pour ajouter image");
        imageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageLabelMouseClicked(evt);
            }
        });

        jLabel11.setText("Adresse:");

        jLabel12.setText("Profession:");

        jLabel13.setText("Statut social");

        StatutSocial.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "marié(e)", "célibataire", "veuf(ve)", "divorcé(e)" }));
        StatutSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatutSocialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Nom, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Masculin)
                                .addGap(40, 40, 40)
                                .addComponent(Feminin))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(302, 302, 302)
                                .addComponent(imageLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(205, 205, 205)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LieuNaiss, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(DateNaiss, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(86, 86, 86)
                                    .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel11))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Rset)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(valider)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Home))
                                .addComponent(Profession, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Adresse, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(PrenomMère, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(NomPére, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(NomMère, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(PrenomPére, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addGap(92, 92, 92)
                        .addComponent(StatutSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Prenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(DateNaiss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(LieuNaiss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Masculin, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Feminin)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(NomPére, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(PrenomPére, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(NomMère, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrenomMère, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(StatutSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Adresse, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(Profession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Back)
                    .addComponent(Rset)
                    .addComponent(valider)
                    .addComponent(Home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        GestionCin add = new GestionCin();
        add.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BackActionPerformed

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        Acceuil add = new Acceuil();
        add.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_HomeActionPerformed

    private void NomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomActionPerformed

    private void PrenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrenomActionPerformed

    private void NomPéreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomPéreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomPéreActionPerformed

    private void PrenomPéreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrenomPéreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrenomPéreActionPerformed

    private void PrenomMèreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrenomMèreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrenomMèreActionPerformed

    private void NomMèreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomMèreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomMèreActionPerformed

    private void validerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validerActionPerformed

        Utilisateur uti = new Utilisateur();
        if(StatutSocial.getSelectedIndex()==0){
           uti.setStatutSocial("marie");  
        }else if (StatutSocial.getSelectedIndex()==1){
           uti.setStatutSocial("celibataire"); 
        }else if(StatutSocial.getSelectedIndex()==2){
            uti.setStatutSocial("veuf");
        }else if (StatutSocial.getSelectedIndex()==3){
            uti.setStatutSocial("divorce");
        }
       
        uti.setPhoto(selectedFile);
        uti.setNom(Nom.getText());
        uti.setPrenom(Prenom.getText());
        java.util.Date utilDate = DateNaiss.getDateEditor().getDate();
        uti.setDateNaissance(utilDate);
        uti.setLieuNaissance(LieuNaiss.getText());
        if (Feminin.isSelected()) {
            uti.setSexe(Feminin.getText());
        }
        if (Masculin.isSelected()) {
            uti.setSexe(Masculin.getText());
        }
        uti.setNomMere(NomMère.getText());
        uti.setPrenomMere(PrenomMère.getText());
        uti.setNomPere(NomPére.getText());
        uti.setPrenomPere(PrenomPére.getText());
        uti.setProfession(Profession.getText());
        uti.setAdresse(Adresse.getText());
        IUtilisateurDao utiDao = new UtilisateurDao();
        utiDao.addCin(uti);

    }//GEN-LAST:event_validerActionPerformed

    private void FemininActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FemininActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FemininActionPerformed

    private void MasculinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MasculinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MasculinActionPerformed

    private void LieuNaissActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LieuNaissActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LieuNaissActionPerformed

    private void RsetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RsetActionPerformed
        AddCin add = new AddCin();
        add.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_RsetActionPerformed
    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    private void imageLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageLabelMouseClicked

        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        //if the user click on save in Jfilechooser
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            imageLabel.setIcon(ResizeImage(path));
            s = path;
        } //if the user click on save in Jfilechooser
        else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("No File Select");
        }

    }//GEN-LAST:event_imageLabelMouseClicked

    private void StatutSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatutSocialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StatutSocialActionPerformed

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
            java.util.logging.Logger.getLogger(AddCin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCin().setVisible(true);
            }
        });
    }

    String s;
    File selectedFile;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Adresse;
    private javax.swing.JButton Back;
    private com.toedter.calendar.JDateChooser DateNaiss;
    private javax.swing.JRadioButton Feminin;
    private javax.swing.JButton Home;
    private javax.swing.JTextField LieuNaiss;
    private javax.swing.JRadioButton Masculin;
    private javax.swing.JTextField Nom;
    private javax.swing.JTextField NomMère;
    private javax.swing.JTextField NomPére;
    private javax.swing.JTextField Prenom;
    private javax.swing.JTextField PrenomMère;
    private javax.swing.JTextField PrenomPére;
    private javax.swing.JTextField Profession;
    private javax.swing.JButton Rset;
    private javax.swing.JComboBox StatutSocial;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel imageLabel;
    private com.toedter.calendar.JCalendar jCalendar1;
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
    private javax.swing.JButton valider;
    // End of variables declaration//GEN-END:variables
}
