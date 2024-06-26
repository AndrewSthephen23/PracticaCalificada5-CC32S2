package org.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class TowerTest {

    @Mock
    private Tower ejemploMockTower;//Mock de ejemplo para la clase Tower

    @Mock
    private List<Enemy> mockEnemies;//Mock de ejemplo para los enemigos

    @Mock
    private Map mockMap;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        ejemploMockTower = mock(Tower.class);
    }

    @Test
    public void testTowerAttack() {
        // Configura el mock para simular el ataque
        doNothing().when(ejemploMockTower).attack(mockEnemies, mockMap);

        // Llama al método attack() en el mock
        ejemploMockTower.attack(mockEnemies, mockMap);

        // Verifica que el método attack() fue llamado exactamente una vez
        verify(ejemploMockTower, times(1)).attack(mockEnemies, mockMap);
    }

    @Test
    public void testSetAndGetDamage() {
        // Configura el mock para devolver y establecer el daño
        when(ejemploMockTower.getDamage()).thenReturn(50);

        // Verifica que el método getDamage() devuelve el valor esperado
        assertEquals(50, ejemploMockTower.getDamage());

        // Establece un nuevo valor de daño
        ejemploMockTower.setDamage(100);

        // Verifica que el método setDamage() fue llamado exactamente una vez con el valor correcto
        verify(ejemploMockTower, times(1)).setDamage(100);
    }

    @Test
    public void testSetAndGetRange() {
        // Configura el mock para devolver y establecer el rango
        when(ejemploMockTower.getRange()).thenReturn(3);

        // Verifica que el método getRange() devuelve el valor esperado
        assertEquals(3, ejemploMockTower.getRange());

        // Establece un nuevo valor de rango
        ejemploMockTower.setRange(5);

        // Verifica que el método setRange() fue llamado exactamente una vez con el valor correcto
        verify(ejemploMockTower, times(1)).setRange(5);
    }

    @Test
    public void testSetAndGetFireRate() {
        // Configura el mock para devolver y establecer la tasa de fuego
        when(ejemploMockTower.getFireRate()).thenReturn(1);

        // Verifica que el método getFireRate() devuelve el valor esperado
        assertEquals(1, ejemploMockTower.getFireRate());

        // Establece un nuevo valor de tasa de fuego
        ejemploMockTower.setFireRate(2);

        // Verifica que el método setFireRate() fue llamado exactamente una vez con el valor correcto
        verify(ejemploMockTower, times(1)).setFireRate(2);
    }


}
