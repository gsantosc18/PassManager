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
import javafx.fxml.Initializable;
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    
    @FXML private void actionLogin() throws IOException{
        try{
            String login = this.lbLogin.getText();
            String senha = this.lbSenha.getText();
            
            if(login.trim().isEmpty()||senha.trim().isEmpty()){
                Notify.info("Preencha corretamente o Login e Senha");
            }else{
                UsuarioDAO usuarioDao = new UsuarioDAO();
                Usuario usuario = usuarioDao.login(login, senha);

                if(usuario!=null){                
                    Notify.info("Seu login foi realizado com sucesso!");
                    UsuarioCache.setUsuario(usuario);
                    Scenario.show("view/TableManagerFXML.fxml");
                }else{
                    Notify.warning("Algum coisa tá errado aí oh! :(");
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Notify.erro("Houve um erro no login, mas fica de boa e tenta mais uma vez!");
        }
    }
    
    
    @FXML private void actionCadastro() throws IOException{
        Scenario.show("view/CadastroFXML.fxml");
    }
}
