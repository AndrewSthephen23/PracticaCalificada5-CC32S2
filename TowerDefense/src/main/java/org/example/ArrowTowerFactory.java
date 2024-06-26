package org.example;

public class ArrowTowerFactory implements TowerFactory{
    @Override
    public Tower createLaserTower() {
        return null; // No implementado
    }

    @Override
    public Tower createArrowTower() {
        return new ArrowTower();
    }

    @Override
    public Tower createCannonTower() {
        return null; // No implementado
    }
}
