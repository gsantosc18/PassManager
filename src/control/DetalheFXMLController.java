/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import model.dao.ManagerDAO;
import model.entity.Manager;
import model.util.Notify;
import model.util.Scenario;

/**
 * FXML Controller class
 *
 * @author myhouse
 */
public class DetalheFXMLController implements Initializable {

    @FXML Label lbTitulo;
    @FXML Label lbUrl;
    @FXML Label lbUsuario;
    @FXML Label lbEmail;
    @FXML Label lbSenha;
    
    private Manager manager;

    public DetalheFXMLController() {
    }
    
    public DetalheFXMLController(Manager manager) {
        this.manager = manager;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.lbTitulo.setText(this.manager.getTitulo());
        this.lbUrl.setText(this.manager.getUrl());
        this.lbUsuario.setText(this.manager.getUsuario_1());
        this.lbEmail.setText(this.manager.getEmail());
        this.lbSenha.setText(this.manager.getSenha());
    }
    
    @FXML private void actionBack() throws IOException{
        Scenario.show("view/TableManagerFXML.fxml");
    }
    
    @FXML private void actionEditar(){
        
    }
    
    @FXML private void actionApagar() throws IOException{
        Optional<ButtonType> response = Notify.confirm("Você tem certeza que quer apagar?", "Apagar "+manager.getTitulo()+"?");
        
        if(response.get()==ButtonType.OK){
            ManagerDAO managerDAO = new ManagerDAO();
            managerDAO.delete(manager);
            Notify.info("O registro foi deletado com sucesso!");
            actionBack();
        }
    }
    
}
