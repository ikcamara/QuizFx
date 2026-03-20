package com.quizfx.controllers;

import com.quizfx.router.Router;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class AccueilController {

    @FXML
    private Label nomHeaderLabel;

    @FXML
    private Label nomBienvenueLabel;

    @FXML
    public void initialize() {
        // Valeur temporaire pour test
        String nomUtilisateur = "Kalil";

        if (nomHeaderLabel != null) {
            nomHeaderLabel.setText(nomUtilisateur);
        }

        if (nomBienvenueLabel != null) {
            nomBienvenueLabel.setText(nomUtilisateur);
        }
    }

    @FXML
    public void seDeconnecter() {
        try {
            Router.goTo("login");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void allerModules() {
        try {
            Router.goTo("modules");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void allerScores() {
        try {
            Router.goTo("result");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void allerDashboard() {
        System.out.println("Dashboard");
        // Plus tard : Router.goTo("dashboard");
    }

    @FXML
    public void allerParametres() {
        System.out.println("Paramètres");
        // Plus tard : Router.goTo("parametres");
    }
}
