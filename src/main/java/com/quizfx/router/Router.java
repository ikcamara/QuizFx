package com.quizfx.router;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class Router {
    private static Stage stage;
    private static final String FXML_PATH = "/fxml/";

    public static void initRouter(Stage primaryStage) {
        stage = primaryStage;
        stage.setTitle("QuizFx");
    }

    public static void goTo(String page) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(
                Router.class.getResource(FXML_PATH + page + ".fxml")));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }
}
