package com.sda.zdjavapol107.examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Censore {

    //[k****e, molek, zenek, costam]
    public String censore(String text) {
        Map<String, String> words = new HashMap<>();
        words.put("kurde", "k****e");

        String[] s = text.split(" ");
        return Arrays.stream(s)
                .map(word -> {
                    String censoredWord = words.get(word);
                    return censoredWord != null ? censoredWord : word;
                })
                .collect(Collectors.joining(" "));
    }
}
