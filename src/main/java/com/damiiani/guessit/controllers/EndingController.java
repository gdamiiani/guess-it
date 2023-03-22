package com.damiiani.guessit.controllers;

import com.damiiani.guessit.Main;
import com.damiiani.guessit.models.EndingModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class EndingController implements Initializable {
    @FXML
    private TextField textField00;
    @FXML
    private TextField textField01;
    @FXML
    private TextField textField02;
    @FXML
    private TextField textField03;
    @FXML
    private TextField textField04;
    @FXML
    private Label result;

    @FXML
    public void goBack() throws IOException {
        Main.setRoot("main_menu");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EndingModel endingModel = new EndingModel(result, List.of(textField00, textField01, textField02, textField03, textField04));

        boolean areAllColorsGreen = endingModel.setRowColors();

        if (areAllColorsGreen) {
            endingModel.win();
        } else {
            endingModel.lose();
        }
    }
}
