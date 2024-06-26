package org.example;

import java.util.ArrayList;
import java.util.List;

public class Wave {
    private List<Enemy> enemies; // Lista de enemigos en la oleada
    private int waveNumber; // Número de la oleada
    private static final int START_X = 0; // Posición inicial X de los enemigos
    private static final int START_Y = 2; // Posición inicial Y de los enemigos

    // Constructor que inicializa la oleada
    public Wave(int waveNumber) {
        this.waveNumber = waveNumber;
        this.enemies = generateEnemies(waveNumber);
    }

    // Método para generar enemigos basado en el número de la oleada
    private List<Enemy> generateEnemies(int waveNumber) {
        List<Enemy> enemies = new ArrayList<>();

        // Agregar enemigos básicos a la oleada
        for (int i = 0; i < waveNumber * 5; i++) { // Más enemigos cada oleada
            enemies.add(new BasicEnemy());
        }

        // Agregar enemigos rápidos cada 3 oleadas
        if (waveNumber % 3 == 0) {
            for (int i = 0; i < waveNumber; i++) {
                enemies.add(new SpeedyEnemy());
            }
        }

        // Agregar un jefe cada 5 oleadas
        if (waveNumber % 5 == 0) {
            enemies.add(new BossEnemy());
        }

        return enemies;
    }

    // Método para obtener la lista de enemigos de la oleada
    public List<Enemy> getEnemies() {
        return enemies;
    }

    // Método para generar y colocar los enemigos en el mapa
    public void spawnEnemies(Map map) {
        for (Enemy enemy : enemies) {
            enemy.setPosition(START_X, START_Y);
            map.addEnemy(enemy);
        }
    }

    // Método para manejar el progreso de la oleada
    public boolean isWaveDefeated() {
        // La oleada se considera derrotada si todos los enemigos han sido derrotados
        for (Enemy enemy : enemies) {
            if (!enemy.isDefeated()) {
                return false;
            }
        }
        return true;
    }

    // Método para obtener el número de la oleada
    public int getWaveNumber() {
        return waveNumber;
    }
}

