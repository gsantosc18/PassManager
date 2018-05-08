/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.util;

import com.jfoenix.controls.JFXButton;
import control.DetalheFXMLController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import model.dao.ManagerDAO;
import model.entity.Manager;

public class ListView {
    private int ID;
    private String titulo;
    private String data_criacao;
    private Button detalhes;

    public ListView(int ID, String titulo, String data_criacao) {
        this.ID = ID;
        this.titulo = titulo;
        this.data_criacao = data_criacao;
        
        this.detalhes = new JFXButton("Detalhes");
        detalhes.setStyle("-fx-background-color: blue;-fx-text-fill: #FFFFFF;");
        
        this.detalhes.setOnAction((ActionEvent event) -> {
            Platform.runLater(()->{
                Manager manager = new ManagerDAO().findById(getID());
                Scenario.show("view/DetalheFXML.fxml", new DetalheFXMLController(manager));
            });
        });
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the data_criacao
     */
    public String getData_criacao() {
        return data_criacao;
    }

    /**
     * @param data_criacao the data_criacao to set
     */
    public void setData_criacao(String data_criacao) {
        this.data_criacao = data_criacao;
    }

    /**
     * @return the detalhes
     */
    public Button getDetalhes() {
        return detalhes;
    }

    /**
     * @param detalhes the detalhes to set
     */
    public void setDetalhes(Button detalhes) {
        this.detalhes = detalhes;
    }
}
