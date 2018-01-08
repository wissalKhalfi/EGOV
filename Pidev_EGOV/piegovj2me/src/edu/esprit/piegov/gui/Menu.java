///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package edu.esprit.piegov.gui;
//
//
////import crowdrisej2me.XMLMidlet;
//import edu.esprit.piegov.midlet.Midlet;
//import javax.microedition.lcdui.ChoiceGroup;
//
//import javax.microedition.lcdui.Command;
//import javax.microedition.lcdui.CommandListener;
//import javax.microedition.lcdui.Display;
//import javax.microedition.lcdui.Displayable;
//import javax.microedition.lcdui.Form;
//import javax.microedition.lcdui.List;
//
//
//public class Menu extends Form implements CommandListener{
//    ChoiceGroup l1=new ChoiceGroup("Menu", List.EXCLUSIVE);
//    Command cmdok = new Command("Suivant", Command.OK, 0);
//   
//    Display disp;
//    public Menu() {
//        super("Menu");
//       // disp=Midlet.INSTANCE.disp;
//        l1.append("Consulter", null); 
//        l1.append("Ajouter", null); 
//        l1.append("Localisation", null);
//        addCommand(cmdok);
//        append(l1);
//      //  disp.setCurrent(l1);
//        setCommandListener(this);
//      
//       
//    }
//
//   
//     
//       
//   
//
//    public void commandAction(Command c, Displayable d) {
//        if(l1.getSelectedIndex()==1){
//         if(c==cmdok){
//             
//             PasseportList f = new PasseportList();
//            Midlet.INSTANCE.disp.setCurrent(f);
//        }
//        }
//        else if(l1.getSelectedIndex()==2){
//            if(c==cmdok){
//               PasseportAdd f= new PasseportAdd();
//               Midlet.INSTANCE.disp.setCurrent(f);
//           
//            }
//        }
//        else
//        {
//             if(c==cmdok)
//             {
//        
//             PasseportList f = new PasseportList();
//            Midlet.INSTANCE.disp.setCurrent(f);
//            }
//        
//        }
//    }
//}
