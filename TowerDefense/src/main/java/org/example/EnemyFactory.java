package org.example;

public interface EnemyFactory {
    Enemy createBasicEnemy();
    Enemy createBossEnemy();
    Enemy createFastEnemy();
}
