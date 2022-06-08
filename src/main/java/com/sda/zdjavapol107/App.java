package com.sda.zdjavapol107;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;


@Log4j2
public class App {
//    private static final Logger log = org.apache.logging.log4j.LogManager.getLogger(App.class);

    public static void main(String[] args) {
        SessionFactory sessionFactory = new HibernateFactory().getSessionFactory();
        Session session = sessionFactory.openSession();
        System.out.println("HELLO!");
        System.out.println("1. JAKAS GRA");
        System.out.println("2. JAKAS GRA");
        System.out.println("3. STATKI");
        System.out.println("4. JAKAS GRA");
        System.out.println("PODAJ NUMER GRY W KTORA CHCESZ GRAC :)");

        Scanner scanner = new Scanner(System.in);
        int gameNumber = scanner.nextInt();
        log.info("GAME NUMBER !!!!! {}, {}",gameNumber, "THIS WILL BE ARG");
        boolean exit = false;

        for (int i = 0;  exit!=true; i++) {
            switch (gameNumber) {
                case 1:
                    System.out.println("HERE SHOULD BE YOUR GAME ! ");
                    break;
                case 2:
                    System.out.println("HERE SHOULD BE YOUR GAME ! ");
                    break;
                case 3:
                    System.out.println("HERE SHOULD BE YOUR GAME ! ");
                    break;
                case 4:
                    System.out.println("HERE SHOULD BE YOUR GAME ! ");
                    break;
                default:
                    exit = true;
                    break;
            }
        }
        session.close();
        sessionFactory.close();
    }
}
