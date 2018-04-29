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
import model.util.RelativeLocation;
import model.util.Scenario;

/**
 *
 * @author myhouse
 */
public class Principal extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(RelativeLocation.location("view/WaiteFXML.fxml"));
        Scene scenario = new Scene(root);
        scenario.lookup("#Tela");
        try{
            Scenario.setStage(primaryStage);
            Scenario.show("view/LoginFXML.fxml");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
