/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.adapters;


import esprit.egov.gui.Detailarticle;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ButtondetailEditor extends DefaultCellEditor {

    protected JButton btn;
    private String lbl;
    private Boolean clicked;

    public ButtondetailEditor(JTextField txt) {
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

        clicked = true;

        return btn;
    }

    //IF BUTTON CELL VALUE CHNAGES,IF CLICKED THAT IS
    @Override
    public Object getCellEditorValue() {

        if (clicked) {
     Detailarticle rech=new Detailarticle();
     
     rech.setVisible(true);   
    
        }
        clicked = false;
        return lbl;
    }

}
