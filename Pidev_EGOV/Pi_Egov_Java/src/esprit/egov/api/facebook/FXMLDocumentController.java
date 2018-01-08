package esprit.egov.api.facebook;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.web.PopupFeatures;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;
import javafx.util.Callback;

public class FXMLDocumentController implements Initializable{
    
    public static boolean isFBConnected=false;

    @FXML
    private Label label;

    @FXML
    void connectfb(ActionEvent event) throws IOException {
        
        Parent homePage = FXMLLoader.load(getClass().getResource("FXML_LogIN.fxml"));
        
        Scene homePage_scene=new Scene(homePage);
        
        Stage app_stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        
        app_stage.setScene(homePage_scene);
        
      

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    
    }

}
