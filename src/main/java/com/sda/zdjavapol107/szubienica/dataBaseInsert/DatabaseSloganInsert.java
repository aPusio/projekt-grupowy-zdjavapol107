package com.sda.zdjavapol107.szubienica.dataBaseInsert;

import com.sda.zdjavapol107.HibernateFactory;
import com.sda.zdjavapol107.szubienica.repository.dao.HangmanSloganDao;
import com.sda.zdjavapol107.szubienica.repository.model.HangmanSlogan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class DatabaseSloganInsert {

    public static HibernateFactory hibernateFactory;
    private static HangmanSloganDao hangmanSloganDao;

    public static void run() {
        hibernateFactory = new HibernateFactory();
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        hangmanSloganDao = new HangmanSloganDao(sessionFactory);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<String> slogans = new ArrayList<>();

        slogans = List.of("filiżanka", "czajnik", "talerz", "widec", "łyżka", "nożyce", "półmisek", "chlebak",
                "garnek", "patelnia", "mikrofalówka", "toster", "lodówka", "gofrownica", "telewizor", "kanapa", "podłoga",
                "laptop", "komputer", "myszka", "klawiatura", "monitor", "podkładka", "stolik", "dywan", "krzesło",
                "poduszka", "żyrandol", "komoda", "abażur", "parapet", "stojak", "książka", "mydelniczka", "szczoteczka",
                "umywalka", "ręcznik", "prysznic", "szampon", "odżywka", "golarka", "brodzik", "wanna", "pralka", "wycieraczka",
                "gąbka", "samochód", "motor", "rower", "opona", "śrubokręt", "wiertarka", "kosiarka", "sekator", "podkaszarka",
                "kluczyk", "grabie", "szpadel", "przedłużacz", "torebka", "kurtka", "spodnie", "bluzka", "ramonezka",
                "kardigan", "spoódnica", "sukienka", "garnitur", "skarpetka", "krawat", "szelki", "nosorożec", "mrówkojad",
                "wiewiórka", "myszojeleń", "żyrafa", "flaming", "pelikan", "bocian", "energetyk", "drukarka", "doniczka",
                "implementacja", "konkatenacja", "hermetyzacja", "enkapsulacja", "szubienica", "warcaby", "memorki",
                "szachownica", "statki", "hibernate", "framework", "spring", "oracle", "kolczuga", "pierścionek",
                "zegarek", "obrączka", "kaszanka");

        List<String> upperedSlogans= slogans.stream().map(a -> a.toUpperCase(Locale.ROOT)).collect(Collectors.toList());

        for (int i = 0; i <= upperedSlogans.size()-1; i++) {
            hangmanSloganDao.save(new HangmanSlogan(upperedSlogans.get(i)));
        }
        transaction.commit();
        session.close();
    }
}
