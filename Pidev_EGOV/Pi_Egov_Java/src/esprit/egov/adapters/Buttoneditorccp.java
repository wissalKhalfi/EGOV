/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.adapters;

import esprit.egov.gui.SupprimerCcp;
import esprit.egov.dao.classes.CcpDao;
import esprit.egov.entities.Ccp;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author USER
 */
public class Buttoneditorccp extends DefaultCellEditor {
    

    protected JButton btn;
    private String lbl;
    private Boolean clicked;

    public Buttoneditorccp (JTextField txt) {
        super(txt);
        
        btn = new JButton();
        btn.setOpaque(true);

        //WHEN BUTTON IS CLICKED
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object obj,
            boolean selected, int row, int col) {

        //SET TEXT TO BUTTON,SET CLICKED TO TRUE,THEN RETURN THE BTN OBJECT
        lbl = (obj == null) ? "" : obj.toString();
        btn.setText(lbl);
        clicked = true;
        return btn;
    }

    //IF BUTTON CELL VALUE CHNAGES,IF CLICKED THAT IS
    @Override
    public Object getCellEditorValue() {

        if (clicked) {
            
       
        CcpDao cd = new CcpDao();
        Ccp carte = new Ccp();
        int m = Integer.parseInt(SupprimerCcp.getjTextField2().getText());
       carte = cd.findCcp(m);
       cd.removeCcp(carte);
	JOptionPane.showMessageDialog(btn, "Le comtpt a été supprimée");
        }
        clicked = false;
        return new String(lbl);
    }

    @Override
    public boolean stopCellEditing() {

        //SET CLICKED TO FALSE FIRST
        clicked = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        // TODO Auto-generated method stub
        super.fireEditingStopped();
    }
}

