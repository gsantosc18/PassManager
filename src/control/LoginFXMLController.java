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
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.dao.UsuarioDAO;
import model.entity.Usuario;
import model.util.Notify;
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
    
    @FXML Pane waitePane;
    
    @FXML Pane boxView;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hideWaite();
    }    
    
    
    @FXML private void actionLogin() throws IOException{
        String login = this.lbLogin.getText();
        String senha = this.lbSenha.getText();
        
        showWaite();

        if(login.trim().isEmpty()||senha.trim().isEmpty()){
            Notify.info("Preencha corretamente o Login e Senha");
        }else{
            new Thread(() -> {
                UsuarioDAO usuarioDao = new UsuarioDAO();
                Usuario usuario = usuarioDao.login(login, senha);
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
                hideWaite();
            }).start();
        }
    }
    
    private void showWaite(){
        waitePane.setVisible(true);
    }
    
    private void hideWaite(){
        waitePane.setVisible(false);
    }
    
    @FXML private void actionCadastro() throws IOException{
        Scenario.show("view/CadastroFXML.fxml");
    }
}
