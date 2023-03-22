package com.damiiani.guessit.controllers;

import com.damiiani.guessit.Main;
import javafx.fxml.FXML;

import java.io.IOException;

public class MainMenuController {
    @FXML
    public void startGame() throws IOException {
        Main.setRoot("game");
    }

    @FXML
    public void exit() {
        Main.close();
    }
}
