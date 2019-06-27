package hardwaremanagement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.AnnotationConfiguration;
//import org.hibernate.cfg.AnnotationConfiguration;ku 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Shashiprabha-PC
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
     public static HibernateUtil instance = null;
    private static StandardServiceRegistry registry;
    static Session session;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
            
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
     public static HibernateUtil getInstance() {
        if (instance == null) {
            instance = new HibernateUtil();
        }

        return instance;
    }
     
     
     public Session openWritebleDbConnection() {
        if (session == null || !session.isOpen()) {
            session = getSessionFactory().openSession();
        }
        session.beginTransaction();
        return this.session;
    }
    public void closeWritebleDbConnection(Session session) {
        session.getTransaction().commit();
        session.close();
    }

    public Session openReadableDbConnection() {
        if (session == null || !session.isOpen()) {
            session = getSessionFactory().openSession();
        }
        return this.session;
    }

    public void closeReadableDbConnection(Session session) {
        //if(session.isOpen()){
        session.close();
        //}

    }
    
    
    
}
