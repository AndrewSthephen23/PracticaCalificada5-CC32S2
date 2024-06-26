package org.example;
import java.util.Map;

public interface BaseDeDatosPuntuacion {
    void guardarPuntuacion(String nombreJugador, int puntuacion);
    int obtenerPuntuacion(String nombreJugador);
    Map<String, Integer> obtenerTodasLasPuntuaciones();
}
