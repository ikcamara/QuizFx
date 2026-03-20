package com.quizfx.controllers;

import com.quizfx.router.Router;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;

public class QuizController {

    @FXML
    private Label moduleLabel;

    @FXML
    private Label numeroQuestionLabel;

    @FXML
    private Label questionLabel;

    @FXML
    private RadioButton rep1;

    @FXML
    private RadioButton rep2;

    @FXML
    private RadioButton rep3;

    @FXML
    private RadioButton rep4;

    @FXML
    private ToggleGroup reponsesGroup;

    private int indexQuestion = 0;
    private int score = 0;

    private final String[] questions = {
            "Quelle classe permet de grouper les RadioButton ?",
            "Quel mot-clé permet d’hériter d’une classe ?",
            "Quelle méthode sert à lire le texte d’un TextField ?"
    };

    private final String[][] reponses = {
            {"Label", "ToggleGroup", "Scene", "AnchorPane"},
            {"this", "super", "extends", "implements"},
            {"getText()", "setText()", "readText()", "text()"}
    };

    private final String[] bonnesReponses = {
            "ToggleGroup",
            "extends",
            "getText()"
    };

    @FXML
    public void initialize() {
        afficherQuestion();
    }

    private void afficherQuestion() {
        moduleLabel.setText("Java");
        numeroQuestionLabel.setText((indexQuestion + 1) + "/" + questions.length);
        questionLabel.setText(questions[indexQuestion]);

        rep1.setText(reponses[indexQuestion][0]);
        rep2.setText(reponses[indexQuestion][1]);
        rep3.setText(reponses[indexQuestion][2]);
        rep4.setText(reponses[indexQuestion][3]);

        reponsesGroup.selectToggle(null);
    }

    @FXML
    public void validerReponse() {
        RadioButton selectedRadio = (RadioButton) reponsesGroup.getSelectedToggle();

        if (selectedRadio == null) {
            System.out.println("Veuillez choisir une réponse.");
            return;
        }

        String reponseChoisie = selectedRadio.getText();

        if (reponseChoisie.equals(bonnesReponses[indexQuestion])) {
            score++;
        }

        indexQuestion++;

        if (indexQuestion < questions.length) {
            afficherQuestion();
        } else {
            System.out.println("Quiz terminé !");
            System.out.println("Score final : " + score + "/" + questions.length);

            // Plus tard, tu peux passer le score à la page résultat
            try {
                Router.goTo("result");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    public void annulerQuiz() {
        try {
            Router.goTo("modules");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}