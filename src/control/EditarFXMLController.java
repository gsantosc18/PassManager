/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javax.crypto.NoSuchPaddingException;
import model.dao.ManagerDAO;
import model.entity.Manager;
import model.util.HashCode;
import model.util.Notify;
import model.util.Scenario;

/**
 * FXML Controller class
 *
 * @author myhouse
 */
public class EditarFXMLController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private JFXTextField lbTitulo;
    @FXML
    private JFXTextField lbUrl;
    @FXML
    private JFXTextField lbUsuario;
    @FXML
    private JFXTextField lbEmail;
    @FXML
    private JFXTextField lbSenha;
    
    private Manager manager;
    
    public EditarFXMLController(Manager manager){
        this.manager = manager;
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbTitulo.setText(manager.getTitulo());
        lbUrl.setText(manager.getUrl());
        lbUsuario.setText(manager.getUsuario_1());
        lbEmail.setText(manager.getEmail());
        try {
            lbSenha.setText(new HashCode().decodifica(manager.getSenha()));
        } catch (NoSuchAlgorithmException | NoSuchProviderException | NoSuchPaddingException | UnsupportedEncodingException ex) {
            Logger.getLogger(EditarFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(EditarFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void actionAtualizar(ActionEvent event) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, UnsupportedEncodingException, Exception {
        ManagerDAO managerDAO = new ManagerDAO();
        
        manager.setTitulo(lbTitulo.getText());
        manager.setUsuario_1(lbUsuario.getText());
        manager.setEmail(lbEmail.getText());
        manager.setSenha(new HashCode().codifica(lbSenha.getText()));
        manager.setUrl(lbUrl.getText());
        
        managerDAO.update(manager);
        
        Notify.info("Sua alteração foi realizada com sucesso!");
        
        Scenario.show(EditarFXMLController.class.getClass().getResource("/view/DetalheFXML.fxml"), new DetalheFXMLController(managerDAO.findById(manager.getIdManager())),event);
    }

    @FXML
    private void actionCancelar(ActionEvent event) throws IOException {
        Scenario.show(EditarFXMLController.class.getClass().getResource("/view/TableManagerFXML.fxml"),event);
    }
    
}
