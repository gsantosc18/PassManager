package model.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Notify {
    static private Alert alert = null;
    
    public static void erro(String message){
        if(alert==null){
            alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
        }
        
        alert.setAlertType(AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setContentText(message);
        alert.show();
    }
    
    public static void info(String message){
        if(alert==null){
            alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText(null);
        }
        
        alert.setAlertType(AlertType.INFORMATION);        
        alert.setTitle("Informação");
        alert.setContentText(message);
        alert.show();
    }
    
    public static void warning(String message){
        if(alert==null){
            alert = new Alert(AlertType.WARNING);
            alert.setHeaderText(null);
        }
        
        alert.setAlertType(AlertType.WARNING);
        alert.setTitle("Atenção");
        alert.setContentText(message);
        alert.show();
    }
}
