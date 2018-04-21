/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.entity.Usuario;
import model.util.HibernateUtil;
import org.hibernate.Session;

public class UsuarioDAO {
    
    private Session session;
    
    public UsuarioDAO(){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public Usuario login(String email, String senha){        
        try{
            session.beginTransaction();        
        Usuario usuario = (Usuario) session.createQuery("From Usuario where login = ? and senha = ?")
            .setParameter(0, email)
            .setParameter(1, senha)
            .uniqueResult();
            session.getTransaction().commit();
            
            return usuario;
            
        }catch(Exception e){
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public void insert(Usuario usuario){
        try{
            session.beginTransaction();
            session.save(usuario);
            session.getTransaction().commit();  
        }catch(Exception e){
            session.getTransaction().rollback();
        }
    }
}
