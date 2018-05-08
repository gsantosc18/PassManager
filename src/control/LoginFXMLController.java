/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.dao.UsuarioDAO;
import model.entity.Usuario;
import model.util.Notify;
import model.util.Overlay;
import model.util.Scenario;
import model.util.UsuarioCache;

/**
 * FXML Controller class
 *
 * @author myhouse
 */
public class LoginFXMLController implements Initializable {
    
    @FXML JFXTextField lbLogin;
    
    @FXML JFXPasswordField lbSenha;
    
    @FXML AnchorPane anchorPane;
    
    @FXML Pane wrap;
    
    @FXML Pane boxView;
    
    private Overlay overlay;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        try {
            overlay = new Overlay();            
            anchorPane.getChildren().add(overlay.getAnchorPane());
        } catch (IOException ex) {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    
    @FXML private void actionLogin() throws IOException{
        String login = this.lbLogin.getText();
        String senha = this.lbSenha.getText();
        
        overlay.show();

        if(login.trim().isEmpty()||senha.trim().isEmpty()){
            Notify.info("Preencha corretamente o Login e Senha");
        }else{
            new Thread(() -> {
                try {
                    UsuarioDAO usuarioDao = new UsuarioDAO();
                    Usuario usuario = usuarioDao.login(login, senha);
                    overlay.hide();
                    if(usuario!=null){
                            UsuarioCache.setUsuario(usuario);
                            Platform.runLater(()->{
                                try {
                                    Scenario.show("view/TableManagerFXML.fxml");
                                } catch (IOException ex) {
                                    System.out.println("Erro: "+ex.getMessage());
                                }
                            });
                    }else{
                        Platform.runLater(()->{Notify.warning("Algum coisa tá errado aí! :(");});
                    }
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }).start();
        }
    }
    
    @FXML private void actionCadastro() throws IOException{
        Scenario.show("view/CadastroFXML.fxml");
    }
}
