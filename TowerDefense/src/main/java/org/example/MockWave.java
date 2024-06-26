package org.example;

import java.util.List;

public class MockWave extends Wave {
    private List<Enemy> mockEnemies;

    public MockWave(int waveNumber, List<Enemy> mockEnemies) {
        super(waveNumber);
        this.mockEnemies = mockEnemies;
    }

    @Override
    public List<Enemy> getEnemies() {
        return mockEnemies;
    }

    @Override
    public void spawnEnemies(Map map) {
        for (Enemy enemy : mockEnemies) {
            enemy.setPosition(0, 2); // Posición inicial fija
            map.addEnemy(enemy);
        }
    }
}
