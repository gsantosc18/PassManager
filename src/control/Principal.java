/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javafx.application.Application;
import javafx.stage.Stage;
import model.util.Scenario;

/**
 *
 * @author myhouse
 */
public class Principal extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scenario.setStage(primaryStage);
        Scenario.show(Principal.class.getClass().getResource("/view/LoginFXML.fxml"));
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
