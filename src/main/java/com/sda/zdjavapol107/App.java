package com.sda.zdjavapol107;

import com.sda.zdjavapol107.checkers.Checkers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class App {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new HibernateFactory().getSessionFactory();
        Session session = sessionFactory.openSession();
        Checkers.startGame();
//        System.out.println("HELLO!");
//        System.out.println("1. JAKAS GRA");
//        System.out.println("2. JAKAS GRA");
//        System.out.println("3. STATKI");
//        System.out.println("4. JAKAS GRA");
//        System.out.println("PODAJ NUMER GRY W KTORA CHCESZ GRAC :)");
//
//        Scanner scanner = new Scanner(System.in);
//        int gameNumber = scanner.nextInt();
//        boolean exit = false;
//
//        for (int i = 0; exit != true; i++) {
//            switch (gameNumber) {
//                case 1:
//                    System.out.println("HERE SHOULD BE YOUR GAME ! ");
//                    break;
//                case 2:
//                    System.out.println("HERE SHOULD BE YOUR GAME ! ");
//                    break;
//                case 3:
//                    System.out.println("HERE SHOULD BE YOUR GAME ! ");
//                    break;
//                case 4:
//                    System.out.println("HERE SHOULD BE YOUR GAME ! ");
//                    break;
//                default:
//                    exit = true;
//                    break;
//            }
//        }
        session.close();
        sessionFactory.close();
    }
}
