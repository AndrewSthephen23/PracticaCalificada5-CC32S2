package org.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class FactoryTest {

    // Mocks de las fábricas
    @Mock
    private EnemyFactory ejemploMockFactory;

    @Mock
    private TowerFactory ejemploMockTowerFactory;

    // Mocks de tipos específicos de enemigos
    @Mock
    private BasicEnemy mockBasicEnemy;

    @Mock
    private BossEnemy mockBossEnemy;

    @Mock
    private SpeedyEnemy mockFastEnemy;

    // Mocks de tipos específicos de torres
    @Mock
    private LaserTower mockLaserTower;

    @Mock
    private CannonTower mockCannonTower;

    @Mock
    private ArrowTower mockArrowTower;

    @BeforeEach
    public void setUp() {
        // Inicializa los mocks
        MockitoAnnotations.openMocks(this);

        // Configura stubs para EnemyFactory para que devuelvan los mocks específicos de enemigos
        when(ejemploMockFactory.createBasicEnemy()).thenReturn(mockBasicEnemy);
        when(ejemploMockFactory.createBossEnemy()).thenReturn(mockBossEnemy);
        when(ejemploMockFactory.createFastEnemy()).thenReturn(mockFastEnemy);

        // Configura stubs para TowerFactory para que devuelvan los mocks específicos de torres
        when(ejemploMockTowerFactory.createLaserTower()).thenReturn(mockLaserTower);
        when(ejemploMockTowerFactory.createArrowTower()).thenReturn(mockArrowTower);
        when(ejemploMockTowerFactory.createCannonTower()).thenReturn(mockCannonTower);
    }

    // Prueba para la creación de un BasicEnemy
    @Test
    public void testCreateBasicEnemy() {
        Enemy basicEnemy = ejemploMockFactory.createBasicEnemy();
        assertNotNull(basicEnemy); // Verifico que el enemigo no sea nulo
        assertEquals(mockBasicEnemy, basicEnemy); // Verifico que el enemigo sea el mock esperado
        verify(ejemploMockFactory, times(1)).createBasicEnemy(); // Verifico que el método se llame una vez
    }

    // Prueba para la creación de un BossEnemy
    @Test
    public void testCreateBossEnemy() {
        Enemy bossEnemy = ejemploMockFactory.createBossEnemy();
        assertNotNull(bossEnemy); // Verifico que el enemigo no sea nulo
        assertEquals(mockBossEnemy, bossEnemy); // Verifico que el enemigo sea el mock esperado
        verify(ejemploMockFactory, times(1)).createBossEnemy(); // Verifico que el método se llame una vez
    }

    // Prueba para la creación de un FastEnemy
    @Test
    public void testCreateFastEnemy() {
        Enemy fastEnemy = ejemploMockFactory.createFastEnemy();
        assertNotNull(fastEnemy); // Verifico que el enemigo no sea nulo
        assertEquals(mockFastEnemy, fastEnemy); // Verifico que el enemigo sea el mock esperado
        verify(ejemploMockFactory, times(1)).createFastEnemy(); // Verifico que el método se llame una vez
    }

    // Prueba para la creación de una LaserTower
    @Test
    public void testCreateLaserTower() {
        Tower laserTower = ejemploMockTowerFactory.createLaserTower();
        assertNotNull(laserTower); // Verifico que la torre no sea nula
        assertEquals(mockLaserTower, laserTower); // Verifico que la torre sea el mock esperado
        verify(ejemploMockTowerFactory, times(1)).createLaserTower(); // Verifico que el método se llame una vez
    }

    // Prueba para la creación de una CannonTower
    @Test
    public void testCreateCannonTower() {
        Tower cannonTower = ejemploMockTowerFactory.createCannonTower();
        assertNotNull(cannonTower); // Verifico que la torre no sea nula
        assertEquals(mockCannonTower, cannonTower); // Verifico que la torre sea el mock esperado
        verify(ejemploMockTowerFactory, times(1)).createCannonTower(); // Verifico que el método se llame una vez
    }

    // Prueba para la creación de una ArrowTower
    @Test
    public void testCreateArrowTower() {
        Tower arrowTower = ejemploMockTowerFactory.createArrowTower();
        assertNotNull(arrowTower); // Verifico que la torre no sea nula
        assertEquals(mockArrowTower, arrowTower); // Verifico que la torre sea el mock esperado
        verify(ejemploMockTowerFactory, times(1)).createArrowTower(); // Verifico que el método se llame una vez
    }
}

