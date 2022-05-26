package com.sda.zdjavapol107.szubienica.bazaDanych;

import lombok.SneakyThrows;

import java.io.File;
import java.util.*;

public class ZapisSlowDoBazyDanych {

    @SneakyThrows
    public static void main(String[]args){


        Scanner scanner = new Scanner(new File("C:/bazaDanych.txt"));
        Random random = new Random();

        List<String> words = new ArrayList<>();


        while (scanner.hasNext()){
            words.add(scanner.nextLine().toUpperCase(Locale.ROOT));
        }
        String name = words.get(random.nextInt(words.size()));
        System.out.println(name);
        }
}
