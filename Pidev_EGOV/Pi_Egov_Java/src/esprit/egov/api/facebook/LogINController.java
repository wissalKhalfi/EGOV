package esprit.egov.api.facebook;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.types.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.swing.text.html.HTMLEditorKit;

public class LogINController implements Initializable{

    @FXML
    private WebView webview;

    
  public static String APP_ID = "682169445258647";
  public static String APP_SECRET = "be8491b62a43d404024a2b8e649c5e6d";

  final String fb_url ="https://www.facebook.com/dialog/oauth?" +
                      "client_id="+APP_ID
                      +"&redirect_uri=https://www.facebook.com/connect/login_success.html" +
                      "&client_secret="
                      +APP_SECRET+"&response_type=token";
  
  
  public static String access_token = "2c6ab004ab8b2be702f6e2514c294c79";
  
  
  
  //////////
  
  
  /////////

  

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        
        WebEngine webengine=webview.getEngine();
        
         webengine.load(fb_url);
       
         webengine.getLoadWorker().stateProperty().addListener(
        new ChangeListener<State>() {
            public void changed(ObservableValue ov, State oldState, State newState) {
                if (newState == State.SUCCEEDED) {
                    
                    
                    if(webengine.getLocation().substring(0, 51).equals("https://www.facebook.com/connect/login_success.html"))
                    {
                        System.out.println("c bon connecte ! ");
                        
                        //////////////////////////////////nodkhlou lel application 
//                        
//
                          String string = new String(webengine.getLocation());
                     //     System.out.println(string);
                         String[] temp1 = string.split("&");
                         String[] temp2 = temp1[0].split("=");
                
                        access_token=temp2[1];
                        
                 //       System.out.println(access_token);
                        
                        FacebookClient fbClient=new DefaultFacebookClient(access_token);

                         User me=fbClient.fetchObject("me",User.class);
//         
                         System.out.println(me.getName());
                         
                         System.out.println(me.getId());
                         
                        FXMLDocumentController.isFBConnected=true;
                        
                        /////////
                        
                        
                        
                        
                        
                        
                        ////////////////////////////////
                        
                    }
                }
            }
        });



    }


    @FXML
    void close(ActionEvent event) throws IOException {
        
        if(FXMLDocumentController.isFBConnected)
        {        
        
        Parent homePage = FXMLLoader.load(getClass().getResource("GUIAPPLICATION.fxml"));
        
        Scene homePage_scene=new Scene(homePage);
        
        Stage app_stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        
        app_stage.setScene(homePage_scene);
            
        }
        
        else
        {
     
        Parent homePage = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene homePage_scene=new Scene(homePage);
        
        Stage app_stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        
        app_stage.setScene(homePage_scene);
        }

        
    }
  
    


}
