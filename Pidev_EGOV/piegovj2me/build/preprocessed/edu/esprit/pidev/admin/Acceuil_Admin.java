package edu.esprit.pidev.admin;



import edu.esprit.pidev.actualite.ListeActualite;
import edu.esprit.pidev.ccp.ListeCompte;
import edu.esprit.pidev.universite.ListeUniversite;
import edu.esprit.piegov.Passeport.Menu;
import edu.esprit.piegov.Passeport.PasseportList;
import edu.esprit.piegov.carteedinar.ListeCartes;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextField;


public class Acceuil_Admin extends List implements CommandListener,Runnable{

     private String [] selection = {"Carte Edinar","Compte courant postal","universite","Actualité","Passeport"};
    TextField CritereTF = new TextField("Admin:", null, 1000, TextField.ANY);
   
    Command backCmd = new Command("Retour", Command.EXIT, 0);

    Thread t;
    
    int id;
    String critere="";
    boolean modifyFlag=false;
    
    public Acceuil_Admin(){
        super("Admin", IMPLICIT);
        
        addCommand(backCmd);

        
        
        setCommandListener(this);
        t = new Thread(this);
        t.start();
    }
    


    
    

   
    public void run() 
    {
        
        if (selection != null)
        {
            for (int i = 0; i < selection.length; i++) {
                append(selection[i], null);
//              append(critere, null);
            }
        }
        closeThread();
    }
    
    private void closeThread()
    {
        t.interrupt();
    }
    
     public void commandAction(Command c, Displayable d) 
    {
        if (List.SELECT_COMMAND == c)
        {
            String cmd =selection[this.getSelectedIndex()];
                     if (cmd.equals("Carte Edinar"))
                         {
                           utils.StaticMidlet.disp.setCurrent(new ListeCartes() );
                           System.out.println(selection[this.getSelectedIndex()]);
                         }
                     if (cmd.equals("Compte courant postal"))
                         {
                            utils.StaticMidlet.disp.setCurrent(new ListeCompte() );
                            System.out.println(selection[this.getSelectedIndex()]);
                        }
                     if (cmd.equals("universite"))
                         {
                            utils.StaticMidlet.disp.setCurrent(new ListeUniversite() );
                            System.out.println(selection[this.getSelectedIndex()]);
                        }
                       if (cmd.equals("Actualité"))
                         {
                            utils.StaticMidlet.disp.setCurrent(new ListeActualite() );
                            System.out.println(selection[this.getSelectedIndex()]);
                        }
                       if (cmd.equals("Passeport"))
                         {
                            utils.StaticMidlet.disp.setCurrent(new Menu() );
                            System.out.println(selection[this.getSelectedIndex()]);
                        }
                       
        }

        
        
       
    }
}
