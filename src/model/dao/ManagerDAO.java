/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.entity.Manager;
import model.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ManagerDAO {
    
    public List<Manager> listaByIdUsuario(int id_usuario){
        List<Manager> lista = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        lista =  session
                .createQuery("from Manager where id_usuario = ?")
                .setParameter(0, id_usuario)
                .list();
        transaction.commit();
        
        return lista;
    }
    
    public void save(Manager manager){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();;
        Transaction transaction = session.beginTransaction();  
        
        session.save(manager);
        transaction.commit();
    }
    
    public Manager findById(int id){
        Manager manager = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();  
        
        manager = (Manager) session.get(Manager.class,id);
        transaction.commit();
        
        return manager;
    }
}
