package org.example;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private char[][] mapa;
    private final int filas;
    private final int columnas;
    private List<Enemy> activeEnemies;

    // Constructor que inicializa el mapa con un diseño ya predefinido
    public Map() {
        this.filas = 5;
        this.columnas = 5;
        this.mapa = new char[][] {
                {' ', ' ', 'C', ' ', ' '},
                {' ', 'C', ' ', ' ', ' '},
                {'C', ' ', ' ', 'C', 'B'},
                {' ', ' ', 'C', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '}
        };
        activeEnemies = new ArrayList<>();
    }

    public char[][] getMapa() {
        return mapa;
    }

    // Método para imprimir el mapa
    public void imprimirMapa() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("[" + mapa[i][j] + "]");
            }
            System.out.println();
        }
    }

    // Método para obtener la posición de la base 'B'
    public int[] obtenerPosicionBase() {
        int[] posicionBase = new int[2];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (mapa[i][j] == 'B') {
                    posicionBase[0] = i;
                    posicionBase[1] = j;
                    return posicionBase;
                }
            }
        }
        return posicionBase;
    }

    // Metodo para insertar en una posicion la torre 'T'
    public void insertarTower(Tower tower, int x, int y) {
        if (isValidPosition(x, y)) {
            mapa[x][y] = 'T'; // 'T' representará una torre
        } else {
            System.out.println("No se puede colocar la torre en esa posición");
        }
    }

    // Metodo para insertar una ola de enemigos
    public void addEnemy(Enemy enemy) {
        activeEnemies.add(enemy);
        mapa[enemy.getX()][enemy.getY()] = 'E';
    }

    // Método para verificar si una posición es válida en el mapa
    public boolean esPosicionValida(int fila, int columna) {
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
    }

    public boolean isValidPosition(int x,int y){
        if(mapa[x][y] == ' '){
            return true;
        }else {
            System.out.println("No se puede colocar la torre en esa posición");
            return false;
        }
    }

    // Método para obtener el contenido de una posición específica del mapa
    public char contenidoEnPosicion(int fila, int columna) {
        if (esPosicionValida(fila, columna)) {
            return mapa[fila][columna];
        } else { // Si es que la posicion insertada esta fuera del mapa
            throw new IllegalArgumentException("Posición fuera de los límites del mapa.");
        }
    }
}

