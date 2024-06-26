package org.example;

public class FastEnemyFactory implements EnemyFactory{
    @Override
    public Enemy createBasicEnemy() {
        return null; // No implementado
    }

    @Override
    public Enemy createBossEnemy() {
        return null; // No implementado
    }

    @Override
    public Enemy createFastEnemy() {
        return new SpeedyEnemy();
    }
}
