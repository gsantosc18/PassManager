/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.util;

import java.io.IOException;
import java.net.URL;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

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
        scenario.setOnCloseRequest(new EventHandler<WindowEvent>(){
            @Override
            public void handle(WindowEvent event) {
                HibernateUtil.getSessionFactory().close();
            }
        });
        
        scenario.show();
    }
    
    public static void show(URL location) throws IOException{
            Parent root = FXMLLoader.load(location);
            Scene scene = new Scene(root);        
            scenario.setScene(scene);

            show();
    }
    
    public static void show(URL location, Object controller) throws IOException{
            FXMLLoader loader = new FXMLLoader(location);
            loader.setController(controller);
            Parent root = loader.load();
            Scene scene = new Scene(root);        
            scenario.setScene(scene);
            show();
    }
}
