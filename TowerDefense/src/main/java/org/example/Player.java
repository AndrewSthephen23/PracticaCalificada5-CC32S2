package org.example;

public class Player {
    private int score; // Puntuación del jugador
    private int baseHealth; // Salud de la base del jugador

    // Constructor que inicializa la puntuación y la salud de la base
    public Player() {
        this.score = 0;
        this.baseHealth = 100;
    }

    // Método para agregar puntos a la puntuación del jugador
    public void addScore(int points) {
        this.score += points;
    }

    // Método para deducir salud de la base
    public void deductBaseHealth(int damage) {
        this.baseHealth -= damage;
        if (this.baseHealth < 0) {
            this.baseHealth = 0; // Asegurar de que la salud de la base no sea negativa
        }
    }

    // Getters para la puntuación y la salud de la base
    public int getScore() {
        return score;
    }

    public int getBaseHealth() {
        return baseHealth;
    }

    // Método para verificar si la base ha sido destruida
    public boolean isBaseDestroyed() {
        return this.baseHealth <= 0;
    }

    // Método para actualizar la puntuación y la salud de la base
    public void updateScoreAndHealth(Enemy enemy, int damage) {
        boolean defeated = enemy.isDefeated();
        if (defeated) {
            // Si el enemigo fue derrotado, se suma la recompensa a la puntuación
            addScore(enemy.getReward());
        } else {
            // Si el enemigo no fue derrotado y alcanzó la base, se deduce la salud de la base
            deductBaseHealth(damage);
        }
    }
}

