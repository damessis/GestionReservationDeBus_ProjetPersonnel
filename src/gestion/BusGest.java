/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author IDA
 */
public class BusGest extends Application {
    
    
    private static final int COUNT_LIMIT = 10;
     
   
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root2; 
        root2 = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root2); 
        
         
        
        primaryStage.getIcons().add(new Image("/image/5.png"));
        primaryStage.setTitle("Bus-Gest");
        
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        
        
        

    }
    
    @Override
    public void init() throws Exception {       
        
        // Perform some heavy lifting (i.e. database start, check for application updates, etc. )
        for (int i = 1; i <= COUNT_LIMIT; i++) {
            double progress =(double) i/10;
            /*System.out.println("progress: " +  progress);*/            
            LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(progress));
            Thread.sleep(300);
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LauncherImpl.launchApplication(BusGest.class, MyLoader.class, args);
    }
    
}
