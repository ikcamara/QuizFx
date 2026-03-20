package com.quizfx.controllers;

import com.quizfx.router.Router;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class ResultController {

    @FXML
    private Label nomLabel;

    @FXML
    private Label scoreLabel;

    @FXML
    private Label moduleLabel;

    @FXML
    private Label bonneReponseLabel;

    @FXML
    private Label mauvaiseReponseLabel;

    @FXML
    public void initialize() {
        // Valeurs temporaires pour test
        nomLabel.setText("Kalil");
        scoreLabel.setText("8/10");
        moduleLabel.setText("Java");
        bonneReponseLabel.setText("8");
        mauvaiseReponseLabel.setText("2");
    }

    @FXML
    public void retourAccueil() {
        try {
            Router.goTo("accueil");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void rejouerQuiz() throws IOException {
        try {
            Router.goTo("quiz");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void choisirAutreModule() {
        try {
            Router.goTo("modules");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Méthode utile plus tard pour injecter les vraies données
    public void setResultat(String nom, String score, String module, String bonnesReponses, String mauvaisesReponses) {
        nomLabel.setText(nom);
        scoreLabel.setText(score);
        moduleLabel.setText(module);
        bonneReponseLabel.setText(bonnesReponses);
        mauvaiseReponseLabel.setText(mauvaisesReponses);
    }
}