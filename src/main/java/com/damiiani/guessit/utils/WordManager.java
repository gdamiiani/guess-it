package com.damiiani.guessit.utils;

import java.util.ArrayList;
import java.util.Random;

public class WordManager {
    private final ArrayList<String> words;

    public WordManager(ArrayList<String> words) {
        this.words = words;
    }

    public String getRandomWord() {
        return words.get(new Random().nextInt(0, words.size()));
    }
}
