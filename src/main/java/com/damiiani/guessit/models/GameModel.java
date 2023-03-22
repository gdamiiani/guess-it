package com.damiiani.guessit.models;

import com.damiiani.guessit.GuessIt;
import com.damiiani.guessit.controllers.GameController;
import com.damiiani.guessit.utils.Color;
import com.damiiani.guessit.utils.FileManager;
import com.damiiani.guessit.utils.WordManager;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GameModel {
    private final List<List<TextField>> rows;
    private final GuessIt guessIt;

    public GameModel(List<List<TextField>> rows) {
        this.rows = rows;

        try {
            FileManager fileManager = new FileManager("dictionary");
            String word = new WordManager(fileManager.getWords()).getRandomWord();

            guessIt = new GuessIt(word);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setTextFieldsListeners() {
        for (int i = 0; i < rows.size(); ++i) {
            var row = rows.get(i);
            var nextRow = rows.get(i < rows.size() - 1 ? i + 1 : i);

            final char[] typedWord = {' ', ' ', ' ', ' ', ' '};

            for (int j = 0; j < row.size(); ++j) {
                var textField = row.get(j);
                var nextTextField = row.get(j < row.size() - 1 ? j + 1 : j);
                var previousTextField = row.get(j > 0 ? j - 1 : j);

                textField.setOnKeyPressed(keyEvent -> {
                    final String typedWordStr = new String(typedWord);

                    if (keyEvent.getCode().equals(KeyCode.BACK_SPACE) || keyEvent.getCode().equals(KeyCode.LEFT)) {
                        previousTextField.requestFocus();
                    } else if (keyEvent.getCode().equals(KeyCode.RIGHT)){
                        nextTextField.requestFocus();
                    } else if (keyEvent.getCode().equals(KeyCode.ENTER) && !typedWordStr.contains(" ")) {
                        guessIt.setTypedWord(typedWordStr);

                        boolean areAllColorsGreen = setRowColors(row, nextRow);
                        boolean isGameOver = areAllColorsGreen || row.equals(nextRow);

                        if (isGameOver) {
                            try {
                                GameController.endGame();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                });

                final int finalJ = j;

                textField.textProperty().addListener(((observableValue, oldChar, newChar) -> {
                    String text = newChar.toUpperCase();

                    if (newChar.length() > 1) {
                        if (oldChar.charAt(0) == newChar.charAt(0)) {
                            text = Character.toString(newChar.charAt(1)).toUpperCase();
                        } else {
                            text = Character.toString(newChar.charAt(0)).toUpperCase();
                        }
                    } else if (newChar.length() == 1 && !newChar.contains(" ")) {
                        nextTextField.requestFocus();
                    }

                    if (text.chars().noneMatch(Character::isLetter) || text.isEmpty()) {
                        text = " ";
                    }

                    textField.setText(text);
                    typedWord[finalJ] = text.charAt(0);
                }));
            }
        }
    }

    private boolean setRowColors(List<TextField> row, List<TextField> nextRow) {
        var colors = guessIt.compareWords();
        var text = guessIt.getTypedWord();

        boolean areAllColorsGreen = Arrays.stream(colors).allMatch(color -> color.equals(Color.GREEN));

        for (int i = 0; i < row.size(); ++i) {
            var textField = row.get(i);

            textField.setText(String.valueOf(text.charAt(i)));
            textField.setStyle("-fx-text-fill: " + colors[i]);
            textField.setDisable(true);

            if (row == nextRow) break;

            var nextRowTextField = nextRow.get(i);

            nextRowTextField.setDisable(false);
        }

        return areAllColorsGreen;
    }
}
