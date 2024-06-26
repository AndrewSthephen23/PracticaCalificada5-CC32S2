package org.example;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

public class GameTest {

    @Mock
    private Map mockMap;

    @Mock
    private Player mockPlayer;

    @Mock
    private Wave mockWave;

    @InjectMocks
    private Game game;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        game.waves = new ArrayList<>(); // Reset waves list
    }

    /*
    @Test
    public void testPlaceTower_Cannon() {
        TowerFactory mockCannonTowerFactory = mock(CannonTowerFactory.class);
        Tower mockCannonTower = mock(Tower.class);
        when(mockCannonTowerFactory.createCannonTower()).thenReturn(mockCannonTower);

        // Inyectar el mock de factory en la instancia del juego
        game.placeTower("cannon", 1, 1);

        verify(mockMap, times(1)).insertarTower(any(Tower.class), eq(1), eq(1));
        System.out.println("Torre cannon colocada en (1, 1)");
    }
     */


    @Test
    public void testStartWave() {
        // Asegúrar de que no hay olas inicialmente
        assertTrue(game.waves.isEmpty());

        // Iniciar la ola
        game.startWave();

        // Verificar que se añade y se inicia una nueva ola
        assertEquals(1, game.waves.size());
        assertEquals(1, game.currentWaveIndex);
        System.out.println("Oleada 1 iniciada");
    }
}
