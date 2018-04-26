/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
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
        try{
//            ZipFile zipfile = new ZipFile(System.getProperty("java.class.path"));
            
//            ZipEntry inputStream = zipfile.getEntry("view/LoginFXML.fxml");
//            
//            URL location = ClassLoader.getSystemResource(inputStream.getName());
//            
//            Parent root = FXMLLoader.load(location);
//            Scene scene = new Scene(root);
//
//            primaryStage.setScene(scene);

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
