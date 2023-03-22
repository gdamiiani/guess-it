package com.damiiani.guessit.controllers;

import com.damiiani.guessit.Main;
import com.damiiani.guessit.models.GameModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class GameController implements Initializable {
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
    private TextField textField10;
    @FXML
    private TextField textField11;
    @FXML
    private TextField textField12;
    @FXML
    private TextField textField13;
    @FXML
    private TextField textField14;
    @FXML
    private TextField textField20;
    @FXML
    private TextField textField21;
    @FXML
    private TextField textField22;
    @FXML
    private TextField textField23;
    @FXML
    private TextField textField24;
    @FXML
    private TextField textField30;
    @FXML
    private TextField textField31;
    @FXML
    private TextField textField32;
    @FXML
    private TextField textField33;
    @FXML
    private TextField textField34;
    @FXML
    private TextField textField40;
    @FXML
    private TextField textField41;
    @FXML
    private TextField textField42;
    @FXML
    private TextField textField43;
    @FXML
    private TextField textField44;
    @FXML
    private TextField textField50;
    @FXML
    private TextField textField51;
    @FXML
    private TextField textField52;
    @FXML
    private TextField textField53;
    @FXML
    private TextField textField54;

    @FXML
    public void goBack() throws IOException {
        Main.setRoot("main_menu");
    }

    public static void endGame() throws IOException {
        Main.setRoot("ending");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GameModel gameModel = new GameModel(List.of(
                List.of(textField00, textField01, textField02, textField03, textField04),
                List.of(textField10, textField11, textField12, textField13, textField14),
                List.of(textField20, textField21, textField22, textField23, textField24),
                List.of(textField30, textField31, textField32, textField33, textField34),
                List.of(textField40, textField41, textField42, textField43, textField44),
                List.of(textField50, textField51, textField52, textField53, textField54)
        ));

        gameModel.setTextFieldsListeners();
    }
}
