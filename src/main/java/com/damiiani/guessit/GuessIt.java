package com.damiiani.guessit;

import com.damiiani.guessit.utils.Color;

import java.util.Objects;

public class GuessIt {
    private static String[] colors = new String[5];
    private static String targetWord;
    private String typedWord;

    public GuessIt(String targetWord) {
        GuessIt.targetWord = targetWord.toUpperCase();
    }

    public String[] compareWords() {
        var out = new String[5];

        for (int i = 0; i < targetWord.length(); ++i) {
            if (typedWord.charAt(i) == targetWord.charAt(i)) {
                out[i] = Color.GREEN;
                colors[i] = out[i];
            } else if (targetWord.contains(String.valueOf(typedWord.charAt(i)))) {
                var wordIndex = targetWord.indexOf(typedWord.charAt(i));
                out[i] = Color.YELLOW;
                if (!Objects.equals(colors[wordIndex], Color.GREEN)) {
                    colors[wordIndex] = out[i];
                }
            } else {
                out[i] = Color.RED;
                if (!Objects.equals(colors[i], Color.GREEN) && !Objects.equals(colors[i], Color.YELLOW)) {
                    colors[i] = out[i];
                }
            }
        }

        return out;
    }

    public static String[] getColors() {
        return colors;
    }
    public static void resetColors() {
        colors = new String[5];
    }

    public static String getTargetWord() {
        return targetWord;
    }

    public void setTypedWord(String typedWord) {
        this.typedWord = typedWord.toUpperCase();
    }
    public String getTypedWord() {
        return typedWord;
    }
}
