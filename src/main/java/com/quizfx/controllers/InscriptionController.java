package com.quizfx.controllers;

import com.quizfx.router.Router;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class InscriptionController {

    @FXML
    private TextField nomField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Label errorLabel;

    @FXML
    public void initialize() {
        errorLabel.setText("");
    }

    @FXML
    public void sinscrire() {
        String nom = nomField.getText().trim();
        String email = emailField.getText().trim();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (nom.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            errorLabel.setText("Tous les champs sont obligatoires.");
            return;
        }

        if (!email.contains("@") || !email.contains(".")) {
            errorLabel.setText("Email invalide.");
            return;
        }

        if (password.length() < 4) {
            errorLabel.setText("Le mot de passe doit contenir au moins 4 caractères.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            errorLabel.setText("Les mots de passe ne correspondent pas.");
            return;
        }

        errorLabel.setStyle("-fx-text-fill: green; -fx-font-size: 13px; -fx-font-weight: bold;");
        errorLabel.setText("Inscription réussie.");

        // Plus tard :
        // 1. appeler AuthService / UtilisateurDao
        // 2. enregistrer l'utilisateur en base
        // 3. rediriger vers login ou accueil

        // Exemple de navigation :
        // Router.goTo("login");
    }

    @FXML
    public void allerConnexion() {
        try {
            Router.goTo("login");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}