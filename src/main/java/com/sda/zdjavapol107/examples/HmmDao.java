package com.sda.zdjavapol107.examples;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@AllArgsConstructor
public class HmmDao {
    private SessionFactory sessionFactory;

    public void save(String string){
        Session session = sessionFactory.openSession();
        session.save(string);
        session.close();
    }
}
