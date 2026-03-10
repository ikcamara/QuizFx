package com.quizfx;

import javafx.application.Application;
import javafx.stage.Stage;
import com.quizfx.router.Router;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Router.initRouter(primaryStage);
        Router.goTo("accueil");
    }

    public static void main(String[] args) {
        launch(args);
    }
}



