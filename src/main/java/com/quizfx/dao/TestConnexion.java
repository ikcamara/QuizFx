package com.quizfx.dao;

import java.sql.Connection;

public class TestConnexion {
    public static void main(String[] args) {
        try (Connection conn = Database.getConnection()) {
            System.out.println("Connexion à la base réussie !");
        } catch (Exception e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
            e.printStackTrace();
        }
    }
}