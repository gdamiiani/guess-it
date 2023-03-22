package com.damiiani.guessit.models;

import com.damiiani.guessit.GuessIt;
import com.damiiani.guessit.utils.Color;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.List;

public class EndingModel {
    private final Label result;
    private final List<TextField> row;

    public EndingModel(Label result, List<TextField> row) {
        this.result = result;
        this.row = row;
    }

    public boolean setRowColors() {
        var colors = GuessIt.getColors();
        GuessIt.resetColors();

        boolean areAllColorsGreen = Arrays.stream(colors).allMatch(color -> color.equals(Color.GREEN));

        for (int i = 0; i < row.size(); ++i) {
            var color = colors[i];
            var text = String.valueOf(GuessIt.getTargetWord().charAt(i));
            var textField = row.get(i);

            textField.setText(text);
            textField.setStyle("-fx-text-fill: " + color);
            textField.setDisable(true);
        }

        return areAllColorsGreen;
    }

    public void win() {
        result.setText("Você ganhou!");
        result.setStyle("-fx-text-fill: " + Color.GREEN);
    }

    public void lose() {
        result.setText("Você perdeu...");
        result.setStyle("-fx-text-fill: " + Color.RED);
    }
}
