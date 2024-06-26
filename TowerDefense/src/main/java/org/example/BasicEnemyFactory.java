package org.example;

public class BasicEnemyFactory implements EnemyFactory{
    @Override
    public Enemy createBasicEnemy() {
        return new BasicEnemy();
    }

    @Override
    public Enemy createBossEnemy() {
        return null; // No implementado
    }

    @Override
    public Enemy createFastEnemy() {
        return null; // No implementado
    }
}
