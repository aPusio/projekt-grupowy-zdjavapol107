package com.sda.zdjavapol107;

import org.hibernate.SessionFactory;

import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new HibernateFactory().getSessionFactory();
        System.out.println("HELLO!");
        System.out.println("1. JAKAS GRA");
        System.out.println("2. JAKAS GRA");
        System.out.println("3. JAKAS GRA");
        System.out.println("4. JAKAS GRA");
        System.out.println("PODAJ NUMER GRY W KTORA CHCESZ GRAC :)");

        Scanner scanner = new Scanner(System.in);
        //TODO tutaj powinna byc pewnie jakas petla
        int gameNumber = scanner.nextInt();

        switch (gameNumber){
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
                System.out.println("WHAT ?!");
        }
        sessionFactory.close();
    }
}
