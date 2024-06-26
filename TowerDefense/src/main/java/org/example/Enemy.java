package org.example;

public class Enemy {
    private int speed; // Número de celdas que se mueve por turno
    private int health; // Cantidad de vida
    private int reward; // Recompensa por derrotar al enemigo
    private int x, y; // Posición del enemigo en el mapa
    // Constructor de la clase Enemy
    public Enemy(int speed, int health, int reward) {
        this.speed = speed;
        this.health = health;
        this.reward = reward;
    }

    // Getters y Setters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Método para recibir daño
    public void receiveDamage(int damage) {
        this.health -= damage;
    }

    // Método para verificar si el enemigo está derrotado
    public boolean isDefeated() {
        return this.health <= 0;
    }
}


