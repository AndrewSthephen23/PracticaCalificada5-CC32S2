package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TowerTest2 {
    private Tower tower;
    private Map map;

    @BeforeEach
    public void setUp() {
        tower = new Tower(50, 2, 1);
        tower.setPosition(2, 1);
        map = new Map(); // Inicializa el mapa con el diseño predefinido
    }

    @Test
    public void testAttack_EnemyInRange() {
        List<Enemy> enemies = Arrays.asList(new Enemy(1, 100, 10));
        enemies.get(0).setPosition(2, 2); // Enemigo dentro del rango de la torre
        map.addEnemy(enemies.get(0)); // Agrega el enemigo al mapa

        tower.attack(enemies, map);

        // Verificar que el enemigo ha recibido daño
        assertEquals(50, enemies.get(0).getHealth());
    }

    @Test
    public void testAttack_EnemyOutOfRange() {
        List<Enemy> enemies = Arrays.asList(new Enemy(1, 100, 10));
        enemies.get(0).setPosition(4, 4); // Enemigo fuera del rango de la torre
        map.addEnemy(enemies.get(0)); // Agrega el enemigo al mapa

        tower.attack(enemies, map);

        // Verificar que el enemigo no ha recibido daño
        assertEquals(100, enemies.get(0).getHealth());
    }
}
