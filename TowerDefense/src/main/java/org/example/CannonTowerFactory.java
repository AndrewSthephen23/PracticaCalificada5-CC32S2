package org.example;

public class CannonTowerFactory implements TowerFactory{
    @Override
    public Tower createLaserTower() {
        return null; // No implementado
    }

    @Override
    public Tower createArrowTower() {
        return null; // No implementado
    }

    @Override
    public Tower createCannonTower() {
        return new CannonTower();
    }
}
