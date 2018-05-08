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
import model.dao.UsuarioDAO;
import model.entity.Usuario;
import model.util.EncryptMD5;
import model.util.Notify;
import model.util.Overlay;
import model.util.Scenario;

/**
 * FXML Controller class
 *
 * @author myhouse
 */
public class CadastroFXMLController implements Initializable {

    @FXML JFXTextField lbLogin;
    @FXML JFXPasswordField lbSenha;
    @FXML JFXPasswordField lbConfirmSenha;
    
    @FXML AnchorPane anchorPane;
    
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
    
    @FXML private void actionDoCadastro(){
        String login = lbLogin.getText();
        String senha = lbSenha.getText();
        String cSenha = lbConfirmSenha.getText();

        if(login.trim().isEmpty() || senha.trim().isEmpty() || cSenha.trim().isEmpty()){
            Notify.info("Preencha corretamente os campos!");
        }else
        if(!cSenha.equals(senha)){
            Notify.warning("As senhas não são iguais!");
        }else{
            overlay.show();
            new Thread(){
                @Override
                public void run() {
                    try {
                        UsuarioDAO usuarioDAO = new UsuarioDAO();
                        if(usuarioDAO.findByName(login)!=null){
                            Notify.warning("Este usuario já está sendo usado!");
                        }
                        else{
                            Usuario usuario = new Usuario();
                            usuario.setLogin(login);
                            usuario.setSenha(EncryptMD5.encrypt(senha));
                            usuarioDAO.insert(usuario);
                            Notify.info("Seu usuário foi criado com sucesso!");
                            actionBack();
                        }
                        overlay.hide();
                    } catch (NoSuchAlgorithmException ex) {
                        Notify.erro("Vixi... deu um erro!");                        
                    }
                }                    
            }.start();
        }
    }
    
    @FXML private void actionBack(){
        try {
            Scenario.show("view/LoginFXML.fxml");
        } catch (IOException ex) {
            Logger.getLogger(CadastroFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
