/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.security.NoSuchAlgorithmException;
import model.entity.Usuario;
import model.util.EncryptMD5;
import model.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioDAO {
        
    public Usuario login(String email, String senha) throws NoSuchAlgorithmException{
        Usuario usuario = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();       
        
        usuario = (Usuario) session.createQuery("From Usuario where login = ? and senha = ?")
        .setParameter(0, email)
        .setParameter(1, EncryptMD5.encrypt(senha))
        .uniqueResult();
        transaction.commit();
        
        return usuario;
    }
    
    public void insert(Usuario usuario) throws NoSuchAlgorithmException{
        Session session;
        Transaction transaction;
        
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();  
        
        usuario.setSenha(EncryptMD5.encrypt(usuario.getSenha()));
        
        session.save(usuario);
        transaction.commit();
    }
}