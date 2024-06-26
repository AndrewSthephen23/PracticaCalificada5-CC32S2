package org.example;

public class BossEnemyFactory implements EnemyFactory{
    @Override
    public Enemy createBasicEnemy() {
        return null; // No implementado
    }

    @Override
    public Enemy createBossEnemy() {
        return new BossEnemy();
    }

    @Override
    public Enemy createFastEnemy() {
        return null; // No implementado
    }
}
