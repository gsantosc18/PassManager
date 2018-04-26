/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.entity.Usuario;
import model.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioDAO {
    
    private Session session;
    private Transaction transaction;
    
    public Usuario login(String email, String senha){
        Usuario usuario = null;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = null;
        try{
            transaction = session.beginTransaction();       
            usuario = (Usuario) session.createQuery("From Usuario where login = ? and senha = ?")
            .setParameter(0, email)
            .setParameter(1, senha)
            .uniqueResult();
            transaction.commit();
        }catch(Exception ex){
            if(transaction!=null){
                transaction.rollback();
            }
        }
        
        return usuario;
    }
    
    public void insert(Usuario usuario){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = null;
        try{
            transaction = session.beginTransaction();
            session.save(usuario);
            transaction.commit();
        }catch(Exception ex){
            if(transaction!=null){
                transaction.rollback();
            }
        }
    }
}
