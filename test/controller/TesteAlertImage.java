/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import javafx.application.Application;
import javafx.stage.Stage;
import model.util.Scenario;

/**
 *
 * @author myhouse
 */
public class TesteAlertImage extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try{
            Scenario.setStage(primaryStage);
            Scenario.show("view/LoginFXML.fxml");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
//        launch(args);
        URL location = TesteAlertImage.class.getClassLoader().getResource("./");
        System.out.println(location);
    }
}
