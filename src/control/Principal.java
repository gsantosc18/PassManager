/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.util.Scenario;

/**
 *
 * @author myhouse
 */
public class Principal extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("../view/LoginFXML.fxml"));
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        
        Scenario.setStage(primaryStage);
        
        Scenario.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
