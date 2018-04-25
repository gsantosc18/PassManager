/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.entity.Manager;
import model.util.HibernateUtil;
import org.hibernate.Session;

public class ManagerDAO {

    private Session session;

    public ManagerDAO() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Manager> listaByIdUsuario(int id_usuario){
        session.beginTransaction();
        
        List<Manager> lista =  (List<Manager>) session
                .createQuery("from Manager where id_usuario = ?")
                .setParameter(0, id_usuario)
                .list();
        
        session.getTransaction().commit();
        
        return lista;
    }
    
    public void save(Manager manager){
        try{
            session.beginTransaction();
            session.save(manager);        
            session.getTransaction().commit();
        }catch(Exception e){
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }
    }
    
    public Manager findById(int id){
        session.beginTransaction();
        Manager manager = (Manager) session.get(Manager.class,id);
        session.getTransaction().commit();
        return manager;
    }
    
}
