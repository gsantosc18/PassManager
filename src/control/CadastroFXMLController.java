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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import model.dao.UsuarioDAO;
import model.entity.Usuario;
import model.util.Notify;
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML private void actionDoCadastro(){
        try{
            String login = lbLogin.getText();
            String senha = lbSenha.getText();
            String cSenha = lbConfirmSenha.getText();
            if(login.trim().isEmpty() || senha.trim().isEmpty() || cSenha.trim().isEmpty()){
                Notify.info("Preencha corretamente os campos!");
            }
            if(!cSenha.equals(senha)){
                Notify.warning("As senhas não são iguais!");
            }
            else{
                Usuario usuario = new Usuario();
                
                usuario.setLogin(login);
                usuario.setSenha(senha);
                
                new UsuarioDAO().insert(usuario);
                
                Notify.info("Seu usuário foi criado com sucesso!");
                
                actionBack();
            }
        }
        catch(Exception e){
            Notify.erro("Vixi... deu um erro!");
        }
    }
    
    @FXML private void actionBack() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../view/LoginFXML.fxml"));
        
        Scene sena = new Scene(root);
        
        Scenario.setScene(sena);
    }
}
