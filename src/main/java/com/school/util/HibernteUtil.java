package com.school.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernteUtil {
    private static  HibernteUtil instance = new HibernteUtil();
    private SessionFactory sessionFactory;
    public static HibernteUtil getInstance(){

        return instance;
    }
    private HibernteUtil(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernet.cfg.xml");
        sessionFactory=configuration.buildSessionFactory();

            }
            public static Session getSession(){
        Session
                session=getInstance().sessionFactory.openSession();
        return session;
        }

    }

