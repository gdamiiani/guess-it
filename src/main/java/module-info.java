module com.damiiani.adivinha {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.damiiani.guessit to javafx.fxml;
    exports com.damiiani.guessit;
    exports com.damiiani.guessit.controllers;
    opens com.damiiani.guessit.controllers to javafx.fxml;
    exports com.damiiani.guessit.utils;
    opens com.damiiani.guessit.utils to javafx.fxml;
    exports com.damiiani.guessit.models;
    opens com.damiiani.guessit.models to javafx.fxml;
}
