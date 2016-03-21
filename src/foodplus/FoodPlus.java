/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodplus;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Packie
 */
public class FoodPlus extends Application {
    
    @Override
    public void start(Stage stage)  {
        try {
            
            Properties settings = new Properties();
            settings.load(new FileInputStream("src/etc/settings.properties"));
            String language=settings.getProperty("lang.lang");
            String country=settings.getProperty("lang.country");
            
            Locale locale;
            if(language == null || country == null){
                locale=Locale.ENGLISH;
            }else{
             locale = new Locale(language,country);
            }
           
            ResourceBundle resources = ResourceBundle.getBundle("etc.language",locale);
            
            Parent root = FXMLLoader.load(getClass().getResource("FoodPLus.fxml"),resources);
            
            
            
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.setTitle("Food+");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FoodPlus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
