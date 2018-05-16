/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.dao.ManagerDAO;
import model.entity.Manager;
import model.entity.Usuario;
import model.util.ListView;
import model.util.Overlay;
import model.util.Scenario;
import model.util.UsuarioCache;

/**
 * FXML Controller class
 *
 * @author myhouse
 */
public class TableManagerFXMLController implements Initializable {

    @FXML private TableView<ListView> tableLista;
    
    @FXML private AnchorPane anchorPane;
    @FXML private ScrollPane scrollPane;
    
    private Overlay overlay;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            overlay = new Overlay();
            anchorPane.getChildren().add(overlay.getAnchorPane());
        } catch (IOException ex) {
            Logger.getLogger(TableManagerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        anchorPane.prefWidthProperty().bind(scrollPane.widthProperty());
        
        TableColumn<ListView, String> id = new TableColumn<>("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        id.setPrefWidth(40);
        id.setMaxWidth(40);
        id.setMinWidth(40);
        id.setResizable(false);
        
        TableColumn<ListView, String> titulo = new TableColumn<>("Título");
        titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        titulo.setMinWidth(355);
        
        TableColumn<ListView, String> cadastro = new TableColumn<>("Cadastro");
        cadastro.setCellValueFactory(new PropertyValueFactory<>("data_criacao"));
        cadastro.setPrefWidth(150);
        cadastro.setMaxWidth(150);
        cadastro.setMinWidth(150);
        cadastro.setResizable(false);
        
        TableColumn<ListView, Button> control = new TableColumn<>("Controles");
        control.setCellValueFactory(new PropertyValueFactory<>("detalhes"));
        control.setPrefWidth(100);
        control.setMaxWidth(100);
        control.setMinWidth(100);
        control.setResizable(false);
        
        this.tableLista.getColumns().addAll(id,titulo, cadastro, control);
        
        if(!UsuarioCache.isEmpty()){
            ObservableList<ListView> lista = FXCollections.observableArrayList();
            new Thread(){
                @Override
                public void run(){
                    Platform.runLater(()->{            
                        ManagerDAO managerDAO = new ManagerDAO();
                        Usuario usuario = UsuarioCache.getUsuario();
                        List<Manager> listaManager = managerDAO.listaByIdUsuario(usuario.getIdUsuario());

                        for(Manager manager : listaManager){            
                            try {
                                ListView listViewManager;
                                SimpleDateFormat formatDateOUT;
                                SimpleDateFormat formatDateIN;
                                String dataStr;

                                formatDateOUT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                                formatDateIN = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                                dataStr = formatDateOUT.format(formatDateIN.parse(manager.getCadastro().toString()));

                                listViewManager = new ListView(manager.getIdManager(), manager.getTitulo(),dataStr);
                                lista.add(listViewManager);
                            } catch (ParseException ex) {
                                Logger.getLogger(TableManagerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                            }            
                        }

                        tableLista.setItems(lista); 
                    }); 
                }
            }.start();      
        }else{
            System.out.println("O usuário guardado no cache está vazio!");
        }
    }
    
    @FXML private void actionCriarNovo() throws IOException{
        overlay.show();
        Scenario.show(TableManagerFXMLController.class.getClass().getResource("/view/CriarNovoFXML.fxml"));
    }
    
    @FXML private void actionClose() throws IOException{
        overlay.show();
        Scenario.show(TableManagerFXMLController.class.getClass().getResource("/view/LoginFXML.fxml"));
    }
    
}
