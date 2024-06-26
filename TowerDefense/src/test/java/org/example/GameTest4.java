package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.*;

public class GameTest4 {
    private Game game;
    private Wave mockWave;

    @BeforeEach
    public void setUp() {
        // Crear el mock de Wave
        mockWave = Mockito.mock(Wave.class);

        // Configurar el mock para devolver el número de oleada y los enemigos simulados
        when(mockWave.getWaveNumber()).thenReturn(1); // Número de la primera oleada
        when(mockWave.getEnemies()).thenReturn(List.of(new BasicEnemy(), new BasicEnemy())); // Dos enemigos simulados

        // Crear una instancia de Game e inyectar el mockWave en la lista de waves
        game = new Game();
        game.waves.clear(); // Asegurarse de que la lista de waves esté vacía
        game.waves.add(mockWave); // Agregar el mockWave a la lista de waves
    }

    @Test
    public void testStartWave() {
        // Llamar al método startWave en la instancia de Game
        game.startWave();

        // Verificar que se añadió correctamente una nueva oleada a la lista de waves
        assert(game.waves.size() == 1); // Debería haber una sola oleada en la lista

        // Verificar que el método getEnemies en el mockWave fue llamado exactamente una vez
        verify(mockWave, times(1)).getEnemies();

    }
}
