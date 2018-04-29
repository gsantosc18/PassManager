/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.dao.ManagerDAO;
import model.entity.Manager;
import model.util.Notify;
import model.util.Scenario;
import model.util.UsuarioCache;

/**
 * FXML Controller class
 *
 * @author myhouse
 */
public class CriarNovoFXMLController implements Initializable {

    @FXML JFXTextField lbTitulo;
    @FXML JFXTextField lbUsuario;
    @FXML JFXTextField lbEmail;
    @FXML JFXTextField lbSenha;
    @FXML JFXTextField lbUrl;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML private void actionDoCadastrarNovo() throws IOException{
        String titulo = this.lbTitulo.getText();
        String usuario = this.lbUsuario.getText();
        String email = this.lbEmail.getText();
        String senha = this.lbSenha.getText();
        String url = this.lbUrl.getText();

        if(UsuarioCache.isEmpty()){
            Notify.warning("É necessário estar logado coom um conta de usuário!");
        }else if(titulo.trim().isEmpty()||(usuario.trim().isEmpty()&&email.trim().isEmpty())||senha.trim().isEmpty()){
            Notify.warning("Preencha correntamente todos os campos!");
        }else{                
            Manager manager = new Manager();
            ManagerDAO managerDAO = new ManagerDAO();
            manager.setTitulo(titulo);
            manager.setUsuario_1(usuario);
            manager.setEmail(email);
            manager.setSenha(senha);
            manager.setUrl(url);
            manager.setUsuario(UsuarioCache.getUsuario());
            try{
                managerDAO.save(manager);
                
                Notify.info("Chave de acesso foi cadastrada com sucesso!");

                actionCancelar();
            }catch(Exception e){
                System.out.println("Erro: "+e.getMessage());
                Notify.erro("Houve um erro no cadastro da credencial!");
            }
        }
    }
    
    @FXML private void actionCancelar() throws IOException{
        Scenario.show("view/TableManagerFXML.fxml");
    }
    
}
