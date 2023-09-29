package com.banu.utility;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtility {



//    private static final SessionFactory SESSION;
//
//    static  {
//        try {
//            // SESSION = new Configuration().configure("c:\\config\\hibernate.cfg.xml").buildSessionFactory();
//            // CreateSessionFactory default olarak resources altında hibernate.cfg.xml i arar
//            SESSION = new Configuration().configure().buildSessionFactory();
//
//        }catch (Exception e){
//            System.out.println("Hibernate baslatilitken hata olustu : "+e);
//            throw  new ExceptionInInitializerError(e);
//        }
//
//    }
//    public static SessionFactory getSessionFactory(){
//        return SESSION;
//    }
private static final SessionFactory SESSION_FACTORY=sessionFactoryHibernate();

    private static SessionFactory sessionFactoryHibernate(){
        try {
            Configuration configuration = new Configuration();
            // hibernate.cfg.xml dosyasinda yaptigimiz mapping in farklı olusturma yontemi
            //configuration.addAnnotatedClass(User.class);
            SessionFactory session = configuration.configure().buildSessionFactory();
            return session;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;

    }
    public static SessionFactory getSessionFactory () {
        return SESSION_FACTORY;
    }


}
