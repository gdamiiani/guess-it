package com.damiiani.guessit.utils;

import com.damiiani.guessit.Main;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    private final InputStream inputStream;

    public FileManager(String fileName) throws IOException {
        inputStream = Main.class.getResourceAsStream(fileName + ".txt");

        assert inputStream != null;
    }

    public ArrayList<String> getWords() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayList<String> words = new ArrayList<>();
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            words.add(line);
        }

        return words;
    }
}
