package com.sda.zdjavapol107.szubienica.service;

import com.sda.zdjavapol107.HibernateFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SessionFactoryService {

    private static HibernateFactory hibernateFactory = new HibernateFactory();

    public static SessionFactory getSessionFactory () {

        return hibernateFactory.getSessionFactory();
    }
}
