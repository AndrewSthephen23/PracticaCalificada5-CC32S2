package org.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BasicEnemyFactoryTest {

    private BasicEnemyFactory basicEnemyFactory;

    @BeforeEach
    public void setUp() {
        basicEnemyFactory = new BasicEnemyFactory();
    }

    @Test
    public void testCreateBasicEnemy() {
        Enemy enemy = basicEnemyFactory.createBasicEnemy();
        assertNotNull(enemy, "El enemigo creado no debería ser nulo");
        assertTrue(enemy instanceof BasicEnemy, "El enemigo creado debería ser una instancia de BasicEnemy");
    }

    @Test
    public void testCreateBossEnemy() {
        Enemy enemy = basicEnemyFactory.createBossEnemy();
        assertNull(enemy, "El método createBossEnemy debería devolver nulo");
    }

    @Test
    public void testCreateFastEnemy() {
        Enemy enemy = basicEnemyFactory.createFastEnemy();
        assertNull(enemy, "El método createFastEnemy debería devolver nulo");
    }
}
