/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpletexteditor.controllers;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author rtbfl
 */
public class HowtoFXMLController implements Initializable {
    Hyperlink link1 = new Hyperlink("Click Me!");
    
    @FXML
    private void linkToReadMe(ActionEvent event) throws IOException, URISyntaxException{
      
      if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
    Desktop.getDesktop().browse(new URI("https://github.com/rossfletcher19/simpleTextEditor/blob/master/README.md"));
        }
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
