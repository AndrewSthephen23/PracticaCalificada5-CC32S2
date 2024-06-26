package org.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

public class WaveTest {
    private Game game;
    private Map mockMap;
    private Player mockPlayer;

    @BeforeEach
    public void setUp() {
        game = new Game();
        mockMap = mock(Map.class);
        mockPlayer = mock(Player.class);
        game.map = mockMap;
        game.player = mockPlayer;
    }

    @Test
    public void testStartWave_WithEnemies() {
        Enemy enemy = mock(BasicEnemy.class);
        Wave wave = new MockWave(1, Arrays.asList(enemy));
        game.waves.add(wave);

        when(mockMap.isValidPosition(anyInt(), anyInt())).thenReturn(true);

        game.startWave();

        // Verificar que los enemigos han sido generados y la oleada ha comenzado
        assertFalse(game.waves.get(0).getEnemies().isEmpty());
        verify(mockMap, times(1)).addEnemy(enemy);
    }

    @Test
    public void testStartWave_NoEnemies() {
        Wave wave = new MockWave(1, Collections.emptyList());
        game.waves.add(wave);

        game.startWave();

        // Verificar que no se han generado enemigos
        assertTrue(game.waves.get(0).getEnemies().isEmpty());
        verify(mockMap, never()).addEnemy(any(Enemy.class));
    }

    @Test
    public void testStartWave_NewWaveAdded() {
        game.startWave();

        // Verificar que una nueva oleada ha sido añadida
        assertEquals(1, game.waves.size());
        assertEquals(1, game.currentWaveIndex);
    }

    @Test
    public void testStartWave_ExistingWaveContinued() {
        Wave existingWave = new MockWave(1, Arrays.asList(mock(BasicEnemy.class)));
        game.waves.add(existingWave);

        game.startWave();

        // Verificar que la oleada existente se ha continuado
        assertEquals(1, game.currentWaveIndex);
        assertEquals(existingWave, game.waves.get(0));
    }

    @Test
    public void testStartWave_EndOfWavesList() {
        game.waves.add(new MockWave(1, Arrays.asList(mock(BasicEnemy.class))));

        game.startWave();
        game.startWave();

        // Verificar que se añade una nueva oleada cuando se alcanzan los límites de la lista de oleadas
        assertEquals(2, game.waves.size());
        assertEquals(2, game.currentWaveIndex);
    }
}
