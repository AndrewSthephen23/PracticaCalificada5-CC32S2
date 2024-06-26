package org.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GameTest2 {

    @Mock
    private Map mockMap;

    private Game game;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        game = new Game();
        game.map = mockMap;  // Injectar el mock de Map en el juego
    }

    @Test
    public void testPlaceTower_ValidCannonTower() {
        // Configurar mock para posición válida
        when(mockMap.isValidPosition(3, 4)).thenReturn(true);

        game.placeTower("cannon", 3, 4);

        // Verificar que la torre se haya colocado
        verify(mockMap).insertarTower(any(CannonTower.class), eq(3), eq(4));
    }

    @Test
    public void testPlaceTower_ValidLaserTower() {
        // Configurar mock para posición válida
        when(mockMap.isValidPosition(3, 4)).thenReturn(true);

        game.placeTower("laser", 3, 4);

        // Verificar que la torre se haya colocado
        verify(mockMap).insertarTower(any(LaserTower.class), eq(3), eq(4));
    }

    @Test
    public void testPlaceTower_ValidArrowTower() {
        // Configurar mock para posición válida
        when(mockMap.isValidPosition(3, 4)).thenReturn(true);

        game.placeTower("arrow", 3, 4);

        // Verificar que la torre se haya colocado
        verify(mockMap).insertarTower(any(ArrowTower.class), eq(3), eq(4));
    }

    @Test
    public void testPlaceTower_InvalidPosition() {
        // Configurar mock para posición inválida
        when(mockMap.isValidPosition(3, 4)).thenReturn(false);

        game.placeTower("cannon", 3, 4);

        // Verificar que la torre no se haya colocado
        verify(mockMap, never()).insertarTower(any(Tower.class), eq(3), eq(4));
    }

    @Test
    public void testPlaceTower_InvalidTowerType() {
        // Configurar mock para cualquier posición
        when(mockMap.isValidPosition(anyInt(), anyInt())).thenReturn(true);

        game.placeTower("invalidType", 3, 4);

        // Verificar que la torre no se haya colocado
        verify(mockMap, never()).insertarTower(any(Tower.class), eq(3), eq(4));
    }
}
