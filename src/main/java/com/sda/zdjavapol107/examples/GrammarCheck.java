package com.sda.zdjavapol107.examples;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GrammarCheck {
    private Censore censore;

    public String correct(String text){
        String result = "";
        if(!text.endsWith(".")){
            result = text + ".";
        }

        return censore.censore(result);
    }
}
