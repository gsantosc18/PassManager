/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.util;

import java.io.IOException;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author myhouse
 */
public class Scenario {
    private static Stage scenario;
    
    private Scenario(){}
    
    public static void setScene(Scene sena){
        scenario.setScene(sena);
    }
    
    public static void setStage(Stage stage){
        scenario =  stage;
    }
       
    public static void show(){        
        Scene scena = scenario.getScene();
        scenario.sizeToScene();
        scenario.minWidthProperty().bind(scena.widthProperty());
        scenario.minHeightProperty().bind(scena.heightProperty());
        scenario.show();
    }
    
    public static void show(String file){          
        try {
            ZipFile zipfile = new ZipFile(System.getProperty("java.class.path"));
            ZipEntry entry = zipfile.getEntry(file);            
            URL location = ClassLoader.getSystemResource(entry.getName());        
            Parent root = FXMLLoader.load(location);
            Scene scene = new Scene(root);        
            scenario.setScene(scene);
            show();
        } catch (IOException ex) {
            System.out.println("Erro: "+ex.getMessage());
        }
    }
    
    public static void show(String file, Object controller){
        try {
            ZipFile zipfile = new ZipFile(System.getProperty("java.class.path"));            
            ZipEntry entry = zipfile.getEntry(file);            
            URL location = ClassLoader.getSystemResource(entry.getName());            
            FXMLLoader loader = new FXMLLoader(location);
            loader.setController(controller);
            Parent root = loader.load();
            Scene scene = new Scene(root);        
            scenario.setScene(scene);
            show();
        } catch (Exception ex) {
            System.out.println("Erro: "+ex.getMessage());
        }
    }
}
