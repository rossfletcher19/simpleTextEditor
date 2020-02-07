/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpletexteditor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JFileChooser;

/**
 *
 * @author rtbfl
 */
public class FXMLDocumentController implements Initializable {
    private Stage primaryStage;
    String opSystem = new String();
    String documentsPath = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
    @FXML public TextArea textArea;
    
    
    private void createOpeningFolder(){
        
        if (opSystem.contains("mac")) {
            Path path = Paths.get(documentsPath + "/Documents" + "/ssef");
            if (Files.exists(path)) {
                    // Do nothing
            } else {
            new File(documentsPath + "/Documents" + "/ssef").mkdir();
            }
        
        } else {
            Path path = Paths.get(documentsPath + "\\ssef");
            if (Files.exists(path)) {
                    // Do nothing
            } else {
            new File(documentsPath + "\\ssef").mkdir();
            }
        }
        
    }
    
    @FXML
    private void saveFile(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(primaryStage);

        if(file != null){

            Save(textArea.getText().replaceAll("\n", System.getProperty("line.separator")), file);
        } 
    }
    
    private void Save(String content, File file){
        try {
            FileWriter fileWriter;
            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class
                .getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void quitApp(ActionEvent event){
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String osName = System.getProperty("os.name").toLowerCase();
        this.opSystem = osName;
        System.out.println("Operating System: "   + this.opSystem);
        textArea.setWrapText(true);
        createOpeningFolder();
    }    
    
}
