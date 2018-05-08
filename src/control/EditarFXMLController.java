/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import model.entity.Manager;

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
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbTitulo.setText(manager.getTitulo());
        lbUrl.setText(manager.getUrl());
        lbUsuario.setText(manager.getUsuario_1());
    }    

    @FXML
    private void actionAtualizar(ActionEvent event) {
    }

    @FXML
    private void actionCancelar(ActionEvent event) {
    }
    
}
