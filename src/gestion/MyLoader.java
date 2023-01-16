/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import static gestion.FXMLDocumentController.chargementMessage;
import javafx.application.Preloader;
import static javafx.application.Preloader.StateChangeNotification.Type.BEFORE_START;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author IDA
 */
public class MyLoader extends Preloader {

    private Stage preloaderStage;
    private Scene scene;
    
    public MyLoader() {
        
    }

    @Override
    public void init() throws Exception {               
                                         
    Parent root1 = FXMLLoader.load(getClass().getResource("loader.fxml")); 
    scene = new Scene(root1); 
    
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
       this.preloaderStage = primaryStage;

    
        preloaderStage.setScene(scene);  
        preloaderStage.show();
        
        
      
    }
    
   

    @Override
    public void handleStateChangeNotification(Preloader.StateChangeNotification info) {
      
        StateChangeNotification.Type type = info.getType();
        switch (type) {
            
            case BEFORE_START:
                // appelé après initialisation de MyApplication et avant le demarrage de MyApplication...
                /*System.out.println("BEFORE_START");*/
                preloaderStage.close();
                break;
        }
        
        
    }
    
}
