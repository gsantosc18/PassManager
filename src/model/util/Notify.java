package model.util;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Notify {
    static private Alert alert = null;
    
    public static void erro(String message){
        alert(AlertType.ERROR, message, "Erro");
    }
    
    public static void info(String message){
        alert(AlertType.INFORMATION, message, "Informação");
    }
    
    public static void warning(String message){
        alert(AlertType.CONFIRMATION, message, "Atenção");
    }
    
    public static Optional<ButtonType> confirm(String message, String header){
        return alert(AlertType.CONFIRMATION, message, header);
    }
    
    private static Optional<ButtonType> alert(AlertType type, String message, String title){
        alert = new Alert(type);
        alert.setHeaderText(null);        
        alert.setTitle(title);
        alert.setContentText(message);
        return alert.showAndWait();
    }
}
