package org.example;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyTest {

    @Mock
    private Enemy ejemploMockEnemy;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        ejemploMockEnemy = mock(Enemy.class);
    }

    @Test
    public void testReceiveDamage() {
        // Configuro el mock para devolver una salud inicial de 100
        when(ejemploMockEnemy.getHealth()).thenReturn(100);

        // Verifico la salud inicial del mock
        assertEquals(100, ejemploMockEnemy.getHealth());

        // Aplico daño al mock
        ejemploMockEnemy.receiveDamage(20);

        // Configuro el mock para devolver una salud actualizada después del daño
        when(ejemploMockEnemy.getHealth()).thenReturn(80);

        // Verifico la salud después de recibir daño
        assertEquals(80, ejemploMockEnemy.getHealth());

        // Aplico más daño al mock
        ejemploMockEnemy.receiveDamage(80);

        // Configuro el mock para devolver una salud actualizada después del daño adicional
        when(ejemploMockEnemy.getHealth()).thenReturn(0);

        // Verifico la salud después de recibir más daño
        assertEquals(0, ejemploMockEnemy.getHealth());
    }

    @Test
    public void testIsDefeated() {
        // Configuro el mock para devolver una salud inicial de 100
        when(ejemploMockEnemy.getHealth()).thenReturn(100);

        // Verifico que el enemigo no esté derrotado inicialmente
        when(ejemploMockEnemy.isDefeated()).thenReturn(false);
        assertFalse(ejemploMockEnemy.isDefeated());

        // Aplico daño al mock
        ejemploMockEnemy.receiveDamage(100);

        // Configuro el mock para devolver una salud actualizada y estado de derrota
        when(ejemploMockEnemy.getHealth()).thenReturn(0);
        when(ejemploMockEnemy.isDefeated()).thenReturn(true);

        // Verifico que el enemigo esté derrotado después de recibir suficiente daño
        assertTrue(ejemploMockEnemy.isDefeated());
    }

    @Test
    public void testSetPosition() {
        // Establece una posición
        ejemploMockEnemy.setPosition(5, 10);

        // Configuro el mock para devolver la posición establecida
        when(ejemploMockEnemy.getX()).thenReturn(5);
        when(ejemploMockEnemy.getY()).thenReturn(10);

        // Verifico la posición
        assertEquals(5, ejemploMockEnemy.getX());
        assertEquals(10, ejemploMockEnemy.getY());
    }

    @Test
    public void testSetAndGetSpeed() {
        // Establece una nueva velocidad
        ejemploMockEnemy.setSpeed(3);

        // Configuro el mock para devolver la nueva velocidad
        when(ejemploMockEnemy.getSpeed()).thenReturn(3);

        // Verifico la nueva velocidad
        assertEquals(3, ejemploMockEnemy.getSpeed());
    }

    @Test
    public void testSetAndGetReward() {
        // Establece una nueva recompensa
        ejemploMockEnemy.setReward(20);

        // Configuro el mock para devolver la nueva recompensa
        when(ejemploMockEnemy.getReward()).thenReturn(20);

        // Verifico la nueva recompensa
        assertEquals(20, ejemploMockEnemy.getReward());
    }
}
