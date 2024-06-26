package org.example;

public class LaserTowerFactory implements TowerFactory{
    @Override
    public Tower createLaserTower() {
        return new LaserTower();
    }

    @Override
    public Tower createArrowTower() {
        return null; // No implementado
    }

    @Override
    public Tower createCannonTower() {
        return null; // No implementado
    }
}
