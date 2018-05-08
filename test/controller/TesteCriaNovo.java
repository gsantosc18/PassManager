/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.security.NoSuchAlgorithmException;
import model.dao.ManagerDAO;
import model.dao.UsuarioDAO;
import model.entity.Manager;
import model.entity.Usuario;

/**
 *
 * @author myhouse
 */
public class TesteCriaNovo {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.login("gsantosc18", "123456789");
        
        Manager manager = new Manager();
        ManagerDAO managerDAO = new ManagerDAO();
        
        String texto = "Teste 1231231231231231";
        
        manager.setTitulo(texto);
        manager.setUsuario_1(texto);
        manager.setEmail(texto);
        manager.setSenha(texto);
        manager.setUrl(texto);
        
        manager.setUsuario(usuario);
        
        managerDAO.save(manager);
        
        System.out.println(usuario.getLogin());
    }
}
