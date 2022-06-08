package com.sda.zdjavapol107;

import com.sda.zdjavapol107.statki.model.*;
import com.sda.zdjavapol107.szubienica.repository.model.HangmanGame;
import com.sda.zdjavapol107.szubienica.repository.model.HangmanSlogan;
import com.sda.zdjavapol107.szubienica.repository.model.HangmanUser;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {
    private org.hibernate.cfg.Configuration getHibernateConfig() {
        org.hibernate.cfg.Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.url", "jdbc:hsqldb:file:db-data/mydatabase;hsqldb.write_delay_millis=0");
        configuration.setProperty("hibernate.connection.username", "admin123");
        configuration.setProperty("hibernate.connection.password", "admin123");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbc.JDBCDriver");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
//		configuration.setProperty("hibernate.show_sql", "true");

        configuration.addAnnotatedClass(HangmanSlogan.class);
        configuration.addAnnotatedClass(HangmanUser.class);
        configuration.addAnnotatedClass(HangmanGame.class);

        configuration.addAnnotatedClass(UserShipsGame.class);
        configuration.addAnnotatedClass(BoardShipsGame.class);
        configuration.addAnnotatedClass(ShipShipsGame.class);
        configuration.addAnnotatedClass(PointShipsGame.class);
        configuration.addAnnotatedClass(GameHistoryShips.class);

        return configuration;
    }

    //to można wygooglować!
    public SessionFactory getSessionFactory() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(getHibernateConfig().getProperties()).build();
        SessionFactory sessionFactory = getHibernateConfig().buildSessionFactory(registry);
        return sessionFactory;
    }
}
