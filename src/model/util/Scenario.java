/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.util;

import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
    
    public static Scene getScene(){
        return scenario.getScene();
    }
       
    public static void show() throws IOException{
        Scene scena = scenario.getScene();
        scenario.sizeToScene();
        scenario.minWidthProperty().bind(scena.widthProperty());
        scenario.minHeightProperty().bind(scena.heightProperty());
        scenario.show();
        scenario.requestFocus();
        scenario.getIcons().add(new Image(Scenario.class.getClass().getResourceAsStream("/image/iconKey.png")));
    }
    
    public static void show(String file) throws IOException{
            Parent root = FXMLLoader.load(RelativeLocation.location(file));
            Scene scene = new Scene(root);        
            scenario.setScene(scene);
            show();
    }
    
    public static void show(URL file) throws IOException{
            Parent root = FXMLLoader.load(file);
            Scene scene = new Scene(root);        
            scenario.setScene(scene);
            show();
    }
    
    public static void show(String file, Object controller){
        try {          
            FXMLLoader loader = new FXMLLoader(RelativeLocation.location(file));
            loader.setController(controller);
            Parent root = loader.load();
            Scene scene = new Scene(root);        
            scenario.setScene(scene);
            show();
        } catch (Exception ex) {
            System.out.println("Erro: "+ex.getMessage());
        }
    }
    
    public static void show(URL file, Object controller){
        try {          
            FXMLLoader loader = new FXMLLoader(file);
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
