package org.example;

import java.util.List;

public class Tower {
    private int damage;
    private int range;
    private int fireRate;
    private int[] position;

    public Tower(int damage, int range, int fireRate) {
        this.damage = damage;
        this.range = range;
        this.fireRate = fireRate;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getFireRate() {
        return fireRate;
    }

    public void setFireRate(int fireRate) {
        this.fireRate = fireRate;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        this.position = new int[]{x, y};
    }

    public void attack(List<Enemy> enemies, Map map) {
        for (Enemy enemy : enemies) {
            if (isEnemyWithinRange(enemy, map)) {
                enemy.setHealth(enemy.getHealth() - damage);
            }
        }
    }

    public boolean isEnemyWithinRange(Enemy enemy, Map map) {
        if (map == null) {
            return false; // Si el mapa es nulo, no hay enemigos en el rango
        }

        int xStart = Math.max(0, position[0] - range);
        int xEnd = Math.min(map.getMapa().length - 1, position[0] + range);
        int yStart = Math.max(0, position[1] - range);
        int yEnd = Math.min(map.getMapa()[0].length - 1, position[1] + range);

        int enemyX = enemy.getX();
        int enemyY = enemy.getY();

        return enemyX >= xStart && enemyX <= xEnd && enemyY >= yStart && enemyY <= yEnd;
    }
}

