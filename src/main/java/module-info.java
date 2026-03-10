module org.example.quizfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.quizfx to javafx.fxml;
    opens com.quizfx.controllers to javafx.fxml;
    opens org.example.quizfx to javafx.fxml;

    exports org.example.quizfx;
    exports com.quizfx;
    exports com.quizfx.controllers;
}