package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class GameTest3 {
    private Game game;
    private Map mockMap;

    @BeforeEach
    public void setUp() {
        // Crear el mock de Map
        mockMap = Mockito.mock(Map.class);

        // Inyectar el mock en Game
        game = new Game();
        game.map = mockMap;  // Asignamos el mockMap a la instancia de map en Game
    }

    @Test
    public void testPlaceTower_ValidPosition() {
        // Configurar el mock para devolver true para una posición válida
        when(mockMap.isValidPosition(2, 2)).thenReturn(true);

        // Llamar al método bajo prueba
        game.placeTower("cannon", 2, 2);

        // Verificar que insertarTower fue llamado con los parámetros correctos
        verify(mockMap, times(1)).insertarTower(any(Tower.class), eq(2), eq(2));
    }

    @Test
    public void testPlaceTower_InvalidPosition() {
        // Configurar el mock para devolver false para una posición inválida
        when(mockMap.isValidPosition(2, 2)).thenReturn(false);

        // Llamar al método bajo prueba
        game.placeTower("cannon", 2, 2);

        // Verificar que insertarTower no fue llamado
        verify(mockMap, never()).insertarTower(any(Tower.class), eq(2), eq(2));
    }
}
