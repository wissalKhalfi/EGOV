/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.adapters;

import esprit.egov.dao.classes.ArticlesDao;
import esprit.egov.entities.Articles;
import java.awt.Image;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class ActualitepostModel extends AbstractTableModel {

    String[] elements = {"id_article", "Titre_article", "date_article", "image_article", "details"};
    Vector<Articles> articles;
    Vector<Articles> rows;
    Vector<ImageIcon> rows2;
    JLabel label = new JLabel();

    public ActualitepostModel() throws SQLException, IOException {
        articles = new Vector<Articles>();
        rows = new Vector<Articles>();
        rows2 = new Vector<ImageIcon>();
        ArticlesDao cd = new ArticlesDao();
        articles = cd.findArticlestype("post");
        label.setText("detail");
        for (Articles d : articles) {

            Blob blob = d.getImage_article();
            int blobLength = (int) blob.length();

            byte[] bytes = blob.getBytes(1, blobLength);
            ImageIcon image = new ImageIcon(bytes);
            label.setBounds(10, 10, 670, 250);
            Image im = image.getImage();
            Image myImg = im.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon newImage = new ImageIcon(myImg.getScaledInstance(150, 120, Image.SCALE_SMOOTH));
            label.setIcon(newImage);
            rows2.add(newImage);
            rows.add(d);

        }

    }

    @Override
    public Class getColumnClass(int column) {
        if (column == 3) {
            return ImageIcon.class;
        }

        return Object.class;
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return elements.length;
    }

    @Override
    public String getColumnName(int i) {
        return elements[i];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rows.get(rowIndex).getTexte_article();
            case 1:
                return rows.get(rowIndex).getTitre_article();
            case 2:
                return rows.get(rowIndex).getDate_article();
            case 3:
                return rows2.get(rowIndex);
            case 4:
                return "detail";
            default:
                return null;
        }
    }

}
