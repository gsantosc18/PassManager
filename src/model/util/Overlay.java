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
import javafx.scene.layout.AnchorPane;

public class Overlay {
    
    private final URL location = RelativeLocation.location("view/WaiteFXML.fxml");
    private final AnchorPane anchorOverlayer;
    
    public Overlay() throws IOException{
        Parent root = FXMLLoader.load(location);
        anchorOverlayer = (AnchorPane) root.lookup("#anchorOverlayer");
        hide();
    }
    
    public AnchorPane getAnchorPane(){
        return anchorOverlayer;
    }
    
    public void show(){
        anchorOverlayer.setVisible(true);
    }
    
    public void hide(){
        anchorOverlayer.setVisible(false);
    }
}
